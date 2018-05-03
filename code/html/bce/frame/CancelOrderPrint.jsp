<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.BusiPrintInvoke"%>
<%@page import="com.ai.common.util.CenterUtil"%>
<%@page import="com.ai.omframe.util.SoSessionCachedFactory"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.asiainfo.crm.customer.common.CmConstants"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/jsv2/AIWaitBanner.js">
</script>
<script type="text/javascript" src="<%=request.getContextPath() %>/zjcrm_java/jsv2/UserData_v2.js">
</script>
<% String postParam = HttpUtil.getAsString(request,"postParam"); %>
<script language="javascript">
var G_RTUN_QR = _gModuleName+"/business/com.asiainfo.crm.so.web.PrintInfoAction?action=contorlWithRoute&InterfacesType=1&";
		function doPrintForCannelOrd(){
			var myrandom=Math.random(); 
			var paramStr = <%=postParam%>;
		   	var url  = G_RTUN_QR+"&"+paramStr+"&myrandom="+myrandom;
		   	var ret = 	window.showModalDialog(url,window,"scroll:yes;resizable:no;help:no;status:no;dialogHeight:700px;dialogWidth:750px");
		} 	
</script>
