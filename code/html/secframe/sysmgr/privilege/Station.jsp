<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<HTML>
	<head>
		<title><i18n:message key="sec.station.objstation" res="i18n.secframe_resource"/></title>
	</head>
	<body onLoad="init()">
			<ai:contractframe id="" contenttype="table"
						title="sec.station.stationselect" i18nRes="i18n.secframe_resource"
						width="100%" allowcontract="false" frameclosed="false">
						<ai:contractitem />
					<ai:table
						setname="com.ai.secframe.sysmgr.web.SETQBOSecMoPermission"
						tableid="tblStation" needrefresh="true" initial="false"
						multiselect="false" editable="false" pagesize="5" width="100%"
						height="120" onrowchange="qryPer"
						tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
						implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecMoPrivilegeSV"
						implservice_querymethod="getQBOSecMoPermissionValues"
						implservice_countmethod="getQBOSecMoPermissionCount">
						<ai:col fieldname="PERMISSION_ID" visible="false" />
						<ai:col fieldname="STATION_ID" visible="false" />
						<ai:col fieldname="STATION_CODE" width="40%" />
						<ai:col fieldname="STATION_NAME" width="60%" />
					</ai:table>
</ai:contractframe>

				<div class="area_button">
					<ai:button text="sec.add" i18nRes="i18n.secframe_resource" id="newBtn"
						onclick="addStation()" />&nbsp;&nbsp;
					<ai:button text="sec.delete" i18nRes="i18n.secframe_resource" id="delBtn"
						onclick="delStation()" />
				</div>
	</body>
</html>
<script language="javascript">
var tblStation = g_TableRowSetManager.get("tblStation");
var flag = 1;
function init(){
	var moId = window.parent.moId;
	var operName = window.parent.operName;
	if(moId==null){
		return false;
	}else{
    	var cond = "mo_id='"+moId+"' and operator_name='"+operName+"' and STATION_ID is not null";
		tblStation.refresh(cond);
		//if(tblStation.count()>0)
			//tblStation.setRow(0);
	}
}
function addStation(){
	var moId = window.parent.moId;;
  	if( moId == null ) 
  		return ;
  	var arr = new Array();
   	var len = tblStation.count();
   	for( var i=0;i<len;i++)
   		arr.push(tblStation.getValue(i,"STATION_ID"));
  	///orgmodel/operstation/StationSelect.jsp
	
	var url = "StationSelect.jsp";
	var ret = window.showModalDialog(url,"" , "scroll:no;resizable:no;help:no;status:no;dialogHeight:450px;dialogWidth:700px");
	//var ret = window.showModalDialog("../../orgmodel/operstation/StationSelect.jsp?org_id=<%=SessionManager.getUser().getOrgId()%>&staff_id=0","","scroll:no;resizable:no;status:no;dialogHeight:450px;dialogWidth:300px;help:no");
  	if(ret!=null){
  		ret[0] = ret[0].substr(0,ret[0].length-1);
  		window.parent.save(ret[0]);
  		init();
  	}
}


function delStation(){
	var tabStation = g_TableRowSetManager.get("tblStation");
	var selCount=tabStation.getTotalRowCount();
	if(selCount==0){
		alert(g_I18NMessage("sec_qsecstaffselec", "sec_qsecstaffselect_nonote"));
		return;
	}
	var stationName= tabStation.getValue(tabStation.getRow(),"STATION_NAME");
	if(stationName=="")
	{
		alert(g_I18NMessage("secframe_mo","sec_mo_deleterecord"));
		return;
	}
	if( tblStation.getRow() != -1 && window.confirm(g_I18NMessage("secframe_stationa", "sec_stationa_sureselect")+tblStation.getValue(tblStation.getRow(),"STATION_NAME")+g_I18NMessage("secframe_stationa", "sec_stationa_what"))){
   		window.parent.delPerm(tblStation.getValue(tblStation.getRow(),"PERMISSION_ID"));
 		init();
	}
}
function qryPer(){	
	var permId = tblStation.getValue(tblStation.getRow(),"PERMISSION_ID");
	window.parent.permId = permId;
	window.parent.qryPerm(permId);
}
function initPermId(){
	if(tblStation.getRow()<=-1){
		window.parent.permId = null;
	}else{
		window.parent.permId = tblStation.getValue(tblStation.getRow(),"PERMISSION_ID");
	}
}
</script>
