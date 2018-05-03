<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>

<%@ page import="com.ai.appframe2.web.HttpUtil" %>
<%
	String moduleId = HttpUtil.getAsString(request,"module_id");
	if(!"".equals(moduleId)){
		request.setAttribute("cond","MODULE_ID="+moduleId + " or module_id='0' or module_id is null");
	}
%>

<html>
<head>
<title>
<%=LocaleResourceFactory.getResource("BES0000537")%>
</title>
<script language="javascript" src="<%=request.getContextPath() %>/bce/configtool/common/js/configtool.js"></script>
</head>

<body  onload="init()">
		<ai:contractframe title="" i18nRes="CRM" id="" contenttype="table"
			allowcontract="false" width="100%">
		<ai:contractitem></ai:contractitem>
			<table>
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000328")%></td>
					<td><input type="text" id="search_type_value" style="width:240px"></td>
					<td >
						<ai:button text="BES0000325" i18nRes="CRM"
							onclick="getSearchInfo()" style="cursor:hand" />
					</td>
				</tr>
			</table>
		</ai:contractframe>

		   		<ai:table tableid="AttrTable" setname="com.ai.bce.web.BceAttr" needrefresh="true"
		   		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" conditionname="condition"
		   		implservice_name = "com.ai.bce.configtool.service.interfaces.IConfFrameAreaFormSV"
		   		implservice_querymethod = "getBceAttr(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"		
		   		implservice_countmethod = "getBceAttrCount(String cond)"		
		   		initial="true" height="220" width="100%" editable="false" multiselect="true"
			  	footdisplay="block" pagesize="10" rowsequence="false">
	   		    <ai:col fieldname="ATTR_ID" />
	   		    <ai:col fieldname="MODULE_ID" />
	   		    <ai:col fieldname="OBJ_NAME" />
	   		    <ai:col fieldname="ATTR_CODE" />
	   		    <ai:col fieldname="ATTR_NAME" />
	   		    <ai:col fieldname="I18N_RES" />
	   		    <ai:col fieldname="FIELD_TYPE" />
	   		    <ai:col fieldname="RULE_ID" />
	   		    <ai:col fieldname="FIELD_WIDTH" />
	   		    <ai:col fieldname="COL_SPAN" />
	   		    <ai:col fieldname="IS_NULLABLE" />
	   		    <ai:col fieldname="EDIT_TYPE" />
	   		    <ai:col fieldname="MAX_LENGTH" />
	   		    <ai:col fieldname="RES_SRC" />
	   		    <ai:col fieldname="RES_PARAM" />
	   		    <ai:col fieldname="DEFAULT_VALUE" />
	   		    <ai:col fieldname="VALUE_CLASS" />	 
	   		    <ai:col fieldname="REMARKS" />
	   		    <ai:col fieldname="STATE" />
	   			</ai:table>		
	   			 <div class="area_button">
	   				<ai:button text="BES0000322" i18nRes="CRM" onclick="addAttr()" />&nbsp;&nbsp;
					<ai:button text="BES0000323" i18nRes="CRM" onclick="modAttr()" />&nbsp;&nbsp;
					<ai:button text="BES0000324" i18nRes="CRM"  onclick="delAttr()" />
					<ai:button text="BES0000631" i18nRes="CRM"  onclick="bImport()" />
				</div>
</body>
</html>

<script type="text/javascript">
function init(){
	for(var i=0;i<getTblAttr().count();i++){
		getTblAttr().setRowEditSts(i,false);
	}
	setSearchText('search_type_value');
}

function getTblAttr(){
	return g_TableRowSetManager.get("AttrTable");
}

function addAttr(){
 	var url = "<%=request.getContextPath()%>/bce/configtool/autopage/attrconfig/addAttr.jsp?moduleId=<%=moduleId%>";
 	var flag = window.showModalDialog(url, <%=moduleId%>,"scroll:no;resizable:no;status:no;dialogHeight:420px;dialogWidth:600px");
 	if(flag == 1){
 		getSearchInfo();
 	}
}

function modAttr(){
	var row = getTblAttr().getRow();
	if(row == -1)
	{
		alert(crm_i18n_msg("BEC0000307"));
		return;
	}
 	var attrId = getTblAttr().getValue(row, "ATTR_ID");
	var url = "<%=request.getContextPath()%>/bce/configtool/autopage/attrconfig/addAttr.jsp?attrId="+attrId;
 	window.showModalDialog(url, <%=moduleId%>,"scroll:no;resizable:no;status:no;dialogHeight:420px;dialogWidth:600px");
 	getSearchInfo();
}

function delAttr(){
  var rows = getTblAttr().getSelectedRows();
  if(rows.length == 0){
    alert(crm_i18n_msg("BEC0000332"));
    return;
  }
  if(confirm(crm_i18n_msg("BEC0000015")+"?")){
  	for(var i=rows.length-1; i>=0; i--){
  	  getTblAttr().deleteRow(rows[i]);
		}
		  var list = new Array();
    	list.push(getTblAttr());
    	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
    	if (ud.getValueByName("FLAG") == "ERROR" ) {
			  alert(crm_i18n_msg("BEC0000013"));
			  return;
			}
		getSearchInfo();
  }
}


 function $(id){
        return document.getElementById(id);
        } 
        
		function getSearchInfo(){ 
    		var cond = '1=2 ' ;
    		var search_value = getValueFromSearchText ('search_type_value');
    			//解析查询条件，按空格分开
    			var args = search_value.split(/\s/);
    			if(args == null || args == ''){
    				cond = '1=1';
    			}else{
	    			for(i=0;i<args.length;i++){
	    				if(args[i]=='')continue;
	    				
	    				cond = cond + getCondtionSql(args[i]);
	    			}
    			}
    			cond= "("+cond+") AND (MODULE_ID =<%=moduleId%> or MODULE_ID = 0 or MODULE_ID is null)";
    		getTblAttr().refresh("cond="+cond);
    	}
    	
    	//根据查询类型返回条件
    	function getCondtionSql(args){
    			return " or REMARKS like '%" + args 
    				+ "%' or ATTR_ID  like '%" + args 
    				+ "%' or OBJ_NAME like '%"+args 
    				+ "%' or ATTR_CODE like '%"+args 
    				+ "%' or ATTR_NAME like '%"+args 
    				+ "%' or I18N_RES like '%"+args 
    				+ "%' or FIELD_TYPE like '%"+args 
    				+ "%' or RULE_ID like '%"+args 
    				+"%' ";	
    	}
    	
   		function getSelectedVal(id){
    	 	  var i = $(id).selectedIndex;
    		  return $(id).options[i].value;
        }
        
        function bImport(){
        	var rtnVal=window.showModalDialog("addAttrConfig.jsp?moduleId=<%=moduleId%>",'','dialogWidth:900px;dialogHeight:600px');
        	if(rtnVal == 1)
        		window.location.reload();
        }
</script>
