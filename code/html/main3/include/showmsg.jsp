<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.asiainfo.task.web.AssignTaskAction"%>
<%@ page import="com.ai.secframe.orgmodel.ivalues.IBOSecStaffValue"%>

<%
IBOSecStaffValue secStaffValue = AssignTaskAction.getOperatorInfo(request,response);
String staffName="";
String billId="";
 if(secStaffValue!=null){
	 staffName = secStaffValue.getStaffName();
	 billId = secStaffValue.getBillId();
 }
%>
<html>
  <head>
    <title>��Ϣ��ʾ</title>
  </head>
  <body onload="">
    <div id='div'><span class="font_red">������Ա����:</span><input type="text" id="staffName" size=10></input><span class="font_red">�ֻ���:</span><input id="billid" type="text" size=18></input></div>
	<div id='div'><span class="font_red">�������:</span><textarea id="approval_opinion" rows="11" cols="75" readonly=readonly></textarea></div>
  </body>
  <script type="text/javascript">
    var obj = window.dialogArguments;
    document.getElementById('approval_opinion').value=obj.name;
    document.getElementById('staffName').value="<%=staffName%>";
    document.getElementById('billid').value="<%=billId%>";
    //document.getElementById('div').readonly=true;
    //document.write("�������:"+obj.name);
  </script>
  
</html>
