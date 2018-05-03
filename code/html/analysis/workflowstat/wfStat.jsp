<%@ page contentType="text/html; charset=GBK"%>
<%--<%@ include file="/secframe/common/common.jsp"%>--%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<title>工单状态查询</title>
		<script language="javascript"
			src="<%=request.getContextPath()%>/jsv2/Calendar.jsp"
			type="text/javascript"></script>
		<script language="JavaScript"
			src="<%=request.getContextPath()%>/jsv2/CommUtil.js"></script>
	</head>
	<body onload="">
		<ai:contractframe id="wfStateQuery" contenttype="table" title="统计条件"
			width="100%" allowcontract="false" frameclosed="false">
			<ai:contractitem />
			<ai:dbform formid="wfStateQueryForm"
				setname="com.asiainfo.workflow.workflowstat.web.SETWFStat"
				onvalchange="" editable="true" initial="false">
				<table width="98%" align="center" border="0" cellpadding="1"
					cellspacing="2">
					<tr>
						<td class="td_font">
							申请地区：
						</td>
						<td>
							<ai:dbformfield formid="wfStateQueryForm" fieldname="REGION_ID"
								width="150" />
						</td>
						<td class="td_font">
							申请类型：
						</td>
						<td>
							<ai:dbformfield formid="wfStateQueryForm"
								fieldname="WORKFLOW_OBJECT_TYPE" width="150" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							创建时间起：
						</td>
						<td>
							<ai:dbformfield formid="wfStateQueryForm"
								fieldname="CREATE_DATE_START" width="150" editable="" />
						</td>
						<td class="td_font">
							创建时间止：
						</td>
						<td>
							<ai:dbformfield formid="wfStateQueryForm"
								fieldname="CREATE_DATE_END" width="150" editable="" />
						</td>
						<td class="td_button">
							<ai:button id="queryWfState" text="统计" onclick="queryWfState()" />
						</td>
					</tr>
				</table>
			</ai:dbform>
		</ai:contractframe>

		<ai:contractframe id="wfStateInfo" contenttype="table" title="工单状态信息"
			width="100%" allowcontract="false" frameclosed="fale">
			<ai:contractitem>
				<ai:button id="queryWfState" text="导出EXCEL"
					onclick="doWork('toExcel()')" />
			</ai:contractitem>
			<ai:table tableid="wfStateInfoTable"
				setname="com.asiainfo.workflow.workflowstat.web.SETWFStat"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.asiainfo.workflow.workflowstat.service.interfaces.IWfStateSV"
				implservice_querymethod="getWfState(String regionId,String workflowObjectType, String createDateStart, String createDateEnd, int $STARTROWINDEX, int $ENDROWINDEX)"
				implservice_countmethod="getWfCount(String regionId,String workflowObjectType, String createDateStart, String createDateEnd,)"
				ondbclick="dbclick" initial="false" pagesize="7" editable="false"
				width="100%" height="150" needrefresh="true">
				<ai:col title="工单流程编号" fieldname="WORKFLOW_ID" width="15%"
					visible="false" />
				<ai:col title="申请人" fieldname="STAFF_NAME" width="15%"
					visible="true" />
				<ai:col title="申请地区" fieldname="REGION_ID" width="12%"
					visible="true" />
				<ai:col title="工单类型" fieldname="WORKFLOW_OBJECT_TYPE" width="12%"
					visible="true" />
				<ai:col title="工单编号" fieldname="WORKFLOW_OBJECT_ID" width="11%"
					visible="true" />
				<ai:col title="创建时间" fieldname="CREATE_DATE" width="20%"
					visible="true" />
				<ai:col title="工单当前状态" fieldname="LABEL" width="30%" visible="true" />
			</ai:table>
		</ai:contractframe>

		<ai:contractframe id="wfDetInfo" contenttype="table" title="工单流转信息"
			width="100%" allowcontract="false" frameclosed="fale">
			<ai:contractitem />
			<ai:table tableid="wfDetInfoTable"
				setname="com.asiainfo.workflow.workflowstat.web.SETAllTaskStat"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.asiainfo.workflow.workflowstat.service.interfaces.IAllTaskSV"
				implservice_querymethod="getAllTaskByWorkFlowId(String workflowId, int $STARTROWINDEX, int $ENDROWINDEX)"
				implservice_countmethod="getAllTaskCount(String workflowId)"
				initial="false" pagesize="10" editable="false" width="100%"
				height="150" needrefresh="true">
				<ai:col fieldname="ORG_NAME" width="15%" />
				<ai:col fieldname="TASK_STAFF_NAME" width="10%" />
				<ai:col fieldname="LABEL" width="20%" />
				<ai:col fieldname="TLABEL" width="20%" />
				<ai:col fieldname="FINISH_DATE" width="15%" />
				<ai:col fieldname="DESCRIPTION" width="20%" />
				<%--<ai:col fieldname="STATE_NAME" width="180" visible="false" />
				<ai:col fieldname="WORKFLOW_OBJECT_TYPE" width="100" visible="false" />
				<ai:col fieldname="OBJECT_TYPE_NAME" width="100" visible="false" />
				<ai:col fieldname="WORKFLOW_OBJECT_ID" width="150" />
				<ai:col fieldname="TASK_ID" width="200" visible="false" />
				<ai:col fieldname="WORKFLOW_ID" width="200" visible="false" />
				<ai:col fieldname="STATION_ID" width="100" visible="false" />
				<ai:col fieldname="TASK_STAFF_ID" width="100" visible="false" />
				<ai:col fieldname="TASK_TAG" width="100" visible="false" />--%>
			</ai:table>
		</ai:contractframe>
	</body>
</html>
<script type="text/javascript">

	var wfStateQueryForm = g_FormRowSetManager.get("wfStateQueryForm");
	var wfStateInfoTable = g_TableRowSetManager.get("wfStateInfoTable");	
	var wfDetInfoTable = g_TableRowSetManager.get("wfDetInfoTable");
	
	function queryWfState(){
	    var regionId = wfStateQueryForm.getValue("REGION_ID");
	    var workflowObjectType = wfStateQueryForm.getValue("WORKFLOW_OBJECT_TYPE");
	    var createDateStart = wfStateQueryForm.getValue("CREATE_DATE_START");
	    var createDateEnd = wfStateQueryForm.getValue("CREATE_DATE_END");
	    
	    var compareResult = g_CompareDate(createDateStart,createDateEnd);
		if(compareResult=="1"){
			alert("创建时间起不能大于创建时间止！");
			return;
		}
			    
		var param = "regionId=" + regionId +"&workflowObjectType="+workflowObjectType
						+"&createDateStart="+createDateStart+"&createDateEnd="+createDateEnd;
	    wfStateInfoTable.refresh(param);
	    wfStateInfoTable.setFocus(0,0);
	    
	    dbclick();   
  	}
  
  	//获取条件后刷新记录
  	function dbclick(){ 
	    var curRow = wfStateInfoTable.getRow();
	    var WORKFLOW_ID = wfStateInfoTable.getValue(curRow,"WORKFLOW_ID");
	 	var param1 = "workflowId="+WORKFLOW_ID;
	 	
	    wfDetInfoTable.refresh(param1);//刷新
  }
  
  function toExcel(){
  		var totalRowCount = wfStateInfoTable.getTotalRowCount();
  		if(totalRowCount == 0){
  			alert("无数据可导出！");
  			return false;
  		};
  		var regionId = wfStateQueryForm.getValue("REGION_ID");
  		var workflowObjectType = wfStateQueryForm.getValue("WORKFLOW_OBJECT_TYPE");
  		var createDateStart = wfStateQueryForm.getValue("CREATE_DATE_START");
	    var createDateEnd = wfStateQueryForm.getValue("CREATE_DATE_END");
  		
  		var url = "<%=request.getContextPath()%>/analysis/workflowstat/downloadExcel.jsp?&regionId="+regionId+"&workflowObjectType="+workflowObjectType
  					+"&createDateStart="+createDateStart+"&createDateEnd="+createDateEnd;
  		window.location.href = url;
  }

</script>
<script language="javascript"
	src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>