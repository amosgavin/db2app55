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
	 * 显示页面详细信息
	 */
	function showDetailInfo()
	{	
		var table = g_TableRowSetManager.get("pageDBTable");
		var pageId = table.getValue(table.getRow(),"PAGE_ID");
		showDataDetail('PAGE_ID='+pageId);
	}
	//查询功能
	function search(){
		var text = getValueFromSearchText ('search_type_value');
		var type = document.getElementById("search_type").value;
		var cond = "";

		// 根据分隔符拆分查询文本
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
			cond = "(MODULE_ID=<%=moduleId%> OR MODULE_ID='0' OR MODULE_ID is null)";
		}
		else
		{
			cond = "("+cond+") AND (MODULE_ID=<%=moduleId%> OR MODULE_ID='0' OR MODULE_ID is null)";
		}
		// 刷新页面
		g_TableRowSetManager.get("pageDBTable").refresh("cond="+cond);
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
				cond += " AND (PAGE_ID LIKE '%"+text+"%' OR PAGE_URL LIKE '%"+text+"%' OR "
						+getPageLoadTypeCond(text)+" OR "+getPageTypeCond(text)
						+" OR "+getPageDataCond(text)+" OR "+getDataMustCond(text)
						+" OR PAGE_RULESET_ID LIKE '%"+text+"%' "+" OR REMARKS LIKE '%"+text+"%' ) ";
				break;
			case "PAGE_ID":
				cond += " AND PAGE_ID LIKE '%"+text+"%' ";
				break;
			case "PAGE_TYPE":
				cond += "AND "+getPageTypeCond(text);
				break;
			case "PAGE_URL":
				cond += " AND PAGE_URL LIKE'%"+text+"%' ";
				break;
			case "IS_GET_PAGE_DATA":
				cond += " AND "+getPageDataCond(text);
				break;
			case "IS_DATA_MUST":
				cond += " AND "+getDataMustCond(text);
				break;
			case "PAGE_RULESET_ID":
				cond += " AND PAGE_RULESET_ID LIKE '%"+text+"%' ";
				break;
			case "PAGE_LOAD_TYPE":
				cond += " AND "+getPageLoadTypeCond(text);
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
	 * 获取“是否提取数据”条件
	 */
	function getPageDataCond(text)
	{
		if(text == null)
		{
			return "";
		}
		else if(text == crm_i18n_msg("BEC0000319"))
		{
			return "IS_GET_PAGE_DATA=1";
		}
		else if(text == crm_i18n_msg("BEC0000320"))
		{
			return "IS_GET_PAGE_DATA=0";
		}
		else 
		{
			return "IS_GET_PAGE_DATA LIKE '%"+text+"%'";
		}						
	}
	/**
	 * 获取“数据是否可为空”条件
	 */
	function getDataMustCond(text)
	{
		if(text == null)
		{
			return "";
		}
		else if(text == crm_i18n_msg("BEC0000319"))
		{
			return "IS_DATA_MUST=1";
		}
		else if(text == crm_i18n_msg("BEC0000320"))
		{
			return "IS_DATA_MUST=0";
		}
		else 
		{
			return "IS_DATA_MUST LIKE '%"+text+"%'";
		}	
	}
	/**
	 * 获取页面类型条件
	 */
	function getPageTypeCond(text)
	{
		if(text == null)
		{
			return "";
		}
		else if(text == crm_i18n_msg("BEC0000326"))
		{
			return " PAGE_TYPE=1 ";
		}
		else if(text == crm_i18n_msg("BEC0000327"))
		{
			return " PAGE_TYPE=2 ";
		}
		else if(text == crm_i18n_msg("BEC0000328"))
		{
			return " PAGE_TYPE=3 ";
		}	
		else
		{
			return " PAGE_TYPE LIKE '%"+text+"%' ";
		}	
	}
	/**
	 * 获取页面加载方式条件
	 */
	function getPageLoadTypeCond(text)
	{
		if(text == null)
		{
			return "";
		}
		else if(text == crm_i18n_msg("BEC0000324"))
		{
			return " PAGE_LOAD_TYPE=1 ";
		}
		else if(text == crm_i18n_msg("BEC0000325"))
		{
			return " PAGE_LOAD_TYPE=2 ";
		}
		else (text == "")
		{
			return " PAGE_LOAD_TYPE LIKE '%"+text+"%' ";
		}
	}
	/**
	 * 新增页面
	 */
	function addNewPage()
	{
		var url = "<%=request.getContextPath()%>/bce/configtool/page/AddPage.jsp";
	 	window.showModalDialog(url, <%=moduleId%>,"scroll:no;resizable:no;status:no;dialogHeight:300px;dialogWidth:700px");
	 	search();
	}
    /**
   	 * 删除页面
   	 */
   	function delPage()
   	{
		var table = g_TableRowSetManager.get("pageDBTable");
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
   	
   	function initPage()
   	{
   		setSearchText('search_type_value') ;
   		clickFirstRow('pageDBTable');
   	}
	//将查询方法注册到顶层
	registerEventWhenDetailChange(search); 
</script>
<body onload="initPage()">

		<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem />	
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
				<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000327")%></td>
				<td>
					<select id="search_type" style="width:200px">
						<option value="ALL"><%=LocaleResourceFactory.getResource("BES0000333")%></option>
						<option value="PAGE_ID"><%=LocaleResourceFactory.getResource("BES0000388")%></option>
						<option value="PAGE_TYPE"><%=LocaleResourceFactory.getResource("BES0000392")%></option>
						<option value="PAGE_URL"><%=LocaleResourceFactory.getResource("BES0000393")%></option>
						<option value="IS_GET_PAGE_DATA"><%=LocaleResourceFactory.getResource("BES0000386")%></option>
						<option value="IS_DATA_MUST"><%=LocaleResourceFactory.getResource("BES0000385")%></option>
						<option value="PAGE_RULESET_ID"><%=LocaleResourceFactory.getResource("BES0000390")%></option>
						<option value="PAGE_LOAD_TYPE"><%=LocaleResourceFactory.getResource("BES0000389")%></option>
						<option value="REMARKS"><%=LocaleResourceFactory.getResource("BES0000142")%></option>	
					</select></td>
			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000328")%></td>
			<td><input type="text" id="search_type_value" style="width:240px"></td>
			</tr>
			<tr>
				<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%></td>
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
				<td class="td_font"><ai:button text="BES0000325" i18nRes="CRM" onclick="search()" /></td>
			</tr>
		</table>  
		</ai:contractframe>
		<div class="area_button">
		<ai:button text="BES0000322" i18nRes="CRM" onclick="addNewPage()"/>&nbsp;&nbsp;
		<ai:button text="BES0000324" i18nRes="CRM" onclick = "delPage()"/>
		</div>
		
		 
		   	<ai:table tableid="pageDBTable" setname="com.ai.bce.web.BcePage" needrefresh="true"
		   		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" conditionname="condition"
		   		implservice_name = "com.ai.bce.configtool.service.interfaces.IConfPageSV"
		   		implservice_querymethod = "getBcePageValues(String cond, int $STARTROWINDEX,int $ENDROWINDEX)"   	
		   		implservice_countmethod="getBcePageCount(String cond)" 			
		   		initial="true" height="220" width="100%" editable="false" multiselect="false"
				footdisplay="block" pagesize="10" rowsequence="true" onrowchange="showDetailInfo"
				ondbclick="showDetailInfo">
	   		<ai:col fieldname="PAGE_ID"/>
	   		<ai:col fieldname="MODULE_ID"/>
			<ai:col fieldname="PAGE_TYPE"/>	
			<ai:col fieldname="PAGE_URL" width="310"/>					
			<ai:col fieldname="IS_GET_PAGE_DATA"/>
			<ai:col fieldname="IS_DATA_MUST" width="110"/>
			<ai:col fieldname="PAGE_RULESET_ID"/>
			<ai:col fieldname="PAGE_LOAD_TYPE" width="210"/>
			<ai:col fieldname="STATE"/>
			<ai:col fieldname="REMARKS" width="150"/>
	   		</ai:table>						
 
</body>
</html>


