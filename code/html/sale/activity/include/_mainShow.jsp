<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="saleOrderframe" contenttype="table" title="Ӫ�����Ҫ��Ϣ" width="100%" allowcontract="true" frameclosed="true">
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
            	<td class="td_font">�����ˣ�</td>
            	<td><ai:dbformfield formid="saleOrderForm" fieldname="PRINCIPLE" width="150" visible="false"/>
            	    <ai:dbformfield formid="saleOrderForm" fieldname="PROP_NAME" width="150"/></td>
            	<td class="td_font">���뵥λ��</td>
            	<td><ai:dbformfield formid="saleOrderForm" fieldname="ORG_ID" width="150" visible="false"/>
            	    <ai:dbformfield formid="saleOrderForm" fieldname="ORG_NAME" width="150" /></td>
            </tr>
            <tr>
                <td class="td_font">�������ƣ�</td>
                <td><ai:dbformfield formid="saleOrderForm" fieldname="ORDER_NAME" width="300"/><span class="font_red">*</span>
                <ai:dbformfield formid="saleOrderForm" fieldname="ORDER_ID" width="50" visible="false"/>
                <ai:dbformfield formid="saleOrderForm" fieldname="STATE" visible="false"/></td>         
            </tr>
  		</table>
    </ai:dbform>
</ai:contractframe>
<ai:contractframe id="saleMainListframe" contenttype="table" title="������Ϣ" width="100%" allowcontract="true" frameclosed="false">
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
        <ai:col title="����ID" fieldname="MAINID" width="100" />
        <ai:col title="��������" fieldname="SALE_MAIN_NAME" width="300" />
        <ai:col title="ִ�з�Χ" fieldname="EXEAREA" width="100" />
        <ai:col title="��ʼʱ�䣺" fieldname="BEGIN_TIME" width="150" />
        <ai:col title="����ʱ�䣺" fieldname="END_TIME" width="150" />
        <ai:col title="ϸ���г�" fieldname="MARKTYPE" width="300" />
        <ai:col fieldname="ISGROUP" width="300" visible="false"/>
    </ai:table>
</ai:contractframe>
<%-- 
<%@ include file="/sale/product/include/_saleDetail.jsp" %>  --%>
<ai:contractframe id="saleDetailListframe" contenttype="table" title="������Ϣ" width="100%" allowcontract="true" frameclosed="fale" frameclosed="false">
    <ai:contractitem><ai:button id="bt_newSaleDetail" text="����" onclick="newSaleDetail()"/>
                   <ai:button id="bt_delSaleDetail" text="ɾ��" onclick="doWork('include_delSaleDetail()')"/></ai:contractitem>
    <ai:table
        tableid="saleDetailListTable"
        setname="com.asiainfo.sale.activity.web.SETSaleDetail"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleDetailSV"
        implservice_querymethod="getSaleDetailBySaleFlag(String mainId, String saleFlag, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getCountBySaleFlag(String mainId, String saleFlag)"
        ondbclick="showDetailInfo" onrowchange="onrowchange"
        initial="false"  multiselect="true"
        pagesize="10" editable="false" width="100%"
        height="240" needrefresh="true">
        <ai:col title="DETAIL_ID" fieldname="DETAIL_ID" visible="false"/>
        <ai:col title="����ID" fieldname="SALE_ID" width="60" />
        <ai:col title="��������" fieldname="RESERVE2" width="80" />
        <ai:col title="����ģ��" fieldname="SALE_FLAG" width="100" />
        <ai:col title="����" fieldname="SALE_ACTIVE_NAME" width="300" />
        <ai:col title="ϸ���г�" fieldname="MARKET" width="80" />
        <ai:col title="ƽ̨����" fieldname="SALE_ACTIVE_CODE" width="180" />
        <ai:col title="BOSSϵͳ���α���" fieldname="LEVEL_CODE" width="180" />
        <ai:col title="�������(%)" fieldname="PRE_DISCOUNT" width="100" />
        <ai:col title="����ʱ��" fieldname="CREATE_TIME" width="140" visible="false"/>
        <ai:col title="����޸�ʱ��" fieldname="MODIFY_TIME" visible="false" />
        <ai:col title="�Ƿ���Ҫ��������" fieldname="IS_SEND_SMS" visible="false" />

    </ai:table>
</ai:contractframe>
<script type="text/javascript">
var saleStartTime;
var saleEndTime;
function _fromSaleOrderFormRowSet(){
	return g_FormRowSetManager.get("saleOrderForm");
}

function _include_fromSaleMainTabRowSet(){
	return g_TableRowSetManager.get("saleMainListTable");
}

function _include_tableSaleDetailListTableRowSet(){
    return g_TableRowSetManager.get("saleDetailListTable");
}

function include_refreshSaleMainTable(mainId) {
    _include_fromSaleMainTabRowSet().refresh("&orderId="+mainId);
    //_include_tableSaleDetailListTableRowSet().refresh("&mainId=" + mainId);
}

function showSaleDetailInfo(oldIndex,newIndex){
	if(-1 != oldIndex) {
       _include_fromSaleMainTabRowSet().setRowBgColor(oldIndex,"");
    }
	var mainId = _include_fromSaleMainTabRowSet().getValue(newIndex,"MAINID");
	saleStartTime = _include_fromSaleMainTabRowSet().getValue(newIndex,"BEGIN_TIME").toString().substr(0,10);
	saleEndTime = _include_fromSaleMainTabRowSet().getValue(newIndex,"END_TIME").toString().substr(0,10);
    _include_fromSaleMainTabRowSet().setRowBgColor(newIndex,"yellow");
    if(mainId == null || mainId == '') return;
    //_saleDetail.qrySaleDetail("&mainId="+mainId);
    _include_tableSaleDetailListTableRowSet().refresh("&mainId="+mainId);
    newSaleDetail();
}

function include_delSaleDetail()
{
    var ss = new Array();
    ss = _include_tableSaleDetailListTableRowSet().getSelectedRows();
    if (ss.length < 1) {
        alert("��ѡ��Ҫɾ�������ݣ�");
        return;
    }
    var saleDetailListTab = _include_tableSaleDetailListTableRowSet();
    var mainId = _include_fromSaleMainTabRowSet().getValue(_include_fromSaleMainTabRowSet().getCurRowIndex(),"MAINID");
    _include_tableSaleDetailListTableRowSet().refresh("&mainId="+mainId);
    for ( var i = ss.length; i > 0; i--) {
        saleDetailListTab.deleteRow(ss[i - 1]);
    }
    include_savaRowSet(saleDetailListTab);
    newSaleDetail();
    //alertTagsRefreshMainShow(_include_fromSaleMainFormRowSet().getValue("MAINID"));
}

function include_savaRowSet(rowSet){
    var list = new Array();
    list.push(rowSet);
    var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.SaleDetailAction?action=saveSaleDetail';
    saveRowSet(strUrl, list);
}

function include_isShowAllow(){
    //var mainId = _include_fromSaleMainFormRowSet().getValue("MAINID");
    //if ("" == mainId || "null" == mainId){
        //return false;
    //}
    //return true;
    if (_include_fromSaleMainTabRowSet().count() > 0) {
    	return true;
    }
    return false;
}
</script>
<script type="text/javascript">
function include_setButtonDisabled(style){
    if (true == style || false == style){
        g_AIButtonManager.get("bt_newSaleDetail").setDisabled(style);
        g_AIButtonManager.get("bt_delSaleDetail").setDisabled(style);
        g_AIButtonManager.get("bt_addGoodsTag").setDisabled(style);
        g_AIButtonManager.get("bt_delGoodsTag").setDisabled(style);
        return style;
    } else {
        if ("" != _fromSaleOrderFormRowSet().getValue("STATE") && "1" != _fromSaleOrderFormRowSet().getValue("STATE")){
            include_setButtonDisabled(true);
            return true;
        }
        return false;
    }
}

function onrowchange(oldIndex,newIndex){
    if(-1 != oldIndex) {
   		//_saleDetail.grid().setRowBgColor(oldIndex,"");
    	_include_tableSaleDetailListTableRowSet().setRowBgColor(oldIndex,"");
    }
    	_include_tableSaleDetailListTableRowSet().setRowBgColor(newIndex,"yellow");
    	showDetailInfo();
}
</script>