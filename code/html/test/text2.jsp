<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<title>�����ƶ���˾Ӫ������ϵͳ</title>
	</head>
	<body onload="querytext()">
		<ai:contractframe id="textformid" contenttype="table" title="��ѯ����"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:dbform formid="text2Form" initial="false"
				setname="com.text2.web.settext2"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.text2.service.interfaces.IText2SV"
				implservice_querymethod="select(String number,String name,String height,String score,int $STARTROWINDEX, int $ENDROWINDEX)"
				editable="true">
				<table width="98%" align="center" border="0" cellpadding="1"
					cellspacing="2">
					<tr id="tr_1">
						<td class="td_font">
							ѧ�ţ�
						</td>
						<td>
							<ai:dbformfield formid="text2Form" fieldname="NUMBER" width="150" />
							<span class="font_red">*</span>
						</td>
						<td class="td_font">
							������
						</td>
						<td>
							<ai:dbformfield formid="text2Form" fieldname="NAME" width="150" />
							<span class="font_red">*</span>
						</td>
						<td class="td_font">
							��ߣ�
						</td>
						<td>
							<ai:dbformfield formid="text2Form" fieldname="HEIGHT" width="150" />
							<span class="font_red">*</span>
						</td>
						<td class="td_font">
							�ɼ���
						</td>
						<td>
							<ai:dbformfield formid="text2Form" fieldname="SCORE" width="150" />
							<span class="font_red">*</span>
						</td>
					</tr>
				</table>
				<table align="center">
					<tr>
						<td>
							<ai:button id="newTag" text="��ѯ" onclick="query()" />
						</td>
					</tr>
				</table>
			</ai:dbform>
		</ai:contractframe>


		<ai:contractframe id="textframe" contenttype="table" title="��ѯ���"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem>
				<ai:button id="delete" text="ɾ��" onclick="deletetable()" />
			</ai:contractitem>
			<ai:table tableid="textTable" setname="com.text2.web.settext2"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.text2.service.interfaces.IText2SV"
				implservice_querymethod="select(String number,String name,String height,String score,int $STARTROWINDEX, int $ENDROWINDEX)"
				implservice_countmethod="count(String number,String name,String height,String score)"
				initial="false" multiselect="true" pagesize="10" editable="false"
				width="100%" height="200" needrefresh="true" ondbclick="shuaxin">
				<ai:col title="ѧ��" fieldname="NUMBER" width="20%" />
				<ai:col title="����" fieldname="NAME" width="20%" />
				<ai:col title="���" fieldname="HEIGHT" width="20%" />
				<ai:col title="�ɼ�" fieldname="SCORE" width="20%" />
				<ai:col title="ʱ��" fieldname="TIME" width="20%" />
				<ai:col title="��ַ" fieldname="ADDRESS" width="20%" />
			</ai:table>
		</ai:contractframe>

		<ai:contractframe id="texttianxie" contenttype="table" title="���"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:dbform formid="textForm" initial="false"
				setname="com.text2.web.settext2"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.text2.service.interfaces.IText2SV"
				implservice_querymethod="select(String number,String name,String height,String score,int $STARTROWINDEX, int $ENDROWINDEX)"
				editable="true">
				<table width="98%" align="center" border="0" cellpadding="1"
					cellspacing="2">
					<tr id="tr_1">
						<td class="td_font">
							ѧ�ţ�
						</td>
						<td>
							<ai:dbformfield formid="textForm" fieldname="NUMBER" width="150" />
							<span class="font_red">*</span>
						</td>
						<td class="td_font">
							������
						</td>
						<td>
							<ai:dbformfield formid="textForm" fieldname="NAME" width="150"   />
							<span class="font_red">*</span>
						</td>
						<td class="td_font">
							��ߣ�
						</td>
						<td>
							<ai:dbformfield formid="textForm" fieldname="HEIGHT" width="150" />
							<span class="font_red">*</span>
						</td>
						<td class="td_font">
							�ɼ���
						</td>
						<td>
							<ai:dbformfield formid="textForm" fieldname="SCORE" width="150" />
							<span class="font_red">*</span>
						</td>
					</tr>
					<tr>
					<td class="td_font">
							ʱ�䣺
						</td>
						<td>
							<ai:dbformfield formid="textForm" fieldname="TIME" width="150" />
							<span class="font_red">*</span>
						</td>
						<td class="td_font">
							��ַ��
						</td>
						<td>
							<ai:dbformfield formid="textForm" fieldname="ADDRESS" width="150" />
							<span class="font_red">*</span>
						</td>
                        <tr id="bt_check" style="display: block;">
                        <td class="td_font"> ��ѡ��</td>
                        <td>
						   <input id="a_checkbox" type="checkbox" value="hehe" /> 
					   </td>
						</tr>
				</tr>
				</table>
				<table align="center">
					<tr>
					    <td>
							<ai:button id="newTag" text="���" onclick="clearup()" />
						</td>
						<td>
							<ai:button id="newTag" text="����" onclick="save()" />
						</td>
					</tr>
				</table>
			</ai:dbform>
		</ai:contractframe>



	</body>
</html>
<script type="text/javascript">
var textTable = g_TableRowSetManager.get("textTable");
var text2Form = g_FormRowSetManager.get("text2Form");
var textForm = g_FormRowSetManager.get("textForm");
function querytext() {
	var list = new Array();
	list.push(textTable);
	textTable.refresh();
    textForm.setFocus("ADDRESS");
}
function query() {
	var number = text2Form.getValue("NUMBER");
	var name = text2Form.getValue("NAME");
	var height = text2Form.getValue("HEIGHT");
	var score = text2Form.getValue("SCORE");
	var list = new Array();
	list.push(textTable);
	textTable.refresh("&number=" + number + "&name=" + encodeURI(trim(name))
			+ "&height=" + height + "&score=" + score);

}
function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, '');
}

function save() {
	var s =document.getElementById("a_checkbox").checked;
	alert(s);
	var list = new Array();
	list.push(textForm);
	var address=textForm.getValue("ADDRESS");
	alert(address);
	var strUrl = '<%=request.getContextPath()%>/business/com.text2.web.Text2Action?action=save&pid=0';
	var recode = saveRowSet(strUrl, list);
	textTable.refresh();
	textForm.setColEditSts("NUMBER", false);
	textForm.setColEditSts("NAME", false);
	textForm.setColEditSts("HEIGHT", false);
	textForm.setColEditSts("SCORE", false);
}

function deletetable(){
	debugger;
	var list = new Array();
 	list = textTable.getSelectedRows();
  	if (list.length < 1) {
	alert("��ѡ��Ҫɾ�������ݣ�");
	return;
      }
  	for ( var i = list.length; i > 0; i--) {
	       textTable.deleteRow(list[i - 1]);
	    }
  	var list = new Array();
	list.push(textTable);
	var strUrl = '<%=request.getContextPath()%>/business/com.text2.web.Text2Action?action=deletetest2&pid=0';
	var recode = saveRowSet(strUrl, list);
	query();
 }
function shuaxin(){
	var curRowIndex = textTable.getRow();
	var number = textTable.getValue(curRowIndex, "number");
	textForm.refresh("number="+number);
	textForm.setColEditSts("NUMBER", true);
	textForm.setColEditSts("NAME", true);
	textForm.setColEditSts("HEIGHT", true);
	textForm.setColEditSts("SCORE", true);
	
}
function clearup(){
	textForm.setValue("NUMBER","");
	textForm.setValue("NAME","");
	textForm.setValue("HEIGHT","");
	textForm.setValue("HEIGHT","");
	textForm.setValue("TIME","");
}
</script>

