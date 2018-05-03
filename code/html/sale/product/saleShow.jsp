<%--
	���ߣ�������
	��������:2013-12-09
	����˵����Ӫ����������Ϣ�����Թ���

 --%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%String visible ="false"; %>
<html>
	<head>
		<title>Ӫ�������β�ѯ</title>

	</head>
	<body onload="init();">
		<ai:contractframe id="prodInfoQry" contenttype="table" title="��ѯ��Ϣ"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:dbform setname="com.asiainfo.sale.product.web.SETSaleDetailExtQ"
				formid="formQry"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				initial="false">

				<table>
					<tr>
						<td class="td_font">Ӫ�����α��</td>
						<td><ai:dbformfield fieldname="SALE_ID" formid="formQry"/></td>
						<td class="td_font">��������</td>
						<td><ai:dbformfield fieldname="SALE_ACTIVE_NAME" formid="formQry"/></td>
						<td class="td_font">����</td>
						<td><ai:dbformfield fieldname="SALE_FLAG" formid="formQry"/></td>
					</tr>
					<tr>
						<td class="td_font">ϸ���г�</td>
						<td><ai:dbformfield fieldname="MARKET" formid="formQry"/></td>
						<td class="td_font">����ʱ�����</td>
						<td><ai:dbformfield fieldname="START_DATE"  formid="formQry"/></td>
						<td class="td_font">����ʱ��С��</td>
						<td><ai:dbformfield fieldname="END_DATE" formid="formQry"/></td>
					</tr>
				</table>
			</ai:dbform>

			<table>
				<tr align="right">
					<td width="750" colspan="5">
					<td>
						<ai:button id="qryProdInfo" text="��ѯ" onclick="qryProdInfo()" />
						&nbsp;
						<ai:button id="qryMoreProdInfo" text="�߼���ѯ"
							onclick="qryMoreProdInfo()" />

					</td>
				</tr>
			</table>
		</ai:contractframe>	
		<%@ include file="/sale/product/include/_saleDetail.jsp"%>
		
		<div class="area_button">
			<ai:button id="addAttr" text="���Թ���" onclick="addAttr()" />
			&nbsp;&nbsp;
			<ai:button id="modifyData" text="�޸�����" onclick="modifyData()" />
			&nbsp;&nbsp;
			<ai:button id="showSaleHis" text="�鿴��ʷ��¼" onclick="showSaleHis()" />
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
		alert("����д��ѯ������");
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
			alert("��ѡ��Ҫ�޸ĵļ�¼");
			return;
		}
		if (selectRows.length>1){
			alert("��ֻ��ѡ��һ����¼");
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
		alert("��ѡ��һ����¼");
		return;
	}
	if(curRows.length>1){
		alert("ֻ��ѡ��һ����¼");
		return;
	}
	var detail_id = _saleDetail.grid().getValue(curRows[0],"DETAIL_ID");

	var url = "<%=request.getContextPath()%>/sale/product/saleDetailHis.jsp?detail_id="+detail_id;
	window.open(url);
}


</script>