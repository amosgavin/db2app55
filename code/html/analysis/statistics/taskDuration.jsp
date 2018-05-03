<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="工单流转时间查看"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initOper()">

<table width="100%" align="center" border="0" cellpadding="1" cellspacing="2">

 <tr>
    <td align="center"><span style="font-family:华文中宋; color:red; ">营销活动流转时间</span><br>
        <input type="radio" id="itemType_id" name="itemType" value="1" onclick="radio_click(this)"></td>
    <td align="center"><span style="font-family:华文中宋; color:red; ">资费流转时间</span><br>
        <input type="radio" id="itemType_id" name="itemType" value="0" onclick="radio_click(this)"></td>
  </tr>
  <tr>
  	<td height="1" colspan="4" bgcolor="#CCCCCC"></td>
  </tr>
</table>

<ai:contractframe id="taskDurationframe" contenttype="table" title="流转时间(单位天)" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="taskDurationForm" initial="false"
			setname="com.asiainfo.bi.web.SETTaskDuration"
			>
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">在</td>
	           	<td><ai:dbformfield formid="taskDurationForm" fieldname="STARTTIMEFROM" width="150"/>-><ai:dbformfield formid="taskDurationForm" fieldname="STARTTIMETO" width="150"/>期间提交的工单
	           	<ai:button id="bt" text="查询" onclick="query()"/></td> 
			</tr>
		</table>
	</ai:dbform>
    <ai:table
        tableid="taskDurationTab"
        setname="com.asiainfo.bi.web.SETTaskDuration"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.bi.service.interfaces.IStatisticsSV"
        implservice_querymethod="getProcessNodeAvgTime(String objectType, String startTimeFrom, String startTimeTo)"
        initial="false" pagesize="100" width="100%" editable="true" 
        height="355" needrefresh="true">
        <ai:col fieldname="REGION_ID" width="150" editable="false" />
        <ai:col fieldname="AVG_TIME1" width="150" editable="false" />
           <ai:col fieldname="AVG_TIME2" width="150" editable="false" />
           <ai:col fieldname="AVG_TIME3" width="150" editable="false"/>
           <ai:col fieldname="AVG_TIME4" width="180" editable="false"/>
           <ai:col fieldname="AVG_TIME5" width="150" editable="false"/>
           <ai:col fieldname="AVG_ALL" width="150" editable="false"/>
    </ai:table>
</ai:contractframe>
</body>

<script type="text/javascript">

var taskDurationTab = g_TableRowSetManager.get("taskDurationTab");
var objectType = "<%=request.getParameter("objectType")%>";
var taskDurationForm = g_FormRowSetManager.get("taskDurationForm");

function initOper()
{
	document.all.itemType[0].checked = true;
    taskDurationTab.refresh("&objectType=" + 'sale');
    dealAllData();
}

function query() {
	var startTimeFrom = taskDurationForm.getValue("STARTTIMEFROM");
	var startTimeTo = taskDurationForm.getValue("STARTTIMETO");
	var itemType = GetRadioValue("itemType");
	refreshTable(itemType, startTimeFrom, startTimeTo);
}

function radio_click(obj){
	taskDurationForm.setValue("STARTTIMEFROM","");
	taskDurationForm.setValue("STARTTIMETO","");
   	refreshTable(obj.value, "", "");
}

function GetRadioValue(RadioName){
    var obj;    
    obj=document.getElementsByName(RadioName);
    if(obj!=null){
        var i;
        for(i=0;i<obj.length;i++){
            if(obj[i].checked){
                return obj[i].value;            
            }
        }
    }
    return null;
}

function refreshTable(objectType, startTimeFrom, startTimeTo){
	
	if (objectType == 1) {
    	taskDurationTab.refresh("&objectType=sale&startTimeFrom=" + startTimeFrom + "&startTimeTo=" + startTimeTo);
    } else {
    	taskDurationTab.refresh("&objectType=charge&startTimeFrom=" + startTimeFrom + "&startTimeTo=" + startTimeTo);
    }
    dealAllData();
}
function dealAllData() {
	
    taskDurationTab.newRow();
    taskDurationTab.setValue(taskDurationTab.getTotalRowCount()-1,"REGION_ID","平均");
    var colNameArray = ["AVG_TIME1","AVG_TIME2","AVG_TIME3","AVG_TIME4","AVG_TIME5","AVG_ALL"];
    for(var j = 0; j < 6; ++j){
    	var count = 0;
    	var sumValue = 0.0;
    	for (var k = 0; k < taskDurationTab.getTotalRowCount()-1; ++k)
    	{
    		if(taskDurationTab.getValue(k, colNameArray[j]) != null && taskDurationTab.getValue(k, colNameArray[j]) != '')
    			{	
	    			sumValue += parseFloat(taskDurationTab.getValue(k, colNameArray[j]));
    				if(j == 5 && taskDurationTab.getValue(k, colNameArray[j]) == 0.0) {
    				} else {
	    				++count;
    				}
    			}
    	}
    	taskDurationTab.setValue(taskDurationTab.getTotalRowCount()-1, colNameArray[j], (count?parseFloat(sumValue/count).toFixed(1):0));
    }
    for(var i = 0; i < taskDurationTab.getTotalRowCount(); ++i){
    	taskDurationTab.setValue(i, "AVG_ALL",(parseFloat(taskDurationTab.getValue(i, "AVG_TIME1")?taskDurationTab.getValue(i, "AVG_TIME1"):0)
    											+ parseFloat(taskDurationTab.getValue(i, "AVG_TIME2")?taskDurationTab.getValue(i, "AVG_TIME2"):0)
    											+ parseFloat(taskDurationTab.getValue(i, "AVG_TIME3")?taskDurationTab.getValue(i, "AVG_TIME3"):0)
    											+ parseFloat(taskDurationTab.getValue(i, "AVG_TIME4")?taskDurationTab.getValue(i, "AVG_TIME4"):0)
    											+ parseFloat(taskDurationTab.getValue(i, "AVG_TIME5")?taskDurationTab.getValue(i, "AVG_TIME5"):0)).toFixed(1));
    }
}

</script>
</html>