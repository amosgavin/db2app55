<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page import="com.ai.bce.util.LocaleResourceFactory"%>


<%
	//是否展现基本信息
	String showDetail = HttpUtil.getAsString(request ,"showDetail");

	//是否展现图表树形信息
	String showChart = HttpUtil.getAsString(request ,"showChart"); 
	
    
	//展现其它窗口的时候的打开方式
	String openType = HttpUtil.getAsString(request ,"openType"); 
	
	boolean initial = true;
	//上次所在的tabId，如果存在，则不预先初始化，通过JS设置选中的页面
	String curTabItemName = HttpUtil.getAsString(request,"curTabItemName");
	if(curTabItemName != null && curTabItemName.equals("") == false){
		initial = false;
	}
	
	String module_id = HttpUtil.getAsString(request ,"module_id");
	
	String rulesetId = HttpUtil.getAsString(request ,"RULESET_ID");
	String rulesetType = HttpUtil.getAsString(request, "RULESET_TYPE");	//受影响的页面或者框架
%>
<html>
<head>
<title>
</title>
<script language="javascript" src="../common/js/configtool.js"></script>
</head>
<body onload="resizeTabToFullWindwo('main_tab')" onresize="resizeTabToFullWindwo('main_tab')">

 	<ai:tab id="main_tab" height="100%" width="100%" type="H">
 		<%
 			//展现基本信息
 			if("false".equalsIgnoreCase(showDetail) ==false){
 		%>
 				<ai:tabitem  id="detail" src='<%="detail.jsp?rulesetId="+rulesetId+ "&module_id=" +module_id%>' 
 				title='<%=LocaleResourceFactory.getResource("BES0000515")%>'
 								initial='<%=("detail".equals(curTabItemName) || initial) +"" %>'></ai:tabitem>
 		<%
 				initial=false;
 			}
 		
 			//展现图示信息
 			if("false".equalsIgnoreCase(showChart) ==false ){
 		%>
 				<ai:tabitem id="chart" src='<%="chart_frame.jsp?RULESET_ID="+rulesetId + "&module_id=" +module_id%>' 
 					title='<%=LocaleResourceFactory.getResource("BES0000514")%>' 
					initial='<%=("chart".equals(curTabItemName) || initial ) +""%>'></ai:tabitem>
 		<%
 				initial=false;
 			}
 		%>
		
		<ai:tabitem id="includerule" src='<%="includerule.jsp?openType="+openType + "&rulesetId=" + rulesetId+"&rulesetType="+rulesetType+ "&module_id=" +module_id%>' 
		title='<%=LocaleResourceFactory.getResource("BES0000529")%>' 
			initial='<%=("includerule".equals(curTabItemName) || initial) +""%>'></ai:tabitem>
		<%
			if("2".equals(rulesetType)){ //后台JAVA规则
		%>
		<ai:tabitem id="effectJavaRuleset" src='<%="effectJavaRuleset.jsp?openType="+openType + "&rulesetId=" + rulesetId+ "&module_id=" +module_id%>' 
		title='<%=LocaleResourceFactory.getResource("BES0000530")%>' 
			initial='<%=("effectJavaRuleset".equals(curTabItemName) || initial) +""%>'></ai:tabitem>
		<%} else{%>
		<ai:tabitem id="effectPage" src='<%="effectPage.jsp?openType="+openType + "&rulesetId=" + rulesetId+ "&module_id=" +module_id%>' 
		title='<%=LocaleResourceFactory.getResource("BES0000531")%>'
			initial='<%=("effectPage".equals(curTabItemName) || initial) +""%>'></ai:tabitem>	
		<%}%>		
	</ai:tab>

</body>
<script type="text/javascript"> 
</script> 
</html>