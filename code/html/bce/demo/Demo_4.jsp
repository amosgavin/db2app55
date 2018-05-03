<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/frame/BceFrameHead.jsp"%>
<html>  
<head>
<title></title>
</head>
<% 
String bceFrameId = HttpUtil.getAsString(request,com.ai.bce.util.BceUtil.BCE_FRAME_ID_KEY);
%>
<body>
<ai:contractframe id="查询条件" contenttype="table" title="查询条件" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
	    <tr><td class="t-bot-mc-button">
	        <bce:button_area bceframeid="<%=bceFrameId %>" areaid="btnAreaQry"/>
			</td></tr>
	  </table>
	</ai:contractitem>
  <table width="98%" align="center" border="0" cellpadding="0" cellspacing="0"><tr><td align="center">
    <bce:autoform_area formid="frmQry" bceframeid="<%=bceFrameId %>"
					  setname="${class=com.ai.bce.web.BceAutoSetAction;method=getBceAttrAutoForm}"
					  templateclass="com.ai.bce.web.BceAutoSetEchoClass"/>
  </td></tr></table>
</ai:contractframe>

<ai:contractframe id="信息列表" contenttype="table" title="信息列表" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
    <bce:table_area tableid="tblInfo" bceframeid="<%=bceFrameId %>"
			tablemodel="" 
			height="220" width="100%"  
			onvalchange="" multiselect="false" editable="true" 
			needrefresh="true" initial="false">
		</bce:table_area> 
</ai:contractframe>

<ai:contractframe id="详细信息" contenttype="table" title="详细信息" width="100%" allowcontract="true" frameclosed="false">
  <ai:contractitem/>
  <table width="98%" align="center" border="0" cellpadding="0" cellspacing="0"><tr><td align="center">
     <bce:autoform_area formid="frmInfo" bceframeid="<%=bceFrameId %>"
					  setname="${class=com.ai.bce.web.BceAutoSetAction;method=getBceAttrAutoForm}"
					  templateclass="com.ai.bce.web.BceAutoSetEchoClass"/>
  </td></tr></table>
</ai:contractframe>

<div class="area_button">
  <bce:button_area bceframeid="<%=bceFrameId %>" areaid="btnAreaDeal"/>
</div>

<bce:pagetab areaid="tt" bceframeid="<%=bceFrameId %>"/>

</body>
</html>

<script language="javascript">
gBceFrame_setReturnPage("SELF");
function getFrmQry(){
  return g_FormRowSetManager.get("frmQry");
}

function getFrmInfo(){
  return g_FormRowSetManager.get("frmInfo");
}

function getTabInfo(){
  return g_TableRowSetManager.get("tblInfo");
}

function addNew(){
  getTabInfo().newRow(false);
 // getFrmInfo().refresh("");
//  getFrmQry().setValue("REGION_ID","1");
//  alert(getFrmQry().getValue("REGION_ID"));
  getTabInfo().setValue(0,"REGION_ID","2");
 // alert(getTabInfo().getValue(0,"REGION_ID"));
}
</script>