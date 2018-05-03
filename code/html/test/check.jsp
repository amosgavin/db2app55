<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>审核</title>
</head>
<body onload="initCheckPage()">
<ai:contractframe id="wfCheckframe" contenttype="table" title="营销活动主要信息" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <ai:dbform formid="wfCheckForm" 
        onvalchange="onValChange" initial="false"
        setname="com.asiainfo.workflow.util.web.SETFWOperate">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr id="result" style="display: block;" onmouseover="">
                <td class="td_font">审批操作：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="RESULT" width="260"/></td>
            </tr>
            <tr id="staffs" style="display: block;">
                <td id="inner_staffs" class="td_font">：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="STAFFS" width="260" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
            </tr>
            <tr id="reason" style="display: block;">
                <td class="td_font">说明：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="REASON" width="260" height="60"/><span class="font_red">*</span></td>
            </tr>
            <tr id="comment" style="display: none;">
                <td class="td_font">注释：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="COMMENT" width="260" height="60" visible="false"/></td>
            </tr>
            <tr>
                <td class="td_font" colspan="2"><ai:button id="doSubmit" text="提交" onclick="doSubmit()"/></td>
            </tr>
        </table>
        </ai:dbform>
</ai:contractframe>
</body>
<ai:loginuser/>
<script type="text/javascript">
    var url_selectStaff;
    var title_staff;
    var isShow_staff = false;
    var style_selectStaff = "scroll:no;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px";
    var templateCode = "<%=request.getParameter("templateCode")%>";
    var taskId = "<%=request.getParameter("taskTemplateId")%>";
    function _fromWfCheckFormRowSet(){
        return g_FormRowSetManager.get("wfCheckForm");
    }
    
    function initCheckPage(){
        //alert(templateCode+"~"+taskId);
        try
        {
        _fromWfCheckFormRowSet().refreshListBox("RESULT","templateCode="+templateCode+"&taskId="+taskId,true);
        } catch(e) {
        	//alert(e);
        	//window.location.reload();
        }
        _fromWfCheckFormRowSet().setFocus("RESULT");
        var result = _fromWfCheckFormRowSet().getValue("RESULT");
        //alert(result);
        if ("" == result){
            //window.location.reload();
        }
        //alert(1);
        
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
        var array = resultInfo.split("|");
        var taskType = array[0];
        var result = array[1];
        var userType = array[2];
        var roleId = array[3];
        var userId = array[4];
        
        var orgId = 10;//g_GetUserInfo().ORG_ID.substr(0,2);
        
        isShow_staff = true;
        document.getElementById("staffs").style.display = "block";
        //设置主办人会签人信息
        if ("sign" == taskType) {
            title_staff = "会签人：";
            document.getElementById("inner_staffs").innerHTML = title_staff;
            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s.jsp?org_id=10";
            style_selectStaff = "scroll:no;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px";
        } else if("" == roleId || "null" == roleId) {
            title_staff = "处理人：";
            document.getElementById("inner_staffs").innerHTML = title_staff;
            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?org_id=10";
            style_selectStaff = "scroll:no;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px";
        } else if("-1" == roleId || "14" == taskId) {
            isShow_staff = false;
            document.getElementById("staffs").style.display = "none";
        } else {
            title_staff = "处理人：";
            document.getElementById("inner_staffs").innerHTML = title_staff;
            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s1.jsp?roleId="+roleId+"&orgId="+orgId;
            style_selectStaff = "scroll:no;resizable:no;help:no;status:no;dialogHeight:250px;dialogWidth:320px";
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
    
    function doSubmit() {
        var taskId = "<%=request.getParameter("taskId")%>";
        if (null == taskId || "" == taskId)
        {
            return alert("流程编号为空，请刷新后再试！");
        }
        var resultTmp = _fromWfCheckFormRowSet().getValue("RESULT");
        var array = resultTmp.split("|");
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
        if (null == reason || "" == reason)
        {
            alert("说明为空");
            _fromWfCheckFormRowSet().setFocus("REASON");
            return;
        }
        var comment = _fromWfCheckFormRowSet().getValue("COMMENT");
        if (null == comment || "" == comment)
        {
            //alert("申请单编号为空");
            //_fromWfCheckFormRowSet().setFocus("COMMENT");
            //return ;
        }
        
        var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.SaleMainAction?action=finishUserTask&taskId=' + taskId
                    + "&result=" + result
                    + "&staffId=" + staffId
                    + "&reason=" + reason
                    + "&comment=" + comment;
        //alert(strUrl);
        //return;
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