<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<head>
<title>资费配置</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
</head>
 
<ai:contractframe id="chargeDevInfoframe" contenttype="table" title="资费开发信息" width="100%" allowcontract="true" frameclosed="true">
	<ai:contractitem/>
	<ai:dbform formid="chargeDevInfo" 
	          setname="com.asiainfo.charge.web.SETChargeDevelopInfo"
	          conditionname="condition" parametersname="parameters"
	          editable="true" initial="false" 
	          datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	          implservice_name="com.asiainfo.charge.service.interfaces.IChargeCfgSV"
	          implservice_querymethod="getChargeDevInfo(String chargeId)" >
	      <table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
		     <tr>
		       <td class="td_font">需求编号：</td>
		       <td><ai:dbformfield formid="chargeDevInfo" fieldname="CODE" width="180"/><span class="font_red">*</span>
		           <ai:dbformfield formid="chargeDevInfo" fieldname="CHARGE_ID" width="180" visible="false"/>
		       </td>
		       <td class="td_font">开发状态：</td>
		       <td><ai:dbformfield formid="chargeDevInfo" fieldname="STATE" width="180"/><span class="font_red">*</span></td>
		       <td class="td_font">项目负责人：</td>
		       <td><ai:dbformfield formid="chargeDevInfo" fieldname="PRINCIPAL" width="180"/><span class="font_red">*</span>
		       </td>
		     </tr>
		     <tr>
		       <td class="td_font">计划完成时间：</td>
		       <td><ai:dbformfield formid="chargeDevInfo" fieldname="PLAN_DATE" width="180"/><span class="font_red">*</span></td>
		       <td class="td_font">实际完成时间：</td>
		       <td><ai:dbformfield formid="chargeDevInfo" fieldname="FINISH_DATE" width="180"/>
		       </td>
		     </tr>
		     <tr><td colspan="6" align="center"><ai:button text="保存资费开发信息" id="saveDevInfo_bt" onclick="saveDevInfo()"/></td></tr>
	     </table>
	</ai:dbform>
</ai:contractframe>

<script type="text/javascript">
var mainId = "<%=request.getParameter("recordId")%>";
var chargeDevInfo = g_FormRowSetManager.get("chargeDevInfo");
initDevInfoPage();

function initDevInfoPage() {
	var templateCode = "<%=request.getParameter("templateCode")%>";
	var taskTag = "<%=request.getParameter("taskTag")%>";
	if (mainId == null || mainId == 'null' || mainId == '') mainId = <%=request.getParameter("applyid")%>;
	chargeDevInfo.refresh("chargeId=" + mainId);
	if ('template.NewPChargeFlow' == templateCode || 'template.NewTChargeFlow' == templateCode) {
		if (taskTag == 'PC047' || taskTag == 'C047') {
			document.getElementById('contractFrame_chargeDevInfoframe').style.display='block';
		}
 	} else {
 		chargeDevInfo.setEditSts("false");
		document.getElementById('saveDevInfo_bt').style.visibility='hidden';
 	}
}

function saveDevInfo() {
	if ("O" !=chargeDevInfo.getSts()){
		chargeDevInfo.setValue("CHARGE_ID",mainId);
	    if (checkDevInfoWrite() == false) return;
		var list = new Array();
		list.push(chargeDevInfo);
		
		var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeCfgAction?action=saveChargeDevInfo';
		var recode = saveRowSet(strUrl, list);
	}
}

function checkDevInfoWrite() {
	if (trim(chargeDevInfo.getValue("CODE")) == '' || trim(chargeDevInfo.getValue("STATE")) == ''
		|| trim(chargeDevInfo.getValue("PRINCIPAL")) == '' || trim(chargeDevInfo.getValue("PLAN_DATE")) == '') {
		alert("带星号为必填项！");
		return false;
	} else  {
		return true;
	}
}

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>