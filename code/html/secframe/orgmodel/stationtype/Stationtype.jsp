<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=gb2312">
<title><i18n:message key="sec.stationtype.title" res="i18n.secframe_resource"/></title>
</head>
<SCRIPT LANGUAGE="JavaScript">
	var tempKindId=0;
	var stationType = false;
</SCRIPT>
<script src="<%=request.getContextPath()%>/secframe/js/orgmodel/stationtype/Stationtype.js"></script>
<body>
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="220" valign="top">
			<ai:contractframe id="ct_stationtypetree" contenttype="table" title="sec.stationtype.tree" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
  				<ai:contractitem/>
  				<table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
				<ai:dbtree_new
					id="stationtype_tree" width="100%" height="500"
					datamodel="com.ai.secframe.orgmodel.web.SecStationTypeModel"
					initial="true" ishaveline="true" onselect="Stationtype.reloadForm"
					onrightclick="" />
						</td>
					</tr>
				</table>
			</ai:contractframe>
		</td>
		<td valign="top">
			<div id="station_type" style="display: none">
				<ai:contractframe id="ctframe1" contenttype="table" title="sec.stationtype.info" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
					<ai:contractitem/>
					<ai:dbform formid="stationtypeform"
						setname="com.ai.secframe.orgmodel.web.SETSecStationType"
						initial="false"
						datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
						implservice_name="com.ai.secframe.orgmodel.service.interfaces.ISecStationSV"
						implservice_querymethod="queryStationType">
						<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
							<tr>
								<td class="td_font"><i18n:message key="sec.stationtype.code" res="i18n.secframe_resource"/>：</td>
								<td>
									<ai:dbformfield fieldname="CODE" formid="stationtypeform" width="150" /><span class="font_red">*</span>
								</td>
								<td class="td_font"><i18n:message key="sec.stationtype.name" res="i18n.secframe_resource"/>：</td>
								<td>
									<ai:dbformfield fieldname="NAME" formid="stationtypeform" width="150" /><span class="font_red">*</span>
								</td>
							</tr>
							<tr>
								<td class="td_font"><i18n:message key="sec.stationtype.kind" res="i18n.secframe_resource"/>：</td>
								<td>
									<ai:dbformfield fieldname="KIND_ID" formid="stationtypeform" width="150" />
								</td>
								<td class="td_font"><i18n:message key="sec.stationtype.sort" res="i18n.secframe_resource"/>：</td>
								<td>
									<ai:dbformfield fieldname="SORT_ID" formid="stationtypeform" width="150" />
								</td>
							</tr>
							<tr>
								<td class="td_font"><i18n:message key="sec.stationtype.note" res="i18n.secframe_resource"/>：</td>
								<td colspan="3">
									<ai:dbformfield fieldname="STATION_TYPE_ID" formid="stationtypeform" visible="false" /> 
									<ai:dbformfield fieldname="NOTES" formid="stationtypeform" editable="true" width="150"/>
								</td>
							</tr>						
						</table>
					</ai:dbform>
				</ai:contractframe>
				<div class="area_button">
			  		<ai:button id="saveStationType" text="sec.save" i18nRes="i18n.secframe_resource" onclick="Stationtype.updateStationTypeAction()"/>&nbsp;
					<ai:button id="delStationType" text="sec.delete" i18nRes="i18n.secframe_resource" onclick="Stationtype.delStationTypeAction()"/>
				</div>
			</div>
			<div id="station_type_kind" style="display: block">
				<ai:contractframe id="ctframe2" contenttype="table" title="sec.stationkind.info" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
	  				<ai:contractitem/>
					<ai:dbform
					formid="stationtypekindform"
					setname="com.ai.secframe.orgmodel.web.SETSecStationTypeKind"
					initial="false"
					datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.orgmodel.service.interfaces.ISecStationSV"
					implservice_querymethod="querySecStationTypeKind">
					<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
						<tr>
							<td class="td_font"><i18n:message key="sec.stationkind.id" res="i18n.secframe_resource"/>：</td>
							<td>
								<ai:dbformfield fieldname="KIND_ID" formid="stationtypekindform" width="150" />
							</td>
							<td class="td_font"><i18n:message key="sec.stationkind.name" res="i18n.secframe_resource"/>：</td>
							<td>
								<ai:dbformfield fieldname="KIND_NAME" formid="stationtypekindform" width="150" /><span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td class="td_font"><i18n:message key="sec.stationkind.parentid" res="i18n.secframe_resource"/>：</td>
							<td>
								<ai:dbformfield fieldname="PARENT_KIND_ID" formid="stationtypekindform" width="150" editable="false"/>
							</td>
							<td class="td_font"><i18n:message key="sec.stationkind.sort" res="i18n.secframe_resource"/>：</td>
							<td>
								<ai:dbformfield fieldname="SORT_ID" formid="stationtypekindform" width="150" />
							</td>
						</tr>										
					</table>
					</ai:dbform>
				</ai:contractframe>
				<div class="area_button">
			  		<ai:button id="addKind" text="sec.stationtype.addKind" i18nRes="i18n.secframe_resource" onclick="Stationtype.newStationTypeKindAction()"/> &nbsp;
					<ai:button id="addType" text="sec.stationtype.addType" i18nRes="i18n.secframe_resource" onclick="Stationtype.newStationTypeAction()"/> &nbsp;
					<ai:button id="saveKind" text="sec.stationtype.saveKind" i18nRes="i18n.secframe_resource" onclick="Stationtype.updateStationTypeKindAction()"/> &nbsp;
					<ai:button id="delKind" text="sec.stationtype.delKind" i18nRes="i18n.secframe_resource" onclick="Stationtype.delStationTypeKindAction()"/>
				</div>
			</div>
		</td>
	</tr>
</table>
</body>
</html>
<script type="text/javascript">
	//设置按钮状态
	Stationtype.setBtnDisabled(true);
</script>
