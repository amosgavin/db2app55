<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>专款范围</title>
</head>
<body onload="initPage();">
<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
         <tr>
           <td width="50%" valign="top">
            <ai:contractframe id="itemframe" contenttype="table" title="可选专款" width="100%" allowcontract="true" frameclosed="fale">
                <ai:contractitem/>
                <ai:listbox width="200" id="itemList"
                    ds="com.asiainfo.sale.prestore.web.DSFundSelected"
                    initial="true" listsize="10" showtype="list" parameters="codeType=acctypey"
                    onclick="selectItemAction(this);" />
            </ai:contractframe>
        </td>
        <td width="50%" valign="top">
            <ai:contractframe id="selectedItemframe" contenttype="table" title="已选专款" width="100%" allowcontract="true" frameclosed="fale">
            <ai:contractitem/>
                <select size="10" id="selectedItemList" style="width: 200" onclick="deleteItemAction(this);">
                </select>
            </ai:contractframe>
        </td>
    </tr>
</table>
<div class="area_button">
<ai:button id="saveSaleMain" text="确定" onclick="onSubmit()"/>
<ai:button id="saveSaleMain" text="清空已选" onclick="clearSelectedItemAction()"/>
</div>
</body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/modaldialog/js/MultiplySelected.js"></script>
