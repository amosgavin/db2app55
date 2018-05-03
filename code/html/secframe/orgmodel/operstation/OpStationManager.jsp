<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    
    <title><i18n:message key="sec.opstation.title" res="i18n.secframe_resource"/></title>
  </head>
<body onload="diableOrg()">
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="220" valign="top">
			<ai:contractframe id="orgtype" contenttype="table" title="sec.operator.select" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
  				<ai:contractitem>
  					<div class="t-bot-mc-button">
					           <ai:button id="byorgbtn" text="sec.operator.query.org" i18nRes="i18n.secframe_resource" onclick="QueryByOrg()"/>
							   <ai:button id="bycondbtn" text="sec.operator.query.condition" i18nRes="i18n.secframe_resource" onclick="QueryByCond()"/>
					</div>
  				</ai:contractitem>
							<div id="bycond" style="display: none; height:500px;">
								<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					                      <tr>
					                        <td class="td_font"><i18n:message key="sec.operator.name" res="i18n.secframe_resource"/>£º</td>
					                        <td>
					                        	<input value="" type="text" id="name" style="width:130"/>
					                        </td>
					                      </tr>
					                      <tr>
					                        <td class="td_font"><i18n:message key="sec.operator.code" res="i18n.secframe_resource"/>£º</td>
					                        <td>
					                        	<input type="text" value="" id="code" style="width:130"/>
					                        </td>
					                      </tr>
					                      <tr>
					                        <td class="td_font"><i18n:message key="sec.operator.billid" res="i18n.secframe_resource"/>£º</td>
					                        <td>
					                        	<input type="text" value="" id="billId" style="width:130"/>
					                        </td>
					                      </tr>
					                    </table>
					                    <div class="area_button">
											<ai:button text="sec.query" i18nRes="i18n.secframe_resource" id="searchOperBtn" onclick="searchOperatorStaff()"/>
										</div>
							</div>
							<div id="byorg">
							<table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
              					<ai:dbtree_new id="orgTree" datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel" 
									multiselect="false" height="500" width="100%" ishaveline="true" 
									onselect="treeNodeClick"/>
								</td>
							</tr>
						</table>
            				</div>
			</ai:contractframe>
		</td>
		<td align="right" valign="top">	
			<ai:contractframe id="ctframe1" contenttype="table" title="sec.operator.list" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
  				<ai:contractitem/>
				<ai:table tableid="dbTableOperator"
							setname="com.ai.secframe.orgmodel.web.SETSecOrgStaffOper"
							initial="false" multiselect="false" editable="false"
							tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
							parametersname="com.ai.secframe.orgmodel.web.SecOperatorAction"
							onrowchange="selectOperator" pagesize="8"
							width="100%" height="180" needrefresh="true" footdisplay="true">
				  <ai:col fieldname="OPERATOR_ID" visible="false" />			
	              <ai:col fieldname="CODE" width="20%" editable="true" visible="true" />
	              <ai:col fieldname="STAFF_NAME" width="30%" editable="true" visible="true"/>
	              <ai:col fieldname="OPSTATE" width="20%" editable="true" visible="true"/>
	              <ai:col fieldname="STAFF_ID" editable="true" visible="false"/>
	              <ai:col fieldname="ORG_CODE" editable="true" visible="false"/>
	              <ai:col fieldname="ORGANIZE_NAME" width="30%" editable="true" visible="true"/>	
	              <ai:col fieldname="ORGANIZE_ID" editable="true" visible="false"/>              
	            </ai:table>
			</ai:contractframe>
			<ai:contractframe id="ctframe2" contenttype="table" title="sec.opstation.info" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
				<ai:contractitem/>				
	            <ai:table setname="com.ai.secframe.orgmodel.web.SETSecOpStationOrg" tableid="DBTableOpStation"
						 tablemodel="com.ai.appframe2.web.tag.ActionDataModel"	width="100%" height="180"	
						 parametersname="com.ai.secframe.orgmodel.web.SecOpStationAction" pagesize="8"
						 initial = "false" multiselect = "true" needrefresh="true" editable = "false">
			 		<ai:col fieldname="OP_STATION_ID"  visible="false"/>
					<ai:col fieldname="CODE"   visible="true" width="20%"/>
					<ai:col fieldname="STAFF_NAME"  visible="true" width="30%"/>
					<ai:col fieldname="STATION_ID"  visible="false"/>
					<ai:col fieldname="STATION_NAME"  visible="true" width="30%"/>
					<ai:col fieldname="IS_BASE_STATION"  visible="true" width="20%"/>
					<ai:col fieldname="ORGANIZE_NAME"  visible="false"/>
					<ai:col fieldname="ORG_CODE"  visible="false"/>
					<ai:col fieldname="CREATE_DATE" visible="false"/>
					<ai:col fieldname="STATE"  visible="false"/>
			 	</ai:table>
			</ai:contractframe>
			<div class="area_button">
				<ai:button id="onStationBtn" text="sec.opstation.on" i18nRes="i18n.secframe_resource" onclick="showStationDialog()"/>&nbsp;&nbsp;
				<ai:button id="offStationBtn" text="sec.opstation.off" i18nRes="i18n.secframe_resource" onclick="offStation()"/>
			</div>
		</td>
	</tr>
</table>
  </body>
  <script type="text/javascript" src="<%=request.getContextPath()%>/secframe/js/orgmodel/operstation/OpStationManager.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/secframe/js/orgmodel/operator/OperatorList.js"></script>
  <script type="text/javascript">
  
	/**
	 * ÏÔÊ¾ÉÏ¸Ú¶Ô»°¿ò
	 */
	function showStationDialog()
	{
		var dbTableOper = getDBTableOper();
		var operId = dbTableOper.getValue(dbTableOper.getRow(),"OPERATOR_ID");
		if (operId == "")
		{
			alert(g_I18NMessage("secframe_opstation", "sec_opstation_operator_select"));
			return;
		}
	 	var url = "<%=request.getContextPath()%>/secframe/orgmodel/operstation/StationSelect.jsp";
		var retVal = window.showModalDialog(url, operId, "scroll:no;resizable:no;help:no;status:no;dialogHeight:450px;dialogWidth:700px");
		if(retVal != "undefined" && retVal == 1)
		{
			init(operId, -1, -1, "");
		}
	}
	/**
	 * Àë¸Ú
	 */
	function offStation()
	{
		var dbTableOpStation = g_TableRowSetManager.get("DBTableOpStation");
		var selRows = dbTableOpStation.getSelectedRows();
		if(selRows != null && selRows.length > 0)
		{
			var opstIdStr = "";
			for(var i=0; i < selRows.length; i++)
	   		{
	   			var opStId = dbTableOpStation.getValue(selRows[i], "OP_STATION_ID");
	   			opstIdStr = opstIdStr + opStId+",";
	   		}
	   		// Àë¸Ú
	   		var param = "opstIdStr="+opstIdStr;
		    var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOpStationAction?action=offStation&"+param);
		    var retVal = msg.getValueByName("retVal");
		    if(retVal == 1 || retVal == "1")
		    {
		    	alert(g_I18NMessage("secframe_common", "sec_common_saveok"));
		    	var dbTableOper = getDBTableOper();
				var operId = dbTableOper.getValue(dbTableOper.getRow(),"OPERATOR_ID");
		    	init(operId, -1, -1, "");
		    }
		    else
		    {
		    	alert(g_I18NMessage("secframe_common", "sec_common_savefail"));
		    }
		}
		else
		{
			alert(g_I18NMessage("secframe_opstation", "sec_opstation_record_select"));
		}
	}
		
	function diableOrg()
	{
		g_AIButtonManager.get("byorgbtn").setDisabled(true);
	}
  </script>
</html>
