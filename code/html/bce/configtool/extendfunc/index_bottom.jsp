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
 	 
 	<ai:tabitem  id="singleFunc" src='<%="singlefunc/singleFunc.jsp?bceFrameId="+bceFrameId + "&module_id=" +module_id %>' 
 	title='<%=LocaleResourceFactory.getResource("BES0000532")%>' 
 			initial='<%=("singleFunc".equals(curTabItemName) || initial) +"" %>'></ai:tabitem>
 	<%
 		initial = false;
 	%>	  
 	
	</ai:tab>

</body> 
</html>

<script>
	//��ťά��
	function btnConfig(){
		setTabItem("main_tab" ,"btnConfig");
	}
	
	//����ά��
	function attrConfig(){
		setTabItem("main_tab" ,"attrConfig");
	}

</script>


