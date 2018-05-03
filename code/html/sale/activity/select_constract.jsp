<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="logger.query.login.titile" res="i18n.secframe_resource"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="init()">
<ai:contractframe id="selectContractframe" contenttype="table" title="Ӫ������ѯ����" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="selectContractForm" initial="false" onvalchange="onSelectContractFormValChange"
			setname="com.asiainfo.sale.activity.web.SETContract"> 
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
		     <tr>
		        <td class="td_font">��ѯ��ʽ��</td>
	           	<td><ai:dbformfield formid="selectContractForm" fieldname="QUERY_MEHTODS" width="150"/></td>   
	           	<td class="td_font">�ն����ͣ�</td>
	           	<td><ai:dbformfield formid="selectContractForm" fieldname="IS_CONTRACT" width="150"/></td>
			</tr>
			<tr>
	           	<td class="td_font">���α�ţ�</td>
	           	<td><ai:dbformfield formid="selectContractForm" fieldname="SALE_MAIN_CODE" width="150"/></td>
	           	<td class="td_font">�������ƣ�</td>
	           	<td><ai:dbformfield formid="selectContractForm" fieldname="SALE_MAIN_NAME" width="150"/></td>        	
			</tr>
			<tr>
	           	<td class="td_font">���α�ţ�</td>
	           	<td><ai:dbformfield formid="selectContractForm" fieldname="SALE_ACTIVE_CODE" width="150"/></td>
	           	<td class="td_font">�������ƣ�</td>
	           	<td><ai:dbformfield formid="selectContractForm" fieldname="SALE_ACTIVE_NAME" width="150"/></td>        	
			</tr>
			<tr>
			<td colspan="4" align="center"><ai:button id="querytable" text="��ѯ" onclick="doWork('selecttable()')"/>
			<ai:button id="queryClear" text="���" onclick="clearPrinciple()"/></td>
			</tr>
			<tr>
                <td colspan="4" align="right" ><span class="font_red" style="font-weight:bold font-size:40px">�޸ĺ��ն����ͺ���㱣��</span></td>
            </tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<div id = "mohtods1_div">
<ai:contractframe id="saleContractframe" contenttype="table" title="Ӫ������Ϣ" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem>
	<ai:button id="saveContract" text="����" onclick="saveContract()"/>
	<ai:button id="makeSure" text="������" onclick="makeSure()"/>
   </ai:contractitem>
 	<ai:table
		tableid="saleContractTable"
		setname="com.asiainfo.sale.activity.web.SETContract"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.activity.service.interfaces.IContractSV"
		implservice_querymethod="getContractInfoBySql(String sale_main_code,String sale_main_name, String sale_active_code, 
		                                     String sale_active_name, String is_contract,int $STARTROWINDEX, int $ENDROWINDEX)"
		implservice_countmethod="getContractCountBySql(String sale_main_code,String sale_main_name, String sale_active_code,
		                                     String sale_active_name, String is_contract)"
		initial="false"  multiselect="false" 
		pagesize="15" editable="true" width="100%"
		height="98%" needrefresh="true">
        <ai:col title="���α��" fieldname="SALE_MAIN_CODE" width="190" editable="false"/>
		<ai:col title="��������" fieldname="SALE_MAIN_NAME" width="290" editable="false"/>
		<ai:col title="���α��" fieldname="SALE_ACTIVE_CODE" width="190" editable="false"/>
		<ai:col title="��������" fieldname="SALE_ACTIVE_NAME" width="290" editable="false"/>
		<ai:col title="�ն�����" fieldname="IS_CONTRACT" width="150" />
	</ai:table>
</ai:contractframe>
</div>

<div id = "mohtods2_div">
<ai:contractframe id="MainDetailContractframe" contenttype="table" title="Ӫ������Ϣ" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem>
	<ai:button id="saveContract" text="����" onclick="saveContract()"/>
	<ai:button id="makeSure" text="������" onclick="makeSure()"/>
   </ai:contractitem>
 	<ai:table
		tableid="mainDetailContractTable"
		setname="com.asiainfo.sale.activity.web.SETMainDetailContract"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.activity.service.interfaces.IMainDetailContractSV"
		implservice_querymethod="getContractInfoBySql(String sale_main_code,String sale_main_name, String sale_active_code, 
		                                     String sale_active_name, String is_contract,int $STARTROWINDEX, int $ENDROWINDEX)"
		implservice_countmethod="getContractCountBySql(String sale_main_code,String sale_main_name, String sale_active_code,
		                                     String sale_active_name, String is_contract)"
		initial="false"  multiselect="false" 
		pagesize="15" editable="true" width="100%"
		height="98%" needrefresh="true">
        <ai:col title="���α��" fieldname="SALE_MAIN_CODE" width="190" editable="false"/>
		<ai:col title="��������" fieldname="SALE_MAIN_NAME" width="290" editable="false"/>
		<ai:col title="���α��" fieldname="SALE_ACTIVE_CODE" width="190" editable="false"/>
		<ai:col title="��������" fieldname="SALE_ACTIVE_NAME" width="290" editable="false"/>
        <ai:col title="�ն�����" fieldname="IS_CONTRACT" width="150" />
	</ai:table>
</ai:contractframe>
</div>
</body>
</html>
<ai:loginuser/>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/DBListBox.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script type="text/javascript">
var _fromSelectContractFormRowSet = g_FormRowSetManager.get("selectContractForm");
var _tableContractInfoTableRowSet = g_TableRowSetManager.get("saleContractTable");
var _tableContractInfoTable2RowSet = g_TableRowSetManager.get("mainDetailContractTable");
var flag='0';

function init(){
	//_fromSelectContractFormRowSet.addListBoxElement("IS_CONTRACT","4","δ��ʼ��");
	document.getElementById("mohtods2_div").style.display="none";
	_fromSelectContractFormRowSet.setValue("QUERY_MEHTODS","1");
	var ret= PostInfo(_gModuleName + '/business/com.asiainfo.sale.activity.web.MainDetailContractAction?action=querymakeSure');
	if(ret.getValueByName("FLAG") == '1'){
		flag='1';
	}
}

function makeSure(){
	if(flag=='1'){
		alert("�����Ѿ�������");
		return;
	}else if(flag=='0'){
	var count=queryremain();
	var ret= PostInfo(_gModuleName + '/business/com.asiainfo.sale.activity.web.MainDetailContractAction?action=makeSure');
	if(ret.getValueByName("FLAG") == 'N'){
		alert("����ʧ��");
	}else if(ret.getValueByName("FLAG") == 'Y'){
		flag='1'
		alert("�����ɹ�,����"+count+"δ��ʼ��");
	}
	}
}

function queryremain(){
	var ret= PostInfo(_gModuleName + '/business/com.asiainfo.sale.activity.web.MainDetailContractAction?action=queryremain');
	var count=ret.getValueByName("COUNT");
	return count;
}

function selecttable(){
	var query_mohtods = _fromSelectContractFormRowSet.getValue("QUERY_MEHTODS");
	var is_contract = _fromSelectContractFormRowSet.getValue("IS_CONTRACT");
	var sale_main_code = _fromSelectContractFormRowSet.getValue("SALE_MAIN_CODE");
	var sale_main_name = _fromSelectContractFormRowSet.getValue("SALE_MAIN_NAME");
	var sale_active_code = _fromSelectContractFormRowSet.getValue("SALE_ACTIVE_CODE");
	var sale_active_name = _fromSelectContractFormRowSet.getValue("SALE_ACTIVE_NAME");
	
	var condition = "&sale_main_code=" + sale_main_code
					+ "&sale_main_name=" + encodeURI(trim(sale_main_name))
					+ "&sale_active_code=" + sale_active_code
					+ "&sale_active_name=" + encodeURI(trim(sale_active_name))
					+ "&is_contract=" + is_contract;
	if(query_mohtods=="2"){
	_tableContractInfoTable2RowSet.refresh(condition);
	}else{
	_tableContractInfoTableRowSet.refresh(condition);
	}
}

function saveContract(){
	var query_mohtods = _fromSelectContractFormRowSet.getValue("QUERY_MEHTODS");
	var list = new Array();
    if (query_mohtods=="2"){
	list.push(_tableContractInfoTable2RowSet);
	var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.MainDetailContractAction?action=saveContract';
	}else{
	list.push(_tableContractInfoTableRowSet);
	var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.SaleContractAction?action=saveContract';
	}
  	var recode = saveRowSet(strUrl, list);
}

function trim(str){
     return str.replace(/(^\s*)|(\s*$)/g, '');
}

function clearPrinciple(){
	_fromSelectContractFormRowSet.setValue("SALE_MAIN_CODE","");
	_fromSelectContractFormRowSet.setValue("SALE_MAIN_NAME","");
	_fromSelectContractFormRowSet.setValue("SALE_ACTIVE_CODE","");
	_fromSelectContractFormRowSet.setValue("SALE_ACTIVE_NAME","");
	_fromSelectContractFormRowSet.setValue("IS_CONTRACT","");
	_fromSelectContractFormRowSet.setValue("QUERY_MEHTODS","1");
}

function onSelectContractFormValChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText){
	if (pFieldName == 'QUERY_MEHTODS'){
		showChangeObjectTag(pOldText);
	}
}

function showChangeObjectTag(chageObject) {
	if (chageObject == "1"){
		document.getElementById("mohtods1_div").style.display="block";
		document.getElementById("mohtods2_div").style.display="none";
	}else if (chageObject == "2"){
		document.getElementById("mohtods1_div").style.display="none";
		document.getElementById("mohtods2_div").style.display="block";
	}
}

</script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"���ڴ������Ժ�...");
}
</script>