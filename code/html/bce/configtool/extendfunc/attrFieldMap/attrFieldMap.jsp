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
								<%=LocaleResourceFactory.getResource("BES0000766")%>
							</option>
							<option value="ATTR_ID">
								<%=LocaleResourceFactory.getResource("BES0000124")%>
							</option>
							<option value="BUSINESS_ID">
								<%=LocaleResourceFactory.getResource("BES0000126")%>
							</option>
							<option value="REMARKS">
								<%=LocaleResourceFactory.getResource("BES0000142")%>
							</option>
						</select>
					<br><br></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000049")%><%=LocaleResourceFactory.getResource("BES0000000")%><br><br></td>
					<td><input type="text" id="search_type_value" style="width: 200px">
					<br><br></td>
			</tr>
			<tr>
					<td class="td_font"><ai:button text="BES0000325"  i18nRes="CRM" onclick="getSearchInfo()" /></td>
				</tr>
			</table>
			</ai:contractframe>
				<ai:table tableid="attrFieldMapTbl"
					setname="com.ai.bce.web.BceAttrFieldMap" needrefresh="true"
					tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.ai.bce.configtool.service.interfaces.IConfAttrFieldMapSV"
					implservice_querymethod="getAttrFieldMapValues(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
					implservice_countmethod="getAttrFieldMapValuesCount(String cond)"
					initial="true" height="180" width="100%" editable="false"
					multiselect="false" footdisplay="block" pagesize="10"
					rowsequence="true"  >
				</ai:table>
				<div class="area_button">
				<ai:button text="BES0000322" i18nRes="CRM" onclick="add()" />
				<ai:button text="BES0000323" i18nRes="CRM" onclick="mod()" />
				<ai:button text="BES0000324" i18nRes="CRM" onclick="del()" />
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

    		getAttrFieldMapTbl().refresh("cond="+cond);
    	}
    	
    	//根据查询类型返回条件
    	function getCondtionSql(search_type ,args){
    		if(search_type !='search_all'){
    			return " or " + search_type + " like '%" + args + "%'";
    		}
    		else {
    			return " or ATTR_ID like '%" + args 
    				+ "%' or CONFIG_ID  like '%" + args 
    				+ "%' or BUSINESS_ID  like '%" + args 
    				+ "%' or DEST_FIELD_NAME like '%"+args
    				+ "%'  or DEST_TABLE_NAME like '%"+args
    				+ "%' or REMARKS like '%"+args 
    				+"%' ";
    		}    		
    	}
    	
    	
    	function getSelectedVal(id){
    	 	  var i = $(id).selectedIndex;
    		  return $(id).options[i].value;
        }
    	
	function getAttrFieldMapTbl(){
		return g_TableRowSetManager.get("attrFieldMapTbl");
	}
	function add(){
		var obj = {module_id:<%=moduleId%>};
		var returnVal = window.showModalDialog('addAttrFieldMap.jsp',obj,'dialogHeight=480px;dialogWidth=700px');
		if(returnVal == 1){
			getSearchInfo();
		}	
	}
	function mod(){
		var index = getAttrFieldMapTbl().getRow();
		if(index == -1){
			alert(crm_i18n_msg("BEC0000014"));
			return;
		}
		var configId = getAttrFieldMapTbl().getValue(index,"CONFIG_ID");
		var obj = {module_id:<%=moduleId%>,config_id:configId};
		var returnVal = window.showModalDialog('addAttrFieldMap.jsp',obj,'dialogHeight=480px;dialogWidth=700px');
		if(returnVal == 1){
			getSearchInfo();
		}	
	}
	function del(){
		var index = getAttrFieldMapTbl().getRow();
		if(index == -1){
			alert(crm_i18n_msg("BEC0000014"));
			return;
		}
		if(!confirm(crm_i18n_msg("BEC0000015"))){
			return;
		}
		getAttrFieldMapTbl().deleteRow(index);
		var list = new Array();
	    list.push(getAttrFieldMapTbl());
	    var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
		if (ud.getValueByName("FLAG") == "ERROR") {
			alert(crm_i18n_msg("BEC0000013"));
			return;
		} 
		getSearchInfo();
	}
	
	</script>
</html>


