<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="统计图信息"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body >
<a href="#" onclick="window.open('<%=request.getContextPath()%>/analysis/statistics/processStatisticsItems.jsp','_blank','toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');">
<span style="font-family:华文中宋; color:red; "><b>数据表格链接</b></span></a> 
<iframe width="100%" height="800" src="http://10.25.125.14:8098/MicroStrategy/servlet/mstrWeb?Server=HPTEST14&Project=ChargeAndSaleManager&port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&documentID=17AADD664CD0998547C56ABBDACC0BC2&currentViewMedia=2&hiddensections=header,path,dockTop,dockLeft,footer&uid=Administrator&pwd=Administrator!2012"></iframe>
</body>
<script type="text/javascript">

function initOper()
{
    if ("" == objectType || "null" == objectType){
    	return alert("页面链接出错， 请重新链接");
    } else if (objectType == 'sale') {
    	document.title = '营销案统计信息';
    	statisticsMTable.refresh("&objectType=" + 'saleM');
    	statisticsDTable.refresh("&objectType=" + 'saleD');
    	
    } else if (objectType == 'charge') {
    	document.title = '资费统计信息';
    	statisticsMTable.refresh("&objectType=" + 'chargeM');
    	statisticsDTable.refresh("&objectType=" + 'chargeD');
    } else if (objectType == 'weapon') {
    	document.getElementById("sale_chargetr").style.display = "none";
    	document.getElementById("weapontr").style.display = "block";
    	document.title = '武器统计信息';
    	g_TableRowSetManager.get("statisticsWTable").refresh("&objectType=" + 'weapon');
    }
}

</script>
</html>