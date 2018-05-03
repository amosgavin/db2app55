<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<title>�ʷѽṹ��Ϣ</title>
		<script language="javascript"
			src="<%=request.getContextPath()%>/jsv2/Calendar.jsp"
			type="text/javascript"></script>
		<script language="javascript"
			src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js"
			type="text/javascript"></script>
	</head>
	<body onload="initChargeProd()">
		<ai:contractframe id="prodframe" contenttype="table" title="�ʷѽṹ��Ϣ������д�ʷ���Ŀ������Ϊ�գ�"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem>
				<!-- <ai:button id="bt_saveAll" text="�����ʷѽṹ��Ϣ"
					onclick="doWork('doSaveProdAll()')" /> -->
			</ai:contractitem>
			<ai:contractframe id="prodframe_1" contenttype="table" title="�ʷ���Ŀ"
				width="100%" allowcontract="true" frameclosed="false">
				<ai:contractitem>
					<ai:button id="bt_add" text="����" onclick="doAddProd()" />
					<ai:button id="bt_del" text="ɾ��" onclick="doDelProd()" />
					<!--
					<ai:button id="bt_addExt" text="������չ����" onclick="doAddExt()" />
					<ai:button id="bt_showExt" text="�鿴��չ����" onclick="doShowExt()" />
					<ai:button id="bt_save" text="����" onclick="doWork('doSaveProd()')"/>-->
				</ai:contractitem>
				<ai:table tableid="tblProd"
					setname="com.asiainfo.charge.web.SETChargeApplyProdAttr"
					conditionname="condition" parametersname="parameters" width="100%"
					rowsequence="true" editable="true" initial="false" pagesize="10"
					height="100" needrefresh="true" multiselect="true"
					tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.asiainfo.charge.service.interfaces.IChargeProdAttrSV"
					implservice_querymethod="getProdAttrById(String chargeId, int $STARTROWINDEX, int $ENDROWINDEX)"
					implservice_countmethod="getProdAttrCount(String chargeId)">
					<ai:col title="���" fieldname="APPLY_ID" width="" visible="false" />
					<ai:col title="�ʷ�ID" fieldname="CHARGE_ID" width="" visible="false" />
					<ai:col title="�ʷ���Ŀ������ID" fieldname="APPLY_MAIN_ID" width=""
						visible="false" />
					<ai:col title="��Ŀ" fieldname="PROD_TYPE" width="15%" />
					<ai:col title="�ʷѷ�Χ" fieldname="AREA_TYPE" width="15%" />
					<ai:col title="����(Ԫ/���ӻ�Ԫ/����Ԫ/��)" fieldname="UNIT_PRICE" width="15%" />
					<ai:col title="������(���ӻ�������)" fieldname="GIVES_AMOUNT" width="15%" />
					<ai:col title="�������Ƿ�������" fieldname="GIVES_AMOUNT_TYPE" width="18%" />
					<ai:col title="��ע" fieldname="REMARKS" width="20%" />
					<ai:col title="״̬" fieldname="STATE" width="" visible="false" />
					<ai:col title="������" fieldname="PRINCIPAL" width="" visible="false" />
					<ai:col fieldname="EXT1" visible="false"/>

				</ai:table>
			</ai:contractframe>

			<ai:dbform formid="FormProd_Ext"
				setname="com.asiainfo.charge.web.SETChargeApplyProdAttrExt"
				conditionname="condition" parametersname="parameters"
				initial="false" onvalchange=""
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.asiainfo.charge.service.interfaces.IChargeProdAttrSV"
				implservice_querymethod="getProdAttrExtById(String chargeId)">
				<ai:contractframe id="prodframe_2" contenttype="table" title="�ʷ���Ϣ(��������û������)"
					width="100%" allowcontract="true" frameclosed="false">
					<ai:contractitem />
					<table width="98%" align="center" border="0" cellpadding="1"
						cellspacing="2">
						<tr>
							<td>
								<b>�̶��ѣ�</b>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								һ������ȡ��
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="DISPOSABLE_INCOME" width="150" />
								<span class="font_red">*</span>
							</td>
							<td class="td_font">
								��һ������ȡ��
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="NON_DISPOSABLE_INCOME" width="150" />
								<span class="font_red">*</span>
							</td>
							<td class="td_font">
								�Ƿ��µ�ȡ����
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext" fieldname="ROUNDING"
									width="150" />
								<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								���û��Ƿ���ȫ�����⣺
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="IS_MONTHLY_RENT" width="150" />
								<span class="font_red">*</span>
							</td>
							<td class="td_font">
								���ײ�ʹ�÷���(Ԫ)��
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext" fieldname="MONTHLY_FEE"
									width="150" />
								<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td>
								<b>�˵��Żݣ�</b>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								�Ƿ��б��ף�
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="IS_MINIMUM_CHARGE" width="150" />
								<span class="font_red">*</span>
							</td>
							<td class="td_font">
								���׷�Χ��
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="MINIMUM_CHARGE_RANGE" width="150" />
									<span class="font_red">*</span>
							</td>
							<td class="td_font">
								�Ƿ��������û�����
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="IS_USER_PROCESS" width="150" />
								<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								�����Żݣ�
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="OTHER_PREFERENTIAL" width="150" />
									<span class="font_red">*</span>
							</td>
							<td class="td_font">
								�Żݷ�Χ��
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="PREFERENTIAL_RANGE" width="150" />
									<span class="font_red">*</span>
							</td>
							<td class="td_font">
								�Ż�������
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="PREFERENTIAL_CONDITIONS" width="150" />
									<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td>
								<b>����������</b>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								�������ʷѵ��ӵĴ���
							</td>
							<td colspan="5">
								<ai:dbformfield formid="FormProd_Ext" fieldname="CHARGE_PROCESS"
									width="80%" />
									<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								�������ʷѵĻ��⣺
							</td>
							<td colspan="5">
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="CHARGE_REPULSION" width="80%" />
									<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td>
								<b>��Ʒ������˵����</b>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								����������������
							</td>
							<td colspan="5">
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="CHANNEL_DESCRIPTION" width="80%" height="50" />
									<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								������Ʒ��������
							</td>
							<td colspan="5">
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="PRODUCT_DESCRIPTION" width="80%" height="50" />
									<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td>
								<b>������֧��˵����</b>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								�ײͷѵ�����ռ�ȷֳɣ�
							</td>
							<td colspan="5">
								<ai:dbformfield formid="FormProd_Ext" fieldname="INCOME_SHARE"
									width="80%" height="50" />
									<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								���񱨱��ϵ���֧��
							</td>
							<td colspan="5">
								<ai:dbformfield formid="FormProd_Ext" fieldname="REPORT_DETAILS"
									width="80%" height="50" />
									<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								�����˵����
							</td>
							<td colspan="5">
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="SETTLEMENT_INSTRUCTIONS" width="80%" height="50" />
									<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td>
								<ai:dbformfield formid="FormProd_Ext" fieldname="PRINCIPAL"
									width="" visible="false" />
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext" fieldname="STATE" width=""
									visible="false" />
							</td>
						</tr>
						<tr>
							<td>
								<b>�����ʷ�Ҫ��</b>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								�����ʷ�Ҫ��
							</td>
							<td colspan="5">
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="OTHER_CHARGE_REQUIREMENT" width="80%" height="50" />
									<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td>
								<ai:dbformfield formid="FormProd_Ext" fieldname="CHARGE_ID"
									width="" visible="false" />
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext" fieldname="APPLY_ID"
									width="" visible="false" />
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext" fieldname="APPLY_NAME"
									width="" visible="false" />
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext" fieldname="PROMOTE_DEPART"
									width="" visible="false" />
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext" fieldname="AREA_CODE"
									width="" visible="false" />
							</td>

						</tr>
					</table>
				</ai:contractframe>
			</ai:dbform>

			<!-- <table align="center" height="10">
   	 
   	 	<ai:button id="bt_1" text="�½�" onclick="newProdExt()"/>&nbsp;&nbsp;
    	<ai:button id="bt_2" text="�޸�" onclick="modifyProdExt()"/>&nbsp;&nbsp;
		<ai:button id="bt_3" text="����" onclick="doWork('doSaveProdExt(true)')"/>&nbsp;&nbsp;
		<ai:button id="bt_4" text="T_�ʷѲ��Ա���" onclick="doTestProdAttr()"/>&nbsp;&nbsp;
		<ai:button id="bt_5" text="T_�ʷѲ��Ա������" onclick="doCheckTestProdAttr()"/>&nbsp;&nbsp;
	</table>-->
			<ai:button id="bt_saveAll2" text="�����ʷѽṹ��Ϣ"
				onclick="doWork('doSaveProdAll()')" />
		</ai:contractframe>
	</body>
</html>
<script language="javascript"
	src="<%=request.getContextPath()%>/jsv2/DBListBox.js"></script>
<script language="javascript"
	src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>


<script type="text/javascript">
var feeType = "<%=request.getParameter("feeType")%>";
var applyId = "<%=request.getParameter("applyId")%>";
var mainState = "<%=request.getParameter("state")%>";

var tblProd = g_TableRowSetManager.get("tblProd");
var ProdExtF = g_FormRowSetManager.get("FormProd_Ext");

var isTest = false;



function initChargeProd()
{
	var chargeId = _fromChargeMainDeFormRowSet.getValue("MID");
    if(chargeId != "" && chargeId != null && chargeId != "undefined"){
		tblProd.refresh("&chargeId=" +chargeId);
		ProdExtF.refresh("&chargeId=" +chargeId);
	}
	//setWebStatus();
	
}

function doAddProd() {
	var chargeId = _fromChargeMainDeFormRowSet.getValue("MID");
	if(chargeId == "" || chargeId == null || chargeId == "undefined"){
		alert("���ȱ����ʷѵ�����Ϣ��");
		return;
	}
	
	var staffId = g_GetUserInfo().STAFF_ID;
	var cityCode = g_GetUserInfo().ORG_ID.substr(0,2);
	
	var formApplyId = ProdExtF.getValue("APPLY_ID");  

	tblProd.newRow(false);
	var curRow = tblProd.getRow();
	tblProd.setValue(curRow,"CHARGE_ID",chargeId,chargeId);
	tblProd.setValue(curRow,"PROD_TYPE","1");
	tblProd.setValue(curRow,"AREA_TYPE","1");
	tblProd.setValue(curRow,"STATE","1");
	tblProd.setValue(curRow,"PRINCIPAL",staffId);	
	
	//���form�����Ѿ����ڣ���tbl����APPLY_MAIN_ID
	if(formApplyId != null && formApplyId != ""){
		tblProd.setValue(curRow,"APPLY_MAIN_ID",formApplyId);	
	}	
	//tblProd.setFocus(curRow,"UNIT_PRICE");
	
}

function doDelProd(){
	if(!confirm("��ȷ��Ҫɾ��ѡ�еļ�¼��")){
		return false;
	}
	
	var selectedRows = tblProd.getSelectedRows();
	var RowCount = selectedRows.length;
	
    var staffId = g_GetUserInfo().STAFF_ID;
	var bFound = false;
	while (RowCount > 0) {
		RowCount--;
		var prodId = tblProd.getValue(selectedRows[RowCount], "APPLY_ID");
		
		var state = tblProd.getValue(selectedRows[RowCount], "STATE");
		if (staffId == tblProd.getValue(selectedRows[RowCount], "PRINCIPAL")){
			if (state != "1") {
				alert("��ѡ�ļ�¼�����ѱ���״̬��������ɾ����������ѡ��");
				return;
			}else{
				if(prodId != null && prodId!=""){
					bFound = true;
				}
				tblProd.deleteRow(selectedRows[RowCount]);
				
			}
		}else {
			alert("��ѡ�ļ�¼�����Լ��ģ�������ɾ����");
			return;
		}
	}
	if(bFound){
		var list = new Array();
		list.push(tblProd);
		var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeProdAttrAction?action=delProdAttr",list);
		if(ud.getValueByName("retVal") == "Y"){
			alert(ud.getValueByName("retMsg"));
		}else{
			alert(ud.getValueByName("retMsg"));
			return;
		}
	}
	
	//���CHARGE_APPLY_PROD_ATTR_EXT_T �����ݴ��ڣ���Ҫ�����������ʷѽṹ�ĵ����ײ�����
	var extApplyId = ProdExtF.getValue("APPLY_ID");
	if(extApplyId != null && extApplyId != "" && bFound ){
		updateProdExt("del");
	}
}


function doSaveProd(){
	var xmlbody = tblProd.toXmlString(true);
	if(xmlbody == ""){
		alert("��ʾ��û����Ҫ��������ݣ�");
		return;
	}
	
	var tempArr = new Array(); 
	for(var i = 0; i < tblProd.getTotalRowCount();i++){
		var prodTypeName = tblProd.getDisplayText(i, "PROD_TYPE");
		tempArr.push(prodTypeName);
		if(prodTypeName == "" || prodTypeName == null){
			alert("��ѡ���"+(i+1)+"�� ��Ŀ �е����ݣ�");
			return;
		}
		
		var areaTypeName = tblProd.getDisplayText(i, "AREA_TYPE");
		if(areaTypeName == "" || areaTypeName == null){
			alert("��ѡ���"+(i+1)+"�� �ʷѷ�Χ �е����ݣ�");
			return;
		}
	}
	var nary = tempArr.sort();
	for(var i = 0;i < tempArr.length;i++){
	  if (nary[i]==nary[i+1]){
	  	alert("����������ͬ����Ŀ����ȷ�ϣ�");
	  	return;
	  }
	}
	
	
	var chargeId = _fromChargeMainDeFormRowSet.getValue("MID");
	var dealUrlParam = "&chargeId="+chargeId + "&isTest="+isTest;	
	var list = new Array();
	list.push(tblProd);
	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeProdAttrAction?action=saveProdAttr"+dealUrlParam, list);

	//var id = ud.getValueByName("retId");
	if(ud.getValueByName("retVal") == "Y"){
		alert(ud.getValueByName("retMsg"));
		tblProd.refresh("&chargeId=" +chargeId);
	}else{
		alert(ud.getValueByName("retMsg"));
		tblProd.setStsToNew();
		return;
	}
	
	//���CHARGE_APPLY_PROD_ATTR_EXT_T �����ݴ��ڣ���Ҫ�����������ʷѽṹ�ĵ����ײ�����
	var extApplyId = ProdExtF.getValue("APPLY_ID");
	if(extApplyId != null && extApplyId != ""){
		updateProdExt("add");
	}
}

function getItemFeeName(){
	var itemFeeName = "";
	for(var i = 0; i < tblProd.getTotalRowCount();i++){
		var prodTypeName = tblProd.getDisplayText(i, "PROD_TYPE");
		var areaTypeName = tblProd.getDisplayText(i, "AREA_TYPE");
		var unitPrice = tblProd.getValue(i,"UNIT_PRICE");
		var givesAmount = tblProd.getValue(i,"GIVES_AMOUNT");
		var givesAmountType = tblProd.getDisplayText(i,"GIVES_AMOUNT_TYPE");
		var unit = 'Ԫ/����';
		var presentUnit = '����';

		
		itemFeeName += prodTypeName + '+' + areaTypeName;
		if(unitPrice != "null" && unitPrice != ""){
			if (prodTypeName == "����" || prodTypeName == "����") {
				unit = 'Ԫ/��';
				presentUnit = '��';
			} else if (prodTypeName == "����") {
				unit = 'Ԫ/��';
				presentUnit = '��';
			} 
			itemFeeName += '������' + unitPrice + unit;
		}
		if(givesAmount != "null" && givesAmount != ""){
			itemFeeName += '����������' + givesAmount + presentUnit;
		}
		if(givesAmount != "null" && givesAmount != ""){
			itemFeeName += '���������Ƿ������㣺' + givesAmountType;
		}		
		itemFeeName += '��';
		
	}
	return itemFeeName;
}


//add by jiangxl
var xmlArray = new Array(); 

function doAddExt(){
	var selectedRows = tblProd.getSelectedRows();
	var len = selectedRows.length;
	if(len <=0){
		alert("��ѡ��һ����¼");
		return;
	}
	else if (len >1){
		alert("��ֻ��ѡ��һ����¼");
		return;
	}
	var type = tblProd.getValue(selectedRows[0],"PROD_TYPE");
	var apply_id = tblProd.getValue(selectedRows[0],"APPLY_ID");
	var chargeId = tblProd.getValue(selectedRows[0],"CHARGE_ID");
	
	if(null == type || ""== type){
		alert("��ѡ����Ŀ��");
		return;
	}
	var param = "&type="+type+"&opType=1"+"&applyId="+apply_id+"&chargeId="+chargeId;
	
	var url = "<%=request.getContextPath()%>/charge/chargeinfo/chargeInfoExt.jsp?"+param; //����
	
	var xml = window.showModalDialog(url,'',"scroll:no;resizable:no;status:no;dialogHeight:450px;dialogWidth:800px"); 
	//var xml = window.open(url); 
	
	if(null!= xml && ""!=xml){
		tblProd.setValue(selectedRows[0],"EXT1",xml);
	//	xmlArray.push(xml);
	//	alert(xml);
		
		
	}
	
	

}

function doShowExt(){
	var selectedRows = tblProd.getSelectedRows();
	var len = selectedRows.length;
	if(len <=0){
		alert("��ѡ��һ����¼");
		return;
	}
	else if (len >1){
		alert("��ֻ��ѡ��һ����¼");
		return;
	}
	var type = tblProd.getValue(selectedRows[0],"PROD_TYPE");
	var apply_id = tblProd.getValue(selectedRows[0],"APPLY_ID");
	var chargeId = tblProd.getValue(selectedRows[0],"CHARGE_ID");
	
	if(null == type || ""== type){
		alert("��ѡ����Ŀ��");
		return;
	}
	var param = "&type="+type+"&opType=2"+"&applyId="+apply_id+"&chargeId="+chargeId;
	
	var url = "<%=request.getContextPath()%>/charge/chargeinfo/chargeInfoExt.jsp?"+param; //����
	
	window.showModalDialog(url,'',"scroll:no;resizable:no;status:no;dialogHeight:450px;dialogWidth:800px"); 
	//var xml = window.open(url); 
	
}


</script>

<script type="text/javascript">
//ProdExtF.setValue("CHARGE_ID","123456");
function newProdExt()
{
	var chargeId = _fromChargeMainDeFormRowSet.getValue("MID");
	
	if(chargeId == "" || chargeId == null || chargeId == "undefined"){
		alert("���ȱ����ʷѵ�����Ϣ��");
		return;
	}

    if(window.confirm("�½������δ�������Ϣ��ȷ��Ҫ�½���"))
    {
        location.reload();
        //ProdExtF.clear();
    }
}

function doSaveProdExt(){
	var chargeId = _fromChargeMainDeFormRowSet.getValue("MID");
	if(chargeId == "" || chargeId == null || chargeId == "undefined"){
		alert("���ȱ����ʷѵ�����Ϣ��");
		return;
	}

	var tblApplyId = tblProd.getValue(0, "APPLY_ID");
	if(tblApplyId == "" || tblApplyId == null || tblApplyId == "undefined"){
		alert("���ȱ��� �ʷ���Ŀ��");
		return;
	}

	if("" == ProdExtF.getValue("DISPOSABLE_INCOME")){return  alert("һ������ȡ��������Ϊ�գ�");}
	if("" == ProdExtF.getValue("NON_DISPOSABLE_INCOME")){return  alert("��һ������ȡ��������Ϊ�գ�");}
	if("" == ProdExtF.getValue("ROUNDING")){return  alert("�Ƿ��µ�ȡ����������Ϊ�գ�");}
	if("" == ProdExtF.getValue("IS_MONTHLY_RENT")){return  alert("���û��Ƿ���ȫ�����⣬������Ϊ�գ�");}
	if("" == ProdExtF.getValue("MONTHLY_FEE")){return  alert("���ײ�ʹ�÷��ã�������Ϊ�գ�");}
	if("" == ProdExtF.getValue("IS_MINIMUM_CHARGE")){return  alert("�Ƿ��б��ף�������Ϊ�գ�");}
	if("" == ProdExtF.getValue("IS_USER_PROCESS")){return  alert("�Ƿ��������û�����������Ϊ�գ�");}
	
	var cityCode = g_GetUserInfo().ORG_ID.substr(0,2);
	ProdExtF.setValue("CHARGE_ID",chargeId);
	ProdExtF.setValue("STATE","1"); //���ݱ���״̬
    //var feeName = _fromChargeMainDeFormRowSet.getValue("FEE_NAME");
	
	var itemFeeName = getItemFeeName();  //��ȡ�ʷ�������ϸ�ʷ�
	//feeName = feeName + '��������' + itemFeeName;
	
	feeName = itemFeeName;
	ProdExtF.setValue("APPLY_NAME",feeName);


	
	var xmlProdExtForm = ProdExtF.toXmlString(true);
	if("" == xmlProdExtForm){
		alert("��ʾ��û����Ҫ��������ݣ�");
		return;
	}

	
	var dealUrlParam = "&cityCode="+cityCode + "&isTest="+isTest;
	var list = new Array();
	list.push(ProdExtF);
	
	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeProdAttrAction?action=saveProdAttrExt"+dealUrlParam, list);
	var id = ud.getValueByName("retId");
	if(ud.getValueByName("retVal") == "Y"){
		alert(ud.getValueByName("retMsg"));
		ProdExtF.refresh("&chargeId=" +chargeId);
		window.parent.window.opener.chargeDetailListTable.refresh("&mainId="+applyId+"&feeType="+feeType);
    	window.parent.window.opener.showTableOn();
	}else{
		alert(ud.getValueByName("retMsg"));
		ProdExtF.setStsToNew();
		return;
	}
}

function doSaveProdAll(){
	//�ж��ʷѵ����Ƿ񱣴�
	var chargeId = _fromChargeMainDeFormRowSet.getValue("MID");
	if(chargeId == "" || chargeId == null || chargeId == "undefined"){
		return alert("���ȱ����ʷѵ�����Ϣ��");
	}

	//�ж��ʷѽṹ��Ϣ�� �ʷ���Ŀ �Ƿ���д
	var rowCount = tblProd.getTotalRowCount();
	if(rowCount == 0){
		return  alert("�ʷ���Ŀ��������Ϊ�գ�");
	}else{
		var tempArr = new Array(); 
		for(var i = 0; i < tblProd.getTotalRowCount();i++){
			var prodTypeName = tblProd.getDisplayText(i, "PROD_TYPE");
			tempArr.push(prodTypeName);
			if(prodTypeName == "" || prodTypeName == null){
				return alert("��ѡ���"+(i+1)+"�� ��Ŀ �е����ݣ�");
			}
		
			var areaTypeName = tblProd.getDisplayText(i, "AREA_TYPE");
			if(areaTypeName == "" || areaTypeName == null){
				return alert("��ѡ���"+(i+1)+"�� �ʷѷ�Χ �е����ݣ�");
			}
		}
		var nary = tempArr.sort();
		for(var i = 0;i < tempArr.length;i++){
	  		if (nary[i]==nary[i+1]){
	  			return alert("����������ͬ����Ŀ����ȷ�ϣ�");
	  		}
		}
	}
	
	//�ж��ʷѽṹ��Ϣ�� �ʷ���Ϣ �Ƿ���д
	if("" == ProdExtF.getValue("DISPOSABLE_INCOME")){return  alert("һ������ȡ��������Ϊ�գ�");}
	if("" == ProdExtF.getValue("NON_DISPOSABLE_INCOME")){return  alert("��һ������ȡ��������Ϊ�գ�");}
	if("" == ProdExtF.getValue("ROUNDING")){return  alert("�Ƿ��µ�ȡ����������Ϊ�գ�");}
	if("" == ProdExtF.getValue("IS_MONTHLY_RENT")){return  alert("���û��Ƿ���ȫ�����⣬������Ϊ�գ�");}
	if("" == ProdExtF.getValue("MONTHLY_FEE")){return  alert("���ײ�ʹ�÷��ã�������Ϊ�գ�");}
	if("" == ProdExtF.getValue("IS_MINIMUM_CHARGE")){return  alert("�Ƿ��б��ף�������Ϊ�գ�");}
	if("" == ProdExtF.getValue("IS_USER_PROCESS")){return  alert("�Ƿ��������û�����������Ϊ�գ�");}
	if("" == ProdExtF.getValue("MINIMUM_CHARGE_RANGE")){return  alert("���׷�Χ��������Ϊ�գ�");}
	if("" == ProdExtF.getValue("OTHER_PREFERENTIAL")){return  alert("�����Żݣ�������Ϊ�գ�");}
	if("" == ProdExtF.getValue("PREFERENTIAL_RANGE")){return  alert("�Żݷ�Χ��������Ϊ�գ�");}
	if("" == ProdExtF.getValue("CHARGE_PROCESS")){return  alert("�������ʷѵ��ӵĴ���������Ϊ�գ�");}
	if("" == ProdExtF.getValue("CHARGE_REPULSION")){return  alert("�������ʷѵĻ��⣬������Ϊ�գ�");}
	if("" == ProdExtF.getValue("CHANNEL_DESCRIPTION")){return  alert("����������������������Ϊ�գ�");}
	if("" == ProdExtF.getValue("PRODUCT_DESCRIPTION")){return  alert("������Ʒ��������������Ϊ�գ�");}
	if("" == ProdExtF.getValue("INCOME_SHARE")){return  alert("�ײͷѵ�����ռ�ȷֳɣ�������Ϊ�գ�");}
	if("" == ProdExtF.getValue("REPORT_DETAILS")){return  alert("���񱨱��ϵ���֧��������Ϊ�գ�");}
	if("" == ProdExtF.getValue("SETTLEMENT_INSTRUCTIONS")){return  alert("�����˵����������Ϊ�գ�");}
	if("" == ProdExtF.getValue("OTHER_CHARGE_REQUIREMENT")){return  alert("�����ʷ�Ҫ�󣬲�����Ϊ�գ�");}
	
	var xmlbodyTbl = tblProd.toXmlString(true);
	var xmlbodyFrm = ProdExtF.toXmlString(true);
	
	if("" == xmlbodyTbl && "" == xmlbodyFrm){
		return alert("��ʾ��û����Ҫ��������ݣ�");
	}
	//��ȡ�ʷ��ײ�
	var feeName = getItemFeeName();
	ProdExtF.setValue("APPLY_NAME",feeName);
	
	var isDone = false;
	var staffId = g_GetUserInfo().STAFF_ID;
	var cityCode = g_GetUserInfo().ORG_ID.substr(0,2);
	var departId = g_GetUserInfo().ORG_ID;

	var chargeId = _fromChargeMainDeFormRowSet.getValue("MID");
	var dealUrlParam = "&cityCode="+cityCode + "&chargeId="+chargeId + "&isTest="+isTest;	
	
	if("" != xmlbodyTbl){
		var listTbl = new Array();
		listTbl.push(tblProd);
		var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeProdAttrAction?action=saveProdAttr"+dealUrlParam, listTbl);
		
		if(ud.getValueByName("retVal") == "Y"){
			isDone = true;
			tblProd.refresh("&chargeId=" +chargeId);
		}else{
			alert(ud.getValueByName("retMsg"));
			//tblProd.setStsToNew();
			return;
		}
		//���CHARGE_APPLY_PROD_ATTR_EXT_T �����ݴ��ڣ�����û�޸�����£���Ҫ�����������ʷѽṹ�ĵ����ײ�����
		var extApplyId = ProdExtF.getValue("APPLY_ID");
		if(extApplyId != null && extApplyId != "" && "" == xmlbodyFrm ){
			updateProdExt("add");
		}
	}

	if("" != xmlbodyFrm){
		var formchargeId = ProdExtF.getValue("CHARGE_ID");  
		if(formchargeId == "" || formchargeId == null){
			ProdExtF.setValue("CHARGE_ID",chargeId);
		}
		var state = ProdExtF.getValue("STATE");  
		if(state == "" || state == null){
			ProdExtF.setValue("STATE","1"); 
			ProdExtF.setValue("PRINCIPAL",staffId);	
			ProdExtF.setValue("PROMOTE_DEPART",departId);	
			ProdExtF.setValue("AREA_CODE",cityCode);	
		}
		
		var listFrm = new Array();
		listFrm.push(ProdExtF);
		var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeProdAttrAction?action=saveProdAttrExt"+dealUrlParam, listFrm);
		//var id = ud.getValueByName("retId");
		if(ud.getValueByName("retVal") == "Y"){
			isDone = true;
			ProdExtF.refresh("&chargeId=" +chargeId);

		}else{
			ProdExtF.setStsToNew();
			return;
		}
	}
	alert(ud.getValueByName("retMsg"));
	if(isDone){
		window.parent.window.opener.chargeDetailListTable.refresh("&mainId="+applyId+"&feeType="+feeType);
		window.parent.window.opener.showTableOn();
	}
}




function updateProdExt(opType){
    var feeName = getItemFeeName();
	ProdExtF.setValue("APPLY_NAME",feeName);
	
	var cityCode = g_GetUserInfo().ORG_ID.substr(0,2);
	var dealUrlParam = "&cityCode="+cityCode + "&isTest="+isTest;
	var list = new Array();
	list.push(ProdExtF);
	
	
	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeProdAttrAction?action=saveProdAttrExt"+dealUrlParam, list);
	if(ud.getValueByName("retVal") != "Y"){
		alert(ud.getValueByName("retMsg"));
		return;
	}
	window.parent.window.opener.chargeDetailListTable.refresh("&mainId="+applyId+"&feeType="+feeType);
    window.parent.window.opener.showTableOn();
}






function modifyProdExt()
{
    if(window.confirm("��ȷ��Ҫ�޸���"))
    {
        //setEditStatus(2);
    }else{return;}
    
}

function getDefualtExearea(){
	var org = g_GetUserInfo().ORG_ID.substr(0,2);
	var cases = {
	  	10:999,
		11:270,
		17:710,
		13:711,
		26:712,
		25:713,
		12:714,
		19:715,
		20:716,
		14:717,
		15:718,
		16:719,
		24:722,
		23:724,
		18:728
	};
	if (cases[org]) {
  		return (cases[org]);
	}
}

//���ò��������״̬
function setWebStatus(){
	var staffId = g_GetUserInfo().STAFF_ID;
	var principal = ProdExtF.getValue("PRINCIPAL");
	if(principal != "" && principal != null && staffId != principal){
		tblProd.setEditSts(false);
		ProdExtF.setEditSts(false);
		g_AIButtonManager.get("bt_add").setDisabled(true); 
		g_AIButtonManager.get("bt_del").setDisabled(true); 
		//g_AIButtonManager.get("bt_addExt").setDisabled(true); 
		//g_AIButtonManager.get("bt_saveAll").setDisabled(true); 
		g_AIButtonManager.get("bt_saveAll2").setDisabled(true); 
	}else{
		if(mainState != "1" && mainState != "" && mainState != "null"){
			tblProd.setEditSts(false);
			ProdExtF.setEditSts(false);
			g_AIButtonManager.get("bt_add").setDisabled(true); 
			g_AIButtonManager.get("bt_del").setDisabled(true); 
			//g_AIButtonManager.get("bt_addExt").setDisabled(true); 
			//g_AIButtonManager.get("bt_saveAll").setDisabled(true); 
			g_AIButtonManager.get("bt_saveAll2").setDisabled(true);
			
		}
	}
	
}

</script>


<script language="javascript"
	src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"���ڴ������Ժ�...");
}
</script>

<script type="text/javascript">
function addLoadEvent(func) {  
    var oldonload = window.onload;  
    if(typeof window.onload != "function"){  
        window.onload = func;  
    }else{  
        window.onload = function(){  
            oldonload();  
            func();  
        }  
    }  
}  
//addLoadEvent(init);
//addLoadEvent(initCheckPage);
//addLoadEvent(include_reflashAttachTable);

</script>

<script type="text/javascript">
function doTestProdAttr(){
	var chargeId = _fromChargeMainDeFormRowSet.getValue("MID");
	var isSubmit = "1"; 
	window.open("<%=request.getContextPath()%>/charge/include/_chargeTestProdAttr.jsp?chargeId="+chargeId+"&isSubmit="+isSubmit,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");	
}

function doCheckTestProdAttr(){
	var chargeId = _fromChargeMainDeFormRowSet.getValue("MID");
	var isSubmit = "1"; 
	window.open("<%=request.getContextPath()%>/charge/include/_chargeTestProdAttrCheck.jsp?chargeId="+chargeId+"&isSubmit="+isSubmit,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");	
	//initProdTest();
}



</script>


