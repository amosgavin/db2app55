<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>



<html>
<head>
<title>
PageFrame
</title>
<script type="text/javascript">	
    	function $(id){
        return document.getElementById(id);
        } 
        
		//查询
		function getSearchInfo(){ 
    		var cond = '1=1 ';
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
    		getPageFramePageTab().refresh("cond="+cond);
    	}
    	
    	//根据查询类型返回条件
    	function getCondtionSql(search_type ,args){
    		if(search_type !='search_all'){
    			return " or " + search_type + " like '%" + args + "%'";
    		}
    		else {
    			return " or REMARKS like '%" + args 
    				+ "%' or PAGE_FRAME_ID  like '%" + args 
    				+ "%' or PAGE_ID like '%"+args 
    				+ "%' or PAGE_TITLE like '%"+args
    				+ "%'  or PAGE_URL like '%"+args
    				+ "%'  or SEQ_NO like '%"+args
    				+ "%'  or PAGE_TEMPLATE like '%"+args
    				+ "%'  or PAGE_RULESET_ID like '%"+args
    				+"%' or PAGE_FRAME_PAGE_ID like '%"+args
    				+"%'";
    		}    		
    	}
    	
   		function getSelectedVal(id){
    	 	  var i = $(id).selectedIndex;
    		  return $(id).options[i].value;
       
    	function dbclick(){
    		var DBTab = g_TableRowSetManager.get("sopageframeDBTable");
    		var index = DBTab.getRow();
    		var pageframeid = DBTab.getValue(index,"PAGE_FRAME_ID");
			window.opener.getBceFrameForm().setValue("PAGE_FRAME_ID",pageframeid); 
			window.opener.getPageFrameForm().refresh("bcePageFrameId="+pageframeid);
			window.close();
    	}  	
</script>
</head>
<body>
   				<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem>
			</ai:contractitem>		
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
				<tr>
					<td class="td_font">
						<%=LocaleResourceFactory.getResource("BES0000054")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<select id="search_type" style="width:200px;">
							<option value="search_all">
								<%=LocaleResourceFactory.getResource("BES0000047")%>
							</option>
							<option value="PAGE_FRAME_ID">
								<%=LocaleResourceFactory.getResource("BES0000395")%>
							</option>
							<option value="PAGE_FRAME_NAME">
								<%=LocaleResourceFactory.getResource("BES0000397")%>
							</option>
						</select>
					</td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000049")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td><input type="text" id="search_type_value" style="width:200px">
					</td>
			</tr>
			<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000049")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
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
					</td>
				<td class="td_font"><ai:button text="BES0000325" i18nRes="CRM" onclick="getSearchInfo()" /></td>
			</tr>
		</table>
		</ai:contractframe>
			   		<ai:table tableid="sopageframeDBTable" setname="com.ai.bce.web.BcePageFrame" needrefresh="true"
			   		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" conditionname="condition"
			   		implservice_name = "com.ai.bce.service.interfaces.IBceStudioSV"
			   		implservice_querymethod = "getPageFrameValues(String cond)"   				
			   		initial="true" height="250" width="100%" editable="false" multiselect="false"
					footdisplay="block" pagesize="1000" rowsequence="true" 
					ondbclick="dbclick">
		   			<ai:col fieldname="PAGE_FRAME_ID"/>
					<ai:col fieldname="PAGE_FRAME_NAME" width="150"/>
					<ai:col fieldname="REMARKS"width="150"/>					
					<ai:col fieldname="FRAME_TYPE"/>	
					<ai:col fieldname="STATE"/>
		   			</ai:table>			
</body>
</html>


