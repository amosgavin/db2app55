<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<html>
<%
String bceFrameId = request.getParameter("bceFrameId");
String formId = request.getParameter("formId");
if(null == bceFrameId|| "".equals(bceFrameId)){
	bceFrameId = "-1";
} 
if(null == formId|| "".equals(formId)){
	formId = "-1";
} %>
<head>
	<title><%= LocaleResourceFactory.getResource("BES0000636")%></title>
</head>
<body onload="init()">
	<ai:contentframe id="" title="BES0000636" i18nRes="CRM" contenttype="table" width="98%">
		<ai:dbform formid="dbformRelateDetail"
			setname="com.ai.bce.web.BceFrameAreaForm" editable="true"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.ai.bce.configtool.service.interfaces.IConfFrameAreaFormSV"
			implservice_querymethod="getFrameAreaFormValueById(String bceFrameId,String formId)"
			initial="false" onvalchange="">
			<table width="98%" align="center" border="0" cellpadding="1"
				cellspacing="2">
				<tr>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000191")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="BCE_FRAME_ID" editable="false"
							formid="dbformRelateDetail"  width="200" />
					</td>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000193")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="FORM_ID" formid="dbformRelateDetail"
							 width="200" />
					</td>

				</tr>
				<tr>
					<td class="td_font">
						DATA_MODEL<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="DATA_MODEL" formid="dbformRelateDetail"
							 width="200" />
					</td>

					<td class="td_font">
						SERVICE_NAME<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="SERVICE_NAME"
							formid="dbformRelateDetail"  width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						QUERY_METHOD<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="QUERY_METHOD"
							formid="dbformRelateDetail"  width="200" />
					</td>
					<td class="td_font">
						WIDTH<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="WIDTH" formid="dbformRelateDetail"
							 width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						CONDITION_NAME<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="CONDITION_NAME"
							formid="dbformRelateDetail"  width="200" />
					</td>
					<td class="td_font">
						PARAMETER_NAME<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="PARAMETER_NAME"
							formid="dbformRelateDetail"  width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						IS_INITIAL<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="IS_INITIAL" formid="dbformRelateDetail"
							 width="200" />
					</td>
					<td class="td_font">
						IS_EDITABLE<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="IS_EDITABLE"
							formid="dbformRelateDetail"  width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						NEED_REFRESH<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="NEED_REFRESH"
							formid="dbformRelateDetail"  width="200" />
					</td>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000111")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="MODULE_ID"
							formid="dbformRelateDetail"  width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						ON_VALUECHANGE:
					</td>
					<td>
						<ai:dbformfield fieldname="ON_VALUECHANGE"
							formid="dbformRelateDetail"  width="200" />
					</td>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="STATE" formid="dbformRelateDetail"
							 width="200" />
						<ai:dbformfield fieldname="FORM_TYPE" formid="dbformRelateDetail"
							visible="false" width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000192")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="COLS"
							formid="dbformRelateDetail"  width="200" />
					</td>
					</tr>
			</table>
			<div class="area_button">
			<ai:button text="BES0000319" i18nRes="CRM" onclick="save()" />
			<ai:button text="BES0000320" i18nRes="CRM" onclick="cancel()" />
			</div>
		</ai:dbform>
	</ai:contentframe>
</body>
<script type="text/javascript">
function init(){
	if("<%=formId%>" != -1){
		getdbformRelateForm().refresh("bceFrameId=<%=bceFrameId%>&formId=<%=formId%>");
		getdbformRelateForm().setColEditSts("FORM_ID",false);
	}else{
		getdbformRelateForm().setValue("BCE_FRAME_ID","<%=bceFrameId%>")
		getdbformRelateForm().setValue("STATE",1);
		getdbformRelateForm().setValue("FORM_TYPE",1);
		getdbformRelateForm().setValue("MODULE_ID",window.dialogArguments);
		getdbformRelateForm().setValue("IS_EDITABLE",1);
		getdbformRelateForm().setValue("IS_INITIAL",0);
		getdbformRelateForm().setValue("NEED_REFRESH",1);
	}
}

function save(){
	var checkField = getdbformRelateForm().isFieldNull("FORM_ID",true);
	if(checkField){
		return;
	}
	var form = getdbformRelateForm();
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

function getdbformRelateForm(){
	return g_FormRowSetManager.get("dbformRelateDetail");
}
</script>
</html>
