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
	
	
	//页面ID
	String PAGE_ID = HttpUtil.getAsString(request ,"PAGE_ID"); 
	
	
	String module_id = HttpUtil.getAsString(request ,"module_id");
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
 				<ai:tabitem  id="detail" src='<%="detail.jsp?PAGE_ID=" + PAGE_ID + "&module_id=" +module_id%>' 
 				title='<%=LocaleResourceFactory.getResource("BES0000515")%>' 
 					initial='<%=("detail".equals(curTabItemName) || initial) +"" %>'></ai:tabitem>
 		<%
 				initial=false;
 			}
 		
 			//展现图示信息
 			if("false".equalsIgnoreCase(showChart) ==false){
 		%>
 				<ai:tabitem id="chart" src='<%="chart_frame.jsp?PAGE_ID="+PAGE_ID + "&module_id=" +module_id%>' 
 				title='<%=LocaleResourceFactory.getResource("BES0000514")%>'  
					initial='<%=("chart".equals(curTabItemName) || initial ) +""%>'></ai:tabitem>
 		<%
 				initial=false;
 			}
 		%>
		
		<ai:tabitem id="useByPageFrame" src='<%="useByPageFrame.jsp?PAGE_ID="+PAGE_ID+ "&module_id=" +module_id %>' 
		title='<%=LocaleResourceFactory.getResource("BES0000519")%>'  
			initial='<%=("useByPageFrame".equals(curTabItemName) || initial ) +""%>'></ai:tabitem>
			
		<ai:tabitem id="pageRuleList" src='<%="pageRuleList.jsp?PAGE_ID="+PAGE_ID+ "&module_id=" +module_id %>' 
		title='<%=LocaleResourceFactory.getResource("BES0000520")%>' 
			initial='<%=("pageRuleList".equals(curTabItemName) || initial ) +""%>'></ai:tabitem>
<% if(false){%>		
		<ai:tabitem id="pageRowsetList" src='<%="pageRowsetList.jsp?PAGE_ID="+PAGE_ID+ "&module_id=" +module_id %>' 
		title='<%=LocaleResourceFactory.getResource("BES0000521")%>' 
			initial='<%=("pageRowsetList".equals(curTabItemName) || initial ) +""%>'></ai:tabitem>
<%} %>			
		
	</ai:tab>

</body> 
</html>


