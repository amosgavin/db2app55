<%@ include file="/webframe/jspcommon/includedhead.jsp"%>
<%@ page contentType="text/html; charset=GBK" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�����޸�</title>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>
</head>
<script language="JavaScript">
   /**
   * ��������
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
      alert("ԭ����,����,����ȷ�ϲ���Ϊ��");
      return;
    }
	if(psw.length>8)
	{
	  alert("���볤�Ȳ��ܳ�����λ");
	  return;
	}
	if(psw.indexOf(" ")>=0 || psw.indexOf("&")>=0)
	{
	  alert("�����м䲻�����п��ַ����ߡ�&���ַ�����")
	  return;
	}
    //alert("psw="+psw+" cpsw="+pswConfirm+"}");
	if(psw!=pswConfirm)
    {
      alert("�����������벻ͬ");
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
    * ȡ����¼
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
<span class=modeMenuName style="width:70;left:30;z-index:10;" >�����޸�</span>
<form name="LoginForm">
  <table align="center" width="90%" border="0" class=modeContArea>
    <tr><td colspan=2>&nbsp;</td>
   </tr>
 <tr>
	  <td class="FormTDName" width="120">ԭ���룺</td>
     <td><input type="password" id="oldUserPwd" onKeyPress="JumpByEnter(UserPwd)" class="input"></td>
  </tr>
  <tr>
	  <td class="FormTDName" width="120">�������룺</td>
     <td><input type="password" id="UserPwd" onKeyPress="JumpByEnter(UserPwdConfirm)" class="input"></td>
  </tr>
  <tr>
      <td class="FormTDName" width="120">����ȷ�ϣ�</td>
     <td><input type="password" id="UserPwdConfirm" onKeyPress="IsEnterKeyPress()" class="input"><td>
  </tr>
  <tr><td colspan=2 height="40">
	  <p align="center">
	  <ai:button text="�� ¼"onclick="chPassFunc()"></ai:button>&nbsp;
	  <ai:button text="�� ��"onclick="resetFunc()"></ai:button>&nbsp;
	  <ai:button text="ȡ ��"onclick="cancelFunc()"></ai:button>
	  </p>
      </td>
   </tr>
</table>
 </form>
<p>
</body>
</html>
