<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<HTML>
<head>
<title><i18n:message key="sec.staff.staff" res="i18n.secframe_resource"/></title>
</head>
<ai:loginuser />
<body onLoad="init()">
  <ai:contractframe id="" contenttype="table"
						title="sec.staff.staffselect" i18nRes="i18n.secframe_resource"
						width="100%" allowcontract="false" frameclosed="false">
						<ai:contractitem />
						<ai:table setname="com.ai.secframe.sysmgr.web.SETQBOSecMoPermission"
						tableid="tblStaff" needrefresh="true" initial="false"
						multiselect="false" editable="false" pagesize="5" width="100%"
						height="120" onrowchange="qryPer"
						tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
						implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecMoPrivilegeSV"
						implservice_querymethod="getOperatorByMoId"
						implservice_countmethod="getQBOSecMoPermissionCount">
        <ai:col fieldname="PERMISSION_ID" visible="false" />
        <ai:col fieldname="OP_STATION_ID" visible="false" />
        <ai:col fieldname="OPERATOR_ID" visible="false" />
        <ai:col fieldname="STAFF_CODE" visible="true" width="20%" />
        <ai:col fieldname="STAFF_NAME" visible="true" width="20%" />
        <ai:col fieldname="STATION_NAME" visible="true" width="30%" />
        <ai:col fieldname="OP_STATION_NAME" visible="false"/>
        <ai:col fieldname="ORG_NAME" visible="true" width="30%" />
      </ai:table>
</ai:contractframe>

    <div class="area_button">
    <ai:button  text="sec.add" i18nRes="i18n.secframe_resource" id="newBtn" onclick="addStaff()" />&nbsp;&nbsp;
      <ai:button  text="sec.delete" i18nRes="i18n.secframe_resource" id="delBtn" onclick="delStaff()"/>
    </div>
</body>
</html><script type="text/javascript">
<!--
var flag = 1;
var tabStaff = g_TableRowSetManager.get("tblStaff");
function qryPer(){	
	var permId = tabStaff.getValue(tabStaff.getRow(),"PERMISSION_ID");
	window.parent.permId = permId;
	window.parent.qryPerm(permId);
}
function init(){
	var moId = window.parent.moId;
	var operName = window.parent.operName;
	if(moId==null){
		return false;
	}else{
    	var cond = "mo_id='"+moId+"' and operator_name='"+operName+"' and OP_STATION_ID is not null";
		tabStaff.refresh(cond);
		}
}

function delStaff(){
	var tabOpStation = g_TableRowSetManager.get("tblStaff");
	var selCount=tabOpStation.getTotalRowCount();
	if(selCount==0){
		alert(g_I18NMessage("sec_qsecstaffselec", "sec_qsecstaffselect_nonote"));
		return;
	}
	var operatorCode=tabStaff.getValue(tabStaff.getRow(),"STAFF_CODE");
	if(operatorCode=="")
	{
		//alert("请选择一条要删除的记录");
		alert(g_I18NMessage("secframe_mo", "sec_mo_deleterecord"));
		return;
	}
	if(window.confirm(g_I18NMessage("secframe_staff", "sec_staff_suredelete")+tabStaff.getValue(tabStaff.getRow(),"STAFF_NAME")+g_I18NMessage("secframe_staff", "sec_staff_what"))){
 		//alert(tabStaff.getValue(tabStaff.getRow(),"STAFF_ID")+":"+tabStaff.getValue(tabStaff.getRow(),"PERMISSION_ID"));
 		//return;
 		window.parent.delPerm(tabStaff.getValue(tabStaff.getRow(),"PERMISSION_ID"));
 		init();
 	}
}
function addStaff(){
	if( window.parent.moId == null ) return ;
  	var oldStaffArray = new Array();
  	for( var i=0;i<tabStaff.count();i++ )
    	oldStaffArray[i] = tabStaff.getValue(i,"OP_STATION_ID");
  	
	var ret = window.showModalDialog("QSecStaffSelect.jsp?staffprivilege=staffprivilege","org","scroll:no;resizable:no;status:no;dialogHeight:500px;dialogWidth:800px");
  	if(ret!=null){
  		ret[0] = ret[0].substr(0,ret[0].length-1);
  		window.parent.save(ret[0]);
  		init();
  	}
}
function initPermId(){
	if(tabStaff.getRow()<=-1){
		window.parent.permId = null;
	}else{
		window.parent.permId = tabStaff.getValue(tabStaff.getRow(),"PERMISSION_ID");
	}
}
//-->
</script>
