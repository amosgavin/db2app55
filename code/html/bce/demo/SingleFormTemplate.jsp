<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/frame/BceFrameHead.jsp"%>
<html>  
<head>
<title></title>
</head>
<% 
String bceFrameId = HttpUtil.getAsString(request,com.ai.bce.util.BceUtil.BCE_FRAME_ID_KEY);
request.setAttribute("APP_PATH",application.getRealPath("")+"/bce/temp/");
%>
<body>
<ai:contractframe id="详细信息" contenttype="table" title="详细信息" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
  <table width="98%" align="center" border="0" cellpadding="0" cellspacing="0"><tr><td align="center">
     <bce:autoform_area formid="frmInfo" bceframeid="<%=bceFrameId %>"
					  setname="${class=com.ai.bce.web.BceAutoSetAction;method=getBceAttrAutoForm}"
					  templateclass="com.asiainfo.crm.bcedemo.group.CustAutoSetEchoClass"/>
  </td></tr></table>
</ai:contractframe>

</body>
</html>
