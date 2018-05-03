<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.secframe.common.Constants"%>
<html>
<head>
<title><i18n:message key="sec.func.funcmgr" res="i18n.secframe_resource"/></title>
</head>
<body onLoad="closeTree()">
<%
    String rootId = Constants.STR_FUNC_ROOT_ID;
%>
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
         <tr>
           <td width="220" valign="top">
           <ai:contractframe id="" contenttype="table" title="sec.func.funcmgr" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
		  <ai:contractitem/>
		  <table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
			<ai:dbtree_new id="secfunction_tree" height="500" width="100%" 
				   datamodel="com.ai.secframe.sysmgr.web.SecFunctionDataModel" 
				   initial="true" ishaveline="true"
				   onselect="SecfuncInfoLoad" />
						</td>
					</tr>
				</table>
			</ai:contractframe>
		</td>
		<td valign="top" align="right">
		<ai:dbform formid="secfuncform" 
			datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
			setname="com.ai.secframe.sysmgr.web.SETSecFunction" 
			implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecFunctionSV"
			implservice_querymethod="querySecFunction"
			initial="false">
			 
              <ai:contractframe id="" contenttype="table" title="sec.func.info" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
			  <ai:contractitem/>
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                <tr>
                        <td class="td_font"><i18n:message key="sec.func.name" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="NAME" formid="secfuncform" width="150" /><span class="font_red">*</span></td>
                  		<td class="td_font"><i18n:message key="sec.func.verifymode" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="VERIFY_MODE" formid="secfuncform" width="150" /><span class="font_red">*</span>
                          <ai:dbformfield fieldname="PARENT_ID" formid="secfuncform"  visible="false"  width="150" />
                          <ai:dbformfield fieldname="FUNC_ID" formid="secfuncform"  visible="false"  width="150" /></td>
                      </tr>
                      <tr>
                        <td class="td_font"><i18n:message key="sec.func.img" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="FUNC_IMG" formid="secfuncform" width="150" /></td>
                        <td class="td_font"><i18n:message key="sec.func.type" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="FUNC_TYPE" formid="secfuncform" width="150" /><span class="font_red">*</span></td>
                      </tr>
                      <tr>
                        <td class="td_font"><i18n:message key="sec.func.typeparam" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="FUNC_ARG" formid="secfuncform" width="150" /></td>
                        <td class="td_font"><i18n:message key="sec.func.dllfile" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="DLL_PATH" formid="secfuncform" width="150" /></td>
                      </tr>
                       <tr>
                        <td class="td_font"><i18n:message key="sec.module.type" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="MODULE_TYPE" formid="secfuncform" width="150" /><span class="font_red">*</span></td>
                        <td class="td_font"><i18n:message key="sec.domain.id" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="DOMAIN_ID" formid="secfuncform" width="150" /><span class="font_red">*</span></td>
                      </tr>
                      <!-- 新增业务场景、业务类型 、登录方式、接入方式-->
                      <tr>
                        <td class="td_font"><i18n:message key="sec.func.busiscene" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="BUSI_SCENE" formid="secfuncform" width="150" /><span class="font_red">*</span></td>
                        <td class="td_font"><i18n:message key="sec.func.bustype" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="BUSI_TYPE" formid="secfuncform" width="150" /><span class="font_red">*</span></td>
                      </tr>
                       <tr>
                        <td class="td_font"><i18n:message key="sec.func.loginmode" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="LOGIN_MODE" formid="secfuncform" width="150" /><span class="font_red">*</span></td>
                        <td class="td_font"><i18n:message key="sec.func.entrance" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="ENTRANCE" formid="secfuncform" width="150" /><span class="font_red">*</span></td>
                      </tr>
                      <!-- end -->
                      <tr>
                        <td class="td_font"><i18n:message key="sec.func.url" res="i18n.secframe_resource"/>：</td>
                        <td  colspan="5"><ai:dbformfield fieldname="VIEWNAME" formid="secfuncform" width="410" />
                          </td>
                      </tr>
                      <tr>
                        <td class="td_font"><i18n:message key="sec.func.note" res="i18n.secframe_resource"/>：</td>
                        <td  colspan="5"><ai:dbformfield fieldname="NOTES" formid="secfuncform" width="410" /></td>
                      </tr>
              </table>
			</ai:contractframe>
          	 </ai:dbform>
          	 <div id="buttonDiv" class="area_button">
              <ai:button text="sec.func.addbutton" i18nRes="i18n.secframe_resource" id="addFunc" onclick="newMenuItemAction()"/>&nbsp;&nbsp;
              <ai:button text="sec.func.savebutton" i18nRes="i18n.secframe_resource" id="save" onclick="updateAction()"/>&nbsp;&nbsp;
              <ai:button text="sec.func.delbutton" i18nRes="i18n.secframe_resource" id="delSysFunc" onclick="delMenuItemAction()"/>
            </div>
          	 </td>
           </tr>
        </table>
		
          	 
</body>
</html><script language="javascript">

var rootId = "<%=rootId%>";
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
	if(curSysfuncId==rootId){
		document.all.item("save").disabled = true;
		document.all.item("delSysFunc").disabled = true;
	}
	conStr ="STATE=1 and FUNC_ID="+curSysfuncId ;
	secFuncRowSet.refresh(conStr);
	secFuncRowSet = g_FormRowSetManager.get("secfuncform");
	
	// 每次刷新后都检查树节点是否是目录节点
	dbtree = g_DBTreeNewManager.get("secfunction_tree");
	curNode = dbtree.getCurNodeInfo();
	var hasChild = dbtree.hasChildNode(curNode.value);
	if (hasChild == true)
	{
		secFuncRowSet.setColEditSts("VIEWNAME",false);
	}
	else
	{
		secFuncRowSet.setColEditSts("VIEWNAME",true);
	}
}

function updateAction(){
	if(secFuncRowSet.toXmlString(true)==""){
		return;
	}
  if(secFuncRowSet.validate("NAME",true,true) == false) {
  	secFuncRowSet.setFocus("NAME");
  	return;
  }
  if(secFuncRowSet.validate("VERIFY_MODE",true,true) == false) {
  	secFuncRowSet.setValue("VERIFY_MODE","");
  	secFuncRowSet.setFocus("VERIFY_MODE");
  	return;
  }
  if(secFuncRowSet.validate("FUNC_TYPE",true,true) == false) {
  	secFuncRowSet.setValue("FUNC_TYPE","");
  	secFuncRowSet.setFocus("FUNC_TYPE");
  	return;
  }
   if(secFuncRowSet.validate("MODULE_TYPE",true,true) == false) {
  	secFuncRowSet.setValue("MODULE_TYPE","");
  	secFuncRowSet.setFocus("MODULE_TYPE");
  	return;
  }
   if(secFuncRowSet.validate("DOMAIN_ID",true,true) == false) {
  	secFuncRowSet.setValue("DOMAIN_ID","");
  	secFuncRowSet.setFocus("DOMAIN_ID");
  	return;
  }
  if(secFuncRowSet.validate("BUSI_SCENE",true,true) == false) {
  	secFuncRowSet.setValue("BUSI_SCENE","");
  	secFuncRowSet.setFocus("BUSI_SCENE");
  	return;
  }
  if(secFuncRowSet.validate("BUSI_TYPE",true,true) == false) {
  	secFuncRowSet.setValue("BUSI_TYPE","");
  	secFuncRowSet.setFocus("BUSI_TYPE");
  	return;
  }
  if(secFuncRowSet.validate("LOGIN_MODE",true,true) == false) {
  	secFuncRowSet.setValue("LOGIN_MODE","");
  	secFuncRowSet.setFocus("LOGIN_MODE");
  	return;
  }
  if(secFuncRowSet.validate("ENTRANCE",true,true) == false) {
  	secFuncRowSet.setValue("ENTRANCE","");
  	secFuncRowSet.setFocus("ENTRANCE");
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
    if(curNode.value == rootId){
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
  
  if(curNode.value == rootId){
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
	if (null != curNode.value && rootId ==curNode.value)
	{
	   secFuncRowSet.refresh("FUNC_ID="+curNode.value);
       secFuncRowSet.setValue("PARENT_ID",curNode.value);
	   setBtnDisabled(1);
	   // 新增按钮响应后，将URL输入框置为可编辑
	   secFuncRowSet.setColEditSts("VIEWNAME",true);
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
       secFuncRowSet.refresh("FUNC_ID="+rootId);
       secFuncRowSet.setValue("PARENT_ID",curNode.value);
	   setBtnDisabled(1);
	   // 新增按钮响应后，将URL输入框置为可编辑
	   secFuncRowSet.setColEditSts("VIEWNAME",true);
    }	
}

//合并节点
function closeTree(){
  
  var arr = dbtree.getChildrenNodesInfo(rootId);
  if(arr==null){
    return;
  }
  
  for(i=0;i<arr.length;i++){
    dbtree.expandNodeByValue(arr[i].value,false);
  }
}

setBtnDisabled(3);
</script>
