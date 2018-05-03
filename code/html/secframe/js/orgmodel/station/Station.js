Station = {
	gridLoad : function() {
		var gRowSet = g_TableRowSetManager.get("station_tbl");
		var tblCount = gRowSet.count();
		if (orgId == "" || orgId == null || orgRoleTypeId == "" || orgRoleTypeId == null) {
			return;
		}
		if (orgId == -1 || orgRoleTypeId == -1) {
			savebtn.disabled = true;
		} else {
			savebtn.disabled = false;
		}
		gRowSet.visibleSelect(-100, false);
		
		for (i = 0; i < tblCount; i++) {
			var fl = gRowSet.getValue(i, "FL");
			var stationId = gRowSet.getValue(i, "STATION_ID");
			if (fl == "STATION_TYPE_KIND") {
				gRowSet.setRowEditSts(i, false);
				gRowSet.visibleSelect(i, false);
				gRowSet.setValue(i, "ORGANIZE_ID", "");
			}
			if (fl == "STATION_TYPE" && stationId != null && stationId != "") {
				gRowSet.rowSelected(i, true, true);
			}
			if (fl == "STATION_TYPE") {
				gRowSet.setValue(i, "ORGANIZE_ID", orgId, orgName);
			}
			if (fl == "STATION_TYPE" && stationId == "") {
				gRowSet.setValue(i, "DEFAULT_DISPATCH_FLAG", "N", g_I18NMessage("secframe_station", "sec_stationtype_no"));
			}
			if (fl == "STATION_TYPE" && gRowSet.isSelected(i) == false) {
				gRowSet.setValue(i, "FL", "STATION_TYPE,DELETE");
			}
		}
		var gExsitRowSet = g_TableRowSetManager.get("tblExsitStation");
		gExsitRowSet.refresh("ORGANIZE_ID=" + orgId);
	},

	saveStation : function() {
		var gRowSet = g_TableRowSetManager.get("tblExsitStation");
		var list = new Array();
		list[0] = gRowSet;
		var retMsg = saveRowSet(_gModuleName + "/business/com.ai.secframe.orgmodel.web.SecStationAction?action=save", list);
		var gExsitRowSet = g_TableRowSetManager.get("tblExsitStation");
		gExsitRowSet.refresh("ORGANIZE_ID=" + orgId);
	},

	showStaffAction : function() {
		var gRowSet = g_TableRowSetManager.get("tblExsitStation");
		var curIndex = gRowSet.getRow();
		if (curIndex == -1) {
			alert(g_I18NMessage("secframe_station", "sec_station_notselect"));
			return;
		}
		var stationId = gRowSet.getValue(curIndex, "STATION_ID");
		var stationName = gRowSet.getValue(curIndex, "STATION_NAME");

		var paraArray = new Array();
		paraArray.push(stationId);
		paraArray.push(stationName);
		var d = new Date();
	},

	updateAction : function() {
		var gRowSet = g_TableRowSetManager.get("station_tbl");
		if (gRowSet.toXmlString(true) == "") return;
		
		var selRows = gRowSet.getSelectedRows();
		
		for ( var i = 0; i < selRows.length; i++) {
			if (gRowSet.getValue(i, "FL") == "STATION_TYPE" && gRowSet.getValue(i, "STATION_ID") != "") {
				if (gRowSet.getValue(i, "STATION_CODE") == null || gRowSet.getValue(i, "STATION_CODE") == "") {
					alert(g_I18NMessage("secframe_station", "sec_station_code_empty", (i + 1) + ""));
					gRowSet.setFocusByName(i, "STATION_CODE");
					return;
				}
				if (gRowSet.getValue(i, "STATION_NAME") == null || gRowSet.getValue(i, "STATION_NAME") == "") {
					alert(g_I18NMessage("secframe_station", "sec_station_name_empty", (i + 1) + ""));
					gRowSet.setFocusByName(i, "STATION_NAME");
					return;
				}
				if (gRowSet.getValue(i, "STATION_TYPE_ID") == null || gRowSet.getValue(i, "STATION_TYPE_ID") == "") {
					alert(g_I18NMessage("secframe_station", "sec_station_type_empty", (i + 1) + ""));
					gRowSet.setFocusByName(i, "STATION_TYPE_ID");
					return;
				}
				if (gRowSet.getValue(i, "ORGANIZE_ID") == null || gRowSet.getValue(i, "ORGANIZE_ID") == "") {
					alert(g_I18NMessage("secframe_station", "sec_station_organize_empty", (i + 1) + ""));
					gRowSet.setFocusByName(i, "ORGANIZE_ID");
					return;
				}
			}
		}
		
		var list = new Array();
		list.push(gRowSet);
		var retMsg = saveRowSet(_gModuleName + "/business/com.ai.secframe.orgmodel.web.SecStationAction?action=saveStation", list);
		var ret = retMsg.getValueByName("retVal");
		var msg = retMsg.getValueByName("msg");
		
		if (ret == 0) {
			alert(g_I18NMessage("secframe_station", "sec_station_saveok"));
		} else if (ret == -1) {
			alert(msg);
		} else if (ret == -2) {
			alert(g_I18NMessage("secframe_station", "sec_station_save_err", msg));
		} else {
			alert(g_I18NMessage("secframe_station", "sec_station_save_exception", ret));
		}
		
		gRowSet.refresh("orgId=" + orgId + "&orgRoleTypeId=" + orgRoleTypeId);
		Station.gridLoad();
	},

	deleteAction : function() {
		var gRowSet = g_TableRowSetManager.get("tblExsitStation");
		var gStationRowSet = g_TableRowSetManager.get("station_tbl");
		var selCount = gRowSet.getSelectedRows();
		var len = selCount.length;
		if (len <= 0) {
			alert(g_I18NMessage("secframe_station", "sec_station_delete_notselect"));
			return;
		}
		if (window.confirm(g_I18NMessage("secframe_station", "sec_station_delete_confirm"))) {
			for ( var i = len - 1; i >= 0; i--) {
				gRowSet.deleteRow(selCount[i]);
			}
			var list = new Array();
			list.push(gRowSet);
			var retMsg = saveRowSet(_gModuleName + "/business/com.ai.secframe.orgmodel.web.SecStationAction?action=deleteStation", list);
			var ret = retMsg.getValueByName("retVal");
			var msg = retMsg.getValueByName("msg");
			if (ret == "0") {
				alert(g_I18NMessage("secframe_station", "sec_station_deleteok"));
			} else {
				alert(g_I18NMessage("secframe_station", "sec_station_delete_notok", msg));
			}
			gStationRowSet.refresh("orgId=" + orgId + "&orgRoleTypeId=" + orgRoleTypeId);
			Station.gridLoad();
		}
	},

	selectAction : function(RowIndex, isSelected) {
		var gRowSet = g_TableRowSetManager.get("station_tbl");
		if (isSelected == true && gRowSet.getValue(RowIndex, "STATION_CODE") == "" && gRowSet.getValue(RowIndex, "STATION_NAME") == "") {
			gRowSet.setValue(RowIndex, "STATION_CODE", orgId + "-" + gRowSet.getValue(RowIndex, "STATIONTYPE_CODE"));
			gRowSet.setValue(RowIndex, "STATION_NAME", orgName + "-" + gRowSet.getValue(RowIndex, "STATIONTYPE_NAME"));
		}
		if (isSelected == false) {
			gRowSet.setValue(RowIndex, "FL", "STATION_TYPE,DELETE");
		}
		if (isSelected == true) {
			gRowSet.setValue(RowIndex, "FL", "STATION_TYPE");
		}
		if (isSelected == false) {
			gRowSet.setValue(RowIndex, "STATION_CODE", "");
			gRowSet.setValue(RowIndex, "STATION_NAME", "");
			gRowSet.setValue(RowIndex, "WORK_DESC", "");
			gRowSet.setValue(RowIndex, "NOTES", "");
		}
	},

	selectAll : function() {
		var gRowSet = g_TableRowSetManager.get("station_tbl");
		gRowSet.selectAll(true);
		var selRows = gRowSet.getSelectedRows();
		
		if (selRows != null && selRows.length > 0) {
			for ( var i = 0; i < selRows.length; i++) {
				if (gRowSet.getValue(selRows[i], "STATION_CODE") == "" && gRowSet.getValue(selRows[i], "STATION_NAME") == "") {
					gRowSet.setValue(selRows[i], "STATION_CODE", orgId + "-" + gRowSet.getValue(selRows[i], "STATIONTYPE_CODE"));
					gRowSet.setValue(selRows[i], "STATION_NAME", orgName + "-" + gRowSet.getValue(selRows[i], "STATIONTYPE_NAME"));
				}
				gRowSet.setValue(selRows[i], "FL", "STATION_TYPE");
			}
		}
	},

	notSelectAll : function() {
		var gRowSet = g_TableRowSetManager.get("station_tbl");
		gRowSet.selectAll(false);
		
		for ( var i = 0; i < gRowSet.count(); i++) {
			if (gRowSet.getValue(i, "FL") != "STATION_TYPE_KIND") {
				gRowSet.setValue(i, "FL", "STATION_TYPE,DELETE");
				gRowSet.setValue(i, "STATION_CODE", "");
				gRowSet.setValue(i, "STATION_NAME", "");
				gRowSet.setValue(i, "WORK_DESC", "");
				gRowSet.setValue(i, "NOTES", "");
			}
		}
	}
}