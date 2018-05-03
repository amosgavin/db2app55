<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title></title>
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
							implservice_querymethod="querySecRole"  pagesize="5"
							implservice_countmethod="querySecRoleCount" width="100%" onrowchange="loadRoleMessage"	
							height="120" needrefresh="true">
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
                 
         
          <table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
	         <tr>
	           <td width="49%" valign="top">
                <ai:contractframe id="" contenttype="table" title="sec.roleexclude.msgdetail" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
                 <ai:contractitem/>
                <ai:table
					setname="com.ai.secframe.sysmgr.web.SETSecRoleExclude"
					tableid="roleExcludeTable"
					tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecRoleSV"
					implservice_querymethod="getSecRoleExclude" pagesize="5"
					implservice_countmethod="getSecRoleExcludeCount" height="120" width="100%" multiselect="true" initial="false"
					needrefresh="true">
					<ai:col fieldname="ROLE_ID" visible="false" />
					<ai:col fieldname="RELAT_ROLE_NAME"  width="100%" editable="false" />
					<ai:col fieldname="RELAT_ROLE_ID"  visible="false" />
					<ai:col fieldname="FLAG" visible="false" />
				</ai:table>
            </ai:contractframe>

                </td>
                <td align=center width="40"><img id="add" border="0" src="<%=request.getContextPath()%>/webframe/images/icon/left.gif"  alt="" onClick="add()" align="absmiddle" style="cursor:hand;"/>
                  <br>
                  <br>
                  <img id="remove" border="0" src="<%=request.getContextPath()%>/webframe/images/icon/right.gif"  alt="" onClick="remove()" align="absmiddle" style="cursor:hand;"/>
                </td>
				<td width="49%" valign="top" align="right">
				<ai:contractframe id="" contenttype="table" title="sec.roleexclude.msgdetail" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
                 <ai:contractitem/>
                <ai:table
					setname="com.ai.secframe.sysmgr.web.SETSecRoleNotExclude"
					tableid="roleNotExcludeTable"
					tablemodel="com.ai.appframe2.web.tag.ActionDataModel"
					parametersname="com.ai.secframe.sysmgr.web.SecRoleAction"
					height="120" width="100%" initial="false" multiselect="true"
					pagesize="5"
					needrefresh="true">
					<ai:col fieldname="ROLE_ID" visible="false" />
					<ai:col fieldname="FLAG" visible="false" />
					<ai:col fieldname="ROLE_NAME"  width="100%" editable="false" />
				</ai:table>
            </ai:contractframe>

				</td>
              </tr>
            </table>
                  <div class="area_button">
                    <ai:button text="sec.roleexclude.save" i18nRes="i18n.secframe_resource" id="updateBtn" onclick="save()"/>
                  </div>
       
<script type="text/javascript">
//初始化按钮
var roleId = "";
var condition = "";
var roleExcludeTable = g_TableRowSetManager.get("roleExcludeTable");
var roleNotExcludeTable = g_TableRowSetManager.get("roleNotExcludeTable");
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
    secRoleSearchResultTable.refresh(cond);
}	

function loadRoleMessage()
{
    var secRoleSearchResultTable = g_TableRowSetManager.get("secRoleSearchResultTable");	
    var roleExcludeTable = g_TableRowSetManager.get("roleExcludeTable");
    var roleNotExcludeTable = g_TableRowSetManager.get("roleNotExcludeTable");
    var selRoleId = secRoleSearchResultTable.getValue(secRoleSearchResultTable.getRow(),"ROLE_ID");
    if (null == selRoleId || selRoleId =="")
    {
       //alert("请在列表中选择一条角色！");
       alert(g_I18NMessage("secframe_role" , "sec_role_sel_one_role"));
       return;
    }
    var cond = "ROLE_ID = " + selRoleId;
    roleExcludeTable.refresh(cond); 
    roleId = selRoleId;
    condition = cond;
    roleNotExcludeTable.refresh("refresh","roleId="+selRoleId);  
}

function add()
{
    if("" == roleId)
    {
       //alert("请选择！");
       alert(g_I18NMessage("secframe_role_exclude" , "sec_role_exclude_select"));
    }
    if( roleNotExcludeTable.getSelectedRows()!=null&&roleNotExcludeTable.getSelectedRows().length>0)
    {
	 		var selRows = roleNotExcludeTable.getSelectedRows();
	  		for(var i=0;i<selRows.length;i++)
	  		{
		  		roleExcludeTable.newRow(false);
		  		roleExcludeTable.setValue(roleExcludeTable.getRow(),"ROLE_ID",roleId,roleId);
		  		roleExcludeTable.setValue(roleExcludeTable.getRow(),"FLAG",roleNotExcludeTable.getValue(selRows[i],"FLAG"),roleNotExcludeTable.getValue(selRows[i],"FLAG"));
				roleExcludeTable.setValue(roleExcludeTable.getRow(),"RELAT_ROLE_ID",roleNotExcludeTable.getValue(selRows[i],"ROLE_ID"),roleNotExcludeTable.getValue(selRows[i],"ROLE_ID"));
				roleExcludeTable.setValue(roleExcludeTable.getRow(),"RELAT_ROLE_NAME",roleNotExcludeTable.getValue(selRows[i],"ROLE_NAME"),roleNotExcludeTable.getValue(selRows[i],"ROLE_NAME"));
	  		}
	  		for(var i=0;i < roleNotExcludeTable.count();i++)
	  		{
			    if(roleNotExcludeTable.isSelected(i))
			    {
				    roleNotExcludeTable.deleteRow(i);
				    i--;
				}
         	}
	  		
	 }
	 else
	 {
	  //alert("请选择要添加的互斥角色！");
	  alert(g_I18NMessage("secframe_role_exclude" , "sec_role_exclude_selexclude"));
	 }
   
}

function remove()
{

    if( roleExcludeTable.getSelectedRows()!=null&&roleExcludeTable.getSelectedRows().length>0)
    {
	 		var selRows = roleExcludeTable.getSelectedRows();
	  		for(var i=0;i<selRows.length;i++)
	  		{
		  		roleNotExcludeTable.newRow(false);
			    roleNotExcludeTable.setValue(roleNotExcludeTable.getRow(),"FLAG",roleExcludeTable.getValue(selRows[i],"FLAG"),roleExcludeTable.getValue(selRows[i],"FLAG"));
	            roleNotExcludeTable.setValue(roleNotExcludeTable.getRow(),"ROLE_ID",roleExcludeTable.getValue(selRows[i],"RELAT_ROLE_ID"),roleExcludeTable.getValue(selRows[i],"RELAT_ROLE_ID"));	            
				roleNotExcludeTable.setValue(roleNotExcludeTable.getRow(),"ROLE_NAME",roleExcludeTable.getValue(selRows[i],"RELAT_ROLE_NAME"),roleExcludeTable.getValue(selRows[i],"RELAT_ROLE_NAME"));
	  		}
	  		for(var i=0;i < roleExcludeTable.count();i++)
	  		{
			    if(roleExcludeTable.isSelected(i))
			    {
				    roleExcludeTable.deleteRow(i);
				    i--;
				}
         	}
	  		
	 }
	 else
	 {
	  //alert("请选择要删除的互斥角色记录！");
	  alert(g_I18NMessage("secframe_role_exclude" , "sec_role_exclude_delexclude"));
	 }
    
}

function save()
{
    var addCount = roleExcludeTable.count();
    var addRoleIds="";
    for (var i = 0 ;i<addCount;i++)
    {
       roleExcludeTable.setRow(i);
       var flag = roleExcludeTable.getValue(roleExcludeTable.getRow(),"FLAG");
       var relatRoleId = roleExcludeTable.getValue(roleExcludeTable.getRow(),"RELAT_ROLE_ID");
       if (null != flag && flag == 0)
       {
           addRoleIds = addRoleIds + ","+relatRoleId;
       }
    }
    addRoleIds = addRoleIds.substring(1);
    
    var delCount = roleNotExcludeTable.count();
    var delRoleIds="";
    for (var i = 0 ;i<delCount;i++)
    {
       roleNotExcludeTable.setRow(i);
       var flag = roleNotExcludeTable.getValue(roleNotExcludeTable.getRow(),"FLAG");
       var delRoleId = roleNotExcludeTable.getValue(roleNotExcludeTable.getRow(),"ROLE_ID");
       if (null != flag && flag == 1)
       {
           delRoleIds = delRoleIds + ","+delRoleId;
       }
    }
    delRoleIds = delRoleIds.substring(1);
    var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecRoleAction?"+
				"action=saveAddDelRoleExclude&addRoleIds="+addRoleIds+"&delRoleIds="+delRoleIds+"&roleId="+roleId);
	var retVal = msg.getValueByName("retVal");
	if( retVal == "0" )
	{
	   //alert("互斥角色信息保存成功!");
	   alert(g_I18NMessage("secframe_role_exclude" , "sec_role_exclude_save_ok"));
	   g_TableRowSetManager.get("roleExcludeTable").refresh(condition); 
	   g_TableRowSetManager.get("roleNotExcludeTable").refresh("refresh","roleId="+roleId);  
	}
    else
	{
	   alert(msg.getValueByName("retMsg"));
	}
}
</script>
</body>
</html>