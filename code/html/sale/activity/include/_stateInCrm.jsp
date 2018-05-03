<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/jquery/jquery-1.8.3.js" type="text/javascript"></script>
<div id="crm_div" style="display: none">
<ai:contractframe id="actInfoCrmframe" contenttype="table" title="CRM--活动审批" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
   <!--   <ai:table tableid="actInfoCrmTab" 
            tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            setname="com.asiainfo.sale.activity.web.SETActInfoCrm"
            conditionname="condition" parametersname="parameters" ondbclick="showActInfoCrm"
            editable="false" initial="false" width="100%" height="23" footdisplay ="none">
	        <ai:col title="批次编码" fieldname="PRODID" width="100" />
	        <ai:col title="批次名称" fieldname="PRODNAME" width="500" />
	        <ai:col fieldname="CREATEDATE" width="130" />
	        <ai:col title="状态" fieldname="STATUS" width="100" />
	        <ai:col fieldname="AUDITSTATUS" width="150" />
    </ai:table>
    -->
    <ai:table tableid="levInfoCrmTab" 
            tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            setname="com.asiainfo.sale.activity.web.SETLevInfoCrm"
            conditionname="condition" parametersname="parameters" ondbclick="showLevInfoCrm"
            editable="false" initial="false" width="100%" height="23" footdisplay ="none">
	        <ai:col fieldname="PRIVID" width="180" />
	        <ai:col fieldname="PRIVNAME" width="500" />
	        <ai:col fieldname="AUDITSTATUS" width="150" />
    </ai:table>
</ai:contractframe>
</div>
<script language="javascript" src="<%=request.getContextPath()%>/sale/activity/js/requestToCrm.js"></script>
<script type="text/javascript">

//var actInfoCrmTab = g_TableRowSetManager.get("actInfoCrmTab");
var levInfoCrmTab = g_TableRowSetManager.get("levInfoCrmTab");
var privDetail;
var prodDetail;

function initCrmInfo(privID, privName) {
	var privStatus = query_CRM("QueryPrivStatus",privID);
        if (privStatus == '') return;
	if (privStatus.head.retCode != 0) return;
        if (levInfoCrmTab.count() < 1) {
		levInfoCrmTab.newRow();
	}
	levInfoCrmTab.setValue(0,"PRIVID",privID);
	levInfoCrmTab.setValue(0,"PRIVNAME",privName);
	levInfoCrmTab.setValue(0,"AUDITSTATUS",privStatus.body.privStatus);
}

function showActInfoCrm() {
	var allSaleInfoTab = g_TableRowSetManager.get("allSaleInfoTable")
	var curRowIndex = allSaleInfoTab.getRow();
	var batchCode = allSaleInfoTab.getValue(curRowIndex,"SALE_MAIN_CODE");
	var batchName = allSaleInfoTab.getValue(curRowIndex,"BATCH_NAME");
	var levCode = allSaleInfoTab.getValue(curRowIndex,"SALE_ACTIVE_CODE");
	var levName = allSaleInfoTab.getValue(curRowIndex,"LEVEL_NAME");
	var levDesc = allSaleInfoTab.getValue(curRowIndex,"LEVEL_DESC");
	var beginDate = allSaleInfoTab.getValue(curRowIndex,"BEGIN_TIME");
	var endDate = allSaleInfoTab.getValue(curRowIndex,"END_TIME");
	var saleFlag = allSaleInfoTab.getDisplayText(curRowIndex,"SALE_FLAG");
	var url = "<%=request.getContextPath()%>/sale/activity/include/_prodDetailInfoCrm.jsp?prodDetail="+prodDetail 
	                                                                                    + "&batchCode="+batchCode
	                                                                                    + "&batchName="+batchName
	                                                                                    + "&levCode="+levCode
	                                                                                    + "&levName="+levName
	                                                                                    + "&beginDate="+beginDate
	                                                                                    + "&endDate="+endDate
	                                                                                    + "&saleFlag="+saleFlag
	                                                                                    + "&levDesc="+levDesc;
	var retVal = window.open(url,"","height=650,width=600,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}

function showLevInfoCrm() {
	if(levInfoCrmTab.getValue(0,"AUDITSTATUS") == 0 || levInfoCrmTab.getValue(0,"AUDITSTATUS") ==3){
		return alert("工单不可审核！");
	}
	var allSaleInfoTab = g_TableRowSetManager.get("allSaleInfoTable")
	var curRowIndex = allSaleInfoTab.getRow();
	var batchCode = allSaleInfoTab.getValue(curRowIndex,"SALE_MAIN_CODE");
	var batchName = allSaleInfoTab.getValue(curRowIndex,"BATCH_NAME");
	var levCode = allSaleInfoTab.getValue(curRowIndex,"SALE_ACTIVE_CODE");
	var levName = allSaleInfoTab.getValue(curRowIndex,"LEVEL_NAME");
	var levDesc = allSaleInfoTab.getValue(curRowIndex,"LEVEL_DESC");
	var beginDate = allSaleInfoTab.getValue(curRowIndex,"BEGIN_TIME");
	var endDate = allSaleInfoTab.getValue(curRowIndex,"END_TIME");
	var saleFlag = allSaleInfoTab.getDisplayText(curRowIndex,"SALE_FLAG");
	var url = "<%=request.getContextPath()%>/sale/activity/include/_privDetailInfoCrm.jsp?privDetail="+privDetail
	                                                                                    + "&batchCode="+batchCode
	                                                                                    + "&batchName="+batchName
	                                                                                    + "&levCode="+levCode
	                                                                                    + "&levName="+levName
	                                                                                    + "&beginDate="+beginDate
	                                                                                    + "&endDate="+endDate
	                                                                                    + "&saleFlag="+saleFlag
	                                                                                    + "&levDesc="+levDesc;
	var retVal = window.open(url,"","height=650,width=600,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}

function _fromSaleOrderFormRowSet(){
	return g_FormRowSetManager.get("saleOrderForm");
}

function _include_fromSaleMainTabRowSet(){
	return g_TableRowSetManager.get("saleMainListTable");
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
    _include_fromSaleMainTabRowSet().setRowBgColor(newIndex,"yellow");
    if(mainId == null || mainId == '') return;
    _saleDetail.qrySaleDetail("&mainId="+mainId);
  //  _include_tableSaleDetailListTableRowSet().refresh("&mainId="+mainId);
    newSaleDetail();
}

</script>
