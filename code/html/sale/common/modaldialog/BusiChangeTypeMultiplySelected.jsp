<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>�������</title>
</head>
<body onload="initPage();">
<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
         <tr>
           <td width="50%" valign="top">
            <ai:contractframe id="itemframe" contenttype="table" title="��ѡҵ��������" width="100%" allowcontract="true" frameclosed="fale">
                <ai:contractitem/>
                <ai:listbox width="200" id="itemList"
                    ds="com.asiainfo.sale.common.web.DSBusiChangeType" 
                    initial="true" listsize="10" showtype="list" parameters=""
                    onclick="selectItemAction(this);" />
            </ai:contractframe>
        </td>
        <td width="50%" valign="top">
            <ai:contractframe id="selectedItemframe" contenttype="table" title="��ѡҵ��������" width="100%" allowcontract="true" frameclosed="fale">
            <ai:contractitem/>
                <select size="10" id="selectedItemList" style="width: 200" onclick="deleteItemAction(this);">
                </select>
            </ai:contractframe>
        </td>
    </tr>
</table>
<div class="area_button">
<ai:button id="sure_bt" text="ȷ��" onclick="onSubmit()"/>
<ai:button id="clear_bt" text="�����ѡ" onclick="clearSelectedItemAction()"/>
</div>
</body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/modaldialog/js/MultiplySelected.js"></script>
