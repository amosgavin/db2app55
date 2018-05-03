<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>湖北移动公司营销管理系统</title>
</head>
<body onload="">
  <ai:contractframe id="chargeTestframe" contenttype="table" title="Test" width="100%" allowcontract="true" frameclosed="false">
   <ai:contractitem/>
   <ai:table
        tableid="chargeTestTable" 
        setname="com.asiainfo.bi.web.SETChargeTest"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleOrderSV"
        implservice_querymethod="getSaleMainByOrderId(String orderId, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getSaleMainCountByOrderId(String orderId)"
        initial="false"  multiselect="true" 
        pagesize="15" editable="false" width="100%" 
        height="100" needrefresh="true">
        <ai:col fieldname="ORDER_ID" width="80" />
        <ai:col fieldname="REASON" width="300" />
        <ai:col fieldname="FLAG" width="100" visible="false"/>
    </ai:table>
</ai:contractframe>
</body>
</html>
<ai:loginuser/>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script type="text/javascript">
</script>