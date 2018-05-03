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
<%
    String rootId = Constants.STR_FUNC_ROOT_ID;
%>
<body onLoad="closeTree();loadRoleFuncDetail();sysfunction_tree.setNodeSelect(<%=rootId%>);">
         <ai:contractframe id="" contenttype="table" title="sec.rolefunction.funcs" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>
            <table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
        			<tr>
         			  <td>
            <ai:dbtree_new id="sysfunction_tree" height="380" width="100%" datamodel="com.ai.secframe.sysmgr.web.SecRoleFunctionTreeModel" initial="false" ishaveline="true" multiselect="true" onwillexpand="selectFunc" oncheckboxclick="chkSelected" />
        </td>
                  </tr>
              </table>	
         </ai:contractframe>
         <div class="area_button">
				<ai:button id="saveBtn" text="sec.rolefunction.save" i18nRes="i18n.secframe_resource" onclick="saveRoleFunc()"/>&nbsp;&nbsp;
				<ai:button text="sec.rolefunction.cancel" i18nRes="i18n.secframe_resource" id="cancelBtn" onclick="cancel()"/>
         </div>
   
	</body>
</html>
<script type="text/javascript">
var rootId = "<%=rootId%>";
var sysfunction_tree = g_DBTreeNewManager.get("sysfunction_tree");
sysfunction_tree.setCheckBoxSts(rootId, false);
var selRoleId = "";
var funcids = "::";

//根据岗位类型查询该岗位类型的所拥有功能
function loadRoleFuncDetail()
{
	var sysfunctionTree = g_DBTreeNewManager.get("sysfunction_tree");
	sysfunctionTree.setCheckBoxSts(rootId, false);
	selRoleId = window.dialogArguments;
	if(selRoleId!=null || selRoleId !="")
	{
		// 获取角色当前关联的菜单ID
	    getFuncId(selRoleId);
		
  	    sysfunctionTree.setQueryCondtion("roleId="+selRoleId);
  	    var ud = sysfunctionTree.refresh(null,-1,"roleId="+selRoleId);
        closeTree();
	}else{
		var ud = sysfunctionTree.refresh(null,-1);
		var childNodes = sysfunctionTree.getChildrenNodesInfo(rootId);
		for(var i=0;i<childNodes.length;i++){
			sysfunctionTree.setCheckBoxSts(childNodes[i].value, false);
		}
	}
}

function setFuncIds(funcId, isChecked)
{
	if(isChecked){
		funcids = funcids.replace(":"+funcId+":",":");
		funcids = funcids + funcId +":";
	} else {
		funcids = funcids.replace(":"+funcId+":",":");
	}
}

function getFuncId(v)
{
    var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecRoleAction?"+
              "action=getFuncIds&roleId="+v);
    funcids = msg.getValueByName("retVal"); 
    if(funcids=="-1")
    {
        //alert("获取菜单IDS出错");
        alert(g_I18NMessage("secframe_role_function" , "sec_role_function_catcherror"));
    }
}
//保存用户所做的修改
function saveRoleFunc()
{
	setCheckedFuncIds();
	if (null == funcids)
	{
		return;
	}
	
	 var flag = PostInfotoServer( "<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecRoleAction?action=saveRoleFunction&roleId="+selRoleId,funcids);
	 if(flag=="OK"){
	 		//alert("保存数据成功!");
	 		alert(g_I18NMessage("secframe_role_function" , "sec_role_function_save_ok"));
			selFuncArray=null;
			window.returnValue = "ok";	
	        window.self.close();
	 } else {
			alert(flag);
	 }
}

function setCheckedFuncIds()
{
	var dbtree = g_DBTreeNewManager.get("sysfunction_tree");
	var checkedNodes = dbtree.getCheckedNodesInfo();
	if ((null != checkedNodes) && (0 < checkedNodes.length))
	{
		for(var i=0;i<checkedNodes.length;i++)
		{
			var value = checkedNodes[i].value;
			// 根节点进行过滤
			if (value != rootId)
			{
				setFuncIds(value, true);
			}
		}
	}
}

function selectFunc()
{
	var dbtree = g_DBTreeNewManager.get("sysfunction_tree");
	var node=dbtree.getCurNodeInfo();
	if(node==null) return ;
	var value=node.value;
	var roleId=-1;
	if(selRoleId!=null) roleId=selRoleId;
	dbtree.setQueryCondtion("roleId="+roleId);
}

function chkSelected(value,text,userobj,isChecked,nType)
{
	setFuncIds(value, isChecked);
	if(value!=rootId)
	{
		var dbtree = g_DBTreeNewManager.get("sysfunction_tree");
		// 如果是非叶子节点
		if(nType!=g_Tree_NODETYPE_LEAF)
		{
		    if(isChecked && window.confirm(g_I18NMessage("secframe_role_function" , "sec_role_function_confirmsel")))
		    {
			    setAllSubNodeSts(dbtree ,value ,true);
		    }else if(!isChecked && window.confirm(g_I18NMessage("secframe_role_function" , "sec_role_function_confirmdel")))
		    {
			    setAllSubNodeSts(dbtree ,value ,false);
		    }
		}
	    setAllParNodeSts(dbtree,value);
	}
}

//递归设置下属所有节点的选中或不选中的状态
function setAllSubNodeSts(dbtree ,parentValue , isChecked)
{
	// 设置获取子节点最大层数为10层(可修改，为保证能够获取父节点下所有的子节点)
    setOffspringNodesSts(dbtree, parentValue,10,isChecked);
}

/**
 * Function Description:set all Offspring status of a tree node
 * Parameters：     pParentNodeVal:value of parentNode;childDeep:depth of this search;isChecked:check status
 * Creator:xuehao
 * Create Date:2011-6-24
 */
function setOffspringNodesSts(dbtree, pParentNodeVal,childDeep,isChecked)
{
   var selNode =  DBTreeNew_Public_getNodeByValue(dbtree.DBTreeID,pParentNodeVal);
   if(selNode)
   {  
	 if(childDeep==-1)
		 dbtree.buildChildNode(selNode,30,dbtree.queryCondtion); 
	 else
		 dbtree.buildChildNode(selNode,childDeep,dbtree.queryCondtion); 
     if(selNode.nType!=g_Tree_NODETYPE_LEAF)
     {
	     var parentNodeChildDivObj = dbtree.getChildNodeDivObj(selNode.id);
	     var tableObjArray = parentNodeChildDivObj.all.tags("TABLE"); 
	     for(var i=0;i<tableObjArray.length;i++)
	     { 
		     var sId = tableObjArray.item(i).id+"_CB";
		     var obj = document.getElementById(sId); 
		     obj.checked = isChecked;
		     setFuncIds(tableObjArray.item(i).I, isChecked);
		}
     }
   }
}

//递归设置上级所有节点的选中的状态
function setAllParNodeSts(dbtree ,curValue){
  var parentNode = dbtree.getParentNodeInfo(curValue);
  //alert(parentNode);
  //递归
  while(parentNode!=null){
    dbtree.setNodeChecked(parentNode.value,true);
    parentNode = dbtree.getParentNodeInfo(parentNode.value);
  }
}

//合并节点
function closeTree(){
  var arr = sysfunction_tree.getChildrenNodesInfo(rootId);
  
  if(arr==null){
    return;
  } 
  for(i=0;i<arr.length;i++){
    sysfunction_tree.expandNodeByValue(arr[i].value,false);
  }
}

function cancel(){	
	window.self.close();
}
</script>
