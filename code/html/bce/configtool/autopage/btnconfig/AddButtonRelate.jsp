<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>

<%@ page import="com.ai.appframe2.web.HttpUtil" %>

<%
	String buttonId = HttpUtil.getParameter(request, "buttonId");
	String oldAreaId = HttpUtil.getParameter(request, "areaId");
	String frameId = HttpUtil.getParameter(request, "frameId");
	if(buttonId == null)
	{
		buttonId = "";
	}
	if(oldAreaId == null)
	{
		oldAreaId = "";
	}
	if(frameId == null)
	{
		frameId = "";
	}
%>
<html>
<head>
<title><%=LocaleResourceFactory.getResource("BES0000497")%></title>

<script language="javascript" src="../common/js/configtool.js"></script>
<script type="text/javascript">
	function initButton()
	{
		var form = g_FormRowSetManager.get("buttonRelateForm");
		var buttonId = '<%=buttonId%>';
		var frameId = '<%=frameId%>';
		var oldAreaId = '<%=oldAreaId%>';
		if(buttonId == "null" || buttonId == "")
		{
			form.setValue("BCE_FRAME_ID", frameId);
			form.setValue("STATE", 1);
			form.setValue("MODULE_ID", window.dialogArguments);
		}
		else
		{
			form.refresh("cond= BCE_FRAME_ID='"+frameId+"' AND AREA_ID='"+oldAreaId+"' AND BUTTON_ID='"+buttonId+"'");
		}
	}
</script>
</head>
<body onLoad="initButton()">
	<center>
		<ai:contentframe id="" title="BES0000497" i18nRes="CRM" contenttype="table" width="98%">
		<ai:dbform formid="buttonRelateForm" setname="com.ai.bce.web.BceFrameButton" editable="true"
   				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService" initial="false" onvalchange="" 
   				implservice_name = "com.ai.bce.configtool.service.interfaces.IConfButtonSV"
   				implservice_querymethod = "getBceFrameButton(String cond)" >
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000360")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="BCE_FRAME_ID" formid="buttonRelateForm" editable="false" width="180"/></td>
				</tr><tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000181")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="BUTTON_ID"  formid="buttonRelateForm" editable="false" width="160"/><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif" id="selButtonBtn"
								alt='<%=LocaleResourceFactory.getResource("BES0000611")%>' onClick="showButtonDialog()" align="absmiddle" style="cursor: hand;" />
					</td>
				</tr><tr>	
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000359")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="AREA_ID" formid="buttonRelateForm"  width="180"/></td>
				</tr><tr>	
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000362")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="EVENT_CLICK" formid="buttonRelateForm"  width="180"/></td>
				</tr><tr>	
					<td class="td_font">ENABLE<%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="ENABLE" formid="buttonRelateForm"  width="180"/></td>
				</tr><tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000121")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="MODULE_ID" formid="buttonRelateForm"  width="180"/></td>
				</tr><tr>	
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="STATE" formid="buttonRelateForm"  width="180"/></td>
				</tr>
			</table>
		</ai:dbform>
	  </ai:contentframe>
	  <div class="area_button">
		<ai:button text="BES0000319" i18nRes="CRM" onclick = "saveButton()"/>&nbsp;&nbsp;
		<ai:button text="BES0000480" i18nRes="CRM" onclick = "closeWindow()"/>
	  </div>
	 </center> 
</body> 
<script type="text/javascript">
		
    	/**
    	 * 保存
    	 */
    	function saveButton()
    	{
    		var buttonRelateForm = g_FormRowSetManager.get("buttonRelateForm");
    		if(buttonRelateForm.toXmlString(true) == "")
    		{
    			alert(crm_i18n_msg("BEC0000008"));
    			return;
    		}
    		if(buttonRelateForm.isFieldNull("BUTTON_ID,AREA_ID",true))
    		{
    			return;
    		}
  			var list = new Array();
	      	list.push(buttonRelateForm);
	        var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);

       if (ud.getValueByName("FLAG") == "ERROR") {
			  if(!ud.getValueByName("MESSAGE"))
			    alert(crm_i18n_msg("BEC0000013"));
				return;
			}			
			window.self.close();
    	}
    	/**
		 * 关闭窗口
		 */
		function closeWindow()
		{
			window.self.close();
		}    	
    	/**
    	 * 选择关联的按钮
    	 */
    	function showButtonDialog()
    	{
			var url = "<%=request.getContextPath()%>/bce/configtool/autopage/btnconfig/selectButton.jsp?module_id="+window.dialogArguments;
	 		var retVal = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");
	 		if(retVal != null)
	 		{
	 			var form = g_FormRowSetManager.get("buttonRelateForm");
	 			form.setValue("BUTTON_ID", retVal);
	 		}    		
    	}
</script>

</html>


