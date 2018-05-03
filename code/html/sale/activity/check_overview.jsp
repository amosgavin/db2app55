<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>审核主要信息</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body>
<ai:loginuser/>
<%@include file="/sale/activity/include/_allSaleInfoShow.jsp"%>
<%@include file="/sale/activity/include/_eitAppriseShow.jsp"%>
<%@include file="/sale/activity/include/_telPayFeeAppriseShow.jsp"%>
<%@include file="/sale/activity/include/_telPartsAppriseShow.jsp"%>
<div id="tagDeploy_div" style="display: none">
	<%@include file="/sale/activity/include/_deployTag.jsp"%>
</div>
<%@include file="/sale/activity/include/_overview.jsp"%>
<script type="text/javascript">
var _mainId = "<%=request.getParameter("orderId")%>";
</script>
<%@include file="/sale/common/include/_check.jsp"%>
</body>
</html>
<script type="text/javascript">
var pageName = 'overview';
function initPage(){
	var taskTag = "<%=request.getParameter("taskTag")%>";
    var orderId = "<%=request.getParameter("orderId")%>";
    if ("" == orderId || "null" == orderId){
        return;
    }
   _fromSaleOrderFormRowSet().refresh("&orderId="+orderId);
   if(taskTag=='wp02'||taskTag=='su107'){
   	 document.getElementById("echnnl_re_mess").style.display="block";	
   }
	include_refreshAllSaleInfoTable(orderId);
	
}

function closePage(){
    window.parent.opener.location.reload();
    window.parent.self.close();
}

function reloadPage(){
    window.parent.opener.location.replace("http://10.25.125.12:808/mmp/frame/frameMain.jsp?flowStep=2&activeTab=0");
    window.parent.self.close();
}
</script>
<script type="text/javascript">
function addLoadEvent(func) {  
    var oldonload = window.onload;  
    if(typeof window.onload != "function"){  
        window.onload = func;  
    }else{  
        window.onload = function(){  
            oldonload();  
            func();  
        }  
    }  
}  
addLoadEvent(initPage);
addLoadEvent(initCheckPage);
</script>
