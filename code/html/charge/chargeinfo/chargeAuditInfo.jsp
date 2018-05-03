<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
 <body onload="init()">
  <ai:contractframe id="chargeAMainframe" contenttype="table" title="�ʷѰ�����Ϣ" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem>
    </ai:contractitem>
    <ai:dbform formid="chargeAMainframe" 
            setname="com.asiainfo.charge.web.SETChargeMain"
            conditionname="condition" parametersname="parameters"
            editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.charge.service.interfaces.IChargeNewMainSV"
            implservice_querymethod="IChargeMainshow(String id)">
        <table width="98%" align="center" border="0" >
          <tr>
          <td class="td_font">�������ƣ�</td>
             <td><ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_1" width="200" editable="" visible=""/>
            <ai:dbformfield formid="chargeAMainframe" fieldname="MAIN_ID" width="200" editable="" visible="false"/>
            <ai:dbformfield formid="chargeAMainframe" fieldname="STATE" width="200" editable="" visible="false"/>
                </td>
          <td class="td_font">�����ˣ�</td>
                <td><ai:dbformfield formid="chargeAMainframe" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
                 <td><ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_2" width="150" editable="false" />
                </td>
                  <td class="td_font">���뵥λ��</td>
                <td><ai:dbformfield formid="chargeAMainframe" fieldname="ORG" width="130" editable="false" visible="false" />
                <td><ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_3" width="130" editable="false" />
               </td>
           </tr> 
        </table>
        </ai:dbform>
        </ai:contractframe>
        
  
  
  <ai:contractframe id="chargeApplyMain" contenttype="table" title="�ѱ���ĵ�����Ϣ" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem><%--<ai:button id="newSaleDetail" text="�½��" onclick="newSaleDetail()"/>--%>
    <ai:button id="bt_addCharge" text="�����ʷ�����"  onclick="addChargePc()"/> <ai:button id="bt_delCharge" text="ɾ���ʷ�����"  onclick="delCharge()"/></ai:contractitem>
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
        	<ai:col title="ϸ���г�" fieldname="MARKET_TYPE" width="20%"/>
            <ai:col title="��ʼʱ��" fieldname="APPLY_TIME" width="20%" />
            <ai:col title="����ʱ��" fieldname="APPLY_END_TIME" width="20%" />
    </ai:table>
</ai:contractframe>
  
 
    <ai:contractframe id="chargeMainframe" contenttype="table" title="�ʷѰ���Ҫ��Ϣ" width="100%" allowcontract="true" frameclosed="true">
    <ai:contractitem/>
    <ai:dbform formid="chargeMainframe" 
            setname="com.asiainfo.charge.web.SETChargeApplyMain"
            conditionname="condition" parametersname="parameters"
            onvalchange="" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
            implservice_querymethod="IChargeMainshow(String id)">
        <table width="100%" align="center" border="0" cellpadding="1" cellspacing="2">
        <tr>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="STAFFNAME" width="150" editable=""  visible="false"/>
                </td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="ORG" width="130" editable="false" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="ORGNAME" width="130" editable=""  visible="false"/></td>
           </tr> 
            <tr>
                <td class="td_font">�ʷѰ����ƣ�</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_NAME" width="150"/><span class="font_red">*</span>
                <ai:dbformfield formid="chargeMainframe" fieldname="APPLY_ID" width="50" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="IS_SUBMIT" width="150"  visible="false"/>
                </td>
                 <td class="td_font">�ʷ����ͣ�</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="FEE_TYPE" width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">��ʼʱ�䣺</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_TIME" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">����ʱ�䣺</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_END_TIME" width="150"/><span class="font_red">*</span></td>
              </tr>
          <tr>
                <td class="td_font">�ƹ�������</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="EXTEND_CHANNEL" height="" width="800"/></td>
            </tr>
            <tr>
                <td class="td_font">�����ںţ�</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="FLACK" height="" width="800"/><br></td>
            </tr>
               <tr>
                  <td class="td_font">������</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="BACK_GROUND" height="80" width="800"/></td>
            </tr>
             <tr>
                <td class="td_font">Ŀ�ģ�</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_MARK" height="80" width="800"/><br></td>
            </tr>
            <tr>
              <td class="td_font">�û����������</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="USER_CIRCS" height="80" width="800"/></td>
            </tr>
                <tr>
                <td class="td_font">Ŀ���û������ص㣺</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="CONSUME_ANALYSE" height="80" width="800"/></td>
            </tr>
            
          </table>
    </ai:dbform>
</ai:contractframe>
      <div class="area_button">
   <ai:button text="�����ʷ�" id="query4" onclick="addChargeMainNew()" />&nbsp;&nbsp;
   <ai:button text="�޸��ʷ�����Ϣ" id="query3" onclick="doWork('updateChargeMain()')" />&nbsp;&nbsp;
  <ai:button text="�����ʷ�����Ϣ" id="query2" onclick="doWork('addChargeMain()')" />&nbsp;&nbsp;
  </div>
<ai:contractframe id="chargeDetailListframe" contenttype="table" title="�ѱ���ĵ�����Ϣ" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem><%--<ai:button id="newSaleDetail" text="�½��" onclick="newSaleDetail()"/>--%>
   <ai:button id="bt_showChargeDetailinfo" text="�鿴�ʷѵ���"  onclick="showChargeDetail()"/></ai:contractitem>
    <ai:table
        tableid="chargeDetailListTable"
        setname="com.asiainfo.charge.web.SETChargeInfo"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
        implservice_querymethod="getChargeDetailByFeeType(String mainId, String feetype, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getCountByFeeType(String mainId, String feetype)"
        initial="false"  multiselect="" ondbclick="showChargeDetail"
        pagesize="15" editable="false" width="100%" rowheight="50"
        height="180" needrefresh="true">
        	<ai:col title="����ID" fieldname="MID" visible="false"/>
            <ai:col title="����" fieldname="CHARGE_TYPE" width="8%"/>
            <ai:col title="����" fieldname="FEE_NAME" width="12%" />
            <ai:col title="�ʷ�ϵͳ���α���" fieldname="CASE" width="140" />
        	<ai:col title="BOSSϵͳ����ID" fieldname="INADD_USER_COUNT" width="140"/>
            <ai:col title="��̬�����ܺ�" fieldname="DOOR_EARNING" width="8%"/>
            <ai:col title="��̬�����ܺ�" fieldname="EARNING_DAMNIFY" width="8%" />
            <ai:col title="�ײ���" fieldname="ADD_USER_MARKET" width="32%" />
            <ai:col title="�ײ���" fieldname="SPLICE_MUTEX_RULE" width="32%" />
            <ai:col title="�ײ�" fieldname="EARNING_TOTAL" width="80%" />
            <ai:col title="�Ƿ���Ҫ��������" fieldname="IS_SEND_SMS" visible="false" />
            <ai:col title="�����ײ�" fieldname="EXT5" width="32%"/>
            <ai:col title="���ʷѵ��α�ʶ" fieldname="EXT6" visible="false" />
    </ai:table>
</ai:contractframe>
<div id="stype">
<%@include file="/sale/common/include/_check.jsp"%>
</div>
</div>
  </body>
</html>
<ai:loginuser/>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script type="text/javascript">
var rid = "<%=request.getParameter("recordId")%>";
var _mainId =  "<%=request.getParameter("recordId")%>";

var applyid="<%=request.getParameter("applyid")%>";
var taskTag="<%=request.getParameter("taskTag")%>";
var _fromChargeMainFormRowSet= g_FormRowSetManager.get("chargeMainframe");
var _fromChargeAMainFormRowSet= g_FormRowSetManager.get("chargeAMainframe");
var chargeDetailListTable=g_TableRowSetManager.get("chargeDetailListTable");
var chargeApplyMainTable=g_TableRowSetManager.get("chargeApplyMainTable");
var stype="<%=request.getParameter("stype")%>";


function init(){

g_AIButtonManager.get("bt_addCharge").setDisabled(true);
g_AIButtonManager.get("bt_delCharge").setDisabled(true);
	
//�˻ػ��Ƿ������޸ĵ�ʱ��
if(stype=="y"){
document.getElementById("stype").style.display="none";
}else{
initCheckPage();
}
	if(taskTag=="C002"||taskTag=="C013"||taskTag=="PC023"||taskTag=="C032"||taskTag=="PC001"||taskTag=="C036"){
	var templateTag = "<%=request.getParameter("templateTag")%>";
  	 var recordId = "<%=request.getParameter("recordId")%>";
  	 var recordType = "<%=request.getParameter("recordType")%>";
  	 var taskId ="<%=request.getParameter("taskId")%>";
     var taskTemplateId ="<%=request.getParameter("taskTemplateId")%>";
     var templateCode ="<%=request.getParameter("templateCode")%>";
     var workflowId ="<%=request.getParameter("workflowId")%>";
	  var url = "<%=request.getContextPath()%>/charge/chargeinfo/chargeAuditEditInfo.jsp?applyid="+applyid+"&templateTag="+templateTag
                                                                       +"&taskTag="+taskTag
                                                                       +"&recordId="+recordId
                                                                       +"&recordType="+recordType
                                                                       +"&taskId="+taskId
                                                                       +"&taskTemplateId="+taskTemplateId
                                                                       +"&templateCode="+templateCode
                                                                       +"&workflowId="+workflowId;
	window.location.href=url;
	}
		
	if("null"==applyid||""==applyid){
	applyid=rid;
	}
	//var id =_fromChargeMainFormRowSet.getValue("APPLY_ID");
	if("null"!=applyid||""==applyid){
	_fromChargeAMainFormRowSet.refresh("&id="+applyid);
	 chargeApplyMainTable.refresh("&mainid="+applyid);
	_fromChargeMainFormRowSet.setFocus("STAFFNAME");
    _fromChargeMainFormRowSet.setFocus("ORGNAME");
    _fromChargeMainFormRowSet.setColEditSts("ORGNAME",false);
	_fromChargeMainFormRowSet.setColEditSts("STAFFNAME",false);
	_fromChargeMainFormRowSet.setEditSts(false);
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	var staffId = g_GetUserInfo().STAFF_ID;
	 g_AIButtonManager.get("query2").setDisabled(true);
	//chargeDetailListTable.refresh("&mainId="+recordId+"&feetype="+feeType);
	showTableOn();
	//include_reflashAttachTable();
	}
	else{
		if(""!=id){
		_fromChargeMainFormRowSet.refresh("&id="+id);
		_fromChargeMainFormRowSet.setEditSts(false);
		var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
		var staffId = g_GetUserInfo().STAFF_ID;
		 g_AIButtonManager.get("query2").setDisabled(true);
		chargeDetailListTable.refresh("&mainId="+applyid+"&feetype="+feeType);
		}else{
	 var staffId = g_GetUserInfo().STAFF_ID;
	g_AIButtonManager.get("query3").setDisabled(true);
	}
	}
	g_AIButtonManager.get("query2").setDisabled(true);
	g_AIButtonManager.get("query3").setDisabled(true);
	g_AIButtonManager.get("query4").setDisabled(true);
	//document.getElementById("include").style.display="block";
}

function addChargeMain(){
var applyName=_fromChargeMainFormRowSet.getValue("APPLY_NAME");
var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
var applyTime=_fromChargeMainFormRowSet.getValue("APPLY_TIME");
var applyEndTime=_fromChargeMainFormRowSet.getValue("APPLY_END_TIME");
if(""==applyName){return  alert("�������ʷѻ���ƣ�");}
if(""==feeType){return  alert("�������ʷ����ͣ�");}
if(""==applyTime){return  alert("�������ʷѻ��ʼʱ�䣡");}
if(""==applyEndTime){return  alert("�������ʷѻ����ʱ�䣡");}
if(1 == g_CompareDate(applyTime,applyEndTime)){ return alert("�������ʱ�䲻��С�ڿ�ʼʱ�䣡");}
 if ("O" != _fromChargeMainFormRowSet.getSts())
    {
    var list = new Array();
	    list.push(_fromChargeMainFormRowSet);
	    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=saveChargeMain';
	    var recode = saveRowSet(strUrl, list);
	    var mainId = recode.getValueByName("MAINID");
	    _fromChargeMainFormRowSet.setValue("APPLY_ID",mainId);
	    var rFlag = recode.getValueByName("FLAG");
	    g_AIButtonManager.get("query2").setDisabled(true);
		g_AIButtonManager.get("query3").setDisabled(false);
		_fromChargeMainFormRowSet.setEditSts(false);
		//document.getElementById("include").style.display="block";
        return rFlag;
    } else {
    	return "Y";
    }

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
var taskId="<%=request.getParameter("taskId")%>";
var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
var returnP=window.showModalDialog("<%=request.getContextPath()%>/charge/chargeinfo/chargeDetailInfo.jsp?applyId="+applyId+"&feeType="+feeType+"&taskId="+taskId,"","dialogWidth=1000px"); 
chargeDetailListTable.refresh("&mainId="+applyId+"&feetype="+feeType);
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

var isNewFee = chargeDetailListTable.getValue(curRow,"EXT6"); //��ʾ�ʷѵ�����ϸʱ ����charge_info_t.EXT6�ֶ����ж��Ƿ����µ��ʷѽṹҳ��

window.open("<%=request.getContextPath()%>/charge/chargeinfo/chargeDetail.jsp?applyId="+applyId+"&feeType="+feeType+"&mid="+mid+"&feeName="+feeName+"&state="+state+"&taskId="+taskId+"&isSendSmsVal="+isSendSmsVal+"&isNewFee="+isNewFee,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no"); 
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
		}else{
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
	}else{
	return true;
	}
}

function showApplyMain(){
	if(AIContractFrame_closeMe()){
	 }else{
	  AIContractFrame_OpenClose("chargeMainframe");
	 }
	 var curRow = chargeApplyMainTable.getRow();
	 var applyid=chargeApplyMainTable.getValue(curRow,"APPLY_ID");
	 _fromChargeMainFormRowSet.refresh("&id="+applyid);
	 	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	  chargeDetailListTable.refresh("&mainId="+applyid+"&feetype="+feeType);
}
</script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"���ڴ������Ժ�...");
}
</script>

