<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title><i18n:message key="staffselect.selstaff" res="i18n.secframe_resource"/></title>
  </head>
  <body>

         	<ai:contractframe id="contractframe2" contenttype="table" title="staffselect.staffsel" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
	         <ai:contractitem>
                <div class="t-bot-mc-button">
					<ai:button id="byorgbtn"  text="staffselect.org" i18nRes="i18n.secframe_resource"  onclick="QueryByOrg()"/>
                  	<ai:button id="bycondbtn" text="staffselect.condition" i18nRes="i18n.secframe_resource"  onclick="QueryByCond()"/>
				</div>
				</ai:contractitem>
          	<table width="99%" border="0" cellpadding="0" cellspacing="0">     
        <tr>
          <td align="left" height="230" valign="top">
          <div id="bycond" style="display: none;">
                  <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                      <tr>
                        <td class="td_font"><i18n:message key="staffselect.name" res="i18n.secframe_resource"/></td>
                        <td><input value="" type="text" id="name" class="input" style="width:150px;"/>
                        </td>
                      </tr>
                      <tr>
                        <td class="td_font"><i18n:message key="staffselect.email" res="i18n.secframe_resource"/></td>
                        <td><input type="text"  value="" id="email" class="input" style="width:150px;"/>
                        </td>
                      </tr>
                      <tr>
                        <td class="td_font"><i18n:message key="staffselect.mobile" res="i18n.secframe_resource"/></td>
                        <td><input type="text"  value="" id="billId" class="input" style="width:150px;"/></td>
                      </tr>
                    </table>
                  <div class="area_button">
                  <ai:button text="staffselect.search" i18nRes="i18n.secframe_resource" id="searchOperBtn" onclick="searchStaff()"/>
                  </div>
            </div>
            <div id="byorg" >
            <table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
	              <ai:dbtree_new id="orgStaffTree" datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel" 
						multiselect="false" height="230" width="100%" ishaveline="true" 
						onselect="orgTreeNodeClick"/>
								</td>
							</tr>
						</table>
			</div>
			</table>
          </ai:contractframe> 
	<ai:contractframe id="contractframe1" contenttype="table" title="staffselect.stafflist" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
	         <ai:contractitem/>
          	 <ai:table tableid="dbTableExistStaff"
						setname="com.ai.secframe.orgmodel.web.SETSecOrgStaff"
						tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
						parametersname="com.ai.secframe.orgmodel.web.SecOperatorAction"
						initial="false" multiselect="false" editable="false" pagesize="8"
						width="300" height="180" needrefresh="true" footdisplay="true"
						ondbclick="selectExistStaff">					
					  <ai:col fieldname="STAFF_ID" visible="false"/>	
					  <ai:col fieldname="STAFF_NAME" width="130" visible="true"/>
					  <ai:col fieldname="GENDER" width="80" visible="true"/>
					  <ai:col fieldname="BIRTHDAY" width="80" visible="true"/>
		              <ai:col fieldname="BILL_ID" width="90" visible="true" />
		              
		              <ai:col fieldname="ORGANIZE_NAME" width="120" visible="true"/>
		              <ai:col fieldname="ORG_CODE" width="80" visible="true"/>
		              <ai:col fieldname="EMAIL" width="80" visible="true"/>
            </ai:table> 
     </ai:contractframe> 
     <div class="area_button">
            <ai:button text="orgrelat.cancel" i18nRes="i18n.secframe_resource" id="cancel" onclick="cancel()"/>
     </div> 
  </body>
  <script type="text/javascript">
    function cancel()
	{	
		window.self.close();
	}
	
  	function getDbTableExistStaff()
	{
		return g_TableRowSetManager.get("dbTableExistStaff");
	}
	/**
	 * 点击组织节点显示该组织下的员工
	 */
	function orgTreeNodeClick(organizeId, organizeName, treeUserObj, treeNodeType)
	{
		var dbTableExistStaff = getDbTableExistStaff();
		if(organizeId == -1)
		{
			return;
		}
		// 显示员工列表
		dbTableExistStaff.refresh("refreshStaffByOrgOrCond","organizeId="+organizeId);
	}
	/**
	 * 选择已有的员工
	 */
	function selectExistStaff()
	{
		var dbTableExistStaff = getDbTableExistStaff();
		var selRows = dbTableExistStaff.getSelectedRows();
	    if(selRows != null && selRows.length > 0)
	    {
	   		var staffId = dbTableExistStaff.getValue(selRows[0], "STAFF_ID");
    		window.returnValue = staffId;
	    	window.self.close();
	    }
	}
	
	/**
	 * 查询操作员与员工信息
	 */
	function searchStaff(){
		var dbTableStaff = getDbTableExistStaff(); 
		var name = document.getElementById("name").value;
		var email = document.getElementById("email").value;
		var bill = document.getElementById("billId").value;
		
		var nameCond = "";
		var emailCond = "";
		var billCond="";
		
		var flag = false;
		
		if(name != null && name != "")
		{
			name = encodeURI(name); 
			name = encodeURI(name);
			nameCond = "name="+name;
		}
		if(email != null && email != "")
		{
			emailCond = "email="+email;
		}
		if(bill != null && bill != "")
		{
			billCond = "billId="+bill;
		}
		var cond = "";
		if(nameCond != "")
		{
			cond = cond + nameCond;
			flag = true;
		}
		
		if(emailCond != "")
		{
			if(flag)
			{
				cond = cond +"&"+ emailCond;
			}
			else 
			{
				cond = cond +  emailCond;
				flag = true;
			}
		}
		if(billCond != "")
		{
			if(flag)
			{
				cond = cond +"&"+ billCond;
			}
			else 
			{
				cond = cond +  billCond;
				flag = true;
			}
		}
		
		if(cond == "")
		{
			alert(g_I18NMessage("secframe_operator", "sec_operator_condition_empty"));
			return ;
		}
		dbTableStaff.refresh("refreshStaffByOrgOrCond",cond);
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
	g_AIButtonManager.get("byorgbtn").setDisabled(true);
  </script>
  
</html>
