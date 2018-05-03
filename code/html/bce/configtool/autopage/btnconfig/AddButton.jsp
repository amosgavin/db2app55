<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>

<%@ page import="com.ai.appframe2.web.HttpUtil" %>

<%
	String buttonId = HttpUtil.getParameter(request, "buttonId");
	
%>
<html>
<head>
<title><%=LocaleResourceFactory.getResource("BES0000496")%></title>

<script language="javascript" src="../common/js/configtool.js"></script>

</head>
<body onLoad="initButton()">
		<ai:contentframe id="" title="BES0000496" i18nRes="CRM" contenttype="table" width="98%">
		<ai:dbform formid="buttonForm" setname="com.ai.bce.web.BceButton" editable="true"
   				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService" initial="false" onvalchange="" 
   				implservice_name = "com.ai.bce.configtool.service.interfaces.IConfButtonSV"
   				implservice_querymethod = "getBceButtonValues(String cond)" >
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000180")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="BUTTON_ID" formid="buttonForm" editable="false" width="180"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000179")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="BUTTON_CODE" formid="buttonForm"  width="180"/></td>
				</tr>
				<tr>	
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000181")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="BUTTON_NAME" formid="buttonForm"  width="180"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000184")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="TEXT" formid="buttonForm"  width="180"/></td>
				</tr>
				<tr>					
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000183")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="I18N_RES" formid="buttonForm"  width="180"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000185")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="WIDTH" formid="buttonForm"  width="180"/>	</td>
				</tr>
				<tr>					
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000182")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="EVENT_CLICK" formid="buttonForm"  width="180"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000121")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="MODULE_ID" formid="buttonForm"  width="180"/></td>
				</tr>
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="STATE" formid="buttonForm"  width="180"/></td>
				</tr>
			</table>
		</ai:dbform>
	  </ai:contentframe>
	  <div class="area_button">
		<ai:button text="BES0000319" i18nRes="CRM" onclick = "saveButton()"/>&nbsp;&nbsp;
		<ai:button text="BES0000480" i18nRes="CRM" onclick = "closeWindow()"/>
	  </div>
</body> 
<script type="text/javascript">
		
		function initButton()
		{
			var form = g_FormRowSetManager.get("buttonForm");
			var buttonId = '<%=buttonId%>';
			if(buttonId == "null" || buttonId == "")
			{
				form.setValue("STATE", 1);
				form.setValue("MODULE_ID", window.dialogArguments);
			}
			else
			{
				form.refresh("cond= BUTTON_ID="+buttonId);
			}
		}
    	/**
    	 * ±£´æ
    	 */
    	function saveButton()
    	{
    		var buttonForm = g_FormRowSetManager.get("buttonForm");
    		if(buttonForm.toXmlString(true) == "")
    		{
    			alert(crm_i18n_msg("BEC0000008"));
    			return;
    		}
    		if(buttonForm.isFieldNull("BUTTON_CODE,BUTTON_NAME,TEXT",true))
    		{
    			return;
    		}
  			var list = new Array();
	      	list.push(buttonForm);
	        var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);

      if (ud.getValueByName("FLAG") == "ERROR") {
			  if(!ud.getValueByName("MESSAGE"))
			    alert(crm_i18n_msg("BEC0000013"));
				return;
			} 			
			window.self.close();
    	}
    	/**
		 * ¹Ø±Õ´°¿Ú
		 */
		function closeWindow()
		{
			window.self.close();
		}    	
    	
</script>

</html>


