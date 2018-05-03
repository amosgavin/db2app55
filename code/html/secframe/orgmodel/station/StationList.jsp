<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<HTML>
<head>
<title><i18n:message key="sec.organize.orgmgr" res="i18n.secframe_resource"/></title>
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
         <ai:contractframe id="" contenttype="table"  title="sec.station.alreadystation" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
			  <ai:contractitem/>
				<ai:table
					setname="com.ai.secframe.orgmodel.web.SETSecStation"
					tableid="existStationTable"
					tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.orgmodel.service.interfaces.ISecStationSV"
					implservice_querymethod="querySecStation" 
					footdisplay="none" height="200" width="100%" multiselect="true" initial="false"
					needrefresh="true">
					<ai:col fieldname="STATION_ID" visible="false" />
					<ai:col fieldname="STATION_TYPE_ID" visible="false" />
					<ai:col fieldname="NAME" width="70%" editable="false" />
					<ai:col fieldname="CODE" width="30%"  editable="false" />
				</ai:table>
           </ai:contractframe>
           <div class="area_button">
           <img id="add" border="0" src="<%=request.getContextPath()%>/webframe/images/icon/up.gif"  alt="" onClick="add()" align="absmiddle" style="cursor:hand;"/>&nbsp;&nbsp;
           <img id="remove" border="0" src="<%=request.getContextPath()%>/webframe/images/icon/down.gif"  alt="" onClick="remove()" align="absmiddle" style="cursor:hand;"/>
           </div>
           <ai:contractframe id="" contenttype="table"  title="sec.station.willstation" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
			  <ai:contractitem/>
			  <ai:table
					setname="com.ai.secframe.orgmodel.web.QSETSecNoExistStation"
					tableid="noExistStationTable"
					tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.ai.secframe.orgmodel.service.interfaces.ISecStationSV"
					footdisplay="none"  conditionname="condition" 
					implservice_querymethod="getNoExistStationByOrgId(long organizeId)" 
					height="140" width="100%" initial="false" multiselect="true"
					needrefresh="true">
					<ai:col fieldname="STATION_ID" visible="false" />
					<ai:col fieldname="NAME" width="30%" editable="false" />
					<ai:col fieldname="STATION_TYPE_ID" visible="false" />
					<ai:col fieldname="CODE"  width="70%" editable="false" />
				</ai:table>
           </ai:contractframe>

            <div class="area_button">
                    <ai:button text="sec.station.save" i18nRes="i18n.secframe_resource"  id="updateBtn" onclick="save()"/>
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
       var noExistStationTable = g_TableRowSetManager.get("noExistStationTable");
       noExistStationTable.refresh("organizeId="+org_id);
   }
}	

function add()
{
    var existStationTable = g_TableRowSetManager.get("existStationTable");
    var noExistStationTable = g_TableRowSetManager.get("noExistStationTable");
    if( noExistStationTable.getSelectedRows()!=null&&noExistStationTable.getSelectedRows().length>0)
    {
	 		var selRows = noExistStationTable.getSelectedRows();
	  		for(var i=0;i<selRows.length;i++)
	  		{
		  		existStationTable.newRow(false);
		  		existStationTable.setValue(existStationTable.getRow(),"STATION_ID",noExistStationTable.getValue(selRows[i],"STATION_ID"),noExistStationTable.getValue(selRows[i],"STATION_ID"));
		  		existStationTable.setValue(existStationTable.getRow(),"STATION_TYPE_ID",noExistStationTable.getValue(selRows[i],"STATION_TYPE_ID"),noExistStationTable.getValue(selRows[i],"STATION_TYPE_ID"));
				existStationTable.setValue(existStationTable.getRow(),"NAME",noExistStationTable.getValue(selRows[i],"NAME"),noExistStationTable.getValue(selRows[i],"NAME"));
				existStationTable.setValue(existStationTable.getRow(),"CODE",noExistStationTable.getValue(selRows[i],"CODE"),noExistStationTable.getValue(selRows[i],"CODE"));
	  		}
	  		for(var i=0;i < noExistStationTable.count();i++)
	  		{
			    if(noExistStationTable.isSelected(i))
			    {
				    noExistStationTable.deleteRow(i);
				    i--;
				}
         	}
	  		
	 }
	 else
	 {
	     //alert("请选择要添加的岗位！");
	     alert(g_I18NMessage("secframe_stationlist", "secframe_stationlist_selstation"));
	 }
   
}

function remove()
{

    var existStationTable = g_TableRowSetManager.get("existStationTable");
    var noExistStationTable = g_TableRowSetManager.get("noExistStationTable");
    if( existStationTable.getSelectedRows()!=null&&existStationTable.getSelectedRows().length>0)
    {
	 		var selRows = existStationTable.getSelectedRows();
	  		for(var i=0;i<selRows.length;i++)
	  		{
		  		noExistStationTable.newRow(false);
		  		noExistStationTable.setValue(noExistStationTable.getRow(),"STATION_ID",existStationTable.getValue(selRows[i],"STATION_ID"),existStationTable.getValue(selRows[i],"STATION_ID"));
	            noExistStationTable.setValue(noExistStationTable.getRow(),"STATION_TYPE_ID",existStationTable.getValue(selRows[i],"STATION_TYPE_ID"),existStationTable.getValue(selRows[i],"STATION_TYPE_ID"));
	            noExistStationTable.setValue(noExistStationTable.getRow(),"NAME",existStationTable.getValue(selRows[i],"NAME"),existStationTable.getValue(selRows[i],"NAME"));
				noExistStationTable.setValue(noExistStationTable.getRow(),"CODE",existStationTable.getValue(selRows[i],"CODE"),existStationTable.getValue(selRows[i],"CODE"));
	  		}
	  		for(var i=0;i < existStationTable.count();i++)
	  		{
			    if(existStationTable.isSelected(i))
			    {
				    existStationTable.deleteRow(i);
				    i--;
				}
         	}
	  		
	 }
	 else
	 {
	     //alert("请选择要删除的岗位！");
	     alert(g_I18NMessage("secframe_stationlist", "secframe_stationlist_seldelstation"));
	 }
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

//点击参与人显示该参与所包含的操作员
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
</script>
