<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title>��Ϣ��ʾ</title>
  </head>
  <body onload="">
	��Ʒ�������:<input type="text" id="rowname">
	<input id="queryTag" type="button" value="ȷ��" onclick="queryTagbyCharge()"/>
  </body>
  <script type="text/javascript">
    function queryTagbyCharge(){
    if(document.getElementById('rowname').value!=""){
    window.returnValue =document.getElementById('rowname').value;
    }
    window.close();
    }
  </script>
  
</html>
