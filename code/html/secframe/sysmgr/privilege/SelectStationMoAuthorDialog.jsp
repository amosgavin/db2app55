<%@ page contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.secframe.common.Constants"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title></title>
	</head>
<body onLoad="closeTree();selectStation();">
<%
    String rootId = Constants.STR_FUNC_ROOT_ID;
%>
         <ai:contractframe id="" contenttype="table" title="sec.stationmoauthor.selstationauthor" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>
            <table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
        			<tr>
         			  <td>
            <ai:dbtree_new id="funcMoTree" datamodel="com.ai.secframe.sysmgr.web.SecStationFunctionMoDataModel" 
								multiselect="true" height="380" width="100%" ishaveline="true" 
								onwillexpand="expandFuncMoTree()" oncheckboxclick="setCheckStatus()"/>
								</td>
                  </tr>
              </table>	
         </ai:contractframe>
         <div class="area_button">
               <table>
               <tr>
                <td>
				<ai:button id="saveMoStAuthor" text="sec.stationmoauthor.save" i18nRes="i18n.secframe_resource" onclick="saveMoStationAuthor()"/>
				</td>
				<td>
				<ai:button text="sec.stationmoauthor.cancel" i18nRes="i18n.secframe_resource" id="cancelBtn" onclick="cancel()"/>
				</td>
				</tr>
			   </table>
         </div>
	</body>
</html>
<script type="text/javascript">
    var rootId = "<%=rootId%>"; 
    var selStationId="";
    /**
	 * ����ѡ�еĸ�λ��ʼ���˵�MO��
	 */
	function selectStation()
	{
		selStationId = window.dialogArguments;
		if(selStationId != null)
		{
			closeTree();
			loadFuncMoTree(selStationId);
		}
	}
	/**
	 * �����˵�MO��
	 */
	function closeTree()
	{
		var funcMoTree = g_DBTreeNewManager.get("funcMoTree");
		var arr = funcMoTree.getChildrenNodesInfo(rootId);
        if(arr==null)
        {
           return;
        }
        for(i=0;i<arr.length;i++)
        {
           
           funcMoTree.expandNodeByValue(arr[i].value,false);
        }
	}
	/** 
	 * ����MO��λ��Ȩ��Ϣ
	 */
	function saveMoStationAuthor()
	{
    	var funcMoTree = g_DBTreeNewManager.get("funcMoTree");
    	var selNodeArray = funcMoTree.getCheckedNodesInfo();
    	// ��װ
		var moIds = "";
		var moNames = "";
   		for(var i=0; i < selNodeArray.length; i++)
   		{
   			var curNode = selNodeArray[i];
   			if(curNode != null && curNode.userobj == "ISMO")
   			{
  					moIds = moIds+curNode.value+",";
  					moNames = moNames+curNode.text+",";
   			}
   		}
   		// ����
  			var param = "&stationId="+selStationId+"&moIds="+moIds+"&moNames="+moNames;
  			var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.PrivilegeAction?action=saveMoStationAuthor"+param);
  			if(msg != null)
  			{
  				var retVal = msg.getValueByName("retVal");
		    if(retVal == 1 || retVal == "1")
		    {
		    	//alert("����ɹ���");
		    	alert(g_I18NMessage("secframe_stationmoauthor" , "secframe_stationmoauthor_saveok"));
		    	window.returnValue = "ok";	
	            window.self.close();
		    }
		    else
		    {
		    	var retMsg = msg.getValueByName("retMsg");
		    	//alert("����ʧ�ܣ�"+", "+retMsg);
		    	alert(g_I18NMessage("secframe_stationmoauthor" , "secframe_stationmoauthor_saveerror")+", "+retMsg);
		    }
  			}

	}
	/**
	 * ���ز˵�MO��
	 */
	function loadFuncMoTree(stId)
	{
		var funcMoTree = g_DBTreeNewManager.get("funcMoTree");
		funcMoTree.refresh(rootId, -1, "stationId="+stId);
		setStatus(rootId);		
	}
	function setStatus(nodeValue)
	{
	    var funcMoTree = g_DBTreeNewManager.get("funcMoTree");
		var childNodes = funcMoTree.getChildrenNodesInfo(nodeValue);
		for(var i=0; i < childNodes.length; i++)
		{	    
		    
			if(childNodes[i].userobj != null && childNodes[i].userobj == "ISMO")
			{		
			       
				funcMoTree.setCheckBoxSts(childNodes[i].value, true);
			}
			else
			{	 
				funcMoTree.setCheckBoxSts(childNodes[i].value, false);
				setStatus(childNodes[i].value);			
			}
		} 
       funcMoTree.setCheckBoxSts(nodeValue, false);
	}
	/**
	 * չ���˵�MO��
	 */
	function expandFuncMoTree()
	{
		var funcMoTree = g_DBTreeNewManager.get("funcMoTree");
		var curNode = funcMoTree.getCurNodeInfo();
		if(curNode != null)
		{
			var childNodes = funcMoTree.getChildrenNodesInfo(curNode.value);
			if(childNodes[i].userobj != null && childNodes[i].userobj == "ISMO")
			{
				funcMoTree.setCheckBoxSts(childNodes[i].value, true);
			}
			else
			{
				funcMoTree.setCheckBoxSts(childNodes[i].value, false);
			}
		}
	}
	/**
	 * ���õ�ǰ�ڵ��״̬�������MO��ɲ��������򲻿ɲ���
	 */
	function setCheckStatus()
	{
		var funcMoTree = g_DBTreeNewManager.get("funcMoTree");
		var curNode = funcMoTree.getCurNodeInfo();
		if(curNode != null && curNode.userobj != "ISMO")
		{
			funcMoTree.setNodeChecked(curNode.value, false);
		}
	}
	
function cancel(){	
	window.self.close();
}
</script>