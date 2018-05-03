<html>
<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.service.ServiceFactory"%>
<%@ page import="com.ai.bce.service.interfaces.IBceFrameSV"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.bce.ivalues.IBceModuleValue"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page import="com.ai.appframe2.web.BaseServer"%>
<%@ page import="com.ai.common.i18n.CrmLocaleFactory"%>

<script src="<%=request.getContextPath()%>/crm/common/CrmJsResource.jsp?v=<%=com.ai.common.util.WebUtil.getJsVersion()%>"></script>

<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath() %>/bce/configtool/charts/FusionCharts.js"></script>
<script src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
<title><%=LocaleResourceFactory.getResource("BES0000876") %></title>
<style>
BODY {font-family:Arial,"<%=LocaleResourceFactory.getResource("BES0000877") %>"; background:#77b6db url(common/images/bg.jpg) repeat-x top;font-size:12px; margin: 0;overflow:hidden;}
input { background:#EEEEEE;border-top:1px solid #666666; border-left:1px solid #666666; border-right:1px solid #CCCCCC; border-bottom:1px solid #CCCCCC; height:22px;font-size:12px;}

a.top:link {color: #0082d7; text-decoration: none;}
a.top:visited {color: #0082d7; text-decoration: none}
a.top:active {color: #0082d7; text-decoration: none}
a.top:hover {color: #2c94d7; text-decoration: underline}

#center{text-align:center; width:100%}
#main{ position:relative;top:10px;height:590px; width:950px; background:url(common/images/bce.jpg) no-repeat;}
#main_middle{position:absolute;left:0px;top:115px;padding:0 20px;}
.right_top{ float:right; text-align:right;padding:50px 20px 0 0;color:#0082d7;width:500px;}
.pic{float:left;text-align:left;width:580px;}
.word{float:right;text-align:left;width:310px;}
.title_big{padding-left:90px;font-size:20px;color:#366fbe;font-weight:bold;line-height:76px;}
.content{padding:20px;line-height:30px;color:#666666;font-size:14px;height:150px;}
.right_button{text-align:right;padding:10px;}
.div_over{border:1 solid #FFFFFF;width:120px; height:100px; padding-top:10px;line-height:30px;color:#366fbe;font-size:12px; text-decoration: none;}
.div_over:hover{border:1 solid #bddbe6; background-color:#edf8fc;}
a.button{background:url(common/images/more.gif) left top;display:block;width:140px;height:40px;text-align:left;padding:11px 0 0 35px;color:#FFFFFF;font-weight:bold;font-size:14px; text-decoration: none}
a.button:visited{background-position:left top;color:#FFFFFF; text-decoration: none}
a.button:hover{background-position:left bottom;color:#f8d350; text-decoration: none}
.font_bold{font-weight:bold;}
.copyright{left:265px; bottom:75px; position:absolute; line-height:24px; width:500px; text-align:left;color:#666666;}
</style>
</head>

<% 
request.getSession().setAttribute("VERTIFY_CODE_ATTR","");
%>
<script>

//Login();

function UserVerify(account,psw,vertifycode){
    var xml = null;
    var XMLSender = new ActiveXObject("Microsoft.XMLHTTP");
    IPAddr = '';
    var url = "<%=request.getContextPath()%>/baseserver?CHANNEL_ID=1&EventID=1&LOGIN_USRNAME="+account+"&LOGIN_PSWD="+psw+"&LOGIN_VERFYCODE="
	    +"&IP_ADDR="+IPAddr+"&MAC_ADDR=123456";//hxx add
    XMLSender.Open("POST",url,false);
    XMLSender.setRequestHeader("Content-Type","text/xml; charset=UTF-8");
    XMLSender.send(xml);
    return XMLSender.responseText;
  }

function Login(){
  var acc = "f888888";
  var psw = "password1";
  var loginRe = UserVerify(acc,psw,"");

  var xml= new ActiveXObject("Msxml.DOMDocument");
  xml.async = false;
  var bload = xml.loadXML(loginRe);

  var xmlNode = xml.documentElement;
  var ud = createUserDataClass(xmlNode);
  if(ud==null){
    alert(crm_i18n_msg("BAW1000003"));
    return;
  }
  if (ud.getValueByName("LOGIN_FLAG") == "Y"){ //登录成功

  }
  else {//登录失败
    alert(ud.getValueByName("MESSAGE"));
  }
}
 
function openwindow(module_id,module_name){  
	window.open("<%=request.getContextPath()%>/business/com.ai.bce.configtool.web.ConfVersionAction?action=dispatcherUrl&moduleId="+module_id+"&moduleName="+module_name);
 	//window.open('main.jsp?module_id=' + module_id + '&module_name=' + module_name,"","menubar=no,status=no,resizable=yes,scrollbars=no,toolbar=no,top=0,left=0,width="+ (screen.Width-8)+ ",height=" +(screen.Height-60));
}

function showCharts(moduleId,moduleName){ 
  document.getElementById("title").innerHTML=moduleName;
  var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.bce.configtool.web.ChartAction?action=getXmlStrByModuleId&moduleId="+moduleId);
  if(msg.getValueByName("flag") == 'false'){
  	alert('ERROR!');
  	return;
  }
  var moduleChart = new FusionCharts("<%=request.getContextPath()%>/bce/configtool/charts/Column2D.swf", "moduleChart", "310", "200", "0", "0");
  var xmlStr = msg.getValueByName("xmlStr");
  moduleChart.setDataXML(xmlStr);
  moduleChart.render("moduleChart");
}

function hideCharts(){
	document.getElementById("moduleChart").innerHTML='';
	document.getElementById("title").innerHTML='';
}
</script>

<%
	IBceFrameSV sv =(IBceFrameSV)ServiceFactory.getService(IBceFrameSV.class);
	IBceModuleValue modules[] = sv.getBceModule();
%>
<body>
<div id="center">
<div id="main">
<div class="right_top"><a href="#" class="top"><%=LocaleResourceFactory.getResource("BES0000878") %></a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#" class="top"><%=LocaleResourceFactory.getResource("BES0000879") %></a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="javascript:window.external.addFavorite(location.href,'BCE业务生成环境配置系统');" class="top">加入收藏</a></div>
<div id="main_middle">

<div class="pic">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

<%
	for(int i=0;i<modules.length;i++){
		if(i==0){
			out.println("<tr align='center'>");
		}
		else if(i%4==0 ){
			out.println("</tr>");
			out.println("<tr align='center'>");
		}
%>
		<td><a href="#nogo" class="div_over" onClick="openwindow('<%=modules[i].getModuleId()%>','<%=modules[i].getModuleName()%>')" onmouseover="showCharts('<%=modules[i].getModuleId()%>','<%=modules[i].getModuleName()%>')" onmouseout="hideCharts()">
		<img src="<%=request.getContextPath() +  modules[i].getIconUrl()%>" align="absmiddle" border="0"><br><%=modules[i].getModuleName()%></a></td>
<%
	}
%>
<!--
  <tr align="center">
    <td><a href="#nogo" class="div_over" onClick="openwindow()"><img src="common/images/icon01.gif" align="absmiddle" border="0"><br>公共模块</a></td>
    <td><a href="#nogo" class="div_over" onClick="openwindow()"><img src="common/images/icon02.gif" align="absmiddle" border="0"><br>订单管理</a></td>
    <td><a href="#nogo" class="div_over" onClick="openwindow()"><img src="common/images/icon03.gif" align="absmiddle" border="0"><br>客户管理</a></td>
    <td><a href="#nogo" class="div_over" onClick="openwindow()"><img src="common/images/icon04.gif" align="absmiddle" border="0"><br>资源管理</a></td>
  </tr>
  <tr align="center">
    <td><a href="#nogo" class="div_over" onClick="openwindow()"><img src="common/images/icon05.gif" align="absmiddle" border="0"><br>账务管理</a></td>
    <td><a href="#nogo" class="div_over" onClick="openwindow()"><img src="common/images/icon06.gif" align="absmiddle" border="0"><br>渠道管理</a></td>
    <td><a href="#nogo" class="div_over" onClick="openwindow()"><img src="common/images/icon07.gif" align="absmiddle" border="0"><br>客服管理</a></td>
    <td>&nbsp;</td>
  </tr>
-->
  </table>

</div>
<div class="word">
<div id="title" class="title_big" ></div>

<div  id="moduleChart" style="align:center"></div>
</div>

</div>

<div class="copyright">Copyright &copy; 2005 - 2010 Asiainfo-Linkage<br>
<%=LocaleResourceFactory.getResource("BES0000880") %></div>
</div>
</div>

</body>
</html>
</body>