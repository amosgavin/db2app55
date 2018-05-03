<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<ai:contractframe id="channelRuleTabframe" contenttype="table" title="产品发布渠道规则" width="100%" allowcontract="false" frameclosed="false">
    <ai:contractitem>
	    <ai:button id="bt_addRule" text="添加" onclick="_addRule()"/>
		<ai:button id="bt_delRule" text="删除" onclick="_delRule()"/>
	</ai:contractitem>
    <ai:table tableid="channelRuleTab" 
            setname="com.asiainfo.sale.activity.web.SETChannelRule"
            conditionname="condition" parametersname="parameters" width="100%" rowsequence='true'
            onvalchange="" editable="false" initial="false" pagesize="30" height="150"
            needrefresh="true" multiselect="true"
            tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.activity.service.interfaces.IChannelRuleSV"
            implservice_querymethod="getRuleByChargeDetailId(String chargeDetailId, String channelRulesIds)"
            implservice_countmethod="getRuleCountByChargeDetailId(String chargeDetailId, String channelRulesIds)">
            <ai:col fieldname="RULE_ID" width="100" visible="false"/>
	        <ai:col fieldname="CONF_MODE" width="150" />
	        <ai:col fieldname="CHANNEL_TYPE" width="300" />
	        <ai:col fieldname="CHANNEL_POS_TYPE" width="300" />
	        <ai:col fieldname="CHANNEL_LEV_TYPE" width="300" />
    </ai:table>
</ai:contractframe>

<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function include_refreshChannealRule(chargeDetailId) {
	var channelRuleTab = g_TableRowSetManager.get("channelRuleTab");
	if (chargeDetailId == null || chargeDetailId == "" || chargeDetailId == "null") return;
    channelRuleTab.refresh("&chargeDetailId=" + chargeDetailId);
}

function _addRule(){

	var chargeDetailId =  _fromChargeMainDeFormRowSet.getValue("MID");
	
	//var saleDetailCode = _fromSaleDetailFormRowSet().getValue("SALE_ACTIVE_CODE");
	if (null == chargeDetailId || chargeDetailId == '') {
		return alert("请先保存资费档次！");
	}
	var url = "<%=request.getContextPath()%>/charge/include/_channelRule.jsp?chargeDetailId=" + chargeDetailId;
    window.showModalDialog(url, null, "scroll:yes;resizable:yes;help:no;status:s;dialogHeight:600px;dialogWidth:800px");
    var channelRuleTab = g_TableRowSetManager.get("channelRuleTab");
    channelRuleTab.refresh("&chargeDetailId=" + chargeDetailId);
}

function _delRule() {
	var channelRuleTab = g_TableRowSetManager.get("channelRuleTab");
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
</script>