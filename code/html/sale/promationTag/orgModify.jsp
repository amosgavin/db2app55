<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title>修改</title>
  </head>
<body onload = "initTree()">
<ai:contractframe id="contractframe2" contenttype="table" title="部门" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem/>
  <div id="byorg" >
     <table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
		<tr><td>
	        <ai:dbtree_new id="orgStaffTree" datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel" 
				multiselect="true" height="450" width="100%" ishaveline="true" oncheckboxclick="ckboxClick"
				explanonselect="true"/>
		</td></tr>
	</table>
	<div class="area_button">
		<ai:button text="确定" id="cancel" onclick="doReturn()"/>
		<ai:button text="orgrelat.cancel" i18nRes="i18n.secframe_resource" id="cancel" onclick="cancel()"/>
	</div> 
</div>
</ai:contractframe>	
</body>
<script type="text/javascript">

	var dbTree = g_DBTreeNewManager.get("orgStaffTree");
	var workflowId = "<%=request.getParameter("workflowId")%>";
	
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
    	if (orgIds == null || orgIds.length < 1){
    		alert('至少要有一个发布部门');
    		return;
    	}
        var condition = 'workflowId=' + workflowId + '&orgList=' + orgIds;
        var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AppriseAction?action=saveAppriseOrg&' + condition;
        var recode = PostInfo(strUrl, null);
        window.self.close();
    }
    
</script>
  
</html>
