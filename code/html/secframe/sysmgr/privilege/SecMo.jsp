<%@ page contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title><i18n:message key="sec.secmo.addfile" res="i18n.secframe_resource"/></title>
	</head>
	<body>
				<ai:dbform formid="frmsysmo"
					datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecMoSV"
					implservice_querymethod="querySecMo"	
					setname="com.ai.secframe.sysmgr.web.SETSecMo" editable="true"
					initial="false">
					
			   		<ai:contractframe id="" contenttype="table" title="sec.secmo.addfile" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
			  			<ai:contractitem/>
		  				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
						<tr>
							<td class="td_font">
								<i18n:message key="sec.secmo.domainid" res="i18n.secframe_resource"/>
							</td>
							<td>
								<input type="text" value="<%=SessionManager.getUser().getDomainId()%>" width="150" readonly>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								<i18n:message key="sec.secmo.filename" res="i18n.secframe_resource"/>
							</td>
						    <td><ai:dbformfield width="150" fieldname="NAME" formid="frmsysmo" editable="true" />
								<ai:dbformfield fieldname="DIR_ID" formid="frmsysmo" visible="false" />
								<ai:dbformfield fieldname="DIR_FULL_NAME" formid="frmsysmo" visible="false" />
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
var arrNode = window.dialogArguments;
var frmsysmo = g_FormRowSetManager.get("frmsysmo");
function saveDir(){
	if(frmsysmo.getValue("NAME").length<=0){
		alert(g_I18NMessage("sec_secmo", "sec_secmo_writename"));
		return false;
	}
	var dirFullName = (arrNode[1]==''?'':(arrNode[1]+'.'))+frmsysmo.getValue("NAME");
	frmsysmo.setValue("DIR_FULL_NAME",dirFullName);
	frmsysmo.setValue("DIR_ID",arrNode[0]);
	var list = new Array();
	list[0] =frmsysmo;
	saveRowSet(_gModuleName+"/business/com.ai.secframe.sysmgr.web.SecMoManageAction?action=saveSecMo",list);
	window.self.close();
}
//-->
</script>
