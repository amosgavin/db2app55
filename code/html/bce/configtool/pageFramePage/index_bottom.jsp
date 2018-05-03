<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page import="com.ai.bce.util.LocaleResourceFactory"%>


<%
	//�Ƿ�չ�ֻ�����Ϣ
	String showDetail = HttpUtil.getAsString(request ,"showDetail");

	//�Ƿ�չ��ͼ��������Ϣ
	String showChart = HttpUtil.getAsString(request ,"showChart"); 
	

	//BCE_FRAME_ID
	String BCE_FRAME_ID = HttpUtil.getAsString(request ,"BCE_FRAME_ID"); 
	

	//չ���������ڵ�ʱ��Ĵ򿪷�ʽ
	String openType = HttpUtil.getAsString(request ,"openType"); 
	
	String pFramePageId = HttpUtil.getAsString(request,"pFramePageId");
	
	boolean initial = true;
	//�ϴ����ڵ�tabId��������ڣ���Ԥ�ȳ�ʼ����ͨ��JS����ѡ�е�ҳ��
	String curTabItemName = HttpUtil.getAsString(request,"curTabItemName");
	if(curTabItemName != null && curTabItemName.equals("") == false){
		initial = false;
	}
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
 			//չ�ֻ�����Ϣ
 			if("false".equalsIgnoreCase(showDetail) ==false){
 				
 		%>
 				<ai:tabitem  id="detail" src='<%= "detail.jsp?pFramePageId="+pFramePageId+ "&module_id=" +module_id%>'
 				 title='<%=LocaleResourceFactory.getResource("BES0000515")%>'
 					initial='<%=("detail".equals(curTabItemName) || initial )+""%>' ></ai:tabitem>
 		<%
 				initial=false;
 			}
 		
 			//չ��ͼʾ��Ϣ
 			if("false".equalsIgnoreCase(showChart) ==false){
 		%>
 				<ai:tabitem id="chart" src='<%= "chart_frame.jsp?pFramePageId=" + pFramePageId + "&module_id=" +module_id%>' 
 				title='<%=LocaleResourceFactory.getResource("BES0000514")%>'  
 					initial='<%=("chart".equals(curTabItemName) || initial )+""%>' ></ai:tabitem>
 		<%
 				initial =false;
 			}
 		%>
		
		<ai:tabitem id="includeRowsetList" src='<%="includeRowsetList.jsp?pFramePageId="+pFramePageId+"&openType="+openType+ "&module_id=" +module_id%>' 
		title='<%=LocaleResourceFactory.getResource("BES0000524")%>' 
			initial='<%=("includeRowsetList".equals(curTabItemName) || initial )+""%>' ></ai:tabitem>
<%//if(BCE_FRAME_ID != null && !"".equals(BCE_FRAME_ID) && !"null".equals(BCE_FRAME_ID)){ %>
		<ai:tabitem id="includeRole" src='<%="includeRole.jsp?BCE_FRAME_ID=" + BCE_FRAME_ID +"&pFramePageId=" + pFramePageId+ "&module_id=" +module_id%>' 
		title='<%=LocaleResourceFactory.getResource("BES0000525")%>'  
			initial='<%=("includeRole".equals(curTabItemName) || initial )+""%>' ></ai:tabitem>
		<ai:tabitem id="includeSpecialPage" src='<%="includeSpecialPage.jsp?BCE_FRAME_ID=" + BCE_FRAME_ID +"&pFramePageId=" + pFramePageId+ "&module_id=" +module_id%>' 
		title='<%=LocaleResourceFactory.getResource("BES0000526")%>'  
			initial='<%=("includeSpecialPage".equals(curTabItemName) || initial )+""%>' ></ai:tabitem>
<%//} %>
	</ai:tab>

</body> 
</html>