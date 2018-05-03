<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>Э���ʷ�����</title>
</script>
</head>
<ai:loginuser/>
<body onload="init();">
<ai:contractframe id="chargeInfoframe" contenttype="table" title="�ʷ�����" width="100%" allowcontract="true" frameclosed="true">
<ai:contractitem/>
 <div id="chargeApplyM_div" style="display: none">  
    <ai:dbform formid="chargeAMainframe" 
            setname="com.asiainfo.charge.web.SETChargeMain"
            conditionname="condition" parametersname="parameters"
            editable="true" initial="false" onvalchange=""
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.charge.service.interfaces.IChargeNewMainSV"
            implservice_querymethod="IChargeMainshow(String id)">
        <table width="98%" align="center" border="0">
          <tr>
          	<td class="td_font">�����ˣ�</td>
            <td><ai:dbformfield formid="chargeAMainframe" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
                <ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_2" width="150" editable="false" />
                <ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_1" width="200" editable="" visible="false"/>
	            <ai:dbformfield formid="chargeAMainframe" fieldname="MAIN_ID" width="200" editable="" visible="false"/>
	            <ai:dbformfield formid="chargeAMainframe" fieldname="STATE" width="200" editable="" visible="false"/></td>
            <td class="td_font">���뵥λ��</td>
            <td><ai:dbformfield formid="chargeAMainframe" fieldname="ORG" width="130" editable="false" visible="false" />
                <ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_3" width="150" editable="false" /></td>
           </tr> 
        </table>
    </ai:dbform>
   
 <ai:contractframe id="chargeApplyMain" contenttype="table" title="�ѱ�����ʷ�����Ϣ" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:table
        tableid="chargeApplyMainTable"
        setname="com.asiainfo.charge.web.SETChargeApplyMain"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.charge.service.interfaces.IChargeNewMainSV"
        implservice_querymethod="getApplyMainsByMainId(String mainid)"
        initial="false"  multiselect="" ondbclick="" onrowchange="showApplyMain"
        pagesize="15" editable="false" width="100%" rowheight=""
        height="100" needrefresh="true">
        	<ai:col title="����ID" fieldname="APPLY_ID" visible=""/>
            <ai:col title="����" fieldname="APPLY_NAME" width="20%" />
            <ai:col title="�ʷ�����" fieldname="FEE_TYPE" width="20%" />
        	<ai:col title="ϸ���г�" fieldname="MARKET_TYPE" width="10%"/>
            <ai:col title="��ʼʱ��" fieldname="APPLY_TIME" width="20%" />
            <ai:col title="����ʱ��" fieldname="APPLY_END_TIME" width="20%" />
    </ai:table>
 </ai:contractframe>
 </div>
 
    <ai:dbform formid="chargeMainframe" 
            setname="com.asiainfo.charge.web.SETChargeApplyMain"
            conditionname="condition" parametersname="parameters"
            onvalchange="" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
            implservice_querymethod="IChargeMainshow(String id)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        <tr>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="STAFFNAME" width="150" editable="" visible="false"/>
                </td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="ORG" width="130" editable="false" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="ORGNAME" width="130" editable="" visible="false"/></td>
           </tr> 
               <tr>
                </td>
                 <td class="td_font">�ʷ����ͣ�</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="FEE_TYPE" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">ϸ���г���</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="MARKET_TYPE" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">Ʒ�ƣ�</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="SALE_FASHION" width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">��ʼʱ�䣺</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_TIME" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">����ʱ�䣺</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_END_TIME" width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">�ʷѰ����ƣ�</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_NAME" width="600"/><span class="font_red">*</span>
                <ai:dbformfield formid="chargeMainframe" fieldname="APPLY_ID" width="50" visible="false"/>
                  <ai:dbformfield formid="chargeMainframe" fieldname="MAIN_ID" width="50" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="IS_SUBMIT" width="150"  visible="false"/>
            </tr>
          <tr>
                <td class="td_font">�ƹ�������</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="EXTEND_CHANNEL" editable="false"  width="600"/>
                <img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="channelMultiplySelected();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
                </td>
            </tr>
            <tr>
                <td class="td_font">�����ںţ�</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="FLACK" height="" width="800"/><span class="font_red">*</span><br></td>
            </tr>
               <tr>
                  <td class="td_font">������</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="BACK_GROUND" height="50" width="800"/><span class="font_red">*</span></td>
            </tr>
             <tr>
                <td class="td_font">Ŀ�ģ�</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_MARK" height="50" width="800"/><span class="font_red">*</span><br></td>
            </tr>
            <tr>
              <td class="td_font">�û����������</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="USER_CIRCS" height="50" width="800"/><span class="font_red">*</span></td>
            </tr>
                <tr>
                <td class="td_font">Ŀ���û������ص㣺</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="CONSUME_ANALYSE" height="50" width="800"/><span class="font_red">*</span></td>
            </tr>
          </table>
    </ai:dbform>

  <div id="modifyMain_bt_div" class="area_button">
   <ai:button text="�޸��ʷ�����Ϣ" id="query3" onclick="doWork('updateChargeMain()')" />&nbsp;&nbsp;
   <ai:button text="�����ʷ�����Ϣ" id="query2" onclick="doWork('addChargeMain()')" />&nbsp;&nbsp;
  </div>
  
 <ai:contractframe id="chargeDetailListframe" contenttype="table" title="" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem>
    <ai:button id="bt_addChargeDetail" text="�����ʷ�"  onclick="addChargeDetail()"/> 
    <ai:button id="bt_delChargeDetail" text="ɾ���ʷ�"  onclick="delChargeDetail()"/>
    <ai:button id="bt_showChargeDetailinfo" text="�鿴�ʷ���Ϣ"  onclick="showChargeDetail()"/>
  </ai:contractitem>
    <ai:table
        tableid="chargeDetailListTable"
        setname="com.asiainfo.charge.web.SETChargeInfo"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
        implservice_querymethod="getChargeDetailByFeeType(String mainId, String feetype, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getCountByFeeType(String mainId, String feetype)"
        initial="false"  multiselect="" ondbclick="showChargeDetail" onrowchange=""
        pagesize="15" editable="false" width="100%" rowheight="50"
        height="180" needrefresh="true">
        	<ai:col title="�ʷ���ϸID" fieldname="MID" visible="false"/>
            <ai:col title="����" fieldname="CHARGE_TYPE" width="8%"/>
            <ai:col title="����" fieldname="FEE_NAME" width="12%" />
            <ai:col title="ϵͳ���ɱ���" fieldname="CASE" width="140" />
        	<ai:col title="BOSSϵͳ����" fieldname="INADD_USER_COUNT" width="140"/>
        	<ai:col fieldname="DOOR_DAMNIFY" width="80"/>
        	<ai:col title="�ײ���Ϣ" fieldname="EXT5" width="20%"/>
        	<ai:col fieldname="FEE_MARK" width="50%"/>
            <ai:col title="�ײ���" fieldname="ADD_USER_MARKET" width="20%" />
            <ai:col title="�ײ���" fieldname="SPLICE_MUTEX_RULE" width="20%" />
            <ai:col title="�ײ�" fieldname="EARNING_TOTAL" width="20%"/>
            <ai:col title="�Ƿ���Ҫ��������" fieldname="IS_SEND_SMS" visible="false" />
            <ai:col title="��̬�����ܺ�" fieldname="DOOR_EARNING" width="8%"/>
            <ai:col title="��̬�����ܺ�" fieldname="EARNING_DAMNIFY" width="8%" />
            <ai:col title="���ʷѵ��α�ʶ" fieldname="EXT6" visible="false" />
    </ai:table>
  </ai:contractframe>
</ai:contractframe>
<div id="fujian">
	<%@ include file="/charge/include/_attach.jsp" %>
</div>
</body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script type="text/javascript">
var rid = "<%=request.getParameter("recordId")%>";
var _mainId =  "<%=request.getParameter("recordId")%>";
var applyId="<%=request.getParameter("recordId")%>";
var taskTag="<%=request.getParameter("taskTag")%>";
var _fromChargeMainFormRowSet= g_FormRowSetManager.get("chargeMainframe");
var _fromChargeAMainFormRowSet= g_FormRowSetManager.get("chargeAMainframe");
var chargeDetailListTable=g_TableRowSetManager.get("chargeDetailListTable");
var chargeApplyMainTable=g_TableRowSetManager.get("chargeApplyMainTable");

function init(){
	initChargeDesc();
	document.all("contractFrame_chargeInfoframe").style.display='block';
	document.all("contractFrame_attachFrame").style.display='block';
	include_reflashAttachTable();
}

function initChargeDesc() {
	if(!taskTag.endWith("-m")){
		_fromChargeAMainFormRowSet.setEditSts(false);
		_fromChargeMainFormRowSet.setEditSts(false);
		document.getElementById("modifyMain_bt_div").style.display="none";
		g_AIButtonManager.get("query2").setDisabled(true);
		g_AIButtonManager.get("query3").setDisabled(true);
		g_AIButtonManager.get("bt_addChargeDetail").setDisabled(true);
		g_AIButtonManager.get("bt_delChargeDetail").setDisabled(true);
	} else {
        document.all("contractFrame_chargeInfoframe").style.display='block';
	}
	if (_mainId == null || _mainId == 'null' || _mainId == '') return;
	_fromChargeAMainFormRowSet.refresh("&id="+applyId);
	chargeApplyMainTable.refresh("&mainid="+applyId);
	chargeApplyMainTable.setFocus(0,0);
}

function addChargeMain(){
	var applyName=_fromChargeMainFormRowSet.getValue("APPLY_NAME");
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	var applyTime=_fromChargeMainFormRowSet.getValue("APPLY_TIME");
	var applyEndTime=_fromChargeMainFormRowSet.getValue("APPLY_END_TIME");
	var extchannel=_fromChargeMainFormRowSet.getValue("EXTEND_CHANNEL");
	var flack=_fromChargeMainFormRowSet.getValue("FLACK");
	var background=_fromChargeMainFormRowSet.getValue("BACK_GROUND");
	var amark=_fromChargeMainFormRowSet.getValue("APPLY_MARK");
	var usercircs=_fromChargeMainFormRowSet.getValue("USER_CIRCS");
	var analyse=_fromChargeMainFormRowSet.getValue("CONSUME_ANALYSE");

	//��������
	if(""==applyName) {return  alert("�������ʷѻ���ƣ�");}
	if(""==feeType) {return  alert("�������ʷ����ͣ�");}
	if(""==applyTime) {return  alert("�������ʷѻ��ʼʱ�䣡");}
	if(""==extchannel) {return  alert("�������ƹ�������");}
	if(""==flack) {return  alert("�����������ںţ�");}
	if(""==background) {return  alert("�����뱳����");}
	if(""==amark) {return  alert("������Ŀ�ģ�");}
	if(""==usercircs) {return  alert("�������û����������");}
	if(""==analyse) {return  alert("������Ŀ���û������ص㣡");}
	if(""==applyEndTime) {applyEndTime=addDate(6,1,applyTime);}
	if(1 == g_CompareDate(applyTime,applyEndTime)) { return alert("�������ʱ�䲻��С�ڿ�ʼʱ�䣡");}

	if ("O" != _fromChargeMainFormRowSet.getSts())
	{
		_fromChargeAMainFormRowSet.setValue("REAMRK_1", _fromChargeMainFormRowSet.getValue("APPLY_NAME"));
		if ("N" == _fromChargeAMainFormRowSet.getSts())
	    {
	    	var chargeOrderList = new Array();
		    chargeOrderList.push(_fromChargeAMainFormRowSet);
		    var actionUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=saveChargeNewMain&applyid=0';
		    var ret = saveRowSet(actionUrl, chargeOrderList);
		    var orderId = ret.getValueByName("NewMainID");
		    _fromChargeAMainFormRowSet.refresh("&id="+orderId);
		    if (orderId == "" || orderId == null) {
		    	return alert("����ʧ��!");
		    }
	    }
		_mainId = _fromChargeAMainFormRowSet.getValue("MAIN_ID");
		_fromChargeMainFormRowSet.setValue("MAIN_ID", _mainId);
	    var list = new Array();
	    list.push(_fromChargeMainFormRowSet);
	    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=saveChargeMain&applyid=0';
	    var recode = saveRowSet(strUrl, list);
	    var mainId = recode.getValueByName("MAINID");
	    _fromChargeMainFormRowSet.setValue("APPLY_ID",mainId);
	    var rFlag = recode.getValueByName("FLAG");
	    if (rFlag == "Y") chargeApplyMainTable.refresh("&mainid="+_mainId);
	 }
    chargeDetailListTable.refresh("&mainId="+_fromChargeMainFormRowSet.getValue("APPLY_ID")+"&feetype="+feeType);
    g_AIButtonManager.get("query2").setDisabled(true);
	g_AIButtonManager.get("query3").setDisabled(false);
	_fromChargeMainFormRowSet.setEditSts(false);
	showTableOn();

}

function delChargeDetail(){
 	var ss = new Array();
    ss = chargeDetailListTable.getSelectedRows();
    if (ss.length < 1) {
        alert("��ѡ��Ҫɾ�������ݣ�");
        return;
    }
    for ( var i = ss.length; i > 0; i--) {
        chargeDetailListTable.deleteRow(ss[i - 1]);
    }
    var list = new Array();
    list.push(chargeDetailListTable);
    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainDeAction?action=saveChargeMainDe';
    var recode = saveRowSet(strUrl, list);
}

function zdyxdMultiplySelected(){
	var url = "<%=request.getContextPath()%>/sale/common/modaldialog/SaleZDYXDMultiplySelected.jsp";
	var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
	var iniVal = _fromChargeMainFormRowSet.getValue("SALE_FASHION");
	_fromChargeMainFormRowSet.setValue("SALE_FASHION",onItemMultiplySelected(url, iniVal, style));
}

function addChargeDetail(){
	var applyId=_fromChargeMainFormRowSet.getValue("APPLY_ID");
	if(""==applyId){
		return alert("���ȱ����ʷ�����Ϣ��");
	}
	var feeName=_fromChargeMainFormRowSet.getValue("APPLY_NAME");
	var taskId="<%=request.getParameter("taskId")%>";
	if(""==applyId){
		return alert("���ȱ����ʷ�������Ϣ��");
	}
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	//0918
	var zfbmmark=_fromChargeMainFormRowSet.getValue("MARKET_TYPE");
	var typecards=_fromChargeMainFormRowSet.getValue("SALE_FASHION");
	var isNewFee = "1" //�����ʷѵ���Ĭ�� �µ��ʷѽṹҳ��
	var url = "<%=request.getContextPath()%>/charge/chargeinfo/chargeDetail.jsp?" +
	          "applyId="+applyId+"&feeType="+feeType+"&feeName="+feeName+
	          "&taskId="+taskId+"&zfbmmark="+zfbmmark+"&typecards="+typecards+
	          "&isNewFee="+isNewFee;
	var returnP=window.open(url,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}


function showChargeDetail(){
	var feeName=_fromChargeMainFormRowSet.getValue("APPLY_NAME");
	var state=_fromChargeAMainFormRowSet.getValue("STATE");
	var curRow = chargeDetailListTable.getRow();
	var mid = chargeDetailListTable.getValue(curRow,"MID");
	var isSendSmsVal=chargeDetailListTable.getValue(curRow,"IS_SEND_SMS");  
	
	var applyId=_fromChargeMainFormRowSet.getValue("APPLY_ID");
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	var taskId="<%=request.getParameter("taskId")%>";
	if(mid==""){
		return alert("��ѡ��һ�����ݣ�");
	}
	var applyId=_fromChargeMainFormRowSet.getValue("APPLY_ID");
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	var typecards=_fromChargeMainFormRowSet.getValue("SALE_FASHION");
	
	var isNewFee = chargeDetailListTable.getValue(curRow,"EXT6"); //��ʾ�ʷѵ�����ϸʱ ����charge_info_t.EXT6�ֶ����ж��Ƿ����µ��ʷѽṹҳ��
	if(taskTag.endWith("-m")){
		state = 1;
	} else {
		state = 2;
	}
	var url = "<%=request.getContextPath()%>/charge/chargeinfo/chargeDetail.jsp?" +
			  "applyId="+applyId+"&feeType="+feeType+"&mid="+mid+"&feeName="+feeName+
			  "&state="+state+"&taskId="+taskId+"&isSendSmsVal="+isSendSmsVal+
			  "&isNewFee="+isNewFee + "&taskTag=" + taskTag;
	window.open(url,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no"); 
}

function addChargeMainNew(){
	if(window.confirm("�½��ʷѰ������δ�����Ӫ������Ϣ��ȷ��Ҫ�½���"))
    {
        location.reload();
    }
}


function  updateChargeMain(){
		init();
		_fromChargeMainFormRowSet.setEditSts(true);
		_fromChargeMainFormRowSet.setColEditSts("PRINCIPLE",false);
		_fromChargeMainFormRowSet.setColEditSts("ORG",false);
		//document.getElementById("include").style.display="none";
	    g_AIButtonManager.get("query3").setDisabled(true);
		g_AIButtonManager.get("query2").setDisabled(false);
}


function showEndTime(pFieldName,pOldVal,pOldText,pNewVal,pNewText){
	if(pFieldName=="APPLY_TIME"){
		if(""!=pFieldName){
			_fromChargeMainFormRowSet.setValue("APPLY_END_TIME",addDate(6,1,_fromChargeMainFormRowSet.getValue("APPLY_TIME")));
		}
	}
	if(pFieldName=="FEE_TYPE"){
		showTableOn();
	}
}

function closePage(){
   	window.opener.location.reload();
    window.self.close();
}

function showTableOn(){
	if("41"==_fromChargeMainFormRowSet.getValue("FEE_TYPE")||"31"==_fromChargeMainFormRowSet.getValue("FEE_TYPE")){
		chargeDetailListTable.setColVisible("ADD_USER_MARKET",false);
		chargeDetailListTable.setColVisible("SPLICE_MUTEX_RULE",false);
		chargeDetailListTable.setColVisible("EARNING_TOTAL",true);
	} else {
		chargeDetailListTable.setColVisible("ADD_USER_MARKET",true);
		chargeDetailListTable.setColVisible("SPLICE_MUTEX_RULE",true);
		chargeDetailListTable.setColVisible("EARNING_TOTAL",false);
	}
}

function checkHasEmptyBossid(){
    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=checkChargeBossid&mainid='+_mainId;
    var recode = PostInfo(strUrl, null);
    var check=recode.getValueByName("check");
	if(check=="N"){
		return false;
	} else {
		return true;
	}
}

function showApplyMain(){
	
	var curRow = chargeApplyMainTable.getRow();
	var applyId=chargeApplyMainTable.getValue(curRow,"APPLY_ID");
	_fromChargeMainFormRowSet.refresh("&id="+applyId);
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	chargeDetailListTable.refresh("&mainId="+applyId+"&feetype="+feeType);
}

function selectFile(type,colNum) {
	var retVal = window.showModalDialog('<%=request.getContextPath()%>/charge/include/_fileSelectDlg.jsp?colNum='+colNum, null, "scroll:no;resizable:no;help:no;status:no;dialogHeight:100px;dialogWidth:560px");
	if (retVal == "" || retVal == undefined) return;
	var targetTab;
 	if (type == 'i_test') {
  		targetTab = chargeInnerTestTab;
 	} else if (type == 'e_test') {
  		targetTab = chargeExternTestTab;
 	} else if (type == 'cfg') {
  		targetTab = chargeCfgTab;
 	} 
	if (type.endWith("test")){
		targetTab.clear();
	    var rows = retVal.split("|");
		for (var i = 0; i < rows.length; ++i) {
			targetTab.newRow(false);
			targetTab.setValue(i,"TEST_FACTOR",rows[i].split("-")[0]);
			targetTab.setValue(i,"TEST_RESULT",rows[i].split("-")[1]);
			targetTab.setValue(i,"REASON",rows[i].split("-")[2]);
			targetTab.setValue(i,"ORDER_ID",_mainId);
		}
 	} else if (type.endWith("cfg")) {
 		targetTab.clear();
	    var rows = retVal.split("|");
 		for (var i = 0; i < rows.length; ++i) {
			targetTab.newRow(false);
			targetTab.setValue(i,"FACTOR",rows[i].split("-")[0]);
			targetTab.setValue(i,"MOLD",rows[i].split("-")[1]);
			targetTab.setValue(i,"DESC",rows[i].split("-")[2]);
			targetTab.setValue(i,"MODE",rows[i].split("-")[3]);
			targetTab.setValue(i,"ORDER_ID",_mainId);
		}
 	} 
}

function doOnFinish(aUserDataXml){
  var aFlag=getReturnValueByName(aUserDataXml,"FLAG");
  var aMsg=getReturnValueByName(aUserDataXml,"MESSAGE");
  var targetTab;
  var type = getReturnValueByName(aUserDataXml,"TYPE");
  if (type == 'i_test') {
	  targetTab = chargeInnerTestTab;
  } else if (type == 'e_test') {
	  targetTab = chargeExternTestTab;
  } else if (type == 'cfg') {
	  targetTab = chargeCfgTab;
  } 
  if (aFlag=="Y" && type.endWith("test")){
	targetTab.clear();
    var confs = getReturnValueByName(aUserDataXml,"confs");
    var rows = confs.split("|");
	for (var i = 0; i < rows.length; ++i) {
		targetTab.newRow(false);
		targetTab.setValue(i,"TEST_FACTOR",rows[i].split("-")[0]);
		targetTab.setValue(i,"TEST_RESULT",rows[i].split("-")[1]);
		targetTab.setValue(i,"REASON",rows[i].split("-")[2]);
	}
  } else if (aFlag=="Y" && type.endWith("cfg")) {
	 targetTab.clear();
     var confs = getReturnValueByName(aUserDataXml,"confs");
     var rows = confs.split("|");
	 for (var i = 0; i < rows.length; ++i) {
		targetTab.newRow(false);
		targetTab.setValue(i,"FACTOR",rows[i].split("-")[0]);
		targetTab.setValue(i,"MOLD",rows[i].split("-")[1]);
		targetTab.setValue(i,"DESC",rows[i].split("-")[2]);
		targetTab.setValue(i,"MODE",rows[i].split("-")[3]);
	}
  } else if (aFlag=="Y") {
	  include_reflashAttachTable();
  } else {
	   alert(aMsg);
  }
}

String.prototype.endWith=function(str){     
  var reg=new RegExp(str+"$");     
  return reg.test(this);        
}

function trim(str){
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"���ڴ������Ժ�...");
}

</script>




