<%@ page contentType="text/html; charset=GBK"%>

<div id="wf_div" style="display: block">
<ai:contractframe id="wfCheckframe" contenttype="table" title="�����Ϣ" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <ai:dbform formid="appriseForm" 
            setname="com.asiainfo.sale.tag.web.SETApproveColumn"
            conditionname="condition" parametersname="parameters"
            onvalchange="" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
            <tr id='_assistEmp'><td class="td_font">ѡ��Э���ˣ�</td>
                <td><input type="text" id="a_assistEmp" style="width: 260px;"/>
                    <img id="selectStaff1" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="a_assistEmpSelect();" align="middle" style="cursor:hand;"/>
                </td></tr>
            <tr id='_appriseEmp'><td class="td_font"><i18n:message key="SOS0100102" res="CRM" /></td>
                <td><input type="text" id="a_appriseEmp" style="width: 260px;"/>
                    <img id="selectStaff1" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="a_appriseEmpSelect();" align="middle" style="cursor:hand;"/>
                </td>
            </tr>
        </table>
    </ai:dbform>
    <ai:dbform formid="wfCheckForm" 
        onvalchange="onValChange" initial="false"
        setname="com.asiainfo.workflow.util.web.SETFWOperate">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr id="tr_notice" style="display: none;">
                <td colspan="2"><span class="font_red">�����ڵ���ȯ����ѡ�񷢻��������Ĵ���</span></td>
            </tr>
            <tr id="bt_selectMessageDep" style="display: none;">
                <td class="td_font" colspan="1"><ai:button id="doSubmit" text="ѡ�񷢲�����" onclick="selectMessageDep()"/></td>
            	<td><span class="font_red">(�ʷ�/Ӫ�����������Ҫ��֪�Ĳ���)</span></td>
            </tr>
            <tr id="bt_modifyMessageDep" style="display: none;">
                <td class="td_font" colspan="1"><ai:button id="doSubmit" text="�޸ķ�������" onclick="modifyMessageDep()"/></td>
            	<td><span class="font_red">(�ʷ�/Ӫ�����������Ҫ��֪�Ĳ���)</span></td>
            </tr>
            <tr id="bt_selectMessageDepStaff" style="display: none;">
            	<td class="td_font">ѡ�񷢲���Ա��</td>
                <td><input type="text" id="a_publishEmp" style="width: 260px;"/><img id="selectStaff1" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectMessageDepStaff();" align="middle" style="cursor:hand;"/><span class="font_red">*</span>
                <span class="font_red">(�ʷ�/Ӫ�����������Ҫ��֪����Ա)</span></td>
            </tr>
            <tr id="bt_selectMessageDepStaff_S" style="display: none;">
                <td class="td_font" colspan="1"><ai:button id="doSubmit" text="ѡ��֪�Ჿ��Ա��" onclick="selectMessageDepStaff(false)"/>
                                                <!-- <ai:button id="doSubmit" text="ѡ����첿��Ա��" onclick="selectWorkDepStaff(false)"/> -->
                </td>
            </tr>
            <%--
            <tr>
              <td class="td_font">����ѡ��</td>
              <td>
	                                    ͬ��(Ĭ��)<input type="radio" id="auditFlag" name="audit" value="ok"  checked="checked" onclick="autoSelectYes()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    		    ��ͬ��<input type="radio" id="auditFlag" name="audit" value="no" onclick="autoSelectNo()"></td>
            </tr>
            --%>
            <tr id="result" style="display: block;" onmouseover="">
                <td class="td_font">����������</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="RESULT" width="260"/></td>
            </tr>
            <tr id ="jh_tr" style="display: none;">
             <td></td><td colspan="2"><span class="font_red">���������š�Ǳ����Ӫ�������Ҫ���������ֹ�˾���г������λ�ǩ��</span></td></tr>
            <tr id="staffs" style="display: block;">
                <td id="inner_staffs" class="td_font">��һ���ڴ����ˣ�</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="STAFFS" width="260" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
<%--                <ai:button id="clearstaff" text="���" onclick="clearstaff()"/>--%>
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
                <td><ai:dbformfield formid="wfCheckForm" fieldname="REASON" width="260" height="60"/></td>
            </tr>
            <tr id="comment" style="display: none;">
                <td class="td_font">ע�ͣ�</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="COMMENT" width="260" height="60" visible="false"/></td>
            </tr>
            <tr id="attach_cfg_tr" style="display: none;">
            	 <td class="td_font">�Ƿ񷢵�������: </td>
                 <td><select id="attachCfgSelect">
						  <option>��</option>
						  <option>��</option>
						</select>
    		    <span class="font_red">*��ѡ(ѡ���ǡ�������д�������ģ�沢�ϴ�)</span></td>
            </tr>
            <tr id="attach_cfg_1" style="display: none;">
            	<td class="td_font">����ģ�棺</td><td><a href="javascript:downTemplate(4)"><span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:blue; ">ҵ���������.xlsx</span></a></td></tr>
            <tr id="attach_cfg_2" style="display: none;">
            	<td class="td_font">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	</td><td><a href="javascript:downTemplate(5)"><span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:blue; ">�����ػ�����.xlsx</span></a></td></tr>
            <tr id="attach_cfg_3" style="display: none;">
            	<td class="td_font">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	</td><td><a href="javascript:downTemplate(6)"><span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:blue; ">�ײͲ�ѯ����.xlsx</span></a></td></tr>
            <tr></tr>
            <tr id="logSale_bossid" style="display: none;">
            	<td class="td_font">��д/�޸�bossid��</td>
            	<td><a href="#" onclick="window.open('<%=request.getContextPath()%>/sale/activity/include/_loggingBossid.jsp?orderId='+_mainId,'_blank','toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');">
            	<span style="font-family:��������; color:red; ">>>>>>>>>>>>>GO!(�����)</span></a> 
            	</td>
            </tr>
            <tr id="logCharge_bossid" style="display: none;">
            	<td class="td_font">��д/�޸��ʷ�bossid��</td>
            	<td><a href="#" onclick="window.open('<%=request.getContextPath()%>/charge/include/_loggingBossid.jsp?mainId='+_mainId,'_blank','toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');">
            	<span style="font-family:��������; color:red; ">>>>>>>>>>>>>GO!(�����)</span></a> 
            	</td>
            </tr>
            <tr></tr>
            <tr></tr>
            <tr id="Tosure" style="display: none;">
            	<td colspan=3><span class="font_red" style="font-size:15px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��ȷ���Ƿ񱣴���Ա�������ύ��</span></td>
            </tr>
           <tr></tr>
           <tr></tr>
            <tr><td colspan=2><span id="echnnl_re_mess" style="display: none;" class="font_red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ע��:�û�����������Ҫ���С�����ָ�����,����Ҫ����,���ڡ�Ӫ�����Ҫ��Ϣ��ҳ���������</span></td></tr>
            <tr align="right" colspan=2><td ><ai:button id="doSubmit" text="�ύ" onclick="doSubmit()"/></td></tr>
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
</div>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/DBListBox.js"></script>
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
    var IsHasSpareTag = false;
    var needWPTestAudit = false;
    var saleMainType = '';
    
    function _fromWfCheckFormRowSet(){
        return g_FormRowSetManager.get("wfCheckForm");
    }
    
    function initCheckPage(){
    	if (taskTag == 't05' || taskTag == 't09' || taskTag == 'p02' || taskTag == 'p28' || taskTag == 'I009' || taskTag == 'I010') {
        	 var checkTagRet = PostInfo(_gModuleName + '/business/com.asiainfo.sale.activity.web.SaleOrderAction?action=isHasSpareTag&orderId=' + _mainId);
        	 _fromWfCheckFormRowSet().clearListBox("RESULT");
        	 if ("Y" == checkTagRet.getValueByName("FLAG")) {
	        	 IsHasSpareTag = true;
				_fromWfCheckFormRowSet().addListBoxElement("RESULT" ,"user~default~staff~103809~:staff~����˰��~autodecision~su105~127~������˰�ʣ�������Ҫ���ã�~user", "ͬ��,������˰��");
		        _fromWfCheckFormRowSet().addListBoxElement("RESULT" ,"sign~hq~staff~-1~:staff~ʡ��˾�г�����ǩ~autodecision~sign02~24~�����ǩ~sign", "�����ǩ");
				_fromWfCheckFormRowSet().addListBoxElement("RESULT" ,"user~false~staff~-1~:staff01~AE~autodecision~t08~14~��ͬ�⣬�������з������޸�~user", "��ͬ��,�������޸�");
        	 } else {
	        	_fromWfCheckFormRowSet().addListBoxElement("RESULT" ,"user~pz~staff~-1~:staff04~����ָ��������~autodecision~t0001~44~���������û~user", "ͬ��,�����û");
		        _fromWfCheckFormRowSet().addListBoxElement("RESULT" ,"sign~hq~staff~-1~:staff~ʡ��˾�г�����ǩ~autodecision~sign02~24~�����ǩ~sign", "�����ǩ");
				_fromWfCheckFormRowSet().addListBoxElement("RESULT" ,"user~false~staff~-1~:staff01~AE~autodecision~t08~14~��ͬ�⣬�������з������޸�~user", "��ͬ��,�������޸�");
        	 }
        } else {
        	_fromWfCheckFormRowSet().refreshListBox("RESULT","templateCode="+templateCode+"&taskId="+taskId,true);
        }
        _fromWfCheckFormRowSet().setFocus("RESULT");
        pageSet();
        //��Ʒ������Ӹ���
        if(flowType!="productCase"){
        	include_reflashAttachTable();
        }else{
        	document.getElementById("fujian").style.display="none";
        }
        //if (taskTag == 'C27' || taskTag == 'PC008' || taskTag == 'PC010' || taskTag == 'PC011') {
        if (taskTag == 'PC041' || taskTag == 'PC015' || taskTag == 'PC040' || taskTag == 'C040'|| taskTag == 'C031' || taskTag == 'C041') {
			document.getElementById("Tosure").style.display="block";
		}
        if (taskTag == 'wp02' || taskTag == 'su105' || taskTag == 'su106') {
        	document.getElementById("tagDeploy_div").style.display="block";
        	document.getElementById("contractFrame_saleMainOverviewframe").style.display="none"
        }
        //AIContractFrame_OpenClose("attachFrame");
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
            if (nextTaskTag == 'PC041' || nextTaskTag == 'PC015' || nextTaskTag == 'C041' || nextTaskTag == 'C031'
            		|| nextTaskTag == 't15' || nextTaskTag == 't0003' || nextTaskTag == 't0023' 
            		|| nextTaskTag == 'p52' || nextTaskTag == 'p05' || nextTaskTag == 'p14' || taskTag == 'wp01') {
            	document.getElementById("addate_tr").style.display = "block";
			    //_fromWfCheckFormRowSet().setColEditSts("ADVISE_FINISHDATE", false);
	 			var taskReceiverOpid = _fromWfCheckFormRowSet().getValue("STAFFS");
	 			if (taskReceiverOpid == null || taskReceiverOpid == '') {
	 				return alert("��ѡ����Ա��");
	 			}
				var ret = PostInfo(_gModuleName + '/business/com.asiainfo.common.web.ItemOtherInfoAction?action=getAdDateInConf&itemId=' + _mainId + "&itemType=" + flowType + "&taskTag=" + nextTaskTag + "&taskReceiverOpid=" + taskReceiverOpid);
	        	if (ret.getValueByName("FLAG") == 'N') {
	        		_fromWfCheckFormRowSet().setValue("ADVISE_FINISHDATE", ret.getValueByName("advDate").substr(0,10));
	        		alert(ret.getValueByName("MESSAGE"));
	        	} else {
	        		_fromWfCheckFormRowSet().setValue("ADVISE_FINISHDATE", ret.getValueByName("advDate").substr(0,10));
	        	}
	        } else if (nextTaskTag == 'p17' || nextTaskTag == 'p54'
            		  || nextTaskTag == 'I019' || nextTaskTag == 'C27' || nextTaskTag == 'PC008') {
	        	document.getElementById("addate_tr").style.display = "block";
			    _fromWfCheckFormRowSet().setColEditSts("ADVISE_FINISHDATE", false);
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
        if (taskTag == 't0014' || taskTag == 'p06' || taskTag == 'I016'){
        	 var checkRet = PostInfo(_gModuleName + '/business/com.asiainfo.sale.activity.web.SaleMainAction?action=hasEitInSale&orderId=' + _mainId);
        	 if ("Y" == checkRet.getValueByName("FLAG")) {
	        	 IsHasTicket = true;
        		_fromWfCheckFormRowSet().setValue("RESULT","�����������Ĳ��ž�����")
	        	resultInfo = 'user~hlw~staff~102210~:staff~�����������Ĳ��ž�����~autodecition';
        		_fromWfCheckFormRowSet().setColEditSts("RESULT",false);
        	}
        }
        var array = resultInfo.split("~");
        var taskType = array[0];
        var result = array[1];
        var userType = array[2];
        var roleId = array[3];
        var userId = array[4];
        messageType = array[5];
        var thisTaskType = array[6];
        var nextTaskTag = array[7];
        var orgId = g_GetUserInfo().ORG_ID.substr(0,2);
        
        if (nextTaskTag == 't03' && orgId == '29') {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20007720','����');
 			}
        
        if(taskTag == 'p09' && messageType == '���ɻ��������' || taskTag == 'p09' && messageType == '������������' 
        		|| taskTag == 't0005' && messageType == 'ʡҵ֧�����������' || taskTag == 't3001' && messageType == 'ʡҵ֧�����������'){
        	var saleMainType= PostInfo(_gModuleName + '/business/com.asiainfo.sale.activity.web.SaleMainAction?action=checksalemaintype&orderId=' + _mainId);
        	if("rtPerson" ==saleMainType.getValueByName("SALE_MAIN_TYPE")){
        		_fromWfCheckFormRowSet().setValue("STAFFS", '20004983', '�ӹ���');
        	}
        	else{
        		_fromWfCheckFormRowSet().setValue("STAFFS", '20005008', '�ƻ�');
        	}
        }
        
        if (taskTag == 't0007') {
        	 var checkWPTestRet = PostInfo(_gModuleName + "/business/com.asiainfo.sale.activity.web.SaleOrderAction?action=needWeaponTestAudit&workflowId=<%=request.getParameter("workflowId")%>");
        	 if ("Y" == checkWPTestRet.getValueByName("FLAG")) {
        		needWPTestAudit = true;
        	 }
        }
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
        document.getElementById("bt_selectMessageDep").style.display = "none";
        document.getElementById("bt_modifyMessageDep").style.display = "none";
        document.getElementById("bt_selectMessageDepStaff").style.display = "none";
        document.getElementById("bt_selectMessageDepStaff_S").style.display = "none";
        document.getElementById("tr_notice").style.display = "none";
        
        document.getElementById("_assistEmp").style.display = "block";
	    document.getElementById("_appriseEmp").style.display = "block";
	    
	    document.getElementById("a_assistEmp").disabled=true;
		document.getElementById("a_appriseEmp").disabled=true;

		if ((taskTag == 'C037' || taskTag == 't06' || taskTag == 'C012' || taskTag=='t0010') && (result == 'hq' || messageType == '�г��򼯿Ͳ���ǩ')){
	        document.getElementById("jh_tr").style.display = "block";
	    } else{
	    	document.getElementById("jh_tr").style.display = "none";
	    }
        //���Ʒ���
        if ('template.TownSaleCaseApprove' == templateCode){
        	
	        if (nextTaskTag == 't05'){
	            document.getElementById("bt_selectMessageDep").style.display = "block";
	        } else if (taskTag == 't05'||taskTag=='t0025'){
	            document.getElementById("bt_modifyMessageDep").style.display = "block";
	        } else if (taskTag == 't14' && messageType == '������ȷ��'){
	        	document.getElementById("_assistEmp").style.display = "none";
	        	document.getElementById("_appriseEmp").style.display = "none";
	            document.getElementById("bt_selectMessageDepStaff").style.display = "block";
	            document.getElementById("a_publishEmp").disabled=true;
	        } else {
                //document.getElementById("bt_selectMessageDepStaff_S").style.display = "block";
	        }
	        if (messageType.indexOf("N") > -1){
	            document.getElementById("tr_notice").style.display = "block";
	        }
        } else if ('template.InternetSaleCaseApprove' == templateCode){
        	
	        if (nextTaskTag == 'I009'){
	            document.getElementById("bt_selectMessageDep").style.display = "block";
	        } else if (taskTag == 'I009'){
	            document.getElementById("bt_modifyMessageDep").style.display = "block";
	        } else if (taskTag == 'I026' && messageType == '������ȷ��'){
	        	document.getElementById("_assistEmp").style.display = "none";
	        	document.getElementById("_appriseEmp").style.display = "none";
	            document.getElementById("bt_selectMessageDepStaff").style.display = "block";
	            document.getElementById("a_publishEmp").disabled=true;
	        } else if (taskTag == 'p07'){
	        	document.getElementById("_assistEmp").style.display = "none";
	        	document.getElementById("_appriseEmp").style.display = "none";
	            document.getElementById("bt_selectMessageDepStaff").style.display = "block";
	            document.getElementById("a_publishEmp").disabled=true;
        	} else {
                //document.getElementById("bt_selectMessageDepStaff_S").style.display = "block";
	        }
	        
	        if (messageType.indexOf("N") > -1){
	            document.getElementById("tr_notice").style.display = "block";
	        }
        } else if ('template.ProvinceSaleCaseApprove' == templateCode || 'template.ZqSaleFlow' == templateCode){
        	
        	if (nextTaskTag == 'p02' || nextTaskTag == 'p24'){
	            document.getElementById("bt_selectMessageDep").style.display = "block";
	        } else if (taskTag == 'p02' || taskTag == 'p24'){
	            document.getElementById("bt_modifyMessageDep").style.display = "block";
	        } else if (taskTag == 'p07'){
	        	document.getElementById("_assistEmp").style.display = "none";
	        	document.getElementById("_appriseEmp").style.display = "none";
	            document.getElementById("bt_selectMessageDepStaff").style.display = "block";
	            document.getElementById("a_publishEmp").disabled=true;
        	}
	    } else if ('template.TownChargeApplyFlow' == templateCode || 'template.NewTChargeFlow' == templateCode){
        	
	    	if (nextTaskTag == 'C014'){
	            document.getElementById("bt_selectMessageDep").style.display = "block";
	        } else if (taskTag == 'C014'){
	            document.getElementById("bt_modifyMessageDep").style.display = "block";
	        } else if (taskTag == 'C023' && messageType == '������ȷ��'){
	        	document.getElementById("_assistEmp").style.display = "none";
	        	document.getElementById("_appriseEmp").style.display = "none";
	            document.getElementById("bt_selectMessageDepStaff").style.display = "block";
	            document.getElementById("a_publishEmp").disabled=true;
	        } else {
                //document.getElementById("bt_selectMessageDepStaff_S").style.display = "block";
	        }
       
        } else if ('template.ProvinceChargeApplyFlow' == templateCode || 'template.NewPChargeFlow' == templateCode
        		   || 'template.ZqChargeFlow' == templateCode){
        	
        	if (taskTag == 'PC001' || 'zqs0009' == taskTag){
	            document.getElementById("bt_selectMessageDep").style.display = "block";
	        } else if (taskTag == 'PC002'){
	            document.getElementById("bt_modifyMessageDep").style.display = "block";
	        } else if (taskTag == 'PC022'){
	        	document.getElementById("_assistEmp").style.display = "none";
	        	document.getElementById("_appriseEmp").style.display = "none";
	            document.getElementById("bt_selectMessageDepStaff").style.display = "block";
	            document.getElementById("a_publishEmp").disabled=true;
        	}
        }
 		// ����Ӫ����bossid��д�޸�
 		//alert(g_FormRowSetManager.get("saleMainOverviewForm").getValue("SALE_MAIN_CODE"));
 		if ('template.TownSaleCaseApprove' == templateCode || 'template.InternetSaleCaseApprove' == templateCode 
 			|| 'template.ProvinceSaleCaseApprove' == templateCode || 'template.ZqSaleFlow' == templateCode){
 				
	 		if (g_FormRowSetManager.get("saleMainOverviewForm").getValue("SALE_MAIN_CODE") != '0000') {
	 			
		 		if (taskTag == 't15' || taskTag == 't0003' || taskTag == 't0023' || taskTag == 'I018' || taskTag == 'I021' || taskTag == 'p05' || taskTag == 'p14'){
		 			document.getElementById("logSale_bossid").style.display = "block";
		 		}
	 		}
 		}
 		
 		// �����ʷ�bossid��д�޸�
 		if ('template.TownChargeApplyFlow' == templateCode || 'template.ProvinceChargeApplyFlow' == templateCode){
 			
	 		//if (g_TableRowSetManager.get("chargeDetailListTable").getValue(0,"CASE") != '') {
	 			
		 		if (taskTag == 'C019' || taskTag == 'C031' || taskTag == 'PC007' || taskTag == 'PC015'){
		 			document.getElementById("logCharge_bossid").style.display = "block";
		 		}
	 		//}
 		}
 		if (taskTag == 'C041' || taskTag == 'PC041') {
 			document.getElementById("logCharge_bossid").style.display = "block";
 		}
 		
 		//ʡҵ֧Ĭ����Աѡ��
 		var applyCity = taskRecordId.substr(3,2);
 		if (taskTag == 'I023' || taskTag == 'I025' || (taskTag=='p04' && 'template.ProvinceChargeApplyFlow'==templateCode) || taskTag == 't3005') {
 			if (applyCity == '10' || applyCity == '11' || applyCity == '17' || applyCity == '13' || applyCity == '14') {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004938', '��Ө');
 			} else if (applyCity == '26' || applyCity == '15' || applyCity == '24') {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004931', '���');
 			} else if (applyCity == '25' || applyCity == '20' || applyCity == '16' || applyCity == '18') {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004946', '���');
 			}  else  {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004947', '����');
 			}
 		} 
 		if (taskTag == 'PC006' || taskTag == 'C018' || taskTag == 'wp01') {
 			if (applyCity == '10') {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20007430', '��ξ');
 			} else if (applyCity == '11' || applyCity == '17' || applyCity == '13' || applyCity == '14') {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004934', 'Ф��');
 			} else if (applyCity == '26' || applyCity == '15' || applyCity == '24') {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004916', 'Ф��');
 			} else if (applyCity == '12' || applyCity == '19' || applyCity == '23') {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20007430', '��ξ');
 			} else  {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004919', '����');
 			}
 		}
 		if (taskTag == 'PC041' || taskTag == 'PC015' || taskTag == 'C041' || taskTag == 'C031'
            		|| taskTag == 't15' || taskTag == 't0003' || taskTag == 't0023' 
            		|| taskTag == 'p52' || taskTag == 'p05' || taskTag == 'p14'
            		|| taskTag == 'p17' || taskTag == 'p54'
            		|| taskTag == 'I019' || taskTag == 'C27' || taskTag == 'PC008' || taskTag == 'wp02') {
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
 		
 		if ('template.NewTChargeFlow' == templateCode || 'template.NewPChargeFlow' == templateCode
 			|| 'template.ZqChargeFlow' == templateCode) {
 			
 			if (nextTaskTag == 'C040' || nextTaskTag == 'PC040') {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004937', '����');
 			}
 		}
 		
 		// �������̰������Ż��Ҫ��������
 		if ("template.TownSaleCaseApprove" == templateCode && "t03" == taskTag) {
 			var ret = PostInfo(_gModuleName + '/business/com.asiainfo.sale.activity.web.SaleOrderAction?action=checkHasGroupAct&orderId=' + _mainId);
        	if ("Y" == ret.getValueByName("FLAG") && "yes" == ret.getValueByName("hasGroupAct")) {
        		var listBox = FormRowSet_Field_DBListBox_getEditor(_fromWfCheckFormRowSet(),"RESULT");
				_fromWfCheckFormRowSet().setValue("RESULT",listBox.options[1].value);
        	}
        }
 		
 		if (taskTag == 'wp02') {
 			document.getElementById("attach_cfg_tr").style.display = "block";
 			document.getElementById("attach_cfg_1").style.display = "block";
 			document.getElementById("attach_cfg_2").style.display = "block";
 			document.getElementById("attach_cfg_3").style.display = "block";
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
    
    function selectMessageDep() {
        var url = "<%=request.getContextPath()%>/sale/promationTag/orgSelect.jsp?org_id=10&workflowId=<%=request.getParameter("workflowId")%>";
        var style = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:590px;dialogWidth:320px";
        org_selected = window.showModalDialog(url, null, style);
    }
    
    function modifyMessageDep() {
        var url = "<%=request.getContextPath()%>/sale/promationTag/orgModify.jsp?org_id=10&workflowId=<%=request.getParameter("workflowId")%>";
        var style = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:560px;dialogWidth:320px";
        window.showModalDialog(url, null, style);
    }
    
    function selectMessageDepStaff(flag) {
        var url = "<%=request.getContextPath()%>/sale/promationTag/staffSelect_adv.jsp?type=notice&orgInit="+flag+"&org_id=10&workflowId=<%=request.getParameter("workflowId")%>";
        var style = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:800px;dialogWidth:700px";
        var result = window.showModalDialog(url, null, style);
        if(result != null){
            
            var name;
            for(var i=0;i < result.elements.length;i++)
            {
                if (i == 0)
                {
                    a_publishEmp = result.elements[i].operatorId;
                    name = result.elements[i].name;
                } else {
                    a_publishEmp = a_publishEmp + ";" + result.elements[i].operatorId;
                    name = name + ";" + result.elements[i].name;
                }
            }
            document.getElementById("a_publishEmp").value = name; 
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
        if (IsHasTicket) {
       		displaytxt = "�����������Ĳ��ž�����";
        	resultTmp = 'user~hlw~staff~102210~:staff~�����������Ĳ��ž�����~autodecition';
        }
        var array = resultTmp.split("~");
        var taskType = array[0];
        var result = array[1];
        var userType = array[2];
        var roleId = array[3];
        var userId = array[4];
        var nextTaskTag = array[7];
        
        /**���б��ñ�ǩ����ʡҵ֧����
        if (taskTag != 'su109') {
	        if (IsHasSpareTag && (nextTaskTag == 't0001' || nextTaskTag == 'p09' || nextTaskTag == 'I014')) {
	        	//return alert('�������Ҫ���õı��ñ�ǩ,�뷢ʡҵ֧���ã�');
	        	if(!confirm("��������ñ�ǩ����ȷ������ʡҵ֧���ã�")) {
	        		return;
	        	}
	        } else if (!IsHasSpareTag && nextTaskTag == 'su105') {
	        	if(!confirm("����������ñ�ǩ����ȷ����ʡҵ֧���ã�")) {
	        		return;
	        	}
	        	//return alert('����������ñ�ǩ,����Ҫ��ʡҵ֧����');
	        }
        } */
        //��鱸�ñ�ǩ�Ƿ���д��BossID
        if (taskTag == 'wp02' && checkHasEmptyTagBossId()) {
        	if(!confirm("�б�ǩû����дBossID��ʵ������˰��,��ȷ��Ҫ�ύ��")){
		        return;
		    }
        }
        if (nextTaskTag == 'wp01' && checkHasEmptyTagTax()) {
        	if(!confirm("�б�ǩû����д˰��,��ȷ��Ҫ�ύ��")){
		        return;
		    }
        }
        if (taskTag == "su106" && result == "default") {
        	changeTagToUse();
        }
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
       
        if (((taskTag.substr(0,1)).toUpperCase() == 'S' || 'C001' == taskTag) && taskTag.substr(0,2) != 'su'){
        	
        	if (null == reason || trim(reason).length < 3) {
            	alert("��ǩ�����С��3���֣�");
           		_fromWfCheckFormRowSet().setFocus("REASON");
            	return;
        	}
        }
        reason = displaytxt+"|"+reason;
        var comment = _fromWfCheckFormRowSet().getValue("COMMENT");
        
        if (taskTag == 't3002'|| taskTag == 'p17') {
        	var cn = _include_fromAttachFileFormRowSet().getTotalRowCount();
        	if (cn == 0) return alert("���ϴ����Ա��棡");
        	if (_include_fromAttachFileFormRowSet().getValue(cn-1,"LABEL") != "���в���" 
        		&& _include_fromAttachFileFormRowSet().getValue(cn-1,"LABEL") != "���²���" 
        		&& _include_fromAttachFileFormRowSet().getValue(cn-1,"LABEL") != "����" ) {
        		return alert("���ϴ����Ա��棡");
        	}
		}
        
        if (taskTag == 't0007') {
        	if (needWPTestAudit && nextTaskTag == 't13') {
        		return alert("������������ã����ȷ�����������ˣ�");
        	} else if (!needWPTestAudit && nextTaskTag == 't0008') {
        		return alert("��������������ã�����Ҫ������������ˣ�");
        	}
        	var cn = _include_fromAttachFileFormRowSet().getTotalRowCount();
        	if (cn == 0) return alert("ȱ�ٲ��Ա��棬���ϴ���");
        	var hasTestAttach = false;
        	for (var i = 0; i < cn; ++i) {
        		if (_include_fromAttachFileFormRowSet().getValue(i,"LABEL") == "����" 
        		   || _include_fromAttachFileFormRowSet().getValue(i,"LABEL") == "���²���"
        		   || _include_fromAttachFileFormRowSet().getValue(i,"LABEL") == "���в���"
        		   || _include_fromAttachFileFormRowSet().getValue(i,"LABEL") == "������������˲��Ա���"){
	        		hasTestAttach = true;
	        		break;
        		}
        	}
        	if (!hasTestAttach) {
        		return alert("ȱ�ٲ��Ա��棬����ӣ�");
        	}
		}
        
        if (nextTaskTag == 't05' || taskTag == 'PC001' || nextTaskTag == 'C014'
        	|| nextTaskTag == 'I009' || nextTaskTag == 'p02'){
	        
        	if (org_selected == null || org_selected.length < 1) {
        		
        		var workflowId = "<%=request.getParameter("workflowId")%>";
	        	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AppriseAction?action=getAppriseOrgIds&workflowId=' + workflowId;
		    	var ret = PostInfo(strUrl, null);
		    	var orgStr = ret.getValueByName("orgStr");
	        	if (orgStr == null || orgStr.length < 1){
		    		alert('����Ҫ��һ����������');
		    		return;
	    		}
        	}
	    } else if (taskTag == 't14' || taskTag == 'C023' || taskTag == 'I026') {
	    	
	    	if (messageType == '������ȷ��' && a_publishEmp == '') {
	    		
		        alert("��ѡ�񷢲���Ա");
		        return;
	    	}
        } else if (taskTag == 'p07' || taskTag == 'PC022' ) {
        	
        	if (a_publishEmp == '') {
	    		
		        alert("��ѡ�񷢲���Ա");
		        return;
	    	}
        }
        
        if (taskTag == 't0001' || taskTag == 'p09'){
        	
        	var checkRet = PostInfo(_gModuleName + '/business/com.asiainfo.sale.activity.web.SaleMainAction?action=hasEitInSale&orderId=' + _mainId);
        	if ("Y" == checkRet.getValueByName("FLAG")) {
        		if (a_appriseEmp != '') {
	        		a_appriseEmp += ';20006350';
        		} else {
        			a_appriseEmp = '20006350';
        		}
        	}
        }
        
		//**R130614014-����֪��ͻ�������������(�ڷ������ù������ڣ�ϵͳ�Զ�֪��ʡ�ͷ�������ۣ�20005100 | yanghui)
		//���й�˾Ӫ�����������(template.TownSaleCaseApprove)�� t0008-ҵ֧���ķ�����˲�������
		//ʡ��˾����������Ӫ��������(template.InternetSaleCaseApprove)�� I023-��ʡҵ֧���
		//ʡ��˾ͳһӪ������������(template.ProvinceSaleCaseApprove)�� p04-����ҵ��֧������
		
		//ʡ��˾�ʷѰ���������(template.ProvinceChargeApplyFlow)��PC006-��ҵ֧���ķ��ɿ�������
		//�����ʷ���������(template.TownChargeApplyFlow)����ǰ�ڵ㣺C018-ҵ֧���ķ������� ���������������ÿ���

		//�����������(template.AccessChangeFlow):��ǰ�ڵ㣺A04-ҵ֧���ķ�������
        if (taskTag == 't0008' || taskTag == 'I023' || taskTag == 'p04' || taskTag == 'PC006' || taskTag == 'C018' || taskTag == 'A04'){
        	if (("false" != result) && ("fasle" != result)) {
        		if (a_appriseEmp != '') {
	        		a_appriseEmp += ';20005100';
        		} else {
        			a_appriseEmp = '20005100';
        		}
        	}
        }
        // �ж�bossid�Ƿ���Ϊ�յ�
        if ('template.TownSaleCaseApprove' == templateCode || 'template.InternetSaleCaseApprove' == templateCode
            || 'template.ProvinceSaleCaseApprove' == templateCode || 'template.ZqSaleFlow' == templateCode){
        	
	        if (g_FormRowSetManager.get("saleMainOverviewForm").getValue("SALE_MAIN_CODE") != '0000') {
		 		if (taskTag == 't15' || taskTag == 't0003' || taskTag == 't0023' || taskTag == 'I018' || taskTag == 'I021' || taskTag == 'p05' || taskTag == 'p14'){
		 			var checkRet = PostInfo(_gModuleName + '/business/com.asiainfo.sale.activity.web.SaleOrderAction?action=IsHasEmptyBossid&orderId=' + _mainId);
		 			if ("yes" == checkRet.getValueByName("YON")) {
		        		alert("����/����bossid��Ϊ�յ�,������ã�");
		        		window.open('<%=request.getContextPath()%>/sale/activity/include/_loggingBossid.jsp?orderId='+_mainId,'_blank','toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
		        		return;
		        	}
		 		}
	        }
        }
        
        // �����ʷ�bossid��д�޸�
 		if ('template.TownChargeApplyFlow' == templateCode || 'template.ProvinceChargeApplyFlow' == templateCode){
 			
 			if (taskTag == 'C019' || taskTag == 'C031' || taskTag == 'PC007' || taskTag == 'PC015'){
 				
		 		if (g_TableRowSetManager.get("chargeDetailListTable").getTotalRowCount() > 0) {
			 		if (!checkHasEmptyBossid()){
			 			alert("����bossid��Ϊ�յ�,������ã�");
			        	window.open('<%=request.getContextPath()%>/charge/include/_loggingBossid.jsp?mainId='+_mainId,'_blank','toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
			        	return;
			 		}
		 		}
 			}
 		}
        if (taskTag == 'C041' || taskTag == 'PC041') {
 			if (g_TableRowSetManager.get("chargeDetailListTable").getTotalRowCount() > 0) {
			 		if (!checkHasEmptyBossid()){
			 			alert("����bossid��Ϊ�յ�,������ã�");
			        	window.open('<%=request.getContextPath()%>/charge/include/_loggingBossid.jsp?mainId='+_mainId,'_blank','toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
			        	return;
			 		}
		 		}
 		}
 		
 		if ('template.NewPChargeFlow' == templateCode || 'template.NewTChargeFlow' == templateCode
 		    || 'template.ZqChargeFlow' == templateCode) {
 		    if(taskTag == 'PC007' || taskTag == 'PC042' || taskTag == 'C019' || taskTag == 'C042') {
 		    	var checkRet = PostInfo(_gModuleName + '/business/com.asiainfo.charge.web.ChargeCfgAction?action=checkCfgIsNotNull&chargeId=' + _mainId);
 		    	if (checkRet.getValueByName("FLAG") == "N") {
 		    		return alert("����д�ʷ����÷�����");
 		    	}
 		    }
 		}
        if(!a_send()){
            return;   
        }
        if(taskTag=="PB002"){
         	var length = TagDetailTable.getTotalRowCount();
 		 	if(length>0){
 				return alert("�뽫��Ʒ��ԴID������ɺ�,�ύ��������!"); 	
 			}
        }
        
        if (nextTaskTag == 'PC041' || nextTaskTag == 'PC015' || nextTaskTag == 'C041' || nextTaskTag == 'C031'
            		|| nextTaskTag == 't15' || nextTaskTag == 't0003' || nextTaskTag == 't0023' 
            		|| nextTaskTag == 'p52' || nextTaskTag == 'p05' || nextTaskTag == 'p14'
            		|| nextTaskTag == 't0004' || nextTaskTag == 't3002' || nextTaskTag == 'p17' || nextTaskTag == 'p54'
            		|| nextTaskTag == 'I019' || nextTaskTag == 'C27' || nextTaskTag == 'PC008' || taskTag == 'wp01') {
        	var advDate = _fromWfCheckFormRowSet().getValue("ADVISE_FINISHDATE");
        	if (advDate != "") {
        		var ret = PostInfo(_gModuleName + '/business/com.asiainfo.common.web.ItemOtherInfoAction?action=saveItemOtherInfo&itemId=' + _mainId+"&advDate="+advDate + "&taskTag=" + nextTaskTag);
        		if (ret.getValueByName("FLAG") == "N") {
        			return alert("�ύʧ�ܣ�");
        		}
        	}
        }
        if (taskTag=="wp02" && result == "default") {
        	//��������Э�����̡�
        	var curIndex=document.getElementById("attachCfgSelect").selectedIndex;
        	if (document.getElementById("attachCfgSelect")[curIndex].text == '��') {
        		var hasCfgAttach = false;
        		var cn = _include_fromAttachFileFormRowSet().getTotalRowCount();
        		for (var i = 0; i < cn; ++i) {
	        		var fileName = _include_fromAttachFileFormRowSet().getValue(i,"FILENAME");
	        		if (fileName.indexOf("�����ػ�") != -1 || fileName.indexOf("�ײͲ�ѯ") != -1 || fileName.indexOf("ҵ���������") != -1){
	        			hasCfgAttach = true;
	        			break;
	        		}
	        	}
	        	if (hasCfgAttach) {
		 			PostInfo(_gModuleName + '/business/com.asiainfo.sale.activity.web.SaleOrderAction?action=submitElectChannAssCfg&orderId=' + _mainId);
	        	} else {
	        		return alert("���ϴ���Ҫ��������������ο�ģ����д��");
	        	}
        	}
        	//�����������̡�
        	PostInfo(_gModuleName + '/business/com.asiainfo.sale.activity.web.SaleOrderAction?action=checkDispachElectChann&orderId=' + _mainId);
        }
        
    	if(taskTag=='wp02'||taskTag=='su107'){
        	if(!confirm('ȷ���ύô? �û��ڿ�����Ҫ�ڡ�Ӫ�����Ҫ��Ϣ��ҳ����С�����ָ�������,������Ҫ���û����������ȷ�ϣ�')){
        		return;
        	  }
        	}

        //��������Ϣ����CRM
        //if(parseInt(_mainId) >= 23287) {
        //	PostInfo(_gModuleName + '/business/com.asiainfo.sale.activity.web.SaleToCRMAction?action=createOrderInCRM&orderId=' + _mainId);
        //}
        
        //var auditFlag = document.getElementById("auditFlag").value;
        var strUrl = _gModuleName + '/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=finishUserTask&taskId=' + taskId
                    + "&result=" + result
                    + "&staffId=" + staffId
                    + "&reason=" + reason.replace(/%/g,"^#")
                    + "&comment=" + comment
                    + "&taskType=" + taskType
                    + "&templateCode=" + templateCode
                    + "&flowType=" + flowType
                    + "&mainId=" + _mainId
                  //  + "&auditFlag=" + auditFlag
                    + "&taskTag=" + taskTag;

       var recode = PostInfo(strUrl);
       if ("Y" == recode.getValueByName("FLAG"))
       {
          alert(recode.getValueByName("MESSAGE"));
       } else {
          alert(recode.getValueByName("MESSAGE"));
       }
       closePage();
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
        
        if (taskTag == 'PC041' || taskTag == 'PC015' || taskTag == 'C041' || taskTag == 'C031'
        		|| taskTag == 't15' || taskTag == 't0003' || taskTag == 't0023' 
        		|| taskTag == 'p52' || taskTag == 'p06' || taskTag == 'p14') {
        	PostInfo(_gModuleName + '/business/com.asiainfo.common.web.ItemOtherInfoAction?action=reComputeAdviseDate&itemId='+_mainId+"&itemType="+flowType+"&node=pz"+"&taskTag="+taskTag+"&reAuthorOpid="+nextStaffId);
        }
        if(taskTag == 't0004' || taskTag == 't3002' || taskTag == 'p17' || taskTag == 'p54'
        		|| taskTag == 'I019' || taskTag == 'C27' || taskTag == 'PC008') {
        	PostInfo(_gModuleName + '/business/com.asiainfo.common.web.ItemOtherInfoAction?action=reComputeAdviseDate&itemId='+_mainId+"&itemType="+flowType+"&node=test"+"&taskTag="+taskTag+"&reAuthorOpid="+nextStaffId);
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
    var content = _fromWfCheckFormRowSet().getValue("REASON").replace(/%/g,"^#");
    var condition = 'workflowId=' + a_workflowId + '&appriseEmp=' + a_appriseEmp + '&assistEmp=' + a_assistEmp + '&publishEmp=' + a_publishEmp + '&content=' +content ;
    if ((taskTag == 't0009' || taskTag == 't13') && messageType == '������ȷ��'){
    	var url = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AppriseAction?action=autoSendApprise&' + condition;
    	var ret = PostInfo(url, null);
    	if (ret.getValueByName("FLAG") != "Y") {
        	alert(ret.getValueByName("MESSAGE"));
        	return false;
    	}
    }
    if (a_appriseEmp == '' && a_assistEmp == '' && a_publishEmp == ''){
        //alert(crm_i18n_msg("SOC0100106"));
        return true;
    }
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

function autoSelectNo() {
	
   //var fieldObj = FormRowSet_All_getFieldSpanObj(_fromWfCheckFormRowSet().DBFormPK, "RESULT");
   //var ls=fieldObj.ls;
   //var oldLsObj = _fromWfCheckFormRowSet().ListDataSource.find(ls);
   var tmpEditor = FormRowSet_Field_DBListBox_getEditor(_fromWfCheckFormRowSet(),"RESULT");
   var optionLength = tmpEditor.options.length;
   if (optionLength == 1) return;
   for (var i=0; i<optionLength; ++i) {
	   var optionValue = tmpEditor.options[i].value;
	   if (optionValue.split("~")[1] == 'false') {
		   _fromWfCheckFormRowSet().setValue("RESULT",tmpEditor.options[1].value);
		   _fromWfCheckFormRowSet().setColEditSts("RESULT",false);
	   }
   }
}

function autoSelectYes() {
   var tmpEditor = FormRowSet_Field_DBListBox_getEditor(_fromWfCheckFormRowSet(),"RESULT");
   var optionLength = tmpEditor.options.length;
   if (optionLength == 1) return;
	_fromWfCheckFormRowSet().setColEditSts("RESULT",true);
	_fromWfCheckFormRowSet().setValue("RESULT",tmpEditor.options[0].value);
}

function downTemplate(id) {
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AttachAction?action=downLoadFile&idList='+id;
    window.location.href = strUrl;
}
</script>
 <div id="fujian">
<%@include file="/sale/common/include/_attach.jsp"%>
 </div>
