<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<HTML>
	<head>
		<title>MOPrivilege</title>
	</head>
	<body>
		<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="220" valign="top">
					<ai:contractframe id="" contenttype="table"
						title="sec.mobased.select" i18nRes="i18n.secframe_resource"
						width="100%" allowcontract="false" frameclosed="false">
						<ai:contractitem />
						<table width="99%" align="center" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td>
									<ai:dbtree_new id="sysdirtree"
										datamodel="com.ai.secframe.sysmgr.web.DBTreeModelSecMo"
										height="500" width="100%" multiselect="false"
										ishaveline="true" onselect="refdata" />
								</td>
							</tr>
						</table>
					</ai:contractframe>
				</td>
				<td valign="top" align="right">
				<div style="padding:0 5px;">
									<ai:tab id="tab" getParameter="getParameter" width="100%"
										height="250">
										<ai:tabitem id="staff" src="Staff.jsp"
											title="sec.OrgBased.operator"
											i18nRes="i18n.secframe_resource" />
										<ai:tabitem id="station" src="Station.jsp"
											title="sec.OrgBased.station" i18nRes="i18n.secframe_resource" />
										<ai:tabitem id="role" src="Role.jsp"
											title="sec.OrgBased.role" i18nRes="i18n.secframe_resource" />
									</ai:tab>
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
                      <td><select id="allProperites" style="width: 98%;" size="5" name="allProperites" ondblclick="addProperties()">
                        </select></td>
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
                      <td ><select id="allGlobalVar" style="width: 98%;" size="5" name="allGlobalVar" ondblclick="addCondText('allGlb')">
                        </select></td>
                    </tr>
                  </table></td>
              </tr>
            </table>
			
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                    <tr>
                      <td>&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/webframe/images/icon/mini056.gif" align="absmiddle" />&nbsp;<i18n:message key="sec.privilege.inputcod" res="i18n.secframe_resource"/></td>
                    </tr>
              <tr>
                <td><textarea cols="" rows="" id="condText" style="width:98%;height:50"></textarea>
                </td>
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
					  <td><img id="delExtBtn" border="0" src="<%=request.getContextPath()%>/webframe/images/clean.gif"  alt="sec.privilege.delarb" res="i18n.secframe_resource"  onClick="delProperties('havePrs')" align="absmiddle" style="cursor:hand;"/></td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td><select id="haveProperites" style="width: 98%;" size="3" name="haveProperites" ondblclick="addCondText('havePrs')">
                        </select></td>
              </tr>
            </table></td>
          <td><table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
              <tr>
                <td><table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                    <tr>
                      <td>&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/webframe/images/icon/mini049.gif" align="absmiddle" />&nbsp;<i18n:message key="sec.privilege.updatearb" res="i18n.secframe_resource"/></td>
					  <td><img id="affirm" border="0" src="<%=request.getContextPath()%>/webframe/images/clean.gif"  alt="sec.privilege.delarb" res="i18n.secframe_resource"  onClick="delProperties('haveModPrs')" align="absmiddle" style="cursor:hand;"/></td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td><select id="haveModProperites" style="width: 98%;" size="3" name="haveModProperites" ondblclick="addCondText('haveModPrs')">
                        </select></td>
              </tr>
            </table></td>
          <td><table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
              <tr>
                <td><table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                    <tr>
                      <td>&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/webframe/images/icon/mini050.gif" align="absmiddle" />&nbsp;<i18n:message key="sec.privilege.addbo" res="i18n.secframe_resource"/></td>
					  <td><img id="" border="0" src="<%=request.getContextPath()%>/webframe/images/add.gif"  alt="sec.privilege.addbos" res="i18n.secframe_resource" onClick="extBoSelect()" align="absmiddle" style="cursor:hand;"/>
                        &nbsp;
                        <img id="affirm" border="0" src="<%=request.getContextPath()%>/webframe/images/clean.gif"   alt="sec.privilege.delbo" res="i18n.secframe_resource" onClick="delProperties('haveExtendBo')" align="absmiddle" style="cursor:hand;"/></td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td><select id="haveExtendBo" style="width: 98%;" size="3" name="haveExtendBo" ondblclick="addCondText('haveExtendBo')">
                        </select></td>
              </tr>
            </table></td>
							</tr>
						</table>
	<div class="area_button">
        <ai:button text="sec.save" i18nRes="i18n.secframe_resource" id="saveBtn"  onclick="saveData()"/>
     </div>
		</ai:contractframe>	
				</td>
			</tr>
		</table>
	</body>
	<script language="javascript">
var dbtree= g_DBTreeNewManager.get("sysdirtree");
var curTab = null;
var moId = null;
var operName = null;
var permId = null;
var flag = 1;
var condText = document.all.item("condText");
var allPrs = document.all.item("allProperites").options;
var havePrs = document.all.item("haveProperites").options;
var haveModPrs = document.all.item("haveModProperites").options;
var allGlb = document.all.item("allGlobalVar").options;
var haveExtendBo = document.all.item("haveExtendBo").options;

/**
	点击MO目录树
**/
function refdata(){
	var curNode = dbtree.getCurNodeInfo();
	var parentNode = dbtree.getParentNodeInfo(curNode.value);
	if(curNode.userobj=="O"){
		moId = parentNode.value;
		operName = curNode.text;
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


/**
	更换页面
**/
function getParameter(itemId){
	curTab = itemId;
	clearMOPre();
	globalVar(itemId.toUpperCase());
	var tab = eval("tab_"+itemId);
	if(tab.flag!=null){
		tab.initPermId();
		if (permId != null) qryPerm(permId);
	}
}

function clearVar(flag){
	moId = null;
	operName = null;
	if(flag)
		permId = null;
}
//获得tab页面当前的组织对象类型(员工，岗位，角色)
function getChildCurTab(curTab){
	if(curTab==null) return;
	var tab = eval("tab_"+curTab);
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
		var objJSON = eval("("+ret+")");
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
	var flag = window.showModalDialog("PropertiesType.jsp","","help:no;scroll:no;resizable:no;status:no;dialogHeight:200px;dialogWidth:300px");		
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
</html>