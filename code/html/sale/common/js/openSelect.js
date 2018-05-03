var openSelect = {};

openSelect.staffSelect = function (type, org_id, orgId, roleId){
	var condition = "";
	if(null != orgId && "null" != orgId && "" != orgId && undefined != orgId && "undefined" != orgId){
		condition = condition + "&orgId=" + orgId;
	}
	if(null != roleId && "null" != roleId && "" != roleId && undefined != roleId && "undefined" != roleId){
		condition = condition + "&roleId=" + roleId;
	}
	if("tsd" == type){
	    var url = _gModuleName + "/sale/common/modaldialog/StaffSelect_ss.jsp?org_id=" + org_id +condition;
	    var style = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:670px";
	    return window.showModalDialog(url, null, style);
	} else if("tmd" == type){
	    var url = _gModuleName + "/sale/common/modaldialog/StaffSelect_s.jsp?org_id=" + org_id +condition;
	    var style = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:680px;dialogWidth:670px";
	    return window.showModalDialog(url, null, style);
	} else if("md" == type){
	    var url = _gModuleName + "/sale/common/modaldialog/StaffSelect_s2.jsp?org_id=" + org_id +condition;
	    var style = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:310px;dialogWidth:430px";
	    return window.showModalDialog(url, null, style);
	} else if("sd" == type){
	    var url = _gModuleName + "/sale/common/modaldialog/StaffSelect_s1.jsp?org_id=" + org_id +condition;
	    var style = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:310px;dialogWidth:430px";
	    return window.showModalDialog(url, null, style);
	} else {
		alert("请设置选择类型");
	}
}

openSelect.optionalPackeg = function(packageId, name) {
    var url = _gModuleName + "/charge/common/modaldialog/optionalPackage.jsp";
    var style = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:650px";
    return window.showModalDialog(url, null, style);
}

openSelect.selectMessageDep = function(orgId, workflowId) {
    var url = _gModuleName + "/sale/promationTag/orgSelect.jsp?org_id=" + orgId + "&workflowId=" + workflowId;
    var style = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:580px;dialogWidth:320px";
    return window.showModalDialog(url, null, style);
}

openSelect.proxy = function() {
    var url = _gModuleName + "/sale/common/proxy.jsp";
    var style = "height=380px,width=640px,top=100,left=200,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no";
    return window.open(url, null, style);
}

openSelect.modifyMessageDep = function(orgId, workflowId) {
    var url = _gModuleName + "/sale/promationTag/orgModify.jsp?org_id=" + orgId + "&workflowId=" + workflowId;
    var style = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:560px;dialogWidth:320px";
   return window.showModalDialog(url, null, style);
}

openSelect.selectMessageDepStaff = function(orgId, workflowId, flag) {
    var url = _gModuleName + "/sale/promationTag/appriseDialog.jsp?orgInit="+flag+"&org_id=" + orgId + "&workflowId=" + workflowId;
    var style = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:390px;dialogWidth:700px";
	return window.showModalDialog(url, null, style);
}