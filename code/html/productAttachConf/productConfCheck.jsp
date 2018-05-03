<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<div id="detail_div" style="display: block">
		<% String relaOrderType =request.getParameter("relaOrderType");
		   String recordId = request.getParameter("recordId");
		   String targ_jsp = "./_charge.jsp?recordId="
				   				+ recordId
		                        + "&orderState=1";
		   if (relaOrderType.equals("sale")) {
			    targ_jsp = "./_sale.jsp?orderId="
			    			 + recordId
			    			 + "&editable=false";
		   } 
		%>  
		<jsp:include page="<%=targ_jsp %>"></jsp:include>
</div>
  
<ai:contractframe id="WFCheckframe" contenttype="table" title="审核信息" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <ai:dbform formid="WFCheckForm" 
        onvalchange="_onValChange" initial="false"
        setname="com.asiainfo.workflow.util.web.SETFWOperate">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
           
            <tr id="result" style="display: block;" onmouseover="">
                <td class="td_font">审批操作：</td>
                <td><ai:dbformfield formid="WFCheckForm" fieldname="RESULT" width="300"/></td>
            </tr>
            <tr id="staffs" style="display: block;">
                <td id="inner_staffs" class="td_font">下一环节处理人：</td>
                <td><ai:dbformfield formid="WFCheckForm" fieldname="STAFFS" width="300" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="_selectStaff();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
                </td>
            </tr>
            <tr id="reason" style="display: block;">
                <td class="td_font">说明：</td>
                <td><ai:dbformfield formid="WFCheckForm" fieldname="REASON" width="300" height="60"/></td>
            </tr>
            <tr id="comment" style="display: none;">
                <td class="td_font">注释：</td>
                <td><ai:dbformfield formid="WFCheckForm" fieldname="COMMENT" width="300" height="60" visible="false"/></td>
            </tr>
            <tr align="right"><td><ai:button id="doSubmit" text="提交" onclick="_doSubmit()"/></td></tr>
        </table>
        </ai:dbform>
</ai:contractframe>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script type="text/javascript">

var applyId="<%=request.getParameter("recordId")%>";

var url_selectStaff;
var title_staff;
var isShow_staff = false;
var style_selectStaff = "scroll:no;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px";
var templateCode = "<%=request.getParameter("templateCode")%>";
var taskId = "<%=request.getParameter("taskId")%>";
var taskTag = "<%=request.getParameter("taskTag")%>";
var taskRecordId = "<%=request.getParameter("taskRecordId")%>";
var flowType = "<%=request.getParameter("recordType")%>";
var messageType = '';
var org_selected = '';
var IsHasTicket = false;

_initCheckPage();
function _WfCheckFormRowSet(){
    return g_FormRowSetManager.get("WFCheckForm");
}

function _initCheckPage(){
    _WfCheckFormRowSet().refreshListBox("RESULT","templateCode="+templateCode+"&taskId="+taskId,true);
    _WfCheckFormRowSet().setFocus("RESULT");
    _pageSet();
    //AIContractFrame_OpenClose("attachFrame");
}

function _onValChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText){
    if (pFieldName == 'RESULT') {
        _WfCheckFormRowSet().clearValue("STAFFS"); 
        var result = _WfCheckFormRowSet().getValue("RESULT");
        _pageSet();
    }
}

function _pageSet(){
    var resultInfo = _WfCheckFormRowSet().getValue("RESULT");
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
   }
}
    
function _selectStaff()
{
	
    var result = window.showModalDialog(url_selectStaff, null, style_selectStaff);
    if(result != null){
        var operatorId;
        var name;
        for(var i=0;i < result.elements.length;i++){
            if (i == 0){
                operatorId = result.elements[i].operatorId;
                name = result.elements[i].name;
            } else {
                operatorId = operatorId + ";" + result.elements[i].operatorId;
                name = name + ";" + result.elements[i].name;
            }
        }
        _WfCheckFormRowSet().setValue("STAFFS", operatorId, name); 
    }
} 

function _selectWorkDepStaff(flag) {
    var url = "<%=request.getContextPath()%>/sale/promationTag/appriseDialog.jsp?type=work&orgInit="+flag+"&org_id=10&a_workflowId=<%=request.getParameter("workflowId")%>";
    var style = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:390px;dialogWidth:700px";
    window.showModalDialog(url, null, style);
}

function _doSubmit() {
    var taskId = "<%=request.getParameter("taskId")%>";
    if (null == taskId || "" == taskId)
    {
        return alert("流程编号为空，请刷新后再试！");
    }
    var resultTmp = _WfCheckFormRowSet().getValue("RESULT");
    var displaytxt = _WfCheckFormRowSet().getDisplayText("RESULT");
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
        _WfCheckFormRowSet().setFocus("RESULT");
        return;
    }
    var staffId = _WfCheckFormRowSet().getValue("STAFFS");
    if (isShow_staff && (null == staffId || "" == staffId))
    {
        alert(title_staff + "为空");
        _WfCheckFormRowSet().setFocus("STAFFS");
        return;
    }
    var reason = _WfCheckFormRowSet().getValue("REASON");
    reason = displaytxt+"|"+reason;
    var comment = _WfCheckFormRowSet().getValue("COMMENT");
    var strUrl = _gModuleName + '/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=finishUserTask&taskId=' + taskRecordId
                + "&result=" + result
                + "&staffId=" + staffId
                + "&reason=" + reason.replace(/%/g,"^#")
                + "&comment=" + comment
                + "&taskType=" + taskType
                + "&templateCode=" + templateCode
                + "&flowType=" + flowType
                + "&mainId=" + "<%=request.getParameter("id")%>";
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
