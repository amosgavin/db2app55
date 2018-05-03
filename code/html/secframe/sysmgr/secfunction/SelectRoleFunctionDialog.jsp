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

//���ݸ�λ���Ͳ�ѯ�ø�λ���͵���ӵ�й���
function loadRoleFuncDetail()
{
	var sysfunctionTree = g_DBTreeNewManager.get("sysfunction_tree");
	sysfunctionTree.setCheckBoxSts(rootId, false);
	selRoleId = window.dialogArguments;
	if(selRoleId!=null || selRoleId !="")
	{
		// ��ȡ��ɫ��ǰ�����Ĳ˵�ID
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
        //alert("��ȡ�˵�IDS����");
        alert(g_I18NMessage("secframe_role_function" , "sec_role_function_catcherror"));
    }
}
//�����û��������޸�
function saveRoleFunc()
{
	setCheckedFuncIds();
	if (null == funcids)
	{
		return;
	}
	
	 var flag = PostInfotoServer( "<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecRoleAction?action=saveRoleFunction&roleId="+selRoleId,funcids);
	 if(flag=="OK"){
	 		//alert("�������ݳɹ�!");
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
			// ���ڵ���й���
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
		// ����Ƿ�Ҷ�ӽڵ�
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

//�ݹ������������нڵ��ѡ�л�ѡ�е�״̬
function setAllSubNodeSts(dbtree ,parentValue , isChecked)
{
	// ���û�ȡ�ӽڵ�������Ϊ10��(���޸ģ�Ϊ��֤�ܹ���ȡ���ڵ������е��ӽڵ�)
    setOffspringNodesSts(dbtree, parentValue,10,isChecked);
}

/**
 * Function Description:set all Offspring status of a tree node
 * Parameters��     pParentNodeVal:value of parentNode;childDeep:depth of this search;isChecked:check status
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

//�ݹ������ϼ����нڵ��ѡ�е�״̬
function setAllParNodeSts(dbtree ,curValue){
  var parentNode = dbtree.getParentNodeInfo(curValue);
  //alert(parentNode);
  //�ݹ�
  while(parentNode!=null){
    dbtree.setNodeChecked(parentNode.value,true);
    parentNode = dbtree.getParentNodeInfo(parentNode.value);
  }
}

//�ϲ��ڵ�
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
