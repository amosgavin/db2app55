<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="saleOrderframe" contenttype="table" title="营销活动主要信息" width="100%" allowcontract="true" frameclosed="true">
    <ai:contractitem/>
    <ai:dbform formid="saleOrderForm" 
            setname="com.asiainfo.sale.activity.web.SETSaleOrder"
            conditionname="condition" parametersname="parameters"
            editable="false" initial="false"
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
                <td><ai:dbformfield formid="saleOrderForm" fieldname="ORDER_NAME" width="350"/><span class="font_red">*</span>
                <ai:dbformfield formid="saleOrderForm" fieldname="ORDER_ID" width="50" visible="false"/>
                <ai:dbformfield formid="saleOrderForm" fieldname="STATE" visible="false"/></td>         
            </tr>
  		</table>
    </ai:dbform>
</ai:contractframe>
<ai:contractframe id="saleMainListframe" contenttype="table" title="批次信息" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem></ai:contractitem>
    <ai:table
        tableid="saleMainListTable" 
        setname="com.asiainfo.sale.activity.web.SETSaleMain"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleOrderSV"
        implservice_querymethod="getSaleMainByOrderId(String orderId, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getSaleMainCountByOrderId(String orderId)"
        initial="false"  multiselect="false" onrowchange="showSaleDetailInfo"
        pagesize="5" editable="false" width="100%"
        height="100" needrefresh="true">
        <ai:col title="批次ID" fieldname="MAINID" width="100" />
        <ai:col title="批次名称" fieldname="SALE_MAIN_NAME" width="300" />
        <ai:col title="执行范围" fieldname="EXEAREA" width="100" />
        <ai:col title="开始时间：" fieldname="BEGIN_TIME" width="200" />
        <ai:col title="结束时间：" fieldname="END_TIME" width="150" />
        <ai:col title="细分市场" fieldname="MARKTYPE" width="300" />
        <ai:col fieldname="ISGROUP" width="300" visible="false"/>
    </ai:table>
</ai:contractframe>

<script type="text/javascript">

function _fromSaleOrderFormRowSet(){
	return g_FormRowSetManager.get("saleOrderForm");
}

function _include_fromSaleMainTabRowSet(){
	return g_TableRowSetManager.get("saleMainListTable");
}

function include_refreshSaleMainTable(orderId) {
    _include_fromSaleMainTabRowSet().refresh("&orderId="+orderId);
    //var principal = _include_fromSaleMainFormRowSet().getValue("PRINCIPAL");
    //var staff_name = _include_fromSaleMainFormRowSet().getValue("STAFF_NAME");
    //var promote_depart = _include_fromSaleMainFormRowSet().getValue("PROMOTE_DEPART");
    //var organize_name = _include_fromSaleMainFormRowSet().getValue("ORGANIZE_NAME");
    //_include_fromSaleMainFormRowSet().setValue("PRINCIPAL",principal,principal+"|"+staff_name);
    //_include_fromSaleMainFormRowSet().setValue("PROMOTE_DEPART",promote_depart,promote_depart+"|"+organize_name);
    //_include_tableSaleDetailListTableRowSet().refresh("&mainId=" + mainId);
}

function showSaleDetailInfo(oldIndex,newIndex){
	if(-1 != oldIndex) {
       _include_fromSaleMainTabRowSet().setRowBgColor(oldIndex,"");
    }
	var mainId = _include_fromSaleMainTabRowSet().getValue(newIndex,"MAINID");
    _include_fromSaleMainTabRowSet().setRowBgColor(newIndex,"yellow");
    if (pageName == 'overview') {
    	initEitApprise(mainId);
    	include_refreshSaleMainOverviewForm(mainId);
    } else if (pageName == 'explan') {
    	include_refreshSaleMainExplanForm(mainId);
    }
    //_include_tableSaleDetailListTableRowSet().setRow(0);
}

function include_isShowAllow(){
    //var mainId = _fromSaleOrderFormRowSet().getValue("MAINID");
    //if ("" == mainId || "null" == mainId){
    //    return false;
    //}
    return true;
    if (_include_fromSaleMainTabRowSet().count() > 0) {
    	return true;
    }
    return false;
}
</script>
<script type="text/javascript">
function include_setButtonDisabled(style){
    if (true == style || false == style){
        return style;
    } else {
        if ("" != _fromSaleOrderFormRowSet().getValue("STATE") && "1" != _fromSaleOrderFormRowSet().getValue("STATE")){
            include_setButtonDisabled(true);
            return true;
        }
        return false;
    }
}
</script>