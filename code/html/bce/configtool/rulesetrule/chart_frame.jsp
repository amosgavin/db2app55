
<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>


<%
	String RULESET_ID = HttpUtil.getAsString(request ,"RULESET_ID"); 
	String RULE_ID = HttpUtil.getAsString(request ,"RULE_ID"); 
	String RELATE_ID = HttpUtil.getAsString(request ,"RELATE_ID"); 
	//是否可编辑状态，当该页面处于框架上方时，处于可编辑状态
	String isCharEdit = HttpUtil.getAsString(request ,"isCharEdit"); 

%>
<html>
<title>
</title>

<link rel="stylesheet" href="../common/css/chart.css" type="text/css">
<body class='framechar'>
<table width=100% >
<tr>
<td align=center valign=top>
    <iframe id="chart_iframe" style="width=200;height=100" frameBorder=0  SCROLLING='no'
    src="chart.jsp?RULE_ID=<%=RULE_ID%>&RULESET_ID=<%=RULESET_ID%>&RELATE_ID=<%=RELATE_ID%>&isCharEdit=<%=isCharEdit%>"></iframe>
</td>
</tr>
</table>
</body>
</html>


