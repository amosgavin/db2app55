<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="sec.role.manager" res="i18n.secframe_resource"/></title>
</head>
<body>
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
								width="150" height="20" editable="true" visible="true" />
                <td class="td_font"><i18n:message key="sec.role.type" res="i18n.secframe_resource"/></td>
                <td><ai:dbformfield formid="secRoleSearchForm" fieldname="ROLE_TYPE"
								width="150" height="20" editable="true" visible="true" /></td>
                <td class="td_font"><i18n:message key="sec.role.district" res="i18n.secframe_resource"/></td>
                <td><ai:dbformfield formid="secRoleSearchForm" fieldname="REGION_CODE"
								width="150" height="20" editable="true" visible="true" /></td>
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
							height="220" needrefresh="true"
							mo="com.ai.secframe.renlltest.moCheckTable" operator="moCheckTable" modealtype="mask">
				  <ai:col fieldname="ROLE_ID" width="25%"/>				
	              <ai:col fieldname="ROLE_NAME" width="25%"/>
				  <ai:col fieldname="ROLE_TYPE" width="25%"/>
				  <ai:col fieldname="REGION_CODE" width="25%"/>					
            </ai:table>
            </ai:contractframe>
            <p><font color="red">
             &nbsp;&nbsp;&nbsp;&nbsp; ������MO�п�����table���ĸ��ֶΣ�ʹ��֮���������Ա�и�MOȨ�ޣ���ô���ĸ��ֶζ�������ʾ������
            <br>&nbsp;&nbsp;&nbsp;&nbsp; �������Ա�����и�MO���ԣ���ҳ�����ʾ���Բ���XXX������ִ�в���Ȩ�ޡ���
            </font></p>
            <p><font color="blue">
            &nbsp;&nbsp;&nbsp;&nbsp; ��MO��Ȩʱ������Ϊһ����ɫ�����˶�ROLE_ID��ROLE_NAME�ɶ������޸ĵ�Ȩ�ޣ�Ϊ��һ����ɫ����ȫ���ֶοɶ������޸ĵ�Ȩ�ޡ�
            <br>&nbsp;&nbsp;&nbsp;&nbsp;��ʹ�þ���ǰ�߽�ɫ���û���¼ʱ��ֻ�ɿ���ROLE_ID��ROLE_NAME�ֶΣ�ʹ�þ��к��߽�ɫ���û���¼ʱ���ɿ���ȫ���ֶΡ�
			<br>&nbsp;&nbsp;&nbsp;&nbsp; ��ʹ��renll2��renll3��¼ϵͳ���в鿴�Աȡ�
			</font></p>
</body>
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
		//alert(g_I18NMessage("secframe_role" , "sec_role_condition"));
		secRoleSearchResultTable.refresh(cond);
		return ;
	}
	condition = cond;
    secRoleSearchResultTable.refresh(cond);
}	

</script>
</html>