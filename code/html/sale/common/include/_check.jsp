<%@ page contentType="text/html; charset=GBK"%>

<div id="wf_div" style="display: block">
<ai:contractframe id="wfCheckframe" contenttype="table" title="审核信息" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <ai:dbform formid="appriseForm" 
            setname="com.asiainfo.sale.tag.web.SETApproveColumn"
            conditionname="condition" parametersname="parameters"
            onvalchange="" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
            <tr id='_assistEmp'><td class="td_font">选择协办人：</td>
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
                <td colspan="2"><span class="font_red">若存在电子券，请选择发互联网中心处理！</span></td>
            </tr>
            <tr id="bt_selectMessageDep" style="display: none;">
                <td class="td_font" colspan="1"><ai:button id="doSubmit" text="选择发布部门" onclick="selectMessageDep()"/></td>
            	<td><span class="font_red">(资费/营销案活动上线需要告知的部门)</span></td>
            </tr>
            <tr id="bt_modifyMessageDep" style="display: none;">
                <td class="td_font" colspan="1"><ai:button id="doSubmit" text="修改发布部门" onclick="modifyMessageDep()"/></td>
            	<td><span class="font_red">(资费/营销案活动上线需要告知的部门)</span></td>
            </tr>
            <tr id="bt_selectMessageDepStaff" style="display: none;">
            	<td class="td_font">选择发布人员：</td>
                <td><input type="text" id="a_publishEmp" style="width: 260px;"/><img id="selectStaff1" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectMessageDepStaff();" align="middle" style="cursor:hand;"/><span class="font_red">*</span>
                <span class="font_red">(资费/营销案活动上线需要告知的人员)</span></td>
            </tr>
            <tr id="bt_selectMessageDepStaff_S" style="display: none;">
                <td class="td_font" colspan="1"><ai:button id="doSubmit" text="选择知会部门员工" onclick="selectMessageDepStaff(false)"/>
                                                <!-- <ai:button id="doSubmit" text="选择代办部门员工" onclick="selectWorkDepStaff(false)"/> -->
                </td>
            </tr>
            <%--
            <tr>
              <td class="td_font">审批选择：</td>
              <td>
	                                    同意(默认)<input type="radio" id="auditFlag" name="audit" value="ok"  checked="checked" onclick="autoSelectYes()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    		    不同意<input type="radio" id="auditFlag" name="audit" value="no" onclick="autoSelectNo()"></td>
            </tr>
            --%>
            <tr id="result" style="display: block;" onmouseover="">
                <td class="td_font">审批操作：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="RESULT" width="260"/></td>
            </tr>
            <tr id ="jh_tr" style="display: none;">
             <td></td><td colspan="2"><span class="font_red">江汉、天门、潜江的营销活动，需要其他二个分公司的市场部主任会签！</span></td></tr>
            <tr id="staffs" style="display: block;">
                <td id="inner_staffs" class="td_font">下一环节处理人：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="STAFFS" width="260" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
<%--                <ai:button id="clearstaff" text="清空" onclick="clearstaff()"/>--%>
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
                <td><ai:dbformfield formid="wfCheckForm" fieldname="REASON" width="260" height="60"/></td>
            </tr>
            <tr id="comment" style="display: none;">
                <td class="td_font">注释：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="COMMENT" width="260" height="60" visible="false"/></td>
            </tr>
            <tr id="attach_cfg_tr" style="display: none;">
            	 <td class="td_font">是否发电渠配置: </td>
                 <td><select id="attachCfgSelect">
						  <option>否</option>
						  <option>是</option>
						</select>
    		    <span class="font_red">*必选(选‘是’必须填写下列相关模版并上传)</span></td>
            </tr>
            <tr id="attach_cfg_1" style="display: none;">
            	<td class="td_font">下载模版：</td><td><a href="javascript:downTemplate(4)"><span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:blue; ">业务受理短信.xlsx</span></a></td></tr>
            <tr id="attach_cfg_2" style="display: none;">
            	<td class="td_font">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	</td><td><a href="javascript:downTemplate(5)"><span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:blue; ">入网关怀短信.xlsx</span></a></td></tr>
            <tr id="attach_cfg_3" style="display: none;">
            	<td class="td_font">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	</td><td><a href="javascript:downTemplate(6)"><span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:blue; ">套餐查询配置.xlsx</span></a></td></tr>
            <tr></tr>
            <tr id="logSale_bossid" style="display: none;">
            	<td class="td_font">填写/修改bossid：</td>
            	<td><a href="#" onclick="window.open('<%=request.getContextPath()%>/sale/activity/include/_loggingBossid.jsp?orderId='+_mainId,'_blank','toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');">
            	<span style="font-family:华文中宋; color:red; ">>>>>>>>>>>>>GO!(点击我)</span></a> 
            	</td>
            </tr>
            <tr id="logCharge_bossid" style="display: none;">
            	<td class="td_font">填写/修改资费bossid：</td>
            	<td><a href="#" onclick="window.open('<%=request.getContextPath()%>/charge/include/_loggingBossid.jsp?mainId='+_mainId,'_blank','toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');">
            	<span style="font-family:华文中宋; color:red; ">>>>>>>>>>>>>GO!(点击我)</span></a> 
            	</td>
            </tr>
            <tr></tr>
            <tr></tr>
            <tr id="Tosure" style="display: none;">
            	<td colspan=3><span class="font_red" style="font-size:15px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请确认是否保存测试报告后再提交！</span></td>
            </tr>
           <tr></tr>
           <tr></tr>
            <tr><td colspan=2><span id="echnnl_re_mess" style="display: none;" class="font_red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注意:该环节审批可能要进行“短厅指令”配置,若需要配置,请在“营销活动主要信息”页面进行配置</span></td></tr>
            <tr align="right" colspan=2><td ><ai:button id="doSubmit" text="提交" onclick="doSubmit()"/></td></tr>
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
				_fromWfCheckFormRowSet().addListBoxElement("RESULT" ,"user~default~staff~103809~:staff~财务定税率~autodecision~su105~127~发财务定税率（武器需要配置）~user", "同意,发财务定税率");
		        _fromWfCheckFormRowSet().addListBoxElement("RESULT" ,"sign~hq~staff~-1~:staff~省公司市场部会签~autodecision~sign02~24~发起会签~sign", "发起会签");
				_fromWfCheckFormRowSet().addListBoxElement("RESULT" ,"user~false~staff~-1~:staff01~AE~autodecision~t08~14~不同意，并发地市发起人修改~user", "不同意,发起人修改");
        	 } else {
	        	_fromWfCheckFormRowSet().addListBoxElement("RESULT" ,"user~pz~staff~-1~:staff04~地市指定主办人~autodecision~t0001~44~发地市配置活动~user", "同意,发配置活动");
		        _fromWfCheckFormRowSet().addListBoxElement("RESULT" ,"sign~hq~staff~-1~:staff~省公司市场部会签~autodecision~sign02~24~发起会签~sign", "发起会签");
				_fromWfCheckFormRowSet().addListBoxElement("RESULT" ,"user~false~staff~-1~:staff01~AE~autodecision~t08~14~不同意，并发地市发起人修改~user", "不同意,发起人修改");
        	 }
        } else {
        	_fromWfCheckFormRowSet().refreshListBox("RESULT","templateCode="+templateCode+"&taskId="+taskId,true);
        }
        _fromWfCheckFormRowSet().setFocus("RESULT");
        pageSet();
        //货品不用添加附件
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
	 				return alert("请选择人员！");
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
        		_fromWfCheckFormRowSet().setValue("RESULT","发互联网中心部门经理处理")
	        	resultInfo = 'user~hlw~staff~102210~:staff~发互联网中心部门经理处理~autodecition';
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
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20007720','黄瑞');
 			}
        
        if(taskTag == 'p09' && messageType == '分派活动配置任务' || taskTag == 'p09' && messageType == '分派配置任务' 
        		|| taskTag == 't0005' && messageType == '省业支分派审核任务' || taskTag == 't3001' && messageType == '省业支分派审核任务'){
        	var saleMainType= PostInfo(_gModuleName + '/business/com.asiainfo.sale.activity.web.SaleMainAction?action=checksalemaintype&orderId=' + _mainId);
        	if("rtPerson" ==saleMainType.getValueByName("SALE_MAIN_TYPE")){
        		_fromWfCheckFormRowSet().setValue("STAFFS", '20004983', '居国栋');
        	}
        	else{
        		_fromWfCheckFormRowSet().setValue("STAFFS", '20005008', '黄辉');
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
        document.getElementById("bt_selectMessageDep").style.display = "none";
        document.getElementById("bt_modifyMessageDep").style.display = "none";
        document.getElementById("bt_selectMessageDepStaff").style.display = "none";
        document.getElementById("bt_selectMessageDepStaff_S").style.display = "none";
        document.getElementById("tr_notice").style.display = "none";
        
        document.getElementById("_assistEmp").style.display = "block";
	    document.getElementById("_appriseEmp").style.display = "block";
	    
	    document.getElementById("a_assistEmp").disabled=true;
		document.getElementById("a_appriseEmp").disabled=true;

		if ((taskTag == 'C037' || taskTag == 't06' || taskTag == 'C012' || taskTag=='t0010') && (result == 'hq' || messageType == '市场或集客部会签')){
	        document.getElementById("jh_tr").style.display = "block";
	    } else{
	    	document.getElementById("jh_tr").style.display = "none";
	    }
        //控制发布
        if ('template.TownSaleCaseApprove' == templateCode){
        	
	        if (nextTaskTag == 't05'){
	            document.getElementById("bt_selectMessageDep").style.display = "block";
	        } else if (taskTag == 't05'||taskTag=='t0025'){
	            document.getElementById("bt_modifyMessageDep").style.display = "block";
	        } else if (taskTag == 't14' && messageType == '发起人确认'){
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
	        } else if (taskTag == 'I026' && messageType == '发起人确认'){
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
	        } else if (taskTag == 'C023' && messageType == '发起人确认'){
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
 		// 控制营销案bossid填写修改
 		//alert(g_FormRowSetManager.get("saleMainOverviewForm").getValue("SALE_MAIN_CODE"));
 		if ('template.TownSaleCaseApprove' == templateCode || 'template.InternetSaleCaseApprove' == templateCode 
 			|| 'template.ProvinceSaleCaseApprove' == templateCode || 'template.ZqSaleFlow' == templateCode){
 				
	 		if (g_FormRowSetManager.get("saleMainOverviewForm").getValue("SALE_MAIN_CODE") != '0000') {
	 			
		 		if (taskTag == 't15' || taskTag == 't0003' || taskTag == 't0023' || taskTag == 'I018' || taskTag == 'I021' || taskTag == 'p05' || taskTag == 'p14'){
		 			document.getElementById("logSale_bossid").style.display = "block";
		 		}
	 		}
 		}
 		
 		// 控制资费bossid填写修改
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
 		
 		//省业支默认人员选择
 		var applyCity = taskRecordId.substr(3,2);
 		if (taskTag == 'I023' || taskTag == 'I025' || (taskTag=='p04' && 'template.ProvinceChargeApplyFlow'==templateCode) || taskTag == 't3005') {
 			if (applyCity == '10' || applyCity == '11' || applyCity == '17' || applyCity == '13' || applyCity == '14') {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004938', '李莹');
 			} else if (applyCity == '26' || applyCity == '15' || applyCity == '24') {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004931', '张铮');
 			} else if (applyCity == '25' || applyCity == '20' || applyCity == '16' || applyCity == '18') {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004946', '王璨');
 			}  else  {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004947', '张雯');
 			}
 		} 
 		if (taskTag == 'PC006' || taskTag == 'C018' || taskTag == 'wp01') {
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
				advDate = advDate.replace(/-/g,"/");//替换字符，变成标准格式  
				var d2=new Date();//取今天的日期  
				var d1 = new Date(Date.parse(advDate));
				if (d1 < d2 ) {
					document.getElementById("sp_delay").innerHTML='工单已经延时，请填写延时原因(点击红色字体进入填写)*';
				}
        	} 
	 	}
 		
 		if ('template.NewTChargeFlow' == templateCode || 'template.NewPChargeFlow' == templateCode
 			|| 'template.ZqChargeFlow' == templateCode) {
 			
 			if (nextTaskTag == 'C040' || nextTaskTag == 'PC040') {
 				_fromWfCheckFormRowSet().setValue("STAFFS", '20004937', '高文');
 			}
 		}
 		
 		// 地市流程包含集团活动需要发往政企
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
            return alert("流程编号为空，请刷新后再试！");
        }
        var resultTmp = _fromWfCheckFormRowSet().getValue("RESULT");
        var displaytxt = _fromWfCheckFormRowSet().getDisplayText("RESULT");
        if (IsHasTicket) {
       		displaytxt = "发互联网中心部门经理处理";
        	resultTmp = 'user~hlw~staff~102210~:staff~发互联网中心部门经理处理~autodecition';
        }
        var array = resultTmp.split("~");
        var taskType = array[0];
        var result = array[1];
        var userType = array[2];
        var roleId = array[3];
        var userId = array[4];
        var nextTaskTag = array[7];
        
        /**含有备用标签，发省业支配置
        if (taskTag != 'su109') {
	        if (IsHasSpareTag && (nextTaskTag == 't0001' || nextTaskTag == 'p09' || nextTaskTag == 'I014')) {
	        	//return alert('活动包含需要配置的备用标签,请发省业支配置！');
	        	if(!confirm("活动包含备用标签，您确定不发省业支配置！")) {
	        		return;
	        	}
	        } else if (!IsHasSpareTag && nextTaskTag == 'su105') {
	        	if(!confirm("活动不包含备用标签，您确定发省业支配置！")) {
	        		return;
	        	}
	        	//return alert('活动不包含备用标签,不需要发省业支配置');
	        }
        } */
        //检查备用标签是否都填写了BossID
        if (taskTag == 'wp02' && checkHasEmptyTagBossId()) {
        	if(!confirm("有标签没有填写BossID或实际配置税率,您确定要提交！")){
		        return;
		    }
        }
        if (nextTaskTag == 'wp01' && checkHasEmptyTagTax()) {
        	if(!confirm("有标签没有填写税率,您确定要提交！")){
		        return;
		    }
        }
        if (taskTag == "su106" && result == "default") {
        	changeTagToUse();
        }
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
       
        if (((taskTag.substr(0,1)).toUpperCase() == 'S' || 'C001' == taskTag) && taskTag.substr(0,2) != 'su'){
        	
        	if (null == reason || trim(reason).length < 3) {
            	alert("会签意见不小于3个字！");
           		_fromWfCheckFormRowSet().setFocus("REASON");
            	return;
        	}
        }
        reason = displaytxt+"|"+reason;
        var comment = _fromWfCheckFormRowSet().getValue("COMMENT");
        
        if (taskTag == 't3002'|| taskTag == 'p17') {
        	var cn = _include_fromAttachFileFormRowSet().getTotalRowCount();
        	if (cn == 0) return alert("请上传测试报告！");
        	if (_include_fromAttachFileFormRowSet().getValue(cn-1,"LABEL") != "地市测试" 
        		&& _include_fromAttachFileFormRowSet().getValue(cn-1,"LABEL") != "重新测试" 
        		&& _include_fromAttachFileFormRowSet().getValue(cn-1,"LABEL") != "测试" ) {
        		return alert("请上传测试报告！");
        	}
		}
        
        if (taskTag == 't0007') {
        	if (needWPTestAudit && nextTaskTag == 't13') {
        		return alert("活动包含武器配置，请先发武器测试审核！");
        	} else if (!needWPTestAudit && nextTaskTag == 't0008') {
        		return alert("活动不包含武器配置，不需要发武器测试审核！");
        	}
        	var cn = _include_fromAttachFileFormRowSet().getTotalRowCount();
        	if (cn == 0) return alert("缺少测试报告，请上传！");
        	var hasTestAttach = false;
        	for (var i = 0; i < cn; ++i) {
        		if (_include_fromAttachFileFormRowSet().getValue(i,"LABEL") == "测试" 
        		   || _include_fromAttachFileFormRowSet().getValue(i,"LABEL") == "重新测试"
        		   || _include_fromAttachFileFormRowSet().getValue(i,"LABEL") == "地市测试"
        		   || _include_fromAttachFileFormRowSet().getValue(i,"LABEL") == "地市主办人审核测试报告"){
	        		hasTestAttach = true;
	        		break;
        		}
        	}
        	if (!hasTestAttach) {
        		return alert("缺少测试报告，请添加！");
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
		    		alert('至少要有一个发布部门');
		    		return;
	    		}
        	}
	    } else if (taskTag == 't14' || taskTag == 'C023' || taskTag == 'I026') {
	    	
	    	if (messageType == '发起人确认' && a_publishEmp == '') {
	    		
		        alert("请选择发布人员");
		        return;
	    	}
        } else if (taskTag == 'p07' || taskTag == 'PC022' ) {
        	
        	if (a_publishEmp == '') {
	    		
		        alert("请选择发布人员");
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
        
		//**R130614014-流程知会客户服务中心需求(在分派配置工单环节，系统自动知会省客服中心杨慧：20005100 | yanghui)
		//地市公司营销活动审批流程(template.TownSaleCaseApprove)： t0008-业支中心分派审核测试任务
		//省公司互联网中心营销案流程(template.InternetSaleCaseApprove)： I023-发省业支审核
		//省公司统一营销案审批流程(template.ProvinceSaleCaseApprove)： p04-发送业务支撑中心
		
		//省公司资费案申请流程(template.ProvinceChargeApplyFlow)：PC006-发业支中心分派开发任务。
		//地市资费申请流程(template.TownChargeApplyFlow)：当前节点：C018-业支中心分配任务 审批操作：发配置开发

		//渠道变更流程(template.AccessChangeFlow):当前节点：A04-业支中心分派任务
        if (taskTag == 't0008' || taskTag == 'I023' || taskTag == 'p04' || taskTag == 'PC006' || taskTag == 'C018' || taskTag == 'A04'){
        	if (("false" != result) && ("fasle" != result)) {
        		if (a_appriseEmp != '') {
	        		a_appriseEmp += ';20005100';
        		} else {
        			a_appriseEmp = '20005100';
        		}
        	}
        }
        // 判断bossid是否有为空的
        if ('template.TownSaleCaseApprove' == templateCode || 'template.InternetSaleCaseApprove' == templateCode
            || 'template.ProvinceSaleCaseApprove' == templateCode || 'template.ZqSaleFlow' == templateCode){
        	
	        if (g_FormRowSetManager.get("saleMainOverviewForm").getValue("SALE_MAIN_CODE") != '0000') {
		 		if (taskTag == 't15' || taskTag == 't0003' || taskTag == 't0023' || taskTag == 'I018' || taskTag == 'I021' || taskTag == 'p05' || taskTag == 'p14'){
		 			var checkRet = PostInfo(_gModuleName + '/business/com.asiainfo.sale.activity.web.SaleOrderAction?action=IsHasEmptyBossid&orderId=' + _mainId);
		 			if ("yes" == checkRet.getValueByName("YON")) {
		        		alert("批次/档次bossid有为空的,请先填好！");
		        		window.open('<%=request.getContextPath()%>/sale/activity/include/_loggingBossid.jsp?orderId='+_mainId,'_blank','toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
		        		return;
		        	}
		 		}
	        }
        }
        
        // 控制资费bossid填写修改
 		if ('template.TownChargeApplyFlow' == templateCode || 'template.ProvinceChargeApplyFlow' == templateCode){
 			
 			if (taskTag == 'C019' || taskTag == 'C031' || taskTag == 'PC007' || taskTag == 'PC015'){
 				
		 		if (g_TableRowSetManager.get("chargeDetailListTable").getTotalRowCount() > 0) {
			 		if (!checkHasEmptyBossid()){
			 			alert("档次bossid有为空的,请先填好！");
			        	window.open('<%=request.getContextPath()%>/charge/include/_loggingBossid.jsp?mainId='+_mainId,'_blank','toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
			        	return;
			 		}
		 		}
 			}
 		}
        if (taskTag == 'C041' || taskTag == 'PC041') {
 			if (g_TableRowSetManager.get("chargeDetailListTable").getTotalRowCount() > 0) {
			 		if (!checkHasEmptyBossid()){
			 			alert("档次bossid有为空的,请先填好！");
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
 		    		return alert("请填写资费配置方案！");
 		    	}
 		    }
 		}
        if(!a_send()){
            return;   
        }
        if(taskTag=="PB002"){
         	var length = TagDetailTable.getTotalRowCount();
 		 	if(length>0){
 				return alert("请将货品资源ID配置完成后,提交结束流程!"); 	
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
        			return alert("提交失败！");
        		}
        	}
        }
        if (taskTag=="wp02" && result == "default") {
        	//电子渠道协助流程。
        	var curIndex=document.getElementById("attachCfgSelect").selectedIndex;
        	if (document.getElementById("attachCfgSelect")[curIndex].text == '是') {
        		var hasCfgAttach = false;
        		var cn = _include_fromAttachFileFormRowSet().getTotalRowCount();
        		for (var i = 0; i < cn; ++i) {
	        		var fileName = _include_fromAttachFileFormRowSet().getValue(i,"FILENAME");
	        		if (fileName.indexOf("入网关怀") != -1 || fileName.indexOf("套餐查询") != -1 || fileName.indexOf("业务受理短信") != -1){
	        			hasCfgAttach = true;
	        			break;
	        		}
	        	}
	        	if (hasCfgAttach) {
		 			PostInfo(_gModuleName + '/business/com.asiainfo.sale.activity.web.SaleOrderAction?action=submitElectChannAssCfg&orderId=' + _mainId);
	        	} else {
	        		return alert("请上传需要电子渠道配置项，参考模版填写！");
	        	}
        	}
        	//电子渠道流程。
        	PostInfo(_gModuleName + '/business/com.asiainfo.sale.activity.web.SaleOrderAction?action=checkDispachElectChann&orderId=' + _mainId);
        }
        
    	if(taskTag=='wp02'||taskTag=='su107'){
        	if(!confirm('确认提交么? 该环节可能需要在“营销活动主要信息”页面进行“短厅指令”的配置,若不需要配置或已配置请点确认！')){
        		return;
        	  }
        	}

        //将工单信息传给CRM
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
            return alert("请选择加办人");
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
    var content = _fromWfCheckFormRowSet().getValue("REASON").replace(/%/g,"^#");
    var condition = 'workflowId=' + a_workflowId + '&appriseEmp=' + a_appriseEmp + '&assistEmp=' + a_assistEmp + '&publishEmp=' + a_publishEmp + '&content=' +content ;
    if ((taskTag == 't0009' || taskTag == 't13') && messageType == '发起人确认'){
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
