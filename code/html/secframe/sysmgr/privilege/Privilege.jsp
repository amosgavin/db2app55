<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<HTML>
<head>
<title></title>
</head>
<body>
<table width="98%" align="center" valign="top" style="height:100%">
  <tr>
    <td width="370" height="529" valign="top"><div id="tabGenericDiv" style="width:400px;overflow:auto;">
        <ai:tab id="tabQuery" getParameter="getParameter" width="400"
							height="510">
          <ai:tabitem id="mobased" src="MoBased.jsp" title="sec.privilege.bymo" i18nRes="i18n.secframe_resource" />
          <ai:tabitem id="orgbased" src="OrgBased.jsp" title="sec.privilege.byorg" i18nRes="i18n.secframe_resource" />
        </ai:tab>
      </div></td>
    <!-- 
	the separate line
-->
    <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td colspan="3"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="1" >
                    <tr>
                      <td  ><table width="100%" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="40" style="height: 20px">&nbsp;&nbsp;<img src="../../images/circle.gif" width="12" height="12" /></td>
                            <td style="height: 20px"><i18n:message key="sec.privilege.allarb" res="i18n.secframe_resource"/></td>
                            <td align="right" style="height: 20px"></td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr>
                      <td align="left" style="padding-left:5px;" height="160" valign="top"><select id="allProperites" 
																style="width: 200; height: 160" size="10"
																name="allProperites" ondblclick="addProperties()">
                        </select></td>
                    </tr>
                  </table></td>
                <td  style="padding-left:20px;"><table width="100%" border="0" cellpadding="0" cellspacing="1" >
                    <tr>
                      <td ><table width="100%" border="0" cellpadding="0" cellspacing="0" >
                          <tr>
                            <td width="40" style="height: 20px">&nbsp;&nbsp;<img src="../../images/circle.gif" width="12" height="12" /></td>
                            <td style="height: 20px"><i18n:message key="sec.privilege.usevalid" res="i18n.secframe_resource"/></td>
                            <td align="right" style="height: 20px"></td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr>
                      <td  align="left" style="padding-left:5px;" height="160" valign="top"><select id="allGlobalVar" 
													style="width: 200; height: 160" size="10"
													name="allGlobalVar" ondblclick="addCondText('allGlb')">
                        </select></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td colspan="3" style="padding-top:5px; padding-bottom:5px;"><table width="100%" border="0" cellpadding="0" cellspacing="1" >
              <tr>
                <td  ><table width="100%" border="0" cellpadding="0" cellspacing="0"  >
                    <tr>
                      <td width="40" style="height: 20px">&nbsp;&nbsp;<img src="../../images/circle.gif" width="12" height="12" /></td>
                      <td style="height: 20px"><i18n:message key="sec.privilege.inputcod" res="i18n.secframe_resource"/></td>
                      <td align="right" style="height: 20px"></td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td  align="left" style="padding-left:5px;" valign="top"><textarea cols="" rows="" id="condText"
									style="width:99%;height:80"></textarea>
                </td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="1" >
              <tr>
                <td  ><table width="100%" border="0" cellpadding="0" cellspacing="0"  >
                    <tr>
                      <td width="40" style="height: 20px">&nbsp;&nbsp;<img src="../../images/circle.gif" width="12" height="12" /></td>
                      <td style="height: 20px"><i18n:message key="sec.privilege.seearb" res="i18n.secframe_resource"/></td>
                      <td align="right" style="height: 20px"></td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td  align="left" style="padding-left:5px;" valign="top"><table border="0" cellspacing="0" cellpadding="0"
										align="center">
                    <tr>
                      <td align="center">
                      <input name="Input" type="button"   value="-" id="delExtBtn" onClick="delProperties('havePrs')"/>
                      </td>
                    </tr>
                    <tr>
                      <td><select id="haveProperites"  
													style="width: 100; height: 160" size="10"
													name="haveProperites" ondblclick="addCondText('havePrs')">
                        </select>
                      </td>
                    </tr>
                    <tr>
                      <td height="8"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
          <td style="padding-left:10px;"><table width="100%" border="0" cellpadding="0" cellspacing="1" >
              <tr>
                <td  ><table width="100%" border="0" cellpadding="0" cellspacing="0"  >
                    <tr>
                      <td width="40" style="height: 20px">&nbsp;&nbsp;<img src="../../images/circle.gif" width="12" height="12" /></td>
                      <td style="height: 20px"><i18n:message key="sec.privilege.updatearb" res="i18n.secframe_resource"/></td>
                      <td align="right" style="height: 20px"></td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td align="left" style="padding-left:5px;" valign="top"><table border="0" cellspacing="0" cellpadding="0"
										align="center">
                    <tr>
                      <td align="center"><input name="Input" type="button"   value="-" id="affirm" onClick="delProperties('haveModPrs')"/>
                      </td>
                    </tr>
                    <tr>
                      <td><select id="haveModProperites"  
													style="width: 100; height: 160" size="10"
													name="haveModProperites" ondblclick="addCondText('haveModPrs')">
                        </select>
                      </td>
                    </tr>
                    <tr>
                      <td height="8"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
          <td style="padding-left:10px;"><table width="100%" border="0" cellpadding="0" cellspacing="1" >
              <tr>
                <td  ><table width="100%" border="0" cellpadding="0" cellspacing="0"  >
                    <tr>
                      <td width="40" style="height: 20px">&nbsp;&nbsp;<img src="../../images/circle.gif" width="12" height="12" /></td>
                      <td style="height: 20px"><i18n:message key="sec.privilege.addbo" res="i18n.secframe_resource"/></td>
                      <td align="right" style="height: 20px"></td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td align="left" style="padding-left:5px;" valign="top"><table border="0" cellspacing="0" cellpadding="0"
										align="center">
                    <tr>
                      <td align="center"><input name="Input" type="button"   value="+"  onClick="extBoSelect()"/>
                        &nbsp;
                        <input name="Input" type="button"   value="-" id="affirm" onClick="delProperties('haveExtendBo')"/>
                      </td>
                    </tr>
                    <tr>
                      <td align="center"><select id="haveExtendBo"
													style="width: 140; height: 160" size="10"
													name="haveExtendBo" ondblclick="addCondText('haveExtendBo')">
                        </select>
                      </td>
                    </tr>
                    <tr>
                      <td height="8"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <div align="center" style=" padding-top:5px; height:30px;">
        <ai:button text="sec.save" i18nRes="i18n.secframe_resource" id="saveBtn"  onclick="saveData()"/>
      </div></td>
  </tr>
</table>
</body>
<script language="javascript">
var condText = document.all.item("condText");
var allPrs = document.all.item("allProperites").options;
var havePrs = document.all.item("haveProperites").options;
var haveModPrs = document.all.item("haveModProperites").options;
var allGlb = document.all.item("allGlobalVar").options;
var haveExtendBo = document.all.item("haveExtendBo").options;
var curTab = null;
setTabItem("tabQuery","mobased");

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
	var tab = eval("tabQuery_"+curTab);
	var moId = tab.getMoId();
	var curChildTab = getChildCurTab(curTab);
	var operName = tab.getOperName();
	var url = "<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.PrivilegeAction?action=save&moId="+moId;
	url+= "&type="+curChildTab+"&id="+id+"&dealType=1&moOper="+operName;
	var ret = PostInfotoServer(url,"");
}
function saveData(){
	var tab = eval("tabQuery_"+curTab);
	var moId = tab.getMoId();
	var operName = tab.getOperName();
	var permId = tab.getPermId();
	var curChildTab = getChildCurTab(curTab);
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
	url += "&type="+curChildTab+"&moName="+getParaMo()+"&moCon="+getParaCon()+"&moProE="+getParaOPE()+"&moPro="+getParaPro()+"&permissionId="+permId;
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