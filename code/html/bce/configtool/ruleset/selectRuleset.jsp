<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page contentType="text/html; charset=GBK"%>   
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<html>
<head>
<title>
<%=LocaleResourceFactory.getResource("BES0000608")%>
</title>
</head>
<body onload="getSearchInfo()">

<%
	String RULESET_TYPE = HttpUtil.getAsString(request ,"RULESET_TYPE"); 
	//if(RULESET_TYPE !=null && "".equals(RULESET_TYPE)==false){
		//request.setAttribute("cond" , "RULESET_TYPE='" + RULESET_TYPE + "'");
	//}
%>
<ai:contentframe id="" title="BES0000602" contenttype="table" width="98%" i18nRes="CRM">
   					<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
		   				<tr>
		   					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000327")%></td>
							<td><select id="search_type" style="width:200px">
										<option value="search_all"><%=LocaleResourceFactory.getResource("BES0000333")%></option>
										<option value="RULESET_ID"><%=LocaleResourceFactory.getResource("BES0000336")%></option>
										<option value="REMARKS"><%=LocaleResourceFactory.getResource("BES0000337")%></option>
									</select></td>
							<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000328")%></td>
							<td><input type="text" id="search_type_value" name="search_type_value" style="width:200px"></td>
						</tr>
						<tr>
							
							<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000329")%></td>
							<td><select id="state_select" style="width:200px">
									   <option value=""><%=LocaleResourceFactory.getResource("BES0000330")%></option>
										<option value="1"><%=LocaleResourceFactory.getResource("BES0000331")%></option>
										<option value="0"><%=LocaleResourceFactory.getResource("BES0000332")%></option>
									</select>
									
		   					</td>
		   					<td class="td_button" colspan="2">
			   					<ai:button text="BES0000325" onclick = "getSearchInfo()" i18nRes="CRM"/>
							</td>
		   				</tr>	
	   				</table>					
</ai:contentframe>

<ai:contentframe id="" title="BES0000603" contenttype="table" width="98%" i18nRes="CRM">
			   		<ai:table tableid="rulesetDBTable" setname="com.ai.bce.web.BceRuleset" needrefresh="true"
						tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" conditionname=""
						implservice_name = "com.ai.bce.configtool.service.interfaces.IConfRulesetSV"
						implservice_querymethod = "getBceRulesetValues(String cond,int $STARTROWINDEX,int $ENDROWINDEX)" 	
						implservice_countmethod="getBceRulesetValuesCount(String cond)"			
						initial="false" height="220" width="100%" editable="false" multiselect="false"
						footdisplay="block" pagesize="10" rowsequence="true" 
						ondbclick="dbclick">
						<ai:col fieldname="RULESET_ID"/>
						<ai:col fieldname="MODULE_ID"/>
						<ai:col fieldname="RULESET_TYPE" width="15%"/>
						<ai:col fieldname="STATE"/>
						<ai:col fieldname="REMARKS" width="50%"/>
					</ai:table>					
</ai:contentframe>
			<div class="area_button">
				<ai:button text="BES0000321" onclick="selectPage()" i18nRes="CRM"/>&nbsp;&nbsp;
				<ai:button text="BES0000320" onclick="cancelPage()" i18nRes="CRM"/>
				<ai:button text="BES0000712" onclick="noSelect()" i18nRes="CRM"/>
			</div>	
</body>
<script type="text/javascript">
var RULESET_TYPE="<%=RULESET_TYPE%>";
/**
 * 查询
 */
function getSearchInfo(){  
		var cond = "1=1 ";
		var moduleId = window.dialogArguments;
			if(moduleId != "" && moduleId != null){
    			cond = " (module_id="+moduleId+" or module_id='0' or module_id is null ) ";
    		}
    		// 过滤规则集类型
    		if(RULESET_TYPE != null && RULESET_TYPE != ''){
    			cond+=" and ruleset_type="+ RULESET_TYPE;
    		}
		var key = getSelectedVal("search_type");
		var search_value = document.getElementById("search_type_value").value;
		
		if(key != null ){
			if(search_value == null){
				alert(crm_i18n_msg("BEC0000306"));
		 		return;
		 	}
  
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
		var stateVal = getSelectedVal("state_select");
		if(stateVal != ""){
			cond += " and STATE = '" + stateVal + "'";
		}
		g_TableRowSetManager.get("rulesetDBTable").refresh("cond=" + cond);
	}

	//根据查询类型返回条件
	function getCondtionSql(search_type ,args){
		if(search_type !='search_all'){
			return " or " + search_type + " like '%" + args + "%'";
		}
		else {
			return " or REMARKS like '%" + args 
				+ "%' or RULESET_ID  like '%" + args 
				+"%' ";
		}    		
	}		


function getSelectedVal(id){
	var i = document.getElementById(id).selectedIndex;
	return document.getElementById(id).options[i].value;
}
	
function dbclick(){
	var dbTable = g_TableRowSetManager.get("rulesetDBTable");
	var index = dbTable.getRow();
	var retObj = getRetObjByInx(index);
	if(retObj != null){
		window.returnValue = dbTable.getValue(index, "RULESET_ID");//retObj;
		window.self.close();
	}
}  	

/**
 * 显示页面详细信息
 */
function selectPage() {	
	var dbTable = g_TableRowSetManager.get("rulesetDBTable");
	var selRows = dbTable.getSelectedRows();
	if(selRows == null || selRows.length <= 0) {
		alert(crm_i18n_msg("BEC0000307"));
		return;
	}
	var index = dbTable.getRow();
	var retObj = getRetObjByInx(index);
	if(retObj != null){
		window.returnValue = dbTable.getValue(index, "RULESET_ID");//retObj;
		window.self.close();
	}
}

function cancelPage(){
	window.self.close();
}

/**
 * 关闭窗口
 */
function closeWindow() {
	window.self.close();
}

/**
 * 拼装返回对象
 */
function getRetObjByInx(index){
	var dbTable = g_TableRowSetManager.get("rulesetDBTable");
	var retObj = {
		rulesetId: dbTable.getValue(index, "RULESET_ID"),
		moduleId: dbTable.getValue(index, "MODULE_ID"),
		state: dbTable.getValue(index, "STATE"),
		remarks: dbTable.getValue(index, "REMARKS")
	};
	return retObj;
}

//不选
function noSelect(){
	window.returnValue=-1;
	window.close();
}
</script>
</html>