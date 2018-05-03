<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<HTML>
<head>
<title></title>
 <%
 		long operId_local = SessionManager.getUser().getID();
 %>
</head>
<body onLoad="doResize()" onResize="doResize()">
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
         <tr>
           <td width="220" valign="top">
           <ai:contractframe id="" contenttype="table"  title="sec.organize.orgchioc" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
		  	<ai:contractitem/>
		  	<table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                     <td>
		  	<ai:dbtree_new id="orgTree"
							datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel"
							multiselect="false" height="500" width="100%" ishaveline="true"
							onselect="treeNodeClick"/>
                     </td>
                  </tr>
              </table>	
           </ai:contractframe>
		</td>
		<td valign="top" align="right">
         <ai:contractframe id="" contenttype="table"  title="已建岗位(单击选中)"  width="100%" allowcontract="false" frameclosed="false">
			  <ai:contractitem/>
				<ai:table
					setname="com.ai.secframe.orgmodel.web.SETSecStation"
					tableid="existStationTable"
					tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.orgmodel.service.interfaces.ISecStationSV"
					implservice_querymethod="querySecStation" 
					footdisplay="none" height="200" width="100%" multiselect="false" initial="false"
					onrowchange="initOpStation"
					needrefresh="true">
					<ai:col fieldname="STATION_ID" visible="true" width="100"/>
					<ai:col fieldname="STATION_TYPE_ID" visible="true" width="150"/>
					<ai:col fieldname="NAME" width="80%" editable="true" width="200"/>
					<ai:col fieldname="CODE" width="20%"  editable="true" width="100"/>
				</ai:table>
           </ai:contractframe>
           <div class="area_button">
  	           <ai:button id="openAuthorWinBtn" text="sec.authormanager.author" i18nRes="i18n.secframe_resource" enable="false" onclick="showAuthorDialog()"/>
           </div>
           <ai:contractframe id="contractframe2" contenttype="table" title=""  width="100%" allowcontract="false" frameclosed="false">
			<ai:contractitem/>
			<ai:table setname="com.ai.secframe.sysmgr.web.SETSecAuthoredRole" tableid="dbTableAuthoredRole"
					 tablemodel="com.ai.appframe2.web.tag.ActionDataModel"	height="100" width="100%"	
					 parametersname="com.ai.secframe.sysmgr.web.SecAuthorAction4Default" pagesize="4"
					 initial = "false" multiselect = "true" needrefresh="true" editable="true">							 
				<ai:col fieldname="AUTHOR_ID"  visible="false" editable = "false"/>	 
		 		<ai:col fieldname="ROLE_ID"  visible="false" editable = "false"/>
				<ai:col fieldname="ROLE_NAME"  visible="true" width="20%" editable = "false"/>
				<ai:col fieldname="ROLE_TYPE"  visible="true" width="15%" editable = "false"/>
				<ai:col fieldname="REGION_CODE"   visible="false" editable = "false"/>
				<ai:col fieldname="DOMAIN_ID"   visible="false" editable = "false"/>
				<ai:col fieldname="AUTHOR_TYPE"  visible="false" width="15%"/>
				<ai:col fieldname="AUTHOR_VALID_DATE"  visible="false" width="25%"/>
				<ai:col fieldname="AUTHOR_EXPIRE_DATE"  visible="false" width="25%"/>
		 	</ai:table>
		</ai:contractframe>
            <div class="area_button">
                     <ai:button text="解除所选授权"  id="unAuthorBtn" onclick="unauthor()"/>
            <div>
    </td>
  </tr>
</table>
</body>
</html>
<script>
var org_id =""; //当前节点的组织ID
var organizeName = "";	 //当前组织的名称	
var dbTree = g_DBTreeNewManager.get("orgTree");

function refreshTable()
{
   if(null != org_id && org_id != "")
   {
       var existStationTable = g_TableRowSetManager.get("existStationTable");
       existStationTable.refresh("ORGANIZE_ID="+org_id+" AND STATE =1");
   }
}	

	/**
	 * 初始化上岗页面
	 */
	function initOpStation()	{
		var curOpstId = -1;
		var existStationTable = g_TableRowSetManager.get("existStationTable");
		var selRows = existStationTable.getSelectedRows();
		
		var stId = -1;
		var selRows = existStationTable.getSelectedRows();
		if(selRows != null && selRows.length > 0)
		{
			stId = existStationTable.getValue(selRows[0], "STATION_ID");
            g_AIButtonManager.get("openAuthorWinBtn").setDisabled(false);	
		}else{
            g_AIButtonManager.get("openAuthorWinBtn").setDisabled(true);				
		}
		var dbTableAuthoredRole = g_TableRowSetManager.get("dbTableAuthoredRole");
		if(stId != -1)
		{
			dbTableAuthoredRole.refresh("refreshDefaultsRoles", "operId="+<%=operId_local%>+"&stId="+stId);
			if(dbTableAuthoredRole.getTotalRowCount() > 0)
			{
				g_AIButtonManager.get("unAuthorBtn").setDisabled(false);
			}
			else
			{
				g_AIButtonManager.get("unAuthorBtn").setDisabled(true);
			}
		}
		else
		{
			dbTableAuthoredRole.refresh("refreshAuthoredRoles", "1<>1");
			g_AIButtonManager.get("unAuthorBtn").setDisabled(true);
		}
		
	/*	var dbgridOper = getDBGridOper();
		var operId = dbgridOper.getValue(dbgridOper.getRow(),"OPERATOR_ID");
		curOrgId = dbgridOper.getValue(dbgridOper.getRow(),"ORGANIZE_ID");
		initial(operId, -1, curOrgId);*/
	}
	
function save()
{ 
    var existStationTable = g_TableRowSetManager.get("existStationTable");
    var existCount = existStationTable.count();
    var addStation ="";
    var oneStation="";
    for (var i = 0 ;i<existCount;i++)
    {
       existStationTable.setRow(i);
       var stationId = existStationTable.getValue(existStationTable.getRow(),"STATION_ID");
       var stationTypeId = existStationTable.getValue(existStationTable.getRow(),"STATION_TYPE_ID");
       var stationCode = existStationTable.getValue(existStationTable.getRow(),"CODE");
       var stationName = existStationTable.getValue(existStationTable.getRow(),"NAME");
       if (null == stationId || stationId == "")
       {
           oneStation = stationTypeId + ","+stationCode +","+stationName;
           addStation = addStation + "|" +oneStation;
       }
    }
    addStation = addStation.substring(1);
    var noExistStationTable = g_TableRowSetManager.get("noExistStationTable");
    var noExistCount = noExistStationTable.count();
    var delStation ="";
    var delStationIds="";
    for (var i = 0 ;i<noExistCount;i++)
    {
       noExistStationTable.setRow(i);
       var stationId = noExistStationTable.getValue(noExistStationTable.getRow(),"STATION_ID");
       
       if (null != stationId && stationId != "")
       {
           delStationIds = delStationIds + "|" +stationId;
       }
    }
    delStationIds = delStationIds.substring(1);
    
    var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecStationAction?"+
				"action=saveExistStation&addStation="+addStation+"&organizeId="+org_id+"&delStationIds="+delStationIds);
    
	var retVal = msg.getValueByName("retVal");
	if( retVal == "0" )
	{
	   alert(g_I18NMessage("secframe_stationlist", "secframe_stationlist_save_ok"));
	   refreshTable();
	}
    else
	{
	   alert(msg.getValueByName("retMsg"));
	   refreshTable();
	}  
}
//右键菜单刷新
function refreshOrg()
{
	dbTree.refresh(org_id ,1);
}

//刷新树的某个节点
function refreshTreeNode(organizeId)
{
	dbTree.refresh(org_id ,1);
}
//刷新当前树节点
function refreshCurNode()
{
 dbTree.refresh(org_id ,1);
}

//刷新树的某个节点的父节点
function refreshParentTreeNode(org_id,org_name){
    
    var objCurParNode=dbTree.getParentNodeInfo(org_id);
    //alert(org_id);
    if(objCurParNode!=null&&objCurParNode.value>0)
    {
	 var parent_value = objCurParNode.value;		 
	 dbTree.refresh(parent_value ,1);
	}
	if(objCurParNode.value==-1)
	  dbTree.setCurNodeInfo(org_id,org_name,org_id);
}

//点击组织结构显示该结点包含的岗位
function treeNodeClick(treeVal,treeText,treeUserObj,treeNodeType){
    org_id = treeVal;
	organizeName = treeText;
	refreshTable();
}

//调整控件大小以适应窗口
function doResize()
{
	var width = document.body.offsetWidth;
	var height = document.body.offsetHeight;
}

//选择角色
function addRole(){


}

//删除所选角色
function unauthor(){
        var existStationTable = g_TableRowSetManager.get("existStationTable");
		var selRows = existStationTable.getSelectedRows();
		if(selRows != null && selRows.length > 0)
		{
			stId = existStationTable.getValue(selRows[0], "STATION_ID");
		}else{
		    alert("请选择岗位!");
		}
		var dbTableAuthoredRole = g_TableRowSetManager.get("dbTableAuthoredRole");
        var rolwRows = dbTableAuthoredRole.getSelectedRows();
		if(rolwRows != null && rolwRows.length > 0)
		{
			roleId = dbTableAuthoredRole.getValue(rolwRows[0], "ROLE_ID");
		}else{
		    alert("请选择删除的角色!");
		}
	    var list = new Array();
    	var param = "roleid="+roleId+"&stid="+stId;
    	alert(param);
        var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecAuthorAction4Default?action=unAuthor&"+"roleid="+roleId+"&stid="+stId);
		
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

	/**
	 * 显示授权对话框
	 */
	function showAuthorDialog()
	{
		var existStationTable = g_TableRowSetManager.get("existStationTable");
		var selRows = existStationTable.getSelectedRows();
		if(selRows != null && selRows.length > 0)
		{
			stId = existStationTable.getValue(selRows[0], "STATION_ID");
			if (stId == "")
			{
				alert(g_I18NMessage("secframe_author", "sec_station_select"));
				return;
			}
		 	var url = "<%=request.getContextPath()%>/secframe/sysmgr/author/DefaultRoleSelect.jsp";
			var retVal = window.showModalDialog(url, stId, "scroll:no;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:600px");
			if(retVal != "undefined" && retVal == 1)
			{
				// 刷新已授权角色
				initOpStation();
			}
		}
		else
		{
			alert(g_I18NMessage("secframe_author", "sec_station_select"));
			return;
		}
	}



</script>
