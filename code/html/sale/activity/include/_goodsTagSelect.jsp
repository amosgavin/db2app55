<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>��Ʒѡ��</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body>
<table>
	<tr align = "left">
       <td id="searchName">��</td>
	        <td align = "center"><input type="text" id="fee" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"></td>
	       <!-- <td>������</td>
	        <td align = "center"><input type="text" id="month" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"></td>
	          --> 
	         <td>��Ʒ���ƣ�</td>
	        <td><input type="text" id="hpSelect"></td>
	        <td>
		<ai:button id="queryTag" text="��ѯ" onclick="queryTagbyCharge()"/></td>
	</tr>
</table>
<ai:contractframe id="tagDetailTab" contenttype="table" title="��Ʒ��Ϣ" width="100%" allowcontract="true" frameclosed="false" >
<table><td id="delGoods"> <ai:button id="deleteGoods" text="ɾ����Ʒ"  onclick="deleteRows()"/>   <ai:button id="exportAll" text="������Ʒ��Ϣ"  onclick="exportAll()"/></td></table>
	<ai:contractitem/>
	<ai:table setname="com.asiainfo.sale.tag.web.SETGoodsPromation"
			tableid="tagDetailTab"  editable="false"  ondbclick="editGoods"
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			needrefresh="true" pagesize="14" initial="false" width="100%" multiselect="true"
			implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			implservice_querymethod="queryZFQTagDetail(String charge,String tagType,String name,String orgid, int $STARTROWINDEX, int $ENDROWINDEX)"
			implservice_countmethod="getTagDetailCount(String charge,String tagType,String name,String orgid)" >
 			<ai:col  title="BOSS���" fieldname="WPID" width="10%" editable="false" visible="false"/>
 			<ai:col  title="״̬" fieldname="STATE"  editable="false" visible="false"/>		
            <ai:col title="��ԴID" fieldname="TAG_CODE" width="13%" editable="false" visible=""/>
            <ai:col title="һ������" fieldname="FIRST_CLASSIFY" width="10%" editable="false" visible="true"/>	
            <ai:col title="��������" fieldname="TAG_TYPE" width="10%" editable="false" visible="true"/>	
            <ai:col title="��������" fieldname="BUSI_NAME" width="10%" editable="false" visible="true"/>	
            <ai:col title="�ļ�����" fieldname="THIRF_CLASSIFY" width="10%" editable="false" visible="true"/>	
            <ai:col title="�弶����" fieldname="NAME" width="15%" editable="false" visible="true"/>
            <ai:col title="�ɹ���(Ԫ)" fieldname="CHARGE" width="10%" editable="false" visible="true" /> 
            <ai:col title="����ָ����(Ԫ)" fieldname="SUMCHARGE" width="10%" editable="false" visible="" /> 
            <ai:col title="���ŵ���" fieldname="AREA" width="30%" editable="false" visible=""/>	
            <ai:col title="���Ż����" fieldname="STOCK_FLAG" width="10%" editable="false" visible=""/>
            <ai:col title="�ɹ����" fieldname="SHOW_FLAG" width="10%" editable="false" visible=""/>
            <ai:col title="��Чʱ��" fieldname="MODIFY_TIME" width="13%" editable="false" visible=""/>
            <ai:col title="ʧЧʱ��" fieldname="OVERDUE_TIME" width="13%" editable="false" visible=""/>
            <ai:col title="��������" fieldname="REMARK" width="13%" editable="false" visible=""/>
	</ai:table>
	<table>
		<td id="addgood"><ai:button id="bt_addGoodsTag" text="ȷ�����" onclick="addGoodsTag()"/></td>
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
	orgid="�人";
	}else if(stateTown=="12"){
	orgid="��ʯ";
	}
	else if(stateTown=="13"){
	orgid="����";
	}
	else if(stateTown=="14"){
	orgid="�˲�";
	}
	else if(stateTown=="15"){
	orgid="��ʩ";
	}
	else if(stateTown=="16"){
	orgid="ʮ��";
	}
	else if(stateTown=="17"){
	orgid="����";
	}
	else if(stateTown=="18"){
	orgid="����";
	}
	else if(stateTown=="19"){
	orgid="����";
	}
	else if(stateTown=="20"){
	orgid="����";
	}
	else if(stateTown=="23"){
	orgid="����";
	}
	else if(stateTown=="24"){
	orgid="����";
	}
	else if(stateTown=="25"){
	orgid="�Ƹ�";
	}
	else if(stateTown=="26"){
	orgid="Т��";
	}
		var name = "�ɹ���";
	   	TagDetailTable.setTitle("CHARGE",name);
	   	searchName.innerText=name+"��";
	   	TagDetailTable.setTitle("CHARGE",name+"(Ԫ)");
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
	orgid="�人";
	}else if(stateTown=="12"){
	orgid="��ʯ";
	}
	else if(stateTown=="13"){
	orgid="����";
	}
	else if(stateTown=="14"){
	orgid="�˲�";
	}
	else if(stateTown=="15"){
	orgid="��ʩ";
	}
	else if(stateTown=="16"){
	orgid="ʮ��";
	}
	else if(stateTown=="17"){
	orgid="����";
	}
	else if(stateTown=="18"){
	orgid="����";
	}
	else if(stateTown=="19"){
	orgid="����";
	}
	else if(stateTown=="20"){
	orgid="����";
	}
	else if(stateTown=="23"){
	orgid="����";
	}
	else if(stateTown=="24"){
	orgid="����";
	}
	else if(stateTown=="25"){
	orgid="�Ƹ�";
	}
	else if(stateTown=="26"){
	orgid="Т��";
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
			return alert("��ѡ���Ʒ��");
		}
	}
    	
   var condition = '&saleDetailId=' + saleDetailId + "&detailid="+detailid + '&goodsTagIds=' + goodsTagIds+ '&isrows=';
   var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.activity.web.SaleDetailAction?action=saveRelateGoodsWithSaleDetail' + condition;
   var sid= PostInfo(strUrl, null);
   if(sid.getValueByName("FLAG")=="Y"){
	   if(sid.getValueByName("saleDetailId")!=""){
	   // window.opener._fromSaleDetailFormRowSet().setValue("DETAIL_ID",sid.getValueByName("saleDetailId"));
	   } else {
	   	 alert("����ʧ��!");
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
			alert("ɾ��ʧ�ܣ�");
			return;
		}else if(recode2.getValueByName("FLAG") == "Y"){
			alert("ɾ���ɹ���");
			queryTagbyCharge();
		}
	}
	} else {
		var selectedRow = TagDetailTable.getCurRowIndex();
		var goodsTagIds = TagDetailTable.getValue(selectedRow,"WPID");
		if (goodsTagIds == '') {
			return alert("��ѡ���Ʒ��");
		}
	}
}

//ɾ��
function deleteRows(){
	var selectedRows = TagDetailTable.getSelectedRows(); 
	var RowCount = selectedRows.length;
	if(!confirm("��ȷ��Ҫɾ��ѡ�еļ�¼��")){
		return false;
	}
	
	if(RowCount < 1){
		alert("��ѡ��Ҫɾ���ļ�¼��");
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
			alert("ɾ��ʧ�ܣ�");
			return;
		}else if(ud.getValueByName("FLAG") == "Y"){
			alert("ɾ���ɹ���");
			queryTagbyCharge();
		}	
}

	//����
	function exportAll(){
	
	if(TagDetailTable.count()<=0){
		alert("����û�����ݣ�");
		return;
	}
    location.href = TagDetailTable.toExcelUrl("GoodsMessage_"+g_GetSysDate(),false,null,500,false);
  // location.href = table0.toExcelUrlWithVal("TouchLogQuery_"+g_GetSysDate(),3,null,null,null,null);
}

</script>
</body>
</html>
