<%@ page contentType="text/html; charset=gb2312"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title><i18n:message key="sec.getpswd.title" res="i18n.secframe_resource"/></title>
<script src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>
<script src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
<style>
body, td, p, li, th {
    font-family:"Tahoma", "宋体", "Helvetica", "sans-serif";
    font-size: 12px;
    color: #0E0376;
}
</style>
<script language="JavaScript" type="text/javascript">

function getMobile(){
  var loginName = document.all.login_name.value;
  if(loginName==null||loginName==""){
      alert(g_I18NMessage("secframe_getpswd", "loginname_not_null"));
      return;
  }
  document.getElementById("getPasswd_btn").disabled = false;
  
  var strUrl = "<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOperatorAction?action=getMobile";
  strUrl += "&loginName="+loginName;
  
  var msg = PostInfo(strUrl);
  if (msg != null)
  {
	  var mobile = msg.getValueByName("op_mobile");
	  var opId = msg.getValueByName("op_id");
	  document.all.op_mobile.value = (mobile!=null ? mobile :"");
	  document.all.op_id.value = (opId!=null ? opId :"");
  }
}

function getPasswd(){
  var mobile = document.all.op_mobile.value;
  var opId = document.all.op_id.value;
  if(mobile==null||mobile==""){
      alert(g_I18NMessage("secframe_getpswd", "mobilenumber_not_null"));
      return;
  }
  var strUrl = "<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOperatorAction?action=getPassword";
  strUrl += "&opId="+opId;
  
  var msg = PostInfo(strUrl, "");
}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<table width="349" height="184" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" background="../../images/bg.jpg">
	<form name="getPwdForm" action="">
      <table width="310" height="130" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td colspan="3" height="10"><i18n:message key="sec.getpswd.warninginfo" res="i18n.secframe_resource"/></td>
        </tr>
        <tr>
          <td width="150" align="right"><i18n:message key="sec.getpswd.loginname" res="i18n.secframe_resource"/></td>
          <td width="180" height="25">
            <input name="login_name" type="text" value="" size="16" maxlength="20">
          </td>
          <td height="25">
            <ai:button id="getMobile_btn" text="sec.getpswd.getmobilebutton" i18nRes="i18n.secframe_resource" onclick="getMobile()"/>
          </td>
        </tr>
        <tr>
          <td align="right" ><i18n:message key="sec.getpswd.mobilenumber" res="i18n.secframe_resource"/></td>
          <td height="25">
            <input name="op_id" type="hidden" >
            <input name="op_mobile" type="text" size="16" readonly>
          </td>
          <td height="25">
            <ai:button id="getPasswd_btn" text="sec.getpswd.getpasswordbutton" i18nRes="i18n.secframe_resource" onclick="getPasswd()"/>
          </td>
        </tr>
      </table>
	 </form>
    </td>
  </tr>
</table>
</body>
</html>
