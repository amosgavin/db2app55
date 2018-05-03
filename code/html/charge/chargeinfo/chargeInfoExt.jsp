<%-- 
	作者：江晓莉
	日期：2013年12月3日
	功能说明：资费扩展属性查看与填写
 --%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<%@ page import="com.asiainfo.charge.ivalues.IBOProductExtDescValue"%>
<%@ page
	import="com.asiainfo.common.service.interfaces.IAbstractProductExtSV"%>
<%@ page import="com.ai.appframe2.service.ServiceFactory"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%
	IAbstractProductExtSV sv = (IAbstractProductExtSV) ServiceFactory
			.getService(IAbstractProductExtSV.class);
	String extType = HttpUtil.getAsString(request, "type");
	String opType = HttpUtil.getAsString(request, "opType");//1:新增    2:查看
	String applyId = HttpUtil.getAsString(request, "applyId");
	String chargeId = HttpUtil.getAsString(request, "chargeId");
	String rowIndex = HttpUtil.getAsString(request, "rowIndex");
	;
	if ("1".equals(extType)) {
		extType = "VOICE";

	} else if ("2".equals(extType)) {
		extType = "SMS";

	} else if ("3".equals(extType)) {
		extType = "MMS";
	} else if ("4".equals(extType)) {
		extType = "GPRSNOBUSY";
	}

	IBOProductExtDescValue[] values = sv.getColsName("", extType, "1",
			"1", -1, -1); //只查询扩展属性
	int length = values.length;
	int trNums = length % 3 == 0 ? length / 3 : length / 3 + 1;
%>
<html>
	<head>

		<title>资费扩展属性信息</title>
	</head>
	<body onload="init();">
		<ai:contractframe id="prodValue" contenttype="table" title="资费档次扩展信息"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:dbform setname="com.asiainfo.charge.web.SETChargeInfoExt"
				formid="prodInfo"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.asiainfo.charge.service.interfaces.IChargeInfoExtSV"
				implservice_querymethod="getChargeInfoExt(String applyId, String type)"
				initial="false">
				<table>
					<ai:dbformfield fieldname="APPLY_ID" formid="prodInfo"
						visible="false" />
					<ai:dbformfield fieldname="MID" formid="prodInfo" visible="false" />
					<ai:dbformfield fieldname="PRIV_TYPE" formid="prodInfo"
						visible="false" />

					<%
						for (int i = 0; i < trNums; i++) {
					%><tr>
						<%
							for (int j = 0; j <= 2; j++) {
									if ((3 * i + j) >= length) {
										break;
									}
									String editable = "true";
									if ("1".equals(opType)) {
										editable = "true";
									} else {
										editable = "false";
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
			<ai:button id="saveData" text="确定" onclick="confirmData()" />
		</div>
	</body>
</html>
<script type="text/javascript" language="javascript">

var chargForm = g_FormRowSetManager.get("prodInfo");
var type = "<%=extType%>";
var rowIndex = "<%=rowIndex%>";
var opType ="<%=opType%>";
var len = "<%=length%>";
function init(){
	var applyId = "<%=applyId%>";
	var chargeId = "<%=chargeId%>";
	if("2" == opType || "0" == len){
		g_AIButtonManager.get("saveData").setDisabled(true); 
	}
	if(null != applyId && ""!= applyId) {
		var cond ="";
		cond+="&applyId="+applyId;
		if(null!=type && ""!=type){
			cond+="&type="+type;
		}
		chargForm.refresh(cond);
		chargForm.setValue("APPLY_ID",applyId,applyId);
		chargForm.setValue("MID",chargeId,chargeId);
		chargForm.setValue("PRIV_TYPE",type,type);
		
	}
	else{
		return;
	}
	
}

function confirmData(){
	
	var xmlbody = chargForm.toXmlString(false);
	window.returnValue =xmlbody;
	window.close();
	
}
</script>