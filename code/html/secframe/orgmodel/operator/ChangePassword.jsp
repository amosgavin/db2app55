<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title><i18n:message key="changepassword.updatepwd" res="i18n.secframe_resource"/></title>
    <script src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>
    <script src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
  </head>
  <body onload="initCode()">
    <ai:contractframe id="" contenttype="table" title="changepassword.updatepwd" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>		
            <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">   	
    	<tr>
    		<td class="td_font">
				<i18n:message key="changepassword.code" res="i18n.secframe_resource"/>：
			</td>
			<td class="td_font">
				<input type="text" id="code" size="19" readonly>
			</td>
    	</tr>
  		<tr>
			<td class="td_font">
				<i18n:message key="changepassword.oldpwd" res="i18n.secframe_resource"/>：
			</td>
			<td class="td_font">
				<input type="password" id="oldPass" size="20">
			</td>
		</tr>
		<tr>
			<td class="td_font">
				<i18n:message key="changepassword.newpwd" res="i18n.secframe_resource"/>：
			</td>
			<td class="td_font">
				<input type="password" id="newPwd" size="20">
			</td>
		</tr>
		<tr>
			<td class="td_font">
				<i18n:message key="changepassword.confirmpwd" res="i18n.secframe_resource"/>：
			</td>
			<td class="td_font">
				<input type="password" id="newPwdConfirm" size="20">
			<td>
		</tr>
    	 </table>
    	</ai:contractframe>
			<div class="area_button">
					<ai:button text="changepassword.confirm" i18nRes="i18n.secframe_resource" onclick="changePass()"/>
					&nbsp;
					<ai:button text="changepassword.reset" i18nRes="i18n.secframe_resource" onclick="reset()"/>
					&nbsp;
					<ai:button text="changepassword.cancel" i18nRes="i18n.secframe_resource" onclick="cancel()"/>
			</div>
			
       
   
</body>
    <script type="text/javascript">
    function initCode()
    {
   	   document.getElementById("code").value = window.dialogArguments;
    }	
    
    function changePass()
    {
    	var psw = document.getElementById("newPwd").value;
	    var pswConfirm = document.getElementById("newPwdConfirm").value;
	    var code = document.getElementById("code").value;
	    var old = document.getElementById("oldPass").value;
    	if(verify() != 1)
    	{
    		return;
    	}
    	var param = "&code="+code+"&old="+old+"&password="+psw;
	    var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOperatorAction?action=setPasswordByCode"+param, "");
	    if(msg != null)
	    {
	    	var retVal = msg.getValueByName("retVal");
		    if(retVal != null && retVal == "1" )
		    {
		      	alert(g_I18NMessage("secframe_changepassword", "secframe_changepassword_updatesucc"));
		      	cancel();
		    }
		    else
		    {
		    	alert(msg.getValueByName("retMsg"));
		    }
	    }
    }
   
	function verify()
	{
		var psw = document.getElementById("newPwd").value;
	    var pswConfirm = document.getElementById("newPwdConfirm").value;
	    var code = document.getElementById("code").value;
	    var old = document.getElementById("oldPass").value;
	    if(code == "")
	    {
	    	alert(g_I18NMessage("secframe_changepassword","secframe_changepassword_codenotnull"));
	    	document.getElementById("code").focus();
	    	return 0;
	    }
	    if(old == "")
	    {
	    	alert(g_I18NMessage("secframe_changepassword","secframe_changepassword_oldpwdnotnull"));
	    	document.getElementById("oldPass").focus();
	    	return 0;
	    }
	    if(old == psw)
	    {
	        alert(g_I18NMessage("secframe_changepassword","secframe_changepassword_newpwdnotold"));
	    	document.getElementById("oldPass").focus();
	    	return 0;
	    }
		if(psw.length <= 0|| pswConfirm.length <= 0)
		{
	      alert(g_I18NMessage("secframe_changepassword","secframe_changepassword_newpwdnotnull"));
	      return 0;
	    }
		if(psw.length > 12)
		{
		  alert(g_I18NMessage("secframe_changepassword","secframe_changepassword_pwdlength"));
		  return 0;
		}
		if(psw.indexOf(" ") >= 0 || psw.indexOf("&") >= 0 || psw.indexOf("^") >= 0)
		{
		  alert(g_I18NMessage("secframe_changepassword","secframe_changepassword_pwdcondition"));
		  return 0;
		}
		// 密码必须是字母和数字组合
		if(psw.length < 6)
		{
		  alert(g_I18NMessage("secframe_changepassword","secframe_changepassword_list6bit"));
		  return 0;
		}
		var tempStr = '';
		var bNum = false;
		var bStr = false;
		var bUpperStr = false;
		for(var i=0; i < psw.length; i++)
		{
			tempStr = psw.charAt(i);
			if(!isNaN(tempStr))
			{
				bNum = true;
			}
			if(/^[a-z]$/.test(tempStr))
			{
				bStr = true;
			}
			if(/^[A-Z]$/.test(tempStr))
			{
				bUpperStr = true;
			}
		}
		if(bNum != true || bStr != true || bUpperStr != true)
		{
		  alert(g_I18NMessage("secframe_changepassword","secframe_changepassword_pwdup"));
		  document.getElementById("newPwd").focus();
		  return 0;
		}
		if(psw != pswConfirm)
	    {
	      alert(g_I18NMessage("secframe_changepassword","secframe_changepassword"));
	      return 0;
	    }
	    return 1;
	}   	
    function reset()
    {
    	document.getElementById("newPwd").value = "";
	    document.getElementById("newPwdConfirm").value = "";
	    document.getElementById("code").value = "";
	    document.getElementById("oldPass").value = "";
    }
 
    function cancel()
    {
		window.self.close();    
    }
    
  </script>  
</html>