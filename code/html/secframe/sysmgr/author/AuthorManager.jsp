<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title><i18n:message key="sec.authormanager.title" res="i18n.secframe_resource"/></title>
 	 <%
 		long operId = SessionManager.getUser().getID();
 	 %>
  </head>
  
  <body>
  <ai:contractframe id="contractframe1" contenttype="table" title="sec.authormanager.info" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	<ai:table setname="com.ai.secframe.orgmodel.web.SETSecOpStationOrg" tableid="DBTableOpStation"
			 tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
			 parametersname="com.ai.secframe.orgmodel.web.SecOpStationAction" pagesize="4" width="100%" height="100"
			 initial = "false" multiselect = "false" onrowchange="refreshAuthoredRoles"
			 needrefresh="true" editable="false" >
 		<ai:col fieldname="OP_STATION_ID"  visible="false"/>
		<ai:col fieldname="CODE" width="20%"/>
		<ai:col fieldname="STAFF_NAME"  width="30%"/>
		<ai:col fieldname="STATION_ID"  visible="false"/>
		<ai:col fieldname="STATION_NAME"  width="30%"/>
		<ai:col fieldname="IS_BASE_STATION" width="20%"/>
		<ai:col fieldname="ORGANIZE_NAME" visible="false"/>
		<ai:col fieldname="ORG_CODE" visible="false"/>
		<ai:col fieldname="CREATE_DATE" visible="false"/>
		<ai:col fieldname="STATE" visible="false"/>
 	</ai:table>
</ai:contractframe>
<div class="area_button">
  	<ai:button id="openAuthorWinBtn" text="sec.authormanager.author" i18nRes="i18n.secframe_resource" enable="false" onclick="showAuthorDialog()"/>
</div>
<ai:contractframe id="contractframe2" contenttype="table" title="sec.authormanager.author.list" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	<ai:table setname="com.ai.secframe.sysmgr.web.SETSecAuthoredRole" tableid="dbTableAuthoredRole"
			 tablemodel="com.ai.appframe2.web.tag.ActionDataModel"	height="100" width="100%"	
			 parametersname="com.ai.secframe.sysmgr.web.SecAuthorAction" pagesize="4"
			 initial = "false" multiselect = "true" needrefresh="true" editable="true">							 
		<ai:col fieldname="AUTHOR_ID"  visible="false" editable = "false"/>	 
 		<ai:col fieldname="ROLE_ID"  visible="false" editable = "false"/>
		<ai:col fieldname="ROLE_NAME"  visible="true" width="20%" editable = "false"/>
		<ai:col fieldname="ROLE_TYPE"  visible="true" width="15%" editable = "false"/>
		<ai:col fieldname="REGION_CODE"   visible="false" editable = "false"/>
		<ai:col fieldname="DOMAIN_ID"   visible="false" editable = "false"/>
		<ai:col fieldname="AUTHOR_TYPE"  visible="true" width="15%"/>
		<ai:col fieldname="AUTHOR_VALID_DATE"  visible="true" width="25%"/>
		<ai:col fieldname="AUTHOR_EXPIRE_DATE"  visible="true" width="25%"/>
 	</ai:table>
</ai:contractframe>
<div class="area_button">
  	<ai:button id="modifyAuthorBtn" text="sec.authormanager.author.modify" i18nRes="i18n.secframe_resource" enable="false" onclick="modifyAuthor()"/>
	<ai:button id="unAuthorBtn" text="sec.authormanager.author.cancel" i18nRes="i18n.secframe_resource" enable="false" onclick="unAuthor()"/>
</div>
  </body>
  <script type="text/javascript">
  
    var opstId = ""; 
  	/**
  	 * 初始化
  	 */
  	function initial(operatorId, stId, orgId)
  	{
  		// 查询操作员岗位关系
  		if(operatorId != 0)
  		{
	  		var dbTableOpStation = g_TableRowSetManager.get("DBTableOpStation");
			dbTableOpStation.refresh("refresh", "operId="+operatorId+"&stId="+stId);
			g_AIButtonManager.get("openAuthorWinBtn").setDisabled(false);
		}
		else
		{
			var dbTableOpStation = g_TableRowSetManager.get("DBTableOpStation");
			dbTableOpStation.refresh("refresh", "1<>1");
			g_AIButtonManager.get("openAuthorWinBtn").setDisabled(true);
		}
		refreshAuthoredRoles();
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
			opstId = dbTableOpStation.getValue(selRows[0], "OP_STATION_ID");
			if (opstId == "")
			{
				alert(g_I18NMessage("secframe_author", "sec_station_select"));
				return;
			}
		 	var url = "<%=request.getContextPath()%>/secframe/sysmgr/author/RoleSelect.jsp";
			var retVal = window.showModalDialog(url, opstId, "scroll:no;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:600px");
			if(retVal != "undefined" && retVal == 1)
			{
				// 刷新已授权角色
				refreshAuthoredRoles();
			}
		}
		else
		{
			alert(g_I18NMessage("secframe_author", "sec_station_select"));
			return;
		}
	}
	/**
	 * 回收角色
	 */
	function unAuthor()
	{
		if (opstId == "")
		{
			alert(g_I18NMessage("secframe_author", "sec_station_select"));
			return;
		}
		var dbTableAuthoredRole = g_TableRowSetManager.get("dbTableAuthoredRole");
		var selRows = dbTableAuthoredRole.getSelectedRows();
		if(selRows != null && selRows.length > 0)
		{
			var roleIdStr = "";
			for(var i=0; i < selRows.length; i++)
	   		{
	   			var roleId = dbTableAuthoredRole.getValue(selRows[i], "ROLE_ID");
	   			roleIdStr = roleIdStr + roleId+",";
	   		}
	   		// 回收角色
	   		var param = "opstId="+opstId+"&roleIdStr="+roleIdStr;
		    var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecAuthorAction?action=delAuthor&"+param);
		    var retVal = msg.getValueByName("retVal");
		    if(retVal == 1 || retVal == "1")
		    {
		    	alert(g_I18NMessage("secframe_common", "sec_common_saveok"));
		    	refreshAuthoredRoles();
		    }
		    else
		    {
		    	alert(g_I18NMessage("secframe_common", "sec_common_savefail"));
		    }
		}
		else
		{
			alert(g_I18NMessage("secframe_author", "sec_author_select"));
		}
	}
	/**
	 * 刷新已授权角色列表
	 */
	function refreshAuthoredRoles()
	{
		var curOpstId = -1;
		var dbTableOpStation = g_TableRowSetManager.get("DBTableOpStation");
		var selRows = dbTableOpStation.getSelectedRows();
		if(selRows != null && selRows.length > 0)
		{
			curOpstId = dbTableOpStation.getValue(selRows[0], "OP_STATION_ID");
		}
		var dbTableAuthoredRole = g_TableRowSetManager.get("dbTableAuthoredRole");
		if(curOpstId != -1)
		{
			opstId = curOpstId;
			dbTableAuthoredRole.refresh("refreshAuthoredRoles", "operId="+<%=operId%>+"&opstId="+curOpstId);
			if(dbTableAuthoredRole.getTotalRowCount() > 0)
			{
				g_AIButtonManager.get("modifyAuthorBtn").setDisabled(false);
				g_AIButtonManager.get("unAuthorBtn").setDisabled(false);
			}
			else
			{
				g_AIButtonManager.get("modifyAuthorBtn").setDisabled(true);
				g_AIButtonManager.get("unAuthorBtn").setDisabled(true);
			}
		}
		else
		{
			dbTableAuthoredRole.refresh("refreshAuthoredRoles", "1<>1");
			g_AIButtonManager.get("modifyAuthorBtn").setDisabled(true);
			g_AIButtonManager.get("unAuthorBtn").setDisabled(true);
		}
	}
	/**
	 * 修改授权
	 */
	function modifyAuthor()
	{
		var dbTableAuthoredRole = g_TableRowSetManager.get("dbTableAuthoredRole");
		if(dbTableAuthoredRole.toXmlString(true) != "")
		{
			var list = new Array();
			list.push(dbTableAuthoredRole);
	   		// 修改授权
	   		var param = "opstId="+opstId;
		    var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecAuthorAction?action=updateAuthorities&"+param, list);
		    var retVal = msg.getValueByName("retVal");
		    if(retVal == 1 || retVal == "1")
		    {
		    	alert(g_I18NMessage("secframe_common", "sec_common_saveok"));
		    	refreshAuthoredRoles();
		    }
		    else
		    {
		    	alert(g_I18NMessage("secframe_common", "sec_common_savefail"));
		    }
		}
		else
		{
			alert(g_I18NMessage("secframe_common", "sec_common_nochange"));
		}
	}
  </script>
</html>
