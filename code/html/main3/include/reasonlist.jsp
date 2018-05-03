<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/secframe/common/common.jsp" %>
<%@ include file="/webframe/common/commonhead.jsp" %>

<ai:table tableid="reasonList" setname="com.asiainfo.task.bo.SETCurTask" height="30%" multiselect="false" oncellchange="" editable="false" oncontextmenu="" needrefresh="true" onrowchange="" pagesize="200"
width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.task.service.interfaces.ICurTaskSV"  
implservice_querymethod="getReasons(String recordId,String recordType)" 
implservice_countmethod="">
 <ai:col fieldname="WORKFLOW_OBJECT_ID" width="160"/>
 <ai:col fieldname="TLABEL" width="160"/>
 <ai:col fieldname="STAFF_NAME" width="100"/>
 <ai:col fieldname="DESCRIPTION" width="400"/>
</ai:table>

<script language="JavaScript" for="window">
  var reasonList01 = g_TableRowSetManager.get("reasonList");	

  function reason(recordId,recordType){
	var param = "recordId=" + recordId + "&recordType=" + recordType;
    reasonList01.refresh(param);
  }
</script>
