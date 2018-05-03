LoginLog = {
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

	queryLoginLog : function() {
		var loginQueryForm = g_FormRowSetManager.get("loginLogForm");
		var loginLogInfoTable = g_TableRowSetManager.get("loginLogInfo");
		var staffCode = loginQueryForm.getValue("STAFF_CODE");
		
		if (staffCode.indexOf(" ") >= 0 || staffCode.indexOf("&") >= 0) {
			alert(g_I18NMessage("secframe_log", "sec_log_staffcode_invalid"));
			loginQueryForm.setFocus("STAFF_CODE");
			return;
		}
		var ip = loginQueryForm.getValue("IP");

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
		param = "staffCode=" + staffCode + "&ip=" + ip + "&startDate=" + startDate + "&endDate=" + endDate;
		loginLogInfoTable.refresh(param);
	}
}