<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<!--
	页面名称：selectBceQrTemplate.jsp
	页面功能：选择回执单模板信息管理
	作者：liwt
	创建日期：2011-5-10
	最后修改者：
	最后修改时间：
	修改说明：
-->
<%
	UserInfoInterface user=SessionManager.getUser();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<script language="JavaScript" src="<%=request.getContextPath()%>/secframe/common/common.js"></script>
<title><i18n:message key="SOS3041794" res="CRM" /></title>
</head>
<body>
<table width="100%" border=0 cellpadding=0  align="center" cellspacing="0"  >
<tr id="mainPanel">
	<td>
		<%--查询条件 --%>
		<ai:contractframe i18nRes="CRM" id="queryCondition" contenttype="table" title="OMS0000661" width="100%" allowcontract="false" frameclosed="false">
		<ai:contractitem/>
				<ai:dbform formid="queryTeamForm"  setname="com.ai.bce.web.BceQrTemplate"
					datamodel="com.ai.appframe2.web.tag.ActionDataModel" 
					initial="false" editable="true">
					<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					 	<tr>
				            <td class="td_font"><i18n:message key="SOS3041823" res="CRM" />:</td>
							<td><ai:dbformfield fieldname="CONTENT_CLASS" formid="queryTeamForm" width="150" /></td>
							<td class="td_font"><i18n:message key="SOS3041824" res="CRM" /><i18n:message key="SOS2001007" res="CRM" /></td>
							<td><ai:dbformfield fieldname="FILE_PATH" formid="queryTeamForm" width="150" /></td>
							<td class="td_font"><i18n:message key="SOS2000312" res="CRM" /><i18n:message key="SOS2001007" res="CRM" /></td>
							<td><ai:dbformfield fieldname="TEMPLATE_NAME" formid="queryTeamForm" width="150" /></td>
							<td><ai:button text="OMS0000652" i18nRes="CRM" id="btnQuery" onclick="doQuery()" /></td>
						</tr>
					</table>
				</ai:dbform>
		</ai:contractframe>
		
		<ai:contractframe i18nRes="CRM" id="teamInfo" contenttype="table" title="SOS3041825"  width="100%" allowcontract="false" frameclosed="false">
		  <ai:contractitem/>
				<ai:table tableid="templateInfoTable" setname="com.ai.bce.web.BceQrTemplate"  
		        	needrefresh="true" editable="false" initial="false" multiselect="false"
		          	pagesize="10" width="100%" height="220" rowsequence="true"  
		          	tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		          	implservice_name="com.ai.bce.configtool.service.interfaces.IConfQrTemplateSV"
					implservice_querymethod = "queryBceQrTemplateValues(String contentClass,String templateName,String filePath,int $STARTROWINDEX,int $ENDROWINDEX)"
					implservice_countmethod = "queryBceQrTemplateCounts(String contentClass,String templateName,String filePath)">
					<ai:col fieldname="TEMPLATE_ID" width="10%" visible="false"/>
		     		<ai:col fieldname="CONTENT_CLASS" width="35%" visible="true"/>
		            <ai:col fieldname="FILE_PATH" width="25%" visible="true"/>
		            <ai:col fieldname="TEMPLATE_NAME" width="20%" visible="true"/>
		            <ai:col fieldname="REMARKS" width="20%" visible="true"/>
		          </ai:table>
		</ai:contractframe>
		<div class="area_button">
		    <%-- 确定 --%>
			<ai:button text="OMS2000059" i18nRes="CRM" id="btnOk" onclick="doOk()" />&nbsp;&nbsp;
			<%-- 取消 --%>	
			<ai:button text="OMS0000570" i18nRes="CRM" id="btnCanel" onclick="doCanel()" />&nbsp;&nbsp;
		</div>
	</td>
</tr>

</table>
</body>
</html>
<script language="javascript">
/*****************************************************************************
*                                变量声明区
******************************************************************************/
var treeOp = "";
var actionUrl = "<%=request.getContextPath()%>/business/com.ai.bce.configtool.web.ConfQrTemplateAction?action=";
var editableArray = ["TEAM_VERSION","TEAM_NAME","EXPIRE_DATE","VALID_DATE","OUT_STATUS","TEAM_CONTENT","APPLY_DEPT","APPLY_MAN","APPLY_DATE","APPLY_CONTENT","NOTES"];

/*****************************************************************************
*                                按钮事件处理区
******************************************************************************/

doQuery();

//查询
function doQuery(){
	var queryForm = g_FormRowSetManager.get("queryTeamForm");
	var table = g_TableRowSetManager.get("templateInfoTable");
	
	var contentClass = queryForm.getValue("CONTENT_CLASS");
	var templateName= queryForm.getValue("TEMPLATE_NAME");
	var filePath = queryForm.getValue("FILE_PATH");
	
	var condition = "contentClass=" + contentClass + "&templateName=" + templateName + "&filePath="+filePath;
	table.refresh(condition);
	
	if(table.count() > 0){
	    table.setRow(0);
    }else{
        alert(crm_i18n_msg("SOC3021764"));
        return;
    }
}

function doOk(){
	var table = g_TableRowSetManager.get("templateInfoTable");
	var index = table.getRow();
	if(index == -1){
		alert(crm_i18n_msg("SOC3021764"));
		return;
	}   
	
	var templateName = table.getValue(index,"TEMPLATE_NAME");
	var templateId = table.getValue(index,"TEMPLATE_ID");

	var rtnVal={
       templateId:templateId,
       templateName:templateName
	};
	window.returnValue = rtnVal;
	window.close();
	
}

function doCanel(){
	window.self.close();
}

/******************************************功能函数************************************************************/
/**
* @desc 判断一段是否为空
* @return boolean
*/
function isEmptyString(s){
	if("" == s || null == s){
		return true;
	}
    return false;
}


/**
* 删除左右两端的空格
*/
String.prototype.trim=function()
{
     return this.replace(/(^\s*)(\s*$)/g, '');
}

</script>
