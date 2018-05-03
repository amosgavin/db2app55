<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<title>湖北移动公司营销管理系统</title>
	</head>
	<body onload="querytext()">
		<ai:contractframe id="selectformid" contenttype="table"
			title="查询条件" width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:dbform formid="selectForm" initial="false"
				setname="com.asiainfo.costWarn.web.SelectStaff"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.asiainfo.costWarn.service.interfaces.ISelectStaffSV"
				implservice_querymethod="selectstaff(String staffid, String staffname, String billid, int $STARTROWINDEX, int $ENDROWINDEX)"
				editable="true">
				<table width="100%" align="center" border="0" cellpadding="1"
					cellspacing="2">
					<tr id="tr_1">
						<td class="td_font">
							姓名：
						</td>
						<td>
							<ai:dbformfield formid="selectForm" fieldname="BUMEN"
								width="100" />
							<span class="font_red">*</span>
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

		<ai:contractframe id="selectframe" contenttype="table" title="查询结果"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem>
			</ai:contractitem>
			<ai:table tableid="selectTable"
				setname="com.asiainfo.costWarn.web.SelectStaff"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.asiainfo.costWarn.service.interfaces.ISelectStaffSV"
				implservice_querymethod="selectstaff(String staffid, String staffname, String billid, int $STARTROWINDEX, int $ENDROWINDEX)"
				implservice_countmethod="countstaff(String staffid, String staffname, String billid)"
				initial="false" multiselect="true" pagesize="10" editable="false"
				width="100%" height="200" needrefresh="true">
				<ai:col fieldname="STAFF_ID" width="20%" />
				<ai:col fieldname="STAFF_NAME" width="20%" />
				<ai:col fieldname="BILL_ID" width="20%" />
			</ai:table>
		</ai:contractframe>

	</body>
</html>
<script type="text/javascript">
var selectTable = g_TableRowSetManager.get("selectTable");
var selectForm = g_FormRowSetManager.get("selectForm");
function querytext() {
	var list = new Array();
	list.push(selectTable);
	selectTable.refresh();
}

</script>

