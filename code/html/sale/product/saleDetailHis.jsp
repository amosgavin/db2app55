<%-- 
	作者：江晓莉
	创建日期:2013-10-21
	功能说明：资费记录历史查询
--%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%
	String detail_id = HttpUtil.getAsString(request, "detail_id");
	String visible="true";
%>
<html>
	<head>
		<title>资费记录历史查询</title>
	</head>
	<body onload="init();">
		<%@ include file="/sale/product/include/_saleDetail.jsp"%>
	</body>
</html>
<script language="javascript" type="text/javascript">
var mainId="<%=detail_id%>";
	function init(){
		document.getElementById('bt_newSaleDetail').style.visibility='hidden';
		document.getElementById('bt_delSaleDetail').style.visibility='hidden';
		var cond ="";
		if(null!=mainId && ""!=mainId){
			cond+="&detail_id="+mainId;
		}
		cond+="&status=0";
		_saleDetail.qrySaleDetail(cond);
		
	}
	function showDetailInfo(){}
	
</script>