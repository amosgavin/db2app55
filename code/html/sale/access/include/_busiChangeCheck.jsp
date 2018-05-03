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
             <tr id="addate_tr" style="display: none;">
            	<td class="td_font">��һ���������ʱ�䣺</td>
            	<td><ai:dbformfield formid="wfCheckForm" fieldname="ADVISE_FINISHDATE" width="100" />
            	</td>
            </tr>
            <tr id="currentTask_tr" style="display: none;">
            	<td class="td_font">��ǰ�������ʱ�䣺</td>
            	<td><ai:dbformfield formid="wfCheckForm" fieldname="CURRENT_TASK_FINISH_DATE" width="100" />
            	<a href="#" onclick="window.open('<%=request.getContextPath()%>/sale/common/include/_delayReason.jsp?itemId='+_mainId+'&taskTag='+'<%=request.getParameter("taskTag")%>','_blank','toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');">
            	<span id="sp_delay" style="font-family:��������; color:red; "></span></a> </td>
            </tr>
            <tr id="reason" style="display: block;">
                <td class="td_font">˵����</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="REASON" width="300" height="60"/></td>
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
    var count_WfCheckFormFlash = 0;
    var messageType = '';
    var org_selected = '';
    var IsHasTicket = false;
    var dq_kf = PostInfo(_gModuleName + '/business/com.asiainfo.sale.access.web.BusiChangeAction?action=checkdq_kf&busiId=' + _mainId);
    var Is_Dq_Kf=dq_kf.getValueByName("DQ_KF");
    
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
        if (pFieldName == 'STAFFS') {
       		var resultInfo = _fromWfCheckFormRowSet().getValue("RESULT");
      	    var array = resultInfo.split("~");
            var nextTaskTag = array[7];
        	if (nextTaskTag == 'busi013') {
	        	document.getElementById("addate_tr").style.display = "block";
			    //_fromWfCheckFormRowSet().setColEditSts("ADVISE_FINISHDATE", false);
	 			var taskReceiver = _fromWfCheckFormRowSet().getValue("STAFFS");
				var ret = PostInfo(_gModuleName + '/business/com.asiainfo.common.web.ItemOtherInfoAction?action=getAdDateInGeneral&itemId=' + _mainId + "&itemType=" + flowType + "&taskTag=" + nextTaskTag + "&needDays=3");
	        	if (ret.getValueByName("FLAG") == 'N') {
	        		alert(ret.getValueByName("MESSAGE"));
	        	} else {
	        		_fromWfCheckFormRowSet().setValue("ADVISE_FINISHDATE", ret.getValueByName("advDate").substr(0,10));
	        	}
            } else {
            	document.getElementById("addate_tr").style.display = "none";
            }
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
	            
	            //url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?roleId="+roleId+"&orgId="+orgId;
	            //style_selectStaff = "scroll:no;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px";
            }
        //document.getElementById("tr_notice").style.display = "none";
        document.getElementById("_assistEmp").style.display = "block";
	    document.getElementById("_appriseEmp").style.display = "block";
        //alert(messageType);
        //if("sign" != thisTasType){
        //alert(templateCode + '----' + taskTag);
        if (taskTag == 'busi007' || taskTag == 'busi010'){
        	document.getElementById("tr_notice").style.display = "block";
        }//��ʡ��˾������    ����������  �а������ 
<%--        if (((taskTag == 'busi007' || taskTag == 'busi010') && messageType == 'ʡҵ֧��������') || taskTag == 'busi021') {--%>
<%--			//|| netBusiChangeTab.getTotalRowCount() > 0--%>
<%--        	if (saleBusiChangeTab.getTotalRowCount() > 0 || netBusiChangeTab.getTotalRowCount() > 0) {--%>
<%--				_fromWfCheckFormRowSet().setValue("STAFFS", '20004983', '�ӹ���');--%>
<%--			} else {--%>
<%--				_fromWfCheckFormRowSet().setValue("STAFFS", '20004952', 'ë����');--%>
<%--			}--%>
<%--		}--%>
<%--		var applyCity = taskRecordId.substr(3,2);--%>
<%--		if (taskTag == 'busi008' || taskTag == 'busi024') {--%>
<%--			if (saleBusiChangeTab.getTotalRowCount() > 0 || netBusiChangeTab.getTotalRowCount() > 0) {--%>
<%--				if (applyCity == '10' || applyCity == '11' || applyCity == '17' || applyCity == '13' || applyCity == '14') {--%>
<%-- 				  _fromWfCheckFormRowSet().setValue("STAFFS", '20004938', '��Ө');--%>
<%--	 			} else if (applyCity == '26' || applyCity == '15' || applyCity == '24') {--%>
<%--	 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004931', '���');--%>
<%--	 			} else if (applyCity == '25' || applyCity == '20' || applyCity == '16' || applyCity == '18') {--%>
<%--	 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004946', '���');--%>
<%--	 			}  else  {--%>
<%--	 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004947', '����');--%>
<%--	 			}--%>
<%--			} else {--%>
<%--				if (applyCity == '10') {--%>
<%--	 				_fromWfCheckFormRowSet().setValue("STAFFS", '20007430', '��ξ');--%>
<%--	 			} else if (applyCity == '11' || applyCity == '17' || applyCity == '13' || applyCity == '14') {--%>
<%--	 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004934', 'Ф��');--%>
<%--	 			} else if (applyCity == '26' || applyCity == '15' || applyCity == '24') {--%>
<%--	 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004916', 'Ф��');--%>
<%--	 			} else if (applyCity == '12' || applyCity == '19' || applyCity == '23') {--%>
<%--	 				_fromWfCheckFormRowSet().setValue("STAFFS", '20007430', '��ξ');--%>
<%--	 			} else  {--%>
<%--	 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004919', '����');--%>
<%--	 			}--%>
<%--			}--%>
<%--		}--%>
       if (((taskTag == 'busi007' || taskTag == 'busi010') && messageType == 'ʡҵ֧��������') || taskTag == 'busi021') {
       		if (saleBusiChangeTab.getTotalRowCount() > 0 || netBusiChangeTab.getTotalRowCount() > 0) {
       							if (Is_Dq_Kf == "dq") {
													_fromWfCheckFormRowSet().setValue("STAFFS", '20004983', '�ӹ���');
										} else if (Is_Dq_Kf == "kf") {
													_fromWfCheckFormRowSet().setValue("STAFFS", '20005008', '�ƻ�');
										}
       		}else{
       			_fromWfCheckFormRowSet().setValue("STAFFS", '20004952', 'ë����');
       		}
			
		}
		if (taskTag == 'busi013') {
			document.getElementById("currentTask_tr").style.display = "block";
	 		_fromWfCheckFormRowSet().setColEditSts("CURRENT_TASK_FINISH_DATE", false);
	 		var ret = PostInfo(_gModuleName + '/business/com.asiainfo.common.web.ItemOtherInfoAction?action=getAdDateInGeneral&itemId=' + _mainId + "&taskTag=" + taskTag);
        	if (ret.getValueByName("FLAG") == 'Y') {
        		_fromWfCheckFormRowSet().setValue("CURRENT_TASK_FINISH_DATE", ret.getValueByName("advDate").substr(0,10));
        		var advDate = ret.getValueByName("advDate").substr(0,10);  
				advDate = advDate.replace(/-/g,"/");//�滻�ַ�����ɱ�׼��ʽ  
				var d2=new Date();//ȡ���������  
				var d1 = new Date(Date.parse(advDate));
				if (d1 < d2 ) {
					document.getElementById("sp_delay").innerHTML='�����Ѿ���ʱ������д��ʱԭ��(�����ɫ���������д)*';
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
            return alert("���̱��Ϊ�գ���ˢ�º����ԣ�");
        }
        var resultTmp = _fromWfCheckFormRowSet().getValue("RESULT");
        var displaytxt = _fromWfCheckFormRowSet().getDisplayText("RESULT");
        if (taskTag == 'busi007' || taskTag == 'busi010'){
        	if (checkChargeType()) {
	        	 var checkRet = PostInfo(_gModuleName + '/business/com.asiainfo.sale.access.web.BusiChangeAction?action=isHasTicketChange&busiId=' + _mainId);
	        	 if ("true" == checkRet.getValueByName("HasTicket") && displaytxt != 'ͬ�⣬�������������ģ��漰����ȯ��ҵ������' && displaytxt != '��ͬ�⣬�˻ط�����') {
		        	 alert("���е���ȯ����Դ׷�ӣ��뷢���������ģ�");
		        	 if(!confirm("��ȷ��Ҫ�ύ��")){
		        		 return;
		        	 }
        	 	}	
	        } else {
	        	if (displaytxt == 'ͬ�⣬�������������ģ��漰����ȯ��ҵ������') {
	        		if(!confirm("���漰����ȯ����Դ׷�ӡ�ʱ���ӳ�����Ҫ�������������ģ���ȷ��Ҫ�ύ��")){
		        		 return;
		        	 }
	        	}
	        }
        }
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
        if ((taskTag.substr(0,1)).toUpperCase() == 'S'){
        	
        	if (null == reason || trim(reason).length < 3) {
            	alert("��ǩ�����С��3���֣�");
           		_fromWfCheckFormRowSet().setFocus("REASON");
            	return;
        	}
        }
        
        if (nextTaskTag == 'busi013') {
        	var advDate = _fromWfCheckFormRowSet().getValue("ADVISE_FINISHDATE");
        	if (advDate != "") {
        		var ret = PostInfo(_gModuleName + '/business/com.asiainfo.common.web.ItemOtherInfoAction?action=saveItemOtherInfo&itemId=' + _mainId+"&advDate="+advDate + "&taskTag=" + nextTaskTag);
        		if (ret.getValueByName("FLAG") == "N") {
        			return alert("�ύʧ�ܣ�");
        		}
        	}
        }
        
        reason = displaytxt+"|"+reason;
        var comment = _fromWfCheckFormRowSet().getValue("COMMENT");
        if (null == comment || "" == comment)
        {
            //alert("���뵥���Ϊ��");
            //_fromWfCheckFormRowSet().setFocus("COMMENT");
            //return ;
        }
        
		//**R130614014-����֪��ͻ�������������(�ڷ������ù������ڣ�ϵͳ�Զ�֪��ʡ�ͷ�������ۣ�20005100 | yanghui)
        //��ҵ��������(template.BusichangeFlow): busi008-ʡҵ֧�������� , busi024-ʡҵ֧��������
        if (taskTag == 'busi008' || taskTag == 'busi024'){
        	if ("false" != result) {
        		if (a_appriseEmp != '') {
	        		a_appriseEmp += ';20005100';
        		} else {
        			a_appriseEmp = '20005100';
        		}
        	}
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
		//alert(strUrl);
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
     if (taskTag == 'busi013') {
        	PostInfo(_gModuleName + '/business/com.asiainfo.common.web.ItemOtherInfoAction?action=reComputeAdviseDate&itemId='+_mainId+"&itemType="+flowType+"&node=pz"+"&taskTag="+taskTag+"&reAuthorOpid="+nextStaffId);
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
 <div id="fujian">
<%@include file="/sale/access/include/_busiChangeAttach.jsp"%>
 </div>
 </html>