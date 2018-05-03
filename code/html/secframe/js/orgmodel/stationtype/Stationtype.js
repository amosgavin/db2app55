Stationtype = {
	reloadForm : function() {
		var conStr = "";
		Stationtype.setBtnDisabled(false);
		
		var stationTypeRowSet = g_FormRowSetManager.get("stationtypeform");
		var stationTypeKindRowSet = g_FormRowSetManager.get("stationtypekindform");
		var dbtree = g_DBTreeNewManager.get("stationtype_tree");
		var curNode = dbtree.getCurNodeInfo();
		var fl = curNode.userobj;

		if (curNode.value == -1)
			return;

		var vv = dbtree.getParentNodeInfo(curNode.value).text;
		if (curNode == null) {
			Stationtype.setBtnDisabled(true);
			return;
		}
		if (stationType == true) {
			fl = "STATION_TYPE";
		}

		if (fl == "STATION_TYPE") {
			document.getElementById("station_type").style.display = "block";
			document.getElementById("station_type_kind").style.display = "none";
			var curStationTypeId = curNode.value;
			conStr = "STATE=1 and STATION_TYPE_ID=" + curStationTypeId;
			stationTypeRowSet.refresh(conStr);
		} else {
			document.getElementById("station_type").style.display = "none";
			document.getElementById("station_type_kind").style.display = "block";
			var curKindId = curNode.value;
			if (curKindId == -1) {
				g_AIButtonManager.get("saveKind").setDisabled(true);
				g_AIButtonManager.get("delKind").setDisabled(true);
				g_AIButtonManager.get("addType").setDisabled(true);
			} else {
				g_AIButtonManager.get("saveKind").setDisabled(false);
				g_AIButtonManager.get("delKind").setDisabled(false);
				g_AIButtonManager.get("addType").setDisabled(false);
			}
			conStr = "STATE=1 and KIND_ID=" + curKindId;
			stationTypeKindRowSet.refresh(conStr);
		}
		if (stationType == true) {
			tempKindId = curNode.value;
			stationTypeRowSet.setValue("KIND_ID", curNode.text, curNode.text);
			stationType = false;
		} else {
			tempKindId = dbtree.getParentNodeInfo(curNode.value).value;
			stationTypeRowSet.setValue("KIND_ID", vv, vv);
		}
	},

	setBtnDisabled : function(flag) {
		if (document.getElementById("station_type").style.display == "block") {
			g_AIButtonManager.get("saveStationType").setDisabled(flag);
			g_AIButtonManager.get("delStationType").setDisabled(flag);
		}
		if (document.getElementById("station_type_kind").style.display == "block") {
			g_AIButtonManager.get("saveKind").setDisabled(flag);
			g_AIButtonManager.get("delKind").setDisabled(flag);
			g_AIButtonManager.get("addType").setDisabled(flag);
			g_AIButtonManager.get("addKind").setDisabled(flag);
		}
	},

	refreshTree : function() {
		var dbtree = g_DBTreeNewManager.get("stationtype_tree");
		var ud = dbtree.refresh(null, -1);
	},

	delStationTypeKindAction : function() {
		return;
		var dbtree = g_DBTreeNewManager.get("stationtype_tree");
		var curNode = dbtree.getCurNodeInfo();
		if (curNode != null) {
			if (window.confirm(g_I18NMessage("secframe_station", "sec_stationtype_confirm_deletekind"))) {
				var parent_value = dbtree.getParentNodeInfo(curNode.value).value;
				var stationTypeKindRowSet = g_FormRowSetManager
						.get("stationtypekindform");
				stationTypeKindRowSet.setStsToDel();
				var list = new Array();
				list.push(stationTypeKindRowSet);
				var retMsg = saveRowSet(
						_gModuleName + "/business/com.ai.secframe.orgmodel.web.SecStationTypeModel?action=saveStationTypeKind", list);
				var retVal = retMsg.getValueByName("retVal");

				if (retVal == "OK") {
					alert(g_I18NMessage("secframe_station", "sec_stationtype_deletekindok"));
					Stationtype.reloadForm();
					dbtree.refresh(parent_value);
					dbtree.setNodeSelect(parent_value);
				} else {
					alert(retVal);
				}
			}
		} else {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_notselect"));
		}
	},

	delStationTypeAction : function() {
		return;
		var dbtree = g_DBTreeNewManager.get("stationtype_tree");
		var curNode = dbtree.getCurNodeInfo();
		if (curNode == null) {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_notselect"));
			return;
		}

		if (!window.confirm(g_I18NMessage("secframe_station", "sec_stationtype_confirm_deletetype"))) return;

		var parent_value = dbtree.getParentNodeInfo(curNode.value).value;
		var stationTypeRowSet = g_FormRowSetManager.get("stationtypeform");
		stationTypeRowSet.setValue("KIND_ID", '0', '0');
		stationTypeRowSet.setValue("NOTES",
				stationTypeRowSet.getValue("NOTES") + ' ', stationTypeRowSet
						.getValue("NOTES") + ' ');
		var list = new Array();
		list.push(stationTypeRowSet);

		var retMsg = saveRowSet(
				_gModuleName + "/business/com.ai.secframe.orgmodel.web.SecStationTypeModel?action=saveStationType&del=Y", list);
		var retVal = retMsg.getValueByName("retVal");

		if (retVal == "OK") {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_deletetypeok"));
			Stationtype.reloadForm();
			dbtree.refresh(parent_value);
			dbtree.setNodeSelect(parent_value);
		} else {
			alert(retVal);
		}
	},

	updateStationTypeKindAction : function() {
		var dbtree = g_DBTreeNewManager.get("stationtype_tree");
		var curNode = dbtree.getCurNodeInfo();
		var stationTypeKindRowSet = g_FormRowSetManager
				.get("stationtypekindform");
		if (stationTypeKindRowSet.toXmlString() == "") {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_nochange"));
			return;
		}
		var name = stationTypeKindRowSet.getValue("KIND_NAME");
		if (name == null || name == "") {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_kindname_empty"));
			return;
		}
		if (/[^a-zA-Z0-9\u4e00-\u9fa5]/g.test(name)) {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_kindname_invalid"));
			return;
		}
		var sortId = stationTypeKindRowSet.getValue("SORT_ID");
		if (g_IsDigit(sortId) == false) {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_sort_invalid"));
			stationTypeKindRowSet.setValue("SORT_ID", "");
			stationTypeKindRowSet.setFocus("SORT_ID");
			return;
		}
		if (g_GetStrLen(sortId) > 3) {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_sort_checklength", "3"));
			stationTypeKindRowSet.setValue("SORT_ID", "");
			stationTypeKindRowSet.setFocus("SORT_ID");
			return;
		}
		var list = new Array();
		list.push(stationTypeKindRowSet);
		var retMsg = saveRowSet(
				_gModuleName
				+ "/business/com.ai.secframe.orgmodel.web.SecStationTypeModel?action=saveStationTypeKind", list);
		var retVal = retMsg.getValueByName("retVal");

		if (retVal == "OK") {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_savekindok"));
			Stationtype.reloadForm();
			var dbtree = g_DBTreeNewManager.get("stationtype_tree");
			var node = dbtree.getCurNodeInfo();
			if (node.value == "-1") {
				dbtree.refresh(null, -1);
			} else {
				dbtree.setCurNodeInfo(node.value, name, node.userobj);
				var curParNode = dbtree.getParentNodeInfo(node.value);
				dbtree.refresh(curParNode.value);
				dbtree.expandNodeByValue(node.value, true);
				dbtree.expandNodeByValue(curParNode.value, true);
			}
		} else {
			alert(retVal);
		}
	},

	updateStationTypeAction : function() {
		var dbtree = g_DBTreeNewManager.get("stationtype_tree");
		var curNode = dbtree.getCurNodeInfo();
		var stationTypeRowSet = g_FormRowSetManager.get("stationtypeform");

		if (stationTypeRowSet.toXmlString() == "") {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_nochange"));
			return;
		}
		// alert(tempKindId);
		stationTypeRowSet.setValue("KIND_ID", tempKindId, tempKindId);
		var code = stationTypeRowSet.getValue("CODE");
		if (code == null || code == "") {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_kindid_empty"));
			return;
		}
		if (/[^a-zA-Z0-9\-\_]/g.test(code)) {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_code_invalid"));
			return;
		}
		var name = stationTypeRowSet.getValue("NAME");
		if (name == null || name == "") {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_kindname_empty"));
			return;
		}
		if (/[^a-zA-Z0-9\u4e00-\u9fa5]/g.test(name)) {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_name_invalid"));
			return;
		}
		var sortId = stationTypeRowSet.getValue("SORT_ID");
		if (g_IsDigit(sortId) == false) {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_sort_invalid"));
			stationTypeRowSet.setValue("SORT_ID", "");
			stationTypeRowSet.setFocus("SORT_ID");
			return;
		}
		if (g_GetStrLen(sortId) > 3) {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_sort_checklength", "3"));
			stationTypeRowSet.setValue("SORT_ID", "");
			stationTypeRowSet.setFocus("SORT_ID");
			return;
		}
		var list = new Array();
		list.push(stationTypeRowSet);
		var retMsg = saveRowSet(
				_gModuleName
				+ "/business/com.ai.secframe.orgmodel.web.SecStationTypeModel?action=saveStationType", list);
		var retVal = retMsg.getValueByName("retVal");
	
		if (retVal == "OK") {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_savetypeok"));
			Stationtype.reloadForm();
			var node = dbtree.getCurNodeInfo();
			dbtree.setCurNodeInfo(node.value, name, node.userobj);
			var curParNode = dbtree.getParentNodeInfo(node.value);
			dbtree.refresh(curParNode.value);
			dbtree.expandNodeByValue(node.value, true);
			dbtree.expandNodeByValue(curParNode.value, true);
		} else {
			alert(retVal);
		}
	},
	
	newStationTypeKindAction : function() {
		var dbtree = g_DBTreeNewManager.get("stationtype_tree");
		var stationTypeKindRowSet = g_FormRowSetManager.get("stationtypekindform");
		var curNode = dbtree.getCurNodeInfo();
		if (curNode == null) {
			alert(g_I18NMessage("secframe_station", "sec_stationtype_notselect"));
			return;
		}
		stationTypeKindRowSet.refresh("KIND_ID=-1");
		stationTypeKindRowSet.setValue("PARENT_KIND_ID", curNode.value);
	},
	
	newStationTypeAction : function() {
		stationType = true;
		Stationtype.reloadForm();
	    var stationTypeRowSet = g_FormRowSetManager.get("stationtypeform");
	    stationTypeRowSet.setValue("STATION_TYPE_ID","0");
		stationTypeRowSet.setValue("CODE","");
		stationTypeRowSet.setValue("NAME","");
        stationTypeRowSet.setValue("SORT_ID","");
        stationTypeRowSet.setValue("NOTES","");
	}
}