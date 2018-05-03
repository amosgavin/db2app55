<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<body onload = 'initCheckPage()'>
<ai:contractframe id="wfCheckframe" contenttype="table" title="审核信息" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <ai:dbform formid="appriseForm" 
            setname="com.asiainfo.sale.tag.web.SETApproveColumn"
            conditionname="condition" parametersname="parameters"
            onvalchange="" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
            <tr id='_assistEmp'><td class="td_font">选择协办人：</td>
                <td><input type="text" id="a_assistEmp" style="width: 300px;"/>
                    <img id="selectStaico" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="a_assistEmpSelect();" align="middle" style="cursor:hand;"/>
                </td></tr>
            <tr id='_appriseEmp'><td class="td_font"><i18n:message key="SOS0100102" res="CRM" /></td>
                <td><input type="text" id="a_appriseEmp" style="width: 300px;"/>
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
                <td class="td_font">备注：</td>
                <td colspan="1"><span class="font_red">含电子券不涉及资源追加、时间延长不需要发到互联网中心！</span></td>
           
            <tr id="result" style="display: block;" onmouseover="">
                <td class="td_font">审批操作：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="RESULT" width="300"/></td>
            </tr>
            <tr id="staffs" style="display: block;">
                <td id="inner_staffs" class="td_font">下一环节处理人：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="STAFFS" width="300" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
                </td>
            </tr>
             <tr id="addate_tr" style="display: none;">
            	<td class="td_font">下一个环节完成时间：</td>
            	<td><ai:dbformfield formid="wfCheckForm" fieldname="ADVISE_FINISHDATE" width="100" />
            	</td>
            </tr>
            <tr id="currentTask_tr" style="display: none;">
            	<td class="td_font">当前任务完成时间：</td>
            	<td><ai:dbformfield formid="wfCheckForm" fieldname="CURRENT_TASK_FINISH_DATE" width="100" />
            	<a href="#" onclick="window.open('<%=request.getContextPath()%>/sale/common/include/_delayReason.jsp?itemId='+_mainId+'&taskTag='+'<%=request.getParameter("taskTag")%>','_blank','toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');">
            	<span id="sp_delay" style="font-family:华文中宋; color:red; "></span></a> </td>
            </tr>
            <tr id="reason" style="display: block;">
                <td class="td_font">说明：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="REASON" width="300" height="60"/></td>
            </tr>
            <tr id="comment" style="display: none;">
                <td class="td_font">注释：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="COMMENT" width="300" height="60" visible="false"/></td>
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
    
    function initCheckPage(){
        if(count_WfCheckFormFlash>20){
            //window.location.reload();
            //return;
        }
        count_WfCheckFormFlash++;
        //alert(count_WfCheckFormFlash);
        try
        {
            _fromWfCheckFormRowSet().refreshListBox("RESULT","templateCode="+templateCode+"&taskId="+taskId,true);
        } catch(e) {
            //initCheckPage();
            //return;
        }
        var result = _fromWfCheckFormRowSet().getValue("RESULT");
        if ("" == result){
            //initCheckPage();
            //return;
        }
        
        _fromWfCheckFormRowSet().setFocus("RESULT");
        pageSet();
        AIContractFrame_OpenClose("attachFrame");
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
        var nextTaskTag = array[7];
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
        //document.getElementById("tr_notice").style.display = "none";
        document.getElementById("_assistEmp").style.display = "block";
	    document.getElementById("_appriseEmp").style.display = "block";
        //alert(messageType);
        //if("sign" != thisTasType){
        //alert(templateCode + '----' + taskTag);
        if (nextTaskTag == 'complain003') {
			if (table00.getTotalRowCount() > 0 ) {
				if(table00.getValue(0,"COMPLAINS_TYPE")=='1'){
				_fromWfCheckFormRowSet().setValue("STAFFS", '20005008', '黄辉');
				}else{
				_fromWfCheckFormRowSet().setValue("STAFFS", '20004952', '毛晶晶');
				}
			}
		}
		var applyCity = taskRecordId.substr(3,2);
		if (taskTag == 'complain003') {
			if(table00.getTotalRowCount() > 0){
				if (table00.getValue(0,"COMPLAINS_TYPE")=='1' ) {
					if (applyCity == '10' || applyCity == '11' || applyCity == '17' || applyCity == '13' || applyCity == '14') {
	 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004938', '李莹');
		 			} else if (applyCity == '26' || applyCity == '15' || applyCity == '24') {
		 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004931', '张铮');
		 			} else if (applyCity == '25' || applyCity == '20' || applyCity == '16' || applyCity == '18') {
		 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004946', '王璨');
		 			}  else  {
		 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004947', '张雯');
		 			}
				} else {
					if (applyCity == '10') {
		 				_fromWfCheckFormRowSet().setValue("STAFFS", '20007430', '张尉');
		 			} else if (applyCity == '11' || applyCity == '17' || applyCity == '13' || applyCity == '14') {
		 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004934', '肖敏');
		 			} else if (applyCity == '26' || applyCity == '15' || applyCity == '24') {
		 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004916', '肖剑');
		 			} else if (applyCity == '12' || applyCity == '19' || applyCity == '23') {
		 				_fromWfCheckFormRowSet().setValue("STAFFS", '20007430', '张尉');
		 			} else  {
		 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004919', '刘辉');
		 			}
				}
			}
		}
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
        var array = resultTmp.split("~");
        var taskType = array[0];
        var result = array[1];
        var userType = array[2];
        var roleId = array[3];
        var userId = array[4];
        var nextTaskTag = array[7];
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
        if ((taskTag.substr(0,1)).toUpperCase() == 'S'){
        	
        	if (null == reason || trim(reason).length < 3) {
            	alert("会签意见不小于3个字！");
           		_fromWfCheckFormRowSet().setFocus("REASON");
            	return;
        	}
        }
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

function trim(str)
{
   return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>
 <div id="fujian">
<%@include file="/sale/complain/complainAttach.jsp"%>
 </div>
 </html>