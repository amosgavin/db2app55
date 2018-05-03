<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/i18n/secframe_js_resource_<%=com.ai.appframe2.util.locale.AppframeLocaleFactory.getCurrentLocale().toString()%>.js"></script>

<html>
<head>
<title>
	<i18n:message key="sec.operator.select" res="i18n.secframe_resource"/>
</title>
</head>
<body onload="initSearchType()">
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
    <table>
        <tr>
          <td class="tdhead">
          	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="Tl_Header_table">
              <tr>
                <td width="40" style="height: 20px">&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/image/sysmgr/home.gif" width="12" height="12" /></td>
                <td style="height: 20px"><i18n:message key="sec.operator.select" res="i18n.secframe_resource"/></td>
                <td align="right" style="height: 20px">
                	<ai:button id="byorgbtn" text="sec.operator.query.org" i18nRes="i18n.secframe_resource" onclick="QueryByOrg()"/>
                  	<ai:button id="bycondbtn" text="sec.operator.query.condition" i18nRes="i18n.secframe_resource" onclick="QueryByCond()"/>
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td align="left" height="220" valign="top"><div id="bycond" style="display: none;">
              <table align="center" border="1"  cellpadding="0" cellspacing="0">                
                <tr>
                  <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="100"><i18n:message key="sec.staff.name" res="i18n.secframe_resource"/></td>
                        <td width="1"></td>
                        <td colspan="5"><input value="" type="text" id="name"/>
                        </td>
                      </tr>
                      <tr>
                        <td width="100"><i18n:message key="sec.operator.code" res="i18n.secframe_resource"/></td>
                        <td width="1"></td>
                        <td colspan="5"><input type="text"  value="" id="code"/>
                        </td>
                      </tr>
                    </table>
                <tr >
                  <td align="center" valign="middle">
                  		<ai:button id="searchOperBtn" text="sec.query" i18nRes="i18n.secframe_resource" onclick="searchOperatorStaff()"/>
                  </td>
                <tr>
              </table>
            </div>
            <div id="byorg">
              <ai:dbtree_new id="orgTree" datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel" 
					multiselect="false" height="220" width="100%" ishaveline="true" 
					onselect="treeNodeClick"/>
            </div></td>
        </tr>
        <tr>
          <td class="tdhead">
          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="Tl_Header_table">
              <tr>
                <td width="40">&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/image/sysmgr/home.gif" width="12" height="12" /></td>
                <td style="height: 20px"><i18n:message key="sec.operator.list" res="i18n.secframe_resource"/></td>
                <td align="right"></td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td align="center">
          	 <ai:table tableid="dbGridOperator"
						setname="com.ai.secframe.orgmodel.web.SETSecOrgStaffOper"
						initial="false" multiselect="false" editable="false"
						tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
						parametersname="com.ai.secframe.orgmodel.web.SecOperatorAction"
						ondbclick="selectOperator" pagesize="10"
						width="100%" height="220" needrefresh="true" footdisplay="true">
			  <ai:col fieldname="OPERATOR_ID" visible="false" />			
              <ai:col fieldname="CODE" width="15%" editable="true" visible="true" />
              <ai:col fieldname="STAFF_NAME" width="20%" editable="true" visible="true"/>
              <ai:col fieldname="OPSTATE" width="15%" editable="true" visible="true"/>
              <ai:col fieldname="STAFF_ID" editable="true" visible="false"/>
              <ai:col fieldname="ORG_CODE" width="15%" editable="true" visible="true"/>
              <ai:col fieldname="ORGANIZE_NAME" width="20%" editable="true" visible="true"/>
              <ai:col fieldname="ORGANIZE_ID" width="15%" editable="true" visible="true"/>
            </ai:table>
          </td>
        </tr>
      </table>
     </td>
  </tr>
</table>
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
		var operId = dbGridOper.getValue(dbGridOper.getRow(),"OPERATOR_ID");
		var name = dbGridOper.getValue(dbGridOper.getRow(),"STAFF_NAME");
		var operator = new Object();
		operator.value = operId;
		operator.text = name;
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
	</script>
</body>
</html>