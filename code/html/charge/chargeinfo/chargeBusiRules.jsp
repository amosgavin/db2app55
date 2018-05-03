<%@ page contentType="text/html; charset=GBK"%>
<%--<%@ include file="/secframe/common/common.jsp"%>--%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<title>档次信息-业务规则</title>
		<script language="javascript"
			src="<%=request.getContextPath()%>/jsv2/Calendar.jsp"
			type="text/javascript"></script>
	</head>

	<body onload="initPage()">
		<ai:contractframe id="chargeBusiRules" contenttype="table"
			title="业务规则" width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:dbform formid="chargeBusiRulesForm"
				setname="com.asiainfo.charge.web.SETBusiRules"
				conditionname="condition" parametersname="parameters" onvalchange=""
				editable="true" initial="false"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.asiainfo.charge.service.interfaces.IBusiRulesSV"
				implservice_querymethod="queryBusiRules(String id)">
				<table width="98%" align="center" border="0" cellpadding="1"
					cellspacing="2">
					<tr>
						<td>
							<b>可选叠加包</b> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
							<ai:button text="请点击选择可选叠加包" id="overLappedPackage"
								onclick="selectOverLappedPackage();" />
							<ai:dbformfield formid="chargeBusiRulesForm"
								fieldname="BUSIRULES_ID" width="50" visible="false" />
						</td>
					</tr>
					<tr>
						<td colspan="1">
							<ai:dbformfield formid="chargeBusiRulesForm"
								fieldname="OVERLAPPED_PACKAGE" height="80" width="500"
								editable="false" />
						</td>
					</tr>
					<tr>
						<td>
							<b>生效规则</b>
						</td>
					</tr>
					<tr>
						<td>
							<ai:dbformfield formid="chargeBusiRulesForm"
								fieldname="EFFECTIVE_RULES" height="160" width="500" editable="" />
						</td>
					</tr>
					<tr>
						<td>
							<b>套餐费计费规则</b>
						</td>
					</tr>
					<tr>
						<td>
							<ai:dbformfield formid="chargeBusiRulesForm"
								fieldname="BILLING_RULES" height="160" width="500" editable="" />
						</td>
					</tr>
				</table>
			</ai:dbform>
		</ai:contractframe>
		<div class="area_button">
			<ai:button text="清空" id="addBusiRules" onclick="addBusiRules()" />
			&nbsp;&nbsp;
			<ai:button text="保存" id="saveBusiRules"
				onclick="doWork('saveBusiRules()')" />
		</div>
	</body>
</html>
<script language="javascript">

var chargeBusiRulesFormRowSet= g_FormRowSetManager.get("chargeBusiRulesForm");

function initPage(){
var mid = "<%=request.getParameter("mid")%>";
var state="<%=request.getParameter("state")%>";
	if("" == mid || "null" == mid || null == mid){
		//var mid = window.parent.getTabitem("chargeTab","charge_1").contentWindow.g_FormRowSetManager.get("chargeMainDefrom").getValue("MID");
		if("" == mid || "null" == mid || null == mid){
			return;
		} 
	}
	if(state!="1"&&state!=""){
		    g_AIButtonManager.get("addBusiRules").setDisabled(true);
		    g_AIButtonManager.get("saveBusiRules").setDisabled(true);
		   }
	
	chargeBusiRulesFormRowSet.refresh("&id="+mid);
	var tmpID = chargeBusiRulesFormRowSet.getValue("BUSIRULES_ID");
	if(""==tmpID){
		chargeBusiRulesFormRowSet.setStsToNew();
	}
}

function selectOverLappedPackage(){
	var url = _gModuleName + "/charge/common/modaldialog/optionalPackage.jsp";
    var style = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px";
	var selectOverlappedPackage = window.showModalDialog(url,'',"scroll:no;resizable:no;status:no;dialogHeight:500px;dialogWidth:600px",style);
	var overlappedPackageText = "";
	for(var i = 0; i<selectOverlappedPackage.elements.length; i++){
		overlappedPackageText += selectOverlappedPackage.elements[i].packageId+":"
									+ selectOverlappedPackage.elements[i].name+"；";
	}
	chargeBusiRulesFormRowSet.setValue("OVERLAPPED_PACKAGE",overlappedPackageText);
}

function saveBusiRules(){
	var feeType = window.parent.getTabitem("chargeTab","charge_1").contentWindow.g_FormRowSetManager.get("chargeMainDefrom").getValue("CHARGE_TYPE");
	var busid = window.parent.getTabitem("chargeTab","charge_1").contentWindow.g_FormRowSetManager.get("chargeMainDefrom").getValue("MID");
	if ("" == busid){
		return alert("请先保存档次信息!");
	}
	chargeBusiRulesFormRowSet.setValue("BUSIRULES_ID",busid);
	var busiRulesId=chargeBusiRulesFormRowSet.getValue("BUSIRULES_ID");
	var overLappedPackage=chargeBusiRulesFormRowSet.getValue("OVERLAPPED_PACKAGE");
	var effectiveRules=chargeBusiRulesFormRowSet.getValue("EFFECTIVE_RULES");
	var billingRules=chargeBusiRulesFormRowSet.getValue("BILLING_RULES");
	if(overLappedPackage=="" && feeType !="31" && feeType !="41"){
		return  alert("请输入可选叠加包！");
	}
	if(effectiveRules==""){
		return alert("请输入生效规则！");
	}
	if(billingRules==""){
		return alert("请输入套餐费计费规则！");
	}
	if("O" != chargeBusiRulesFormRowSet.getSts()){
		var list = new Array();
	    list.push(chargeBusiRulesFormRowSet);
	    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.BusiRulesAction?action=saveBusiRules';
	    var recode = saveRowSet(strUrl, list);
	    var successFlag = recode.getValueByName("FLAG");
	    if(successFlag=="Y"){
	    	//var busiRulesId = recode.getValueByName("ID");
	    	chargeBusiRulesFormRowSet.refresh("&id="+busiRulesId);
	    	//chargeBusiRulesFormRowSet.setValue("BUSIRULES_ID",busiRulesId);
	    	//chargeBusiRulesFormRowSet.setStsToOld();
	    }
	}
}

function addBusiRules(){
	chargeBusiRulesFormRowSet.setValue("BUSIRULES_ID","");
	chargeBusiRulesFormRowSet.setValue("OVERLAPPED_PACKAGE","");
	chargeBusiRulesFormRowSet.setValue("EFFECTIVE_RULES","");
	chargeBusiRulesFormRowSet.setValue("BILLING_RULES","");
}

</script>
<script language="javascript"
	src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>