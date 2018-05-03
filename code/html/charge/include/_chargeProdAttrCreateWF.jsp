<%@ page contentType="text/html; charset=GBK"%>
<div class="area_button" id="div_createWorkflow">
    <ai:dbform formid="wfCheckForm" 
        onvalchange="onValChange" initial="false"
        setname="com.asiainfo.workflow.util.web.SETFWOperate">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr id="result" style="display: block;">
                <td class="td_font">����������</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="RESULT" width="260"/></td>
            </tr>
            <tr id="staffs" style="display: block;">
                <td id="inner_staffs" class="td_font">��һ���ڴ����ˣ�</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="STAFFS" width="260" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
<%--                <ai:button id="clearstaff" text="���" onclick="clearstaff()"/>--%>
                </td>
            </tr>
        </table>
           <div class="area_button"><ai:button id="bt_createWorkflow" text="�ύ���" onclick="doWork('createWorkflow()')"/></div>
        </ai:dbform>
</div>
<script type="text/javascript">

    if("" == _templateCode || "" == _flowType){
        alert("������ز���ȱʧ����ˢ�º����ԡ�");
    }
    
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
        var resultInfo = _fromWfCheckFormRowSet().getValue("RESULT");
        var array = resultInfo.split("~");
        var taskType = array[0];
        var result = array[1];
        var userType = array[2];
        var roleId = array[3];
        var userId = array[4];
        
        var orgId = g_GetUserInfo().ORG_ID.substr(0,2);
        if ("sign" == taskType) {
            title_staff = "��ǩ�ˣ�";
            document.getElementById("inner_staffs").innerHTML = title_staff;
            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s.jsp?org_id=10&orgId="+g_GetUserInfo().ORG_ID;
            style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:670px";
        } else {
            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s1.jsp?roleId="+roleId+"&orgId="+orgId;
            style_selectStaff = "scroll:no;resizable:no;help:no;status:no;dialogHeight:350px;dialogWidth:320px";
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
    	_mainId = frmProdExtTest.getValue("APPLY_ID");
    	
    	if(("chargeCaseT" == _flowType || "chargeCase" == _flowType) && !addYOrN()){
           return;
        }
        if (null == _mainId || "" == _mainId)
        {
            alert("���뵥���Ϊ��,���ȱ�����浥���ύ��ˣ�");
            return;
        }
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
            alert("�����˲���Ϊ��");
            return;
        }
        if ("saleCaseT" == _flowType || "saleCase" == _flowType || "saleCaseI" == _flowType) {
        	
        	var chechExplanUrl =  _gModuleName + '/business/com.asiainfo.sale.activity.web.SalePageCheck?action=checkExplantStatistic&mainId=' + _mainId;
        	var rt = PostInfo(chechExplanUrl);
        	if ("N" == rt.getValueByName("FLAG"))
	        {
	            alert("�뵽������Ϣҳ����д�������ҵ����˷�����,�����棡");
	            return;
	        }
        	//return alert(window.parent.getExplanStatisticValue());
        	//getTabitem("activityTab","activity_3").contentWindow.include_refreshSaleMainForm(mainId);
        	//if (getTabitem("activityTab","activity_3").contentWindow._include_fromSaleMainExplanFormRowSet().getValue("BUSINESSCHECKPLAN") == "") {
        		//return alert("�뵽������Ϣҳ����д�������ҵ����˷�����");
        	//}
	        var checkUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.SaleMainAction?action=checkEitACT&mainId=' + _mainId;
	        var ret = PostInfo(checkUrl);
	        if ("N" == ret.getValueByName("FLAG"))
	        {
	            alert("��������Ӿ��뵽Ӫ�������Ϣҳ����д����ȯ��浥");
	            return;
	        }
        }
        
        var strUrl = _gModuleName + '/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=createWorkflow&mainId=' + mainId+"&staffId="+staffId+"&flowType="+_flowType+"&result="+result;
        
        var recode = PostInfo(strUrl);
        if ("Y" == recode.getValueByName("FLAG"))
        {
            alert("�ύ��˳ɹ�");
            if("chargeCaseT" == _flowType || "chargeCase" == _flowType){
            	//window.opener.queryChargeMain();
            	window.location.reload();
            }else if("prestoreCase" == _flowType){
            	//var url ="<%=request.getContextPath()%>/sale/prestore/prestoreAddInfo.jsp" 
                //window.location.href = url;   
                window.location.reload();         		
            } 
            else {
                window.parent.resetTabitem(mainId);
            }
        } else {
            alert(recode.getValueByName("MESSAGE"));
        }
    }

function clearstaff(){
	_fromWfCheckFormRowSet().setValue("STAFFS","");
}
</script>