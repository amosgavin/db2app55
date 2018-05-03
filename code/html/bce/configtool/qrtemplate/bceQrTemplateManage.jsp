<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<!--
	ҳ�����ƣ�bceQrTemplateManage.jsp
	ҳ�湦�ܣ���ִ��ģ����Ϣ����
	���ߣ�liwt
	�������ڣ�2011-5-10
	����޸��ߣ�
	����޸�ʱ�䣺
	�޸�˵����
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
<body >
<table width="100%" border=0 cellpadding=0  align="center" cellspacing="0"  >
<tr id="mainPanel">
	<td>
		<%--��ѯ���� --%>
		<ai:contractframe i18nRes="CRM" id="queryCondition" contenttype="table" title="OMS0000661" width="100%" allowcontract="false" frameclosed="false">
		<ai:contractitem/>
				<ai:dbform formid="queryTeamForm"  setname="com.ai.bce.web.BceQrTemplate"
					datamodel="com.ai.appframe2.web.tag.ActionDataModel" 
					onvalchange="onvaluechange" initial="false" editable="true">
					<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					 	<tr>
				            <td class="td_font"><i18n:message key="SOS3041795" res="CRM" />:</td>
							<td><ai:dbformfield fieldname="CONTENT_CLASS" formid="queryTeamForm" width="150" /></td>
							<td class="td_font"><i18n:message key="SOS3041796" res="CRM" /><i18n:message key="SOS2001007" res="CRM" /></td>
							<td><ai:dbformfield fieldname="FILE_PATH" formid="queryTeamForm" width="150" /></td>
							<td class="td_font"><i18n:message key="SOS3032086" res="CRM" /><i18n:message key="SOS2001007" res="CRM" /></td>
							<td><ai:dbformfield fieldname="TEMPLATE_NAME" formid="queryTeamForm" width="150" /></td>
							<td><ai:button text="OMS0000652" i18nRes="CRM" id="btnQuery" onclick="doQuery()" /></td>
						</tr>
					</table>
				</ai:dbform>
		</ai:contractframe>
		
		<ai:contractframe i18nRes="CRM" id="teamInfo" contenttype="table" title="SOS3041797"  width="100%" allowcontract="false" frameclosed="false">
		  <ai:contractitem/>
				<ai:table tableid="templateInfoTable" setname="com.ai.bce.web.BceQrTemplate"  
		        	needrefresh="true" editable="false" initial="false" multiselect="false"
		          	pagesize="10" width="100%" height="220" rowsequence="true"  ondbclick="doAttrView" onrowchange="mainTableRowChange" 
		          	tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		          	implservice_name="com.ai.bce.configtool.service.interfaces.IConfQrTemplateSV"
					implservice_querymethod = "queryBceQrTemplateValues(String contentClass,String templateName,String filePath,int $STARTROWINDEX,int $ENDROWINDEX)"
					implservice_countmethod = "queryBceQrTemplateCounts(String contentClass,String templateName,String filePath)">
					<ai:col fieldname="TEMPLATE_ID" width="10%" visible="false"/>
		     		<ai:col fieldname="CONTENT_CLASS" width="20%" visible="true"/>
		            <ai:col fieldname="FILE_PATH" width="20%" visible="true"/>
		            <ai:col fieldname="TEMPLATE_NAME" width="20%" visible="true"/>
		            <ai:col fieldname="REMARKS" width="20%" visible="true"/>
		          </ai:table>
		</ai:contractframe>
		
		<ai:contractframe i18nRes="CRM" id="qrTemplateAttrInfo2" contenttype="table" title="SOS3041798"  width="100%" allowcontract="false" frameclosed="false">
		<ai:contractitem/>
				<ai:dbform formid="qrTemplateAttrInfoForm" setname="com.ai.bce.web.BceQrTemplate"  
		        	 initial="false" editable="false" datamodel="com.ai.appframe2.web.tag.ActionDataModel">
		          <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
		            <tr> 
		            	<td class="td_font"><i18n:message key="SOS3041795" res="CRM" /><span><i18n:message key="SOS2001007" res="CRM" /></span></td>
		            	<td><ai:dbformfield fieldname="CONTENT_CLASS" width="200" formid="qrTemplateAttrInfoForm" visible="true"/></td>
		            	<td class="td_font"><i18n:message key="SOS3041796" res="CRM" /><span><i18n:message key="SOS2001007" res="CRM" /></span></td>
		            	<td>
		            		<ai:dbformfield fieldname="FILE_PATH" width="200" formid="qrTemplateAttrInfoForm" visible="true"/>
		            		<ai:dbformfield fieldname="TEMPLATE_ID" width="150" formid="qrTemplateAttrInfoForm" visible="false"/>
		            	</td>
		          	</tr>
		          	<tr> 
		            	<td class="td_font"><i18n:message key="SOS3032086" res="CRM" /><span><i18n:message key="SOS2001007" res="CRM" /></span></td>
		            	<td colspan="1"><ai:dbformfield fieldname="TEMPLATE_NAME" width="200" formid="qrTemplateAttrInfoForm" visible="true" /></td>
		            	<td class="td_font"><i18n:message key="SOS2000118" res="CRM" /><span><i18n:message key="SOS2001007" res="CRM" /></span></td>
		            	<td colspan="1"><ai:dbformfield fieldname="REMARKS" width="200" formid="qrTemplateAttrInfoForm" visible="true" /></td>
		          	</tr>
		          </table>
		          </ai:dbform>
		</ai:contractframe>
		
		<div class="area_button">
		    <%-- �鿴���� --%>
			<ai:button text="SOS3041799"  i18nRes="CRM" id="btnView" onclick="doAttrView()" />&nbsp;&nbsp;
			<%-- ���� --%>	
			<ai:button text="SOS2000129"  i18nRes="CRM" id="btnAdd" onclick="doAddNew()" />&nbsp;&nbsp;
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
var treeOp = "";
var actionUrl = "<%=request.getContextPath()%>/business/com.ai.bce.configtool.web.ConfQrTemplateAction?action=";

/*****************************************************************************
*                                ��ť�¼�������
******************************************************************************/

init();

function init(){
	 document.all.btnView.disabled = true;
	 document.all.btnAdd.disabled = true;
	 document.all.btnSave.disabled = true;
	 document.all.btnDelete.disabled = true;
	 document.all.btnModify.disabled = true;
}

//��ѯ
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

	 document.all.btnView.disabled = false;
	 document.all.btnAdd.disabled = false;
	 document.all.btnSave.disabled = true;
	 document.all.btnDelete.disabled = false;
	 document.all.btnModify.disabled = false;
}


//ѡ��һ���鿴��ϸ��Ϣ
function mainTableRowChange(OldRowIndex,NewRowIndex){
	var rowset =g_TableRowSetManager.get("templateInfoTable");
	var detailrowset = getPageRowsetForm();
	detailrowset.newRow();
	if(rowset.getRow() >=0){
		copyRowSet(rowset, rowset.getRow(), detailrowset, 0);
		detailrowset.setStsToOld();
	}
	 detailrowset.setEditSts(false);

	 document.all.btnView.disabled = false;
	 document.all.btnAdd.disabled = false;
	 document.all.btnSave.disabled = true;
	 document.all.btnDelete.disabled = false;
	 document.all.btnModify.disabled = false;
	
}

function doAttrView(){
	var table = g_TableRowSetManager.get("templateInfoTable");
	var attrTable = g_TableRowSetManager.get("qrTemplateAttrTable");
	var n = table.getRow();
	var templateId = table.getValue(n,"TEMPLATE_ID");
	var url = "bceQrTemplateAttr.jsp?templateId=";
	url += templateId;
	var ret = window.showModalDialog(url,null,"scroll:no;resizable:no;help:no;status:no;dialogHeight:600px;dialogWidth:700px");
}


//����
function doAddNew(){
	 var formset = getPageRowsetForm();
	 formset.setEditSts(true);
	 formset.newRow();
	 document.all.btnView.disabled = true;
	 document.all.btnAdd.disabled = true;
	 document.all.btnSave.disabled = false;
	 document.all.btnDelete.disabled = true;
	 document.all.btnModify.disabled = true;
}


function getPageRowsetForm(){
	return g_FormRowSetManager.get("qrTemplateAttrInfoForm");
}


//����
function doSave(){
    treeOp = "SAVE";
    var list = new Array();
    var formset = getPageRowsetForm();

    if (formset.toXmlString(true)==""){
		alert(crm_i18n_msg("SOC3021772"));//��û���޸��κ����ݣ�
		doQuery();
		return;
	}
    
	list.push(formset);

	var templateName = formset.getValue("TEMPLATE_NAME").trim();
	var filePath = formset.getValue("FILE_PATH").trim();

	if(isEmptyString(templateName)){
		alert(crm_i18n_msg("SOC3021773"));
		return;
	 }

	if(isEmptyString(filePath)){
		alert(crm_i18n_msg("SOC3021774"));
		return;
	 }
	
    var url = actionUrl + "saveQrTemplate";
    var ret = saveRowSet(url,list,false);
    var flag  = ret.getValueByName("flag");
   
    if(ret && "succ" == flag){
        alert(crm_i18n_msg("SOC3021775")+crm_i18n_msg("SOC3021769"));
    }else{
    	 alert(crm_i18n_msg("SOC3021775")+crm_i18n_msg("SOC3021770"));
        }

    doQuery();
}

//ɾ��
function doDel(){
	treeOp = "DEL";
    var table = g_TableRowSetManager.get("templateInfoTable");
    var n = table.getRow();
    if(n<0){
        alert(crm_i18n_msg("SOC3021776"));//��ѡ��һ��������Ϣ��
        return;
    }

    var templateId = table.getValue(n,"TEMPLATE_ID");
    
    if(null == templateId){
        alert(crm_i18n_msg("SOC3021777"));//û���ҵ���ϢID
        return;
    }
    if(!window.confirm(crm_i18n_msg("SOC3021778"))){//ȷ��Ҫɾ����ѡ�ļ�¼��
        return;
    }
    var url = actionUrl + "deleteQrTemplate&TEMPLATE_ID="+templateId;
    var ret = PostInfo(url);
    var flag  = ret.getValueByName("flag");
   
    if(ret && "succ" == flag){
        alert(crm_i18n_msg("SOC3021779"));
    }else{
    	 alert(crm_i18n_msg("SOC3021780"));
        }

    doQuery();
}
//�޸�
function doModify(){
   treeOp = "MODIFY";
    var table = g_TableRowSetManager.get("templateInfoTable");
    var n = table.getRow();
    if(n<0){
        alert(crm_i18n_msg("SOC3021781"));  //��ѡ��һ��������Ϣ��
        return;
    }
	var formset = getPageRowsetForm();
	formset.setEditSts(true);
	document.all.btnView.disabled = true;
	document.all.btnAdd.disabled = true;
    document.all.btnSave.disabled = false;
	document.all.btnDelete.disabled = true;
	document.all.btnModify.disabled = true;
}



//����
function doExport(){
    var table = g_TableRowSetManager.get("templateInfoTable");
	if (table.count()==0){
		//alert("��ǰ�����û�����ݣ�");
		alertcrm_i18n_msg("CAC0000001");
		return false;
	}
	location.href = table.toExcelUrl("result");  

}
//����
function onvaluechange(pFieldName,pOldVal,pNewVal,DBFormPK){
	var queryForm = g_FormRowSetManager.get("queryTeamForm");
    if(pFieldName=="REGION_CODE"){
        queryForm.refreshDynamicListBox("COUNTY_CODE");
    }
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
