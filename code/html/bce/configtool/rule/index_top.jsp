<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil" %>
<%
	String moduleId = HttpUtil.getAsString(request,"module_id");
	if(!"".equals(moduleId)){
		request.setAttribute("cond","MODULE_ID="+moduleId + " or module_id='0' or module_id is null");
	}
%>
<html>
<head>
<title>
</title>

<script language="javascript" src="../common/js/configtool.js"></script>
</head>

<script>
	/**
	 * 显示规则详细信息
	 */
	function showDetailInfo()
	{	
		var table = g_TableRowSetManager.get("ruleDBTable");
		var ruleId = table.getValue(table.getRow(),"RULE_ID");
		var ruleType = table.getValue(table.getRow(),"RULE_TYPE");
		showDataDetail("RULE_ID="+ruleId+"&RULE_TYPE="+ruleType);
	}
	/**
	 * 新增规则
	 */
	function addNewRule()
	{
		var url = "<%=request.getContextPath()%>/bce/configtool/rule/AddRule.jsp";
	 	window.showModalDialog(url, <%=moduleId%>,"scroll:no;resizable:no;status:no;dialogHeight:300px;dialogWidth:700px");
	 	search();
	}
	//查询功能
	function search(){
		var text = getValueFromSearchText ('search_type_value');
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
		var state = document.getElementById("state_select").value;
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
			cond = "(MODULE_ID=<%=moduleId%> OR MODULE_ID='0' OR MODULE_ID is null)";
		}
		else
		{
			cond = "("+cond+") AND (MODULE_ID=<%=moduleId%> OR MODULE_ID='0' OR MODULE_ID is null)";
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
						+getRuleKindCond(text)+" OR "+getRuleTypeCond(text)
						+" OR FILE_NAME LIKE '%"+text+"%' "+" OR FUNC_NAME LIKE '%"+text+"%' " 
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
			case "RULE_TYPE":
				cond += " AND "+getRuleTypeCond(text);
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
	 * 获取角色类型条件
	 */
	function getRuleTypeCond(text)
	{
		if(text == null)
		{
			return "";
		}
		else if(text == "JS" || text == "js")
		{
			return " RULE_TYPE=1 ";
		}
		else if(text == "JAVA" || text == "java")
		{
			return " RULE_TYPE=2 ";
		}
		else
		{
			return " RULE_TYPE LIKE '%"+text+"%' ";
		}		
	}
	/**
	 * 获取角色种类条件
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
   	/**
   	 * 删除
   	 */
   	function delRule()
   	{
		var table = g_TableRowSetManager.get("ruleDBTable");
		var row = table.getRow();
		if(row == -1)
		{
			alert(crm_i18n_msg("BEC0000014"));
			return;
		}
		if(!confirm(crm_i18n_msg("BEC0000015"))){
    		return false;
    	}
		  table.deleteRow(row);
    	var list = new Array();
    	list.push(table);
    	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
    	if (ud.getValueByName("FLAG") == "ERROR" ) {
			  alert(crm_i18n_msg("BEC0000013"));
			  return;
			}			
		search();
		showDetailInfo();	
   	}	
   	
   	function initRule()
   	{
   		clickFirstRow('ruleDBTable');
   		setSearchText('search_type_value') ;
   	}
	//将查询方法注册到顶层
	registerEventWhenDetailChange(search); 
</script>
	<body onload="initRule()">
		<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem />	
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
				<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000327")%></td>
				<td><select id="search_type" style="width:200px">
							<option value="ALL"><%=LocaleResourceFactory.getResource("BES0000333")%></option>
							<option value="RULE_ID"><%=LocaleResourceFactory.getResource("BES0000299")%></option>
							<option value="RULE_NAME"><%=LocaleResourceFactory.getResource("BES0000511")%></option>
							<option value="RULE_KIND"><%=LocaleResourceFactory.getResource("BES0000510")%></option>
							<option value="RULE_TYPE"><%=LocaleResourceFactory.getResource("BES0000212")%></option>
							<option value="FILE_NAME"><%=LocaleResourceFactory.getResource("BES0000296")%></option>
							<option value="FUNC_NAME"><%=LocaleResourceFactory.getResource("BES0000297")%></option>
							<option value="PARAM_LIST"><%=LocaleResourceFactory.getResource("BES0000298")%></option>
							<option value="REMARKS"><%=LocaleResourceFactory.getResource("BES0000142")%></option>
						</select></td>
			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000328")%></td>
			<td><input type="text" id="search_type_value" style="width:200px"></td>
			</tr>
			<tr>
				<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
				<td><select id="state_select" style="width:200px">
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
				<td class="td_font"><ai:button text="BES0000325" i18nRes="CRM" onclick="search()" /></td>
			</tr>
		</table>  
		</ai:contractframe>
		<div class="area_button">
	<ai:button text="BES0000322" i18nRes="CRM" onclick="addNewRule()"/>
	<ai:button text="BES0000324" i18nRes="CRM" onclick="delRule()"/>
		</div>
		
		 
  				<ai:table tableid="ruleDBTable" setname="com.ai.bce.web.BceRule" needrefresh="true"
	   				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" 
	   				implservice_name = "com.ai.bce.configtool.service.interfaces.IConfRuleSV"
			   		implservice_querymethod="getBceRuleValues(String cond, int $STARTROWINDEX,int $ENDROWINDEX)"
	   				implservice_countmethod="getBceRuleCount(String cond)" 	   				
	   				initial="true" height="220" width="100%" editable="false" multiselect="false"
					footdisplay="block" pagesize="10" rowsequence="true" 
					onrowchange="showDetailInfo" ondbclick="showDetailInfo">
  					<ai:col fieldname="RULE_ID" />
					<ai:col fieldname="RULE_NAME" width="300"/>
					<ai:col fieldname="MODULE_ID" />
					<ai:col fieldname="RULE_KIND" />
					<ai:col fieldname="RULE_TYPE" />
					<ai:col fieldname="FILE_NAME" width="360"/>	
					<ai:col fieldname="FUNC_NAME" width="200"/>					
					<ai:col fieldname="PARAM_LIST" width="230"/>
					<ai:col fieldname="ALERT_MESSAGE" width="200"/>
					<ai:col fieldname="STATE"/>
					<ai:col fieldname="REMARKS" width="200"/>
  				</ai:table>
 
</body>
</html>


