<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface"%>
<%@ page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<!--
	ҳ�����ƣ�configBceFrame.jsp
	ҳ�湦�ܣ�������ģ������
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
<!--��������Ϣ��ѯ -->
<title><i18n:message key="SOS3032081" res="CRM" /></title>
</head>
<body >

<table width="100%" border=0 cellpadding=0  align="center" cellspacing="0"  >
<tr id="mainPanel">
	<td>
		<%--��ѯ���� --%>
		<ai:contractframe i18nRes="CRM" id="queryCondition" contenttype="table" title="OMS0000661" width="100%" allowcontract="false" frameclosed="false">
		<ai:contractitem/>
				<ai:dbform formid="bceFrameQueryForm"  setname="com.ai.bce.web.BceFrameConfigTemplate"
					datamodel="com.ai.appframe2.web.tag.ActionDataModel" 
					initial="false" editable="true">
					<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					 	<tr>
				            <td class="td_font"><i18n:message key="SOS30320821" res="CRM" />:</td>
							<td><ai:dbformfield fieldname="ENTRY_PAGE_URL" formid="bceFrameQueryForm" width="150" /></td>
							<td class="td_font"><i18n:message key="SOS3032083" res="CRM" /><i18n:message key="SOS2001007" res="CRM" /></td>
							<td><ai:dbformfield fieldname="DATA_PARSER" formid="bceFrameQueryForm" width="150" /></td>
							<td class="td_font"><i18n:message key="SOS3032084" res="CRM" /><i18n:message key="SOS2001007" res="CRM" /></td>
							<td><ai:dbformfield fieldname="WORKFLOW_CODE" formid="bceFrameQueryForm" width="150" /></td>
							<td class="td_button"><ai:button text="OMS0000652" i18nRes="CRM" id="btnQuery" onclick="doQuery()" /></td>
						</tr>
					</table>
				</ai:dbform>
		</ai:contractframe>
		<ai:contractframe i18nRes="CRM" id="bceFrameInfo" contenttype="table" title="OMS0000712"  width="100%" allowcontract="false" frameclosed="false">
		  <ai:contractitem/>
				<ai:table tableid="bceFrameInfoTable" setname="com.ai.bce.web.BceFrameConfigTemplate"
		        	needrefresh="true" editable="false" initial="false" multiselect="false"
		          	pagesize="10" width="100%" height="220" rowsequence="true"  onrowchange="mainTableRowChange" 
		          	tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		          	implservice_name="com.ai.bce.configtool.service.interfaces.IConfFrameSV"
					implservice_querymethod="getBceFrameConfigTemplateValues(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
					implservice_countmethod="getBceFrameConfigTemplateValuesCount(String cond)">
					<ai:col fieldname="BCE_FRAME_ID" width="10%" visible="false"/>
		     		<ai:col fieldname="DEAL_SERVICE" width="17%" visible="true" title="SOS3032085" i18nRes="CRM"/>
		            <ai:col fieldname="DATA_PARSER" width="20%" visible="true" title="SOS3032083" i18nRes="CRM"/>
		            <ai:col fieldname="TEMPLATE_NAME" width="8%" visible="true" title="SOS3032086" i18nRes="CRM"/>
		            <ai:col fieldname="PARAM_DATA" width="10%" visible="true" title="SOS3032087" i18nRes="CRM"/>
		            <ai:col fieldname="ENTRY_PAGE_URL" width="10%" visible="true" title="SOS30320821" i18nRes="CRM"/>
		            <ai:col fieldname="WORKFLOW_CODE" width="25%" visible="true" title="SOS3032084" i18nRes="CRM"/>
		            <ai:col fieldname="REMARKS" width="20%" visible="true" title="OMS0000662" i18nRes="CRM"/>
		            <ai:col fieldname="PRINT_TEMPLATE_ID" width="20%" visible="false" title="SOS3032088" i18nRes="CRM"  />
		            <ai:col fieldname="TEMPLATE_ID" width="20%" visible="false" title="SOS3032088" i18nRes="CRM" />
		          </ai:table>
		</ai:contractframe>
		<ai:contractframe i18nRes="CRM" id="bceFrameInfoDetail" contenttype="table" title="OMS0000711"  width="100%" allowcontract="false" frameclosed="false">
		<ai:contractitem/>
				<ai:dbform formid="bceFrameInfoDetailForm" setname="com.ai.bce.web.BceFrameConfigTemplate"
		        	 initial="false" editable="false" datamodel="com.ai.appframe2.web.tag.ActionDataModel">
		          <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
		            <tr> 
		            	<td class="td_font"><i18n:message key="SOS3032082" res="CRM" /><span><i18n:message key="SOS2001007" res="CRM" /></span></td>
		            	<td><ai:dbformfield fieldname="ENTRY_PAGE_URL" width="150" formid="bceFrameInfoDetailForm" visible="true"/>
		            		<ai:dbformfield fieldname="BCE_FRAME_ID" width="150" formid="bceFrameInfoDetailForm" visible="false"/>
		            		<ai:dbformfield fieldname="TEMPLATE_ID" width="150" formid="bceFrameInfoDetailForm" visible="false"/>
		            	</td>
		            	<td class="td_font"><i18n:message key="SOS3032083" res="CRM" /><span><i18n:message key="SOS2001007" res="CRM" /></span></td>
		            	<td>
		            		<ai:dbformfield fieldname="DATA_PARSER" width="150" formid="bceFrameInfoDetailForm" visible="true"/>
		            	</td>
		            	<td class="td_font"><i18n:message key="SOS3032084" res="CRM" /><span><i18n:message key="SOS2001007" res="CRM" /></span></td>
		            	<td><ai:dbformfield fieldname="WORKFLOW_CODE" width="150" formid="bceFrameInfoDetailForm" visible="true" /></td>
		          	</tr>
		          	<tr> 
		          	<td class="td_font"><i18n:message key="SOS3032087" res="CRM" /><span><i18n:message key="SOS2001007" res="CRM" /></span></td>
		            	<td colspan="1"><ai:dbformfield fieldname="PARAM_DATA" width="150" formid="bceFrameInfoDetailForm" visible="true" /></td>
		            	<td class="td_font"><i18n:message key="SOS3032088" res="CRM" /><span><i18n:message key="SOS2001007" res="CRM" /></span></td>
		            	<td>
		            	 <ai:dbformfield fieldname="TEMPLATE_NAME" formid="bceFrameInfoDetailForm" editable="false"	width="130" /><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="doSelectBceQrTemplate()" align="absmiddle"  style="cursor:hand;" id="selectBceQrTemplate"/>
						 <ai:dbformfield fieldname="PRINT_TEMPLATE_ID" width="150" formid="bceFrameInfoDetailForm" visible="false" />
		            	</td>
		            	<td class="td_font"><i18n:message key="OMS0000662" res="CRM" /><span><i18n:message key="SOS2001007" res="CRM" /></span></td>
		            	<td><ai:dbformfield fieldname="REMARKS" width="150" formid="bceFrameInfoDetailForm" visible="true" /></td>
		          	</tr>
		          </table>
		        </ai:dbform>
		        
		</ai:contractframe>
		<div class="area_button">
					<%-- ���� --%>	
		    		<ai:button text="SOS3032089"  i18nRes="CRM" id="btnSave" onclick="doSave()"/>
				</div>
</body>
</html>
<script language="javascript">
/*****************************************************************************
*                                ����������
******************************************************************************/
var treeOp = "";
var actionUrl = "<%=request.getContextPath()%>/business/com.ai.bce.configtool.web.ConfBceFrameTemplateAction?action=";

/*****************************************************************************
*                                ��ť�¼�������
******************************************************************************/
init();
function init(){
	g_AIButtonManager.get("btnSave").setDisabled(true);
}

/***
 * ѡ��ȷ��ҳģ��
 */
function doSelectBceQrTemplate(){
	var rtnVal = window.showModalDialog("<%=request.getContextPath()%>/bce/configtool/qrtemplate/selectBceQrTemplate.jsp", "",
	"scroll:no;resizable:no;help:no;status:no;dialogHeight:550px;dialogWidth:700px");
	if(rtnVal){
		getBceFrameDetailForm().setValue("PRINT_TEMPLATE_ID",rtnVal.templateId,rtnVal.templateId);
		getBceFrameDetailForm().setValue("TEMPLATE_NAME",rtnVal.templateName,rtnVal.templateName);
	}	
	
}

//��ѯ
function doQuery(){
	var queryForm =  getBceFrameQueryForm();
	var table = getBceFrameTab();
	var entryPageUrl = queryForm.getValue("ENTRY_PAGE_URL").trim();
	var dataParser= queryForm.getValue("DATA_PARSER").trim();
	var workFlowCode = queryForm.getValue("WORKFLOW_CODE").trim();
	
	var cond = " 1=1 ";

   if(entryPageUrl != null && entryPageUrl !=""){
	   cond += " and ENTRY_PAGE_URL  like '%" + entryPageUrl+"%'"; 
	   }

   if(dataParser != null && dataParser !=""){
	   cond += " and DATA_PARSER  like '%" + dataParser+"%'"; 
	  }

   if(workFlowCode != null && workFlowCode !=""){
	   cond += " and WORKFLOW_CODE  like '%" + workFlowCode+"%'"; 
	 }

   cond += " and STATE ='1'"; 
	table.refresh("cond="+cond);
	
	if(table.count() > 0){
	    table.setRow(0);
	    
    }else{
        alert(crm_i18n_msg("SOC3021764"));
        return;
    }
	 g_AIButtonManager.get("btnSave").setDisabled(false);
}

function getBceFrameTab(){
    return g_TableRowSetManager.get("bceFrameInfoTable");
    }

function getBceFrameQueryForm(){
    return g_FormRowSetManager.get("bceFrameQueryForm");
    }

function getBceFrameDetailForm(){
    return g_FormRowSetManager.get("bceFrameInfoDetailForm");
    }



//ѡ��һ���鿴��ϸ��Ϣ
function mainTableRowChange(OldRowIndex,NewRowIndex){
	var rowset = getBceFrameTab();
	var detailrowset = getBceFrameDetailForm();
	 
	detailrowset.newRow();
	
	if(rowset.getRow() >=0){
		copyRowSet(rowset, rowset.getRow(), detailrowset, 0);
		detailrowset.setStsToOld();
	}
	detailrowset.setEditSts(false);
	
	g_AIButtonManager.get("btnSave").setDisabled(false);
}

//����
function doSave(){
    var table = getBceFrameTab();
    var detailForm = getBceFrameDetailForm();
    var templateId = detailForm.getValue("PRINT_TEMPLATE_ID");
    var templateName = detailForm.getValue("TEMPLATE_NAME");
    var bceFrameId = detailForm.getValue("BCE_FRAME_ID");

    if(table.getRow <0){
         alert(crm_i18n_msg("SOC3021766"));
         return;
     }
    if(templateName == null  || templateName == ""){
           alert(crm_i18n_msg("SOC3021767"));
           return;
     }
    var url = actionUrl + "configBceFrameTemplate&bceFrameId="+bceFrameId+"&templateId="+templateId;
    var ret = PostInfo(url);
    var flag  = ret.getValueByName("flag");
    if(ret && "succ" == flag){
        alert(crm_i18n_msg("SOC3021768")+crm_i18n_msg("SOC3021769"));
    }else{
    	 alert(crm_i18n_msg("SOC3021768")+crm_i18n_msg("SOC3021770"));
        }
    
    doQuery();
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
