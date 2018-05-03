<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<script language="JavaScript"
	src="<%=request.getContextPath()%>/jsv2/i18n/secframe_js_resource_<%=com.ai.appframe2.util.locale.AppframeLocaleFactory
							.getCurrentLocale().toString()%>.js"></script>

<html>
	<head>
		<title><i18n:message key="sec.operator.select"
				res="i18n.secframe_resource" /></title>
	</head>
	<body onload="initSearchType()">
		<ai:contractframe id="orgtype" contenttype="table"
			title="sec.operator.select" i18nRes="i18n.secframe_resource"
			width="100%" allowcontract="false" frameclosed="false">
			<ai:contractitem>
				<div class="t-bot-mc-button">
					<ai:button id="byorgbtn" text="sec.operator.query.org"
						i18nRes="i18n.secframe_resource" onclick="QueryByOrg()" />
					<ai:button id="bycondbtn" text="sec.operator.query.condition"
						i18nRes="i18n.secframe_resource" onclick="QueryByCond()" />
				</div>
			</ai:contractitem>
			<table width="99%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="left" height="230" valign="top">
						<div id="bycond" style="display: none;">
							<table width="98%" align="center" border="0" cellpadding="1"
								cellspacing="2">
								<tr>
									<td class="td_font">
										<i18n:message key="sec.staff.name"
											res="i18n.secframe_resource" />
									</td>

									<td>
										<input value="" type="text" id="name" style="width: 150px;" />
									</td>
								</tr>
								<tr>
									<td class="td_font">
										<i18n:message key="sec.operator.code"
											res="i18n.secframe_resource" />
									</td>
									<td>
										<input type="text" value="" id="code" style="width: 150px;" />
									</td>
								</tr>
							</table>
							<div class="area_button">
								<ai:button id="searchOperBtn" text="sec.query"
									i18nRes="i18n.secframe_resource"
									onclick="searchOperatorStaff()" />
							</div>
						</div>
						<div id="byorg">
							<table width="99%" align="center" border="0" cellpadding="0"
								cellspacing="0">
								<tr>
									<td>
										<ai:dbtree_new id="orgTree"
											datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel"
											multiselect="false" height="220" width="100%"
											ishaveline="true" onselect="treeNodeClick" />
									</td>
								</tr>
							</table>
						</div>
		</ai:contractframe>


		<ai:contractframe id="contractframe1" contenttype="table"
			title="sec.operator.list" i18nRes="i18n.secframe_resource"
			width="100%" allowcontract="false" frameclosed="false">
			<ai:contractitem />
			<ai:table tableid="dbGridOperator"
				setname="com.ai.secframe.orgmodel.web.SETSecOrgStaffOper"
				initial="false" multiselect="false" editable="false"
				tablemodel="com.ai.appframe2.web.tag.ActionDataModel"
				parametersname="com.ai.secframe.orgmodel.web.SecOperatorAction"
				ondbclick="selectOperator" pagesize="10" width="100%" height="195"
				needrefresh="true" footdisplay="true">
				<ai:col fieldname="OPERATOR_ID" visible="false" />
				<ai:col fieldname="CODE" width="20%" editable="true" visible="true" />
				<ai:col fieldname="STAFF_NAME" width="25%" editable="true"
					visible="true" />
				<ai:col fieldname="OPSTATE" width="15%" editable="true"
					visible="true" />
				<ai:col fieldname="STAFF_ID" editable="true" visible="false" />
				<ai:col fieldname="ORGANIZE_NAME" width="25%" editable="true"
					visible="true" />
				<ai:col fieldname="ORGANIZE_ID" width="20%" editable="true"
					visible="true" />
			</ai:table>
		</ai:contractframe>
		<div class="area_button">
			<ai:button text="orgrelat.cancel" i18nRes="i18n.secframe_resource"
				id="cancel" onclick="cancel()" />
		</div>
	</body>
	<script type="text/javascript">
	var curOrgId = "";
	/**
	 * 获取操作员Table
	 */
	function getDBGridOper()
	{
		return g_TableRowSetManager.get("dbGridOperator");
	}
	/**
	 * 点击组织节点显示该组织所包含的操作员
	 */
	function treeNodeClick()
	{
		var orgTree = g_DBTreeNewManager.get("orgTree");
		var curNode = orgTree.getCurNodeInfo();
		var organizeId = curNode.value;
		var organizeName = curNode.text;
		var dbGridOper = getDBGridOper();
		curOrgId=organizeId;
		if(organizeId == -1)
		{
			return;
		}
		dbGridOper.refresh("refresh","organizeId="+organizeId);
	}
	/**
	 * 根据组织查询
	 */
	function refreshStaff()
	{	
		var orgTree = g_DBTreeNewManager.get("orgTree");
		var curNode = orgTree.getCurNodeInfo();
		var organizeId = curNode.value;
		var dbGridOper = getDBGridOper();
		dbGridOper.refresh("refresh","organizeId="+organizeId);
	}
	/**
	 * 根据选中的操作员初始化操作员/岗位信息区
	 */
	function selectOperator(){
		var dbGridOper = getDBGridOper();
		var opId = dbGridOper.getValue(dbGridOper.getRow(),"OPERATOR_ID");
		var opName = dbGridOper.getValue(dbGridOper.getRow(),"STAFF_NAME");
		var opCode=dbGridOper.getValue(dbGridOper.getRow(),"CODE");
		var orgId=dbGridOper.getValue(dbGridOper.getRow(),"ORGANIZE_ID");
		var orgName=dbGridOper.getValue(dbGridOper.getRow(),"ORGANIZE_NAME");
		var operator = new Operator(opId,opName,opCode,orgId,orgName);
		window.returnValue = operator;
		window.close();
	}
	
	/**
	 * 查询操作员与员工信息
	 */
	function searchOperatorStaff(){
		var dbGridOper = getDBGridOper(); 
		var name = document.getElementById("name").value;
		var code = document.getElementById("code").value;
		var bill = "";
		
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
		dbGridOper.refresh("refresh",cond);
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
	
	function initSearchType()
	{
		g_AIButtonManager.get("byorgbtn").setDisabled(true);
	}
	/**
	*	操作员信息定义 add by liyh
	*/
	function Operator(opId,opName,opCode,orgId,orgName){
		this.opId = opId;
		this.opName = opName;
		this.opCode = opCode;
		this.orgId = orgId;
		this.orgName = orgName;
	}
	
	function cancel()
	{	
		window.self.close();
	}
	
	</script>

</html>