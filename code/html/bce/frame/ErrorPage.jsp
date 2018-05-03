<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/bce/frame/BceFrameHead.jsp"%>
<%
    String errorMsg = HttpUtil.getAsString(request, "ERROR_MSG");
%>
<html>
<head>
<%--提示信息--%>
<title>Alarm</title>
<style type="text/css">
a:link,a:visited	{ text-decoration: none; color: #003366 }
a:hover			{ text-decoration: underline }
body			{ scrollbar-base-color: #F8F8F8; scrollbar-arrow-color: #698CC3; font-size: 12px; background-color: #FFFFFF }
table			{ font-family: Tahoma, Verdana; color: #000000; font-size: 12px }
textarea,input,object	{ font-family: Tahoma, Verdana; font-size: 12px;  color: #000000; font-weight: normal; background-color: #F8F8F8 }
select			{ font-family: Arial, Tahoma; font-size: 11px;  color: #000000; font-weight: normal; background-color: #F8F8F8 }
.nav			{ font-family: Tahoma, Verdana; font-size: 12px; font-weight: bold }
.navtd			{ font-family: Tahoma, Verdana; font-size: 12px; color: #FFFFFF; text-decoration: none }
.header			{ font-family: Tahoma, Verdana; font-size: 11px; color: #FFFFFF; font-weight: bold; background-color: #698CC3 }
.category		{ font-family: Arial, Tahoma; font-size: 11px; color: #000000; background-color: #EFEFEF }
.multi			{ font-family: Arial, Tahoma; font-size: 11px; color: #003366; }
.smalltxt		{ font-family: Arial, Tahoma; font-size: 11px }
.mediumtxt		{ font-family: Tahoma, Verdana; font-size: 12px; color: #000000 }
.bold			{ font-weight: bold }
</style>
</head>
<body leftmargin="0" rightmargin="0" topmargin="0">
<br><br>
<table width="99%" cellpadding="0" cellspacing="0" border="0" align="center">
<tr>
  <td>
    <br>
    <br>
    <table cellspacing="0" cellpadding="0" border="0" width="500" align="center">
	<tr>
		<td bgcolor="#698CC3">
		<table border="0" cellspacing="1" cellpadding="4" width="100%">
		<%--提示信息--%>
		<tr class="header"><td>INFO</td></tr>
		<tr><td bgcolor="#FFFFFF" align="center">
			<table border="0" width="90%" cellspacing="0" cellpadding="0">
			<tr><td align="center" class="smalltxt">
			<br><%=errorMsg%><br><br>
<br><br>

</td></tr></table>
</td></tr></table>
</td></tr></table>
<br><br>

<br></td></tr></table><br>



</body></html>

