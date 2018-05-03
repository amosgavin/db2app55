<%@ page contentType="text/html; charset=GBK"%>
<div class="area_button" id="div_createWorkflow">
    <ai:dbform formid="wfCheckForm" 
        onvalchange="onValChange" initial="false"
        setname="com.asiainfo.workflow.util.web.SETFWOperate">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr id="result" style="display: block;">
                <td class="td_font">审批操作：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="RESULT" width="260" editable="true"/></td>
            </tr>
            <tr id="staffs" style="display: block;">
                <td id="inner_staffs" class="td_font">下一环节处理人：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="STAFFS" width="260" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
                </td>
            </tr>
        </table>
           <div class="area_button"><ai:button id="bt_createWorkflow" text="提交审核" onclick="doWork('createWorkflow()')"/></div>
        </ai:dbform>
</div>
<script type="text/javascript">
var _templateCode = "template.UniteChargeFlow";
var _flowType = "UniteChargeFlow";
var _orgId = g_GetUserInfo().ORG_ID;
var url_selectStaff;
var style_selectStaff = "scroll:no;resizable:no;help:no;status:no;dialogHeight:560px;dialogWidth:560px";

function _fromWfCheckFormRowSet(){
    return g_FormRowSetManager.get("wfCheckForm");
}

function initCheckPage(){
    var taskId = "1";
    _fromWfCheckFormRowSet().refreshListBox("RESULT","templateCode="+_templateCode+"&taskId="+taskId,true);
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
    var tmpEditor = FormRowSet_Field_DBListBox_getEditor(_fromWfCheckFormRowSet(),"RESULT");
    var optionLength = tmpEditor.options.length;
    if (optionLength == 1) return;
    for (var i=0; i<optionLength; ++i) {
	    if ("10" == _orgId.substr(0,2) && "1003" != _orgId.substr(0,4) && "1010" != _orgId.substr(0,4)) {
		   _fromWfCheckFormRowSet().setValue("RESULT",tmpEditor.options[1].value);
		   _fromWfCheckFormRowSet().setValue("STAFFS", 20004937, '高文');
		   
	    } 
    }
    _fromWfCheckFormRowSet().setColEditSts("RESULT",false);
    
    var resultInfo = _fromWfCheckFormRowSet().getValue("RESULT");
    var array = resultInfo.split("~");
    var taskType = array[0];
    var result = array[1];
    var userType = array[2];
    var roleId = array[3];
    var userId = array[4];
    
    var orgId = _orgId.substr(0,2);
    if ("sign" == taskType) {
        title_staff = "会签人：";
        document.getElementById("inner_staffs").innerHTML = title_staff;
        url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s.jsp?org_id=10&orgId="+g_GetUserInfo().ORG_ID;
        style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:670px";
    } else {
        url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s1.jsp?roleId="+roleId+"&orgId="+orgId;
        style_selectStaff = "scroll:no;resizable:no;help:no;status:no;dialogHeight:350px;dialogWidth:320px";
    }
    if (_orgId == "1003" || _orgId == "1010") orgId = _orgId.substr(0,4);
    
    var strUrl = _gModuleName + '/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=getDefaultPsByRoleAndOrg&roleId=' + roleId+'&orgId='+orgId;        
   	var ret = PostInfo(strUrl);
    if ("Y" == ret.getValueByName("FLAG"))
    {
    	_fromWfCheckFormRowSet().setValue("STAFFS", ret.getValueByName("opIds"), ret.getValueByName("stNames")); 
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

function createWorkflow()
{
	if(!haveAttch()) return;
	if(!addYOrN()){
       return;
    }
    if (null == _mainId || "" == _mainId)
    {
        return alert("申请单编号为空");
    }
    
    if (!checkChargeInfo ()) return;
    var resultTmp = _fromWfCheckFormRowSet().getValue("RESULT");
    var array = resultTmp.split("~");
    var taskType = array[0];
    var result = array[1];
    var userType = array[2];
    var roleId = array[3];
    var userId = array[4];
    
    var mainId =_mainId;
    var staffId = _fromWfCheckFormRowSet().getValue("STAFFS"); 
    if (null == staffId || "" == staffId)
    {
        alert("审批人不能为空");
        return;
    }
   var strUrl = _gModuleName + '/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=createWorkflow&mainId=' + mainId+"&staffId="+staffId+"&flowType="+_flowType+"&result="+result;        
   var recode = PostInfo(strUrl);
    if ("Y" == recode.getValueByName("FLAG"))
    {
        alert("提交审核成功");
        window.location.reload();
    } else {
        alert(recode.getValueByName("MESSAGE"));
    }
}

function clearstaff(){
	_fromWfCheckFormRowSet().setValue("STAFFS","");
}
</script>