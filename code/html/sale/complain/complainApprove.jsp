<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>工单投诉申请</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  
  <body onload="init()">
    <ai:contractframe id="orderComplainMainframe" contenttype="table" title="投诉申请主要信息" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="orderComplainMainForm" 
            setname="com.asiainfo.sale.complain.web.SETOrderComplains"
            conditionname="condition" parametersname="parameters"
            editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.complain.service.interfaces.IOrderComplainSV"
            implservice_querymethod="getOrderComplainByID(String complainid)">
        <table width="100%" align="center" border="0" cellpadding="1" cellspacing="1">
        <tr>
           <td class="td_font">申请名称:</td>
           <td><ai:dbformfield formid="orderComplainMainForm" fieldname="APPLY_NAME" width="200"/><span class="font_red">*</span>
           <ai:dbformfield formid="orderComplainMainForm" fieldname="COMPLAINS_ID" width="60" editable="" visible="false"/>
           <ai:dbformfield formid="orderComplainMainForm" fieldname="STATE" width="150" editable="" visible="false"/></td>
           <td class="td_font">申请人:</td>
           <td><ai:dbformfield formid="orderComplainMainForm" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
               <ai:dbformfield formid="orderComplainMainForm" fieldname="PROP_STAFF" width="150" editable="false" /><span class="font_red">*</span>
           </td>
         </tr> 
         <tr>
           <td class="td_font">申请单位:</td>
           <td><ai:dbformfield formid="orderComplainMainForm" fieldname="ORG" width="130" editable="false" visible="false"/>
               <ai:dbformfield formid="orderComplainMainForm" fieldname="ORG_NAME" width="200" editable="false"/><span class="font_red">*</span></td>
           <td class="td_font">联系电话:</td>
           <td><ai:dbformfield formid="orderComplainMainForm" fieldname="TEL" width="150"/><span class="font_red">*</span></td>
         
         </tr>
         <tr>
            <td class="td_font">申请说明及依据:</td>
            <td colspan="5"><ai:dbformfield formid="orderComplainMainForm" fieldname="DESCRIPTION" height="60" width="700"/><span class="font_red">*</span><span style="font-family:华文中宋; color:red; "></span></td>
         </tr>
         <tr><td colspan="4" align="center"><ai:button text="保存主信息" id="saveMain" onclick="doWork('saveorderComplainMainInfo()')" /></td></tr>
       </table>
    </ai:dbform>
</ai:contractframe>

	<ai:contractframe id="orderComplainDetailFrame" contenttype="table" title="投诉申请详细信息" width="100%" allowcontract="true" frameclosed="fale">
	    <ai:contractitem>
	    <ai:button id="bt_addComplainDetail" text="新增"  onclick="addComplain()"/> <ai:button id="bt_delComplainDetail" text="删除"  onclick="delComplain()"/></ai:contractitem>
	    <ai:table
	        tableid="table00"
	        setname="com.asiainfo.sale.complain.web.SETOrderComplainsDetail"
	        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	        implservice_name="com.asiainfo.sale.complain.service.interfaces.IOrderComplainDetailSV"
	        implservice_querymethod="getOrderComplainDetailByPID(String complainId, int $STARTROWINDEX,int $ENDROWINDEX)"
	        implservice_countmethod="getOrderComplainDetailCountByPID(String complainId)" 
	        initial="false"  multiselect="true" onrowchange="showComplain"
	        pagesize="15" editable="false" width="100%" 
	        height="100" needrefresh="true">
	        	<ai:col title="编号" fieldname="ID" visible="" width="10%"/>
	        	<ai:col title="工单号" fieldname="COMPLAINS_ID" visible="" width="10%"/>
	        	<ai:col title="投诉工单号" fieldname="ORDER_ID" visible="" width="10%"/>
	        	<ai:col title="投诉工单类型" fieldname="COMPLAINS_TYPE" width="10%"/>
	            <ai:col title="投诉工单名称" fieldname="ORDER_NAME" width="15%" />
	            <ai:col title="投诉工单申请人" fieldname="ORDER_STAFF" width="15%" />
	        	<ai:col title="投诉原因" fieldname="COMPLAINS_REASON" width="30%"/>
	        	<ai:col title="投诉时间" fieldname="CREATE_TIME" width="15%" visible="false" />
	        	<ai:col title="投诉工单上线时间" fieldname="ORDER_TIME" width="15%" visible="false"/>
	            <ai:col title="BOSS系统编码" fieldname="BOSS_ID" width="20%" visible="false"/>
	    </ai:table>
		</ai:contractframe>
		
		<ai:contractframe id="orderComplainDetailFrame" contenttype="table"
			title="投诉详细申请" width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem>
			</ai:contractitem>
			<ai:dbform formid="orderComplainDetailForm"
				setname="com.asiainfo.sale.complain.web.SETOrderComplainsDetail" 
				onvalchange="" initial="false"
				conditionname="condition" parametersname="parameters"
             datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.complain.service.interfaces.IOrderComplainDetailSV"
            implservice_querymethod="getOrderComplainDetailByID(String Id)">
	
				<table width="98%" align="center" border="0" cellpadding="1"
					cellspacing="2" >
					<tr>
						<td>
							<ai:dbformfield formid="orderComplainDetailForm" fieldname="ID"
								width="150" visible="false"/>
						</td>
						<td>
							<ai:dbformfield formid="orderComplainDetailForm" fieldname="COMPLAINS_ID"
								width="150" visible="false"/>
						</td>
					</tr>
					<tr>
						<td class="td_font">
							投诉工单类型：
						</td>
						<td>
							<ai:dbformfield formid="orderComplainDetailForm" fieldname="COMPLAINS_TYPE"
								width="150" />
								<span class="font_red">*</span>
						</td>
						<td class="td_font">
							投诉工单号：
						</td>
						<td>
							<ai:dbformfield formid="orderComplainDetailForm" fieldname="ORDER_ID"
								width="150" />
								<span class="font_red">*</span>
						</td>
					</tr>
					<tr>
						
						<td class="td_font">
							投诉工单申请人：
						</td>
						<td>
							<ai:dbformfield formid="orderComplainDetailForm"
								fieldname="ORDER_STAFF" width="150" editable="false" />
								<img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectorderstaff();" style="cursor:hand;"/>&nbsp;<a href="javascript:clearorderstaff();">清空</a>
								<ai:dbformfield formid="orderComplainDetailForm"
								fieldname="PRINCIPLE" width="150" editable="false" visible ="false"/>
						</td>
						<td class="td_font">
							投诉工单名称：
						</td>
						<td>
							<ai:dbformfield formid="orderComplainDetailForm"
								fieldname="ORDER_NAME" width="150" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							投诉工单上线时间：
						</td>
						<td>
							<ai:dbformfield formid="orderComplainDetailForm" fieldname="ORDER_TIME"
								width="150"  />
						</td>
						<td class="td_font">
							BOSS系统编码：
						</td>
						<td>
							<ai:dbformfield formid="orderComplainDetailForm"
								fieldname="BOSS_ID" width="150" />
								<span class="font_red">*</span>
						</td>
					</tr>
					<tr>
						<td class="td_font">
							投诉原因：
						</td>
						<td colspan="5"><ai:dbformfield formid="orderComplainDetailForm" fieldname="COMPLAINS_REASON" height="60" width="700"/><span class="font_red">*</span><span style="font-family:华文中宋; color:red; "></span></td>
					</tr>
					 <tr><td colspan="4" align="center"><ai:button text="保存" id="saveDetail" onclick="doWork('saveDetail()')" /></td></tr>
			</table>
		</ai:dbform>
	</ai:contractframe>
<ai:loginuser/>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js" type="text/javascript"></script>
<%@include file="/sale/complain/complainCheck.jsp"%>

</body>
</html>
<script type="text/javascript">
	var _orgId = g_GetUserInfo().ORG_ID;
	var complainId = "<%=request.getParameter("recordId")%>";
	var _mainId = complainId;
	var taskTag="<%=request.getParameter("taskTag")%>";
	var _ordercomplainFormRowSet= g_FormRowSetManager.get("orderComplainMainForm");
	var orderComplainDetailForm= g_FormRowSetManager.get("orderComplainDetailForm");
	var table00 = g_TableRowSetManager.get("table00"); 
	function doWork(fun){ 
    	beginAIWaitBanner(fun,"正在处理，请稍后...");
	}
	function init(){ 
	//点击查询时候（状态为已保存）进入页面	
	if (complainId== '' || complainId=='null' ||complainId == 'undefined') {
		//页面刷新，或是修改；id为空时，是申请
		//var staffId = g_GetUserInfo().STAFF_ID;
		_ordercomplainFormRowSet.setValue("PRINCIPLE",g_GetUserInfo().STAFF_ID);
		_ordercomplainFormRowSet.setValue("PROP_STAFF",g_GetUserInfo().STAFF_NAME);
		_ordercomplainFormRowSet.setValue("ORG",g_GetUserInfo().ORG_ID);
		_ordercomplainFormRowSet.setValue("ORG_NAME",g_GetUserInfo().ORG_NAME);
		_ordercomplainFormRowSet.setValue("TEL",g_GetUserInfo().STAFF_ID);
		showName();
	} else {
	  _ordercomplainFormRowSet.refresh("&complainid="+complainId);
	  showName();
	  table00.refresh("&complainId="+complainId);
	  include_reflashAttachTable();
   }
   initCheckPage();
   if (taskTag != 'complain002'){
	   _ordercomplainFormRowSet.setEditSts("false");
	   orderComplainDetailForm.setEditSts("false");
	   g_AIButtonManager.get("saveMain").setDisabled("false");
	   g_AIButtonManager.get("bt_addComplainDetail").setDisabled("false");
	   g_AIButtonManager.get("bt_delComplainDetail").setDisabled("false");
	   g_AIButtonManager.get("saveDetail").setDisabled("false");
   }
}

function showName(){
	_ordercomplainFormRowSet.setFocus("TEL");
	_ordercomplainFormRowSet.setColEditSts("TEL",false);
}

function clearorderstaff(){
	orderComplainDetailForm.setValue("PRINCIPLE", "");
	orderComplainDetailForm.setValue("ORDER_STAFF", "");
}

function selectorderstaff()
{
	var result = openSelect.staffSelect("tsd",'10',g_GetUserInfo().ORG_ID);
    if(result != null){
        var operatorId;
        var name;
        for(var i=0;i < result.elements.length;i++)
        {
            if (i == 0)
            {
                operatorId = result.elements[i].operatorId;
                name = result.elements[i].name;
            } else {
                operatorId = operatorId + ";" + result.elements[i].operatorId;
                name = name + ";" + result.elements[i].name;
            }
        }
        orderComplainDetailForm.setValue("PRINCIPLE", operatorId);
        orderComplainDetailForm.setValue("ORDER_STAFF", name);
    }
} 
	
	//保存投诉申请主信息
	function saveorderComplainMainInfo(){
	//complainId = 21924;
	//_ordercomplainFormRowSet.refresh("&complainid="+complainId);
	// table00.refresh("&complainId="+complainId);
	// return;
	 var applyName=_ordercomplainFormRowSet.getValue("APPLY_NAME");
	 var mark=_ordercomplainFormRowSet.getValue("DESCRIPTION"); 
	 if(""==applyName){return  alert("请输入投诉申请名称！");}
	 if(""==mark){return  alert("请填写申请说明！");}
	
	 if ("O" != _ordercomplainFormRowSet.getSts()||_ordercomplainFormRowSet.getSts()=="U")
	 {
        var list = new Array();
	    list.push(_ordercomplainFormRowSet);
	    var strUrl = _gModuleName + '/business/com.asiainfo.sale.complain.web.OrderComplainAction?action=saveOrderComplainMainInfo';
	    var recode = saveRowSet(strUrl, list);
	    complainId = recode.getValueByName("complainId");
	    if(complainId == null || complainId == '' || complainId == 'undefined'){
	    	return alert("保存操作失败！");
	    }
  	    _ordercomplainFormRowSet.refresh("&complainid="+complainId);
	 }
}
	
	//保存投诉申请详细信息
	function saveDetail(){
	 		var complainId = _ordercomplainFormRowSet.getValue("COMPLAINS_ID");
		 	if (complainId == '') 
		 	return alert("请先保存投诉申请主信息！");
		 	if(orderComplainDetailForm.getValue("COMPLAINS_TYPE")=='') 
		 	return alert("请选择投诉类型！");
		 	if(orderComplainDetailForm.getValue("COMPLAINS_TYPE")=='1'){
		 		if (table00.getTotalRowCount() > 0) {
		 			for(var i=0;i<table00.getTotalRowCount();i++){
		 				if(table00.getValue(i,"COMPLAINS_TYPE")!='1')
	    				return alert("投诉工单类型只能包含全是营销案或者（资费+武器案）！");
		 			}
	    		}
		 	}
		 	if (orderComplainDetailForm.getValue("COMPLAINS_TYPE") == '2' || orderComplainDetailForm.getValue("COMPLAINS_TYPE") == '3') {
		    	if (table00.getTotalRowCount() > 0) {
		    		for(var i=0;i<table00.getTotalRowCount();i++){
		 				if(table00.getValue(i,"COMPLAINS_TYPE")=='1')
	    				return alert("投诉工单类型只能包含全是营销案或者（资费+武器案）！");
		 			}
		    	}
	    	}
		 	if(orderComplainDetailForm.getValue("ORDER_ID")=='') 
		 	return alert("请填写投诉工单号！");
		 	if(orderComplainDetailForm.getValue("BOSS_ID")=='') 
		 	return alert("请填写BOSS系统编码！");
		 	if(orderComplainDetailForm.getValue("COMPLAINS_REASON")=='') 
		 	return alert("请填写投诉原因！");
		 	
	 if ("O" != orderComplainDetailForm.getSts()){
		 	orderComplainDetailForm.setValue("COMPLAINS_ID",complainId);
		 	var list = new Array();
		    list.push(orderComplainDetailForm);
		    var strUrl = _gModuleName + '/business/com.asiainfo.sale.complain.web.OrderComplainAction?action=saveOrderComplainDetail';
		    var recode = saveRowSet(strUrl, list);
		    var Did = recode.getValueByName("Did");
		    if(Did == null || Did == '' || Did == 'Did'){
		    	return alert("保存操作失败！");
		    }
		    orderComplainDetailForm.setColEditSts("COMPLAINS_TYPE",false);
	  	    orderComplainDetailForm.refresh("&Id="+Did);
	  	    table00.refresh("&complainId="+complainId);
	  	}
	}
	
	//新增投诉申请详细信息
	function addComplain(){
		orderComplainDetailForm.setColEditSts("COMPLAINS_TYPE",true);
		orderComplainDetailForm.newRow();
		var complainId = _ordercomplainFormRowSet.getValue("COMPLAINS_ID");
		if(complainId== '' || complainId=='null' ||complainId == 'undefined'){
		
		}else{
			table00.refresh("&complainId="+complainId);
		}
	}
	
	//删除投诉申请详细信息
	function delComplain(){
		if(confirm("您确定要删除！")){
		var complainId = _ordercomplainFormRowSet.getValue("COMPLAINS_ID");
		var ss = new Array();
	 	ss = table00.getSelectedRows();
	  	if (ss.length < 1) {
		        alert("请选择要删除的数据！");
		        return;
	    }
	    for ( var i = ss.length; i > 0; i--) {
	        table00.deleteRow(ss[i - 1]);
	    }
		var list = new Array();
		list.push(table00);
		var strUrl = _gModuleName + '/business/com.asiainfo.sale.complain.web.OrderComplainAction?action=delOrderComplainDetail';
		var ud = saveRowSet(strUrl, list);
		if (ud.getValueByName("FLAG") == "Y") {
			table00.refresh("&complainId="+complainId);
		} else {
			alert(ud.getValueByName("MESSAGE"));
			return;
		}
		orderComplainDetailForm.setColEditSts("COMPLAINS_TYPE",true);
		orderComplainDetailForm.newRow();
	}
	}
	
	//换行查看每条记录信息
	function showComplain(oldIndex,newIndex){
		orderComplainDetailForm.setColEditSts("COMPLAINS_TYPE",false);
		if(-1 != oldIndex) {
      	 	table00.setRowBgColor(oldIndex,"");
    	}
    	 table00.setRowBgColor(newIndex,"yellow");
    	 var Did = table00.getValue(newIndex,"ID");
		 if(Did != null && Did != ""){
		 	 orderComplainDetailForm.refresh("&Id="+Did);
		 }
	}
</script>
