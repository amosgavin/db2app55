<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<ai:comment author="������" date="2004-12-16">
    Title:SINGLE_FORM������ҳ��ģ��
    Description: ҳ�溬�е�������������ɾ�������水ť
    Copyright: Copyright (c) 2004
    Company: AsiaINFO(NanJing)

    ��Ҫ���õ����԰�����
        ����Form.setname="����Form��SET����"
        ����Form.conditionname="����ȫ��Ψһ���,��OBDAction������ѯ����ʹ��"
        ����Form.parametersname="����OBDActionClassName"
        ����detailFormSave�����еı���Action�����ƺͷ�������
</ai:comment>

<html>
<head>
<title>
 SINGLE_FORM������ҳ��ģ��
</title>
</head>
<body bgcolor="#ffffff" >

<div style="width:100%;height:100%;overflow:auto">
  <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
      <td valign="top">
<!--����д�����棺�м���ģ����ü���table��table�Ŀ�Ȳ��ɳ���900�����DBGrid����900������'div'�м���'style="width:900;overflow:auto"';�߶Ȳ�Ҫ����-->
<!--�������ݿ�ʼ-->
<!--������ʼ-->
<ai:contentframe id="��ϸ��Ϣ" contenttype="form" title="��ϸ��Ϣ" width="600">
<ai:dbform formid="detailForm" setname="����Form��SET����" datamodel="com.ai.appframe2.web.obd.OBDDataModel" onvalchange="detailForm_ValueChange" conditionname="����ȫ��Ψһ���,��OBDAction������ѯ����ʹ��" parametersname="����OBDActionClassName" editable="true" initial="true">
</ai:dbform>

<ai:script id="gdetailFormRowSet" remark="��ȡ������">
  return g_FormRowSetManager.get("detailForm");
</ai:script>

<ai:script id="detailForm_ValueChange" parameters="col,oldValue,newValue" remark="�� detailForm ���ݵ�Ԫֵ�ı��¼�����">
��var rowset = gdetailFormRowSet();
  //�û�����------begin

</ai:script>

<ai:script id="detailFormAddNew" parameters="" remark="��� detailForm ��������">
��var rowset = gdetailFormRowSet();
      rowset.newRow();
  //�û�����------begin

</ai:script>

<ai:script id="detailFormDelete" parameters="" remark="��� detailForm ɾ������">
��var rowset = gdetailFormRowSet();
    var row_no=rowset.getRow();
    if (row_no==null||row_no==undefined||row_no=="undefined"||row_no==-1){
        alert("��ѡ��һ������!");
        return;
    }
    rowset.deleteRow();
  //�û�����------begin

</ai:script>

<ai:script id="detailFormSave" parameters="" remark="��� detailForm ���溯��">


��var rowset = gdetailFormRowSet();
    if (rowset.toXmlString(true)==""){
        alert("��û���޸��κ�����,���ĳ������������һ�ո�");
      return;
    }
    var list = new Array();
    list[list.length]=rowset;
    var r=saveRowSet('<%=request.getContextPath()%>/business/����ActionName?action=save',list);
    //�û�����------begin
</ai:script>

</ai:contentframe>
<!--��������-->

<ai:pagearea id="��ť����">
<table border="0" width="60%" align="center">
    <tr>
          <td align="right" width="100"><ai:button text="����" id="btntableAddNew" onclick="detailFormAddNew();"></ai:button></td>
          <td align="right" width="100"><ai:button text="ɾ��" id="btntableDelete" onclick="detailFormDelete();"></ai:button></td>
          <td align="right" width="100"><ai:button text="����" id="btntableSave" onclick="detailFormSave();" enable=""></ai:button></td>
       </tr>
</table>
</td></tr>
</table>
</ai:pagearea>
</div>
</BODY>
</HTML>
