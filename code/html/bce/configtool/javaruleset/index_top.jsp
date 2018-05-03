<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>

<%
	String moduleId = HttpUtil.getAsString(request,"module_id");
	if(moduleId !=null && !"".equals(moduleId)){
		request.setAttribute("cond","MODULE_ID="+moduleId + " or module_id='0' or module_id is null");
	}
%>

<html>
	<head>
		<title></title>
		<script language="javascript" src="../common/js/configtool.js"></script>
	</head>
<script type="text/javascript">
	function getSearchInfo(){  
		var cond = "1=1 ";
		
			if('<%=moduleId%>' != "" && '<%=moduleId%>' != 'null'){
    			cond = " (module_id=<%=moduleId%> or module_id='0' or module_id is null ) ";
    		}
    		
		var key = getSelectedVal("search_type");
		var value = document.getElementById("search_type_value").value;
		if(key != null ){
			if(value == null){
				alert(crm_i18n_msg("BEC0000306"));
		 		return;
		 	}

			var search_value = value;
    		if(search_value !=''){
    			cond = cond + "and (1=2 ";
    			var search_type = getSelectedVal("search_type");
    			
    			//解析查询条件，按空格分开
    			var args = search_value.split(/\s/);
    			for(i=0;i<args.length;i++){
    				if(args[i]=='')continue;
    				
    				cond = cond + getCondtionSql(search_type ,args[i]);
    			}
    			
    			cond = cond +")";
    		}
		}
		
		//处理状态
		var stateVal = getSelectedVal("state");
		if(stateVal != ""){
			cond += " and STATE = '" + stateVal + "'";
		}
		g_TableRowSetManager.get("javarulesetrelDBTable").refresh("cond=" + cond);
	}

	//根据查询类型返回条件
	function getCondtionSql(search_type ,args){
		if(search_type !='search_all'){
			return " or " + search_type + " like '%" + args + "%'";
		}
		else {
			return " or REMARKS like '%" + args 
				+ "%' or BCE_FRAME_ID  like '%" + args 
				+ "%' or RELATE_ID  like '%" + args
				+ "%' or RULESET_ID  like '%" + args
				+"%' ";
		}    		
	}
    	
	function getAllInfo(){
		var condition = "";
   		g_TableRowSetManager.get("javarulesetrelDBTable").refresh("cond="+condition);
	}

	function getSelectedVal(id){
		var i = document.getElementById(id).selectedIndex;
		return document.getElementById(id).options[i].value;
	}

	function add(){
		var rtnVal = window.showModalDialog("detail.jsp?isEditable=-1", "", "scroll:no;resizable:no;help:no;status:no;dialogHeight:350px;dialogWidth:700px");
    	if(rtnVal == 1){
	    	getSearchInfo();
    	}
	}

	function del(){
		var dbTable = g_TableRowSetManager.get("javarulesetrelDBTable");
    	var selRows = dbTable.getSelectedRows();
    	if(selRows == null || selRows.length <= 0) {
    		alert(crm_i18n_msg("BEC0000307"));
    		return;
    	}
    	
    	var index = dbTable.getRow();

   		var relateId = dbTable.getValue(index,"RELATE_ID");	
  		var result = confirm(crm_i18n_msg("BEC0000311"), relateId);
  		if(result == false){
  			return;
  		}
    	
    	dbTable.deleteRow(index);
    	var list = new Array();
    	list.push(dbTable);
    	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
    	if (ud.getValueByName("FLAG") == "ERROR" ) {
    	  if(!ud.getValueByName("MESSAGE"))
    		alert(crm_i18n_msg("BEC0000305"));
			  return;
		}
		var rtVal = showDataDetail("RELATE_ID=");
		if(rtVal == '1'){
		}
		getSearchInfo();
	}
    	
	function dbclick(){	 
  		var dbTable = g_TableRowSetManager.get("javarulesetrelDBTable");
    	var index = dbTable.getRow();
    	var ruleRelateId = dbTable.getValue(index,"RELATE_ID");
    	var bceFrameId = dbTable.getValue(index,"BCE_FRAME_ID");
    	var rulesetId = dbTable.getValue(index,"RULESET_ID");
    	var condition = "RELATE_ID="+ruleRelateId + "&BCE_FRAME_ID=" + bceFrameId + "&RULESET_ID=" + rulesetId;
   		showDataDetail(condition);
    }

	//将查询方法注册到顶层
	registerEventWhenDetailChange(getAllInfo); 
</script>
	<body onload="clickFirstRow('javarulesetrelDBTable')">
	 <ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem>
			</ai:contractitem>	
			
			
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
				<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000327")%></td>
				<td>
					<select id="search_type" style="width:200px">
						<option value="search_all"><%=LocaleResourceFactory.getResource("BES0000333")%></option>
						<option value="BCE_FRAME_ID"><%=LocaleResourceFactory.getResource("BES0000334")%></option>
						<option value="RELATE_ID"><%=LocaleResourceFactory.getResource("BES0000335")%></option>
						<option value="RULESET_ID"><%=LocaleResourceFactory.getResource("BES0000336")%></option>
						<option value="REMARKS"><%=LocaleResourceFactory.getResource("BES0000337")%></option>
					</select></td>
			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000328")%></td>
			<td><input type="text" id="search_type_value" style="width:200px"></td>
			</tr>
			<tr>
				<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000329")%></td>
				<td><select id="state" style="width:200px">
					   <option value="">
					   		<%=LocaleResourceFactory.getResource("BES0000330")%>					
					   	</option>
						<option value="1">
							<%=LocaleResourceFactory.getResource("BES0000331")%>
						</option>
						<option value="0">
							<%=LocaleResourceFactory.getResource("BES0000332")%>
						</option>
					</select>
				</td>
				<td class="td_font"><ai:button text="BES0000325" onclick="getSearchInfo()" i18nRes="CRM"/></td>
			</tr>
			
		</table> 
				</ai:contractframe> 
	<ai:table tableid="javarulesetrelDBTable"
					setname="com.ai.bce.web.BceFrameJavaRulesetRel" needrefresh="true"
					tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.ai.bce.service.interfaces.IBceStudioSV"
					implservice_querymethod="getFrameJavaRulesetRelValues(String cond)"
					initial="true" height="220" width="100%" editable="false"
					multiselect="false" footdisplay="block" pagesize="10"
					rowsequence="true" onrowchange="dbclick" ondbclick="dbclick">
					<ai:col fieldname="RELATE_ID" width="10%"/>
					<ai:col fieldname="BCE_FRAME_ID" width="10%"/>
					<ai:col fieldname="CHECK_TYPE" width="10%"/>
					<ai:col fieldname="PARAM_DATA" width="10%"/>					
					<ai:col fieldname="REMARKS" width="30%"/>
					<ai:col fieldname="RULESET_ID" width="10%"/>
					<ai:col fieldname="RULESET_TYPE" width="15%"/>
					<ai:col fieldname="STATE" width="10%"/>
				</ai:table> 
	</body>
	
</html>