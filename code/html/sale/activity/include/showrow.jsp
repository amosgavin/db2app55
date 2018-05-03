<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title>信息提示</title>
  </head>
  <body onload="">
	货品组合名称:<input type="text" id="rowname">
	<input id="queryTag" type="button" value="确定" onclick="queryTagbyCharge()"/>
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
