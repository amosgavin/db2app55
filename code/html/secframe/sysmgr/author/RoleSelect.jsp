<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title><i18n:message key="sec.roleselect.title" res="i18n.secframe_resource"/></title>
     <%
    	long operId = SessionManager.getUser().getID();
     %>
  </head>
  <body onload="initRole()">
    <ai:dbform formid="secRoleSearchForm"
               setname="com.ai.secframe.sysmgr.web.SETSecRole"
               initial="false" editable="true">
      <ai:contractframe id="roleSearchCondition" contenttype="table" title="sec.role.querycondition" i18nRes="i18n.secframe_resource" 
                        width="100%" allowcontract="false" frameclosed="false">
        <ai:contractitem/>		
          <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr>
              <td class="td_font"><i18n:message key="sec.role.name" res="i18n.secframe_resource"/></td>
              <td><ai:dbformfield formid="secRoleSearchForm" fieldname="ROLE_NAME"
    	            width="150" height="20" editable="true" visible="true" />
              <td class="td_font"><i18n:message key="sec.role.type" res="i18n.secframe_resource"/></td>
              <td><ai:dbformfield formid="secRoleSearchForm" fieldname="ROLE_TYPE"
    	            width="95" height="20" editable="true" visible="true" /></td>
              <td class="td_font"><i18n:message key="sec.role.district" res="i18n.secframe_resource"/></td>
              <td><ai:dbformfield formid="secRoleSearchForm" fieldname="REGION_CODE"
    	            width="95" height="20" editable="true" visible="true" /></td>
              <td><ai:button  text="sec.role.query" i18nRes="i18n.secframe_resource" id="addBtn" onclick="search()"/></td>				
            </tr>
          </table>
      </ai:contractframe>
    </ai:dbform>

    <ai:contractframe id="ctframe1" contenttype="table" title="sec.roleselect.list" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
    	<ai:contractitem/>
    	<ai:table tableid="dbTableRole"
    		setname="com.ai.secframe.sysmgr.web.SETSecAuthorableRole"
    		initial="false" multiselect="true" editable="true" pagesize="13" height="280" width="100%"
    		tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
    		parametersname="com.ai.secframe.sysmgr.web.SecAuthorAction"
    		needrefresh="true" footdisplay="true" onafterturnpage="mark">
    		
     		<ai:col fieldname="ROLE_ID"  visible="false" editable = "false"/>
    		<ai:col fieldname="ROLE_NAME"  visible="true" editable = "false" width="30%"/>
    		<ai:col fieldname="ROLE_TYPE"  visible="true" editable = "false" width="13%"/>
    		<ai:col fieldname="REGION_CODE"   visible="true" editable = "false" width="13%"/>
    		<ai:col fieldname="DOMAIN_ID"   visible="true" editable = "false" width="10%"/>
    		<ai:col fieldname="AUTHOR_TYPE"  visible="true" width="13%"/>
    		<ai:col fieldname="AUTHOR_VALID_DATE"  visible="true" width="8%" visible="false"/>
    		<ai:col fieldname="AUTHOR_EXPIRE_DATE"  visible="true" width="8%" visible="false"/>
    		<ai:col fieldname="AUTHOR_ID"  visible="false"/>
    		<ai:col fieldname="STATE"  visible="false"/>
    		<ai:col fieldname="NOTES"  visible="false"/>
    	</ai:table>
    </ai:contractframe>
    <div class="area_button">
    	<ai:button text="sec.confirm" i18nRes="i18n.secframe_resource" onclick="author()"/>
        <ai:button text="sec.cancel" i18nRes="i18n.secframe_resource" onclick="cancel()"/>
    </div>
  </body>
  <script type="text/javascript">
    
  	function getDBTableRole()
	{
		return g_TableRowSetManager.get("dbTableRole");
	}
	
	/**
	 * 标记勾选
	 */
	function mark()
	{
		var dbTableRole = getDBTableRole();
		var count = dbTableRole.count();
		for(var i=0; i < count; i++)
		{
			var notes = dbTableRole.getValue(i, "NOTES");
			if(notes != null && notes == "1")
			{
				dbTableRole.rowSelected(i, true, false);
			}
		}
	}
	
	/**
	 * 初始化角色列表
	 */
	function initRole()
	{
		var dbTableRole = getDBTableRole();
		// 获取操作员ID
    	var curOpstId = window.dialogArguments;
		
		dbTableRole.refresh("refreshAuthorableRole","operId="+<%=operId%>+"&opstId="+curOpstId);
		
		mark();
	}
	
	/**
	 * 按条件查询授权角色列表
	 */
	function search()
	{
	   var secRoleSearchForm = g_FormRowSetManager.get("secRoleSearchForm");
	   var roleName = secRoleSearchForm.getValue("ROLE_NAME");
	   var roleType = secRoleSearchForm.getValue("ROLE_TYPE");
	   var regionCode = secRoleSearchForm.getValue("REGION_CODE");
	   
	   // 上岗ID,多个ID以逗号隔开
	   var curOpStationIds = window.dialogArguments;
	   
	   var dbTableRole = getDBTableRole();
	   dbTableRole.refresh("refreshAuthorableRole","operId="+<%=operId%>+"&opstId="+curOpStationIds
			   +"&roleName="+roleName+"&roleType="+roleType+"&regionCode="+regionCode);
	   
	   // 标记为选上
	   mark();
	}
	
	/**
	 * 授权
	 */
	function author()
	{
		var dbTableRole = getDBTableRole();
		var selRows = dbTableRole.getSelectedRows();
	    if(selRows != null && selRows.length > 0)
	    {
	    	for(var i=0; i < selRows.length; i++)
	    	{
	    		dbTableRole.setValue(selRows[i], "NOTES", "-1");
	    		dbTableRole.setValue(selRows[i], "AUTHOR_VALID_DATE", "2012-4-18 19:53:14");
	    		dbTableRole.setValue(selRows[i], "AUTHOR_EXPIRE_DATE", "2051-4-30 15:47:21");
}
	    	// 获取操作员上岗ID
	    	var curOpstId = window.dialogArguments;
	    	var param = "opstId="+curOpstId;
	    	var list = new Array();
	    	list.push(dbTableRole);
		    var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecAuthorAction?action=saveAuthor&"+param, list);
		    var retVal = msg.getValueByName("retVal");
		    if(retVal == 1 || retVal == "1")
		    {
		    	alert(g_I18NMessage("secframe_common", "sec_common_saveok"));
		    	window.returnValue = 1;
		    	window.self.close();
		    }
		    else
		    {
		    	var retMsg = msg.getValueByName("retMsg");
		    	alert(g_I18NMessage("secframe_common", "sec_common_savefail")+", "+retMsg);
		    }
	    }
	    else
	    {
	    	alert(g_I18NMessage("secframe_author", "sec_author_role_notselect"));
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
