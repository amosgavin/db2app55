<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<div class="area_button" id="div_createWorkflow">
    <ai:dbform formid="wfCheckForm" 
        onvalchange="onValChange" initial="false"
        setname="com.asiainfo.workflow.util.web.SETFWOperate">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr id="result" style="display: block;">
                <td class="td_font">审批操作：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="RESULT" width="260"/></td>
            </tr>
            <tr id="staffs" style="display: block;">
                <td id="inner_staffs" class="td_font">下一环节处理人：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="STAFFS" width="260" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
                </td>
            </tr>
        </table>
           <div class="area_button"><ai:button id="bt_createWorkflow" text="提交审核" onclick="doSubmit()"/></div>
        </ai:dbform>
</div>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script type="text/javascript">
    var title_staff;
    var isShow_staff = false;
    var style_selectStaff = "scroll:no;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px";
    var templateCode = "<%=request.getParameter("templateCode")%>";
    var taskId = "<%=request.getParameter("taskTemplateId")%>";
    var taskTag = "<%=request.getParameter("taskTag")%>";
    var taskRecordId = "<%=request.getParameter("taskId")%>";
    var flowType = "<%=request.getParameter("recordType")%>";
    var url_selectStaff;
    initCheckPage();
    function _fromWfCheckFormRowSet(){
        return g_FormRowSetManager.get("wfCheckForm");
    }
 
    function initCheckPage(){
        try
        {
            _fromWfCheckFormRowSet().refreshListBox("RESULT","templateCode="+templateCode+"&taskId="+taskId,true);
        } catch(e) {
        }
        var result = _fromWfCheckFormRowSet().getValue("RESULT");
        if ("" == result){
        }
        _fromWfCheckFormRowSet().setFocus("RESULT");
        pageSet();
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
    //alert(resultInfo);
    var array = resultInfo.split("~");
    var taskType = array[0];
    var result = array[1];
    var userType = array[2];
    var roleId = array[3];
    var userId = array[4];
    
    var orgId = g_GetUserInfo().ORG_ID.substr(0,2);
    isShow_staff = true;
    if ("sign" == taskType) {
        title_staff = "会签人：";
        document.getElementById("inner_staffs").innerHTML = title_staff;
        url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s.jsp?org_id=10&orgId="+g_GetUserInfo().ORG_ID;
    	style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:670px";
	} else {
    	url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s1.jsp?roleId="+roleId+"&orgId="+orgId;
        style_selectStaff = "scroll:no;resizable:no;help:no;status:no;dialogHeight:350px;dialogWidth:320px";
    }
    
    if(taskTag =='res003' || taskTag =='res099' || taskTag =='res002'){
       document.getElementById("staffs").style.display = "none";
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

function doSubmit(){
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
        if(taskTag !='res003'&& taskTag !='res099'&& taskTag!='res002'){
        if (isShow_staff && (null == staffId || "" == staffId))
        {
            alert("下一环节处理人为空");
            _fromWfCheckFormRowSet().setFocus("STAFFS");
            return;
        }
        }
        var reason = displaytxt+"|"+reason;
        var comment="";
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

function trim(str)
{
   return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>
 </html>