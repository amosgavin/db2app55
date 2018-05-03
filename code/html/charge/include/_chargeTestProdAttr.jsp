<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>资费测试报告界面</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
</head>
<body onload="initProdTest()">
<ai:contractframe id="prodframeTest" contenttype="table" title="资费测试报告" width="100%" allowcontract="true" frameclosed="false">
 	<ai:contractitem/>
 	<ai:contractframe id="prodframe_1" contenttype="table" title="资费项目" width="100%" allowcontract="true" frameclosed="false">
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
        <ai:col title="编号" fieldname="APPLY_ID" width="" visible="false" />
		<ai:col title="资费ID" fieldname="CHARGE_ID" width="" visible="false" />
		<ai:col title="资费项目属性主ID" fieldname="APPLY_MAIN_ID" width="" visible="false" />
        <ai:col title="项目" fieldname="PROD_TYPE" width="10%" editable="false"/>
		<ai:col title="资费范围" fieldname="AREA_TYPE" width="10%" editable="false"/>
		<ai:col title="单价(元分钟)" fieldname="UNIT_PRICE" width="15%" editable="false"/>
        <ai:col title="赠送量(分钟数)" fieldname="GIVES_AMOUNT" width="15%" editable="false"/>
        <ai:col title="赠送量是否按天折算" fieldname="GIVES_AMOUNT_TYPE" width="18%" editable="false"/>
        <ai:col title="包内测试" fieldname="TEST_ITEM_A" width="10%"/>
        <ai:col title="包外测试" fieldname="TEST_ITEM_B" width="10%" />
        <ai:col title="跨分钟测试(只针对语音)" fieldname="TEST_ITEM_C" width="20%" />
	</ai:table>
</ai:contractframe>

	<ai:dbform formid="FormProdTest" 
  			setname="com.asiainfo.charge.web.SETChargeApplyProdAttrExt"
            conditionname="condition" parametersname="parameters"
            initial="false" onvalchange=""
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.charge.service.interfaces.IChargeProdAttrSV"
            implservice_querymethod="getProdAttrExtById(String chargeId)">

		<ai:contractframe id="prodframe_2" contenttype="table" title="固定费" width="100%" allowcontract="true" frameclosed="fale">
		<ai:contractitem/>
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">一次性收取：</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="DISPOSABLE_INCOME" width="150" editable="false"/></td>
	           	<td><input type="checkbox" id="isTest1" value="1" onclick="isTestCheck(1);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
	        </tr>
	        <tr>
	           	<td class="td_font">非一次性收取：</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="NON_DISPOSABLE_INCOME" width="150" editable="false"/></td>
	           	<td><input type="checkbox" id="isTest2" value="1" onclick="isTestCheck(2);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
			</tr>
			<tr>
				<td class="td_font">是否月底取整：</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="ROUNDING" width="150" editable="false"/></td>
			    <td><input type="checkbox" id="isTest3" value="1" onclick="isTestCheck(3);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
		    </tr>
		    <tr>
				<td class="td_font">新用户是否收全月月租：</td>
	        	<td><ai:dbformfield formid="FormProdTest" fieldname="IS_MONTHLY_RENT" width="150" editable="false"/></td>
			    <td><input type="checkbox" id="isTest4" value="1" onclick="isTestCheck(4);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
		    </tr>
		    <tr>
				<td class="td_font">月套餐使用费用(元)：</td>
	        	<td><ai:dbformfield formid="FormProdTest" fieldname="MONTHLY_FEE" width="150" editable="false"/></td>
			    <td><input type="checkbox" id="isTest5" value="1" onclick="isTestCheck(5);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
			</tr>
		</table>
		</ai:contractframe>
		
		<ai:contractframe id="prodframe_3" contenttype="table" title="账单优惠" width="100%" allowcontract="true" frameclosed="fale">
		<ai:contractitem/>
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">是否有保底：</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="IS_MINIMUM_CHARGE" width="150" editable="false"/></td>
	           	<td><input type="checkbox" id="isTest6" value="1" onclick="isTestCheck(6);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
	        </tr>    	
	        <tr>
	           	<td class="td_font">保底范围：</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="MINIMUM_CHARGE_RANGE" width="150" editable="false"/></td>
	           	<td><input type="checkbox" id="isTest7" value="1" onclick="isTestCheck(7);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
 			</tr>
 			<tr>
	           	<td class="td_font">是否参与零次用户处理：</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="IS_USER_PROCESS" width="150" editable="false"/></td>
	           	<td><input type="checkbox" id="isTest8" value="1" onclick="isTestCheck(8);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
			</tr>
			<tr>
	           	<td class="td_font">其他优惠：</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="OTHER_PREFERENTIAL" width="150" editable="false"/></td>
	           	<td><input type="checkbox" id="isTest9" value="1" onclick="isTestCheck(9);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
			</tr>
			<tr>			
	           	<td class="td_font">优惠范围：</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="PREFERENTIAL_RANGE" width="150" editable="false"/></td>
	           	<td><input type="checkbox" id="isTest10" value="1" onclick="isTestCheck(10);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
			</tr>
			<tr>
	           	<td class="td_font">优惠条件：</td>
	           	<td><ai:dbformfield formid="FormProdTest" fieldname="PREFERENTIAL_CONDITIONS" width="150" editable="false"/></td>
	           	<td><input type="checkbox" id="isTest11" value="1" onclick="isTestCheck(11);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
			</tr>
		</table>
		</ai:contractframe>
	
		<ai:contractframe id="prodframe_4" contenttype="table" title="其他特征" width="100%" allowcontract="true" frameclosed="fale">
		<ai:contractitem/>
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">与其他资费叠加的处理：</td>
	           	<td colspan="3"><ai:dbformfield formid="FormProdTest" fieldname="CHARGE_PROCESS" width="70%" editable="false"/>
	           	<input type="checkbox" id="isTest12" value="1" onclick="isTestCheck(12);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
			</tr>
			<tr>
	           	<td class="td_font">与其他资费的互斥：</td>
	           	<td colspan="3"><ai:dbformfield formid="FormProdTest" fieldname="CHARGE_REPULSION" width="70%" editable="false"/>
	           	<input type="checkbox" id="isTest13" value="1" onclick="isTestCheck(13);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
			</tr>
		</table>
		</ai:contractframe>
	
		<ai:contractframe id="prodframe_5" contenttype="table" title="产品发布的说明" width="100%" allowcontract="true" frameclosed="fale">
		<ai:contractitem/>
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">发布渠道的描述：</td>
	           	<td colspan="3"><ai:dbformfield formid="FormProdTest" fieldname="CHANNEL_DESCRIPTION" width="70%" height="50" editable="false"/>
	           	<input type="checkbox" id="isTest14" value="1" onclick="isTestCheck(14);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
			</tr>
			<tr>
	           	<td class="td_font">发布产品的描述：</td>
	           	<td colspan="3"><ai:dbformfield formid="FormProdTest" fieldname="PRODUCT_DESCRIPTION" width="70%" height="50" editable="false"/>
	           	<input type="checkbox" id="isTest15" value="1" onclick="isTestCheck(15);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
			</tr>
		</table>
		</ai:contractframe>

		<ai:contractframe id="prodframe_6" contenttype="table" title="收入列支的说明" width="100%" allowcontract="true" frameclosed="fale">
		<ai:contractitem/>
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">套餐费的收入占比分成：</td>
	           	<td colspan="3"><ai:dbformfield formid="FormProdTest" fieldname="INCOME_SHARE" width="70%" height="50" editable="false"/>
	           	<input type="checkbox" id="isTest16" value="1" onclick="isTestCheck(16);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
			</tr>
			<tr>
	           	<td class="td_font">财务报表上的列支：</td>
	           	<td colspan="3"><ai:dbformfield formid="FormProdTest" fieldname="REPORT_DETAILS" width="70%" height="50" editable="false"/>
	           	<input type="checkbox" id="isTest17" value="1" onclick="isTestCheck(17);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
			</tr>
			<tr>
	           	<td class="td_font">结算的说明：</td>
	           	<td colspan="3"><ai:dbformfield formid="FormProdTest" fieldname="SETTLEMENT_INSTRUCTIONS" width="70%" height="50" editable="false"/>
	           	<input type="checkbox" id="isTest18" value="1" onclick="isTestCheck(18);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
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
		
		<ai:contractframe id="prodframe_7" contenttype="table" title="其他资费要求" width="100%" allowcontract="true" frameclosed="fale">
		<ai:contractitem/>
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
				<td class="td_font">其他资费要求：</td>
	        	<td colspan="3"><ai:dbformfield formid="FormProdTest" fieldname="OTHER_CHARGE_REQUIREMENT" width="70%" height="50" editable="false"/>
	           	<input type="checkbox" id="isTest0" value="1" onclick="isTestCheck(0);" title="是否测试（请打√）"/><span class="font_red">是否测试（请打√）</span></td>
			</tr>
			<tr>
				<td><ai:dbformfield formid="FormProdTest" fieldname="CHARGE_ID" width="10" visible="false"/></td>
				<td><ai:dbformfield formid="FormProdTest" fieldname="APPLY_ID" width="10" visible="false"/></td>
				<td><ai:dbformfield formid="FormProdTest" fieldname="APPLY_NAME" width="10" visible="false"/></td>
			</tr>
		</table>
		</ai:contractframe>
					
	</ai:dbform>

	<table align="center" height="10">
		<ai:button id="bt_S" text="保存测试报告" onclick="doWork('doTestDone(true)')"/>
	</table>
</ai:contractframe>
	
<div id="div_attach" style="display:block">
<%@include file="/charge/include/_chargeProdAttrAttach.jsp"%>
</div>

<div id="div_createWF" style="display:block">
<%@include file="/charge/include/_chargeProdAttrCreateWF.jsp"%>
</div>


</body>
</html>

<ai:loginuser />
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/DBListBox.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>


<script type="text/javascript">


var chargeId="<%=request.getParameter("chargeId")%>";
var isSubmit="<%=request.getParameter("isSubmit")%>";
var listProdTest = g_TableRowSetManager.get("tblProdTest");
var frmProdExtTest = g_FormRowSetManager.get("FormProdTest");

//listProdTest.setCurCellBgColor('#FFFFFF');			
//frmProdExtTest.setCurCellFontColor('#0000FF');

var isTest = true;
var initTestResult;

function initProdTest()
{	
	if(chargeId != "" && chargeId != null && chargeId != "undefined"){
		listProdTest.refresh("&chargeId=" +chargeId);
		frmProdExtTest.refresh("&chargeId=" +chargeId);
	} 
	
	initTestResult = frmProdExtTest.getValue("TEST_RESULT");	
	setCheckboxSts();

	 
    
}

function doSaveTestProdList(){
	var xmlbody = listProdTest.toXmlString(true);
	if(xmlbody != ""){
		var dealUrlParam = "&chargeId="+chargeId+"&isTest="+isTest;	
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
	var cityCode = g_GetUserInfo().ORG_ID.substr(0,2);
	var staffId = g_GetUserInfo().STAFF_ID;
	
	frmProdExtTest.setValue("TEST_PRINCIPAL",staffId);
	frmProdExtTest.setValue("STATE","2"); //测试结果保存状态
	var chargeId = frmProdExtTest.getValue("CHARGE_ID");
	var testResult = getAllTestResult();
	
	if(initTestResult == testResult && doSaveTestProdList() != "up_list_ok"){
		alert("提示：测试结果没有被更新，请确认！");
		return;
	}
	
	if(initTestResult != testResult){
		frmProdExtTest.setValue("TEST_RESULT",testResult);
		var dealUrlParam = "&cityCode="+cityCode+"&isTest="+isTest;
		
		var list = new Array();
		list.push(frmProdExtTest);
		var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeProdAttrAction?action=saveProdAttrExt"+dealUrlParam, list);
		var id = ud.getValueByName("retId");
		if(ud.getValueByName("retVal") == "Y"){
			alert(ud.getValueByName("retMsg"));
			frmProdExtTest.refresh("&chargeId=" +chargeId);
			setCheckboxSts();
		}else{
			alert(ud.getValueByName("retMsg"));
			//frmProdExtTest.setStsToNew();
			return;
		}
	}
}



</script>

<script type="text/javascript">

function  getAllTestResult() {
	var isAllTestValues = "000000000000000000000000000000"; 
	var changeStr = "1"; 
	var testArray = new Array("isTest0", "isTest1", "isTest2", "isTest3", "isTest4", "isTest5", "isTest6", "isTest7", "isTest8", "isTest9", "isTest10", "isTest11", "isTest12", "isTest13", "isTest14", "isTest15", "isTest16", "isTest17", "isTest18"); 
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

</script>



<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
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
//addLoad(initCheckPage);
//addLoad(include_reflashAttachTable);

</script>



