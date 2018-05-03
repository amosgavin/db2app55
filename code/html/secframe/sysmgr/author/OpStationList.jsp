<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title><i18n:message key="opstationlist.station.list" res="i18n.secframe_resource"/></title>
  </head>
  <body>
 <table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="220" valign="top">
			<ai:contractframe id="orgtype" contenttype="table" title="sec.stationmoauthor.selstationauthor" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
  				<ai:contractitem/>
  				<table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
        			<tr>
         			  <td>
  				<ai:dbtree_new id="orgStationTree" datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel" 
					multiselect="false" height="500" width="100%" ishaveline="true" onselect="orgTreeNodeClick"/>
			</td>
                  </tr>
              </table>
			</ai:contractframe>
		</td>
		<td align="right" valign="top">	
			<ai:contractframe id="ctframe1" contenttype="table" title="sec.stationmoauthor.stationlist" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
  				<ai:contractitem/>
				<ai:table tableid="dbTableStation"	setname="com.ai.secframe.orgmodel.web.SETSecStation"
							tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
							parametersname="com.ai.secframe.orgmodel.web.SecOpStationAction"
							initial="false" multiselect="false" editable="false" pagesize="4"
							width="100%" height="100" needrefresh="true" footdisplay="true" 
							onrowchange="selectStation">							
						  <ai:col fieldname="STATION_ID" visible="false"/>	
			              <ai:col fieldname="CODE" width="30%" visible="true" />
			              <ai:col fieldname="NAME" width="30%" visible="true"/>
			              <ai:col fieldname="STATION_TYPE_ID" width="20%" visible="true"/>
			              <ai:col fieldname="ORGANIZE_ID" width="20%" visible="true"/>
			              <ai:col fieldname="CREATE_DATE" visible="false"/>
			              <ai:col fieldname="NOTES" visible="false"/>
	            </ai:table>
			</ai:contractframe>
			<%
          		String isBatchAuthor = request.getParameter("isBatchAuthor");
          		if(isBatchAuthor == null)
          		{
          			isBatchAuthor = "";
          		} 
          		if(isBatchAuthor.trim().equals("Y"))
          		{
          	 %>
          			<%@include file="/secframe/sysmgr/author/BatchAuthorManager.jsp"%>  
          	<%
          		}
          		else if(isBatchAuthor.trim().equals("N"))
          		{          		
          	 %>
          	 		<%@include file="/secframe/orgmodel/operstation/OpStationManager.jsp"%>  
          	 <%
          	 	}
          	 %>	
		</td>
	</tr>
</table>
  </body>
  <script type="text/javascript">
  	/**
  	 * 获取岗位Table
  	 */
  	function getDBTableStation()
	{
		return g_TableRowSetManager.get("dbTableStation");
	}
	/**
	 * 点击组织节点显示该组织所包含的岗位
	 */
	function orgTreeNodeClick()
	{
		var dbgridStation = getDBTableStation();
		var orgTree = g_DBTreeNewManager.get("orgStationTree");
		var curNode = orgTree.getCurNodeInfo();
		var organizeId = curNode.value;
		if(organizeId == -1)
		{
			return;
		}
		// 获取操作员ID
    	var curOperId = "";
		dbgridStation.refresh("refreshStation","organizeId="+organizeId+"&operId="+curOperId);
		initial(0, 0, organizeId);
	}
	/** 
	 * 选择岗位
	 */
	function selectStation()
	{
		var dbTableStation = getDBTableStation();
    	var stId = dbTableStation.getValue(dbTableStation.getRow(), "STATION_ID");
		var organizeId = dbTableStation.getValue(dbTableStation.getRow(), "ORGANIZE_ID"); 
		initial(0, stId, organizeId);
	}
  </script>
  
</html>
