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
            initial="false" onvalchange=""
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
//var _templateCode = "template.MyFlow_Test";
//var _flowType = "prestoreCase_Test";

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




<div id="div_include_check" style="display:none">
<script type="text/javascript">
var _mainId = "<%=request.getParameter("recordId")%>";
</script>
</div>
<%@include file="/sale/prestore/include/_prestoreAttach.jsp"%>

<%@include file="/sale/prestore/include/_prestoreCheck.jsp"%>





</body>
</html>

<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script language="javascript" type="text/javascript">
var saleEditPrestoreF = g_FormRowSetManager.get("saleEditPrestoreForm");

var recordId = "<%=request.getParameter("recordId")%>";
var _mainId = recordId;

var applyid="<%=request.getParameter("applyid")%>";
var taskTag="<%=request.getParameter("taskTag")%>";


function initOper() {
	if("null" == recordId){
		alert("工单编号为空，无法对任务进行处理！");
		return;
	}
	applyid = recordId;
	saleEditPrestoreF.refresh("&id=" +applyid);
	setCheckStatus(0);

}

function marketMultiplySelected(){
    var url = "<%=request.getContextPath()%>/sale/prestore/prestoreFundSelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = saleEditPrestoreF.getValue("FUND_RANGE");
    saleEditPrestoreF.setValue("FUND_RANGE",onItemMultiplySelected(url, iniVal, style));
}

</script>

<script type="text/javascript">
function addLoad(func) {  
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
addLoad(initCheck);
addLoad(include_reflashAttachTable);
</script>


<script language="javascript" type="text/javascript">
//设置操作区域的状态
function setCheckStatus(type){
		var sendType = saleEditPrestoreF.getValue("SMS_SEND_TYPE");
		if("" == sendType || null == sendType || "0" == sendType){
			saleEditPrestoreF.setValue("SMS_SEND_TYPE",'0');
			document.getElementById("aom_sms_id").style.display="none";
		}else{document.getElementById("aom_sms_id").style.display="block";}

		saleEditPrestoreF.setEditSts(false);
		g_AIButtonManager.get("bt_add").setDisabled(true); //查看详细信息进入，默认屏蔽新增按钮
		g_AIButtonManager.get("bt_save").setDisabled(true);
		g_AIButtonManager.get("bt_mod").setDisabled(true);
		document.getElementById("div_include_check").style.display="block";
		
		if("batch10" == taskTag || "batch11" == taskTag){//batch10: 地市发起人配置,batch11:省业支复核
			g_AIButtonManager.get("bt_mod").setDisabled(false);
		}
}	
		
function modifySaleMain()
{
    if(window.confirm("您确定要修改吗？"))
    {
    	if("batch10" == taskTag){
			saleEditPrestoreF.setColEditSts("BOSS_DONE_CODE",true);
		}
		if("batch11" == taskTag){
			saleEditPrestoreF.setColEditSts("BUSINESS_REVIEW",true);
		}
		g_AIButtonManager.get("bt_save").setDisabled(false);
    }else{return;}
    
}		

function doSave(){	
	saleEditPrestoreF = g_FormRowSetManager.get("saleEditPrestoreForm");
	var xmlEmailForm = saleEditPrestoreF.toXmlString();
	
    if("batch10" == taskTag){
		saleEditPrestoreF.setColEditSts("BOSS_DONE_CODE",false);
	}
	if("batch11" == taskTag){
		saleEditPrestoreF.setColEditSts("BUSINESS_REVIEW",false);
	}	
		
	if("" == xmlEmailForm){
		alert("提示：没有数据被修改!");
		g_AIButtonManager.get("bt_save").setDisabled(true);
		return;
	}
	
	//if("" == saleEditPrestoreF.getValue("OPERATOR_ID")){return  alert("请输入BOSS操作工号！");}
	//if("" == saleEditPrestoreF.getValue("BOSS_DONE_CODE")){return  alert("请输入BOSS作业号！");}
	
    var citycode = g_GetUserInfo().ORG_ID.substr(0,2);
	var dealUrlParam = "&citycode="+citycode;
	var list = new Array();
	list.push(saleEditPrestoreF);
	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.sale.prestore.web.SaleBatchPrestoreAction?action=saveSaleBatchPrestore"+dealUrlParam, list);
	var id = ud.getValueByName("retId");
	if(ud.getValueByName("retVal") == "Y"){
		alert(ud.getValueByName("retMsg"));
		saleEditPrestoreF.refresh("&id=" +id);
		//g_AIButtonManager.get("bt_save").setDisabled(true);
		setCheckStatus(0);
	}else{
		alert(ud.getValueByName("retMsg"));
		saleEditPrestoreF.setStsToNew();
		return;
	}
}

function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}

</script>
