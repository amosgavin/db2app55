<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="java.util.HashMap"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<script language=javascript>
	var curRoleId = -1;
	var curRoleName = "";
</script>
<script src="<%=request.getContextPath()%>/secframe/js/orgmodel/stationtype/StationOrgRelat.js"></script>
<title><i18n:message key="sec.stationtype.orgtype.title" res="i18n.secframe_resource"/></title>
</head>
<body>
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="220" valign="top">
			<ai:contractframe id="orgtype" contenttype="table" title="sec.stationtype.orgtype.tree" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
  				<ai:contractitem/>
  				<table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
				<ai:dbtree_new id="tree" height="500" width="100%"
						datamodel="com.ai.secframe.orgmodel.web.SecOrgTypeTreeModel"
						initial="true" ishaveline="true" multiselect="false"
						onselect="StationOrgRelat.select" />
						</td>
					</tr>
				</table>
			</ai:contractframe>
		</td>
		<td align="right" valign="top">				
			<ai:contractframe id="stationList" contenttype="table" title="sec.stationtype.orgtype.stationlist" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
  				<ai:contractitem/>
				<ai:table
					setname="com.ai.secframe.orgmodel.web.QSETSecStationKindAndTypeInfo"
					tableid="tblStationType"
					tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.ai.secframe.orgmodel.service.interfaces.ISecStationSV"
					implservice_querymethod="getSecStationKindAndTypeInfo(long orgRoleTypeId)"
					footdisplay="none" editable="false" rowsequence="true"
					pagesize="50" height="450" width="100%" multiselect="true"
					initial="false" onrowselected="StationOrgRelat.selectAction" needrefresh="true">
					<ai:col fieldname="STATIONTYPE_NAME" edittype="DBTree" width="30%" />
					<ai:col fieldname="STATIONTYPE_CODE" width="30%" />
					<ai:col fieldname="NOTES" width="40%" />
					<ai:col fieldname="STATION_TYPE_ID" visible="false" />
					<ai:col fieldname="FL" visible="false" />
				</ai:table>
			</ai:contractframe>
			
			<div class="area_button">
			  <ai:button id="updateStationTypeBtn" text="sec.save" i18nRes="i18n.secframe_resource" onclick="StationOrgRelat.updateStationTypeAction()"/>
			</div>
		</td>
	</tr>
</table>
</body>
</html>