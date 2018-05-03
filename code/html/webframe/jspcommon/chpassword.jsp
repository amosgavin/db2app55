<%@ include file="/webframe/jspcommon/includedhead.jsp"%>
<%@ page contentType="text/html; charset=GBK" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>密码修改</title>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>
</head>
<script language="JavaScript">
   /**
   * 密码设置
   * @return
   */
  var gParam = dialogArguments;
  var staffCode="";
  if(gParam)
  {
     staffCode=gParam;
  }
  function chPassFunc()
  {
    var oldpsw=  document.all.item("oldUserPwd").value;
    var psw = document.all.item("UserPwd").value;
    var pswConfirm = document.all.item("UserPwdConfirm").value;

	if(oldpsw.length<=0 || psw.length<=0|| pswConfirm.length<=0)
	{
      top.returnValue = false;
      alert("原密码,密码,密码确认不能为空");
      return;
    }
	if(psw.length>8)
	{
	  alert("密码长度不能超过八位");
	  return;
	}
	if(psw.indexOf(" ")>=0 || psw.indexOf("&")>=0)
	{
	  alert("密码中间不允许有空字符或者‘&’字符存在")
	  return;
	}
    //alert("psw="+psw+" cpsw="+pswConfirm+"}");
	if(psw!=pswConfirm)
    {
      alert("两次密码输入不同");
      return;
    }
    var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.frame.loginmgr.webaction.WebFrameAction?action=chPassword&staffCode="+staffCode+"&oldpass="+oldpsw+"&newpass="+psw,"");

    alert(msg.getValueByName("MESSAGE"));
    if(msg.getValueByName("FLAG")=="ERROR"){
	document.all.item("oldUserPwd").value="";
	document.all.item("UserPwd").value="";
	document.all.item("UserPwdConfirm").value="";
	document.all.item("oldUserPwd").focus();

    }
    else
      cancelFunc();
   }

   /**
    * 取消登录
    * @return
    */
   function cancelFunc(){
     top.returnValue=false;
     top.close();
   }

   function JumpByEnter(NextElement){
     var lKeyCode = (navigator.appname=="Netscape")?event.which:event.keyCode;
     if ( lKeyCode == 13 ){
       NextElement.focus();
     }
   }

   function IsEnterKeyPress(){
     var lKeyCode = (navigator.appname=="Netscape")?event.which:event.keyCode;
     if ( lKeyCode == 13 ){
       chPassFunc();
     }
     else
       return false;
   }
</script>
<body class=modeBody>
<span class=modeMenuName style="width:70;left:30;z-index:10;" >密码修改</span>
<form name="LoginForm">
  <table align="center" width="90%" border="0" class=modeContArea>
    <tr><td colspan=2>&nbsp;</td>
   </tr>
 <tr>
	  <td class="FormTDName" width="120">原密码：</td>
     <td><input type="password" id="oldUserPwd" onKeyPress="JumpByEnter(UserPwd)" class="input"></td>
  </tr>
  <tr>
	  <td class="FormTDName" width="120">新设密码：</td>
     <td><input type="password" id="UserPwd" onKeyPress="JumpByEnter(UserPwdConfirm)" class="input"></td>
  </tr>
  <tr>
      <td class="FormTDName" width="120">密码确认：</td>
     <td><input type="password" id="UserPwdConfirm" onKeyPress="IsEnterKeyPress()" class="input"><td>
  </tr>
  <tr><td colspan=2 height="40">
	  <p align="center">
	  <ai:button text="登 录"onclick="chPassFunc()"></ai:button>&nbsp;
	  <ai:button text="重 置"onclick="resetFunc()"></ai:button>&nbsp;
	  <ai:button text="取 消"onclick="cancelFunc()"></ai:button>
	  </p>
      </td>
   </tr>
</table>
 </form>
<p>
</body>
</html>
