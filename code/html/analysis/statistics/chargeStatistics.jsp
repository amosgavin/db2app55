<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="ͳ�Ʊ���Ϣ"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body >
<iframe width="100%" height="1000" src="http://10.25.125.14:8098/MicroStrategy/servlet/mstrWeb?Server=HPTEST14&Project=%E8%B5%84%E8%B4%B9%E7%BB%9F%E8%AE%A1%E6%8A%A5%E8%A1%A8&port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=857A54EF4E2E864A273E95B0AF00F974&currentViewMedia=8&hiddensections=header,path,dockTop,dockLeft,footer"></iframe>
</body>
<script type="text/javascript">

function tableToExcel(tname) {
	
  if(confirm('�Ƿ�Ҫ������excel��')!=0)
  { 
	alert(tname);
   	window.clipboardData.setData("Text",document.all(tname).outerHTML);
   	try {
	    ExApp = new ActiveXObject("Excel.Application");
	    var ExWBk = ExApp.workbooks.add();
	    var ExWSh = ExWBk.worksheets(1);
	    ExApp.DisplayAlerts = false;
	    ExApp.visible = true;
   	} catch(e) {
	    alert("����û�гɹ���1.���ĵ���û�а�װMicrosoft Excel�����2.������Internetѡ���Զ��弶�𣬶�û�б�ǰ�ȫ�����  ActiveX�ؼ�������ʾ��");
	    return false;
   	} 
    ExWBk.worksheets(1).Paste;
   } else { 
   		return;
  }	
} 
</script>
</html>