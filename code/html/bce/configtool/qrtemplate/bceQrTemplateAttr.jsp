<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<!--
	页面名称：bceQrTemplateAttrManage.jsp
	页面功能：回执单模板属性信息信息管理
	作者：liwt
	创建日期：2011-5-10
	最后修改者：
	最后修改时间：
	修改说明：
-->
<%
   String templateId = request.getParameter("templateId");
	UserInfoInterface user=SessionManager.getUser();
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<script language="JavaScript" src="<%=request.getContextPath()%>/secframe/common/common.js"></script>
<title><i18n:message key="SOS3041800" res="CRM" /></title>
</head>
<body >
<table width="100%" border=0 cellpadding=0  align="center" cellspacing="0"  >
<tr id="mainPanel">
	<td>
		<ai:contractframe i18nRes="CRM" id="qrTemplateAttrInfo" contenttype="table" title="SOS3041801"  width="100%" allowcontract="false" frameclosed="false">
		<ai:contractitem/>
				<ai:table tableid="qrTemplateAttrTable" setname="com.ai.bce.web.BceQrAttr"  
		        	needrefresh="true" editable="false" initial="false" multiselect="false"
		          	pagesize="10" width="100%" height="220" rowsequence="true"  onrowchange="mainTableRowChange" 
		          	tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		          	implservice_name="com.ai.bce.configtool.service.interfaces.IConfQrAttrSV"
					implservice_querymethod = "queryBceQrTemplateAttrValues(String templateId,int $STARTROWINDEX,int $ENDROWINDEX)"
					implservice_countmethod = "queryBceQrTemplateAttrCounts(String templateId)">
					<ai:col fieldname="ATTR_ID" width="20%" visible="false"/>
					<ai:col fieldname="ATTR_NAME" width="20%" visible="true"/>
					<ai:col fieldname="ALIAS_NAME" width="15%" visible="true"/>
		            <ai:col fieldname="BCE_GET_RULE" width="45%" visible="true"/>
		            <ai:col fieldname="PARAM_RE" width="15%" visible="true" title="SOS3041802" i18nRes="CRM"/>
		            <ai:col fieldname="DEFAULT_VALUE" width="10%" visible="true" title="SOS3041803" i18nRes="CRM"/>
		          </ai:table>
		</ai:contractframe>
		
		<ai:contractframe i18nRes="CRM" id="qrTemplateAttrInfo2" contenttype="table" title="SOS3041804"  width="100%" allowcontract="false" frameclosed="false">
		<ai:contractitem/>
				<ai:dbform formid="qrTemplateAttrInfoForm" setname="com.ai.bce.web.BceQrAttr"  
		        	 initial="false" editable="false" datamodel="com.ai.appframe2.web.tag.ActionDataModel">
		          <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
		            <tr> 
		            	<td class="td_font"><i18n:message key="OMS0000411" res="CRM" /><span><i18n:message key="SOS2001007" res="CRM" /></span></td>
		            	<td><ai:dbformfield fieldname="ATTR_NAME" width="150" formid="qrTemplateAttrInfoForm" visible="true"/></td>
		            	<td class="td_font"><i18n:message key="SOS3041805" res="CRM" /><span><i18n:message key="SOS2001007" res="CRM" /></span></td>
		            	<td><ai:dbformfield fieldname="ALIAS_NAME" width="150" formid="qrTemplateAttrInfoForm" visible="true"/>
		            	<ai:dbformfield fieldname="ATTR_ID" width="150" formid="qrTemplateAttrInfoForm" visible="false"/>
		            	</td>
		          	</tr>
		          	<tr> 
		            	<td class="td_font"><i18n:message key="SOS3041802" res="CRM" /><span><i18n:message key="SOS2001007" res="CRM" /></span></td>
		            	<td colspan="1"><ai:dbformfield fieldname="PARAM_RE" width="150" formid="qrTemplateAttrInfoForm" visible="true" /></td>
		            	<td class="td_font"><i18n:message key="SOS3041803" res="CRM" /><span><i18n:message key="SOS2001007" res="CRM" /></span></td>
		            	<td colspan="1"><ai:dbformfield fieldname="DEFAULT_VALUE" width="150" formid="qrTemplateAttrInfoForm" visible="true" /></td>
		          	</tr>
		          	 <tr> 
		            	<td class="td_font"><i18n:message key="SOS3041806" res="CRM" /><span><i18n:message key="SOS2001007" res="CRM" /></span></td>
		            	<td colspan="3"><ai:dbformfield fieldname="BCE_GET_RULE" width="480" formid="qrTemplateAttrInfoForm" visible="true"/></td>
		          	</tr>
		          </table>
		          </ai:dbform>
		</ai:contractframe>
		
		<div class="area_button">
			<%-- 新增 --%>	
			<ai:button text="SOS2000129" i18nRes="CRM" id="btnAdd" onclick="doAddNew()" />&nbsp;&nbsp;
			<%-- 修改 --%>		
			<ai:button text="SOS2000130" i18nRes="CRM" id="btnModify" onclick="doModify()"/>&nbsp;&nbsp;
			<%-- 删除 --%>	
			<ai:button text="OMS0000859" i18nRes="CRM" id="btnDelete" onclick="doDel()"/>&nbsp;&nbsp;
			<%-- 保存 --%>		
			<ai:button text="SOS2021108" i18nRes="CRM" id="btnSave" onclick="doSave()"/>&nbsp;&nbsp;
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
var templateId = '<%=templateId%>';
var treeOp = "";
var actionUrl = "<%=request.getContextPath()%>/business/com.ai.bce.configtool.web.ConfQrTemplateAttrAction?action=";
var editableArray = ["TEAM_VERSION","TEAM_NAME","EXPIRE_DATE","VALID_DATE","OUT_STATUS","TEAM_CONTENT","APPLY_DEPT","APPLY_MAN","APPLY_DATE","APPLY_CONTENT","NOTES"];

/*****************************************************************************
*                                按钮事件处理区
******************************************************************************/

init();

function init(){
	var attrTable = g_TableRowSetManager.get("qrTemplateAttrTable");
	var condition = "templateId=" + templateId;
	attrTable.refresh(condition);
	attrTable.setFocus(0);

	document.all.btnSave.disabled = true;
	
}

function refreshAttrForm(){ 
	var attrTable = g_TableRowSetManager.get("qrTemplateAttrTable");
	var n = attrTable.getRow();
	var attrId = attrTable.getValue(n,"ATTR_ID");
	var infoForm = getPageRowsetForm();
	infoForm.refresh("cond=attrId = "+attrId);
}

function getPageRowsetForm(){
	return g_FormRowSetManager.get("qrTemplateAttrInfoForm");
}

//选中一条查看详细信息
function mainTableRowChange(OldRowIndex,NewRowIndex){
	var rowset =g_TableRowSetManager.get("qrTemplateAttrTable");
	var detailrowset = getPageRowsetForm();
	detailrowset.newRow();
	if(rowset.getRow() >=0){
		copyRowSet(rowset, rowset.getRow(), detailrowset, 0);
		detailrowset.setStsToOld();
	}
	 detailrowset.setEditSts(false);

	 document.all.btnSave.disabled = true;
	 document.all.btnModify.disabled = false;
	 document.all.btnDelete.disabled = false;
	 document.all.btnAdd.disabled = false;
}

//新增
function doAddNew(){
	 var formset = getPageRowsetForm();
	 formset.setEditSts(true);
	 formset.newRow();
	 document.all.btnSave.disabled = false;
	 document.all.btnModify.disabled = true;
	 document.all.btnDelete.disabled = true;
	 document.all.btnAdd.disabled = true;
}


//保存
function doSave(){
    treeOp = "SAVE";
    var list = new Array();
    var formset = getPageRowsetForm();

    if (formset.toXmlString(true)==""){
		alert(crm_i18n_msg("SOC3021772"));//您没有修改任何数据！
		init();
		return;
	}
    
	list.push(formset);
    var url = actionUrl + "saveQrTemplateAttr&templateId="+templateId;
    var ret = saveRowSet(url,list,false);
    var flag  = ret.getValueByName("flag");
   
    if(ret && "succ" == flag){
        alert(crm_i18n_msg("SOC3021775")+crm_i18n_msg("SOC3021769"));
        init();
    }
}

//删除
function doDel(){
    treeOp = "DEL";
    var table = g_TableRowSetManager.get("qrTemplateAttrTable");
    var n = table.getRow();
    if(n<0){
        alert(crm_i18n_msg("SOC3021776"));//请选择一条合作信息！
        return;
    }

    var attrId = table.getValue(n,"ATTR_ID");
    
    if(null == attrId){
        alert(crm_i18n_msg("SOC3021777"));//没有找到信息ID
        return;
    }
    if(!window.confirm(crm_i18n_msg("SOC3021778"))){//确认要删除所选的记录吗？
        return;
    }
    var url = actionUrl + "deleteQrTemplateAttr&ATTR_ID="+attrId;
    var ret = PostInfo(url);
    var flag  = ret.getValueByName("flag");
   
    if(ret && "succ" == flag){
        alert(crm_i18n_msg("SOC3021779"));
        init();
    }
}
//修改
function doModify(){
    treeOp = "MODIFY";
    var table = g_TableRowSetManager.get("qrTemplateAttrTable");
    var n = table.getRow();
    if(n<0){
        alert(crm_i18n_msg("SOC3021781"));  //请选择一条合作信息！
        return;
    }

   // var infoid = table.getValue(n,"TEAM_ID");
    var formset = getPageRowsetForm();
    formset.setEditSts(true);
    document.all.btnSave.disabled = false;
    document.all.btnModify.disabled = true;
    document.all.btnDelete.disabled = true;
    document.all.btnAdd.disabled = true;
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
* @desc 隐藏页面元素
* @param1 页面元素id数组
* @param2 boolean 是否显示
*/
function setHtmlVisible(id,is){
    for(var i=0; i<id.length; i++){
        if(is){
            document.getElementById(id).style.display = "block";
        }else{
            document.getElementById(id).style.display = "none";
        }
    }
}

/**
* @desc 设置DBFORM中Field的编辑状态
* @param1 DBForm控件
* @param2 DBForm中的字段的数组
* @param3 is : true可编辑 false 不可编辑
*/
function setDBFormEditable(form,fields,is){
    for(var i=0; i<fields.length; i++){
        form.setColEditSts(fields[i],is);
    }
}

/**
* 删除左右两端的空格
*/
String.prototype.trim=function()
{
     return this.replace(/(^\s*)(\s*$)/g, '');
}
</script>
