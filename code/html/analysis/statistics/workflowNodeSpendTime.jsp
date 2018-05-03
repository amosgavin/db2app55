<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="统计表单信息"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initPage();">
<iframe id='itemInfoFrame' width="100%" height="800" src="<%=request.getContextPath()%>/main3/right.jsp"></iframe>
</body>
<script type="text/javascript">

//function chargeSrc(){
//	window.document.getElementById("itemInfoFrame").src = "http://10.25.125.14:8098/MicroStrategy/servlet/mstrWeb?Server=HPTEST14&Project=ChargeAndSaleManager&port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=CDC5A5B24C4CF3239D8885943BED3928&currentViewMedia=8&hiddensections=header,path,dockTop,dockLeft,footer";
//}

function initPage(){
	var url = "<%=request.getContextPath()%>/analysis/statistics/mstrNodeTime.jsp";
	var retVal = window.open(url,"","width=100%,height=800,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}
</script>
</html>