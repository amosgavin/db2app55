<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.web.BaseServer"%>
<%@ include file="/secframe/common/getMACIP.html"%>
<%System.out.println(com.ai.appframe2.complex.util.e.U.e("password1")); %>
<html>
<head>
<title>�����ƶ���˾Ӫ������ϵͳ</title>
<style type="text/css">
BODY {font-family:Arial,"����"; background:#ADD7FF url(images/bg.jpg) repeat-x top;font-size:12px; margin: 0;overflow:hidden;}
input { background:#EEEEEE;border-top:1px solid #666666; border-left:1px solid #666666; border-right:1px solid #CCCCCC; border-bottom:1px solid #CCCCCC; height:22px;font-size:12px;}

A:link {color: #1580b0; text-decoration: none;}
A:visited {color: #1580b0; text-decoration: none}
a:active {color: #1580b0; text-decoration: none}
A:hover {color: #000000; text-decoration: none}

#center{text-align:center; width:100%}
.main{ position:relative;top:120px; height:433px; width:698px; background:url(images/denglu.jpg) no-repeat;}
.word{position:absolute;left:403px;top:162px;line-height:30px;text-align:right;color:#333333;}
#UserAccount{ position:absolute;left:455px;top:164px;width:130px;background:#F5F5F5 url(images/icon_03.gif) repeat-x;background-position: 1px 1px;background-repeat:no-repeat;padding-left:20px;height:20px;}
#UserPwd{ position:absolute;left:455px;top:198px;width:130px;background:#F5F5F5 url(images/icon_04.gif);background-position: 1px 1px;background-repeat:no-repeat;padding-left:20px;height:20px;}
#UserVertifyCode{ position:absolute;left:455px;top:228px;width:80px;background-repeat:no-repeat;height:20px;}
#vertifyCodeImg{position:absolute;top:228px;left:535px;}
a.button{position:absolute;background:url(images/button.gif) left top;display:block;width:73px;height:23px;text-align:center;padding:4px 0 0 0;color:#1580b0;}
a#Login{left:415px;top:260px;}
a#Reset{left:500px;top:260px;}
a.button:visited{background-position:left top;color:#1580b0;}
a.button:hover{background-position:right top;color:#666666;}

#chpsw{left:415px;top:309px; position:absolute; color:#1580b0;}
#favorite{left:495px;top:309px; position:absolute; color:#1580b0;}
.copyright{left:140px; bottom:80px; position:absolute;}
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
 function showSaleDetailInfo(){
    url = "<%=request.getContextPath()%>"+"/Ssologin.jsp"+"?"+"USERID=liuls";
        window.open(url, null, "height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}

 showSaleDetailInfo();

</SCRIPT>
</head>

<body>

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
 	document.getElementById("fav").href="javascript:window.external.addFavorite(location.href,'�й��ƶ����Ϲ�˾BOSS3.0ϵͳ');";
  	document.getElementById("fav").innerText="�ղؼ�";
  	document.getElementById("fav").target="";
  	document.getElementById("fav").title="��ӵ��ղؼ�";
 	}
 }
 if (top.location != location){
  		document.getElementById("loginSystem").remove(0);
  		document.getElementById("loginSystem").remove(1);
  		document.getElementById("fav").href="javascript:window.external.addFavorite(location.href,'�й��ƶ����Ϲ�˾BOSS3.0ϵͳ');";
  		document.getElementById("fav").innerText="�ղؼ�";
  		document.getElementById("fav").target="";
  		document.getElementById("fav").title="��ӵ��ղؼ�";
<%--  		document.getElementById("fav").href="ftp://kfdoc:doc_1206@10.87.32.113";--%>
<%--//  		document.getElementById("fav").innerHTML="<font color='red'>��Ҫ֪ͨ</font>";--%>
<%--  		document.getElementById("fav").target="_blank";--%>
<%-- // 		document.getElementById("fav").title="��Ҫ֪ͨ";--%>
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
