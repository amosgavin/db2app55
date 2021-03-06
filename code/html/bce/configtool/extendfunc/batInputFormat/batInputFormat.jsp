<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>

<%	
	String moduleId = HttpUtil.getAsString(request,"module_id");
	if(moduleId !=null && !"".equals(moduleId)){
		String cond = "(MODULE_ID="+moduleId + " or module_id='0' or module_id is null) ";
		request.setAttribute("cond",cond);
	}
%>
<html>
	<head>
		<title></title>
		<script language="javascript" src="../common/js/configtool.js"></script>
	</head>

<body >
		<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem>
			</ai:contractitem>
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
				<tr>
					<td class="td_font">
						<%=LocaleResourceFactory.getResource("BES0000054")%><%=LocaleResourceFactory.getResource("BES0000000")%><br><br></td>
					<td>
						<select id="search_type" style="width:200px;">
							<option value="search_all">
								<%=LocaleResourceFactory.getResource("BES0000047")%>
							</option>
							<option value="CONFIG_ID">
								<%=LocaleResourceFactory.getResource("BES0000137")%>
							</option>
							<option value="BUSINESS_ID">
								<%=LocaleResourceFactory.getResource("BES0000106")%>
							</option>
							<option value="REMARKS">
								<%=LocaleResourceFactory.getResource("BES0000113")%>
							</option>
						</select>
					<br><br></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000049")%><%=LocaleResourceFactory.getResource("BES0000000")%><br><br></td>
					<td><input type="text" id="search_type_value" style="width: 200px">
					<br><br></td>
			</tr>
			<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000329")%><%=LocaleResourceFactory.getResource("BES0000000")%><br><br></td>
					<td>
						<select id="state_select" style="width:200px;">
							<option value="">
								<%=LocaleResourceFactory.getResource("BES0000050")%>
							</option>
							<option value="1">
								<%=LocaleResourceFactory.getResource("BES0000051")%>
							</option>
							<option value="0">
								<%=LocaleResourceFactory.getResource("BES0000052")%>
							</option>
						</select>
					<br><br></td>
					<td class="td_font"><ai:button text="BES0000325"  i18nRes="CRM" onclick="getSearchInfo()" /></td>
				</tr>
			</table>
			</ai:contractframe>
				<ai:table tableid="batInputFormatTbl"
					setname="com.ai.bce.web.BceBatInputFormat" needrefresh="true"
					tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.ai.bce.configtool.service.interfaces.IConfBatInputFormatSV"
					implservice_querymethod="getBatInputFormatValues(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
					implservice_countmethod="getBatInputFormatValuesCount(String cond)"
					initial="true" height="180" width="100%" editable="false"
					multiselect="false" footdisplay="block" pagesize="10"
					rowsequence="true"  ondbclick="dbclick">
				</ai:table>
				<div class="area_button">
				<ai:button text="BES0000322" i18nRes="CRM" onclick="add()" />
				<ai:button text="BES0000323" i18nRes="CRM" onclick="mod()" />
				<ai:button text="BES0000324" i18nRes="CRM" onclick="del()" />
				</div>
				<ai:table tableid="batInputFiledFormatTbl"
					setname="com.ai.bce.web.BceBatInputFieldFormat" needrefresh="true"
					tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.ai.bce.configtool.service.interfaces.IConfBatInputFieldFormatSV"
					implservice_querymethod="getBatInputFieldFormatValues(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
					implservice_countmethod="getBatInputFieldFormatValuesCount(String cond)"
					initial="false" height="180" width="100%" editable="false"
					multiselect="false" footdisplay="block" pagesize="10"
					rowsequence="true" >
				</ai:table>
				<div class="area_button">
				<ai:button text="BES0000322" i18nRes="CRM" onclick="addField()" />
				<ai:button text="BES0000323" i18nRes="CRM" onclick="modField()" />
				<ai:button text="BES0000324" i18nRes="CRM" onclick="delField()" />
				</div>
	</body>
	<script type="text/javascript">
	 function $(id){
       		return document.getElementById(id);
        }
        
        
        //查询
		function getSearchInfo(){ 
    		var cond = '1=1';
    		
			if('<%=moduleId%>' != "" && '<%=moduleId%>' != 'null'){
    			cond = " (module_id=<%=moduleId%> or module_id='0' or module_id is null ) ";
    		}
    		//状态
    		if(state_select.value !=''){
    			cond = "  state='" + state_select.value+"'";
    		}
  
    		
    		var search_value = $("search_type_value").value;
    		
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

    		getBatInputFormatTbl().refresh("cond="+cond);
    	}
    	
    	//根据查询类型返回条件
    	function getCondtionSql(search_type ,args){
    		if(search_type !='search_all'){
    			return " or " + search_type + " like '%" + args + "%'";
    		}
    		else {
    			return " or REMARKS like '%" + args 
    				+ "%' or CONFIG_ID  like '%" + args 
    				+ "%' or BUSINESS_ID  like '%" + args 
    				+ "%' or BUSI_SERVICE like '%"+args
    				+ "%'  or PARSE_SERVICE like '%"+args
    				+ "%' or EXTRA_1 like '%"+args 
    				+ "%' or EXTRA_2 like '%"+args
    				+ "%'  or INPUT_TYPE like '%"+args
    				+ "%'  or PROD_SPEC_ID like '%"+args
    				+ "%'  or ROLE_ID like '%"+args
    				+ "%'  or STYLE_DESC like '%"+args
    				+ "%'  or STYLE_IMG like '%"+args
    				+ "%'  or SPLIT_CHAR like '%"+args
    				+ "%'  or RET_CHAR like '%"+args
    				+"%' ";
    		}    		
    	}
    	
    	
    	function getSelectedVal(id){
    	 	  var i = $(id).selectedIndex;
    		  return $(id).options[i].value;
        }
    	
	function getBatInputFormatTbl(){
		return g_TableRowSetManager.get("batInputFormatTbl");
	}
	function getBatInputFiledFormatTbl(){
		return g_TableRowSetManager.get("batInputFiledFormatTbl");
	}
	function dbclick(){
		var index = getBatInputFormatTbl().getRow();
		var configId = getBatInputFormatTbl().getValue(index,"CONFIG_ID");
		getBatInputFiledFormatTbl().refresh("cond=CONFIG_ID="+configId);
	}
	function add(){
		var obj = {module_id:<%=moduleId%>};
		var returnVal = window.showModalDialog('addBatInputFormat.jsp',obj,'dialogHeight=480px;dialogWidth=700px');
		if(returnVal == 1){
			getSearchInfo();
		}	
	}
	function mod(){
		var index = getBatInputFormatTbl().getRow();
		if(index == -1){
			alert(crm_i18n_msg("BEC0000014"));
			return;
		}
		var configId = getBatInputFormatTbl().getValue(index,"CONFIG_ID");
		var obj = {module_id:<%=moduleId%>,config_id:configId};
		var returnVal = window.showModalDialog('addBatInputFormat.jsp',obj,'dialogHeight=480px;dialogWidth=700px');
		if(returnVal == 1){
			getSearchInfo();
		}	
	}
	function del(){
		var index = getBatInputFormatTbl().getRow();
		if(index == -1){
			alert(crm_i18n_msg("BEC0000014"));
			return;
		}
		if(!confirm(crm_i18n_msg("BEC0000015"))){
			return;
		}
		getBatInputFormatTbl().deleteRow(index);
		var list = new Array();
	    list.push(getBatInputFormatTbl());
	    var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
		if (ud.getValueByName("FLAG") == "ERROR") {
			alert(crm_i18n_msg("BEC0000013"));
			return;
		} 
		getSearchInfo();
	}
	function addField(){
		var index = getBatInputFormatTbl().getRow();
		if(index == -1){
			alert(crm_i18n_msg("BEC00000305"));
			return;
		}
		var config_id = getBatInputFormatTbl().getValue(index,"CONFIG_ID");
		var obj = {module_id:<%=moduleId%>,config_id:config_id};
		var returnVal = window.showModalDialog('addBatInputFieldFormat.jsp',obj,'dialogHeight:480px;dialogWidth:700px');
		if(returnVal == 1){
			getBatInputFiledFormatTbl().refresh("cond=CONFIG_ID="+config_id);
		}	
	}
	function modField(){
		var index = getBatInputFiledFormatTbl().getRow();
		if(index == -1){
			alert(crm_i18n_msg("BEC0000014"));
			return;
		}
		var configId = getBatInputFiledFormatTbl().getValue(index,"CONFIG_ID");
		var listType = getBatInputFiledFormatTbl().getValue(index,"LIST_TYPE");
		var seqNo = getBatInputFiledFormatTbl().getValue(index,"SEQ_NO");
		var obj = {module_id:<%=moduleId%>,config_id:configId,list_type:listType,seq_no:seqNo};
		var returnVal = window.showModalDialog('addBatInputFieldFormat.jsp',obj,'dialogHeight=480px;dialogWidth=700px');
		if(returnVal == 1){
			getBatInputFiledFormatTbl().refresh("cond=CONFIG_ID="+config_id);
		}	
	}
	function delField(){
		var index = getBatInputFiledFormatTbl().getRow();
		if(index == -1){
			alert(crm_i18n_msg("BEC0000014"));
			return;
		}
		if(!confirm(crm_i18n_msg("BEC0000015"))){
			return;
		}
		getBatInputFiledFormatTbl().deleteRow(index);
		var list = new Array();
	    list.push(getBatInputFiledFormatTbl());
	    var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
		if (ud.getValueByName("FLAG") == "ERROR") {
			alert(crm_i18n_msg("BEC0000013"));
			return;
		} 
		getBatInputFiledFormatTbl().refresh("cond=CONFIG_ID="+config_id);
	}
	</script>
</html>


