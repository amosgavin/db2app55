<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ai.appframe2.web.BaseServer"%>
<!DOCTYPE html>
<html> 
 <head>
  <title></title>
  <link rel="shortcut icon" href="resources/fc/images/icon/favicon.ico">
  <link href="<%=request.getContextPath()%>/jsv2/login/css/zice.style.css" rel="stylesheet" type="text/css" />
  <link href="<%=request.getContextPath()%>/jsv2/login/css/buttons.css" rel="stylesheet" type="text/css" />
  <link href="<%=request.getContextPath()%>/jsv2/login/css/icon.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jsv2/login/css/tipsy.css" media="all" />
  <style type="text/css">
html {
	background-image: none;
}

label.iPhoneCheckLabelOn span {
	padding-left: 0px
}

#versionBar {
	background-color: #212121;
	position: fixed;
	width: 100%;
	height: 35px;
	bottom: 0;
	left: 0;
	text-align: center;
	line-height: 35px;
	z-index: 11;
	-webkit-box-shadow: black 0px 10px 10px -10px inset;
	-moz-box-shadow: black 0px 10px 10px -10px inset;
	box-shadow: black 0px 10px 10px -10px inset;
}

.copyright {
	text-align: center;
	font-size: 10px;
	color: #CCC;
}

.copyright a {
	color: #A31F1A;
	text-decoration: none
}

#login .logo {
	width: 500px;
	height: 51px;
}
</style>

<script src="<%=request.getContextPath()%>/jsv2/UserData_v2.js" charset="GBK"></script>
<script language="JavaScript"  src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp" charset="GBK"></script>
<script language="JavaScript"  src="<%=request.getContextPath()%>/jsv2/CommUtil.js" charset="GBK"></script>
    <%
        String param=request.getParameter("param");
     %>
<script language="JavaScript" type="text/JavaScript">
	var MACAddr;
	var IPAddr;
  //验证登陆是否正确
  var isVertifyCode = true;//界面是否有验证码校验输入框;
  //BBOSS的编码是11
  var channel_id = "1";

  function UserVerify(account,psw,vertifycode){
    var xml = null;
    //var   WshShell   =new   ActiveXObject("WScript.Shell"); 
    //var windowsLoginName=WshShell.ExpandEnvironmentStrings("%USERNAME%");
    //var computorName=WshShell.ExpandEnvironmentStrings("%COMPUTERNAME%");
    var XMLSender = new ActiveXObject("Microsoft.XMLHTTP");
    IPAddr = '';
    var url = "<%=request.getContextPath()%>/baseserver?CHANNEL_ID=" + channel_id + "&EventID=1&LOGIN_USRNAME="+account+"&LOGIN_PSWD="+psw+"&LOGIN_VERFYCODE="+vertifycode
    	+"&IP_ADDR="+IPAddr+"&MAC_ADDR="+MACAddr+"&windowsLoginName=&computorName=";//hxx add

    XMLSender.Open("POST",url,false);
    XMLSender.setRequestHeader("Content-Type","text/xml; charset=UTF-8");
    XMLSender.send(xml);
    return XMLSender.responseText;
  }
  function checkFirstLogin()
  {
      //var code = document.getElementById("UserAccount").value;
      //var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.web.SecFrameAction?action=checkFirstLogin&code="+code, "");
      //if (null != msg)
      //{
      //   var retVal = msg.getValueByName("retVal");
        // if(retVal != null && retVal == "1" )
	  //   {
	    //   var result = window.showModalDialog("secframe/orgmodel/operator/FirstLoginChangePassword.jsp",
            //document.getElementById("UserAccount").value, "scroll:no;resizable:no;status:no;dialogHeight:280px;dialogWidth:380px");
            
		//   if(result=='undefined'||result==null ||result!='succ')
		//   {
		 //     alert("修改密码失败");
		//	  return "failed";
		 //  }
		  // return "succ";
//          }
  //        else if (retVal != null && retVal == "2" )
    //      {
      //        return "succ";
        //  }
//      }
  //    return "failed";
  }
  function checkChangePassword()
  {
      var code = document.getElementById("UserAccount").value;
      var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.web.SecFrameAction?action=checkChangePassword&code="+code, "");
      if (null != msg)
      {
         var retVal = msg.getValueByName("retVal");
         if(retVal != null && retVal == "1" )
	     {
	         alert("您的密码已快过期，请尽快修改您的密码！");
         }
      }
  }
  
   function selectSystem(){

   	  var csp_url="";
   	  if('<%=request.getParameter("redirect")%>'==''||'<%=request.getParameter("redirect")%>'=='null'){
	  	csp_url="";
	  	}
	  else{
	  		csp_url="";
	  }
	  <%
	  if(request.getParameter("redirect")!=null&&!request.getParameter("redirect").equals("")){
	  	//download ="";
	  }
	  %>

	  var cboss_url = "";

	  var acc = document.getElementById("UserAccount").value;
      var psw = document.getElementById("UserPwd").value;
      if(acc==null||acc==""){
      	alert("请输入工号");
      	document.getElementById("UserAccount").focus();
      	return;
      }
       if(psw==null||psw==""){
      	alert("请输入密码");
      	document.getElementById("UserPwd").focus();
      	return;
      }
      var vertifycode = "";
    if(isVertifyCode){
      vertifycode = "111";//new String(document.getElementById("UserVertifyCode").value)
    }
    var blank = "   " ;
    if(isVertifyCode && blank.indexOf(vertifycode)!=-1){
      alert("用户校验码不能为空");
      document.getElementById("UserVertifyCode").focus();
      return;
    }
	  var selected = ""
	  //alert(selected);
	  //var parentUrl = window.parent.location.href;
	  //alert(window.parent);
	  //alert(parentUrl);

	  var url = window.location.href;

	  var check = url.indexOf("10.96.20.250");

	  //如果是250的IP，直接跳转到客服系统
	  if(selected=="CSP"||check>0){
	  		//alert(csp_url + "?user_code="+acc+"&user_password="+psw+"&url="+parentUrl);
	  		//window.parent.location.href = csp_url + "?user_code="+acc+"&user_password="+psw+"&url="+parentUrl;
	  		//window.location.href = csp_url + "?user_code="+acc+"&user_password="+psw+"&url="+parentUrl;

	  		if (top.location != location){
	  				document.getElementById("user_code").value=acc;
	  				document.getElementById("user_password").value=psw;
	  				document.forms(0).action=csp_url;
	  				document.forms(0).submit();
		  			//window.parent = null;
		  			//top.window.opener=null;
	      			//top.window.location.href="http://www.baidu.com";
	      			//window.close();
	  		} else {
	  				document.getElementById("user_code").value=acc;
	  				document.getElementById("user_password").value=psw;
	  				document.forms(0).action=csp_url;
	  				document.forms(0).submit();
		  		//window.open(csp_url + "?user_code="+acc+"&user_password="+psw,"","menubar=no,status=no,resizable=yes,scrollbars=no,toolbar=no,top=0,left=0,width="+ (screen.Width-8)+ ",height=" +(screen.Height-60));
		  		//window.opener = null;
	     		//window.close();
	     	}
	  		return false;

	  } else if(selected=="CBOSS"){
	  				document.getElementById("login_user").value=acc;
	  				document.getElementById("login_password").value=psw;
	  				cboss_url = cboss_url + "?action=login&login_source=0";
	  				document.forms(0).action=cboss_url;
	  				document.forms(0).submit();
	  		//window.open(cboss_url + "?login_user="+acc+"&login_password="+psw + "&action=login&login_source=0","","menubar=no,status=no,resizable=yes,scrollbars=no,toolbar=no,top=0,left=0,width="+ (screen.Width-8)+ ",height=" +(screen.Height-60));
	  		//window.opener = null;
     		//window.close();
     		return false;
	  }
	  return true;
  }


  /**
   * 用户登录
   * @return
   */
  function _Login(){
  	if(selectSystem())//跳到别的系统
  	{
  	var blank = "                                      ";
    var acc = new String(document.getElementById("UserAccount").value);
    var psw = new String(document.getElementById("UserPwd").value);
    var vertifycode = "";
    if(isVertifyCode){
      vertifycode = "111";//new String(document.getElementById("UserVertifyCode").value)
    }
    if(blank.indexOf(acc) != -1 || blank.indexOf(psw) != -1){
      alert("用户名，密码不能为空");
      return;
    }
    //if(acc != "maoxinping"){
    //  alert("请通过4A登录本系统");
    //  return;
    //}
    if(isVertifyCode && blank.indexOf(vertifycode)!=-1){
      alert("用户校验码不能为空");
      return;
    }
    var loginRe = UserVerify(acc,psw,vertifycode);

    //alert("loginRe="+loginRe);
    var xml= new ActiveXObject("Msxml.DOMDocument");
    xml.async = false;
    var bload = xml.loadXML(loginRe);
    //alert(bload);
    var xmlNode = xml.documentElement;
    var ud = createUserDataClass(xmlNode);

    if(ud==null){
      alert('登陆失败！');
      return;
    }
    //alert(ud.getValueByName("LOGIN_FLAG"));
    if (ud.getValueByName("LOGIN_FLAG") == "Y"){ //登录成功
       var SUCCESS_MESSAGE = ud.getValueByName("SUCCESS_MESSAGE");
       if(SUCCESS_MESSAGE!=null && SUCCESS_MESSAGE!=''){
          alert(SUCCESS_MESSAGE);
       }
	     var mySrc = ud.getValueByName("MESSAGE");
	     //openWin(mySrc);
	     //alert(screen.width+" "+screen.height);
	   var jumpVar=<%=param%>;
	   if(jumpVar=="ZZXH"){		//进行跳转使用
	  	    window.open("../boss/res/phone/SelfSelPhoneDir.jsp","","menubar=no,status=no,resizable=yes,scrollbars=no,toolbar=no,top=0,left=0,width=1004,height=600");
	    }else{
	        var checkResult = checkFirstLogin();
	        if (null != checkResult && checkResult =="failed" )
	        {
	            return;
	        }
	        checkChangePassword();
	    	window.open (ud.getValueByName("MESSAGE"),"","menubar=no,status=no,resizable=yes,scrollbars=no,toolbar=no,top=0,left=0,width=1004,height=600");
	   		//window.opener = null;
	   		window.open('','_parent','');
	   		
	     	window.close();
	    }

    }
    else if(ud.getValueByName("MESSAGE")=="CHANGE_PASS")
    {
    	alert("系统重置的密码，在第一登陆请修改密码");
    	changePassword();
    	return;
    }
    else
    {//登录失败
      alert(ud.getValueByName("MESSAGE"));
      if(isVertifyCode && document.getElementById("vertifyCodeImg")!=null){
	document.getElementById("UserVertifyCode").value="";
	document.getElementById("vertifyCodeImg").src="<%=request.getContextPath()%>/vertifycodeservlet";
      }
      var xStr = ud.getValueByName("MESSAGE");
	  //alert(xStr);
	  if(xStr=="密码不正确!")
	  {
	     document.getElementById("UserPwd").value="";
		 document.getElementById("UserPwd").focus();
	 	document.getElementById("UserPwd").focus();
	  }
	  else
	  {
	 	document.getElementById("UserAccount").value="";
		 document.getElementById("UserPwd").value="";
	     document.getElementById("UserAccount").focus();
	 	document.getElementById("UserAccount").focus();
      }
    }
    //alert(loginRe) ;
  	}

   }

   /**
    * 取消登录
    * @return
    */
   function CancleLogin()
   {
     top.close();
   }
    /**
    * 输入重置
    * @return
    */
   function Reset()
   {
      document.getElementById("UserAccount").value="";
      document.getElementById("UserPwd").value="";
      document.getElementById("UserAccount").focus();

   }

   function JumpByEnter(NextElement){
     var lKeyCode = (navigator.appname=="Netscape")?event.which:window.event.keyCode;
     if ( lKeyCode == 13 ){

	   NextElement.focus();
     }
   }

   function IsEnterKeyPress(){
     var lKeyCode = (navigator.appname=="Netscape")?event.which:event.keyCode;
     if ( lKeyCode == 13 ){
       Login();
     }
     else
       return false;
   }



function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

//-->
</script>
<SCRIPT LANGUAGE="VBScript">


function openWin(myScr)
  window.open myScr,vbNull,"menubar=no,resizable=1,status=no,scrollbars=0,top=0,left=0,width=" & screen.Width - 10  & ",height=" & screen.Height - 57

  if not (window.opener is null) then
     window.opener = null
     window.close()
  end if

end function

</SCRIPT>

 </head>
 <body>
  <div id="alertMessage"></div>
  <div id="successLogin"></div>
  <div class="text_success">
   <img src="<%=request.getContextPath()%>/jsv2/login/images/loader_green.gif" alt="Please wait" />
   <span>登陆成功!请稍后....</span>
  </div>
  <div id="login">
   <div class="ribbon" style="background-image:url(<%=request.getContextPath()%>/jsv2/login/images/typelogin.png);"></div>
   <div class="inner">
    <div class="logo">
     <img src="<%=request.getContextPath()%>/jsv2/login/images/toplogo-jeecg.png"/>
    </div>
    <div class="formLogin">
     <form name="formLogin" id="formLogin" action="loginController.do?login" check="loginController.do?checkuser" method="post">
      <input name="userKey" type="hidden" id="userKey" value="D1B5CC2FE46C4CC983C073BCA897935608D926CD32992B5900"/>
      <div class="tip">
       <input class="userName" name="UserAccount" type="text" id="UserAccount" title="用户名" iscookie="true" value=""  nullmsg="请输入用户名!"/>
      </div>
      <div class="tip">
       <input class="password" name="UserPwd" type="password" id="UserPwd" title="密码" value="" nullmsg="请输入密码!"/>
      </div>
      <div class="loginButton">
       <div style="float: left; margin-left: -9px;">
        <input type="checkbox" id="on_off" name="remember" checked="ture" class="on_off_checkbox" value="0" />
        <span class="f_help">是否记住用户名 ?</span>
       </div>
       <div style="float: right; padding: 3px 0; margin-right: -12px;">
        <div>
         <ul class="uibutton-group">
          <li>
          <div style="display: none"><input type="text" id="UserVertifyCode" onKeyPress="IsEnterKeyPress()" value=""/>
    <image id="vertifyCodeImg" src="<%=request.getContextPath()%>/vertifycodeservlet" width="50" height="20" align="absmiddle" ></div>
           <a class="uibutton normal" href="#"  onClick="" id="but_login">登陆</a>
          </li>
          <li>
           <a class="uibutton normal" href="#" id="forgetpass">重置</a>
          </li>
         </ul>
        </div>
       </div>
       <div class="clear"></div>
      </div>
     </form>
    </div>
   </div>
   <div class="shadow"></div>
  </div>
  <!--Login div-->
  <div class="clear"></div>
  <div id="versionBar">
   <div class="copyright">
    <!--  &copy; 版权所有 -->
    <span class="tip"><a href="#" title=""></a> (推荐使用IE8+可以获得更快,更安全的页面响应速度)</span>
   </div>
  </div>
    <!-- Link JScript-->
  <script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/jquery/jquery-1.8.3.min.js" charset="utf-8"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/jquery/jquery.cookie.js" charset="utf-8"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/login/js/jquery-jrumble.js" charset="utf-8"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/login/js/jquery.tipsy.js" charset="utf-8"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/login/js/iphone.check.js" charset="utf-8"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/login/js/login.js" charset="utf-8"></script>
 </body>
 <script language="JavaScript">
 function judgeTime()
 {
     //对比客户机时间与服务器时间,如相差超过一天,进行提示
	 var curDateObj = new Date();
   var serverDateTime = null;
   try{
	   var serverDateTime = g_GetSysDateTime();
   }catch(e){
    return;
   }
   if(serverDateTime==null)return;

	 var dateTimeArray = serverDateTime.split(" ");
	 var dateArray = dateTimeArray[0].split("-");
	 var timeArray = dateTimeArray[1].split(":");
	 var serverDateObj = null;

	 if(dateArray.length==3 && timeArray.length == 3)
	 {
		   serverDateObj = new Date(dateArray[0],parseInt(dateArray[1],10)-1,parseInt(dateArray[2],10),timeArray[0],timeArray[1],timeArray[2]);
		   var dyMilli = 1000 * 60 * 60 * 24;
		   var minus = Math.floor((curDateObj.getTime()-serverDateObj.getTime())/ dyMilli);

		   if(minus>=1)
		   {
		     alert("用户客户的时间优先服务器时间24小时以上.会对应用系统会产生影响.请客户调整使客户端，服务器时间保持一致.当前服务器时间："+serverDateTime);
		   }
 	}
 }

 judgeTime();
 document.getElementById("UserAccount").focus();
 document.getElementById("UserAccount").focus();

 //修改密码
 function changePassword(){
  //var flag = 
  window.showModalDialog("secframe/orgmodel/operator/ChangePassword.jsp",
    document.getElementById("UserAccount").value, "scroll:no;resizable:no;status:no;dialogHeight:280px;dialogWidth:380px");

 }
 function changeSys(value){
 	if(value=="CSP"){
	document.getElementById("cspdown").style.visibility="visible";
	document.getElementById("cspdownimg").style.visibility="visible";
	//document.getElementById("fav").href="ftp://kfdoc:doc_1206@10.87.32.113";
 	//document.getElementById("fav").innerHTML="<font color='red'>重要通知</font>";
  	//document.getElementById("fav").target="_blank";
  	//document.getElementById("fav").title="重要通知";

 	} else{
 	document.getElementById("cspdown").style.visibility="hidden";
 	document.getElementById("cspdownimg").style.visibility="hidden";
 	document.getElementById("fav").href="javascript:window.external.addFavorite(location.href,'中国移动河南公司BOSS3.0系统');";
  	document.getElementById("fav").innerText="收藏夹";
  	document.getElementById("fav").target="";
  	document.getElementById("fav").title="添加到收藏夹";
 	}
 }
 if (top.location != location){
  		document.getElementById("loginSystem").remove(0);
  		document.getElementById("loginSystem").remove(1);
  		document.getElementById("fav").href="javascript:window.external.addFavorite(location.href,'中国移动河南公司BOSS3.0系统');";
  		document.getElementById("fav").innerText="收藏夹";
  		document.getElementById("fav").target="";
  		document.getElementById("fav").title="添加到收藏夹";
<%--  		document.getElementById("fav").href="ftp://kfdoc:doc_1206@10.87.32.113";--%>
<%--//  		document.getElementById("fav").innerHTML="<font color='red'>重要通知</font>";--%>
<%--  		document.getElementById("fav").target="_blank";--%>
<%-- // 		document.getElementById("fav").title="重要通知";--%>
  		document.getElementById("cspdown").style.visibility="visible";
		document.getElementById("cspdownimg").style.visibility="visible";
  }
<%
String co = request.getParameter("code");
if(co==null){
co="";
}
%>



<%if(co.equals("")){%>
	document.getElementById("UserVertifyCode").value="";
	document.getElementById("vertifyCodeImg").src="<%=request.getContextPath()%>/vertifycodeservlet";
<%} else {
session.setAttribute( BaseServer.WBS_VERTIFY_CODE_ATTR, co );
%>
document.getElementById("UserVertifyCode").value="<%=co%>";
<%
}
%>


</script>

<script LANGUAGE="JScript">
	try{
		var service = locator.ConnectServer();
		service.Security_.ImpersonationLevel=3;
		service.InstancesOfAsync(foo, 'Win32_NetworkAdapterConfiguration');
	}catch(e){
		// alert("系统检测到您的浏览器设置尚不符合登陆要求，请根据【注意事项】进行信任站点安全设置");
	}
</script>
<script type="text/javascript">
/*
try{
 	var url = window.location.href;
	var check = url.indexOf("10.96.20.250");
	if(check==-1){//客服的机器，不用支持一个电脑只能登陆一个，客服系统自己控件有控制
		try{
			var fso=new ActiveXObject("Scripting.FileSystemObject");
			try{
				var a=fso.CreateTextFile("c:\\boss30.lck",true);
				a.WriteLine("Locked!");
			}catch(err1){
				alert("本系统不支持重复运行,本窗口会自动关闭!");
				window.opener=null;
				window.close();
				}
			}catch(err){
				if(confirm("请在弹出下载框下载IE安全配置文件，然后打开该文件，双击执行ie_sec.reg文件，然后重新打开页面")){
				var msg = "/ie_sec.zip";
				window.open(msg);
			}
		}
	}
} catch(err3){
}
*/
</script>
</html>