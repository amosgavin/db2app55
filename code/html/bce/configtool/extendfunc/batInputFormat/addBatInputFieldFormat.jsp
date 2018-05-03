<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>

<%
	
%>
<html>
	<head>
		<title></title>
		<script language="javascript" src="../common/js/configtool.js"></script>
	</head>

	<body onload="init()">
		<ai:contentframe id="" title="BES0000632" i18nRes='CRM'
			contenttype="table" width="100%">
			<ai:dbform formid="inputFieldFormatForm"
				setname="com.ai.bce.web.BceBatInputFieldFormat" editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfBatInputFieldFormatSV"
				implservice_querymethod="getBatInputFieldFormatValue(String configId,String listType,String seqNo)"
				initial="false" onvalchange="">
				<table width="98%" align="center" border="0" cellpadding="1"
					cellspacing="2">
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000130")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td class="td_font">
							<ai:dbformfield fieldname="LIST_TYPE"
								formid="inputFieldFormatForm" width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000131")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="SEQ_NO" formid="inputFieldFormatForm"
								width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000129")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="CONFIG_ID"
								formid="inputFieldFormatForm" visible="false" />
							<ai:dbformfield fieldname="FIELD_NAME"
								formid="inputFieldFormatForm" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000133")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="TITLE" formid="inputFieldFormatForm"
								width="200" />
						</td>

					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000134")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="VERIFY_SRVNAME"
								formid="inputFieldFormatForm" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000132")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="STATE" formid="inputFieldFormatForm"
								width="200" />
						</td>

					</tr>
					<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000111")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="MODULE_ID" formid="inputFieldFormatForm"
								width="200" />
						</td>

					</tr>
					<tr>
						<td colspan="8" align=center>
							<hr style="width: 90%" />
						</td>
					</tr>
				</table>
			</ai:dbform>
			<div class="area_button">
				<ai:button text="BES0000319" i18nRes="CRM" onclick="save()" />
				<ai:button text="BES0000320" i18nRes="CRM" onclick="window.close()" />
			</div>
		</ai:contentframe>
	</body>
	<script type="text/javascript">
	function getInputFieldFormatForm(){
		return g_FormRowSetManager.get("inputFieldFormatForm");
	}
	function init(){
		if(window.dialogArguments.config_id != null && window.dialogArguments.config_id != ''&&window.dialogArguments.list_type != null&&window.dialogArguments.list_type!=''&&window.dialogArguments.seq_no != null &&window.dialogArguments.seq_no != ''){
			getInputFieldFormatForm().refresh('configId='+window.dialogArguments.config_id+'&listType='+window.dialogArguments.list_type+'&seqNo='+window.dialogArguments.seq_no);
			getInputFieldFormatForm().setColEditSts('LIST_TYPE',false);
			getInputFieldFormatForm().setColEditSts('SEQ_NO',false);
		}else{
			getInputFieldFormatForm().setValue('MODULE_ID',window.dialogArguments.module_id);
			getInputFieldFormatForm().setValue('CONFIG_ID',window.dialogArguments.config_id);
			getInputFieldFormatForm().setValue('STATE',1);
		}
	}
	function save(){
		var checkField = getInputFieldFormatForm().isFieldNull("LIST_TYPE,SEQ_NO,TITLE",true);
	   		if(checkField){
	   			return;
	   		}
	   	var list = new Array();
	    list.push(getInputFieldFormatForm());
	    var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
		if (ud.getValueByName("FLAG") == "ERROR") {
			alert(crm_i18n_msg("BEC0000013"));
			return;
		} 
		window.returnValue=1;
		window.close();
	}
	</script>
</html>


