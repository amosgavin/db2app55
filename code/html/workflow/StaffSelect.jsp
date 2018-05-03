<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<html>
<head>
  <title><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.StaffSelect8"></i18n:message></title></head>
<body>
<ai:contractframe title="" id="">
<ai:contractitem></ai:contractitem>
<table style="width: 98%;" cellspacing="2" cellpadding="1">
  <tr>
    <td class="td_button">
      <input type="radio" name="radioType" checked="checked">
      <i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.StaffSelect16"></i18n:message>
     </td>
     <td class="td_button">
      <input type="radio" name="radioType">
      <i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.StaffSelect17"></i18n:message>
      </td>
      <td>ID:<input type="text" name="txtId" width="150px"/></td>
  </tr>
  <tr>
    <td colspan="3" class="td_button">
    <ai:button text="comframe.html.workflow.InstVars46" i18nRes="i18n.comframe_resource" id="btnOk" onclick="saveFunc()"/>&nbsp;&nbsp; 
    <ai:button text="comframe.html.workflow.InstVars47" i18nRes="i18n.comframe_resource" id="btnQuit" onclick="cancelFunc()"/>    
    </td>
  </tr>
</table>     
</ai:contractframe>
</body>
</html>

<script type="text/javascript">
function saveFunc(){
  var id = document.all.txtId.value;
  if(id == ""){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_StaffSelect39"));    return;
  }
  var param = new Array(2);
  if(radioType[0].checked){
    param[0] = id;
    param[1] = "-1";
  }
  else{
    param[0] = "-1";
    param[1] = id;
  }
  window.returnValue = param;
  window.close();  
}

function cancelFunc(){
  window.close();
}
</script>