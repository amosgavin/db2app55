<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="sec.func.funcmgr" res="i18n.secframe_resource"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body onLoad="closeTree()">
<table width="100%"  border="0" cellspacing="0" cellpadding="1">
  <tr>
    <td width="250"><table width="100%" border="1" cellpadding="0" cellspacing="1" >
        <tr>
          <td ><table width="100%" border="0" cellpadding="0" cellspacing="1" >
              <tr>
                <td width="40">&nbsp;&nbsp;<img src="../../images/circle.gif" width="12" height="12" /></td>
                <td ><i18n:message key="sec.func.area" res="i18n.secframe_resource"/></td>
                <td align="right" ></td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td  align="left" ><ai:dbtree_new id="secfunction_tree" height="515" width="100%" 
			   datamodel="com.ai.secframe.sysmgr.web.SecFunctionDataModel" 
			   initial="true" ishaveline="true"
			   onselect="SecfuncInfoLoad" />
          </td>
        </tr>
      </table></td>
      <td valign="top" width="80%"><table border=0 cellspacing=0 cellpadding=0 id="mainTable">
        <tr>
          <td valign="top" >
          <ai:dbform formid="secfuncform" 
			datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
			setname="com.ai.secframe.sysmgr.web.SETSecFunction" 
			implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecFunctionSV"
			implservice_querymethod="querySecFunction"
			initial="false" mo="com.ai.secframe.moForm" operator="modifyMOForm" modealtype="mask">
			 
              <table width="100%" border="0" cellpadding="0" cellspacing="1" >
                <tr>
                  <td ><table width="100%" border="0" cellpadding="0" cellspacing="0" >
                      <tr>
                        <td width="40" >&nbsp;&nbsp;<img src="../../images/circle.gif" width="12" height="12" /></td>
                        <td > <i18n:message key="sec.func.info" res="i18n.secframe_resource"/></td>
                        <td align="right" ></td>
                      </tr>
                    </table></td>
                </tr>
                <tr>
                  <td align="left" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" height="200">
                      <tr>
                        <td width="100" ><i18n:message key="sec.func.code" res="i18n.secframe_resource"/></td>
                        <td width="1"></td>
                        <td ><ai:dbformfield fieldname="FUNC_CODE" formid="secfuncform" width="200" />
                          <span class="pr9">*</span>
                          <ai:dbformfield fieldname="PARENT_ID" formid="secfuncform"  visible="false"  width="200" />
                          <ai:dbformfield fieldname="FUNC_ID" formid="secfuncform"  visible="false"  width="200" /></td>
                        <td width="1"></td>
                        <td width="100" ><i18n:message key="sec.func.name" res="i18n.secframe_resource"/></td>
                        <td width="1"></td>
                        <td ><ai:dbformfield fieldname="NAME" formid="secfuncform" width="200" />
                          <span class="pr9">*</span></td>
                      </tr>
                      <tr>
                        <td height="1" ></td>
                        <td width="1"></td>
                        <td ></td>
                        <td width="1"></td>
                        <td ></td>
                        <td width="1"></td>
                        <td ></td>
                      </tr>
                      <tr>
                        <td width="100" ><i18n:message key="sec.func.img" res="i18n.secframe_resource"/></td>
                        <td width="1"></td>
                        <td ><ai:dbformfield fieldname="FUNC_IMG" formid="secfuncform" width="200" /></td>
                        <td width="1"></td>
                        <td width="100" ><i18n:message key="sec.func.type" res="i18n.secframe_resource"/></td>
                        <td width="1"></td>
                        <td ><ai:dbformfield fieldname="FUNC_TYPE" formid="secfuncform" width="200" />
                          <span class="pr9">*</span></td>
                      </tr>
                      <tr>
                        <td height="1" ></td>
                        <td width="1"></td>
                        <td ></td>
                        <td width="1"></td>
                        <td ></td>
                        <td width="1"></td>
                        <td ></td>
                      </tr>
                      <tr>
                        <td width="100" ><i18n:message key="sec.func.typeparam" res="i18n.secframe_resource"/></td>
                        <td width="1"></td>
                        <td ><ai:dbformfield fieldname="FUNC_ARG" formid="secfuncform" width="200" /></td>
                        <td width="1"></td>
                        <td width="100" ><i18n:message key="sec.func.dllfile" res="i18n.secframe_resource"/></td>
                        <td width="1"></td>
                        <td ><ai:dbformfield fieldname="DLL_PATH" formid="secfuncform" width="200" /></td>
                      </tr>
                      <tr>
                        <td height="1" ></td>
                        <td width="1"></td>
                        <td ></td>
                        <td width="1"></td>
                        <td ></td>
                        <td width="1"></td>
                        <td ></td>
                      </tr>
                      <tr>
                        <td width="100" ><i18n:message key="sec.func.url" res="i18n.secframe_resource"/></td>
                        <td width="1"></td>
                        <td  colspan="5"><ai:dbformfield fieldname="VIEWNAME" formid="secfuncform" width="533" />
                          </td>
                      </tr>
                      <tr>
                        <td height="1" ></td>
                        <td width="1"></td>
                        <td ></td>
                        <td width="1"></td>
                        <td ></td>
                        <td width="1"></td>
                        <td ></td>
                      </tr>
                      <tr>
                        <td width="100" ><i18n:message key="sec.func.note" res="i18n.secframe_resource"/></td>
                        <td width="1"></td>
                        <td  colspan="5"><ai:dbformfield fieldname="NOTES" formid="secfuncform" width="533" /></td>
                      </tr>
                      <tr>
                        <td height="1" ></td>
                        <td width="1"></td>
                        <td ></td>
                        <td width="1"></td>
                        <td ></td>
                        <td width="1"></td>
                        <td ></td>
                      </tr>
                      <tr>
                        <td height="1" ></td>
                        <td width="1"></td>
                        <td ></td>
                        <td width="1"></td>
                        <td ></td>
                        <td width="1"></td>
                        <td ></td>
                      </tr>
                    </table></td>
                </tr>
              </table>
          	 </ai:dbform>
            <br>
            <div id="buttonDiv" align="center">
              <ai:button  text="sec.func.addbutton" i18nRes="i18n.secframe_resource" id="addFunc" onclick="newMenuItemAction()"/>
              &nbsp;
              <ai:button text="sec.func.savebutton" i18nRes="i18n.secframe_resource" id="save" onclick="updateAction()"/>
              &nbsp;
              <ai:button   text="sec.func.delbutton" i18nRes="i18n.secframe_resource" id="delSysFunc" onclick="delMenuItemAction()"/>
            </div></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html><script language="javascript">

var secFuncRowSet = g_FormRowSetManager.get("secfuncform");
var dbtree = g_DBTreeNewManager.get("secfunction_tree");



//-- flag 1 = add,2 = update ,3 =init
function setBtnDisabled(flag){
if(flag==3){	
  document.getElementById("addfunc").disabled  = true;
  document.getElementById("save").disabled = true;
  document.getElementById("delSysFunc").disabled = true;
  } else if(flag == 1){
    document.getElementById("addfunc").disabled  = true;
  	document.getElementById("save").disabled = false;
  	document.getElementById("delSysFunc").disabled = true;
  } else if(flag == 2) {
   document.getElementById("addfunc").disabled  = false;
  	document.getElementById("save").disabled = false;
  	document.getElementById("delSysFunc").disabled = false;
  }
}

function refreshTree(){
   var dbtree = g_DBTreeNewManager.get("secfunction_tree");
   var ud = dbtree.refresh(null,1);
}

function SecfuncInfoLoad(){
	var conStr = "";
	setBtnDisabled(2);
	var dbtree = g_DBTreeNewManager.get("secfunction_tree");
	var curNode = dbtree.getCurNodeInfo();
	var curSysfuncId = curNode.value;
	if(curNode== null || curSysfuncId ==""){
	  setBtnDisabled(3);
	  return;
	}
	if(curSysfuncId==1){
		document.all.item("save").disabled = true;
		document.all.item("delSysFunc").disabled = true;
	}
	conStr ="STATE=1 and FUNC_ID="+curSysfuncId ;
	secFuncRowSet.refresh(conStr);
    	secFuncRowSet = g_FormRowSetManager.get("secfuncform");
}

function updateAction(){
	if(secFuncRowSet.toXmlString(true)==""){
		return;
	}
  if(secFuncRowSet.validate("FUNC_CODE",true,true) == false) {
  	secFuncRowSet.setFocus("FUNC_CODE");
  	return;
  }
  if(secFuncRowSet.validate("NAME",true,true) == false) {
  	secFuncRowSet.setFocus("NAME");
  	return;
  }
  
  if(secFuncRowSet.validate("FUNC_TYPE",true,true) == false) {
  	secFuncRowSet.setValue("FUNC_TYPE","");
  	secFuncRowSet.setFocus("FUNC_TYPE");
  	return;
  }

  if( secFuncRowSet.toXmlString()=="" ) {
  	//alert("未做任何修改!");
  	alert(g_I18NMessage("secframe_function","sec_function_no_change"));
  	return ;
  }
  var dbtree = g_DBTreeNewManager.get("secfunction_tree");
  var curNode = dbtree.getCurNodeInfo();
  var param="&curid="+curNode.value;
  var list = new Array();
  list.push(secFuncRowSet);
  var msg = saveRowSet('<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecFunctionDataModel?action=saveSecFunction'+param,list);
  var rtnval=msg.getValueByName("reVal");
  if(rtnval!="OK"){
    alert(rtnval);
  }else{
    alert(g_I18NMessage("secframe_function","sec_function_save_ok"));  
    //alert("保存成功");
    if(curNode.value == 1){
    	dbtree.refresh(curNode.value,1);
    } else {
    	var parentNode = dbtree.getParentNodeInfo(curNode.value);
    	
		dbtree.refresh(parentNode.value,1);
		dbtree.expandNodeByValue(curNode.value,true);
		dbtree.expandNodeByValue(parentNode.value,true);
		}
		
  }
  setBtnDisabled(2);
}

function delMenuItemAction(){
  var dbtree = g_DBTreeNewManager.get("secfunction_tree");
  var curNode = dbtree.getCurNodeInfo();
  if(curNode==null){
    //alert("请选择菜单中的某一功能！");
    alert(g_I18NMessage("secframe_function","sec_function_select_func"));
    return;
  }
  
  if(curNode.value == "1"){
    //alert("不可删除根节点");
    alert(g_I18NMessage("secframe_function","sec_function_notdel_root"));
    return;
  }

  //if(!window.confirm("是否确定要删除该功能模块?"))return;
  if(!window.confirm(g_I18NMessage("secframe_function","sec_function_confirm_del")))return;
  var param ="&curid="+curNode.value;
  var rtnval = PostInfo('<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecFunctionDataModel?action=deleteSecFunction'+param,'');  	
  if(rtnval.getValueByName("rtnval")!="OK"){
    alert(rtnval.getValueByName("rtnval"));
  }else{
    //alert("删除成功.");
    alert(g_I18NMessage("secframe_function","sec_function_del_success"));
    var parentNode = dbtree.getParentNodeInfo(curNode.value);
    dbtree.refresh(parentNode.value,1);
    secFuncRowSet.newRow(false);
  }
}

function newMenuItemAction(){
	var curNode = dbtree.getCurNodeInfo();
	
	var param="&curid="+curNode.value;
	if (null != curNode.value && 1 ==curNode.value)
	{
	   secFuncRowSet.refresh("FUNC_ID=1");
       secFuncRowSet.setValue("PARENT_ID",curNode.value);
	   setBtnDisabled(1);
	   return;
	}
    var rtnval = PostInfo('<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecFunctionDataModel?action=checkIsLeaf'+param,'');
	if(rtnval.getValueByName("MESSAGE")!="OK")
	{
       //alert("对不起！菜单目录下不能再新增菜单");
       alert(g_I18NMessage("secframe_function" , "sec_function_notdel_farnode"));
       return ;
    }
    else
    {
       secFuncRowSet.refresh("FUNC_ID=1");
       secFuncRowSet.setValue("PARENT_ID",curNode.value);
	   setBtnDisabled(1);
    }	
}

//合并节点
function closeTree(){
  
  var arr = dbtree.getChildrenNodesInfo(1);
  if(arr==null){
    return;
  }
  
  for(i=0;i<arr.length;i++){
    dbtree.expandNodeByValue(arr[i].value,false);
  }
  
  dbtree.setNodeSelect(1);
}

setBtnDisabled(3);
</script>
