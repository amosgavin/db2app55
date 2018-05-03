<%--
	作者：江晓莉
	创建日期:2013-12-09
	功能说明：营销案档次信息及属性管理

 --%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%String visible ="false"; %>
<html>
	<head>
		<title>营销案档次查询</title>

	</head>
	<body onload="init();">
		<ai:contractframe id="prodInfoQry" contenttype="table" title="查询信息"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:dbform setname="com.asiainfo.sale.product.web.SETSaleDetailExtQ"
				formid="formQry"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				initial="false">

				<table>
					<tr>
						<td class="td_font">营销批次编号</td>
						<td><ai:dbformfield fieldname="SALE_ID" formid="formQry"/></td>
						<td class="td_font">档次名称</td>
						<td><ai:dbformfield fieldname="SALE_ACTIVE_NAME" formid="formQry"/></td>
						<td class="td_font">类型</td>
						<td><ai:dbformfield fieldname="SALE_FLAG" formid="formQry"/></td>
					</tr>
					<tr>
						<td class="td_font">细分市场</td>
						<td><ai:dbformfield fieldname="MARKET" formid="formQry"/></td>
						<td class="td_font">创建时间大于</td>
						<td><ai:dbformfield fieldname="START_DATE"  formid="formQry"/></td>
						<td class="td_font">创建时间小于</td>
						<td><ai:dbformfield fieldname="END_DATE" formid="formQry"/></td>
					</tr>
				</table>
			</ai:dbform>

			<table>
				<tr align="right">
					<td width="750" colspan="5">
					<td>
						<ai:button id="qryProdInfo" text="查询" onclick="qryProdInfo()" />
						&nbsp;
						<ai:button id="qryMoreProdInfo" text="高级查询"
							onclick="qryMoreProdInfo()" />

					</td>
				</tr>
			</table>
		</ai:contractframe>	
		<%@ include file="/sale/product/include/_saleDetail.jsp"%>
		
		<div class="area_button">
			<ai:button id="addAttr" text="属性管理" onclick="addAttr()" />
			&nbsp;&nbsp;
			<ai:button id="modifyData" text="修改数据" onclick="modifyData()" />
			&nbsp;&nbsp;
			<ai:button id="showSaleHis" text="查看历史记录" onclick="showSaleHis()" />
		</div>


	</body>
</html>
<script  type="text/javascript">

var qryForm = g_FormRowSetManager.get("formQry");

function init(){
		document.getElementById('bt_newSaleDetail').style.visibility='hidden';
		document.getElementById('bt_delSaleDetail').style.visibility='hidden';
}
function setButtonDisabled(){
    document.getElementById('bt_weaponSelect1').style.visibility='hidden';
	document.getElementById('bt_refreshCompute4weapon').style.visibility='hidden';
	document.getElementById('bt_newSaleDetail').style.visibility='hidden';
	document.getElementById('bt_delSaleDetail').style.visibility='hidden';
	document.getElementById('bt_applyWeapon').style.visibility='hidden';
	document.getElementById('bt_addGoodsTag').style.visibility='hidden';
	document.getElementById('bt_delGoodsTag').style.visibility='hidden';
	document.getElementById('bt_saveSaleMain').style.visibility='hidden';
	document.getElementById('bt_gotoExplanTag').style.visibility='hidden';
	document.getElementById('bt_addRule').style.visibility='hidden';
	document.getElementById('bt_delRule').style.visibility='hidden';
}

function qryProdInfo(){
	var cond = getCond("");
	if(!checkIsNull(cond)){
		_saleDetail.qrySaleDetail(cond);
	}
	else {
		alert("请填写查询条件！");
		return;
	}

}



function qryMoreProdInfo(){

		var extType =  "SALE"
		var url = "<%=request.getContextPath()%>/charge/product/advanceQry.jsp?extType="+extType;
		var result = window.showModalDialog(url,'',"scroll:no;resizable:no;status:no;dialogHeight:450px;dialogWidth:800px");
	
		var cond = getCond(result);
		
		_saleDetail.qrySaleDetail(cond);

}

function checkIsNull(str){
	if(null == str || ""==str){
		return true;
	}
	else return false;
}

function getCond(appendStr){
	if(null==appendStr){
		appendStr = "";
	}
	if(appendStr != null && ""!=appendStr){
			appendStr += " and  ";
		}
		appendStr+=" LEVEL_CODE is not null and level_code <>'' ";
		var condStr= "";
		var sale_id = qryForm.getValue("SALE_ID");
		var active_name =qryForm.getValue("SALE_ACTIVE_NAME");
		var sale_flag = qryForm.getValue("SALE_FLAG");
		var market = qryForm.getValue("MARKET");
		var start_date = qryForm.getValue("START_DATE");
		var end_date = qryForm.getValue("END_DATE");
		//var status="1";
		
		var str="(status is null or status='1')";
		if(null!=appendStr && ""!=appendStr){
			appendStr = str+" and "+ appendStr;
		}
		
		if(!checkIsNull(sale_id)){
			condStr+="&mainId="+sale_id;
		}
		if(!checkIsNull(active_name)){
			active_name = encodeURI(active_name);
			condStr+="&active_name="+active_name;
		}
		if(!checkIsNull(sale_flag)){
			condStr+="&saleFlag="+sale_flag;
		}
		if(!checkIsNull(market)){
			condStr+="&market="+market;
		}
		
		if(!checkIsNull(start_date)){
			condStr+="&start_date="+start_date;
		}
	
		if(!checkIsNull(end_date)){
			condStr+="&end_date="+end_date;
		}
		if(!checkIsNull(appendStr)){
			condStr+="&condStr="+appendStr;
		}
		return condStr;
	
}

function addAttr(){

	var url = "<%=request.getContextPath()%>/sale/product/saleAttrMrg.jsp";
	var result = window.showModalDialog(url,'',"scroll:no;resizable:no;status:no;dialogHeight:450px;dialogWidth:800px");

	window.location.reload();
			
}

function modifyData(){
	
		var selectRows = _saleDetail.grid().getSelectedRows();
		if(selectRows.length <=0){
			alert("请选择要修改的记录");
			return;
		}
		if (selectRows.length>1){
			alert("您只能选择一条记录");
			return;
		}
		
		var detail_id = _saleDetail.grid().getValue(selectRows[0],"DETAIL_ID");
		var url = "<%=request.getContextPath()%>/sale/product/saleDetailInfo.jsp?mainId="+detail_id+"&editable=false";
		window.open(url);
	//	qryProdInfo();
	
}
function showDetailInfo(){
}


function showSaleHis(){
	var curRows = _saleDetail.grid().getSelectedRows();
	if(curRows.length<=0){
		alert("请选择一条记录");
		return;
	}
	if(curRows.length>1){
		alert("只能选择一条记录");
		return;
	}
	var detail_id = _saleDetail.grid().getValue(curRows[0],"DETAIL_ID");

	var url = "<%=request.getContextPath()%>/sale/product/saleDetailHis.jsp?detail_id="+detail_id;
	window.open(url);
}


</script>