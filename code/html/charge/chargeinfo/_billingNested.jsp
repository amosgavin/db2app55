<%@ page contentType="text/html; charset=GBK"%>
<%--<%@ include file="/secframe/common/common.jsp"%>--%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
	<body onload="_billingNested.initPage">
	 <div id="finalshare_form_div" style="display: block">
		<ai:contractframe id="_billingNested_finaAllocShare" contenttype="table" title="选择财务分摊项" width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem>
				<!--<ai:button id="_billingNested_addFinaAllocShare" text="新增" onclick="_billingNested.addFinaAllocShare()" />
				<ai:button id="_billingNested_delFinaAllocShare" text="删除" onclick="doWork('_billingNested.delFinaAllocShare()')" />-->
				<ai:button id="_billingNested_saveFinaAllocShare" text="保存" onclick="doWork('_billingNested.saveFinaAllocShare()')" />
			</ai:contractitem>
			<ai:dbform formid="_billingNested_finaAllocShareForm" setname="com.asiainfo.charge.web.SETFinalShare" 
			conditionname="condition" parametersname="parameters" onvalchange="" 
			editable="true" initial="false" datamodel="com.ai.appframe2.web.datamodel.MethodModelForService" 
			implservice_name="com.asiainfo.charge.service.interfaces.IFinaAllocShareSV" 
			implservice_querymethod="queryFinaAllocShare(String chargeId)">
				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2" nowrap="nowrap" >
					<tr>
						<td>
							<ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="CHARGE_ID" width="100" editable="false" visible="false" />
						</td>
						<td>
							<ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="ID" width="100" editable="false" visible="false" />
						</td>
					</tr>
					<tr>
						<td class="td_font" >
							来电提醒：
						</td>
						<td nowrap="nowrap">
							<input type="checkbox" name="finalShare" id="LDTX" value="LDTX"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="LDTX" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							月租费收入：
						</td>
						<td  nowrap="nowrap">
							<input type="checkbox" name="finalShare" id="YZF" value="YZF" />
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="YZF" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							本地通话费：
						</td>
						<td  nowrap="nowrap">
							<input type="checkbox" name="finalShare" id="BDTHF" value="BDTHF"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="BDTHF" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							手机报：
						</td>
						<td  nowrap="nowrap">
							<input type="checkbox" name="finalShare" id="SJB" value="SJB"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="SJB" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							语音杂志：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="YY_ZZ" value="YY_ZZ"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="YY_ZZ" width="100" editable="" />% -->
							
						</td>
					</tr>
					<tr>
						<td class="td_font">
							主叫显示：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="ZJXS" value="ZJXS"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="ZJXS" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							流量费：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="LLF" value="LLF"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="LLF" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							IP电话收入-省内：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="IP_SR" value="IP_SR"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="IP_SR" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							无线音乐:彩铃功能费：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="WXYY_CLGNF" value="WXYY_CLGNF"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="WXYY_CLGNF" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							MM：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="MM" value="MM"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="MM" width="100" editable="" />% -->
							
						</td>
					</tr>
					<tr>
						<td class="td_font">
							网内点对点彩信：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="WNCX" value="WNCX"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="WNCX" width="100" editable="" />%  -->
							
						</td>
						<td class="td_font">
							移动秘书：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="YDMS" value="YDMS"/>
							<!--  <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="YDMS" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							网内点对点短信：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="WNDX" value="WNDX"/>
							<!--  <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="WNDX" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							移动数据业务收入-其他：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="YDSJYW_QT" value="YDSJYW_QT"/>
							<!--  <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="YDSJYW_QT" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							手机电视：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="SJ_DX" value="SJ_DX"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="SJ_DX" width="100" editable="" />% -->
							
						</td>
					</tr>
					<tr>
						<td class="td_font">
							无线音乐:俱乐部会费：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="WXYY_JLB" value="WXYY_JLB"/>
							<!--  <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="WXYY_JLB" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							139邮箱：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="YX_139" value="YX_139"/>
							<!--  <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="YX_139" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							WLAN通信费：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="WLAN_TXF" value="WLAN_TXF"/>
							<!--  <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="WLAN_TXF" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							12580：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="YEWBL" value="YEWBL"/>
							<!--  <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="YEWBL" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							手机导航：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="SJ_DH" value="SJ_DH"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="SJ_DH" width="100" editable="" />% -->
							
						</td>
					</tr>
					<tr>
						<td class="td_font">
							农信通：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="NXT" value="NXT"/>
							<!--  <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="NXT" width="100" editable="" />%  -->
							
						</td>
						<td class="td_font">
							号簿管家：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="HBGJ" value="HBGJ"/>
							<!--  <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="HBGJ" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							飞信：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="FEIX" value="FEIX"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="FEIX" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							短信回执：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="DXHZ" value="DXHZ"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="DXHZ" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							手机证券：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="SJ_ZQ" value="SJ_ZQ"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="SJ_ZQ" width="100" editable="" />% -->
							
						</td>
					</tr>
					<tr>
						<td class="td_font">
							手机阅读：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="SJYD" value="SJYD"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="SJYD" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							非漫游基本长途（省内）：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="FMYJBCT" value="FMYJBCT"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="FMYJBCT" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							彩信信息费：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="CX_XXF" value="CX_XXF"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="CX_XXF" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							车务通：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="CWT" value="CWT"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="CWT" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							手机支付业务：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="SJ_ZF" value="SJ_ZF"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="SJ_ZF" width="100" editable="" />% -->
							
						</td>
					</tr>
					<tr>
						<td class="td_font">
							移动气象站：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="YDQXZ" value="YDQXZ"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="YDQXZ" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							集团通讯管家：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="JTTXGJ" value="JTTXGJ"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="JTTXGJ" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							彩铃信息费：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="CLXXF" value="CLXXF"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="CLXXF" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							个人专线(互联网)：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="GRZX_HLW" value="GRZX_HLW"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="GRZX" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							个人专线(数据)：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="GRZX_SJ" value="GRZX_SJ"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="GRZX" width="100" editable="" />% -->
							
						</td>
					</tr>
					<tr>
						<td class="td_font">
							省内出访漫游长途（省内）：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="SNCFMY" value="SNCFMY"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="SNCFMY" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							手机视频：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="SJ_SP" value="SJ_SP"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="SJ_SP" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							手机动漫：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="SJ_DM" value="SJ_DM"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="SJ_DM" width="100" editable="" />% -->
							
						</td>
						<td class="td_font">
							手机游戏：
						</td>
						<td>
							<input type="checkbox" name="finalShare" id="SJ_YX" value="SJ_YX"/>
							<!-- <ai:dbformfield formid="_billingNested_finaAllocShareForm" fieldname="SJ_YX" width="100" editable="" />% -->
							
						</td>
					</tr>
				</table>
			</ai:dbform>
		</ai:contractframe>
	</div>
		
	<div id="finalshare_tab_div" style="display: none">
		<ai:contractframe id="finaAllocShareframe" contenttype="table" title="财务分摊规则" width="100%" allowcontract="false" frameclosed="false">
			<ai:contractitem>
				<ai:button id="_billingNested_saveFinalShare" text="保存" onclick="doWork('_billingNested.saveFinalShareTab()')" />
			</ai:contractitem>
			<ai:table tableid="_billingNested.finaAllocShareTab" setname="com.asiainfo.charge.web.SETFinalShare" 
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" 
			implservice_name="com.asiainfo.charge.service.interfaces.IFinaAllocShareSV" 
			implservice_querymethod="queryFinaAllocShare(String chargeId)" 
			ondbclick="" initial="false" 
			pagesize="7" editable="false" width="100%" height="160" needrefresh="true" multiselect="true">
				<ai:col fieldname="R_ID" visible="false" />
				<ai:col title="资费ID" fieldname="CHARGE_ID" width="5%" visible="false" editable="false" />
				<ai:col title="财务项" fieldname="FINAL" width="15%" visible="true" editable="false"/>
				<ai:col title="占比" fieldname="FINAL_RATE" width="15%" visible="true" />
				<ai:col title="税率(单位%，值为0 待定)" fieldname="FINAL_TAXRATE" width="15%" visible="true" />
				<ai:col title="账务清单" fieldname="AMOUNT_ITEM" width="50%" visible="true" />
			</ai:table>
		</ai:contractframe>
	</div>
		
		<ai:contractframe id="_billingNested_billingCheckInfo" contenttype="table" title="资费对比" width="100%" allowcontract="false" frameclosed="false">
			<ai:contractitem>
				<ai:button id="_billingNested_addBillingCheck" text="新增" onclick="_billingNested.addBillingCheck()" />
				<ai:button id="_billingNested_delBillingCheck" text="删除" onclick="doWork('_billingNested.delBillingCheck()')" />
				<ai:button id="_billingNested_saveBillingCheck" text="保存" onclick="doWork('_billingNested.saveBillingCheck()')" />
			</ai:contractitem>
			<ai:table tableid="_billingNested_billingCheckInfoTable" setname="com.asiainfo.charge.web.SETBillingCheck" 
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" 
			implservice_name="com.asiainfo.charge.service.interfaces.IBillingCheckSV" 
			implservice_querymethod="queryBillingCheckInfo(String chargeId, int $STARTROWINDEX, int $ENDROWINDEX)" 
			implservice_countmethod="countBillingCheckInfo(String chargeId)" ondbclick="" initial="false" 
			pagesize="7" editable="true" width="100%" height="160" needrefresh="true" multiselect="true">
				<ai:col fieldname="BILLINGCHECK_ID" visible="false" />
				<ai:col title="资费ID" fieldname="CHARGE_ID" width="5%" visible="false" editable="false" />
				<ai:col title="对比项目" fieldname="CHECK_ITEM" width="15%" visible="true" />
				<ai:col title="方案名称" fieldname="SCHEME_NAME" width="15%" visible="true" />
				<ai:col title="品牌" fieldname="BRAND" width="12%" visible="true" />
				<ai:col title="目标市场" fieldname="TARGET_MARKET" width="12%" visible="true" />
				<ai:col title="资费内容" fieldname="BILLING_CONTENT" width="16%" visible="true" />
				<ai:col title="资费卖点" fieldname="BILLING_SELLINGPOINT" width="10%" visible="true" />
				<ai:col title="传播口号" fieldname="SLOGAN" width="15%" visible="true" />
			</ai:table>
		</ai:contractframe>

	</body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript">
</script>
<script language="javaScript">
var _billingNested = {};

_billingNested.billingCheckInfoTable = g_TableRowSetManager
		.get("_billingNested_billingCheckInfoTable");
_billingNested.finaAllocShareForm = g_FormRowSetManager
		.get("_billingNested_finaAllocShareForm");
_billingNested.finaAllocShareTab = g_TableRowSetManager
		.get("_billingNested.finaAllocShareTab");

//初始化页面
_billingNested.initPage = function() {
	var chargeId = _fromChargeMainDeFormRowSet.getValue("MID");
	var param = "chargeId=" + chargeId;
	//var param1 = "&chargeId=" + chargeId;
	if ("" != chargeId) {
		_billingNested.billingCheckInfoTable.refresh(param);
		_billingNested.finaAllocShareTab.refresh(param);
		for (var k=0; k < _billingNested.finaAllocShareTab.getTotalRowCount(); ++ k) {
			var value = _billingNested.finaAllocShareTab.getValue(k,"FINAL");
			/*var value = _billingNested.finaAllocShareTab.getValue(k,"FINAL_RATE");
			for(var i = 0; i<_billingNested.finaAllocShareForm.fieldNameArray.length; i++){
				var fieldName = _billingNested.finaAllocShareForm.fieldNameArray[i];
				var fieldValue = _billingNested.finaAllocShareForm.getValue(fieldName);
				var fieldTitle = _billingNested.finaAllocShareForm.getTitle(fieldName);
				if (title == fieldTitle) {
					_billingNested.finaAllocShareForm.setValue(fieldName,value);
					break;
				}
			} */
			document.getElementById(value).checked=true;
		}
	}
}
//新增资费对比数据
_billingNested.addBillingCheck = function() {
	var chargeId = _fromChargeMainDeFormRowSet.getValue("MID");
	if (chargeId == "" || chargeId == null || chargeId == "undefined") {
		alert("请先保存资费档次信息！");
		return;
	}
	_billingNested.billingCheckInfoTable.newRow();
	var curRow = _billingNested.billingCheckInfoTable.getRow();
	_billingNested.billingCheckInfoTable.setValue(curRow, "CHARGE_ID",
			chargeId, chargeId);
}

//保存资费对比数据
_billingNested.saveBillingCheck = function() {
	var list = new Array();
	list.push(_billingNested.billingCheckInfoTable);
	for ( var i = 0; i < _billingNested.billingCheckInfoTable
			.getTotalRowCount(); i++) {

		var checkItem = _billingNested.billingCheckInfoTable.getValue(i,
				"CHECK_ITEM");
		if (checkItem == "" || checkItem == null || checkItem == 'undefined') {
			alert("请输入第" + (i + 1) + "行 对比项目 列的内容！");
			return;
		}

		var schemeName = _billingNested.billingCheckInfoTable.getValue(i,
				"SCHEME_NAME");
		if (schemeName == "" || schemeName == null || schemeName == 'undefined') {
			alert("请输入第" + (i + 1) + "行 方案名称 列的内容！");
			return;
		}

		var brand = _billingNested.billingCheckInfoTable.getValue(i, "BRAND");
		if (brand == "" || brand == null || brand == 'undefined') {
			alert("请输入第" + (i + 1) + "行 品牌 列的内容！");
			return;
		}

		var targetMarket = _billingNested.billingCheckInfoTable.getValue(i,
				"TARGET_MARKET");
		if (targetMarket == "" || targetMarket == null
				|| targetMarket == 'undefined') {
			alert("请输入第" + (i + 1) + "行 目标市场 列的内容！");
			return;
		}

		var billingContent = _billingNested.billingCheckInfoTable.getValue(i,
				"BILLING_CONTENT");
		if (billingContent == "" || billingContent == null
				|| billingContent == 'undefined') {
			alert("请输入第" + (i + 1) + "行 资费内容 列的内容！");
			return;
		}

		var billingSellingPoint = _billingNested.billingCheckInfoTable
				.getValue(i, "BILLING_SELLINGPOINT");
		if (billingSellingPoint == "" || billingSellingPoint == null
				|| billingSellingPoint == 'undefined') {
			alert("请输入第" + (i + 1) + "行 资费卖点 列的内容！");
			return;
		}

		var slogan = _billingNested.billingCheckInfoTable.getValue(i, "SLOGAN");
		if (slogan == "" || slogan == null || slogan == 'undefined') {
			alert("请输入第" + (i + 1) + "行 传播口号 列的内容！");
			return;
		}
	}
	if ("" != _billingNested.billingCheckInfoTable.toXmlString()) {
		saveRowSet(
				_gModuleName + '/business/com.asiainfo.charge.web.BillingCheckAction?action=saveBillingCheckInfo',
				list);
		var curRow = _billingNested.billingCheckInfoTable.getRow();
		var chargeId = _billingNested.billingCheckInfoTable.getValue(curRow,
				"CHARGE_ID")
		var param = "chargeId=" + chargeId;
		_billingNested.billingCheckInfoTable.refresh(param);//刷新
	} else {
		return alert("请先增加资费对比!");
	}
}

//删除资费对比数据
_billingNested.delBillingCheck = function() {
	var selectedRows = new Array();
	selectedRows = _billingNested.billingCheckInfoTable.getSelectedRows();
	if (selectedRows.length < 1) {
		alert("请选择要删除的数据！");
		return;
	} else {
		if (confirm("确定要删除这" + selectedRows.length + "条数据吗？")) {
			for ( var i = selectedRows.length; i > 0; i--) {
				var billingcheckId = _billingNested.billingCheckInfoTable
						.getValue(selectedRows[selectedRows.length - i],
								"BILLINGCHECK_ID");
				if (billingcheckId != ""
						&& typeof billingcheckId != "undefined") {
					_billingNested.billingCheckInfoTable
							.deleteRow(selectedRows[i - 1]);
					_billingNested
							.savaBillingCheckRowSet(_billingNested.billingCheckInfoTable);
				} else {
					_billingNested.billingCheckInfoTable
							.deleteRow(selectedRows[i - 1]);
				}
			}
		}
	}
}

_billingNested.savaBillingCheckRowSet = function(rowSet) {
	var list = new Array();
	list.push(rowSet);
	var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.BillingCheckAction?action=saveBillingCheckInfo';
	saveRowSet(strUrl, list);
}

//新增财务分摊规则
/*  Deprecated
_billingNested.addFinaAllocShare = function() {
	var chargeId = _fromChargeMainDeFormRowSet.getValue("MID");
	if (chargeId == "" || chargeId == null || chargeId == "undefined") {
		alert("请先保存资费档次信息！");
		return;
	}
	_billingNested.finaAllocShareForm.newRow();
	_billingNested.finaAllocShareForm.setValue("CHARGE_ID", chargeId);
	_billingNested.finaAllocShareForm.setValue("CALLING_EXPENSE", "通话费");
	_billingNested.finaAllocShareForm.setValue("MONTHFIXED_EXPENSE", "月租费");
	_billingNested.finaAllocShareForm.setValue("INCOMINGSHOW_EXPENSE", "主叫显示");
	_billingNested.finaAllocShareForm.setValue("SMS_EXPENSE", "短信");
	_billingNested.finaAllocShareForm.setValue("WLAN", "WLAN");
	_billingNested.finaAllocShareForm.setValue("WAPGPRS_EXPENSE", "WAP/GPRS");
	_billingNested.finaAllocShareForm.setValue("WAPSMS_EXPENSE", "梦网短信");
	_billingNested.finaAllocShareForm.setValue("MMS_EXPENSE", "彩信");

}

//删除财务分摊规则
_billingNested.delFinaAllocShare = function() {
	var finaAllocShareId = _billingNested.finaAllocShareForm
			.getValue("FINAALLOCRULES_ID");
	if (finaAllocShareId == "" || finaAllocShareId == null
			|| finaAllocShareId == "undefined") {
		alert("请先新增数据保存之后删除数据！");
		return;
	} else {
		_billingNested.finaAllocShareForm.setStsToDel();
		var list = new Array();
		list.push(_billingNested.finaAllocShareForm);
		var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.FinaAllocShareAction?action=saveFinaAllocShare';
		var recode = saveRowSet(strUrl, list);
		var successFlag = recode.getValueByName("FLAG");
		if (successFlag == "Y") {
			_billingNested.finaAllocShareForm.newRow();
			g_AIButtonManager.get("_billingNested_addFinaAllocShare")
					.setDisabled(false);
		}
	}
}
*/
//保存财务分摊规则	
_billingNested.saveFinaAllocShare = function() {
	if (_billingNested.finaAllocShareForm.getSts() == 'O') return;
	var chargeId = _fromChargeMainDeFormRowSet.getValue("MID");
	if (chargeId == "" || chargeId == null || chargeId == "undefined") {
		alert("请先保存资费档次信息！");
		return;
	}

	for (var k=_billingNested.finaAllocShareTab.getTotalRowCount(); k >= 0; -- k) {
		_billingNested.finaAllocShareTab.deleteRow(k);
	} 
	
	var x=document.getElementsByName("finalShare");
	for (var i=0;i<x.length;i++)
	{	
		if (x[i].checked) {
			_billingNested.finaAllocShareTab.newRow(false);
			var curRowIndex = _billingNested.finaAllocShareTab.getTotalRowCount();
			_billingNested.finaAllocShareTab.setValue(curRowIndex,"CHARGE_ID",chargeId);
			_billingNested.finaAllocShareTab.setValue(curRowIndex,"FINAL",x[i].value);
			_billingNested.finaAllocShareTab.setValue(curRowIndex,"FINAL_TAXRATE",getTaxRate(x[i].value));
		}
	}
	
	//return;
	/*_billingNested.finaAllocShareForm.setValue("CHARGE_ID", chargeId);
	var sumValue = 0;
	for(var i = 0 ;i<_billingNested.finaAllocShareForm.fieldNameArray.length;i++){
		var fieldName = _billingNested.finaAllocShareForm.fieldNameArray[i];
			if(fieldName=="CHARGE_ID"||fieldName=="ID"){
				continue;
			}
			var fieldValue = _billingNested.finaAllocShareForm.getValue(fieldName);
			var fieldTitle = _billingNested.finaAllocShareForm.getTitle(fieldName);
			 
			if (_billingNested.finaAllocShareForm.isFieldNull(fieldName,false)) {
				//_billingNested.finaAllocShareForm.setValue(fieldName, "0");
				fieldValue = 0;//_billingNested.finaAllocShareForm.getValue(fieldName);
			}else{
				if(!_billingNested.checkIsNum(fieldValue, fieldTitle, fieldValue)){
					return;
				} else if (fieldValue != 0){
					_billingNested.finaAllocShareTab.newRow(false);
					var curRowIndex = _billingNested.finaAllocShareTab.getTotalRowCount();
					_billingNested.finaAllocShareTab.setValue(curRowIndex,"CHARGE_ID",chargeId);
					_billingNested.finaAllocShareTab.setValue(curRowIndex,"FINAL",fieldTitle);
					_billingNested.finaAllocShareTab.setValue(curRowIndex,"FINAL_RATE",fieldValue);
				}
			}
			sumValue +=parseFloat(fieldValue);
		
	} */
	
	//if ("" != _billingNested.finaAllocShareForm.toXmlString()) {
	_billingNested.saveFinalShareTab(chargeId);
	//}else{
		//alert("提交数据无更新！");
	//}
}

_billingNested.saveFinalShareTab = function(chargeId) {
	
	var list = new Array();
	list.push(_billingNested.finaAllocShareTab);
	var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.FinaAllocShareAction?action=saveFinaAllocShare';
	var recode = saveRowSet(strUrl, list);
	var successFlag = recode.getValueByName("FLAG");
	if (chargeId == '' || chargeId ==undefined) return;
	if (successFlag == "Y") {
		//var finaAllocShareId = recode.getValueByName("ID");
		_billingNested.finaAllocShareTab.refresh("&chargeId="+ chargeId);
		//g_AIButtonManager.get("_billingNested_addFinaAllocShare").setDisabled(true);
	}
}

//检查输入是否是数字
_billingNested.checkIsNum = function(content, filedName, fieldValue) {

	if (content != "" && content != null) {
		if (!_billingNested.checkIsDouble(content)) {
			alert(filedName + ":填写格式不对！");
			_billingNested.finaAllocShareForm.setValue(fieldValue, "");
			_billingNested.finaAllocShareForm.setFocus(fieldValue);
			return false;
		}
	} 
	return true;
}

//校验实数
_billingNested.checkIsDouble = function(objField) {
	var patrn = /^[-\+]?\d+(\.\d+)?$/;
	var strField = new String(objField);
	if (!patrn.exec(strField)) {
		return false;
	} else {
		return true;
	}
}

function getTaxRate(item){
	var cases = {
	  	LDTX:6,
		YZF:0,
		BDTHF:11,
		SJB:6,
		ZJXS:6,
		LLF:6,
		IP_SR:11,
		WXYY_CLGNF:6,
		WNCX:6,
		YDMS:6,
		WNDX:6,
		YDSJYW_QT:6,
		WXYY_JLB:6,
		YX_139:6,
		WLAN_TXF:6,
		YEWBL:6,
		NXT:6,
		HBGJ:6,
		FEIX:6,
		DXHZ:6,
		SJYD:6,
		FMYJBCT:11,
		CX_XXF:6,
		CWT:6,
		YDQXZ:6,
		JTTXGJ:6,
		CLXXF:6,
		GRZX_HLW:6,
		GRZX_SJ:11,
		SNCFMY:11,
		SJ_SP:6,
		SJ_DM:6,
		SJ_YX:6,
		SJ_DX:6,
		YY_ZZ:6,
		MM:6,
		SJ_DH:6,
		SJ_ZQ:6,
		SJ_ZF:6 
	};
  	return (cases[item]);
}
</script>

<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js">
</script>
<script type="text/javascript">
function doWork(fun) {
	beginAIWaitBanner(fun, "正在处理，请稍后...");
}
</script>