<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>�ʷѰ�</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  
   <body onload="init">
    <ai:contractframe id="chargeMainframe" contenttype="table" title="�ʷѰ���Ҫ��Ϣ" width="98%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="chargeMainframe" 
            setname="com.asiainfo.charge.web.SETChargeApplyMain"
            conditionname="condition" parametersname="parameters"
            onvalchange="" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
            implservice_querymethod="IChargeMainshow(String id)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        <tr>
           <td class="td_font">�����ˣ�</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="PRINCIPLE" width="" editable="false" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="STAFFNAME" width="150" editable=""/>
                <span class="font_red">*</span>
                </td>
                <td	class="td_font">���뵥λ��</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="ORG" width="" editable="false" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="ORGNAME" width="130" editable=""/><span class="font_red">*</span></td>
           </tr> 
            <tr>
                <td class="td_font">�ʷѰ����ƣ�</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_NAME" width="150"/><span class="font_red">*</span>
                <ai:dbformfield formid="chargeMainframe" fieldname="APPLY_ID" width="" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="IS_SUBMIT" width=""  visible="false"/>
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
    <ai:button id="bt_showChargeDetail" text="�鿴�ʷѵ���"  onclick="showChargeDetail()"/></ai:contractitem>
    <ai:table
        tableid="chargeDetailListTable"
        setname="com.asiainfo.charge.web.SETChargeInfo"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
        implservice_querymethod="getChargeDetailByFeeType(String mainId, String feetype, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getCountByFeeType(String mainId, String feetype)"
        initial="false"  multiselect="" ondbclick="showChargeDetail" onrowchange="onrowchange1"
        pagesize="15" editable="false" width="100%" rowheight="50"
        height="180" needrefresh="true">
        	<ai:col title="����ID" fieldname="MID" visible="false"/>
            <ai:col title="����" fieldname="CHARGE_TYPE" width="8%"/>
            <ai:col title="����" fieldname="FEE_NAME" width="12%" />
            <ai:col title="�ʷ�ϵͳ���α���" fieldname="CASE" width="140"/>
        	<ai:col title="BOSSϵͳ����ID" fieldname="INADD_USER_COUNT" width="140"/>
            <ai:col title="��̬�����ܺ�" fieldname="DOOR_EARNING" width="8%"/>
            <ai:col title="��̬�����ܺ�" fieldname="EARNING_DAMNIFY" width="8%" />
            <ai:col title="�ײ���" fieldname="ADD_USER_MARKET" width="32%" />
            <ai:col title="�ײ���" fieldname="SPLICE_MUTEX_RULE" width="32%" />
              <ai:col title="�ײ�" fieldname="EARNING_TOTAL" width="80%" />
    </ai:table>
</ai:contractframe>

<ai:loginuser/>
<script type="text/javascript">
var _templateCode = "";
var _flowType = "";
var _mainId = "";
var _orgId = g_GetUserInfo().ORG_ID;
if("10" == _orgId.substr(0,2)){
    _templateCode = "template.TownChargeApplyFlow";
    _flowType = "chargeCaseT";
} else {
    _templateCode = "template.TownChargeApplyFlow";
    _flowType = "chargeCaseT";
}
</script>

  </body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script type="text/javascript">
var _fromChargeMainFormRowSet= g_FormRowSetManager.get("chargeMainframe");
var chargeDetailListTable=g_TableRowSetManager.get("chargeDetailListTable");
var recordId = "<%=request.getParameter("recordId")%>";
var applyid="<%=request.getParameter("applyid")%>";
function init(){
	if("null"==applyid){
	applyid=recordId;
	}
	var id =_fromChargeMainFormRowSet.getValue("APPLY_ID");
	if("null"!=applyid){
	//_fromChargeMainFormRowSet.setEditSts(false);
	_fromChargeMainFormRowSet.refresh("&id="+applyid);
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	var staffId = g_GetUserInfo().STAFF_ID;
	 g_AIButtonManager.get("query2").setDisabled(true);
	chargeDetailListTable.refresh("&mainId="+applyid+"&feetype="+feeType);
	showTableOn();
	}
	else{
		if(""!=id){
		_fromChargeMainFormRowSet.setEditSts(false);
		_fromChargeMainFormRowSet.refresh("&id="+id);
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
	 _fromChargeMainFormRowSet.setFocus("STAFFNAME");
	  _fromChargeMainFormRowSet.setFocus("ORGNAME");
	_fromChargeMainFormRowSet.setColEditSts("ORGNAME",false);
	_fromChargeMainFormRowSet.setColEditSts("STAFFNAME",false);
	_fromChargeMainFormRowSet.setEditSts(false);
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
if(1 == g_CompareDate(applyTime,applyEndTime)){ return alert("�������ʱ�䲻��С�ڿ�ʼʱ�䣡");;}
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
var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
var returnP=window.showModalDialog("<%=request.getContextPath()%>/charge/chargeinfo/chargeDetailInfo.jsp?applyId="+applyId+"&feeType="+feeType,"","dialogWidth=1000px"); 
chargeDetailListTable.refresh("&mainId="+applyId+"&feetype="+feeType);
}


function showChargeDetail(){
var feeName=_fromChargeMainFormRowSet.getValue("APPLY_NAME");
var state=_fromChargeMainFormRowSet.getValue("IS_SUBMIT");
var curRow = chargeDetailListTable.getRow();
var mid = chargeDetailListTable.getValue(curRow,"MID");
var applyId=_fromChargeMainFormRowSet.getValue("APPLY_ID");
var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
if(mid==""){
return alert("��ѡ��һ�����ݣ�");
}
var applyId=_fromChargeMainFormRowSet.getValue("APPLY_ID");
var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
var staffid=_fromChargeMainFormRowSet.getValue("PRINCIPLE");
if(staffid!=g_GetUserInfo().STAFF_ID){
state=2;
}
window.open("<%=request.getContextPath()%>/charge/chargeinfo/chargeDetail.jsp?applyId="+applyId+"&feeType="+feeType+"&mid="+mid+"&feeName="+feeName+"&state="+state,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no"); 
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
		if("41"==_fromChargeMainFormRowSet.getValue("FEE_TYPE")){
		chargeDetailListTable.setColVisible("ADD_USER_MARKET",false);
		chargeDetailListTable.setColVisible("SPLICE_MUTEX_RULE",false);
		chargeDetailListTable.setColVisible("EARNING_TOTAL",true);
		}else if("31"==_fromChargeMainFormRowSet.getValue("FEE_TYPE")){
		chargeDetailListTable.setColVisible("ADD_USER_MARKET",true);
		chargeDetailListTable.setColVisible("SPLICE_MUTEX_RULE",true);
			chargeDetailListTable.setColVisible("EARNING_TOTAL",true);
		}else{
		chargeDetailListTable.setColVisible("ADD_USER_MARKET",true);
		chargeDetailListTable.setColVisible("SPLICE_MUTEX_RULE",true);
		chargeDetailListTable.setColVisible("EARNING_TOTAL",false);
		}
	}
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

function onrowchange1(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	chargeDetailListTable.setRowBgColor(oldIndex,"");
    }
    	chargeDetailListTable.setRowBgColor(newIndex,"yellow");
}
</script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"���ڴ������Ժ�...");
}
</script>
<script type="text/javascript">
function addLoadEvent(func) {  
    var oldonload = window.onload;  
    if(typeof window.onload != "function"){  
        window.onload = func;  
    }else{  
        window.onload = function(){  
            oldonload();  
            func();  
        }  
    }  
}  
addLoadEvent(init);
</script>
