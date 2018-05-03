<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<title>湖北移动公司营销管理系统</title>
	</head>
	<body onload="querytext()">
		<ai:contractframe id="configureformid2" contenttype="table"
			title="查询条件" width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:dbform formid="configurequeryForm" initial="false"
				setname="com.asiainfo.costWarn.web.Configure"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.asiainfo.costWarn.service.interfaces.IConfigureSV"
				implservice_querymethod="select(String city, String staffid, String staffname, String bumen, String telphone, int $STARTROWINDEX, int $ENDROWINDEX)"
				editable="true">
				<table width="100%" align="center" border="0" cellpadding="1"
					cellspacing="2">
					<tr id="tr_1">
						<td class="td_font">
							部门：
						</td>
						<td>
							<ai:dbformfield formid="configurequeryForm" fieldname="BUMEN"
								width="100" />
						</td>
						<td class="td_font">
							地市：
						</td>
						<td>
							<ai:dbformfield formid="configurequeryForm" fieldname="CITY"
								width="100" />
						</td>
						<td class="td_font">
							工号：
						</td>
						<td>
							<ai:dbformfield formid="configurequeryForm" fieldname="STAFFID"
								width="100" />
						</td>
						<td class="td_font">
							姓名：
						</td>
						<td>
							<ai:dbformfield formid="configurequeryForm" fieldname="STAFFNAME"
								width="100" />
						</td>
						<td class="td_font">
							联系电话：
						</td>
						<td>
							<ai:dbformfield formid="configurequeryForm" fieldname="TELPHONE"
								width="100" />
						</td>
					</tr>
				</table>
				<table align="center">
					<tr>
						<td>
							<ai:button id="newTag" text="查询" onclick="query()" />
						</td>
					</tr>
				</table>
			</ai:dbform>
		</ai:contractframe>

		<ai:contractframe id="configureframe" contenttype="table" title="查询结果"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem>
				<ai:button id="delete" text="删除" onclick="deleteconfigure()" />
			</ai:contractitem>
			<ai:table tableid="configureTable"
				setname="com.asiainfo.costWarn.web.Configure"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.asiainfo.costWarn.service.interfaces.IConfigureSV"
				implservice_querymethod="select(String city, String staffid, String staffname, String bumen, String telphone, int $STARTROWINDEX, int $ENDROWINDEX)"
				implservice_countmethod="count(String city, String staffid, String staffname, String bumen, String telphone)"
				initial="false" multiselect="true" pagesize="10" editable="false"
				width="100%" height="200" needrefresh="true"
				ondbclick="refreshTable">
				<ai:col fieldname="BUMEN" width="20%" />
				<ai:col fieldname="CITY" width="20%" />
				<ai:col fieldname="STAFFNAME" width="20%" />
				<ai:col fieldname="STAFFID" width="20%" />
				<ai:col fieldname="TELPHONE" width="20%" />
			</ai:table>
		</ai:contractframe>

		<ai:contractframe id="configureformid" contenttype="table" title="添加"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:dbform formid="configureForm" initial="false"
				setname="com.asiainfo.costWarn.web.Configure"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.asiainfo.costWarn.service.interfaces.IConfigureSV"
				implservice_querymethod="select(String city, String staffid, String staffname, String bumen, String telphone, int $STARTROWINDEX, int $ENDROWINDEX)"
				editable="true">
				<table width="100%" align="center" border="0" cellpadding="1"
					cellspacing="2">
					<tr id="tr_1">
						<td class="td_font">
							部门：
						</td>
						<td>
							<ai:dbformfield formid="configureForm" fieldname="BUMEN"
								width="100" />
							<span class="font_red">*</span>
						</td>
						<td class="td_font">
							地市：
						</td>
						<td>
							<ai:dbformfield formid="configureForm" fieldname="CITY"
								width="100" />
							<span class="font_red">*</span>
						</td>
						<td class="td_font">
							工号：
						</td>
						<td>
							<ai:dbformfield formid="configureForm" fieldname="STAFFID"
								width="100" />
							<span class="font_red">*</span>
						</td>
						<td class="td_font">
							姓名：
						</td>
						<td>
							<ai:dbformfield formid="configureForm" fieldname="STAFFNAME"
								width="100" />
							<span class="font_red">*</span>
						</td>
						<td class="td_font">
							联系电话：
						</td>
						<td>
							<ai:dbformfield formid="configureForm" fieldname="TELPHONE"
								width="100" />
							<span class="font_red">*</span>
						</td>
					</tr>
					<tr id="query_tr" style="display: block">
						<td id="query_td" class="td_font">
							查询人员：
						</td>
						<td>
							<img id="select" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="selectExistInfo()" align="absmiddle"
								style="cursor: hand;" />
						</td>
					</tr>
					</tr>
				</table>
				<table align="center">
					<tr>
						<td>
							<ai:button id="newTag" text="清空" onclick="clearup()" />
						</td>
						<td>
							<ai:button id="newTag" text="保存" onclick="save()" />
						</td>
					</tr>
				</table>
			</ai:dbform>
		</ai:contractframe>

	</body>
</html>
<script type="text/javascript" src="<%=request.getContextPath()%>/secframe/js/orgmodel/operator/OperatorManager.js"></script>
<script type="text/javascript">
var configureTable = g_TableRowSetManager.get("configureTable");
var configureForm = g_FormRowSetManager.get("configureForm");
var configurequeryForm = g_FormRowSetManager.get("configurequeryForm");
function querytext() {
	var list = new Array();
	list.push(configureTable);
	configureTable.refresh();
}

function save() {
	var list = new Array();
	list.push(configureForm);
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.costWarn.web.ConfigureAction?action=save';
<%--var strUrl = '<%=request.getContextPath()%>/business/asiainfo.costWarn.web.ConfigureAction?action=save&pid=0';--%>
	var recode = saveRowSet(strUrl, list);
	configureTable.refresh();
}

function refreshTable(){
	var curRowIndex = configureTable.getRow();
	var staffid = configureTable.getValue(curRowIndex, "staffid");
	configureForm.refresh("staffid=" + staffid);
}

function query() {
	var bumen = configurequeryForm.getValue("BUMEN");
	var city = configurequeryForm.getValue("CITY");
	var staffid = configurequeryForm.getValue("STAFFID");
	var staffname = configurequeryForm.getValue("STAFFNAME");
	var telphone = configurequeryForm.getValue("TELPHONE");
	var list = new Array();
	list.push(configureTable);
	configureTable.refresh("&bumen=" + encodeURI(trim(bumen)) + "&city=" + city
			+ "&staffid=" + staffid + "&staffname=" + encodeURI(trim(staffname)) + "&telphone=" + telphone);
}
function selectExistInfo(){
 var url = "<%=request.getContextPath()%>/costWarn/StaffSelect.jsp";
 var style = "dialogWidth:300px";
 var retMsg = window.showModalDialog(url, '', style);
 if(retMsg==null || retMsg==''){
    	return;
    } else {
    	configureForm.setValue("STAFFID",retMsg.split(",")[0]);
    	configureForm.setValue("STAFFNAME",retMsg.split(",")[1]);
    	configureForm.setValue("TELPHONE",retMsg.split(",")[2]);
    	configureForm.setValue("BUMEN",retMsg.split(",")[3]);
    }
 
}
function deleteconfigure(){
	var list = new Array();
 	list = configureTable.getSelectedRows();
  	if (list.length < 1) {
	alert("请选择要删除的数据！");
	return;
      }
  	for ( var i = list.length; i > 0; i--) {
	       configureTable.deleteRow(list[i - 1]);
	    }
  	var list = new Array();
	list.push(configureTable);
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.costWarn.web.ConfigureAction?action=deleteconfigure';
	var recode = saveRowSet(strUrl, list);
	configureTable.refresh();
}

function clearup(){
	configureForm.setValue("STAFFID","");
	configureForm.setValue("STAFFNAME","");
	configureForm.setValue("TELPHONE","");
	configureForm.setValue("BUMEN","");
	configureForm.setValue("CITY","");
}

function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, '');
}

</script>

