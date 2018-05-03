<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="wfCheckframe" contenttype="table" title="资费结构信息" width="100%" height="400" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <iframe src="" frameborder="0" width="100%" height="100%" scrolling="auto" ></iframe>
</ai:contractframe>
<script type="text/javascript">
var _chargeTreeShow = {};
_chargeTreeEdit.setTree = function () {
document.getElementById("_chargeTreeEdit_iFrame").src="<%=request.getContextPath()%>/charge/chargeTreeShow.jsp";
}
</script>