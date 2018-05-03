<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@include file="/secframe/common/common.jsp"%>
<ai:scriptinclude src="/secframe/common/common.js" />
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="logger.query.operate.titile" res="i18n.secframe_resource"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<%
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.util.Date currentTime = new java.util.Date();//得到当前系统时间 		
	String cur_date = formatter.format(currentTime);
%>
</head>

<script type="text/javascript">
	var curdate = "<%=cur_date%>";
	var orgId = "<%=com.ai.appframe2.common.SessionManager.getUser().getOrgId()%>";
</script>
<script src="<%=request.getContextPath()%>/secframe/js/common/query/OperateLog.js"></script>

<body onLoad="OperateLog.init();">
<ai:contractframe id="contractframe1" contenttype="table" title="logger.query.operate.condition" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="operateQueryForm" setname="com.ai.secframe.common.web.SETSecOperateLog" initial="false">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font"><i18n:message key="logger.query.operate.staffcode" res="i18n.secframe_resource"/>：</td>
	           	<td><ai:dbformfield formid="operateQueryForm" fieldname="CONTENT" width="150"/></td>
	           	<td class="td_font"><i18n:message key="logger.query.operate.operatetype" res="i18n.secframe_resource"/>：</td>
	           	<td><ai:dbformfield formid="operateQueryForm" fieldname="OPERATE_TYPE" width="150"/></td>
	           	<td class="td_font"><i18n:message key="logger.query.operate.operatelogtype" res="i18n.secframe_resource"/>：</td>
	           	<td><ai:dbformfield formid="operateQueryForm" fieldname="OPERATE_LOG_TYPE" width="150"/></td>
			</tr>
			<tr>
	           	<td class="td_font"><i18n:message key="logger.query.operate.organize" res="i18n.secframe_resource"/>：</td>
	           	<td>
					<ai:dbformfield formid="operateQueryForm" fieldname="ORG_ID" width="100" visible="false" /> 
					<ai:dbformfield formid="operateQueryForm" fieldname="TABLE_NAME_OP" width="130" visible="true" editable="false" /><img id="selOrgBtn" border="0" src="<%=request.getContextPath()%>/webframe/images/check.gif" onClick="OperateLog.orgSelect()" align="absmiddle" style="cursor:hand;"/>					
				</td>
	           	<td class="td_font"><i18n:message key="logger.query.operate.starttime" res="i18n.secframe_resource"/>：</td>
	           	<td><input type="text" id="startDate" readonly onclick="calendar(this);" style="width:150"></td>
	           	<td class="td_font"><i18n:message key="logger.query.operate.endtime" res="i18n.secframe_resource"/>：</td>
	           	<td><input type="text" id="endDate" readonly onclick="calendar(this);" style="width:150"></td>
	           	<td class="td_button">
	           		<ai:button id="queryBtn" text="sec.query" i18nRes="i18n.secframe_resource" onclick="OperateLog.queryOperateLog()"/>
	           	</td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:contractframe id="contractframe2" contenttype="table" title="logger.query.operate.list" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
 	<ai:table
		tableid="operateLogInfo"
		setname="com.ai.secframe.common.web.SETSecOperateLog"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.ai.secframe.common.service.interfaces.ISecLogSV"
		implservice_querymethod="querySecOperateLog(String staffCode, String orgID, String operateType, String operateLogType, String startDate, String endDate, int $STARTROWINDEX, int $ENDROWINDEX)"
		implservice_countmethod="querySecOperateLogCount(String staffCode, String orgID, String operateType, String operateLogType, String startDate, String endDate)"
		initial="false" pagesize="15" editable="false" width="100%"
		height="320" needrefresh="true">
		<ai:col fieldname="OPERATE_LOG_ID" width="100" />
		<ai:col fieldname="ORDER_ID" width="100" />
		<ai:col fieldname="ORG_ID" width="100" />
		<ai:col fieldname="OP_ID" width="100" />
		<ai:col fieldname="CONTENT" width="600" />
		<ai:col fieldname="DONE_DATE" width="130" />
		<ai:col fieldname="RECORD_ID" width="100" />
		<ai:col fieldname="CLUM_ID" width="120" />
		<ai:col fieldname="OPERATE_TYPE" width="100" />
		<ai:col fieldname="TABLE_NAME_OP" width="160" />
		<ai:col fieldname="H_TABLE_NAME_OP" width="180" />
	</ai:table>
</ai:contractframe>
</body>
</html>