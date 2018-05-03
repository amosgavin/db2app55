<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>营销活动主要信息</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/DBListBox.js" type="text/javascript"></script>
</head>
<body onload="initPage();">

<ai:contractframe id="saleOrderframe" contenttype="table" title="营销活动主要信息" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="saleOrderForm" 
            setname="com.asiainfo.sale.activity.web.SETSaleOrder"
            conditionname="condition" parametersname="parameters"
            onvalchange="onSaleMainFormValChange" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleOrderSV"
            implservice_querymethod="getSaleOrderInfo(String orderId,
			String orderName, String pinciple, String staffName, String orgId,
			String orgName, String state, String beginTime, String endTime,int $STARTROWINDEX, int $ENDROWINDEX)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr>
            	<td class="td_font">申请人：</td>
            	<td><ai:dbformfield formid="saleOrderForm" fieldname="PRINCIPLE" width="150" visible="false"/>
            	    <ai:dbformfield formid="saleOrderForm" fieldname="PROP_NAME" width="150"/></td>
            	<td class="td_font">申请单位：</td>
            	<td><ai:dbformfield formid="saleOrderForm" fieldname="ORG_ID" width="150" visible="false"/>
            	    <ai:dbformfield formid="saleOrderForm" fieldname="ORG_NAME" width="150" /></td>
            </tr>
            <tr>
                <td class="td_font">工单名称：</td>
                <td colspan="3"><ai:dbformfield formid="saleOrderForm" fieldname="ORDER_NAME" width="300"/><span class="font_red">*</span>
                <ai:dbformfield formid="saleOrderForm" fieldname="ORDER_ID" width="50" visible="false"/>
                <ai:dbformfield formid="saleOrderForm" fieldname="STATE" visible="false"/></td>         
            </tr>
            <tr align="center"><td colspan="4"><ai:button id="bt_saveSaleOrder" text="保存工单信息" onclick="doWork('saveSaleOrderInfo(true)')"/></td></tr>
  </table>
    </ai:dbform>
</ai:contractframe>
<ai:contractframe id="saleMainListframe" contenttype="table" title="已保存的批次信息" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem><ai:button id="bt_newSaleMain" text="新建营销案" onclick="newSaleMain()"/>
    <ai:button id="bt_delSaleMain" text="删除选择活动" onclick="doWork('delSaleMain()')"/></ai:contractitem>
    <ai:table
        tableid="saleMainListTable" 
        setname="com.asiainfo.sale.activity.web.SETSaleMain"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleOrderSV"
        implservice_querymethod="getSaleMainByOrderId(String orderId, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getSaleMainCountByOrderId(String orderId)"
        initial="false"  multiselect="true" onrowchange="showSaleMainInfo"
        pagesize="15" editable="false" width="100%" 
        height="100" needrefresh="true">
        <ai:col title="批次ID" fieldname="MAINID" width="80" />
        <ai:col title="批次名称" fieldname="SALE_MAIN_NAME" width="300" />
        <ai:col title="执行范围" fieldname="EXEAREA" width="100" />
        <ai:col title="开始时间：" fieldname="BEGIN_TIME" width="150" />
        <ai:col title="结束时间：" fieldname="END_TIME" width="150" />
        <ai:col title="细分市场" fieldname="MARKTYPE" width="300" />
        <ai:col fieldname="ISGROUP" width="300" visible="false"/>
        <ai:col fieldname="ISACTIVE_SALE" width="300" visible="false"/>
    </ai:table>
</ai:contractframe>
<ai:contractframe id="saleMainframe" contenttype="table" title="营销活动批次信息" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="saleMainForm" 
            setname="com.asiainfo.sale.activity.web.SETSaleMain"
            conditionname="condition" parametersname="parameters"
            onvalchange="onSaleMainFormValChange" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleMainSV"
            implservice_querymethod="getSaleMainById(String id)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        	<tr>
                <td class="td_font">活动类型：</td>
                <td colspan="1"><ai:dbformfield formid="saleMainForm" fieldname="SALE_MAIN_TYPE"  width="150"/><span class="font_red">*</span></td>
            	<td class="td_font">活动分类：</td>
	            <td colspan="1"><ai:dbformfield formid="saleMainForm" fieldname="EXERCISE_TYPE" width="150"/><span class="font_red">*</span></td>
	            <td class="td_font">档次默认关系：</td>
	            <td colspan="1"><ai:dbformfield formid="saleMainForm" fieldname="GRADE_DEFAULT_RELATION" width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">营销案名称：</td>
                <td><ai:dbformfield formid="saleMainForm" fieldname="SALE_MAIN_NAME" width="220"/><span class="font_red">*</span>
                <ai:dbformfield formid="saleMainForm" fieldname="MAINID" width="50" visible="false"/>
                <ai:dbformfield formid="saleMainForm" fieldname="IS_SUBMIT" visible="false"/>
                <ai:dbformfield formid="saleMainForm" fieldname="ORDER_ID" visible="false"/></td>  
                <td class="td_font">开始时间：</td>
                <td><ai:dbformfield formid="saleMainForm" fieldname="BEGIN_TIME" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">结束时间：</td>
                <td><ai:dbformfield formid="saleMainForm" fieldname="END_TIME" width="150"/><span class="font_red">*</span></td>
                <%--<td class="td_font">编码：</td>
                <td><ai:dbformfield formid="saleMainForm" fieldname="SALE_MAIN_CODE" width="150" editable="false"/>
            	--%>
            </tr>
            <tr>
                <td class="td_font">细分市场：</td>
                <td colspan="1"><ai:dbformfield formid="saleMainForm" fieldname="MARKTYPE"  width="200"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="marketMultiplySelected();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
            	<td class="td_font">批次编码：</td>
	            <td colspan="1"><ai:dbformfield formid="saleMainForm" fieldname="SALE_MAIN_CODE" editable="false" width="150"/></td>
	            <td class="td_font">BOSS系统批次ID：</td>
	            <td colspan="1"><ai:dbformfield formid="saleMainForm" fieldname="PROMOTE_MANAGER" editable="false" width="150"/></td>
            </tr>
            <tr>
                <td class="td_font">执行范围：</td>
                <td><ai:dbformfield formid="saleMainForm" fieldname="EXEAREA" width="150"/><span class="font_red">*</span></td>
                <%-- <td class="td_font">是否集团信息化：</td>
                <td><ai:dbformfield formid="saleMainForm" fieldname="ISGROUP" width="150"/></td> --%>
                <td class="td_font">是否主动营销：</td>
                <td><ai:dbformfield formid="saleMainForm" fieldname="ISACTIVE_SALE" width="150"/></td>
            </tr>
            <tr id="zdyxdTR" style="display: none;">
                <td class="td_font">主动营销点：</td>
                <td colspan="5"><ai:dbformfield formid="saleMainForm" fieldname="ACTIVE_SALE_SITE"  width="460" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="zdyxdMultiplySelected();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
            </tr>
            <tr>
	        	<td class="td_font">电子渠道承载：</td>
	        	<td colspan="5"><ai:dbformfield formid="saleMainForm" fieldname="E_CHANNEL_BEAR" width="10" visible="false"/>
	        		<input type="checkbox" id="hint0_input" value="0" onclick="checkboxSts(0);" />短厅&nbsp;
	        		<input type="checkbox" id="hint1_input" value="1" onclick="checkboxSts(1);" />网厅&nbsp;
	               	<input type="checkbox" id="hint2_input" value="2" onclick="checkboxSts(2);" />WAP厅&nbsp;
	               	<input type="checkbox" id="hint3_input" value="3" onclick="checkboxSts(3);" />微厅&nbsp;
	               	<input type="checkbox" id="hint4_input" value="4" onclick="checkboxSts(4);" />和悦会&nbsp;
	               	<input type="checkbox" id="hint5_input" value="5" onclick="checkboxSts(5);" />手机营业厅APP&nbsp;
	               	<input type="checkbox" id="hint6_input" value="6" onclick="checkboxSts(6);" />移动商城PC版&nbsp;
	               	<input type="checkbox" id="hint7_input" value="7" onclick="checkboxSts(7);" />触屏版&nbsp;
	               	<input type="checkbox" id="hint8_input" value="8" onclick="checkboxSts(8);" />外部电商</td>
        	</tr>
            <tr>
                <td class="td_font">策划人：</td>
                <td><ai:dbformfield formid="saleMainForm" fieldname="PROJECTER" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">策划人联系电话：</td>
                <td><ai:dbformfield formid="saleMainForm" fieldname="PROJECTER_TELNUM" width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr id="jttype" style="display: none;">
            <td class="td_font">集团单位属性：</td>
             <td><ai:dbformfield formid="saleMainForm" fieldname="GROUP_PROP" width="150"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="groupTypeSelected();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
             <td class="td_font">营销对象：</td>
             <td><ai:dbformfield formid="saleMainForm" fieldname="SALE_OBJECT" width="150"/><span class="font_red">*</span></td>
             <td class="td_font">活动类型：</td>
             <td><ai:dbformfield formid="saleMainForm" fieldname="ACTIVITY_TYPE" width="150"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="activityTypeSelected();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">背景：</td>
                <td colspan="5"><ai:dbformfield formid="saleMainForm" fieldname="BACK_GROUND" height="86" width="650"/></td>
            </tr>
            <tr>
                <td class="td_font">目标：</td>
                <td colspan="5"><ai:dbformfield formid="saleMainForm" fieldname="AIM" height="86" width="650"/></td>
            </tr>
            <tr>
                <td class="td_font">详细：</td>
                <td colspan="5"><ai:dbformfield formid="saleMainForm" fieldname="CONTENT" height="86" width="650"/></td>
            </tr>
            <tr>
            	<td class="td_font">备注：</td>
                <td colspan="3"><span class="font_red">如果是电子券的营销活动,请保存主要信息后填写电子券申告单</span></td>
            </tr>
            <%--<tr>
                <td class="td_font">审核状态：</td>
                <td colspan="5"><ai:dbformfield formid="saleMainForm" fieldname="IS_SUBMIT" editable="false"/><ai:button id="newSaleMain" text="新建营销案" onclick="newSaleMain()"/>
                                <ai:button id="bt_saveSaleMain" text="保存当前" onclick="doWork('saveSaleMain(true)')"/>
                                <ai:button id="bt_doCreateDetail" text="下一步：档次信息填写" onclick="doWork('doCreateDetail()')"/></td>
            </tr>
        --%></table>
    </ai:dbform>
</ai:contractframe>
<ai:contractframe id="channelListframe" contenttype="table" title="批次渠道信息（必填项）" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem>
    	<ai:button id="bt_addChannl" text="新增" onclick="addChannel()"/>
    	<ai:button id="bt_delChannl" text="删除（勾选项）" onclick="doWork('delChannel()')"/>
    </ai:contractitem>
    <ai:table
        tableid="channelListTable"
        setname="com.asiainfo.sale.activity.web.SETChannelInfo"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleChannelInfoSV"
        implservice_querymethod="getChannelInfoByRelaId(String relaId,String relaType, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getCnChannelListByRelaId(String relaId, String relaType)"
        initial="false"  multiselect="true"
        pagesize="15" editable="true" width="100%"
        height="120" needrefresh="true">
        <ai:col fieldname="REGION" width="15%" />
        <ai:col fieldname="CHANNEL_CODE" width="30%" />
        <ai:col fieldname="OPERATION" width="15%" />
        <ai:col fieldname="ID" width="15%" visible="false"/>
        <ai:col fieldname="REL_ID" width="15%" visible="false"/>
        <ai:col fieldname="REL_TYPE" width="15%" visible="false"/>
    </ai:table>
</ai:contractframe>
<ai:contractframe id="cgroupListframe" contenttype="table" title="目标客户群信息" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem>
    	<ai:button id="bt_addCgroup" text="新增" onclick="addCgroup()"/>
    	<ai:button id="bt_delCgroup" text="删除（勾选项）" onclick="doWork('delCgroup()')"/>
    </ai:contractitem>
    <ai:table
        tableid="cgroupListTable"
        setname="com.asiainfo.sale.activity.web.SETSaleRelatCgroup"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" 
        implservice_name="com.asiainfo.sale.activity.service.interfaces.ICustGroupSV"
        implservice_querymethod="getSaleRelatCgroupByRelaId(String relaId,String relaType, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getCnSaleRelatCgroupByRelaId(String relaId, String relaType)"
        initial="false"  multiselect="true" 
        pagesize="15" editable="true" width="100%"
        height="120" needrefresh="true">
        <ai:col fieldname="CGROUP_ID" width="15%" editable="false"/>
        <ai:col fieldname="CGROUP_NAME" width="30%" editable="false"/>
        <ai:col fieldname="CGROUP_REGION" width="15%" editable="false"/>
        <ai:col fieldname="CGROUP_FLAG" width="10%" />
        <ai:col fieldname="CGROUP_BEGIN_TIME" width="10%"/>
        <ai:col fieldname="CGROUP_END_TIME" width="10%" />
        <ai:col fieldname="ID" width="1%" visible="false"/>
        <ai:col fieldname="CGROUP_TAB" width="30%" visible="false"/>
        <ai:col fieldname="CGROUP_USERNUM" width="30%" visible="false"/>
        <ai:col fieldname="ORDER_ID" width="15%" visible="false"/>
        <ai:col fieldname="RELAT_ID" width="15%" visible="false"/>
        <ai:col fieldname="RELAT_TYPE" width="15%" visible="false"/>
    </ai:table>
</ai:contractframe>
<div id="eChnlCommand_div1" style='display: none;'>
<ai:contractframe id="EChannelNcodeCommand" contenttype="table" title="短厅指令列表" width="100%" allowcontract="true" frameclosed="false">
   
    <ai:contractitem>
    	<ai:button id="bt_addEChannelNcodeCommand" text="新增" onclick="addEChannelNcodeCommand()"/>
    	<ai:button id="bt_delUEChannelNcodeCommand" text="删除（勾选项）" onclick="doWork('delEchannelNcodeCommand()')"/>
    	<span class="font_red">（"名称,开通指令,取消指令"请由发起人填写；"主体资费,产品包,增值产品,产品包,基础产品,附加属性,业务规则"请由配置人员填写）</span>
    </ai:contractitem>
    <ai:table
        tableid="EChannelNcodeCommandListTable"
        setname="com.asiainfo.charge.web.SETEchannelNcodeCommand"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.charge.service.interfaces.IEchannelNcodeCommandSV"
        implservice_querymethod="getEchannelNcodeCommandByRelaId(String relaId,String infoType, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getCnEchannelNcodeCommandListByRelaId(String relaId,String infoType)"
        initial="false"  multiselect="true"
        pagesize="15" editable="true" width="100%"
        height="120" needrefresh="true">
      	<ai:col fieldname="NAME" width="10%" />
        <ai:col fieldname="OPEN_COMMAND" width="7%" />
        <ai:col fieldname="CANCEL_COMMAND" width="7%" />
        <ai:col fieldname="NCODE" width="6%" visible="false"/>
        <ai:col fieldname="PRI_TARIFF" width="10%"/>
        <ai:col fieldname="PROD_PACKAGE" width="10%" />
        <ai:col fieldname="G_PRODUCT" width="10%" />
        <ai:col fieldname="PROD_PACKAGE2" width="7%"/>
		<ai:col fieldname="BASE_PRODUCT" width="7%" />
        <ai:col fieldname="ADD_ATTR" width="10%" />
		<ai:col fieldname="BUSI_RULE" width="16%" />
		<ai:col fieldname="INFO_TYPE" width="15%" visible="false"/>
		<ai:col fieldname="REL_ID" width="15%" visible="false"/>
    </ai:table>
</ai:contractframe>
</div>
<div id='e_channel_exp' style='display: none;'>
	<%@include file="/sale/activity/include/_explan_main.jsp"%>
	<%@include file="/sale/activity/include/_attach_main.jsp"%>
</div>
<div class="area_button">
	<ai:button id="bt_saveEchlCom" text="保存短厅指令" onclick="saveEChannelNcodeCommandb()"/>
    <ai:button id="bt_newSaleMain1" text="新建营销案" onclick="newSaleMain()"/>
    <ai:button id="bt_saveSaleMain" text="保存当前" onclick="doWork('saveSaleMain(true)')"/>
    <ai:button id="bt_saveSaleEit" text="填写电子券申告单" onclick="writeSaleEitApprise()"/>
    <ai:button id="bt_telPayFee" text="手机支付话费申告单" onclick="telPayFeeApprise()"/>
    <ai:button id="bt_telPartsFee" text="手机配件定向专用申告单" onclick="telPartsApprise()"/>
     <ai:button id="bt_saveSaleHbHb" text="填写和包红包申告单" onclick="writeSaleHbHb()"/>
    <ai:button id="bt_doCreateDetail" text="下一步：档次信息填写" onclick="doWork('doCreateDetail()')"/>
</div>

</body>
</html>
<ai:loginuser/>
<script type="text/javascript">
var _saleMainForm = _fromSaleMainFormRowSet();
var _saleOrderForm = _fromSaleOrderFormRowSet();
var _saleMainTab = _fromSaleMainTabRowSet();
var _channelListTab = g_TableRowSetManager.get("channelListTable");
var _cgroupListTab = g_TableRowSetManager.get("cgroupListTable");
var _EChannelNcodeCommandListTab = g_TableRowSetManager.get("EChannelNcodeCommandListTable");

function _fromSaleOrderFormRowSet(){
	return g_FormRowSetManager.get("saleOrderForm");
}
function _fromSaleMainTabRowSet(){
	return g_TableRowSetManager.get("saleMainListTable");
}
function _fromSaleMainFormRowSet(){
	return g_FormRowSetManager.get("saleMainForm");
}
function _tableSaleDetailGroupListTableRowSet(){
	return g_TableRowSetManager.get("saleDetailGroupListTable");
}
function _tableSaleDetailListTableRowSet(){
	return g_TableRowSetManager.get("saleDetailListTable");
}

function include_refreshSaleMainTable(orderId) {
    _saleMainTab.refresh("&orderId="+orderId);
    newSaleMain();
}

function getMainId() {
	return _saleMainForm.getValue("MAINID");
}

function initPage()
{
	var orderId = "<%=request.getParameter("orderId")%>";
	var taskTag = "<%=request.getParameter("taskTag")%>";
	if(taskTag=='wp02'||taskTag=='su107'){
		
	}else{
		document.getElementById('bt_saveEchlCom').style.visibility='hidden';	
	}
    initSaleOrderForm(orderId);
    if (g_GetUserInfo().ORG_ID.substr(0,2) != 10 && g_GetUserInfo().ORG_ID.substr(0,2) != 29){
    	document.getElementById('bt_telPayFee').style.display='none';
    }
    //_saleMainForm.setFocus("ISGROUP")
    var editable = "<%=request.getParameter("editable")%>";
    if (editable == "false") {
    	_saleOrderForm.setEditSts(false);
    	_saleMainForm.setEditSts(false);
    	_channelListTab.setEditSts(false);
    	_cgroupListTab.setEditSts(false);
    	_EChannelNcodeCommandListTab.setEditSts(false);
    	setButtonDisabled();
    }else{
    	_saleMainForm.removeListBoxOption("EXERCISE_TYPE","rtOther");
    	_saleMainForm.removeListBoxOption("EXERCISE_TYPE","rtPrepayTerm");
    	_saleMainForm.removeListBoxOption("EXERCISE_TYPE","rtPresentTerm");
    	_saleMainForm.removeListBoxOption("EXERCISE_TYPE","rtHeartMobile");
    	_saleMainForm.removeListBoxOption("EXERCISE_TYPE","rtRealInvoice");
    }
    if(_saleMainTab.getTotalRowCount() > 0){
	    _saleMainTab.setRow(0);
    }
    document.getElementById("TableRowSet_cgroupListTable").onclick= calendarDlg;
}

function writeSaleEitApprise(){
	if (getMainId() == ""){
		return alert("请先选择营销案批次！");
	}
	var saleName = _saleMainForm.getValue("SALE_MAIN_NAME").replace(/"/g,"\'");
	var url = "<%=request.getContextPath()%>/sale/activity/include/_eitApprise.jsp?mainId="+getMainId()+"&saleName="+saleName;
	var retVal = window.open(url,"","height=650,width=600,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}

function writeSaleHbHb(){
	if (getMainId() == ""){
		return alert("请先选择营销案批次！");
	}
	var saleName = _saleMainForm.getValue("SALE_MAIN_NAME").replace(/"/g,"\'");
	var url = "<%=request.getContextPath()%>/sale/activity/include/_saleHbhb.jsp?mainId="+getMainId()+"&saleName="+saleName;
	var retVal = window.open(url,"","height=650,width=600,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}

function telPayFeeApprise(){
	if (getMainId() == ""){
		return alert("请先选择营销案批次！");
	}
	var saleName = _saleMainForm.getValue("SALE_MAIN_NAME").replace(/"/g,"\'");
	var url = "<%=request.getContextPath()%>/sale/activity/include/_telPayFeeApprise.jsp?mainId="+getMainId()+"&saleName="+saleName;
	var retVal = window.open(url,"","height=650,width=600,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}

function telPartsApprise() {
	if (getMainId() == ""){
		return alert("请先选择营销案批次！");
	}
	var saleName = _saleMainForm.getValue("SALE_MAIN_NAME").replace(/"/g,"\'");
	var url = "<%=request.getContextPath()%>/sale/activity/include/_telPartsApprise.jsp?mainId="+getMainId()+"&saleName="+saleName;
	var retVal = window.open(url,"","height=650,width=600,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}

function initSaleOrderForm(orderId)
{
	if("" == orderId || "null" == orderId){
	    _saleOrderForm.setValue("PRINCIPLE",g_GetUserInfo().STAFF_ID);
	    _saleOrderForm.setValue("PROP_NAME",g_GetUserInfo().STAFF_NAME);
	    _saleOrderForm.setValue("ORG_ID",g_GetUserInfo().ORG_ID);
	    _saleOrderForm.setValue("ORG_NAME",g_GetUserInfo().ORG_NAME);
	    newSaleMain();
	} else {
	    _saleOrderForm.refresh("&orderId="+orderId);
	    _saleMainTab.refresh("&orderId="+orderId);
	}
    _saleOrderForm.setColEditSts("PROP_NAME",false);
    _saleOrderForm.setColEditSts("ORG_NAME",false);
}

/*function initSaleMainForm(orderId)
{   //_saleMainForm.setColEditSts("ISGROUP",false);
	if("" == orderId || "null" == orderId){
	    _saleMainForm.setValue("PRINCIPAL",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
	    _saleMainForm.setValue("PROMOTE_DEPART",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
	    _saleMainForm.setValue("ISACTIVE_SALE","false");
	    _saleMainForm.setValue("ISGROUP","false");
	    _saleMainForm.setValue("EXEAREA",getDefualtExearea());
	} else {
	    _saleMainForm.refresh("&id=" + orderId);
	    var principal = _saleMainForm.getValue("PRINCIPAL");
	    var staff_name = _saleMainForm.getValue("STAFF_NAME");
	    var promote_depart = _saleMainForm.getValue("PROMOTE_DEPART");
	    var organize_name = _saleMainForm.getValue("ORGANIZE_NAME");
	    var isgroup = _saleMainForm.getValue("ISGROUP");
	    _saleMainForm.setValue("PRINCIPAL",principal,principal+"|"+staff_name);
	    _saleMainForm.setValue("PROMOTE_DEPART",promote_depart,promote_depart+"|"+organize_name);
	    //_tableSaleDetailListTableRowSet().refresh("&orderId=" + orderId);
	}
	if(isgroup=="true"){
	    _saleMainForm.setValue("ISACTIVE_SALE","false");
		_saleMainForm.setColEditSts("ISACTIVE_SALE",false);
		document.getElementById("jttype").style.display="block";
	} else {
	    _saleMainForm.setColEditSts("ISACTIVE_SALE",true);
	    document.getElementById("jttype").style.display="none";
	}
}*/

function checkboxSts(pos) {
	if(pos == 0){
		if(true == document.getElementById('hint0_input').checked){
			document.getElementById("eChnlCommand_div1").style.display="block";
		} else {
			document.getElementById("eChnlCommand_div1").style.display="none";
		}
	}
	if(pos>0&&pos<9){
		var checkflag = false;
		for(var i=1;i<9;i++){
			checkflag = document.getElementById('hint'+i+'_input').checked;
			if(checkflag) break;
		}
		if(checkflag){
			document.getElementById("e_channel_exp").style.display="block";
		} else {
			document.getElementById("e_channel_exp").style.display="none";
		}
	}	
}

function setCheckBox(hintVal) {
	document.getElementById("hint0_input").checked = false;
    document.getElementById("hint1_input").checked = false;
    document.getElementById("hint2_input").checked = false;
    document.getElementById("hint3_input").checked = false;
	document.getElementById("hint4_input").checked = false;
    document.getElementById("hint5_input").checked = false;
    document.getElementById("hint6_input").checked = false;
    document.getElementById("hint7_input").checked = false;
	document.getElementById("hint8_input").checked = false;
	document.getElementById("e_channel_exp").style.display="none";
	document.getElementById("eChnlCommand_div1").style.display="none";
	
	if(hintVal != null && hintVal != ""){
    	var hintVec = hintVal.split(";");
    	for(var i = 0; i < hintVec.length; i++){
    		document.getElementById("hint"+hintVec[i] + "_input").checked = true;
    		if(hintVec[i]==0){
				document.getElementById("eChnlCommand_div1").style.display="block";
			}
			if(hintVec[i]>0){
				document.getElementById("e_channel_exp").style.display="block";
			}
    	}
    } 
}

function getHintCheckBoxVal(){
	var hintVal = ""; 
   	for(var pos = 0; pos < 9; ++pos){
    	if (document.getElementById("hint" + pos + "_input").checked) {
      		if (hintVal != ""){
            	hintVal += ";";
          	}
      		hintVal += document.getElementById("hint" + pos + "_input").value;
        }
    }
    return hintVal;
}

function getDefualtExearea(){
	var org = g_GetUserInfo().ORG_ID.substr(0,2);
	var cases = {
	  	10:999,
		11:270,
		17:710,
		13:711,
		26:712,
		25:713,
		12:714,
		19:715,
		20:716,
		14:717,
		15:718,
		16:719,
		24:722,
		23:724,
		18:728,
		27:728,
		28:728
	};
	if (cases[org]) {
  		return (cases[org]);
	}
}

function addDate(type,NumDay,dtDate) 
{ 
	var date = new Date(StringToDate(dtDate)); 
	type = parseInt(type); //类型 
	var lIntval = parseInt(NumDay);//间隔 
	switch(type) 
	{ 
		case 6 ://年 
		date.setYear(date.getFullYear() + lIntval) 
		break; 
		case 7 ://季度 
		date.setMonth(date.getMonth() + (lIntval * 3) ) 
		break; 
		case 5 ://月 
		date.setMonth(date.getMonth() + lIntval) 
		break; 
		case 4 ://天 
		date.setDate(date.getDate() + lIntval) 
		break 
		case 3 ://时 
		date.setHours(date.getHours() + lIntval) 
		break 
		case 2 ://分 
		date.setMinutes(date.getMinutes() + lIntval) 
		break 
		case 1 ://秒 
		date.setSeconds(date.getSeconds() + lIntval) 
		break; 
		default: 
	} 
	var month= date.getMonth()+1;
	var second=date.getDate();
	
	return date.getFullYear() + '-' + month + '-' +second +dtDate.substr(10); 
} 
	
StringToDate=function(DateStr){
	if(typeof DateStr=="undefined")return new Date();
	if(typeof DateStr=="date")return DateStr;
	var converted = Date.parse(DateStr);
	var myDate = new Date(converted);
	if(isNaN(myDate)){
	DateStr=DateStr.replace(/:/g,"-");
	DateStr=DateStr.replace(" ","-");
	DateStr=DateStr.replace(".","-");
	var arys= DateStr.split('-');
	switch(arys.length){
	case 7 : myDate = new Date(arys[0],--arys[1],arys[2],arys[3],arys[4],arys[5],arys[6]);break;
	case 6 : myDate = new Date(arys[0],--arys[1],arys[2],arys[3],arys[4],arys[5]);break;
	default: myDate = new Date(arys[0],--arys[1],arys[2]);break;};};return myDate;
}

function saveSaleOrderInfo(){
	 var orderName=_saleOrderForm.getValue("ORDER_NAME");
	 if(""==orderName){return  alert("请填写营销活动工单名称！");}
	
	 if ("O" != _saleOrderForm.getSts() || _saleOrderForm.getSts()=="U")
	 {
        var list = new Array();
	    list.push(_saleOrderForm);
	    var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.SaleOrderAction?action=saveSaleOrderInfo';
	    var recode = saveRowSet(strUrl, list);
	    var orderId = recode.getValueByName("orderId");
	    if(orderId == null || orderId == '' || orderId == 'undefined'){
	    	return alert("保存操作失败！");
	    }
  	    _saleOrderForm.refresh("&orderId="+orderId);
  	    //showName();
	 }
}

function saveSaleMain()
{
	var orderId = _saleOrderForm.getValue("ORDER_ID");
	var phone=_saleMainForm.getValue("PROJECTER_TELNUM");
	_saleMainForm.setValue("ORDER_ID",orderId);
	if (null == orderId || "" == orderId){
		return alert("请先保存工单信息！");
	}
	if (null == _saleMainForm.getValue("SALE_MAIN_TYPE") 
			|| "" == _saleMainForm.getValue("SALE_MAIN_TYPE")){
		return alert("请先填写活动类型！");
	}
	if (null == _saleMainForm.getValue("EXERCISE_TYPE") 
			|| "" == _saleMainForm.getValue("EXERCISE_TYPE")){
		return alert("请先填写活动分类！");
	}
	if (null == _saleMainForm.getValue("GRADE_DEFAULT_RELATION") 
			|| "" == _saleMainForm.getValue("GRADE_DEFAULT_RELATION")){
		return alert("请先填写档次默认关系！");
	}
    if ("" == _saleMainForm.getValue("SALE_MAIN_NAME"))
   	{
        return alert("请输入活动案名称！");
   	}
    if ("" == _saleMainForm.getValue("BEGIN_TIME"))
    {
        return alert("请输入活动案开始时间！");
    }
    if ("" == _saleMainForm.getValue("END_TIME"))
    {
        return alert("请输入活动案结束时间！");
    }
    if (1 == g_CompareDate(_saleMainForm.getValue("BEGIN_TIME"),_saleMainForm.getValue("END_TIME")))
    {
        return alert("活动案结束时间不能小于开始时间！");
    }
    if ("true" == _saleMainForm.getValue("ISACTIVE_SALE") &&　"" == _saleMainForm.getValue("ACTIVE_SALE_SITE"))
    {
        return alert("请输入主动营销点！");
    }
    if ("" == _saleMainForm.getValue("PROJECTER"))
    {
        return alert("请输入策划人！");
    }
        if ("" == _saleMainForm.getValue("PROJECTER_TELNUM"))
    {
        return alert("请输入策划人联系电话！");
    }
    if("" !=phone && null!= phone){
    	if(!g_IsMobileNumber(phone)){
    		alert("手机号码不合法，请重新输入！");
    		_saleMainForm.setFocus("PROJECTER_TELNUM");
    		return 0;
    	}
    }
    
    if ("" == _saleMainForm.getValue("MARKTYPE"))
    {
        return alert("请输入细分市场！");
    }
    
    if (_saleMainForm.getValue("EXEAREA") == '000'){
    	if(!confirm("您确定执行范围选择全网！")){
    		return;
    	}
    } else if(_saleMainForm.getValue("EXEAREA") != getDefualtExearea()) {
    	if(!confirm("您选择的执行范围与您所在地市有差异,您确定要保存！")){
    		return;
    	}
    }
    
    var eChnlBearChBox = getHintCheckBoxVal();
	_saleMainForm.setValue("E_CHANNEL_BEAR",eChnlBearChBox);
    
    //2015-7-1 渠道信息为必填项
    if (_channelListTab.getTotalRowCount() == 0) {
    	return alert("请填写批次渠道信息！");
    } else {
    	for (var k=0; k<_channelListTab.getTotalRowCount(); ++k) {
	    	if (_channelListTab.getValue(k,"REGION") == ""
	    	    || _channelListTab.getValue(k,"CHANNEL_CODE") == ""
	    	    || _channelListTab.getValue(k,"OPERATION") == "") {
	    		return alert("渠道信息不能为空！");
	    	}
    	}
    }
    if (_cgroupListTab.getTotalRowCount() >= 1) {
    	for (var j=0; j<_cgroupListTab.getTotalRowCount(); ++j) {
	    	if (_cgroupListTab.getValue(j,"CGROUP_FLAG") == ""
	    	    || _cgroupListTab.getValue(j,"CGROUP_BEGIN_TIME") == ""
	    	    || _cgroupListTab.getValue(j,"CGROUP_END_TIME") == "") {
	    		return alert("目标客户群信息不能有为空的！");
	    	}
    	}
    }
    
    if ("O" != _saleMainForm.getSts())
    {	
    	var list = new Array();
	    list.push(_saleMainForm);
	    var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.SaleMainAction?action=saveSaleMain';
	    var recode = saveRowSet(strUrl, list);
	    var actId = recode.getValueByName("MAINID");
	    if (actId == null || actId == 'null' || actId == "") {
	    	actId = _saleMainForm.getValue("MAINID");
	    }
	    _saleMainForm.setValue("MAINID",actId);
	    saveChannel(actId,'n');
	    saveCgroup(actId,'n');
	    saveEChannelNcodeCommand(actId,'n');
		//doUpload();
	    //var mainId = recode.getValueByName("MAINID");
	    //_saleMainForm.setValue("MAINID",mainId);
	    //_saleMainTab.refresh("&orderId="+orderId);
	    var rFlag = recode.getValueByName("FLAG");
	    if ("Y" == rFlag)
	    {
	    	if ("<%=request.getParameter("orderId")%>" == "") {
		        window.parent.resetTabitem(orderId);
	    	} else {
		        window.parent.refreshTabItem("activityTab","activity_2","第二步：档次信息：","new_detail.jsp?orderId=" + orderId + "&editable=true");
		        window.parent.refreshTabItem("activityTab","activity_1","第一步：营销活动主要信息：","new_main.jsp?orderId=" + orderId + "&editable=true");
	    	}
	    } else {
	    	_saleMainForm.setStsToNew();
	    }
	    if(eChnlBearChBox!=null&&eChnlBearChBox!=""){	
			if(eChnlBearChBox.indexOf('1')>=0||eChnlBearChBox.indexOf('2')>=0||eChnlBearChBox.indexOf('3')>=0||eChnlBearChBox.indexOf('4')>=0||
			eChnlBearChBox.indexOf('6')>=0||eChnlBearChBox.indexOf('7')>=7||eChnlBearChBox.indexOf('8')>=0){
				if(_include_fromAttachFileFormRowSet().count()==0){
					return alert('请注意，该活动批次为电子渠道承载,需要在“模板下载(电子渠道承载)处”下载模板并填写后上传附件,请注意是否操作!!');
				}
			}
		}
        return rFlag;
    } else {
    	saveChannel(_saleMainForm.getValue("MAINID"),'y');
    	saveCgroup(_saleMainForm.getValue("MAINID"),'n');
    	saveEChannelNcodeCommand(_saleMainForm.getValue("MAINID"),'n');
    	var e_chlbear = getHintCheckBoxVal();
	
		if(e_chlbear!=null&&e_chlbear!=""){	
			if(e_chlbear.indexOf('1')>=0||e_chlbear.indexOf('2')>=0||e_chlbear.indexOf('3')>=0||e_chlbear.indexOf('4')>=0||
			e_chlbear.indexOf('6')>=0||e_chlbear.indexOf('7')>=7||e_chlbear.indexOf('8')>=0){
				if(_include_fromAttachFileFormRowSet().count()==0){
					return alert('请注意，该活动批次为电子渠道承载,需要在“模板下载(电子渠道承载)处”下载模板并填写后上传附件,请注意是否操作!!');
				}
			}
		}
    	return "Y";
    }
   
}

function showSaleMainInfo(oldIndex,newIndex){
	if(-1 != oldIndex) {
       _saleMainTab.setRowBgColor(oldIndex,"");
    }
	var mainId = _saleMainTab.getValue(newIndex,"MAINID");
    _saleMainTab.setRowBgColor(newIndex,"yellow");
    _saleMainForm.refresh("&id="+mainId);
    var eChnlBear = _saleMainForm.getValue("E_CHANNEL_BEAR");
    if(eChnlBear==null){
    	setCheckBox(null);
    }else{
    	setCheckBox(eChnlBear.toString());
    }
    _channelListTab.refresh("&relaId="+mainId+"&relaType=act");
    _cgroupListTab.refresh("&relaId="+mainId+"&relaType=act");
    _EChannelNcodeCommandListTab.refresh("&relaId="+mainId+"&infoType=act");
    document.getElementById("TableRowSet_cgroupListTable").onclick= calendarDlg;
    
    if ("true" == _saleMainForm.getValue("ISGROUP")){
    	document.getElementById("jttype").style.display="block";
    }
    if ("true" == _saleMainForm.getValue("ISACTIVE_SALE")){
    	document.getElementById("zdyxdTR").style.display="block";
    } else {
    	document.getElementById("zdyxdTR").style.display="none";
    }
    
    
    include_reflashAttachTable(mainId);
}

function newSaleMain()
{
	_saleMainForm.newRow();
	_saleMainForm.setValue("PRINCIPAL",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
	_saleMainForm.setValue("PROMOTE_DEPART",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
	_saleMainForm.setValue("ISACTIVE_SALE","false");
	_saleMainForm.setValue("EXEAREA",getDefualtExearea());
	_saleMainForm.setValue("ISGROUP","false");
	_channelListTab.clear();
	_cgroupListTab.clear();
	_EChannelNcodeCommandListTab.clear();
	setCheckBox("");
}

function delSaleMain()
{
    var ss = new Array();
    ss = _saleMainTab.getSelectedRows();
    if (ss.length < 1) {
        alert("请勾选要删除的数据！");
        return;
    }
    for ( var i = ss.length; i > 0; i--) {
        _saleMainTab.deleteRow(ss[i - 1]);
    }
    savaRowSet(_saleMainTab);
    var orderId = _saleOrderForm.getValue("ORDER_ID");
    window.parent.resetTabitem(orderId);
}

function alertTagsRefreshMainShow(mainId){
    window.parent.resetTabitemsMainShow(mainId);
}

function savaRowSet(rowSet){
    var list = new Array();
    list.push(rowSet);
    var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.SaleMainAction?action=delSaleMain';
    saveRowSet(strUrl, list);
}
function showDetailList()
{
    //var curRow = _tableSaleDetailGroupListTableRowSet().getRow();
    var mainId = _saleMainForm.getValue("MAINID");
    //var saleFlag = _tableSaleDetailGroupListTableRowSet().getValue(curRow, "SALE_FLAG");
    doShowDetailList(mainId, "");
}

function doShowDetailList(mainId, saleFlag)
{
    _tableSaleDetailListTableRowSet().refresh("&mainId=" + mainId +"&saleFlag=" + saleFlag);
}

function doCreateDetail()
{
	if (_saleMainForm.getValue("SALE_MAIN_NAME") != null && _saleMainForm.getValue("SALE_MAIN_NAME") != ''){
		if ('Y' != saveSaleMain()){
			return;
		}
	}
	var e_chlbear = getHintCheckBoxVal();
	
	if(e_chlbear!=null&&e_chlbear!=""){	
		if(e_chlbear.indexOf('1')>=0||e_chlbear.indexOf('2')>=0||e_chlbear.indexOf('3')>=0||e_chlbear.indexOf('4')>=0||
		e_chlbear.indexOf('6')>=0||e_chlbear.indexOf('7')>=0||e_chlbear.indexOf('8')>=0){
			if(_include_fromAttachFileFormRowSet().count()==0){
				return alert('请上传电渠营销活动发布附件');
			}
		}
	}
	window.parent.isNew = true;
	window.parent.setTabItem("activityTab","activity_2");
	window.parent.isNew = false;
}

function onSaleMainFormValChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText){
	if (pFieldName == 'ISACTIVE_SALE') {
		if ("true" == pOldText) {
			document.getElementById("zdyxdTR").style.display="block";
		} else {
			document.getElementById("zdyxdTR").style.display="none";
		}
	}
	if (pFieldName == 'ISGROUP') {
		if ("true" == pOldText) {
			_saleMainForm.setValue("ISACTIVE_SALE","false");
			_saleMainForm.setValue("SALE_OBJECT","政企客户");
			_saleMainForm.setColEditSts("ISACTIVE_SALE",false);
			document.getElementById("jttype").style.display="block";
		} else {
			_saleMainForm.setColEditSts("ISACTIVE_SALE",true);
		    _saleMainForm.setValue("GROUP_PROP","");
	        _saleMainForm.setValue("SALE_OBJECT","");
	        _saleMainForm.setValue("ACTIVITY_TYPE","");
			document.getElementById("jttype").style.display="none";
		}
	}
	if (pFieldName=="BEGIN_TIME"){
			_saleMainForm.setValue("END_TIME",addDate(5,1,_saleMainForm.getValue("BEGIN_TIME")));
	}
	
	if (pFieldName=="SALE_MAIN_TYPE"){
		//_saleMainForm.removeListBoxOption("EXERCISE_TYPE","rtChargePrepay");
		if (_saleMainForm.getValue("SALE_MAIN_TYPE") == "rtGroup") {
			_saleMainForm.clearListBox("EXERCISE_TYPE");
			_saleMainForm.addListBoxElement("EXERCISE_TYPE","rtChargePrepay","预存赠送");
			_saleMainForm.addListBoxElement("EXERCISE_TYPE","rtScoreReward","积分回馈");
		} else {
			_saleMainForm.refreshListBox("EXERCISE_TYPE");
			_saleMainForm.removeListBoxOption("EXERCISE_TYPE","rtOther");
    	    _saleMainForm.removeListBoxOption("EXERCISE_TYPE","rtPrepayTerm");
    	    _saleMainForm.removeListBoxOption("EXERCISE_TYPE","rtPresentTerm");
	    	_saleMainForm.removeListBoxOption("EXERCISE_TYPE","rtHeartMobile");
	    	_saleMainForm.removeListBoxOption("EXERCISE_TYPE","rtRealInvoice");
			//_saleMainForm.refreshDynamicListBox("EXERCISE_TYPE");
		}
	}
}

function g_IsMobileNumber(s)
{
if(s==null || s=='')return true;
if( s.length!=11 || ( s.substring(0,2)!='13' && s.substring(0,2)!='15' && s.substring(0,3)!='147' && s.substring(0,3)!='188'&&s.substring(0,3)!='187'))return false;
return true
}
</script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script type="text/javascript">
function zdyxdMultiplySelected(){
	var url = "<%=request.getContextPath()%>/sale/common/modaldialog/SaleZDYXDMultiplySelected.jsp";
	var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
	var iniVal = _saleMainForm.getValue("ACTIVE_SALE_SITE");
	_saleMainForm.setValue("ACTIVE_SALE_SITE",onItemMultiplySelected(url, iniVal, style));
}

function marketMultiplySelected(){
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/SaleMarketMultiplySelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = _saleMainForm.getValue("MARKTYPE");
    _saleMainForm.setValue("MARKTYPE",onItemMultiplySelected(url, iniVal, style));
}

function groupTypeSelected(){
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/groupTypeSelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = _saleMainForm.getValue("GROUP_PROP");
    _saleMainForm.setValue("GROUP_PROP",onItemMultiplySelected(url, iniVal, style));
}

function activityTypeSelected(){
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/activityTypeSelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = _saleMainForm.getValue("ACTIVITY_TYPE");
    _saleMainForm.setValue("ACTIVITY_TYPE",onItemMultiplySelected(url, iniVal, style));
}

// 渠道
function addChannel() {
	_channelListTab.newRow(false);
	var curRow = _channelListTab.getCurRowIndex();
	_channelListTab.setValue(curRow,"REL_TYPE", 'act');
	_channelListTab.setValue(curRow,"CHANNEL_CODE", 'ALL');
	_channelListTab.setValue(curRow,"REGION", getDefualtExearea());
}

function delChannel() {
	var delChannelList = new Array();
	delChannelList = _channelListTab.getSelectedRows();
	var delChannelRc = delChannelList.length;
    if (delChannelRc < 1) {
        return alert("请勾选要删除的记录！");
    }
    var relId = _channelListTab.getValue(0,"REL_ID");
    while (delChannelRc > 0) {
	    delChannelRc--;
	    _channelListTab.deleteRow(delChannelList[delChannelRc]);
    }
    if (relId == null || relId==""){
    	return;
    }
    saveChannel("", "y");
}

function saveChannel(batchId, alertFlag) {
	if (batchId != null && batchId != "") {
		for (var i=0; i< _channelListTab.getTotalRowCount(); ++i) {
			_channelListTab.setValue(i, "REL_ID", batchId);
		}
	} else {
		batchId = _saleMainForm.getValue("MAINID");
	}
	var list = new Array();
	list.push(_channelListTab);
  	var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.ChannelInfoAction?action=save';
	var recode = saveRowSet(strUrl, list);
  	var rFlag = recode.getValueByName("FLAG");
  	if (alertFlag == 'y' && rFlag == 'Y') {
  		alert("操作成功！");
  	} else if (alertFlag == 'y' && rFlag == 'N') {
  		alert("操作失败！");
  	}
	_channelListTab.refresh("&relaId="+batchId+"&relaType=act");
}

// 目标客户群
function addCgroup() {
	var url = "<%=request.getContextPath()%>/sale/activity/include/_custGroup.jsp?orgId="+g_GetUserInfo().ORG_ID.substr(0,2);
    var style = "dialogWidth:600px;dialogHeight:600";
    var retMsg = window.showModalDialog(url, '', style);
    if(retMsg==null || retMsg==''){
    	return;
    } else {
		_cgroupListTab.newRow(false);
		var curRow = _cgroupListTab.getCurRowIndex();
		_cgroupListTab.setValue(curRow,"RELAT_TYPE", 'act');
		_cgroupListTab.setValue(curRow,"ORDER_ID", _saleOrderForm.getValue("ORDER_ID"));
    	_cgroupListTab.setValue(curRow,"CGROUP_ID",retMsg.split(",")[0]);
    	_cgroupListTab.setValue(curRow,"CGROUP_TAB",retMsg.split(",")[1]);
    	_cgroupListTab.setValue(curRow,"CGROUP_NAME",retMsg.split(",")[2]);
    	_cgroupListTab.setValue(curRow,"CGROUP_REGION",retMsg.split(",")[3]);
    	_cgroupListTab.setValue(curRow,"CGROUP_USERNUM",retMsg.split(",")[4]);
    }
}

function delCgroup() {
	var delCgroupList = new Array();
	delCgroupList = _cgroupListTab.getSelectedRows();
	var delCgroupRc = delCgroupList.length;
    if (delCgroupRc < 1) {
        return alert("请勾选要删除的记录！");
    }
    var relId = _channelListTab.getValue(0,"REL_ID");
    while (delCgroupRc > 0) {
	    delCgroupRc--;
	    _cgroupListTab.deleteRow(delCgroupList[delCgroupRc]);
    }
    if (relId == null || relId==""){
    	return;
    }
    saveCgroup("", "y");
}

function saveCgroup(batchId, alertFlag) {
	if (batchId != null && batchId != "") {
		for (var i=0; i< _cgroupListTab.getTotalRowCount(); ++i) {
			_cgroupListTab.setValue(i, "RELAT_ID", batchId);
		}
	} else {
		batchId = _saleMainForm.getValue("MAINID");
	}
	var list = new Array();
	list.push(_cgroupListTab);
  	var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.CustGroupAction?action=save';
	var recode = saveRowSet(strUrl, list);
  	var rFlag = recode.getValueByName("FLAG");
  	if (alertFlag == 'y' && rFlag == 'Y') {
  		alert("操作成功！");
  	} else if (alertFlag == 'y' && rFlag == 'N') {
  		alert("操作失败！");
  	}
	_cgroupListTab.refresh("&relaId="+batchId+"&relaType=act");
	document.getElementById("TableRowSet_cgroupListTable").onclick= calendarDlg;
}

//短厅指令与NCODE列表
function addEChannelNcodeCommand() {
	_EChannelNcodeCommandListTab.newRow(false);
	var curRow = _EChannelNcodeCommandListTab.getCurRowIndex();
	_EChannelNcodeCommandListTab.setValue(curRow,"INFO_TYPE", 'act');
}

function delEChannelNcodeCommand() {
	var delEChannelNcodeCommandList = new Array();
	delEChannelNcodeCommandList = _EChannelNcodeCommandListTab.getSelectedRows();
	var delEChannelNcodeCommandRc = delEChannelNcodeCommandList.length;
    if (delEChannelNcodeCommandRc < 1) {
        return alert("请勾选要删除的记录！");
    }
    var relId = _EChannelNcodeCommandListTab.getValue(0,"REL_ID");
    while (delEChannelNcodeCommandRc > 0) {
	    delEChannelNcodeCommandRc--;
	    _EChannelNcodeCommandListTab.deleteRow(delEChannelNcodeCommandList[delEChannelNcodeCommandRc]);
    }
    if (relId == null || relId==""){
    	return;
    }
    saveEChannelNcodeCommand("", "y");
}

function saveEChannelNcodeCommand(levId, alertFlag) {
	if(_EChannelNcodeCommandListTab.count()==0&& levId != "") return;
	if (levId != null && levId != "") {
		for (var i=0; i< _EChannelNcodeCommandListTab.getTotalRowCount(); ++i) {
			_EChannelNcodeCommandListTab.setValue(i, "REL_ID", levId);
		}
	} else {
		levId = _saleMainForm.getValue("MAINID");
	}
	var list = new Array();

	list.push(_EChannelNcodeCommandListTab);
  	var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.EchannelNcodeCommandAction?action=save';
	var recode = saveRowSet(strUrl, list);
  	var rFlag = recode.getValueByName("FLAG");
  	if (alertFlag == 'y' && rFlag == 'Y') {
  		alert("操作成功！");
  	} else if (alertFlag == 'y' && rFlag == 'N') {
  		alert("操作失败！");
  	}
	_EChannelNcodeCommandListTab.refresh("&relaId="+levId+"&infoType=act");
}

function saveEChannelNcodeCommandb() {
	var list = new Array();
	list.push(_EChannelNcodeCommandListTab);
  	var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.EchannelNcodeCommandAction?action=save';
	var recode = saveRowSet(strUrl, list);
  	var rFlag = recode.getValueByName("FLAG");
  	if ( rFlag == 'Y') {
  		alert("操作成功！");
  	} else if (rFlag == 'N') {
  		alert("操作失败！");
  	}
}

function calendarDlg() {
	var curRow = _cgroupListTab.getRow();
	var curCol = _cgroupListTab.getCol();
	if(_cgroupListTab.getRowEditSts(curRow) == true && (curCol==4 || curCol==5)){
	     var url = "<%=request.getContextPath()%>/jsv2/DBCalendarDlg_zh_CN.htm";
	     var ret = window.showModalDialog(url, obj, "scroll:yes;resizable:yes;help:no;status:yes;dialogHeight:220px;dialogWidth:200px;unadorned:yes");
	     if (ret != null && ret != "" && ret != "none") {
			if (curCol == 4) {
				if (_cgroupListTab.getValue(curRow,"CGROUP_END_TIME") !="" &&
						-1 != g_CompareDate(ret, _cgroupListTab.getValue(curRow,"CGROUP_END_TIME"))) {
					return alert("开始时间必须小于结束时间")
				}
				_cgroupListTab.setValue(curRow, "CGROUP_BEGIN_TIME", ret);
			} else if (curCol == 5) {
				if (_cgroupListTab.getValue(curRow,"CGROUP_BEGIN_TIME") !="" &&
						-1 != g_CompareDate(_cgroupListTab.getValue(curRow,"CGROUP_BEGIN_TIME"),ret)) {
					return alert("结束时间必须大于开始时间")
				}
				_cgroupListTab.setValue(curRow, "CGROUP_END_TIME", ret);
			}
	     }
	     _cgroupListTab.setFocus(0,0);
	}
}
</script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function setButtonDisabled(){
	document.getElementById('bt_saveSaleOrder').style.visibility='hidden';
	document.getElementById('bt_newSaleMain').style.visibility='hidden';
	document.getElementById('bt_newSaleMain1').style.visibility='hidden';
	document.getElementById('bt_delSaleMain').style.visibility='hidden';
	document.getElementById('bt_saveSaleMain').style.visibility='hidden';
	document.getElementById('bt_addChannl').style.visibility='hidden';
	document.getElementById('bt_delChannl').style.visibility='hidden';
	document.getElementById('bt_addCgroup').style.visibility='hidden';
	document.getElementById('bt_delCgroup').style.visibility='hidden';
	document.getElementById('bt_doCreateDetail').style.visibility='hidden';
	document.getElementById('bt_saveSaleEit').style.visibility='hidden';
	document.getElementById('bt_telPayFee').style.visibility='hidden';
	document.getElementById('bt_telPartsFee').style.visibility='hidden';
	document.getElementById('bt_saveSaleHbHb').style.visibility='hidden';
	document.getElementById('bt_addEChannelNcodeCommand').style.visibility='hidden';
	document.getElementById('bt_delUEChannelNcodeCommand').style.visibility='hidden';
	document.getElementById('deleteAttachFile').style.visibility='hidden';
	document.getElementById('up_file_area').style.display="none";
}
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>
