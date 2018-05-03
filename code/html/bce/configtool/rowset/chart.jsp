<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.service.ServiceFactory"%>
<%@ page import="com.ai.bce.configtool.service.interfaces.IConfTreeChartSV"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page import="com.ai.bce.util.LocaleResourceFactory"%>

 <%
	//是否可编辑状态，当该页面处于框架上方时，处于可编辑状态
	String isCharEdit = HttpUtil.getAsString(request ,"isCharEdit"); 
	long ROWSET_ID = HttpUtil.getAsLong(request ,"ROWSET_ID"); 
%>
<html>
<head>
<title>
<%=LocaleResourceFactory.getResource("BES0000514")%>
</title>
<script>
	var isCharEdit = "<%=isCharEdit%>"; 
</script>
<script language="javascript" src="../common/js/organization.js"></script>
<script language="javascript" src="../common/js/configtool.js"></script>


<link rel="stylesheet" href="../common/css/chart.css" type="text/css">
</head>


<body onload="initTree()">

<script>
<% 
	IConfTreeChartSV sv = (IConfTreeChartSV)ServiceFactory.getService(IConfTreeChartSV.class);
	out.println(sv.getBceDataset(ROWSET_ID));
%>
</script>
</body>
</html>


