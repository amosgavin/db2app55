<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page import="com.ai.bce.util.LocaleResourceFactory"%>


<%	
	String bceFrameId = HttpUtil.getAsString(request ,"BCE_FRAME_ID");  
	
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
<script language="javascript" src="../common/js/configtool.js"></script>
</head>
<body onload="resizeTabToFullWindwo('main_tab');" onresize="resizeTabToFullWindwo('main_tab')">
 	<ai:tab id="main_tab" height="100%" width="100%" type="H">
 	<ai:tabitem  id="buttonRelate" src='<%="buttonRelate.jsp?bceFrameId="+bceFrameId + "&module_id=" +module_id %>' 
 	title='<%=LocaleResourceFactory.getResource("BES0000533")%>' 
 			initial='<%=("buttonRelate".equals(curTabItemName) || initial) +"" %>'></ai:tabitem>
 			
 	<ai:tabitem  id="dbformRelate" src='<%="dbformRelate.jsp?bceFrameId="+bceFrameId+ "&module_id=" +module_id  %>' 
 	title='<%=LocaleResourceFactory.getResource("BES0000534")%>' 
 			initial='<%=("dbformRelate".equals(curTabItemName) || initial) +"" %>'></ai:tabitem>
 			
 	<ai:tabitem  id="dbgridRelate" src='<%="dbgridRelate.jsp?bceFrameId="+bceFrameId + "&module_id=" +module_id %>' 
 	title='<%=LocaleResourceFactory.getResource("BES0000535")%>' 
 			initial='<%=("dbgridRelate".equals(curTabItemName) || initial) +"" %>'></ai:tabitem>
 			
 	<ai:tabitem  id="tabRelate" src='<%="tabRelate.jsp?bceFrameId="+bceFrameId + "&module_id=" +module_id %>' 
 	title='<%=LocaleResourceFactory.getResource("BES0000800")%>' 
 			initial='<%=("tabRelate".equals(curTabItemName) || initial) +"" %>'></ai:tabitem>
	</ai:tab>

</body> 
</html>

<script>
	//��ťά��
	function btnConfig(){
		//setTabItem("main_tab" ,"btnConfig");
	}
	
	//����ά��
	function attrConfig(){
		//setTabItem("main_tab" ,"attrConfig");
	}

</script>


