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
		<ai:contentframe id="" title="BES0000632" i18nRes='CRM' contenttype="table" width="100%">
			<ai:dbform formid="extTableForm" setname="com.ai.bce.web.BceExtTableConfig"
				editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfExtTableSV"
				implservice_querymethod="getExtTable(String configId)"
				initial="false" onvalchange="">
				<table width="98%" align="center" border="0" cellpadding="1"
					cellspacing="2">
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000186")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="CONFIG_ID" formid="extTableForm"
								visible="false" width="200" />
							<ai:dbformfield fieldname="BO_NAME" formid="extTableForm"
								 width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000188")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="EXT_TABLE_NAME" formid="extTableForm"
								 width="200" />
						</td>

					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000189")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="REL_COL_NAME" formid="extTableForm"
								 width="200" />
						</td>

						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000190")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="REL_TYPE" formid="extTableForm"
								 width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="STATE" formid="extTableForm"
								 width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000202")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="REMARKS" formid="extTableForm"
								 width="200" />
						</td>
						</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000111")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="MODULE_ID" formid="extTableForm"
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
	function getExtTableForm(){
		return g_FormRowSetManager.get("extTableForm");
	}
	function init(){
		if(window.dialogArguments.config_id != null && window.dialogArguments.config_id != ''){
			getExtTableForm().refresh('configId='+window.dialogArguments.config_id);
		}else{                                 
			getExtTableForm().setValue('MODULE_ID',window.dialogArguments.module_id);
			getExtTableForm().setValue('STATE',1);
		}
	}
	function save(){
	   	var list = new Array();
	    list.push(getExtTableForm());
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


