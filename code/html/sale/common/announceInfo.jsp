<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>������Ϣά��</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="init()">

<ai:contractframe id="queryframe" contenttype="table" title="��ѯ����" width="100%" allowcontract="false" frameclosed="false">
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
	           	<td class="td_font">�������ƣ�</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="TITLE" width="150"/></td>
	           	<td class="td_font">����ʱ�䣺</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="APPLY_TIME" width="100"/></td>
	           	<td class="td_font">����</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="CREATE_TIME" width="100"/></td>
	           	<td class="td_font">����״̬��</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="FLAG" width="80"/></td>
			</tr>
		</table>
	</ai:dbform>
    <table align = "center">
      <td><ai:button id="query" text="��ѯ" onclick="query()"/></td>
    </table>
</ai:contractframe>

<ai:contractframe id="announceInfoframe" contenttype="table" title="������Ϣ�б�" width="100%" allowcontract="true" frameclosed="false">
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
    <td><ai:button id="applyAnnounceInfo" text="����������Ϣ" onclick="doWork('apply()')"/></td>
    <td><ai:button id="cancleAnnounceInfo" text="ȡ��������Ϣ" onclick="doWork('cancle()')"/></td>
</table>
</ai:contractframe>

<ai:contractframe id="announceInfoFormFrame" contenttype="table" title="����������Ϣ" i18nRes="CRM" width="100%" height="250" allowcontract="false" frameclosed="false">
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
			   <td class="td_font">�������ƣ�</td>
				<td>
				   <ai:dbformfield formid="announceInfoForm" fieldname="TITLE" width="150" />
                   <ai:dbformfield formid="announceInfoForm" fieldname="ID" width="60" editable="" visible="false"/>				   
				</td>
			</tr>
			<tr>
			    <td class="td_font">�������ݣ�</td>
				<td><ai:dbformfield formid="announceInfoForm" fieldname="CONTENT" height="100" width="850" /></td>
			</tr>
		</table>
</ai:dbform>
<table align = "center">
    <ai:button id="saveannounceInfo" text="���湫����Ϣ" onclick="doWork('save()')"/></td>
    <ai:button id="applySaveAnnounceInfo" text="���沢����������Ϣ" onclick="doWork('applySave()')"/></td>
</table>
</ai:contractframe>

<ai:loginuser/>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script language="javascript" type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"���ڴ������Ժ�...");
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
	  if(flagtext=="ȫ��"){
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
 if(""==title){return  alert("�����뷢���������ƣ�");}
 if(""==content){return  alert("�����뷢���������ݣ�");}

 if ("O" != aInfoForm.getSts()||aInfoForm.getSts()=="U")
    {
        var list = new Array();

	    list.push(aInfoForm);
	    var strUrl = _gModuleName + '/business/com.asiainfo.sale.common.web.AnnounceInfoAction?action=saveAnnounceInfo';
	    var recode = saveRowSet(strUrl, list);
	    var aid = recode.getValueByName("id");
	    if(aid==null){
	    	return alert("�������ʧ�ܣ�");
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
		alert("��ѡ����Ҫȡ���Ĺ���");
		return;
	}
	var flag = gRowSet1.getValue(curRowIndex, "FLAG");
	var id = gRowSet1.getValue(curRowIndex, "ID");
    if(flag!="2"){
		alert("ֻ��ȡ���ѷ����Ĺ���!");
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
		alert("��ѡ����Ҫ�����Ĺ���");
		return;
	}
	var flag = gRowSet1.getValue(curRowIndex, "FLAG");
	var id = gRowSet1.getValue(curRowIndex, "ID");
    /* if(flag!="1"){
		alert("ֻ�ܷ���״̬Ϊ�ѱ���Ĺ���!");
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
