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
      //��ǰ�����������δ����������Ϣ��
  	 out.println(CrmLocaleFactory.getResource("BES0000882"));
  	 return;
  }
    //��̨��������ͼ
   String title=CrmLocaleFactory.getResource("BES0000046");
    // ����޷�����ͼƬ�������鿴����
    String nonPictTitle=CrmLocaleFactory.getResource("BES0000883");
    // �������ͼ�޷���ʾ������Ҫ��װ��������ʾ����ͼ��
    String workflowPictNotDispTitle=CrmLocaleFactory.getResource("BES0000884");
    // ��������
    String leftKeyTitle= CrmLocaleFactory.getResource("BES0000885");
    // �������
    String clickHereTitle= CrmLocaleFactory.getResource("BES0000886");
    //  SVG��װ�ļ�
    String svgTitle= CrmLocaleFactory.getResource("BES0000887");
    //  ���е����ĶԻ�����ѡ��򿪻��߰�װ���������Զ���װ�����Ļ�����.
    String popupTitle= CrmLocaleFactory.getResource("BES0000888");
    //  ��װ����
    String installTitle= CrmLocaleFactory.getResource("BES0000889");
  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><%=title%></title>

  </head>
  
  <body onload="init()" scroll="yes"> 
  	<div id="graphDiv" align="center" style="height:500"></div>

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
    //PostInfo(url);
	showSVG(url);
}
 
function showSVG(url){
  document.all("graphDiv").innerHTML ="";
	var s = "<embed src='"+url+"' type='image/svg-xml' width='650' height='500'>"
                          + "</embed>";
  document.all("graphDiv").innerHTML = s;
}

 
</script>
