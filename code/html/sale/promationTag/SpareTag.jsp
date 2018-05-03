<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>选择备用标签</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body>

<ai:table setname="com.asiainfo.sale.tag.web.SETPromationTag"
			tableid="spareTagTab" multiselect="true" editable="true"
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			needrefresh="true" pagesize="15" initial="true" width="600" height = "350"
			implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			implservice_querymethod="getTagDetailInSpare(String charge, String tag_type, int $STARTROWINDEX, int $ENDROWINDEX)"
			implservice_countmethod="getTagInSpareCount(String charge, String tag_type)" 
			>
	        <ai:col fieldname="ID" width="80" editable="false" visible="true" /> 
	        <ai:col fieldname="TAG_TYPE" width="120" editable="false" visible="true" /> 
			<ai:col fieldname="CHARGE" width="125" editable="false" visible="true" />
			<ai:col fieldname="NAME" width="125" editable="false" visible="true"/>
			<ai:col fieldname="CYCLE" width="125" editable="false" visible="true"/> 
</ai:table>
	
<ai:dbform formid="tagDetailForm" initial="false"  
			setname="com.asiainfo.sale.tag.web.SETPromationTag" 
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		    editable="true">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
	        <tr>
	           		<td class="td_font">标识类型：</td>
	           		<td><ai:dbformfield formid="tagDetailForm" fieldname="TAG_TYPE" width="110"/></td>
	           		<td class="td_font">标识金额：</td>
	           		<td><ai:dbformfield formid="tagDetailForm" fieldname="CHARGE" width="110"/></td>
	           		<td> <ai:button id="queryTag" text="查    询" onclick="queryTagbyCharge()"/></td>
	        </tr>
	        <tr>
	           	<td align="right" class="td_button" colspan="3"><ai:button text = "取        消" onclick="cancel()"/></td>
				<td align="left" class="td_button" colspan="3"><ai:button text = "确        定" onclick="commitSelectTag()"/></td>
			</tr>
	     </table>
</ai:dbform>

<ai:loginuser/>
<script type="text/javascript">
function cancel()
{	
	window.self.close();
}
	
function getDbTableSelectTag()
{
	return g_TableRowSetManager.get("spareTagTab");
}

function commitSelectTag()
{
	var dbTableSelectTag = g_TableRowSetManager.get("spareTagTab");
	var selRows = new Array();
	var idList = new Array();
	selRows = dbTableSelectTag.getSelectedRows();
	if(selRows != null && selRows.length > 0)
	{
		var sleRowCount = selRows.length;
		var i = -1;
		while (sleRowCount > 0) {
			sleRowCount--;
			idList[++i] = dbTableSelectTag.getValue(selRows[sleRowCount], "ID");
		}
		alert(idList);
    	window.returnValue = idList;
	    window.self.close();
	} else{
		alert("选择条数为0，请选择！")
	}
}

function queryTagbyCharge()
{
	var _formTagMainRowSet = g_FormRowSetManager.get("tagDetailForm");
	var charge = _formTagMainRowSet.getValue("CHARGE");
	var tag_type = _formTagMainRowSet.getValue("TAG_TYPE");
	if(charge==''){
		charge = "-1";
	}
	if(tag_type==''){
		tag_type = "-1";
	}
	var _tagDetailTable = g_TableRowSetManager.get("spareTagTab");
	var param = "&charge=" + charge+"&tag_type=" + tag_type;
    _tagDetailTable.refresh(param);
}

</script>
</body>
</html>