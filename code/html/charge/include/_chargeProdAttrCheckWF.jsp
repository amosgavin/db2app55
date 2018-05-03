<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<body onload = 'initCheck()'>
<ai:contractframe id="wfCheckframe" contenttype="table" title="审核信息" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <ai:dbform formid="appriseForm" 
            setname="com.asiainfo.sale.tag.web.SETApproveColumn"
            conditionname="condition" parametersname="parameters"
            onvalchange="" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
            <tr id='_assistEmp'><td class="td_font">选择协办人：</td>
                <td><input type="text" id="a_assistEmp" style="width: 260px;"/>
                    <img id="selectStaico" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="a_assistEmpSelect();" align="middle" style="cursor:hand;"/>
                </td></tr>
            <tr id='_appriseEmp'><td class="td_font"><i18n:message key="SOS0100102" res="CRM" /></td>
                <td><input type="text" id="a_appriseEmp" style="width: 260px;"/>
                    <img id="selectStaico" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="a_appriseEmpSelect();" align="middle" style="cursor:hand;"/>
                </td>
            </tr>
        </table>
    </ai:dbform>
    <ai:dbform formid="wfCheckForm" 
        onvalchange="onValChange" initial="false"
        setname="com.asiainfo.workflow.util.web.SETFWOperate">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr id="tr_notice" style="display: none;">
                <td colspan="2"><span class="font_red">若存在电子券标签，请先行配置！</span></td>
           
            <tr id="result" style="display: block;" onmouseover="">
                <td class="td_font">审批操作：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="RESULT" width="260"/></td>
            </tr>
            <tr id="staffs" style="display: block;">
                <td id="inner_staffs" class="td_font">下一环节处理人：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="STAFFS" width="260" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
                </td>
            </tr>
            <tr id="reason" style="display: block;">
                <td class="td_font">说明：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="REASON" width="260" height="60"/></td>
            </tr>
            <tr id="comment" style="display: none;">
                <td class="td_font">注释：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="COMMENT" width="260" height="60" visible="false"/></td>
            </tr>
            <tr align="right"><td><ai:button id="doSubmit" text="提交" onclick="doSubmit()"/></td></tr>
        </table>
        </ai:dbform>
</ai:contractframe>
<ai:contractframe id="wfCheckAddframe" contenttype="table" title="加办" width="100%" allowcontract="true" frameclosed="true">
    <ai:contractitem><ai:button id="doSubmit" text="选择加办人" onclick="openSelectStaff()"/></ai:contractitem>
    <ai:dbform formid="wfCheckAddForm" 
        onvalchange="" initial="false"
        setname="com.asiainfo.sale.common.web.SETFWOperate">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr id="staffs">
                <td class="td_font">加办人：</td>
                <td><ai:dbformfield formid="wfCheckAddForm" fieldname="STAFFS" width="260"/><img id="bt_selectAddStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectAddStaff();" align="absmiddle" style="cursor:hand;"/></td>
            </tr>
            <tr id="reason" style="display: none">
                <td class="td_font">说明：</td>
                <td><ai:dbformfield formid="wfCheckAddForm" fieldname="REASON" width="260" height="60"/></td>
            </tr>
        </table>
    </ai:dbform>
    <div class="area_button">
   <ai:button text="加办" id="queryB" onclick="AssignJB()" />&nbsp;&nbsp;
   </div>
</ai:contractframe>
</body>

<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script type="text/javascript">
    var url_selectStaff;
    var title_staff;
    var isShow_staff = false;
    var style_selectStaff = "scroll:no;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px";
    var templateCode = "<%=request.getParameter("templateCode")%>";
    var taskId = "<%=request.getParameter("taskTemplateId")%>";
    var taskTag = "<%=request.getParameter("taskTag")%>";
    var taskRecordId = "<%=request.getParameter("taskId")%>";
    var flowType = "<%=request.getParameter("recordType")%>";
    var count_WfCheckFormFlash = 0;
    var messageType = '';
    var org_selected = '';
    var IsHasTicket = false;
    

    
    function _fromWfCheckFormRowSet(){
        return g_FormRowSetManager.get("wfCheckForm");
    }
    
    function initCheck(){
    
        if(count_WfCheckFormFlash>20){
            //window.location.reload();
            //return;
        }
        count_WfCheckFormFlash++;
        //alert(count_WfCheckFormFlash);
        try
        {	

        	 //var taskId = "1";
            _fromWfCheckFormRowSet().refreshListBox("RESULT","templateCode="+templateCode+"&taskId="+taskId,true);
            
        } catch(e) {
            //initCheckPage();
            //return;
        }
        _fromWfCheckFormRowSet().setValue("RESULT","111");
        var result = _fromWfCheckFormRowSet().getValue("RESULT");
 
        if ("" == result){
            //initCheckPage();
            //return;
        }
        
        _fromWfCheckFormRowSet().setFocus("RESULT");
        pageSet();
        //AIContractFrame_OpenClose("attachFrame");
    }
    
    function onValChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText){
        if (pFieldName == 'RESULT') {
            _fromWfCheckFormRowSet().clearValue("STAFFS"); 
            var result = _fromWfCheckFormRowSet().getValue("RESULT");
            pageSet();
        }
    }
    
    function pageSet(){
        var resultInfo = _fromWfCheckFormRowSet().getValue("RESULT");
        var array = resultInfo.split("~");
        var taskType = array[0];
        var result = array[1];
        var userType = array[2];
        var roleId = array[3];
        var userId = array[4];
        messageType = array[5];
        var thisTaskType = array[6];
        var orgId = g_GetUserInfo().ORG_ID.substr(0,2);
        isShow_staff = true;
        document.getElementById("staffs").style.display = "block";
        //设置主办人会签人信息
	       if(roleId == "-2" && "finish" != taskType){
	            title_staff = "下一环节处理人：";
	            document.getElementById("inner_staffs").innerHTML = title_staff;
	            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?org_id=1001&orgId="+g_GetUserInfo().ORG_ID;
	            style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:670px";
	        } else if ("sign" == taskType && roleId != "-2") {
	        	title_staff = "下一环节会签人：";
	            document.getElementById("inner_staffs").innerHTML = title_staff;
	            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s.jsp?org_id=10&orgId="+g_GetUserInfo().ORG_ID;
	            style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:670px";
	        } else if("finish" != taskType && ("" == roleId || "null" == roleId )){
	            title_staff = "下一环节处理人：";
	            document.getElementById("inner_staffs").innerHTML = title_staff;
	            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?org_id=10&orgId="+g_GetUserInfo().ORG_ID;
	            style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:670px";
	        } else if("-1" == roleId || "sign" == thisTaskType || "finish" == taskType) {
	            isShow_staff = false;
	            document.getElementById("staffs").style.display = "none";
	        } else {
	            title_staff = "下一环节处理人：";
	            document.getElementById("inner_staffs").innerHTML = title_staff;
	            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s1.jsp?roleId="+roleId+"&orgId="+orgId;
	            style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:550px;dialogWidth:430px";
	            
	            //url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?roleId="+roleId+"&orgId="+orgId;
	            //style_selectStaff = "scroll:no;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px";
            }
        document.getElementById("tr_notice").style.display = "none";
        document.getElementById("_assistEmp").style.display = "block";
	    document.getElementById("_appriseEmp").style.display = "block";
        //alert(messageType);
        //if("sign" != thisTasType){
        //alert(templateCode + '----' + taskTag);
    }
    
    function selectStaff()
    {
        var result = window.showModalDialog(url_selectStaff, null, style_selectStaff);
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
            _fromWfCheckFormRowSet().setValue("STAFFS", operatorId, name); 
        }
    } 
    
    function selectWorkDepStaff(flag) {
        var url = "<%=request.getContextPath()%>/sale/promationTag/appriseDialog.jsp?type=work&orgInit="+flag+"&org_id=10&a_workflowId=<%=request.getParameter("workflowId")%>";
        var style = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:390px;dialogWidth:700px";
        window.showModalDialog(url, null, style);
    }
    
    function doSubmit() {
        var taskId = "<%=request.getParameter("taskId")%>";
        if (null == taskId || "" == taskId)
        {
            return alert("流程编号为空，请刷新后再试！");
        }
        var resultTmp = _fromWfCheckFormRowSet().getValue("RESULT");
        var displaytxt = _fromWfCheckFormRowSet().getDisplayText("RESULT");
        if (taskTag == 'busi007' || taskTag == 'busi010'){
        	 var checkRet = PostInfo(_gModuleName + '/business/com.asiainfo.sale.access.web.BusiChangeAction?action=isHasTicketChange&busiId=' + _mainId);
        	 if ("true" == checkRet.getValueByName("HasTicket") && displaytxt != '同意，并发互联网中心（资源追加含电子卷）' && displaytxt != '不同意，退回发起人修改') {
	        	 alert("含有电子券的资源追加，请发互联网中心！");
	        	 if(!confirm("您确定要提交！")){
	        		 return;
	        	 }
        	 }
        }
        

        if (taskTag == 'batch10'){
			var bossDoneCode = saleEditPrestoreF.getValue("BOSS_DONE_CODE");
			if(bossDoneCode == "null" || bossDoneCode == ""){
				alert("在【地市发起人配置】流程节点中，必需填写BOSS作业号！");
				return;
			}
        }
       if (taskTag == 'batch11'){
       		var businessReview = saleEditPrestoreF.getValue("BUSINESS_REVIEW");
       		if(businessReview == "null" || businessReview == ""){
				alert("在【省业支复核】流程节点中，必需填写业务复核！");
				return;
			}
			
       }
       
       //alert(document.getElementById("bt_save").disabled);
       
       if(true != document.getElementById("bt_save").disabled){return  alert("请对修改进行保存后再提交！");}
       		
        
        var array = resultTmp.split("~");
        var taskType = array[0];
        var result = array[1];
        var userType = array[2];
        var roleId = array[3];
        var userId = array[4];
        if (null == result || "" == result)
        {
            alert("审批操作为空");
            _fromWfCheckFormRowSet().setFocus("RESULT");
            return;
        }
        var staffId = _fromWfCheckFormRowSet().getValue("STAFFS");
        if (isShow_staff && (null == staffId || "" == staffId))
        {
            alert(title_staff + "为空");
            _fromWfCheckFormRowSet().setFocus("STAFFS");
            return;
        }
        var reason = _fromWfCheckFormRowSet().getValue("REASON");
        //if (null == reason || "" == reason)
       // {
           // alert("说明为空");
           // _fromWfCheckFormRowSet().setFocus("REASON");
            //return;
        //}
        reason = displaytxt+"|"+reason;
        var comment = _fromWfCheckFormRowSet().getValue("COMMENT");
        if (null == comment || "" == comment)
        {
            //alert("申请单编号为空");
            //_fromWfCheckFormRowSet().setFocus("COMMENT");
            //return ;
        }
        
        if(!a_send()){
            return;   
        }
        
        var strUrl = _gModuleName + '/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=finishUserTask&taskId=' + taskId
                    + "&result=" + result
                    + "&staffId=" + staffId
                    + "&reason=" + reason.replace(/%/g,"^#")
                    + "&comment=" + comment
                    + "&taskType=" + taskType
                    + "&templateCode=" + templateCode
                    + "&flowType=" + flowType
                    + "&mainId=" + _mainId;
        var recode = PostInfo(strUrl);
        if ("Y" == recode.getValueByName("FLAG"))
        {
            alert(recode.getValueByName("MESSAGE"));
            window.parent.opener.location.reload();
    		window.parent.self.close();
        } else {
            alert(recode.getValueByName("MESSAGE"));
        }
    }
    
</script>
<script type="text/javascript">
function _fromWfCheckAddFormRowSet(){
    return g_FormRowSetManager.get("wfCheckAddForm");
}

function openSelectStaff() {
    AIContractFrame_OpenClose("wfCheckAddframe");
    AIContractFrame_openMe();
    selectAddStaff();
}

function AssignJB(){
 	 var nextStaffId=_fromWfCheckAddFormRowSet().getValue("STAFFS");
     if (null == nextStaffId || "" == nextStaffId)
     {
         return alert("请选择加办人");
     }
     var strUrl = "<%=request.getContextPath()%>/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=reAuthorizeTask&taskId="+taskRecordId + "&nextStaffId="+nextStaffId;      
     
     var recode = PostInfo(strUrl);
     if ("Y" == recode.getValueByName("FLAG"))
     {
         alert("加办提交成功");
         
     } else {
         alert(recode.getValueByName("MESSAGE"));
     }
     window.parent.opener.location.reload();
     window.parent.self.close();
}
    
function selectAddStaff()
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
        _fromWfCheckAddFormRowSet().setValue("STAFFS", operatorId, name); 
    }
} 
</script>
<script type="text/javascript">
var a_appriseEmp = '';
var a_assistEmp = '';
var a_publishEmp = '';
var a_workflowId = "<%=request.getParameter("workflowId")%>";
var a_formRowSet = g_FormRowSetManager.get("appriseForm");

function a_send()
{
    if (a_appriseEmp == '' && a_assistEmp == '' && a_publishEmp == ''){
        //alert(crm_i18n_msg("SOC0100106"));
        return true;
    }
    var content = _fromWfCheckFormRowSet().getValue("REASON").replace(/%/g,"^#");
    var condition = 'workflowId=' + a_workflowId + '&appriseEmp=' + a_appriseEmp + '&assistEmp=' + a_assistEmp + '&publishEmp=' + a_publishEmp + '&content=' +content ;
    var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AppriseAction?action=saveAppriseMember&' + condition;
    var recode = PostInfo(strUrl, null);
    if (recode.getValueByName("FLAG") == "Y") {
        //alert(crm_i18n_msg("SOC0100107"));
        return true;
    } else {
        alert(recode.getValueByName("MESSAGE"));
        return false;
    }
}

function a_appriseEmpSelect()
{
    var result = openSelect.staffSelect("tmd",'10',g_GetUserInfo().ORG_ID);
        if(result != null){
            
            var name;
            for(var i=0;i < result.elements.length;i++)
            {
                if (i == 0)
                {
                    a_appriseEmp = result.elements[i].operatorId;
                    name = result.elements[i].name;
                } else {
                    a_appriseEmp = a_appriseEmp + ";" + result.elements[i].operatorId;
                    name = name + ";" + result.elements[i].name;
                }
            }
            document.getElementById("a_appriseEmp").value = name; 
        }
} 

function a_assistEmpSelect()
{
	//alert(g_GetUserInfo().ORG_ID);
    var result = openSelect.staffSelect("tmd",'10',g_GetUserInfo().ORG_ID);
        if(result != null){
            
            var name;
            for(var i=0;i < result.elements.length;i++)
            {
                if (i == 0)
                {
                    a_assistEmp = result.elements[i].operatorId;
                    name = result.elements[i].name;
                } else {
                    a_assistEmp = a_assistEmp + ";" + result.elements[i].operatorId;
                    name = name + ";" + result.elements[i].name;
                }
            }
            document.getElementById("a_assistEmp").value = name; 
        }
}

function clearstaff(){
	_fromWfCheckFormRowSet().setValue("STAFFS","");
}
</script>

 </html>