<%@ page contentType="text/html; charset=GBK"%>
   
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>



<html>
<head>
<title>
<%=LocaleResourceFactory.getResource("BES0000542")%>
</title>
<script type="text/javascript">	
    	function getObj(id){
    		return document.getElementById(id);
    	}
    	
    	function getSearchInfo(){ 
    		//alert("\"");
    		//window.parent.test();
    		var notesvalue = getObj("remark").value; 
    		var DBTab = g_TableRowSetManager.get("rulesetDBTable");   		
    		if(notesvalue==""){
    			alert(crm_i18n_msg("BEC0000306"));
    			return;
    		}else{
    			var condition = "notes like "+"\'"+"%"+notesvalue+"%"+"\'";
    			DBTab.refresh("cond="+condition);
    			//setDBGridTitle("soframeDBTable");
    			afterSearch();    			
    		}
    	}
    	function getAllInfo(){
    		var condition = "";
    		g_TableRowSetManager.get("rulesetDBTable").refresh("cond="+condition);
    		//setDBGridTitle("soframeDBTable");
    	}
    			
    	function afterSearch(){
    		var DBTab = g_TableRowSetManager.get("rulesetDBTable");
    		var totalCount = DBTab.getTotalRowCount();
    		if(totalCount>0){
    			//alert("have item");
    		}else{
    			alert(crm_i18n_msg("BEC0000316"));
    		}    	
    	}   
    	
    	function dbclick(){
    		var DBTab = g_TableRowSetManager.get("rulesetDBTable");
    		var index = DBTab.getRow();
    		var javarulesetid = DBTab.getValue(index,"RULESET_ID");
			window.opener.g_FormRowSetManager.get("<%=request.getParameter("form")%>").setValue("<%=request.getParameter("col")%>",javarulesetid); 
			window.close();
    	}  	
</script>
</head>
<body>
<ai:contentframe id="" title="BES0000602" i18nRes="CRM" contenttype="table"  width="98%">
   					<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
		   				<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000337")%></td>
						<td><input type="text" id="remark" name="remark">&nbsp;</td>
		   				<td class="td_button">
			   					<ai:button text="BES0000325" i18nRes="CRM" onclick = "getSearchInfo()" />
			   					<ai:button text="BES0000806" i18nRes="CRM" onclick = "getAllInfo()" />
							</td>
		   				</tr>	
	   				</table>
		
</ai:contentframe>

<ai:contentframe id="" title="BES0000542" i18nRes="CRM" contenttype="table"  width="98%">
			   		<ai:table tableid="rulesetDBTable" setname="com.ai.bce.web.BceRuleset" needrefresh="true"
							   		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" conditionname=""
							   		implservice_name = "com.ai.bce.service.interfaces.IBceStudioSV"
							   		implservice_querymethod = "getBceRulesetValues(String cond)" 				
							   		initial="true" height="220" width="100%" editable="false" multiselect="false"
									footdisplay="block" pagesize="10" rowsequence="true" 
									ondbclick="dbclick">
						   			<ai:col fieldname="RULESET_ID"/>
						   			<ai:col fieldname="MODULE_ID"/>
									  <ai:col fieldname="STATE"/>
									  <ai:col fieldname="REMARKS"  width="50%"/>
						 </ai:table>					
</ai:contentframe>
</body>
</html>


