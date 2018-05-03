<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="_chargeTreeEdit_treeframe" contenttype="table" title="资费结构信息" width="100%" height="400" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <iframe id="_chargeTreeEdit_iFrame" src="" frameborder="0" width="100%" height="100%" scrolling="auto" ></iframe>
</ai:contractframe>
<script type="text/javascript">
var _chargeTreeEdit = {};
_chargeTreeEdit.setTree = function () {
document.getElementById("_chargeTreeEdit_iFrame").src="<%=request.getContextPath()%>/charge/chargeTreeEdit.jsp";
}
_chargeTreeEdit.openAndClose = function () {
	AIContractFrame_OpenClose("_chargeTreeEdit_treeframe");
}
</script>