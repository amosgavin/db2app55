<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/frame/BceFrameHead.jsp"%>
<%@ page import="com.ai.bce.web.BceFrameAction" %>
<%@page import="com.ai.bce.ivalues.IBceRuleReturnData"%>
<%@page import="com.ai.bce.util.BceUtil"%>
<script src="<%=request.getContextPath()%>/bce/frame/BceFrame.js"></script>
<script src="<%=request.getContextPath()%>/bce/frame/BceSubmitData.js"></script>
<script src="<%=request.getContextPath()%>/bce/frame/BceSubmitUtil.js"></script>

<%
  String busiId = HttpUtil.getAsString(request,com.ai.bce.util.BceUtil.BUSIOPER_ID_KEY);
  String pageUrl = "";
	String msg = null;
	if (StringUtils.isNotBlank(busiId)) {
    try {  
    	//����У��
    	IBceRuleReturnData returnData = BceFrameAction.isBusiCanDo(request);
			if (returnData != null) {
				//�������������ת����ҳ��
				if (returnData.getResultCode() == BceUtil.JAVA_RULE_RETURN_CODE_NO) {
					request.setAttribute("ERROR_MSG", returnData.getMsg());
					request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
					return;
				} 
				else if (returnData.getResultCode() == BceUtil.JAVA_RULE_RETURN_CODE_WARNNING) {
					msg = returnData.getMsg();
				}
			}
    	
    	//У��ͨ����չʾҳ��
      pageUrl = BceFrameAction.writePageInfos(pageContext,request, out);
    	BceFrameAction.writeFrameRuleDetails(pageContext,request, out);
    }
    catch (Exception e) {
    	request.setAttribute("ERROR_MSG", e.getMessage());
		request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
      //e.printStackTrace();
    }
  }
%>
<script lanagage="javascript">

initPage();

var STR_COMM_PARAM="";
<%if(pageUrl.indexOf("?")>0){%>
  STR_COMM_PARAM = "<%=pageUrl.substring(pageUrl.indexOf("?")+1)%>";
<%}%>

function initPage(){
  <%
    //����ں�̨У�����ʱ,�о�����Ϣ.��ֱ����ʾ����alert�Ի���.
    if(msg!=null){
      out.print("displayMessage('"+msg+"');");
    }
	%>
}

function displayMessage(str){
  var ret = confirm(str); 
	if(ret == false){
	  window.location = G_RTN_URL;
	}
}
</script>

<jsp:include page="<%=pageUrl %>"/>
