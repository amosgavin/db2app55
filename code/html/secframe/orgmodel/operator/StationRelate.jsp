<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title><i18n:message key="stationrelat.selbasestation" res="i18n.secframe_resource"/></title>
  </head>
  <body onload="initStation()">
	      <ai:contractframe id="" contenttype="table" title="stationrelat.stationlist" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
           <ai:contractitem/>      
          	 <ai:table tableid="dbTableStation"
						setname="com.ai.secframe.orgmodel.web.SETSecStation"
						tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
						parametersname="com.ai.secframe.orgmodel.web.SecOpStationAction"
						initial="false" multiselect="false" editable="false" pagesize="10"
						width="100%" height="220" needrefresh="true" footdisplay="true">					
					  <ai:col fieldname="STATION_ID" visible="false"/>	
		              <ai:col fieldname="CODE" visible="true" />
		              <ai:col fieldname="NAME" visible="true"/>
		              <ai:col fieldname="STATION_TYPE_ID" visible="true"/>
		              <ai:col fieldname="ORGANIZE_ID" visible="true"/>
		              <ai:col fieldname="CREATE_DATE" visible="true"/>
		              <ai:col fieldname="NOTES" visible="false"/>
            </ai:table>
			</ai:contractframe>

    		<div class="area_button">
    			<ai:button text="stationrelat.confirm" i18nRes="i18n.secframe_resource" onclick="onStation()"/>&nbsp;&nbsp;
    			<ai:button text="stationrelat.cancel" i18nRes="i18n.secframe_resource" onclick="cancel()"/>
    		</div>

  </body>
  <script type="text/javascript">
  	function getDBTableStation()
	{
		return g_TableRowSetManager.get("dbTableStation");
	}
	/**
	 * 初始化组织所包含的岗位
	 */
	function initStation()
	{
		var dbgridStation = getDBTableStation();
		// 获取组织ID
    	var orgId = window.dialogArguments;
    	if(orgId == -1)
		{
			return;
		}
		dbgridStation.refresh("refreshStation","organizeId="+orgId);
		var count = dbgridStation.count();
		for(var i=0; i < count; i++)
		{
			var notes = dbgridStation.getValue(i, "NOTES");
			if(notes != null && notes == "1")
			{
				dbgridStation.rowSelected(i, true, false);
			}
		}
	}
	/**
	 * 返回选中的岗位
	 */
	function onStation()
	{
		var dbTableStation = getDBTableStation();
		var selRows = dbTableStation.getSelectedRows();
	    if(selRows != null && selRows.length > 0)
	    {
	    	var stId = dbTableStation.getValue(dbTableStation.getRow(), "STATION_ID");
	    	var name = dbTableStation.getValue(dbTableStation.getRow(), "NAME");
	    	var station = Station(stId, name);
		    window.returnValue = station;
	    	window.self.close();
	    }
	    else
	    {
	    	alert(g_I18NMessage("secframe_stationrelat", "secframe_stationrelat_selstation"));
	    	return;
	    }
	}
	/**
	 * 退出，关闭窗口
	 */
	function cancel()
	{
		window.returnValue = null;
		window.self.close();
	}
	/**
	 * 岗位对象
	 */
	function Station(id, name)
	{
		var station = new Object();
		station.id = id;
		station.name = name;
		return station;
	}
  </script>
  
</html>
