OperateLog = {
	init : function() {
		if (curdate != null && curdate != "" && curdate.length != 0) {
			curdate = curdate.split(" ");
		} else {
			alert(g_I18NMessage("secframe_log", "sec_log_sysdate_null"));
			return;
		}
		document.getElementById("startDate").value = curdate[0] + " 00:00:00";
		document.getElementById("endDate").value = curdate[0] + " 23:59:59";
	},

	queryOperateLog : function() {
		var operateQueryForm = g_FormRowSetManager.get("operateQueryForm");
		var operateLogInfoTable = g_TableRowSetManager.get("operateLogInfo");
		var staffCode = operateQueryForm.getValue("CONTENT");
		if (staffCode.indexOf(" ") >= 0 || staffCode.indexOf("&") >= 0) {
			alert(g_I18NMessage("secframe_log", "sec_log_staffcode_invalid"));
			operateQueryForm.setFocus("CONTENT");
			return;
		}
		
		var ORG_ID = operateQueryForm.getValue("ORG_ID");
		var operateType = operateQueryForm.getValue("OPERATE_TYPE");
		var operateLogType = operateQueryForm.getValue("OPERATE_LOG_TYPE");
		var startDate = document.getElementById("startDate").value;
		var endDate = document.getElementById("endDate").value;
		
		if (startDate == "" || endDate == "") {
			alert(g_I18NMessage("secframe_log", "sec_log_query_date_null"));
		}
		if (g_CompareDate(endDate, startDate) == -1) {
			alert(g_I18NMessage("secframe_log", "sec_log_comparedate_err"));
			return;
		}
		var param = "";
		param = "staffCode=" + staffCode + "&orgID=" + ORG_ID + "&operateType="
				+ operateType + "&operateLogType=" + operateLogType
				+ "&startDate=" + startDate + "&endDate=" + endDate;
		operateLogInfoTable.refresh(param);
	},

	orgSelect : function() {
		var operateQueryForm = g_FormRowSetManager.get("operateQueryForm");
		var url = _gModuleName + "/secframe/orgmodel/operator/OrgRelate.jsp";
	 	var result = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:no;dialogHeight:450px;dialogWidth:300px");
		if (result != null) {
			operateQueryForm.setValue("TABLE_NAME_OP", result.text, null);
			operateQueryForm.setValue("ORG_ID", result.value, null);
		}
	}
}