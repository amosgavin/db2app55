<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>货品选择</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body>
<table>
	<tr align = "left">
       <td id="searchName">：</td>
	        <td align = "center"><input type="text" id="fee" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"></td>
	       <!-- <td>月数：</td>
	        <td align = "center"><input type="text" id="month" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"></td>
	          --> 
	         <td>礼品名称：</td>
	        <td><input type="text" id="hpSelect"></td>
	        <td>
		<ai:button id="queryTag" text="查询" onclick="queryTagbyCharge()"/></td>
	</tr>
</table>
<ai:contractframe id="tagDetailTab" contenttype="table" title="货品信息" width="100%" allowcontract="true" frameclosed="false" >
<table><td id="delGoods"> <ai:button id="deleteGoods" text="删除货品"  onclick="deleteRows()"/>   <ai:button id="exportAll" text="导出货品信息"  onclick="exportAll()"/></td></table>
	<ai:contractitem/>
	<ai:table setname="com.asiainfo.sale.tag.web.SETGoodsPromation"
			tableid="tagDetailTab"  editable="false"  ondbclick="editGoods"
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			needrefresh="true" pagesize="14" initial="false" width="100%" multiselect="true"
			implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			implservice_querymethod="queryZFQTagDetail(String charge,String tagType,String name,String orgid, int $STARTROWINDEX, int $ENDROWINDEX)"
			implservice_countmethod="getTagDetailCount(String charge,String tagType,String name,String orgid)" >
 			<ai:col  title="BOSS编号" fieldname="WPID" width="10%" editable="false" visible="false"/>
 			<ai:col  title="状态" fieldname="STATE"  editable="false" visible="false"/>		
            <ai:col title="资源ID" fieldname="TAG_CODE" width="13%" editable="false" visible=""/>
            <ai:col title="一级分类" fieldname="FIRST_CLASSIFY" width="10%" editable="false" visible="true"/>	
            <ai:col title="二级分类" fieldname="TAG_TYPE" width="10%" editable="false" visible="true"/>	
            <ai:col title="三级分类" fieldname="BUSI_NAME" width="10%" editable="false" visible="true"/>	
            <ai:col title="四级分类" fieldname="THIRF_CLASSIFY" width="10%" editable="false" visible="true"/>	
            <ai:col title="五级分类" fieldname="NAME" width="15%" editable="false" visible="true"/>
            <ai:col title="采购价(元)" fieldname="CHARGE" width="10%" editable="false" visible="true" /> 
            <ai:col title="零售指导价(元)" fieldname="SUMCHARGE" width="10%" editable="false" visible="" /> 
            <ai:col title="开放地市" fieldname="AREA" width="30%" editable="false" visible=""/>	
            <ai:col title="开放活动类型" fieldname="STOCK_FLAG" width="10%" editable="false" visible=""/>
            <ai:col title="采购类别" fieldname="SHOW_FLAG" width="10%" editable="false" visible=""/>
            <ai:col title="生效时间" fieldname="MODIFY_TIME" width="13%" editable="false" visible=""/>
            <ai:col title="失效时间" fieldname="OVERDUE_TIME" width="13%" editable="false" visible=""/>
            <ai:col title="生产厂家" fieldname="REMARK" width="13%" editable="false" visible=""/>
	</ai:table>
	<table>
		<td id="addgood"><ai:button id="bt_addGoodsTag" text="确定添加" onclick="addGoodsTag()"/></td>
	</table>
</ai:contractframe>

<ai:loginuser />
<script type="text/javascript">
var TagDetailTable = g_TableRowSetManager.get("tagDetailTab");
var saleDetailId = "<%=request.getParameter("saleDetailId")%>";
var detailid = "<%=request.getParameter("detailid")%>";
var isrows= "<%=request.getParameter("isrows")%>";
var saleType="<%=request.getParameter("saleType")%>";

var templateCode = "<%=request.getParameter("templateCode")%>";
var taskId = "<%=request.getParameter("taskTemplateId")%>";
var taskTag = "<%=request.getParameter("taskTag")%>";
var taskRecordId = "<%=request.getParameter("taskId")%>";
var flowType = "<%=request.getParameter("recordType")%>";
var _mainId = "<%=request.getParameter("recordId")%>";
// var worktype="1";
var tagType="";
//var tagDetailForm = g_FormRowSetManager.get("tagDetailForm");	
init();
function init(){
	if(saleType!="13"&&saleType!="15"&&saleType!="41"){
	document.getElementById("addgood").style.display="none";
	}else{
	document.getElementById("addgood").style.display="block";
	document.getElementById("delGoods").style.display="none";
	}
	//  var org="<%=request.getParameter("orgid")%>";
	var stateTown=g_GetUserInfo().ORG_ID.substring(0,2);
	var orgid=""
	if(stateTown=="11"){
	orgid="武汉";
	}else if(stateTown=="12"){
	orgid="黄石";
	}
	else if(stateTown=="13"){
	orgid="鄂州";
	}
	else if(stateTown=="14"){
	orgid="宜昌";
	}
	else if(stateTown=="15"){
	orgid="恩施";
	}
	else if(stateTown=="16"){
	orgid="十堰";
	}
	else if(stateTown=="17"){
	orgid="襄阳";
	}
	else if(stateTown=="18"){
	orgid="江汉";
	}
	else if(stateTown=="19"){
	orgid="咸宁";
	}
	else if(stateTown=="20"){
	orgid="荆州";
	}
	else if(stateTown=="23"){
	orgid="荆门";
	}
	else if(stateTown=="24"){
	orgid="随州";
	}
	else if(stateTown=="25"){
	orgid="黄冈";
	}
	else if(stateTown=="26"){
	orgid="孝感";
	}
		var name = "采购价";
	   	TagDetailTable.setTitle("CHARGE",name);
	   	searchName.innerText=name+"：";
	   	TagDetailTable.setTitle("CHARGE",name+"(元)");
	   	if(taskTag!=null&&taskTag!="null"){
	   	tagType=taskTag;
	   	}else{
	   	tagType="";
	   	}
	TagDetailTable.refresh("&orgid="+encodeURI(trim(orgid))+"&tagType="+tagType);
}

function queryTagbyCharge()
{

	var charge = document.getElementById("fee").value;
	var name =  document.getElementById("hpSelect").value;
     var stateTown=g_GetUserInfo().ORG_ID.substring(0,2);
	var orgid=""
	if(stateTown=="11"){
	orgid="武汉";
	}else if(stateTown=="12"){
	orgid="黄石";
	}
	else if(stateTown=="13"){
	orgid="鄂州";
	}
	else if(stateTown=="14"){
	orgid="宜昌";
	}
	else if(stateTown=="15"){
	orgid="恩施";
	}
	else if(stateTown=="16"){
	orgid="十堰";
	}
	else if(stateTown=="17"){
	orgid="襄阳";
	}
	else if(stateTown=="18"){
	orgid="江汉";
	}
	else if(stateTown=="19"){
	orgid="咸宁";
	}
	else if(stateTown=="20"){
	orgid="荆州";
	}
	else if(stateTown=="23"){
	orgid="荆门";
	}
	else if(stateTown=="24"){
	orgid="随州";
	}
	else if(stateTown=="25"){
	orgid="黄冈";
	}
	else if(stateTown=="26"){
	orgid="孝感";
	}
      if(charge==""&&name==""){
        TagDetailTable.refresh("&tagType="+tagType+"&orgid="+encodeURI(trim(orgid)));
      }
    else if(charge==""&&name!=""){
    TagDetailTable.refresh("&tagType="+tagType+"&name="+encodeURI(trim(name))+"&orgid="+encodeURI(trim(orgid)));
    }else if(name==""&&charge!=""){
	var  mon= "&charge=" + charge+"&tagType="+tagType+"&orgid="+encodeURI(trim(orgid));
    TagDetailTable.refresh(mon);
    }
    else{
    var  mon= "&charge=" + charge+"&tagType="+tagType+"&name="+encodeURI(trim(name))+"&orgid="+encodeURI(trim(orgid));
    TagDetailTable.refresh(mon);
    }
} 

function trim(str)
{
    return str.replace(/(^\s*)|(\s*$)/g, '');
}

function addGoodsTag(){
	
   var goodsTagIds = '';
   var selectedRows = TagDetailTable.getSelectedRows();
   if (selectedRows.length > 0) {
	    for (var i=0; i<selectedRows.length; ++i){
	    	
	   		if (i != 0 && goodsTagIds != '') goodsTagIds += ',';
	   		goodsTagIds += TagDetailTable.getValue(selectedRows[i],"WPID");
	    }
	} else {
		var selectedRow = TagDetailTable.getCurRowIndex();
		goodsTagIds = TagDetailTable.getValue(selectedRow,"WPID");
		if (goodsTagIds == '') {
			return alert("请选择货品！");
		}
	}
    	
   var condition = '&saleDetailId=' + saleDetailId + "&detailid="+detailid + '&goodsTagIds=' + goodsTagIds+ '&isrows=';
   var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.activity.web.SaleDetailAction?action=saveRelateGoodsWithSaleDetail' + condition;
   var sid= PostInfo(strUrl, null);
   if(sid.getValueByName("FLAG")=="Y"){
	   if(sid.getValueByName("saleDetailId")!=""){
	   // window.opener._fromSaleDetailFormRowSet().setValue("DETAIL_ID",sid.getValueByName("saleDetailId"));
	   } else {
	   	 alert("保存失败!");
	   }
   }
   
   window.returnValue = sid.getValueByName("saleDetailId");
   // window.parent.goodsTagTab.refresh("&saleItemId=" + sid.getValueByName("saleDetailId"));
   window.self.close();
}

function editGoods(){
	if(saleDetailId==""||saleDetailId=="null"){
	var selectedRow = TagDetailTable.getCurRowIndex();
	var goodsId=TagDetailTable.getValue(selectedRow,"WPID");
	tagGoodsForm.refresh("id=" + goodsId);
	}
	if(g_GetUserInfo().STAFF_ID=="20005238"){
	 g_AIButtonManager.get("newTag").setDisabled(true);
	}
}

function deleteGoods(){
 var selectedRows = TagDetailTable.getSelectedRows();
   if (selectedRows.length > 0) {
	    for (var i=0; i<selectedRows.length; ++i){
	    	
	   		if (i != 0 && goodsTagIds != '') goodsTagIds += ',';
	   		TagDetailTable.setValue(i,"STATE","0","0");
	    }
	    
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveGoods';
	var xmlbody = TagDetailTable.toXmlString(true);
	if (xmlbody != null || xmlbody != "") {
		var xml = "<RootInfo>" + xmlbody + "</RootInfo>";
		var recode2 = PostInfo(strUrl, xml);
		if(recode2.getValueByName("FLAG") == "N"){
			alert("删除失败！");
			return;
		}else if(recode2.getValueByName("FLAG") == "Y"){
			alert("删除成功！");
			queryTagbyCharge();
		}
	}
	} else {
		var selectedRow = TagDetailTable.getCurRowIndex();
		var goodsTagIds = TagDetailTable.getValue(selectedRow,"WPID");
		if (goodsTagIds == '') {
			return alert("请选择货品！");
		}
	}
}

//删除
function deleteRows(){
	var selectedRows = TagDetailTable.getSelectedRows(); 
	var RowCount = selectedRows.length;
	if(!confirm("您确定要删除选中的记录吗？")){
		return false;
	}
	
	if(RowCount < 1){
		alert("请选择要删除的记录！");
		return;
	}
	while (RowCount > 0) {
		RowCount--;
		//var so_nbr = TagDetailTable.getValue(selectedRows[RowCount], "WPID");
		TagDetailTable.deleteRow(selectedRows[RowCount]);
	}
	var list = new Array();
	list.push(TagDetailTable);
	//var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveGoods';
	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveGoods",list);
	if(ud.getValueByName("FLAG") == "N"){
			alert("删除失败！");
			return;
		}else if(ud.getValueByName("FLAG") == "Y"){
			alert("删除成功！");
			queryTagbyCharge();
		}	
}

	//导出
	function exportAll(){
	
	if(TagDetailTable.count()<=0){
		alert("表中没有数据！");
		return;
	}
    location.href = TagDetailTable.toExcelUrl("GoodsMessage_"+g_GetSysDate(),false,null,500,false);
  // location.href = table0.toExcelUrlWithVal("TouchLogQuery_"+g_GetSysDate(),3,null,null,null,null);
}

</script>
</body>
</html>
