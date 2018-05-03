<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>所有标签</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body>
<ai:contractframe id="tagSearchframe" contenttype="table" title="标签查找" width="100%" allowcontract="true" frameclosed="fale">
<ai:contractitem/>
<ai:dbform formid="tagDetailForm" initial="false" editable="true"  
			setname="com.asiainfo.sale.tag.web.SETPromationTag" 
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		    >
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
	        <tr>
	           		<td class="td_font">标识类型：</td>
	           		<td><ai:dbformfield formid="tagDetailForm" fieldname="TAG_TYPE" width="130"/></td>
	           		<td class="td_font">标识名：</td>
	           		<td><ai:dbformfield formid="tagDetailForm" fieldname="NAME" width="170"/></td>
	           		<td class="td_font">标识金额：</td>
	           		<td><ai:dbformfield formid="tagDetailForm" fieldname="CHARGE" width="110"/>
	           		<select id="chargeSelect" onchange = "chargeSelect()">
					  <option id="">选择</option>
					  <option id="0">0</option>
					  <option id="3">3</option>
					  <option id="5">5</option>
					  <option id="7">7</option>
					  <option id="8">8</option>
					  <option id="9">9</option>
					  <option id="10">10</option>
					  <option id="12">12</option>
					  <option id="15">15</option>
					  <option id="16">16</option>
					  <option id="17">17</option>
					  <option id="20">20</option>
					  <option id="24">24</option>
					  <option id="30">30</option>
					  <option id="32">32</option>
					  <option id="33">33</option>
					  <option id="40">40</option>
					  <option id="48">48</option>
					  <option id="50">50</option>
					  <option id="72">72</option>
					  <option id="80">80</option>
					  <option id="100">100</option>
					  <option id="200">200</option>
					  <option id="360">360</option>
					</select></td>
					<td class="td_font">状态：</td>
	           		<td><ai:dbformfield formid="tagDetailForm" fieldname="STATE" width="170"/></td></tr>
	        <tr align="center">
	       
	        <td colspan="6" align="center"><ai:button id="queryTag" text="查      询" onclick="queryTag()"/></td></tr>
	     </table>
</ai:dbform>
</ai:contractframe>
<ai:contractframe id="tagDetailframe" contenttype="table" title="所有标签" width="100%" allowcontract="true" frameclosed="fale">
<ai:contractitem/>
<ai:table setname="com.asiainfo.sale.tag.web.SETPromationTag"
			tableid="allTagTab" editable="false" 
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			needrefresh="true" pagesize="18" initial="false" width="100%" height = "380"
			implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			implservice_querymethod="queryTagDetail(String charge,String tagType,String month,String orgid,String chargename, String state, int $STARTROWINDEX, int $ENDROWINDEX)"
			implservice_countmethod="getTagDetailCount(String charge,String tagType,String month,String orgid,String chargename, String state)" 
			ondbclick = "showMainTag">
	        <ai:col title="标签编号" fieldname="ID" width="100" editable="false" visible="true" />
	        <ai:col fieldname="PID" width="100" editable="false" visible="false" /> 
	        <ai:col fieldname="TAG_TYPE" width="180" editable="false" visible="true" /> 
			<ai:col fieldname="CHARGE" width="170" editable="false" visible="true" />
			<ai:col fieldname="NAME" width="380" editable="false" visible="true"/>
			<ai:col fieldname="CYCLE" width="150" editable="false" visible="true"/> 
			<ai:col fieldname="STATE" width="150" editable="false" visible="true"/>
</ai:table>
</ai:contractframe>	

<ai:loginuser/>
<script type="text/javascript">

function chargeSelect()
{
	var listBox = document.getElementById("chargeSelect");
	var _formTagDetailRowSet = g_FormRowSetManager.get("tagDetailForm");
	_formTagDetailRowSet.setValue("CHARGE", listBox.options[listBox.selectedIndex].id);
	listBox.value = "";
}

function queryTag()
{
	var _tableTagRowSet = g_TableRowSetManager.get("allTagTab");
	var _formTagMainRowSet = g_FormRowSetManager.get("tagDetailForm");
	var charge = _formTagMainRowSet.getValue("CHARGE");
	var tagType = _formTagMainRowSet.getValue("TAG_TYPE");
	var state = _formTagMainRowSet.getValue("STATE");
	var tagName = _formTagMainRowSet.getValue("Name");
	//if (tagName == null) tagName='11';
	var _tagDetailTable = g_TableRowSetManager.get("spareTagTab");
	var param = "&charge=" + charge+"&tagType=" + tagType + "&chargename=" + encodeURI(trim(tagName)) + "&state=" + state;
    _tableTagRowSet.refresh(param);
}

function showMainTag()
{
	var tableRowSet = g_TableRowSetManager.get("allTagTab");
	var curRowIndex = tableRowSet.getCurRowIndex();
	var mainId = tableRowSet.getValue(curRowIndex, "PID");
	var _formTagMainRowSet = g_FormRowSetManager.get("tagMainForm");
	_formTagMainRowSet.refresh("&id=" + mainId);
}

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>
</body>
</html>