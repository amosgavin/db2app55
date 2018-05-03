<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="统计表单信息"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body>
<iframe id='allItemInfoFrame' width="100%" height="800" src="http://10.25.125.14:8098/MicroStrategy/servlet/mstrWeb?Server=HPTEST14&Project=ChargeAndSaleManager&port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=22BA15A64BFAD7D5D3D2ADAAE9BBA120&currentViewMedia=8&hiddensections=header,path,dockTop,dockLeft,footer&uid=hbsale&pwd=hbsale"></iframe>
</body>
</html>