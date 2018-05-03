<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>工单知会痕迹</title>
</head>
<body onload="init()">

<ai:contractframe id="appriseframe" contenttype="table" title="知会痕迹" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem/>

<ai:table tableid="appriseMark" setname="com.asiainfo.sale.common.web.SETAppriseMark" height="400" multiselect="false" oncellchange="" editable="false" 
	needrefresh="true" pagesize="20" initial="false" onrowchange='changeColor'
	width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	implservice_name="com.asiainfo.sale.common.service.interfaces.IAppriseSV"  
	implservice_querymethod="getAppriseMark(String workflowId,int $STARTROWINDEX,int $ENDROWINDEX)" 
	implservice_countmethod="getAppriseMarkCount(String workflowId)">
		 <ai:col fieldname="STAFF_NAME" width="70"/>
		 <ai:col fieldname="ORGANIZE_NAME" width="80"/>
		 <ai:col fieldname="DEPART" width="130"/>
		 <ai:col fieldname="SEND_TIME" width="120"/>
		 <ai:col fieldname="APPRISE_FLAG" width="70"/>
		 <ai:col fieldname="IS_READED" width="70"/>
		 <ai:col fieldname="DEAL_TIME" width="120"/>
</ai:table>
</ai:contractframe>

<ai:loginuser/>
<script type="text/javascript">

var gRowSet = g_TableRowSetManager.get("appriseMark");
var workflowId = "<%=request.getParameter("workflowId")%>";

function init(){
	
    gRowSet.refresh("workflowId=" + workflowId);
}

function changeColor(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	gRowSet.setRowBgColor(oldIndex,"");
    }
   		gRowSet.setRowBgColor(newIndex,"yellow");
}
</script>
