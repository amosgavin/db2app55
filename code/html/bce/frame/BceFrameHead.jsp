
<%@page import="com.ai.bce.util.BceUtil"%>
<%@page import="com.ai.bce.util.CheckTask"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>

<%--
/************************************************
  Project Name:       AIAppFrame3
  Module Name:        WebFrame 
  Author:             zhongrui
  Version:            受理框架的头文件.如果需要设置page规则,则必须包含该文件
************************************************/
--%>
<!-- appframe的js包 -->
<ai:scriptinclude src="/bce/frame/AIEvent.js" />
<!-- omframe的js包 -->
<ai:scriptinclude src="/bce/frame/Util.js" />
<ai:scriptinclude src="/bce/frame/js/BceJsConfig.js" />

<%
	//CheckTask.main(new String[]{});
	String pageRulesetId = HttpUtil.getAsString(request,
			"PAGE_RULESET_ID");
	if (StringUtils.isNotBlank(pageRulesetId)
			&& "0".equals(pageRulesetId) == false) {
%>

<%@include file="/bce/frame/JsRuleHead.jsp"%>

<%
	}
	//处理自定义传递参数 格式:UDF_PARAM_STR=aaa:bbb;ccc:ddd 生成getaaa(),getbbb()的js函数
	String udfParamStr = HttpUtil.getAsString(request, "UDF_PARAM_STR");
	if (StringUtils.isNotBlank(udfParamStr)) {
%>
<script language="javascript">
<%String[] paramPairs = udfParamStr.split(";");
				if (null != paramPairs && paramPairs.length > 0) {
					for (int i = 0; i < paramPairs.length; i++) {
						String[] paramPair = paramPairs[i].split(":");
						if (null != paramPair && paramPair.length == 2) {
							//设置到request中以便后台规则获取使用
							request.setAttribute(paramPair[0], paramPair[1]);
							//实现js函数供前台调用%>
					function get<%=paramPair[0]%>(){
						return "<%=paramPair[1]%>";
					}
<%}
					}
				}%>
	</script>
<%
	}
%>

<%
	if (BceUtil.getIsDebug() != true) {
%>
<script language="Javascript">
	function document.onkeydown(){          
	          if(event.keyCode==116)         {
	                    event.keyCode     =     0;          
	                    event.cancelBubble     =   true;          
	                  return   false;          
	            }          
	}          
	           
	          
	function document.oncontextmenu(){          
	      return   false;          
	}
	
	</script>
<%
	}
%>