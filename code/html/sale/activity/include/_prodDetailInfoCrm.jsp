<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>CRM������Ϣ���</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/jquery/jquery-1.8.3.js" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  
<body onload="initPage()">
<ai:contractframe id="ProdDetailframe" contenttype="table" title="������Ϣ" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="ProdDetailForm" initial="false" editable="false"
			setname="com.asiainfo.sale.activity.web.SETActInfoCrm">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">���α��룺</td>
	           	<td><ai:dbformfield formid="ProdDetailForm" fieldname="PRODID" width="170"/></td>
	           	<td class="td_font">�������ƣ�</td>
	           	<td><ai:dbformfield formid="ProdDetailForm" fieldname="PRODNAME" width="170"/></td>   
	           	<td class="td_font">������λ��</td>
	           	<td><ai:dbformfield formid="ProdDetailForm" fieldname="CREATEORGID" width="170"/></td>
	        </tr>
	        <tr>
	           	<td class="td_font">��ʼʱ�䣺</td>
	           	<td><ai:dbformfield formid="ProdDetailForm" fieldname="AVAILABLEDATE" width="170"/></td> 
	           	<td class="td_font">����ʱ�䣺</td>
	           	<td><ai:dbformfield formid="ProdDetailForm" fieldname="ENDDATE" width="170"/></td>
	           	<td class="td_font">����ʱ�䣺</td>
	           	<td><ai:dbformfield formid="ProdDetailForm" fieldname="CREATEDATE" width="170"/></td> 
			</tr>
			<tr>
				<td class="td_font">����ͣ�</td>
	           	<td><ai:dbformfield formid="ProdDetailForm" fieldname="PRODUCTTYPE" width="170"/></td> 
	           	<td class="td_font">����ࣺ</td>
	           		<td><ai:dbformfield formid="ProdDetailForm" fieldname="PRODUCTCLASS" width="170"/></td> 
	           	<td class="td_font">����Ĭ�Ϲ�ϵ��</td>
	           	<td><ai:dbformfield formid="ProdDetailForm" fieldname="PRIVRELATETYPE" width="170"/></td>     	
			</tr>
			<tr>
	           	<td class="td_font">�ܽ�</td>
	           	<td><ai:dbformfield formid="ProdDetailForm" fieldname="ALLOWFEE" width="170"/></td>     	
				<td class="td_font">ƽ̨���ͣ�</td>
	           	<td><ai:dbformfield formid="ProdDetailForm" fieldname="PLATTYPE" width="170"/></td> 
	           	<td class="td_font">������ذ���</td>
	           	<td><ai:dbformfield formid="ProdDetailForm" fieldname="ALLOWOUTREGION" width="170"/></td> 
			</tr>
			<tr>
	           	<td class="td_font">��Ч���ͣ�</td>
	           	<td><ai:dbformfield formid="ProdDetailForm" fieldname="AFFECTTYPE" width="170"/></td> 
	           	<td class="td_font">��Чʱ�䣺</td>
	           	<td><ai:dbformfield formid="ProdDetailForm" fieldname="AFFECTOFFSET" width="170"/></td> 
	        </tr>
	        <tr>
				<td class="td_font">ʧЧ���ͣ�</td>
	           	<td><ai:dbformfield formid="ProdDetailForm" fieldname="INVALIDTYPE" width="170"/></td>  
	           	<td class="td_font">ʧЧʱ�䣺</td>
	           	<td><ai:dbformfield formid="ProdDetailForm" fieldname="INVALIDOFFSET" width="170"/></td>
	           	<td class="td_font">���״̬��</td>
	           	<td><ai:dbformfield formid="ProdDetailForm" fieldname="AUDITSTATUS" width="170"/></td>    
			</tr>
			<tr>
				<td class="td_font">��ע��</td>
	           	<td colspan="5"><ai:dbformfield formid="ProdDetailForm" fieldname="NOTES" width="650" height="50"/></td> 
			</tr>
		</table>
	</ai:dbform>
	</ai:contractframe>
	
	<ai:contractframe id="Prodorgframe" contenttype="table" title="��������" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="ProdorgTab" 
            tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            setname="com.asiainfo.sale.activity.web.SETActInfoCrm"
            conditionname="condition" parametersname="parameters"
            editable="false" initial="false" width="100%" height="200" pagesize="2">
	        <ai:col fieldname="ORGID" width="170" />
	        <ai:col fieldname="ORGNAME" width="200" />
    	</ai:table>
	</ai:contractframe>
	<ai:contractframe id="Prodchannelframe" contenttype="table" title="��������" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="ProdchannelTab" 
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.sale.activity.web.SETActInfoCrm"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="200" pagesize="4">
	        <ai:col fieldname="REGION" width="170" />
	        <ai:col fieldname="CHANNELNAME" width="300" />
	        <ai:col fieldname="OPERATION" width="300" />
	   	</ai:table>
	</ai:contractframe>
	<ai:contractframe id="Prodcusttypeframe" contenttype="table" title="�ͻ��ȼ�" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="ProdcusttypeTab" 
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.sale.activity.web.SETActInfoCrm"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="200" pagesize="4">
	        <ai:col fieldname="REGION" width="170" />
	        <ai:col fieldname="VIPTYPE" width="300" />
	   	</ai:table>
	</ai:contractframe>
	<!-- 
	<ai:dbform formid="crmAuditForm" initial="false" editable="true"
			setname="com.asiainfo.common.web.SETCrmAuditLog">
		<table>
			<tr>
				<td class="td_font">��������</td>
	           	<td><ai:dbformfield formid="crmAuditForm" fieldname="CONTENT" width="600" height="50"/>
	           	    <ai:dbformfield formid="crmAuditForm" fieldname="INTERFACE_ID" width="150" visible="false"/>
	           	    <ai:dbformfield formid="crmAuditForm" fieldname="BOSS_CODE" width="150" visible="false"/>
	           	    <ai:dbformfield formid="crmAuditForm" fieldname="AUDIT_FLAG" width="150" visible="false"/></td>
				<td><ai:button id="bt_yes" text="���ͨ��"  onclick="auditProd(1)"/></td>
				<td><ai:button id="bt_no" text="��    ��"  onclick="auditProd(0)"/></td>
			</tr>
		</table>
    </ai:dbform>
     -->
<ai:loginuser/>
<script language="javascript" src="<%=request.getContextPath()%>/sale/activity/js/requestToCrm.js"></script>
<script type="text/javascript">
//var SysSaleInfoForm = g_FormRowSetManager.get("SysSaleInfoForm");
var ProdDetailForm = g_FormRowSetManager.get("ProdDetailForm");
//var crmAuditForm = g_FormRowSetManager.get("crmAuditForm");
var ProdorgTab = g_TableRowSetManager.get("ProdorgTab");
var ProdchannelTab = g_TableRowSetManager.get("ProdchannelTab");
var ProdcusttypeTab = g_TableRowSetManager.get("ProdcusttypeTab");
var prodID = "<%=request.getParameter("prodID")%>";
var prodDetail = "<%=request.getParameter("prodDetail")%>";

function initPage(){
	
	//������Ϣ
	//prodID = "yxt20140703";
	prodDetail = query_CRM("QueryProdDetail",'',prodID);
    ProdDetailForm.setValue("PRODID",prodDetail.body.prodID);
	ProdDetailForm.setValue("PRODNAME",prodDetail.body.prodName);
	ProdDetailForm.setValue("CREATEORGID",prodDetail.body.createOrgID);
	ProdDetailForm.setValue("AVAILABLEDATE",prodDetail.body.availableDate);
	ProdDetailForm.setValue("ENDDATE",prodDetail.body.endDate);
	ProdDetailForm.setValue("CREATEDATE",prodDetail.body.createDate);
	ProdDetailForm.setValue("AUDITSTATUS",prodDetail.body.auditStatus);
    ProdDetailForm.setValue("PRODUCTTYPE",prodDetail.body.productType);
	ProdDetailForm.setValue("PRODUCTCLASS",prodDetail.body.productClass);
	ProdDetailForm.setValue("PRIVRELATETYPE",prodDetail.body.privRelateType);
	ProdDetailForm.setValue("AFFECTTYPE",prodDetail.body.affectType);
	ProdDetailForm.setValue("AFFECTOFFSET",prodDetail.body.affectOffset);
	ProdDetailForm.setValue("INVALIDTYPE",prodDetail.body.invalidType);
	ProdDetailForm.setValue("INVALIDOFFSET",prodDetail.body.invalidOffset);
	ProdDetailForm.setValue("NOTES",prodDetail.body.notes);
	ProdDetailForm.setValue("ALLOWFEE",prodDetail.body.allowfee);
	ProdDetailForm.setValue("PLATTYPE",prodDetail.body.PlatType);
	ProdDetailForm.setValue("ALLOWOUTREGION",prodDetail.body.allowOutRegion);
	//��������
	prodOrg = query_CRM("QueryProdorg",'',prodID);
	for (var i=0; i < prodOrg.body.array.$list.length; ++i) {
		ProdorgTab.newRow();
		ProdorgTab.setValue(i,"ORGID",prodOrg.body.array.$list[i].orgID);
		ProdorgTab.setValue(i,"ORGNAME",prodOrg.body.array.$list[i].orgName);
	}
	//��������
	prodChannel = query_CRM("QueryProdchannel",'',prodID);
	for (var i=0; i < prodChannel.body.array.$list.length; ++i) {
		ProdchannelTab.newRow();
		ProdchannelTab.setValue(i,"REGION",prodChannel.body.array.$list[i].region);
		ProdchannelTab.setValue(i,"CHANNELNAME",prodChannel.body.array.$list[i].channelName);
		ProdchannelTab.setValue(i,"OPERATION",prodChannel.body.array.$list[i].operation);
	}
	//�ͻ��ȼ�
	prodCusttype = query_CRM("QueryProdcusttype",'',prodID);
	for (var i=0; i < prodCusttype.body.array.$list.length; ++i) {
		ProdcusttypeTab.newRow();
		ProdcusttypeTab.setValue(i,"REGION",prodCusttype.body.array.$list[i].region);
		ProdcusttypeTab.setValue(i,"VIPTYPE",prodCusttype.body.array.$list[i].vipType);
	}
}

function auditProd(flag){
	var retState = audit_CRM("Prodaddaudit", '', prodID, '', flag);
	if (retState.retCode == 0) {
		alert("��˳ɹ���");
	} else {
		crmAuditForm.setValue("CONTENT","���ʧ��");
		alert("���ʧ�ܣ�");
	}
	crmAuditForm.setValue("INTERFACE_ID","Prodaddaudit");
	crmAuditForm.setValue("BOSS_CODE",prodID)
	crmAuditForm.setValue("AUDIT_FLAG",flag);
	var list = new Array();
	list.push(crmAuditForm);
	var strUrl = _gModuleName + '/business/com.asiainfo.common.web.CrmAuditLogAction?action=saveAuditLog';
	var recode = saveRowSet(strUrl, list);
}
</script>
