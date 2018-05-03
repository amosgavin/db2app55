<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<ai:contractframe id="chargeCfgframe" contenttype="table" title="资费配置" width="100%" allowcontract="true" frameclosed="true">
<ai:contractitem/>
	<ai:contractframe id="chargeBusiSurpCfgframe" contenttype="table" title="资费配置(支持txt,xls,xlsx文件上传,txt以制表符分开)" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem>
		<ai:button id="select_conf_bt" text="选择上传文件" onclick="selectFile('cfg',4)"/>
		<ai:button id="save_conf_bt" text="保存" onclick="saveChargeCfg()"/>
		<ai:button id="add_conf_bt" text="新增一行" onclick="addConfs()"/>
		<ai:button id="delete_conf_bt" text="删除勾选行" onclick="deleteSelectedConfs()"/>
	    <!-- <ai:button id="clear_conf_bt" text="清空表单" onclick="clearConfTab()"/> -->
	</ai:contractitem>
		<ai:table tableid="chargeCfgTab" editable="true" width="100%" height="150"
	              setname="com.asiainfo.charge.web.SETBusiSurpConf" pagesize="30"
	              needrefresh="true" initial="false" multiselect="true"
	              tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	              implservice_name="com.asiainfo.charge.service.interfaces.IChargeCfgSV"
	              implservice_querymethod="getBusiSurpConfsByChargeId(String chargeOrderId,int $STARTROWINDEX,int $ENDROWINDEX)"
	              implservice_countmethod="getBusiSurpConfCnByChargeId(String chargeOrderId)">
	               <ai:col fieldname="ID" width="70" visible="false"/>
	               <ai:col fieldname="FACTOR" width="170" />
	               <ai:col fieldname="MOLD" width="170"/>
	               <ai:col fieldname="DESC" width="500"/>
	               <ai:col fieldname="MODE" width="70"/>
	               <ai:col fieldname="REASON" width="300"/>
	               <ai:col fieldname="ORDER_ID" width="150" visible="false" />
	    </ai:table> 
	 	
	</ai:contractframe>
	<div id='eChnlCommand_div2' style="display: none;">
		<ai:contractframe id="EChannelNcodeCommand2" contenttype="table" title="短厅指令与NCODE列表" width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem>
				<ai:button id="bt_saveEChannelNcodeCommand" text="保存短厅指令与NCODE" onclick="saveEChannelNcodeCommandb()"/>
			</ai:contractitem>
			<ai:table
				tableid="EChannelNcodeCommandListTable2"
				setname="com.asiainfo.charge.web.SETEchannelNcodeCommand"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.asiainfo.charge.service.interfaces.IEchannelNcodeCommandSV"
				implservice_querymethod="getEchannelNcodeCommandByRelaId(String relaId,String infoType, int $STARTROWINDEX, int $ENDROWINDEX)"
				implservice_countmethod="getCnEchannelNcodeCommandListByRelaId(String relaId,String infoType)"
				initial="false"  multiselect="true"
				pagesize="15" editable="true" width="100%"
				height="120" needrefresh="true">
				<ai:col fieldname="NAME" width="10%" />
				<ai:col fieldname="OPEN_COMMAND" width="7%" />
				<ai:col fieldname="CANCEL_COMMAND" width="7%" />
				<ai:col fieldname="NCODE" width="6%" visible="false"/>
				<ai:col fieldname="PRI_TARIFF" width="10%"/>
				<ai:col fieldname="PROD_PACKAGE" width="10%" />
				<ai:col fieldname="G_PRODUCT" width="10%" />
				<ai:col fieldname="PROD_PACKAGE2" width="7%"/>
				<ai:col fieldname="BASE_PRODUCT" width="7%" />
				<ai:col fieldname="ADD_ATTR" width="10%" />
				<ai:col fieldname="BUSI_RULE" width="16%" />
				<ai:col fieldname="INFO_TYPE" width="15%" visible="false"/>
				<ai:col fieldname="REL_ID" width="15%" visible="false"/>
			</ai:table>
		</ai:contractframe>
	</div>	
	<div id="wf5_div" style="display: block">
		<% String taskTag =request.getParameter("taskTag");
		   String audit5_jsp = "/charge/workflow/_blank.jsp";
		   if (taskTag.endsWith("-conf")) {
		   	   audit5_jsp = "/charge/workflow/_submitWF.jsp";
		   }
		%>
		<jsp:include page="<%=audit5_jsp %>"></jsp:include> 
	</div>
</ai:contractframe>
<script type="text/javascript">
var chargeCfgTab = g_TableRowSetManager.get("chargeCfgTab");
function initCfgPage() {
	if (_mainId == null || _mainId == 'null' || _mainId == '') return;
	chargeCfgTab.refresh("chargeOrderId="+_mainId);
	var taskTag = "<%=request.getParameter("taskTag")%>";
	if(!taskTag.endWith("-conf")) {
		chargeCfgTab.setEditSts(false);
		document.getElementById('select_conf_bt').style.visibility='hidden';
		document.getElementById('save_conf_bt').style.visibility='hidden';
		document.getElementById('add_conf_bt').style.visibility='hidden';
		document.getElementById('delete_conf_bt').style.visibility='hidden';
		//document.getElementById('clear_conf_bt').style.visibility='hidden';
	} else {
		document.all("contractFrame_chargeCfgframe").style.display='block';
	}
}

function clearConfTab() {
	chargeCfgTab.clear();
}

function addConfs() {
	chargeCfgTab.newRow(false);
	chargeCfgTab.setValue(chargeCfgTab.getTotalRowCount()-1,"ORDER_ID",_mainId);
}

function deleteSelectedConfs() {
	var delRows = chargeCfgTab.getSelectedRows();
	var delRowCount = delRows.length;
	if (delRowCount == 0) {
		alert("请先选择要删除的行");
		return;
	}
	while (delRowCount > 0) {
		delRowCount--;
		chargeCfgTab.deleteRow(delRows[delRowCount]);
	}
	saveChargeCfg();
}

function saveChargeCfg() {
	var list = new Array();
	list.push(chargeCfgTab);
	var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeCfgAction?action=saveChargeConf';
	var recode = saveRowSet(strUrl, list);
	//if (recode.getValueByName("FLAG") == "Y") alert("保存成功！");
}
</script>