<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>

<html>
<%request.setAttribute("cond",""); %>
	<head>
		<title><%=LocaleResourceFactory.getResource("BES0000106")%></title>
		<script type="text/javascript">
        function $(id){
        return document.getElementById(id);
        }
        
        function getOperatorTbl(){
        return g_TableRowSetManager.get("operatorTbl");
        }
        
		function getSearchInfo(){ 
    		var cond = '1=1';
    		
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

    		getOperatorTbl().refresh("cond="+cond);
    	}
    	
    	//根据查询类型返回条件
    	function getCondtionSql(search_type ,args){
    		if(search_type !='search_all'){
    			return " or " + search_type + " like '%" + args + "%'";
    		}
    		else {
    			return " or NAME like '%" + args 
    				+ "%' or BUSINESS_ID  like '%" + args 
    				+ "%' or MODULE_CODE like '%"+args 
    				+ "%' or STATE_DATE like '%"+args
    				+"%' ";
    		}    		
    	}
    	
    	
    	function getSelectedVal(id){
    	 	  var i = $(id).selectedIndex;
    		  return $(id).options[i].value;
        }
        
        function dbclick(){
          var i =getOperatorTbl().getRow();
          if(i==-1){
          	alert(crm_i18n_msg("BEC0000014"));
          	return;
          	}
	          window.returnValue = getOperatorTbl().getValue(i,"BUSINESS_ID");
	          window.close();
        }
</script>
	</head>

	<body>
		<ai:contentframe id=""
			title='<%=LocaleResourceFactory.getResource("BES0000055")%>'
			contenttype="table" width="98%">
			<table width="98%" align="center" border="0" cellpadding="1"
				cellspacing="2">
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000054")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<select id="search_type" style="width: 200px">
							<option value="search_all">
								<%=LocaleResourceFactory.getResource("BES0000047")%>
							</option>
							<option value="BUSINESS_ID">
								<%=LocaleResourceFactory.getResource("BES0000106")%>
							</option>
							<option value="NAME">
								<%=LocaleResourceFactory.getResource("BES0000755")%>
							</option>
						</select>
					</td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000049")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<input type="text" id="search_type_value" style="width: 200px" />
					</td>
				</tr>
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000049")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<select id="state_select" style="width: 200px">
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
						<ai:button text="BES0000325" i18nRes="CRM"
							onclick="getSearchInfo()" />
					</td>
				</tr>
			</table>

		</ai:contentframe>

		<ai:contentframe id=""
			title=""
			contenttype="table" width="98%">
			<ai:table tableid="operatorTbl"
				setname="com.ai.bce.web.BceOperator" needrefresh="true"
				conditionname=""
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfBusinessSV"
				implservice_querymethod="getOperatorBeans(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
				implservice_countmethod="getOperatorBeansCount(String cond)"
				initial="true" height="220" width="100%" editable="false"
				multiselect="false" footdisplay="block" pagesize="10"
				rowsequence="true" ondbclick="dbclick">
				<ai:col fieldname="BUSINESS_ID" width="200" />
				<ai:col fieldname="NAME" width="100" />
				<ai:col fieldname="MODULE_CODE" width="100" />
				<ai:col fieldname="STATE_DATE" width="110" />
			</ai:table>
		</ai:contentframe>

		<div class="area_button">
			<ai:button text="BES0000321" i18nRes="CRM" onclick="dbclick()" />
			<ai:button text="BES0000320" i18nRes="CRM" onclick="window.close()" />
		</div>
	</body>
</html>