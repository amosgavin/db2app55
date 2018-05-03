<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>

<html>
<head>
<title>Url Parameter Setting</title>
</head>
<body onload="init('factor')">
<table>
<tr>
<td>
<textArea id="factor" style="width:400;height:100" ></textArea>
</td>
</tr>
<tr>
<td>
<ai:button text="BES0000321" i18nRes="CRM" onclick="genFac()"/>
</td>
</tr>
</table>
</body>
<script type="text/javascript">

var text = "<%=LocaleResourceFactory.getResource("BES0000805")%>";
function genFac(){
	var obj = document.getElementById('factor');
	var args = document.getElementById("factor").value.split('&');
	if(obj.value == text){
		args = '';
	}
	window.returnValue=args;
	window.close();
}

function init(id){
	var obj = document.getElementById(id);
	obj.blur();
	obj.onfocus = setText;
	obj.onblur = setText;
}

function setText(){
	var obj = document.getElementById('factor');
	if(obj.value != null && obj.value != '' && obj.value != text)  {
		return;
	}
	if(document.activeElement.id=='factor'){
		obj.value='';
	}else{
		obj.value=text;
	}
}
</script>
</html>



