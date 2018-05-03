<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<base target="_self">
<html>
	<head>
		<title><i18n:message key="sec.secmodirectory.addpackage" res="i18n.secframe_resource"/></title>
	</head>
	<body>

				<ai:dbform formid="formSecMoDir"
					setname="com.ai.secframe.sysmgr.web.SETSecMoDirectory" editable="true" 
					initial="false">
					<ai:contractframe id="" contenttype="table" title="sec.secmodirectory.addpackage" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
			  			<ai:contractitem/>
		  				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
						<tr>
							<td  class="td_font">
								<i18n:message key="sec.secmodirectory.domainid" res="i18n.secframe_resource"/>
							</td>
							<td>
								<input type="text"
									value="<%=SessionManager.getUser().getDomainId()%>" width="150" readonly>
								<br>
							</td>
						</tr>
						<tr>
							<td  class="td_font">
								<i18n:message key="sec.secmodirectory.packagename" res="i18n.secframe_resource"/>
							</td>
							<td>
								<ai:dbformfield fieldname="NAME" formid="formSecMoDir"
									editable="true" width="150"/>
								<ai:dbformfield fieldname="PARENT_ID" formid="formSecMoDir"
									visible="false" />
							</td>
						</tr>
					</table>
					</ai:contractframe>
				</ai:dbform>
 			<div class="area_button">
				<ai:button text="sec.save" i18nRes="i18n.secframe_resource" onclick="saveDir();" />
				<ai:button text="sec.cancel" i18nRes="i18n.secframe_resource" onclick="window.self.close();" />
			</div>
	</body>
</html>
<script type="text/javascript">
<!--
var node = window.dialogArguments;
var formSecMoDir = g_FormRowSetManager.get("formSecMoDir");

function saveDir(){
	formSecMoDir.setValue("PARENT_ID",node.value);
	if(formSecMoDir.getValue("NAME").length<=0){
		window.alert(g_I18NMessage("sec_secmodirectory", "sec_secmodirectory_writename"));
		return false;
	}
	var list = new Array();
	list[0] = formSecMoDir;
	saveRowSet(_gModuleName+"/business/com.ai.secframe.sysmgr.web.SecMoManageAction?action=saveSecMoDir",list);
	window.self.close();
}
//-->
</script>
