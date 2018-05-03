<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>CRM档次信息审核</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/jquery/jquery-1.8.3.js" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  
<body onload="initPage()">
<ai:contractframe id="SysSaleInfoframe" contenttype="table" title="营销平台营销方案信息" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="SysSaleInfoForm" initial="false" editable="false"
			setname="com.asiainfo.sale.activity.web.SETOrderShow">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">批次编码：</td>
	           	<td><ai:dbformfield formid="SysSaleInfoForm" fieldname="BATCH_ID" width="170"/></td>
	           	<td class="td_font">批次名称：</td>
	           	<td colspan="3"><ai:dbformfield formid="SysSaleInfoForm" fieldname="BATCH_NAME" width="170"/></td>        	
			</tr>
			<tr>
	           	<td class="td_font">档次编码：</td>
	           	<td><ai:dbformfield formid="SysSaleInfoForm" fieldname="LEVEL_ID" width="170"/></td>
	           	<td class="td_font">档次名称：</td>
	           	<td><ai:dbformfield formid="SysSaleInfoForm" fieldname="LEVEL_NAME" width="170"/></td>
	           	<td class="td_font">活动类型：</td>
	           	<td><ai:dbformfield formid="SysSaleInfoForm" fieldname="SALE_FLAG" width="170"/></td>
			</tr>
			<tr>
	           	<td class="td_font">活动开始时间：</td>
	           	<td><ai:dbformfield formid="SysSaleInfoForm" fieldname="BEGIN_TIME" width="170"/></td>
	           	<td class="td_font">活动结束时间：</td>
	           	<td><ai:dbformfield formid="SysSaleInfoForm" fieldname="END_TIME" width="170"/></td>
			</tr>
			<tr>
	           	<td class="td_font">档次信息描述：</td>
	           	<td colspan="5"><ai:dbformfield formid="SysSaleInfoForm" fieldname="LEVEL_DESC" width="650" height="50"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

	<ai:contractframe id="PrivDetailframe" contenttype="table" title="基本信息" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem>
		<ai:button id="prodAudit_bt" text="查看批次信息" onclick="openProdDetail()"/>
		<ai:button id="modInfo_bt" text="查看变更信息" onclick="openModDetail()"/>
	</ai:contractitem>
	<ai:dbform formid="PrivDetailForm" initial="false" editable="false"
			setname="com.asiainfo.sale.activity.web.SETLevInfoCrm">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">档次编码：</td>
	           	<td><ai:dbformfield formid="PrivDetailForm" fieldname="PRIVID" width="170"/>
	           	    <ai:dbformfield formid="PrivDetailForm" fieldname="PRODID" width="170" visible="false"/></td>
	           	<td class="td_font">档次名称：</td>
	           	<td><ai:dbformfield formid="PrivDetailForm" fieldname="PRIVNAME" width="170"/></td>   
	           	<td class="td_font">创建单位：</td>
	           	<td><ai:dbformfield formid="PrivDetailForm" fieldname="CREATEORG" width="170"/></td>
	        </tr>
	        <tr>
	           	<td class="td_font">启用时间：</td>
	           	<td><ai:dbformfield formid="PrivDetailForm" fieldname="STARTDATE" width="170"/></td> 
	           	<td class="td_font">停用时间：</td>
	           	<td><ai:dbformfield formid="PrivDetailForm" fieldname="STOPDATE" width="170"/></td>
	           	<td class="td_font">审核状态：</td>
	           	<td><ai:dbformfield formid="PrivDetailForm" fieldname="AUDITSTATUS" width="170"/></td>     	
			</tr>
			<tr>
	           	<td class="td_font">生效类型：</td>
	           	<td><ai:dbformfield formid="PrivDetailForm" fieldname="AFFECTTYPE" width="170"/></td> 
	           	<td class="td_font">生效时间：</td>
	           	<td><ai:dbformfield formid="PrivDetailForm" fieldname="AFFECTOFFSET" width="170"/></td> 
			</tr>
			<tr>
				<td class="td_font">失效类型：</td>
	           	<td><ai:dbformfield formid="PrivDetailForm" fieldname="INVALIDTYPE" width="170"/></td>
	           	<td class="td_font">失效时间：</td>
	           	<td><ai:dbformfield formid="PrivDetailForm" fieldname="INVALIDOFFSET" width="170"/></td> 
			</tr>
			<tr>
				<td class="td_font">描述：</td>
	           	<td colspan="5"><ai:dbformfield formid="PrivDetailForm" fieldname="REMARK" width="650" height="50"/></td> 
			</tr>
		</table>
	</ai:dbform>
	</ai:contractframe>
	
	<ai:contractframe id="Privorgframe" contenttype="table" title="发布地区" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivorgTab" 
            tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            setname="com.asiainfo.sale.activity.web.SETLevInfoCrm"
            conditionname="condition" parametersname="parameters"
            editable="false" initial="false" width="100%" height="200" pagesize="4">
	        <ai:col fieldname="ORGID" width="170" />
	        <ai:col fieldname="ORGNAME" width="200" />
    	</ai:table>
	</ai:contractframe>
	<ai:contractframe id="Privchannelframe" contenttype="table" title="发布渠道" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivchannelTab" 
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.sale.activity.web.SETLevInfoCrm"
	           conditionname="condition" parametersname="parameters" pagesize="4"
	           editable="false" initial="false" width="100%" height="200" rowheight="50">
	        <ai:col fieldname="REGION" width="170" />
	        <ai:col fieldname="CHANNELNAME" width="300" />
	        <ai:col fieldname="OPERATION" width="300" />
	   	</ai:table>
	</ai:contractframe>
	<ai:contractframe id="Privprepayframe" contenttype="table" title="预存信息" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivprepayTab" 
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.sale.activity.web.SETLevInfoCrm"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="150" pagesize="4">
	        <ai:col fieldname="SUBJECT" width="170" />
	        <ai:col fieldname="AMOUNT" width="100" />
	        <ai:col fieldname="ISPRESENT" width="100" />
	        <ai:col fieldname="CREATEDATE" width="130" />
	        <ai:col fieldname="USETYPE" width="180" />
	        <ai:col fieldname="CHARGEITEM" width="180" />
	        <ai:col fieldname="CHGAFFECTOFFSET" width="170" />
	        <ai:col fieldname="STATUS" width="100" />
	        <ai:col title="说明" fieldname="REMARK" width="300" />
	   	</ai:table>
	</ai:contractframe>
	<ai:contractframe id="Privcusttypeframe" contenttype="table" title="客户等级" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivcusttypeTab" 
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.sale.activity.web.SETLevInfoCrm"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="150" pagesize="4">
	        <ai:col fieldname="REGION" width="170" />
	        <ai:col fieldname="VIPTYPE" width="300" />
	   	</ai:table>
	</ai:contractframe>
	<ai:contractframe id="Privcustgroupframe" contenttype="table" title="允许办理客户群" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivcustgroupTab" 
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.sale.activity.web.SETLevInfoCrm"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="200" pagesize="4">
	        <ai:col fieldname="CUSTGROUPNAME" width="300" />
	        <ai:col fieldname="REGION" width="170" />
	        <ai:col fieldname="CREATEDATE" width="130" />
	        <ai:col title="说明" fieldname="STARTDATE" width="130" />
	        <ai:col fieldname="ENDDATE" width="130" />
	   	</ai:table>
	</ai:contractframe>
	
	<ai:contractframe id="Privoperframe" contenttype="table" title="指定的工号" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivoperTab" 
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.sale.activity.web.SETLevInfoCrm"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="200" pagesize="4">
	        <ai:col fieldname="REGION" width="170" />
	        <ai:col fieldname="GROUPNAME" width="300" />
	        <ai:col fieldname="ISOPER" width="130" />
	   	</ai:table>
	</ai:contractframe>
	
	<ai:contractframe id="Privuserdefineframe" contenttype="table" title="自定义条件" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivuserdefineTab" 
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.sale.activity.web.SETLevInfoCrm"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="150" pagesize="4">
	        <ai:col fieldname="REGION" width="100" />
	        <ai:col fieldname="CONDITION" width="100" />
	        <ai:col title="约束条件" fieldname="OPERATION" width="100" />
	        <ai:col fieldname="PARAVALUE1" width="130" />
	        <ai:col fieldname="PARAVALUE2" width="130" />
	        <ai:col fieldname="BEGINDATE" width="130" />
	        <ai:col fieldname="ENDDATE" width="130" />
	        <ai:col fieldname="RULE" width="300" visible="false"/>
	        <ai:col fieldname="CHANNEL" width="180" />
	   	</ai:table>
	</ai:contractframe>
	<ai:contractframe id="Privrewardframe" contenttype="table" title="奖品选择" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivrewardTab" 
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.sale.activity.web.SETLevInfoCrm"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="150" pagesize="4">
	        <ai:col fieldname="REWARDNAME" width="300" />
	        <ai:col fieldname="SELTYPE" width="300" />
	        <ai:col fieldname="PRIVMETHOD" width="300" />
	        <ai:col title="优惠金额" fieldname="PRIVVALUE" width="130" />
	   	</ai:table>
	</ai:contractframe>
	<ai:dbform formid="crmAuditForm" initial="false" editable="true"
			setname="com.asiainfo.common.web.SETCrmAuditLog">
		<table>
			<tr>
				<td class="td_font">审核意见：</td>
	           	<td><ai:dbformfield formid="crmAuditForm" fieldname="CONTENT" width="600" height="50"/>
	           	    <ai:dbformfield formid="crmAuditForm" fieldname="INTERFACE_ID" width="150" visible="false"/>
	           	    <ai:dbformfield formid="crmAuditForm" fieldname="BOSS_CODE" width="150" visible="false"/>
	           	    <ai:dbformfield formid="crmAuditForm" fieldname="AUDIT_FLAG" width="150" visible="false"/></td>
				<td><ai:button id="bt_yes" text="审核通过"  onclick="auditPriv(1)"/></td>
				<td><ai:button id="bt_no" text="驳    回"  onclick="auditPriv(0)"/></td>
			</tr>
		</table>
    </ai:dbform>
<ai:loginuser/>
<script language="javascript" src="<%=request.getContextPath()%>/sale/activity/js/requestToCrm.js"></script>
<script type="text/javascript">
var SysSaleInfoForm = g_FormRowSetManager.get("SysSaleInfoForm");
var PrivDetailForm = g_FormRowSetManager.get("PrivDetailForm");
var crmAuditForm = g_FormRowSetManager.get("crmAuditForm");
var PrivorgTab = g_TableRowSetManager.get("PrivorgTab");
var PrivchannelTab = g_TableRowSetManager.get("PrivchannelTab");
var PrivprepayTab = g_TableRowSetManager.get("PrivprepayTab");
var PrivcusttypeTab = g_TableRowSetManager.get("PrivcusttypeTab");
var PrivcusttypeTab = g_TableRowSetManager.get("PrivcusttypeTab");
var PrivcustgroupTab = g_TableRowSetManager.get("PrivcustgroupTab");
var PrivoperTab = g_TableRowSetManager.get("PrivoperTab");
var PrivuserdefineTab = g_TableRowSetManager.get("PrivuserdefineTab");
var PrivrewardTab = g_TableRowSetManager.get("PrivrewardTab");
//var privDetail = "<%=request.getParameter("privDetail")%>";
//var prodDetail = "<%=request.getParameter("prodDetail")%>";
var privID = "<%=request.getParameter("levCode")%>";

function initCrmInfo() {
	//var privStatus = query_CRM("QueryPrivStatus");
	//if (privStatus.body.privstatus);
	privDatail = query_CRM("QueryPrivDetail");
	prodID = privDatail.body.prodID;
	prodDetail = query_CRM("QueryProdDetail",'',prodID);
	levInfoCrmTab.setValue(0,"PRIVID",privDatail.body.privID);
	levInfoCrmTab.setValue(0,"PRIVNAME",privDatail.body.privName);
	levInfoCrmTab.setValue(0,"CREATEDATE",privDatail.body.createDate);
	levInfoCrmTab.setValue(0,"STATUS",privDatail.body.status);
	levInfoCrmTab.setValue(0,"AUDITSTATUS",privDatail.body.auditStatus);
}


function initPage(){
	SysSaleInfoForm.setValue("LEVEL_ID","<%=request.getParameter("levCode")%>");
	SysSaleInfoForm.setValue("BATCH_ID","<%=request.getParameter("batchCode")%>");
	SysSaleInfoForm.setValue("BATCH_NAME","<%=request.getParameter("batchName")%>");
	SysSaleInfoForm.setValue("LEVEL_NAME","<%=request.getParameter("levName")%>");
	SysSaleInfoForm.setValue("LEVEL_DESC","<%=request.getParameter("levDesc")%>");
	SysSaleInfoForm.setValue("SALE_FLAG","<%=request.getParameter("saleFlag")%>");
	SysSaleInfoForm.setValue("BEGIN_TIME","<%=request.getParameter("beginDate")%>");
	SysSaleInfoForm.setValue("END_TIME","<%=request.getParameter("endDate")%>");
	//privID = "LEV270060120130101060026";
	privDetail = query_CRM("QueryPrivDetail", privID);
	if (privDetail.head.retCode != 0) return;
	//基本信息
	PrivDetailForm.setValue("PRIVID",privID);
	PrivDetailForm.setValue("PRODID",privDetail.body.prodID);
	PrivDetailForm.setValue("PRIVNAME",privDetail.body.privName);
	PrivDetailForm.setValue("CREATEORG",privDetail.body.createOrg);
	PrivDetailForm.setValue("STARTDATE",privDetail.body.startDate);
	PrivDetailForm.setValue("STOPDATE",privDetail.body.stopDate);
	PrivDetailForm.setValue("CREATEDATE",privDetail.body.createDate);
	PrivDetailForm.setValue("AUDITSTATUS",privDetail.body.auditStatus);
	PrivDetailForm.setValue("AFFECTTYPE",privDetail.body.affectType);
	PrivDetailForm.setValue("AFFECTOFFSET",privDetail.body.affectOffset);
	PrivDetailForm.setValue("INVALIDTYPE",privDetail.body.invalidType);
	PrivDetailForm.setValue("INVALIDOFFSET",privDetail.body.invalidOffset);
	PrivDetailForm.setValue("REMARK",privDetail.body.description);
	//发布地区
	var privOrg = query_CRM("QueryPrivorg",privID);
	for (var i=0; i<privOrg.body.array.$list.length; ++i) {
		PrivorgTab.newRow();
		PrivorgTab.setValue(i,"ORGID",privOrg.body.array.$list[i].orgID);
		PrivorgTab.setValue(i,"ORGNAME",privOrg.body.array.$list[i].orgName);
	}
	//发布渠道
	var privChannel = query_CRM("QueryPrivchannel",privID);
	for (var i=0; i< privChannel.body.array.$list.length; ++i) {
		PrivchannelTab.newRow(true);
		PrivchannelTab.setValue(i,"REGION",privChannel.body.array.$list[i].region);
		PrivchannelTab.setValue(i,"CHANNELNAME",privChannel.body.array.$list[i].channelName);
		PrivchannelTab.setValue(i,"OPERATION",privChannel.body.array.$list[i].operation);
	}
	//预存
	var privPrepay = query_CRM("QueryPrivprepay",privID);
	for (var i=0; i< privPrepay.body.array.$list.length; ++i) {
		PrivprepayTab.newRow();
		PrivprepayTab.setValue(i,"SUBJECT",privPrepay.body.array.$list[i].subject);
		PrivprepayTab.setValue(i,"AMOUNT",privPrepay.body.array.$list[i].amount);
		PrivprepayTab.setValue(i,"ISPRESENT",privPrepay.body.array.$list[i].isPresent);
		PrivprepayTab.setValue(i,"CREATEDATE",privPrepay.body.array.$list[i].createDate);
		PrivprepayTab.setValue(i,"REMARK",privPrepay.body.array.$list[i].remark);
		PrivprepayTab.setValue(i,"USETYPE",privPrepay.body.array.$list[i].useType);
		PrivprepayTab.setValue(i,"CHARGEITEM",privPrepay.body.array.$list[i].chargeitem);
		PrivprepayTab.setValue(i,"CHGAFFECTOFFSET",privPrepay.body.array.$list[i].chgAffectOffset);
		PrivprepayTab.setValue(i,"STATUS",privPrepay.body.array.$list[i].status);
	}
	//客户等级
	var privCusttype = query_CRM("QueryPrivcusttype",privID);
	for (var i=0; i< privCusttype.body.array.$list.length; ++i) {
		PrivcusttypeTab.newRow();
		PrivcusttypeTab.setValue(i,"REGION",privCusttype.body.array.$list[i].region);
		PrivcusttypeTab.setValue(i,"VIPTYPE",privCusttype.body.array.$list[i].vipType);
	}
	//允许办理客户群
	var privCustgroup = query_CRM("QueryPrivcustgroup",privID);
	for (var i=0; i< privCustgroup.body.array.$list.length; ++i) {
	  	PrivcustgroupTab.newRow();
		PrivcustgroupTab.setValue(i,"CUSTGROUPNAME",privCustgroup.body.array.$list[i].custGroupName);
		PrivcustgroupTab.setValue(i,"REGION",privCustgroup.body.array.$list[i].region);
		PrivcustgroupTab.setValue(i,"CREATEDATE",privCustgroup.body.array.$list[i].createDate);
		PrivcustgroupTab.setValue(i,"STARTDATE",privCustgroup.body.array.$list[i].startDate);
		PrivcustgroupTab.setValue(i,"ENDDATE",privCustgroup.body.array.$list[i].endDate);
	}
	//指定工号
	var privOper = query_CRM("QueryPrivoper",privID);
	for (var i=0; i< privOper.body.array.$list.length; ++i) {
		PrivoperTab.newRow();
		PrivoperTab.setValue(i,"REGION",privOper.body.array.$list[i].region);
		PrivoperTab.setValue(i,"GROUPNAME",privOper.body.array.$list[i].groupName);
		PrivoperTab.setValue(i,"ISOPER",privOper.body.array.$list[i].isOper);
	}
	//自定义条件
	var privUserDefine = query_CRM("QueryPrivuserdefine",privID);
	for (var i=0; i< privUserDefine.body.array.$list.length; ++i) {
		PrivuserdefineTab.newRow();
		PrivuserdefineTab.setValue(i,"REGION",privUserDefine.body.array.$list[i].region);
		PrivuserdefineTab.setValue(i,"CONDITION",privUserDefine.body.array.$list[i].condition);
		PrivuserdefineTab.setValue(i,"OPERATION",privUserDefine.body.array.$list[i].operation);
		PrivuserdefineTab.setValue(i,"PARAVALUE1",privUserDefine.body.array.$list[i].paraValue1);
		PrivuserdefineTab.setValue(i,"PARAVALUE2",privUserDefine.body.array.$list[i].paraValue2);
		PrivuserdefineTab.setValue(i,"BEGINDATE",privUserDefine.body.array.$list[i].beginDate);
		PrivuserdefineTab.setValue(i,"ENDDATE",privUserDefine.body.array.$list[i].endDate);
		PrivuserdefineTab.setValue(i,"RULE",privUserDefine.body.array.$list[i].rule);
		PrivuserdefineTab.setValue(i,"CHANNEL",privUserDefine.body.array.$list[i].channel);
	}
	//奖品选择
	var privReward = query_CRM("QueryPrivreward",privID);
	for (var i=0; i< privReward.body.array.$list.length; ++i) {
		PrivrewardTab.newRow();
		PrivrewardTab.setValue(i,"REWARDNAME",privReward.body.array.$list[i].rewardName);
		PrivrewardTab.setValue(i,"SELTYPE",privReward.body.array.$list[i].selType);
		PrivrewardTab.setValue(i,"PRIVMETHOD",privReward.body.array.$list[i].privMethod);
		PrivrewardTab.setValue(i,"PRIVVALUE",privReward.body.array.$list[i].privValue);
	}
}

function auditPriv(flag){
	var retState = audit_CRM("Privaddaudit", privID, '', '', flag);
	if (retState.head.retCode == 0) {
		alert("审核成功！");
		var privStatus = query_CRM("QueryPrivStatus",privID);
		if (privStatus == '') return;
		PrivDetailForm.setValue("AUDITSTATUS",privStatus.body.privStatus);
	} else {
		crmAuditForm.setValue("CONTENT","审核失败");
		alert("审核失败！");
	}
	crmAuditForm.setValue("INTERFACE_ID","Privaddaudit");
	crmAuditForm.setValue("BOSS_CODE",privID)
	crmAuditForm.setValue("AUDIT_FLAG",flag);
	var list = new Array();
	list.push(crmAuditForm);
	var strUrl = _gModuleName + '/business/com.asiainfo.common.web.CrmAuditLogAction?action=saveAuditLog';
	var recode = saveRowSet(strUrl, list);
}

function openProdDetail() {
	var prodID = PrivDetailForm.getValue("PRODID");
	if (prodID == null || prodID == "") return alert("批次编码为空！");
	var url = "<%=request.getContextPath()%>/sale/activity/include/_prodDetailInfoCrm.jsp?prodID="+prodID;
    window.showModalDialog(url, null, "scroll:yes;resizable:yes;help:no;status:s;dialogHeight:800px;dialogWidth:1200px");
}

function openModDetail() {
	var prodID = PrivDetailForm.getValue("PRODID");
	var url = "<%=request.getContextPath()%>/sale/activity/include/_modInfoCrm.jsp?prodID="+prodID + "&privID="+privID;
    window.showModalDialog(url, null, "scroll:yes;resizable:yes;help:no;status:s;dialogHeight:800px;dialogWidth:1200px");
}
</script>