<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>

<html>

	<head>
		<title><%=LocaleResourceFactory.getResource("BES0000637")%></title>
	</head>

	<body onload="init()">
		<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem>
			</ai:contractitem>

			<table width="100%">
				<tr>
					<td>
						<select id="search_type" style="width: 200px;">
							<option value="search_all">
								<%=LocaleResourceFactory.getResource("BES0000047")%>
							</option>
							<option value="OBJ_NAME">
								<%=LocaleResourceFactory.getResource("BES0000122")%>
							</option>
							<option value="ATTR_NAME">
								<%=LocaleResourceFactory.getResource("BES0000116")%>
							</option>
						</select>
					</td>
					<td>
						<input type="text" id="remark" name="remark">
						&nbsp;
					</td>
					<td align="center">
						<ai:button text="BES0000325" i18nRes="CRM"
							onclick="getSearchInfo()" style="cursor:hand" />
					</td>
				</tr>
			</table>
		</ai:contractframe>
		<ai:table tableid="AttrTable" setname="com.ai.bce.web.BceAttr"
			needrefresh="true"
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			conditionname="condition"
			implservice_name="com.ai.bce.configtool.service.interfaces.IConfFrameAreaFormSV"
			implservice_querymethod="getBceAttr(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
			implservice_countmethod="getBceAttrCount(String cond)"
			initial="false" height="320" width="100%" editable="true"
			multiselect="true" footdisplay="block" pagesize="10"
			rowsequence="false">
			<ai:col fieldname="ATTR_ID" />
			<ai:col fieldname="ATTR_NAME" />
			<ai:col fieldname="ATTR_CODE" />
			<ai:col fieldname="EDIT_TYPE" />
			<ai:col fieldname="OBJ_NAME" />
			<ai:col fieldname="FIELD_TYPE" />
			<ai:col fieldname="MODULE_ID" />
			<ai:col fieldname="STATE" />
			<ai:col fieldname="I18N_RES" />
			<ai:col fieldname="IS_NULLABLE" />
			<ai:col fieldname="COL_SPAN" />
			<ai:col fieldname="FIELD_WIDTH" />
			<ai:col fieldname="FIELD_HEIGHT" />
			<ai:col fieldname="MAX_LENGTH" />
			<ai:col fieldname="REMARKS"/>
			<ai:col fieldname="RES_SRC" />
			<ai:col fieldname="RES_PARAM" />
			<ai:col fieldname="RULE_ID" />
			<ai:col fieldname="VALUE_CLASS" />
			<ai:col fieldname="DEFAULT_VALUE" />
			<ai:col fieldname="IS_MULTIVALUEABLE" />
		</ai:table>
		<div class="area_button">
			<ai:button text="BES0000762" i18nRes="CRM" onclick="returnAttrs()" />
			<ai:button text="BES0000480" i18nRes="CRM" onclick="cancel()" />
		</div>
	</body>
</html>

<script type="text/javascript">
function getTblAttr(){
  return g_TableRowSetManager.get("AttrTable");
}

function init(){
  if(getTblAttr().count()>0){
    for(var i=0;i<getTblAttr().count();i++){
      getTblAttr().setRowEditSts(i,false);
    }
  }
  getSearchInfo();
}

function addAttr(){
  if(getTblAttr().count()>0){
    for(var i=0;i<getTblAttr().count();i++){
      getTblAttr().setRowEditSts(i,false);
    }
  }
  getTblAttr().newRow();
  var row = getTblAttr().getRow();
  getTblAttr().setRowEditSts(row,true);
	getTblAttr().setCellEditSts(row,"ATTR_ID",false);
}

function modAttr(){
  if(getTblAttr().count()>0){
    for(var i=0;i<getTblAttr().count();i++){
      getTblAttr().setRowEditSts(i,false);
    }
  }
  var row = getTblAttr().getRow();
  getTblAttr().setRowEditSts(row,true);
	getTblAttr().setCellEditSts(row,"ATTR_ID",false);
}

function delAttr(){
  var rows = getTblAttr().getSelectedRows();
  if(rows.length == 0){
    alert(crm_i18n_msg("BEC0000014"));
    return;
  }
  if(confirm(crm_i18n_msg("BEC0000015"))){
    for(var i=rows.length-1;i>=0;i--){
      getTblAttr().deleteRow(rows[i]);
    }
    alert(crm_i18n_msg("BEC0000020"));
  }
}

function saveAttr(){
  if(getTblAttr().toXmlString() == ""){
     alert(crm_i18n_msg("BEC0000021"));
    return;
  }
  var list = new Array();
  list.push(getTblAttr());
  var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
	if (ud.getValueByName("FLAG") == "ERROR" ) {
	  if(!ud.getValueByName("MESSAGE"))
		alert(crm_i18n_msg("BEC0000013"));
		return;
	}
	getSearchInfo();
  if(getTblAttr().count()>0){
    for(var i=0;i<getTblAttr().count();i++){
      getTblAttr().setRowEditSts(i,false);
    }
  }
}

function returnAttrs(){
  var tblAttr = getTblAttr();
  var rows = tblAttr.getSelectedRows();
  if(rows.length == 0){
    alert(crm_i18n_msg("BEC0000023"));
    return;
  }
  var bceAttrs = new Array();
  for(var i=0;i<rows.length;i++){
  	var attrId = tblAttr.getValue(rows[i],"ATTR_ID");
  	var attrName = tblAttr.getValue(rows[i],"ATTR_NAME");
  	var moduleId = tblAttr.getValue(rows[i],"MODULE_ID");
  	var isNullable = tblAttr.getValue(rows[i],"IS_NULLABLE")==''?'1':tblAttr.getValue(rows[i],"IS_NULLABLE");
  	var editType = tblAttr.getValue(rows[i],"EDIT_TYPE")==''?'0':tblAttr.getValue(rows[i],"EDIT_TYPE");
  	var maxLength = tblAttr.getValue(rows[i],"MAX_LENGTH");
  	var fieldWidth =  tblAttr.getValue(rows[i],"FIELD_WIDTH");
  	var resSrc = tblAttr.getValue(rows[i],"RES_SRC");
  	var resParam = tblAttr.getValue(rows[i],"RES_PARAM");
  	var defaultValue = tblAttr.getValue(rows[i],"DEFAULT_VALUE");
  	var valueClass = tblAttr.getValue(rows[i],"VALUE_CLASS");
  	var bceAttr = {attrId:attrId,attrName:attrName,moduleId:moduleId,isNullable:isNullable,fieldWidth:fieldWidth,editType:editType,maxLength:maxLength,resSrc:resSrc,resParam:resParam,defaultValue:defaultValue,valueClass:valueClass};
    bceAttrs.push(bceAttr);
  }
    window.returnValue = bceAttrs;
    window.close();
}


		function $(id){
        	return document.getElementById(id);
        } 
        
		function getSearchInfo(){ 
			var moduleId = window.dialogArguments;
    		var cond = " 1=1 "
			if(moduleId != null && moduleId != ''){
    			cond = " (module_id="+moduleId+" or module_id='0' or module_id is null ) ";
    		}
    	
    		var search_value = $("remark").value;
    		
    		if(search_value !=''){
    			cond += " and (1=2 ";
    			var search_type = getSelectedVal("search_type");
    			//解析查询条件，按空格分开
    			var args = search_value.split(/\s/);
    			for(i=0;i<args.length;i++){
    				if(args[i]=='')continue;
    				
    				cond = cond + getCondtionSql(search_type ,args[i]);
    			}
    				cond+=")";
    			}
    		getTblAttr().refresh("cond="+cond);
    	}
    	
    	//根据查询类型返回条件
    	function getCondtionSql(search_type ,args){
    	if(search_type !='search_all'){
    			return " or " + search_type + " like '%" + args + "%'";
    		}
    			return " or REMARKS like '%" + args 
    				+ "%' or MODULE_ID  like '%" + args 
    				+ "%' or ATTR_CODE  like '%" + args 
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


function cancel(){
	window.close();
}
</script>
