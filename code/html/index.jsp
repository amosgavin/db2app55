<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.web.BaseServer"%>
<%@ include file="/secframe/common/getMACIP.html"%>
  <%
  //System.out.println(com.ai.appframe2.complex.util.e.U.e("password1")); 
  %>  
<html>
<head>
<title>�����ƶ���˾Ӫ������ϵͳ</title>
<style type="text/css">
BODY {font-family:Arial,"����"; background:#f1f6fe url(images/bg.jpg) repeat-x top middle;font-size:12px; margin: 0;overflow:hidden;}
input { background:#ffffff;border-top:1px solid #999999; border-left:1px solid #999999; border-right:1px solid #dedede; border-bottom:1px solid #dedede; height:20px;font-size:12px;;padding:2px;}

A:link {color: #666666; text-decoration: none;}
a:active {color: #666666; text-decoration: none}
A:visited {color: #666666; text-decoration: none}
A:hover {color: #999999; text-decoration: none}

#center{text-align:center; width:100%}
.main{ position:relative;top:120px; height:400px; width:700px; background:url(images/denglu.jpg) no-repeat;}
.word{position:absolute;left:403px;top:162px;line-height:30px;text-align:right;color:#333333;white-space: nowrap; word-break: keep-all;}
#UserAccount{ position:absolute;left:455px;top:164px;width:130px;background:#F5F5F5 url(images/icon_03.gif) repeat-x;background-position: 1px 1px;background-repeat:no-repeat;padding-left:20px;height:20px;}
#UserPwd{ position:absolute;left:455px;top:198px;width:130px;background:#F5F5F5 url(images/icon_04.gif);background-position: 1px 1px;background-repeat:no-repeat;padding-left:20px;height:20px;}

#UserVertifyCode{ position:absolute;left:455px;top:228px;width:80px;background:#F5F5F5 url(images/code.gif);background-position: 1px 1px;background-repeat:no-repeat;padding-left:20px;height:20px;}

#vertifyCodeImg{position:absolute;top:228px;left:535px;}
a.button{position:absolute;background:url(images/button.gif) left top;display:block;width:73px;height:23px;text-align:center;padding:4px 0 0 0;color:#1580b0;}
a#Login{left:415px;top:260px;}
a#Reset{left:500px;top:260px;}
a.button:visited{background-position:left top;color:#1580b0;}
a.button:hover{background-position:right top;color:#666666;}

#chpsw{left:415px;top:309px; position:absolute; color:#1580b0;}
#favorite{left:495px;top:309px; position:absolute; color:#1580b0;}
.copyright{left:220px; bottom:31px; position:absolute;white-space: nowrap; word-break: keep-all;}
</style>

<script src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
<script language="JavaScript"
    src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>
<script language="JavaScript"
    src="<%=request.getContextPath()%>/jsv2/CommUtil.js"></script>
    <%
        String param=request.getParameter("param");
     %>
<script language="JavaScript" type="text/JavaScript">
    var MACAddr;
    var IPAddr;
  //��֤��½�Ƿ���ȷ
  var isVertifyCode = true;//�����Ƿ�����֤��У�������;
  //BBOSS�ı�����11
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
<%--      var code = document.all.item("UserAccount").value;--%>
<%--      var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.web.SecFrameAction?action=checkFirstLogin&code="+code, "");--%>
<%--      if (null != msg)--%>
<%--      {--%>
<%--         var retVal = msg.getValueByName("retVal");--%>
<%--         if(retVal != null && retVal == "1" )--%>
<%--         {--%>
<%--           var result = window.showModalDialog("secframe/orgmodel/operator/FirstLoginChangePassword.jsp",--%>
<%--            document.getElementById("UserAccount").value, "scroll:no;resizable:no;status:no;dialogHeight:280px;dialogWidth:380px");--%>
<%--            --%>
<%--           if(result=='undefined'||result==null ||result!='succ')--%>
<%--           {--%>
<%--              alert("�޸�����ʧ��");--%>
<%--              return "failed";--%>
<%--           }--%>
<%--           return "succ";--%>
<%--          }--%>
<%--          else if (retVal != null && retVal == "2" )--%>
<%--          {--%>
<%--              return "succ";--%>
<%--          }--%>
<%--      }--%>
<%--      return "failed";--%>
     return "succ";
  }
  function checkChangePassword()
  {
<%--      var code = document.all.item("UserAccount").value;--%>
<%--      var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.web.SecFrameAction?action=checkChangePassword&code="+code, "");--%>
<%--      if (null != msg)--%>
<%--      {--%>
<%--         var retVal = msg.getValueByName("retVal");--%>
<%--         if(retVal != null && retVal == "1" )--%>
<%--         {--%>
<%--             alert("���������ѿ���ڣ��뾡���޸��������룡");--%>
<%--         }--%>
<%--      }--%>
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

      var acc = document.all.item("UserAccount").value;
      var psw = document.all.item("UserPwd").value;
      if(acc==null||acc==""){
        alert("�������û���");
        document.all.item("UserAccount").focus();
        return;
      }
       if(psw==null||psw==""){
        alert("����������");
        document.all.item("UserPwd").focus();
        return;
      }
      var vertifycode = "";
    if(isVertifyCode){
      vertifycode = new String(document.all.item("UserVertifyCode").value)
    }
    var blank = "   " ;
    if(isVertifyCode && blank.indexOf(vertifycode)!=-1){
      alert("�û�У���벻��Ϊ��");
      document.all.item("UserVertifyCode").focus();
      return;
    }
      var selected = document.getElementById("loginSystem").options[document.getElementById("loginSystem").selectedIndex].value;
      //alert(selected);
      //var parentUrl = window.parent.location.href;
      //alert(window.parent);
      //alert(parentUrl);

      var url = window.location.href;

      var check = url.indexOf("10.96.20.250");

      //�����250��IP��ֱ����ת���ͷ�ϵͳ
      if(selected=="CSP"||check>0){
            //alert(csp_url + "?user_code="+acc+"&user_password="+psw+"&url="+parentUrl);
            //window.parent.location.href = csp_url + "?user_code="+acc+"&user_password="+psw+"&url="+parentUrl;
            //window.location.href = csp_url + "?user_code="+acc+"&user_password="+psw+"&url="+parentUrl;

            if (top.location != location){
                    document.all.item("user_code").value=acc;
                    document.all.item("user_password").value=psw;
                    document.forms(0).action=csp_url;
                    document.forms(0).submit();
                    //window.parent = null;
                    //top.window.opener=null;
                    //top.window.location.href="http://www.baidu.com";
                    //window.close();
            } else {
                    document.all.item("user_code").value=acc;
                    document.all.item("user_password").value=psw;
                    document.forms(0).action=csp_url;
                    document.forms(0).submit();
                //window.open(csp_url + "?user_code="+acc+"&user_password="+psw,"","menubar=no,status=no,resizable=yes,scrollbars=no,toolbar=no,top=0,left=0,width="+ (screen.Width-8)+ ",height=" +(screen.Height-60));
                //window.opener = null;
                //window.close();
            }
            return false;

      } else if(selected=="CBOSS"){
                    document.all.item("login_user").value=acc;
                    document.all.item("login_password").value=psw;
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
   * �û���¼
   * @return
   */
  function Login(){
    if(selectSystem())//�������ϵͳ
    {
    var blank = "                                      ";
    var acc = new String(document.all.item("UserAccount").value);
    var psw = new String(document.all.item("UserPwd").value);
    var vertifycode = "";
    if(isVertifyCode){
      vertifycode = new String(document.all.item("UserVertifyCode").value)
    }
    if(blank.indexOf(acc) != -1 || blank.indexOf(psw) != -1){
      alert("�û��������벻��Ϊ��");
      return;
    }
    if(isVertifyCode && blank.indexOf(vertifycode)!=-1){
      alert("�û�У���벻��Ϊ��");
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
      alert('��½ʧ�ܣ�');
      return;
    }
    //alert(ud.getValueByName("LOGIN_FLAG"));
    if (ud.getValueByName("LOGIN_FLAG") == "Y"){ //��¼�ɹ�
       var SUCCESS_MESSAGE = ud.getValueByName("SUCCESS_MESSAGE");
       if(SUCCESS_MESSAGE!=null && SUCCESS_MESSAGE!=''){
          alert(SUCCESS_MESSAGE);
       }
         var mySrc = ud.getValueByName("MESSAGE");
         //openWin(mySrc);
         //alert(screen.width+" "+screen.height);
       var jumpVar=<%=param%>;
       if(jumpVar=="ZZXH"){     //������תʹ��
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
        alert("ϵͳ���õ����룬�ڵ�һ��½���޸�����");
        changePassword();
        return;
    }
    else
    {//��¼ʧ��
      alert(ud.getValueByName("MESSAGE"));
      if(isVertifyCode && document.all.item("vertifyCodeImg")!=null){
    document.all.item("UserVertifyCode").value="";
    document.all.item("vertifyCodeImg").src="<%=request.getContextPath()%>/vertifycodeservlet";
      }
      var xStr = ud.getValueByName("MESSAGE");
      //alert(xStr);
      if(xStr=="���벻��ȷ!")
      {
         document.all.item("UserPwd").value="";
         document.all.item("UserPwd").focus();
        document.all.item("UserPwd").focus();
      }
      else
      {
        document.all.item("UserAccount").value="";
         document.all.item("UserPwd").value="";
         document.all.item("UserAccount").focus();
        document.all.item("UserAccount").focus();
      }
    }
    //alert(loginRe) ;
    }

   }

   /**
    * ȡ����¼
    * @return
    */
   function CancleLogin()
   {
     top.close();
   }
    /**
    * ��������
    * @return
    */
   function Reset()
   {
      document.all.item("UserAccount").value="";
      document.all.item("UserPwd").value="";
      document.all.item("UserAccount").focus();

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
<form action="#" target="_self" id="forcsp" name="forcsp" method="post">
<input type="hidden" id="user_code" name="user_code"/>
<input id="user_password" type="hidden" name="user_password"/>
<input type="hidden" id="login_user" name="login_user"/>
<input id="login_password" type="hidden" name="login_password"/></form>

<div id="center">
  <div class="main">
    <div class="word"> �û�����<br>
      ���룺<br>
       ��֤�룺</div>
    <input type="text" id="UserAccount" onKeyPress="JumpByEnter(UserPwd)" value=""/>
    <input type="password" id="UserPwd" onKeyPress="IsEnterKeyPress()" value=""/>
    <div style="display: block"><input type="text" id="UserVertifyCode" onKeyPress="IsEnterKeyPress()" value="123"/>
    <image id="vertifyCodeImg" src="<%=request.getContextPath()%>/vertifycodeservlet" width="50" height="20" align="absmiddle" ></div>
    <a href="#" id="Login" onClick="Login()" name="Submit" class="button"><img src="images/icon_05.gif" align="absmiddle" border="0">&nbsp;�� ¼</a> <a href="#" id="Reset" onClick="Reset()" name="Submit2" class="button"><img src="images/icon_06.gif" align="absmiddle" border="0">&nbsp;�� ��</a>
    <div id="chpsw"><img src="images/chpsw.gif" align="absmiddle">&nbsp;<a href="#" onClick="changePassword()" title="�޸ĵ�¼����">�޸�����</a></div>
    <div id="favorite"><img src="images/icon_02.gif" align="absmiddle">&nbsp;<a href="javascript:window.external.addFavorite(location.href,'Ӫ���ʷѹ���ƽ̨');" title="��ӵ��ղؼ�">�����ղؼ�</a></div>
    <div class="copyright">���Ŵ����Ƽ����й����ṩ����֧��</div>
  </div>
</div>
<div style="display:none">��&nbsp;&nbsp;�ڣ�<select onchange="changeSys(this.value)" id="loginSystem" name="loginSystem"  style="width:130px;">
             <option VALUE="BOSS" selected>Ӫҵϵͳ</option>
             <option VALUE="CSP">�ͷ�ϵͳ</option>
             <option VALUE="CBOSS">CBOSSϵͳ</option>
           </select></div>
 
</body>
<script language="JavaScript">
 function judgeTime()
 {
     //�Աȿͻ���ʱ���������ʱ��,������һ��,������ʾ
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
             alert("�û��ͻ���ʱ�����ȷ�����ʱ��24Сʱ����.���Ӧ��ϵͳ�����Ӱ��.��ͻ�����ʹ�ͻ��ˣ�������ʱ�䱣��һ��.��ǰ������ʱ�䣺"+serverDateTime);
           }
    }
 }

 judgeTime();
 document.all.item("UserAccount").focus();
 document.all.item("UserAccount").focus();

 //�޸�����
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
    //document.getElementById("fav").innerHTML="<font color='red'>��Ҫ֪ͨ</font>";
    //document.getElementById("fav").target="_blank";
    //document.getElementById("fav").title="��Ҫ֪ͨ";

    } else{
    document.getElementById("cspdown").style.visibility="hidden";
    document.getElementById("cspdownimg").style.visibility="hidden";
    document.getElementById("fav").href="javascript:window.external.addFavorite(location.href,'�й��ƶ�������˾BOSS3.0ϵͳ');";
    document.getElementById("fav").innerText="�ղؼ�";
    document.getElementById("fav").target="";
    document.getElementById("fav").title="��ӵ��ղؼ�";
    }
 }
 if (top.location != location){
        document.getElementById("loginSystem").remove(0);
        document.getElementById("loginSystem").remove(1);
        document.getElementById("fav").href="javascript:window.external.addFavorite(location.href,'�й��ƶ�������˾BOSS3.0ϵͳ');";
        document.getElementById("fav").innerText="�ղؼ�";
        document.getElementById("fav").target="";
        document.getElementById("fav").title="��ӵ��ղؼ�";
<%--        document.getElementById("fav").href="ftp://kfdoc:doc_1206@10.87.32.113";--%>
<%--//          document.getElementById("fav").innerHTML="<font color='red'>��Ҫ֪ͨ</font>";--%>
<%--        document.getElementById("fav").target="_blank";--%>
<%-- //         document.getElementById("fav").title="��Ҫ֪ͨ";--%>
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
    document.all.item("UserVertifyCode").value="";
    document.all.item("vertifyCodeImg").src="<%=request.getContextPath()%>/vertifycodeservlet";
<%} else {
session.setAttribute( BaseServer.WBS_VERTIFY_CODE_ATTR, co );
%>
document.all.item("UserVertifyCode").value="<%=co%>";
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
        // alert("ϵͳ��⵽��������������в����ϵ�½Ҫ������ݡ�ע�������������վ�㰲ȫ����");
    }
</script>
<script type="text/javascript">
/*
try{
    var url = window.location.href;
    var check = url.indexOf("10.96.20.250");
    if(check==-1){//�ͷ��Ļ���������֧��һ������ֻ�ܵ�½һ�����ͷ�ϵͳ�Լ��ؼ��п���
        try{
            var fso=new ActiveXObject("Scripting.FileSystemObject");
            try{
                var a=fso.CreateTextFile("c:\\boss30.lck",true);
                a.WriteLine("Locked!");
            }catch(err1){
                alert("��ϵͳ��֧���ظ�����,�����ڻ��Զ��ر�!");
                window.opener=null;
                window.close();
                }
            }catch(err){
                if(confirm("���ڵ������ؿ�����IE��ȫ�����ļ���Ȼ��򿪸��ļ���˫��ִ��ie_sec.reg�ļ���Ȼ�����´�ҳ��")){
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
