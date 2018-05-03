<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<HTML>
<HEAD>
<TITLE></TITLE>
</HEAD>
<body>
         <ai:dbform formid="secRoleSearchForm"
					setname="com.ai.secframe.sysmgr.web.SETSecRole"
					datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecRoleSV"
					implservice_querymethod="querySecRole" 
					initial="false" editable="true">
            <ai:contractframe id="" contenttype="table" title="sec.role.querycondition" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>		
            <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
              <tr>
                <td class="td_font"><i18n:message key="sec.role.name" res="i18n.secframe_resource"/></td>
                <td><ai:dbformfield formid="secRoleSearchForm" fieldname="ROLE_NAME"
								width="150" height="20" editable="true" visible="true" />
                <td class="td_font"><i18n:message key="sec.role.type" res="i18n.secframe_resource"/></td>
                <td><ai:dbformfield formid="secRoleSearchForm" fieldname="ROLE_TYPE"
								width="150" height="20" editable="true" visible="true" /></td>
                <td class="td_font"><i18n:message key="sec.role.district" res="i18n.secframe_resource"/></td>
                <td><ai:dbformfield formid="secRoleSearchForm" fieldname="REGION_CODE"
								width="150" height="20" editable="true" visible="true" /></td>
				<td><ai:button  text="sec.role.query" i18nRes="i18n.secframe_resource" id="addBtn" onclick="search()"/></td>				
              </tr>
            </table>
            </ai:contractframe>
           </ai:dbform>
       
       <ai:contractframe id="" contenttype="table" title="sec.role.queryresult" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
           <ai:contractitem/>
           <ai:table tableid="secRoleSearchResultTable"
							setname="com.ai.secframe.sysmgr.web.SETSecRole"
							initial="false" multiselect="false" editable="false"
							tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
							implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecRoleSV"
							implservice_querymethod="querySecRole"  pagesize="15"
							implservice_countmethod="querySecRoleCount" width="100%" onrowchange="selectRole" ondbclick="selectFunc"
							height="320" needrefresh="true">
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
            <ai:button text="sec.rolefunction.change" i18nRes="i18n.secframe_resource" id="saveBtn" onclick="saveRoleFunc()"/>
            <ai:button text="sec.copyFuncPrivilege" i18nRes="i18n.secframe_resource" id="copyBtn" onclick="showCopyRoleRightDialog()"/>  
            </div>   
<script type="text/javascript">
var selRole ="";
function search()
{
   var secRoleSearchForm = g_FormRowSetManager.get("secRoleSearchForm");
   var secRoleSearchResultTable = g_TableRowSetManager.get("secRoleSearchResultTable");	
   var roleName = secRoleSearchForm.getValue("ROLE_NAME");
   var roleType = secRoleSearchForm.getValue("ROLE_TYPE");
   var regionCode = secRoleSearchForm.getValue("REGION_CODE");
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
		
	if(cond=="")
	{
		//alert("请输入条件");
		//alert(g_I18NMessage("secframe_role" , "sec_role_condition"));
		secRoleSearchResultTable.refresh(cond);
		return ;
	}
	condition = cond;
    secRoleSearchResultTable.refresh(cond);
}	

function selectRole()
{
    var secRoleSearchResultTable = g_TableRowSetManager.get("secRoleSearchResultTable");
    selRole =secRoleSearchResultTable.getValue(secRoleSearchResultTable.getRow(),"ROLE_ID");
}

function selectFunc()
{  
    var secRoleSearchResultTable = g_TableRowSetManager.get("secRoleSearchResultTable");
    selRole =secRoleSearchResultTable.getValue(secRoleSearchResultTable.getRow(),"ROLE_ID");
    var result = window.showModalDialog("<%=request.getContextPath()%>/secframe/sysmgr/secfunction/SelectRoleFunctionDialog.jsp",selRole,"scroll:no;resizable:no;status:no;dialogHeight:500px;dialogWidth:300px");
}

function saveRoleFunc()
{   
    if (null == selRole || "" == selRole)
    { 
        //alert("请在列表中选择一条角色！");
        alert(g_I18NMessage("sec_roleselect" , "sec_roleselect_select"));
        return;
    }
    var result = window.showModalDialog("<%=request.getContextPath()%>/secframe/sysmgr/secfunction/SelectRoleFunctionDialog.jsp",selRole,"scroll:no;resizable:no;status:no;dialogHeight:500px;dialogWidth:300px");
}

/**
 * 显示复制权限对话框
 */
function showCopyRoleRightDialog()
{
	var secRoleSearchResultTable = g_TableRowSetManager.get("secRoleSearchResultTable");
	var selRows = secRoleSearchResultTable.getSelectedRows();
	if(selRows != null && selRows.length > 0)
	{
		var roleId = secRoleSearchResultTable.getValue(selRows[0], "ROLE_ID");
		if (roleId == "")
		{
			alert(g_I18NMessage("sec_roleselect", "sec_roleselect_select"));
			return;
		}
		var param = roleId + "&entType=F";
	 	var url = "<%=request.getContextPath()%>/secframe/sysmgr/role/RoleSelect.jsp";
		window.showModalDialog(url, param, "scroll:no;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:600px");
	}
	else
	{
		alert(g_I18NMessage("sec_roleselect", "sec_roleselect_select"));
		return;
	}
}
</script>
</body>
</HTML>