<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="修改标签" res="i18n.secframe_resource"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initPage()">

<ai:contractframe id="tagDetailframe" contenttype="table" title="标识明细" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:dbform setname="com.asiainfo.sale.tag.web.SETPromationTag"
			  formid="tagDetailForm" editable="true" initial="false"
			  datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			  implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			  implservice_querymethod="getTagDetailById(int id)"			  
			  >
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
	        <tr>
	        	<td style='display:none'><ai:dbformfield formid="tagDetailForm" fieldname="WPID" width="150"/></td>
	        	<td class="td_font">标识类型：</td>
	           	<td><ai:dbformfield formid="tagDetailForm" fieldname="TAG_TYPE" width="150" editable="false"/></td>
				<td class="td_font">标签名：</td>
	           	<td><ai:dbformfield formid="tagDetailForm" fieldname="NAME" width="150" editable="true"/></td>
	         </tr><tr>
	           	<td class="td_font">金额(元)：</td>
	           	<td><ai:dbformfield formid="tagDetailForm" fieldname="CHARGE" width="150" editable="true"/></td>
	           	<td class="td_font">月数(月)：</td>
	           	<td><ai:dbformfield formid="tagDetailForm" fieldname="CYCLE" width="150" editable="true"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>	

<table align = "center">
	<ai:button id="deleteAttachFile" text="取   消" onclick="cancel()"/>
	<ai:button id="downloadAttachFile" text="保   存" onclick="save()"/>
</table>

<script type="text/javascript">

var id = <%=request.getParameter("id")%>;
var _formTagDetailRowSet = g_FormRowSetManager.get("tagDetailForm");

function initPage()
{
	_formTagDetailRowSet.refresh("&id=" + id);
}

function cancel()
{
	top.close();
}

function save()
{
	var list = new Array();
	list.push(_formTagDetailRowSet);
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveDetailTag&pid=0';
	var recode = saveRowSet(strUrl, list);
	top.close();
}

function trim(str)
{
     return str.replace(/(^\s*)(\s*$)/g, '');
}
</script>
