<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>细分市场</title>
</head>
<body>
<ai:contractframe id="itemframe" contenttype="table" title="可选细分市场" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <ai:listbox width="240" id="itemList"
        ds="com.asiainfo.sale.common.web.DSMarket" 
        initial="true" listsize="10" showtype="list" parameters=""
        ondblclick="onSelect();" />
</ai:contractframe>
<div class="area_button">
<ai:button id="saveSaleMain" text="确定" onclick="onSelect()"/>
</div>
</body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/modaldialog/js/SimpleSelected.js"></script>
