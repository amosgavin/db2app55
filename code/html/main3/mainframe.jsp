<%@ page contentType="text/html; charset=GBK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>湖北移动营销管理平台</title>
</head>
<%
	String visitType = request.getParameter("visitType");
 %>
<frameset rows="70,*" cols="*" framespacing="0" frameborder="no" border="0">

  <frameset rows="*" cols="20%,60%,20%" framespacing="0" frameborder="no" border="0">
   <frame src="leftframe/leftmenu.jsp" name="mainFrame" scrolling="yes" marginwidth="0" marginheight="0" id="mainFrame" title="mainFrame" />
   <frame src="right.jsp"  name="main"  frameborder="no" scrolling="auto" marginwidth="0" marginheight="0" />
   <frame src="message.jsp"  name="message"  frameborder="no" scrolling="auto" marginwidth="0" marginheight="0" id="message" title="message" />
  </frameset>
</frameset>
<noframes>
<body>

</body>
</noframes></html>

<script type="text/javascript">
	function toMainPage(){
		parent.document.getElementById("main").src = "<%=request.getContextPath()%>/main3/right.jsp";
	}

   function downloadSystemHelpFile(){
      var window_url = "<%=request.getContextPath()%>/help/zjsalehelp.jsp";
	  window.open(window_url , null , "height=100, width=600, top=300, left=200, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
   }
</script>
