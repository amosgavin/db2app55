<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page import="com.ai.bce.ivalues.IQModuleMenuRelateValue"%>
<%@ page import="com.ai.bce.configtool.service.interfaces.IConfModuleSV"%>
<%@ page import="com.ai.appframe2.service.ServiceFactory"%>

<%
	String module_id = HttpUtil.getAsString(request,"module_id");
	String module_name = HttpUtil.getAsString(request,"module_name");
	if(module_id == null || "".equals(module_id)==true){
		module_id = "-1";
	}
	
	IConfModuleSV sv = (IConfModuleSV)ServiceFactory.getService(IConfModuleSV.class);
	
	IQModuleMenuRelateValue[] menus = sv.getMenusByModuleId(module_id);
%>
<html>
<head>
<title>MENU</title>
<style>
body{background:#F0F3FA;}
ul,li{display:inline;margin:0;padding:0;}
.leftmenu_out {background:url(<%=request.getContextPath()%>/webframe/images/main/left_o.gif) repeat-x;color: #6186B0;width:200px;height:32px;padding-left:5px;cursor: hand;}
.leftmenu_over {background:url(<%=request.getContextPath()%>/webframe/images/main/left_h.gif) repeat-x;color: #578bc7;width:200px;height:32px;padding-left:5px;cursor: hand;}
</style>


<script> 
/*菜单点击方法*/
var oldElem = null;

function mOvrMenu(src){
	if(src!=oldElem){
	 src.className = 'leftmenu_over';
	}
}

function mClickMenu(src ,title,url ,topHeight){
	if(oldElem && src!=oldElem)
	  oldElem.className = 'leftmenu_out';
	  
	oldElem = src;  
	openframe( url ,title ,topHeight);
}

function mOutMenu(src){
	if(src!=oldElem){
	  src.className = 'leftmenu_out';
	}
}


function openframe(url ,pageTitle ,topHeight){ 
	clearIframe(window.parent.document.getElementById("frame_top"));
	clearIframe(window.parent.document.getElementById("frame_bottom")); 
	 
	if(topHeight !=null && topHeight !='' && topHeight !='null'){
		window.parent.document.getElementById("td_top").style.height=parseInt(topHeight);
	}else{
		window.parent.document.getElementById("td_top").style.height='410px';
	} 
	window.parent.frame_top.window.location=url +"?module_id=<%=module_id%>" ;
	window.parent.document.title = "<%=module_name%> -- "+pageTitle;
}

//写空格字符
function writeSpaceChar(number){
	try{
		number = parseInt(number);
	}catch(e){
		return;
	}
	
	for(i=1;i<number;i++){
		document.write("&nbsp;&nbsp;");
	}
}

</script>

</head>

<script language="javascript" src="js/configtool.js"></script>
<body>
<ul>
<%
	for(int i=0;i<menus.length;i++){
%>
  	<li onMouseOver="mOvrMenu(this)" onMouseOut="mOutMenu(this)" 
  	onClick="mClickMenu(this ,'<%=menus[i].getPageTitle()%>','<%=request.getContextPath() +  menus[i].getMenuUrl()%>' ,'<%=menus[i].getExt1()%>')" class="leftmenu_out">
   <script>writeSpaceChar('<%=menus[i].getMenuLevel()%>');</script> <img src="<%=request.getContextPath() + menus[i].getMenuIcon()%>" align="absmiddle"
    >&nbsp;<%=menus[i].getMenuName()%></li>
<%
	}
%>    
	
</ul>

</body>
</html>


