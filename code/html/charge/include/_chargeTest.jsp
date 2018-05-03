<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<ai:contractframe id="chargeTestframe" contenttype="table" title="�ʷѲ���" width="100%" allowcontract="true" frameclosed="true">
<ai:contractitem/>
	<ai:contractframe id="chargeInnerTestframe" contenttype="table" title="�ڲ�������Ϣ(֧��txt,xls,xlsx�ļ��ϴ�,txt���Ʊ���ֿ�)" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem>
		<ai:button id="select_inner_bt" text="ѡ���ϴ��ļ�" onclick="selectFile('i_test',3)"/>
		<ai:button id="save_inner_bt" text="����" onclick="saveChargeTest('i')"/>
		<ai:button id="add_inner_bt" text="����һ��" onclick="addChargeTest('i')"/>
		<ai:button id="delete_inner_bt" text="ɾ����ѡ��" onclick="deleteSelectedChargeTest('i')"/>
	    <!-- <ai:button id="clear_inner_bt" text="��ձ�" onclick="clearChargeTestTab('i')"/> -->
	</ai:contractitem>
		<ai:table tableid="chargeInnerTestTab" editable="true" width="100%" height="150"
	              setname="com.asiainfo.charge.web.SETChargeTest" pagesize="30"
	              needrefresh="true" initial="false" multiselect="true"
	              tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	              implservice_name="com.asiainfo.charge.service.interfaces.IChargeTestSV"
	              implservice_querymethod="getChargeTestsByOrderId(String chargeOrderId,String flag,int $STARTROWINDEX,int $ENDROWINDEX)"
	              implservice_countmethod="getChargeTestCnByOrderId(String chargeOrderId,String flag)">
	               <ai:col fieldname="ID" width="70" visible="false"/>
	               <ai:col fieldname="TEST_FACTOR" width="170" />
	               <ai:col fieldname="TEST_RESULT" width="500"/>
	               <ai:col fieldname="REASON" width="300"/>
	               <ai:col fieldname="ORDER_ID" width="150" visible="false" />
	    </ai:table>
	 	
	</ai:contractframe>
	<ai:contractframe id="chargeExternTestframe" contenttype="table" title="�ⲿ������Ϣ(֧��txt,xls,xlsx�ļ��ϴ�,txt���Ʊ���ֿ�)" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem>
		<ai:button id="select_extern_bt" text="ѡ���ϴ��ļ�" onclick="selectFile('e_test',3)"/>
		<ai:button id="save_extern_bt" text="����" onclick="saveChargeTest('e')"/>
		<ai:button id="add_extern_bt" text="����һ��" onclick="addChargeTest('e')"/>
		<ai:button id="delete_extern_bt" text="ɾ����ѡ��" onclick="deleteSelectedChargeTest('e')"/>
	    <!-- <ai:button id="clear_extern_bt" text="��ձ�" onclick="clearChargeTestTab('e')"/> -->
	</ai:contractitem>
		<ai:table tableid="chargeExternTestTab" editable="true" width="100%" height="150"
	              setname="com.asiainfo.charge.web.SETChargeTest" pagesize="30"
	              needrefresh="true" initial="false" multiselect="true"
	              tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	              implservice_name="com.asiainfo.charge.service.interfaces.IChargeTestSV"
	              implservice_querymethod="getChargeTestsByOrderId(String chargeOrderId, String flag,int $STARTROWINDEX,int $ENDROWINDEX)"
	              implservice_countmethod="getChargeTestCnByOrderId(String chargeOrderId,String flag)">
	               <ai:col fieldname="ID" width="70" visible="false"/>
	               <ai:col fieldname="TEST_FACTOR" width="170" />
	               <ai:col fieldname="TEST_RESULT" width="500"/>
	               <ai:col fieldname="REASON" width="300"/>
	               <ai:col fieldname="ORDER_ID" width="150" visible="false" />
	    </ai:table>
	 	
	</ai:contractframe>
	<div id="wf6_div" style="display: block">
		<% String taskTag =request.getParameter("taskTag");
		   String audit6_jsp = "/charge/workflow/_blank.jsp";
		   if (taskTag.endsWith("-test")) {
		   	   audit6_jsp = "/charge/workflow/_submitWF.jsp";
		   }
		%>  
		<jsp:include page="<%=audit6_jsp %>"></jsp:include>
	</div>
</ai:contractframe>
<script type="text/javascript">
var chargeInnerTestTab = g_TableRowSetManager.get("chargeInnerTestTab");
var chargeExternTestTab = g_TableRowSetManager.get("chargeExternTestTab");

function initTestPage() {
	if (_mainId == null || _mainId == 'null' || _mainId == '') return;
	chargeInnerTestTab.refresh("chargeOrderId="+_mainId+"&flag=i");
	chargeExternTestTab.refresh("chargeOrderId="+_mainId+"&flag=e");
	var taskTag = "<%=request.getParameter("taskTag")%>";
	if (!taskTag.endWith("-test")) {
		chargeInnerTestTab.setEditSts(false);
		chargeExternTestTab.setEditSts(false);
		document.getElementById('select_inner_bt').style.visibility='hidden';
		document.getElementById('save_inner_bt').style.visibility='hidden';
		document.getElementById('add_inner_bt').style.visibility='hidden';
		document.getElementById('delete_inner_bt').style.visibility='hidden';
		//document.getElementById('clear_inner_bt').style.visibility='hidden';
		document.getElementById('select_extern_bt').style.visibility='hidden';
		document.getElementById('save_extern_bt').style.visibility='hidden';
		document.getElementById('add_extern_bt').style.visibility='hidden';
		document.getElementById('delete_extern_bt').style.visibility='hidden';
		//document.getElementById('clear_extern_bt').style.visibility='hidden';
	} else {
		document.all("contractFrame_chargeTestframe").style.display='block';
	}
}

function clearChargeTestTab(flag) {
	var tbRs = chargeInnerTestTab;
	if (flag == 'e') {
		tbRs = chargeExternTestTab;
	} 
	tbRs.clear();
}

function addChargeTest(flag) {
	var tbRs = chargeInnerTestTab;
	if (flag == 'e') {
		tbRs = chargeExternTestTab;
	} 
	tbRs.newRow(false);
	tbRs.setValue(tbRs.getTotalRowCount()-1,"ORDER_ID",_mainId);
	
}

function deleteSelectedChargeTest(flag) {
	var tbRs = chargeInnerTestTab;
	if (flag == 'e') {
		tbRs = chargeExternTestTab;
	} 
	var delRows =tbRs.getSelectedRows();
	var delRowCount = delRows.length;
	if (delRowCount == 0) {
		alert("����ѡ��Ҫɾ������");
		return;
	}
	while (delRowCount > 0) {
		delRowCount--;
		tbRs.deleteRow(delRows[delRowCount]);
	}
}

function saveChargeTest(flag) {
	var tbRs = chargeInnerTestTab;
	if (flag == 'e') {
		tbRs = chargeExternTestTab;
	} 
	var list = new Array();
	list.push(tbRs);
	var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeTestAction?action=save&flag='+flag;
	var recode = saveRowSet(strUrl, list);
	//if (recode.getValueByName("FLAG") == "Y") alert("����ɹ���");
}

</script>