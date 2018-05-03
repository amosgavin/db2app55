<%@page contentType="text/html; charset=gbk"%>
<%@page import="com.ai.appframe2.privilege.UserInfoInterface"%>
<%@page import="com.ai.appframe2.privilege.UserManagerFactory"%>
<%@page import="com.ai.appframe2.util.StringUtils"%>
<%@page import="com.ai.appframe2.complex.tab.id.BatchSequence"%>
<%@page import="com.ai.appframe2.complex.cache.CacheFactory"%>
<%@page import="com.ai.appframe2.complex.cache.impl.BatchIdGeneratorCacheImpl"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<SCRIPT language="JavaScript" src="<%=request.getContextPath()%>/jsv2/DBTreeXmlModel.js"></SCRIPT>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/FieldType_v2.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/DataType_v2.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/NormalRowSet.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/DBTree_v2.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/CommUtil.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/UIRelation_v2.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/Object_v2.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/PopMenu_v2.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/DataSource_v2.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/jsv2/AppFrameCss.jsp" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/sale/common/leftMenuCss.css" type="text/css">

<%
  UserInfoInterface user = SessionManager.getUser();
  long staffId = user.getID();
	System.out.println("staffId = "+ staffId);
	
%>
<DIV style="width: 150px; height: 100px; overflow-y: auto; overflow-x: auto; scrollbar-face-color: #D3E0F5; scrollbar-shadow-color: #fff; scrollbar-highlight-color: #fff; scrollbar-3dlight-color: #B9C5E3; scrollbar-darkshadow-color: #88AAE4; scrollbar-track-color: #EDF2FB; scrollbar-arrow-color: #88AAE4; position: absolute; top: 32px; left: 25px;"
	id="menuTreeDiv">
</DIV>
<body onLoad="resize()" onResize="resize()">
	<div class="title_tab_r"> 
	     <div class="title_tab_l">
			<div class="tab">
	            <a href="#" class="current" ><span>操作菜单</span></a>
	            <a href="#" ><span>&nbsp;</span></a>
	        </div>
	     </div>   
	</div>
	<table border="0" cellspacing="0" cellpadding="0" class="box" >
	
	  <tr>
	    <td class="box_l">&nbsp;</td>
	        <td class="box_c">
	          <table id="menuTable" width="100%" border="0" cellspacing="0" cellpadding="0" class="box1" height="600">
	              <tr>
	                <td class="box1_tl"></td>
	                <td class="box1_t"></td>
	                <td class="box1_tr"></td>
	              </tr>
	              <tr>
	                <td class="box1_l">&nbsp;</td>
	                <td class="box1_c">&nbsp;
					</td> 
	                <td class="box1_r" >&nbsp;</td>
	              </tr>
	              <tr>
	                <td class="box1_bl" ></td>
	                <td class="box1_b" ></td>
	                <td class="box1_br" ></td>
	              </tr>
	        </table>
		</td>
	    <td class="box_r">&nbsp;</td>
	  </tr>
	  <tr>
	    <td class="box_bl" height="5"></td>
	    <td class="box_b" height="5"></td>
	    <td class="box_br" height="5"></td>
	  </tr>
	</table> 


<%
		String xml = UserManagerFactory.getUserManager().getUserMenuXml(user.getCode(),"H",2);
       System.out.println(xml);
       out.print("<div style=\"display:none\" id=\"FUNC_INFO\">");
       out.print(xml);
       out.print("</div>");
%>
<%--<%--%>
<%--	   leftMenuDrawXml dx = new leftMenuDrawXml();--%>
<%--       String xml2 = dx.getUserMenuXmlSec(user.getCode(),"C",1);--%>
<%--       out.print("<div style=\"display:none\" id=\"FUNC_INFO2\">");--%>
<%--       out.print(xml2);--%>
<%--       out.print("</div>");--%>
<%--%>--%>



<%--  <table  border="0" cellspacing="0" cellpadding="0" >--%>
<%--  <tr>--%>
<%--    <td height="23"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="../../image/home/bg_l1.jpg">--%>
<%--      <tr>--%>
<%--        <td width="10"><img src="../../image/home/bg_l2.jpg" width="1" height="23"></td>--%>
<%--        <td><span style="color:#FFFFFF; line-height:20px; font-size:12px;"><small style=" float:right"><img src="../../image/home/a2.png" width="12" height="12" vspace="3"></small>操作菜单</span></td>--%>
<%--        <td width="3" align="right"><img src="../../image/home/bg_l2.jpg" width="1" height="23"></td>--%>
<%--      </tr>--%>
<%--    </table></td>--%>
<%--    <td width="5" rowspan="2" background="../../image/home/l1.gif"><img src="../../image/home/l1.gif" width="5" height="9"></td>--%>
<%--  </tr>--%>
<%--  <tr>--%>
<%--    <td>--%>

<%--</td>--%>
<%--  </tr>--%>
<%--</table>--%>
</body>
</HTML>
<script language="JavaScript" >
var menuTree = null;
var menuTree2 = null;
var model = null;
var model2 = null;

function openUrl(url,name){
  top.main.location = url;
}

function getUrlStr(id,mm){
   return _gModuleName+mm.getUserObject(id,"url");
}
function getImgStr(id,mm){
   return _gModuleName+mm.getUserObject(id,"img");
}

function Tree_DbClickListener(name)
 {  this.Name = name;
    this.execute = function(event)
    {
       var urlStr = getUrlStr(menuTree.getCurNodeValue(),model);
       var imgStr = getImgStr(menuTree.getCurNodeValue(),model);
       var aMenuId=menuTree.getCurNodeValue();
       var aMenuName=menuTree.getCurNodeText();
       openUrl(urlStr,aMenuName);
    }
 }

function Tree_DbClickListener2(name)
 {  this.Name = name;
    this.execute = function(event)
    {
       var urlStr = getUrlStr(menuTree2.getCurNodeValue(),model2);
       var imgStr = getImgStr(menuTree2.getCurNodeValue(),model2);
       var aMenuId=menuTree2.getCurNodeValue();
       var aMenuName=menuTree2.getCurNodeText();
       openUrl(urlStr,aMenuName);
    }
 }

function DBTreeLoad(xmlStr){
  model = createDBTreeXmlModel(xmlStr,"id1","caption","url,img");
  menuTree = new DBTree(model);
  menuTree.setSameNodeEvent(true);
  menuTree.setFolderEvent(false);
  menuTree.setRootEvent(false);
  menuTree.setAllowDragDrop(true);
  menuTree.displayTree();
  menuTree.addListener(S_OnChange,new Tree_DbClickListener(""));
  document.all.item("menuTreeDiv").appendChild(menuTree.getUIObject());
}

function DBTreeLoad2(xmlStr){
  model2 = createDBTreeXmlModel(xmlStr,"id2","caption","url,img");
  menuTree2 = new DBTree(model2);
  menuTree2.setSameNodeEvent(true);
  menuTree2.setFolderEvent(false);
  menuTree2.setRootEvent(false);
  menuTree2.setAllowDragDrop(true);
  menuTree2.displayTree();
  menuTree2.addListener(S_OnChange,new Tree_DbClickListener2(""));
  document.all.item("menuTreeDiv").appendChild(menuTree2.getUIObject());
}

function resize(){
  document.all("menuTreeDiv").style.height = document.body.offsetHeight-23;
  document.all("menuTreeDiv").style.width = document.body.offsetWidth-5;
  document.getElementById("menuTable").height = document.body.clientHeight-30;
}

window.onresize = resize;


DBTreeLoad(document.all.item("FUNC_INFO").innerHTML);
//DBTreeLoad2(document.all.item("FUNC_INFO2").innerHTML);
</script>
