<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<%@page import="com.ai.secframe.common.service.interfaces.ISecframeFSV"%>
<%@page import= "com.ai.appframe2.service.ServiceFactory"%>
<%
  long operId = SessionManager.getUser().getID();
  ISecframeFSV secFrameFSV = (ISecframeFSV)ServiceFactory.getService(ISecframeFSV.class);
  boolean flag = secFrameFSV.checkEntityPermission(operId,261,46999450);
 %>
<HTML>
<head>
<title><i18n:message key="sec.organize.orgmgr" res="i18n.secframe_resource"/></title>

</head>
<body>
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
  <tr>
    
    <td valign="top" align="right">
                  
					  <ai:contractframe id="" contenttype="table" title="sec.organize.orgbaseinfo" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
			  <ai:contractitem/>					
      <ai:dbform setname="com.ai.secframe.orgmodel.web.SETSecOrganize"
	     formid="partyRoleOrg_form"
	     datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
	     implservice_name="com.ai.secframe.orgmodel.service.interfaces.ISecOrganizeSV" 
	     implservice_querymethod="querySecOrganize"
	     initial="false"
	     editable="false">
        <ai:dbformfield fieldname="PARENT_ORGANIZE_ID" formid="partyRoleOrg_form" width="150" visible="false" />
		  
		
		  <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.name" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="ORGANIZE_NAME" formid="partyRoleOrg_form" width="150" /><span class="font_red">*</span></td>
                <td class="td_font"><i18n:message key="sec.organize.id" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="ORGANIZE_ID" formid="partyRoleOrg_form" width="150" /><span class="font_red">*</span></td>              
              </tr>
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.englishname" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="ENGLISH_NAME" formid="partyRoleOrg_form" width="150" /></td>
                <td class="td_font"><i18n:message key="sec.organize.shortname" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="SHORT_NAME" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.managername" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="MANAGER_NAME" formid="partyRoleOrg_form" width="150" /></td>
                <td class="td_font"><i18n:message key="sec.organize.email" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="EMAIL" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.phoneid" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="PHONE_ID" formid="partyRoleOrg_form" width="150" /></td>
                <td class="td_font"><i18n:message key="sec.organize.faxid" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="FAX_ID" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.contactname" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="CONTACT_NAME" formid="partyRoleOrg_form" width="150" /></td>
                <td class="td_font"><i18n:message key="sec.organize.contactbillid" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="CONTACT_BILL_ID" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
            </table>
           
            
           </ai:dbform>
            </ai:contractframe>
           	
           <div id="buttonDiv" class="area_button">
             <%if(flag){%>
              <ai:button text="sec.organize.addbutton" i18nRes="i18n.secframe_resource" id="insertOrg" onclick="insertOrg()"/>
              &nbsp;
              <%}%>
              <ai:button text="sec.organize.savebutton"  i18nRes="i18n.secframe_resource" id="saveOrg" onclick="saveOrg()"/>
              &nbsp;
              <ai:button text="sec.organize.delbutton" i18nRes="i18n.secframe_resource" id="deleteOrg" onclick="deleteOrg()"/>
              &nbsp;
              <ai:button text="sec.organize.dobutton" i18nRes="i18n.secframe_resource" id="undeleteOrg" onclick="undeleteOrg()"/>
            </div>
            </td>
  </tr>
</table>
   <p><font color="red">
       &nbsp;&nbsp;&nbsp;&nbsp; 此处我们对新增按钮进行了控制，有权限的操作员可以看到该按钮，没有权限的操作员则看不到该按钮。
   </font></p>
   <p><font color="blue">
	&nbsp;&nbsp;&nbsp;&nbsp; 可使用renll2与renll3登录系统进行查看。
	</font></p>
</body>

</html>
