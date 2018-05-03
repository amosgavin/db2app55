<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title><i18n:message key="sec.stationselect.selectstation" res="i18n.secframe_resource"/></title>
  </head>
  <body>
  <% 
  	String selectType=request.getParameter("selectType");
  %>
  <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
				<td width="220" valign="top">
   <ai:contractframe id="" contenttype="table"
						title="sec.organize.orgchioc" i18nRes="i18n.secframe_resource"
						width="100%" allowcontract="false" frameclosed="false">
						<ai:contractitem />
						<table width="99%" align="center" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td>
	              <ai:dbtree_new id="orgStationTree" datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel" 
						multiselect="false" height="360" width="100%" ishaveline="true" 
						onselect="orgTreeNodeClick"/>
								</td>
							</tr>
						</table>
					</ai:contractframe>
				</td>
				<td valign="top" align="right">	
              <ai:contractframe id="" contenttype="table"
						title="sec.stationselect.stationlist" i18nRes="i18n.secframe_resource"
						width="100%" allowcontract="false" frameclosed="false">
						<ai:contractitem />
          	 <ai:table tableid="dbTableStation"
						setname="com.ai.secframe.orgmodel.web.SETSecStation"
						tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
						parametersname="com.ai.secframe.orgmodel.web.SecOpStationAction"
						initial="false" multiselect="true" editable="false" pagesize="10"
						width="100%" height="220" needrefresh="true" footdisplay="true">
						
					  <ai:col fieldname="STATION_ID" visible="false"/>	
		              <ai:col fieldname="CODE" visible="true" width="200" />
		              <ai:col fieldname="NAME" visible="true" width="200"/>
		              <ai:col fieldname="STATION_TYPE_ID" visible="true" width="100"/>
		              <ai:col fieldname="ORGANIZE_ID" visible="true" width="100"/>
		              <ai:col fieldname="CREATE_DATE" visible="true" width="100"/>
		              <ai:col fieldname="NOTES" visible="false"/>
            </ai:table>
		</ai:contractframe>
    		<div class="area_button">
    			<ai:button text="sec.confirm" i18nRes="i18n.secframe_resource" onclick="onStation()"/>&nbsp;&nbsp;
    			<ai:button text="sec.cancel" i18nRes="i18n.secframe_resource" onclick="cancel()"/>
    		</div>
		
								</td>
							</tr>
						</table>
  </body>
  <script type="text/javascript">
  	var selectType="<%=selectType%>";
  	var curNode = null;
	var dbTree = g_DBTreeNewManager.get("orgStationTree");
  	function getDBTableStation()
	{
		return g_TableRowSetManager.get("dbTableStation");
	}
	/**
	 * 点击组织节点显示该组织所包含的岗位
	 */
	function orgTreeNodeClick(organizeId, organizeName, treeUserObj, treeNodeType)
	{
		var dbgridStation = getDBTableStation();
		if(organizeId == -1)
		{
			return;
		}
		// 获取操作员ID
    	var curOperId = window.dialogArguments;
		dbgridStation.refresh("refreshStation","organizeId="+organizeId+"&operId="+curOperId);
		var count = dbgridStation.count();
		for(var i=0; i < count; i++)
		{
			var notes = dbgridStation.getValue(i, "NOTES");
			if(notes != null && notes == "1")
			{
				dbgridStation.rowSelected(i, true, false);
			}
		}
	}
	/**
	 * 上岗
	 */
	function onStation()
	{
		var dbTableStation = getDBTableStation();
		var selRows = dbTableStation.getSelectedRows();
   		var stIdStr = "";
   		var stNameStr="";
   		if(selectType=="oneStationSelect"&&selRows.length>1){
   			alert(g_I18NMessage("secframe_stationselect", "sec_stationselect_only"));
   			return;
   		}
	    if(selRows != null && selRows.length > 0)
	    {
	   		for(var i=0; i < selRows.length; i++)
	   		{
	   			var selStId = dbTableStation.getValue(selRows[i], "STATION_ID");
	   			stIdStr = stIdStr + selStId+",";
	   			var selStName=dbTableStation.getValue(selRows[i], "NAME");
	   			stNameStr=stNameStr+selStName+",";
	   		}
	    
	    }else{
	    	alert(g_I18NMessage("sec_qsecstaffselec", "sec_qsecstaffselect_nonote"));
	    	return;
	    }
	    var list = new Array();
	    if(selectType=="oneStationSelect")
	    {
		    curNode = dbTree.getCurNodeInfo();
			if(curNode == null){
				alert(g_I18NMessage("secframe_stationselect", "sec_stationselect_select"));
				return false;
			}
			var v_org = new Organize(curNode.value,curNode.text);
			list[1] = stNameStr;
			list[2] = v_org;		
	    }
		list[0] = stIdStr;
											
		window.returnValue = list;
		window.self.close();
	}
	/**
	 * 退出，关闭窗口
	 */
	function cancel()
	{
		window.returnValue = 0;
		window.self.close();
	}
	

function affirm(){
	curNode = dbTree.getCurNodeInfo();
	if(curNode == null){
		alert(g_I18NMessage("secframe_stationselect", "sec_stationselect_select"));
		return false;
	}
	var v_org = new Organize(curNode.value,curNode.text);
	var list = new Array();
	list[0] = v_org
	window.returnValue = list;
	window.self.close();
}
function Organize(orgId,orgName){
	this.orgId = orgId;
	this.orgName = orgName;
}
	
  </script>
  
</html>
