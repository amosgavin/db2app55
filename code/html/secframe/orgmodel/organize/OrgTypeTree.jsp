<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body>
              <ai:contractframe id="" contenttype="table" title="sec.organize.typeselect" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
              <ai:contractitem/>
              <table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
        			<tr>
         			  <td>
              <ai:dbtree_new 
                 id="tree" height="350"  
                 datamodel="com.ai.secframe.orgmodel.web.SecOrgTypeTreeModel" 
 				 initial="true" ishaveline="true" width="100%"  multiselect="false" 
                 onselect="select" onwillexpand="onwillexpand" ondblclick="oncommit" />
                 </td>
                  </tr>
              </table>	
              </ai:contractframe> 
              
				<div class="area_button">
				<ai:button text="sec.organize.selected" i18nRes="i18n.secframe_resource"  id="affirm" onclick="oncommit()"/>
				&nbsp;
				<ai:button  text="sec.organize.cancel" i18nRes="i18n.secframe_resource" id="cancel" onclick="onclose()"/>
                </div>
</body>
<script language="javascript">
function select(){
	return;
	
	var conStr = "";
	
	var dbtree = g_DBTreeNewManager.get("tree");
	var curNode = dbtree.getCurNodeInfo();
	if(curNode== null)
		return;
	
	conStr ="STATE=1 and FUNC_ID="+curValue ;
}

function oncommit(){    
    var dbtree = g_DBTreeNewManager.get("tree");
	var curNode = dbtree.getCurNodeInfo();
	if(curNode== null)
		return;
		
    window.returnValue = curNode.value+"|"+curNode.text;
    top.close();
} 

//��ѡ,����""  ֻΪ������ʹ��
function onnoselect(){
	window.returnValue = "clear";
	top.close();
}

//�رմ��� ֻΪ������ʹ��
function onclose(){
	//window.returnValue = "";
	top.close();
}

//�ڵ�չ���¼�
function onwillexpand(){
}

//�ϲ��ڵ�
function closeTree(){
  var dbtree = g_DBTreeNewManager.get("tree");
  var arr = dbtree.getChildrenNodesInfo(1);
  if(arr==null){
    return;
  }
  
  for(i=0;i<arr.length;i++){
    dbtree.expandNodeByValue(arr[i].value,false);
  }
  
  dbtree.setNodeSelect(1);
}

function refreshTree(){
   var dbtree = g_DBTreeNewManager.get("tree");
   var ud = dbtree.refresh(null,-1);
}
</script>
</html>
