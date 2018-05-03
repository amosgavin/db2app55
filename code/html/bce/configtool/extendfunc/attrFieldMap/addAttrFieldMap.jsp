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
			<ai:dbform formid="attrFieldMapForm" setname="com.ai.bce.web.BceAttrFieldMap"
				editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfAttrFieldMapSV"
				implservice_querymethod="getAttrFieldMapValue(String configId)"
				initial="false" onvalchange="">
				<table width="98%" align="center" border="0" cellpadding="1"
					cellspacing="2">
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000126")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="CONFIG_ID" formid="attrFieldMapForm"
								visible="false" width="200" />
							<ai:dbformfield fieldname="BUSINESS_ID" formid="attrFieldMapForm"
								 width="180" /><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								onClick="getBS()" align="absmiddle" 
								style="cursor: hand;" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000124")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="ATTR_ID" formid="attrFieldMapForm"
								 width="200" />
						</td>

					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000765")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="DATA_TYPE" formid="attrFieldMapForm"
								 width="200" />
						</td>

						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000764")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="DEST_FIELD_NAME" formid="attrFieldMapForm"
								 width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000127")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="DEST_TABLE_NAME" formid="attrFieldMapForm"
								 width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000202")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="REMARKS" formid="attrFieldMapForm"
								 width="200" />
						</td>
						</tr>
					<tr>
					
					<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000125")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="ATTR_TYPE" formid="attrFieldMapForm"
								 width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000111")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="MODULE_ID" formid="attrFieldMapForm"
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
	function getAttrFieldMapForm(){
		return g_FormRowSetManager.get("attrFieldMapForm");
	}
	function getBS(){
		var rtnVal = window.showModalDialog("../../bceframe/selectBusiness.jsp", "",
			"scroll:no;resizable:no;help:no;status:no;dialogHeight:580px;dialogWidth:800px");
			if(rtnVal != null && rtnVal != '')
				getAttrFieldMapForm().setValue("BUSINESS_ID",rtnVal);
	}
	function init(){
		if(window.dialogArguments.config_id != null && window.dialogArguments.config_id != ''){
			getAttrFieldMapForm().refresh('configId='+window.dialogArguments.config_id);
		}else{                                 
			getAttrFieldMapForm().setValue('MODULE_ID',window.dialogArguments.module_id);
			getAttrFieldMapForm().setValue('ATTR_TYPE',"ORD_SRV_ATTR");
		}
	}
	function save(){
	   	var list = new Array();
	    list.push(getAttrFieldMapForm());
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


