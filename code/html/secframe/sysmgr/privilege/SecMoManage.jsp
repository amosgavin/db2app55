<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<ai:scriptinclude src="/jsv2/PopMenu_v2.js" />
<html>
<head>
	<title><i18n:message key="sec.mo.moManage"
			res="i18n.secframe_resource"></i18n:message></title>
</head>
<body>
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
  <tr>
     <td  align="left" width="220" valign="top">
    <ai:contractframe id="" contenttype="table" title="sec.mo.moDir" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
       <ai:contractitem/>
		  	<table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                     <td>
		<ai:dbtree_new id="sysdirtree"
			datamodel="com.ai.secframe.sysmgr.web.DBTreeModelSecMoDir"
			multiselect="false" onrightclick="rightMenu" height="460"
			width="100%" onselect="refRight" ishaveline="true" />
                     </td>
                  </tr>
              </table>			
	  </ai:contractframe>
	  <div class="area_button"><span class="font_red"><i18n:message key="sec.mo.attention" res="i18n.secframe_resource"></i18n:message></span></div>	
	 </td>
	 <td valign="top" align="left">      						
					<ai:dbform formid="frmsysmo"
						setname="com.ai.secframe.sysmgr.web.SETSecMo"
						editable="true"
						datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
						implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecMoSV"
						implservice_querymethod="querySecMo" initial="false">
						<ai:contractframe id="" contenttype="table" title="sec.mo.moManageObject" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
						  <ai:contractitem/>
					  		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
							<tr>
								<td class="td_font"><i18n:message key="sec.mo.moName" res="i18n.secframe_resource"></i18n:message>：</td>
								<td><ai:dbformfield fieldname="MO_ID" formid="frmsysmo" visible="false" />
									<ai:dbformfield fieldname="NAME" formid="frmsysmo" editable="false" width="150" />
								</td>
								<td class="td_font"><i18n:message key="sec.mo.moType" res="i18n.secframe_resource"></i18n:message>：</td>
								<td><ai:dbformfield fieldname="MO_TYPE" formid="frmsysmo" editable="true" width="150" /></td>
							</tr>
							<tr>
								<td class="td_font"><i18n:message key="sec.mo.moRemarks" res="i18n.secframe_resource"></i18n:message>：</td>
								<td colspan="3"><ai:dbformfield fieldname="REMARKS" formid="frmsysmo" editable="true" width="420" /></td>
							</tr>
						</table>
						</ai:contractframe>
					</ai:dbform>
    
													
            <ai:contractframe id="" contenttype="table" title="sec.mo.setMoAttr" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
                <ai:contractitem>
                <div class="t-bot-mc-button">
	               <ai:button id="add" text="sec.add" i18nRes="i18n.secframe_resource" onclick="grdMrg('grdMoAttr','0');" />
				   <ai:button id="del" text="sec.delete" i18nRes="i18n.secframe_resource" onclick="grdMrg('grdMoAttr','1');" />
				</div>
				</ai:contractitem>
				<ai:table tableid="grdMoAttr" oncontextmenu=""
					footdisplay="none"
					tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecMoSV"
					implservice_querymethod="queryMoAttr"
					implservice_countmethod="getMoAttrBeansCount"
					setname="com.ai.secframe.sysmgr.web.SETSecMoAttr"
					height="140" multiselect="false" oncellchange=""
					editable="true" needrefresh="true" width="100%"
					initial="false">
					<ai:col fieldname="TITLE" width="35%"/>
					<ai:col fieldname="ATTR_TYPE" width="30%"/>
					<ai:col fieldname="REMARKS" width="35%"/>
				</ai:table>
				</ai:contractframe>
													
	
		   <ai:contractframe id="" contenttype="table" title="sec.mo.setMoOp" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
               <ai:contractitem>
                <div class="t-bot-mc-button">
	               <ai:button id="add" text="sec.add" i18nRes="i18n.secframe_resource" onclick="newMoOp();" />
					<ai:button id="del" text="sec.delete" i18nRes="i18n.secframe_resource" onclick="grdMrg('grdMoOp','1');" />
				</div>
				</ai:contractitem>									
				<ai:table tableid="grdMoOp" oncontextmenu=""
					setname="com.ai.secframe.sysmgr.web.SETSecMoOp"
					tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecMoSV"
					implservice_querymethod="queryMoOp"
					implservice_countmethod="getMoOpBeansCount"
					multiselect="false" oncellchange="" footdisplay="none"
					editable="true" needrefresh="true" width="100%" height="140"
					initial="false">
					<ai:col fieldname="NAME" width="25%"/>
					<ai:col fieldname="IS_QUERY" width="25%"/>
					<ai:col fieldname="TITLE" width="25%"/>
					<ai:col fieldname="FUNC_ID" editable="false" width="25%"/>
				</ai:table>
			</ai:contractframe>		
			<div class="area_button">				
		 	<ai:button id="save" text="sec.save" i18nRes="i18n.secframe_resource" onclick="save();" />
		    </div>
</td>
</tr>
</table>
</body>
</html>
<script type="text/javascript">
<!--
//初始化页面控件
var grdMoAttr = g_TableRowSetManager.get("grdMoAttr");
var grdMoOp = g_TableRowSetManager.get("grdMoOp");
var frmsysmo = g_FormRowSetManager.get("frmsysmo");
var dbTree = g_DBTreeNewManager.get("sysdirtree");
var model = new AIPopMenuModel();
//初始化右击菜单
model.addPopMenuItem(1,g_I18NMessage("secframe_mo","sec_mo_newDir"),null,"newDir");//构造
model.addPopMenuItem(2,g_I18NMessage("secframe_mo","sec_mo_newMo"),null,"newMo");
model.addSeparator(null);//分隔线
model.addPopMenuItem(3,g_I18NMessage("secframe_mo","sec_mo_delOper"),null,"delOper");



var popMenu = new AIPopMenu(model);


//MO OP新增
function newMoOp()
{
		if(isNull()==false){
			return false;
		}
	    var paramObj = new Object();
        var dbtblMoOp = eval("grdMoOp");
		var dbformMoOp = window.showModalDialog("MoOpAdd.jsp?sequence="+(new Date().getMilliseconds()),"",
			"scroll:yes;resizable:no;status:no;help:no;dialogHeight:230px;dialogWidth:350px");
		if(dbformMoOp != null){		
		
		dbtblMoOp.newRow(false);
		dbtblMoOp.setValue(dbtblMoOp.getRow(),"NAME",dbformMoOp.name,dbformMoOp.name);
		dbtblMoOp.setValue(dbtblMoOp.getRow(),"IS_QUERY",dbformMoOp.is_query,dbformMoOp.is_query);
		dbtblMoOp.setValue(dbtblMoOp.getRow(),"TITLE",dbformMoOp.title,dbformMoOp.title);
		dbtblMoOp.setValue(dbtblMoOp.getRow(),"FUNC_ID",dbformMoOp.func_id,dbformMoOp.func_name);
	 }

}



//Grid表格的增加、删除函数
function grdMrg(grdId,type){
	var grdObj = eval(grdId);
	if(type==0){
		if(isNull()==false){
			return false;
		}
		grdObj.newRow(false);
	}else if(type==1){
		if(grdObj.getCurRowIndex()<0){
			alert(g_I18NMessage("secframe_mo","sec_mo_selectdelete"));
		}else{
			var delName=grdObj.getValue(0,"TITLE");
			if(delName==null||delName==""){
				delName=grdObj.getValue(0,"NAME");
				}
			if(!confirm(g_I18NMessage("secframe_mo","sec_mo_suredelete"))){
				return;
				}
			grdObj.deleteRow(grdObj.getCurRowIndex());
			save();
		}
	}
}
function save(){
	if(isNull()==false){
		return false;
	}
	if(frmsysmo.getValue("MO_TYPE").length<=0){
		alert(g_I18NMessage("secframe_mo","sec_mo_selectstyle"));
		frmsysmo.setFocus("MO_TYPE");
		return false;
	}
	if(attrIsNull()!=0){
		alert(g_I18NMessage("secframe_mo","sec_mo_totleattb"));
		var arr = attrIsNull().split(",");
		grdMoAttr.setFocusByName(arr[0],arr[1]);
		return false;
	}
	if(opIsNull()!=0){
		alert(g_I18NMessage("secframe_mo","sec_mo_totleaopp"));
		var arr = opIsNull().split(",");
		grdMoOp.setFocusByName(arr[0],arr[1]);
		return false;
	}
	var list = new Array();
	list[0] = frmsysmo;
	list[1] = grdMoAttr;
	list[2] = grdMoOp;
	saveRowSet(_gModuleName+"/business/com.ai.secframe.sysmgr.web.SecMoManageAction?action=saveSecMoAttrOp&MO_ID="+frmsysmo.getValue("MO_ID")+"",list);
	refdata(frmsysmo.getValue("MO_ID"));
}
function rightMenu(){
	var node = dbTree.getCurNodeInfo();
	if(node.value==0){
		popMenu.setItemEnabledById("3",false);
	}else{
		popMenu.setItemEnabledById("3",true);
	}
	popMenu.showPopMenu();
	
}
function hide(){
	popMenu.hidePopMenu();
}
document.onclick=hide;
function newDir(){
	var node = dbTree.getCurNodeInfo();
	if(node.userobj!='E'){
		alert(g_I18NMessage("secframe_mo","sec_mo_nottitle"));
		return false;
	}
	showModalDialog('SecMoDirectory.jsp',node,'dialogWidth:400px;dialogHeight:180px;center:yes;scroll:no;resizable:no;help:no;status:no;');
	dbTree.refresh(node.value,1);
}
function newMo(){
	var allnode = dbTree.getSelectionPathInfo();
	var dirFullName = "";
	var arrNode = new Array();
	var node = dbTree.getCurNodeInfo();
	if(node.userobj!='E'){
		alert(g_I18NMessage("secframe_mo","sec_mo_nottitle"));
		return false;
	}
	if(node.value!=0){
		for(var i=1;i<allnode.length;i++){
			dirFullName += "."+allnode[i].text;
		}
	}
	arrNode[0] = node.value;
	arrNode[1] = dirFullName.substr(1);
	window.showModalDialog("SecMo.jsp",arrNode,"dialogWidth:400px;dialogHeight:180px;center:yes;scroll:no;resizable:no;help:no;status:no;");
	dbTree.refresh(node.value,1);
}
function refRight(){
	var node = dbTree.getCurNodeInfo();
	if(node.userobj=='E'){
		return false;
	}
	refdata(node.value);
}
function delOper(){
	var node = dbTree.getCurNodeInfo();
	var obj = dbTree.getChildrenNodesInfo(node.value);
	var dirValue = "";
	var moId = "";
	if(node.userobj!="E"&&obj.length>0){
		alert(g_I18NMessage("secframe_mo","sec_mo_firstdata"));
		dbTree.refresh(node.value,1);
		return false;
	}
	if(node.userobj=="E")
		dirValue = node.value;
	else
		moId = node.value;
	if(window.confirm(g_I18NMessage("secframe_mo","sec_mo_suredelete"))==true){
		PostInfotoServer(_gModuleName+"/business/com.ai.secframe.sysmgr.web.SecMoManageAction?action=delSecMoAndDir&dirValue="+dirValue+"&moId="+moId,'');
		alert(g_I18NMessage("secframe_mo","sec_mo_successdelete"));
		dbTree.refresh(dbTree.getParentNodeInfo(node.value).value);
		refdata(node.value);
	}
}
function refdata(moId){
	frmsysmo.refresh("MO_ID='"+moId+"'");
	grdMoAttr.refresh("MO_ID='"+moId+"'");
	grdMoOp.refresh("MO_ID='"+moId+"'");	
}
function isNull(){
	if(frmsysmo.getValue("NAME")==""||frmsysmo.getValue("NAME").length<=0){
		alert(g_I18NMessage("secframe_mo","sec_mo_seletemo"));
		return false;
	}
	return true;
}
function attrIsNull(){
	var atrCount = grdMoAttr.getTotalRowCount();
	for(var i=0;i<atrCount;i++){
		if(grdMoAttr.getValue(i,"TITLE")==""){
			return i+",TITLE";
		}
		if(grdMoAttr.getValue(i,"ATTR_TYPE")==""){
			return i+",ATTR_TYPE";
		}
	}
	return 0;
}
function opIsNull(){
	var opCount = grdMoOp.getTotalRowCount();
	for(var i=0;i<opCount;i++){
		if(grdMoOp.getValue(i,"NAME")==""){
			return i+",NAME";
		}
		if(grdMoOp.getValue(i,"IS_QUERY")==""){
			return i+",IS_QUERY";
		}
	}
	return 0;
}
//-->
</script>
