<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>�ʷѲ��Ա������</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
</head>
<body onload="initTestResult()">
<ai:contractframe id="prodframeTest" contenttype="table" title="�ʷѲ��Ա���" width="100%" allowcontract="true" frameclosed="true">
 	<ai:contractitem/>
	<ai:contractframe id="prodframe_1" contenttype="table" title="�ʷ���Ŀ" width="100%" allowcontract="true" frameclosed="false">
 	<ai:contractitem/>
 	<ai:table
		tableid="tblProdTest"   
		setname="com.asiainfo.charge.web.SETChargeApplyProdAttr"
		conditionname="condition" parametersname="parameters" width="100%" rowsequence="true"
		editable="true" initial="false" pagesize="10" height="150"
		needrefresh="true" multiselect="false"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.charge.service.interfaces.IChargeProdAttrSV"
		implservice_querymethod="getProdAttrById(String chargeId, int $STARTROWINDEX, int $ENDROWINDEX)"
		implservice_countmethod="getProdAttrCount(String chargeId)">
        <ai:col title="���" fieldname="APPLY_ID" width="5" visible="false" />
		<ai:col title="�ʷ�ID" fieldname="CHARGE_ID" width="5" visible="false" />
        <ai:col title="��Ŀ" fieldname="PROD_TYPE" width="10%" editable="false"/>
		<ai:col title="�ʷѷ�Χ" fieldname="AREA_TYPE" width="10%" editable="false"/>
		<ai:col title="����(Ԫ����)" fieldname="UNIT_PRICE" width="15%" editable="false"/>
        <ai:col title="������(������)" fieldname="GIVES_AMOUNT" width="15%" editable="false"/>
        <ai:col title="�������Ƿ�������" fieldname="GIVES_AMOUNT_TYPE" width="18%" editable="false"/>
        <ai:col title="���ڲ���" fieldname="TEST_ITEM_A" width="10%"/>
        <ai:col title="�������" fieldname="TEST_ITEM_B" width="10%" />
        <ai:col title="����Ӳ���(ֻ�������)" fieldname="TEST_ITEM_C" width="20%" />
        <ai:col title="״̬" fieldname="STATE" width="" visible="false"/>
        <ai:col title="������" fieldname="PRINCIPAL" width="" visible="false"/>
	</ai:table>
	</ai:contractframe>

	<ai:dbform formid="FormProdTest" 
  			setname="com.asiainfo.charge.web.SETChargeApplyProdAttrExt"
            conditionname="condition" parametersname="parameters"
            initial="false" onvalchange=""
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.charge.service.interfaces.IChargeProdAttrSV"
            implservice_querymethod="getProdAttrExtById(String chargeId)">

		<ai:contractframe id="prodframe_2" contenttype="table" title="�̶���" width="100%" allowcontract="true" frameclosed="fale">
		<ai:contractitem/>
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">һ������ȡ��</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="DISPOSABLE_INCOME" width="150" editable="false"/></td>
	           	<td><input type="checkbox" id="isTest1" value="1" onclick="isTestCheck(1);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
	        </tr>
	        <tr>
	           	<td class="td_font">��һ������ȡ��</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="NON_DISPOSABLE_INCOME" width="150" editable="false"/></td>
	           	<td><input type="checkbox" id="isTest2" value="1" onclick="isTestCheck(2);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
			</tr>
			<tr>
				<td class="td_font">�Ƿ��µ�ȡ����</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="ROUNDING" width="150" editable="false"/></td>
			    <td><input type="checkbox" id="isTest3" value="1" onclick="isTestCheck(3);" title="�Ƿ���ԣ����̣�" /><span class="font_red">�Ƿ���ԣ����̣�</span></td>
		    </tr>
		    <tr>
				<td class="td_font">���û��Ƿ���ȫ�����⣺</td>
	        	<td><ai:dbformfield formid="FormProdTest" fieldname="IS_MONTHLY_RENT" width="150" editable="false"/></td>
			    <td><input type="checkbox" id="isTest4" value="1" onclick="isTestCheck(4);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
		    </tr>
		    <tr>
				<td class="td_font">���ײ�ʹ�÷���(Ԫ)��</td>
	        	<td><ai:dbformfield formid="FormProdTest" fieldname="MONTHLY_FEE" width="150" editable="false"/></td>
			    <td><input type="checkbox" id="isTest5" value="1" onclick="isTestCheck(5);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
			</tr>
		</table>
		</ai:contractframe>
		
		<ai:contractframe id="prodframe_3" contenttype="table" title="�˵��Ż�" width="100%" allowcontract="true" frameclosed="fale">
		<ai:contractitem/>
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">�Ƿ��б��ף�</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="IS_MINIMUM_CHARGE" width="150" editable="false"/></td>
	           	<td><input type="checkbox" id="isTest6" value="1" onclick="isTestCheck(6);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
	        </tr>    	
	        <tr>
	           	<td class="td_font">���׷�Χ��</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="MINIMUM_CHARGE_RANGE" width="150" editable="false"/></td>
	           	<td><input type="checkbox" id="isTest7" value="1" onclick="isTestCheck(7);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
 			</tr>
 			<tr>
	           	<td class="td_font">�Ƿ��������û�����</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="IS_USER_PROCESS" width="150" editable="false"/></td>
	           	<td><input type="checkbox" id="isTest8" value="1" onclick="isTestCheck(8);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
			</tr>
			<tr>
	           	<td class="td_font">�����Żݣ�</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="OTHER_PREFERENTIAL" width="150" editable="false"/></td>
	           	<td><input type="checkbox" id="isTest9" value="1" onclick="isTestCheck(9);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
			</tr>
			<tr>			
	           	<td class="td_font">�Żݷ�Χ��</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="PREFERENTIAL_RANGE" width="150" editable="false"/></td>
	           	<td><input type="checkbox" id="isTest10" value="1" onclick="isTestCheck(10);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
			</tr>
			<tr>
	           	<td class="td_font">�Ż�������</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="PREFERENTIAL_CONDITIONS" width="150" editable="false"/></td>
	           	<td><input type="checkbox" id="isTest11" value="1" onclick="isTestCheck(11);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
			</tr>
		</table>
		</ai:contractframe>
	
		<ai:contractframe id="prodframe_4" contenttype="table" title="��������" width="100%" allowcontract="true" frameclosed="fale">
		<ai:contractitem/>
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">�������ʷѵ��ӵĴ���</td>
	           	<td colspan="3"><ai:dbformfield formid="FormProdTest" fieldname="CHARGE_PROCESS" width="70%" editable="false"/>
	           	<input type="checkbox" id="isTest12" value="1" onclick="isTestCheck(12);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
			</tr>
			<tr>
	           	<td class="td_font">�������ʷѵĻ��⣺</td>
	           	<td colspan="3"><ai:dbformfield formid="FormProdTest" fieldname="CHARGE_REPULSION" width="70%" editable="false"/>
	           	<input type="checkbox" id="isTest13" value="1" onclick="isTestCheck(13);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
			</tr>
		</table>
		</ai:contractframe>
	
		<ai:contractframe id="prodframe_5" contenttype="table" title="��Ʒ������˵��" width="100%" allowcontract="true" frameclosed="fale">
		<ai:contractitem/>
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">����������������</td>
	           	<td colspan="3"><ai:dbformfield formid="FormProdTest" fieldname="CHANNEL_DESCRIPTION" width="70%" height="50" editable="false"/>
	           	<input type="checkbox" id="isTest14" value="1" onclick="isTestCheck(14);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
			</tr>
			<tr>
	           	<td class="td_font">������Ʒ��������</td>
	           	<td colspan="3"><ai:dbformfield formid="FormProdTest" fieldname="PRODUCT_DESCRIPTION" width="70%" height="50" editable="false"/>
	           	<input type="checkbox" id="isTest15" value="1" onclick="isTestCheck(15);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
			</tr>
		</table>
		</ai:contractframe>

		<ai:contractframe id="prodframe_6" contenttype="table" title="������֧��˵��" width="100%" allowcontract="true" frameclosed="fale">
		<ai:contractitem/>
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">�ײͷѵ�����ռ�ȷֳɣ�</td>
	           	<td colspan="3"><ai:dbformfield formid="FormProdTest" fieldname="INCOME_SHARE" width="70%" height="50" editable="false"/>
	           	<input type="checkbox" id="isTest16" value="1" onclick="isTestCheck(16);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
			</tr>
			<tr>
	           	<td class="td_font">���񱨱��ϵ���֧��</td>
	           	<td colspan="3"><ai:dbformfield formid="FormProdTest" fieldname="REPORT_DETAILS" width="70%" height="50" editable="false"/>
	           	<input type="checkbox" id="isTest17" value="1" onclick="isTestCheck(17);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
			</tr>
			<tr>
	           	<td class="td_font">�����˵����</td>
	           	<td colspan="3"><ai:dbformfield formid="FormProdTest" fieldname="SETTLEMENT_INSTRUCTIONS" width="70%" height="50" editable="false"/>
	           	<input type="checkbox" id="isTest18" value="1" onclick="isTestCheck(18);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
			</tr>
		</table>
		</ai:contractframe>
		
		<ai:contractframe id="prodframe_7" contenttype="table" title="�����ʷ�Ҫ��" width="100%" allowcontract="true" frameclosed="fale">
		<ai:contractitem/>
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
				<td class="td_font">�����ʷ�Ҫ��</td>
	        	<td colspan="3"><ai:dbformfield formid="FormProdTest" fieldname="OTHER_CHARGE_REQUIREMENT" width="70%" height="50" editable="false"/>
	           	<input type="checkbox" id="isTest0" value="1" onclick="isTestCheck(0);" title="�Ƿ���ԣ����̣�"/><span class="font_red">�Ƿ���ԣ����̣�</span></td>
			</tr>
			<tr>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="APPLY_ID" width="" visible="false"/></td>
				<td><ai:dbformfield formid="FormProdTest" fieldname="CHARGE_ID" width="" visible="false"/></td>
			</tr>
			<tr>
				<td><ai:dbformfield formid="FormProdTest" fieldname="STATE" width="" visible="false"/></td>
	        	<td><ai:dbformfield formid="FormProdTest" fieldname="TEST_PRINCIPAL" width="" visible="false"/></td>
			</tr>
			<tr>
				<td><ai:dbformfield formid="FormProdTest" fieldname="TEST_RESULT" width="" visible="false"/></td>
			</tr>
		</table>
		</ai:contractframe>
					
	</ai:dbform>

	<table align="center" height="10">
		<ai:button id="bt_S" text="������Ա���" onclick="doWork('doTestDone(true)')"/>
	</table>

</ai:contractframe>


</body>
</html>


<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>


<script type="text/javascript">
var taskTag = "<%=request.getParameter("taskTag")%>";
var templateCode = "<%=request.getParameter("templateCode")%>";

var _orgId = g_GetUserInfo().ORG_ID;
var cityCode = g_GetUserInfo().ORG_ID.substr(0,2);
var staffId = g_GetUserInfo().STAFF_ID;
	
var listProdTest = g_TableRowSetManager.get("tblProdTest");
var frmProdExtTest = g_FormRowSetManager.get("FormProdTest");
var isTest = true;
var initResult = '000000000000000000000000000000';
var testArray = new Array("isTest0", "isTest1", "isTest2", "isTest3", "isTest4", "isTest5", "isTest6", "isTest7", "isTest8", "isTest9", "isTest10", "isTest11", "isTest12", "isTest13", "isTest14", "isTest15", "isTest16", "isTest17", "isTest18"); 

</script>

<script type="text/javascript">
function initTestResult() {
	//showTestMain();
	var curRow = chargeDetailListTable.getRow();
	var chargeId = chargeDetailListTable.getValue(curRow,"MID");
	listProdTest.refresh("&chargeId=" + chargeId);
	frmProdExtTest.refresh("&chargeId=" + chargeId);
    //setWebStatus(2);  
	if ('template.NewPChargeFlow' == templateCode || 'template.NewTChargeFlow' == templateCode) {
		setCheckboxSts();
		//if (taskTag == 'C27' || taskTag == 'PC008' || taskTag == 'PC010' || taskTag == 'PC011') {
		if (taskTag == 'PC041' || taskTag == 'PC015' || taskTag == 'PC040' || taskTag == 'C040'|| taskTag == 'C031' || taskTag == 'C041') {
			showTestMain();   //չ�����Ա���
			setWebStatus(2);  //�༭���Ա���
		}else if(taskTag == 'C28' || taskTag == 'C021' || taskTag == 'PC009' || taskTag == 'PC014' || taskTag == 'PC012' || taskTag == 'C043' || taskTag == 'PC043'){
			showTestMain();   //չ�����Ա���
			setWebStatus(1);  //�鿴���Ա���
		} else{
			setWebStatus(1);
		
		}
 	}
 	
	
}

function doSaveTestProdList(){
	var xmlbody = listProdTest.toXmlString(true);
	if(xmlbody != ""){
		var chargeId = frmProdExtTest.getValue("CHARGE_ID");
		var dealUrlParam = "&cityCode="+cityCode + "&chargeId="+chargeId + "&isTest="+isTest;	
		var list = new Array();
		list.push(listProdTest);
		var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeProdAttrAction?action=saveProdAttr"+dealUrlParam, list);

		if(ud.getValueByName("retVal") == "Y"){
			alert(ud.getValueByName("retMsg"));
			listProdTest.refresh("&chargeId=" +chargeId);
			return "up_list_ok";
		}else{
			alert(ud.getValueByName("retMsg"));
			return;
		}
	}
}

function doTestDone(){
	frmProdExtTest.setValue("TEST_PRINCIPAL",staffId);
	frmProdExtTest.setValue("STATE","2"); //���Խ������״̬
	var chargeId = frmProdExtTest.getValue("CHARGE_ID");
	initResult = frmProdExtTest.getValue("TEST_RESULT");
	if(initResult == "" || initResult == "null"){
		initResult = '000000000000000000000000000000';
	}
	
	var isUpLIST = doSaveTestProdList();
	var testResult = getAllTestResult();
	if(initResult == testResult && isUpLIST != 'up_list_ok'){
		alert("��ʾ�����Խ��û�б仯����ȷ�ϣ�");
		return;
	}
	
	//var testResult = getAllTestResult();
	//if(initResult == testResult && doSaveTestProdList() != "up_list_ok"){
	//	alert("��ʾ�����Խ��û�б仯����ȷ�ϣ�");
	//	return;
	//}
	
	if(initResult != testResult){
		//if(doSaveTestProdList() == "up_list_ok")
		//{
		//isDone = true;
		//}
		frmProdExtTest.setValue("TEST_RESULT",testResult);
		var dealUrlParam = "&cityCode="+cityCode + "&chargeId="+chargeId + "&isTest="+isTest;
		
		var list = new Array();
		list.push(frmProdExtTest);
		var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeProdAttrAction?action=saveProdAttrExt"+dealUrlParam, list);
		var id = ud.getValueByName("retId");
		if(ud.getValueByName("retVal") == "Y"){
			frmProdExtTest.refresh("&chargeId=" +chargeId);
			setCheckboxSts();
			if(isUpLIST != 'up_list_ok'){
				alert(ud.getValueByName("retMsg"));
			}
		}else{
			if(isUpLIST != 'up_list_ok'){
				alert(ud.getValueByName("retMsg"));
			}
			return;
		}
	}
}


</script>

<script type="text/javascript">
function  getAllTestResult() {
	var isAllTestValues = "000000000000000000000000000000"; 
	var changeStr = "1"; 
    var pos = 0;
   	for(pos = 0;pos < testArray.length;pos++){
    	if (document.getElementById(testArray[pos]).checked) {
        	isAllTestValues = isAllTestValues.substring(0,pos)+changeStr+isAllTestValues.substring(pos+1,isAllTestValues.length); 
        }
    }
    return isAllTestValues;
}

function  setCheckboxSts() {
	var testResult = frmProdExtTest.getValue("TEST_RESULT");
    var pos = 0;
   	for(pos = 0;pos < testResult.length;pos++){
   		var sPos = testResult.substr(pos,1);
   		if(sPos == "1"){
        	document.getElementById("isTest"+pos).checked = true;
        }
    }
}

//���ò��������״̬
function setWebStatus(type){
	var pos = 0;
	
	//type=1 �鿴��type=2 �༭
	if(type == 1){
		listProdTest.setEditSts(false);
		g_AIButtonManager.get("bt_S").setDisabled(true);
   		for(pos = 0;pos < testArray.length;pos++){
   			document.getElementById("isTest"+pos).disabled = true;
   		}
    }
    if(type == 2){
		listProdTest.setEditSts(true);
		g_AIButtonManager.get("bt_S").setDisabled(false);
   		for(pos = 0;pos < testArray.length;pos++){
   			document.getElementById("isTest"+pos).disabled = false;
   		}
    }

}

function showTestMain(){
	if(AIContractFrame_closeMe()){
	 }else{
	  AIContractFrame_OpenClose("prodframeTest");
	 }
}
</script>



<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">

function doWork(fun){ 
    beginAIWaitBanner(fun,"���ڴ������Ժ�...");
}
</script>

<script type="text/javascript">
function addLoad(func) {  
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
//addLoad(initCheck);
//addLoad(include_reflashAttachTable);

</script>



