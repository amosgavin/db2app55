<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<HTML>
<head>
<title><i18n:message key="sec.role.stationstyle" res="i18n.secframe_resource"/></title>
</head>
<body onLoad="init()">
    <ai:contractframe id="" contenttype="table"
						title="sec.role.styleselect" i18nRes="i18n.secframe_resource"
						width="100%" allowcontract="false" frameclosed="false">
						<ai:contractitem />
						<ai:table setname="com.ai.secframe.sysmgr.web.SETQBOSecMoPermission"
							tableid="tblRole" needrefresh="true" initial="false"
							multiselect="false" editable="false"  pagesize="5" width="100%"
						height="120"  onrowchange="qryPer"
							tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
							implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecMoPrivilegeSV"
							implservice_querymethod="getQBOSecMoPermissionValues"
							implservice_countmethod="getQBOSecMoPermissionCount">
        <ai:col fieldname="PERMISSION_ID" visible="false" />
        <ai:col fieldname="ROLE_ID" width="40%"/>
        <ai:col fieldname="ROLE_NAME" width="60%" />
      </ai:table>
</ai:contractframe>

   <div class="area_button">
   		<ai:button  text="sec.add" i18nRes="i18n.secframe_resource" id="newBtn" onclick="addRole()"/>&nbsp;&nbsp;
    	<ai:button text="sec.delete" i18nRes="i18n.secframe_resource" id="delBtn" onclick="delRole()"/>
    </div>
</body>
</html><script language="javascript">
var tblRole = g_TableRowSetManager.get("tblRole");
var flag = 1;
function init(){
	var moId = window.parent.moId;
	var operName = window.parent.operName;
	if(moId==null){
		return false;
	}else{
    	var cond = "mo_id='"+moId+"' and operator_name='"+operName+"' and ROLE_ID is not null";
		tblRole.refresh(cond);
		//if(tblRole.count()>0)
			//tblRole.setRow(0);
	}
}
function addRole(){
	var moId = window.parent.moId;;
	if( moId == null ) 
  		return ;
   	var len = tblRole.count();
   	var url = "RoleSelect.jsp";
	var ret = window.showModalDialog(url,"" , "scroll:no;resizable:no;help:no;status:no;dialogHeight:450px;dialogWidth:800px");
	if(ret!=null){
  	  	ret[0] = ret[0].substr(0,ret[0].length-1);
		window.parent.save(ret[0]);
		init();
  	}
}

function delRole(){
	var tabRole = g_TableRowSetManager.get("tblRole");
	var selCount=tabRole.getTotalRowCount();
	if(selCount==0){
		alert(g_I18NMessage("sec_qsecstaffselec", "sec_qsecstaffselect_nonote"));
		return;
	}
	var roleName=tabRole.getValue(tabRole.getRow(),"ROLE_NAME");
	if(roleName=="")
	{
		alert(g_I18NMessage("secframe_mo", "sec_mo_deleterecord"));
		return;
	}
  	if(tblRole.getRow() != -1 &&
      	window.confirm(g_I18NMessage("secframe_role_mo", "secframe_role_mo_sureselect")+tblRole.getValue(tblRole.getRow(),"ROLE_NAME")+g_I18NMessage("secframe_role_mo", "secframe_role_mo_what")) ){
    	window.parent.delPerm(tblRole.getValue(tblRole.getRow(),"PERMISSION_ID"));
    	init();
	}
}
function qryPer(){
	var permId = tblRole.getValue(tblRole.getRow(),"PERMISSION_ID");
	window.parent.permId = permId;
	window.parent.qryPerm(permId);
}
function initPermId(){
	if(tblRole.getRow()<=-1){
		window.parent.permId = null;
	}else{
		window.parent.permId = tblRole.getValue(tblRole.getRow(),"PERMISSION_ID");
	}
}
</script>
