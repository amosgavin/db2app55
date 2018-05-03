<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="_chargeTree_treeframe" contenttype="table" title="资费结构信息" width="100%" height="400" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <iframe id="_chargeTree_iFrame" name="_chargeTree_iFrame_n" src="" frameborder="0" width="100%" height="100%" scrolling="auto" ></iframe>
</ai:contractframe>
<script type="text/javascript">
var _chargeTree = {};
_chargeTree.setTreeEdit = function () {
document.getElementById("_chargeTree_iFrame").src="<%=request.getContextPath()%>/charge/chargeTreeEdit.jsp";
}
_chargeTree.setTreeShow = function () {
document.getElementById("_chargeTree_iFrame").src="<%=request.getContextPath()%>/charge/chargeTreeShow.jsp";
}
_chargeTree.openAndClose = function () {
	AIContractFrame_OpenClose("_chargeTree_treeframe");
}
</script>