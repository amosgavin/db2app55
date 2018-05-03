<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="统计表单信息"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body >
<iframe width="100%" height="800" src="http://10.25.125.12:7080/MicroStrategy/servlet/mstrWeb?Server=LIULS&Project=ChargeAndSaleManager&port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=F0397767417FA86305DBAFA52FCF7F20&currentViewMedia=8&hiddensections=header,path,dockTop,dockLeft,footer"></iframe>
</body>
<script type="text/javascript">

function tableToExcel(tname) {
	
  if(confirm('是否要导出到excel？')!=0)
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
	    alert("导出没有成功！1.您的电脑没有安装Microsoft Excel软件！2.请设置Internet选项自定义级别，对没有标记安全级别的  ActiveX控件进行提示。");
	    return false;
   	} 
    ExWBk.worksheets(1).Paste;
   } else { 
   		return;
  }	
} 
</script>
</html>