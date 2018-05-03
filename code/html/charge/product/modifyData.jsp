<%--
	作者：江晓莉
	创建日期:2013-10-18
	功能说明：修改资费记录

 --%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.asiainfo.charge.service.interfaces.IProdInfoQrySV"%>
<%@ page import="com.ai.appframe2.service.ServiceFactory"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page import="com.asiainfo.charge.ivalues.IBOProductExtDescValue"%>
<%
	String attrId = HttpUtil.getAsString(request, "attrId");
	String privId = HttpUtil.getAsString(request, "privId");
	IProdInfoQrySV sv = (IProdInfoQrySV) ServiceFactory
			.getService(IProdInfoQrySV.class);
	String extType = HttpUtil.getAsString(request, "type");
	String setName = "";
	if ("GPRS".equals(extType)) {
		setName = "com.asiainfo.charge.web.SETGprsProductInfo";
	} else {
		setName = "com.asiainfo.charge.web.SETProductInfo";
	}
	IBOProductExtDescValue[] values = sv.getColsName("", extType, "1",
			"", -1, -1);
	int length = values.length;
	int trNums = length % 3 == 0 ? length / 3 : length / 3 + 1;
	String qryCols = "";
%>
<html>
	<head>
		<title>修改记录</title>
	</head>
	<body onload="init();">
		<ai:contractframe id="prodValue" contenttype="table" title="资费记录信息"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:dbform setname="<%=setName%>" formid="prodInfo"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.asiainfo.charge.service.interfaces.IProdInfoQrySV"
				implservice_querymethod="getBasicProdInfo(String qryCols, String prodName,
											String type, String attrId, String privId,String condStr,
											int startIndex, int endIndex)"
				initial="false">
				<table>
					<%
						for (int i = 0; i < trNums; i++) {
					%><tr>
						<%
							for (int j = 0; j <= 2; j++) {
									if ((3 * i + j) >= length) {
										break;
									}
									String editable = ("0".equals(values[3 * i + j]
											.getIsCanModify())) ? "false" : "true";
									qryCols += values[3 * i + j].getExtCode();
									if (3 * i + j < length - 1) {
										qryCols += ",";
									}
						%>
						<td class="td_font"><%=values[3 * i + j].getExtName()%></td>
						<td>
							<ai:dbformfield fieldname="<%=values[3 * i + j].getExtCode()%>"
								formid="prodInfo" editable="<%=editable%>" />
						</td>
						<%
							}
						%>

					</tr>
					<%
						}
					%>

				</table>
			</ai:dbform>
		</ai:contractframe>
		<div class="area_button">
			<ai:button id="saveData" text="保存" onclick="saveData()" />
		</div>

	</body>
</html>

<script language="javascript" type="text/javascript">
function init(){
	 var privId = "<%=privId%>";
	 var type = "<%=extType%>";
	 var qryCols = "<%=qryCols%>";
	 var attrId = "<%=attrId%>";
	
	var cond = "&privId="+privId+"&attrId="+attrId +"&type="+type+"&qryCols="+qryCols+"&startIndex=-1&endIndex=-1";
	g_FormRowSetManager.get("prodInfo").refresh(cond);
	
	
}

function saveData(){
	var privId = g_FormRowSetManager.get("prodInfo").getValue("PRIVID");
	var attrId =  g_FormRowSetManager.get("prodInfo").getValue("ATTR_ID");
	if(null == attrId){
		attrId = "";
	}

	var extType = "<%=extType%>";
	var param = "&privId="+privId+"&attrId="+attrId+"&extType="+extType;
	var url ="<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeShowAction?"+
	"action=saveData"+param;
	var xmlbody = g_FormRowSetManager.get("prodInfo").toXmlString(false);
	var xml = "<RootInfo>" + xmlbody + "</RootInfo>";

	var returnValues = PostInfo(url,xml);
	if(returnValues != null){
			if(returnValues.getValueByName("retVal") == "Y"){
				alert(returnValues.getValueByName("retMsg"));
			}
			else{
				alert(returnValues.getValueByName("retMsg"));
				return;
			}
	}
	else{
		alert("保存失败");
		return;
	}
	

	
}
</script>