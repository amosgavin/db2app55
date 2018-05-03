<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>

<html>

	<head>
		<title><%=LocaleResourceFactory.getResource("BES0000637")%></title>
	</head>

	<body onload="init()">
		<ai:contentframe contenttype="table" title="BES0000640" i18nRes="CRM"
			id="" width="100%">
			<ai:dbform formid="groupForm" setname="com.ai.bce.web.BceFormGroup"
				editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfFrameAreaFormSV"
				implservice_querymethod=""
				initial="false">
				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000645")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
						<ai:dbformfield fieldname="BCE_FRAME_ID" formid="groupForm"
								editable="false" width="200" />
							<ai:dbformfield fieldname="GROUP_ID" formid="groupForm"
								 visible="false" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000646")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="FORM_ID" formid="groupForm"
								editable="false" width="200" />
						</td>

					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000648")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="GROUP_NAME" formid="groupForm"
								 width="200" />
						</td>

						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000652")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="SEQ_NO" formid="groupForm"
								 width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000383")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="MODULE_ID" formid="groupForm"
								 width="200" />
						</td>
						
					
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000650")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="IS_ALLOW_STRACT" formid="groupForm"
								 width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000651")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="IS_CLOSED" formid="groupForm"
								 width="200" />
						</td> 
						
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000649")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="GROUP_STYLE" formid="groupForm"
								 width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000639")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td >
							<ai:dbformfield fieldname="ATTR_1"
								formid="groupForm"  width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000641")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td >
							<ai:dbformfield fieldname="ATTR_2"
								formid="groupForm"  width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000642")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td >
							<ai:dbformfield fieldname="ATTR_3"
								formid="groupForm"  width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000643")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td >
							<ai:dbformfield fieldname="ATTR_4"
								formid="groupForm"  width="200" />
						</td>
						</tr>
						<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000644")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td >
							<ai:dbformfield fieldname="ATTR_5"
								formid="groupForm"  width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td >
							<ai:dbformfield fieldname="STATE"
								formid="groupForm"  width="200" />
						</td>
					</tr>
				</table>
			</ai:dbform>
			<div class="area_button">
				<ai:button text="BES0000319" i18nRes="CRM" onclick="saveGroup()" />
				<ai:button text="BES0000480" i18nRes="CRM" onclick="cancel()" />
			</div>
		</ai:contentframe>
</html>

<script type="text/javascript">
function getGroupForm(){
  return g_FormRowSetManager.get("groupForm");
}

function init(){
	var obj = window.dialogArguments;
	getGroupForm().setValue("BCE_FRAME_ID",obj.bceFrameId,obj.bceFrameId);
	getGroupForm().setValue("FORM_ID",obj.formId,obj.formId);
	getGroupForm().setValue("MODULE_ID",obj.moduleId);
	getGroupForm().setValue("STATE","1");
}

function saveGroup(){
	var form = getGroupForm();
  if(form.toXmlString(true) == ""){
    alert(crm_i18n_msg("BEC0000008"));
    return;
  }
  if(form.isFieldNull("GROUP_NAME",true)){
    return;
  }
  var list = new Array();
	list.push(form);
	var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
	if(msg.getValueByName("FLAG")=="ERROR" ){
		alert(crm_i18n_msg("BEC0000013"));
		return;
	}
	window.returnValue=1;
	window.close();
}

function cancel(){
	window.close();
}
</script>
