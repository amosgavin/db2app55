<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<body onload = 'initCheckPage()'>
<ai:contractframe id="wfCheckframe" contenttype="table" title="�����Ϣ" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <ai:dbform formid="appriseForm" 
            setname="com.asiainfo.sale.tag.web.SETApproveColumn"
            conditionname="condition" parametersname="parameters"
            onvalchange="" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
            <tr id='_assistEmp'><td class="td_font">ѡ��Э���ˣ�</td>
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
                <td class="td_font">��ע��</td>
                <td colspan="1"><span class="font_red">������ȯ���漰��Դ׷�ӡ�ʱ���ӳ�����Ҫ�������������ģ�</span></td>
           
            <tr id="result" style="display: block;" onmouseover="">
                <td class="td_font">����������</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="RESULT" width="300"/></td>
            </tr>
            <tr id="staffs" style="display: block;">
                <td id="inner_staffs" class="td_font">��һ���ڴ����ˣ�</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="STAFFS" width="300" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
                </td>
            </tr>
            <tr id="reason_explan1" style="display: none;">
             	<td class="td_font"><font color="red">��д˵����</font></td>
             	<td><font color="blue">ʡ���ſͻ������ж϶Լ��ſͻ�Ӫ�����Ӱ��;<br/>
						     ʡ֧�ŵ������������ж϶�ȫʡ������ģ�桢ǰ̨Ӫ�����������WAP���������ն�ҵ�������Ӱ��;<br/>
						     ���������ģ��ж϶�����ҵ�������Ӱ��;<br/>
						     �ͷ����ģ��ж϶�����ҵ�������Ӱ��;<br/>
						     ���й�˾���ж϶Ա�������ģ�桢ǰ̨Ӫ�����Ӱ��;<br/>
						  (�ı����޷���д�����ģ��Ը����ϴ�)<br/>
             	</font></td>
            </tr>
            <tr id="reason_explan2" style="display: none;">
             	<td class="td_font"><font color="red">��д˵����</font></td>
             	<td><font color="blue">1.Ӫ�����Ϣ������μ�������Ϣ����������ƣ�<br/>
									   2.����ģ�壺ģ������<br/>
									   3.���Žӿ���Ϣ�����߽ӿ�����<br/>
									   4.�����������նˡ�����������Ϣ������Ӫ������μ�������Ϣ�����뼰���ƣ����ʷ���Ϣ��BOSS�ʷ�ID���ʷ����ƣ�<br/>
									   (�ı����޷���д�����ģ��Ը����ϴ�)<br/>
             	</font></td>
            </tr>
            <tr id="reason" style="display: block;">
                <td class="td_font">˵����</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="REASON" width="500" height="120"/><span class="font_red">*</span></td>
            </tr>
            <tr id="comment" style="display: none;">
                <td class="td_font">ע�ͣ�</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="COMMENT" width="300" height="60" visible="false"/></td>
            </tr>
            <tr align="right"><td><ai:button id="doSubmit" text="�ύ" onclick="doSubmit()"/></td></tr>
        </table>
        </ai:dbform>
</ai:contractframe>
<ai:contractframe id="wfCheckAddframe" contenttype="table" title="�Ӱ�" width="100%" allowcontract="true" frameclosed="true">
    <ai:contractitem><ai:button id="doSubmit" text="ѡ��Ӱ���" onclick="openSelectStaff()"/></ai:contractitem>
    <ai:dbform formid="wfCheckAddForm" 
        onvalchange="" initial="false"
        setname="com.asiainfo.sale.common.web.SETFWOperate">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr id="staffs">
                <td class="td_font">�Ӱ��ˣ�</td>
                <td><ai:dbformfield formid="wfCheckAddForm" fieldname="STAFFS" width="260"/><img id="bt_selectAddStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectAddStaff();" align="absmiddle" style="cursor:hand;"/></td>
            </tr>
            <tr id="reason" style="display: none">
                <td class="td_font">˵����</td>
                <td><ai:dbformfield formid="wfCheckAddForm" fieldname="REASON" width="260" height="60"/></td>
            </tr>
        </table>
    </ai:dbform>
    <div class="area_button">
   <ai:button text="�Ӱ�" id="queryB" onclick="AssignJB()" />&nbsp;&nbsp;
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
    var wfId = "<%=request.getParameter("workflowId")%>";
    var count_WfCheckFormFlash = 0;
    var messageType = '';
    var org_selected = '';
    var IsHasTicket = false;
    
    function _fromWfCheckFormRowSet(){
        return g_FormRowSetManager.get("wfCheckForm");
    }
    
    function initCheckPage(){
        _fromWfCheckFormRowSet().refreshListBox("RESULT","templateCode="+templateCode+"&taskId="+taskId,true);
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
        //���������˻�ǩ����Ϣ
       if(roleId == "-2" && "finish" != taskType){
            title_staff = "��һ���ڴ����ˣ�";
            document.getElementById("inner_staffs").innerHTML = title_staff;
            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?org_id=1001&orgId="+g_GetUserInfo().ORG_ID;
            style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:670px";
        } else if ("sign" == taskType && roleId != "-2") {
        	title_staff = "��һ���ڻ�ǩ�ˣ�";
            document.getElementById("inner_staffs").innerHTML = title_staff;
            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s.jsp?org_id=10&orgId="+g_GetUserInfo().ORG_ID;
            style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:670px";
        } else if("finish" != taskType && ("" == roleId || "null" == roleId )){
            title_staff = "��һ���ڴ����ˣ�";
            document.getElementById("inner_staffs").innerHTML = title_staff;
            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?org_id=10&orgId="+g_GetUserInfo().ORG_ID;
            style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:670px";
        } else if("-1" == roleId || "sign" == thisTaskType || "finish" == taskType) {
            isShow_staff = false;
            document.getElementById("staffs").style.display = "none";
        } else {
            title_staff = "��һ���ڴ����ˣ�";
            document.getElementById("inner_staffs").innerHTML = title_staff;
            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s1.jsp?roleId="+roleId+"&orgId="+orgId;
            style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:550px;dialogWidth:430px";
        }
        if((taskTag == 'pcss001' || taskTag == 'pcss007' || taskTag == 'pcss004' || taskTag == 'ppcss001' || taskTag == 'ppcss007' || taskTag == 'ppcss004') 
        		&& result == "default") {
	        	title_staff = "��һ���ڻ�ǩ�ˣ�";
	            document.getElementById("inner_staffs").innerHTML = title_staff;
	            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ro.jsp?org_id=10&roleId=103419";
	            style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:670px";
	    		//��ǩ����Ĭ����Ա
	            initAsignPe();
	    }
        
        if ((taskTag == 'ppsss004' || taskTag == 'psss004') && result == "default") {
        		title_staff = "��һ���ڻ�ǩ�ˣ�";
	            document.getElementById("inner_staffs").innerHTML = title_staff;
	            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ro.jsp?org_id=10&roleId=103419";
	            style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:670px";
	            var defaultOpIds = "20004983;20005110;20005059";
	            var defaultOpStaffs = "�ӹ���;����;������";
	            _fromWfCheckFormRowSet().setValue("STAFFS", defaultOpIds, defaultOpStaffs);
        }
        
        if (taskTag == 'ppsss010' || taskTag == 'psss010') {
        	   var defaultOpIds = "20004983;20005110;20005059";
	           var defaultOpStaffs = "�ӹ���;����;������";
	           document.getElementById("a_appriseEmp").value = defaultOpStaffs;
	           a_appriseEmp = defaultOpIds;
        }
        
        if (taskTag.indexOf("Sign005")) {
        	document.getElementById("reason_explan2").style.display = "block";
        	var checkRet = PostInfo(_gModuleName + '/business/com.asiainfo.stopSelling.web.StopSellMAction?action=checkIsDispacher&taskId=' + taskRecordId);
        	if ("Y" == checkRet.getValueByName("FLAG")) {
	        	document.getElementById("inner_staffs").innerHTML = "��ͣ�۴���";
	        	document.getElementById("staffs").style.display = "block";
	        	document.getElementById("result").style.display = "none";
	        	url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?org_id=10";
        		style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:670px";
        	}
        }
        
        document.getElementById("_assistEmp").style.display = "block";
	    document.getElementById("_appriseEmp").style.display = "block";
	    if (taskTag == 'pcssSign003' || taskTag == 'ppcssSign003'){
	    	document.getElementById("reason_explan1").style.display = "block";
	    }
    }
    
    function initAsignPe() {
    	var asignPerson = [{"orgid":1001,"opid":20004983,"name":"�ӹ���"},
							{"orgid":1004,"opid":20005110,"name":"����"},
							{"orgid":1003,"opid":20005059,"name":"������"},
							{"orgid":13,"opid":20005661,"name":"�ܵ��"},
							{"orgid":15,"opid":20004500,"name":"��С��"},
							{"orgid":25,"opid":20006320,"name":"��ǿ"},
							{"orgid":12,"opid":20005984,"name":"Ң־��"},
							{"orgid":23,"opid":20005464,"name":"��ƽ"},
							{"orgid":20,"opid":20005355,"name":"�ղ���"},
							{"orgid":16,"opid":20005918,"name":"����"},
							{"orgid":24,"opid":20005755,"name":"����"},
							{"orgid":11,"opid":20006360,"name":"л��"},
							{"orgid":19,"opid":20007385,"name":"������"},
							{"orgid":17,"opid":20005605,"name":"�����"},
							{"orgid":26,"opid":20007394,"name":"����"},
							{"orgid":14,"opid":20004446,"name":"�ŷ�Դ"},
							{"orgid":18,"opid":20004897,"name":"������"},
							{"orgid":27,"opid":20003610,"name":"������"},
							{"orgid":28,"opid":20009717,"name":"ë����"}]
		var propOrg = stopSellMainForm.getValue("ORG_ID").substr(0,2);
    	var opId = asignPerson[0].opid;
    	var opName = asignPerson[0].name;
    	for (var i=1; i < 19; ++i) {
    		if (taskTag == 'pcss004' ||��taskTag == 'ppcss004')��{
    			opId += ";"+asignPerson[i].opid;
	    	    opName += ";"+asignPerson[i].name;
    		} else {
	    		if (asignPerson[i].orgid != propOrg) {
	    			opId += ";"+asignPerson[i].opid;
	    			opName += ";"+asignPerson[i].name;
	    		}
    		}
    	}
    	var text=document.getElementById("FormRowSet_wfCheckForm_STAFFS").childNodes;
    	text[0].style.width=800;
    	//alert(text.style.width);
	    _fromWfCheckFormRowSet().setValue("STAFFS", opId, opName);
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
            return alert("���̱��Ϊ�գ���ˢ�º����ԣ�");
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
            alert("��������Ϊ��");
            _fromWfCheckFormRowSet().setFocus("RESULT");
            return;
        }
        var staffId = _fromWfCheckFormRowSet().getValue("STAFFS");
        if (isShow_staff && (null == staffId || "" == staffId))
        {
            alert(title_staff + "Ϊ��");
            _fromWfCheckFormRowSet().setFocus("STAFFS");
            return;
        }
        var reason = _fromWfCheckFormRowSet().getValue("REASON");
        if (taskTag == 'pcssSign003' || taskTag == 'pcssSign005' || taskTag == 'ppcssSign003' || taskTag == 'ppcssSign005'){
        	
        	if (null == reason || trim(reason).length < 3) {
            	alert("�밴Ҫ����д�����ݲ���̫�̣�");
           		_fromWfCheckFormRowSet().setFocus("REASON");
            	return;
        	}
        }
        reason = displaytxt+"|"+reason;
        var comment = _fromWfCheckFormRowSet().getValue("COMMENT");
        
        if(!a_send()){
            return;   
        }
        
        if (nextTaskTag.indexOf("Sign005") != -1) {
        	var staffL = staffId.split(";");
        	for (var ac=0; ac<staffL.length; ++ac) {
        		staffId += ";000";
        	}
        }
        var strUrl = _gModuleName + '/business/com.asiainfo.stopSelling.web.StopSellMAction?action=finishUserTask&taskId=' + taskId
                    + "&result=" + result
                    + "&staffId=" + staffId
                    + "&reason=" + reason.replace(/%/g,"^#")
                    + "&comment=" + comment
                    + "&taskType=" + taskType
                    + "&templateCode=" + templateCode
                    + "&flowType=" + flowType
                    + "&mainId=" + _mainId
                    + "&wfId=" + wfId
                    + "&taskTag=" + taskTag
                    + "&nextTaskTag=" + nextTaskTag;
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
         return alert("��ѡ��Ӱ���");
     }
     
     var strUrl = "<%=request.getContextPath()%>/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=reAuthorizeTask&taskId="+taskRecordId + "&nextStaffId="+nextStaffId;      
     
     var recode = PostInfo(strUrl);
     if ("Y" == recode.getValueByName("FLAG"))
     {
         alert("�Ӱ��ύ�ɹ�");
         
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
 </html>