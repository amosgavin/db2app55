<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title><i18n:message key="sec.opstmo.opstlist" res="i18n.secframe_resource"/></title>
    <%
 		long operId = SessionManager.getUser().getID();
 	 %>
  </head>
<body onload="diableOrg()">
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="220" valign="top">
			<ai:contractframe id="orgtype" contenttype="table" title="sec.organize.orgchioc" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
  				<ai:contractitem>
  					<div class="t-bot-mc-button">
					           <ai:button id="byorgbtn" text="sec.operator.query.org" i18nRes="i18n.secframe_resource" onclick="QueryByOrg()"/>
							   <ai:button id="bycondbtn" text="sec.operator.query.condition" i18nRes="i18n.secframe_resource" onclick="QueryByCond()"/>
  					</div>
  				</ai:contractitem>
							<div id="bycond" style="display: none; height:500px;">
								<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					                      <tr>
					                        <td class="td_font"><i18n:message key="sec.operator.code" res="i18n.secframe_resource"/>：</td>
					                        <td>
					                        	<input value="" type="text" id="code" style="width:130"/>
					                        </td>
					                      </tr>
					                      <tr>
					                        <td class="td_font"><i18n:message key="sec.station.name" res="i18n.secframe_resource"/>：</td>
					                        <td>
					                        	<input type="text" value="" id="stationName" style="width:130"/>
					                        </td>
					                      </tr>					                      
					                    </table>
					                    <div class="area_button">
											<ai:button text="sec.query" i18nRes="i18n.secframe_resource" id="searchOperBtn" onclick="searchOpStation()"/>
										</div>
							</div>
							<div id="byorg">
							<table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
              					<ai:dbtree_new id="orgStationTree" datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel" 
									multiselect="false" height="500" width="100%" ishaveline="true" onselect="orgStationClick"/>
								</td>
							</tr>
						</table>
            				</div>
			</ai:contractframe>
		</td>
		<td align="right" valign="top">	
			<ai:contractframe id="ctframe1" contenttype="table" title="sec.opstmo.opstlist" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
  				<ai:contractitem/>
				<ai:table setname="com.ai.secframe.orgmodel.web.SETSecOpStationOrg" tableid="DBTableOpStation"
					 tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
					 parametersname="com.ai.secframe.orgmodel.web.SecOpStationAction" 
					 initial="false" pagesize="20" width="100%" height="420"
					 needrefresh="true" footdisplay="true" onrowchange="selectStation" ondbclick="selectMo">
			 		<ai:col fieldname="OP_STATION_ID"  visible="false"/>
					<ai:col fieldname="CODE"  width="20%" visible="true"/>
					<ai:col fieldname="STAFF_NAME" width="20%" visible="true"/>
					<ai:col fieldname="STATION_ID"  visible="false"/>
					<ai:col fieldname="STATION_NAME" width="30%" visible="true"/>
					<ai:col fieldname="ORGANIZE_NAME" width="30%" visible="true"/>
					<ai:col fieldname="ORG_CODE"  visible="false"/>
					<ai:col fieldname="CREATE_DATE"  visible="false"/>
					<ai:col fieldname="STATE"  visible="false"/>
			 	</ai:table>
			</ai:contractframe>
			<div class="area_button">
				<ai:button id="saveMoStAuthor" text="sec.stationmoauthor.change" i18nRes="i18n.secframe_resource" onclick="changeMoStationAuthor()"/>
			</div>
		</td>
	</tr>
</table>
  </body>
  <script type="text/javascript">
  	var selStationId ="";
	/**
	 * 点击组织节点显示该组织所包含的岗位
	 */
	function orgStationClick()
	{
		var orgTree = g_DBTreeNewManager.get("orgStationTree");
		var curNode = orgTree.getCurNodeInfo();
		if(curNode != null && curNode.value != null)
		{
			if(curNode.value == -1)
			{
				return;
			}
			var rowset = g_TableRowSetManager.get("DBTableOpStation");
			rowset.refresh("refreshByOrgId","orgId="+curNode.value+"&operId=<%=operId%>");
		}
	}
	/**
	 * 根据选中的岗位初始化菜单MO树
	 */
	function selectStation()
	{
		var stationTable = g_TableRowSetManager.get("DBTableOpStation");
		selStationId = stationTable.getValue(stationTable.getRow(), "OP_STATION_ID");
	}

	function selectMo()
	{
	   var stationTable = g_TableRowSetManager.get("DBTableOpStation");
	   selStationId = stationTable.getValue(stationTable.getRow(), "OP_STATION_ID");
	   var result = window.showModalDialog("<%=request.getContextPath()%>/secframe/sysmgr/privilege/SelectOpStationMoAuthorDialog.jsp",selStationId,"scroll:no;resizable:no;status:no;dialogHeight:500px;dialogWidth:300px");
	   selStationId = "";
	}
	
	function changeMoStationAuthor()
	{
	   if (null == selStationId || "" == selStationId)
        { 
             alert(g_I18NMessage("secframe_stationmoauthor" , "secframe_stationmoauthor_change"));
             return;
        }
	   var result = window.showModalDialog("<%=request.getContextPath()%>/secframe/sysmgr/privilege/SelectOpStationMoAuthorDialog.jsp",selStationId,"scroll:no;resizable:no;status:no;dialogHeight:500px;dialogWidth:300px");
	   selStationId = "";
	}
	
	function diableOrg() {
		g_AIButtonManager.get("byorgbtn").setDisabled(true);
	}

	/**
	 * 根据组织查询，灰化条件查询按钮
	 */
	function QueryByOrg()
	{
		document.getElementById("byorg").style.display="block";
		document.getElementById("bycond").style.display="none";
		g_AIButtonManager.get("byorgbtn").setDisabled(true);
		g_AIButtonManager.get("bycondbtn").setDisabled(false);
	}
	/**
	 * 根据条件查询，灰化组织查询按钮
	 */
	function QueryByCond()
	{
		document.getElementById("byorg").style.display="none";
		document.getElementById("bycond").style.display="block";
		g_AIButtonManager.get("byorgbtn").setDisabled(false);
		g_AIButtonManager.get("bycondbtn").setDisabled(true);
	}

	/**
	 * 查询上岗信息
	 */
	function searchOpStation(){
		var dbTableOper = g_TableRowSetManager.get("DBTableOpStation");
		var code = document.getElementById("code").value;
		var stationName = document.getElementById("stationName").value;

		var cond = "code=" + code +"&stationName=" + stationName;
		
		if(code == "" && stationName == "")
		{
			alert(g_I18NMessage("secframe_common", "condition_empty"));
			return ;
		}
		dbTableOper.refresh("refreshByOrgId",cond);
	}
  </script>
</html>
