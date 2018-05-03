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
        tableid="allSaleInfoTable" 
        setname="com.asiainfo.sale.activity.web.SETOrderShow"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.sale.activity.service.interfaces.IOrderShowSV"
        implservice_querymethod="getSaleInfoByOrderId(String orderId)"
        initial="false"  multiselect="false" onrowchange="showEitInfo"
        pagesize="200" editable="false" width="100%" rowheight="30"
        height="300" needrefresh="true">
        <ai:col fieldname="BATCH_ID" width="70" />
        <ai:col fieldname="BATCH_NAME" width="250" />
        <ai:col fieldname="SALE_MAIN_CODE" width="250" visible="false"/>
        <ai:col fieldname="LEVEL_NAME" width="250"/>
        <ai:col fieldname="LEVEL_DESC" width="250" visible="false"/>
        <ai:col fieldname="SALE_ACTIVE_CODE" width="250" visible="false"/>
        <ai:col fieldname="SALE_FLAG" width="80" />
        <ai:col fieldname="BEGIN_TIME" width="130" />
        <ai:col fieldname="END_TIME" width="130" />
        <ai:col fieldname="MARKTYPE" width="100" />
        <ai:col fieldname="EXEAREA" width="70" />
        <ai:col fieldname="PRESTORE_FEE" width="90" />
        <ai:col fieldname="PRESTRORE_REACH_ACCOUNT" width="100" />
        <ai:col fieldname="BASE" width="50" />
        <ai:col fieldname="PRESENT_FEE" width="90" />
        <ai:col fieldname="PRESENT_REACH_AMOUNT" width="100" />
        <ai:col fieldname="PRESENT_TICK" width="100" />
        <ai:col fieldname="GOODS_NAMES" width="100" />
        <ai:col fieldname="REFERENCE_PRICE" width="100" />
        <ai:col fieldname="DIG_TYPE" width="100" />
        <ai:col fieldname="GLOBAL_SCORE" width="130"/>
    </ai:table>
</ai:contractframe>
<%@include file="/sale/activity/include/_stateInCrm.jsp"%>
<script type="text/javascript">
function _fromSaleOrderFormRowSet(){
	return g_FormRowSetManager.get("saleOrderForm");
}

function include_refreshAllSaleInfoTable(orderId) {
    g_TableRowSetManager.get("allSaleInfoTable").refresh("&orderId="+orderId);
    g_TableRowSetManager.get("allSaleInfoTable").setRow(0);
}

function showEitInfo(oldIndex,newIndex){
	if(-1 != oldIndex) {
       g_TableRowSetManager.get("allSaleInfoTable").setRowBgColor(oldIndex,"");
    }
	var mainId = g_TableRowSetManager.get("allSaleInfoTable").getValue(newIndex,"BATCH_ID");
    g_TableRowSetManager.get("allSaleInfoTable").setRowBgColor(newIndex,"yellow");
   	initEitApprise(mainId);
   	include_refreshSaleMainOverviewForm(mainId);
   	var taskTag = "<%=request.getParameter("taskTag")%>";
    if (taskTag == 't13' || taskTag == 't0009' || taskTag == 't3001') {
   		document.getElementById("crm_div").style.display="block";
   		//initCrmInfo(g_TableRowSetManager.get("allSaleInfoTable").getValue(newIndex,"SALE_ACTIVE_CODE"));
   		//initCrmInfo("yxt201407030939");
   		initCrmInfo(g_TableRowSetManager.get("allSaleInfoTable").getValue(newIndex,"SALE_ACTIVE_CODE"), g_TableRowSetManager.get("allSaleInfoTable").getValue(newIndex,"LEVEL_NAME"));
   	}
}

function include_isShowAllow(){
    return true;
    if (g_TableRowSetManager.get("allSaleInfoTable").count() > 0) {
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