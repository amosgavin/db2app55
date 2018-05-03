<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<HTML>
	<head>
		<title><i18n:message key="sec.rolequery.query" res="i18n.secframe_resource"/></title>
	</head>
	<body>
	<ai:contractframe id="" contenttype="table"
						title="sec.rolequery.query" i18nRes="i18n.secframe_resource"
						width="100%" allowcontract="false" frameclosed="false">
						<ai:contractitem />
								<ai:dbform formid="secRoleSearchForm"
									setname="com.ai.secframe.sysmgr.web.SETSecRole"
									datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
									implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecRoleSV"
									implservice_querymethod="querySecRole" initial="false"
									editable="true">
									<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
										<tr>
											<td class="td_font">
												<i18n:message key="sec.rolequery.name" res="i18n.secframe_resource"/>
											</td>
											<td>
												<ai:dbformfield formid="secRoleSearchForm" fieldname="ROLE_NAME" width="150" editable="true" visible="true" />
											<td class="td_font">
												<i18n:message key="sec.rolequery.style" res="i18n.secframe_resource"/>
											</td>
											<td>
												<ai:dbformfield formid="secRoleSearchForm" fieldname="ROLE_TYPE" width="150" editable="true" visible="true" />
											</td>
										</tr>
										<tr>
											<td class="td_font">
												<i18n:message key="sec.rolequery.city" res="i18n.secframe_resource"/>
											</td>
											<td>
												<ai:dbformfield formid="secRoleSearchForm" fieldname="REGION_CODE" width="150" editable="true" visible="true" />
											</td>
											<td align="center" colspan="2"><ai:button text="sec.query" i18nRes="i18n.secframe_resource" id="searchBtn" onclick="search()" />
											</td>
										</tr>
									</table>
								</ai:dbform>
					</ai:contractframe>
	</body>
</HTML>
<script type="text/javascript">
var flag = 1;
var condition = "";
init();
function init(){
	window.parent.qryObj(condition);
}
function search()
{
   var secRoleSearchForm = g_FormRowSetManager.get("secRoleSearchForm");
   var roleName = secRoleSearchForm.getValue("ROLE_NAME");
   var roleType = secRoleSearchForm.getValue("ROLE_TYPE");
   var regionCode = secRoleSearchForm.getValue("REGION_CODE");
   condition = "roleName="+roleName+"&roleType="+roleType+"&regionCode="+regionCode;
   init();
}	
</script>
	