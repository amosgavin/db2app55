<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.appframe2.web.datamodel.CommonTreeModel"%>
<html>
<head>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/PopMenu_v2.js"></script>
<title>ģ��012</title>
<!--����/�Ҽ��˵��ṹģ��ҳ��˵�� -->
<!--
1����ģ�������ں���/�Ҽ��˵����ҽṹ��jspҳ�棻��߹̶���ȣ��ұ�����Ӧ��ȣ�
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
3����ѯ����ѯ����ֱ���ai:contractframe���÷ָ
4��ai:contractframeʹ��ע�⣺���������100%���߶�������������Ȼ�ſ���allowcontract���ԣ��Ƿ��������� Ĭ��true��ֵ��true/false����frameclosed���ԣ���ʼ��ʱ���������Ƿ��ڹر�״̬��Ĭ��false��ֵ��true/false��
5����ѯ���ai:tableʹ��ע�⣺���������100%���߶�������220������������10����pagesize="10"�������ж����������٣�
6����ťλ����ע�⣺��ѯ��ťʹ��css��class="td_button"����������ťʹ��css��class="area_button"��;���Ŷ����ť����ʱ���м����2��&nbsp;&nbsp;��
7�����Ŀ�Ȱ�����ai:contractframe/ai:tab�еĹ̶����������100%���߶�ai:contractframe��480��ai:tab��460��
8�����Ĳ�����ʽ��ע�⣺�ڰ�ť�ܶ࣬��ť���ֹ�������ʹ���Ҽ�ģʽ���籾ģ����ʾ������ť����һ�������Ҳ���ӵ��������£��뾡��ʹ�����Ű�ť�Ű��ʽ����ο�ģ��tab4.jsp��
9��ʹ���Ҽ��˵�������jsv2Ŀ¼�µ�PopMenu_v2.js��
 -->
</head>
<%
String rootUrl = "";
request.setAttribute(CommonTreeModel.ROOT_ID,"0");
request.setAttribute(CommonTreeModel.ROOT_NAME,"ϵͳ���");
request.setAttribute(CommonTreeModel.ROOT_URL,rootUrl);
request.setAttribute(CommonTreeModel.TREE_TYPE_ID,"30");
%>
<body>
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
         <tr>
           <td width="220" valign="top">
<ai:contractframe id="�ͻ��ṹ" contenttype="table" title="�ͻ��ṹ" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
<ai:dbtree_new id="menuTreeDiv" datamodel="com.ai.appframe2.web.datamodel.CommonTreeModel" width="100%" height="480" ishaveline="true" isdrag="true" onselect="" onrightclick="showPopMenu"/>
</ai:contractframe>
</td>
<td width="10"></td>
<td valign="top" align="right">
<ai:contractframe id="�ͻ��޸��б�" contenttype="table" title="�ͻ��޸��б�" width="100%" allowcontract="true" frameclosed="false">
  <ai:contractitem/>
<ai:table setname="com.ai.frame.attach.SETSysAttach" tableid="spselect"  
        needrefresh="true" editable="ture" initial="true" multiselect="true"
          pagesize="10" width="100%" height="220" ondblink="">
          <ai:col fieldname="ATTACH_ID" width="10%"/>
       		<ai:col fieldname="BUSI_SHEET_ID" width="15%" />
       		<ai:col fieldname="BUSI_TYPE_CODE" width="15%" />
       		<ai:col fieldname="REMARKS" width="30%" />
       		<ai:col fieldname="NAME" width="30%" />
           </ai:table>
</ai:contractframe>

<ai:contractframe id="�ͻ������޸�" contenttype="table" title="�ͻ������޸�" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td class="td_font">�ͻ����ƣ�</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
           <td class="td_font">��ϵ�绰��</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
		</tr>
		<tr>
           <td class="td_font">�ͻ����ԣ�</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
           <td class="td_font">��ϵ��ַ��</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
		</tr>
		<tr>
           <td class="td_font">�������룺</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">��ע��</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
      </table>
</ai:contractframe>

<div class="area_button">
  <ai:button text="������ť" id="query1" onclick="" />&nbsp;&nbsp;
  <ai:button text="�����ð�ť" id="query3" onclick="" enable="false" />
</div>
		</td>
	</tr>
</table>


</body>
</html>
<script language="javascript">
var dbtree = g_DBTreeNewManager.get("menuTreeDiv"); 
 
function pageOpen(){ 
var node = dbtree.getCurNodeInfo(); 
    var aMenuId=node.value;
        var aMenuName=node.text;
    var aurl  = node.userobj;
 
 
 if(dbtree.getChildrenNodesInfo(node.value).length==0){
alert("����[ " + node.text +" ]���ڽ����� ......");
return false;
  }
}
 var popMenu = null;
document.onclick = hidePopMenu;
//document.all.treeTD.oncontextmenu = treeRefresh;

function selectNode(newVal,newText,newUserObj,newNodeType){
}

function showPopMenu(treeVal,treeText,treeUserObj,treeNodeType){
    hidePopMenu();
    treeRefresh();
}

function hidePopMenu(){
  if(popMenu){
    popMenu.hidePopMenu();
  }
}

//ˢ����
function  treeRefresh(){
  hidePopMenu();
  var tmpGroupModel = new AIPopMenuModel();
  tmpGroupModel.addPopMenuItem("1","ˢ�µ�����",null,"rootRefresh");
  tmpGroupModel.addPopMenuItem("2","����",1,"rootRefresh");
  tmpGroupModel.addPopMenuItem("3","�޸�",1,"rootRefresh");
  tmpGroupModel.addPopMenuItem("4","ɾ��",1,"rootRefresh");
  tmpGroupModel.addPopMenuItem("1","ˢ�²˵�",null,"rootRefresh");
  tmpGroupModel.addPopMenuItem("1","ˢ��ҳ��",null,"rootRefresh");
  popMenu = new AIPopMenu(tmpGroupModel);
  popMenu.showPopMenu();
  return false;
}
function rootRefresh(){
  dbtree.refresh();
}

//ˢ�½ڵ�
function nodeRefresh(){
  var curNodeInfo = dbtree.getCurNodeInfo();
  if(curNodeInfo ==null){
    return;
  }
  var nodes = curNodeInfo.value.split("_");
  if(nodes.length==1){   //���ڵ�
    dbtree.refresh();
  }
  else if(nodes.length==2){  //��һ���ڵ�
    dbtree.refresh(curNodeInfo.value);
  }
  else if(nodes.length>2){   //ˢ�¸��ڵ�
    var start = 0;
    var end = curNodeInfo.value.lastIndexOf("_");
    dbtree.refresh(curNodeInfo.value.substr(start,end));
  }
}
</script>