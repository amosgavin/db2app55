<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<title>资费属性管理</title>
	</head>
	<body onload="init()">

		<ai:contractframe id="qryInfo" contenttype="table" title="查询信息"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:dbform formid="attrForm"
				setname="com.asiainfo.charge.web.SETProductExtDesc"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				initial="false">
				<table>
					<tr>
						<td class="td_font" colspan="2">
							属性名称
						</td>
						<td colspan="2">
							<ai:dbformfield fieldname="EXT_NAME" formid="attrForm" />
							&nbsp;&nbsp;
							<ai:button id="qryAttr" text="查询" onclick="qryAttr()" />
						</td>

					</tr>
				</table>

			</ai:dbform>
		</ai:contractframe>
	  <%@ include file="/sale/product/include/_attrList.jsp"%>	
	</body>
</html>
<ai:loginuser />
<script language="javascript" type="text/javascript">
function getUrl(opType){
	var url = "";
	if("delete"==opType){
		url = "<%=request.getContextPath()%>/business/com.asiainfo.sale.product.web.SaleShowAction?action=delAttr";
		//"action=delAttr&codesArray="+codesArray+"&extType="+extType;
	}
	else if("save"==opType){
		url="<%=request.getContextPath()%>/business/com.asiainfo.sale.product.web.SaleShowAction?action=saveAttr";
		//&extName="+_attrList.trim(extName)+"&extType="+extType;
	}
	return url;
}

var form = g_FormRowSetManager.get("attrForm");

function init(){
  qryAttr();
}

function qryAttr(){
	var cond = "";
	var ext_name = encodeURI(form.getValue("EXT_NAME"));
	if(null != ext_name && ""!= ext_name){
	  	cond+= "&extName="+ext_name;
	}
	cond+="&type=SALE&state=1&is_can_moidfy=1";
	_attrList.qryAttr(cond);
	
}

function controlExtType(){
	_attrList.addForm.setValue("EXT_TYPE","SALE","营销案档次");
	
	_attrList.addForm.setColEditSts("EXT_TYPE",false);
}


</script>