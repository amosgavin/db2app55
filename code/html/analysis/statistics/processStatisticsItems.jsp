<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="ͳ�Ʊ���Ϣ"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body >
<iframe width="100%" height="800" src="http://10.25.125.12:7080/MicroStrategy/servlet/mstrWeb?Server=LIULS&Project=ChargeAndSaleManager&port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=F0397767417FA86305DBAFA52FCF7F20&currentViewMedia=8&hiddensections=header,path,dockTop,dockLeft,footer"></iframe>
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