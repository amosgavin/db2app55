<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>

<% 
	
	//展现其它窗口的时候的打开方式
	String openType = HttpUtil.getAsString(request ,"openType"); 
	
		//是否展现基本信息
	String showDetail = HttpUtil.getAsString(request ,"showDetail");

	//是否展现图表树形信息
	String showChart = HttpUtil.getAsString(request ,"showChart"); 
	
	
	String select_page = HttpUtil.getAsString(request ,"select_page"); 
	String select_page_title = HttpUtil.getAsString(request ,"select_page_title");
	
	String module_id = HttpUtil.getAsString(request ,"module_id");
	String module_name = HttpUtil.getAsString(request ,"module_name");
%>

<html>
<head>
<script language="javascript" src="<%=request.getContextPath()%>/bce/configtool/common/js/configtool.js"></script>

<script>
 
/* 隐藏/显示左边菜单 */
function changLeftBar(){
  if (document.all.frame_left.style.display==''){
  	document.all.frame_left.style.display='none';
  	document.all.arrow_left.style.backgroundImage="url(<%=request.getContextPath()%>/webframe/images/main/arrow_right.gif)";
  	document.all.left.style.width="20px";
  } else if(document.all.frame_left.style.display=='none'){
  	document.all.frame_left.style.display='';
  	document.all.arrow_left.style.backgroundImage="url(<%=request.getContextPath()%>/webframe/images/main/arrow_left.gif)";
  	document.all.left.style.width="200px";
  }
  document.all.left_arrow_div.style.width=document.all.left.style.width;
}

//当前模块的ID
var module_id ="<%=module_id%>";
</script>

<title>
<%=module_name %> -- Business Frame
</title>
<style>
#left_arrow_div{ position:absolute; top:8px; left:0;height:24px; text-align:right; padding-right:3px; }
a.button{ background:url(<%=request.getContextPath()%>/webframe/images/main/arrow_right.gif) left top;display:block;width:14px;height:15px;border:0;}
a.button:hover{background-position:right top;}
</style>
</head>

<body>
<div id="left_arrow_div" style="width:20px;"><a href="#" id="arrow_left" onClick="changLeftBar()" class="button" onFocus="this.blur()"></a></div>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
	<tr valign="top">
		<td rowspan=2 width="20" height="100%" id="left"> 
		<iframe name="frame_left" src="<%=request.getContextPath()%>/bce/configtool/common/menu.jsp?module_id=<%=module_id%>&module_name=<%=module_name%>" id="frame_left" style="display:none" frameborder="0" width="100%" height="100%"></iframe> 
		</td>
		<td height="400" id="td_top">
		<iframe name="frame_top" id="frame_top" src="<%=request.getContextPath()%>/bce/configtool/bceframe/index_top.jsp?module_id=<%=module_id%>" frameborder="0" width="100%" height="100%"></iframe> 
		</td>
	</tr>
	<tr valign="top">
		<td>
		<iframe name="frame_bottom" id="frame_bottom" frameborder="0" width="100%" height="100%"></iframe>
		</td>
	</tr>
</table>
</body>
</html>


