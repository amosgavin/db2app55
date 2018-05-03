<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<title>OrgMoBase</title>
		<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/json.js"></script>
	</head>
	<body onLoad="init()">
				<div style="padding:0 5px;">
									<ai:tab id="tabPrivilegeObj" getParameter="getParameter"
										width="100%" height="70" type="H">
										<ai:tabitem id="staff" src="OrgOpStation.jsp"
											title="sec.OrgBased.operator"
											i18nRes="i18n.secframe_resource" />
										<ai:tabitem id="station" src="OrgTree.jsp"
											title="sec.OrgBased.station" i18nRes="i18n.secframe_resource" />
										<ai:tabitem id="role" src="RoleQuery.jsp"
											title="sec.OrgBased.role" i18nRes="i18n.secframe_resource" />
									</ai:tab>
				</div>		
							<ai:contractframe id="" contenttype="table"
						title="sec.OrgBased.resultlist" i18nRes="i18n.secframe_resource"
						width="100%" allowcontract="true" frameclosed="false">
						<ai:contractitem />
						<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
							<tr>
								<td><select name="select" size="6" id="searchList"  style="width:100%" onChange="qryMoList();">
                                </select></td>
							</tr>
						</table>
						</ai:contractframe>
						<ai:contractframe id="" contenttype="table"
						title="sec.OrgBased.molist" i18nRes="i18n.secframe_resource"
						width="100%" allowcontract="true" frameclosed="false">
						<ai:contractitem />
									<ai:table
										setname="com.ai.secframe.sysmgr.web.SETQBOSecMoPermission"
										tableid="tblPermission" needrefresh="true" initial="false"
										multiselect="false" editable="false" pagesize="5"
										onrowchange="getMoInfo" width="100%" height="120"
										tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
										implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecMoPrivilegeSV"
										implservice_querymethod="getQBOSecMoPermissionValues"
										implservice_countmethod="getQBOSecMoPermissionCount">
										<ai:col fieldname="PERMISSION_ID" visible="false" />
										<ai:col fieldname="MO_ID" visible="false" />
										<ai:col fieldname="MO_NAME" width="40%" />
										<ai:col fieldname="OPERATOR_NAME" width="60%" />
									</ai:table>
			</ai:contractframe>
								<div class="area_button">
									<ai:button text="sec.add" i18nRes="i18n.secframe_resource"
										id="Input3" onclick="addMo()" />
									&nbsp;
									<ai:button text="sec.delete" i18nRes="i18n.secframe_resource"
										id="Input4" onclick="delMo()" />
								</div>
								
				<ai:contractframe id="" contenttype="table"
						title="sec.mobased.attribute" i18nRes="i18n.secframe_resource"
						width="100%" allowcontract="true" frameclosed="false">
						<ai:contractitem />
						<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
              <tr>
                <td><table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                    <tr>
                      <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td>&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/webframe/images/icon/mini006.gif" align="absmiddle" />&nbsp;<i18n:message key="sec.privilege.allarb" res="i18n.secframe_resource"/></td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr>
                      <td><select id="allProperites" style="width: 98%;" size="5" name="allProperites" ondblclick="addProperties()"></select></td>
                    </tr>
                  </table></td>
                <td><table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                    <tr>
                      <td ><table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                          <tr>
                            <td>&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/webframe/images/icon/mini031.gif" align="absmiddle" />&nbsp;<i18n:message key="sec.privilege.usevalid" res="i18n.secframe_resource"/></td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr>
                      <td ><select id="allGlobalVar" style="width: 98%;" size="5" name="allGlobalVar" ondblclick="addCondText('allGlb')"></select></td>
                    </tr>
                  </table></td>
              </tr>
            </table>
			
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                    <tr>
                      <td>&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/webframe/images/icon/mini056.gif" align="absmiddle" />&nbsp;<i18n:message key="sec.privilege.inputcod" res="i18n.secframe_resource"/></td>
                    </tr>
              <tr>
                <td><textarea cols="" rows="" id="condText"  style="width:98%;height:50"></textarea></td>
              </tr>
            </table>
			
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
              <tr>
                <td>
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
              <tr>
                <td><table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                    <tr>
                      <td>&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/webframe/images/icon/mini053.gif" align="absmiddle" />&nbsp;<i18n:message key="sec.privilege.seearb" res="i18n.secframe_resource"/></td>
					  <td><img id="delExtBtn" border="0" src="<%=request.getContextPath()%>/webframe/images/clean.gif"  alt="sec.privilege.delarb" res="i18n.secframe_resource" onClick="delProperties('havePrs')" align="absmiddle" style="cursor:hand;"/></td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td><select id="haveProperites" style="width: 98%;" size="3" name="haveProperites" ondblclick="addCondText('havePrs')"></select></td>
              </tr>
            </table></td>
          <td><table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
              <tr>
                <td><table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                    <tr>
                      <td>&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/webframe/images/icon/mini049.gif" align="absmiddle" />&nbsp;<i18n:message key="sec.privilege.updatearb" res="i18n.secframe_resource"/></td>
					  <td><img id="affirm" border="0" src="<%=request.getContextPath()%>/webframe/images/clean.gif"  alt="sec.privilege.delarb" res="i18n.secframe_resource" onClick="delProperties('haveModPrs')" align="absmiddle" style="cursor:hand;"/></td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td><select id="haveModProperites" style="width: 98%;" size="3" name="haveModProperites" ondblclick="addCondText('haveModPrs')"></select></td>
              </tr>
            </table></td>
          <td><table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
              <tr>
                <td><table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                    <tr>
                      <td>&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/webframe/images/icon/mini050.gif" align="absmiddle" />&nbsp;<i18n:message key="sec.privilege.addbo" res="i18n.secframe_resource"/></td>
					  <td><img id="" border="0" src="<%=request.getContextPath()%>/webframe/images/add.gif"  alt="sec.privilege.addbos" res="i18n.secframe_resource" onClick="extBoSelect()" align="absmiddle" style="cursor:hand;"/>
                        &nbsp;
                        <img id="affirm" border="0" src="<%=request.getContextPath()%>/webframe/images/clean.gif"  alt="sec.privilege.delbo" res="i18n.secframe_resource" onClick="delProperties('haveExtendBo')" align="absmiddle" style="cursor:hand;"/></td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td><select id="haveExtendBo" style="width: 98%;" size="3" name="haveExtendBo" ondblclick="addCondText('haveExtendBo')"></select></td>
              </tr>
            </table></td>
							</tr>
						</table>
	<div class="area_button">
        <ai:button text="sec.save" i18nRes="i18n.secframe_resource" id="saveBtn"  onclick="saveData()"/>
     </div>
		</ai:contractframe>	
	</body>
</html>
<script language="javascript">
var condText = document.all.item("condText");
var allPrs = document.all.item("allProperites").options;
var havePrs = document.all.item("haveProperites").options;
var haveModPrs = document.all.item("haveModProperites").options;
var allGlb = document.all.item("allGlobalVar").options;
var haveExtendBo = document.all.item("haveExtendBo").options;
var curTab = null;
var searchListSel = document.all.item("searchList").options;
var tblPermission = g_TableRowSetManager.get("tblPermission");
var curTab = null;
var moId = null;
var permId = null;
var operName = null;
var flag = 1;
function getMoId(){
	return moId;
}
function getOperName(){
	return operName;
}
function getPermId(){
	return permId;
}
function init(){
	curTab = "orgbased";
	if(curTab==null){
		setTabItem("tabPrivilegeObj","staff");
		curChildTab = "staff";
		curTab = "staff";
	}
}

function refdata(){
	var curNode = dbtree.getCurNodeInfo();
	var parentNode = dbtree.getParentNodeInfo(curNode.value);
	if(curNode.userobj=="O"){
		moId = parentNode.value;
		
		operName = curNode.text;
		//alert(moId+"|"+operName);
		permId = null;
		if(curTab == null){
			curTab = "staff";
			setTabItem("tab","staff");
		}else{
			var tab = eval("tab_"+curTab);
			if(tab.flag==undefined)
				return;
			else
				tab.init();
		}
		refrRight(moId);
	}
}
function qryObj(codeValue){
	var url = "";
	var type = (curTab).toLowerCase();
	clearSearchList();
	if(type=="staff"){
		url = _gModuleName + "/business/com.ai.secframe.sysmgr.web.PrivilegeAction?action=qrySecOpStation&orgStationId="+codeValue;
		var ret = PostInfotoServer(url,"");
		if(ret!="NO"){
			var objJSON = ret.parseJSON();
			for(var i=0;i<objJSON.Staff.length;i++){
				searchList[i] = new Option(objJSON.Staff[i].staffName,objJSON.Staff[i].opStationId,false,false);
			}
		}
	}else if(type=="station"){
		url = _gModuleName + "/business/com.ai.secframe.sysmgr.web.PrivilegeAction?action=qrySecStation&orgId="+codeValue;
		var ret = PostInfotoServer(url,"");
		if(ret!=""&&ret!="NO"){
	 		var objJSON = ret.parseJSON();
			for(var i=0;i<objJSON.Station.length;i++){
				searchList[i] = new Option(objJSON.Station[i].stationName,objJSON.Station[i].stationId,false,false);
			}
		}
	}else if(type=="role"){
		url = _gModuleName+ "/business/com.ai.secframe.sysmgr.web.PrivilegeAction?action=qrySecRole&"+codeValue;
		var ret = PostInfotoServer(url,"");
		if(ret!=null&&ret!="NO"){
  			var objJSON = ret.parseJSON();
  			for(var i=0;i<objJSON.Role.length;i++){
  				searchList[i] = new Option(objJSON.Role[i].roleName,objJSON.Role[i].roleId,false,false);
  			}
  		}
  	} 	
}
function clearSearchList(){
	searchListSel.length = 0;
}
function qryMoList(){
	clearMOPre();
	allPrs.length = 0;
	if(searchListSel.length<=0)
		return false;
	var cond = "";
	if(curTab == "staff")
		cond = "op_station_id="; 
	else if(curTab == "station")
		cond = "station_id="; 
	else if( curTab == "role" )
		cond = "role_id=";
	else if(curTab == "orgQuery"){
		curTab = tabPrivilegeObj_orgQuery.getCurTab();
		if(curTab == "staff")
			cond = "staff_id="; 
		else if(curTab == "station")
			cond = "station_id="; 		
	}
	cond += searchList.value;
	tblPermission.refresh(cond);
	//if(tblPermission.count()>0)
		//tblPermission.setRow(0);
}
function delMo(){
	var permissionId=tblPermission.getValue(tblPermission.getRow(),"PERMISSION_ID");
	if(permissionId=="")
	{	
		alert(g_I18NMessage("secframe_mo", "sec_mo_deleterecord"));
		return;
	}
	if(tblPermission.getRow()>=0){
		var permId = tblPermission.getValue(tblPermission.getRow(),"PERMISSION_ID");
		delPerm(permId);
		qryMoList();
		clearAll();
		getParameter(curTab)
	}
}
function addMo(){
	if(searchList.length < 1) return;
	var arrMo = new Array();
	for(var i=0;i<tblPermission.count();i++){
		arrMo[i] = tblPermission.getValue(tblPermission.getRow(),"MO_ID")+","+tblPermission.getValue(tblPermission.getRow(),"OPERATOR_NAME");
	}
	var ret = window.showModalDialog("MoSelect.jsp",arrMo,"scroll:no;help:no;resizable:no;status:no;dialogHeight:480px;dialogWidth:300px");
	if(ret !=null){	
		window.moId = ret.moId;
		window.operName = ret.operName;
		save(searchList.value);
    	qryMoList();
    }
}
function getMoInfo(){
	permId = tblPermission.getValue(tblPermission.getRow(),"PERMISSION_ID");
	operName = tblPermission.getValue(tblPermission.getRow(),"OPERATOR_NAME");
	moId = tblPermission.getValue(tblPermission.getRow(),"MO_ID");
	qryPerm(permId);
	qryMoInfo(moId);
}
function getCurTab(){
	return curTab;
}
function clearVar(flag){
	moId = null;
	operName = null;
	if(flag)
		permId = null;
}
function getParameter(itemId){
	clearVar(true);
	clearAll();
	curTab = itemId;
	var tab = eval("tabPrivilegeObj_"+itemId);
	globalVar(itemId.toUpperCase());
	tblPermission.refresh("op_station_id=-1");
	if(tab.flag!=undefined){
		tab.init();
	}
}
//获得tab页面当前的组织对象类型(员工，岗位，角色)
function getChildCurTab(curTab){
	if(curTab==null) return;
	var tab = eval("tabQuery_"+curTab);
	if(tab.flag==undefined)	
		return;
	else
		return tab.getCurTab();
}
function clearAll(){
	clearMOPre();
	allPrs.length = 0;
	allGlb.length = 0;
}
function clearMOPre(){
   	condText.value = "";
   	havePrs.length = 0;
   	haveModPrs.length = 0;
   	haveExtendBo.length = 0;
}
function refrRight(moId){
	clearMOPre();
	qryMoInfo(moId);
}
function qryMoInfo(moId){
	var ret = PostInfotoServer("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.PrivilegeAction?action=querySecMoOp&moName="+moId,"");
	if(ret!=null){
		var retArray = ret.split("$");
   		var prArray = retArray[1].substr(1).split(",");
   		allPrs.length = 0;
   		for( var i=0;i<prArray.length;i++ ){
			if( prArray[i] != "null" && prArray[i] != "" )
       			allPrs[i] = new Option( prArray[i],prArray[i],false,false);
   		}
   	}
}
function globalVar(qryType){
	//查询所有可用的全局变量
	var url = "<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.PrivilegeAction?action=queryGlobalVar";
	url +="&queryType="+qryType;
  	var  retVal = PostInfotoServer(url,"" );
  	var varArray = retVal.split(",");
  	allGlb.length = 0;
  	for( var i=0;i<varArray.length;i++){
    if( varArray[i] != null && varArray[i] != "" )
      	allGlb[i] = new Option( varArray[i],varArray[i],false,false);
  	}	
}
function qryPerm(permId){
	clearMOPre();
	var url = "<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.PrivilegeAction?action=queryStaffInfo&permissionId="+permId;
	var ret = PostInfotoServer(url,"");
	if(ret!=""){
		var objJSON = ret.parseJSON();
  	 	var temp;
  	 	if(objJSON.Permission[0].propertys!="null"&&objJSON.Permission[0].propertys!=""){
  	 		temp = objJSON.Permission[0].propertys.split(",");
  	 		for(var i=0;i<temp.length;i++){
  	 				havePrs[havePrs.length] = new Option(temp[i],temp[i],false,false);
  	 		}
  	 	} 
  	 	if(objJSON.Permission[0].modifyPeopertys!="null"&&objJSON.Permission[0].modifyPeopertys!=""){
  	 		temp = objJSON.Permission[0].modifyPeopertys.split(",");
  	 		for(var i=0;i<temp.length;i++){
  	 				haveModPrs[haveModPrs.length] = new Option(temp[i],temp[i],false,false);
  	 		}
  	 	} 
  	 	if(objJSON.Permission[0].extendObject!="null"&&objJSON.Permission[0].extendObject!=""){
  	 		temp = objJSON.Permission[0].extendObject.split(",");
  	 		for(var i=0;i<temp.length;i++){
  	 				haveExtendBo[haveExtendBo.length] = new Option(temp[i],temp[i],false,false);
  	 		}
  	 	} 
  	 	if(objJSON.Permission[0].condition!="null"&&objJSON.Permission[0].condition!=""){
  	 		condText.value = objJSON.Permission[0].condition;
  	 	} 
  	}
}
function addProperties(){
	var flag = window.showModalDialog("PropertiesType.jsp","","help:no;scroll:no;resizable:no;status:no;dialogHeight:110px;dialogWidth:180px");		
	if(flag !=-1 && flag != undefined){
		if(flag=="view")
			addItem( allPrs,havePrs,2 ) ;
		else if(flag=="modify")			
			addItem( allPrs,haveModPrs,2 ) 
		else if(flag=="all"){
			addItem( allPrs,havePrs,2 );
			addItem( allPrs,haveModPrs,2 )
		}
	}	  
}
function addItem(srcOpts,dstOpts,single){
	var isNew = true;
  	for (var i=srcOpts.length-1;i>=0;i--) {
      	if (srcOpts[i].selected) {
        //如果已经选择某个item,就不将其加入
        	for(var m=0;m<dstOpts.length;m++){
            	if(srcOpts[i].value == dstOpts[m].value){
              		isNew = false;
            	}
        	}
        if(isNew)dstOpts[dstOpts.length] = new Option(srcOpts[i].text,srcOpts[i].value,false,false);
      	}
    }
    return isNew;
}
function delProperties(modPrs){
  delItem(eval(modPrs),"porpertys_mod" );
}
function delItem( srcOpts,name ){
	for (var i=srcOpts.length-1;i>=0;i--) {
		if (srcOpts[i].selected) {
        	var tmp = srcOpts[i].value;
        	srcOpts[i] = null;
        	if(name == "operator"){
          		clear( false ); 
        	}
      	}
    }
}
function addCondText(srcOpts){
	appendCondText(eval(srcOpts));
}
function appendCondText(srcOpts){
    for (var i=0;i<srcOpts.length;i++) {
      if (srcOpts[i].selected)
        condText.value += " "+srcOpts[i].value;
    }
}
function extBoSelect(){
   var gParamObject = new Object();
   gParamObject.isSingleSel = 2;
   gParamObject.winObj = window;
   gParamObject.oldArray = new Array();
   for( var i=0;i<haveExtendBo.length;i++)
     gParamObject.oldArray.push(haveExtendBo[i].text);
   var flag =window.showModalDialog("ExtboSelect.jsp",gParamObject,"scroll:no;resizable:no;status:no;dialogHeight:460px;dialogWidth:450px;help:no");
   if( flag!="undefined" ){
      var val_text_array = flag.split(",");
      for( var i=0;i<val_text_array.length;i++){
         if( !isExist( haveExtendBo,val_text_array[i] ) && val_text_array[i] != "" )
           haveExtendBo[haveExtendBo.length] = new Option(val_text_array[i],val_text_array[i],false,false);
      }
      
   }
}
//判断列表框中是否已经存在某项
function isExist( listOpts,val ){
   for( var i=0;i<listOpts.length;i++ ){
     if( listOpts[i] == val )
       return true;
   }
   return false;
}
function delPerm(perm_id){
	var url = "<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.PrivilegeAction?action=save";
	url+= "&type=staff&dealType=3&permissionId="+perm_id;
	var ret = PostInfotoServer(url,"");
	clearMOPre();
	alert(ret);	
}
function save(id){
	var url = "<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.PrivilegeAction?action=save&moId="+moId;
	url+= "&type="+curTab+"&id="+id+"&dealType=1&moOper="+operName;
	var ret = PostInfotoServer(url,"");
}
function saveData(){
	if( moId == null || operName == null ){
		alert(g_I18NMessage("secframe_privilege", "sec_privilege_notexist"));
		return;
	}
	if( curTab == null ){
		alert(g_I18NMessage("secframe_privilege", "sec_privilege_notactive"));
		return;
	}
	if( permId == null ){
		alert(g_I18NMessage("secframe_privilege", "sec_privilege_selectobj"));
		return;
	}
	var url = "<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.PrivilegeAction?action=save&dealType=2";
	url += "&type="+curTab+"&moName="+getParaMo()+"&moCon="+getParaCon()+"&moProE="+getParaOPE()+"&moPro="+getParaPro()+"&permissionId="+permId;
	var ret = PostInfotoServer(url,"");
	alert(ret);
}
function getParaOPE(){
	var temp = ""
	for(var i=0;i<haveModPrs.length;i++){
		temp += ","+haveModPrs[i].value;
	}
	if(temp.length>0)
		temp = temp.substr(1);	
	return temp;
}
function getParaPro(){
	var temp = ""
	for(var i=0;i<havePrs.length;i++){
		temp += ","+havePrs[i].value;
	}
	if(temp.length>0)
		temp = temp.substr(1);
	return temp;
}
function getParaMo(){
	var temp = ""
	for(var i=0;i<haveExtendBo.length;i++){
		temp += ","+haveExtendBo[i].value;
	}
	if(temp.length>0)
		temp = temp.substr(1);
	return temp;
}
function getParaCon(){
	return condText.value;
}

</script>
