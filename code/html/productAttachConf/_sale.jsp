<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<%String visible="false"; %>

<html>
<head>
<title>协助营销活动配置</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language='javascript' src='<%=request.getContextPath()%>/sale/common/js/computeTools.js' ></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/activity/js/computeCost4saleDetail.js"></script>
</head>
<body onload="initPage()">
<%@include file="/sale/activity/include/_mainShow.jsp"%>
    <ai:dbform formid="saleDetailForm"  initial="false"
            setname="com.asiainfo.sale.activity.web.SETSaleDetail"
            conditionname="condition" parametersname="parameters"
            onvalchange="onSaleTypeChange" editable="true"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleDetailSV"
            implservice_querymethod="getSaleDetailById(String id)">
<ai:contractframe id="saleDetailFrame" contenttype="table" title="档次主要信息" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr>
                <td class="td_font">编码：</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="SALE_ACTIVE_CODE" width="180" editable="false"/>
                    <ai:dbformfield formid="saleDetailForm" fieldname="DETAIL_ID" visible="false"/>
                    <ai:dbformfield formid="saleDetailForm" fieldname="SALE_ID" visible="false"/>
                    <ai:dbformfield formid="saleDetailForm" fieldname="WEAPON_ID" visible="false"/></td>
                <td class="td_font">活动业务目标类型：</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="RESERVE2" width="150"/></td>
            </tr>
            <tr>
                <td class="td_font">档次名称：</td>
                <td colspan="1"><ai:dbformfield formid="saleDetailForm" fieldname="SALE_ACTIVE_NAME" width="180"/><span class="font_red">*</span></td>
                <td class="td_font">活动类型：</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="SALE_FLAG" width="150"/></td>
            </tr>
            <%--<tr id="jthdxs">
             <td class="td_font">活动形式：</td>
                <td colspan="1"><ai:dbformfield formid="saleDetailForm" fieldname="RESERVE1" width="150" visible="false"/></td>
            </tr> --%>
            <tr>
                <td class="td_font">档次说明：</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="LEVEL_DESC" height="36" width="450"/></td>
            </tr>
            <tr>
                <td class="td_font">细分市场：</td>
                <td ><ai:dbformfield formid="saleDetailForm" fieldname="MARKET"  width="150"/><%--<img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="marketSimpleSelected();" align="absmiddle" style="cursor:hand;"/>--%><span class="font_red">*</span></td>
                <td class="td_font">是否单位担保：</td>
                <td colspan="1"><ai:dbformfield formid="saleDetailForm" fieldname="RESERVE3" width="150"/></td>
            </tr>
            <tr>
            	<td class="td_font">促销积分有效期截止时间：</td>
                <td ><ai:dbformfield formid="saleDetailForm" fieldname="EXT6"  width="150"/><span class="font_red">(不跨年)赠送积分类活动必填</span>
            </tr>
            <tr>
                <td class="td_font">指定办理网点ID：</td>
                <td ><ai:dbformfield formid="saleDetailForm" fieldname="HANDLE_WEBSITE_ID"  width="450"/>(用";"分开a;b;c;d)</td>
            </tr>
            <tr>
                <td class="td_font">指定办理工号ID：</td>
                <td ><ai:dbformfield formid="saleDetailForm" fieldname="HANDLE_EMPLOYEE_ID"  width="450"/>(用";"分开a;b;c;d)</td>
            </tr>
            <%-- <tr>
        		<td class="td_font">是否需要短信提醒：</td>
        		<td colspan=3 ><ai:dbformfield formid="saleDetailForm" fieldname="IS_SEND_SMS" width="10" visible="false"/>
        			<input type="checkbox" id="selSendType0" value="0" onclick="checkboxSts(0);" />不需要短信提醒&nbsp;
        			<input type="checkbox" id="selSendType1" value="1" onclick="checkboxSts(1);" />业务受理短信</td>
        	</tr> --%>
            <tr id="channel_tr" style="display: none">
                <td class="td_font">办理渠道：</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="OPEN_CHANNEL"  width="450"/></td>
            </tr>
            <tr>
                <td align="left" colspan="4"><b>个性化业务提示信息：</b></td>
            </tr>
            <tr>
	        	<td class="td_font">提示类型：</td>
	        	<td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="EXT1" width="10" visible="false"/>
	        		<input type="checkbox" id="hint0_input" value="0" onclick="checkboxSts(0);" />前台界面信息提示&nbsp;
	        		<input type="checkbox" id="hint1_input" value="1" onclick="checkboxSts(1);" />事后短信提示&nbsp;
	               	<input type="checkbox" id="hint2_input" value="2" onclick="checkboxSts(2);" />发票打印信息提示&nbsp;
	               	<input type="checkbox" id="hint3_input" value="3" onclick="checkboxSts(3);" />免填单打印信息提示</td>
        	</tr>
        	<tr id="hint0_tr" style="display: none;">
        		<td class="td_font">前台界面信息提示：</td>
        		<td colspan="5"><ai:dbformfield formid="saleDetailForm" fieldname="EXT2" height="60" width="70%"/><span class="font_red">*</span></td>
        	</tr>
        	<tr id="hint1_tr" style="display: none;">
        		<td class="td_font">事后短信提示(最多300字)：</td>
        		<td colspan="5"><ai:dbformfield formid="saleDetailForm" fieldname="EXT3" height="50" width="70%" /><span class="font_red">*</span></td>
        	</tr>
        	<tr id="hint2_tr" style="display: none;">
        		<td class="td_font">发票打印信息提示(最多40字)：</td>
        		<td colspan="5"><ai:dbformfield formid="saleDetailForm" fieldname="EXT4" height="60" width="70%"/><span class="font_red">*</span></td>
        	</tr>
        	<tr id="hint3_tr" style="display: none;">
        		<td class="td_font">免填单打印信息提示：</td>
        		<td colspan="5"><ai:dbformfield formid="saleDetailForm" fieldname="EXT5" height="50" width="70%" /><span class="font_red">*</span></td>
        	</tr>
            <tr>
                <td id="SALETYPE_OTHERSALE_td_1" class="td_font">营销类型：</td>
                <td id="SALETYPE_OTHERSALE_td_2" colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="SALETYPE_OTHERSALE" width="450"/></td>
            </tr>
            <tr>
                <td id="SALETYPE_DES_OTHERSALE_td_1" class="td_font">营销类型描述：</td>
                <td id="SALETYPE_DES_OTHERSALE_td_2" colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="SALETYPE_DES_OTHERSALE" width="450"/></td>
            </tr>
            <tr id="dis1" >
                <td align="left" colspan="4"><b>客户特征及参与资格描述：</b></td>
            </tr>
            <tr id="dis2" >
                <td class="td_font">品牌及资费：</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="BRAND_DESC" width="450"/></td>
            </tr>
            <tr id="dis3" >
                <td class="td_font">其他条件：</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="OTHER_USERINFO" width="450"/></td>
            </tr>
            <tr id="dis4" >
                <td align="left" colspan="4"><b>其他信息：</b></td>
            </tr>
            <tr id="dis5" >
                <td class="td_font">互斥要求：</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="EXCLUDE_DEMAND" height="36" width="450"/></td>
            </tr>
            <tr id="dis6" >
                <td class="td_font">渠道酬金政策：</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="CHANNEL_PAY_POLICY" height="36" width="450"/></td>
            </tr>
            <%--<tr>
                <td class="td_font">宣传语：</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="PUBLICITY_WORD" height="66" width="450"/></td>
            </tr>
            --%><tr>
                <td align="left" colspan="4"><b>用户规模：</b></td>
            </tr>
            <tr>
                <td class="td_font">允许最大用户数：</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="MAX_PERSON" width="150"/>(户)<span class="font_red">*</span></td>
                <td class="td_font">预计用户规模：</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="PRE_PERSON" width="150"/>(户)<span class="font_red">*</span></td>
            </tr>
        </table>
</ai:contractframe>

<ai:contractframe id="saleDetailframe2" contenttype="table" title="成本收益" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem><ai:button text="选择武器" id="bt_weaponSelect1" onclick="weaponSelect()" />&nbsp;&nbsp;<ai:button id="bt_refreshCompute4weapon" text="刷新" onclick="doWork('refreshCompute4weapon()')"/></ai:contractitem>
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td id="BACK_PROPORTION_td_1" class="td_font">客户回报率：</td>
	           	<td id="BACK_PROPORTION_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="BACK_PROPORTION" width="100" editable="false"/>%</td>
	           	<td id="PRE_STORE_TO_PRESENT_td_1" class="td_font">预存与赠送比例：</td>
	           	<td id="PRE_STORE_TO_PRESENT_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="PRE_STORE_TO_PRESENT" width="100" editable="false"/>%</td>
			</tr>
            <tr>
                <td id="PRE_INCOME_td_1" class="td_font">吸纳预存款：</td>
                <td id="PRE_INCOME_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="PRE_INCOME" width="150" editable="false"/>(元)</td>
                <td id="FEE_DISCOUNT_td_1" class="td_font">预计话费折扣：</td>
                <td id="FEE_DISCOUNT_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="FEE_DISCOUNT" width="150" editable="false"/>(元)</td>
            </tr>
            <tr>
                <td id="PRE_INCOME2_td_1" class="td_font">预计收入：</td>
                <td id="PRE_INCOME2_td_2" colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="PRE_INCOME2" width="150" editable="false"/>(元)</td>
            </tr>
            <tr>
                <td id="BUSINESS_DISCOUNT_td_1" class="td_font">预计业务折扣：</td>
                <td id="BUSINESS_DISCOUNT_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="BUSINESS_DISCOUNT" width="100" editable="false"/>(元)</td>
                <td id="MOBILE_COST_td_1" class="td_font">终端成本：</td>
                <td id="MOBILE_COST_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="MOBILE_COST" width="100" editable="false"/>(元)</td>
            </tr>
            <tr>
                <td id="ELECPAY_COST_td_1" class="td_font">电子购物券成本：</td>
                <td id="ELECPAY_COST_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="ELECPAY_COST" width="100" editable="false"/>(元)</td>
                <td id="MOBILEPAY_COST_td_1" class="td_font">手机红包成本：</td>
                <td id="MOBILEPAY_COST_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="MOBILEPAY_COST" width="100" editable="false"/>(元)</td>
            </tr>
            <tr>
                <td id="ELECGOODS_COST_td_1" class="td_font">电子提货券成本：</td>
                <td id="ELECGOODS_COST_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="ELECGOODS_COST" width="100" editable="false"/>(元)</td>
                <td id="GOODS_COST_td_1" class="td_font">货品成本：</td>
                <td id="GOODS_COST_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="GOODS_COST" width="100" editable="false"/>(元)</td>
            </tr>
			<tr>
	           	<td id="CHANNEL_PAY_td_1" class="td_font">渠道酬金：</td>
	           	<td id="CHANNEL_PAY_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="CHANNEL_PAY" width="100"/>(元)</td>
	           	<td id="ESTIMATE_AD_FEE_td_1" class="td_font">广告宣传费：</td>
	           	<td id="ESTIMATE_AD_FEE_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="ESTIMATE_AD_FEE" width="100"/>(元)</td>
			</tr>
			<tr>
                <td id="ESTIMATE_OTHER_FEE_td_1" class="td_font">其他：</td>
                <td id="ESTIMATE_OTHER_FEE_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="ESTIMATE_OTHER_FEE" width="100"/>(元)
                <ai:dbformfield formid="saleDetailForm" fieldname="COST_TOTAL" width="100" visible="false"/></td>
			</tr>
		</table>
</ai:contractframe>
</ai:dbform>
<%@include file="/sale/activity/include/_weaponInfo.jsp"%>
<%@include file="/sale/common/include/_attach.jsp"%>
</body>
</html>
<ai:loginuser/>
<script type="text/javascript">
var is_tableSaleDetailListTableRowSetEditAble = true;

function _tableSaleDetailListTableRowSet(){ 
	return g_TableRowSetManager.get("saleDetailListTable");
}

function _fromSaleDetailFormRowSet(){
	return g_FormRowSetManager.get("saleDetailForm");
}

function getMainId() {
    return _fromSaleMainFormRowSet.getValue("MAINID");
}

function initPage()
{
    var orderId = "<%=request.getParameter("orderId")%>";
    if ("" == orderId || "null" == orderId){
    	return;
    }
    _fromSaleOrderFormRowSet().refresh("&orderId="+orderId);
	include_refreshSaleMainTable(orderId);
	_include_fromSaleMainTabRowSet().setRow(0);
	newSaleDetail();
	_fromSaleDetailFormRowSet().setValue("SALE_FLAG",11);
	//var saleType=_fromSaleDetailFormRowSet().getValue("SALE_FLAG");
	include_setWeaponFrom(11);
	var editable = "<%=request.getParameter("editable")%>";
    if (editable == "false") {
    	_fromSaleDetailFormRowSet().setEditSts(false);
    	is_tableSaleDetailListTableRowSetEditAble = false;
    	setButtonDisabled();
    	document.getElementById("channel_tr").style.display="block";
    }
    include_reflashAttachTable();
}

function clsTable(table){
    var cols = table.count();
    for (var i=cols; i>0;i--){
        table.deleteRow(i-1);
    }
}

function onSaleTypeChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText)
{
	if (pFieldName == 'SALE_FLAG') {
		var saleType = _fromSaleDetailFormRowSet().getValue("SALE_FLAG");
        _include_formWeaponSelectFormRowSet().newRow();
        clsTable(_include_formDetailTagTabTableRowSet());
		initDetailForm();
        initComputeFormClose();
		initComputeFormOpen(saleType);
		
	}
}

function initDetailForm(){
	_fromSaleDetailFormRowSet().setColEditSts("SALE_ACTIVE_CODE",false);
    //_fromSaleDetailFormRowSet().setFocus("SALE_FLAG");
    //_fromSaleDetailFormRowSet().setFocus("MARKET");
    //_fromSaleDetailFormRowSet().setFocus("SALE_ACTIVE_NAME");
    //_fromSaleDetailFormRowSet().setValue("SALE_FLAG",11);
    _fromSaleDetailFormRowSet().setValue("MARKET",1);
    _fromSaleDetailFormRowSet().setValue("RESERVE2",1);
    _fromSaleDetailFormRowSet().setValue("RESERVE3",0);
    _fromSaleDetailFormRowSet().setColEditSts("OPEN_CHANNEL",false);
	document.getElementById("SALETYPE_OTHERSALE_td_1").style.display="none";
    document.getElementById("SALETYPE_OTHERSALE_td_2").style.display="none";
    _fromSaleDetailFormRowSet().setValue("SALETYPE_OTHERSALE","");
    document.getElementById("SALETYPE_DES_OTHERSALE_td_1").style.display="none";
    document.getElementById("SALETYPE_DES_OTHERSALE_td_2").style.display="none";
    _fromSaleDetailFormRowSet().setValue("SALETYPE_DES_OTHERSALE","");
    
}

function initComputeFormClose(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="none";
    document.getElementById("BACK_PROPORTION_td_2").style.display="none";
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION","");
    _fromSaleDetailFormRowSet().setColEditSts("BACK_PROPORTION",false);
    document.getElementById("PRE_STORE_TO_PRESENT_td_1").style.display="none";
    document.getElementById("PRE_STORE_TO_PRESENT_td_2").style.display="none";
    _fromSaleDetailFormRowSet().setValue("PRE_STORE_TO_PRESENT","");
    _fromSaleDetailFormRowSet().setColEditSts("PRE_STORE_TO_PRESENT",false);
    document.getElementById("PRE_INCOME_td_1").style.display="none";
    document.getElementById("PRE_INCOME_td_2").style.display="none";
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME","");
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2","");
    _fromSaleDetailFormRowSet().setColEditSts("PRE_INCOME",false);
    _fromSaleDetailFormRowSet().setColEditSts("PRE_INCOME2",false);
    document.getElementById("FEE_DISCOUNT_td_1").style.display="none";
    document.getElementById("FEE_DISCOUNT_td_2").style.display="none";
    _fromSaleDetailFormRowSet().setValue("FEE_DISCOUNT","");
    _fromSaleDetailFormRowSet().setColEditSts("FEE_DISCOUNT",false);
    document.getElementById("BUSINESS_DISCOUNT_td_1").style.display="none";
    document.getElementById("BUSINESS_DISCOUNT_td_2").style.display="none";
    _fromSaleDetailFormRowSet().setValue("BUSINESS_DISCOUNT","");
    _fromSaleDetailFormRowSet().setColEditSts("BUSINESS_DISCOUNT",false);
    document.getElementById("MOBILE_COST_td_1").style.display="none";
    document.getElementById("MOBILE_COST_td_2").style.display="none";
    _fromSaleDetailFormRowSet().setValue("MOBILE_COST","");
    _fromSaleDetailFormRowSet().setColEditSts("MOBILE_COST",false);
    document.getElementById("ELECPAY_COST_td_1").style.display="none";
    document.getElementById("ELECPAY_COST_td_2").style.display="none";
    _fromSaleDetailFormRowSet().setValue("ELECPAY_COST","");
    _fromSaleDetailFormRowSet().setColEditSts("ELECPAY_COST",false);
    document.getElementById("MOBILEPAY_COST_td_1").style.display="none";
    document.getElementById("MOBILEPAY_COST_td_2").style.display="none";
    _fromSaleDetailFormRowSet().setValue("MOBILEPAY_COST","");
    _fromSaleDetailFormRowSet().setColEditSts("MOBILEPAY_COST",false);
    document.getElementById("ELECGOODS_COST_td_1").style.display="none";
    document.getElementById("ELECGOODS_COST_td_2").style.display="none";
    _fromSaleDetailFormRowSet().setValue("ELECGOODS_COST","");
    _fromSaleDetailFormRowSet().setColEditSts("ELECGOODS_COST",false);
    document.getElementById("GOODS_COST_td_1").style.display="none";
    document.getElementById("GOODS_COST_td_2").style.display="none";
    _fromSaleDetailFormRowSet().setValue("GOODS_COST","");
    _fromSaleDetailFormRowSet().setColEditSts("GOODS_COST",false);
    //_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY","");
    _fromSaleDetailFormRowSet().setColEditSts("CHANNEL_PAY",false);
    //_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE","");
    _fromSaleDetailFormRowSet().setColEditSts("ESTIMATE_AD_FEE",false);
    //_fromSaleDetailFormRowSet().setValue("ESTIMATE_OTHER_FEE","");
    _fromSaleDetailFormRowSet().setColEditSts("ESTIMATE_OTHER_FEE",false);
    _fromSaleDetailFormRowSet().setValue("COST_TOTAL","");
    _fromSaleDetailFormRowSet().setColEditSts("COST_TOTAL",false);
}

function initComputeFormOpen(saleType){
    _fromSaleDetailFormRowSet().setColEditSts("ESTIMATE_AD_FEE",is_tableSaleDetailListTableRowSetEditAble);
    _fromSaleDetailFormRowSet().setColEditSts("ESTIMATE_OTHER_FEE",is_tableSaleDetailListTableRowSetEditAble);
    _fromSaleDetailFormRowSet().setColEditSts("CHANNEL_PAY",is_tableSaleDetailListTableRowSetEditAble);
	if (saleType == 11) {
	    initDetailForm11();
	} else if (saleType == 12) {
	    initDetailForm12();
	} else if (saleType == 13||saleType == 16) {
	    initDetailForm13();
	} else if (saleType == 14) {
	    initDetailForm14();
	} else if (saleType == 15) {
	    initDetailForm15();
	} else if (saleType == 21) {
	    initDetailForm21();
	} else if (saleType == 22) {
	    initDetailForm22();
	} else if (saleType == 31) {
	    initDetailForm31();
	} else if (saleType == 41) {
	    initDetailForm41();
	} else{
       //alert("档次类型为空");
    }
}

function initDetailForm11(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="block";
    document.getElementById("BACK_PROPORTION_td_2").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_1").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_2").style.display="block";
    document.getElementById("PRE_INCOME_td_1").style.display="block";
    document.getElementById("PRE_INCOME_td_2").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_1").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_2").style.display="block";
}

function initDetailForm12(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="block";
    document.getElementById("BACK_PROPORTION_td_2").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_1").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_2").style.display="block";
    document.getElementById("PRE_INCOME_td_1").style.display="block";
    document.getElementById("PRE_INCOME_td_2").style.display="block";
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    document.getElementById("ELECPAY_COST_td_1").style.display="block";
	    document.getElementById("ELECPAY_COST_td_2").style.display="block";
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    document.getElementById("MOBILEPAY_COST_td_1").style.display="block";
	    document.getElementById("MOBILEPAY_COST_td_2").style.display="block";
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    document.getElementById("ELECGOODS_COST_td_1").style.display="block";
	    document.getElementById("ELECGOODS_COST_td_2").style.display="block";
    }
}

function initDetailForm13(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="block";
    document.getElementById("BACK_PROPORTION_td_2").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_1").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_2").style.display="block";
    document.getElementById("PRE_INCOME_td_1").style.display="block";
    document.getElementById("PRE_INCOME_td_2").style.display="block";
    document.getElementById("GOODS_COST_td_1").style.display="block";
    document.getElementById("GOODS_COST_td_2").style.display="block";
}

function initDetailForm14(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="block";
    document.getElementById("BACK_PROPORTION_td_2").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_1").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_2").style.display="block";
    document.getElementById("PRE_INCOME_td_1").style.display="block";
    document.getElementById("PRE_INCOME_td_2").style.display="block";
    document.getElementById("BUSINESS_DISCOUNT_td_1").style.display="block";
    document.getElementById("BUSINESS_DISCOUNT_td_2").style.display="block";
}

function initDetailForm15(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="block";
    document.getElementById("BACK_PROPORTION_td_2").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_1").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_2").style.display="block";
    document.getElementById("PRE_INCOME_td_1").style.display="block";
    document.getElementById("PRE_INCOME_td_2").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_1").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_2").style.display="block";
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("ELECPAY_COST_td_1").style.display="block";
        document.getElementById("ELECPAY_COST_td_2").style.display="block";
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("MOBILEPAY_COST_td_1").style.display="block";
        document.getElementById("MOBILEPAY_COST_td_2").style.display="block";
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("ELECGOODS_COST_td_1").style.display="block";
        document.getElementById("ELECGOODS_COST_td_2").style.display="block";
    }
    document.getElementById("GOODS_COST_td_1").style.display="block";
    document.getElementById("GOODS_COST_td_2").style.display="block";
    document.getElementById("BUSINESS_DISCOUNT_td_1").style.display="block";
    document.getElementById("BUSINESS_DISCOUNT_td_2").style.display="block";
}

function initDetailForm21(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="block";
    document.getElementById("BACK_PROPORTION_td_2").style.display="block";
    document.getElementById("PRE_INCOME_td_1").style.display="block";
    document.getElementById("PRE_INCOME_td_2").style.display="block";
    document.getElementById("MOBILE_COST_td_1").style.display="block";
    document.getElementById("MOBILE_COST_td_2").style.display="block";
}

function initDetailForm22(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="block";
    document.getElementById("BACK_PROPORTION_td_2").style.display="block";
    document.getElementById("PRE_INCOME_td_1").style.display="block";
    document.getElementById("PRE_INCOME_td_2").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_1").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_2").style.display="block";
}

function initDetailForm31(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="block";
    document.getElementById("BACK_PROPORTION_td_2").style.display="block";
    document.getElementById("PRE_INCOME_td_1").style.display="block";
    document.getElementById("PRE_INCOME_td_2").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_1").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_2").style.display="block";
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("ELECPAY_COST_td_1").style.display="block";
        document.getElementById("ELECPAY_COST_td_2").style.display="block";
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("MOBILEPAY_COST_td_1").style.display="block";
        document.getElementById("MOBILEPAY_COST_td_2").style.display="block";
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("ELECGOODS_COST_td_1").style.display="block";
        document.getElementById("ELECGOODS_COST_td_2").style.display="block";
    }
    document.getElementById("GOODS_COST_td_1").style.display="block";
    document.getElementById("GOODS_COST_td_2").style.display="block";
    document.getElementById("BUSINESS_DISCOUNT_td_1").style.display="block";
    document.getElementById("BUSINESS_DISCOUNT_td_2").style.display="block";
}

function initDetailForm41(){
    document.getElementById("SALETYPE_OTHERSALE_td_1").style.display="block";
    document.getElementById("SALETYPE_OTHERSALE_td_2").style.display="block";
    document.getElementById("SALETYPE_DES_OTHERSALE_td_1").style.display="block";
    document.getElementById("SALETYPE_DES_OTHERSALE_td_2").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_1").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_2").style.display="block";
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("ELECPAY_COST_td_1").style.display="block";
        document.getElementById("ELECPAY_COST_td_2").style.display="block";
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("MOBILEPAY_COST_td_1").style.display="block";
        document.getElementById("MOBILEPAY_COST_td_2").style.display="block";
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("ELECGOODS_COST_td_1").style.display="block";
        document.getElementById("ELECGOODS_COST_td_2").style.display="block";
    }
    document.getElementById("GOODS_COST_td_1").style.display="block";
    document.getElementById("GOODS_COST_td_2").style.display="block";
    document.getElementById("BUSINESS_DISCOUNT_td_1").style.display="block";
    document.getElementById("BUSINESS_DISCOUNT_td_2").style.display="block";
}

function newSaleDetail()
{
	_fromSaleDetailFormRowSet().newRow();
    _include_formWeaponSelectFormRowSet().newRow();
    clsTable(_include_formDetailTagTabTableRowSet());
    //AIContractFrame_OpenClose("weaponInfoframe");
    //AIContractFrame_closeMe();
	//_fromSaleDetailFormRowSet().setEditSts(true);
	initDetailForm();
    initComputeFormClose();
    _fromSaleDetailFormRowSet().setValue("SALE_FLAG",11);
    initComputeFormOpen(11);
	//var mainId = _include_fromSaleMainFormRowSet().getValue("MAINID");
	var curRow = _include_fromSaleMainTabRowSet().getCurRowIndex();
	var mainId = _include_fromSaleMainTabRowSet().getValue(curRow,"MAINID");
	_fromSaleDetailFormRowSet().setValue("SALE_ID",mainId);
	var isGroup = _include_fromSaleMainTabRowSet().getValue(curRow, "ISGROUP");
	if(isGroup == "true") {
		document.getElementById("dis1").style.display="none";
		document.getElementById("dis2").style.display="none";
		document.getElementById("dis3").style.display="none";
		document.getElementById("dis4").style.display="none";
		document.getElementById("dis5").style.display="none";
		document.getElementById("dis6").style.display="none";
		//document.getElementById("jthdxs").style.display="block";
	} else {
		document.getElementById("dis1").style.display="block";
		document.getElementById("dis2").style.display="block";
		document.getElementById("dis3").style.display="block";
		document.getElementById("dis4").style.display="block";
		document.getElementById("dis5").style.display="block";
		document.getElementById("dis6").style.display="block";
		//document.getElementById("jthdxs").style.display="none";
		_fromSaleDetailFormRowSet().setValue("RESERVE3",0);
	}
	//清空checkbox
	setCheckBox("");
	/*document.getElementById('selSendType0').checked = false;
	document.getElementById('selSendType1').checked = false;*/
}

function showDetailInfo()
{
	var curRow = _tableSaleDetailListTableRowSet().getRow();
	var detailId = _tableSaleDetailListTableRowSet().getValue(curRow, "DETAIL_ID");
	_fromSaleDetailFormRowSet().refresh("&id=" + detailId);
	_fromSaleDetailFormRowSet().setColEditSts("SALE_ACTIVE_CODE",false);
	var getIsSendSmsVal=_tableSaleDetailListTableRowSet().getValue(curRow,"IS_SEND_SMS");  
	if("null" != getIsSendSmsVal && "" != getIsSendSmsVal){
    	getcheckboxSts(getIsSendSmsVal);
    }
	
	refreshWeapon(_fromSaleDetailFormRowSet().getValue("WEAPON_ID"));
	_fromSaleDetailFormRowSet().setStsToOld();
	setCheckBox(_fromSaleDetailFormRowSet().getValue("EXT1"));
}

function alertTagsRefreshMainShow(mainId){
	window.parent.resetTabitemsMainShow(mainId);
}

function doShowDetailList(mainId, saleFlag)
{
	_tableSaleDetailListTableRowSet().refresh("&mainId=" + mainId +"&saleFlag=" + saleFlag);
}

function selectStaff()
{
	var url = "<%=request.getContextPath()%>/secframe/orgmodel/operator/StaffSelect_s.jsp";
	var result = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px");
	if(result != null){
		var value;
		var text;
   		for(var i=0;i < result.elements.length;i++)
  		{
  			alert(result.elements[i].value+"~"+result.elements[i].text);
  			if (i == 0)
  			{
	  			value = result.elements[i].value;
	  			text = result.elements[i].text;
  			} else {
	  			value = value + ";" + result.elements[i].value
	  			text = text + ";" + result.elements[i].text;
  			}
  		}
		_fromWfCheckFormRowSet.setValue("STAFFS", value, text); 
	}
} 

function refreshWeapon(weaponId){
	_include_formWeaponSelectFormRowSet().refresh("&wwid="+weaponId+"&name="+"&busiType=");
	//初始化产品协助配置项
	initAttachCfgOpt(_include_formWeaponSelectFormRowSet().getValue("STANDBY_NUM3"));
    _include_formDetailTagTabTableRowSet().refresh("&weaponId="+weaponId);
    include_setWeaponFrom();
    //AIContractFrame_OpenClose("weaponInfoframe");
    //AIContractFrame_openMe();
    compute4weapon();
}

function compute4weapon(){
	if("" == _include_formWeaponSelectFormRowSet().getValue("SALE_FLAG")) {
		return alert("请先选择武器信息！");
	}
	saleType = _include_formWeaponSelectFormRowSet().getValue("SALE_FLAG");
	initComputeFormClose();
	if(saleType==11){
		compute4weapon11();
    } else if(saleType==12||saleType==16){
        compute4weapon12();
    }else if(saleType==18){
    	compute4weapon18();
    } else if(saleType==13){
        compute4weapon13();
	} else if(saleType==14){
        compute4weapon14();
	} else if(saleType==15){
        compute4weapon15();
	} else if(saleType==21){
        compute4weapon21();
	} else if(saleType==22){
        compute4weapon22();
	} else if(saleType==31){
        compute4weapon31();
	} else if(saleType==41){
        compute4weapon41();
	} else if(saleType==17 || saleType==23){
	} else {
	   alert("档次类型为空");
	}
	initComputeFormOpen(saleType);
}

function refreshCompute4weapon(){
    if("" == _include_formWeaponSelectFormRowSet().getValue("SALE_FLAG")) {
    	alert("请先选择武器信息！");
        return false;
    }
    saleType = _include_formWeaponSelectFormRowSet().getValue("SALE_FLAG");
    if(saleType==11){
        compute4weapon11();
    } else if(saleType==12||saleType==16){
        compute4weapon12();
    }else if(saleType==18){
    	compute4weapon18();
    }else if(saleType==13){
        compute4weapon13();
    } else if(saleType==14){
        compute4weapon14();
    } else if(saleType==15){
        compute4weapon15();
    } else if(saleType==21){
        compute4weapon21();
    } else if(saleType==22){
        compute4weapon22();
    } else if(saleType==31){
        compute4weapon31();
    } else if(saleType==41){
        compute4weapon41();
    } else if(saleType==17 || saleType==23) {
    	
    } else {
       alert("档次类型为空");
       return false;
    }
    return true;
}

function setButtonDisabled(){
    document.getElementById('bt_weaponSelect1').style.visibility='hidden';
	document.getElementById('bt_refreshCompute4weapon').style.visibility='hidden';
	document.getElementById('bt_newSaleDetail').style.visibility='hidden';
	document.getElementById('bt_delSaleDetail').style.visibility='hidden';
	document.getElementById('bt_applyWeapon').style.visibility='hidden';
}

function setCheckBox(hintVal) {
	document.getElementById("hint0_input").checked = false;
    document.getElementById("hint1_input").checked = false;
    document.getElementById("hint2_input").checked = false;
    document.getElementById("hint3_input").checked = false;
	if(hintVal != null && hintVal != ""){
    	var hintVec = hintVal.split(";");
    	for(var i = 0; i < hintVec.length; i++){
    		document.getElementById("hint"+hintVec[i] + "_input").checked = true;
    		document.getElementById("hint"+hintVec[i] + "_tr").style.display="block";
    	}
    } 
	if(true == document.getElementById('hint0_input').checked){
		document.getElementById("hint0_tr").style.display="block";
	} else {
		document.getElementById("hint0_tr").style.display="none";
	}
	if(true == document.getElementById('hint1_input').checked){
		document.getElementById("hint1_tr").style.display="block";
	} else {
		document.getElementById("hint1_tr").style.display="none";
	}
	if(true == document.getElementById('hint2_input').checked){
		document.getElementById("hint2_tr").style.display="block";
	} else {
		document.getElementById("hint2_tr").style.display="none";
	}
	if(true == document.getElementById('hint3_input').checked){
		document.getElementById("hint3_tr").style.display="block";
	} else {
		document.getElementById("hint3_tr").style.display="none";
	}
}

function checkboxSts(pos) {
	if(pos == 0){
		if(true == document.getElementById('hint0_input').checked){
			document.getElementById("hint0_tr").style.display="block";
		} else {
			document.getElementById("hint0_tr").style.display="none";
		}
	}
	if(pos == 1){
		if(true == document.getElementById('hint1_input').checked){
			document.getElementById("hint1_tr").style.display="block";
		} else {
			document.getElementById("hint1_tr").style.display="none";
		}
	}
	if(pos == 2){
		if(true == document.getElementById('hint2_input').checked){
			document.getElementById("hint2_tr").style.display="block";
		} else {
			document.getElementById("hint2_tr").style.display="none";
		}
	}
	if(pos == 3){
		if(true == document.getElementById('hint3_input').checked){
			document.getElementById("hint3_tr").style.display="block";
		} else {
			document.getElementById("hint3_tr").style.display="none";
		}
	}
}
</script>