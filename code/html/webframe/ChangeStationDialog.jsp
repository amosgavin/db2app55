<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ page import="com.ai.appframe2.common.SessionManager"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<%
   long operId = SessionManager.getUser().getID();
%>
<html>
	<head>
		<title><i18n:message key="changestationdialog.stationchange" res="i18n.secframe_resource"/></title>
	</head>
	<body onload="initTable()">
	       <ai:contractframe id="" contenttype="table" title="changestationdialog.canstation" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>
            <ai:table tableid="selectStationTable"
							setname="com.ai.secframe.orgmodel.web.SETSecOpStationOrg"
							initial="false" multiselect="false" editable="false"
							tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
							implservice_name="com.ai.secframe.orgmodel.service.interfaces.ISecOpStationSV"
							footdisplay="true"  conditionname="condition" 
							implservice_querymethod="getOpStationQBOsByOperId(long operId)" 
							implservice_countmethod="getOpStationQBOsCountByOperId(long operId)" pagesize="10"
							width="98%" height="300" needrefresh="true">
			  
			  <ai:col fieldname="STATION_ID" width="25%" editable="false" visible="true" />															
              <ai:col fieldname="STATION_NAME" width="25%" editable="false" visible="true" />
			  <ai:col fieldname="IS_BASE_STATION" width="25%" editable="false"	visible="true" />	
			  <ai:col fieldname="ORGANIZE_NAME" width="25%" editable="false" visible="true" />											
            </ai:table>
            </ai:contractframe>
           
				<div class="area_button">
				<ai:button text="changestationdialog.confirm" i18nRes="i18n.secframe_resource" id="affirm" onclick="affirm()"/>
				&nbsp;
				<ai:button text="changestationdialog.basestation" i18nRes="i18n.secframe_resource" id="setBaseStation" onclick="setBaseStation()"/>
				&nbsp;
				<ai:button  text="changestationdialog.cancel" i18nRes="i18n.secframe_resource" id="cancel" onclick="cancel()"/>
				</div>

	</body>
</html>
<script type="text/javascript">
function initTable()
{
   var selectStationTable = g_TableRowSetManager.get("selectStationTable");
   selectStationTable.refresh("operId="+<%= operId%>);
}

function selectStation()
{
    var selectStationTable = g_TableRowSetManager.get("selectStationTable");
    var row = selectStationTable.getRow();
    var stationId = selectStationTable.getValue(selectStationTable.getRow(),"STATION_ID");
    window.returnValue = stationId;	
	window.self.close();
}
function affirm(){
    var selectStationTable = g_TableRowSetManager.get("selectStationTable");
    if(selectStationTable.getSelectedRows()==null ||selectStationTable.getSelectedRows().length == 0)
    {
        //alert("请您先选择要切换岗位！");
        alert(g_I18NMessage("secframe_changestationdialog", "secframe_changestationdialog_selstation"));
		return false;
    }
	var selRows = selectStationTable.getSelectedRows();
	if(selRows != null && selRows.length > 0)
	{
	    var stationId  = selectStationTable.getValue(selRows[0],"STATION_ID");
	    window.returnValue = stationId;	
		window.self.close();
	}
}

function setBaseStation()
{
	var selectStationTable = g_TableRowSetManager.get("selectStationTable");
    var stId = selectStationTable.getValue(selectStationTable.getRow(),"STATION_ID");
    if(stId != null && stId != "")
    {
	    var param = "&stId="+stId+"&operId="+<%=operId%>;
	    var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOperatorAction?action=saveOpStation"+param);
	    if(msg != null)
	    {
		    var retVal = msg.getValueByName("retVal");
		    if( retVal == "1" )
		    {
		      	//alert("设置默认岗位成功!");
		      	alert(g_I18NMessage("secframe_changestationdialog", "secframe_changestationdialog_makebasestation_succ"));
		      	selectStationTable.refresh("operId="+<%= operId%>);
		    }
		    else
		    {
		    	alert(msg.getValueByName("retMsg"));
		    }
	    }
    }
    else
    {
    	//alert("请您选择要设置的默认岗位！");
    	alert(g_I18NMessage("secframe_changestationdialog", "secframe_changestationdialog_selbasestation"));
    }
}
function cancel(){	
	window.self.close();
}
function chkCur(){
	affirm();
}

</script>
