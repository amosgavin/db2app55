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
<%=LocaleResourceFactory.getResource("BES0000701")%>
</title>
<script language="javascript" src="<%=request.getContextPath() %>/bce/configtool/common/js/configtool.js"></script>
<script type="text/javascript">
	function initButton()
	{
		setSearchText('search_type_value');
	}
</script>
</head>
<body onload="initButton()">
		<ai:contractframe title="" i18nRes="CRM" id="" contenttype="table"
			allowcontract="false" width="100%">
		<ai:contractitem></ai:contractitem>
			<table>
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000328")%></td>
					<td><input type="text" id="search_type_value" style="width:240px"></td>
					<td >
						<ai:button text="BES0000325" i18nRes="CRM"
							onclick="getSearchInfo()" style="cursor:hand" />
					</td>
				</tr>
			</table>
		</ai:contractframe>
 
		   <ai:table tableid="btnTable" setname="com.ai.bce.web.BceButton" needrefresh="true"
		   		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" conditionname="condition"
		   		implservice_name = "com.ai.bce.configtool.service.interfaces.IConfButtonSV"
		   		implservice_querymethod = "getBceButtonValues(String cond,  int $STARTROWINDEX,int $ENDROWINDEX)"		
		   		implservice_countmethod="getBceButtonCount(String cond)" 				
		   		initial="true" height="220" width="100%" editable="false" footdisplay="block" pagesize="10" 
		   		rowsequence="false" ondbclick="getButtonId">
	   		    <ai:col fieldname="BUTTON_ID" width= "10%" />
	   		    <ai:col fieldname="BUTTON_CODE" width= "15%" />
	   		    <ai:col fieldname="BUTTON_NAME" width= "10%" />
	   		    <ai:col fieldname="MODULE_ID" width= "10%" />
	   		    <ai:col fieldname="TEXT" width= "15%" />
	   		    <ai:col fieldname="EVENT_CLICK" width= "15%" />
	   		    <ai:col fieldname="I18N_RES" width= "10%" />
	   		    <ai:col fieldname="WIDTH" width= "10%" />
	   		    <ai:col fieldname="STATE" width= "10%" />
	   		    
	   			</ai:table>					
	   			 <div class="area_button">
	   				<ai:button text="BES0000321" i18nRes="CRM" onclick="getButtonId()" />&nbsp;&nbsp;
					<ai:button text="BES0000480" i18nRes="CRM" onclick="closeWindow()" />
			 	</div> 
		 
 
</body>
</html>

<script type="text/javascript">
function getTblBtn(){
  return g_TableRowSetManager.get("btnTable");
}
 /**
  * 模糊查询
  */
 function getSearchInfo()
 {
 	var text = getValueFromSearchText ('search_type_value');
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
			cond += getCondByText(args[i]);
		}
		else
		{
			cond += " OR "+getCondByText(args[i]);
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
 	g_TableRowSetManager.get("btnTable").refresh("cond="+cond);
 }
 /**
  * 获取查询条件
  */
 function getCondByText(text)
 {
 	return " ( 1=1 AND (BUTTON_ID LIKE '%"+text+"%' OR BUTTON_CODE LIKE '%"+text
 				+"%' OR BUTTON_NAME LIKE '%"+text+"%' OR TEXT LIKE '%"+text
				+"%' OR EVENT_CLICK LIKE '%"+text+"%' OR I18N_RES LIKE '%"+text
				+"%' OR WIDTH LIKE '%"+text+"%' OR "+getStateCond(text)+" ) )";
 }
 /**
  * 获取状态相关的查询条件
  */
 function getStateCond(text)
 {
	if(text == null)
	{
		return "";
	}
	else if(text == crm_i18n_msg("BEC0000330"))
	{
		return "STATE=1";
	}
	else if(text == crm_i18n_msg("BEC0000331"))
	{
		return "STATE=0";
	}
	else 
	{
		return "STATE LIKE '%"+text+"%'";
	}			
 }
 /**
  * 选择一个按钮
  */
 function getButtonId()
 {
	var rows = getTblBtn().getSelectedRows();
	if(rows.length == 0)
	{
	   alert(crm_i18n_msg("BEC0000014"));
	   return;
    }
    var buttonTable = getTblBtn();
    window.returnValue=buttonTable.getValue(buttonTable.getRow(), "BUTTON_ID");
    window.self.close();
 }
 
 function closeWindow()
 {
     window.self.close();	
 }
</script>
