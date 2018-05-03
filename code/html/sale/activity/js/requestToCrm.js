var sys_name = g_GetUserInfo().STAFF_NAME;
var operatorID = "1001866";
if (sys_name == "王璨") {
	operatorID = "1001808";
} else if (sys_name == "张雯") {
	operatorID = "1001830"
} else if (sys_name == "杜玖") {
	operatorID = "1001880"
} else if (sys_name == "张铮") {
	operatorID = "1001818"
}
//  查询接口-CRM
function query_CRM(interfaceID, privID, prodID) {
	//var region = privID.substr(3, 3);
	var region = '999';
	if (region == '')
		region = prodID.substr(3, 3);
	var param = "{'head': {'accessType': 'bsacMktmgr','interfaceID': 'MRTMGR"
			+ interfaceID
			+ "','reqTime':'20140711173759', 'reqSeq':'1000000005', 'operatorID':'"
			+ operatorID + "', 'region':'" + region + "'},'body': {'privID': '"
			+ privID + "','prodID': '" + prodID + "'}}";
	try {

		var ret = PostInfo(_gModuleName
				+ '/business/com.asiainfo.common.web.ConnCRMClientAction?action=requestCrm&interfaceID='
				+ interfaceID + '&param=' + param);
		if (ret.getValueByName('FLAG') == 'Y') {
			return jQuery.parseJSON(ret.getValueByName('jsonStr'));
		} else {
			return '';
		}
	} catch (e) {
		return '';
	}
}

//  审核接口-CRM
function audit_CRM(interfaceID, privID, prodID, modeID, auditStatus) {
	//var region = privID.substr(3, 3);
	var region = '999';
	var param = "{'head': {'accessType': 'bsacMktmgr','interfaceID': 'MRTMGR"
			+ interfaceID
			+ "','reqTime':'20140331173759', 'reqSeq':'1000000001', 'operatorID':'"
			+ operatorID + "', 'region':'" + region + "'},'body': {'privID': '"
			+ privID + "','prodID': '" + prodID + "','MODOID': '" + modeID
			+ "','AUDITSTATUS': '" + auditStatus + "'}}";

	try {
		var ret = PostInfo(_gModuleName
				+ '/business/com.asiainfo.common.web.ConnCRMClientAction?action=requestCrm&interfaceID='
				+ interfaceID + '&param=' + param);
		if (ret.getValueByName('FLAG') == 'Y') {
			return jQuery.parseJSON(ret.getValueByName('jsonStr'));
		} else {
			return '';
		}
	} catch (e) {
		return '';
	}
}

//  活动批次、档次ID校验接口-CRM
function check_CRM(interfaceID, privID, prodID) {
	//var region = privID.substr(3, 3);
	var region = '999';
	var param = "{'head': {'accessType': 'bsacMktmgr','interfaceID': 'MRTMGR"
			+ interfaceID
			+ "','reqTime':'20140331173759', 'reqSeq':'1000000001', 'operatorID':'"
			+ operatorID + "', 'region':'" + region + "'},'body': {'privID': '"
			+ privID + "','prodID': '" + prodID + "'}}";
	try {
		var ret = PostInfo(_gModuleName
				+ '/business/com.asiainfo.common.web.ConnCRMClientAction?action=requestCrm&interfaceID='
				+ interfaceID + '&param=' + param);
		if (ret.getValueByName('FLAG') == 'Y') {
			return jQuery.parseJSON(ret.getValueByName('jsonStr'));
		} else {
			return '';
		}
	} catch (e) {
		return '';
	}
}
