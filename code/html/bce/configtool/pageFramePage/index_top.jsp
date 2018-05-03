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
		<title></title>
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
        }
        
        //新增操作
    	function add(){
    	var rtnVal = window.showModalDialog("addPageFramePage.jsp?type=add","","dialogWidth=900px;dialogHeight=600px");
	    	if(rtnVal == 1){
	    	getSearchInfo();
    		}
    	}
    	
    	
    	
    	function dbclick(){	 
    		var tab = getPageFramePageTab();
    		var index = tab.getRow();
    		var pFramePageId = tab.getValue(index,"PAGE_FRAME_PAGE_ID");
    		var condition = "pFramePageId="+pFramePageId;
    		showDataDetail(condition);
    		}
    		
    	function getPageFramePageTab(){
    		return g_TableRowSetManager.get("pageFramePageDBTable");
    	}
	    
		//将查询方法注册到顶层
		registerEventWhenDetailChange(getSearchInfo); 
</script>
	</head>

	<body onload="clickFirstRow('pageFramePageDBTable')">
		<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem/>
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
				<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000054")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
				<td><select id="search_type" style="width=200px">
							<option value="search_all">
								<%=LocaleResourceFactory.getResource("BES0000047")%>
							</option>
							<option value="PAGE_FRAME_ID">
								<%=LocaleResourceFactory.getResource("BES0000500")%>
							</option>
							<option value="PAGE_FRAME_PAGE_ID">
								<%=LocaleResourceFactory.getResource("BES0000501")%>
							</option>
							<option value="PAGE_ID">
								<%=LocaleResourceFactory.getResource("BES0000502")%>
							</option>
							<option value="REMARKS">
								<%=LocaleResourceFactory.getResource("BES0000142")%>
							</option>
						</select></td>
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
			
	<ai:table tableid="pageFramePageDBTable"
				setname="com.ai.bce.web.QPageFramePage" needrefresh="true"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfPFramePageSV"
				implservice_querymethod="getBcePageFramePageValues(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
				implservice_countmethod="getBcePageFramePageValuesCount(String cond)"
				initial="true" height="220" width="100%" editable="false"
				multiselect="false" footdisplay="block" pagesize="10"
				rowsequence="true" onrowchange="dbclick" ondbclick="dbclick">
				<ai:col fieldname="PAGE_FRAME_PAGE_ID" width="150" />
				<ai:col fieldname="PAGE_FRAME_ID" width="100" />
				<ai:col fieldname="PAGE_ID" width="100" />
				<ai:col fieldname="MODULE_ID" width="100" />
				<ai:col fieldname="PAGE_TITLE" width="150" />
				<ai:col fieldname="PAGE_TYPE" width="100" />
				<ai:col fieldname="PAGE_URL" width="350" />
				<ai:col fieldname="SEQ_NO" width="100" />
				<ai:col fieldname="IS_DISPLAY" width="100" />
				<ai:col fieldname="IS_GET_PAGE_DATA" width="100" />
				<ai:col fieldname="IS_DATA_MUST" width="100" />
				<ai:col fieldname="PAGE_TEMPLATE" width="100" />
				<ai:col fieldname="PAGE_RULESET_ID" width="100" />
				<ai:col fieldname="PAGE_LOAD_TYPE" width="200" />
				<ai:col fieldname="STATE" width="100" />
				<ai:col fieldname="REMARKS" width="250" />
			</ai:table>
	</body>


	
</html>


