<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<html>
<%
	String rulesetId = HttpUtil.getParameter(request, "rulesetId");
	String rulesetType = HttpUtil.getParameter(request, "rulesetType");
	if (null == rulesetId || "".equals(rulesetId)) {
		rulesetId = "-1";
	}
	String cond = "RESULT_ID = "+rulesetId;
	String moduleId = HttpUtil.getAsString(request,"module_id");
	if(null != moduleId && !"".equals(moduleId)){
		request.setAttribute(" cond"," and MODULE_ID="+moduleId + " or module_id='0' or module_id is null");
	}
%>
<head>
	<script language="javascript" src="../common/js/configtool.js"></script>
</head>
<body onLoad="init()">
		<ai:table tableid="ruleDBTable" setname="com.ai.bce.web.QBceRulesetRule" needrefresh="true"
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" 
			implservice_name = "com.ai.bce.configtool.service.interfaces.IConfRuleSV"
			implservice_querymethod = "getRulesetRulesByRulesetId(String cond, int $STARTROWINDEX, int $ENDROWINDEX)"
			implservice_countmethod="getRulesetRulesByRulesetIdCount(String cond)"	
			initial="true" height="100" width="100%" editable="false" multiselect="false"
			footdisplay="block" pagesize="8" rowsequence="true" 
			onrowchange="" ondbclick="showDetailInfo">
			<ai:col fieldname="RELATE_ID" width="100"/>
			<ai:col fieldname="RULESET_ID" width="100"/>
			<ai:col fieldname="RULE_ID" width="100"/>
			<ai:col fieldname="RULE_NAME" width="150"/>
			<ai:col fieldname="RULE_TRIGGER_TYPE" width="80"/>
			<ai:col fieldname="EVENT_OBJ_TYPE" width="80"/>
			<ai:col fieldname="OBJ_NAME" width="100"/>
			<ai:col fieldname="CHILD_OBJ_NAME" width="100"/>
			<ai:col fieldname="EVENT_NAME" width="100"/>
			<ai:col fieldname="VERIFY_TYPE" width="100"/>
			<ai:col fieldname="RULE_KIND" width="100"/>
			<ai:col fieldname="RULE_TYPE" width="100"/>
			<ai:col fieldname="FILE_NAME" width="150"/>	
			<ai:col fieldname="FUNC_NAME" width="100"/>					
			<ai:col fieldname="PARAM_LIST" width="150"/>
			<ai:col fieldname="PARAM_VALUE_LIST" width="150"/>
			<ai:col fieldname="SEQ_NO" width="100"/>
			<ai:col fieldname="MODULE_ID" width="100"/>
			<ai:col fieldname="REMARKS" width="100"/>
		</ai:table>
	<div class="area_button">
			<ai:button text="BES0000322" onclick = "add()" style="cursor:hand" enable="true" i18nRes="CRM"/>&nbsp;&nbsp;
			<ai:button text="BES0000323" onclick = "edit()" style="cursor:hand" enable="true" i18nRes="CRM"/>&nbsp;&nbsp;
			<ai:button text="BES0000324" onclick = "del()" style="cursor:hand" enable="true" i18nRes="CRM"/>&nbsp;&nbsp;
	</div>
</body>
<script type="text/javascript">
	var rulesetId = <%=rulesetId%>;
	function init(){
	    var rulesetId = "<%=rulesetId%>";
	    var condition = "cond=" + rulesetId;
	    getRuleDBTable().refresh(condition);
    }
	
	function getRuleDBTable(){
		return g_TableRowSetManager.get("ruleDBTable");
	}

	/** 新增	*/
	function add(){
		if(rulesetId == "-1"){
			alert(crm_i18n_msg("BEC0000310"));
			return;
		}
				
		var dbTable = getRuleDBTable();
		var relateId = -1;
		var retObj = window.showModalDialog("<%=request.getContextPath()%>/bce/configtool/rulesetrule/detail.jsp?rulesetId=" 
				+ rulesetId + "&ruleId=-1" + "&relateId=" + relateId + "&rulesetType=<%=rulesetType%>&isEditable=-1"
				, <%=moduleId%>, "dialogWidth=800px;dialogHeight=350px");
	    var condition = "cond=" + rulesetId;
	    getRuleDBTable().refresh(condition);
	    refreshTopByQuoteChange();
	}

	/** 修改	*/
	function edit(){
		var dbTable = getRuleDBTable();
		var index = dbTable.getRow();
		if(index <0){
			alert(crm_i18n_msg("BEC0000307"));
			return;
		}
		var rulesetId = dbTable.getValue(index, "RULESET_ID");
		var ruleId = dbTable.getValue(index, "RULE_ID");
		var relateId = dbTable.getValue(index, "RELATE_ID");
		var retObj = window.showModalDialog("<%=request.getContextPath()%>/bce/configtool/rulesetrule/detail.jsp?rulesetId=" 
				+ rulesetId + "&ruleId=" + ruleId + "&relateId=" + relateId + "&rulesetType=<%=rulesetType%>&isEditable=2"
				, <%=moduleId%>, "dialogWidth=800px;dialogHeight=350px");
	    var condition = "cond=" + rulesetId;
	    getRuleDBTable().refresh(condition);
	    refreshTopByQuoteChange();
	}

	/** 删除 */
	function del(){
		var dbTable = getRuleDBTable();
		var index = dbTable.getRow();
		if(index <0){
			alert(crm_i18n_msg("BEC0000307"));
			return;
		}
		var ruleId = dbTable.getValue(index, "RULE_ID");
		var rulesetId = dbTable.getValue(index, "RULESET_ID");
		var result = confirm(crm_i18n_msg("BEC0000309", rulesetId, ruleId));
		if(result == false){
			return;
		}else{
	    	dbTable.deleteRow(index);
	    	var list = new Array();
	    	list.push(dbTable);
	    var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.configtool.web.ConfRulesetRuleAction?action=saveRulesetRule",list,false);
			if (ud.getValueByName("FLAG") == "ERROR") {
			  if(!ud.getValueByName("MESSAGE"))
			    alert(crm_i18n_msg("BEC0000013"));
				return;
			}
		    var condition = "cond=" + rulesetId;
		    getRuleDBTable().refresh(condition);
		    refreshTopByQuoteChange();
		}
	}

	/** 双击显示详细信息 */
	function showDetailInfo(){
		var dbTable = getRuleDBTable();
		var index = dbTable.getRow();
		if(index <0){
			alert(crm_i18n_msg("BEC0000307"));
			return;
		}
		var rulesetId = dbTable.getValue(index, "RULESET_ID");
		var ruleId = dbTable.getValue(index, "RULE_ID");
		var relateId = dbTable.getValue(index, "RELATE_ID");
		var retObj = window.showModalDialog("<%=request.getContextPath()%>/bce/configtool/rulesetrule/detail.jsp?rulesetId=" 
				+ rulesetId + "&ruleId=" + ruleId + "&relateId=" + relateId + "&rulesetType=<%=rulesetType%>&isEditable=0"
				, "", "scroll:no;resizable:no;help:no;status:no;dialogHeight:350px;dialogWidth:700px");
	}
</script>
</html>