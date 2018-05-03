<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title><i18n:message key="sec.operatoripmacbandmgmt" res="i18n.secframe_resource"/></title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/secframe/js/orgmodel/ipmacband/IPMACBandManager.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/secframe/js/orgmodel/operator/OperatorList.js"></script>
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
					                        <td class="td_font"><i18n:message key="sec.operator.name" res="i18n.secframe_resource"/>：</td>
					                        <td>
					                        	<input value="" type="text" id="name" style="width:130"/>
					                        </td>
					                      </tr>
					                      <tr>
					                        <td class="td_font"><i18n:message key="sec.operator.code" res="i18n.secframe_resource"/>：</td>
					                        <td>
					                        	<input type="text" value="" id="code" style="width:130"/>
					                        </td>
					                      </tr>
					                      <tr>
					                        <td class="td_font"><i18n:message key="sec.operator.billid" res="i18n.secframe_resource"/>：</td>
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
							onrowchange="selectOperator" pagesize="5"
							width="100%" height="120" needrefresh="true" footdisplay="true">
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
			<ai:contractframe id="ctframe2" contenttype="table" title="sec.operator_band_info" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
				<ai:contractitem/>				
	            <ai:table setname="com.ai.secframe.orgmodel.web.SETSecOperIPMACBand" tableid="DBTableOpIPMac"
						 tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
						 parametersname="com.ai.secframe.orgmodel.web.SecOpIPMacBandAction" 
						 width="100%" initial = "false" multiselect = "true" needrefresh="true"
						 editable = "false" height="120" pagesize="5" onrowchange="editIPMacBand">
					<ai:col fieldname="OPERATOR_IPMAC_BAND_ID"  visible="false"/>	 
			 		<ai:col fieldname="OPERATOR_ID"  visible="false"/>
					<ai:col fieldname="IP"   visible="true" width="30%" />
					<ai:col fieldname="MAC" visible="true" width="30%" />
					<ai:col fieldname="BAND_TYPE"  visible="true" width="20%" />
					<ai:col fieldname="CREATE_DATE" visible="true" width="20%"/>
			 	</ai:table>
			</ai:contractframe>
			<div class="area_button">
				<ai:button id="delBtn" text="sec.delete" i18nRes="i18n.secframe_resource" onclick="delIPMacBand()"/>
			</div>
			<ai:contractframe id="ctframe3" contenttype="table" title="sec.operator_band_info" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
				<ai:contractitem/>				
	            <ai:dbform formid="DBFormOpIPMac" onvalchange="changeLabel"
							setname="com.ai.secframe.orgmodel.web.SETSecOperIPMACBand" 
							datamodel="com.ai.appframe2.web.tag.ActionDataModel"		
							parametersname="com.ai.secframe.orgmodel.web.SecOperatorAction"
							initial="false"	editable="false">
					<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
						<tr>
							<td id="ipBeginTd" class="td_font">
								<i18n:message key="sec.operator.ip" res="i18n.secframe_resource"/>：
							</td>
							<td>
								<ai:dbformfield fieldname="IP" formid="DBFormOpIPMac" width="150"/><span class="font_red">*</span>
								<ai:dbformfield fieldname="OPERATOR_IPMAC_BAND_ID" formid="DBFormOpIPMac" visible="false"/>
							</td>
							<td id="ipEndTd" class="td_font">
								<i18n:message key="sec.operator.mac" res="i18n.secframe_resource"/>：
							</td>
							<td>
								<ai:dbformfield fieldname="MAC" formid="DBFormOpIPMac" width="150"/><span class="font_red">*</span>
							</td>
						</tr>
						<tr>
							<td class="td_font">
								<i18n:message key="sec.operator.bandtype" res="i18n.secframe_resource"/>：
							</td>
							<td colspan="3">
								<ai:dbformfield fieldname="BAND_TYPE" formid="DBFormOpIPMac" width="150"/><span class="font_red">*</span>
							</td>
						</tr>
					</table>
				</ai:dbform>
			</ai:contractframe>
			<div class="area_button">
				<ai:button id="addBtn" text="sec.add" i18nRes="i18n.secframe_resource" onclick="addIPMacBand()"/>
				<ai:button id="saveBtn" text="sec.save" i18nRes="i18n.secframe_resource" enable="false" onclick="saveIPMacBand()"/>
			</div>			
		</td>
	</tr>
</table>
  </body>
  <script type="text/javascript">

	/**
  	 * 保存绑定信息
  	 */
  	function saveIPMacBand()
  	{
  		// 检验IP，MAC合法性
  		var bandForm = g_FormRowSetManager.get("DBFormOpIPMac");
  		var bandId = bandForm.getValue("OPERATOR_IPMAC_BAND_ID");
  		var ip = bandForm.getValue("IP");
  		var mac = bandForm.getValue("mac");
  		var bandType = bandForm.getValue("BAND_TYPE");
		if(checkIpMac(ip, mac, bandType) == 0)
		{
			return;
		}
		var dbTableOper = getDBTableOper();
  		var operId = dbTableOper.getValue(dbTableOper.getRow(),"OPERATOR_ID");
	   	var param = "bandId="+bandId+"&operId="+operId+"&ip="+ip+"&mac="+mac+"&bandType="+bandType;
	    var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOpIPMacBandAction?action=saveIPMacBand&"+param);
	    var retVal = msg.getValueByName("retVal");
	    if(retVal == 1 || retVal == "1")
	    {
	    	alert(g_I18NMessage("secframe_ipmacband", "sec_ipmacband_save_success"));
	    	init(operId, -1, -1, "");
	    }
	    else
	    {
	    	alert(g_I18NMessage("secframe_ipmacband", "sec_ipmacband_save_failure:"));
	    }
  	}
	/**
	 * 删除操作员IPMAC绑定信息
	 */
	function delIPMacBand()
	{
		var dbTableOPIPMAC = g_TableRowSetManager.get("DBTableOpIPMac");
		var selRows = dbTableOPIPMAC.getSelectedRows();
		if(selRows != null && selRows.length > 0) 
		{ 
			var bandIdStr = ""; 
			for(var i=0; i < selRows.length; i++) 
	   		{ 
	   			var bandId = dbTableOPIPMAC.getValue(selRows[i], "OPERATOR_IPMAC_BAND_ID"); 
	   			bandIdStr = bandIdStr + bandId+","; 
	   		} 
	   		// 删除 
	   		var param = "bandIdStr="+bandIdStr; 
		    var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOpIPMacBandAction?action=delIPMacBand&"+param);
		    var retVal = msg.getValueByName("retVal");
		    if(retVal == 1 || retVal == "1")
		    {
		    	alert(g_I18NMessage("secframe_ipmacband", "sec_ipmacband_save_success"));
		    	var dbTableOper = getDBTableOper();
  				var operId = dbTableOper.getValue(dbTableOper.getRow(),"OPERATOR_ID");
		    	init(operId, -1, -1, "");
		    }
		    else
		    {
		    	alert(g_I18NMessage("secframe_ipmacband", "sec_ipmacband_save_failure:"));
		    }
		}
		else
		{
			alert(g_I18NMessage("secframe_ipmacband", "sec_ipmacband_select_record"));
		}
	}
 
	function diableOrg()
	{
		g_AIButtonManager.get("byorgbtn").setDisabled(true);
	}
  </script>
</html>
