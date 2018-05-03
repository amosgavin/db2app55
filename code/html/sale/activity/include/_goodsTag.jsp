<%@ page contentType="text/html; charset=GBK"%>
<table>
<tr id="goods_tag_tr" style="display: none;">
<ai:contractframe id="goodsTagTabframe" contenttype="table" title="赠送货品清单(多选一)" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem>
	<ai:button id="bt_addGoodsTag" text="添加货品" onclick="_addGoodsTags()"/>
	<ai:button id="bt_delGoodsTag" text="删除货品" onclick="_delGoodsTag()"/>
	<!-- <ai:button id="bt_addGoodsTag" text="货品组合" onclick="goodsRows()"/>
	<ai:button id="bt_addGoodsTag" text="货品组查询" onclick="goodsRowsSelect()"/> -->
	</ai:contractitem>
	<ai:table setname="com.asiainfo.sale.tag.web.SETHPRowPromationTag"
			tableid="goodsTagTab"  editable="false" multiselect="true"
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			needrefresh="true" pagesize="99" initial="false" width="100%" height="200"
			implservice_name="com.asiainfo.sale.activity.service.interfaces.IRelateSaleWithGoodsSV"
			implservice_querymethod="getRelateSaleWithGoodsValues(String saleItemId, String goodsTagIds,String isrows)"
			implservice_countmethod="getRelateSaleWithGoodsCount(String saleItemId, String goodsTagIds,String isrows)">
 			<ai:col  title="BOSS编号" fieldname="WPID" width="10%" editable="false" visible="false"/>
 				<ai:col  title="BOSS编号" fieldname="ATID" width="10%" editable="false" visible="false"/>
 		    <ai:col  title="组合名称" fieldname="REMARK2" width="10%" editable="false" visible="false"/>		
            <ai:col title="资源ID" fieldname="TAG_CODE" width="10%" editable="false" visible=""/>
            <ai:col title="礼品名称" fieldname="NAME" width="30%"  editable="false" visible="true"/>	
            <ai:col title="采购价(元)" fieldname="CHARGE" width="10%" editable="false" visible="true" /> 
            <ai:col title="零售指导价(元)" fieldname="SUMCHARGE" width="10%" editable="false" visible="" /> 
            <ai:col title="货品类型" fieldname="TAG_TYPE" width="" editable="false" visible="false"/>
            <ai:col title="开放地市" fieldname="AREA" width="30%" editable="false" visible=""/>	
            <ai:col title="开放活动类型" fieldname="SHOW_FLAG" width="10%" editable="false" visible=""/>
            <ai:col title="采购类别" fieldname="STOCK_FLAG" width="10%" editable="false" visible=""/>
	</ai:table>
</ai:contractframe>
</tr></table>
<script type="text/javascript">

var _goodsTagIdsGolobe = '';
function _addGoodsTag()
{
	var goodsTagTab = g_TableRowSetManager.get("goodsTagTab");
	var curRow = _tableSaleDetailListTableRowSet().getCurRowIndex();
	var saleDetailId = _tableSaleDetailListTableRowSet().getValue(curRow, "DETAIL_ID");
	
	var saleDetailCode = _fromSaleDetailFormRowSet().getValue("SALE_ACTIVE_CODE");
	if (saleDetailCode == null || saleDetailCode == '') {
		saleDetailId = '';
	}
	
	var url = "<%=request.getContextPath()%>/sale/activity/include/_goodsTagSelect.jsp?saleDetailId=" + saleDetailId+"&isrows=";
    var goodsTagIds = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:s;dialogHeight:600px;dialogWidth:700px");
    if(goodsTagIds==null) return;
    if(_goodsTagIdsGolobe == '') {
    	_goodsTagIdsGolobe = goodsTagIds;
    }else{
	  	 var goodsTaglength = goodsTagTab.getTotalRowCount();
	  	 _goodsTagIdsGolobe='';
			for (var i = 0; i < goodsTaglength; ++i){
				if (i != 0 && _goodsTagIdsGolobe != '')
				{ _goodsTagIdsGolobe += "," +goodsTagTab.getValue(i,"WPID");
				}else{
				_goodsTagIdsGolobe=goodsTagTab.getValue(i,"WPID");
				}
			}
			_goodsTagIdsGolobe +="," +goodsTagIds;
		}
    goodsTagTab.refresh("&saleItemId=" + saleDetailId + "&goodsTagIds=" + _goodsTagIdsGolobe+"&isrows=");
}


function _addGoodsTags()
{
	var goodsTagTab = g_TableRowSetManager.get("goodsTagTab");
	var curRow = _tableSaleDetailListTableRowSet().getCurRowIndex();
	var saleDetailId = _tableSaleDetailListTableRowSet().getValue(curRow, "DETAIL_ID");
	var saleType = _fromSaleDetailFormRowSet().getValue("SALE_FLAG");
	var saleDetailCode = _fromSaleDetailFormRowSet().getValue("SALE_ACTIVE_CODE");
	if (saleDetailCode == null || saleDetailCode == '') {
		saleDetailId = '';
	}
	var detailid=_fromSaleDetailFormRowSet().getValue("DETAIL_ID");
	var url = "<%=request.getContextPath()%>/sale/activity/include/_goodsTagSelect.jsp?saleDetailId=" + saleDetailId+"&detailid="+detailid+"&isrows="+detailid+"&saleType="+saleType;
    var did = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:s;dialogHeight:600px;dialogWidth:700px");
    //var did=_fromSaleDetailFormRowSet().getValue("DETAIL_ID");
    // if(goodsTagIds==null) return;
    //  if(did == '') {
    if(did != undefined){
		alert("添加货品成功!");
		_fromSaleDetailFormRowSet().setValue("DETAIL_ID",did);
		goodsTagTab.refresh("&saleItemId=" + did + "&goodsTagIds=" + _goodsTagIdsGolobe+"&isrows=");
    }
	  //  }else{
		//  	 var goodsTaglength = goodsTagTab.getTotalRowCount();
		//		for (var i = 0; i < goodsTaglength; ++i){
		//			if (i != 0 && did != '')
		//			{ did += "," +goodsTagTab.getValue(i,"WPID");
		//			}else{
		//			did=goodsTagTab.getValue(i,"WPID");
			//		}
		//		}
			//	 goodsTagTab.refresh("&saleItemId=" + did + "&goodsTagIds=" + _goodsTagIdsGolobe+"&isrows=");
		//	}
}


function _delGoodsTag()
{
	var goodsTagTab = g_TableRowSetManager.get("goodsTagTab");
	var saleType=_fromSaleDetailFormRowSet().getValue("SALE_FLAG");
	var delGoodsArray = new Array();
	delGoodsArray = goodsTagTab.getSelectedRows();
	var delGoodsRowCount = delGoodsArray.length;
    if (delGoodsRowCount < 1) {
        return alert("请选择要删除的数据！");
    }
    	
	if(saleType=="13"){
	   var saleDetailId=_fromSaleDetailFormRowSet().getValue("DETAIL_ID");
		
	} else {
	 	var curRow = _tableSaleDetailListTableRowSet().getCurRowIndex();
		var saleDetailId = _tableSaleDetailListTableRowSet().getValue(curRow, "DETAIL_ID");
		var saleDetailCode = _fromSaleDetailFormRowSet().getValue("SALE_ACTIVE_CODE");
		if (saleDetailCode == null || saleDetailCode == '') {
			saleDetailId = '';
		}
	}
	if (saleDetailId == '') {
		while (delGoodsRowCount > 0) {
	        delGoodsRowCount--;
	        goodsTagTab.deleteRow(delGoodsArray[delGoodsRowCount]);
    	}
		var goodsTaglength = goodsTagTab.getTotalRowCount();
		_goodsTagIdsGolobe = '';
		for (var i = 0; i < goodsTaglength; ++i){
			
			if (i != 0 && _goodsTagIdsGolobe != '') _goodsTagIdsGolobe += ',';
   			_goodsTagIdsGolobe += goodsTagTab.getValue(i,"ATID");
		}
		goodsTagTab.refresh("&saleItemId=" + saleDetailId + "&goodsTagIds=" + _goodsTagIdsGolobe);
	} else {
		var goodsTagIds = "0";
	    for(var i = 0; i < delGoodsRowCount; ++i) {
	        goodsTagIds += "," + goodsTagTab.getValue(delGoodsArray[i], "ATID");
	    }
	    var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.activity.web.SaleDetailAction?' +
	    			'action=deleteRelateGoodsWithSaleDetail' +
	    			'&saleItemId=' + saleDetailId +
	    			'&goodsTagIds=' + goodsTagIds;
	    PostInfo(strUrl, null);
	    alert("删除货品成功!");
	    goodsTagTab.refresh("&saleItemId=" + saleDetailId);
	}
}

function goodsRows(){
	var goodsTagTab = g_TableRowSetManager.get("goodsTagTab");
	var rowGoodsArray = new Array();
	var goodsTagIds ='';
	rowGoodsArray = goodsTagTab.getSelectedRows();
	var rowGoodsRowCount = rowGoodsArray.length;
    if (rowGoodsRowCount < 1) {
        return alert("请选择要组合的数据！");
    } else {
	    var url="<%=request.getContextPath()%>/sale/activity/include/showrow.jsp";
	    var name=  window.showModalDialog(url,null, "scroll:yes;resizable:yes;help:no;status:yes;dialogHeight:100px;dialogWidth:400px;unadorned:yes");
    
      	for(var i = 0; i < rowGoodsRowCount; ++i) {
	    	if(name==undefined){
	    		return;
	    	} else {
	       		goodsTagTab.setValue(rowGoodsArray[i], "REMARK2",name);
	        }
	        if(i==0){
	       		goodsTagIds = goodsTagTab.getValue(rowGoodsArray[i],"ATID");
	        } else {
	        	goodsTagIds+=","+goodsTagTab.getValue(rowGoodsArray[i],"ATID");
	        }
      }
      var condition = '&saleDetailId=' + saleDetailId + '&goodsTagIds=' + goodsTagIds+ '&isrows='+name;
      var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.activity.web.SaleDetailAction?action=saveRelateGoodsWithSaleDetail' + condition;
      var sid= PostInfo(strUrl, null);
      if(sid.getValueByName("FLAG")=="Y"){
      }
    }
    var curRow = _tableSaleDetailListTableRowSet().getCurRowIndex();
	var saleDetailId = _tableSaleDetailListTableRowSet().getValue(curRow, "DETAIL_ID");
	goodsTagTab.refresh("&saleItemId=" + saleDetailId);
	
}

function goodsRowsSelect(){
	var goodsTagTab = g_TableRowSetManager.get("goodsTagTab");
    var url="<%=request.getContextPath()%>/sale/activity/include/showrow.jsp";
    var name=  window.showModalDialog(url,null, "scroll:yes;resizable:yes;help:no;status:yes;dialogHeight:100px;dialogWidth:400px;unadorned:yes");
    if(name==undefined){
	    return;
	} else {
	    var curRow = _tableSaleDetailListTableRowSet().getCurRowIndex();
		var saleDetailId = _tableSaleDetailListTableRowSet().getValue(curRow, "DETAIL_ID");
	    goodsTagTab.refresh("&saleItemId=" + saleDetailId+"isrow="+name);
	}
}
</script>
