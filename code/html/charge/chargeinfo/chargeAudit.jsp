<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>资费审核</title>
</script>
</head>
<ai:loginuser/>
<body onload="init();">
<%@ include file="/charge/workflow/_chargeFlow.jsp" %>
<ai:contractframe id="chargeInfoframe" contenttype="table" title="资费描述" width="100%" allowcontract="true" frameclosed="true">
<ai:contractitem/>
 <div id="chargeApplyM_div" style="display: none">  
    <ai:dbform formid="chargeAMainframe" 
            setname="com.asiainfo.charge.web.SETChargeMain"
            conditionname="condition" parametersname="parameters"
            editable="true" initial="false" onvalchange=""
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.charge.service.interfaces.IChargeNewMainSV"
            implservice_querymethod="IChargeMainshow(String id)">
        <table width="98%" align="center" border="0">
          <tr>
          	<td class="td_font">申请人：</td>
            <td><ai:dbformfield formid="chargeAMainframe" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
                <ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_2" width="150" editable="false" />
                <ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_1" width="200" editable="" visible="false"/>
	            <ai:dbformfield formid="chargeAMainframe" fieldname="MAIN_ID" width="200" editable="" visible="false"/>
	            <ai:dbformfield formid="chargeAMainframe" fieldname="STATE" width="200" editable="" visible="false"/></td>
            <td class="td_font">申请单位：</td>
            <td><ai:dbformfield formid="chargeAMainframe" fieldname="ORG" width="130" editable="false" visible="false" />
                <ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_3" width="150" editable="false" /></td>
           </tr> 
        </table>
    </ai:dbform>
   
 <ai:contractframe id="chargeApplyMain" contenttype="table" title="已保存的资费主信息" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:table
        tableid="chargeApplyMainTable"
        setname="com.asiainfo.charge.web.SETChargeApplyMain"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.charge.service.interfaces.IChargeNewMainSV"
        implservice_querymethod="getApplyMainsByMainId(String mainid)"
        initial="false"  multiselect="" ondbclick="" onrowchange="showApplyMain"
        pagesize="15" editable="false" width="100%" rowheight=""
        height="100" needrefresh="true">
        	<ai:col title="批次ID" fieldname="APPLY_ID" visible=""/>
            <ai:col title="名称" fieldname="APPLY_NAME" width="20%" />
            <ai:col title="资费类型" fieldname="FEE_TYPE" width="20%" />
        	<ai:col title="细分市场" fieldname="MARKET_TYPE" width="10%"/>
            <ai:col title="开始时间" fieldname="APPLY_TIME" width="20%" />
            <ai:col title="结束时间" fieldname="APPLY_END_TIME" width="20%" />
    </ai:table>
 </ai:contractframe>
 </div>
 
    <ai:dbform formid="chargeMainframe" 
            setname="com.asiainfo.charge.web.SETChargeApplyMain"
            conditionname="condition" parametersname="parameters"
            onvalchange="" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
            implservice_querymethod="IChargeMainshow(String id)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        <tr>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="STAFFNAME" width="150" editable="" visible="false"/>
                </td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="ORG" width="130" editable="false" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="ORGNAME" width="130" editable="" visible="false"/></td>
           </tr> 
               <tr>
                </td>
                 <td class="td_font">资费类型：</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="FEE_TYPE" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">细分市场：</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="MARKET_TYPE" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">品牌：</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="SALE_FASHION" width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">开始时间：</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_TIME" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">结束时间：</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_END_TIME" width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr >
	        	<td class="td_font">电子渠道承载：</td>
	        	<td colspan="5" ><ai:dbformfield formid="chargeMainframe" fieldname="E_CHANNEL_BEAR" width="10" visible="false"/>
	        		<input type="checkbox" id="hint0_input" value="0" onclick="checkboxSts(0);"  />短厅&nbsp;
	        		<input type="checkbox" id="hint1_input" value="1" onclick="checkboxSts(1);"  />网厅&nbsp;
	               	<input type="checkbox" id="hint2_input" value="2" onclick="checkboxSts(2);" />WAP厅&nbsp;
	               	<input type="checkbox" id="hint3_input" value="3" onclick="checkboxSts(3);" />微厅&nbsp;
	               	<input type="checkbox" id="hint4_input" value="4" onclick="checkboxSts(4);" />和悦会&nbsp;
	               	<input type="checkbox" id="hint5_input" value="5" onclick="checkboxSts(5);" />手机营业厅APP&nbsp;
	               	<input type="checkbox" id="hint6_input" value="6" onclick="checkboxSts(6);" />移动商城PC版&nbsp;
	               	<input type="checkbox" id="hint7_input" value="7" onclick="checkboxSts(7);" />触屏版&nbsp;
	               	<input type="checkbox" id="hint8_input" value="8" onclick="checkboxSts(8);"  />外部电商</td>
        	</tr>
            <tr>
                <td class="td_font">资费案名称：</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_NAME" width="600"/><span class="font_red">*</span>
                <ai:dbformfield formid="chargeMainframe" fieldname="APPLY_ID" width="50" visible="false"/>
                  <ai:dbformfield formid="chargeMainframe" fieldname="MAIN_ID" width="50" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="IS_SUBMIT" width="150"  visible="false"/>
            </tr>
          <tr>
                <td class="td_font">推广渠道：</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="EXTEND_CHANNEL" editable="false"  width="600"/>
                <img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="channelMultiplySelected();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
                </td>
            </tr>
            <tr>
                <td class="td_font">宣传口号：</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="FLACK" height="" width="800"/><span class="font_red">*</span><br></td>
            </tr>
               <tr>
                  <td class="td_font">背景：</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="BACK_GROUND" height="50" width="800"/><span class="font_red">*</span></td>
            </tr>
             <tr>
                <td class="td_font">目的：</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_MARK" height="50" width="800"/><span class="font_red">*</span><br></td>
            </tr>
            <tr>
              <td class="td_font">用户调研情况：</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="USER_CIRCS" height="50" width="800"/><span class="font_red">*</span></td>
            </tr>
                <tr>
                <td class="td_font">目标用户消费特点：</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="CONSUME_ANALYSE" height="50" width="800"/><span class="font_red">*</span></td>
            </tr>
          </table>
    </ai:dbform>
<div id='eChnlCommand_div1' style="display: none;">
<ai:contractframe id="EChannelNcodeCommand" contenttype="table" title="短厅指令与NCODE列表" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem>
    	<ai:button id="bt_addEChannelNcodeCommand" text="新增" onclick="addEChannelNcodeCommand()"/>
    	<ai:button id="bt_delUEChannelNcodeCommand" text="删除（勾选项）" onclick="doWork('delEchannelNcodeCommand()')"/>
    	<span class="font_red">（"名称,开通指令,取消指令"请由发起人填写；"NCODE"由业支配置NCODE人员填写；"主体资费,产品包,增值产品,产品包,基础产品,附加属性,业务规则"请由配置人员填写）</span>
    </ai:contractitem>
    <ai:table
        tableid="EChannelNcodeCommandListTable"
        setname="com.asiainfo.charge.web.SETEchannelNcodeCommand"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.charge.service.interfaces.IEchannelNcodeCommandSV"
        implservice_querymethod="getEchannelNcodeCommandByRelaId(String relaId,String infoType, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getCnEchannelNcodeCommandListByRelaId(String relaId,String infoType)"
        initial="false"  multiselect="true"
        pagesize="15" editable="true" width="100%"
        height="120" needrefresh="true">
        <ai:col fieldname="NAME" width="10%" />
        <ai:col fieldname="OPEN_COMMAND" width="7%" />
        <ai:col fieldname="CANCEL_COMMAND" width="7%" />
        <ai:col fieldname="NCODE" width="6%"/>
        <ai:col fieldname="PRI_TARIFF" width="10%"/>
        <ai:col fieldname="PROD_PACKAGE" width="10%" />
        <ai:col fieldname="G_PRODUCT" width="10%" />
        <ai:col fieldname="PROD_PACKAGE2" width="7%"/>
		<ai:col fieldname="BASE_PRODUCT" width="7%" />
        <ai:col fieldname="ADD_ATTR" width="10%" />
		<ai:col fieldname="BUSI_RULE" width="16%" />
		<ai:col fieldname="INFO_TYPE" width="15%" visible="false"/>
		<ai:col fieldname="REL_ID" width="15%" visible="false"/>
    </ai:table>
</ai:contractframe>
</div>

  <div id="modifyMain_bt_div" class="area_button">
   <ai:button text="修改资费主信息" id="query3" onclick="doWork('updateChargeMain()')" />&nbsp;&nbsp;
   <ai:button text="保存资费主信息" id="query2" onclick="doWork('addChargeMain()')" />&nbsp;&nbsp;
  </div>
  
  <div id="saveEchl_bt_div" class="area_button" style="display: none">
   	<ai:button text="保存短厅指令与NCODE" id="saveNcode" onclick="doWork('saveEChannelNcodeCommandc()')" />&nbsp;&nbsp;
  </div>
  
 <ai:contractframe id="chargeDetailListframe" contenttype="table" title="" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem>
    <ai:button id="bt_addChargeDetail" text="新增资费"  onclick="addChargeDetail()"/> 
    <ai:button id="bt_delChargeDetail" text="删除资费"  onclick="delChargeDetail()"/>
    <ai:button id="bt_showChargeDetailinfo" text="查看资费信息"  onclick="showChargeDetail()"/>
  </ai:contractitem>
    <ai:table
        tableid="chargeDetailListTable"
        setname="com.asiainfo.charge.web.SETChargeInfo"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
        implservice_querymethod="getChargeDetailByFeeType(String mainId, String feetype, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getCountByFeeType(String mainId, String feetype)"
        initial="false"  multiselect="" ondbclick="showChargeDetail" onrowchange=""
        pagesize="15" editable="false" width="100%" rowheight="50"
        height="180" needrefresh="true">
        	<ai:col title="资费明细ID" fieldname="MID" visible="false"/>
            <ai:col title="类型" fieldname="CHARGE_TYPE" width="8%"/>
            <ai:col title="名称" fieldname="FEE_NAME" width="12%" />
            <ai:col title="系统生成编码" fieldname="CASE" width="140" />
        	<ai:col title="BOSS系统编码" fieldname="INADD_USER_COUNT" width="140"/>
        	<ai:col fieldname="DOOR_DAMNIFY" width="80"/>
        	<ai:col title="套餐信息" fieldname="EXT5" width="20%"/>
        	<ai:col fieldname="FEE_MARK" width="50%"/>
            <ai:col title="套餐内" fieldname="ADD_USER_MARKET" width="20%" />
            <ai:col title="套餐外" fieldname="SPLICE_MUTEX_RULE" width="20%" />
            <ai:col title="套餐" fieldname="EARNING_TOTAL" width="20%"/>
            <ai:col title="是否需要短信提醒" fieldname="IS_SEND_SMS" visible="false" />
            <ai:col title="静态损益总和" fieldname="DOOR_EARNING" width="8%"/>
            <ai:col title="动态损益总和" fieldname="EARNING_DAMNIFY" width="8%" />
            <ai:col title="新资费档次标识" fieldname="EXT6" visible="false" />
    </ai:table>
  </ai:contractframe>
  <div id="wf1_div" style="display: block">
		<% String taskTag =request.getParameter("taskTag");
		   String audit1_jsp = "/charge/workflow/_blank.jsp";
		   if (taskTag.endsWith("-m")||taskTag.equals("YQ001")) {
			    audit1_jsp = "/charge/workflow/_submitWF.jsp";
		   } 
		%>  
		<jsp:include page="<%=audit1_jsp %>"></jsp:include>
  </div>
</ai:contractframe>
<div id='e_channel_exp' style="display: none;">
	<%@include file="/charge/include/_explan.jsp"%>
</div>
<div id="appr_div" style="display: block">  
	<%@include file="/charge/include/_chargeEstSignAppr.jsp"%>
</div>
<div id="cfg_div" style="display: block">  
	<%@include file="/charge/include/_chargeConf.jsp"%>
</div>
<div id="test_div" style="display: block">  
	<%@include file="/charge/include/_chargeTest.jsp"%>
</div>
<div id="fujian">
	<%@ include file="/charge/include/_attach.jsp" %>
</div>
</body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script type="text/javascript">
var rid = "<%=request.getParameter("recordId")%>";
var _mainId =  "<%=request.getParameter("recordId")%>";
var applyId="<%=request.getParameter("recordId")%>";
var taskTag="<%=request.getParameter("taskTag")%>";
var _fromChargeMainFormRowSet= g_FormRowSetManager.get("chargeMainframe");
var _fromChargeAMainFormRowSet= g_FormRowSetManager.get("chargeAMainframe");
var chargeDetailListTable=g_TableRowSetManager.get("chargeDetailListTable");
var chargeApplyMainTable=g_TableRowSetManager.get("chargeApplyMainTable");
var _EChannelNcodeCommandListTab = g_TableRowSetManager.get("EChannelNcodeCommandListTable");
var _EChannelNcodeCommandListTab2 = g_TableRowSetManager.get("EChannelNcodeCommandListTable2");

function init(){
	initChargeDesc();
	var state = _fromChargeAMainFormRowSet.getValue("STATE");
	initChargeFlow(state, _fromChargeAMainFormRowSet.getValue("ORG"), taskTag, _mainId);
	if (state == 1) {
		document.all("contractFrame_chargeInfoframe").style.display='block';
	} else {
		initEstAsgPage();
		initCfgPage();
		initTestPage();
	}
	if (taskTag != "") {
		initCheckPage();
	} else {
		document.all("contractFrame_chargeInfoframe").style.display='block';
	}
	include_reflashAttachTable();
	if(taskTag=='st4-ch2-conf'||taskTag=='st4-ch4-conf'||taskTag=='st4-ch5-conf'){
		if(_fromChargeMainFormRowSet.getValue("E_CHANNEL_BEAR").indexOf("0")==0){
			document.getElementById("eChnlCommand_div2").style.display="block";
		}
		
	}
}

function initChargeDesc() {
	if(!taskTag.endWith("-m")){
		_fromChargeAMainFormRowSet.setEditSts(false);
		_fromChargeMainFormRowSet.setEditSts(false);
		setEChannelNcodeCommandEditSts(false);
		document.getElementById("modifyMain_bt_div").style.display="none";
		g_AIButtonManager.get("query2").setDisabled(true);
		g_AIButtonManager.get("query3").setDisabled(true);
		g_AIButtonManager.get("bt_addChargeDetail").setDisabled(true);
		g_AIButtonManager.get("bt_delChargeDetail").setDisabled(true);
	} else {
        document.all("contractFrame_chargeInfoframe").style.display='block';
	}
	if(taskTag=="YQ001"){
		document.all("contractFrame_chargeInfoframe").style.display='block';
	}
	
	if (_mainId == null || _mainId == 'null' || _mainId == '') return;
	_fromChargeAMainFormRowSet.refresh("&id="+applyId);
	chargeApplyMainTable.refresh("&mainid="+applyId);
	chargeApplyMainTable.setFocus(0,0);
}

function addChargeMain(){
	var applyName=_fromChargeMainFormRowSet.getValue("APPLY_NAME");
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	var applyTime=_fromChargeMainFormRowSet.getValue("APPLY_TIME");
	var applyEndTime=_fromChargeMainFormRowSet.getValue("APPLY_END_TIME");
	var extchannel=_fromChargeMainFormRowSet.getValue("EXTEND_CHANNEL");
	var flack=_fromChargeMainFormRowSet.getValue("FLACK");
	var background=_fromChargeMainFormRowSet.getValue("BACK_GROUND");
	var amark=_fromChargeMainFormRowSet.getValue("APPLY_MARK");
	var usercircs=_fromChargeMainFormRowSet.getValue("USER_CIRCS");
	var analyse=_fromChargeMainFormRowSet.getValue("CONSUME_ANALYSE");
	var eChnlBearChBox = getHintCheckBoxVal();
	_fromChargeMainFormRowSet.setValue("E_CHANNEL_BEAR",eChnlBearChBox);
	if(eChnlBearChBox.indexOf("0")==0){
		if(_EChannelNcodeCommandListTab.count()==0){
			return  alert("请在短厅指令与NCODE列表配置短厅指令！");
		}
	}
	//检查必填项
	if(""==applyName) {return  alert("请输入资费活动名称！");}
	if(""==feeType) {return  alert("请输入资费类型！");}
	if(""==applyTime) {return  alert("请输入资费活动开始时间！");}
	if(""==extchannel) {return  alert("请输入推广渠道！");}
	if(""==flack) {return  alert("请输入宣传口号！");}
	if(""==background) {return  alert("请输入背景！");}
	if(""==amark) {return  alert("请输入目的！");}
	if(""==usercircs) {return  alert("请输入用户调研情况！");}
	if(""==analyse) {return  alert("请输入目标用户消费特点！");}
	if(""==applyEndTime) {applyEndTime=addDate(6,1,applyTime);}
	if(1 == g_CompareDate(applyTime,applyEndTime)) { return alert("活动案结束时间不能小于开始时间！");}

	if ("O" != _fromChargeMainFormRowSet.getSts())
	{
		_fromChargeAMainFormRowSet.setValue("REAMRK_1", _fromChargeMainFormRowSet.getValue("APPLY_NAME"));
		if ("N" == _fromChargeAMainFormRowSet.getSts())
	    {
	    	var chargeOrderList = new Array();
		    chargeOrderList.push(_fromChargeAMainFormRowSet);
		    var actionUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=saveChargeNewMain&applyid=0';
		    var ret = saveRowSet(actionUrl, chargeOrderList);
		    var orderId = ret.getValueByName("NewMainID");
		    _fromChargeAMainFormRowSet.refresh("&id="+orderId);
		    if (orderId == "" || orderId == null) {
		    	return alert("保存失败!");
		    }
	    }
		_mainId = _fromChargeAMainFormRowSet.getValue("MAIN_ID");
		_fromChargeMainFormRowSet.setValue("MAIN_ID", _mainId);
	    var list = new Array();
	    list.push(_fromChargeMainFormRowSet);
	    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=saveChargeMain&applyid=0';
	    var recode = saveRowSet(strUrl, list);
	    var mainId = recode.getValueByName("MAINID");
	    _fromChargeMainFormRowSet.setValue("APPLY_ID",mainId);
	    var rFlag = recode.getValueByName("FLAG");
	    if (rFlag == "Y") chargeApplyMainTable.refresh("&mainid="+_mainId);
	 }
    chargeDetailListTable.refresh("&mainId="+_fromChargeMainFormRowSet.getValue("APPLY_ID")+"&feetype="+feeType);

    saveEChannelNcodeCommand(_fromChargeMainFormRowSet.getValue("APPLY_ID"), "y");
    setEChannelNcodeCommandEditSts(false);
    g_AIButtonManager.get("query2").setDisabled(true);
	g_AIButtonManager.get("query3").setDisabled(false);
	_fromChargeMainFormRowSet.setEditSts(false);
	showTableOn();

}

function delChargeDetail(){
 	var ss = new Array();
    ss = chargeDetailListTable.getSelectedRows();
    if (ss.length < 1) {
        alert("请选择要删除的数据！");
        return;
    }
    for ( var i = ss.length; i > 0; i--) {
        chargeDetailListTable.deleteRow(ss[i - 1]);
    }
    var list = new Array();
    list.push(chargeDetailListTable);
    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainDeAction?action=saveChargeMainDe';
    var recode = saveRowSet(strUrl, list);
}

function zdyxdMultiplySelected(){
	var url = "<%=request.getContextPath()%>/sale/common/modaldialog/SaleZDYXDMultiplySelected.jsp";
	var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
	var iniVal = _fromChargeMainFormRowSet.getValue("SALE_FASHION");
	_fromChargeMainFormRowSet.setValue("SALE_FASHION",onItemMultiplySelected(url, iniVal, style));
}

function addChargeDetail(){
	var applyId=_fromChargeMainFormRowSet.getValue("APPLY_ID");
	if(""==applyId){
		return alert("请先保存资费主信息！");
	}
	var feeName=_fromChargeMainFormRowSet.getValue("APPLY_NAME");
	var taskId="<%=request.getParameter("taskId")%>";
	if(""==applyId){
		return alert("请先保存资费批次信息！");
	}
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	//0918
	var zfbmmark=_fromChargeMainFormRowSet.getValue("MARKET_TYPE");
	var typecards=_fromChargeMainFormRowSet.getValue("SALE_FASHION");
	var isNewFee = "1" //新增资费档次默认 新的资费结构页面
	var url = "<%=request.getContextPath()%>/charge/chargeinfo/chargeDetail.jsp?" +
	          "applyId="+applyId+"&feeType="+feeType+"&feeName="+feeName+
	          "&taskId="+taskId+"&zfbmmark="+zfbmmark+"&typecards="+typecards+
	          "&isNewFee="+isNewFee;
	var returnP=window.open(url,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}


function showChargeDetail(){
	var feeName=_fromChargeMainFormRowSet.getValue("APPLY_NAME");
	var state=_fromChargeAMainFormRowSet.getValue("STATE");
	var curRow = chargeDetailListTable.getRow();
	var mid = chargeDetailListTable.getValue(curRow,"MID");
	var isSendSmsVal=chargeDetailListTable.getValue(curRow,"IS_SEND_SMS");  
	
	var applyId=_fromChargeMainFormRowSet.getValue("APPLY_ID");
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	var taskId="<%=request.getParameter("taskId")%>";
	if(mid==""){
		return alert("请选择一行数据！");
	}
	var applyId=_fromChargeMainFormRowSet.getValue("APPLY_ID");
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	var typecards=_fromChargeMainFormRowSet.getValue("SALE_FASHION");
	
	var isNewFee = chargeDetailListTable.getValue(curRow,"EXT6"); //显示资费档次详细时 根据charge_info_t.EXT6字段来判断是否是新的资费结构页面
	if(taskTag.endWith("-m")){
		state = 1;
	} else {
		state = 2;
	}
	var url = "<%=request.getContextPath()%>/charge/chargeinfo/chargeDetail.jsp?" +
			  "applyId="+applyId+"&feeType="+feeType+"&mid="+mid+"&feeName="+feeName+
			  "&state="+state+"&taskId="+taskId+"&isSendSmsVal="+isSendSmsVal+
			  "&isNewFee="+isNewFee + "&taskTag=" + taskTag;
	window.open(url,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no"); 
}

function addChargeMainNew(){
	if(window.confirm("新建资费案会清空未保存的营销案信息，确定要新建吗？"))
    {
        location.reload();
    }
}


function  updateChargeMain(){
		init();
		_fromChargeMainFormRowSet.setEditSts(true);
		_fromChargeMainFormRowSet.setColEditSts("PRINCIPLE",false);
		_fromChargeMainFormRowSet.setColEditSts("ORG",false);
		//document.getElementById("include").style.display="none";
	    g_AIButtonManager.get("query3").setDisabled(true);
		g_AIButtonManager.get("query2").setDisabled(false);
		setEChannelNcodeCommandEditSts(true);
}


function showEndTime(pFieldName,pOldVal,pOldText,pNewVal,pNewText){
	if(pFieldName=="APPLY_TIME"){
		if(""!=pFieldName){
			_fromChargeMainFormRowSet.setValue("APPLY_END_TIME",addDate(6,1,_fromChargeMainFormRowSet.getValue("APPLY_TIME")));
		}
	}
	if(pFieldName=="FEE_TYPE"){
		showTableOn();
	}
}

function closePage(){
   	window.opener.location.reload();
    window.self.close();
}

function showTableOn(){
	if("41"==_fromChargeMainFormRowSet.getValue("FEE_TYPE")||"31"==_fromChargeMainFormRowSet.getValue("FEE_TYPE")){
		chargeDetailListTable.setColVisible("ADD_USER_MARKET",false);
		chargeDetailListTable.setColVisible("SPLICE_MUTEX_RULE",false);
		chargeDetailListTable.setColVisible("EARNING_TOTAL",true);
	} else {
		chargeDetailListTable.setColVisible("ADD_USER_MARKET",true);
		chargeDetailListTable.setColVisible("SPLICE_MUTEX_RULE",true);
		chargeDetailListTable.setColVisible("EARNING_TOTAL",false);
	}
}

function checkHasEmptyBossid(){
    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=checkChargeBossid&mainid='+_mainId;
    var recode = PostInfo(strUrl, null);
    var check=recode.getValueByName("check");
	if(check=="N"){
		return false;
	} else {
		return true;
	}
}

function showApplyMain(){
	
	var curRow = chargeApplyMainTable.getRow();
	var applyId=chargeApplyMainTable.getValue(curRow,"APPLY_ID");
	_fromChargeMainFormRowSet.refresh("&id="+applyId);
	var eChnlBear = _fromChargeMainFormRowSet.getValue("E_CHANNEL_BEAR");
   	 if(eChnlBear==null){
    	setCheckBox(null);
     }else{
    	setCheckBox(eChnlBear.toString());
   	 }
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	chargeDetailListTable.refresh("&mainId="+applyId+"&feetype="+feeType);
	_EChannelNcodeCommandListTab.refresh("&relaId="+applyId+"&infoType=cha");
	_EChannelNcodeCommandListTab2.refresh("&relaId="+applyId+"&infoType=cha");
}

function selectFile(type,colNum) {
	var retVal = window.showModalDialog('<%=request.getContextPath()%>/charge/include/_fileSelectDlg.jsp?colNum='+colNum, null, "scroll:no;resizable:no;help:no;status:no;dialogHeight:100px;dialogWidth:560px");
	if (retVal == "" || retVal == undefined) return;
	var targetTab;
 	if (type == 'i_test') {
  		targetTab = chargeInnerTestTab;
 	} else if (type == 'e_test') {
  		targetTab = chargeExternTestTab;
 	} else if (type == 'cfg') {
  		targetTab = chargeCfgTab;
 	} 
	if (type.endWith("test")){
		targetTab.clear();
	    var rows = retVal.split("|");
		for (var i = 0; i < rows.length; ++i) {
			targetTab.newRow(false);
			targetTab.setValue(i,"TEST_FACTOR",rows[i].split("-")[0]);
			targetTab.setValue(i,"TEST_RESULT",rows[i].split("-")[1]);
			targetTab.setValue(i,"REASON",rows[i].split("-")[2]);
			targetTab.setValue(i,"ORDER_ID",_mainId);
		}
 	} else if (type.endWith("cfg")) {
 		targetTab.clear();
	    var rows = retVal.split("|");
 		for (var i = 0; i < rows.length; ++i) {
			targetTab.newRow(false);
			targetTab.setValue(i,"FACTOR",rows[i].split("-")[0]);
			targetTab.setValue(i,"MOLD",rows[i].split("-")[1]);
			targetTab.setValue(i,"DESC",rows[i].split("-")[2]);
			targetTab.setValue(i,"MODE",rows[i].split("-")[3]);
			targetTab.setValue(i,"ORDER_ID",_mainId);
		}
 	} 
}

function doOnFinish(aUserDataXml){
  var aFlag=getReturnValueByName(aUserDataXml,"FLAG");
  var aMsg=getReturnValueByName(aUserDataXml,"MESSAGE");
  var targetTab;
  var type = getReturnValueByName(aUserDataXml,"TYPE");
  if (type == 'i_test') {
	  targetTab = chargeInnerTestTab;
  } else if (type == 'e_test') {
	  targetTab = chargeExternTestTab;
  } else if (type == 'cfg') {
	  targetTab = chargeCfgTab;
  } 
  if (aFlag=="Y" && type.endWith("test")){
	targetTab.clear();
    var confs = getReturnValueByName(aUserDataXml,"confs");
    var rows = confs.split("|");
	for (var i = 0; i < rows.length; ++i) {
		targetTab.newRow(false);
		targetTab.setValue(i,"TEST_FACTOR",rows[i].split("-")[0]);
		targetTab.setValue(i,"TEST_RESULT",rows[i].split("-")[1]);
		targetTab.setValue(i,"REASON",rows[i].split("-")[2]);
	}
  } else if (aFlag=="Y" && type.endWith("cfg")) {
	 targetTab.clear();
     var confs = getReturnValueByName(aUserDataXml,"confs");
     var rows = confs.split("|");
	 for (var i = 0; i < rows.length; ++i) {
		targetTab.newRow(false);
		targetTab.setValue(i,"FACTOR",rows[i].split("-")[0]);
		targetTab.setValue(i,"MOLD",rows[i].split("-")[1]);
		targetTab.setValue(i,"DESC",rows[i].split("-")[2]);
		targetTab.setValue(i,"MODE",rows[i].split("-")[3]);
	}
  } else if (aFlag=="Y") {
	  include_reflashAttachTable();
  } else {
	   alert(aMsg);
  }
}

function addEChannelNcodeCommand() {
	_EChannelNcodeCommandListTab.newRow(false);
	var curRow = _EChannelNcodeCommandListTab.getCurRowIndex();
	_EChannelNcodeCommandListTab.setValue(curRow,"INFO_TYPE", 'cha');
}

function delEChannelNcodeCommand() {
	var delEChannelNcodeCommandList = new Array();
	delEChannelNcodeCommandList = _EChannelNcodeCommandListTab.getSelectedRows();
	var delEChannelNcodeCommandRc = delEChannelNcodeCommandList.length;
    if (delEChannelNcodeCommandRc < 1) {
        return alert("请勾选要删除的记录！");
    }
    var relId = _EChannelNcodeCommandListTab.getValue(0,"REL_ID");
    while (delEChannelNcodeCommandRc > 0) {
	    delEChannelNcodeCommandRc--;
	    _EChannelNcodeCommandListTab.deleteRow(delEChannelNcodeCommandList[delEChannelNcodeCommandRc]);
    }
    if (relId == null || relId==""){
    	return;
    }
    saveEChannelNcodeCommand("", "y");
}

function saveEChannelNcodeCommand(levId, alertFlag) {
	if (levId != null && levId != "") {
		for (var i=0; i< _EChannelNcodeCommandListTab.getTotalRowCount(); ++i) {
			_EChannelNcodeCommandListTab.setValue(i, "REL_ID", levId);
		}
	} else {
		levId = _fromChargeMainFormRowSet.getValue("APPLY_ID");
		
	}
	var list = new Array();
	list.push(_EChannelNcodeCommandListTab);
  	var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.EchannelNcodeCommandAction?action=save';
	var recode = saveRowSet(strUrl, list);
  	var rFlag = recode.getValueByName("FLAG");
  	if (alertFlag == 'y' && rFlag == 'Y') {
  		alert("操作成功！");
  	} else if (alertFlag == 'y' && rFlag == 'N') {
  		alert("操作失败！");
  	}
	_EChannelNcodeCommandListTab.refresh("&relaId="+levId+"&infoType=cha");
	_EChannelNcodeCommandListTab2.refresh("&relaId="+levId+"&infoType=cha");
}

function saveEChannelNcodeCommandb() {
	var list = new Array();
	list.push(_EChannelNcodeCommandListTab2);
  	var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.EchannelNcodeCommandAction?action=save';
	var recode = saveRowSet(strUrl, list);
  	var rFlag = recode.getValueByName("FLAG");
  	if ( rFlag == 'Y') {
  		alert("操作成功！");
  	} else if (rFlag == 'N') {
  		alert("操作失败！");
  	}
}

function saveEChannelNcodeCommandc() {
	var list = new Array();
	list.push(_EChannelNcodeCommandListTab);
  	var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.EchannelNcodeCommandAction?action=save';
	var recode = saveRowSet(strUrl, list);
  	var rFlag = recode.getValueByName("FLAG");
  	if ( rFlag == 'Y') {
  		alert("操作成功！");
  	} else if (rFlag == 'N') {
  		alert("操作失败！");
  	}
}

function setEChannelNcodeCommandEditSts(flag){
	_EChannelNcodeCommandListTab.setEditSts(flag);
	g_AIButtonManager.get("bt_addEChannelNcodeCommand").setDisabled(!flag);
	g_AIButtonManager.get("bt_delUEChannelNcodeCommand").setDisabled(!flag);
	//_addEChannelNcodeCommandBtn.setDisabled(!flag);
	//_delEChannelNcodeCommandBtn.setDisabled(!flag);
}

function checkboxSts(pos) {
	if(pos == 0){
		if(true == document.getElementById('hint0_input').checked){
			document.getElementById("eChnlCommand_div1").style.display="block";
		} else {
			document.getElementById("eChnlCommand_div1").style.display="none";
		}
	}
	if(pos>0&&pos<9){
		var checkflag = false;
		for(var i=1;i<9;i++){
			checkflag = document.getElementById('hint'+i+'_input').checked;
			if(checkflag) break;
		}
		if(checkflag){
			document.getElementById("e_channel_exp").style.display="block";
		} else {
			document.getElementById("e_channel_exp").style.display="none";
		}
	}	
}

function getHintCheckBoxVal(){
	var hintVal = ""; 
   	for(var pos = 0; pos < 9; ++pos){
    	if (document.getElementById("hint" + pos + "_input").checked) {
      		if (hintVal != ""){
            	hintVal += ";";
          	}
      		hintVal += document.getElementById("hint" + pos + "_input").value;
        }
    }
    return hintVal;
}

function setCheckBox(hintVal) {
	document.getElementById("hint0_input").checked = false;
    document.getElementById("hint1_input").checked = false;
    document.getElementById("hint2_input").checked = false;
    document.getElementById("hint3_input").checked = false;
	document.getElementById("hint4_input").checked = false;
    document.getElementById("hint5_input").checked = false;
    document.getElementById("hint6_input").checked = false;
    document.getElementById("hint7_input").checked = false;
	document.getElementById("hint8_input").checked = false;
	document.getElementById("e_channel_exp").style.display="none";
	document.getElementById("eChnlCommand_div1").style.display="none";
	g_AIButtonManager.get("saveNcode").setDisabled(true);
	if(hintVal != null && hintVal != ""){
    	var hintVec = hintVal.split(";");
    	for(var i = 0; i < hintVec.length; i++){
    		document.getElementById("hint"+hintVec[i] + "_input").checked = true;
    		if(hintVec[i]==0){
				document.getElementById("eChnlCommand_div1").style.display="block";
				g_AIButtonManager.get("saveNcode").setDisabled(false);
			}
			if(hintVec[i]>0){
				document.getElementById("e_channel_exp").style.display="block";
			}
    	}
    } 
}

function haveAttch(){
	var e_chlbear = getHintCheckBoxVal();
	
	if(e_chlbear!=null&&e_chlbear!=""){
		
		if(e_chlbear.indexOf('1')>=0||e_chlbear.indexOf('2')>=0||e_chlbear.indexOf('3')>=0||e_chlbear.indexOf('4')>=0||
		e_chlbear.indexOf('6')>=0||e_chlbear.indexOf('7')>=0||e_chlbear.indexOf('8')>=0){
			if(_include_fromAttachFileFormRowSet().count()==0){
				return alert('电渠资费发布附件未上传，请下载模板并填写上传');
				return false;
			}
		}
	}
    return true;
}

String.prototype.endWith=function(str){     
  var reg=new RegExp(str+"$");     
  return reg.test(this);        
}

function trim(str){
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}

</script>




