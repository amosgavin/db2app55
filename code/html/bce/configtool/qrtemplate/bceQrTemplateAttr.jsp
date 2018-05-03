<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<!--
	ҳ�����ƣ�bceQrTemplateAttrManage.jsp
	ҳ�湦�ܣ���ִ��ģ��������Ϣ��Ϣ����
	���ߣ�liwt
	�������ڣ�2011-5-10
	����޸��ߣ�
	����޸�ʱ�䣺
	�޸�˵����
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
			<%-- ���� --%>	
			<ai:button text="SOS2000129" i18nRes="CRM" id="btnAdd" onclick="doAddNew()" />&nbsp;&nbsp;
			<%-- �޸� --%>		
			<ai:button text="SOS2000130" i18nRes="CRM" id="btnModify" onclick="doModify()"/>&nbsp;&nbsp;
			<%-- ɾ�� --%>	
			<ai:button text="OMS0000859" i18nRes="CRM" id="btnDelete" onclick="doDel()"/>&nbsp;&nbsp;
			<%-- ���� --%>		
			<ai:button text="SOS2021108" i18nRes="CRM" id="btnSave" onclick="doSave()"/>&nbsp;&nbsp;
		</div>
	</td>
</tr>

</table>
</body>
</html>
<script language="javascript">
/*****************************************************************************
*                                ����������
******************************************************************************/
var templateId = '<%=templateId%>';
var treeOp = "";
var actionUrl = "<%=request.getContextPath()%>/business/com.ai.bce.configtool.web.ConfQrTemplateAttrAction?action=";
var editableArray = ["TEAM_VERSION","TEAM_NAME","EXPIRE_DATE","VALID_DATE","OUT_STATUS","TEAM_CONTENT","APPLY_DEPT","APPLY_MAN","APPLY_DATE","APPLY_CONTENT","NOTES"];

/*****************************************************************************
*                                ��ť�¼�������
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

//ѡ��һ���鿴��ϸ��Ϣ
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

//����
function doAddNew(){
	 var formset = getPageRowsetForm();
	 formset.setEditSts(true);
	 formset.newRow();
	 document.all.btnSave.disabled = false;
	 document.all.btnModify.disabled = true;
	 document.all.btnDelete.disabled = true;
	 document.all.btnAdd.disabled = true;
}


//����
function doSave(){
    treeOp = "SAVE";
    var list = new Array();
    var formset = getPageRowsetForm();

    if (formset.toXmlString(true)==""){
		alert(crm_i18n_msg("SOC3021772"));//��û���޸��κ����ݣ�
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

//ɾ��
function doDel(){
    treeOp = "DEL";
    var table = g_TableRowSetManager.get("qrTemplateAttrTable");
    var n = table.getRow();
    if(n<0){
        alert(crm_i18n_msg("SOC3021776"));//��ѡ��һ��������Ϣ��
        return;
    }

    var attrId = table.getValue(n,"ATTR_ID");
    
    if(null == attrId){
        alert(crm_i18n_msg("SOC3021777"));//û���ҵ���ϢID
        return;
    }
    if(!window.confirm(crm_i18n_msg("SOC3021778"))){//ȷ��Ҫɾ����ѡ�ļ�¼��
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
//�޸�
function doModify(){
    treeOp = "MODIFY";
    var table = g_TableRowSetManager.get("qrTemplateAttrTable");
    var n = table.getRow();
    if(n<0){
        alert(crm_i18n_msg("SOC3021781"));  //��ѡ��һ��������Ϣ��
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

/******************************************���ܺ���************************************************************/
/**
* @desc �ж�һ���Ƿ�Ϊ��
* @return boolean
*/
function isEmptyString(s){
	if("" == s || null == s){
		return true;
	}
    return false;
}

/**
* @desc ����ҳ��Ԫ��
* @param1 ҳ��Ԫ��id����
* @param2 boolean �Ƿ���ʾ
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
* @desc ����DBFORM��Field�ı༭״̬
* @param1 DBForm�ؼ�
* @param2 DBForm�е��ֶε�����
* @param3 is : true�ɱ༭ false ���ɱ༭
*/
function setDBFormEditable(form,fields,is){
    for(var i=0; i<fields.length; i++){
        form.setColEditSts(fields[i],is);
    }
}

/**
* ɾ���������˵Ŀո�
*/
String.prototype.trim=function()
{
     return this.replace(/(^\s*)(\s*$)/g, '');
}
</script>
