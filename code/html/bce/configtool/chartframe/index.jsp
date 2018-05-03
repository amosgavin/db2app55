<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page import="com.ai.bce.util.LocaleResourceFactory"%>

<% 
	
	//展现其它窗口的时候的打开方式
	String openType = HttpUtil.getAsString(request ,"openType"); 
	
		//是否展现基本信息
	String showDetail = HttpUtil.getAsString(request ,"showDetail");

	//是否展现图表树形信息
	String showChart = HttpUtil.getAsString(request ,"showChart"); 
	
	//获取当前节点类型
	String nodeType = HttpUtil.getAsString(request ,"nodeType"); 
	
	
	String module_id = HttpUtil.getAsString(request ,"module_id");
%>

<html>
<head>
<script language="javascript" src="../common/js/configtool.js"></script>

<script>
	//当前模块ID
	var module_id = "<%=module_id%>";
	function openframe(){
		var queryStr =window.location.search;
		if(queryStr != null || queryStr !=''){
			queryStr = queryStr.substr(1,queryStr.length);
		} 
		//根据节点类型获取对应文件夹的位置
		var url = getJspDirByType("<%=nodeType%>");
		
		document.getElementById("frame_top").style.width=document.body.clientWidth;
		document.getElementById("frame_bottom").style.width=document.body.clientWidth;
		document.getElementById("frame_top").style.height=document.body.clientHeight/2;
		document.getElementById("frame_bottom").style.height=document.body.clientHeight/2;
		
		frame_top.window.location=url +"chart_frame.jsp?isCharEdit=true&" + queryStr;
		 
		frame_bottom.window.location=url +
			"index_bottom.jsp?showChart=false&curTabItemName=detail&" + queryStr; 
	}
</script>
 
<title>
<%=LocaleResourceFactory.getResource("BES0000514")%>
</title>
</head>
 
</html>

<body onload ="openframe()">
<iframe name="frame_top" id="frame_top" style="with='100%'"></iframe><br>
<iframe name="frame_bottom" id="frame_bottom"  style="with='100%'"></iframe>
</body>

