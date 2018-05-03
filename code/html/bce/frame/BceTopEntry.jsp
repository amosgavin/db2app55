<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<%@page import="com.ai.bce.util.BceUtil"%>
<%@page import="com.ai.bce.util.BceServiceFactory"%>
<%@page import="com.ai.bce.ivalues.IQPageFramePageValue"%>
<%@page import="com.ai.bce.create.AbstractTemplateString"%>
<%@page import="com.ai.bce.create.template.impl.TemplateStringForJs"%>
<%@ include file="/bce/frame/BceFrameHead.jsp"%>
<%@ page import="com.ai.bce.web.BceFrameAction"%>
<%@page import="com.ai.bce.ivalues.IBceRuleReturnData"%>
<%@page import="com.ai.bce.util.BceUtil"%>
<script src="<%=request.getContextPath()%>/bce/frame/BceFrame.js"></script>
<script src="<%=request.getContextPath()%>/bce/frame/BceSubmitData.js"></script>
<script src="<%=request.getContextPath()%>/bce/frame/BceSubmitUtil.js"></script>
<%
	long bceFrameId = HttpUtil.getAsLong(request,BceUtil.BCE_FRAME_ID_KEY);
	long pageId = HttpUtil.getAsLong(request,"A_PAGE_ID");
	IQPageFramePageValue pageValue = BceServiceFactory.getBceFrameSV()
			.getPageFramePagesTop(bceFrameId, pageId);
	//¹æÔò
	long rulesetId = pageValue.getPageRulesetId();
	if (rulesetId > 0) {
		/*  					IQBceRulesetRuleValue[] ruleValues = BceServiceFactory.getBceFrameSV().getRulesByRulesetId(rulesetId);
		 EventRuleProcessHelper.writerRuleToPage(pageContext,req,writer, ruleValues,BceUtil.getMap(req));*/
		AbstractTemplateString sb = new TemplateStringForJs();
		sb.setDy(true);
		sb.setRequest(request);
		%><%=sb.dispalayByRusetId(rulesetId)%>
<%
	}
%>
<jsp:include page="<%=pageValue.getPageUrl() %>"></jsp:include>