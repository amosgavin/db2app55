<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.appframe2.web.datamodel.CommonTreeModel"%>
<html>
<head>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/PopMenu_v2.js"></script>
<title>模板012</title>
<!--含树/右键菜单结构模板页面说明 -->
<!--
1、本模板适用于含树/右键菜单左右结构的jsp页面；左边固定宽度，右边自适应宽度；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、查询及查询结果分别用ai:contractframe套用分割；
4、ai:contractframe使用注意：宽度请设置100%，高度由里面内容自然撑开；allowcontract属性（是否允许收缩 默认true，值：true/false）；frameclosed属性（初始化时内容区域是否处于关闭状态，默认false，值：true/false）
5、查询结果ai:table使用注意：宽度请设置100%，高度请设置220，条数请设置10条（pagesize="10"），若有多项可酌情减少；
6、按钮位置请注意：查询按钮使用css（class="td_button"）；操作按钮使用css（class="area_button"）;并排多个按钮存在时，中间请加2个&nbsp;&nbsp;；
7、树的宽度按所在ai:contractframe/ai:tab中的固定宽度中设置100%，高度ai:contractframe中480，ai:tab中460；
8、树的操作方式请注意：在按钮很多，按钮文字过长，请使用右键模式，如本模板所示；若按钮可以一排排完且不显拥挤的情况下，请尽量使用下排按钮排版格式，请参考模板tab4.jsp；
9、使用右键菜单需引用jsv2目录下的PopMenu_v2.js；
 -->
</head>
<%
String rootUrl = "";
request.setAttribute(CommonTreeModel.ROOT_ID,"0");
request.setAttribute(CommonTreeModel.ROOT_NAME,"系统监控");
request.setAttribute(CommonTreeModel.ROOT_URL,rootUrl);
request.setAttribute(CommonTreeModel.TREE_TYPE_ID,"30");
%>
<body>
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
         <tr>
           <td width="220" valign="top">
<ai:contractframe id="客户结构" contenttype="table" title="客户结构" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
<ai:dbtree_new id="menuTreeDiv" datamodel="com.ai.appframe2.web.datamodel.CommonTreeModel" width="100%" height="480" ishaveline="true" isdrag="true" onselect="" onrightclick="showPopMenu"/>
</ai:contractframe>
</td>
<td width="10"></td>
<td valign="top" align="right">
<ai:contractframe id="客户修改列表" contenttype="table" title="客户修改列表" width="100%" allowcontract="true" frameclosed="false">
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

<ai:contractframe id="客户属性修改" contenttype="table" title="客户属性修改" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td class="td_font">客户名称：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
           <td class="td_font">联系电话：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
		</tr>
		<tr>
           <td class="td_font">客户属性：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
           <td class="td_font">联系地址：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
		</tr>
		<tr>
           <td class="td_font">邮政编码：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">备注：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
      </table>
</ai:contractframe>

<div class="area_button">
  <ai:button text="正常按钮" id="query1" onclick="" />&nbsp;&nbsp;
  <ai:button text="不可用按钮" id="query3" onclick="" enable="false" />
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
alert("功能[ " + node.text +" ]正在建设中 ......");
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

//刷新树
function  treeRefresh(){
  hidePopMenu();
  var tmpGroupModel = new AIPopMenuModel();
  tmpGroupModel.addPopMenuItem("1","刷新导航树",null,"rootRefresh");
  tmpGroupModel.addPopMenuItem("2","新增",1,"rootRefresh");
  tmpGroupModel.addPopMenuItem("3","修改",1,"rootRefresh");
  tmpGroupModel.addPopMenuItem("4","删除",1,"rootRefresh");
  tmpGroupModel.addPopMenuItem("1","刷新菜单",null,"rootRefresh");
  tmpGroupModel.addPopMenuItem("1","刷新页面",null,"rootRefresh");
  popMenu = new AIPopMenu(tmpGroupModel);
  popMenu.showPopMenu();
  return false;
}
function rootRefresh(){
  dbtree.refresh();
}

//刷新节点
function nodeRefresh(){
  var curNodeInfo = dbtree.getCurNodeInfo();
  if(curNodeInfo ==null){
    return;
  }
  var nodes = curNodeInfo.value.split("_");
  if(nodes.length==1){   //根节点
    dbtree.refresh();
  }
  else if(nodes.length==2){  //第一级节点
    dbtree.refresh(curNodeInfo.value);
  }
  else if(nodes.length>2){   //刷新父节点
    var start = 0;
    var end = curNodeInfo.value.lastIndexOf("_");
    dbtree.refresh(curNodeInfo.value.substr(start,end));
  }
}
</script>