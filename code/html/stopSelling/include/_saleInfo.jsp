<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<head>
<title>停售营销案信息</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
</head>
<ai:contractframe id="saleStopSellframe" contenttype="table" title="停售营销案信息" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem><ai:button text="删除" id="del_bt1" onclick="delRecord()"/>
	</ai:contractitem>
	<ai:table tableid="saleStopSellTab" setname="com.asiainfo.stopSelling.set.SETStopSellD" 
		height="100" multiselect="true"  needrefresh="true" 
		width="100%" onrowchange="showChargeStopSellInfo" pagesize="30"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.stopSelling.service.interfaces.IStopSellDSV"
		implservice_querymethod="getStopSellDByMainId(String mainId,int $STARTROWINDEX, int $ENDROWINDEX)" 
		implservice_countmethod="getStopSellDCountByMainId(String mainId)" 
		initial="false" editable="false">
				<ai:col fieldname="DID" width="150" visible="false"/>
	        	<ai:col fieldname="BATCH_NAME" width="300" visible="true"/>
	        	<ai:col fieldname="LEVEL_NAME" width="300" visible="true"/>
	            <ai:col fieldname="LEVEL_CODE" width="180" visible="true"/>
	             <ai:col fieldname="EXE_AREA" width="130" visible="true"/>
	            <ai:col fieldname="MARKTYPE" width="150" visible="true"/>
	        	<ai:col fieldname="PRE_OFFDATE" width="130" visible="true"/>
	            <ai:col title="执行开始时间" fieldname="WORK_DATE" width="130" visible="true"/>
	            <ai:col fieldname="END_DATE" width="130" visible="true"/>
	</ai:table>
</ai:contractframe>

<ai:contractframe id="saleDetailframe" contenttype="table" title="营销案停售明细信息" width="100%" allowcontract="true" frameclosed="false">
<ai:contractitem><ai:button text="新增" id="new_add_bt" onclick="newRecord()" /></ai:contractitem>
<ai:dbform formid="saleStopSellForm" 
          setname="com.asiainfo.stopSelling.set.SETStopSellD"
          conditionname="condition" parametersname="parameters"
          editable="true" initial="false" 
          datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
          implservice_name="com.asiainfo.stopSelling.service.interfaces.IStopSellDSV"
          implservice_querymethod="getStopSellDById(String did)" >
    <table width="100%" align="center" border="0" cellpadding="1" cellspacing="1">
     <tr id="query_tr" style="display: block">
     	<td id="query_td" class="td_font">查询平台现有营销活动：</td>
     	<td><img id="select" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" 
       	   alt="" onClick="(selectExistInfo())" align="absmiddle" style="cursor: hand;" /></td>
     </tr>
     <tr id="act_tr">
      <td class="td_font">营销案批次名称：</td>
       <td><ai:dbformfield formid="saleStopSellForm" fieldname="BATCH_NAME" width="300"/><span class="font_red">*</span></td>
       	   <ai:dbformfield formid="saleStopSellForm" fieldname="DID" width="60" editable="" visible="false"/>
       	   <ai:dbformfield formid="saleStopSellForm" fieldname="MAINID" width="150" editable="" visible="false"/>
       <td class="td_font">营销案档次名称：</td>
       <td><ai:dbformfield formid="saleStopSellForm" fieldname="LEVEL_NAME" width="300"/><span class="font_red">*</span>
       </td>
     </tr> 
     <tr>
     	<td class="td_font">BOSS营销案档次编码：</td>
     	<td><ai:dbformfield formid="saleStopSellForm" fieldname="LEVEL_CODE" width="180"/><span class="font_red">*</span></td>
     	<td class="td_font">细分市场：</td>
     	<td><ai:dbformfield formid="saleStopSellForm" fieldname="MARKTYPE" width="180"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="marketMultiplySelected();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
     </tr> 
     <tr>
     	<td class="td_font">执行开始时间：</td>
     	<td><ai:dbformfield formid="saleStopSellForm" fieldname="WORK_DATE" width="180"/><span class="font_red">*</span></td>
     	<td class="td_font">执行截止时间：</td>
     	<td><ai:dbformfield formid="saleStopSellForm" fieldname="END_DATE" width="180"/><span class="font_red">*</span></td>
     </tr>
     <tr>
        <td class="td_font">执行范围：</td>
     	<td><ai:dbformfield formid="saleStopSellForm" fieldname="EXE_AREA" width="180"/><span class="font_red">*</span></td>
     	<td class="td_font">预计下线时间：</td>
     	<td colspan="3"><ai:dbformfield formid="saleStopSellForm" fieldname="PRE_OFFDATE" width="180"/><span class="font_red">*</span></td>
     </tr>
     <tr>
     	<td class="td_font">营销案内容描述：</td>
     	<td colspan="3"><ai:dbformfield formid="saleStopSellForm" fieldname="DESCRIPTION" width="700" height="100"/><span class="font_red">*</span></td>
     </tr>
    <tr><td colspan="4" align="center"><ai:button text="保存停售明细信息" id="saved_bt" onclick="doWork('saveChargeSellDInfo()')"/></td></tr>
</table>
</ai:dbform>
</ai:contractframe>
<script type="text/javascript">
var saleStopSellTab = g_TableRowSetManager.get("saleStopSellTab");
var saleStopSellForm = g_FormRowSetManager.get("saleStopSellForm");

function initSaleStopSellDInfo(){
	saleStopSellTab.refresh("&mainId="+mainId);
}

function saveChargeSellDInfo(){
   if ("O" !=saleStopSellForm.getSts()){
	    if (mainId == '') return alert("请先保存主信息！");
	    if (checkMustWrite() == false) return;
	    saleStopSellForm.setValue("MAINID",mainId);
		var list = new Array();
		list.push(saleStopSellForm);
		
		var strUrl = _gModuleName + '/business/com.asiainfo.stopSelling.web.StopSellDAction?action=saveStopSellDInfo';
		var recode = saveRowSet(strUrl, list);
	    var rFlag = recode.getValueByName("FLAG");
		if ("Y" == rFlag)
		{
		  saleStopSellTab.refresh("&mainId="+mainId);
		  newRecord();
		}
	}
}

function newRecord(){
	saleStopSellForm.newRow();
	if (mainId == null || mainId == '') return;
	saleStopSellTab.refresh("&mainId="+mainId);
}

function delRecord(){
	if(confirm("您确定要删除！")){
		saleStopSellForm.newRow();
		var delRows = saleStopSellTab.getSelectedRows();
		var delRowCount = delRows.length;
		if (delRowCount == 0) {
			alert("请先选择要删除的行");
			return;
		}
		saleStopSellTab.refresh("&mainId="+mainId);
		while (delRowCount > 0) {
			delRowCount--;
			saleStopSellTab.deleteRow(delRows[delRowCount]);
		}
		var list = new Array();
		list.push(saleStopSellTab);
		var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.stopSelling.web.StopSellDAction?action=saveStopSellDInfo';
		var ud = saveRowSet(strUrl, list);
		if (ud.getValueByName("FLAG") == "Y") {
			saleStopSellTab.refresh("&mainId="+mainId);
	        newRecord();
		} else {
			alert(ud.getValueByName("MESSAGE"));
			return;
		}
	}
}

function selectExistInfo(){
	
    var url = "<%=request.getContextPath()%>/sale/access/include/_selectSaleOrCharge.jsp?batchType=sale";
    var style = "dialogWidth:800px";
    var retMsg = window.showModalDialog(url, '', style);
    if(retMsg==null || retMsg==''){
    	return;
    } else {
    	saleStopSellForm.setValue("BATCH_NAME",retMsg.split(",")[1]);
    	saleStopSellForm.setValue("LEVEL_CODE",retMsg.split(",")[3]);
    	saleStopSellForm.setValue("LEVEL_NAME",retMsg.split(",")[4]);
    	saleStopSellForm.setValue("WORK_DATE",retMsg.split(",")[5]);
    	saleStopSellForm.setValue("END_DATE",retMsg.split(",")[6]);
    }
}

function showChargeStopSellInfo(oldIndex,newIndex){
    if(-1 != oldIndex) {
       saleStopSellTab.setRowBgColor(oldIndex,"");
    }
    saleStopSellTab.setRowBgColor(newIndex,"yellow");
    saleStopSellForm.refresh("&did="+saleStopSellTab.getValue(newIndex,"DID"));
}

function checkMustWrite(){
	if (saleStopSellForm.getValue("CHARGE_TYPE") == '') {
		alert("请选择资费类型！");
		return false;
	    
	}
	if (saleStopSellForm.getValue("BUSI_TYPE") == '') {
		alert("请选择业务类型！");
		return false;
	    
	}
	if (saleStopSellForm.getValue("BATCH_NAME") == '') {
		alert("请填写营销案批次名称！");
		return false;
	    
	}
    if ("" == saleStopSellForm.getValue("LEVEL_CODE")){
    	alert("请填写BOSS营销案编码！");
    	return false;
    }
    if ("" == saleStopSellForm.getValue("LEVEL_NAME")){
    	alert("请填写营销案档次名称！");
    	return false;
    }
    if ("" == saleStopSellForm.getValue("MARKTYPE")){
    	alert("请填写细分市场！");
    	return false;
    }
    if ("" == saleStopSellForm.getValue("EXE_AREA")){
    	alert("请填写执行范围！");
    	return false;
    }
	if (saleStopSellForm.getValue("WORK_DATE") == '') {
		alert("请填写执行开始时间！");
		return false;
	    
	}
	if (saleStopSellForm.getValue("END_DATE") == '') {
		alert("请填写执行结束时间！");
		return false;
	    
	}
	if (saleStopSellForm.getValue("PRE_OFFDATE") == '') {
		alert("请填写预计下线时间！");
		return false;
	    
	}
	if (saleStopSellForm.getValue("DESCRIPTION") == '') {
		alert("请填写营销案内容描述！");
		return false;
	    
	}
}

function marketMultiplySelected(){
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/SaleMarketMultiplySelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = saleStopSellForm.getValue("MARKTYPE");
    saleStopSellForm.setValue("MARKTYPE",onItemMultiplySelected(url, iniVal, style));
}

function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>
