<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.comframe.autoform.service.interfaces.IAutoFormSV"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page import="com.ai.appframe2.util.StringUtils"%>
<%@ page import="com.ai.appframe2.service.ServiceFactory"%>

<HTML>
	<HEAD>
		<TITLE></TITLE>		
		<%
			int urlBusiType = 1;//url业务类型
			String aWorkFlowCode = HttpUtil.getAsString(request, "WORK_FLOW_CODE");//
			String aWorkFlowNodeCode = HttpUtil.getAsString(request, "WORK_FLOW_NODE_CODE");//
			String aOrderId = HttpUtil.getAsString(request, "ORDER_ID");//
			String aTaskId = HttpUtil.getAsString(request, "TASK_ID");
			String aWorkFlowId = HttpUtil.getAsString(request, "WORK_FLOW_ID");
			//String queryCondition = HttpUtil.getAsString(request, "QUERY_CONDITION");//任务列表的查询条件
			urlBusiType =  HttpUtil.getAsInt(request, "urlType");
 			
			request.setAttribute("aWorkFlowCode",aWorkFlowCode);
			request.setAttribute("aWorkFlowNodeCode",aWorkFlowNodeCode);
			
			IAutoFormSV autoformSV = (IAutoFormSV)ServiceFactory.getService(IAutoFormSV.class);
			String URL = autoformSV.getObjectItemUrlForTask(aWorkFlowCode,aWorkFlowNodeCode,urlBusiType);
			//回置任务参数
			if(!StringUtils.emptyString(aWorkFlowId)){
				Map vars = autoformSV.getWorkFlowVars(aWorkFlowId);
	  			if(!vars.isEmpty()){
	  				Iterator keyIterator = vars.keySet().iterator();
		    		while(keyIterator.hasNext()){
		    			String key = (String)keyIterator.next();
		    			Object value = vars.get(key);
		    			request.setAttribute(key,value);
		    		}
	  			}	
			}
		%>
	</HEAD>
	<BODY>
		<%
			//URL重定向
			if (!StringUtils.isEmptyString(URL)) {
	  			request.setAttribute("WORK_FLOW_CODE",aWorkFlowCode);
	  			request.setAttribute("WORK_FLOW_NODE_CODE",aWorkFlowNodeCode);
	  			request.setAttribute("ORDER_ID",aOrderId);
	  			request.setAttribute("TASK_ID",aTaskId);
	  			request.setAttribute("WORK_FLOW_ID",aWorkFlowId);
	  			request.setAttribute("order_state","1");                     //未竣工的订单查询
	  			
	  			RequestDispatcher r = request.getRequestDispatcher(URL);
				r.forward(request,response);
				return;
			}else{
				request.setAttribute("WORK_FLOW_CODE",aWorkFlowCode);
	  			request.setAttribute("WORK_FLOW_NODE_CODE",aWorkFlowNodeCode);
	  			request.setAttribute("urlType",String.valueOf(urlBusiType));
	  			RequestDispatcher r = request.getRequestDispatcher("errorInfo.jsp");
				r.forward(request,response);				
			}
		%>
	</BODY>
</HTML>
