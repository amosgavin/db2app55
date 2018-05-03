<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>

<html>
<%long moduleId = HttpUtil.getAsLong(request,"module_id");
	request.setAttribute("cond","MODULE_ID="+moduleId + " or MODULE_ID='0' or MODULE_ID is null");
%>
	<head>
		<script type="text/javascript">
	    function $(id){
       	 return document.getElementById(id);
        } 
        
        function cancel(){
        	window.close();
        }
        	
		function getSearchInfo(){ 
    		var cond = " 1=1 "
			if('<%=moduleId%>' != "" && '<%=moduleId%>' != null){
    			cond = 'module_id=<%=moduleId%>  ';
    		}
    		//状态
    		if(state_select.value !=''){
    			cond += " and state='" + state_select.value+"'";
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

    		getPageFrameTab().refresh("cond="+cond);
    	}
    	
    	//根据查询类型返回条件
    	function getCondtionSql(search_type ,args){
    		if(search_type !='search_all'){
    			return " or " + search_type + " like '%" + args + "%'";
    		}
    		else {
    			return " or REMARKS like '%" + args 
    				+ "%' or PAGE_FRAME_NAME  like '%" + args 
    				+ "%' or FRAME_TYPE  like '%" + args 
    				+ "%' or PAGE_FRAME_ID like '%"+args 
    				+"%' ";
    		}    		
    	}
    	
   		function getSelectedVal(id){
    	 	  var i = $(id).selectedIndex;
    		  return $(id).options[i].value;
        }
        
        
     
    	function dbclick(){ 
    		var tab = getPageFrameTab();
    		var index = tab.getRow();
    		if(index == -1){
    			alert(crm_i18n_msg("BEC0000014"));
    			return;
    		}   
    		var pageframeid = tab.getValue(index,"PAGE_FRAME_ID");
    		window.returnValue=pageframeid;
    		window.close();
    	}
    	
    	function getPageFrameTab(){
    	return g_TableRowSetManager.get("pageDbTable");
    	}
    	
    	
</script>
<title><%=LocaleResourceFactory.getResource("BES0000031")%></title>
	</head>

	<body>
		<ai:contentframe id="" title="BES0000700" i18nRes="CRM" contenttype="table"  width="98%">
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
				</tr>
			</table>
</ai:contentframe>

<ai:contentframe id="" title="BES0000031" i18nRes="CRM" contenttype="table"  width="98%">
		<ai:table tableid="pageDbTable" setname="com.ai.bce.web.BcePageFrame"
			needrefresh="true"
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.ai.bce.configtool.service.interfaces.IConfPageFrameSV"
			implservice_querymethod="getPageFrameValues(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
			implservice_countmethod="getPageFrameValuesCount(String cond)"
			initial="true" height="220" width="100%" editable="false"
			multiselect="false" footdisplay="block" pagesize="10"
			rowsequence="true"   ondbclick="dbclick">
			<ai:col fieldname="PAGE_FRAME_ID" width="100" />
			<ai:col fieldname="PAGE_FRAME_NAME" width="200" />
			<ai:col fieldname="FRAME_TYPE" width="100" />
			<ai:col fieldname="MODULE_ID" width="100" />
			<ai:col fieldname="STATE" width="50" />
			<ai:col fieldname="REMARKS" width="200" />
		</ai:table>					
</ai:contentframe>

		<div class="area_button">
			<ai:button text="BES0000321" i18nRes="CRM" onclick="dbclick()" />&nbsp;&nbsp;
			<ai:button text="BES0000320" i18nRes="CRM" onclick="cancel()" />
		</div>
	</body>
	
</html>


