<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>公告信息维护</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="init()">

<ai:contractframe id="queryframe" contenttype="table" title="查询条件" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem/>
<ai:dbform formid="queryForm" 
			setname="com.asiainfo.sale.common.bo.SETAnnounceInfo"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.sale.common.service.interfaces.IAnnounceInfoSV"
			implservice_querymethod="">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">公告名称：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="TITLE" width="150"/></td>
	           	<td class="td_font">创建时间：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="APPLY_TIME" width="100"/></td>
	           	<td class="td_font">至：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="CREATE_TIME" width="100"/></td>
	           	<td class="td_font">公告状态：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="FLAG" width="80"/></td>
			</tr>
		</table>
	</ai:dbform>
    <table align = "center">
      <td><ai:button id="query" text="查询" onclick="query()"/></td>
    </table>
</ai:contractframe>

<ai:contractframe id="announceInfoframe" contenttype="table" title="公告信息列表" width="100%" allowcontract="true" frameclosed="false">
<ai:contractitem/>
<ai:table tableid="announceInfoList" setname="com.asiainfo.sale.common.bo.SETAnnounceInfo" height="200" multiselect="false" oncellchange="" editable="false" oncontextmenu="" needrefresh="true" onrowchange="" pagesize="100"
width="100%" onrowchange='onrowchange1' tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.sale.common.service.interfaces.IAnnounceInfoSV"  
implservice_querymethod="getAnnounceInfos(String title,String apply_time,String create_time,String flag)" 
implservice_countmethod=""
initial="false">
 <ai:col fieldname="ID" width="80" />
 <ai:col fieldname="TITLE" width="150"/>
 <ai:col fieldname="CREATE_TIME" width="80" />
 <ai:col fieldname="APPLY_TIME" width="80" />
 <ai:col fieldname="CANCEL_TIME" width="80" />
 <ai:col fieldname="FLAG" width="80" />
 <ai:col fieldname="CONTENT" width="400" /> 
</ai:table>
<table align = "center">
    <td><ai:button id="applyAnnounceInfo" text="发布公告信息" onclick="doWork('apply()')"/></td>
    <td><ai:button id="cancleAnnounceInfo" text="取消公告信息" onclick="doWork('cancle()')"/></td>
</table>
</ai:contractframe>

<ai:contractframe id="announceInfoFormFrame" contenttype="table" title="新增发布信息" i18nRes="CRM" width="100%" height="250" allowcontract="false" frameclosed="false">
<ai:contractitem/>
<ai:dbform formid="announceInfoForm" 
			setname="com.asiainfo.sale.common.bo.SETAnnounceInfo"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.sale.common.service.interfaces.IAnnounceInfoSV"
			implservice_querymethod="getAnnounceInfoById(String id)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
			<tr>
			   <td class="td_font">公告名称：</td>
				<td>
				   <ai:dbformfield formid="announceInfoForm" fieldname="TITLE" width="150" />
                   <ai:dbformfield formid="announceInfoForm" fieldname="ID" width="60" editable="" visible="false"/>				   
				</td>
			</tr>
			<tr>
			    <td class="td_font">公告内容：</td>
				<td><ai:dbformfield formid="announceInfoForm" fieldname="CONTENT" height="100" width="850" /></td>
			</tr>
		</table>
</ai:dbform>
<table align = "center">
    <ai:button id="saveannounceInfo" text="保存公告信息" onclick="doWork('save()')"/></td>
    <ai:button id="applySaveAnnounceInfo" text="保存并发布公告信息" onclick="doWork('applySave()')"/></td>
</table>
</ai:contractframe>

<ai:loginuser/>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script language="javascript" type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>
<script type="text/javascript">
  var gRowSet1 = g_TableRowSetManager.get("announceInfoList");
  var aInfoForm = g_FormRowSetManager.get("announceInfoForm");
  var queryForm = g_FormRowSetManager.get("queryForm");

  function query(){
	  var title = queryForm.getValue("TITLE");
	  var btime = queryForm.getValue("APPLY_TIME");
	  var etime = queryForm.getValue("CREATE_TIME");
	  var flag = queryForm.getValue("FLAG");
	  var flagtext = queryForm.getDisplayText("FLAG");
	  if(flagtext=="全部"){
		  flag="";
	  }
	 
	var param = "title=" + encodeURI(title) 
	           +"&apply_time="+ btime
	           +"&create_time="+ etime
	           +"&flag="+ flag;
    gRowSet1.refresh(param);
    gRowSet1.setFocus(0,0);
    gRowSet1.setFocusByName(0,"TITLE");    
}
  
function save(){
 var title=aInfoForm.getValue("TITLE");
 var content=aInfoForm.getValue("CONTENT");
 if(""==title){return  alert("请输入发布公告名称！");}
 if(""==content){return  alert("请输入发布公告内容！");}

 if ("O" != aInfoForm.getSts()||aInfoForm.getSts()=="U")
    {
        var list = new Array();

	    list.push(aInfoForm);
	    var strUrl = _gModuleName + '/business/com.asiainfo.sale.common.web.AnnounceInfoAction?action=saveAnnounceInfo';
	    var recode = saveRowSet(strUrl, list);
	    var aid = recode.getValueByName("id");
	    if(aid==null){
	    	return alert("保存操作失败！");
	    }
  	    aInfoForm.refresh("&id="+aid);
    }else{
        var list = new Array();    	
	    list.push(_fromAccessFormRowSet);
	    var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.AccessChangeAction?action=saveAccessChangeInfo&applyid=0';
	    var recode = saveRowSet(strUrl, list);
	    var accessid = _fromAccessFormRowSet.getValue("ACCESS_ID");
        var message = recode.getValueByName("M");
  	    _fromAccessFormRowSet.refresh("&accessid="+accessid);
    }
}

function cancle(){
	var curRowIndex = 0;
	var selectedRows = gRowSet1.getSelectedRows();
	if (selectedRows.length == 0) {
		curRowIndex = gRowSet1.getCurRowIndex();
	} else if (selectedRows.length == 1){
		curRowIndex = selectedRows[0];
	} else {
		alert("请选择需要取消的公告");
		return;
	}
	var flag = gRowSet1.getValue(curRowIndex, "FLAG");
	var id = gRowSet1.getValue(curRowIndex, "ID");
    if(flag!="2"){
		alert("只能取消已发布的公告!");
		return;
    }

    var strUrl = _gModuleName + '/business/com.asiainfo.sale.common.web.AnnounceInfoAction?action=cancleAnnounceInfo&id='+id;
	var recode = PostInfo(strUrl,null);
	query();
}

function apply(){
	var curRowIndex = 0;
	var selectedRows = gRowSet1.getSelectedRows();
	if (selectedRows.length == 0) {
		curRowIndex = gRowSet1.getCurRowIndex();
	} else if (selectedRows.length == 1){
		curRowIndex = selectedRows[0];
	} else {
		alert("请选择需要发布的公告");
		return;
	}
	var flag = gRowSet1.getValue(curRowIndex, "FLAG");
	var id = gRowSet1.getValue(curRowIndex, "ID");
    /* if(flag!="1"){
		alert("只能发布状态为已保存的公告!");
		return;
    } */
    var strUrl = _gModuleName + '/business/com.asiainfo.sale.common.web.AnnounceInfoAction?action=applyAnnounceInfo&id='+id;
	var recode = PostInfo(strUrl,null);
	query();
}
  
function getPre1MonTime(){
	var now=new Date();
	var year=now.getYear();
	var month=now.getMonth();
	var day=now.getDate();
	var hour=now.getHours();
	var minute=now.getMinutes();
	var second=now.getSeconds();
	if (month == 0){
		year = year - 1;
		month = 12;
	}
	month = month>9?month.toString():'0' + month;
	day = '01';
	hour = hour>9?hour.toString():'0' + hour;
	minute = minute>9?minute.toString():'0' + minute;
	second = second>9?second.toString():'0' + second;
	
	return year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
}
function getCurrentTime(){
	var now=new Date();
	var year=now.getYear();
	var month=now.getMonth()+1;
	var day=now.getDate();
	var hour=now.getHours();
	var minute=now.getMinutes();
	var second=now.getSeconds();
	
	month = month>9?month.toString():'0' + month;
	day = day>9?day.toString():'0' + day;
	hour = hour>9?hour.toString():'0' + hour;
	minute = minute>9?minute.toString():'0' + minute;
	second = second>9?second.toString():'0' + second;
	
	return year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
}

function trim(str)
{	
     return str.replace(/(^\s*)|(\s*$)/g, '');
}

function onrowchange1(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	gRowSet1.setRowBgColor(oldIndex,"");
    }
    	gRowSet1.setRowBgColor(newIndex,"yellow");
}

</script>
