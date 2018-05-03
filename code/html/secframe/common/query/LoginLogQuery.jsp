<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="logger.query.login.titile" res="i18n.secframe_resource"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<%
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.util.Date currentTime = new java.util.Date();//得到当前系统时间 		
	String cur_date = formatter.format(currentTime);
%>
</head>
<script type="text/javascript">
	var curdate = "<%=cur_date%>";
</script>
<script src="<%=request.getContextPath()%>/secframe/js/common/query/LoginLog.js"></script>

<body onLoad="LoginLog.init();">
<ai:contractframe id="contractframe1" contenttype="table" title="logger.query.login.condition" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="loginLogForm" setname="com.ai.secframe.common.web.SETSecLoginLog" initial="false">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font"><i18n:message key="logger.query.login.staffcode" res="i18n.secframe_resource"/>：</td>
	           	<td><ai:dbformfield formid="loginLogForm" fieldname="STAFF_CODE" width="150"/></td>
	           	<td class="td_font">IP：</td>
	           	<td><ai:dbformfield formid="loginLogForm" fieldname="IP" width="150"/></td>	           	
			</tr>
			<tr>
	           	<td class="td_font"><i18n:message key="logger.query.login.starttime" res="i18n.secframe_resource"/>：</td>
	           	<td><input type="text" id="startDate" readonly onclick="calendar(this);" style="width:150"></td>
	           	<td class="td_font"><i18n:message key="logger.query.operate.endtime" res="i18n.secframe_resource"/>：</td>
	           	<td><input type="text" id="endDate" readonly onclick="calendar(this);" style="width:150"></td>
	           	<td class="td_button">
	           		<ai:button id="queryBtn" text="sec.query" i18nRes="i18n.secframe_resource" onclick="LoginLog.queryLoginLog()"/>
	           	</td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:contractframe id="contractframe2" contenttype="table" title="logger.query.login.list" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
 	<ai:table
		tableid="loginLogInfo"
		setname="com.ai.secframe.common.web.SETSecLoginLog"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.ai.secframe.common.service.interfaces.ISecLogSV"
		implservice_querymethod="querySecLoginLog(String staffCode, String ip, String startDate, String endDate, int $STARTROWINDEX, int $ENDROWINDEX)"
		implservice_countmethod="querySecLoginLogCount(String staffCode, String ip, String startDate, String endDate)"
		initial="false" pagesize="15" editable="false" width="100%"
		height="320" needrefresh="true">
		<ai:col fieldname="LOG_ID" width="10%" />
		<ai:col fieldname="STAFF_CODE" width="15%" />
		<ai:col fieldname="LOGIN_DATE" width="15%" />
		<ai:col fieldname="LOGOUT_DATE" width="15%" />
		<ai:col fieldname="IP" width="20%" />
		<ai:col fieldname="MAC" width="15%" />
		<ai:col fieldname="STATE" width="10%" />
	</ai:table>
</ai:contractframe>
</body>
</html>