<%@ page import="com.ai.appframe2.common.SessionManager" %>  
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface" %>  
<%@ page contentType="text/html; charset=GBK"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<%
  String path = request.getContextPath();
  UserInfoInterface user = SessionManager.getUser();
  
 %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>right</title>
		<link href="css/home.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
    <ai:tab id="ddd1" width="100%" type="h">
		<ai:tabitem id="dd1" title="待办事项" src="include/toplist.jsp" initial="true" />
		<ai:tabitem id="dd4" title="协办知会事项" src="include/apprise.jsp" isDeletable="false" />
		<ai:tabitem id="dd2" title="已办未结事项" src="include/finishlist.jsp" isDeletable="false" />
		<ai:tabitem id="dd3" title="已办归档事项" src="include/historylist.jsp" isDeletable="false" />
		<ai:tabitem id="dd5" title="流程图测试" src="../workflow/WorkflowInst.jsp" isDeletable="false" />
	</ai:tab>
	</body>
</html>

