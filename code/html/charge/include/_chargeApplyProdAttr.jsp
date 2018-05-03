<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<title>资费结构信息</title>
		<script language="javascript"
			src="<%=request.getContextPath()%>/jsv2/Calendar.jsp"
			type="text/javascript"></script>
		<script language="javascript"
			src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js"
			type="text/javascript"></script>
	</head>
	<body onload="initChargeProd()">
		<ai:contractframe id="prodframe" contenttype="table" title="资费结构信息（请填写资费项目，不能为空）"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem>
				<!-- <ai:button id="bt_saveAll" text="保存资费结构信息"
					onclick="doWork('doSaveProdAll()')" /> -->
			</ai:contractitem>
			<ai:contractframe id="prodframe_1" contenttype="table" title="资费项目"
				width="100%" allowcontract="true" frameclosed="false">
				<ai:contractitem>
					<ai:button id="bt_add" text="新增" onclick="doAddProd()" />
					<ai:button id="bt_del" text="删除" onclick="doDelProd()" />
					<!--
					<ai:button id="bt_addExt" text="新增扩展属性" onclick="doAddExt()" />
					<ai:button id="bt_showExt" text="查看扩展属性" onclick="doShowExt()" />
					<ai:button id="bt_save" text="保存" onclick="doWork('doSaveProd()')"/>-->
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
					<ai:col title="编号" fieldname="APPLY_ID" width="" visible="false" />
					<ai:col title="资费ID" fieldname="CHARGE_ID" width="" visible="false" />
					<ai:col title="资费项目属性主ID" fieldname="APPLY_MAIN_ID" width=""
						visible="false" />
					<ai:col title="项目" fieldname="PROD_TYPE" width="15%" />
					<ai:col title="资费范围" fieldname="AREA_TYPE" width="15%" />
					<ai:col title="单价(元/分钟或元/条或元/兆)" fieldname="UNIT_PRICE" width="15%" />
					<ai:col title="赠送量(分钟或条或兆)" fieldname="GIVES_AMOUNT" width="15%" />
					<ai:col title="赠送量是否按天折算" fieldname="GIVES_AMOUNT_TYPE" width="18%" />
					<ai:col title="备注" fieldname="REMARKS" width="20%" />
					<ai:col title="状态" fieldname="STATE" width="" visible="false" />
					<ai:col title="受理人" fieldname="PRINCIPAL" width="" visible="false" />
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
				<ai:contractframe id="prodframe_2" contenttype="table" title="资费信息(所有项必填，没有填无)"
					width="100%" allowcontract="true" frameclosed="false">
					<ai:contractitem />
					<table width="98%" align="center" border="0" cellpadding="1"
						cellspacing="2">
						<tr>
							<td>
								<b>固定费：</b>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								一次性收取：
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="DISPOSABLE_INCOME" width="150" />
								<span class="font_red">*</span>
							</td>
							<td class="td_font">
								非一次性收取：
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="NON_DISPOSABLE_INCOME" width="150" />
								<span class="font_red">*</span>
							</td>
							<td class="td_font">
								是否月底取整：
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext" fieldname="ROUNDING"
									width="150" />
								<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								新用户是否收全月月租：
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="IS_MONTHLY_RENT" width="150" />
								<span class="font_red">*</span>
							</td>
							<td class="td_font">
								月套餐使用费用(元)：
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext" fieldname="MONTHLY_FEE"
									width="150" />
								<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td>
								<b>账单优惠：</b>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								是否有保底：
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="IS_MINIMUM_CHARGE" width="150" />
								<span class="font_red">*</span>
							</td>
							<td class="td_font">
								保底范围：
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="MINIMUM_CHARGE_RANGE" width="150" />
									<span class="font_red">*</span>
							</td>
							<td class="td_font">
								是否参与零次用户处理：
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="IS_USER_PROCESS" width="150" />
								<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								其他优惠：
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="OTHER_PREFERENTIAL" width="150" />
									<span class="font_red">*</span>
							</td>
							<td class="td_font">
								优惠范围：
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="PREFERENTIAL_RANGE" width="150" />
									<span class="font_red">*</span>
							</td>
							<td class="td_font">
								优惠条件：
							</td>
							<td>
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="PREFERENTIAL_CONDITIONS" width="150" />
									<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td>
								<b>其他特征：</b>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								与其他资费叠加的处理：
							</td>
							<td colspan="5">
								<ai:dbformfield formid="FormProd_Ext" fieldname="CHARGE_PROCESS"
									width="80%" />
									<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								与其他资费的互斥：
							</td>
							<td colspan="5">
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="CHARGE_REPULSION" width="80%" />
									<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td>
								<b>产品发布的说明：</b>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								发布渠道的描述：
							</td>
							<td colspan="5">
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="CHANNEL_DESCRIPTION" width="80%" height="50" />
									<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								发布产品的描述：
							</td>
							<td colspan="5">
								<ai:dbformfield formid="FormProd_Ext"
									fieldname="PRODUCT_DESCRIPTION" width="80%" height="50" />
									<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td>
								<b>收入列支的说明：</b>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								套餐费的收入占比分成：
							</td>
							<td colspan="5">
								<ai:dbformfield formid="FormProd_Ext" fieldname="INCOME_SHARE"
									width="80%" height="50" />
									<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								财务报表上的列支：
							</td>
							<td colspan="5">
								<ai:dbformfield formid="FormProd_Ext" fieldname="REPORT_DETAILS"
									width="80%" height="50" />
									<span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								结算的说明：
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
								<b>其他资费要求：</b>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								其他资费要求：
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
   	 
   	 	<ai:button id="bt_1" text="新建" onclick="newProdExt()"/>&nbsp;&nbsp;
    	<ai:button id="bt_2" text="修改" onclick="modifyProdExt()"/>&nbsp;&nbsp;
		<ai:button id="bt_3" text="保存" onclick="doWork('doSaveProdExt(true)')"/>&nbsp;&nbsp;
		<ai:button id="bt_4" text="T_资费测试报告" onclick="doTestProdAttr()"/>&nbsp;&nbsp;
		<ai:button id="bt_5" text="T_资费测试报告审核" onclick="doCheckTestProdAttr()"/>&nbsp;&nbsp;
	</table>-->
			<ai:button id="bt_saveAll2" text="保存资费结构信息"
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
		alert("请先保存资费档次信息！");
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
	
	//如果form数据已经存在，给tbl设置APPLY_MAIN_ID
	if(formApplyId != null && formApplyId != ""){
		tblProd.setValue(curRow,"APPLY_MAIN_ID",formApplyId);	
	}	
	//tblProd.setFocus(curRow,"UNIT_PRICE");
	
}

function doDelProd(){
	if(!confirm("您确定要删除选中的记录吗？")){
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
				alert("所选的记录不是已保存状态，不允许删除，请重新选择！");
				return;
			}else{
				if(prodId != null && prodId!=""){
					bFound = true;
				}
				tblProd.deleteRow(selectedRows[RowCount]);
				
			}
		}else {
			alert("所选的记录不是自己的，不允许删除！");
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
	
	//如果CHARGE_APPLY_PROD_ATTR_EXT_T 表数据存在，需要触发更新新资费结构的档次套餐名称
	var extApplyId = ProdExtF.getValue("APPLY_ID");
	if(extApplyId != null && extApplyId != "" && bFound ){
		updateProdExt("del");
	}
}


function doSaveProd(){
	var xmlbody = tblProd.toXmlString(true);
	if(xmlbody == ""){
		alert("提示：没有需要保存的数据！");
		return;
	}
	
	var tempArr = new Array(); 
	for(var i = 0; i < tblProd.getTotalRowCount();i++){
		var prodTypeName = tblProd.getDisplayText(i, "PROD_TYPE");
		tempArr.push(prodTypeName);
		if(prodTypeName == "" || prodTypeName == null){
			alert("请选择第"+(i+1)+"行 项目 列的内容！");
			return;
		}
		
		var areaTypeName = tblProd.getDisplayText(i, "AREA_TYPE");
		if(areaTypeName == "" || areaTypeName == null){
			alert("请选择第"+(i+1)+"行 资费范围 列的内容！");
			return;
		}
	}
	var nary = tempArr.sort();
	for(var i = 0;i < tempArr.length;i++){
	  if (nary[i]==nary[i+1]){
	  	alert("不允许有相同的项目，请确认！");
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
	
	//如果CHARGE_APPLY_PROD_ATTR_EXT_T 表数据存在，需要触发更新新资费结构的档次套餐名称
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
		var unit = '元/分钟';
		var presentUnit = '分钟';

		
		itemFeeName += prodTypeName + '+' + areaTypeName;
		if(unitPrice != "null" && unitPrice != ""){
			if (prodTypeName == "短信" || prodTypeName == "彩信") {
				unit = '元/条';
				presentUnit = '条';
			} else if (prodTypeName == "流量") {
				unit = '元/兆';
				presentUnit = '兆';
			} 
			itemFeeName += '，单价' + unitPrice + unit;
		}
		if(givesAmount != "null" && givesAmount != ""){
			itemFeeName += '，赠送量：' + givesAmount + presentUnit;
		}
		if(givesAmount != "null" && givesAmount != ""){
			itemFeeName += '，赠送量是否按天折算：' + givesAmountType;
		}		
		itemFeeName += '；';
		
	}
	return itemFeeName;
}


//add by jiangxl
var xmlArray = new Array(); 

function doAddExt(){
	var selectedRows = tblProd.getSelectedRows();
	var len = selectedRows.length;
	if(len <=0){
		alert("请选择一条记录");
		return;
	}
	else if (len >1){
		alert("您只能选择一条记录");
		return;
	}
	var type = tblProd.getValue(selectedRows[0],"PROD_TYPE");
	var apply_id = tblProd.getValue(selectedRows[0],"APPLY_ID");
	var chargeId = tblProd.getValue(selectedRows[0],"CHARGE_ID");
	
	if(null == type || ""== type){
		alert("请选择项目！");
		return;
	}
	var param = "&type="+type+"&opType=1"+"&applyId="+apply_id+"&chargeId="+chargeId;
	
	var url = "<%=request.getContextPath()%>/charge/chargeinfo/chargeInfoExt.jsp?"+param; //新增
	
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
		alert("请选择一条记录");
		return;
	}
	else if (len >1){
		alert("您只能选择一条记录");
		return;
	}
	var type = tblProd.getValue(selectedRows[0],"PROD_TYPE");
	var apply_id = tblProd.getValue(selectedRows[0],"APPLY_ID");
	var chargeId = tblProd.getValue(selectedRows[0],"CHARGE_ID");
	
	if(null == type || ""== type){
		alert("请选择项目！");
		return;
	}
	var param = "&type="+type+"&opType=2"+"&applyId="+apply_id+"&chargeId="+chargeId;
	
	var url = "<%=request.getContextPath()%>/charge/chargeinfo/chargeInfoExt.jsp?"+param; //新增
	
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
		alert("请先保存资费档次信息！");
		return;
	}

    if(window.confirm("新建会清空未保存的信息，确定要新建吗？"))
    {
        location.reload();
        //ProdExtF.clear();
    }
}

function doSaveProdExt(){
	var chargeId = _fromChargeMainDeFormRowSet.getValue("MID");
	if(chargeId == "" || chargeId == null || chargeId == "undefined"){
		alert("请先保存资费档次信息！");
		return;
	}

	var tblApplyId = tblProd.getValue(0, "APPLY_ID");
	if(tblApplyId == "" || tblApplyId == null || tblApplyId == "undefined"){
		alert("请先保存 资费项目！");
		return;
	}

	if("" == ProdExtF.getValue("DISPOSABLE_INCOME")){return  alert("一次性收取，不允许为空！");}
	if("" == ProdExtF.getValue("NON_DISPOSABLE_INCOME")){return  alert("非一次性收取，不允许为空！");}
	if("" == ProdExtF.getValue("ROUNDING")){return  alert("是否月底取整，不允许为空！");}
	if("" == ProdExtF.getValue("IS_MONTHLY_RENT")){return  alert("新用户是否收全月月租，不允许为空！");}
	if("" == ProdExtF.getValue("MONTHLY_FEE")){return  alert("月套餐使用费用，不允许为空！");}
	if("" == ProdExtF.getValue("IS_MINIMUM_CHARGE")){return  alert("是否有保底，不允许为空！");}
	if("" == ProdExtF.getValue("IS_USER_PROCESS")){return  alert("是否参与零次用户处理，不允许为空！");}
	
	var cityCode = g_GetUserInfo().ORG_ID.substr(0,2);
	ProdExtF.setValue("CHARGE_ID",chargeId);
	ProdExtF.setValue("STATE","1"); //数据保存状态
    //var feeName = _fromChargeMainDeFormRowSet.getValue("FEE_NAME");
	
	var itemFeeName = getItemFeeName();  //获取资费项中详细资费
	//feeName = feeName + '，包含：' + itemFeeName;
	
	feeName = itemFeeName;
	ProdExtF.setValue("APPLY_NAME",feeName);


	
	var xmlProdExtForm = ProdExtF.toXmlString(true);
	if("" == xmlProdExtForm){
		alert("提示：没有需要保存的数据！");
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
	//判断资费档次是否保存
	var chargeId = _fromChargeMainDeFormRowSet.getValue("MID");
	if(chargeId == "" || chargeId == null || chargeId == "undefined"){
		return alert("请先保存资费档次信息！");
	}

	//判断资费结构信息中 资费项目 是否填写
	var rowCount = tblProd.getTotalRowCount();
	if(rowCount == 0){
		return  alert("资费项目，不允许为空！");
	}else{
		var tempArr = new Array(); 
		for(var i = 0; i < tblProd.getTotalRowCount();i++){
			var prodTypeName = tblProd.getDisplayText(i, "PROD_TYPE");
			tempArr.push(prodTypeName);
			if(prodTypeName == "" || prodTypeName == null){
				return alert("请选择第"+(i+1)+"行 项目 列的内容！");
			}
		
			var areaTypeName = tblProd.getDisplayText(i, "AREA_TYPE");
			if(areaTypeName == "" || areaTypeName == null){
				return alert("请选择第"+(i+1)+"行 资费范围 列的内容！");
			}
		}
		var nary = tempArr.sort();
		for(var i = 0;i < tempArr.length;i++){
	  		if (nary[i]==nary[i+1]){
	  			return alert("不允许有相同的项目，请确认！");
	  		}
		}
	}
	
	//判断资费结构信息中 资费信息 是否填写
	if("" == ProdExtF.getValue("DISPOSABLE_INCOME")){return  alert("一次性收取，不允许为空！");}
	if("" == ProdExtF.getValue("NON_DISPOSABLE_INCOME")){return  alert("非一次性收取，不允许为空！");}
	if("" == ProdExtF.getValue("ROUNDING")){return  alert("是否月底取整，不允许为空！");}
	if("" == ProdExtF.getValue("IS_MONTHLY_RENT")){return  alert("新用户是否收全月月租，不允许为空！");}
	if("" == ProdExtF.getValue("MONTHLY_FEE")){return  alert("月套餐使用费用，不允许为空！");}
	if("" == ProdExtF.getValue("IS_MINIMUM_CHARGE")){return  alert("是否有保底，不允许为空！");}
	if("" == ProdExtF.getValue("IS_USER_PROCESS")){return  alert("是否参与零次用户处理，不允许为空！");}
	if("" == ProdExtF.getValue("MINIMUM_CHARGE_RANGE")){return  alert("保底范围，不允许为空！");}
	if("" == ProdExtF.getValue("OTHER_PREFERENTIAL")){return  alert("其他优惠，不允许为空！");}
	if("" == ProdExtF.getValue("PREFERENTIAL_RANGE")){return  alert("优惠范围，不允许为空！");}
	if("" == ProdExtF.getValue("CHARGE_PROCESS")){return  alert("与其他资费叠加的处理，不允许为空！");}
	if("" == ProdExtF.getValue("CHARGE_REPULSION")){return  alert("与其他资费的互斥，不允许为空！");}
	if("" == ProdExtF.getValue("CHANNEL_DESCRIPTION")){return  alert("发布渠道的描述，不允许为空！");}
	if("" == ProdExtF.getValue("PRODUCT_DESCRIPTION")){return  alert("发布产品的描述，不允许为空！");}
	if("" == ProdExtF.getValue("INCOME_SHARE")){return  alert("套餐费的收入占比分成，不允许为空！");}
	if("" == ProdExtF.getValue("REPORT_DETAILS")){return  alert("财务报表上的列支，不允许为空！");}
	if("" == ProdExtF.getValue("SETTLEMENT_INSTRUCTIONS")){return  alert("结算的说明，不允许为空！");}
	if("" == ProdExtF.getValue("OTHER_CHARGE_REQUIREMENT")){return  alert("其他资费要求，不允许为空！");}
	
	var xmlbodyTbl = tblProd.toXmlString(true);
	var xmlbodyFrm = ProdExtF.toXmlString(true);
	
	if("" == xmlbodyTbl && "" == xmlbodyFrm){
		return alert("提示：没有需要保存的数据！");
	}
	//获取资费套餐
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
		//如果CHARGE_APPLY_PROD_ATTR_EXT_T 表数据存在，本次没修改情况下，需要触发更新新资费结构的档次套餐名称
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
    if(window.confirm("您确定要修改吗？"))
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

//设置操作区域的状态
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
    beginAIWaitBanner(fun,"正在处理，请稍后...");
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


