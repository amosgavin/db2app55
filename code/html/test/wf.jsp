<%@page import="com.asiainfo.workflow.util.TaskUtil"%>
<%@page import="com.asiainfo.workflow.util.bo.BOTaskRouteBean"%>
<%
BOTaskRouteBean[] g = TaskUtil.getRoute4TaskTemplate("template.TownSaleCaseApprove",1);
%>