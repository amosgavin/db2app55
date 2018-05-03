<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="批量预存申告单"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initOper()">

<ai:contractframe id="saleEditPrestoreFrame" contenttype="table" title="批量预存申告单" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="saleEditPrestoreForm" 
  			setname="com.asiainfo.sale.prestore.web.SETSaleBatchPrestore"
            conditionname="condition" parametersname="parameters"
            initial="false" onvalchange="onFormValChange"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.prestore.service.interfaces.ISaleBatchPrestoreSV"
            implservice_querymethod="getSaleMainShowById(String id)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr>    
                <td class="td_font">申请人：</td>
                <td><ai:dbformfield formid="saleEditPrestoreForm" fieldname="PRINCIPAL" width="150" visible="false"/>
                    <ai:dbformfield formid="saleEditPrestoreForm" fieldname="EXT1" width="150" editable="false"/><span class="font_red">*</span></td>
                <td class="td_font">申请部门：</td>
                <td><ai:dbformfield formid="saleEditPrestoreForm" fieldname="PROMOTE_DEPART" width="150"  visible="false"/>
                    <ai:dbformfield formid="saleEditPrestoreForm" fieldname="EXT2" width="150" editable="false"/><span class="font_red">*</span>
                    <ai:dbformfield formid="saleEditPrestoreForm" fieldname="OPER_TYPE" visible="false"/></td>
            </tr>
            <tr>
                <td class="td_font">申请名称：</td>
                <td><ai:dbformfield formid="saleEditPrestoreForm" fieldname="APPLY_NAME" width="150" /><span class="font_red">*</span>
                 <ai:dbformfield formid="saleEditPrestoreForm" fieldname="ID" visible="false"/></td>
                <td class="td_font">申告单类型：</td>
                <td><ai:dbformfield formid="saleEditPrestoreForm" fieldname="BUSI_TYPE" width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">申请金额(元)：</td>
                <td><ai:dbformfield formid="saleEditPrestoreForm" fieldname="APPLY_AMOUNT" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">预计用户数(户)：</td>
                <td><ai:dbformfield formid="saleEditPrestoreForm" fieldname="USER_NUMBER" width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">发放范围：</td>
                <td><ai:dbformfield formid="saleEditPrestoreForm" fieldname="SEND_RANGE" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">专款范围：</td>
                <td colspan="5"><ai:dbformfield formid="saleEditPrestoreForm" fieldname="FUND_RANGE" width="150"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="marketMultiplySelected();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>                
            </tr>
            <tr>
                <td class="td_font">批量预存原因：</td>
                <td colspan="5"><ai:dbformfield formid="saleEditPrestoreForm" fieldname="FUND_REASON" height="86" width="640"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">短信发送类型：</td>
                <td><ai:dbformfield formid="saleEditPrestoreForm" fieldname="SMS_SEND_TYPE" width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr id="aom_sms_id" style="display: block;">
                <td class="td_font">短信下发内容：</td>
                <td colspan="5"><ai:dbformfield formid="saleEditPrestoreForm" fieldname="SMS_CONTENT" height="86" width="640"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">BOSS操作工号：</td>
                <td><ai:dbformfield formid="saleEditPrestoreForm" fieldname="OPERATOR_ID" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">BOSS作业号：</td>
                <td><ai:dbformfield formid="saleEditPrestoreForm" fieldname="BOSS_DONE_CODE"  width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">执行开始时间：</td>
                <td><ai:dbformfield formid="saleEditPrestoreForm" fieldname="PROVIDE_BEGIN_DATE"  width="150"/><span class="font_red">*</span></td>
                <td class="td_font">执行结束时间：</td>
                <td><ai:dbformfield formid="saleEditPrestoreForm" fieldname="PROVIDE_END_DATE"  width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td><ai:dbformfield formid="saleEditPrestoreForm" fieldname="FILE_NAME"  width="200" visible="false"/></td>
            </tr>
            <tr>
                <td class="td_font">业务复核：</td>
                <td colspan="5"><ai:dbformfield formid="saleEditPrestoreForm" fieldname="BUSINESS_REVIEW" height="86" width="640" editable="false"/></td>
            </tr>
        </table>
    </ai:dbform>

<table align="center">
    <ai:button id="bt_add" text="新建预存" onclick="newSaleMain()"/>&nbsp;&nbsp;
    <ai:button id="bt_mod" text="修改预存" onclick="modifySaleMain()"/>&nbsp;&nbsp;
	<ai:button id="bt_save" text="保存当前" onclick="doWork('doSave(true)')"/>&nbsp;&nbsp;
</table>
</ai:contractframe>



<ai:loginuser/>
<script type="text/javascript">
var _templateCode = "template.TownBatchPreApprove";
var _flowType = "prestoreCase";
var _mainId = "";
var _orgId = g_GetUserInfo().ORG_ID;
//if("10" == _orgId.substr(0,2)){
//    _templateCode = "template.ProvincePrestoreFlow";
//    _flowType = "prestoreCase";
//} else {
//    _templateCode = "template.TownPrestoreFlow";
//    _flowType = "prestoreCaseT";
//}

//alert(_orgId);
</script>


<div id="div_attach" style="display:block">
<%@include file="/sale/prestore/include/_prestoreAttach.jsp"%>
</div>

<div id="div_createWF" style="display:block">
<%@include file="/sale/prestore/include/_prestoreCreateWF.jsp"%>
</div>




</body>
</html>

<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script language="javascript" type="text/javascript">
var editFlag="INIT";		// INIT初始化 ,ADD增加,MOD修改,DEL删除
var saleEditPrestoreF = g_FormRowSetManager.get("saleEditPrestoreForm");
var applyId = "<%=request.getParameter("applyId")%>";
var isSubmit = "<%=request.getParameter("isSubmit")%>";


function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}

function initOper() {
	if("null"  == applyId){ //初始化新增
		editFlag="INIT";
   		setEditStatus(0); 
	}else{ //查询信息传入：
    	saleEditPrestoreF.refresh("&id=" +applyId);
    	setEditStatus(1);
		_mainId = applyId;
    }
    var sendType = saleEditPrestoreF.getValue("SMS_SEND_TYPE");
	if("" == sendType || null == sendType || "0" == sendType){
		saleEditPrestoreF.setValue("SMS_SEND_TYPE",'0');
		document.getElementById("aom_sms_id").style.display="none";
	}else{document.getElementById("aom_sms_id").style.display="block";}

}

function onFormValChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText){
	if (pFieldName == 'SMS_SEND_TYPE') {
		if ("1" == pOldText) {
			document.getElementById("aom_sms_id").style.display="block";
			saleEditPrestoreF.setValue("SMS_CONTENT", '系统自动，恭喜您参加XXX活动获得[$]元话费已到账，详询中国移动10086。');
			
		}
		else if ("2" == pOldText) {
			document.getElementById("aom_sms_id").style.display="block";
			saleEditPrestoreF.setValue("SMS_CONTENT", '');
			
		}else{
		    document.getElementById("aom_sms_id").style.display="none";
		}			
		
	}
}

function newSaleMain()
{
    if(window.confirm("新建预存会清空未保存的信息，确定要新建吗？"))
    {
        location.reload();
    }
}

function doSave(){	
	var xmlEmailForm = saleEditPrestoreF.toXmlString();
		
	if("" == xmlEmailForm){
		alert("提示：没有数据被修改!");
		return;
	}
	if("" == saleEditPrestoreF.getValue("APPLY_NAME")){return  alert("请输入申请名称！");}
	if("" == saleEditPrestoreF.getValue("BUSI_TYPE")){return  alert("请输入申告单类型！");}
	if("" == saleEditPrestoreF.getValue("APPLY_AMOUNT")){return  alert("请输入申请金额！");}
	if("" == saleEditPrestoreF.getValue("USER_NUMBER")){return  alert("请输入预计用户数！");}
	if("" == saleEditPrestoreF.getValue("SEND_RANGE")){return  alert("请输入发放范围！");}
	if("" == saleEditPrestoreF.getValue("FUND_RANGE")){return  alert("请输入专款范围！");}
	if("" == saleEditPrestoreF.getValue("FUND_REASON")){return  alert("请输入批量预存原因！");}

	if("2" == saleEditPrestoreF.getValue("SMS_SEND_TYPE") || "1" == saleEditPrestoreF.getValue("SMS_SEND_TYPE")){
		if("" == saleEditPrestoreF.getValue("SMS_CONTENT")){return  alert("请输入短信下发内容！");}
	}
	
	if("" == saleEditPrestoreF.getValue("OPERATOR_ID")){return  alert("请输入BOSS操作工号！");}
	if("" == saleEditPrestoreF.getValue("PROVIDE_BEGIN_DATE")){return  alert("请输入执行开始时间！");}
	if("" == saleEditPrestoreF.getValue("PROVIDE_END_DATE")){return  alert("请输入执行结束时间！");}
		
	if (1 == g_CompareDate(saleEditPrestoreF.getValue("PROVIDE_BEGIN_DATE"),saleEditPrestoreF.getValue("PROVIDE_END_DATE")))
    {
    	return alert("执行结束时间不能小于执行开始时间！");
    }

    var citycode = g_GetUserInfo().ORG_ID.substr(0,2);
	var dealUrlParam = "&citycode="+citycode;
	var list = new Array();
	list.push(saleEditPrestoreF);
	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.sale.prestore.web.SaleBatchPrestoreAction?action=saveSaleBatchPrestore"+dealUrlParam, list);
	var id = ud.getValueByName("retId");
	if(ud.getValueByName("retVal") == "Y"){
		alert(ud.getValueByName("retMsg"));
		saleEditPrestoreF.refresh("&id=" +id);
	}else{
		alert(ud.getValueByName("retMsg"));
		saleEditPrestoreF.setStsToNew();
		return;
	}
}

function modifySaleMain()
{
    if(window.confirm("您确定要修改吗？"))
    {
        //saleEditPrestoreF.refresh("&id=" +id);
        setEditStatus(2);
    }else{return;}
    
}

function getDefualtExearea(){
	var org = g_GetUserInfo().ORG_ID.substr(0,2);
	var cases = {
	  	10:999,
		11:270,
		17:710,
		13:711,
		26:712,
		25:713,
		12:714,
		19:715,
		20:716,
		14:717,
		15:718,
		16:719,
		24:722,
		23:724,
		18:728
	};
	if (cases[org]) {
  		return (cases[org]);
	}
}


//设置操作区域的状态
function setEditStatus(type){
	if (type == 0){	//初始化 新增页面
		saleEditPrestoreF.setValue("PRINCIPAL",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
		saleEditPrestoreF.setValue("PROMOTE_DEPART",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
		saleEditPrestoreF.setValue("SEND_RANGE",getDefualtExearea());
		saleEditPrestoreF.setValue("EXT1",g_GetUserInfo().STAFF_NAME);
		saleEditPrestoreF.setValue("EXT2",g_GetUserInfo().ORG_NAME);
    	g_AIButtonManager.get("bt_mod").setDisabled(true); //新增操作，默认屏蔽修改按钮

	}else if(type == 1){ 
		g_AIButtonManager.get("bt_add").setDisabled(true); //查看详细信息进入，默认屏蔽新增按钮
		g_AIButtonManager.get("bt_save").setDisabled(true);

		saleEditPrestoreF.setEditSts(false);
	
		if(isSubmit == "1"){ //状态 1-保存
			g_AIButtonManager.get("bt_mod").setDisabled(false);
			//document.getElementById("div_createWorkflow").style.display="none";
	   	}else{
	   		document.getElementById("div_attach").style.display="none";
	   		document.getElementById("div_createWF").style.display="none";
	   		g_AIButtonManager.get("bt_mod").setDisabled(true);
	   }
	}else if(type == 2){ 
		saleEditPrestoreF.setEditSts(true);
		saleEditPrestoreF.setColEditSts("BOSS_DONE_CODE",false);
		saleEditPrestoreF.setColEditSts("BUSINESS_REVIEW",false);
		g_AIButtonManager.get("bt_save").setDisabled(false);
		
	}else{
	  	saleEditPrestoreF.setEditSts(true);
	  	g_AIButtonManager.get("bt_save").setDisabled(false);
	  	
	}	
}

function marketMultiplySelected(){
    var url = "<%=request.getContextPath()%>/sale/prestore/prestoreFundSelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = saleEditPrestoreF.getValue("FUND_RANGE");
    saleEditPrestoreF.setValue("FUND_RANGE",onItemMultiplySelected(url, iniVal, style));
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
//addLoadEvent(init);
addLoadEvent(initCheckPage);
addLoadEvent(include_reflashAttachTable);

</script>


