<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="sec.role.manager" res="i18n.secframe_resource"/></title>
</head>
<body onload="initButton()">
<table width="100%"  border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td width="250" valign="top"><table width="100%" border="1" cellpadding="0" cellspacing="1" >
        <tr>
          <td ><table width="380" border="0" cellpadding="0" cellspacing="1" >
              <tr>
                <td width="40">&nbsp;&nbsp;<img src="../../images/circle.gif" width="12" height="12" /></td>
                <td><i18n:message key="sec.role.querycondition" res="i18n.secframe_resource"/></td>
                <td align="right"></td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td  align="left"><ai:dbform formid="secRoleSearchForm"
					setname="com.ai.secframe.sysmgr.web.SETSecRole"
					datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecRoleSV"
					implservice_querymethod="querySecRole" 
					initial="false" editable="true">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" height="">
              <tr>
                <td height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td width="100" ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td width="100" ><i18n:message key="sec.role.name" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td  colspan="5"><ai:dbformfield formid="secRoleSearchForm" fieldname="ROLE_NAME"
								width="150" height="20" editable="true" visible="true" />
              </tr>
              <tr>
                <td height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td width="100" ><i18n:message key="sec.role.type" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td  colspan="5"><ai:dbformfield formid="secRoleSearchForm" fieldname="ROLE_TYPE"
								width="150" height="20" editable="true" visible="true" /></td>
              </tr>
              <tr>
                <td height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td width="100" ><i18n:message key="sec.role.district" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td colspan="5"><ai:dbformfield formid="secRoleSearchForm" fieldname="REGION_CODE"
								width="150" height="20" editable="true" visible="true" /></td>
              </tr>
              <tr>
                <td height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
            </table>
            </ai:dbform><div id="buttonDiv"  align="center">
              <ai:button text="sec.role.query" i18nRes="i18n.secframe_resource" id="searchBtn" onclick="search()"/>
            </div></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="1">
        <tr>
          <td ><table width="380" border="0" cellpadding="0" cellspacing="0" >
              <tr>
                <td width="40">&nbsp;&nbsp;<img src="../../images/circle.gif" width="12" height="12" /></td>
                <td><i18n:message key="sec.role.queryresult" res="i18n.secframe_resource"/></td>
                <td align="right"></td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td  align="left"><ai:table tableid="secRoleSearchResultTable"
							setname="com.ai.secframe.sysmgr.web.SETSecRole"
							initial="false" multiselect="true" editable="false"
							tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
							implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecRoleSV"
							implservice_querymethod="querySecRole"  pagesize="100"
							implservice_countmethod="querySecRoleCount" width="380" ondbclick="loadRoleDetail"	
							height="350" needrefresh="true">
			  <ai:col fieldname="ROLE_ID" width="100" editable="false"
								visible="true" />				
              <ai:col fieldname="ROLE_NAME" width="100" editable="false"
								visible="true" />
			  <ai:col fieldname="ROLE_TYPE" width="100" editable="false"
								visible="true" />
			  <ai:col fieldname="REGION_CODE" width="100" editable="false"
								visible="true" />					
            </ai:table></td>
        </tr>
      </table></td>
      <td valign="top" width="80%"><table width="100%" border=0 cellpadding=0 cellspacing=0 id="mainTable">
        <tr>
          <td valign="top"  ><table width="100%" border="0" cellpadding="0" cellspacing="1" >
              <tr>
                <td class="tdhead"><table width="100%" border="0" cellpadding="0" cellspacing="0" >
                    <tr>
                      <td width="40">&nbsp;&nbsp;<img src="../../images/circle.gif" width="12" height="12" /></td>
                      <td><i18n:message key="sec.role.detail" res="i18n.secframe_resource"/></td>
                      <td align="right"><div id="buttonDiv"></div></td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td align="left" valign="top"><ai:dbform formid="secRoleDetailForm"
					setname="com.ai.secframe.sysmgr.web.SETSecRole"
					datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecRoleSV"
					implservice_querymethod="querySecRole" 
					initial="false" editable="false">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" height="">
                    <tr>
                      <td height="1" ></td>
                      <td width="1"></td>
                      <td ></td>
                      <td width="1"></td>
                      <td width="100" ></td>
                      <td width="1"></td>
                      <td ></td>
                    </tr>
                    <tr>
                      <td width="100" ><i18n:message key="sec.role.name" res="i18n.secframe_resource"/></td>
                      <td width="1"></td>
                      <td><ai:dbformfield formid="secRoleDetailForm" fieldname="ROLE_NAME"
								width="150" height="20" editable="false" visible="true" /><font color="red">*</font>
                    </tr>
                    <tr>
                      <td height="1" ></td>
                      <td width="1"></td>
                      <td ></td>
                      <td width="1"></td>
                      <td ></td>
                      <td width="1"></td>
                      <td ></td>
                    </tr>
                    <tr>
                      <td width="100" ><i18n:message key="sec.role.type" res="i18n.secframe_resource"/></td>
                      <td width="1"></td>
                      <td><ai:dbformfield formid="secRoleDetailForm" fieldname="ROLE_TYPE"
								width="150" height="20" editable="false" visible="true" /><font color="red">*</font>
                    </tr>
                    <tr>
                      <td height="1"></td>
                      <td width="1"></td>
                      <td></td>
                      <td width="1"></td>
                      <td></td>
                      <td width="1"></td>
                      <td></td>
                    </tr>
                    <tr>
                      <td width="100"><i18n:message key="sec.role.district" res="i18n.secframe_resource"/></td>
                      <td width="1"></td>
                      <td><ai:dbformfield formid="secRoleDetailForm" fieldname="REGION_CODE"
								width="150" height="20" editable="false" visible="true" /><font color="red">*</font>
                    </tr>
                    <tr>
                      <td height="1"></td>
                      <td width="1"></td>
                      <td></td>
                      <td width="1"></td>
                      <td></td>
                      <td width="1"></td>
                      <td></td>
                    </tr>
                    <tr>
                      <td width="100"><i18n:message key="sec.role.domain" res="i18n.secframe_resource"/></td>
                      <td width="1"></td>
                      <td><ai:dbformfield formid="secRoleDetailForm" fieldname="DOMAIN_ID"
								width="150" height="20" editable="false" visible="true" /><font color="red">*</font>
                    </tr>
                    <tr>
                      <td height="1" ></td>
                      <td width="1"></td>
                      <td ></td>
                      <td width="1"></td>
                      <td ></td>
                      <td width="1"></td>
                      <td ></td>
                    </tr>
                    <tr>
                      <td width="1"></td>
                      <td ><ai:dbformfield formid="secRoleDetailForm" fieldname="ROLE_ID"
								width="150" height="20" editable="false" visible="false" />
                    </tr>
                  </table>
                  </ai:dbform>
                  <div align="center">
                    <ai:button  text="sec.role.update" i18nRes="i18n.secframe_resource" id="updateBtn" onclick="updateRole()"/>
                    <ai:button  text="sec.role.add" i18nRes="i18n.secframe_resource" id="addBtn" onclick="addRole()"/>
                    <ai:button  text="sec.role.save" i18nRes="i18n.secframe_resource" id="saveBtn" onclick="saveRole()"/>
                    <ai:button  text="sec.role.del" i18nRes="i18n.secframe_resource" id="delBtn" onclick="delRole()"/>
                  <div>
                  </td>
              </tr>
            </table>
            </td>
        </tr>
      </table></td>
  </tr>
</table>
<script type="text/javascript">
var condition = "";
//��ʼ����ť
function initButton()
{
    document.getElementById("updateBtn").disabled = true;
    document.getElementById("addBtn").disabled = false;
    document.getElementById("saveBtn").disabled = true;
    document.getElementById("delBtn").disabled = true;
}

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
   //ƽ�ղ�ѯ����
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
	    //alert("�������ѯ����");
		alert(g_I18NMessage("secframe_role" , "sec_role_condition"));
		return ;
	}
	condition = cond;
    secRoleSearchResultTable.refresh(cond);
}	

//���ؽ�ɫ��ϸ��Ϣ
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
       //alert("�����б���ѡ��һ����ɫ��");
       alert(g_I18NMessage("secframe_role" , "sec_role_sel_one_role"));
       return;
    }
    var cond = "ROLE_ID = " + selRoleId;
    roleDetailForm.refresh(cond);   
}

//���½�ɫ
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

//�����ɫ
function saveRole()
{
    var roleDetailForm = g_FormRowSetManager.get("secRoleDetailForm");
    if (null == roleDetailForm.getValue("ROLE_NAME")||""==roleDetailForm.getValue("ROLE_NAME"))
    {
        //alert("��ɫ���Ʋ���Ϊ�գ�");
        alert(g_I18NMessage("secframe_role" , "sec_rolename_notnull"));
        return;
    }
    if (null == roleDetailForm.getValue("ROLE_TYPE")||""==roleDetailForm.getValue("ROLE_TYPE"))
    {
        //alert("��ɫ���Ͳ���Ϊ�գ�");
        alert(g_I18NMessage("secframe_role" , "sec_roletype_notnull"));
        return;
    }
    if (null == roleDetailForm.getValue("REGION_CODE")||""==roleDetailForm.getValue("REGION_CODE"))
    {
        //alert("��ɫ�������в���Ϊ�գ�");
        alert(g_I18NMessage("secframe_role" , "sec_roledistrict_notnull"));
        return;
    }
    if (null == roleDetailForm.getValue("DOMAIN_ID")||""==roleDetailForm.getValue("DOMAIN_ID"))
    {
        //alert("��ɫ��������Ϊ�գ�");
        alert(g_I18NMessage("secframe_role" , "sec_roledomain_notnull"));
        return;
    }
    // ����
	var list = new Array();
	if(roleDetailForm.toXmlString(true) == "")
	    {
	    	//alert('������δ�޸�,���豣��!');
	    	alert(g_I18NMessage("secframe_role" , "sec_role_nochange"));
	    	return;
	    }
	list.push(roleDetailForm);
	
	var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecRoleAction?action=saveRole", list);
	var retVal = msg.getValueByName("retVal");
	if( retVal == "0" )
	{
	   //alert("��ɫ��Ϣ����ɹ�!");
	   alert(g_I18NMessage("secframe_role" , "sec_role_save_ok"));
	   roleDetailForm.setEditSts(false);
	   document.getElementById("addBtn").disabled = false;
	   roleDetailForm.refresh("ROLE_ID = -1" );
	   g_TableRowSetManager.get("secRoleSearchResultTable").refresh(condition);
	}
    else
	{
	   alert(msg.getValueByName("msg"));
	   document.getElementById("addBtn").disabled = false;
	}
}

//������ɫ
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

//ɾ����ɫ
function delRole()
{
    var list = new Array();
    var roleDetailForm = g_FormRowSetManager.get("secRoleDetailForm");
    var delRoleId = roleDetailForm.getValue("ROLE_ID");
    list.push(roleDetailForm);
	var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecRoleAction?action=delRole&delRoleId="+delRoleId, list);
	var retVal = msg.getValueByName("retVal");
	if( retVal == "0" )
	{
	   //alert("��ɫ��Ϣɾ���ɹ�!");
	   alert(g_I18NMessage("secframe_role" , "sec_role_del_ok"));
	   roleDetailForm.setEditSts(false);
	   roleDetailForm.refresh("ROLE_ID = -1" );
	   g_TableRowSetManager.get("secRoleSearchResultTable").refresh(condition);
	}
    else
	{
	   alert(msg.getValueByName("retMsg"));
	}
    
}
</script>
</body>
</html>