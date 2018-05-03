<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>渠道规则</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<style>
table.stats
{
	text-align: left;
	font-family: Verdana, Geneva, Arial, Helvetica, sans-serif,"华文中宋";
	font-weight: normal;
	font-size: 13px;
	color: black;
	width: 700px;
	background-color: blank;
	border: 1px;
	border-collapse: collapse;
	border-spacing: 0px;
}
</style>
</head>
<body onload="initOper()">
<ai:contractframe id="channelRuleTabframe" contenttype="table" title="产品发布渠道规则" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem>
	    <ai:button id="bt_addRule" text="新增" onclick="newChannelRule()"/>
		<ai:button id="bt_delRule" text="删除" onclick="delRule()"/>
	</ai:contractitem>
    <ai:table tableid="channelRuleTab" 
            setname="com.asiainfo.sale.activity.web.SETChannelRule"
            conditionname="condition" parametersname="parameters" width="100%" rowsequence='true'
            onrowchange="showChannelRule" editable="false" initial="false" pagesize="30" height="250"
            needrefresh="true" multiselect="true"
            tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.activity.service.interfaces.IChannelRuleSV"
            implservice_querymethod="getRuleBySaleDetailId(String saleDetailId, String channelRulesIds)"
            implservice_countmethod="getRuleCountBySaleDetailId(String saleDetailId, String channelRulesIds)">
            <ai:col fieldname="RULE_ID" width="100" visible="false"/>
	        <ai:col fieldname="CONF_MODE" width="150" />
	        <ai:col fieldname="CHANNEL_TYPE" width="180" />
	        <ai:col fieldname="CHANNEL_POS_TYPE" width="180" />
	        <ai:col fieldname="CHANNEL_LEV_TYPE" width="180" />
    </ai:table>
</ai:contractframe>
<ai:contractframe id="channelRuleFormframe" contenttype="table" title="产品发布渠道规则" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="channelRuleForm" 
            setname="com.asiainfo.sale.activity.web.SETChannelRule"
            conditionname="condition" parametersname="parameters"
            onvalchange="onChannelTypeChg" initial="false" 
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.activity.service.interfaces.IChannelRuleSV"
            implservice_querymethod="getRuleByRuleId(String ruleId)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2" bordercolor="blue">
           <tr>
                <td class="td_font">配置方式：</td>
                <td><ai:dbformfield formid="channelRuleForm" fieldname="CONF_MODE" width="120" />
                    <ai:dbformfield formid="channelRuleForm" fieldname="DETAIL_ID" visible="false"/>
                    <ai:dbformfield formid="channelRuleForm" fieldname="REMARK1" visible="false"/></td>
                <td class="td_font">渠道类型：</td>
                <td><ai:dbformfield formid="channelRuleForm" fieldname="CHANNEL_TYPE" width="180"/></td>
           </tr>
           <tr>
                <td class="td_font">地理位置类型：</td>
                <td><ai:dbformfield formid="channelRuleForm" fieldname="CHANNEL_POS_TYPE" width="160"/><img id="selectImage1" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="geoPosMultiplySelected();"  align="absmiddle" style="cursor:hand;"/></td>
                <td class="td_font">渠道星级类型：</td>
                <td><ai:dbformfield formid="channelRuleForm" fieldname="CHANNEL_LEV_TYPE" width="160"/><img id="selectImage2" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="starLevelMultiplySelected();"  align="absmiddle" style="cursor:hand;"/></td>
            </tr>
            <tr><td colspan="4" align="center"><ai:button text="保存" id="savarule_bt" onclick="saveRule()"/></td></tr>
        </table>
    </ai:dbform>
</ai:contractframe>
<div>&nbsp;&nbsp;<span class="font_red">填写示例：</span><br/>
&nbsp;&nbsp;举例一：某个营销活动A允许自建他营3星级以上受理，允许特约代理点、指定专营店的4星及以上受理，允许所有自营厅受理，<br/>
&nbsp;&nbsp;则配置后的界面效果图允许所有自营厅受理，则配置后的界面效果图：
<table id="exmp1" width="100%" border="1" class="stats">
  <tr>
	<th width=80>规则序号</th>
	<th width=80>是否允许</th>
	<th width=80>渠道基础类型</th>
	<th width=80>地理位置类型</th>
	<th width=100>渠道星级</th>
 </tr>
  <tr>
    <td>1</td>
    <td>允许</td>
    <td>自建他营</td>
    <td>全部</td>
    <td>3星;4星;5星</td>
  </tr>
  <tr>
    <td>2</td>
    <td>允许</td>
    <td>特约代理点</td>
    <td>全部</td>
    <td>4星;5星</td>
  </tr>
  <tr>
    <td>3</td>
    <td>允许</td>
    <td>指定专营店</td>
    <td>全部</td>
    <td>4星;5星</td>
  </tr>
  <tr>
    <td>4</td>
    <td>允许</td>
    <td>自营厅</td>
    <td>全部</td>
    <td>------------</td>
  </tr>
</table>
&nbsp;&nbsp;举例二：营销活动B不允许星级4星及以下代理商受理，即相当于仅提供给 5星代理商+自营厅。有正反两种配置方式，效果相同：<br/>
<table id="exmp2" width="100%" border="1" class="stats">
  <tr>
	<th width=80>规则序号</th>
	<th width=80>是否允许</th>
	<th width=80>渠道基础类型</th>
	<th width=80>地理位置类型</th>
	<th width=100>渠道星级</th>
 </tr>
  <tr>
    <td width=80>1</td>
    <td width=80>禁止</td>
    <td width=80>自建他营</td>
    <td width=80>全部</td>
    <td width=100>1星;2星;3星;4星</td>
  </tr>
  <tr>
    <td width=80>2</td>
    <td width=80>禁止</td>
    <td width=80>特约代理点</td>
    <td width=80>全部</td>
    <td width=100>1星;2星;3星;4星</td>
  </tr>
  <tr>
    <td width=80>3</td>
    <td width=80>允许</td>
    <td width=80>自建他营</td>
    <td width=80>全部</td>
    <td width=100>5星</td>
  </tr>
  <tr>
    <td width=80>4</td>
    <td width=80>允许</td>
    <td width=80>特约代理点</td>
    <td width=80>全部</td>
    <td width=100>5星</td>
  </tr>
</table>
</div>
</body>

<script type="text/javascript">
var channelRuleForm = g_FormRowSetManager.get("channelRuleForm");
var channelRuleTab = g_TableRowSetManager.get("channelRuleTab");
var saleDetailId = <%=request.getParameter("saleDetailId")%>;
var channelRulesIds = "<%=request.getParameter("channelRulesIds")%>";

function initOper(){
	//if (saleDetailId == null || saleDetailId == '') return;
	channelRuleTab.refresh("&saleDetailId=" + saleDetailId + "&channelRulesIds=" + channelRulesIds);
	if (<%=request.getParameter("editable")%> == false) {
		channelRuleTab.setEditSts("false");
		channelRuleForm.setEditSts("false");
	}
	newChannelRule();
}

function onChannelTypeChg(pFieldName,pOldVal,pOldText,pNewVal,pNewText) {
	if (pFieldName == 'CHANNEL_TYPE'){
		initChannelRuleForm(pOldText, true);
	}
}
function initChannelRuleForm(channelTypeVal, reSetVal) {
	
	if (channelTypeVal < '7' || channelTypeVal == '8' || channelTypeVal == '9') {
		channelRuleForm.setColEditSts("CHANNEL_POS_TYPE", false);
		channelRuleForm.setColEditSts("CHANNEL_LEV_TYPE",false);
		channelRuleForm.setValue("CHANNEL_POS_TYPE","------------------");
		channelRuleForm.setValue("CHANNEL_LEV_TYPE","------------------")
		document.getElementById("selectImage1").onclick=null;
		document.getElementById("selectImage2").onclick=null;
	} else if (channelTypeVal == 'd' || channelTypeVal == 'c') {
		channelRuleForm.setColEditSts("CHANNEL_POS_TYPE",true);
		channelRuleForm.setColEditSts("CHANNEL_LEV_TYPE",false);
		if (reSetVal == true) {
			channelRuleForm.setValue("CHANNEL_POS_TYPE","");
			channelRuleForm.setValue("CHANNEL_LEV_TYPE","------------------")
		}
		document.getElementById("selectImage1").onclick=geoPosMultiplySelected;
		document.getElementById("selectImage2").onclick=null;
	} else {
		channelRuleForm.setColEditSts("CHANNEL_POS_TYPE",true);
		channelRuleForm.setColEditSts("CHANNEL_LEV_TYPE",true);
		if (reSetVal == true) {
			channelRuleForm.setValue("CHANNEL_POS_TYPE","");
			channelRuleForm.setValue("CHANNEL_LEV_TYPE","")
		}
		document.getElementById("selectImage1").onclick=geoPosMultiplySelected;
		document.getElementById("selectImage2").onclick=starLevelMultiplySelected;
	}
}

function saveRule() {
	if ("O" != channelRuleForm.getSts()){
		if (saleDetailId != null && saleDetailId != '' && saleDetailId != 'null') {
	  	   channelRuleForm.setValue("DETAIL_ID",saleDetailId);
		}
	  	channelRuleForm.setValue("REMARK1",'sale');
		var list = new Array();
		list.push(channelRuleForm);
		
		var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.ChannelRuleAction?action=saveChannelRule';
		var recode = saveRowSet(strUrl, list);
	    var rFlag = recode.getValueByName("FLAG");
		if ("Y" == rFlag)
		{
		  var retId = recode.getValueByName("RULEID");
		  if (retId != '') {
			  if (channelRulesIds != ''){
			  	channelRulesIds += ',' + retId;
			  } else {
			  	channelRulesIds = retId;
			  }
		  }
		  channelRuleTab.refresh("&saleDetailId=" + saleDetailId + "&channelRulesIds=" + channelRulesIds);
		  newChannelRule();
		}
	}
}

function newChannelRule() {
	channelRuleForm.newRow();
	channelRuleForm.setFocus("CONF_MODE");
	channelRuleForm.setFocus("CHANNEL_TYPE");
	channelRuleForm.setValue("CHANNEL_TYPE","2");
}

function delRule() {
	channelRuleForm.newRow();
	var delRulesArray = new Array();
	delRulesArray = channelRuleTab.getSelectedRows();
	var delRulesRowCount = delRulesArray.length;
    if (delRulesRowCount < 1) {
        return alert("请选择要删除的数据！");
    }
    while (delRulesRowCount > 0) {
	     delRulesRowCount--;
	     channelRuleTab.deleteRow(delRulesArray[delRulesRowCount]);
    }
    var list = new Array();
	list.push(channelRuleTab);
    var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.ChannelRuleAction?action=saveChannelRule';
	var recode = saveRowSet(strUrl, list);
    var rFlag = recode.getValueByName("FLAG");
}

function showChannelRule(oldIndex,newIndex) {
	if(-1 != oldIndex) {
       channelRuleTab.setRowBgColor(oldIndex,"");
    }
    channelRuleTab.setRowBgColor(newIndex,"yellow");
    var ruleId = channelRuleTab.getValue(newIndex, "RULE_ID");
    if (ruleId != null && ruleId != ''){
		channelRuleForm.refresh("&ruleId=" + ruleId);
    }
    initChannelRuleForm(channelRuleForm.getValue("CHANNEL_TYPE"),false);
}

function window.onbeforeunload() {
	window.returnValue = channelRulesIds;
}

function geoPosMultiplySelected() {
	var url = "<%=request.getContextPath()%>/sale/common/modaldialog/geoPosTypeSelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = channelRuleForm.getValue("CHANNEL_POS_TYPE");
    channelRuleForm.setValue("CHANNEL_POS_TYPE",onItemMultiplySelected(url, iniVal, style));
}

function starLevelMultiplySelected() {
	var url = "<%=request.getContextPath()%>/sale/common/modaldialog/starLevelSelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = channelRuleForm.getValue("CHANNEL_LEV_TYPE");
    channelRuleForm.setValue("CHANNEL_LEV_TYPE",onItemMultiplySelected(url, iniVal, style));
}
</script>
</html>