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
								width="150" editable="true" visible="true" />
                <td class="td_font"><i18n:message key="sec.role.type" res="i18n.secframe_resource"/></td>
                <td><ai:dbformfield formid="secRoleSearchForm" fieldname="ROLE_TYPE"
								width="150" editable="true" visible="true" /></td>
                <td class="td_font"><i18n:message key="sec.role.district" res="i18n.secframe_resource"/></td>
                <td><ai:dbformfield formid="secRoleSearchForm" fieldname="REGION_CODE"
								width="150" editable="true" visible="true" /></td>
				<td><ai:button text="sec.role.query" i18nRes="i18n.secframe_resource" id="addBtn" onclick="search()"/></td>				
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
           <ai:contractframe id="" contenttype="table" title="sec.roleextend.msgdetail" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
                 <ai:contractitem/>
                <ai:table
					setname="com.ai.secframe.sysmgr.web.SETSecRoleExtend"
					tableid="roleExtendTable"
					tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecRoleSV"
					implservice_querymethod="getSecRoleExtend"  pagesize="5"
					implservice_countmethod="getSecRoleExtendCount" height="120" width="100%" multiselect="true" initial="false"
					needrefresh="true">
					<ai:col fieldname="ROLE_ID" visible="false" />
					<ai:col fieldname="RELAT_ROLE_NAME"  width="100%" editable="false" />
					<ai:col fieldname="RELAT_ROLE_ID"  visible="false" />
					<ai:col fieldname="FLAG" visible="false" />
				</ai:table>
            </ai:contractframe>

                </td>
                <td align=center width="40">
                <img id="add" border="0" src="<%=request.getContextPath()%>/webframe/images/icon/left.gif"  alt="" onClick="add()" align="absmiddle" style="cursor:hand;"/>
                  <br>
                  <br>
                  <img id="remove" border="0" src="<%=request.getContextPath()%>/webframe/images/icon/right.gif"  alt="" onClick="remove()" align="absmiddle" style="cursor:hand;"/>
                </td>
				<td width="49%" valign="top" align="right">
				<ai:contractframe id="" contenttype="table" title="sec.roleextend.msgdetail" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
                 <ai:contractitem/>
                <ai:table
					setname="com.ai.secframe.sysmgr.web.SETSecRoleNotExtend"
					tableid="roleNotExtendTable"
					tablemodel="com.ai.appframe2.web.tag.ActionDataModel"
					parametersname="com.ai.secframe.sysmgr.web.SecRoleAction"
					height="120" width="100%" initial="false" multiselect="true"
					pagesize="5"
					needrefresh="true" >
					<ai:col fieldname="ROLE_ID" visible="false" />
					<ai:col fieldname="ROLE_NAME"  width="100%" editable="false" />
					<ai:col fieldname="FLAG" visible="false" />
				</ai:table>
            </ai:contractframe>

				</td>
              </tr>
            </table>
               <div class="area_button">
                    <ai:button text="sec.roleextend.save" i18nRes="i18n.secframe_resource" id="updateBtn" onclick="save()"/>
               </div>
                  
<script type="text/javascript">
//初始化按钮
var roleId = "";
var condition = "";
var roleExtendTable = g_TableRowSetManager.get("roleExtendTable");
var roleNotExtendTable = g_TableRowSetManager.get("roleNotExtendTable");
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
    var roleExtendTable = g_TableRowSetManager.get("roleExtendTable");
    var roleNotExtendTable = g_TableRowSetManager.get("roleNotExtendTable");
    var selRoleId = secRoleSearchResultTable.getValue(secRoleSearchResultTable.getRow(),"ROLE_ID");
    if (null == selRoleId || selRoleId =="")
    {
       //alert("请在列表中选择一条角色！");
       alert(g_I18NMessage("secframe_role" , "sec_role_sel_one_role"));
       return;
    }
    var cond = "ROLE_ID = " + selRoleId;
    roleExtendTable.refresh(cond); 
    roleId = selRoleId;
    condition = cond;
    roleNotExtendTable.refresh("refreshRoleExtend","roleId="+selRoleId);  
}

function add()
{
    if("" == roleId)
    {
       //alert("请选择！");
       alert(g_I18NMessage("secframe_role_extend" , "sec_role_extend_select"));
    }
    if( roleNotExtendTable.getSelectedRows()!=null&&roleNotExtendTable.getSelectedRows().length>0)
    {
	 		var selRows = roleNotExtendTable.getSelectedRows();
	  		for(var i=0;i<selRows.length;i++)
	  		{
		  		roleExtendTable.newRow(false);
		  		roleExtendTable.setValue(roleExtendTable.getRow(),"ROLE_ID",roleId,roleId);
		  		roleExtendTable.setValue(roleExtendTable.getRow(),"FLAG",roleNotExtendTable.getValue(selRows[i],"FLAG"),roleNotExtendTable.getValue(selRows[i],"FLAG"));
				roleExtendTable.setValue(roleExtendTable.getRow(),"RELAT_ROLE_ID",roleNotExtendTable.getValue(selRows[i],"ROLE_ID"),roleNotExtendTable.getValue(selRows[i],"ROLE_ID"));
				roleExtendTable.setValue(roleExtendTable.getRow(),"RELAT_ROLE_NAME",roleNotExtendTable.getValue(selRows[i],"ROLE_NAME"),roleNotExtendTable.getValue(selRows[i],"ROLE_NAME"));
	  		}
	  		for(var i=0;i < roleNotExtendTable.count();i++)
	  		{
			    if(roleNotExtendTable.isSelected(i))
			    {
				    roleNotExtendTable.deleteRow(i);
				    i--;
				}
         	}
	  		
	 }
	 else
	 {
	  //alert("请选择要添加的互斥角色！");
	  alert(g_I18NMessage("secframe_role_extend" , "sec_role_extend_selexclude"));
	 }
   
}

function remove()
{

    if( roleExtendTable.getSelectedRows()!=null&&roleExtendTable.getSelectedRows().length>0)
    {
	 		var selRows = roleExtendTable.getSelectedRows();
	  		for(var i=0;i<selRows.length;i++)
	  		{
		  		roleNotExtendTable.newRow(false);
	        	roleNotExtendTable.setValue(roleNotExtendTable.getRow(),"FLAG",roleExtendTable.getValue(selRows[i],"FLAG"),roleExtendTable.getValue(selRows[i],"FLAG"));
	            roleNotExtendTable.setValue(roleNotExtendTable.getRow(),"ROLE_ID",roleExtendTable.getValue(selRows[i],"RELAT_ROLE_ID"),roleExtendTable.getValue(selRows[i],"RELAT_ROLE_ID"));            
				roleNotExtendTable.setValue(roleNotExtendTable.getRow(),"ROLE_NAME",roleExtendTable.getValue(selRows[i],"RELAT_ROLE_NAME"),roleExtendTable.getValue(selRows[i],"RELAT_ROLE_NAME"));
	  		}
	  		for(var i=0;i < roleExtendTable.count();i++)
	  		{
			    if(roleExtendTable.isSelected(i))
			    {
				    roleExtendTable.deleteRow(i);
				    i--;
				}
         	}
	  		
	 }
	 else
	 {
	  //alert("请选择要删除的继承角色记录！");
	  alert(g_I18NMessage("secframe_role_extend" , "sec_role_extend_delexclude"));
	 }
}

function save()
{
    var addCount = roleExtendTable.count();
    var addRoleIds="";
    for (var i = 0 ;i<addCount;i++)
    {
       roleExtendTable.setRow(i);
       var flag = roleExtendTable.getValue(roleExtendTable.getRow(),"FLAG");
       var relatRoleId = roleExtendTable.getValue(roleExtendTable.getRow(),"RELAT_ROLE_ID");
       if (null != flag && flag == 0)
       {
           addRoleIds = addRoleIds + ","+relatRoleId;
       }
    }
    addRoleIds = addRoleIds.substring(1);
    var delCount = roleNotExtendTable.count();
    var delRoleIds="";
    for (var i = 0 ;i<delCount;i++)
    {
       roleNotExtendTable.setRow(i);
       var flag = roleNotExtendTable.getValue(roleNotExtendTable.getRow(),"FLAG");
       var delRoleId = roleNotExtendTable.getValue(roleNotExtendTable.getRow(),"ROLE_ID");
       if (null != flag && flag == 1)
       {
           delRoleIds = delRoleIds + ","+delRoleId;
       }
    }
    delRoleIds = delRoleIds.substring(1);
    var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecRoleAction?"+
				"action=saveAddDelRoleExtend&addRoleIds="+addRoleIds+"&delRoleIds="+delRoleIds+"&roleId="+roleId);
	var retVal = msg.getValueByName("retVal");
	if( retVal == "0" )
	{
	   //alert("继承角色信息保存成功!");
	   alert(g_I18NMessage("secframe_role_extend" , "sec_role_extend_save_ok"));
	   g_TableRowSetManager.get("roleExtendTable").refresh(condition); 
	   g_TableRowSetManager.get("roleNotExtendTable").refresh("refreshRoleExtend","roleId="+roleId);  
	}
    else
	{
	   alert(msg.getValueByName("retMsg"));
	}
}
</script>
</body>
</html>