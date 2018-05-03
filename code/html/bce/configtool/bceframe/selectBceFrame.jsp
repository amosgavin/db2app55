<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>

<html>
<% 
	String moduleId = HttpUtil.getAsString(request,"module_id");
	if(moduleId !=null && !"".equals(moduleId)){
		request.setAttribute("cond","MODULE_ID="+moduleId + " or module_id='0' or module_id is null");
	}
%>
	<head>
		<title><%=LocaleResourceFactory.getResource("BES0000020")%></title>
		<script type="text/javascript">
        function $(id){
        return document.getElementById(id);
        }
        
        function getBceFrameTab(){
        return g_TableRowSetManager.get("bceframeDBTable");
        }
        
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

    		getBceFrameTab().refresh("cond="+cond);
    	}
    	
    	//根据查询类型返回条件
    	function getCondtionSql(search_type ,args){
    		if(search_type !='search_all'){
    			return " or " + search_type + " like '%" + args + "%'";
    		}
    		else {
    			return " or REMARKS like '%" + args 
    				+ "%' or BCE_FRAME_ID  like '%" + args 
    				+ "%' or BUSINESS_ID  like '%" + args 
    				+ "%' or PAGE_FRAME_ID like '%"+args 
    				+ "%' or DATA_PARSER like '%"+args
    				+ "%'  or DEAL_SERVICE like '%"+args
    				+ "%' or ENTRY_PAGE_URL like '%"+args 
    				+ "%' or WORKFLOW_CODE like '%"+args
    				+ "%'  or PARAM_DATA like '%"+args
    				+"%' ";
    		}    		
    	}
    	
    	
    	function getSelectedVal(id){
    	 	  var i = $(id).selectedIndex;
    		  return $(id).options[i].value;
        }
        
        function dbclick(){
          var i =getBceFrameTab().getRow();
          if(i==-1){
          	alert(crm_i18n_msg("BEC0000014"));
          	return;
          	}
	          window.returnValue = {bceFrameId:getBceFrameTab().getValue(i,"BCE_FRAME_ID"),pageFrameId:getBceFrameTab().getValue(i,"PAGE_FRAME_ID")};
	          window.close();
        }
</script>
	</head>

	<body>
		<ai:contentframe id="" title='<%=LocaleResourceFactory.getResource("BES0000055")%>' contenttype="table" width="98%">
				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000054")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td><select id="search_type" style="width:200px">
								<option value="search_all">
									<%=LocaleResourceFactory.getResource("BES0000047")%>
								</option>
								<option value="BCE_FRAME_ID">
									<%=LocaleResourceFactory.getResource("BES0000105")%>
								</option>
								<option value="PAGE_FRAME_ID">
									<%=LocaleResourceFactory.getResource("BES0000110")%>
								</option>
								<option value="BUSINESS_ID">
									<%=LocaleResourceFactory.getResource("BES0000106")%>
								</option>
								<option value="REMARKS">
									<%=LocaleResourceFactory.getResource("BES0000113")%>
								</option>
							</select>
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000049")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td><input type="text" id="search_type_value" style="width:200px" /></td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000049")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td><select id="state_select" style="width:200px">
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
						<td class="td_button">
							<ai:button text="BES0000325" i18nRes="CRM" onclick="getSearchInfo()" />
						</td>
					</tr>
				</table>
				
</ai:contentframe>

<ai:contentframe id="" title='<%=LocaleResourceFactory.getResource("BES0000020")%>' contenttype="table"  width="98%">
				<ai:table tableid="bceframeDBTable"
					setname="com.ai.bce.web.BceFrame" needrefresh="true"
					tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.ai.bce.configtool.service.interfaces.IConfFrameSV"
					implservice_querymethod="getBceFrameValues(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
					implservice_countmethod="getBceFrameValuesCount(String cond)"
					initial="true" height="220" width="100%" editable="false"
					multiselect="false" footdisplay="block" pagesize="10"
					rowsequence="true" ondbclick="dbclick">
					<ai:col fieldname="REMARKS" title='<%=LocaleResourceFactory.getResource("BES0000021")%>' width="200" />
					<ai:col fieldname="BCE_FRAME_ID" width="100"/>
					<ai:col fieldname="BUSINESS_ID" width="100" />
					<ai:col fieldname="PAGE_FRAME_ID" width="110" />
					<ai:col fieldname="DATA_PARSER" width="30%" />
					<ai:col fieldname="DEAL_SERVICE" width="20%" />
					<ai:col fieldname="ENTRY_PAGE_URL" width="100"/>
					<ai:col fieldname="WORKFLOW_CODE" width="35%" />
					<ai:col fieldname="MODULE_ID" width="10%" />
					<ai:col fieldname="PARAM_DATA" width="100"/>
					<ai:col fieldname="STATE" width="100" />
				</ai:table>					
</ai:contentframe>

				<div class="area_button">
					<ai:button text="BES0000321" i18nRes="CRM" onclick="dbclick()"/>
					<ai:button text="BES0000320" i18nRes="CRM" onclick="window.close()"/>
				</div>
	</body>
</html>