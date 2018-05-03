<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil" %>
<%
	String moduleId = HttpUtil.getAsString(request,"module_id");
	String rulesetType = HttpUtil.getParameter(request, "rulesetType");
	if(!"".equals(moduleId)){
		String cond = "MODULE_ID="+moduleId + " or module_id='0' or module_id is null ";
		if(rulesetType != null && !"".equals(rulesetType))
		{
			cond = "(" + cond + ") AND RULE_TYPE="+rulesetType;
		}
		request.setAttribute("cond", cond);
	}
%>
<html>
<head>
<title><%=LocaleResourceFactory.getResource("BES0000492")%></title>

<script language="javascript" src="../common/js/configtool.js"></script>
</head>

<body>
<ai:contentframe id="" title="BES0000493" i18nRes="CRM" contenttype="table"  width="98%">
<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000327")%></td>
						<td><select id="search_type" style="width:200px">
							<option value="ALL"><%=LocaleResourceFactory.getResource("BES0000333")%></option>
							<option value="RULE_ID"><%=LocaleResourceFactory.getResource("BES0000299")%></option>
							<option value="RULE_NAME"><%=LocaleResourceFactory.getResource("BES0000511")%></option>
							<option value="RULE_KIND"><%=LocaleResourceFactory.getResource("BES0000510")%></option>
							<option value="FILE_NAME"><%=LocaleResourceFactory.getResource("BES0000296")%></option>
							<option value="FUNC_NAME"><%=LocaleResourceFactory.getResource("BES0000297")%></option>
							<option value="PARAM_LIST"><%=LocaleResourceFactory.getResource("BES0000298")%></option>
							<option value="REMARKS"><%=LocaleResourceFactory.getResource("BES0000142")%></option>
							</select>
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000328")%></td>
						<td><input id="searchText" style="width:200px"></td>
					</tr>
					<tr>
						<td class="td_font"><option value="8"><%=LocaleResourceFactory.getResource("BES0000170")%></option><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td><select id="search_state" style="width:200px">
							   <option value="-1">
							   		<%=LocaleResourceFactory.getResource("BES0000330")%>					
							   	</option>
								<option value="1">
									<%=LocaleResourceFactory.getResource("BES0000331")%>
								</option>
								<option value="0">
									<%=LocaleResourceFactory.getResource("BES0000332")%>
								</option>
						</select>
						</td>
						<td align="center" colspan="2">
						<ai:button text="BES0000325" i18nRes="CRM" onclick="search()"/>
						</td>

</tr>
</table>
</ai:contentframe>
<ai:contentframe id="" title="BES0000544" i18nRes="CRM" contenttype="table"  width="98%">
		  				<ai:table tableid="ruleDBTable" setname="com.ai.bce.web.BceRule" needrefresh="true"
			   				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" 
			   				implservice_name = "com.ai.bce.configtool.service.interfaces.IConfRuleSV"
					   		implservice_querymethod="getBceRuleValues(String cond, int $STARTROWINDEX,int $ENDROWINDEX)"
			   				implservice_countmethod="getBceRuleCount(String cond)" 
			   				initial="true" height="220" width="100%" editable="false" multiselect="true"
							footdisplay="block" pagesize="10" rowsequence="true" ondbclick="selectRule">
		  					<ai:col fieldname="RULE_ID" />
							<ai:col fieldname="RULE_NAME" width="200"/>
							<ai:col fieldname="MODULE_ID" />
							<ai:col fieldname="RULE_KIND" />
							<ai:col fieldname="RULE_TYPE" />
							<ai:col fieldname="FILE_NAME" width="360"/>	
							<ai:col fieldname="FUNC_NAME" width="200"/>					
							<ai:col fieldname="PARAM_LIST" width="230"/>
							<ai:col fieldname="STATE"/>
							<ai:col fieldname="REMARKS" width="200"/>
		  				</ai:table>					
				</ai:contentframe>
			<div class="area_button">
				<ai:button text="BES0000321" i18nRes="CRM" onclick="selectRule()"/>&nbsp;&nbsp;
				<ai:button text="BES0000480" i18nRes="CRM" onclick="closeWindow()"/>
			</div>
</body>
<script>

	/**
	 * 显示页面详细信息
	 */
	function selectRule()
	{	
		var table = g_TableRowSetManager.get("ruleDBTable");
		var selRows = table.getSelectedRows();
		var ruleIds = "";
		if(selRows == null || selRows.length <= 0)
		{
			alert(crm_i18n_msg("BEC0000307"));
			return;
		}
		for(var i=0; i < selRows.length-1 ; i++)
		{
			ruleIds += table.getValue(selRows[i], "RULE_ID") + ",";
		}
		ruleIds += table.getValue(selRows[selRows.length-1], "RULE_ID");
		window.returnValue = ruleIds;
		window.self.close();
	}
	/**
	 * 关闭窗口
	 */
	function closeWindow()
	{
		window.self.close();
	}
	//查询功能
	function search(){
		var text = document.getElementById("searchText").value;
		var type = document.getElementById("search_type").value;
		var cond = "";

		// 根据分隔符拆分查询文本，拼凑查询条件
    	var args = text.split(/\s/);
		for(var i=0; i<args.length; i++)
		{
			if(args[i] == '')
			{
				continue;
			}
			if(cond == "")
			{
				cond += getCondByTypeAndText(type ,args[i]);
			}
			else
			{
				cond += " OR "+getCondByTypeAndText(type ,args[i]);
			}
		}
		var state = document.getElementById("search_state").value;
		if(state != -1 && state != "-1")
		{
			if(cond == "")
			{
				cond += " STATE="+state;
			}
			else
			{
				cond = "("+cond+") AND STATE="+state;
			}
		}
		if(cond == "")
		{
			cond = "(MODULE_ID=<%=moduleId%> OR MODULE_ID='0' OR MODULE_ID is null) AND RULE_TYPE=<%=rulesetType%>";
		}
		else
		{
			cond = "("+cond+") AND (MODULE_ID=<%=moduleId%> OR MODULE_ID='0' OR MODULE_ID is null) AND RULE_TYPE=<%=rulesetType%>";
		}		
		// 刷新页面
		g_TableRowSetManager.get("ruleDBTable").refresh("cond="+cond);
	}
	/**
	 * 根据查询类型与传入的文本拼凑查询条件
	 */
	function getCondByTypeAndText(type, text)
	{
		var cond = " ( 1=1 ";
		switch(type)
		{
			case "ALL":
				cond += " AND (RULE_ID LIKE '%"+text+"%' OR RULE_NAME LIKE '%"+text+"%' OR "
						+getRuleKindCond(text) + " OR FILE_NAME LIKE '%"+text+"%' "+" OR FUNC_NAME LIKE '%"+text+"%' " 
						+" OR PARAM_LIST LIKE '%"+text+"%' "+" OR REMARKS LIKE '%"+text+"%' ) ";
				break;
			case "RULE_ID":
				cond += " AND RULE_ID LIKE '%"+text+"%' ";
				break;
			case "RULE_NAME":
				cond += "AND RULE_NAME LIKE'%"+text+"%' ";
				break;
			case "RULE_KIND":
				cond += " AND "+getRuleKindCond(text);
				break;
			case "FILE_NAME":
				cond += " AND FILE_NAME LIKE '%"+text+"%' ";
				break;
			case "FUNC_NAME":
				cond += " AND FUNC_NAME LIKE '%"+text+"%' ";
				break;
			case "PARAM_LIST":
				cond += " AND PARAM_LIST LIKE '%"+text+"%' ";
				break;
			case "REMARKS":
				cond += " AND REMARKS LIKE '%"+text+"%' ";
				break;
			default:
				alert(crm_i18n_msg("BEC0000329"));
		}		
		return cond+" ) ";
	}	

	/**
	 * 获取规则种类条件
	 */
	function getRuleKindCond(text)
	{
		if(text == null)
		{
			return "";
		}
		else if(text == crm_i18n_msg("BEC0000335"))
		{
			return " RULE_KIND=1 ";
		}
		else if(text == crm_i18n_msg("BEC0000336"))
		{
			return " RULE_KIND=2 ";
		}
		else (text == "")
		{
			return " RULE_KIND LIKE '%"+text+"%' ";
		}
	}

</script>
</html>


