<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title>选择部门</title>
  </head>
<body onload = "initTree()">
<ai:contractframe id="contractframe2" contenttype="table" title="部门选择" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem/>
  <div id="byorg" >
     <table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
		<tr><td>
	        <ai:dbtree_new id="orgStaffTree" datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel" 
				multiselect="true" height="450" width="100%" ishaveline="true" explanonselect="false" 
				oncheckboxclick="ckboxClick"/>
		</td></tr>
	</table>
	<div class="area_button">
		<ai:button text="清空" id="clearAll" onclick="clearAll()"/>
		<ai:button text="确定" id="cancel" onclick="doReturn()"/>
		<ai:button text="orgrelat.cancel" i18nRes="i18n.secframe_resource" id="cancel" onclick="cancel()"/>
	</div> 
</div>
</ai:contractframe>	
</body>
<script type="text/javascript">
	var workflowId = "<%=request.getParameter("workflowId")%>";
	var dbTree = g_DBTreeNewManager.get("orgStaffTree");
	
	function initTree()
	{
		var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AppriseAction?action=getAppriseOrgIds&workflowId=' + workflowId;
    	var ret = PostInfo(strUrl, null);
    	var orgStr = ret.getValueByName("orgStr");
    	if (orgStr == null){
    		return;
    	}
    	var orgIds = orgStr.split(',');
		dbTree.expandNodeByValue(10, 'true');
		for (var i = 0; i < orgIds.length; ++i){
			//dbTree.expandNodeByValue((orgIds[i], 'true');
			dbTree.expandNodeByValue((orgIds[i].toString()).substr(0,2), 'true');
			if((orgIds[i].toString()).length == 6){
				dbTree.expandNodeByValue((orgIds[i].toString()).substr(0,4), 'true');
			}
			dbTree.expandNodeByValue(orgIds[i], 'true');
		}
		for (var j = 0; j < orgIds.length; ++j){
			dbTree.setNodeChecked(orgIds[j], 'true');
		}
	}
	
	function ckboxClick(pCheckedVal,pCheckedText,pCheckUserObj,isChecked,pCheckNodeType) {
		
		//var checkNode = dbTree.getCurNodeInfo();
		//alert(pCheckedVal);
		dbTree.expandNodeByValue(pCheckedVal, 'true');
	}
	
    function cancel()
	{	
		window.self.close();
	}
	
    function clearAll()
    {
    	dbTree.clearSelection();
    }
    
    function checkChild()
    {
    	var curNodeVal = dbTree.getCurNodeInfo();
    	alert(curNodeVal);
    }
    
    /**
     * 选择的机构
     */
    function doReturn()
    {
    	var orgIds = new Array();
    	var selectedNodes = dbTree.getCheckedNodesInfo();
    	if (selectedNodes != null){
	    	for (var i = 0; i < selectedNodes.length; ++i){
	    		orgIds[i] = selectedNodes[i].value;
	    	}
    	}
        //window.returnValue = orgIds;
        var condition = 'workflowId=' + workflowId + '&orgList=' + orgIds;
        var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AppriseAction?action=saveAppriseOrg&' + condition;
        var recode = PostInfo(strUrl, null);
        window.returnValue = orgIds;
        window.self.close();
    }
    
</script>
  
</html>
