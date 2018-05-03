<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<html>
	<head>
		<title><i18n:message key="sec.roleselect.rulemanage" res="i18n.secframe_resource"/></title>
	</head>
	<body>
	<ai:contractframe id="" contenttype="table"
						title="sec.roleselect.rulequery" i18nRes="i18n.secframe_resource"
						width="100%" allowcontract="false" frameclosed="false">
						<ai:contractitem />
								<ai:dbform formid="secRoleSearchForm"
									setname="com.ai.secframe.sysmgr.web.SETSecRole"
									datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
									implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecRoleSV"
									implservice_querymethod="querySecRole" initial="false"
									editable="true">
									<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
										<tr>
											<td class="td_font">
												<i18n:message key="sec.roleselect.rulename" res="i18n.secframe_resource"/>
											</td>
											<td>
												<ai:dbformfield formid="secRoleSearchForm"
													fieldname="ROLE_NAME" width="150"
													editable="true" visible="true" /></td>
											<td class="td_font">
												<i18n:message key="sec.roleselect.rulestyle" res="i18n.secframe_resource"/>
											</td>
											<td>
												<ai:dbformfield formid="secRoleSearchForm"
													fieldname="ROLE_TYPE" width="150"
													editable="true" visible="true" />
											</td>
											<td class="td_font">
												<i18n:message key="sec.roleselect.belongcity" res="i18n.secframe_resource"/>
											</td>
											<td>
												<ai:dbformfield formid="secRoleSearchForm"
													fieldname="REGION_CODE" width="150"
													editable="true" visible="true" />
											</td>
											<td class="td_button"><ai:button text="sec.query" i18nRes="i18n.secframe_resource" id="searchBtn" onclick="search()" /></td>
										</tr>
									</table>
								</ai:dbform>
								
					</ai:contractframe>
					
					<ai:contractframe id="" contenttype="table"
						title="sec.roleselect.resultlist" i18nRes="i18n.secframe_resource"
						width="100%" allowcontract="false" frameclosed="false">
						<ai:contractitem />
								<ai:table tableid="secRoleSearchResultTable"
									setname="com.ai.secframe.sysmgr.web.SETSecRole" initial="false"
									multiselect="true" editable="false"
									tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
									implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecRoleSV"
									implservice_querymethod="querySecRole" pagesize="10"
									implservice_countmethod="querySecRoleCount" width="100%"
									ondbclick="loadRoleDetail" height="220" needrefresh="true">
									<ai:col fieldname="ROLE_ID" width="25%" editable="false"
										visible="true" />
									<ai:col fieldname="ROLE_NAME" width="25%" editable="false"
										visible="true" />
									<ai:col fieldname="ROLE_TYPE" width="25%" editable="false"
										visible="true" />
									<ai:col fieldname="REGION_CODE" width="25%" editable="false"
										visible="true" />
								</ai:table>
					</ai:contractframe>
			<div class="area_button">
				<ai:button text="sec.confirm" i18nRes="i18n.secframe_resource" onclick="onRole()"/>&nbsp;&nbsp;
    			<ai:button text="sec.cancel" i18nRes="i18n.secframe_resource" onclick="cancel()"/>
			</div>
		<script type="text/javascript">
var condition = "";

function search()
{
   var secRoleSearchForm = g_FormRowSetManager.get("secRoleSearchForm");
   var secRoleSearchResultTable = g_TableRowSetManager.get("secRoleSearchResultTable");	
   var roleName = secRoleSearchForm.getValue("ROLE_NAME");
   var roleType = secRoleSearchForm.getValue("ROLE_TYPE");
   var regionCode = secRoleSearchForm.getValue("REGION_CODE");
   var roleNameCond = "";
   var roleTypeCond = "";
   var regionCodeCond="";
   var flag = false;
   if(roleName!=null&&roleName!="")
   {
	    roleNameCond = " ROLE_NAME LIKE '"+roleName+"%' ";
   }
   if(roleType!=null&&roleType!="")
   {
	    roleTypeCond = " ROLE_TYPE LIKE '"+roleType+"%' ";
   }
   if(regionCode!=null&&regionCode!="")
   {
	    regionCodeCond = " REGION_CODE LIKE '"+regionCode+"%' ";
   }
   //平凑查询条件
   var cond = "";
   if(roleNameCond!="")
   {
	   cond = cond + roleNameCond;
			flag=true;
   }
		
   if(roleTypeCond!="")
   {
	   if(flag)
	   {
		  cond = cond +" AND "+ roleTypeCond;
	   }
	   else 
	   {
		  cond = cond +  roleTypeCond;
		  flag = true;
	   }
   }
   
   if(regionCodeCond!="")
   {
	    if(flag)
	    {
			cond = cond +" AND "+ regionCodeCond;
		}
		else 
		{
			cond = cond +  regionCodeCond;
		}
	}
		
	if(cond=="")
	{
		alert(g_I18NMessage("sec_roleselect", "sec_roleselect_input"));
		return ;
	}
	condition = cond;
    secRoleSearchResultTable.refresh(cond);
}	

//加载角色详细信息
function loadRoleDetail()
{
    document.getElementById("updateBtn").disabled = false;
    document.getElementById("addBtn").disabled = false;
    document.getElementById("saveBtn").disabled = false;
    document.getElementById("delBtn").disabled = false;
    var secRoleSearchResultTable = g_TableRowSetManager.get("secRoleSearchResultTable");	
    var roleDetailForm = g_FormRowSetManager.get("secRoleDetailForm");
    var selRoleId = secRoleSearchResultTable.getValue(secRoleSearchResultTable.getRow(),"ROLE_ID");
    
    if (null == selRoleId || selRoleId =="")
    {
       alert(g_I18NMessage("sec_roleselect", "sec_roleselect_select"));
       return;
    }
    var cond = "ROLE_ID = " + selRoleId;
    roleDetailForm.refresh(cond);   
}

//更新角色
function updateRole()
{
    document.getElementById("addBtn").disabled = true;
    document.getElementById("saveBtn").disabled = false;
    document.getElementById("delBtn").disabled = true;
    var roleDetailForm = g_FormRowSetManager.get("secRoleDetailForm");
    roleDetailForm.setColEditSts("ROLE_NAME",true);
    roleDetailForm.setColEditSts("ROLE_TYPE",true);
    roleDetailForm.setColEditSts("REGION_CODE",true);
    roleDetailForm.setColEditSts("DOMAIN_ID",true);
}

//保存角色
function saveRole()
{
    // 保存
	var list = new Array();
	var roleDetailForm = g_FormRowSetManager.get("secRoleDetailForm");
	if(roleDetailForm.toXmlString(true) == "")
	    {
	    	alert(g_I18NMessage("sec_roleselect", "sec_roleselect_noupdate"));
	    	return;
	    }
	list.push(roleDetailForm);
	
	var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecRoleAction?action=saveRole", list);
	var retVal = msg.getValueByName("retVal");
	if( retVal == "0" )
	{
	   alert(g_I18NMessage("sec_roleselect", "sec_roleselect_save"));
	   roleDetailForm.setEditSts(false);
	   roleDetailForm.refresh("ROLE_ID = -1" );
	   g_TableRowSetManager.get("secRoleSearchResultTable").refresh(condition);
	   // 初始化Form与按钮的状态
	   //buttonInit(-1);
	   //   dbformOperator.setEditSts(false);
	   //    dbformStaff.setEditSts(false);
		//    window.parent.refreshStaff();
		//    init(0, parent.curOrgId);
	}
    else
	{
	   alert(msg.getValueByName("retMsg"));
	}
}

//新增角色
function addRole()
{
    document.getElementById("updateBtn").disabled = true;
    document.getElementById("addBtn").disabled = true;
    document.getElementById("saveBtn").disabled = false;
    document.getElementById("delBtn").disabled = true;
    var roleDetailForm = g_FormRowSetManager.get("secRoleDetailForm");
    roleDetailForm.setEditSts(true);
    roleDetailForm.setValue("ROLE_ID","-1");
    roleDetailForm.setValue("ROLE_NAME","");
    roleDetailForm.setValue("ROLE_TYPE","");
    roleDetailForm.setValue("REGION_CODE","");
    roleDetailForm.setValue("DOMAIN_ID","");
}

/**
	 * 
	 */
	function onRole()
	{
		var secRoleSearchResultTable = g_TableRowSetManager.get("secRoleSearchResultTable");	
		var selRows = secRoleSearchResultTable.getSelectedRows();
   		var stIdStr = "";
   		if(selRows != null && selRows.length > 0)
	    {
	   		for(var i=0; i < selRows.length; i++)
	   		{
	   			var selStId = secRoleSearchResultTable.getValue(selRows[i], "ROLE_ID");
	   			stIdStr = stIdStr + selStId+",";
	   		}
	    
	    }
	    var list = new Array();
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

</script>
	</body>
</html>