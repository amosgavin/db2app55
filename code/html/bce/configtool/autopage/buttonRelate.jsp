<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>

<%@ page import="com.ai.appframe2.web.HttpUtil" %>


<html>
<head>
<title>
<%=LocaleResourceFactory.getResource("BES0000533")%>
</title>
</head>
<%
 String bce_frame_id = HttpUtil.getParameter(request,"bceFrameId");
 if(bce_frame_id==null||bce_frame_id.equals("")) bce_frame_id="-1";
  String cond = "bce_frame_id = "+bce_frame_id;
  request.setAttribute("condition" ,"cond="+cond);
  String moduleId = HttpUtil.getParameter(request,"module_id");
%>
 <body>
 	<center>
   		<ai:table tableid="btnRelateTable" setname="com.ai.bce.web.BceFrameButton" needrefresh="true"
	   		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" conditionname="condition"
	   		implservice_name = "com.ai.bce.configtool.service.interfaces.IConfButtonSV"
	   		implservice_querymethod="getBceFrameButton(String cond,  int $STARTROWINDEX,int $ENDROWINDEX)"		
		    implservice_countmethod="getBceFrameButtonCount(String cond)" 	
	   		initial="true" height="220" width="100%"  multiselect="false"
			footdisplay="block" pagesize="10" rowsequence="false" >
  		    <ai:col fieldname="BCE_FRAME_ID" width="17%"/>
  		    <ai:col fieldname="BUTTON_ID"  title='<%=LocaleResourceFactory.getResource("BES0000181")%>' width="17%" />
  		    <ai:col fieldname="AREA_ID" width="17%" />
  		    <ai:col fieldname="EVENT_CLICK"  width="17%"/>
  		    <ai:col fieldname="ENABLE" width="17%" />
  		    <ai:col fieldname="STATE" width="17%" />
  		    <ai:col fieldname="SEQ_NO" width="17%" />
  		</ai:table>				
  		<div class="area_button">
  			<ai:button text="BES0000322" i18nRes="CRM" onclick="addBtnRelate()" />&nbsp; 
			<ai:button text="BES0000323" i18nRes="CRM" onclick="modBtnRelate()" />&nbsp;&nbsp;
			<ai:button text="BES0000324" i18nRes="CRM" onclick="delBtnRelate()" />	&nbsp;&nbsp; 	
			<!--<ai:button text="BES0000499" i18nRes="CRM" onclick="btnConfig()" />	-->
		</div>
</center>
</body>
</html>

<script type="text/javascript">
 
function getTblBtnRelate(){
  return g_TableRowSetManager.get("btnRelateTable");
}
  
function addBtnRelate(){
 	var url = "<%=request.getContextPath()%>/bce/configtool/autopage/btnconfig/AddButtonRelate.jsp?frameId=<%=bce_frame_id%>";
 	window.showModalDialog(url, <%=moduleId%>,"scroll:no;resizable:no;status:no;dialogHeight:320px;dialogWidth:400px");
 	// 刷新当前页面
 	window.location.reload();
}

function modBtnRelate(){
	var selRows = getTblBtnRelate().getSelectedRows();
	if(selRows == null || selRows.length <= 0)
	{
		alert(crm_i18n_msg("BEC0000307"));
		return;
	}
	var frameId = getTblBtnRelate().getValue(getTblBtnRelate().getRow(), "BCE_FRAME_ID");
	var buttonId = getTblBtnRelate().getValue(getTblBtnRelate().getRow(), "BUTTON_ID");
	var areaId = getTblBtnRelate().getValue(getTblBtnRelate().getRow(), "AREA_ID");
  	var url = "<%=request.getContextPath()%>/bce/configtool/autopage/btnconfig/AddButtonRelate.jsp?frameId="+frameId+"&areaId="+areaId+"&buttonId="+buttonId;
 	window.showModalDialog(url, <%=moduleId%>,"scroll:no;resizable:no;status:no;dialogHeight:320px;dialogWidth:400px");
 	var cond = "bce_frame_id =<%=bce_frame_id%> ";
 	// 刷新当前页面
 	window.location.reload();
}

function delBtnRelate(){
  var index = getTblBtnRelate().getRow();
    	if(index == -1){
    		alert(crm_i18n_msg("BEC0000014"));
    		return;
    	}
    	if(!confirm(crm_i18n_msg("BEC0000015"))){
    		return false;
    	}
    	getTblBtnRelate().deleteRow(index);
		  var list = new Array();
    	list.push(getTblBtnRelate());
    	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
    	if (ud.getValueByName("FLAG") == "ERROR" ) {
			  alert(crm_i18n_msg("BEC0000013"));
			  return;
			}		
	window.location.reload();
}

function btnConfig(){
	parent.btnConfig();
}
</script>
