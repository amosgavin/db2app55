<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>资费档次</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  
  <body onload="init()">
    <ai:contractframe id="chargeMainDeframe1" contenttype="table" title="资费档次信息" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="chargeMainDefrom" 
            setname="com.asiainfo.charge.web.SETChargeInfo"
            conditionname="condition" parametersname="parameters"
            onvalchange="" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
             implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainDeSV"
            implservice_querymethod="IChargeMainDeshow(String id)"
           >
        <table width="100%" align="center" border="0" cellpadding="1" cellspacing="2">
        <tr>
         <td class="td_font">资费类型：</td>
         <td><ai:dbformfield formid="chargeMainDefrom" fieldname="CHARGE_TYPE" width="150" editable=""/><span class="font_red">*</span>
         <ai:dbformfield formid="chargeMainDefrom" fieldname="APPLY_ID" width="150" visible="false"/>
        <ai:dbformfield formid="chargeMainDefrom" fieldname="MID" width="150" visible="false"/>
         </td>
         <td class="td_font"  style="display:none">资费档次编码：</td>
         <td  style="display:none"><ai:dbformfield formid="chargeMainDefrom" fieldname="CASE" width="150" visible="false" editable=""/><span class="font_red">*</span>
         <ai:dbformfield formid="chargeMainDefrom" fieldname="FEE_NAME" width="150" visible="false"/>
         </td>
        </tr>
        <tr>
             <td class="td_font">套餐月使用费：</td>
         <td><ai:dbformfield formid="chargeMainDefrom" fieldname="DOOR_DAMNIFY" width="150" editable=""/><span class="font_red">*</span></td>
        </tr>
        <tr>
         <td class="td_font">资费描述：</td>
         <td colspan="3"><ai:dbformfield formid="chargeMainDefrom" fieldname="FEE_MARK"  height="100" width="70%" editable=""/>
         <ai:dbformfield formid="chargeMainDefrom"  fieldname="ADD_USER_MARKET"  height="100" width="" visible="false"/>
         <ai:dbformfield formid="chargeMainDefrom"  fieldname="SPLICE_MUTEX_RULE"  height="100" width="" visible="false"/>
         </td>
        </tr>
         
        </table>
        </ai:dbform>
        </ai:contractframe>
       <%@include file="/charge/include/_chargeTree.jsp"%>
       <div class="area_button"><ai:button text="保存资费档次" id="query2" onclick="doWork('addChargeMainDe()')" />&nbsp;&nbsp;</div>
       <%@include file="/charge/chargeinfo/_dynamicSum.jsp"%>
       <%@include file="/charge/chargeinfo/_billingNested.jsp"%>
       <%@include file="/charge/include/_attach.jsp"%>
  </body>
</html>
<ai:loginuser/>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script type="text/javascript">
var _fromChargeMainDeFormRowSet= g_FormRowSetManager.get("chargeMainDefrom");
var feeType="<%=request.getParameter("feeType")%>";
var applyId="<%=request.getParameter("applyId")%>";
var mid="<%=request.getParameter("mid")%>";
var taskId="<%=request.getParameter("taskId")%>";
function init(){
    if("null"!=mid||""==mid){
    _fromChargeMainDeFormRowSet.refresh("id="+mid);
    var state="<%=request.getParameter("state")%>";
    _dynamic_init();
     document.getElementById("submitButton").style.display="none";
    }
    else{
    _fromChargeMainDeFormRowSet.setValue("CHARGE_TYPE",feeType);
    _fromChargeMainDeFormRowSet.setValue("APPLY_ID",applyId);
          document.getElementById("submitButton").style.display="block";
    }
     _fromChargeMainDeFormRowSet.setColEditSts("CHARGE_TYPE",false);
    _chargeTree.setTreeEdit();
    initPage();
    include_reflashAttachTable();
}

function addChargeMainDe(){
    if ("O" != _fromChargeMainDeFormRowSet.getSts())
    {
    var tMoney=_fromChargeMainDeFormRowSet.getValue("DOOR_DAMNIFY");
    var feename="<%=request.getParameter("feeName")%>";
     _fromChargeMainDeFormRowSet.setValue("FEE_NAME",feename+tMoney+"元套餐");
       saveChargeMainInclude();
    }
    if(true==_chargeTree_iFrame_n.window._chargeTreeEdit.saveTree()){
    _fromChargeMainDeFormRowSet.setValue("ADD_USER_MARKET",_chargeTree_iFrame_n.window._chargeTreeEdit.getText1());
    _fromChargeMainDeFormRowSet.setValue("SPLICE_MUTEX_RULE",_chargeTree_iFrame_n.window._chargeTreeEdit.getText2());
 	saveChargeMainInclude();
        alert("保存操作成功！");
    return true;
    }else{
     return false;
    }
    
}

function saveChargeMainInclude(){
 var list = new Array();
        list.push(_fromChargeMainDeFormRowSet);
        var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainDeAction?action=saveChargeMainDe';
        var recode = saveRowSet(strUrl, list);
        var applyID = recode.getValueByName("applyID");
        var chargeid = recode.getValueByName("chargeid");
        _fromChargeMainDeFormRowSet.setValue("APPLY_ID",applyID);
        _fromChargeMainDeFormRowSet.setValue("MID",chargeid);
        var rFlag = recode.getValueByName("FLAG");
        _fromChargeMainDeFormRowSet.refresh("id="+chargeid);
        window.opener.chargeDetailListTable.refresh("&mainId="+applyId+"&feeType="+feeType);
}

function marketMultiplySelected(){
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/SaleMarketMultiplySelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = _fromChargeMainDeFormRowSet.getValue("ADD_USER_MARKET");
    _fromChargeMainDeFormRowSet.setValue("ADD_USER_MARKET",onItemMultiplySelected(url, iniVal, style));
}

 window.onbeforeunload = onbeforeunload_handler;   
    function onbeforeunload_handler(){   
        var warning="确认信息是否都保存，是否继续?";           
        return warning;   
    }   
</script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>