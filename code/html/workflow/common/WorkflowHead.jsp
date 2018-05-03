<%@ include file="/webframe/common/commonhead.jsp"%>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/i18n/comframe_js_resource_<%=com.ai.appframe2.util.locale.AppframeLocaleFactory.getCurrentLocale() %>.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/CommUtil.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/jsv2/PopMenu_v2.js"></script>
<script>
function isBlank(param){
	  if(param == null || param == undefined || param == "" || param == "null"){
	    return true;
	  }
	  return false;
}

function getCenterStr(regionID){
 	var centerStr="&CenterType=RegionId&CenterValue=";
 	
	if(isBlank(regionID)==true){
		centerStr="";
	}else{
		centerStr+=regionID;
	}
	return centerStr;
}

</script>