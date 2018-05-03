<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title>选择员工</title>
  </head>
  <body onload="initPage()">
  <div class="area_button">
    <i18n:message key="staffselect.name" res="i18n.secframe_resource"/>
    <input value="" type="text" id="name" class="input" style="width:150px;"/>
    <ai:button text="staffselect.search" i18nRes="i18n.secframe_resource" id="searchOperBtn" onclick="searchStaff()"/>
  </div>
  <ai:contractframe id="contractframe1" contenttype="table" title="可选员工列表" width="100%" allowcontract="false" frameclosed="false">
      <ai:contractitem/>
      	 <ai:table tableid="dbTableExistStaff"
		setname="com.asiainfo.sale.common.web.SETWFOperator"
           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
           implservice_name="com.asiainfo.sale.common.service.interfaces.IOperatorInfoSV"
           implservice_querymethod="getWFOperatorInfo(String staffName, String roleId, String orgId, int $STARTROWINDEX, int $ENDROWINDEX)"
           implservice_countmethod="getWFOperatorCountByOrgId(String staffName, String roleId, String orgId)"
           ondbclick="doReturn"
		initial="false" editable="false" pagesize="6" multiselect="true"
		width="390" height="122" needrefresh="true" footdisplay="true">
                      <ai:col fieldname="OPERATOR_ID" visible="false"/>
                      <ai:col fieldname="STAFF_ID" visible="false"/>
                      <ai:col fieldname="CODE" visible="false"/>
                      <ai:col fieldname="STAFF_NAME" width="130" visible="true"/>
                      <ai:col fieldname="ORGANIZE_NAME" width="120" visible="true"/>
                      <ai:col fieldname="ORGANIZE_NAME_P" width="120" visible="true"/>
        	</ai:table>
 		</ai:contractframe>
<div class="area_button">
    <ai:button text="确定" id="bt_doReturn" onclick="doReturn()"/>
    <ai:button text="取消" id="bt_cancel" onclick="cancel()"/>
</div> 
  </body>
</html>
<script type="text/javascript">
  function getDbTableExistStaff()
  {
      return g_TableRowSetManager.get("dbTableExistStaff");
  }   
  
  function initPage(){
      var roleId = "<%=request.getParameter("roleId")%>";
      var orgId = "<%=request.getParameter("orgId")%>";
      getDbTableExistStaff().refresh("roleId="+roleId+"&orgId="+orgId);
  }
  
  function cancel()
  {   
      window.self.close();
  }
    
  function doReturn()
  {
      var sRow = getDbTableExistStaff().getSelectedRows();
      if(sRow.length > 0)
      {
          var staffJSON = {"elements":[]};
          for(var i=0;i<sRow.length;i++)
          {
              staffJSON.elements.push({
                                          "operatorId":getDbTableExistStaff().getValue(i, "OPERATOR_ID"),
                                          "staffId":getDbTableExistStaff().getValue(i, "STAFF_ID"),
                                          "code":getDbTableExistStaff().getValue(i, "CODE"),
                                          "name":getDbTableExistStaff().getValue(i, "STAFF_NAME")
                                      });
          }
          window.returnValue = staffJSON;
          cancel();
      } else {
          alert("请选择员工");
      }
  }
  
  
function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
    /**
     * 查询操作员与员工信息
     */
    function searchStaff(){
        var dbTableStaff = getDbTableExistStaff(); 
        var name = document.getElementById("name").value;
        var roleId = "<%=request.getParameter("roleId")%>";
        var orgId = "<%=request.getParameter("orgId")%>";
        var nameCond = "";
        var roleIdCond = "";
        var orgIdCond="";
        
        var flag = false;
        if(name != null && name != "")
        {
            name = encodeURI(trim(name)); 
            nameCond = "staffName="+name;
        }
        if(roleId != null && roleId != "")
        {
            roleIdCond = "roleId="+roleId;
        }
        if(orgId != null && orgId != "")
        {
            orgIdCond = "orgId="+orgId;
        }
        var cond = "";
        if(nameCond != "")
        {
            cond = cond + nameCond;
            flag = true;
        }
        
        if(roleIdCond != "")
        {
            if(flag)
            {
                cond = cond +"&"+ roleIdCond;
            }
            else 
            {
                cond = cond +  roleIdCond;
                flag = true;
            }
        }
        if(orgIdCond != "")
        {
            if(flag)
            {
                cond = cond +"&"+ orgIdCond;
            }
            else 
            {
                cond = cond +  orgIdCond;
                flag = true;
            }
        }
        
        if(cond == "")
        {
            alert(g_I18NMessage("secframe_operator", "sec_operator_condition_empty"));
            return ;
        }
        dbTableStaff.refresh(cond);
    }
</script>