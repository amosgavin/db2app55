<%@ page import="com.ai.bce.web.BceFrameAction" %>
<%
    try {
        BceFrameAction.writePageRuleDetails(pageContext,request, out);
    }
    catch (Exception e) {
        e.printStackTrace();
    }
%>