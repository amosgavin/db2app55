<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.ai.common.i18n.CrmLocaleFactory" %>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai" %>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp" type="text/javascript"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/jsv2/AppFrameCss.jsp" type="text/css">
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String workflow_id =request.getParameter("workflow_id");
  String template_id = request.getParameter("template_id");
  String task_tag = request.getParameter("workflowCode");
  
  if(task_tag == null || task_tag.equals("")){
  	out.println(CrmLocaleFactory.getResource("BES0000890"));
  	return;
  }
   String title=CrmLocaleFactory.getResource("BES0000517");
    // 如果无法访问图片，请点这查看帮助
    String nonPictTitle=CrmLocaleFactory.getResource("BES0000883");
    // 如果流程图无法显示，您需要安装附件以显示流程图。
    String workflowPictNotDispTitle=CrmLocaleFactory.getResource("BES0000884");
    // 请鼠标左键
    String leftKeyTitle= CrmLocaleFactory.getResource("BES0000885");
    // 点击这里
    String clickHereTitle= CrmLocaleFactory.getResource("BES0000886");
    //  SVG安装文件
    String svgTitle= CrmLocaleFactory.getResource("BES0000887");
    //  如有弹出的对话框，请选择打开或者安装。附件会自动安装到您的机器上.
    String popupTitle= CrmLocaleFactory.getResource("BES0000888");
    //  安装附件
    String installTitle= CrmLocaleFactory.getResource("BES0000889");
  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><%=title%></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body onload="init()" scroll="yes"> 
  	<div id="graphDiv" align="center" style="height='500'"></div>

	<div style="width:100%;text-align:left" id='helpDiv'>
	<a href="javascript:void(0)" onclick="tblInfo.style.display='block';helpDiv.style.display='none'"><%=nonPictTitle%>>> </a>&nbsp;&nbsp;&nbsp;</div>
  	<table id="tblInfo" style="display:none">
  	  <TR><TD class="FormTD">
        <%=workflowPictNotDispTitle%>
      </TD></TR>
    <TR><TD class="FormTD"> <b><%=installTitle%></b><br>
        <span class="pr9"><%=leftKeyTitle%></span><%=clickHereTitle%>:<a href="bce/configtool/SVGView.exe" ><%=svgTitle%></a>
        <%=popupTitle%>
    </TD></TR>
  	</table>
  	
  	
  </body>
</html>
<script type="text/javascript">

 
function init(){
	var workflow_id="<%=workflow_id %>";
	var template_id = "<%=template_id%>";
	var task_tag = "<%=task_tag%>";
	var url = "<%=request.getContextPath()%>/business/com.ai.bce.web.BceFrameAction?";
	url += "action=template2Svg&template_id=-1&task_tag="+task_tag;
 
	showSVG(url);
}
 
function showSVG(url){
  document.all("graphDiv").innerHTML ="";
	var s = "<object type='image/svg+xml' width='650' height='500'>"
                          + "<param name='src' value='" + url + "'/>"
                          + "</object>";
  document.all("graphDiv").innerHTML = s;
}

 
</script>
