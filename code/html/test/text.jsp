<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<title>�����ƶ���˾Ӫ������ϵͳ</title>
		<script language="javascript"
			src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js"
			type="text/javascript">
</script>
	</head>
	<body onload="init();">
		<ai:contractframe id="textframe" contenttype="table" title="Test"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:table tableid="textTable" setname="com.text.web.settext"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.text.service.interfaces.ITextSV"
				implservice_querymethod="select(String id,String address,String city,int $STARTROWINDEX, int $ENDROWINDEX)"
				implservice_countmethod="count(String id,String address,String city)"
				initial="false" multiselect="true" pagesize="3" editable="false"
				width="100%" height="100" needrefresh="true" ondbclick="update">
				<ai:col title="���" fieldname="ID" width="80" />
				<ai:col title="��ַ" fieldname="ADDRESS" width="300" />
				<ai:col title="����" fieldname="CITY" width="100" />
			</ai:table>
		</ai:contractframe>


		<ai:contractframe id="textformid" contenttype="table" title="��д������Ϣ"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:dbform formid="textForm" initial="false"
				setname="com.text.web.settext"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.text.service.interfaces.ITextSV"
				implservice_querymethod="select(String id,String address,String city,int $STARTROWINDEX, int $ENDROWINDEX)"
				editable="true">
				<table width="98%" align="center" border="0" cellpadding="1"
					cellspacing="2">
					<tr id="tr_1">
						<td class="td_font">
							������
						</td>
						<td>
							<ai:dbformfield formid="textForm" fieldname="NAME" width="150" />
							<span class="font_red">*</span>
						</td>
						<td class="td_font">
							��ַ��
						</td>
						<td>
							<ai:dbformfield formid="textForm" fieldname="ADDRESS" width="150" />
							<span class="font_red">*</span>
						</td>
						<%--
						<td class="td_font">
							���У�
						</td>
						<td>
							<ai:dbformfield formid="textForm" fieldname="CITY" width="150" />
							<span class="font_red">*</span>
						</td>

						--%>
						<td class="td_font">
							��ʼʱ�䣺
						</td>
						<td>
							<ai:dbformfield formid="textForm" fieldname="TIME_BEGIN"
								width="150" />
							<span class="font_red">*</span>
						</td>
						<%--
						<td class="td_font">
							������ݣ�
						</td>
						<td>
							<ai:dbformfield formid="textForm" fieldname="CITY" width="200"
								height="50" editable="false" />
							<img id="selectStaff" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								onClick="clearup();" align="absmiddle" style="cursor: hand;" />
							<span class="font_red">*</span>
						</td>
					--%>
					</tr>

					<tr>
						<td class="td_font">
							�����������ͣ�
						</td>
						<td>
							<ai:dbformfield formid="textForm" fieldname="CITY" width="180" />
							<img id="selectStaff" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								onClick="clearup()" align="absmiddle" style="cursor: hand;" />
							<span class="font_red">*</span>
						</td>
						<td id="query_td" class="td_font">
							��ѯӪ������
						</td>
						<td>
							<img id="select" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="query()" align="absmiddle"
								style="cursor: hand;" />
						</td>
					</tr>



				</table>
				<table align="center">
					<tr>
						<td>
							<ai:button id="newTag" text="���" onclick="clearup()" />
						</td>
						<td>
							<ai:button id="newTag" text="��ť" onclick="button()" />
						</td>
						<td>
							<ai:button id="newTag" text="���/����" onclick="save()" />
						</td>
					</tr>
				</table>
			</ai:dbform>
		</ai:contractframe>

	</body>
</html>
<ai:loginuser />
<script language="javascript"
	src="<%=request.getContextPath()%>/sale/common/js/openSelect.js">
</script>
<script type="text/javascript">

var textForm = g_FormRowSetManager.get("textForm");
var textTable = g_TableRowSetManager.get("textTable");
function init() {
	textTable.refresh("name='����'");
	textTable.refresh("city=" + encodeURI("�人"));
	textTable.refresh();
	textForm.setFocus("CITY");
	//document.getElementById("tr_1").style.display="none";
}

function update() {
	var curRowIndex = textTable.getRow();
	var xh = textTable.getValue(curRowIndex, "address");
	console.log(xh);
	textForm.refresh("address=" + xh);
}
function clearup() {
	//textTable.deleteRow(rowIndex);
	var curRowIndex = textTable.getRow();
	var totalCn = textTable.getTotalRowCount();
	var city = textTable.getValue(curRowIndex, "CITY");
	//var url = "<%=request.getContextPath()%>/sale/common/modaldialog/BusiChangeTypeMultiplySelected.jsp";
	//var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
	//var iniVal = "text";//textForm.getValue("CITY");
	//textForm.setValue("CITY", onItemMultiplySelected(url, iniVal, style));
	//alert(curRowIndex+"--" + totalCn);
	//textTable.deleteRow(curRowIndex);
	//textTable.getValue(curRowIndex,"CITY");
	//alert(city);
	//textTable.clear();
	//console.log(city);
	//textTable.setValue("1", "CITY", "�Ϻ�");
	var url = "<%=request.getContextPath()%>/sale/common/modaldialog/channelTypeMultiplySelected.jsp";
	var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
	var iniVal = textForm.getValue("CITY");
	textForm.setValue("CITY", onItemMultiplySelected(url, iniVal, style));
}
function save() {
	var list = new Array();
	list.push(textForm);
	var strUrl = '<%=request.getContextPath()%>/business/com.text.web.TextAction?action=save&pid=0';
	var recode = saveRowSet(strUrl, list);
	textTable.refresh();
}
function update() {
	var curRowIndex = textTable.getRow();
	var xh = textTable.getValue(curRowIndex, "address");
	console.log(xh);
	textForm.refresh("address=" + xh);
}
function query(){
	var changeObject = 'sale';
	var url = "<%=request.getContextPath()%>/sale/access/include/_selectSaleOrCharge.jsp?batchType="+changeObject;
    var style = "dialogWidth:800px";
    var retMsg = window.showModalDialog(url, '', style);
}--%>
</script>