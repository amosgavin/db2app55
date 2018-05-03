<%-- 
	作者：江晓莉
	创建日期:2013-10-21
	功能说明：资费记录历史查询
--%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.asiainfo.charge.service.interfaces.IProdInfoQrySV"%>
<%@ page import="com.ai.appframe2.service.ServiceFactory"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page import="com.asiainfo.charge.ivalues.IBOProductExtDescValue"%>
<%
	String privId = HttpUtil.getAsString(request, "privId");
	String attrId = HttpUtil.getAsString(request, "attrId");
	String extType = HttpUtil.getAsString(request, "extType");
	IProdInfoQrySV sv = (IProdInfoQrySV) ServiceFactory
			.getService(IProdInfoQrySV.class);
	IBOProductExtDescValue[] values = sv.getColsName("", extType, "1",
			"", -1, -1);
	StringBuffer qryCols = new StringBuffer();
	StringBuffer basicCols = new StringBuffer();
	String setName = "";
	String tableName = "";
	if ("GPRS".equals(extType)) {
		setName = "com.asiainfo.charge.web.SETGprsProductInfo";
		tableName = "gprs_flux_param";
	} else {
		setName = "com.asiainfo.charge.web.SETProductInfo";
		tableName = "priv_attr_used_param";
	}
	
	
%>
<html>
	<head>
		<title>资费记录历史查询</title>
	</head>
	<body onload="init();">
		<ai:contractframe id="prodInfoQry" contenttype="table" title="历史信息"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:table tableid="basicProd"
				setname="<%=setName %>"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.asiainfo.charge.service.interfaces.IProdInfoQrySV"
				implservice_querymethod="qryProductInfoHis(String displayCols,
											String basicCols, String tableName, String privId,String attrId, String state,
											String extType, int $STARTROWINDEX,int $ENDROWINDEX )"
				implservice_countmethod="qryProductInfoHisCount(String displayCols,
											String basicCols, String tableName, String privId,String attrId, String state,
											String extType)"
				initial="false" ondbclick="" onrowchange="" pagesize="20" editable=""
				width="100%" height="180" needrefresh="true" multiselect="false">
				<%
					for (int i = 0; i < values.length; i++) {
						String fieldName = values[i].getExtCode();
						
						String title = values[i].getExtName();
						qryCols.append(fieldName);
						if ("0".equals(values[i].getIsCanModify())) {
							if (basicCols.toString().length() > 0) {
								basicCols.append(",");
							}
							basicCols.append(fieldName);

						}
						if (i != values.length - 1) {
							qryCols.append(",");

						}
				%>
				<ai:col fieldname="<%=fieldName%>" title="<%=title%>" visible="true" />
				<%
					}
				qryCols.append(",MODIFY_DATE,STAFF_ID");
				%>
				
				<ai:col fieldname="MODIFY_DATE" title="修改时间" visible="true" />
				<ai:col fieldname="STAFF_ID" title="修改人" visible="true" />
			</ai:table>
		</ai:contractframe>
	</body>
</html>
<script language="javascript" type="text/javascript">
	function init(){
	
		var cond = "";
		cond +="&displayCols=<%=qryCols%>&basicCols=<%=basicCols%>&tableName=<%=tableName%>&privId=<%=privId%>&attrId=<%=attrId%>&state=0&extType=<%=extType%>";
		g_TableRowSetManager.get("basicProd").refresh(cond);
		
		
	}
	
</script>