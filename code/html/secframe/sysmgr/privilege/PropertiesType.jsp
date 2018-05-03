<%@ page contentType="text/html; charset=GBK" %>
<%@include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>
<i18n:message key="sec.propertiestype.attstyleselect" res="i18n.secframe_resource"/>
</title>
</head>

<body>
<ai:contractframe id="" contenttype="table" title="sec.propertiestype.attstyle" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>
			<table width=98% border="0" cellspacing="0" cellpadding="0" height="80"  width="100%" align="center">
 				<tr>
 					<td>
 						<input type="checkbox" id="chxView"  checked ><i18n:message key="sec.propertiestype.cansee" res="i18n.secframe_resource"/><br>
 					</td> 	
 					
 				</tr> 	
 				<tr>
 				<td>
 						<input type="checkbox" id="chxModify" checked ><i18n:message key="sec.propertiestype.canupdate" res="i18n.secframe_resource"/>
 					</td>	
 					</tr>						
			</table>
</ai:contractframe>

		    <div class="area_button">
		    	<ai:button text="sec.confirm" i18nRes="i18n.secframe_resource" style="cursor:hand;" id="ok" onclick="okFunc()"/>
			  	<ai:button text="sec.cancel" i18nRes="i18n.secframe_resource" style="cursor:hand;"  id="cancel" onclick="cancelFunc()"/>
		    </div>

</body>
</html>

<SCRIPT LANGUAGE="JavaScript">
function okFunc()
{
	var propertyType = "all";
	if(chxView.checked&&chxModify.checked) propertyType = "all";
	else{
		if(chxView.checked)propertyType = "view";
		else
			if(chxModify.checked)propertyType = "modify";
		else
			propertyType = "none";
	}

	closeWin(propertyType);
}
function cancelFunc()
{
	closeWin("-1");
}
function closeWin(retValue)
{
  window.returnValue = retValue;
  top.close();
}

</script>
