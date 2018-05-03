<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>资费审核</title>
</script>
</head>
<ai:loginuser/>
<body onload="init();">
   
 <ai:contractframe id="chargeApplyMain" contenttype="table" title="已保存的资费主信息" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:table
        tableid="productAttachConfTab"
        setname="com.asiainfo.common.web.SETProductAttachCfg"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.common.service.interfaces.IProductAttachCfgSV"
        implservice_querymethod="getProductAttachCfgById(String id)"
        initial="false" pagesize="15" editable="false" width="100%" rowheight=""
        height="100" needrefresh="true">
        	<ai:col title="ID" fieldname="ID" width="70"/>
            <ai:col title="关联工单ID" fieldname="RELA_ORDER_ID" width="130" />
            <ai:col title="资费类型" fieldname="RELA_ORDER_TYPE" width="130" />
    </ai:table>
 </ai:contractframe>

</body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script type="text/javascript">
var applyId="<%=request.getParameter("recordId")%>";
var templateCode = "<%=request.getParameter("templateCode")%>";
var taskId = "<%=request.getParameter("taskTemplateId")%>";
var taskTag = "<%=request.getParameter("taskTag")%>";
var taskRecordId = "<%=request.getParameter("taskId")%>";
var flowType = "<%=request.getParameter("recordType")%>";
var workflowId = "<%=request.getParameter("workflowId")%>";
var productAttachConfTab= g_TableRowSetManager.get("productAttachConfTab");

function init(){
	productAttachConfTab.refresh("&id="+applyId);
	reloadPage();
}

function reloadPage() {
	var relaOrderId = productAttachConfTab.getValue(0, "RELA_ORDER_ID");
	var relaOrderType = productAttachConfTab.getValue(0, "RELA_ORDER_TYPE");
	var url = "./productConfCheck.jsp?"
	           +"relaOrderType=" + relaOrderType
	           +"&recordId=" + relaOrderId
	           +"&id=" + applyId
               +"&recordType=" + flowType
               +"&taskTag=" + taskTag
               +"&taskId=" + taskId
               +"&taskRecordId=" + taskRecordId
               +"&templateCode=" + templateCode
               +"&workflowId=" + workflowId;
	window.open(url, null, "height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}

function trim(str){
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>




