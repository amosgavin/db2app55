<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<ai:comment author="张联华" date="2004-12-16">
    Title:SINGLE_FORM单个表单页面模版
    Description: 页面含有单个表单和新增、删除、保存按钮
    Copyright: Copyright (c) 2004
    Company: AsiaINFO(NanJing)

    需要设置的属性包括：
        １、Form.setname="输入Form的SET名称"
        ２、Form.conditionname="输入全局唯一编号,供OBDAction决定查询参数使用"
        ３、Form.parametersname="输入OBDActionClassName"
        ４、detailFormSave函数中的保存Action类名称和方法名称
</ai:comment>

<html>
<head>
<title>
 SINGLE_FORM单个表单页面模版
</title>
</head>
<body bgcolor="#ffffff" >

<div style="width:100%;height:100%;overflow:auto">
  <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
      <td valign="top">
<!--内容写在下面：有几个模块就用几个table；table的宽度不可超过900，如果DBGrid超过900，则在'div'中加入'style="width:900;overflow:auto"';高度不要定义-->
<!--功能内容开始-->
<!--容器开始-->
<ai:contentframe id="详细信息" contenttype="form" title="详细信息" width="600">
<ai:dbform formid="detailForm" setname="输入Form的SET名称" datamodel="com.ai.appframe2.web.obd.OBDDataModel" onvalchange="detailForm_ValueChange" conditionname="输入全局唯一编号,供OBDAction决定查询参数使用" parametersname="输入OBDActionClassName" editable="true" initial="true">
</ai:dbform>

<ai:script id="gdetailFormRowSet" remark="获取表单对象">
  return g_FormRowSetManager.get("detailForm");
</ai:script>

<ai:script id="detailForm_ValueChange" parameters="col,oldValue,newValue" remark="表单 detailForm 数据单元值改变事件函数">
　var rowset = gdetailFormRowSet();
  //用户代码------begin

</ai:script>

<ai:script id="detailFormAddNew" parameters="" remark="表格 detailForm 新增函数">
　var rowset = gdetailFormRowSet();
      rowset.newRow();
  //用户代码------begin

</ai:script>

<ai:script id="detailFormDelete" parameters="" remark="表格 detailForm 删除函数">
　var rowset = gdetailFormRowSet();
    var row_no=rowset.getRow();
    if (row_no==null||row_no==undefined||row_no=="undefined"||row_no==-1){
        alert("请选择一行数据!");
        return;
    }
    rowset.deleteRow();
  //用户代码------begin

</ai:script>

<ai:script id="detailFormSave" parameters="" remark="表格 detailForm 保存函数">


　var rowset = gdetailFormRowSet();
    if (rowset.toXmlString(true)==""){
        alert("您没有修改任何数据,清空某项数据请输入一空格！");
      return;
    }
    var list = new Array();
    list[list.length]=rowset;
    var r=saveRowSet('<%=request.getContextPath()%>/business/输入ActionName?action=save',list);
    //用户代码------begin
</ai:script>

</ai:contentframe>
<!--容器结束-->

<ai:pagearea id="按钮区域">
<table border="0" width="60%" align="center">
    <tr>
          <td align="right" width="100"><ai:button text="新增" id="btntableAddNew" onclick="detailFormAddNew();"></ai:button></td>
          <td align="right" width="100"><ai:button text="删除" id="btntableDelete" onclick="detailFormDelete();"></ai:button></td>
          <td align="right" width="100"><ai:button text="保存" id="btntableSave" onclick="detailFormSave();" enable=""></ai:button></td>
       </tr>
</table>
</td></tr>
</table>
</ai:pagearea>
</div>
</BODY>
</HTML>
