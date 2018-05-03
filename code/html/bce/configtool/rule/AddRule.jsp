<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>

<html>
<head>
<title><%=LocaleResourceFactory.getResource("BES0000490")%></title>

<script language="javascript" src="../common/js/configtool.js"></script>
</head>
<body onLoad="initRule()">
<ai:contentframe id="" title="BES0000490"  i18nRes="CRM" contenttype="table"  width="98%">
				<ai:dbform formid="ruleDetial" setname="com.ai.bce.web.BceRule" editable="true"
	  				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService" initial="false" onvalchange="" 
	  				implservice_name = "com.ai.bce.service.interfaces.IBceStudioSV"
	  				implservice_querymethod = "getBceRuleValues(String cond)">		   					   						
				
<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
<ai:dbformfield fieldname="RULE_ID" formid="ruleDetial" editable="true" visible="false"/>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000511")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="RULE_NAME" formid="ruleDetial" width="200"/></td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000201")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="MODULE_ID" formid="ruleDetial" width="200"/></td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000510")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="RULE_KIND" formid="ruleDetial" width="200"/></td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000512")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="RULE_TYPE" formid="ruleDetial" width="200"/></td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000296")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="FILE_NAME" formid="ruleDetial" width="180"/><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif" id="chooseFileName"
								alt='<%=LocaleResourceFactory.getResource("BES0000611")%>' onClick="getFileName()" align="absmiddle"
								style="cursor: hand;" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000297")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="FUNC_NAME" formid="ruleDetial" width="200"/></td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000298")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="PARAM_LIST" formid="ruleDetial" width="200"/></td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="STATE" formid="ruleDetial" width="200"/></td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="REMARKS" formid="ruleDetial" editable="true" width="200"/></td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000513")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="ALERT_MESSAGE" formid="ruleDetial" width="200"/></td>
				</tr>
				</table>
			</ai:dbform>	
</ai:contentframe>							
		<div class="area_button">
			<ai:button text="BES0000319" i18nRes="CRM" onclick = "save()" />&nbsp;&nbsp;
			<ai:button text="BES0000480" i18nRes="CRM" onclick = "closeWindow()" />
		</div>	
</body> 
<script type="text/javascript">
		/**
		 * 初始化规则
		 */
		function initRule()
		{
			var ruleForm = g_FormRowSetManager.get("ruleDetial");
			ruleForm.setValue("MODULE_ID", window.dialogArguments);
			ruleForm.setValue("RULE_KIND", 1);
			ruleForm.setValue("RULE_TYPE", 1);
			ruleForm.setValue("STATE", 1);
		}
    	/**
    	 * 保存
    	 */
    	function save()
    	{
    		var ruleDetialForm = g_FormRowSetManager.get("ruleDetial");
    		var xmlBody = ruleDetialForm.toXmlString(true);
    		if(xmlBody == "")
    		{
    			alert(crm_i18n_msg("BEC0000008"));
    			return;
    		}
  			var list = new Array();
	        list.push(ruleDetialForm);
	   var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
			if (ud.getValueByName("FLAG") == "ERROR") {
			  if(!ud.getValueByName("MESSAGE"))
			    alert(crm_i18n_msg("BEC0000013"));
				return;
			}
			window.self.close();
    	}
    	/**
    	 * 获取规则文件名称
    	 */
    	function getFileName()
    	{
    		var ruleDetialForm = g_FormRowSetManager.get("ruleDetial");
    		var ruleType = ruleDetialForm.getValue("RULE_TYPE");
    		var rtnVal = null;
    		if(ruleType != null && ruleType == "1")
    		{
	    		rtnVal = window.showModalDialog("<%=request.getContextPath()%>/bce/configtool/model/js/selectJS.jsp", "",
						"scroll:no;resizable:no;help:no;status:no;dialogHeight:580px;dialogWidth:800px");
			}
			else if(ruleType != null && ruleType == "2")
			{
				rtnVal = window.showModalDialog("<%=request.getContextPath()%>/bce/configtool/model/clazz/selectClazz.jsp", "",
						"scroll:no;resizable:no;help:no;status:no;dialogHeight:580px;dialogWidth:800px");
			}
			if(rtnVal != null)
			{
				var pageDetailForm = g_FormRowSetManager.get("ruleDetial");
				pageDetailForm.setValue("FILE_NAME", rtnVal.treeValue);
				if(rtnVal.tableValue != null)
				{
					pageDetailForm.setValue("FUNC_NAME", rtnVal.tableValue);
				}
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


