//ע�������ռ�
Namespace.register("com.ai.bce.ui.js.auto");
com.ai.bce.ui.js.auto.form = function() {
	this.onDbLink = function(pDBFormPk, pFieldName, val, text, para) {
		// ��ѯ�Ƿ���ȡ�����ĺ���
		// ����еĻ�����ȡ������
		var getFunctionName = pDBFormPk + "_" + pFieldName + "_getUrlParams";
		var urlParam ;
		try {
			if (typeof (eval(getFunctionName)) == "function") {
				eval(" urlParam = "+getFunctionName+"()");
			}
		} catch (e) {
		}
		
		var param = "";
		var aAttrAry = pFieldName.split("_");
		var nodeInfo = null;

		if (para != null && !g_StringTrim(para) == "") {

			var paraArray = para.split("|||");
			var aAttrAry = pFieldName.split("_");
			var attrId = "";
			if (aAttrAry[0] == "ATBATCH" || aAttrAry[0] == "AT"
					|| aAttrAry[0] == "SPAT") {
				attrId = aAttrAry[5];
			}
			if (paraArray != null && paraArray.length >= 2) {
				// ����Type
				var attrOpenWinType = paraArray[1];
				// ����ֱ�ӵ���
				var url = _gModuleName + paraArray[0];
				url += "?FIELD_NAME=" + pFieldName + "&FIELD_VALUE=" + val;
				if (param != null && param != "" && param != "undefined") {
					url += "&" + param;
				}

				// var filedInfo = pFieldName.split("_");
				var fieldName = pFieldName;

				// ����Ǹ�ѡ��
				if (attrOpenWinType == "11") {
					var filedValue = window
							.showModalDialog(
									url,
									window,
									"scroll:yes;resizable:no;help:no;status:no;dialogHeight:300px;dialogWidth:500px");
					if (filedValue != null) {
						valueAry = filedValue.split("|");
						var value = valueAry[0];
						var text = value;
						if (valueAry.length > 1) {
							text = valueAry[1];
						}
						g_FormRowSetManager.get(pDBFormPk).setValue(pFieldName,
								value, text);
					}
					return null;
				}

				// ��ͨ����
				if (attrOpenWinType == "12") {
					if(urlParam!=null){
						url+=urlParam; 
					}
					var filedValue = window
							.showModalDialog(
									url + window,
									"scroll:yes;resizable:no;help:no;status:no;dialogHeight:500px;dialogWidth:700px");
					if (filedValue != null) {
						var valueText = filedValue.split("|");
						if (valueText.length > 1) {
							g_FormRowSetManager.get(pDBFormPk).setValue(
									pFieldName, valueText[0], valueText[1]);
						} else {
							g_FormRowSetManager.get(pDBFormPk).setValue(
									pFieldName, valueText[0]);
						}
					}
					return null;
				}
				
				
				if(attrOpenWinType == "13"){
					return null;
				}
			}
		}
	}
}

var g_AiBceAutoForm = new com.ai.bce.ui.js.auto.form();