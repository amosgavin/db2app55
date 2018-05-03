/**
 *组织选择
 *orgSelectDialog(orgId)
 *当orgId传入值为-1显示所有值，如果orgId传入空或null时，则显示当前登陆人的组织及下属组织！
 *返回值为Array
 *得到返回值的组织名称和组织编号如下：
 *var ret = orgSelectDialog(-1);
 *if(ret!=null){
 *	alert(ret[0].orgId+"___"+ret[0].orgName)
 *}
**/
function orgSelectDialog(orgId){
	var url = _gModuleName+"/secframe/sysmgr/common/OrgSelectDialog.jsp?sequence="+(new Date()).valueOf();
	
	if(orgId!=null&&orgId!="")
		url += "&org_id="+orgId;
	var ret = window.showModalDialog(url,null,"scroll:no;resizable:no;help:no;status:no;dialogHeight:450px;dialogWidth:300px");
	if(ret!=null){
		return ret;
	}else{
		return null;
	}
}

/**
 *组织选择
 *orgSelectDialog(regionId)
 *返回值为Array
 *得到返回值的组织名称和组织编号如下：
 *var ret = orgSelectDialog(571);
 *if(ret!=null){
 *	alert(ret[0].orgId+"___"+ret[0].orgName)
 *}
**/
function orgSelectDialogByRegionId(regionId){
	var url = _gModuleName+"/secframe/sysmgr/common/OrgSelectDialog.jsp?sequence="+(new Date()).valueOf();
	
	if(regionId!=null&&regionId!="")
		url += "&region_id="+regionId;
	var ret = window.showModalDialog(url,null,"scroll:no;resizable:no;help:no;status:no;dialogHeight:450px;dialogWidth:300px");
	if(ret!=null){
		return ret;
	}else{
		return null;
	}
}

/**
 *员工选择对话框
 *staffSelectDialog(arrStaff,singleFlag)
 *arrStaff为已经选择的员工(staffId数组),在员工选择界面将不显示，只显示新增的且不在该范围内的员工;
 *singleFlag为是否可以多选员工的标志（true/false）。
 *返回值为Array
 *var ret = staffSelectDialog(null,true);
 *if(ret !=null){
 *  for(var i=0;i<ret.length;i++){
 *	  alert(ret[0].orgId+"___"+ret[0].orgName+"___"+ret[0].staffId+"____"+ret[0].staffName);
 *  }
 *}
**/
function staffSelectDialog(arrStaff,singleFlag){
	var url = _gModuleName+"/secframe/sysmgr/common/StaffSelectDialog.jsp?sequence="+(new Date()).valueOf();
	
	if(arrStaff == null)
		arrStaff = new Array();
	var paraObj = new Object();
	paraObj.arrStaff = arrStaff;
	paraObj.singleFlag = singleFlag;
	paraObj.winObj = window;
	var ret = window.showModalDialog(url,paraObj,"scroll:no;resizable:no;help:no;status:no;dialogHeight:460px;dialogWidth:530px");
	if(ret!=null){
		return ret;
	}else{
		return null;
	}
}

/**
 *功能选择
 *funcSelectDialog
 *
 *返回值为Func对象
 *得到返回值的功能名称和功能编号如下：
 *var ret = funcSelectDialog();
 *if(ret!=null){
 *	alert(ret.funcId+"___"+ret.funcName)
 *}
**/
function funcSelectDialog(){
	var url = _gModuleName+"/secframe/sysmgr/common/FuncSelectDialog.jsp?sequence="+(new Date()).valueOf();
	
	var ret = window.showModalDialog(url,null,"scroll:no;resizable:no;help:no;status:no;dialogHeight:450px;dialogWidth:300px");
	if(ret!=null){
		return ret;
	}else{
		return null;
	}
}

/**
 *岗位对话框选择
 *stationSelectDialog(arrStation,singleFlag)；
 *arrStation已经选择的岗位，为数组。singleFlag是否单选标志。
 *singleFlag为是否可以多选员工的标志（true/false）。
 *var ret = stationSelectDialog(null,true);
 *if(ret!=null)
 *  for(var i=0;i<ret.length;i++){
 *		alert(ret[i].stationId+"_"ret[i].stationName);
 *  }
**/

function stationSelectDialog(arrStation,singleFlag){
	var url = _gModuleName+"/secframe/sysmgr/common/StationSelectDialog.jsp?sequence="+(new Date()).valueOf();
	if(arrStation==null){
		arrStation = new Array();
	}
	var paraObj = new Object();
	paraObj.arrStation = arrStation;
	paraObj.singleFlag = singleFlag;
	paraObj.winObj = window;	
	var ret = window.showModalDialog(url,paraObj,"scroll:no;resizable:no;status:no;dialogHeight:460px;dialogWidth:530px;help:no");
	if(ret!=null){
		return ret;
	}else{
		return null;
	}
}
/**
 *岗位类型对话框选择
 *stationTypeSelectDialog(arrStationType,singleFlag)；
 *arrStationType已经选择的岗位，为数组。singleFlag是否单选标志。
 *singleFlag为是否可以多选员工的标志（true/false）。
 *var ret = stationTypeSelectDialog(null,true);
 *if(ret!=null)
 *  for(var i=0;i<ret.length;i++){
 *		alert(ret[i].stationId+"_"ret[i].stationName);
 *  }
**/
function stationTypeSelectDialog(arrStationType,singleFlag){
	var url = _gModuleName+"/secframe/sysmgr/common/StationTypeSelect.jsp?sequence="+(new Date()).valueOf();
	if(arrStationType==null){
		arrStationType = new Array();
	}
	var paraObj = new Object();
	paraObj.arrStatType = arrStationType;
	paraObj.singleFlag = singleFlag;
	paraObj.winObj = window;
	var ret = window.showModalDialog(url,paraObj,"scroll:no;resizable:no;status:no;dialogHeight:480px;dialogWidth:460px;help:no");
	if(ret!=null){
		return ret;
	}else{
		return null;
	}
}

	/**
  	 * 选择操作员
  	 */
function getOperator()
{
	var url = _gModuleName+"/secframe/common/query/SearchOperator.jsp";
	var retVal = window.showModalDialog(url, null,"scroll:no;resizable:no;status:no;dialogHeight:600px;dialogWidth:400px");
	if(retVal!=null){
		return retVal;
	}else{
		return null;
	}
}