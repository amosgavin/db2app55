<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title><i18n:message key="sec.stationselect.title" res="i18n.secframe_resource"/></title>
  </head>
  <body>
<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
	<tr>
		<td width="220" valign="top">
			<ai:contractframe id="ctframe1" contenttype="table" title="sec.organize.orgchioc" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
		  		<ai:contractitem/>
		  			<table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
		  				<tr>
		  					<td>
		  						<ai:dbtree_new id="orgStationTree" datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel" 
								multiselect="false" height="360" width="100%" ishaveline="true" 
								onselect="orgTreeNodeClick"/>
		  					</td>
		  				</tr>
		  			</table>
		  	</ai:contractframe>
		</td>
		<td valign="top" align="right">	
			<ai:contractframe id="ctframe2" contenttype="table" title="sec.station.list" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
		  		<ai:contractitem/>
		  			<ai:table tableid="dbTableStation"
								setname="com.ai.secframe.orgmodel.web.SETSecStation"
								tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
								parametersname="com.ai.secframe.orgmodel.web.SecOpStationAction"
								initial="false" multiselect="true" editable="false" pagesize="10"
								width="100%" height="220" needrefresh="true" footdisplay="true">
								
							  <ai:col fieldname="STATION_ID" visible="false"/>	
				              <ai:col fieldname="CODE" width="100" visible="true" />
				              <ai:col fieldname="NAME" width="200" visible="true"/>
				              <ai:col fieldname="STATION_TYPE_ID" width="100" visible="true"/>
				              <ai:col fieldname="ORGANIZE_ID" width="100" visible="true"/>
				              <ai:col fieldname="CREATE_DATE" visible="false"/>
				              <ai:col fieldname="NOTES" visible="false"/>
		            </ai:table>  		
		  	</ai:contractframe>
		  	<div class="area_button">
				<ai:button text="sec.confirm" i18nRes="i18n.secframe_resource" onclick="onStation()"/>
				<ai:button text="sec.cancel" i18nRes="i18n.secframe_resource" onclick="cancel()"/>
			</div>
		</td>
	</tr>
</table>
  </body>
  <script type="text/javascript">
  	function getDBTableStation()
	{
		return g_TableRowSetManager.get("dbTableStation");
	}
	/**
	 * 点击组织节点显示该组织所包含的岗位
	 */
	function orgTreeNodeClick(organizeId, organizeName, treeUserObj, treeNodeType)
	{
		var dbgridStation = getDBTableStation();
		if(organizeId == -1)
		{
			return;
		}
		// 获取操作员ID
    	var curOperId = window.dialogArguments;
		dbgridStation.refresh("refreshStation","organizeId="+organizeId+"&operId="+curOperId);
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
	 * 上岗
	 */
	function onStation()
	{
		var dbTableStation = getDBTableStation();
		var selRows = dbTableStation.getSelectedRows();
	    if(selRows != null && selRows.length > 0)
	    {
	    	// 获取操作员ID
	    	var curOperId = window.dialogArguments;
	   		var stIdStr = "";
	   		for(var i=0; i < selRows.length; i++)
	   		{
	   			var selStId = dbTableStation.getValue(selRows[i], "STATION_ID");
	   			stIdStr = stIdStr + selStId+",";
	   		}
	    	var param = "operId="+curOperId+"&stIdStr="+stIdStr;
		    var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOpStationAction?action=saveOpStation&"+param);
		    var retVal = msg.getValueByName("retVal");
		    if(retVal == 1 || retVal == "1")
		    {
		    	alert(g_I18NMessage("secframe_common", "sec_common_saveok"));
		    	window.returnValue = 1;
		    	window.self.close();
		    }
		    else
		    {
		    	alert(g_I18NMessage("secframe_common", "sec_common_saveok"));
		    }
	    }
	    else
	    {
	    	alert(g_I18NMessage("secframe_opstation", "sec_opstation_not_select"));
	    	return;
	    }
	}
	/**
	 * 退出，关闭窗口
	 */
	function cancel()
	{
		window.returnValue = 0;
		window.self.close();
	}
  </script>
  
</html>
