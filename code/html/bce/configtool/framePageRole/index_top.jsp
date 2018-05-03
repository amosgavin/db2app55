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
		<script language="javascript" src="../common/js/configtool.js"></script>
<script type="text/javascript">
		
		function $(id){
        return document.getElementById(id);
        }
        
		//查询
		function getSearchInfo(){ 
    		var cond = " 1=1 "
    		
			if('<%=moduleId%>' != "" && '<%=moduleId%>' != 'null'){
    			cond = " (module_id=<%=moduleId%> or module_id='0' or module_id is null ) ";
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
    		getFramePageRoleTab().refresh("cond="+cond);
    	}
    	
    	//根据查询类型返回条件
    	function getCondtionSql(search_type ,args){
    		if(search_type !='search_all'){
    			return " or " + search_type + " like '%" + args + "%'";
    		}
    		else {
    			return " or REMARKS like '%" + args 
    				+ "%' or BCE_FRAME_ID  like '%" + args 
    				+ "%' or SEQ_NO like '%"+args 
    				+ "%' or MAX_NUM like '%"+args
    				+ "%'  or ROLE_ID like '%"+args
    				+"%' or PAGE_FRAME_PAGE_ID like '%"+args
    				+"%'";
    		}    		
    	}
    	
    	
    	function getSelectedVal(id){
    	 	  var i = $(id).selectedIndex;
    		  return $(id).options[i].value;
        }
    	
    	function add(){
	    	var url = "../framePageRole/selectFramePageRole.jsp";
	    	var rtnVal = window.showModalDialog(url,<%=moduleId%>,"dialogWidth=700px;dialogHeight=280px");
		    if(rtnVal == 1){
		    	getSearchInfo();
	    	}
    	}
    	  
    	//删除操作
    	function del(){
    	var index = getFramePageRoleTab().getRow();
    	if(index == -1){
    		alert(crm_i18n_msg("BEC0000014"));
    		return;
    	}
    	if(!confirm(crm_i18n_msg("BEC0000015"))){
    		return false;
    	}
    	getFramePageRoleTab().deleteRow(index);
    	var list = new Array();
    	list.push(getFramePageRoleTab());
    	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
    	if (ud.getValueByName("FLAG") == "ERROR" ) {
    	  if(!ud.getValueByName("MESSAGE"))
			  alert(crm_i18n_msg("BEC0000013"));
			  return;
			}
		showDataDetail("BCE_FRAME_ID=&bcePageFrameId=");
		getSearchInfo();
    	}
    	
    	function dbclick(){ 
    		var tab = getFramePageRoleTab();
    		var index = tab.getRow();   
    		var roleId = tab.getValue(index,"ROLE_ID");
    		var frameId = tab.getValue(index,"BCE_FRAME_ID");
    		var pFrameId = tab.getValue(index,"PAGE_FRAME_PAGE_ID");
    		var condition = "roleId="+roleId+"&frameId="+frameId+"&pFrameId="+pFrameId; 
    		showDataDetail(condition);
    	}
    	
    	function getFramePageRoleTab(){
    	return g_TableRowSetManager.get("framePageRoleTab");
    	}
    	
    	registerEventWhenDetailChange(getSearchInfo); 
    	
</script>
	</head>

	<body onload="clickFirstRow('framePageRoleTab')">
		<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem />	
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
				<tr>
					<td class="td_font">
						<%=LocaleResourceFactory.getResource("BES0000054")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<select id="search_type" style="width:200px;">
							<option value="search_all">
								<%=LocaleResourceFactory.getResource("BES0000047")%>
							</option>
							<option value="BCE_FRAME_ID">
								<%=LocaleResourceFactory.getResource("BES0000369")%>
							</option>
							<option value="PAGE_FRAME_PAGE_ID">
								<%=LocaleResourceFactory.getResource("BES0000371")%>
							</option>
							<option value="REMARKS">
								<%=LocaleResourceFactory.getResource("BES0000142")%>
							</option>
						</select>
					</td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000049")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td><input type="text" id="search_type_value" style="width:200px">
					</td>
			</tr>
			<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000329")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
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
		<div class="area_button">
		  <ai:button text="BES0000322" i18nRes="CRM" onclick="add()" />
		<ai:button text="BES0000324" i18nRes="CRM" onclick="del()" />
		</div>
			<ai:table tableid="framePageRoleTab"
				setname="com.ai.bce.web.BceFramePageRole" needrefresh="true"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfFramePageRoleSV"
				implservice_querymethod="getPageRoleValues(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
				implservice_countmethod="getPageRoleValuesCount(String cond)"
				initial="true" height="220" width="100%" editable="false"
				multiselect="false" footdisplay="block" pagesize="10"
				rowsequence="true" onrowchange="dbclick" ondbclick="dbclick">
				<ai:col fieldname="BCE_FRAME_ID" width="15%" />
				<ai:col fieldname="PAGE_FRAME_PAGE_ID" width="15%" />
				<ai:col fieldname="ROLE_ID" width="10%" />
				<ai:col fieldname="MAX_NUM" width="15%" />
				<ai:col fieldname="SEQ_NO" width="10%" />
				<ai:col fieldname="STATE" width="10%" />
				<ai:col fieldname="REMARKS" width="30%" />
			</ai:table>
	</body>
	
</html>


