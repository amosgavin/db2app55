<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

   <ai:dbform formid="wfCheckForm" 
       onvalchange="onValChange" initial="false"
       setname="com.asiainfo.workflow.util.web.SETFWOperate">
       <table width="50%" border="0" align="center" ellpadding="1" cellspacing="2">
           <tr id="bt_selectMessageDep" style="display: none;">
               <td class="td_font" colspan="1">�������ţ�</td>
               <td ><a href="#" onclick="window.showModalDialog('<%=request.getContextPath()%>/sale/promationTag/orgSelect.jsp?org_id=10&workflowId=<%=request.getParameter("workflowId")%>','_blank','scroll:yes;resizable:no;help:no;status:no;dialogHeight:590px;dialogWidth:320px');">
               		<span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:red; ">ѡ�񷢲�����(�ʷ�������Ҫ��֪�Ĳ���)</span></a> </td>
           </tr>
           <tr id="bt_modifyMessageDep" style="display: none;">
           	   <td class="td_font" colspan="1">�������ţ�</td>
               <td ><a href="#" onclick="window.showModalDialog('<%=request.getContextPath()%>/sale/promationTag/orgModify.jsp?org_id=10&workflowId=<%=request.getParameter("workflowId")%>','_blank','scroll:yes;resizable:no;help:no;status:no;dialogHeight:590px;dialogWidth:320px');">
               		<span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:red; ">�޸ķ�������(�ʷ�������Ҫ��֪�Ĳ���)</span></a> </td>
           </tr>
           <tr id="bt_selectMessageDepStaff" style="display: none;">
           	<td class="td_font">ѡ�񷢲���Ա��</td>
               <td><input type="text" id="a_publishEmp" style="width: 260px;"/><img id="selectStaff1" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectMessageDepStaff();" align="middle" style="cursor:hand;"/><span class="font_red">*</span>
               <span class="font_red">(�ʷ�������Ҫ��֪����Ա)</span></td>
           </tr>
           <tr id="bt_selectMessageDepStaff_S" style="display: none;">
               <td class="td_font" colspan="1"><ai:button id="doSubmit" text="ѡ��֪�Ჿ��Ա��" onclick="selectMessageDepStaff(false)"/>
                                               <!-- <ai:button id="doSubmit" text="ѡ����첿��Ա��" onclick="selectWorkDepStaff(false)"/> -->
               </td>
           </tr>
           
           <tr id="auditSelect_tr" style="display: block;">
             <td class="td_font">����ѡ��</td>
             <td align="absmiddle" >
                                     ͨ��<input type="radio" id="auditFlag1" name="audit" value="ok" onclick="autoSelectYes()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		    ��ͨ��<input type="radio" id="auditFlag2" name="audit" value="no" onclick="autoSelectNo()"></td>
           </tr>
           
           <tr id="result" style="display: block;" onmouseover="">
               <td class="td_font">��һ���ڣ�</td>
               <td><ai:dbformfield formid="wfCheckForm" fieldname="RESULT" width="260"/></td>
           </tr>
           
            <tr id="curResult" style="display: none" onmouseover="">
                <td class="td_font">��һ���ڣ�</td>
                <td><input id='nextResult' type="text" value="ҵ��֧����������NCODE" width="260"/></td>
            </tr>
            <tr id="curResult_2" style="display: none" onmouseover="">
                <td class="td_font">����������</td>
                <td><input id='nextResult_2' type="text" value="ҵ��֧����������NCODE���" width="260"/></td>
            </tr>
            <tr id="yqresult" style="display: none;" onmouseover="">
                <td class="td_font">����������</td>
                <td>
                	<select id='yqselect' name='yqselect' width="260">
                		<option value="A">����ҵ�����������(����)���</option>
                		<option value="B">��ҵ��֧�����������(����)���</option>
                		<option value="C">���������������(����)���</option>
                	</select>
                </td>
            </tr>
           
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
           <tr id="finalShare_tr" style="display: none;">
           	<td class="td_font" id='discription'>ע�⣺</td>
           	<td><span class="font_red">�뵽�ʷ���ϸ����д�����̯</span></td></tr>
           <tr id="reason" style="display: block;">
               <td class="td_font" id='discription'>˵����</td>
               <td><ai:dbformfield formid="wfCheckForm" fieldname="REASON" width="260" height="60"/></td>
           </tr>
           <tr id="comment" style="display: none;">
               <td class="td_font">ע�ͣ�</td>
               <td><ai:dbformfield formid="wfCheckForm" fieldname="COMMENT" width="260" height="60" visible="false"/></td>
           </tr>
           <tr id="logCharge_bossid" style="display: none;">
           	<td class="td_font">��д�ʷ�bossid��</td>
           	<td><a href="#" onclick="window.open('<%=request.getContextPath()%>/charge/include/_loggingBossid.jsp?mainId='+_mainId,'_blank','toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');">
           	<span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:red;">>>>>>>>>>>>>GO!(�����)</span></a> 
           	</td>
           </tr>
           <tr id="attach_cfg_tr" style="display: none;">
            	 <td class="td_font">�Ƿ񷢵�������: </td>
                 <td><select id="attachCfgSelect">
						  <option>��</option>
						  <option>��</option>
						</select>
    		    <span class="font_red">*��ѡ(ѡ���ǡ�����д�������ģ�沢�ϴ�)</span></td>
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
           <tr></tr>
          <tr>
     		<td align="left">
     			<a href="#" onclick="apprise()"><span style="font-style:italic; font-size:14px; TEXT-DECORATION: underline; ">֪��</span></a>
     			<a href="#" onclick="assign()"><span style="font-style:italic; font-size:14px; TEXT-DECORATION: underline; ">ί��</span></a></td>
     		<td align="left"><ai:button id="doSubmit" text="�ύ" onclick="doSubmit()"/></td>
     	  </tr>
       </table>
       </ai:dbform>
   
   <div id='assign_div' style="display: none;">
    <ai:dbform formid="wfCheckAddForm" 
        onvalchange="" initial="false"
        setname="com.asiainfo.sale.common.web.SETFWOperate">
        <table width="50%" align="center" border="0" cellpadding="1" cellspacing="1">
            <tr id="staffs">
                <td class="td_font">ί���ˣ�</td>
                <td><ai:dbformfield formid="wfCheckAddForm" fieldname="STAFFS" width="260"/>
                    <img id="bt_selectAddStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectAddStaff();" align="absmiddle" style="cursor:hand;"/>
                <ai:button text="�ύί��" id="queryB" onclick="AssignJB()" /></td>
            </tr>
        </table>
    </ai:dbform>
  </div>
  <div id='apprise_div' style="display: none;">
	  <ai:dbform formid="appriseForm" 
	           setname="com.asiainfo.sale.tag.web.SETApproveColumn"
	           conditionname="condition" parametersname="parameters"
	           onvalchange="" editable="true" initial="false"
	           datamodel="com.ai.appframe2.web.datamodel.MethodModelForService">
	       <table width="50%" align="center" border="0" cellpadding="1" cellspacing="1">
	           <tr id='_appriseEmp'><td class="td_font"><i18n:message key="SOS0100102" res="CRM" /></td>
	               <td><input type="text" id="a_appriseEmp" style="width: 260px;"/>
	                   <img id="selectStaff1" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="a_appriseEmpSelect();" align="absmiddle" style="cursor:hand;"/>
	               </td>
	           </tr>
	           <tr id='_assistEmp'><td class="td_font">ѡ��Э���ˣ�</td>
	               <td><input type="text" id="a_assistEmp" style="width: 260px;"/>
	                   <img id="selectStaff1" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="a_assistEmpSelect();" align="absmiddle" style="cursor:hand;"/>
	               </td></tr>
	       </table>
	   </ai:dbform>
	</div>


<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/DBListBox.js"></script>
<script type="text/javascript">
    var url_selectStaff;
    var title_staff;
    var isShow_staff = false;//false��ʾ������һ���ڴ����˽��зǿ���֤
    var style_selectStaff = "scroll:no;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px";
    var templateCode = "<%=request.getParameter("templateCode")%>";
    var taskId = "<%=request.getParameter("taskTemplateId")%>";
    var taskTag = "<%=request.getParameter("taskTag")%>";
    var taskRecordId = "<%=request.getParameter("taskId")%>";
    var flowType = "<%=request.getParameter("recordType")%>";
    var workfId = "<%=request.getParameter("workflowId")%>";
    var count_WfCheckFormFlash = 0;
    var messageType = '';
    var org_selected = '';
    var IsHasTicket = false;
    
    function _fromWfCheckFormRowSet(){
        return g_FormRowSetManager.get("wfCheckForm");
    }
    
    function initCheckPage(){
        count_WfCheckFormFlash++;
        _fromWfCheckFormRowSet().refreshListBox("RESULT","templateCode="+templateCode+"&taskId="+taskId,true);
        _fromWfCheckFormRowSet().setFocus("RESULT");
        var listBoxEditor = FormRowSet_Field_DBListBox_getEditor(_fromWfCheckFormRowSet(),"RESULT");
   		if (listBoxEditor.options.length <= 1 || taskTag.endWith("-m")) {
   			document.getElementById("auditSelect_tr").style.display = "none";
   		} else if (!taskTag.endWith("-sign")){
   			document.getElementById("auditFlag1").checked = true;
   		}
        if (taskTag.endWith("-sign")) {
        	document.getElementById("auditSelect_tr").style.display = "block";
        	document.getElementById("result").style.display = "none";
        }
        if (taskTag == "st3-ch2-audit" || taskTag == "st1-ch7-N") {
        	document.all("contractFrame_chargeInfoframe").style.display='block';
        	document.getElementById("finalShare_tr").style.display = "block";
        }
        pageSet();
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
            if (nextTaskTag == 'st4-ch2-conf') {
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
	        } else if (nextTaskTag == 'st5-ch2-test') {
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
        var nochange = true;
        isShow_staff = true;
        document.getElementById("staffs").style.display = "block";
        //���������˻�ǩ����Ϣ
        
        if(taskTag=="YQ001"){
        	var checkWPTestRet = PostInfo(_gModuleName + "/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=getCurVsTask&taskId=<%=request.getParameter("taskId")%>");
        	var flag= checkWPTestRet.getValueByName("FLAG");
        	var lable = checkWPTestRet.getValueByName("MESSAGE");
        	document.getElementById("result").style.display = "none";//����ѡ��
        	if('Y'==flag){
        		var type = checkWPTestRet.getValueByName("TYPE");
        		if(type=='B'){
        			document.getElementById("yqresult").style.display = "block";
        			title_staff = "��һ���ڴ����ˣ�";
        			url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?org_id=10&orgId="+g_GetUserInfo().ORG_ID;
	            	style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:550px;dialogWidth:430px";
        			isShow_staff=true;
        			nochange=false;
        		}else if(type=='A'){
        			//_EChannelNcodeCommandListTab.setEditSts(true);
					//document.getElementById("saveEchl_bt_div").style.display="block";
        			//document.getElementById("curResult").style.display = "block";
        			url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?org_id=10&orgId="+g_GetUserInfo().ORG_ID;        			
        			//document.getElementById("result").style.display = "none";
        			title_staff = "ҵ��֧����������NCODE�����ˣ�";
        			document.getElementById("curResult").style.display = "block";
        			//document.getElementById("staffs").style.display = "none";
        			nochange=false;//�Ƿ���ʾ�»��ڴ�����
        			isShow_staff=true;
        		}else if(type=='C'){
        			isShow_staff=false;
        			_EChannelNcodeCommandListTab.setEditSts(true);
        			document.getElementById("saveEchl_bt_div").style.display="block";
        			document.getElementById("curResult_2").style.display = "block";
        			//document.getElementById("staffs").style.display = "none";
        			document.getElementById("result").style.display = "none";
        		}else if(type=='D'){
        			var nextlable = "��ҵ�����û򿪷���ʡ������������";
        			if(lable=='ҵ��֧��������������'){
        				nextlable = "ҵ֧�������û򿪷�������������";
        			}else if(lable=='����������������'){
        				nextlable = "��������һ����������";
        			}
        			
        			url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?org_id=10&orgId="+g_GetUserInfo().ORG_ID;
        			document.getElementById("curResult").style.display = "block";
        			document.getElementById("nextResult").value=nextlable;
        			isShow_staff=true;
        			nochange=false;
        			//document.getElementById("staffs").style.display = "none";
        		}else if(type=='E'){
        			isShow_staff=false;
        			document.getElementById("curResult_2").style.display = "block";
        			document.getElementById("nextResult_2").value=lable+'���';
        		}
        	}
        }
        
         if (nextTaskTag == 'C005' && orgId == '29') {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20007720','����');
 			}
       if(roleId == "-2" && "finish" != taskType){
            title_staff = "��һ���ڴ����ˣ�";
            document.getElementById("inner_staffs").innerHTML = title_staff;
            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?org_id=1001&orgId="+g_GetUserInfo().ORG_ID;
            style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:530px;dialogWidth:670px";
        }else if(nextTaskTag=="YQ001"){
	       	title_staff = "��һ���ڴ����ˣ�";
	        document.getElementById("inner_staffs").innerHTML = title_staff;
	       	url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_yq.jsp?roleId="+roleId+"&orgId="+orgId;
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
             if(nochange){
            	isShow_staff = false;
            	document.getElementById("staffs").style.display = "none";
            }
            if (taskTag.endWith("-sign")) {
            	document.getElementById("result").style.display = "none";
            }
            
        } else {
            title_staff = "��һ���ڴ����ˣ�";
            document.getElementById("inner_staffs").innerHTML = title_staff;
            if (taskTag == 'st3-ch1-est') orgId = taskRecordId.substr(3,2);
            url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s1.jsp?roleId="+roleId+"&orgId="+orgId;
            style_selectStaff = "scroll:yes;resizable:no;help:no;status:no;dialogHeight:550px;dialogWidth:430px";
            
            //url_selectStaff = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?roleId="+roleId+"&orgId="+orgId;
            //style_selectStaff = "scroll:no;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px";
           }
       
        document.getElementById("bt_selectMessageDep").style.display = "none";
        document.getElementById("bt_modifyMessageDep").style.display = "none";
        document.getElementById("bt_selectMessageDepStaff").style.display = "none";
        document.getElementById("bt_selectMessageDepStaff_S").style.display = "none";
        
        document.getElementById("_assistEmp").style.display = "block";
	    document.getElementById("_appriseEmp").style.display = "block";
	    
	    document.getElementById("a_assistEmp").disabled=true;
		document.getElementById("a_appriseEmp").disabled=true;

        //���Ʒ���
    	if (taskTag == 'st3-ch2-audit'|| taskTag == 'st1-ch7-N'){
            document.getElementById("bt_selectMessageDep").style.display = "block";
        } else if (taskTag == 'st3-ch5-audit'){
            document.getElementById("bt_modifyMessageDep").style.display = "block";
        } else if (taskTag == 'st6-ch2-audit' && result == 'default'){
        	document.getElementById("_assistEmp").style.display = "none";
        	document.getElementById("_appriseEmp").style.display = "none";
            document.getElementById("bt_selectMessageDepStaff").style.display = "block";
            document.getElementById("a_publishEmp").disabled=true;
        } 

 		// �����ʷ�bossid��д�޸�
 		if (taskTag == 'st4-ch2-conf'){
 			document.getElementById("logCharge_bossid").style.display = "block";
 		}
 		//ʡҵ֧Ĭ����Աѡ��
 		var applyCity = taskRecordId.substr(3,2);
 		if (taskTag == 'st4-ch1-audit') {
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
 		if(nextTaskTag == 'st4-ch1-audit' || nextTaskTag == 'PC006' || nextTaskTag == 'C018'){
 			_fromWfCheckFormRowSet().setValue("STAFFS", '20004952', 'ë����');
 		}
 		if (taskTag == 'st4-ch2-conf' || taskTag == 'st5-ch2-test') {
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
 		
 		if (taskTag == 'st4-ch2-conf') {
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
        var auditFlag = "";
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
        // ��������ѡ
        auditFlag = getAuditSelectResult();
        
        // ��ǩ����
        if (taskTag.endWith("-sign")) {
        	displaytxt="";
        	if (auditFlag == "") {
        		return alert("�빴ѡ��������");
        	}
        	if (auditFlag == "no") {
        		result = "no";
        	} else {
        		var signUrl = _gModuleName + '/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=getSignResult&taskId=' + taskId;
        		var signRet = PostInfo(signUrl);
		        if ("Y" == signRet.getValueByName("FLAG"))
		        {
		           result = signRet.getValueByName("signResult");
		        } else {
		    	   return alert("�ύʧ�ܣ�");
		        }
		    }
        } else {
        	if ((result != "no" && auditFlag == "no") || (result == "no" && auditFlag == "yes")) {
        		return alert("����ѡ������һ���ڲ�����");
        	}
        }
        reason = displaytxt+"|"+reason;
        var comment = _fromWfCheckFormRowSet().getValue("COMMENT");
        // �жϲ����̯˰���Ƿ���д
        if (taskTag == "st3-ch2-audit" || taskTag == "st1-ch7-N") {
        	
        }
        
        if (taskTag == 'st5-ch2-test') {
        	//Ĭ���Զ������ʷ����÷���
			saveChargeTest('e');
        	saveChargeTest('i');
		    //�ж��Ƿ���д���÷���
		    if(chargeInnerTestTab.getTotalRowCount() < 1 && chargeExternTestTab.getTotalRowCount() < 1) {
		    	return alert("����д�ʷѲ����ĵ���");
		    }
		}
        
        if ((taskTag == 'st3-ch2-audit' && result == 'default') || taskTag == 'st1-ch7-N'){
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
	    } else if (taskTag == 'st6-ch2-audit' && result == 'default') {
	    	if (a_publishEmp == '') {
			    return alert("��ѡ�񷢲���Ա");
	    	} else {
			    //���߹۲�󣺷���������
	    		a_publishEmp += ';20005315';
	    	}
        } 
        
		//ҵ֧���ķ�������ڵ㣺֪��ͷ�
        if (taskTag == 'st4-ch1-audit' && "default" == result){
       		if (a_appriseEmp != '') {
        		a_appriseEmp += ';20005100';
       		} else {
       			a_appriseEmp = '20005100';
       		}
        }
		
        // �����ʷ�bossid��д�޸�
		if (taskTag == 'st4-ch2-conf' && "default" == result){
			//Ĭ���Զ������ʷ����÷���
			saveChargeCfg();
		    //�ж��Ƿ���д���÷���
		    if(chargeCfgTab.getTotalRowCount() < 1) {
		    	return alert("����д�ʷ����÷�����");
		    }
		    //���bossid�Ƿ񶼻����ˡ�
	 		if (g_TableRowSetManager.get("chargeDetailListTable").getTotalRowCount() > 0) {
		 		if (!checkHasEmptyBossid()){
		 			alert("����bossid��Ϊ�յ�,������ã�");
		        	window.open('<%=request.getContextPath()%>/charge/include/_loggingBossid.jsp?mainId='+_mainId,'_blank','toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
		        	return;
		 		}
	 		}
		    //����Ƿ���ҪЭ���������̡�
		    var attachCfgSelectO = document.getElementById("attachCfgSelect");
		    if (attachCfgSelectO[attachCfgSelectO.selectedIndex].text == '��') {
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
			    	PostInfo(_gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=submitElectChannAssCfg&mainid=' + _mainId);
	        	} else {
	        		return alert("���ϴ���Ҫ��������������ο�ģ����д��");
	        	}
	        		
	 		}
		    //�����������̡�
		    PostInfo(_gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=checkDispachElectChann&mainid=' + _mainId);
       		/*if (checkAttachConf.getValueByName("FLAG") == "N") {
       			alert(checkAttachConf.getValueByName("MESSAGE"));
       		} */
		}
 		
        if(!a_send()){
            return;   
        }
        if (nextTaskTag == 'st4-ch2-conf' || nextTaskTag == 'st5-ch2-test') {
        	var advDate = _fromWfCheckFormRowSet().getValue("ADVISE_FINISHDATE");
        	if (advDate != "") {
        		var ret = PostInfo(_gModuleName + '/business/com.asiainfo.common.web.ItemOtherInfoAction?action=saveItemOtherInfo&itemId=' + _mainId+"&advDate="+advDate + "&taskTag=" + nextTaskTag);
        		if (ret.getValueByName("FLAG") == "N") {
        			return alert("�ύʧ�ܣ�");
        		}
        	}
        }
        var strUrl = _gModuleName + '/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=finishUserTask&taskId=' + taskId
                    + "&result=" + result
                    + "&staffId=" + staffId
                    + "&reason=" + reason.replace(/%/g,"^#")
                    + "&comment=" + comment
                    + "&taskType=" + taskType
                    + "&templateCode=" + templateCode
                    + "&flowType=" + flowType
                    + "&mainId=" + _mainId
                    + "&auditFlag=" + auditFlag
                    + "&taskTag=" + taskTag
                    + "&workfId=" + workfId
					+ "&nextTaskTag=" + nextTaskTag
					+ "&nextLable=" + document.getElementById("yqselect").value;

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

function assign() {
    //AIContractFrame_OpenClose("wfCheckAddframe");
    //AIContractFrame_openMe();
    document.getElementById("assign_div").style.display = "block";
    selectAddStaff();
}

function apprise() {
	document.getElementById("apprise_div").style.display = "block";
}

function getAuditSelectResult() {
	if (document.getElementById("auditFlag1").checked) {
	    return "yes";
    } else if (document.getElementById("auditFlag2").checked){
        return "no";
    } else {
    	return "";
    }    
}

function AssignJB(){
    var nextStaffId=_fromWfCheckAddFormRowSet().getValue("STAFFS");
        if (null == nextStaffId || "" == nextStaffId)
        {
            return alert("��ѡ��Ӱ���");
        }
        
        if (taskTag == 'st4-ch2-conf') {
        	PostInfo(_gModuleName + '/business/com.asiainfo.common.web.ItemOtherInfoAction?action=reComputeAdviseDate&itemId='+_mainId+"&itemType="+flowType+"&node=pz"+"&taskTag="+taskTag+"&reAuthorOpid="+nextStaffId);
        }
        if(taskTag == 'st5-ch2-test') {
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

function autoSelectNo() {
	
   //var fieldObj = FormRowSet_All_getFieldSpanObj(_fromWfCheckFormRowSet().DBFormPK, "RESULT");
   //var ls=fieldObj.ls;
   //var oldLsObj = _fromWfCheckFormRowSet().ListDataSource.find(ls);
   var tmpEditor = FormRowSet_Field_DBListBox_getEditor(_fromWfCheckFormRowSet(),"RESULT");
   var optionLength = tmpEditor.options.length;
   if (optionLength == 1) return;
   for (var i=0; i<optionLength; ++i) {
	   var optionValue = tmpEditor.options[i].value;
	   if (optionValue.split("~")[1] == 'no') {
		   _fromWfCheckFormRowSet().setValue("RESULT",tmpEditor.options[i].value);
	   }
   }
}

function autoSelectYes() {
   var tmpEditor = FormRowSet_Field_DBListBox_getEditor(_fromWfCheckFormRowSet(),"RESULT");
   var optionLength = tmpEditor.options.length;
   if (optionLength == 1) return;
   var resultInfo = _fromWfCheckFormRowSet().getValue("RESULT");
   var array = resultInfo.split("~");
   var result = array[1];
   if (result == 'no') {
	   for (var i=0; i<optionLength; ++i) {
		   var optionValue = tmpEditor.options[i].value;
		   if (optionValue.split("~")[1] == 'default') {
			   _fromWfCheckFormRowSet().setValue("RESULT",tmpEditor.options[i].value);
		   }
   	   }
   }
}

function downTemplate(id) {
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AttachAction?action=downLoadFile&idList='+id;
    window.location.href = strUrl;
}
</script>
