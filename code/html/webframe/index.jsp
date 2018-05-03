<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface"%>
<%@ page import="com.ai.appframe2.common.SessionManager"%>
<%@page import="com.ai.secframe.common.Constants"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.common.util.StaticDataUtil" %>
<%@ page import="com.ai.common.ivalues.IBOBsStaticDataValue" %>
<%@ page import="com.asiainfo.sale.common.web.AnnounceInfoAction" %>
<script src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
<html>
<head>
<title>湖北移动公司营销管理平台</title>
</head>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/lightBox.js"></script>
<%
	UserInfoInterface user = SessionManager.getUser();
   String staffName = SessionManager.getUser().getName();
   String staffCode = user.getCode();
   long staffId = user.getID();
   String stationId="0";
   //String stationId = String.valueOf(user	.get(Constants.LOGIN_STATION_ID));
   long operatorId = SessionManager.getUser().getID();
   String code = SessionManager.getUser().getCode();
   String userIp = SessionManager.getUser().getIP();
   String orgName = SessionManager.getUser().getOrgName();
   
   long orgId = SessionManager.getUser().getOrgId();	
   String welcome = "欢迎"+staffName+"登陆系统";

   boolean isAllowChPass = SessionManager.getUser().isAllowChPassword();
   String isAllowChPassStr = "Y";
   if(!isAllowChPass)
   {
     isAllowChPassStr = "N";
   }
    String announceInfo = AnnounceInfoAction.getCurrentAnnounceInfo(request,response);
%>
<script language="JavaScript1.2">
//设置marquee的宽度 (in pixels)
var marqueewidth=900
//设置marquee的高度 (in pixels, 该参数只适用于NS)
var marqueeheight=20
//设置marquee滚动的速度(数值大速度快)
var speed=4
//设置marquee显示内容，使用标准的HTML语法。
var content = "<%=announceInfo%>";
var marqueecontents = "";
if(content!=""){
  marqueecontents='<strong><big><font color="red">'+content+'<font></big></strong></font>';	
}

if (document.all)
document.write('<marquee scrollAmount='+speed+' style="width:'+marqueewidth+'">'+marqueecontents+'</marquee>')
function regenerate(){
window.location.reload()
}
function regenerate2(){
if (document.layers){
setTimeout("window.onresize=regenerate",450)
intializemarquee()
}
}
function intializemarquee(){
document.cmarquee01.document.cmarquee02.document.write('<nobr>'+marqueecontents+'</nobr>')
document.cmarquee01.document.cmarquee02.document.close()
thelength=document.cmarquee01.document.cmarquee02.document.width
scrollit()
}
function scrollit(){
if (document.cmarquee01.document.cmarquee02.left>=thelength*(-1)){
document.cmarquee01.document.cmarquee02.left-=speed
setTimeout("scrollit()",100)
}
else{
document.cmarquee01.document.cmarquee02.left=marqueewidth
scrollit()
}
}
window.onload=regenerate2
</script>

<body onResize="resizewin()" style="overflow:hidden">
<div id="top" style="height: 59px;">
			<div id="logo">
				<div id="down_bar" class="down_bar_out">
					&nbsp;<%=staffCode%>&nbsp;&nbsp;&nbsp;
					<span class="font_bold"><%=staffName%></span>&nbsp;&nbsp;
					<img
						src="<%=request.getContextPath()%>/webframe/images/main/down.gif"
						align="absmiddle"
						title="<i18n:message key="SES0005003" res="CRM"></i18n:message>"
						border="0">
					&nbsp;
					<br>
					&nbsp;
					<i18n:message key="SES0005004" res="CRM"></i18n:message>
					<span class="font_blue"><%=orgName%></span>
					<br>
					&nbsp;
					<i18n:message key="SES0005005" res="CRM"></i18n:message>
					<span class="font_blue"><%=userIp%></span>
					<br>
					<span id="span_srv" style="display: none">&nbsp;<i18n:message
							key="SES0005021" res="CRM"></i18n:message><span class="font_blue"
						id="srv_value"></span>
					<br>
					</span>
					<input type="checkbox" name="checkbox" value="checkbox" />
					<i18n:message key="SES0005006" res="CRM"></i18n:message>
					&nbsp;&nbsp;
					<input type="checkbox" name="checkbox" value="checkbox" />
					<i18n:message key="SES0005007" res="CRM"></i18n:message>
					<br>
				</div>
				<div class="right_bar">
					<a href="#nogo" onClick="openNewWin()">
					</a>&nbsp;
					<a href="#nogo" onClick="Logout()">注销
					</a>&nbsp;|&nbsp;
					<a href="#nogo" onClick="">帮助
					</a>
                    <ilayer width=&{marqueewidth}; height=&{marqueeheight}; name="cmarquee01"> 
                    <layer name="cmarquee02"></layer>
                    </ilayer>					
				</div>

			</div>
			<div id="right_top">
				<%--暂时屏蔽修改密码功能，统一在SSO侧修改密码<a href="#nogo" onClick="chpassword()"><i18n:message key="SES0005011" res="CRM"></i18n:message></a>--%>
				&nbsp;&nbsp;
				<a href="#nogo" onClick="proxy()">代理
				</a>&nbsp;|&nbsp;
				<a href="#nogo" onClick="openMain('<%=request.getContextPath()%>/main3/right.jsp')">工作台
				</a>&nbsp;|&nbsp;
				<a href="#nogo" onClick="chpassword()">修改密码
				</a>
				
				
				 &nbsp<a href="#nogo" onClick="openMain('myset.jsp')">个人设置</a>
				
				
				<%-- 
				<a href="#nogo" onClick="personalset()">个人设置
				</a>&nbsp;|&nbsp;
				<a href="#nogo" onClick="changestation()">切换组织
				</a>&nbsp;|&nbsp;
				<a href="#nogo" onClick="">清除认证--%>
				</a>
				<br>
			</div>
		</div>
<div id="top01" class="group"  style="display: none;">
<div class="top01bg">
     <div class="logo"></div>
     <div class="top_right">
     <img src="images/icon/mini002.gif" width="16" height="16" border="0"  />&nbsp<a href="#" onClick="proxy()">代理</a>
     <img src="images/icon/mini076.gif" width="16" height="16" border="0"  />&nbsp<a href="#" onClick="openMain('<%=request.getContextPath()%>/main3/right.jsp')">工作台</a>
     <%--<img src="images/top_01.gif" width="16" height="16" border="0"  />&nbsp<a href="#" onClick="openMain('open.jsp')">展开全部</a>
     <img src="images/top_02.gif" width="16" height="16" border="0"  />&nbsp<a href="#" onClick="changestation()">岗位切换</a>
     --%><img src="images/top_05.gif" width="16" height="16" border="0"  />&nbsp<a href="#nogo" onClick="openMain('myset.jsp')">个人设置</a>
     <img src="images/top_03.gif" width="16" height="16" border="0"  />&nbsp<a href="#" onClick="chpassword()">修改密码</a>
     <img src="images/top_04.gif" width="16" height="16" border="0"  />&nbsp<a href="#" onClick="Logout()">退出系统</a></div>
<div style="display: none;">
<iframe src="../main3/sessionCheck.jsp" frameborder="0" width="0" height="0" scrolling="auto" ></iframe>
</div>
</div></div>
<div id="main" class="group">
  <div id="left1" class="left" style="width:200px;"><iframe id="leftFrame" src="left.jsp" frameborder="0" width="100%" height="99%" scrolling="no"></iframe></div>
  <div id="right1" class="right"><iframe id="mainFrame" src="../main3/right.jsp" frameborder="0" width="100%" height="100%" scrolling="auto"></iframe></div>
</div>
</body>
</html>


<SCRIPT language=javascript type=text/javascript>
var gSize=true;
function resizewin(){
	if(gSize)
   		document.all.mainFrame.height = document.all.left1.style.height = (document.documentElement.clientHeight|document.body.clientHeight)-75;
	gSize=!gSize;
}
resizewin();

function boxshow(){
	   var msg = "";
       var obj= new Object();
	   //if(msg!=""){
        //window.alert(msg);
        //document.write(msg);
        var url="showmsg.jsp";
        obj.name = msg;
        window.showModalDialog(url, obj, "scroll:yes;resizable:yes;help:no;status:yes;dialogHeight:200px;dialogWidth:400px;unadorned:yes");

}
//boxshow();

function openMain(url){
window.document.getElementById("mainFrame").src = url;
}

/*注销当前用户*/
function Logout()
{
   //closeWindow();
   var xml = null;
   var XMLSender = new ActiveXObject("Microsoft.XMLHTTP");
   var url = "<%=request.getContextPath()%>/baseserver?EventID=2";
   XMLSender.Open("POST",url,false);
   XMLSender.setrequestheader("content-type","application/x-www-form-urlencoded");
   XMLSender.send(xml);
   var reInfo = XMLSender.responseText;
   var xml= new ActiveXObject("Msxml.DOMDocument");
   xml.async = false;
   var bload = xml.loadXML(reInfo);
   var xmlNode = xml.documentElement;
   if(xmlNode.baseName=="LOGIN_OUT")
   {
       top.location="<%=request.getContextPath()%>/index.jsp";
   }
   else
   {
     var ud = createUserDataClass(xmlNode);
     if(ud==null)
	top.location="<%=request.getContextPath()%>/index.jsp";
     if (ud.getValueByName("LOGIN_FLAG") == "Y"){ //注销成功
	top.location = ud.getValueByName("MESSAGE");
      }
     else{//注销失败
	alert(ud.getValueByName("MESSAGE"));
      }
    }

}
function chpassword()
{
    var isAllowPassword ="<%=isAllowChPassStr%>";
    var code = "<%=code%>";  
    if (isAllowPassword == "Y")
	{
      window.showModalDialog("<%=request.getContextPath()%>/secframe/orgmodel/operator/ChangePassword.jsp",code, "scroll:no;resizable:no;status:no;dialogHeight:260px;dialogWidth:380px");
    }
    else
    {
	  alert("当前员工无修改自身密码的权限");
    }
}

function changestation()
{ 
    var result = window.showModalDialog("<%=request.getContextPath()%>/webframe/ChangeStationDialog.jsp","org","scroll:no;resizable:no;status:no;dialogHeight:460px;dialogWidth:400px");
	if(result != 'undefined'||result != null)
	{
        var ud=PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.web.SecFrameAction?action=changeStation&stationId="+result);     
 		var retVal =ud.getValueByName("retVal");
 		if (0 == retVal)
 		{
 		   location.reload();
 		   alert("切换岗位成功！");
 		}
 		else if(-3 == retVal)
 		{
 		   alert("切换岗位选择失败！");
 		}
	}
}
function openNewWin(){
	
}

function personalset()
{
	var userInfo = "<%=staffId%>"+"|"+"<%=stationId%>";
	var result = window.showModalDialog("<%=request.getContextPath()%>/webframe/SelectBsStapleEntityDialog.jsp",userInfo,"scroll:no;resizable:no;status:no;dialogHeight:500px;dialogWidth:300px");
	if(result!="ok")return;   
	else{
		document.frames("leftFrame").frames("outlookFrame").frames("bsStapleEntity").location.reload();
		}   
}
function proxy()
{
    openSelect.proxy();
}
</SCRIPT>