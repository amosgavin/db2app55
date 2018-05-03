<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>业务变更申请</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  
  <body onload="init()">
    <ai:contractframe id="busiChangeMainframe" contenttype="table" title="业务变更主要信息" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="busiChangeMainForm" 
            setname="com.asiainfo.sale.access.web.SETBusiChange"
            conditionname="condition" parametersname="parameters"
            editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.access.service.interfaces.IBusiChangeSV"
            implservice_querymethod="getBusiChargeById(String busiId)">
        <table width="100%" align="center" border="0" cellpadding="1" cellspacing="1">
        <tr>
           <td class="td_font">申请名称:</td>
           <td><ai:dbformfield formid="busiChangeMainForm" fieldname="APPLY_NAME" width="200"/><span class="font_red">*</span>
           <ai:dbformfield formid="busiChangeMainForm" fieldname="BUSI_ID" width="60" editable="" visible="false"/>
           <ai:dbformfield formid="busiChangeMainForm" fieldname="STATE" width="150" editable="" visible="false"/></td>
           <td class="td_font">申请人:</td>
           <td><ai:dbformfield formid="busiChangeMainForm" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
               <ai:dbformfield formid="busiChangeMainForm" fieldname="PROP_STAFF" width="150" editable="" /><span class="font_red">*</span>
           </td>
         </tr> 
         <tr>
           <td class="td_font">申请单位:</td>
           <td><ai:dbformfield formid="busiChangeMainForm" fieldname="ORG" width="130" editable="false" visible="false"/>
               <ai:dbformfield formid="busiChangeMainForm" fieldname="ORG_NAME" width="200" editable=""/><span class="font_red">*</span></td>
           <td class="td_font">联系电话:</td>
           <td><ai:dbformfield formid="busiChangeMainForm" fieldname="TEL" width="150" /><span class="font_red">*</span></td>
         
         </tr>
         <tr>
            <td class="td_font">申请说明及依据:</td>
            <td colspan="5"><ai:dbformfield formid="busiChangeMainForm" fieldname="DESCRIPTION" height="60" width="700"/><span class="font_red">*</span><span style="font-family:华文中宋; color:red; ">(请注明本平台或OA平台相应工单号)</span></td>
         </tr>
         <tr><td colspan="4" align="center"><ai:button text="保存主信息" id="busi_bt" onclick="doWork('savebusiChangeMainInfo()')" /></td></tr>
       </table>

    </ai:dbform>
</ai:contractframe>
<ai:loginuser/>
<%@include file="/sale/access/include/_busiChangeDetail.jsp"%>
<script type="text/javascript">

var _orgId = g_GetUserInfo().ORG_ID;
var busiId = "<%=request.getParameter("recordId")%>";
var _mainId = busiId;
var taskTag="<%=request.getParameter("taskTag")%>";

</script>
<%@include file="/sale/access/include/_busiChangeCheck.jsp"%>
</body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script language="javascript" type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>
<script language="javascript" type="text/javascript">
var _busiChangeFormRowSet= g_FormRowSetManager.get("busiChangeMainForm");
function init(){ 
	//var busiId =_busiChangeFormRowSet.getValue("BUSI_ID");
	var state =_busiChangeFormRowSet.getValue("STATE");
	//点击查询时候（状态为已保存）进入页面
	if ('null' != busiId ) {
	  _busiChangeFormRowSet.refresh("&busiId="+busiId);
	  //showName();
	  //include_attach_setButtonDisabled(false);
	  include_reflashAttachTable();
	} else {
		//页面刷新，或是修改；id为空时，是申请
		 var staffId = g_GetUserInfo().STAFF_ID;
		_busiChangeFormRowSet.setValue("PRINCIPLE",g_GetUserInfo().STAFF_ID);
		_busiChangeFormRowSet.setValue("PROP_STAFF",g_GetUserInfo().STAFF_NAME);
		_busiChangeFormRowSet.setValue("ORG",g_GetUserInfo().ORG_ID);
		_busiChangeFormRowSet.setValue("ORG_NAME",g_GetUserInfo().ORG_NAME);
		_busiChangeFormRowSet.setValue("TEL",g_GetUserInfo().STAFF_ID);
		showName();
		//include_attach_setButtonDisabled(true);
   }
   initBusiChangeDetailInfo();
   initCheckPage();
   
   if (taskTag != 'busi009'){
	   _busiChangeFormRowSet.setEditSts("false");
	   busiChangeDetailForm.setEditSts("false");
	   g_AIButtonManager.get("busi_bt").setDisabled("false");
	   g_AIButtonManager.get("busid_bt").setDisabled("false");
	   g_AIButtonManager.get("del_bt1").setDisabled("false");
	   g_AIButtonManager.get("del_bt2").setDisabled("false");
	   g_AIButtonManager.get("del_bt3").setDisabled("false");
	   g_AIButtonManager.get("new_add_bt").setDisabled("false");
	   //include_attach_setButtonDisabled(true);
	   //g_AIButtonManager.get("deleteAttachFile").setDisabled("false");
   }
   if (taskTag == 'busi013'){
	   busiChangeDetailForm.setColEditSts("REMARK2","true");
	   busiChangeDetailForm.setColEditSts("REMARK3","true");
	   g_AIButtonManager.get("busid_bt").setDisabled("true");
   }
}

function showName(){
	
	_busiChangeFormRowSet.setFocus("TEL");    
	_busiChangeFormRowSet.setColEditSts("ORG_NAME",false);
	_busiChangeFormRowSet.setColEditSts("PROP_STAFF",false);
	_busiChangeFormRowSet.setColEditSts("TEL",false);
}

function savebusiChangeMainInfo(){
	 var applyName=_busiChangeFormRowSet.getValue("APPLY_NAME");
	 var mark=_busiChangeFormRowSet.getValue("DESCRIPTION"); 
	 if(""==applyName){return  alert("请输入业务变更申请名称！");}
	 if(""==mark){return  alert("请填写申请说明！");}
	
	 if ("O" != _busiChangeFormRowSet.getSts()||_busiChangeFormRowSet.getSts()=="U")
	 {
        var list = new Array();
	    list.push(_busiChangeFormRowSet);
	    var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.BusiChangeAction?action=saveBusiChangeMainInfo';
	    var recode = saveRowSet(strUrl, list);
	    busiId = recode.getValueByName("busiId");
	    if(busiId == null || busiId == '' || busiId == 'undefined'){
	    	return alert("保存操作失败！");
	    }
  	    _busiChangeFormRowSet.refresh("&busiId="+busiId);
  	    //showName();
	 }
}

</script>
