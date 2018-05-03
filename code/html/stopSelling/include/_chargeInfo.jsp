<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<head>
<title>停售资费信息</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
</head>
<ai:contractframe id="chargeStopSellframe" contenttype="table" title="停售资费信息" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem><ai:button text="删除" id="del_bt1" onclick="delRecord()"/>
	</ai:contractitem>
	<ai:table tableid="chargeStopSellTab" setname="com.asiainfo.stopSelling.set.SETStopSellD" 
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
	            <ai:col fieldname="LEVEL_CODE" width="150" visible="true"/>
	            <ai:col fieldname="WORK_DATE" width="130" visible="true"/>
	        	<ai:col fieldname="PRE_OFFDATE" width="130" visible="true"/>
	            <ai:col fieldname="CHARGE_TYPE" width="180" visible="false"/>
	            <ai:col fieldname="BUSI_TYPE" width="150" visible="false"/>
	</ai:table>
</ai:contractframe>

<ai:contractframe id="busiChangeDetailframe" contenttype="table" title="资费停售明细信息" width="100%" allowcontract="true" frameclosed="false">
<ai:contractitem><ai:button text="新增" id="new_add_bt" onclick="newRecord()" /></ai:contractitem>
<ai:dbform formid="chargeStopSellForm" 
          setname="com.asiainfo.stopSelling.set.SETStopSellD"
          conditionname="condition" parametersname="parameters"
          editable="true" initial="false" 
          datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
          implservice_name="com.asiainfo.stopSelling.service.interfaces.IStopSellDSV"
          implservice_querymethod="getStopSellDById(String did)" >
    <table width="100%" align="center" border="0" cellpadding="1" cellspacing="1">
     <tr id="query_tr" style="display: block">
     	<td id="query_td" class="td_font">查询平台现有资费：</td>
     	<td><img id="select" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" 
       	   alt="" onClick="(selectExistInfo())" align="absmiddle" style="cursor: hand;" /></td>
     </tr>
     <tr>
       <td class="td_font">资费类型：</td>
       <td><ai:dbformfield formid="chargeStopSellForm" fieldname="CHARGE_TYPE" width="180"/><span class="font_red">*</span>
       	   <ai:dbformfield formid="chargeStopSellForm" fieldname="DID" width="60" editable="" visible="false"/>
       	   <ai:dbformfield formid="chargeStopSellForm" fieldname="MAINID" width="150" editable="" visible="false"/>
       </td>
       <td class="td_font">业务类型：</td>
       <td><ai:dbformfield formid="chargeStopSellForm" fieldname="BUSI_TYPE" width="180"/><span class="font_red">*</span></td>
     </tr>
     <tr id="act_tr">
      <td class="td_font">资费批次名称：</td>
       <td><ai:dbformfield formid="chargeStopSellForm" fieldname="BATCH_NAME" width="300"/><span class="font_red">*</span></td>
       <td class="td_font">资费档次名称：</td>
       <td><ai:dbformfield formid="chargeStopSellForm" fieldname="LEVEL_NAME" width="300"/><span class="font_red">*</span>
       </td>
     </tr> 
     <tr>
     	<td class="td_font">BOSS资费档次编码：</td>
     	<td><ai:dbformfield formid="chargeStopSellForm" fieldname="LEVEL_CODE" width="180"/><span class="font_red">*</span></td>
     	<td id="level_code_td" class="td_font">细分市场：</td>
     	<td><ai:dbformfield formid="chargeStopSellForm" fieldname="MARKET" width="180"/><span class="font_red">*</span></td>
     </tr> 
     <tr>
     	<td id="level_code_td" class="td_font">上线时间：</td>
     	<td><ai:dbformfield formid="chargeStopSellForm" fieldname="WORK_DATE" width="180"/><span class="font_red">*</span></td>
     	<td id="level_code_td" class="td_font">预计下线时间：</td>
     	<td colspan="3"><ai:dbformfield formid="chargeStopSellForm" fieldname="PRE_OFFDATE" width="180"/><span class="font_red">*</span></td></tr>
     <tr>
     	<td id="level_code_td" class="td_font">资费内容描述：</td>
     	<td colspan="3"><ai:dbformfield formid="chargeStopSellForm" fieldname="DESCRIPTION" width="700" height="100"/><span class="font_red">*</span></td>
     </tr>
    <tr><td colspan="4" align="center"><ai:button text="保存停售明细信息" id="saved_bt" onclick="doWork('saveChargeSellDInfo()')"/></td></tr>
</table>
</ai:dbform>
</ai:contractframe>
<script type="text/javascript">
var chargeStopSellTab = g_TableRowSetManager.get("chargeStopSellTab");
var chargeStopSellForm = g_FormRowSetManager.get("chargeStopSellForm");

function initChargeStopSellDInfo(){
	chargeStopSellTab.refresh("&mainId="+mainId);
}

function saveChargeSellDInfo(){
   if ("O" !=chargeStopSellForm.getSts()){
	    if (mainId == '') return alert("请先保存主信息！");
	    if (checkMustWrite() == false) return;
	    chargeStopSellForm.setValue("mainId",mainId);
		var list = new Array();
		list.push(chargeStopSellForm);
		
		var strUrl = _gModuleName + '/business/com.asiainfo.stopSelling.web.StopSellDAction?action=saveStopSellDInfo';
		var recode = saveRowSet(strUrl, list);
	    var rFlag = recode.getValueByName("FLAG");
		if ("Y" == rFlag)
		{
		  chargeStopSellTab.refresh("&mainId="+mainId);
		  newRecord();
		}
	}
}

function newRecord(){
	chargeStopSellForm.newRow();
	chargeStopSellTab.refresh("&mainId="+mainId);
}

function delRecord(){
	if(confirm("您确定要删除！")){
		chargeStopSellForm.newRow();
		var delRows = chargeStopSellTab.getSelectedRows();
		var delRowCount = delRows.length;
		if (delRowCount == 0) {
			alert("请先选择要删除的行");
			return;
		}
		chargeStopSellTab.refresh("&mainId="+mainId);
		while (delRowCount > 0) {
			delRowCount--;
			chargeStopSellTab.deleteRow(delRows[delRowCount]);
		}
		var list = new Array();
		list.push(chargeStopSellTab);
		var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.stopSelling.web.StopSellDAction?action=saveStopSellDInfo';
		var ud = saveRowSet(strUrl, list);
		if (ud.getValueByName("FLAG") == "Y") {
			chargeStopSellTab.refresh("&mainId="+mainId);
	        newRecord();
		} else {
			alert(ud.getValueByName("MESSAGE"));
			return;
		}
	}
}

function selectExistInfo(){
	
    var url = "<%=request.getContextPath()%>/sale/access/include/_selectSaleOrCharge.jsp?batchType=charge";
    var style = "dialogWidth:800px";
    var retMsg = window.showModalDialog(url, '', style);
    if(retMsg==null || retMsg==''){
    	return;
    } else {
    	chargeStopSellForm.setValue("BATCH_NAME",retMsg.split(",")[1]);
    	chargeStopSellForm.setValue("LEVEL_CODE",retMsg.split(",")[3]);
    	chargeStopSellForm.setValue("LEVEL_NAME",retMsg.split(",")[4]);
    	//busiChangeDetailForm.setValue("PLAN_BEGIN_TIME",retMsg.split(",")[5]);
    	//busiChangeDetailForm.setValue("PLAN_END_TIME",retMsg.split(",")[6]);
    }
}

function showChargeStopSellInfo(oldIndex,newIndex){
    if(-1 != oldIndex) {
       chargeStopSellTab.setRowBgColor(oldIndex,"");
    }
    chargeStopSellTab.setRowBgColor(newIndex,"yellow");
    chargeStopSellForm.refresh("&did="+chargeStopSellTab.getValue(newIndex,"DID"));
}

function checkMustWrite(){
	if (chargeStopSellForm.getValue("CHARGE_TYPE") == '') {
		alert("请选择资费类型！");
		return false;
	    
	}
	if (chargeStopSellForm.getValue("BUSI_TYPE") == '') {
		alert("请选择业务类型！");
		return false;
	    
	}
	if (chargeStopSellForm.getValue("BATCH_NAME") == '') {
		alert("请填写资费批次名称！");
		return false;
	    
	}
    if ("" == chargeStopSellForm.getValue("LEVEL_CODE")){
    	alert("请填写BOSS资费编码！");
    	return false;
    }
    if ("" == chargeStopSellForm.getValue("LEVEL_NAME")){
    	alert("请填写资费档次名称！");
    	return false;
    }
	if (chargeStopSellForm.getValue("WORK_DATE") == '') {
		alert("请填写上线时间！");
		return false;
	    
	}
	if (chargeStopSellForm.getValue("DESCRIPTION") == '') {
		alert("请填写资费内容描述！");
		return false;
	    
	}
}

function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>
