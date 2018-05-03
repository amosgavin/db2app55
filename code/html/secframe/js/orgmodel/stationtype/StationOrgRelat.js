StationOrgRelat = {
	roleStationTypeReload : function() {
		if (curRoleId == null) {
			curRoleId = -1;
			curRoleName = "";
		}
		if (curRoleId == -1) {
			// 设置岗位类型的操作按钮为不可视
			StationOrgRelat.setBtnVisible(false);
		} else {
			StationOrgRelat.setBtnVisible(true);
		}
		var stationTypeRowSet = g_TableRowSetManager.get("tblStationType");
		var cond = "orgRoleTypeId=" + curRoleId;
		
		stationTypeRowSet.refresh(cond);
		
		var tblCount = stationTypeRowSet.count();
		stationTypeRowSet.visibleSelect(-100, false);
		for (i = 0; i < tblCount; i++) {
			var fl = stationTypeRowSet.getValue(i, "FL");
			if (fl == "STATION_TYPE_KIND") {
				stationTypeRowSet.visibleSelect(i, false);
			}
			flag = fl.split(":");
			if (flag.length == 2 && flag[1] == "SELECT") {
				stationTypeRowSet.rowSelected(i, true, true);
			}
		}
	},

	updateStationTypeAction : function(flag) {
		var stationType = g_TableRowSetManager.get("tblStationType");
		if (stationType.toXmlString(true) == "") {
			return;
		}
		var list = new Array();
		list.push(stationType);
		var url = _gModuleName + "/business/com.ai.secframe.orgmodel.web.SecStationTypeModel?" +
								"action=saveStationTypeRoleTypeRelate&partyRoleTypeId=" + curRoleId;
		var retMsg = saveRowSet(url, list, false);
		var retVal = retMsg.getValueByName("retVal");
		if (retVal == "OK") {
			alert(g_I18NMessage("secframe_station", "sec_station_saveok"));			
		} else {
			alert(retVal);
		}
		StationOrgRelat.roleStationTypeReload();
	},

	setBtnVisible : function(flag) {	
		//document.getElementById("updateStationTypeBtn").disabled = (!flag);
		g_AIButtonManager.get("updateStationTypeBtn").setDisabled(!flag);
	},

	select : function() {
		var dbtree = g_DBTreeNewManager.get("tree");
		var curNode = dbtree.getCurNodeInfo();
		if (curNode == null) return;
		curRoleId = curNode.value;
		curRoleName = curNode.text;
		StationOrgRelat.roleStationTypeReload();
	},

	selectAction : function(RowIndex, isSelected) {
		var gRowSet = g_TableRowSetManager.get("tblStationType");
		if (isSelected == true) {
			gRowSet.setValue(RowIndex, "FL", "STATION_TYPE:SELECT");
		} else {
			gRowSet.setValue(RowIndex, "FL", "STATION_TYPE");
		}
	}
}