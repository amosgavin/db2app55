<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<ai:contractframe id="chargeAssignMframe" contenttype="table" title="会签意见" width="100%" allowcontract="true" frameclosed="true">
<ai:contractitem/>
	<ai:contractframe id="chargeAssignframe" contenttype="table" title="已提交会签意见" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
		<ai:table tableid="chargeAssignTab" editable="false" width="100%" height="150"
	              setname="com.asiainfo.common.web.SETAuditInfoShow" pagesize="30"
	              needrefresh="true" initial="false" multiselect="false" footdisplay="rowcount"
	              tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	              implservice_name="com.asiainfo.common.service.interfaces.IAuditInfoShowSV"
	              implservice_querymethod="getSignInfoByWFId(String orderId,String workflowId)">
	               <ai:col fieldname="ORG" width="170"/>
	               <ai:col fieldname="DEPART" width="170"/>
	               <ai:col fieldname="STAFF_NAME" width="70"/>
	               <ai:col fieldname="LABEL" width="170" />
	               <ai:col fieldname="DECISION_RESULT" width="70"/>
	               <ai:col fieldname="DESCRIPTION" width="600"/>
	    </ai:table>
	</ai:contractframe>
	 <div id="wf2_div" style="display: block">
		<% String taskTag =request.getParameter("taskTag");
		   String audit2_jsp = "/charge/workflow/_blank.jsp";
		   if (taskTag.endsWith("-sign")) {
		   	   audit2_jsp = "/charge/workflow/_submitWF.jsp";
		   }
		%>  
		<jsp:include page="<%=audit2_jsp %>"></jsp:include>
  </div>
</ai:contractframe>

<ai:contractframe id="chargeEstframe" contenttype="table" title="可行分析" width="100%" allowcontract="true" frameclosed="true">
<ai:contractitem/>
    <div id = 'est_div' style="display: block">
	   <ai:dbform formid="chargeEstForm" 
	           setname="com.asiainfo.common.web.SETAuditInfoShow"
	           conditionname="condition" parametersname="parameters"
	           onvalchange="" editable="false" initial="false"
	           datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           implservice_name="com.asiainfo.common.service.interfaces.IAuditInfoShowSV"
		       implservice_querymethod="getEstInfoByWFId(String orderId,String workflowId)">
	       <table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
	          <tr>
	            <td class="td_font">评估人员：</td>
	           	<td><ai:dbformfield formid="chargeEstForm" fieldname="STAFF_NAME" width="150" /></td>
	           	<td class="td_font">评估结果：</td>
	           	<td><ai:dbformfield formid="chargeEstForm" fieldname="DECISION_RESULT" width="150" /></td>
	          </tr>
	          <tr>
	            <td class="td_font">评估描述：</td>
	            <td colspan="3"><ai:dbformfield formid="chargeEstForm" fieldname="DESCRIPTION" width="500" height="70"/></td>
	          </tr>
	       </table>
	   </ai:dbform>
    </div>
	<div id="wf3_div" style="display: block">
		<% String taskTag =request.getParameter("taskTag");
		   String audit3_jsp = "/charge/workflow/_blank.jsp";
		   if (taskTag.endsWith("-est")) {
		   	   audit3_jsp = "/charge/workflow/_submitWF.jsp";
		   }
		%>  
		<jsp:include page="<%=audit3_jsp %>"></jsp:include>
	</div>
</ai:contractframe>

<ai:contractframe id="chargeApproveMframe" contenttype="table" title="审核意见" width="100%" allowcontract="true" frameclosed="true">
<ai:contractitem/>
	<ai:contractframe id="chargeApproveframe" contenttype="table" title="已提交审核意见" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
		<ai:table tableid="chargeApproveTab" editable="false" width="100%" height="150"
	              setname="com.asiainfo.common.web.SETAuditInfoShow" pagesize="30"
	              needrefresh="true" initial="false" multiselect="false" footdisplay="rowcount"
	              tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	              implservice_name="com.asiainfo.common.service.interfaces.IAuditInfoShowSV"
	              implservice_querymethod="getApproveInfoByWFId(String orderId,String workflowId)">
	               <ai:col fieldname="ORG" width="170"/>
	               <ai:col fieldname="DEPART" width="170"/>
	               <ai:col fieldname="STAFF_NAME" width="70"/>
	               <ai:col fieldname="LABEL" width="170" />
	               <ai:col fieldname="DECISION_RESULT" width="70"/>
	               <ai:col fieldname="DESCRIPTION" width="600"/>
	    </ai:table>
	</ai:contractframe>
	<div id="wf4_div" style="display: block">
		<% String taskTag =request.getParameter("taskTag");
		   String audit4_jsp = "/charge/workflow/_blank.jsp";
		   if (taskTag.endsWith("-audit") || taskTag.endsWith("-N")) {
		   	   audit4_jsp = "/charge/workflow/_submitWF.jsp";
		   }
		%>  
		<jsp:include page="<%=audit4_jsp %>"></jsp:include>
	</div>
</ai:contractframe>

<script type="text/javascript">
var chargeAssignTab = g_TableRowSetManager.get("chargeAssignTab");
var chargeEstForm = g_FormRowSetManager.get("chargeEstForm");
var chargeApproveTab = g_TableRowSetManager.get("chargeApproveTab");

function initEstAsgPage() {
	if (_mainId == null || _mainId == 'null' || _mainId == '') return;
	var taskTag = "<%=request.getParameter("taskTag")%>";
	var workflowId = "<%=request.getParameter("workflowId")%>";
	if (workflowId == null || workflowId == "null") workflowId = "";
	chargeAssignTab.refresh("orderId=" + _mainId + "&workflowId=" + workflowId);
	chargeEstForm.refresh("orderId=" + _mainId + "&workflowId=" + workflowId);
	chargeApproveTab.refresh("orderId=" + _mainId + "&workflowId=" + workflowId);
	if (taskTag.endWith("-sign")) {
    	document.all("contractFrame_chargeAssignMframe").style.display='block';
    	document.all("auditSelect_tr").style.display='block';
    } else if (taskTag.endWith("-est")) {
    	document.all("contractFrame_chargeEstframe").style.display='block';
    	document.getElementById('est_div').style.display='none';
    	document.getElementById('discription').innerHTML="评估描述：";
    } else if (taskTag.endWith("-audit") || taskTag.endWith("-N")) {
        document.all("contractFrame_chargeApproveMframe").style.display='block';
    }
}

</script>