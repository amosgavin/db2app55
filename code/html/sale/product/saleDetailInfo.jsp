<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@	include file="/webframe/common/commonhead.jsp"%>
<%
	String mainId = HttpUtil.getAsString(request, "mainId");
	String editable = HttpUtil.getAsString(request, "editable");
%>
<html>
	<head>
		<title>营销案档次详情</title>
	</head>
	<body onload="init()">
		<%@ include file="/sale/product/include/_sale_detail_form.jsp"%>
		<div class="area_button">
			<ai:button id="saveSaleExt" text="保存" onclick="saveSaleExt()"/>
		
		</div>
	</body>
</html>

<script language="javascript" type="text/javascript">
	var mainId = "<%=mainId%>";
	var editable = "<%=editable%>";
	function init(){
		if(null != mainId&& ""!=mainId){
			var str = "&id="+mainId;
			 _sale_detail_form.doRefresh(str);
		
			var cond ="&detail_id="+mainId+"&status=1";
			
			_saleExtInfo.refreshForm(cond);
		}
		
		if (editable == "false") {
	    	_sale_detail_form.detailForm.setEditSts(false);
	    	document.getElementById("channel_tr").style.display="block";
    	}
		
	}
	
	function saveSaleExt(){
		var e_id = _saleExtInfo.extForm.getValue("E_ID");
		var detail_id =  _saleExtInfo.extForm.getValue("F_DETAIL_ID");
		var param="&e_id="+e_id+"&detail_id="+detail_id;
		var url ="<%=request.getContextPath()%>/business/com.asiainfo.sale.product.web.SaleShowAction?"+
		"action=saveData"+param;
		var xmlbody = _saleExtInfo.extForm.toXmlString(false);
		var xml = "<RootInfo>" + xmlbody + "</RootInfo>";
	
		var returnValues = PostInfo(url,xml);
		if(returnValues != null){
				if(returnValues.getValueByName("retVal") == "Y"){
					alert(returnValues.getValueByName("retMsg"));
				}
				else{
					alert(returnValues.getValueByName("retMsg"));
					return;
				}
		}
		else{
			alert("保存失败");
			return;
		}
	
		
	}
	
</script>
