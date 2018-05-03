<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>

<%@ page import="com.ai.appframe2.web.HttpUtil" %>

<%
	String attrId = HttpUtil.getParameter(request, "attrId");
	String moduleId = HttpUtil.getParameter(request, "moduleId");
	String attrIdEditable = "false";
	if("".equals(attrId) && "1".equals(moduleId)){
		attrIdEditable = "true";
	}
%>
<html>
<head>
<title><%=LocaleResourceFactory.getResource("BES0000495")%></title>

<script language="javascript" src="../common/js/configtool.js"></script>

</head>
<body onLoad="initAttr()">
		<ai:contentframe id="" title="BES0000495" i18nRes="CRM" contenttype="table" width="98%">
		<ai:dbform formid="attrForm" setname="com.ai.bce.web.BceAttr" editable="true"
   				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService" initial="false" onvalchange="" 
   				implservice_name = "com.ai.bce.configtool.service.interfaces.IConfFrameAreaFormSV"
   				implservice_querymethod = "getBceAttr(String cond)" >
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000103")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="ATTR_ID" formid="attrForm" editable="<%=attrIdEditable %>" width="180"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000121")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="MODULE_ID" formid="attrForm"  width="180"/></td>
				</tr>
				<tr>	
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000122")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="OBJ_NAME" formid="attrForm"  width="180"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000104")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="ATTR_CODE" formid="attrForm"  width="180"/></td>
				</tr>
				<tr>					
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000116")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="ATTR_NAME" formid="attrForm"  width="180"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000119")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="I18N_RES" formid="attrForm"  width="180"/>	</td>
				</tr>
				<tr>					
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000117")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="FIELD_TYPE" formid="attrForm"  width="180"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000123")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="RULE_ID" formid="attrForm"  width="160" editable="false"/><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif" id="selButtonBtn"
								alt='<%=LocaleResourceFactory.getResource("BES0000611")%>' onClick="showRuleDialog()" align="absmiddle" style="cursor: hand;" />
					</td>
				</tr>				
				<tr>					
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000624")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="FIELD_WIDTH" formid="attrForm"  width="180"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000590")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="COL_SPAN" formid="attrForm"  width="180"/></td>
				</tr>
				<tr>					
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000625")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="IS_NULLABLE" formid="attrForm"  width="180"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000626")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="EDIT_TYPE" formid="attrForm"  width="180"/></td>
				</tr>
				<tr>					
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000627")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="MAX_LENGTH" formid="attrForm"  width="180"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000628")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="RES_SRC" formid="attrForm"  width="180"/></td>
				</tr>
				<tr>					
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000629")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="RES_PARAM" formid="attrForm"  width="180"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000620")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="DEFAULT_VALUE" formid="attrForm"  width="180"/></td>
				</tr>
				<tr>					
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000630")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="VALUE_CLASS" formid="attrForm"  width="180"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000118")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="REMARKS" formid="attrForm"  width="180"/></td>
				</tr>				
				<tr>		
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="STATE" formid="attrForm"  width="180"/></td>
				</tr>
			</table>
		</ai:dbform>
	  </ai:contentframe>
	  <div class="area_button">
		<ai:button text="BES0000319" i18nRes="CRM" onclick = "saveAttr()"/>&nbsp;&nbsp;
		<ai:button text="BES0000480" i18nRes="CRM" onclick = "closeWindow()"/>
	  </div>
</body> 
<script type="text/javascript">
		
		function initAttr()
		{
			var form = g_FormRowSetManager.get("attrForm");
			var attrId = '<%=attrId%>';
			if(attrId == "null" || attrId == "")
			{
				form.setValue("STATE", 1);
				form.setValue("MODULE_ID", window.dialogArguments);
			}
			else
			{
				form.refresh("cond= ATTR_ID="+attrId);
			}
		}
    	/**
    	 * 保存
    	 */
    	function saveAttr()
    	{
    		var attrForm = g_FormRowSetManager.get("attrForm");
    		if(attrForm.toXmlString(true) == "")
    		{
    			alert(crm_i18n_msg("BEC0000301"));
    			return;
    		}
    		if(attrForm.isFieldNull("ATTR_CODE,ATTR_NAME",true))
    		{
    			return;
    		}
  			var list = new Array();
	      	list.push(attrForm);
	        var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);

			if (ud.getValueByName("FLAG") == "ERROR") {
			  if(!ud.getValueByName("MESSAGE"))
			    alert(crm_i18n_msg("BEC0000013"));
				return;
			}				
			window.self.close();
    	}
    	/**
    	 * 选择规则
    	 */
    	function showRuleDialog()
    	{
    		var url = "<%=request.getContextPath()%>/bce/configtool/rule/selectRulesDialog.jsp?module_id="+window.dialogArguments+"&rulesetType=1";
	 		var retVal = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");
	 		if(retVal != null)
	 		{
	 			var form = g_FormRowSetManager.get("attrForm");
	 			form.setValue("RULE_ID", retVal);
	 		}  
    	}
    	/**
		 * 关闭窗口
		 */
		function closeWindow()
		{
			window.self.close();
		}    	
    	
</script>

</html>


