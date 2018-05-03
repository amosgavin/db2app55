<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="sec.operatormgmt" res="i18n.secframe_resource"/></title>
<%

%>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/CommUtil.js"></script>
</head>
<body onload="diableOrg();init()">
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
							onrowchange="selectOperator" pagesize="4"
							width="100%" height="100" needrefresh="true" footdisplay="true">
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
			<ai:contractframe id="ctframe2" contenttype="table" title="sec.operator_info" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
				<ai:contractitem/>
				<ai:dbform formid="dbformOperator"
							setname="com.ai.secframe.orgmodel.web.SETSecOperator"
							datamodel="com.ai.appframe2.web.tag.ActionDataModel"		
							parametersname="com.ai.secframe.orgmodel.web.SecOperatorAction"
							initial="false"	editable="false">
					<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
						<tr>
				           	<td class="td_font">
				           		<i18n:message key="sec.operator.code" res="i18n.secframe_resource"/>：
				           	</td>
				           	<td>
				           		<ai:dbformfield formid="dbformOperator" fieldname="CODE" editable="true" width="130" /><img id="check" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="checkCode();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
				           		<ai:dbformfield formid="dbformOperator" fieldname="OPERATOR_ID" visible="false" />
				           		<ai:dbformfield formid="dbformOperator" fieldname="STAFF_ID" visible="false" />
				           	</td>
				           	<td class="td_font"><i18n:message key="sec.operator.searial" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformOperator" fieldname="NOTES" width="150" />				           		
				           	</td>
				           	
				           	<!-- <td class="td_font">
				           		<i18n:message key="sec.operator.lockstate" res="i18n.secframe_resource"/>：
				           	</td>
				             -->
				           		<ai:dbformfield formid="dbformOperator" fieldname="LOCK_FLAG" width="150" visible="false" />
						</tr>
						<tr>
				           	<td class="td_font"><i18n:message key="sec.operator.password" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformOperator" fieldname="PASSWORD" width="150" /><span class="font_red">*</span>				           		
				           	</td>
				           	<td class="td_font"><i18n:message key="sec.operator.repassword" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<input type="password" id="password2" readonly="readonly" style="width:150"/><span class="font_red">*</span>		           		
				           	</td>
				           		<ai:dbformfield formid="dbformOperator" fieldname="ALLOW_CHANGE_PASSWORD" width="150" visible="false" />
				           		<ai:dbformfield formid="dbformOperator" fieldname="SECURITY_ID" width="150" visible="false" />				           		
						</tr>
						<tr>
							<td class="td_font"><i18n:message key="sec.operator.acct_valid_date" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformOperator" fieldname="ACCT_EFFECT_DATE" width="150" /><span class="font_red">*</span>				           		
				           	</td>
				           	<td class="td_font"><i18n:message key="sec.operator.acct_expire_date" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformOperator" fieldname="ACCT_EXPIRE_DATE" width="150" /><span class="font_red">*</span>	           		
				           	</td>
						</tr>
						<tr>
				           	<td class="td_font"><i18n:message key="sec.operator.pwd_valid_date" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformOperator" fieldname="PASSWORD_VALID_DATE" width="150" /><span class="font_red">*</span>				           		
				           	</td>
				           	<td class="td_font"><i18n:message key="sec.operator.state" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformOperator" fieldname="STATE" width="150" /><span class="font_red">*</span>				           		
				           	</td>
						</tr>
						<tr>
				           		<ai:dbformfield formid="dbformOperator" fieldname="TRY_TIMES" width="150" visible="false" />		    		
				           		<ai:dbformfield formid="dbformOperator" fieldname="CHG_PASSWD_FLAG" width="150" visible="false" />		    		
						</tr>
					</table>
				</ai:dbform>
			</ai:contractframe>			
			<ai:contractframe id="ctframe3" contenttype="table" title="sec.staff_info" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
				<ai:contractitem>
					<div class="t-bot-mc-word"><i18n:message key="sec.click.moreinfo" res="i18n.secframe_resource"/></div>
    				<div class="t-bot-mc-button">
			           <ai:button text="sec.moreinfo" i18nRes="i18n.secframe_resource" id="btnMore" onclick="moreContent();" />&nbsp;&nbsp;			         
					</div>
				</ai:contractitem>
				<ai:dbform formid="dbformStaff"
							setname="com.ai.secframe.orgmodel.web.SETSecStaff"
							datamodel="com.ai.appframe2.web.tag.ActionDataModel"		
							parametersname="com.ai.secframe.orgmodel.web.SecOperatorAction"
							initial="false"	editable="false">
					<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
						<tr>
				           	<td class="td_font">
				           		<i18n:message key="sec.staff.name" res="i18n.secframe_resource"/>：
				           	</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="STAFF_NAME" editable="true" width="130" /><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>				           		
				           	</td>
				           	<td class="td_font">
				           		<i18n:message key="sec.staff.billid" res="i18n.secframe_resource"/>：
				           	</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="BILL_ID" width="150"/><span class="font_red">*</span>
				           	</td>
						</tr>
						<tr>
							<td class="td_font">
				           		<i18n:message key="sec.staff.card_type" res="i18n.secframe_resource"/>：
				           	</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="CARD_TYPE_ID" width="150"/>
				           	</td>
				           	<td class="td_font"><i18n:message key="sec.staff.card_no" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="CARD_NO" width="150" />				           		
				           	</td>
						</tr>
						<tr>
							<td class="td_font"><i18n:message key="sec.staff.sex" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="GENDER" width="150" />				           		
				           	</td>
				           	<td class="td_font"><i18n:message key="sec.staff.birthday" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="BIRTHDAY" width="150" />		           		
				           	</td>
						</tr>
						<tr>
							<td class="td_font"><i18n:message key="sec.staff.orgnize" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="ORGANIZE_ID" editable="true" visible="false" width="0"/>
				           		<input id="orgName" readonly="readonly" style="width:130"/><img id="selectOrgnize" border="0" src="<%=request.getContextPath()%>/webframe/images/check.gif" onClick="selectOrgnize();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>		
				           	</td>
				           	<td class="td_font"><i18n:message key="sec.staff.job" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<input id="stationId" readonly="readonly" type="hidden" size="0"/>
			                	<input id="stationName" readonly="readonly" style="width:130"/><img id="selectStation" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStation();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
				           	</td>
						</tr>
					</table>
					<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2" id="extendCont" style="display:none">	
						<tr>				           	
				           	<td class="td_font"><i18n:message key="sec.staff.short_name" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="SHORT_NAME" width="150" />		           		
				           	</td>
				           	<td class="td_font"><i18n:message key="sec.staff.en_name" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="ENGLISH_NAME" width="150" />				           		
				           	</td>
						</tr>				
						<tr>
				           	<td class="td_font"><i18n:message key="sec.staff.marry_status" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="MARRY_STATUS" width="150" />				           		
				           	</td>
				           	<td class="td_font"><i18n:message key="sec.staff.national" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="NATIONAL_TYPE" width="150" />				           		
				           	</td>
						</tr>
						<tr>
				           	<td class="td_font"><i18n:message key="sec.staff.edu_level" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="EDUCATION_LEVEL" width="150" />		           		
				           	</td>
				           	<td class="td_font"><i18n:message key="sec.staff.politic_face" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="POLITICS_FACE" width="150" />				           		
				           	</td>
						</tr>
						<tr>
				           	<td class="td_font"><i18n:message key="sec.staff.job_desc" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="JOB_DESC" width="150" />				           		
				           	</td>
				           	<td class="td_font"><i18n:message key="sec.staff.home_tel" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="HOME_TEL" width="150" />				           		
				           	</td>
						</tr>
						<tr>
				           	<td class="td_font"><i18n:message key="sec.staff.office_tel" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="OFFICE_TEL" width="150" />		           		
				           	</td>
				           	<td class="td_font"><i18n:message key="sec.staff.religion" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="RELIGION" width="150" />				           		
				           	</td>
						</tr>
						<tr>
				           	<td class="td_font"><i18n:message key="sec.staff.family_info" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="FAMILY_INFO" width="150" />				           		
				           	</td>
				           	<td class="td_font"><i18n:message key="sec.staff.character" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="CHARACTER_DESC" width="150" />		           		
				           	</td>
						</tr>
						<tr>
							<td class="td_font"><i18n:message key="sec.staff.postcode" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="POSTCODE" width="150" />				           		
				           	</td>
				           	<td class="td_font"><i18n:message key="sec.staff.email" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="EMAIL" width="150" />				           		
				           	</td>
						</tr>
						<tr>
				           	<td class="td_font"><i18n:message key="sec.staff.alarm_bill" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="ALARM_BILL_ID" width="150" />		           		
				           	</td>
				           	<td class="td_font"><i18n:message key="sec.staff.car_no" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="CAR_NO" width="150" />				           		
				           	</td>
						</tr>
						<tr>
				           	<td class="td_font"><i18n:message key="sec.staff.company" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="JOB_COMPANY" width="150" />				           		
				           	</td>
				           	<td class="td_font"><i18n:message key="sec.staff.address" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="CONTACT_ADDRESS" width="150" />		           		
				           	</td>
						</tr>
						<tr>
							<td class="td_font"><i18n:message key="sec.operator.note" res="i18n.secframe_resource"/>：</td>
				           	<td>
				           		<ai:dbformfield formid="dbformStaff" fieldname="NOTES" width="150" />				           		
				           	</td>
				           	<td class="td_font">&nbsp;</td>
				           	<td>
				           		&nbsp;			           		
				           	</td>
						</tr>
					</table>
				</ai:dbform>
			</ai:contractframe>
			<div class="area_button">
				<ai:button id="addOperator" text="sec.add" i18nRes="i18n.secframe_resource" onclick="addOperator()"/>
	      		<ai:button id="save"  text="sec.save" i18nRes="i18n.secframe_resource" enable="false" onclick="saveOperatorAndStaff()"/>
	      		<ai:button id="reset"  text="sec.reset_password" i18nRes="i18n.secframe_resource" enable="false" onclick="resetPwd()"/>
	      		<ai:button id="clearAuthor"  text="sec.clear_author" i18nRes="i18n.secframe_resource" enable="false" onclick="clearAuthor()"/>
			</div>
		</td>
	</tr>
</table>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/secframe/js/orgmodel/operator/OperatorManager.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/secframe/js/orgmodel/operator/OperatorList.js"></script>
<script type="text/javascript">
	 /**
	  * 选择员工
	  */
	 function selectStaff()
	 {
	 	var url = "<%=request.getContextPath()%>/secframe/orgmodel/operator/StaffSelect.jsp";
	 	var retVal = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:no;dialogHeight:600px;dialogWidth:320px");
		if(retVal != null)
		{
			if(retVal > 0) 
			{ 
				var dbformStaff = getDBFormStaff();  
				dbformStaff.refresh("refreshStaff", "staffId="+retVal); 
				var dbformOperator = getDBFormOperator(); 
				dbformOperator.setValue("STAFF_ID", retVal); 
			} 
		} 
	 } 
	 /** 
	  * 选择归属组织 
	  */ 
	 function selectOrgnize() 
	 { 
	 	var dbformStaff = getDBFormStaff();  
	 	var url = "<%=request.getContextPath()%>/secframe/orgmodel/operator/OrgRelate.jsp";
	 	var retVal = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:no;dialogHeight:450px;dialogWidth:300px");
		if(retVal != null)
		{
			dbformStaff.setValue("ORGANIZE_ID", retVal.value);
			// 显示组织名称
			document.getElementById("orgName").value = retVal.text;
			// 重置默认岗位ID与名称
			document.getElementById("stationId").value = "";
			document.getElementById("stationName").value = "";
		}
	 }
	 /**
	  * 选择默认岗位
	  */
	 function selectStation()
	 {
		var dbformStaff = getDBFormStaff(); 
		var curOrgId = dbformStaff.getValue("ORGANIZE_ID");
		if(curOrgId != null && curOrgId != "")
		{
		 	var url = "<%=request.getContextPath()%>/secframe/orgmodel/operator/StationRelate.jsp";
		 	var retVal = window.showModalDialog(url, curOrgId, "scroll:no;resizable:no;help:no;status:no;dialogHeight:410px;dialogWidth:500px");
			if(retVal != null)
			{
				if(retVal != null)
				{
					document.getElementById("stationId").value = retVal.id;
					// 显示岗位名称
					document.getElementById("stationName").value = retVal.name;
				}
				else
				{
					alert(g_I18NMessage("secframe_operator", "sec_operator_station_notselect"));
				}
			}
		}
		else
		{
			alert(g_I18NMessage("secframe_operator", "sec_operator_organize_select_required"));
		}
	 }

	 /**
	  * 刷新默认岗位信息
	  */
	 function refreshBaseStation(operId)
	 {
 		var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOperatorAction?action=getBaseStation&operId="+operId);
 		var result = msg.getValueByName("retVal");
 		if(result == 0 )
 		{
			var retMsg = msg.getValueByName("retMsg");
 			if(retMsg == null)
 			{
 				alert(g_I18NMessage("secframe_operator", "sec_operator_defaultstation_miss"));
 			}
 			else
 			{
 				alert(retMsg);
 			}
		}
		else
		{	
			var name = msg.getValueByName("name");
			document.getElementById("stationId").value = msg.getValueByName("id");
			document.getElementById("stationName").value = (name == null ? "" : name);
		}  	 	
	 }
	/**
	 * 保存操作员与员工信息
	 */
	function saveOperatorAndStaff()
	{
		// 验证操作员与员工信息
		var verResult = verifyOperatorStaff();
		if(verResult == 0)
		{
			return;
		}
		// 保存
		var msg = null;
		var stId = document.getElementById("stationId").value;
		if(stId == null || stId == "" || stId < 0)
		{
			alert(g_I18NMessage("secframe_operator", "sec_operator_defaultstation_required"));
			return;
		}
		var dbformStaff = getDBFormStaff();
	    var dbformOperator = getDBFormOperator();
		var param = "&stId="+stId+"&operId="+dbformOperator.getValue("OPERATOR_ID");
	    // 只保存上岗信息	  
	    if(dbformStaff.toXmlString(true) == "" && dbformOperator.toXmlString(true) == "")
	    {
	    	msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOperatorAction?action=saveOpStation"+param);
	    }
	    else
	    {   dbformOperator.setValue("CHG_PASSWD_FLAG", 0);
	    	var list = new Array();
		    list.push(dbformStaff);
		    list.push(dbformOperator);
		    msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOperatorAction?action=saveOperatorAndStaff"+param, list);
	    }
	    if(msg != null)
	    {
		    var retVal = msg.getValueByName("retVal");
		    if( retVal == "1" )
		    {
		    	//连带保存权限默认的角色
		    	var param = "code="+dbformOperator.getValue("CODE")+"&stId="+stId;
			    PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecAuthorAction4Default?action=getOpStationId&"+param);
		      	//end
			    alert(g_I18NMessage("secframe_operator", "sec_operator_saveok"));
		        // 初始化Form与按钮的状态
			    buttonInit(-1);
			    dbformOperator.setEditSts(false);
			    dbformStaff.setEditSts(false);
			    refreshStaff();
			    var curOrgId = getCurrentOrgId();
			    init(0, -1, curOrgId, "");
		    }
		    else
		    {
		    	alert(msg.getValueByName("retMsg"));
		    }
	    }
	}
	
	function diableOrg()
	{
		g_AIButtonManager.get("byorgbtn").setDisabled(true);
	}

	var flag = false;
	function moreContent(){		
		if(!flag){
			document.getElementById("extendCont").style.display="block";
			g_AIButtonManager.get("btnMore").setText(g_I18NMessage("secframe_operator", "hide_info"));
			flag = true;
		}else{
			document.getElementById("extendCont").style.display="none";
			g_AIButtonManager.get("btnMore").setText(g_I18NMessage("secframe_operator", "more_info"));
			flag = false;
		}		
	}
</script>
</html>