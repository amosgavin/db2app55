<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
      <title><i18n:message key="sec.roleselect.title" res="i18n.secframe_resource"/></title>
  </head>
  <body>
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

    <ai:contractframe id="ctframe1" contenttype="table" title="sec.selectrole.list" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>
            <ai:table tableid="dbTableRole"
							setname="com.ai.secframe.sysmgr.web.SETSecRole"
							initial="false" multiselect="false" editable="false"
							tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
							implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecRoleSV"
							implservice_querymethod="querySecRole"  pagesize="13"
							implservice_countmethod="querySecRoleCount" width="100%"	
							height="280" needrefresh="true">
			  <ai:col fieldname="ROLE_ID" width="25%" editable="false"
								visible="true" />				
              <ai:col fieldname="ROLE_NAME" width="25%" editable="false"
								visible="true" />
			  <ai:col fieldname="ROLE_TYPE" width="25%" editable="false"
								visible="true" />
			  <ai:col fieldname="REGION_CODE" width="25%" editable="false"
								visible="true" />					
            </ai:table>
    </ai:contractframe> 
            
    <div class="area_button">
    	<ai:button text="sec.copyPrivilege" i18nRes="i18n.secframe_resource" onclick="copyRoleAllRight()"/>
        <ai:button text="sec.cancel" i18nRes="i18n.secframe_resource" onclick="cancel()"/>
    </div>
  </body>
  <script type="text/javascript">
    
  	function getDBTableRole()
	{
		return g_TableRowSetManager.get("dbTableRole");
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
	   var dbTableRole = getDBTableRole();
	   
	   var roleNameCond = "";
	   var roleTypeCond = "";
	   var regionCodeCond="";
	   var flag = false;
	   if(roleName!=null&&roleName!="")
	   {
		    roleNameCond = " ROLE_NAME LIKE '"+roleName+"%' ";
	   }
	   if(roleType!=null&&roleType!="")
	   {
		    roleTypeCond = " ROLE_TYPE LIKE '"+roleType+"%' ";
	   }
	   if(regionCode!=null&&regionCode!="")
	   {
		    regionCodeCond = " REGION_CODE LIKE '"+regionCode+"%' ";
	   }
	   //平凑查询条件
	   var cond = "";
	   if(roleNameCond!="")
	   {
		   cond = cond + roleNameCond;
		   flag=true;
	   }
			
	   if(roleTypeCond!="")
	   {
		   if(flag)
		   {
			  cond = cond +" AND "+ roleTypeCond;
		   }
		   else 
		   {
			  cond = cond +  roleTypeCond;
			  flag = true;
		   }
	   }
	   
	   if(regionCodeCond!="")
	   {
		    if(flag)
		    {
				cond = cond +" AND "+ regionCodeCond;
			}
			else 
			{
				cond = cond +  regionCodeCond;
			}
		}
			
		dbTableRole.refresh(cond);
	}
	
	/**
	 * 拷贝所选角色的所有权限
	 */
	function copyRoleAllRight()
	{
		var destRoleIdAndEntType = window.dialogArguments;
		
		var dbTableRole = getDBTableRole();
		var selRows = dbTableRole.getSelectedRows();
	    if(selRows != null && selRows.length > 0)
	    {
	    	var srcRoleId = dbTableRole.getValue(selRows[0], "ROLE_ID");
	    	
	    	var param = "srcRoleId="+srcRoleId+"&destRoleId="+destRoleIdAndEntType;
		    var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecRoleAction?action=copyRoleAllRight&"+param);
		    var retVal = msg.getValueByName("retVal");
		    if(retVal == 1 || retVal == "1")
		    {
		    	alert(g_I18NMessage("secframe_roleselect", "copy_privilege_success"));
		    	window.returnValue = 1;
		    	window.self.close();
		    }
		    else
		    {
		    	var retMsg = msg.getValueByName("retMsg");
		    	alert(g_I18NMessage("secframe_roleselect", "copy_privilege_failure")+" "+retMsg);
		    }
	    }
	    else
	    {
	    	alert(g_I18NMessage("sec_roleselect", "sec_roleselect_select"));
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
