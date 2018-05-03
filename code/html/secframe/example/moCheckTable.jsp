<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="sec.role.manager" res="i18n.secframe_resource"/></title>
</head>
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
				<td><ai:button text="sec.role.query" i18nRes="i18n.secframe_resource" id="searchBtn" onclick="search()"/></td>				
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
							implservice_querymethod="querySecRole"  pagesize="10"
							implservice_countmethod="querySecRoleCount" width="100%"	
							height="220" needrefresh="true"
							mo="com.ai.secframe.renlltest.moCheckTable" operator="moCheckTable" modealtype="mask">
				  <ai:col fieldname="ROLE_ID" width="25%"/>				
	              <ai:col fieldname="ROLE_NAME" width="25%"/>
				  <ai:col fieldname="ROLE_TYPE" width="25%"/>
				  <ai:col fieldname="REGION_CODE" width="25%"/>					
            </ai:table>
            </ai:contractframe>
            <p><font color="red">
             &nbsp;&nbsp;&nbsp;&nbsp; 我们在MO中控制了table的四个字段，使用之后，如果操作员有该MO权限，那么这四个字段都可以显示出来。
            <br>&nbsp;&nbsp;&nbsp;&nbsp; 如果操作员不具有该MO属性，则页面会提示“对不起，XXX不具有执行操作权限”。
            </font></p>
            <p><font color="blue">
            &nbsp;&nbsp;&nbsp;&nbsp; 在MO授权时，我们为一个角色赋予了对ROLE_ID和ROLE_NAME可读、可修改的权限，为另一个角色赋予全部字段可读、可修改的权限。
            <br>&nbsp;&nbsp;&nbsp;&nbsp;当使用具有前者角色的用户登录时，只可看到ROLE_ID和ROLE_NAME字段；使用具有后者角色的用户登录时，可看到全部字段。
			<br>&nbsp;&nbsp;&nbsp;&nbsp; 可使用renll2与renll3登录系统进行查看对比。
			</font></p>
</body>
<script type="text/javascript">
    var condition = "";
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
	    //alert("请输入查询条件");
		//alert(g_I18NMessage("secframe_role" , "sec_role_condition"));
		secRoleSearchResultTable.refresh(cond);
		return ;
	}
	condition = cond;
    secRoleSearchResultTable.refresh(cond);
}	

</script>
</html>