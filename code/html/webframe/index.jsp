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
<title>�����ƶ���˾Ӫ������ƽ̨</title>
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
   String welcome = "��ӭ"+staffName+"��½ϵͳ";

   boolean isAllowChPass = SessionManager.getUser().isAllowChPassword();
   String isAllowChPassStr = "Y";
   if(!isAllowChPass)
   {
     isAllowChPassStr = "N";
   }
    String announceInfo = AnnounceInfoAction.getCurrentAnnounceInfo(request,response);
%>
<script language="JavaScript1.2">
//����marquee�Ŀ�� (in pixels)
var marqueewidth=900
//����marquee�ĸ߶� (in pixels, �ò���ֻ������NS)
var marqueeheight=20
//����marquee�������ٶ�(��ֵ���ٶȿ�)
var speed=4
//����marquee��ʾ���ݣ�ʹ�ñ�׼��HTML�﷨��
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
					<a href="#nogo" onClick="Logout()">ע��
					</a>&nbsp;|&nbsp;
					<a href="#nogo" onClick="">����
					</a>
                    <ilayer width=&{marqueewidth}; height=&{marqueeheight}; name="cmarquee01"> 
                    <layer name="cmarquee02"></layer>
                    </ilayer>					
				</div>

			</div>
			<div id="right_top">
				<%--��ʱ�����޸����빦�ܣ�ͳһ��SSO���޸�����<a href="#nogo" onClick="chpassword()"><i18n:message key="SES0005011" res="CRM"></i18n:message></a>--%>
				&nbsp;&nbsp;
				<a href="#nogo" onClick="proxy()">����
				</a>&nbsp;|&nbsp;
				<a href="#nogo" onClick="openMain('<%=request.getContextPath()%>/main3/right.jsp')">����̨
				</a>&nbsp;|&nbsp;
				<a href="#nogo" onClick="chpassword()">�޸�����
				</a>
				
				
				 &nbsp<a href="#nogo" onClick="openMain('myset.jsp')">��������</a>
				
				
				<%-- 
				<a href="#nogo" onClick="personalset()">��������
				</a>&nbsp;|&nbsp;
				<a href="#nogo" onClick="changestation()">�л���֯
				</a>&nbsp;|&nbsp;
				<a href="#nogo" onClick="">�����֤--%>
				</a>
				<br>
			</div>
		</div>
<div id="top01" class="group"  style="display: none;">
<div class="top01bg">
     <div class="logo"></div>
     <div class="top_right">
     <img src="images/icon/mini002.gif" width="16" height="16" border="0"  />&nbsp<a href="#" onClick="proxy()">����</a>
     <img src="images/icon/mini076.gif" width="16" height="16" border="0"  />&nbsp<a href="#" onClick="openMain('<%=request.getContextPath()%>/main3/right.jsp')">����̨</a>
     <%--<img src="images/top_01.gif" width="16" height="16" border="0"  />&nbsp<a href="#" onClick="openMain('open.jsp')">չ��ȫ��</a>
     <img src="images/top_02.gif" width="16" height="16" border="0"  />&nbsp<a href="#" onClick="changestation()">��λ�л�</a>
     --%><img src="images/top_05.gif" width="16" height="16" border="0"  />&nbsp<a href="#nogo" onClick="openMain('myset.jsp')">��������</a>
     <img src="images/top_03.gif" width="16" height="16" border="0"  />&nbsp<a href="#" onClick="chpassword()">�޸�����</a>
     <img src="images/top_04.gif" width="16" height="16" border="0"  />&nbsp<a href="#" onClick="Logout()">�˳�ϵͳ</a></div>
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

/*ע����ǰ�û�*/
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
     if (ud.getValueByName("LOGIN_FLAG") == "Y"){ //ע���ɹ�
	top.location = ud.getValueByName("MESSAGE");
      }
     else{//ע��ʧ��
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
	  alert("��ǰԱ�����޸����������Ȩ��");
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
 		   alert("�л���λ�ɹ���");
 		}
 		else if(-3 == retVal)
 		{
 		   alert("�л���λѡ��ʧ�ܣ�");
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