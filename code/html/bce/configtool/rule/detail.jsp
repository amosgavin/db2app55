<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>


<%
	
	//规则ID
	String curRuleId = HttpUtil.getAsString(request ,"RULE_ID"); 
	String initial ="false";
	
	if(curRuleId != null && !"".equals(curRuleId))
	{
		request.setAttribute("cond","RULE_ID="+curRuleId);
		initial = "true";
	}
%>
<html>
<head>
<title>
</title>

<script language="javascript" src="../common/js/configtool.js"></script>

<script type="text/javascript">
		function initButton()
		{
			<%
				if(initial.equals("true")){
			%>
				document.getElementById("modifyDiv").style.display="block";
			<%}%>
		}
</script>
</head> 
<body  onload="initButton()">

	<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem>
			</ai:contractitem>
			
				<ai:dbform formid="ruleDetial" setname="com.ai.bce.web.BceRule" editable="false"
	  				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService" initial="<%=initial %>" onvalchange="" 
	  				implservice_name = "com.ai.bce.configtool.service.interfaces.IConfRuleSV"
	  				implservice_querymethod = "getBceRuleValues(String cond, int $STARTROWINDEX,int $ENDROWINDEX)">
				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000299")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="RULE_ID" formid="ruleDetial" editable="false" width="200"/></td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000511")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="RULE_NAME" formid="ruleDetial" width="200"/></td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000201")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="MODULE_ID" formid="ruleDetial" width="200"/></td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000510")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="RULE_KIND" formid="ruleDetial" width="200"/></td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000512")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="RULE_TYPE" formid="ruleDetial" width="200"/></td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000296")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="FILE_NAME" formid="ruleDetial" width="180"/><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif" id="chooseFileName"
								alt='<%=LocaleResourceFactory.getResource("BES0000611")%>' onClick="getFileName()" align="absmiddle"
								style="cursor: hand;" disabled=true/>
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000297")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="FUNC_NAME" formid="ruleDetial" width="200"/></td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000298")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="PARAM_LIST" formid="ruleDetial" width="200"/></td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="STATE" formid="ruleDetial" width="200"/></td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="REMARKS" formid="ruleDetial" editable="true" width="200"/></td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000513")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="ALERT_MESSAGE" formid="ruleDetial" width="200"/></td>
					</tr>
					<tr>
					<td colspan="4" align="center">
						<table>
							<tr>
							<td>
								<div id="modifyDiv" style="display:none"> 
									<ai:button text="BES0000323" i18nRes="CRM" onclick = "modify()" />&nbsp;&nbsp;
								</div>
								<div id="saveDiv" style="display:none"> 
									<ai:button text="BES0000319" i18nRes="CRM" onclick = "save()" />&nbsp;&nbsp;
									<ai:button text="BES0000320" i18nRes="CRM" onclick = "setReadOnly()" />
								</div>
							</td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
			</ai:dbform>	
			
			</ai:contractframe>
			
</body> 
<script type="text/javascript">
		
		function refresh(ruleId)
	    { 
	    	g_FormRowSetManager.get("ruleDetial").refresh("cond=RULE_ID = "+ruleId);
	    }
	    /**
    	 * 修改规则
    	 */    	  
    	function modify()
    	{
    		document.getElementById("modifyDiv").style.display="none";
    		document.getElementById("saveDiv").style.display="block";
    		var ruleForm = g_FormRowSetManager.get("ruleDetial");
    		ruleForm.setEditSts(true);
    		ruleForm.setColEditSts("RULE_ID", false);
    		document.getElementById("chooseFileName").disabled = false;
    		document.getElementById("chooseFuncName").disabled = false;
    	}
    	/**
    	 * 保存
    	 */
    	function save()
    	{
    		var ruleDetialForm = g_FormRowSetManager.get("ruleDetial");
    		var xmlBody = ruleDetialForm.toXmlString(true);
    		if(xmlBody=="")
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
			window.location.reload();
			
			//刷新顶层框架
			refreshTopByDetailChange();
    	}

    	/**
		 * 置为只读状态
		 */
		function setReadOnly()
		{
		    document.getElementById("modifyDiv").style.display="block";
    		document.getElementById("saveDiv").style.display="none";
			g_FormRowSetManager.get("ruleDetial").setEditSts(false);
			document.getElementById("chooseFileName").disabled = true;
			document.getElementById("chooseFuncName").disabled = true;
			window.location.reload();
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

</script>

</html>


