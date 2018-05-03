<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/frame/BceFrameHead.jsp"%>
<html>  
<head>
<title></title>
</head>
<body>
<ai:dbform formid="gmdetailForm" setname="com.asiainfo.crm.bcedemo.group.web.GroupAccount" initial="false" 
datamodel="" onvalchange="" editable="true">
<table class="DBForm_Layout_Table" >
<tr class="DBForm_Layout_Tr">
  <td >ACC_ALIAS_NAME:</td>  <td><ai:dbformfield fieldname="ACC_ALIAS_NAME" formid="gmdetailForm" visible="true"/></td>
  <td >ACC_BUSI_TYPE:</td>  <td><ai:dbformfield fieldname="ACC_BUSI_TYPE" formid="gmdetailForm" visible="true"/></td>
</tr>
<tr class="DBForm_Layout_Tr">
  <td >ACC_ID:</td>  <td><ai:dbformfield fieldname="ACC_ID" formid="gmdetailForm" visible="true"/></td>
  <td >CONTACT_BILL_ID:</td>  <td><ai:dbformfield fieldname="CONTACT_BILL_ID" formid="gmdetailForm" visible="true"/></td>
</tr>
<tr class="DBForm_Layout_Tr">
  <td >GROUP_ACC_ID:</td>  <td><ai:dbformfield fieldname="GROUP_ACC_ID" formid="gmdetailForm" visible="true"/></td>
  <td >CONTACT_CARD_TYPE:</td>  <td><ai:dbformfield fieldname="CONTACT_CARD_TYPE" formid="gmdetailForm" visible="true"/></td>
</tr>
<tr class="DBForm_Layout_Tr">
  <td >CONTACT_NAME:</td>  <td><ai:dbformfield fieldname="CONTACT_NAME" formid="gmdetailForm" visible="true"/></td>
  <td >CONTACT_PERSON:</td>  <td><ai:dbformfield fieldname="CONTACT_PERSON" formid="gmdetailForm" visible="true"/></td>
</tr>
<tr class="DBForm_Layout_Tr">
  <td >GROUP_ID:</td>  <td><ai:dbformfield fieldname="GROUP_ID" formid="gmdetailForm" visible="true"/></td>
  <td >IS_SEND:</td>  <td><ai:dbformfield fieldname="IS_SEND" formid="gmdetailForm" visible="true"/></td>
</tr>
<tr class="DBForm_Layout_Tr">
  <td >NEED_TO_SEND_MESSAGE:</td>  <td><ai:dbformfield fieldname="NEED_TO_SEND_MESSAGE" formid="gmdetailForm" visible="true"/></td>
</tr>
</table>
</ai:dbform>
<ai:dbform formid="gmtestForm" setname="com.asiainfo.crm.bcedemo.group.web.GroupTest" initial="false" 
datamodel="" onvalchange="" editable="true">
<table class="DBForm_Layout_Table" >
<tr class="DBForm_Layout_Tr">
  <td >CARD_ID:</td>  <td><ai:dbformfield fieldname="CARD_ID" formid="gmtestForm" visible="true"/></td>
  <td >CARD_TYPE:</td>  <td><ai:dbformfield fieldname="CARD_TYPE" formid="gmtestForm" visible="true"/></td>
</tr>
<tr class="DBForm_Layout_Tr">
  <td >CUSTOMER_ID:</td>  <td><ai:dbformfield fieldname="CUSTOMER_ID" formid="gmtestForm" visible="true"/></td>
  <td >DONE_CODE:</td>  <td><ai:dbformfield fieldname="DONE_CODE" formid="gmtestForm" visible="true"/></td>
</tr>
</table>
</ai:dbform>


  <table width="98%" align="center" border="0" cellpadding="0" cellspacing="0"><tr><td>
<ai:table tableid="gmmainTable" setname="com.asiainfo.crm.bcedemo.group.web.GroupContractInfo" 
tablemodel="" 
height="150" width="700"  
onvalchange="" multiselect="false" editable="true" 
needrefresh="true" initial="false">
<ai:col fieldname="CONTRACT_ID" visible="false"/>
<ai:col fieldname="CONTRACT_NAME" visible="true"/>
<ai:col fieldname="GROUP_ID" visible="true"/>
<ai:col fieldname="MANAGER_ID" visible="true"/>

</ai:table>    
  </td></tr></table>

<div class="area_button">
  <ai:button text="新增" id="btnAdd" onclick="add()" />
  <ai:button text="事件测试" id="alertMessage" />
  <ai:button text="提交A" id="btnSubmitA" onclick="commit('A')" />
  <ai:button text="提交B" id="btnSubmitB" onclick="commit('B')" />
</div>  
</body>
</html>

<script language="javascript">
function getForm(){
  return g_FormRowSetManager.get("gmdetailForm");
}

function getForm2(){
  return g_FormRowSetManager.get("gmtestForm");
}

function getTbl(){
  return g_TableRowSetManager.get("gmmainTable");
}

function add(){
  getTbl().newRow(false);
}

</script>