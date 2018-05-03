<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.asiainfo.task.web.AssignTaskAction"%>
<%@ page import="com.ai.secframe.orgmodel.ivalues.IBOSecStaffValue"%>

<html>
  <head>
    <title>信息提示</title>
  </head>
  <body onload="">
	<div id='div'><span class="font_red"></span><textarea id="approval_opinion" rows="11" cols="75" readonly=readonly></textarea></div>
  </body>
  <script type="text/javascript">
    var obj = window.dialogArguments;
    document.getElementById('approval_opinion').value=obj.name;
    //document.getElementById('div').readonly=true;
    //document.write("审批意见:"+obj.name);
  </script>
  
</html>
