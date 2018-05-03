<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
 <body onload="init()">
  <ai:contractframe id="chargeAMainframe" contenttype="table" title="资费案主信息" width="100%" allowcontract="true" frameclosed="false">
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
          <td class="td_font">工单名称：</td>
             <td><ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_1" width="200" editable="" visible=""/>
            <ai:dbformfield formid="chargeAMainframe" fieldname="MAIN_ID" width="200" editable="" visible="false"/>
            <ai:dbformfield formid="chargeAMainframe" fieldname="STATE" width="200" editable="" visible="false"/>
                </td>
          <td class="td_font">申请人：</td>
                <td><ai:dbformfield formid="chargeAMainframe" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
                 <td><ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_2" width="150" editable="false" />
                </td>
                  <td class="td_font">申请单位：</td>
                <td><ai:dbformfield formid="chargeAMainframe" fieldname="ORG" width="130" editable="false" visible="false" />
                <td><ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_3" width="130" editable="false" />
               </td>
           </tr> 
        </table>
        </ai:dbform>
        </ai:contractframe>
        
  
  
  <ai:contractframe id="chargeApplyMain" contenttype="table" title="已保存的档次信息" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem><%--<ai:button id="newSaleDetail" text="新建活动" onclick="newSaleDetail()"/>--%>
    <ai:button id="bt_addCharge" text="新增资费批次"  onclick="addChargePc()"/> <ai:button id="bt_delCharge" text="删除资费批次"  onclick="delCharge()"/></ai:contractitem>
    <ai:table
        tableid="chargeApplyMainTable"
        setname="com.asiainfo.charge.web.SETChargeApplyMain"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.charge.service.interfaces.IChargeNewMainSV"
        implservice_querymethod="getApplyMainsByMainId(String mainid)"
        initial="false"  multiselect="" ondbclick="" onrowchange="showApplyMain"
        pagesize="15" editable="false" width="100%" rowheight=""
        height="100" needrefresh="true">
        	<ai:col title="批次ID" fieldname="APPLY_ID" visible=""/>
            <ai:col title="名称" fieldname="APPLY_NAME" width="20%" />
            <ai:col title="资费类型" fieldname="FEE_TYPE" width="20%" />
        	<ai:col title="细分市场" fieldname="MARKET_TYPE" width="20%"/>
            <ai:col title="开始时间" fieldname="APPLY_TIME" width="20%" />
            <ai:col title="结束时间" fieldname="APPLY_END_TIME" width="20%" />
    </ai:table>
</ai:contractframe>
  
 
    <ai:contractframe id="chargeMainframe" contenttype="table" title="资费案主要信息" width="100%" allowcontract="true" frameclosed="true">
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
                <td class="td_font">资费案名称：</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_NAME" width="150"/><span class="font_red">*</span>
                <ai:dbformfield formid="chargeMainframe" fieldname="APPLY_ID" width="50" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="IS_SUBMIT" width="150"  visible="false"/>
                </td>
                 <td class="td_font">资费类型：</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="FEE_TYPE" width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">开始时间：</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_TIME" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">结束时间：</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_END_TIME" width="150"/><span class="font_red">*</span></td>
              </tr>
          <tr>
                <td class="td_font">推广渠道：</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="EXTEND_CHANNEL" height="" width="800"/></td>
            </tr>
            <tr>
                <td class="td_font">宣传口号：</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="FLACK" height="" width="800"/><br></td>
            </tr>
               <tr>
                  <td class="td_font">背景：</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="BACK_GROUND" height="80" width="800"/></td>
            </tr>
             <tr>
                <td class="td_font">目的：</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_MARK" height="80" width="800"/><br></td>
            </tr>
            <tr>
              <td class="td_font">用户调研情况：</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="USER_CIRCS" height="80" width="800"/></td>
            </tr>
                <tr>
                <td class="td_font">目标用户消费特点：</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="CONSUME_ANALYSE" height="80" width="800"/></td>
            </tr>
            
          </table>
    </ai:dbform>
</ai:contractframe>
      <div class="area_button">
   <ai:button text="新增资费" id="query4" onclick="addChargeMainNew()" />&nbsp;&nbsp;
   <ai:button text="修改资费主信息" id="query3" onclick="doWork('updateChargeMain()')" />&nbsp;&nbsp;
  <ai:button text="保存资费主信息" id="query2" onclick="doWork('addChargeMain()')" />&nbsp;&nbsp;
  </div>
<ai:contractframe id="chargeDetailListframe" contenttype="table" title="已保存的档次信息" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem><%--<ai:button id="newSaleDetail" text="新建活动" onclick="newSaleDetail()"/>--%>
   <ai:button id="bt_showChargeDetailinfo" text="查看资费档次"  onclick="showChargeDetail()"/></ai:contractitem>
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
        	<ai:col title="档次ID" fieldname="MID" visible="false"/>
            <ai:col title="类型" fieldname="CHARGE_TYPE" width="8%"/>
            <ai:col title="名称" fieldname="FEE_NAME" width="12%" />
            <ai:col title="资费系统档次编码" fieldname="CASE" width="140" />
        	<ai:col title="BOSS系统档次ID" fieldname="INADD_USER_COUNT" width="140"/>
            <ai:col title="静态损益总和" fieldname="DOOR_EARNING" width="8%"/>
            <ai:col title="动态损益总和" fieldname="EARNING_DAMNIFY" width="8%" />
            <ai:col title="套餐内" fieldname="ADD_USER_MARKET" width="32%" />
            <ai:col title="套餐外" fieldname="SPLICE_MUTEX_RULE" width="32%" />
            <ai:col title="套餐" fieldname="EARNING_TOTAL" width="80%" />
            <ai:col title="是否需要短信提醒" fieldname="IS_SEND_SMS" visible="false" />
            <ai:col title="档次套餐" fieldname="EXT5" width="32%"/>
            <ai:col title="新资费档次标识" fieldname="EXT6" visible="false" />
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
	
//退回或是发起人修改的时候
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
if(""==applyName){return  alert("请输入资费活动名称！");}
if(""==feeType){return  alert("请输入资费类型！");}
if(""==applyTime){return  alert("请输入资费活动开始时间！");}
if(""==applyEndTime){return  alert("请输入资费活动结束时间！");}
if(1 == g_CompareDate(applyTime,applyEndTime)){ return alert("活动案结束时间不能小于开始时间！");}
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
return alert("请先保存资费主信息！");
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
return alert("请选择一行数据！");
}
var applyId=_fromChargeMainFormRowSet.getValue("APPLY_ID");
var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");

var isNewFee = chargeDetailListTable.getValue(curRow,"EXT6"); //显示资费档次详细时 根据charge_info_t.EXT6字段来判断是否是新的资费结构页面

window.open("<%=request.getContextPath()%>/charge/chargeinfo/chargeDetail.jsp?applyId="+applyId+"&feeType="+feeType+"&mid="+mid+"&feeName="+feeName+"&state="+state+"&taskId="+taskId+"&isSendSmsVal="+isSendSmsVal+"&isNewFee="+isNewFee,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no"); 
}

function addChargeMainNew(){
if(window.confirm("新建资费案会清空未保存的营销案信息，确定要新建吗？"))
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
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>

