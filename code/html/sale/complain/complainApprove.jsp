<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>����Ͷ������</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  
  <body onload="init()">
    <ai:contractframe id="orderComplainMainframe" contenttype="table" title="Ͷ��������Ҫ��Ϣ" width="100%" allowcontract="true" frameclosed="false">
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
           <td class="td_font">��������:</td>
           <td><ai:dbformfield formid="orderComplainMainForm" fieldname="APPLY_NAME" width="200"/><span class="font_red">*</span>
           <ai:dbformfield formid="orderComplainMainForm" fieldname="COMPLAINS_ID" width="60" editable="" visible="false"/>
           <ai:dbformfield formid="orderComplainMainForm" fieldname="STATE" width="150" editable="" visible="false"/></td>
           <td class="td_font">������:</td>
           <td><ai:dbformfield formid="orderComplainMainForm" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
               <ai:dbformfield formid="orderComplainMainForm" fieldname="PROP_STAFF" width="150" editable="false" /><span class="font_red">*</span>
           </td>
         </tr> 
         <tr>
           <td class="td_font">���뵥λ:</td>
           <td><ai:dbformfield formid="orderComplainMainForm" fieldname="ORG" width="130" editable="false" visible="false"/>
               <ai:dbformfield formid="orderComplainMainForm" fieldname="ORG_NAME" width="200" editable="false"/><span class="font_red">*</span></td>
           <td class="td_font">��ϵ�绰:</td>
           <td><ai:dbformfield formid="orderComplainMainForm" fieldname="TEL" width="150"/><span class="font_red">*</span></td>
         
         </tr>
         <tr>
            <td class="td_font">����˵��������:</td>
            <td colspan="5"><ai:dbformfield formid="orderComplainMainForm" fieldname="DESCRIPTION" height="60" width="700"/><span class="font_red">*</span><span style="font-family:��������; color:red; "></span></td>
         </tr>
         <tr><td colspan="4" align="center"><ai:button text="��������Ϣ" id="saveMain" onclick="doWork('saveorderComplainMainInfo()')" /></td></tr>
       </table>
    </ai:dbform>
</ai:contractframe>

	<ai:contractframe id="orderComplainDetailFrame" contenttype="table" title="Ͷ��������ϸ��Ϣ" width="100%" allowcontract="true" frameclosed="fale">
	    <ai:contractitem>
	    <ai:button id="bt_addComplainDetail" text="����"  onclick="addComplain()"/> <ai:button id="bt_delComplainDetail" text="ɾ��"  onclick="delComplain()"/></ai:contractitem>
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
	        	<ai:col title="���" fieldname="ID" visible="" width="10%"/>
	        	<ai:col title="������" fieldname="COMPLAINS_ID" visible="" width="10%"/>
	        	<ai:col title="Ͷ�߹�����" fieldname="ORDER_ID" visible="" width="10%"/>
	        	<ai:col title="Ͷ�߹�������" fieldname="COMPLAINS_TYPE" width="10%"/>
	            <ai:col title="Ͷ�߹�������" fieldname="ORDER_NAME" width="15%" />
	            <ai:col title="Ͷ�߹���������" fieldname="ORDER_STAFF" width="15%" />
	        	<ai:col title="Ͷ��ԭ��" fieldname="COMPLAINS_REASON" width="30%"/>
	        	<ai:col title="Ͷ��ʱ��" fieldname="CREATE_TIME" width="15%" visible="false" />
	        	<ai:col title="Ͷ�߹�������ʱ��" fieldname="ORDER_TIME" width="15%" visible="false"/>
	            <ai:col title="BOSSϵͳ����" fieldname="BOSS_ID" width="20%" visible="false"/>
	    </ai:table>
		</ai:contractframe>
		
		<ai:contractframe id="orderComplainDetailFrame" contenttype="table"
			title="Ͷ����ϸ����" width="100%" allowcontract="true" frameclosed="false">
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
							Ͷ�߹������ͣ�
						</td>
						<td>
							<ai:dbformfield formid="orderComplainDetailForm" fieldname="COMPLAINS_TYPE"
								width="150" />
								<span class="font_red">*</span>
						</td>
						<td class="td_font">
							Ͷ�߹����ţ�
						</td>
						<td>
							<ai:dbformfield formid="orderComplainDetailForm" fieldname="ORDER_ID"
								width="150" />
								<span class="font_red">*</span>
						</td>
					</tr>
					<tr>
						
						<td class="td_font">
							Ͷ�߹��������ˣ�
						</td>
						<td>
							<ai:dbformfield formid="orderComplainDetailForm"
								fieldname="ORDER_STAFF" width="150" editable="false" />
								<img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectorderstaff();" style="cursor:hand;"/>&nbsp;<a href="javascript:clearorderstaff();">���</a>
								<ai:dbformfield formid="orderComplainDetailForm"
								fieldname="PRINCIPLE" width="150" editable="false" visible ="false"/>
						</td>
						<td class="td_font">
							Ͷ�߹������ƣ�
						</td>
						<td>
							<ai:dbformfield formid="orderComplainDetailForm"
								fieldname="ORDER_NAME" width="150" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							Ͷ�߹�������ʱ�䣺
						</td>
						<td>
							<ai:dbformfield formid="orderComplainDetailForm" fieldname="ORDER_TIME"
								width="150"  />
						</td>
						<td class="td_font">
							BOSSϵͳ���룺
						</td>
						<td>
							<ai:dbformfield formid="orderComplainDetailForm"
								fieldname="BOSS_ID" width="150" />
								<span class="font_red">*</span>
						</td>
					</tr>
					<tr>
						<td class="td_font">
							Ͷ��ԭ��
						</td>
						<td colspan="5"><ai:dbformfield formid="orderComplainDetailForm" fieldname="COMPLAINS_REASON" height="60" width="700"/><span class="font_red">*</span><span style="font-family:��������; color:red; "></span></td>
					</tr>
					 <tr><td colspan="4" align="center"><ai:button text="����" id="saveDetail" onclick="doWork('saveDetail()')" /></td></tr>
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
    	beginAIWaitBanner(fun,"���ڴ������Ժ�...");
	}
	function init(){ 
	//�����ѯʱ��״̬Ϊ�ѱ��棩����ҳ��	
	if (complainId== '' || complainId=='null' ||complainId == 'undefined') {
		//ҳ��ˢ�£������޸ģ�idΪ��ʱ��������
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
	
	//����Ͷ����������Ϣ
	function saveorderComplainMainInfo(){
	//complainId = 21924;
	//_ordercomplainFormRowSet.refresh("&complainid="+complainId);
	// table00.refresh("&complainId="+complainId);
	// return;
	 var applyName=_ordercomplainFormRowSet.getValue("APPLY_NAME");
	 var mark=_ordercomplainFormRowSet.getValue("DESCRIPTION"); 
	 if(""==applyName){return  alert("������Ͷ���������ƣ�");}
	 if(""==mark){return  alert("����д����˵����");}
	
	 if ("O" != _ordercomplainFormRowSet.getSts()||_ordercomplainFormRowSet.getSts()=="U")
	 {
        var list = new Array();
	    list.push(_ordercomplainFormRowSet);
	    var strUrl = _gModuleName + '/business/com.asiainfo.sale.complain.web.OrderComplainAction?action=saveOrderComplainMainInfo';
	    var recode = saveRowSet(strUrl, list);
	    complainId = recode.getValueByName("complainId");
	    if(complainId == null || complainId == '' || complainId == 'undefined'){
	    	return alert("�������ʧ�ܣ�");
	    }
  	    _ordercomplainFormRowSet.refresh("&complainid="+complainId);
	 }
}
	
	//����Ͷ��������ϸ��Ϣ
	function saveDetail(){
	 		var complainId = _ordercomplainFormRowSet.getValue("COMPLAINS_ID");
		 	if (complainId == '') 
		 	return alert("���ȱ���Ͷ����������Ϣ��");
		 	if(orderComplainDetailForm.getValue("COMPLAINS_TYPE")=='') 
		 	return alert("��ѡ��Ͷ�����ͣ�");
		 	if(orderComplainDetailForm.getValue("COMPLAINS_TYPE")=='1'){
		 		if (table00.getTotalRowCount() > 0) {
		 			for(var i=0;i<table00.getTotalRowCount();i++){
		 				if(table00.getValue(i,"COMPLAINS_TYPE")!='1')
	    				return alert("Ͷ�߹�������ֻ�ܰ���ȫ��Ӫ�������ߣ��ʷ�+����������");
		 			}
	    		}
		 	}
		 	if (orderComplainDetailForm.getValue("COMPLAINS_TYPE") == '2' || orderComplainDetailForm.getValue("COMPLAINS_TYPE") == '3') {
		    	if (table00.getTotalRowCount() > 0) {
		    		for(var i=0;i<table00.getTotalRowCount();i++){
		 				if(table00.getValue(i,"COMPLAINS_TYPE")=='1')
	    				return alert("Ͷ�߹�������ֻ�ܰ���ȫ��Ӫ�������ߣ��ʷ�+����������");
		 			}
		    	}
	    	}
		 	if(orderComplainDetailForm.getValue("ORDER_ID")=='') 
		 	return alert("����дͶ�߹����ţ�");
		 	if(orderComplainDetailForm.getValue("BOSS_ID")=='') 
		 	return alert("����дBOSSϵͳ���룡");
		 	if(orderComplainDetailForm.getValue("COMPLAINS_REASON")=='') 
		 	return alert("����дͶ��ԭ��");
		 	
	 if ("O" != orderComplainDetailForm.getSts()){
		 	orderComplainDetailForm.setValue("COMPLAINS_ID",complainId);
		 	var list = new Array();
		    list.push(orderComplainDetailForm);
		    var strUrl = _gModuleName + '/business/com.asiainfo.sale.complain.web.OrderComplainAction?action=saveOrderComplainDetail';
		    var recode = saveRowSet(strUrl, list);
		    var Did = recode.getValueByName("Did");
		    if(Did == null || Did == '' || Did == 'Did'){
		    	return alert("�������ʧ�ܣ�");
		    }
		    orderComplainDetailForm.setColEditSts("COMPLAINS_TYPE",false);
	  	    orderComplainDetailForm.refresh("&Id="+Did);
	  	    table00.refresh("&complainId="+complainId);
	  	}
	}
	
	//����Ͷ��������ϸ��Ϣ
	function addComplain(){
		orderComplainDetailForm.setColEditSts("COMPLAINS_TYPE",true);
		orderComplainDetailForm.newRow();
		var complainId = _ordercomplainFormRowSet.getValue("COMPLAINS_ID");
		if(complainId== '' || complainId=='null' ||complainId == 'undefined'){
		
		}else{
			table00.refresh("&complainId="+complainId);
		}
	}
	
	//ɾ��Ͷ��������ϸ��Ϣ
	function delComplain(){
		if(confirm("��ȷ��Ҫɾ����")){
		var complainId = _ordercomplainFormRowSet.getValue("COMPLAINS_ID");
		var ss = new Array();
	 	ss = table00.getSelectedRows();
	  	if (ss.length < 1) {
		        alert("��ѡ��Ҫɾ�������ݣ�");
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
	
	//���в鿴ÿ����¼��Ϣ
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
