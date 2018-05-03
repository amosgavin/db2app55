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
			<ai:dbform formid="inputFormatForm" setname="com.ai.bce.web.BceBatInputFormat"
				editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfBatInputFormatSV"
				implservice_querymethod="getBatInputFormatValue(String configId)"
				initial="false" onvalchange="">
				<table width="98%" align="center" border="0" cellpadding="1"
					cellspacing="2">
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000135")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="CONFIG_ID" formid="inputFormatForm"
								visible="false" width="200" />
							<ai:dbformfield fieldname="BUSINESS_ID" formid="inputFormatForm"
								 width="180" /><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								onClick="getBS()" align="absmiddle" 
								style="cursor: hand;" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000141")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="PROD_SPEC_ID" formid="inputFormatForm"
								 width="200" />
						</td>

					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000144")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="ROLE_ID" formid="inputFormatForm"
								 width="200" />
						</td>

						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000138")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="INPUT_TYPE" formid="inputFormatForm"
								 width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000139")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="MAX_NO" formid="inputFormatForm"
								 width="200" />
						</td>


						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000147")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="STYLE_DESC" formid="inputFormatForm"
								 width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000148")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="STYLE_IMG" formid="inputFormatForm"
								 width="200" />
						</td>

						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000140")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="PARSE_SERVICE"
								formid="inputFormatForm"  width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000136")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="BUSI_SERVICE" formid="inputFormatForm"
								 width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000143")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="RET_CHAR" formid="inputFormatForm"
								 width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000145")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="SPLIT_CHAR" formid="inputFormatForm"
								 width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000622")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="EXTRA_1" formid="inputFormatForm"
								 width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000623")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="EXTRA_2" formid="inputFormatForm"
								 width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000146")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="STATE" formid="inputFormatForm"
								 width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="REMARKS" formid="inputFormatForm"
								 width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000111")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="MODULE_ID" formid="inputFormatForm"
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
	function getInputFormatForm(){
		return g_FormRowSetManager.get("inputFormatForm");
	}
	function getBS(){
		var rtnVal = window.showModalDialog("../../bceframe/selectBusiness.jsp", "",
			"scroll:no;resizable:no;help:no;status:no;dialogHeight:580px;dialogWidth:800px");
			if(rtnVal != null && rtnVal != '')
				getInputFormatForm().setValue("BUSINESS_ID",rtnVal);
	}
	function init(){
		if(window.dialogArguments.config_id != null && window.dialogArguments.config_id != ''){
			getInputFormatForm().refresh('configId='+window.dialogArguments.config_id);
		}else{                                 
			getInputFormatForm().setValue('MODULE_ID',window.dialogArguments.module_id);
			getInputFormatForm().setValue('STATE',1);
		}
	}
	function save(){
	   	var list = new Array();
	    list.push(getInputFormatForm());
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


