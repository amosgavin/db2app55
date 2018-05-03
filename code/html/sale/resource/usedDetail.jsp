<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>营销资源使用情况</title>
		<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
		<script language="javascript" src="<%=request.getContextPath()%>/jsv2/DBListBox.js" type="text/javascript"></script>
	</head>
  	<body onload="initPage();">
  	<div id="used_div">
	    <ai:contractframe id="saleResAllotTFrame" contenttype="table" title="各地市营销资源使用（%）" width="75%" allowcontract="false" frameclosed="false">
		    <ai:contractitem/>
		    <ai:table
		        tableid="saleResUsedTable" 
		        setname="com.asiainfo.sale.activity.web.SETSaleResourceUsed"
		        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		        implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleResourceSV"
		        implservice_querymethod="selectResourceUsed()"
		        initial="false"  multiselect="false"
		        pagesize="17" editable="false" width="110%" 
		        height="470" needrefresh="true" footdisplay="none">
		        <ai:col fieldname="CITY_NAME" width="100" />
		        <ai:col fieldname="P_TERM_USED" width="110" />
		        <ai:col fieldname="L_TERM_USED" width="110" />
		        <ai:col fieldname="P_DISC_USED" width="110" />
		        <ai:col fieldname="L_DISC_USED" width="110" />
<%--		        <ai:col fieldname="P_POINTS_USED" width="110" />--%>
<%--		        <ai:col fieldname="L_POINTS_USED" width="110" />--%>
		        <ai:col fieldname="P_JF_USED" width="110" />
		        <ai:col fieldname="L_JF_USED" width="110" />
		        <ai:col fieldname="P_FJF_USED" width="110" />
		        <ai:col fieldname="L_FJF_USED" width="110" />
		        <ai:col fieldname="P_PROMT_USED" width="110" />
		        <ai:col fieldname="L_PROMT_USED" width="110" />
		    </ai:table>
		</ai:contractframe>
	</div>
	
	
	<div id="used_div2">
	    <ai:contractframe id="saleResAllotTFrame2" contenttype="table" title="各地市营销资源使用（%）" width="75%" allowcontract="false" frameclosed="false">
		    <ai:contractitem/>
		    <ai:table
		        tableid="saleResUsedTable2" 
		        setname="com.asiainfo.sale.activity.web.SETSaleResourceUsed"
		        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		        implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleResourceSV"
		        implservice_querymethod="selectResourceUsed2(String cityId)"
		        initial="false"  multiselect="false"
		        pagesize="17" editable="false" width="110%" 
		        height="470" needrefresh="true" footdisplay="none">
		        <ai:col fieldname="CITY_NAME" width="100" />
		        <ai:col fieldname="P_TERM_USED" width="110" />
		        <ai:col fieldname="L_TERM_USED" width="110" />
		        <ai:col fieldname="P_DISC_USED" width="110" />
		        <ai:col fieldname="L_DISC_USED" width="110" />
		        <ai:col fieldname="P_JF_USED" width="110" />
		        <ai:col fieldname="L_JF_USED" width="110" />
		        <ai:col fieldname="P_FJF_USED" width="110" />
		        <ai:col fieldname="L_FJF_USED" width="110" />
		        <ai:col fieldname="P_PROMT_USED" width="110" />
		        <ai:col fieldname="L_PROMT_USED" width="110" />
		    </ai:table>
		</ai:contractframe>
	</div>
  	</body>
  	<ai:loginuser/>
  	<script type="text/javascript">
  	var saleResUsedTable = g_TableRowSetManager.get("saleResUsedTable");
  	var saleResUsedTable2 = g_TableRowSetManager.get("saleResUsedTable2");
  	var org = g_GetUserInfo().ORG_ID.substr(0,2);
  	function initPage() {
  		if(org=='10'){
  	    document.getElementById("used_div2").style.display="none";
  		saleResUsedTable.refresh();
  		}else{
  		document.getElementById("used_div").style.display="none";	
  		saleResUsedTable2.refresh("&cityId="+org)
  		}
  		//document.getElementById("used_div").style.display="none";
  	}
  	</script>