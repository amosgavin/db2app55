<%@ page import="com.ai.appframe2.common.SessionManager" %>  
<%@ page contentType="text/html; charset=GBK"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<%
  String path = request.getContextPath();

  String roleId = "5000";
  String staffId = "5000";
 %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>right</title>
		<link href="css/home.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="box1" height="100%">
			<tr>
			<td  valign="top" width="100%" height="5%">
			<LEGEND class="FormZName" style="height:10px;background: url('<%=request.getContextPath()%>/image/home/icon_chart.gif') no-repeat  left;">
  			  <span style="float:left;">消息框</span>
			</legend>
			
			</td>
			</tr>
			<tr>
			<td  valign="top" width="100%" height="100%">
              <iframe src=" "  name="main"  frameborder="no" scrolling="auto" marginwidth="0" marginheight="0" width="100%" height="100%"/>
			</td>
			</tr>
		</table>
	</body>
</html>

