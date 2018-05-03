<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<%@page import="com.ai.secframe.common.service.interfaces.ISecframeFSV"%>
<%@page import="com.ai.secframe.orgmodel.service.interfaces.ISecOrganizeSV"%>
<%@page import="com.ai.appframe2.service.ServiceFactory"%>
<%@page import="com.ai.secframe.orgmodel.ivalues.IQBOSecOrgStaffOperValue"%>
<%@page import="com.ai.secframe.orgmodel.ivalues.IBOSecOrganizeValue"%>
<%
  long operId = SessionManager.getUser().getID();
  ISecframeFSV secFrameFSV = (ISecframeFSV)ServiceFactory.getService(ISecframeFSV.class);
  //�жϲ���Ա�Ƿ���Ȩ�ޣ�����Ȩ�ޣ������ѡ���������е�ֵ������Ȩ�ޣ���ֻ���Բ�ѯ����֯�����ݣ������򲻿ɱ༭
  boolean flag = secFrameFSV.checkEntityPermission(operId,266,46999451);
  
  //��ȡ����Ա���ڵ���֯
  IQBOSecOrgStaffOperValue value = secFrameFSV.getOperQBOByOperId(operId);
  long organizeId = value.getOrganizeId();
  //��ȡ����Ա���ڵĵ���
  ISecOrganizeSV secOrganizeSV = (ISecOrganizeSV)ServiceFactory.getService(ISecOrganizeSV.class);
  IBOSecOrganizeValue secOrganize = secOrganizeSV.getSecOrganizeById(organizeId);
  String districtId = secOrganize.getDistrictId();
 %>
<html>
<head>
<title><i18n:message key="sec.role.manager" res="i18n.secframe_resource"/></title>
</head>
<body onload="init()">
       <ai:dbform formid="secRoleSearchForm"
					setname="com.ai.secframe.sysmgr.web.SETSecRole"
					datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecRoleSV"
					implservice_querymethod="querySecRole" 
					initial="false" editable="true">
            <ai:contractframe id="" contenttype="table" title="sec.role.querycondition" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>		
            <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
              <tr>
                <td class="td_font"><i18n:message key="sec.role.name" res="i18n.secframe_resource"/></td>
                <td><ai:dbformfield formid="secRoleSearchForm" fieldname="ROLE_NAME"
								width="150" height="20"/>
                <td class="td_font"><i18n:message key="sec.role.type" res="i18n.secframe_resource"/></td>
                <td><ai:dbformfield formid="secRoleSearchForm" fieldname="ROLE_TYPE"
								width="150" height="20"/></td>
                <td class="td_font"><i18n:message key="sec.role.district" res="i18n.secframe_resource"/></td>
                <td>
                <ai:dbformfield formid="secRoleSearchForm" fieldname="REGION_CODE" visible="false"/>
				<ai:listbox id="lbxRegionCode" ds="com.ai.secframe.sysmgr.web.DSSecRoleRegionCode" width="150"
				    initial="true" parameters="codeType=50001" nulltext="" nullid=""/>
				</td>
				<td><ai:button text="sec.role.query" i18nRes="i18n.secframe_resource" id="searchBtn" onclick="search()"/></td>				
              </tr>
            </table>
            </ai:contractframe>
            </ai:dbform>
        
        <ai:contractframe id="" contenttype="table" title="sec.role.queryresult" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>
           <ai:table tableid="secRoleSearchResultTable"
							setname="com.ai.secframe.sysmgr.web.SETSecRole"
							initial="false" multiselect="false" editable="false"
							tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
							implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecRoleSV"
							implservice_querymethod="querySecRole"  pagesize="10"
							implservice_countmethod="querySecRoleCount" width="100%"	
							height="220" needrefresh="true">
				  <ai:col fieldname="ROLE_ID" width="25%" />				
	              <ai:col fieldname="ROLE_NAME" width="25%" />
				  <ai:col fieldname="ROLE_TYPE" width="25%"/>
				  <ai:col fieldname="REGION_CODE" width="25%" />					
            </ai:table>
        </ai:contractframe>
                  
        <p><font color="red">
       &nbsp;&nbsp;&nbsp;&nbsp; �˴����ǶԲ�ѯ�����е�������������������˿��ƣ���Ȩ�޵Ĳ���Ա��������ѡ���������ȡֵ��û��Ȩ�޵Ĳ���Աֻ���Բ�ѯ�����е����ݣ�����������Ĭ��ȡֵ�����ɱ༭��
       </font></p>
       <p><font color="blue">
		&nbsp;&nbsp;&nbsp;&nbsp; ��ʹ��renll2��renll3��¼ϵͳ���в鿴��
		</font></p>
<script type="text/javascript">
var condition = "";

function init(){
   if(<%=flag%> == false){
      msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOrganizeAction?"+
				"action=getDisInfo&dis_id="+<%=districtId%>);
	  result = msg.getValueByName("retVal"); 
	  var regionId = result.split("|")[2];
	  var districtName = result.split("|")[1];
      var lbxRegionCode = g_getListBox("lbxRegionCode");
      lbxRegionCode.delAllItem();
      lbxRegionCode.addItem(regionId,districtName);
      lbxRegionCode.setDisabled(true);
   }
}

function search()
{
   var secRoleSearchForm = g_FormRowSetManager.get("secRoleSearchForm");
   var secRoleSearchResultTable = g_TableRowSetManager.get("secRoleSearchResultTable");	
   var roleName = secRoleSearchForm.getValue("ROLE_NAME");
   var roleType = secRoleSearchForm.getValue("ROLE_TYPE");
   
   if("<%=flag%>" == false){
      secRoleSearchForm.setValue("REGION_CODE",<%=organizeId%>);
   }else{
       var lbxRegionCode = g_getListBox("lbxRegionCode").getID();
       var selRegionCode = lbxRegionCode.split(",");
	   secRoleSearchForm.setValue("REGION_CODE",selRegionCode[0]);
   }
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
		secRoleSearchResultTable.refresh(cond);
		return ;
	}
	condition = cond;
    secRoleSearchResultTable.refresh(cond);
}	

</script>
</body>
</html>