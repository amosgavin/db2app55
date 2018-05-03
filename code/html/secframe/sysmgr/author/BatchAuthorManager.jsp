<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title><i18n:message key="sec.batchauthor.title" res="i18n.secframe_resource"/></title>
 	 <%
 		long operId = SessionManager.getUser().getID();
 	 %>
  </head>
  <body>
  <ai:contractframe id="ctframe" contenttype="table" title="sec.authormanager.info" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	<ai:table setname="com.ai.secframe.orgmodel.web.SETSecOpStationOrg" tableid="DBTableOpStation"
			 tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
			 parametersname="com.ai.secframe.orgmodel.web.SecOpStationAction" pagesize="12" width="100%" height="260"
			 initial = "false" multiselect = "true" needrefresh="true" editable="false" >
 		<ai:col fieldname="OP_STATION_ID"  visible="false"/>
		<ai:col fieldname="CODE" width="20%"  visible="true"/>
		<ai:col fieldname="STAFF_NAME" width="20%" visible="true"/>
		<ai:col fieldname="STATION_ID" visible="false"/>
		<ai:col fieldname="STATION_NAME" width="30%" visible="true"/>
		<ai:col fieldname="ORGANIZE_NAME" width="30%" visible="true"/>
		<ai:col fieldname="ORG_CODE" visible="false"/>
		<ai:col fieldname="CREATE_DATE" visible="false"/>
		<ai:col fieldname="STATE" visible="false"/>
 	</ai:table>
</ai:contractframe>
<div class="area_button">
  	<ai:button id="openAuthorWinBtn" text="sec.batchauthor.author" i18nRes="i18n.secframe_resource" enable="false" onclick="showAuthorDialog()"/>
</div>
  </body>
  <script type="text/javascript">
  
  	/**
  	 * 初始化
  	 */
  	function initial(operatorId, stId, orgId)
  	{
  		// 查询操作员岗位关系
  		if(operatorId > 0)
  		{
	  		var dbTableOpStation = g_TableRowSetManager.get("DBTableOpStation");
			dbTableOpStation.refresh("refresh", "operId="+operatorId+"&stId="+stId);
			g_AIButtonManager.get("openAuthorWinBtn").setDisabled(false);
		}
		else if(stId > 0)
		{
			var dbTableOpStation = g_TableRowSetManager.get("DBTableOpStation");
			dbTableOpStation.refresh("refresh", "operId=&stId="+stId);
			if(dbTableOpStation.getTotalRowCount() > 0)
			{
				g_AIButtonManager.get("openAuthorWinBtn").setDisabled(false);
			}
			else
			{
				alert(g_I18NMessage("secframe_author", "sec_batchauthor_station_empty"));
				g_AIButtonManager.get("openAuthorWinBtn").setDisabled(true);
			}
		}
		else
		{
			var dbTableOpStation = g_TableRowSetManager.get("DBTableOpStation");
			dbTableOpStation.refresh("refresh", "1<>1");
			g_AIButtonManager.get("openAuthorWinBtn").setDisabled(true);
		}
  	}
	/**
	 * 显示授权对话框
	 */
	function showAuthorDialog()
	{
		var dbTableOpStation = g_TableRowSetManager.get("DBTableOpStation");
		var selRows = dbTableOpStation.getSelectedRows();
		if(selRows != null && selRows.length > 0)
		{
			var opstIdStr = "";
			for(var i=1; i < selRows.length; i++)
			{
				opstIdStr = opstIdStr +","+ dbTableOpStation.getValue(selRows[i], "OP_STATION_ID");
			}
			opstIdStr = dbTableOpStation.getValue(selRows[0], "OP_STATION_ID") + opstIdStr;
			
			if (opstIdStr == "")
			{
				alert(g_I18NMessage("secframe_author", "sec_station_select"));
				return;
			}
		 	var url = "<%=request.getContextPath()%>/secframe/sysmgr/author/RoleSelect.jsp";
			var retVal = window.showModalDialog(url, opstIdStr, "scroll:no;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:600px");
		}
		else
		{
			alert(g_I18NMessage("secframe_author", "sec_station_select"));
			return;
		}
	}
  </script>
</html>
