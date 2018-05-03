<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil" %>
<html>
<% 
	String bce_frame_id = HttpUtil.getParameter(request,"bceFrameId");
	String module_id = HttpUtil.getParameter(request,"module_id");
	
	if(bce_frame_id == null || bce_frame_id.equals("")){
		bce_frame_id="-1";
	}
 	String cond = "bce_frame_id = "+bce_frame_id;
	request.setAttribute("condition" ,"cond="+cond);
%>	
<head>
<title>
<%=LocaleResourceFactory.getResource("BES0000606")%>
</title>
</head>
<body>
	<ai:contentframe id="" title="BES0000349" contenttype="table" width="98%" i18nRes="CRM">
		<ai:table tableid="sfuncDBTable" setname="com.ai.bce.web.BceSimpleFunc" needrefresh="true"
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" conditionname="condition"
			implservice_name = "com.ai.bce.configtool.service.interfaces.IConfSimpleFuncSV"
		 	implservice_querymethod = "getSimpleFuncValues(String cond, int $STARTROWINDEX, int $ENDROWINDEX)"			
		 	initial="true" height="100" width="100%" editable="false" multiselect="false"
			footdisplay="none"   rowsequence="false" 
			onrowchange="rowchange" ondbclick="dbclick">
	   		<ai:col fieldname="BCE_FRAME_ID" visible="false"/>
			<ai:col fieldname="FUNC_ID" visible="false"/>
			<ai:col fieldname="ROWSET_NAME" width="100"/>
			<ai:col fieldname="ORD_DATASOURCE" width="100"/>
			<ai:col fieldname="ORD_BO" width="200"/>
			<ai:col fieldname="INS_DATASOURCE" width="100"/>
			<ai:col fieldname="INS_BO" width="200"/>
			<ai:col fieldname="DEAL_SERVICE" width="100"/>
			<ai:col fieldname="DEAL_WORKFLOW" width="100"/>
			<ai:col fieldname="MODULE_ID" width="100"/>
			<ai:col fieldname="STATE" width="100"/>
		</ai:table>	
	<div class="area_button" >
		<ai:button text="BES0000322" onclick = "addNew()" i18nRes="CRM"/>&nbsp;&nbsp;
		<ai:button text="BES0000323" onclick = "edit()" i18nRes="CRM"/>&nbsp;&nbsp;
		<ai:button text="BES0000324" onclick = "del()" i18nRes="CRM"/>	 
	</div>	   			
</ai:contentframe>
<ai:contentframe id="" title="BES0000600" contenttype="table" width="98%" i18nRes="CRM">
	<ai:table tableid="sfuncMappingDBTable" setname="com.ai.bce.web.BceSimpleFuncFieldMapping" needrefresh="true"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" conditionname="condition"
		implservice_name = "com.ai.bce.configtool.service.interfaces.IConfSimpleFuncSV"
		implservice_querymethod = "getSimpleFuncFieldMappingValues(String cond, int $STARTROWINDEX, int $ENDROWINDEX)"			
		initial="false" height="100" width="100%" editable="false" multiselect="false"
		footdisplay="none" pagesize="1000" rowsequence="false" 
        onrowchange="rowchangeM" ondbclick="dbclickM">
	 	<ai:col fieldname="FIELD_ID" visible="false"/>
		<ai:col fieldname="FUNC_ID" visible="false"/>
		<ai:col fieldname="FIELD_CODE" width="30%"/>
		<ai:col fieldname="ORD_FIELD" width="30%"/>
		<ai:col fieldname="INS_FIELD" width="20%"/>
		<ai:col fieldname="MODULE_ID" width="10%"/>
		<ai:col fieldname="STATE" width="10%"/>
	</ai:table>	
	   			
	<div class="area_button">
		<ai:button text="BES0000322" onclick = "addNewM()" i18nRes="CRM"/>&nbsp;&nbsp;
		<ai:button text="BES0000323" onclick = "editM()" i18nRes="CRM"/>&nbsp;&nbsp;
		<ai:button text="BES0000324" onclick = "delM()" i18nRes="CRM"/>
	</div>
</ai:contentframe>
</body>
<script type="text/javascript">
	var v_soframeid = <%=bce_frame_id%>;	//受理框架编号
	var v_funcId;

	function getSimpleFuncDBTable(){
		return g_TableRowSetManager.get("sfuncDBTable");
	}

	function getSimpleFuncMappingDBTable(){
		return g_TableRowSetManager.get("sfuncMappingDBTable");
	}	

	function rowchange(){
		var tab = getSimpleFuncDBTable();
		var index = tab.getRow();
		// add by zhangwq，避免删除最后一条数据时出现查询数据库异常
		if(index >= 0)
		{		  		
			v_funcId = tab.getValue(index,"FUNC_ID"); 		
			var condition = "FUNC_ID="+v_funcId;
	    		  
			getSimpleFuncMappingDBTable().refresh("cond="+condition);
		}
	}

	function dbclick(){
		rowchange();
		var rtnVal = window.showModalDialog("simpleFunc.jsp?funcId=" + v_funcId+ "&isEditable=0", 
	    	 	"", "dialogWidth=700px;dialogHeight=270px");
	}

	function addNew(){
		if(v_soframeid=="-1"){
    		alert(crm_i18n_msg("BEC0000312"));
		} else{
    		var rtnVal = window.showModalDialog("simpleFunc.jsp?bceFrameId=" + v_soframeid+ "&isEditable=-1", 
    	    		<%=module_id%>, "dialogWidth=700px;dialogHeight=270px");
        	if(rtnVal == "1"){
            	getSimpleFuncDBTable().refresh("cond="+"BCE_FRAME_ID="+v_soframeid);
        	}
    	}
	}

	function edit(){		
		var dbTable = getSimpleFuncDBTable();
    	var selRows = dbTable.getSelectedRows();
    	if(selRows == null || selRows.length <= 0) {
    		alert(crm_i18n_msg("BEC0000307"));
    		return;
    	}

    	var index = dbTable.getRow();
    	var funcId = dbTable.getValue(index,"FUNC_ID");
		var rtnVal = window.showModalDialog("simpleFunc.jsp?funcId=" + funcId+ "&isEditable=1", 
	    		"", "dialogWidth=700px;dialogHeight=270px");
    	if(rtnVal == "1"){
    		dbTable.refresh("cond="+"BCE_FRAME_ID=" + v_soframeid);
    	}
	}

	function del(){
		var dbTable = getSimpleFuncDBTable();
    	var selRows = dbTable.getSelectedRows();
    	if(selRows == null || selRows.length <= 0) {
    		alert(crm_i18n_msg("BEC0000307"));
    		return;
    	}
    	
    	var index = dbTable.getRow();
   		var funcId = dbTable.getValue(index,"FUNC_ID");	
  		var result = confirm(crm_i18n_msg("BEC0000313", funcId));
  		if(result == false){
  			return;
  		}
    	
    	dbTable.deleteRow(index);
    	
			getSimpleFuncMappingDBTable().refresh("cond="+"FUNC_ID="+funcId);
			for(var i = getSimpleFuncMappingDBTable().count();i>=0;i--){
			  getSimpleFuncMappingDBTable().deleteRow(i);
			}
    	
    	var list = new Array();
    	list.push(dbTable);
    	list.push(getSimpleFuncMappingDBTable());
    	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
    	if (ud.getValueByName("FLAG") == "ERROR") {
			  if(!ud.getValueByName("MESSAGE"))
			    alert(crm_i18n_msg("BEC0000013"));
				return;
			}	
		alert(crm_i18n_msg("BEC0000304"));
	}

	function rowchangeM(){
		//
	}
	
	function dbclickM(){
		rowchangeM();
		var tab = getSimpleFuncMappingDBTable();
		var index = tab.getRow();		  		
		var fieldId = tab.getValue(index,"FIELD_ID"); 		
		var rtnVal = window.showModalDialog("simpleFuncFieldMapping.jsp?fieldId=" + fieldId+ "&isEditable=0", 
	    	 	"", "dialogWidth=700px;dialogHeight=200px");	 
	}
    	
	function addNewM(){
		var dbTable = getSimpleFuncDBTable();
    	var selRows = dbTable.getSelectedRows();
    	if(selRows == null || selRows.length <= 0) {
    		alert(crm_i18n_msg("BEC0000314"));
    		return;
    	}
    	
    	var index = dbTable.getRow();
   		var funcId = dbTable.getValue(index,"FUNC_ID");	

   		var rtnVal = window.showModalDialog("simpleFuncFieldMapping.jsp?funcId=" + funcId+ "&isEditable=-1", 
    	 	<%=module_id%>, "dialogWidth=700px;dialogHeight=300px");
  		if(rtnVal == "1"){
  	  		getSimpleFuncMappingDBTable().refresh("cond="+"FUNC_ID="+funcId);
      	}
	}

	function editM(){
		var dbTable = getSimpleFuncMappingDBTable();
    	var selRows = dbTable.getSelectedRows();
    	if(selRows == null || selRows.length <= 0) {
    		alert(crm_i18n_msg("BEC0000307"));
    		return;
    	}

    	var index = dbTable.getRow();
    	var fieldId = dbTable.getValue(index,"FIELD_ID");
		var rtnVal = window.showModalDialog("simpleFuncFieldMapping.jsp?fieldId=" + fieldId+ "&isEditable=1", 
	    		"", "dialogWidth=700px;dialogHeight=200px");
    	if(rtnVal == "1"){
    		dbTable.refresh("cond="+"FUNC_ID=" + v_funcId);
    	}
	}

	function delM(){
		var dbTable = getSimpleFuncMappingDBTable();
    	var selRows = dbTable.getSelectedRows();
    	if(selRows == null || selRows.length <= 0) {
    		alert(crm_i18n_msg("BEC0000307"));
    		return;
    	}
    	
    	var index = dbTable.getRow();

   		var fieldId = dbTable.getValue(index,"FIELD_ID");	
  		var result = confirm(crm_i18n_msg("BEC0000315", fieldId));
  		if(result == false){
  			return;
  		}
    	dbTable.deleteRow(index);
    	var list = new Array();
    	list.push(dbTable);
    	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
    	if (ud.getValueByName("FLAG") == "ERROR") {
			  if(!ud.getValueByName("MESSAGE"))
			    alert(crm_i18n_msg("BEC0000013"));
				return;
			}	
			alert(crm_i18n_msg("BEC0000304"));
	}
</script>
</html>