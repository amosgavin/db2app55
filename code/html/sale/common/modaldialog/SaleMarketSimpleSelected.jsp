<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>ϸ���г�</title>
</head>
<body>
<ai:contractframe id="itemframe" contenttype="table" title="��ѡϸ���г�" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <ai:listbox width="240" id="itemList"
        ds="com.asiainfo.sale.common.web.DSMarket" 
        initial="true" listsize="10" showtype="list" parameters=""
        ondblclick="onSelect();" />
</ai:contractframe>
<div class="area_button">
<ai:button id="saveSaleMain" text="ȷ��" onclick="onSelect()"/>
</div>
</body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/modaldialog/js/SimpleSelected.js"></script>
