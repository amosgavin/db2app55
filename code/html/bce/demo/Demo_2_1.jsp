<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/frame/BceFrameHead.jsp"%>

<html>  
<head>
<title></title>
</head>
<body onload="init();">
<ai:dbform formid="detailForm" setname="com.asiainfo.crm.bcedemo.group.web.GroupAccount" initial="false" 
datamodel="" onvalchange="" editable="true">
<table class="DBForm_Layout_Table" >
<tr class="DBForm_Layout_Tr">
  <td >ACC_ALIAS_NAME:</td>  <td><ai:dbformfield fieldname="ACC_ALIAS_NAME" formid="detailForm" visible="true"/></td>
  <td >ACC_BUSI_TYPE:</td>  <td><ai:dbformfield fieldname="ACC_BUSI_TYPE" formid="detailForm" visible="true"/></td>
</tr>
<tr class="DBForm_Layout_Tr">
  <td >ACC_ID:</td>  <td><ai:dbformfield fieldname="ACC_ID" formid="detailForm" visible="true"/></td>
  <td >CONTACT_BILL_ID:</td>  <td><ai:dbformfield fieldname="CONTACT_BILL_ID" formid="detailForm" visible="true"/></td>
</tr>
<tr class="DBForm_Layout_Tr">
  <td >GROUP_ACC_ID:</td>  <td><ai:dbformfield fieldname="GROUP_ACC_ID" formid="detailForm" visible="true"/></td>
  <td >CONTACT_CARD_TYPE:</td>  <td><ai:dbformfield fieldname="CONTACT_CARD_TYPE" formid="detailForm" visible="true"/></td>
</tr>
<tr class="DBForm_Layout_Tr">
  <td >CONTACT_NAME:</td>  <td><ai:dbformfield fieldname="CONTACT_NAME" formid="detailForm" visible="true"/></td>
  <td >CONTACT_PERSON:</td>  <td><ai:dbformfield fieldname="CONTACT_PERSON" formid="detailForm" visible="true"/></td>
</tr>
<tr class="DBForm_Layout_Tr">
  <td >GROUP_ID:</td>  <td><ai:dbformfield fieldname="GROUP_ID" formid="detailForm" visible="true"/></td>
  <td >IS_SEND:</td>  <td><ai:dbformfield fieldname="IS_SEND" formid="detailForm" visible="true"/></td>
</tr>
<tr class="DBForm_Layout_Tr">
  <td >NEED_TO_SEND_MESSAGE:</td>  <td><ai:dbformfield fieldname="NEED_TO_SEND_MESSAGE" formid="detailForm" visible="true"/></td>
</tr>
</table>
</ai:dbform>

</body>
</html>

<script language="javascript">
function init(){
    if(parent.setFrameHeight) {
    	sId = "ID_<%=HttpUtil.getAsString(request, "PAGE_FRAME_PAGE_ID")%>";
        parent.setFrameHeight(sId,document.body.scrollHeight+15);
    }
}
</script>