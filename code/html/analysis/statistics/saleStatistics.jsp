<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="统计信息"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initOper()">
<table width=100%>
	<tr id="sale_tr" style="display: block;">
		<td width = 40%><ai:contractframe id="saleMframe" contenttype="table" title="营销案批次统计信息" width="100%" allowcontract="false" frameclosed="false" frameclosed="false">
		    <ai:contractitem>
	         </ai:contractitem>
		    <ai:table
		        tableid="saleMainTable"
		        setname="com.asiainfo.bi.web.SETStatistics"
		        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		        implservice_name="com.asiainfo.bi.service.interfaces.IStatisticsSV"
		        implservice_querymethod="getStatistics(String objectType)"
		        initial="false" pagesize="100" width="100%" editable="false" 
		        height="355" needrefresh="true">
		        <ai:col fieldname="ORG_ID" width="100"/>
		        <ai:col fieldname="A1" width="100" />
	            <ai:col fieldname="A2" width="100" />
	            <ai:col fieldname="A3" width="100" />
	            <ai:col fieldname="A" width="100" />
		    </ai:table>
			</ai:contractframe></td>
		<td width = 40%><ai:contractframe id="saleDframe" contenttype="table" title="营销案档次统计信息" width="100%" allowcontract="false" frameclosed="false" frameclosed="false">
		    <ai:contractitem>
	         </ai:contractitem>
		    <ai:table
		        tableid="saleDetailTable"
		        setname="com.asiainfo.bi.web.SETStatistics"
		        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		        implservice_name="com.asiainfo.bi.service.interfaces.IStatisticsSV"
		        implservice_querymethod="getStatistics(String objectType)"
		        initial="false" pagesize="100" width="100%" editable="false" 
		        height="355" needrefresh="true">
		        <ai:col fieldname="ORG_ID" width="100"/>
		        <ai:col fieldname="A1" width="100" />
	            <ai:col fieldname="A2" width="100" />
	            <ai:col fieldname="A3" width="100" />
	            <ai:col fieldname="A" width="100" />
		    </ai:table>
			</ai:contractframe></td>
	</tr>
	<tr id="charge_tr" style="display: block;">
		<td width = 40%><ai:contractframe id="chargeMframe" contenttype="table" title="资费批次统计信息" width="100%" allowcontract="false" frameclosed="false" frameclosed="false">
		    <ai:contractitem>
	         </ai:contractitem>
		    <ai:table
		        tableid="chargeMainTable"
		        setname="com.asiainfo.bi.web.SETStatistics"
		        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		        implservice_name="com.asiainfo.bi.service.interfaces.IStatisticsSV"
		        implservice_querymethod="getStatistics(String objectType)"
		        initial="false" pagesize="100" width="100%" editable="false" 
		        height="355" needrefresh="true">
		        <ai:col fieldname="ORG_ID" width="100"/>
		        <ai:col fieldname="A1" width="100" />
	            <ai:col fieldname="A2" width="100" />
	            <ai:col fieldname="A3" width="100" />
	            <ai:col fieldname="A" width="100" />
		    </ai:table>
			</ai:contractframe></td>
		<td width = 40%><ai:contractframe id="chargeDframe" contenttype="table" title="资费档次统计信息" width="100%" allowcontract="false" frameclosed="false" frameclosed="false">
		    <ai:contractitem>
	         </ai:contractitem>
		    <ai:table
		        tableid="chargeDetailTable"
		        setname="com.asiainfo.bi.web.SETStatistics"
		        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		        implservice_name="com.asiainfo.bi.service.interfaces.IStatisticsSV"
		        implservice_querymethod="getStatistics(String objectType)"
		        initial="false" pagesize="100" width="100%" editable="false" 
		        height="355" needrefresh="true">
		        <ai:col fieldname="ORG_ID" width="100"/>
		        <ai:col fieldname="A1" width="100" />
	            <ai:col fieldname="A2" width="100" />
	            <ai:col fieldname="A3" width="100" />
	            <ai:col fieldname="A" width="100" />
		    </ai:table>
			</ai:contractframe></td>
	</tr>
	<tr id="weapontr" style="display: block;">
		<td><ai:contractframe id="weaponframe" contenttype="table" title="武器统计信息" width="100%" allowcontract="false" frameclosed="false" frameclosed="false">
			    <ai:contractitem>
		         </ai:contractitem>
			    <ai:table
			        tableid="weaponTable"
			        setname="com.asiainfo.bi.web.SETStatistics"
			        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			        implservice_name="com.asiainfo.bi.service.interfaces.IStatisticsSV"
			        implservice_querymethod="getStatistics(String objectType)"
			        initial="false" pagesize="100" width="100%" editable="false" 
			        height="355" needrefresh="true">
			        <ai:col fieldname="ORG_ID" width="100"/>
			        <ai:col fieldname="A1" width="100" />
		            <ai:col fieldname="A2" width="100" />
		            <ai:col fieldname="A3" width="100" />
		            <ai:col fieldname="A" width="100" />
			    </ai:table>
			</ai:contractframe>
		</td>
	 </tr>
</table>
</body>

<script type="text/javascript">

function initOper()
{
   	g_TableRowSetManager.get("saleMainTable").refresh("&objectType=" + 'saleM');
   	g_TableRowSetManager.get("saleDetailTable").refresh("&objectType=" + 'saleD');
   	g_TableRowSetManager.get("chargeMainTable").refresh("&objectType=" + 'chargeM');
   	g_TableRowSetManager.get("chargeDetailTable").refresh("&objectType=" + 'chargeD');
   	g_TableRowSetManager.get("weaponTable").refresh("&objectType=" + 'weapon');
}

</script>
</html>