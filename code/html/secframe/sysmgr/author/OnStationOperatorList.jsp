<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title></title>
<%
	long orgId = SessionManager.getUser().getOrgId();
%>
</head>
<body>
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
						setname="com.ai.secframe.orgmodel.web.SETSecOnStationOperator"
						initial="false" multiselect="false" editable="false"
						tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
						parametersname="com.ai.secframe.sysmgr.web.SecAuthorAction"
						onrowchange="initOpStation" pagesize="4"
						width="100%" height="100" needrefresh="true" footdisplay="true">
				  <ai:col fieldname="OPERATOR_ID" visible="false" />			
	              <ai:col fieldname="CODE" width="20%" editable="true" visible="true" />
	              <ai:col fieldname="STAFF_NAME" width="30%" editable="true" visible="true"/>
	              <ai:col fieldname="STATE" width="20%" editable="true" visible="true"/>
	              <ai:col fieldname="STAFF_ID" editable="true" visible="false"/>
	              <ai:col fieldname="ORG_CODE" editable="true" visible="false"/>
	              <ai:col fieldname="ORGANIZE_NAME" width="30%" editable="true" visible="true"/>
	              <ai:col fieldname="ORGANIZE_ID" editable="true" visible="false"/>
	            </ai:table>
			</ai:contractframe>
			<%
          		String isBatchAuthor = request.getParameter("isBatchAuthor");
          		String queryFunction = com.ai.appframe2.web.HttpUtil.getParameter(request, "queryFunction");
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
          	 		<%@include file="/secframe/sysmgr/author/AuthorManager.jsp"%>  
          	 <%
          	 	} else if (queryFunction.trim().equals("Y")) {
          	 %>	
          	 		<%@include file="/secframe/sysmgr/secfunction/FunctionQuery.jsp"%>
          	 <%
          	 	}
          	 %>	           	      	 
		</td>
	</tr>
</table>
<script type="text/javascript">
	var organizeId = -1;
	var curOrgId = -1;
	
	function getDBGridOper()
	{
		return g_TableRowSetManager.get("dbTableOperator");
	}
	/**
	 * 点击组织节点显示该组织所包含的操作员
	 */
	function treeNodeClick(organizeId,organizeName,treeUserObj,treeNodeType)
	{
		var dbgridOper = getDBGridOper();
		if(organizeId == -1)
		{
			return;
		}
		curOrgId = organizeId;
		dbgridOper.refresh("refresh","organizeId="+organizeId);
		initial(0, -1, organizeId);
	}
	/**
	 * 初始化上岗页面
	 */
	function initOpStation()
	{
		var dbgridOper = getDBGridOper();
		var operId = dbgridOper.getValue(dbgridOper.getRow(),"OPERATOR_ID");
		curOrgId = dbgridOper.getValue(dbgridOper.getRow(),"ORGANIZE_ID");
		initial(operId, -1, curOrgId);
	}
	/**
	 * 根据组织查询
	 */
	function refreshStaff()
	{	
		var dbgridOper = getDBGridOper();
		dbgridOper.refresh("refresh","organizeId="+curOrgId);
	}
	/**
	 * 获取组织树
	 */
	function getOrgTree(){
		var dbTree = g_DBTreeNewManager.get("orgTree");
		return dbTree;
	}
	/**
	 * 查询操作员与员工信息
	 */
	function searchOperatorStaff(){
		var dbgridOper = getDBGridOper(); 
		var name = document.getElementById("name").value;
		var code = document.getElementById("code").value;
		var bill = document.getElementById("billId").value;
		
		var nameCond = "";
		var codeCond = "";
		var billCond="";
		
		var flag = false;
		
		if(name != null && name != "")
		{
			name = encodeURI(name); 
			name = encodeURI(name);
			nameCond = "name="+name;
		}
		if(code != null && code != "")
		{
			codeCond = "code="+code;
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
		
		if(codeCond != "")
		{
			if(flag)
			{
				cond = cond +"&"+ codeCond;
			}
			else 
			{
				cond = cond +  codeCond;
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
		dbgridOper.refresh("refresh",cond);
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
</body>
</html>