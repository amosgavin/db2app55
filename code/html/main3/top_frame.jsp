<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>top</title>
<link href="css/home.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	background:url(../image/home/header_r.gif) no-repeat top right;
}
#apDiv2 {
	position:absolute;
	left:0px;
	z-index:2;
	top:0px;
	}
#apDiv3 {
	position:absolute;
	right:20px;
	z-index:3;
	top:59px;
	}
.tools_bar{
   float:right;
   margin-top:10px;
   margin-right:20px;
}
.icon{
	display:inline-block;
	}
.icon_home{
	background:url(../image/home/icon_home.gif)  no-repeat center top ;

	padding:35px 0 0 0px;
	color:white;
	text-decoration:none;

	}	
.icon_help{
	background:url(../image/home/icon_help.gif)  no-repeat center top ;

	padding:35px 0 0 0px;
	color:white;
	text-decoration:none;

	}	
	.icon_logout{
	background:url(../image/home/icon_logout.gif)  no-repeat center top ;

	padding:35px 0 0 0px;
	color:white;
	text-decoration:none;

	}	
		.tools_bar span{
	background:url(../image/home/header_lines.gif)  no-repeat center top ;
  width:10px;
  height:58px;
margin:0 8px 0 8px;
display:inline-block;

	}			
</style>
<script src="../Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
</head>

<body>
<div id="apDiv2"><img src="../image/home/header_l.gif" width="514" height="79" /></div>
<div class="tools_bar"><a class="icon icon_home" href="#" onclick="toMainPage();">返回首页</a><span></span><a class="icon icon_logout" href="Loginout.jsp">注销</a><span></span><a class="icon icon_help" href="#" onclick="downloadSystemHelpFile();">帮助</a></div>

</body>
</html>
<script type="text/javascript">
	function toMainPage(){
		parent.document.getElementById("main").src = "<%=request.getContextPath()%>/main3/right.jsp";
	}

   function downloadSystemHelpFile(){
      var window_url = "<%=request.getContextPath()%>/help/zjsalehelp.jsp";
	  window.open(window_url , null , "height=100, width=600, top=300, left=200, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
   }
</script>