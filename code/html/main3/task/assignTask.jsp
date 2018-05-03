<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="com.asiainfo.task.web.AssignTaskAction"%>
<%
String path = request.getContextPath();
String url = AssignTaskAction.forward(request,response);
String templateTag = request.getParameter("templateTag");
String taskTagStr = request.getParameter("taskTag");
String recordIdStr = request.getParameter("recordId");
String recordTypeStr = request.getParameter("recordType");
String taskId = request.getParameter("taskId");
String taskTemplateId = request.getParameter("taskTemplateId");
String templateCode = request.getParameter("templateCode");
String workflowId = request.getParameter("workflowId");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  </body>
</html>
<script language="JavaScript" for="window" even="onload">  
 
 function showSaleDetailInfo(){
    url = "<%=request.getContextPath()%>"+"<%=url%>"+"?"+"recordId=" + "<%=recordIdStr%>"
                                        + "&recordType=" + "<%=recordTypeStr%>"
                                        +"&taskTag="+"<%=taskTagStr%>"
                                        +"&taskId="+"<%=taskId%>"
                                        +"&taskTemplateId="+"<%=taskTemplateId%>"
                                        +"&templateCode="+"<%=templateCode%>"
                                        +"&workflowId="+"<%=workflowId%>";
   window.open(url, null, "height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}

 showSaleDetailInfo();
</script>  
