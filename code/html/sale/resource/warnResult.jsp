<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
		<title>�����ƶ���˾Ӫ������ϵͳ</title>
	</head>
  
  <body onload="initPage()">
   <ai:contractframe id="warnResultQueryframe" contenttype="table" title="��ѯ����" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="warnResultQueryForm" initial="false"
			setname="com.asiainfo.costWarn.web.WarnResult">
		<table width="20%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
			    <td class="td_font">���У�</td>
	           	<td><ai:dbformfield formid="warnResultQueryForm" fieldname="CITY_CODE" width="150"/></td>
	           	<td class="td_font">��Դ���ͣ�</td>
	           	<td><ai:dbformfield formid="warnResultQueryForm" fieldname="REMARK1" width="150"/></td>
	           	<td class="td_font">��������</td>
	           	<td><ai:dbformfield formid="warnResultQueryForm" fieldname="REMARK2" width="150"/></td>
				<td><ai:button id="query" text="��ѯ" onclick="doWork('queryByType()')"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
  
    <ai:contractframe id="warnResultframe" contenttype="table" title="��ѯ���"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem>
			    <ai:button id="show" text="ͣ�" onclick="insert()" />
			</ai:contractitem>
			<ai:table tableid="warnResultTable" setname="com.asiainfo.costWarn.web.WarnResult"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.asiainfo.costWarn.service.interfaces.IWarnResultSV"
				implservice_querymethod="select(String resource_type,String up_down,String city_code,int $STARTROWINDEX, int $ENDROWINDEX)"
				implservice_countmethod="count(String resource_type,String up_down,String city_code)"
				initial="false" multiselect="true" pagesize="20" editable="false"
				width="100%" height="420" needrefresh="true">
				<ai:col title="Ӫ����Դʹ�õ���" fieldname="CITY_CODE" width="10%"/>
				<ai:col title="Ӫ������α���" fieldname="SALE_MAIN_CODE" width="20%" />
				<ai:col title="Ӫ�����������" fieldname="SALE_MAIN_NAME" width="20%" />
				<ai:col title="Ӫ������α���" fieldname="SALE_ACTIVE_CODE" width="20%" />
				<ai:col title="Ӫ�����������" fieldname="SALE_ACTIVE_NAME" width="20%" />
				<ai:col title="�����ն˲���" fieldname="TERMINAL_COST" width="20%" />
				<ai:col title="�����ն˲����ٷֱ�(%)" fieldname="PER_TERMINAL_COST" width="20%" />
				<ai:col title="�����ۿ�ʹ��" fieldname="ACTION_OUT" width="20%" />
				<ai:col title="�����ۿ�ʹ�ðٷֱ�(%)" fieldname="PER_ACTION_OUT" width="20%" />
				<ai:col title="���´�������" fieldname="PROMOTE_SCORE" width="20%" />
				<ai:col title="���´������ְٷֱ�(%)" fieldname="PER_PROMOTE_SCORE" width="20%" />
				<ai:col title="���»���ʹ��" fieldname="SALE_POINT" width="20%" />
				<ai:col title="���»���ʹ�ðٷֱ�(%)" fieldname="PER_SALE_POINT" width="20%" />
				<ai:col title="����ʱ��" fieldname="INSERT_TIME" width="20%" visible="false"/>
			</ai:table>
		</ai:contractframe>
<ai:loginuser />
  </body>
</html>
<script language="javascript" type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"���ڴ������Ժ�...");
}
</script>
<script type="text/javascript">
var warnResultTable = g_TableRowSetManager.get("warnResultTable");
var warnResultQueryForm= g_FormRowSetManager.get("warnResultQueryForm");
var org = g_GetUserInfo().ORG_ID.substr(0, 2);
function initPage(){
	warnResultTable.refresh();
    //warnResultTable.refresh("&city_code="+org);
    warnResultQueryForm.setFocus("REMARK1");
    warnResultQueryForm.setFocus("REMARK2");
}
function insert(){
	var list =new Array();
	list = warnResultTable.getSelectedRows();
	if(list.length <1){
		alert("��ѡ����Ҫͣ�Ļ");
		return;
	}
	if(confirm("��ȷ��Ҫͣ�۸û?")){
	for ( var i = list.length; i > 0; i--) {
	       warnResultTable.deleteRow(list[i - 1]);
	    }
	var list02 = new Array();
	list02.push(warnResultTable);
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.costWarn.web.WarnResultAction?action=insert&pid=0';
	var recode = saveRowSet(strUrl, list02);
	}
}

function queryByType(){
	var resource_type=warnResultQueryForm.getValue("REMARK1");
	var up_down=warnResultQueryForm.getValue("REMARK2");
	var city_code=warnResultQueryForm.getValue("CITY_CODE");
	warnResultTable.refresh("&resource_type="+resource_type+"&up_down="+up_down+"&city_code="+city_code);
}
</script>
