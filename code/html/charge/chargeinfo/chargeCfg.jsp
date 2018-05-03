<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<head>
<title>资费配置</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
</head>
 
<div style="display:block">
<table>
	<tr>
		<td width="55%" height="100%">
		<ai:contractframe id="chargeCfgframe" contenttype="table" title="资费配置信息(多个填写项请用;号隔开。例如：AA;BB;CC)" width="98%" allowcontract="false" frameclosed="false">
			<ai:contractitem/>
			<ai:dbform formid="chargeCfgForm" 
			          setname="com.asiainfo.charge.web.SETChargeCfg"
			          conditionname="condition" parametersname="parameters"
			          editable="true" initial="false" 
			          datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			          implservice_name="com.asiainfo.charge.service.interfaces.IChargeCfgSV"
			          implservice_querymethod="getCfgInfoByChargeId(String chargeId, String flag)" >
			     <table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
				     <tr>
				       <td class="td_font">账目项编码：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="ACCOUNTS_CODE" width="180"/><span class="font_red">*</span>
				       </td>
				       <td class="td_font">账目项名称：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="ACCOUNTS_NAME" width="180"/><span class="font_red">*</span></td>
				     </tr>
				     <tr>
				       <td class="td_font">科目编码：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="COURSE_CODE" width="180"/><span class="font_red">*</span>
				       </td>
				       <td class="td_font">科目名称：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="COURSE_NAME" width="180"/><span class="font_red">*</span></td>
				     </tr>
				     <tr>
				       <td class="td_font">费用组编码：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="FEE_GROUP_CODE" width="180"/><span class="font_red">*</span>
				       </td>
				       <td class="td_font">费用组名称：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="FEE_GROUP_NAME" width="180"/><span class="font_red">*</span></td>
				     </tr>
				     <tr>
				       <td class="td_font">集合编码：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="SET_CODE" width="180"/><span class="font_red">*</span>
				       </td>
				       <td class="td_font">集合名称：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="SET_NM" width="180"/><span class="font_red">*</span></td>
				     </tr>
				     <tr>
				       <td class="td_font">映射编码：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="MAP_CODE" width="180"/><span class="font_red">*</span>
				       </td>
				       <td class="td_font">映射名称：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="MAP_NAME" width="180"/><span class="font_red">*</span></td>
				     </tr>
				     <tr>
				       <td class="td_font">资费批次编码：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="BATCH_CODE" width="180" editable="false"/><img id="select1_" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="batchCodeSelected('C');"  align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
				       	   <ai:dbformfield formid="chargeCfgForm" fieldname="CFID" width="60" editable="" visible="false"/>
				       	   <ai:dbformfield formid="chargeCfgForm" fieldname="CHARGE_ID" width="150" editable="" visible="false"/>
				       	   <ai:dbformfield formid="chargeCfgForm" fieldname="CFG_FLAG" width="150" visible="false"/>
				       </td>
				       <td class="td_font">资费批次名称：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="BATCH_NAME" width="180" editable="false"/><img id="select2_" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="batchNameSelected('C');"  align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
				     </tr>
				     <tr>
				       <td class="td_font">资费号：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="REMARK1" width="180"/><span class="font_red">*</span>
				       </td>
				       <td class="td_font">资费名称：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="REMARK2" width="180"/><span class="font_red">*</span></td>
				     </tr>
				     <tr>
				       <td class="td_font">优惠编码：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="PRE_CODE" width="180"/><span class="font_red">*</span>
				       </td>
				       <td class="td_font">优惠名称：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="PRE_NAME" width="180"/><span class="font_red">*</span></td>
				     </tr>
				     <tr>
				       <td class="td_font">产品编码：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="PRODUCT_CODE" width="180"/><span class="font_red">*</span>
				       </td>
				       <td class="td_font">产品名称：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="PRODUCT_NAME" width="180"/><span class="font_red">*</span></td>
				     </tr>
				     <tr>
				       <td class="td_font">风险等级：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="REMARK3" width="180"/><span class="font_red">*</span>
				       </td>
				     </tr><tr>
				       <td class="td_font">风险评估描述：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="REAMRK7" width="300" height="50"/><span class="font_red">*</span></td>
				     </tr>
				     <tr><td><b>关联修改</b></td></tr>
				     <tr>
				       <td class="td_font">费用组编码：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="RELA_FEEGROUP_CODE" width="180"/>
				       </td>
				       <td class="td_font">费用组名称：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="RELA_FEEGROUP_NAME" width="180"/></td>
				     </tr>
				     <tr>
				       <td class="td_font">修改的原因：</td>
				       <td colspan="3"><ai:dbformfield formid="chargeCfgForm" fieldname="FEEGROUP_MODIFY_REASON" width="300" height="50"/></td>
				     </tr>
				     <tr>
				       <td class="td_font">集合编码：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="RELA_SET_CODE" width="180"/>
				       </td>
				       <td class="td_font">集合名称：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="RELA_SET_NAME" width="180"/></td>
				     </tr>
				     <tr>
				       <td class="td_font">修改的原因：</td>
				       <td colspan="3"><ai:dbformfield formid="chargeCfgForm" fieldname="SET_MODIFY_REASON" width="300" height="50"/></td>
				     </tr>
				     <tr>
				       <td class="td_font">集合编码：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="RELA_MAP_CODE" width="180"/>
				       </td>
				       <td class="td_font">集合名称：</td>
				       <td><ai:dbformfield formid="chargeCfgForm" fieldname="RELA_MAP_NAME" width="180"/></td>
				     </tr>
				     <tr>
				       <td class="td_font">修改的原因：</td>
				       <td colspan="3"><ai:dbformfield formid="chargeCfgForm" fieldname="MAP_MODIFY_REASON" width="300" height="50"/></td>
				     </tr>
				     <tr><td colspan="4" align="center"><ai:button text="保存配置" id="savecfg_bt" onclick="saveChargeCfg()"/></td></tr>
			     </table>
			</ai:dbform>
	</ai:contractframe></td>
    <td width="44%" style="vertical-align: top;">
		<ai:contractframe id="chargeCfgApproveframe" contenttype="table" title="资费配置审核(多个填写项请用;号隔开。例如：AA;BB;CC)" width="98%" allowcontract="false" frameclosed="false">
		<ai:contractitem/>
		<ai:dbform formid="chargeCfgApproveForm" 
		          setname="com.asiainfo.charge.web.SETChargeCfg"
		          conditionname="condition" parametersname="parameters"
		          editable="true" initial="false" 
		          datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		          implservice_name="com.asiainfo.charge.service.interfaces.IChargeCfgSV"
		          implservice_querymethod="getCfgInfoByChargeId(String chargeId, String flag)" >
		      <table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
				     <tr>
				       <td class="td_font">账目项编码：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="ACCOUNTS_CODE" width="180"/>
				       </td>
				       <td class="td_font">账目项名称：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="ACCOUNTS_NAME" width="180"/></td>
				     </tr>
				     <tr>
				       <td class="td_font">科目编码：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="COURSE_CODE" width="180"/>
				       </td>
				       <td class="td_font">科目名称：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="COURSE_NAME" width="180"/></td>
				     </tr>
				     <tr>
				       <td class="td_font">费用组编码：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="FEE_GROUP_CODE" width="180"/>
				       </td>
				       <td class="td_font">费用组名称：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="FEE_GROUP_NAME" width="180"/></td>
				     </tr>
				     <tr>
				       <td class="td_font">集合编码：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="SET_CODE" width="180"/>
				       </td>
				       <td class="td_font">集合名称：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="SET_NM" width="180"/></td>
				     </tr>
				     <tr>
				       <td class="td_font">映射编码：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="MAP_CODE" width="180"/>
				       </td>
				       <td class="td_font">映射名称：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="MAP_NAME" width="180"/></td>
				     </tr>
				     <tr>
				       <td class="td_font">资费批次编码：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="BATCH_CODE" width="180" editable="false"/><img id="select3_" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="batchCodeSelected('A');"  align="absmiddle" style="cursor:hand;"/>
				       	   <ai:dbformfield formid="chargeCfgApproveForm" fieldname="CFID" width="60" editable="" visible="false"/>
				       	   <ai:dbformfield formid="chargeCfgApproveForm" fieldname="CHARGE_ID" width="150" editable="" visible="false"/>
				       	   <ai:dbformfield formid="chargeCfgApproveForm" fieldname="CFG_FLAG" width="150" visible="false"/>
				       </td>
				       <td class="td_font">资费批次名称：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="BATCH_NAME" width="180" editable="false"/><img id="select4_" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="batchNameSelected('A');"  align="absmiddle" style="cursor:hand;"/></td>
				     </tr>
				     <tr>
				       <td class="td_font">资费号：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="REMARK1" width="180"/>
				       </td>
				       <td class="td_font">资费名称：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="REMARK2" width="180"/></td>
				     </tr>
				     <tr>
				       <td class="td_font">优惠编码：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="PRE_CODE" width="180"/>
				       </td>
				       <td class="td_font">优惠名称：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="PRE_NAME" width="180"/></td>
				     </tr>
				     <tr>
				       <td class="td_font">产品编码：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="PRODUCT_CODE" width="180"/>
				       </td>
				       <td class="td_font">产品名称：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="PRODUCT_NAME" width="180"/></td>
				     </tr>
				     <tr>
				       <td class="td_font">风险等级：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="REMARK3" width="180"/>
				       </td>
				     </tr><tr>
				       <td class="td_font">风险评估描述：</td>
				       <td><ai:dbformfield formid="chargeCfgApproveForm" fieldname="REAMRK7" width="300" height="50"/></td>
				     </tr>
				      <tr><td colspan="4" align="center"><ai:button text="保存配置审核" id="savecfgapp_bt" onclick="saveChargeCfgApprove()"/></td></tr>
			    </table>
			</ai:dbform>
			</ai:contractframe>
    </td></tr>
</table>
</div>

<script type="text/javascript">
//g_FormRowSetManager.get("chargeCfgApproveForm").setEditSts("false");
//document.getElementById('savecfgapp_bt').style.visibility='hidden';
var mainId = "<%=request.getParameter("recordId")%>";
var chargeCfgForm = g_FormRowSetManager.get("chargeCfgForm");
var chargeCfgApproveForm =  g_FormRowSetManager.get("chargeCfgApproveForm");
//var chargeDetailListTable = g_TableRowSetManager.get("chargeDetailListTable");
initCfgPage();
function initCfgPage() {
	var templateCode = "<%=request.getParameter("templateCode")%>";
	var taskTag = "<%=request.getParameter("taskTag")%>";
	if (mainId == null || mainId == 'null' || mainId == '') mainId = <%=request.getParameter("applyid")%>;
	chargeCfgForm.refresh("chargeId=" + mainId + "&flag='C'");
	chargeCfgApproveForm.refresh("chargeId=" + mainId + "&flag='A'");
	if ('template.NewPChargeFlow' == templateCode || 'template.NewTChargeFlow' == templateCode || 'template.ZqChargeFlow' == templateCode) {
		if (taskTag == 'PC007' || taskTag == 'PC042' || taskTag == 'C019' || taskTag == 'C042') {
			document.getElementById('contractFrame_chargeCfgIframe').style.display='block';
			chargeCfgApproveForm.setEditSts("false");
			document.getElementById('savecfgapp_bt').style.visibility='hidden';
		} else if (taskTag == 'PC040' || taskTag == 'C040') {
	        document.getElementById('contractFrame_chargeCfgIframe').style.display='block';
			chargeCfgForm.setEditSts("false");
			document.getElementById('savecfg_bt').style.visibility='hidden';
		} else {
			chargeCfgApproveForm.setEditSts("false");
			chargeCfgForm.setEditSts("false");
			document.getElementById('savecfgapp_bt').style.visibility='hidden';
			document.getElementById('savecfg_bt').style.visibility='hidden';
		}
 	} else {
 		chargeCfgApproveForm.setEditSts("false");
		chargeCfgForm.setEditSts("false");
		document.getElementById('savecfgapp_bt').style.visibility='hidden';
		document.getElementById('savecfg_bt').style.visibility='hidden';
 	}
}

function saveChargeCfg() {
	if ("O" !=chargeCfgForm.getSts()){
		chargeCfgForm.setValue("CHARGE_ID",mainId);
		chargeCfgForm.setValue("CFG_FLAG","C");
	    //if (mainId == '') return alert("请先保存主信息！");
	    if (checkMustWrite() == false) return;
		var list = new Array();
		list.push(chargeCfgForm);
		
		var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeCfgAction?action=save';
		var recode = saveRowSet(strUrl, list);
	}
}

function checkMustWrite() {
	//alert(trim(chargeCfgForm.getValue("REMARK3")) == '');
	if (trim(chargeCfgForm.getValue("ACCOUNTS_CODE")) == '' || trim(chargeCfgForm.getValue("ACCOUNTS_NAME")) == ''
		|| trim(chargeCfgForm.getValue("BATCH_NAME")) == '' || trim(chargeCfgForm.getValue("BATCH_CODE")) == ''
		|| trim(chargeCfgForm.getValue("COURSE_CODE")) == '' || trim(chargeCfgForm.getValue("COURSE_NAME")) == ''
		|| trim(chargeCfgForm.getValue("FEE_GROUP_CODE")) == '' || trim(chargeCfgForm.getValue("FEE_GROUP_NAME")) == ''
		|| trim(chargeCfgForm.getValue("MAP_CODE")) == '' || trim(chargeCfgForm.getValue("MAP_NAME")) == ''
		|| trim(chargeCfgForm.getValue("REMARK1")) == '' || trim(chargeCfgForm.getValue("REMARK2")) == ''
		|| trim(chargeCfgForm.getValue("PRE_CODE")) == '' || trim(chargeCfgForm.getValue("PRE_NAME")) == ''
		|| trim(chargeCfgForm.getValue("PRODUCT_CODE")) == '' || trim(chargeCfgForm.getValue("PRODUCT_NAME")) == ''
		|| trim(chargeCfgForm.getValue("SET_CODE")) == '' || trim(chargeCfgForm.getValue("SET_NM")) == ''
		|| trim(chargeCfgForm.getValue("REMARK3")) == '' || trim(chargeCfgForm.getValue("REAMRK7")) == '') {
		alert("带星号为必填项！");
		return false;
	} else if (trim(chargeCfgForm.getValue("RELA_FEEGROUP_CODE")) != '' && (trim(chargeCfgForm.getValue("RELA_FEEGROUP_NAME")) == '' || trim(chargeCfgForm.getValue("FEEGROUP_MODIFY_REASON")) == '')
			   || trim(chargeCfgForm.getValue("RELA_FEEGROUP_NAME")) != '' && (trim(chargeCfgForm.getValue("RELA_FEEGROUP_CODE")) == '' || trim(chargeCfgForm.getValue("FEEGROUP_MODIFY_REASON")) == '')
			   || trim(chargeCfgForm.getValue("RELA_MAP_CODE")) != '' && (trim(chargeCfgForm.getValue("RELA_MAP_NAME")) == '' || trim(chargeCfgForm.getValue("MAP_MODIFY_REASON")) == '')
			   || trim(chargeCfgForm.getValue("RELA_MAP_NAME")) != '' && (trim(chargeCfgForm.getValue("RELA_MAP_CODE")) == '' || trim(chargeCfgForm.getValue("MAP_MODIFY_REASON")) == '')
			   || trim(chargeCfgForm.getValue("RELA_SET_CODE")) != '' && (trim(chargeCfgForm.getValue("RELA_SET_NAME")) == '' || trim(chargeCfgForm.getValue("SET_MODIFY_REASON")) == '')
			   || trim(chargeCfgForm.getValue("RELA_SET_NAME")) != '' && (trim(chargeCfgForm.getValue("RELA_SET_CODE")) == '' || trim(chargeCfgForm.getValue("SET_MODIFY_REASON")) == '')){
		alert("关联修改,请填写好编码、名称、修改原因！");
		return false;
	} else {
		return true;
	}
	
}
function saveChargeCfgApprove() {
	if ("O" !=chargeCfgApproveForm.getSts()){
		chargeCfgApproveForm.setValue("CHARGE_ID",mainId);
		chargeCfgApproveForm.setValue("CFG_FLAG","A");
	    //if (mainId == '') return alert("请先保存主信息！");
	    //if (checkMustWrite() == false) return;
		var list = new Array();
		list.push(chargeCfgApproveForm);
		
		var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeCfgAction?action=save';
		var recode = saveRowSet(strUrl, list);
	}
}

function batchCodeSelected(flag) {
	var url = "<%=request.getContextPath()%>/sale/common/modaldialog/batchCodeSelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    if (flag == 'C') {
	    var iniVal = chargeCfgForm.getValue("BATCH_CODE");
	    chargeCfgForm.setValue("BATCH_CODE",onItemMultiplySelected(url, iniVal, style));
    } else {
    	var iniVal = chargeCfgApproveForm.getValue("BATCH_CODE");
    	chargeCfgApproveForm.setValue("BATCH_CODE",onItemMultiplySelected(url, iniVal, style));
    }
}

function batchNameSelected(flag) {
	var url = "<%=request.getContextPath()%>/sale/common/modaldialog/batchNameSelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    if (flag == 'C') {
	    var iniVal = chargeCfgForm.getValue("BATCH_NAME");
	    chargeCfgForm.setValue("BATCH_NAME",onItemMultiplySelected(url, iniVal, style));
    } else {
    	var iniVal = chargeCfgApproveForm.getValue("BATCH_NAME");
    	chargeCfgApproveForm.setValue("BATCH_NAME",onItemMultiplySelected(url, iniVal, style));
    }
}

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>