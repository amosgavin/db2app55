
<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>


<%
	String roleId = HttpUtil.getAsString(request,"roleId");
	
	String frameId = HttpUtil.getAsString(request,"frameId");
	
	String pFrameId = HttpUtil.getAsString(request,"pFrameId");
	//�Ƿ�ɱ༭״̬������ҳ�洦�ڿ���Ϸ�ʱ�����ڿɱ༭״̬
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
    src="chart.jsp?roleId=<%=roleId%>&frameId=<%=frameId%>&pFrameId=<%=pFrameId%>&isCharEdit=<%=isCharEdit%>"></iframe>
</td>
</tr>
</table>
</body>
</html>


