
<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>


<%
	String pageFramePageId = HttpUtil.getAsString(request,"pageFramePageId");
	
	String bceFrameId = HttpUtil.getAsString(request,"bceFrameId");
	 
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
    src="chart.jsp?bceFrameId=<%=bceFrameId%>&pageFramePageId=<%=pageFramePageId%>&isCharEdit=<%=isCharEdit%>"></iframe>
</td>
</tr>
</table>
</body>
</html>


