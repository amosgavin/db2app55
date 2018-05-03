<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>业务变更申请</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
</head>
<body onload="pageInit()">
<ai:contractframe id="queryframe" contenttype="table" title="查询" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="queryForm" 
            setname="com.asiainfo.sale.access.web.SETSelectSaleOrCharge"
            conditionname="condition" parametersname="parameters"
            editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.access.service.interfaces.IBusiChangeDetailSV"
		    implservice_querymethod="getExistInfo(String batchType, String orgId, String operName, int $STARTROWINDEX, int $ENDROWINDEX)" >
        <table width="100%" align="center" border="0" cellpadding="1" cellspacing="1">
        <tr>
           <td class="td_font">申请部门:</td>
           <td><ai:dbformfield formid="queryForm" fieldname="ORG_ID" width="150"/></td>
           <td class="td_font">申请人:</td>
           <td><ai:dbformfield formid="queryForm" fieldname="STAFF_NAME" width="150"/></td>
        </tr><tr>
           <td class="td_font">批次名:</td>
           <td><ai:dbformfield formid="queryForm" fieldname="BATCH_NAME" width="150"/></td>
           <td class="td_font">档次名:</td>
           <td><ai:dbformfield formid="queryForm" fieldname="LEVEL_NAME" width="150"/>
           <ai:button text="查询" onclick="doWork('query()')" />
           </td>
         </tr> 
       </table>
    </ai:dbform>
</ai:contractframe>
<ai:contractframe id="selectiframe" contenttype="table" title="可选的营销案或资费案" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	<ai:table tableid="selectTab" setname="com.asiainfo.sale.access.web.SETSelectSaleOrCharge" height="300" multiselect="false" oncellchange="" 
		oncontextmenu="" needrefresh="true" onrowchange="changeColor" pagesize="30" ondbclick="sureInfo"
		width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.access.service.interfaces.IBusiChangeDetailSV"
		implservice_querymethod="getExistInfo(String batchType, String orgId, String operName, String batchName, String levelName, int $STARTROWINDEX, int $ENDROWINDEX)" 
		implservice_countmethod="getExistInfoCount(String batchType, String orgId, String operName, String batchName, String levelName)" 
		initial="false" editable="false">
				<ai:col fieldname="ORG_NAME" width="150" visible="true"/>
				<ai:col fieldname="STAFF_NAME" width="50" visible="true"/>
	        	<ai:col fieldname="BATCH_ID" width="50" visible="true"/>
	            <ai:col fieldname="BATCH_TYPE" width="100" visible="false"/>
	        	<ai:col fieldname="BATCH_NAME" width="200" visible="true"/>
	        	<ai:col fieldname="LEVEL_ID" width="200" visible="false"/>
	            <ai:col fieldname="BOSS_BATCH_CODE" width="150" visible="true"/>
	        	<ai:col fieldname="LEVEL_NAME" width="200" visible="true"/>
	            <ai:col fieldname="BOSS_LEV_CODE" width="150" visible="true"/>
	            <ai:col fieldname="BEGIN_TIME" width="150" visible="true"/>
	            <ai:col fieldname="END_TIME" width="150" visible="true"/>
	</ai:table>
</ai:contractframe>
<div align="center">
<ai:button id="bt_saveSaleMain" text="确定" onclick="doWork('sureInfo()')"/>
</div>
<ai:loginuser/>
<script language="javascript" type="text/javascript">
var batchType = "<%=request.getParameter("batchType")%>";
var selectTab = g_TableRowSetManager.get("selectTab");
var queryForm = g_FormRowSetManager.get("queryForm");

function pageInit(){
	//selectTab.refresh("&batchType=" + batchType);
}

function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}

function query() {
	var orgId = queryForm.getValue("ORG_ID");
	var operName = queryForm.getValue("STAFF_NAME");
	var batchName = queryForm.getValue("BATCH_NAME");
	var levelName = queryForm.getValue("LEVEL_NAME");
	selectTab.refresh("&batchType=" + batchType + "&orgId=" + orgId + "&operName=" + encodeURI(trim(operName))
		+"&batchName=" + encodeURI(trim(batchName)) + "&levelName=" + encodeURI(trim(levelName)));
}

function sureInfo() {
	var selRows = selectTab.getSelectedRows();
	var batchId=selectTab.getValue(selRows,"BATCH_ID");
	if (batchId == "") {
		return alert("请先选定一条记录！")
	}
	var batchName=selectTab.getValue(selRows,"BATCH_NAME");
	var bossBatchCode=selectTab.getValue(selRows,"BOSS_BATCH_CODE");
	var bossLevCode=selectTab.getValue(selRows,"BOSS_LEV_CODE");
	var levelId = selectTab.getValue(selRows,"LEVEL_ID");
	var levelName=selectTab.getValue(selRows,"LEVEL_NAME");
	var beginTime=selectTab.getValue(selRows,"BEGIN_TIME");
	var endTime=selectTab.getValue(selRows,"END_TIME");
	window.returnValue=batchId+","+batchName+","+bossBatchCode+","+bossLevCode+","+levelName+","+beginTime+","+endTime+","+levelId;
    window.self.close();
}


function changeColor(oldIndex,newIndex){
	if(-1 != oldIndex) {
      selectTab.setRowBgColor(oldIndex,"");
    }
      selectTab.setRowBgColor(newIndex,"yellow");
}

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>
</body>
</html>