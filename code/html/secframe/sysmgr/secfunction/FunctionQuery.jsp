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
			 initial = "false" multiselect = "false" onrowchange="refreshFunction"
			 needrefresh="true" editable="false" >
 		<ai:col fieldname="OP_STATION_ID"  visible="false"/>
		<ai:col fieldname="CODE" width="15%"/>
		<ai:col fieldname="STAFF_NAME"  width="15%"/>
		<ai:col fieldname="STATION_ID"  visible="false"/>
		<ai:col fieldname="STATION_NAME"  width="30%"/>
		<ai:col fieldname="IS_BASE_STATION" width="15%"/>
		<ai:col fieldname="ORGANIZE_NAME" visible="false"/>
		<ai:col fieldname="ORG_CODE" width="25%"/>
		<ai:col fieldname="CREATE_DATE" visible="false"/>
		<ai:col fieldname="STATE" visible="false"/>
 	</ai:table>
</ai:contractframe>
<ai:contractframe id="contractframe2" contenttype="table" title="function.query.function.list" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	<ai:table setname="com.ai.secframe.sysmgr.web.SETSecFunction" tableid="dbTableFunction"
			 tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
			 parametersname="com.ai.secframe.sysmgr.web.SecFunctionAction" pagesize="4" width="100%" height="100"
			 initial = "false" multiselect = "false" needrefresh="true" editable="false">
		<ai:col fieldname="FUNC_ID" visible="false"/>	 
		<ai:col fieldname="FUNC_CODE" width="20%"/>	 
 		<ai:col fieldname="NAME" width="20%"/>
 		<ai:col fieldname="FUNC_TYPE" width="10%"/> 		
 		<ai:col fieldname="STATE" width="10%"/>		
 		<ai:col fieldname="VIEWNAME" width="40%"/> 		
 	</ai:table>
</ai:contractframe>
<div class="area_button">
  	<ai:button id="modifyAuthorBtn" text="sec.export.excel" i18nRes="i18n.secframe_resource" onclick="toExcel()"/>
</div>
 </body>
  <script type="text/javascript">
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

			var dbTableFunction = g_TableRowSetManager.get("dbTableFunction");
			dbTableFunction.refresh("refresh", "operId="+operatorId);
		}
		else
		{
			var dbTableOpStation = g_TableRowSetManager.get("DBTableOpStation");
			dbTableOpStation.refresh("refresh", "1<>1");
			var dbTableFunction = g_TableRowSetManager.get("dbTableFunction");
			dbTableFunction.refresh("refresh", "1<>1");
		}
  	}
	
	/**
	 * 刷新菜单列表
	 */
	function refreshFunction()
	{
		var curOpstId = -1;
		var dbTableOpStation = g_TableRowSetManager.get("DBTableOpStation");
		var selRows = dbTableOpStation.getSelectedRows();
		if(selRows != null && selRows.length > 0)
		{
			curOpstId = dbTableOpStation.getValue(selRows[0], "OP_STATION_ID");
		}
		var dbTableFunction = g_TableRowSetManager.get("dbTableFunction");
		if(curOpstId != -1)
		{
			dbTableFunction.refresh("refresh", "opStationId="+curOpstId);
		}
		else
		{
			dbTableFunction.refresh("refresh", "1<>1");
		}
	}

	function toExcel() {
		if(g_TableRowSetManager.get("dbTableFunction").getTotalRowCount() == 0) return;
        window.open(g_TableRowSetManager.get("dbTableFunction").toExcelUrl(g_I18NMessage("secframe_author", "function_list")));
    }
  </script>
</html>
