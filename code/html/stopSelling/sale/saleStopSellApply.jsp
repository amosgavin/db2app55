<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>营销案停售申请</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
</head>
 <body onload="init()">
    <ai:contractframe id="chargeStopSellMainframe" contenttype="table" title="营销案停售主要信息" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="stopSellMainForm" 
            setname="com.asiainfo.stopSelling.set.SETStopSellM"
            conditionname="condition" parametersname="parameters"
            editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.stopSelling.service.interfaces.IStopSellMSV"
            implservice_querymethod="getStopSellMInfoById(String mainId)">
        <table width="100%" align="center" border="0" cellpadding="1" cellspacing="1">
        <tr>
           <td class="td_font">申请名称:</td>
           <td><ai:dbformfield formid="stopSellMainForm" fieldname="APPLY_NAME" width="200"/><span class="font_red">*</span>
           <ai:dbformfield formid="stopSellMainForm" fieldname="MAINID" width="60" editable="" visible="false"/>
           <ai:dbformfield formid="stopSellMainForm" fieldname="ITEM_TYPE" width="60" editable="" visible="false"/>
           <ai:dbformfield formid="stopSellMainForm" fieldname="STATE" width="150" editable="" visible="false"/></td>
           <td class="td_font">申请人:</td>
           <td><ai:dbformfield formid="stopSellMainForm" fieldname="PRINCIPAL" width="150" editable="false" visible="false"/>
               <ai:dbformfield formid="stopSellMainForm" fieldname="PROP_STAFF" width="150" editable="false" /><span class="font_red">*</span>
           </td>
         </tr> 
         <tr>
           <td class="td_font">申请单位:</td>
           <td><ai:dbformfield formid="stopSellMainForm" fieldname="ORG_ID" width="130" editable="false" visible="false"/>
               <ai:dbformfield formid="stopSellMainForm" fieldname="ORG_NAME" width="200" editable="false"/><span class="font_red">*</span></td>
           <td class="td_font">联系电话:</td>
           <td><ai:dbformfield formid="stopSellMainForm" fieldname="TEL" width="150"/><span class="font_red">*</span></td>
         
         </tr>
         <tr>
            <td class="td_font">停售理由及原因:</td>
            <td colspan="5"><ai:dbformfield formid="stopSellMainForm" fieldname="DESCRIPTION" height="100" width="700"/><span class="font_red">*</span></td>
         </tr>
         <tr><td colspan="4" align="center"><ai:button text="保存主信息" id="query2" onclick="doWork('saveMainInfo()')" /></td></tr>
       </table>

    </ai:dbform>
</ai:contractframe>
<ai:loginuser/>
<%@include file="/stopSelling/include/_saleInfo.jsp"%>
<%@include file="/stopSelling/include/_sellStopAttach.jsp"%>
<%@include file="/stopSelling/include/_sellStopCreateWF.jsp"%>
</body>
<script language="javascript" type="text/javascript">
var _mainId = "";
var _orgId = g_GetUserInfo().ORG_ID;
var mainId = '';
var attachType = "saleSellStop";
var flowType = "saleSellStopCaseT";
var templateCode = "template.SaleStopSellFlow";
if (_orgId.substr(0,2) == "10"){
	flowType = "saleSellStopCaseP";
	templateCode = "template.PSaleStopSellFlow";
}
var stopSellMainForm= g_FormRowSetManager.get("stopSellMainForm");

function init(){ 
	stopSellMainForm.setValue("PRINCIPAL",g_GetUserInfo().STAFF_ID);
	stopSellMainForm.setValue("PROP_STAFF",g_GetUserInfo().STAFF_NAME);
	stopSellMainForm.setValue("ORG_ID",g_GetUserInfo().ORG_ID);
	stopSellMainForm.setValue("ORG_NAME",g_GetUserInfo().ORG_NAME);
	stopSellMainForm.setValue("ITEM_TYPE","sale");
	stopSellMainForm.setValue("TEL",g_GetUserInfo().STAFF_ID);
	showName();
	initCheckPage();
}

function showName(){
	stopSellMainForm.setFocus("TEL");
	stopSellMainForm.setColEditSts("TEL",false);
}

function saveMainInfo(){
	 var applyName=stopSellMainForm.getValue("APPLY_NAME");
	 var reason=stopSellMainForm.getValue("DESCRIPTION"); 
	 if(""==applyName){return  alert("请输入申请名称！");}
	 if(""==reason){return  alert("请填写停售理由！");}
	
	 if ("O" != stopSellMainForm.getSts()||stopSellMainForm.getSts()=="U")
	 {
        var list = new Array();
	    list.push(stopSellMainForm);
	    var strUrl = _gModuleName + '/business/com.asiainfo.stopSelling.web.StopSellMAction?action=saveStopSellMInfo';
	    var recode = saveRowSet(strUrl, list);
	    mainId = recode.getValueByName("MAINID");
	    if(mainId == null || mainId == '' || mainId == 'undefined'){
	    	return alert("保存操作失败！");
	    }
  	    stopSellMainForm.refresh("&mainId="+mainId);
  	    //showName();
	 }
}
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>
</html>