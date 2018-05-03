<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>

<HTML>
<HEAD>
<TITLE>
 <i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.objectItemRelate18"></i18n:message></TITLE>
</HEAD>
<BODY>
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
<tr>
   <td width="260" valign="top">             
		<ai:contractframe title="comframe.html.workflow.autoform.ObjectItemTree21" id="comframe.html.workflow.autoform.ObjectItemTree21" width="100%" height="100%" i18nRes="i18n.comframe_resource" allowcontract="false">
		<ai:contractitem></ai:contractitem>  
		<ai:dbtree_new id="objectItemTree" datamodel="com.ai.comframe.autoform.web.ObjectItemTree" ishaveline="true"
		  multiselect="false" height="520px" width="240px" onselect="showObjectItemInfo" onrightclick="showItemTreeMenu"/>
		</ai:contractframe>  
	</td>
	<td width="10"></td>
	<td valign="top" align="right">
	<iframe id="objectInfoMain" src="ObjectInfoMain.jsp" style="width:100%;height:560px;"  frameborder="0"></iframe>
	</td>
</tr>
</table>
</BODY>
</HTML>
<script language="JavaScript">
var objectItemTree = g_DBTreeNewManager.get("objectItemTree");
var OBJECT_ITEM_ID=-1;
var OBJECT_ITEM_CODE=g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_ObjectItemTree45");
function refreshNode(){
  var aNodeObj=objectItemTree.getCurNodeInfo();
  var aNodeValue=aNodeObj.value;
  objectItemTree.refresh(aNodeValue,1);
}


function getNodeUserObject(aNodeObj){
  var aUserObj=new Object();
  var aNodeText=aNodeObj.text;
  var aNodeValue=aNodeObj.value;
  var aNodeUserObjStr=aNodeObj.userobj;

  if (aNodeUserObjStr!=null&&aNodeUserObjStr!=""){
    var aListAry=aNodeUserObjStr.split(",");
    if (aListAry!=null&&aListAry.length>0){
	for (var i=0;i<aListAry.length;i++){
	  var aNameValue=aListAry[i];
	  if (aNameValue!=null&&aNameValue!=""){
	    var aNameValueAry=aNameValue.split("=");
	    if (aNameValueAry!=null&&aNameValueAry.length>0){
	      var aName=aNameValueAry[0];
	      var aValue=aNameValueAry[1];
	      if (aName=="OBJECT_ITEM_TYPE_CODE"){
		aUserObj.OBJECT_ITEM_TYPE_CODE=aValue;
	      }else if (aName=="OBJECT_ITEM_KIND_ID"){
		aUserObj.OBJECT_ITEM_KIND_ID=aValue;
	      }else if (aName=="OBJECT_ITEM_ID"){
		aUserObj.OBJECT_ITEM_ID=aValue;
	      }else if (aName=="OBJECT_NODE_TYPE"){
		aUserObj.OBJECT_NODE_TYPE=aValue;
	      }
	    }
	  }
	}
    }
  }
  return aUserObj;
}

function showObjectItemInfo(){
  var aNodeObj=objectItemTree.getCurNodeInfo();
  var aNodeText=aNodeObj.text;
  var aNodeValue=aNodeObj.value;
  var aUserObj=getNodeUserObject(aNodeObj);
  if (aUserObj.OBJECT_NODE_TYPE!=null&&aUserObj.OBJECT_NODE_TYPE=="OBJECT_ITEM"){
    var aObjectItemId=aUserObj.OBJECT_ITEM_ID;
    var aObjectItemKindId=aUserObj.OBJECT_ITEM_KIND_ID;
    objectInfoMain.refreshTab(aUserObj.OBJECT_ITEM_ID,aUserObj.OBJECT_ITEM_TYPE_CODE,aNodeText,aObjectItemKindId);
  }
}

/**以下为右键菜单*/
var ItemTreeModel = new AIPopMenuModel();
var ItemTreeMenu;

/**右键菜单相关功能*/
function addItemKind(){
  var aNodeObj=objectItemTree.getCurNodeInfo();
  if (aNodeObj==null){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_objectItemRelate341"));    return;
  }

  var aNodeText=aNodeObj.text;
  var aNodeValue=aNodeObj.value;
  var aUserObj=getNodeUserObject(aNodeObj);
  var aParentKindId=0;
  var aItemKindCode=aUserObj.OBJECT_ITEM_TYPE_CODE;
  if (aUserObj.OBJECT_NODE_TYPE=="OBJECT_ITEM_KIND"){
    aParentKindId=aUserObj.OBJECT_ITEM_KIND_ID;
  }
  var param="?ITEM_KIND_ID=-1"+"&ITEM_TYPE="+aItemKindCode+"&PARENT_ITEM_KIND_ID="+aParentKindId;
  var r=window.showModalDialog("AddObjectItemKind.jsp"+param,window,
  "scroll:no;resizable:no;status:no;dialogHeight:250px;dialogWidth:250px");
  refreshNode();

}

function delItemKind(){
  var aNodeObj=objectItemTree.getCurNodeInfo();
  if (aNodeObj==null){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_objectItemRelate341"));    return;
  }
  var aNodeText=aNodeObj.text;
  var aNodeValue=aNodeObj.value;
  if (confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_ObjectItemTree137"))==false){    return;
  }

  var aUserObj=getNodeUserObject(aNodeObj);
  var aKindId=aUserObj.OBJECT_ITEM_KIND_ID;
  var param="&KIND_ID="+aKindId;
  var resu=PostInfo('<%=request.getContextPath()%>/business/com.ai.comframe.autoform.web.AutoFormAction?action=deleteObjectItemKind'+param,"").getValueByName("retValue");
  var aResu=resu.substr(0,1);
  var aMsg=resu.substr(1,resu.length);
  alert(aMsg);
  if (aResu=="Y"){
    var aParentNode=objectItemTree.getParentNodeInfo(aNodeValue);
    objectItemTree.refresh(aParentNode.value,1);
    objectInfoMain.refreshTab("-1",aUserObj.OBJECT_ITEM_TYPE_CODE,"",aKindId);
  }

}

function addItem(){
  var aNodeObj=objectItemTree.getCurNodeInfo();
  if (aNodeObj==null){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_objectItemRelate341"));    return;
  }
  var aNodeText=aNodeObj.text;
  var aNodeValue=aNodeObj.value;
  var aUserObj=getNodeUserObject(aNodeObj);
  var aItemType=aUserObj.OBJECT_ITEM_TYPE_CODE;
  var aItemKindId=aUserObj.OBJECT_ITEM_KIND_ID;
  objectInfoMain.refreshTab("-1",aItemType,"",aItemKindId);
}

function delItem(){
  var aNodeObj=objectItemTree.getCurNodeInfo();
  if (aNodeObj==null){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_objectItemRelate341"));    return;
  }
  var aUserObj=getNodeUserObject(aNodeObj);
  var aObjectItemId=aUserObj.OBJECT_ITEM_ID;
  var aNodeValue=aNodeObj.value;
  var aNodeText=aNodeObj.text;
  if (!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_ObjectItemTree179"))){    
	  return;
  }
  var param="&OBJECT_ITEM_ID="+aObjectItemId;
  var resu=PostInfo('<%=request.getContextPath()%>/business/com.ai.comframe.autoform.web.AutoFormAction?action=deleteObjectItem'+param,"").getValueByName("retValue");
  var aResu=resu.substr(0,1);
  var aMsg=resu.substr(1,resu.length);
  if (aResu=="Y"){
    var aParentNode=objectItemTree.getParentNodeInfo(aNodeValue);
    objectItemTree.refresh(aParentNode.value,1);
    objectInfoMain.refreshTab("-1",aUserObj.OBJECT_ITEM_TYPE_CODE,"",aUserObj.OBJECT_ITEM_KIND_ID);
  }
}

function createMenu(){
    /** 增加一个菜单项
   **/
     ItemTreeModel.addPopMenuItem("addItemKind",g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_ObjectItemTree199"),null,"addItemKind()");     
     ItemTreeModel.addPopMenuItem("delItemKind",g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_ObjectItemTree200"),null,"delItemKind()");     
     ItemTreeModel.addPopMenuItem("addItem",g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_ObjectItemTree201"),null,"addItem()");     
     ItemTreeModel.addPopMenuItem("delItem",g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_ObjectItemTree202"),null,"delItem()");
     

     ItemTreeMenu = new AIPopMenu(ItemTreeModel);
     document.onclick=hideItemTreeMenu;
}

function showPopMenu(){
        popMenu.showItemTreeMenu();
}
function hideItemTreeMenu(){
        if(ItemTreeMenu)
                ItemTreeMenu.hidePopMenu();
}

function showItemTreeMenu(){
  var aNodeObj=objectItemTree.getCurNodeInfo();
  if (aNodeObj==null){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_objectItemRelate341"));    return;
  }
  var aNodeText=aNodeObj.text;
  var aNodeValue=aNodeObj.value;
  var aUserObj=getNodeUserObject(aNodeObj);
  if(aNodeValue == "-1")
	  return;
  //先禁用所有的菜单
  ItemTreeMenu.setItemEnabledById("addItemKind",false);
  ItemTreeMenu.setItemEnabledById("delItemKind",false);
  ItemTreeMenu.setItemEnabledById("addItem",false);
  ItemTreeMenu.setItemEnabledById("delItem",false);
  //根据当前节点情况判断是否显示对应的菜单
  if (aUserObj.OBJECT_NODE_TYPE=="OBJECT_ITEM"){
    ItemTreeMenu.setItemEnabledById("delItem",true);
  }else if (aUserObj.OBJECT_NODE_TYPE=="OBJECT_ITEM_TYPE"){
    ItemTreeMenu.setItemEnabledById("addItemKind",true);
  }else{
    //分类
    //如果是最后一级分类，才允许增加元件
    var aAryChildNode=objectItemTree.getChildrenNodesInfo(aNodeValue);
    var aCont=false;
    if (aAryChildNode==null||aAryChildNode==""||aAryChildNode.length==0){
      aCont=true;
      ItemTreeMenu.setItemEnabledById("addItemKind",true);
      ItemTreeMenu.setItemEnabledById("delItemKind",true);
    }else{
      if (aAryChildNode!=null&&aAryChildNode.length>=0){
        var aFirstChild=aAryChildNode[0];
        var aFirstChildUserObj=getNodeUserObject(aFirstChild);
        if (aFirstChildUserObj.OBJECT_NODE_TYPE=="OBJECT_ITEM"){
          aCont=true;
        }else{
          ItemTreeMenu.setItemEnabledById("addItemKind",true);
        }
      }
    }
    if (aCont==true){
      ItemTreeMenu.setItemEnabledById("addItem",true);
    }
  }
  ItemTreeMenu.showPopMenu();
}
//创建菜单
createMenu();
</script>
