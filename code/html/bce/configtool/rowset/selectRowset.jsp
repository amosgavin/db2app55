<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil" %>
<%
	String moduleId = HttpUtil.getAsString(request,"moduleId");
	if(!"".equals(moduleId)){
		request.setAttribute("cond","MODULE_ID="+moduleId + " or module_id='0' or module_id is null");
	}
%>

<html>
<head>
<title><%=LocaleResourceFactory.getResource("BES0000488")%></title>

<script language="javascript" src="../common/js/configtool.js"></script>
</head>

<body>
<ai:contentframe id="" title="BES0000489" i18nRes="CRM" contenttype="table"  width="98%">
<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000327")%></td>
						<td><select id="search_type" style="width:200px">
						<option value="ALL"><%=LocaleResourceFactory.getResource("BES0000333")%></option>
						<option value="ROWSET_ID"><%=LocaleResourceFactory.getResource("BES0000507")%></option>
						<option value="ROWSET_TYPE"><%=LocaleResourceFactory.getResource("BES0000509")%></option>
						<option value="ROWSET_KEY">KEY</option>
						<option value="ROWSET_METHOD"><%=LocaleResourceFactory.getResource("BES0000508")%></option>
						<option value="REMARKS"><%=LocaleResourceFactory.getResource("BES0000142")%></option>
							</select>
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000328")%></td>
						<td><input id="searchText" style="width:200px"></td>
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
						<td align="center" colspan="2">
						<ai:button text="BES0000325" i18nRes="CRM" onclick="search()" />
						</td>

</tr>
</table>

</ai:contentframe>

<ai:contentframe id="" title="BES0000549" i18nRes="CRM" contenttype="table"  width="98%">
					<ai:table tableid="rowsetDBTable" setname="com.ai.bce.web.BceRowset" needrefresh="true"
				   		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" conditionname="condition"
				   		implservice_name = "com.ai.bce.configtool.service.interfaces.IConfRowsetSV"
				   		implservice_querymethod="getRowsetValues(String cond, int $STARTROWINDEX,int $ENDROWINDEX)"
		   				implservice_countmethod="getRowsetCount(String cond)" initial="true" height="220" 
				   		width="100%" editable="false" multiselect="false" footdisplay="true" 
						pagesize="10" rowsequence="false" ondbclick="selectRowset">
						
			   			<ai:col fieldname="ROWSET_ID" width="80"/>
			   			<ai:col fieldname="ROWSET_TYPE" width="120"/>
			   			<ai:col fieldname="ROWSET_KEY" width="180"/>
			   			<ai:col fieldname="ROWSET_METHOD" width="180"/>
			   			<ai:col fieldname="MODULE_ID" width="100"/>
						<ai:col fieldname="STATE" width="80"/>	
						<ai:col fieldname="REMARKS" width="200"/>					
		   			</ai:table>						
</ai:contentframe>
			<div class="area_button">
				<ai:button text="BES0000321" i18nRes="CRM" onclick="selectRowset()"/>&nbsp;&nbsp;
				<ai:button text="BES0000480" i18nRes="CRM" onclick="closeWindow()"/>
			</div>
</body>
<script>
	/**
	 * 显示页面详细信息
	 */
	function selectRowset()
	{	
		var table = g_TableRowSetManager.get("rowsetDBTable");
		var selRows = table.getSelectedRows();
		if(selRows == null || selRows.length <= 0)
		{
			alert(crm_i18n_msg("BEC0000307"));
			return;
		}
		var rowsetObj = {
			id:table.getValue(table.getRow(),"ROWSET_ID"),
			type:table.getValue(table.getRow(),"ROWSET_TYPE"),    
			key:table.getValue(table.getRow(),"ROWSET_KEY"),
			method:table.getValue(table.getRow(),"ROWSET_METHOD"),
			state:table.getValue(table.getRow(),"STATE"),
			remarks:table.getValue(table.getRow(),"REMARKS")
		};
		window.returnValue = rowsetObj;
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
			cond = "(MODULE_ID=<%=moduleId%> OR MODULE_ID='0' OR MODULE_ID is null)";
		}
		else
		{
			cond = "("+cond+") AND (MODULE_ID=<%=moduleId%> OR MODULE_ID='0' OR MODULE_ID is null)";
		}			
		// 刷新页面
		g_TableRowSetManager.get("rowsetDBTable").refresh("cond="+cond);
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
				cond += " AND (ROWSET_ID LIKE '%"+text+"%' OR ROWSET_KEY LIKE '%"+text+"%' OR "
						+getRowsetTypeCond(text)+" OR ROWSET_METHOD LIKE '%"+text+"%' OR REMARKS LIKE '%"+text+"%' ) ";
				break;
			case "ROWSET_ID":
				cond += " AND ROWSET_ID LIKE '%"+text+"%' ";
				break;
			case "ROWSET_TYPE":
				cond += " AND "+getRowsetTypeCond(text);
				break;
			case "ROWSET_KEY":
				cond += " AND ROWSET_KEY LIKE '%"+text+"%' ";
				break;
			case "ROWSET_METHOD":
				cond += " AND ROWSET_METHOD LIKE '%"+text+"%' ";
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
	 * 获取数据集类型条件
	 */
	function getRowsetTypeCond(text)
	{
		if(text == null)
		{
			return "";
		}
		else if(text == "TableRowSet" || text == "tableRowSet" || text == "tablerowSet")
		{
			return " ROWSET_TYPE=1 ";
		}
		else if(text == "FormRowSet" || text == "formRowSet" || text == "formrowSet")
		{
			return " ROWSET_TYPE=2 ";
		}
		else if(text == crm_i18n_msg("BEC0000333"))
		{
			return " ROWSET_TYPE=3 ";
		}
		else if(text == crm_i18n_msg("BEC0000334"))
		{
			return " ROWSET_TYPE=4 ";
		}
		else
		{
			return " ROWSET_TYPE LIKE '%"+text+"%' ";
		}		
	}
</script>
</html>


