<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<HTML>
<HEAD>
<link rel="stylesheet" href="<%=request.getContextPath()%>/webframe/css/WebStyle.jsp" type="text/css">
<script language="javascript">
var CURRENT_TAB_NAME = "object_detail_info";
var objectItemId = "";
var objectItemName = "";
var objectItemType = "";
function getCurrentTabName(){
  return CURRENT_TAB_NAME;
}
function getParam(aTabName){
  CURRENT_TAB_NAME=aTabName;
  return "OBJECT_ITEM_ID="+objectItemId+"&OBJECT_ITEM_TYPE="+objectItemType
  +"&OBJECT_ITEM_NAME="+objectItemName+"&OBJECT_ITEM_KIND_ID="+objectItemKindId;
}

function refreshTab(pObjectItemId,pObjectItemType,pObjectItemName,pObjectItemKindId)
{
  objectItemId = pObjectItemId;
  objectItemName = pObjectItemName;
  objectItemType = pObjectItemType;
  objectItemKindId=pObjectItemKindId;
  if (!CURRENT_TAB_NAME)
    {
	    CURRENT_TAB_NAME="";
    }
    if (CURRENT_TAB_NAME!="")
    {
	    setTabItem("object_tab",CURRENT_TAB_NAME);
    }
    else
    {
	    setTabItem("object_tab","object_detail_info");
    }
}

function close(){
    setTabItem("object_tab","object_detail_info");
}

</script></HEAD>
<BODY>

<ai:tab id="object_tab" height="100%" width="100%" getParameter="getParam" type="H">
	<ai:tabitem id="object_detail_info" src="ObjectItemDetail.jsp" i18nRes="i18n.comframe_resource" title="comframe.html.workflow.autoform.objectInfoMain13" ></ai:tabitem>	
		      
</ai:tab>
</BODY>
</HTML>


