<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
 <body onload="init();setWebStatus(1);">
  <div id="chargeOrder_div" style="display: none">
  <ai:contractframe id="chargeAMainframe" contenttype="table" title="资费案主信息" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem>
    </ai:contractitem>
    <ai:dbform formid="chargeAMainframe" 
            setname="com.asiainfo.charge.web.SETChargeMain"
            conditionname="condition" parametersname="parameters"
            editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.charge.service.interfaces.IChargeNewMainSV"
            implservice_querymethod="IChargeMainshow(String id)">
        <table width="98%" align="center" border="0" >
          <tr>
             <td><ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_1" width="200" editable="" visible="false"/>
            <ai:dbformfield formid="chargeAMainframe" fieldname="MAIN_ID" width="200" editable="" visible="false"/>
            <ai:dbformfield formid="chargeAMainframe" fieldname="STATE" width="200" editable="" visible="false"/>
                </td>
          <td class="td_font">申请人：</td>
                <td><ai:dbformfield formid="chargeAMainframe" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/></td>
                 <td><ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_2" width="150" editable="false" />
                </td>
                  <td class="td_font">申请单位：</td>
                <td><ai:dbformfield formid="chargeAMainframe" fieldname="ORG" width="130" editable="false" visible="false" /></td>
                <td><ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_3" width="130" editable="false" />
               </td>
           </tr> 
        </table>
        </ai:dbform>
        </ai:contractframe>
  </div>  
  
  <div id="chargeApplyM_div" style="display: none">   
  <ai:contractframe id="chargeApplyMain" contenttype="table" title="已保存的资费主信息" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem></ai:contractitem>
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
        	<ai:col title="细分市场" fieldname="MARKET_TYPE" width="20%"/>
            <ai:col title="开始时间" fieldname="APPLY_TIME" width="20%" />
            <ai:col title="结束时间" fieldname="APPLY_END_TIME" width="20%" />
    </ai:table>
   </ai:contractframe>
  </div>
  
  <ai:contractframe id="chargeMainframe" contenttype="table" title="资费案主要信息" width="100%" allowcontract="true" frameclosed="true">
    <ai:contractitem/>
    <ai:dbform formid="chargeMainframe" 
            setname="com.asiainfo.charge.web.SETChargeApplyMain"
            conditionname="condition" parametersname="parameters"
            onvalchange="showEndTime" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
            implservice_querymethod="IChargeMainshow(String id)">
        <table width="100%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr>
                <td class="td_font">资费案名称：</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_NAME" width="150"/><span class="font_red">*</span>
                <ai:dbformfield formid="chargeMainframe" fieldname="APPLY_ID" width="50" visible="false"/>
                 <ai:dbformfield formid="chargeMainframe" fieldname="MAIN_ID" width="50" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="IS_SUBMIT" width="150"  visible="false"/>
                </td>
                 <td class="td_font">资费类型：</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="FEE_TYPE" width="150"/><span class="font_red">*</span></td>
            </tr>
               <tr>
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
          <tr>
                <td class="td_font">推广渠道：</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="EXTEND_CHANNEL" height="" width="800"/>
          	    <img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="channelMultiplySelected();" align="absmiddle" style="cursor:hand;"/>
           		</td>
            </tr>
            <tr>
                <td class="td_font">宣传口号：</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="FLACK" height="" width="800"/><br></td>
            </tr>
               <tr>
                  <td class="td_font">背景：</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="BACK_GROUND" height="80" width="800"/></td>
            </tr>
             <tr>
                <td class="td_font">目的：</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_MARK" height="80" width="800"/><br></td>
            </tr>
            <tr>
              <td class="td_font">用户调研情况：</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="USER_CIRCS" height="80" width="800"/></td>
            </tr>
                <tr>
                <td class="td_font">目标用户消费特点：</td>
                <td colspan="3"><ai:dbformfield formid="chargeMainframe" fieldname="CONSUME_ANALYSE" height="80" width="800"/></td>
            </tr>
            
          </table>
    </ai:dbform>
</ai:contractframe>
  <div class="area_button">
   <ai:button text="修改资费主信息" id="query3" onclick="doWork('updateChargeMain()')" />&nbsp;&nbsp;
   <ai:button text="保存资费主信息" id="query2" onclick="doWork('addChargeMain()')" />&nbsp;&nbsp;
  </div>
<ai:contractframe id="chargeDetailListframe" contenttype="table" title="已保存的资费明细信息" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem><%--<ai:button id="newSaleDetail" text="新建活动" onclick="newSaleDetail()"/>--%>
  <ai:button id="bt_addChargeDetail" text="新增资费"  onclick="addChargeDetail()"/> <ai:button id="bt_addChargeDetail" text="删除资费"  onclick="delChargeDetail()"/></ai:contractitem>
    <ai:table
        tableid="chargeDetailListTable"
        setname="com.asiainfo.charge.web.SETChargeInfo"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
        implservice_querymethod="getChargeDetailByFeeType(String mainId, String feetype, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getCountByFeeType(String mainId, String feetype)"
        initial="false"  multiselect="" ondbclick="showChargeDetail" onrowchange="initTestResult"
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
<ai:loginuser/>

<div id="include" style="">
<script type="text/javascript">
var _mainId = "<%=request.getParameter("recordId")%>";
</script>
<ai:contractframe id="chargeCfgIframe" contenttype="table" title="资费配置信息" width="100%" allowcontract="true" frameclosed="true">
<ai:contractitem/>
<%@include file="/charge/chargeinfo/chargeCfg.jsp"%>
</ai:contractframe>
<%@include file="/charge/chargeinfo/chargeDevInfo.jsp"%>
<%@include file="/charge/include/_chargeTestProdAttrCheck.jsp"%>
<%@include file="/sale/common/include/_check.jsp"%>
</div>
  </body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script type="text/javascript">
var _fromChargeMainFormRowSet= g_FormRowSetManager.get("chargeMainframe");
var _fromChargeAMainFormRowSet= g_FormRowSetManager.get("chargeAMainframe");
var chargeDetailListTable=g_TableRowSetManager.get("chargeDetailListTable");
var chargeApplyMainTable=g_TableRowSetManager.get("chargeApplyMainTable");
var recordId = "<%=request.getParameter("recordId")%>";
var applyid="<%=request.getParameter("applyid")%>";
var taskTag="<%=request.getParameter("taskTag")%>";
function init(){
initCheckPage();
	if("null"==applyid||""==applyid){
		applyid=recordId;
	}
	var id =_fromChargeMainFormRowSet.getValue("APPLY_ID");
	if("null"!=applyid||""==applyid){
		var recordId = "<%=request.getParameter("recordId")%>";
		_fromChargeAMainFormRowSet.refresh("&id="+recordId);
	    chargeApplyMainTable.refresh("&mainid="+recordId);
	    if (chargeApplyMainTable.getTotalRowCount() > 1) {
			document.getElementById("chargeApplyM_div").style.display="block";
		} else if (chargeApplyMainTable.getTotalRowCount() == 1) {
			chargeApplyMainTable.setFocus(0,0);
		} 
		_fromChargeMainFormRowSet.setFocus("STAFFNAME");
	    _fromChargeMainFormRowSet.setFocus("ORGNAME");
	    _fromChargeMainFormRowSet.setEditSts(true);
	    _fromChargeMainFormRowSet.setColEditSts("ORGNAME",false);
		_fromChargeMainFormRowSet.setColEditSts("STAFFNAME",false);
		_fromChargeMainFormRowSet.setEditSts(false);
		var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
		var staffId = g_GetUserInfo().STAFF_ID;
		 g_AIButtonManager.get("query2").setDisabled(true);
		//chargeDetailListTable.refresh("&mainId="+recordId+"&feetype="+feeType);
		showTableOn();
	} else {
		if(""!=id){
			_fromChargeMainFormRowSet.refresh("&id="+id);
			_fromChargeMainFormRowSet.setEditSts(false);
			var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
			var staffId = g_GetUserInfo().STAFF_ID;
			g_AIButtonManager.get("query2").setDisabled(true);
			chargeDetailListTable.refresh("&mainId="+applyid+"&feetype="+feeType);
		} else {
			var staffId = g_GetUserInfo().STAFF_ID;
			g_AIButtonManager.get("query3").setDisabled(true);
		}
	}
	document.getElementById("include").style.display="block";
}

function updateinit(){
		_fromChargeMainFormRowSet.setEditSts(true);
		var id =_fromChargeMainFormRowSet.getValue("APPLY_ID");	
		if (id!="") {	
			_fromChargeMainFormRowSet.refresh("&id="+id);
		}
		var staffId = g_GetUserInfo().STAFF_ID;
		showName();
		_fromChargeMainFormRowSet.setEditSts(true);
		_fromChargeMainFormRowSet.setColEditSts("ORGNAME",false);
		_fromChargeMainFormRowSet.setColEditSts("STAFFNAME",false);
		var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
		var staffId = g_GetUserInfo().STAFF_ID;
		g_AIButtonManager.get("query2").setDisabled(true);
}

function showName(){
	_fromChargeMainFormRowSet.setFocus("STAFFNAME");
    _fromChargeMainFormRowSet.setFocus("ORGNAME");
	_fromChargeMainFormRowSet.setColEditSts("ORGNAME",false);
	_fromChargeMainFormRowSet.setColEditSts("STAFFNAME",false);
}

function addChargeMain(){
	var applyName=_fromChargeMainFormRowSet.getValue("APPLY_NAME");
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	var applyTime=_fromChargeMainFormRowSet.getValue("APPLY_TIME");
	var applyEndTime=_fromChargeMainFormRowSet.getValue("APPLY_END_TIME");
	if(""==applyName){return  alert("请输入资费活动名称！");}
	if(""==feeType){return  alert("请输入资费类型！");}
	if(""==applyTime){return  alert("请输入资费活动开始时间！");}
	if(""==applyEndTime){return  alert("请输入资费活动结束时间！");}
	if(1 == g_CompareDate(applyTime,applyEndTime)){ return alert("活动案结束时间不能小于开始时间！");;}
 	if ("O" != _fromChargeMainFormRowSet.getSts())
    {
    	var list = new Array();
	    list.push(_fromChargeMainFormRowSet);
	    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=saveChargeMain&applyid=0';
	    var recode = saveRowSet(strUrl, list);
	    var mainId = recode.getValueByName("MAINID");
	    _fromChargeMainFormRowSet.setValue("APPLY_ID",mainId);
	    var rFlag = recode.getValueByName("FLAG");
		document.getElementById("include").style.display="block";
		_mainId=mainId;
    } 
    chargeApplyMainTable.refresh("&mainid="+_fromChargeMainFormRowSet.getValue("MAIN_ID"));
	chargeDetailListTable.refresh("&mainId="+_mainId+"&feetype="+feeType);
	g_AIButtonManager.get("query2").setDisabled(true);
	g_AIButtonManager.get("query3").setDisabled(false);
	_fromChargeMainFormRowSet.setEditSts(false);
	showTableOn();
}



function zdyxdMultiplySelected(){
	var url = "<%=request.getContextPath()%>/sale/common/modaldialog/SaleZDYXDMultiplySelected.jsp";
	var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
	var iniVal = _fromChargeMainFormRowSet.getValue("SALE_FASHION");
	_fromChargeMainFormRowSet.setValue("SALE_FASHION",onItemMultiplySelected(url, iniVal, style));
}

function addChargeDetail(){
	var applyId=_fromChargeMainFormRowSet.getValue("APPLY_ID");
	var feeName=_fromChargeMainFormRowSet.getValue("APPLY_NAME");
	if(""==applyId){
		return alert("请先保存资费主信息！");
	}
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	var taskId="<%=request.getParameter("taskId")%>";
	
	var zfbmmark=_fromChargeMainFormRowSet.getValue("MARKET_TYPE");
	var typecards=_fromChargeMainFormRowSet.getValue("SALE_FASHION");
	var isNewFee = "1" //新增资费档次默认 新的资费结构页面
	var returnP=window.open("<%=request.getContextPath()%>/charge/chargeinfo/chargeDetail.jsp?applyId="+applyId+"&feeType="+feeType+"&feeName="+feeName+"&taskId="+taskId+"&zfbmmark="+zfbmmark+"&typecards="+typecards+"&isNewFee="+isNewFee,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no"); 
}

function showChargeDetail(){
	var feeName=_fromChargeMainFormRowSet.getValue("APPLY_NAME");
	var state=_fromChargeMainFormRowSet.getValue("IS_SUBMIT");
	var curRow = chargeDetailListTable.getRow();
	var mid = chargeDetailListTable.getValue(curRow,"MID");
	if(mid==""){
		return alert("请选择一行数据！");
	}
	var applyId=_fromChargeMainFormRowSet.getValue("APPLY_ID");
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	var taskId="<%=request.getParameter("taskId")%>";
	
	var zfbmmark=_fromChargeMainFormRowSet.getValue("MARKET_TYPE");
	var typecards=_fromChargeMainFormRowSet.getValue("SALE_FASHION");
	
	var isSendSmsVal=chargeDetailListTable.getValue(curRow,"IS_SEND_SMS");  
	var isNewFee = chargeDetailListTable.getValue(curRow,"EXT6"); //显示资费档次详细时 根据charge_info_t.EXT6字段来判断是否是新的资费结构页面
	
	window.open("<%=request.getContextPath()%>/charge/chargeinfo/chargeDetail.jsp?applyId="+applyId+"&feeType="+feeType+"&mid="+mid+"&feeName="+feeName+"&state=1"+"&taskId="+taskId+"&zfbmmark="+zfbmmark+"&typecards="+typecards+"&isSendSmsVal="+isSendSmsVal+"&isNewFee="+isNewFee,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no"); 
}

function addChargeMainNew(){
	if(window.confirm("新建资费案会清空未保存的资费案信息，确定要新建吗？"))
    {
        location.reload();
    }
}

function  updateChargeMain(){
	updateinit();
	//document.getElementById("include").style.display="none";
    g_AIButtonManager.get("query3").setDisabled(true);
	g_AIButtonManager.get("query2").setDisabled(false);
	_fromChargeMainFormRowSet.setColEditSts("FEE_TYPE",false);
	_fromChargeMainFormRowSet.setColEditSts("MARKET_TYPE",false);
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

function addDate(type,NumDay,dtDate) 
{ 
	var date = new Date(StringToDate(dtDate)); 
	type = parseInt(type) //类型 
	var lIntval = parseInt(NumDay)//间隔 
	switch(type) 
	{ 
		case 6 ://年 
		date.setYear(date.getFullYear() + lIntval) 
		break; 
		case 7 ://季度 
		date.setMonth(date.getMonth() + (lIntval * 3) ) 
		break; 
		case 5 ://月 
		date.setMonth(date.getMonth() + lIntval) 
		break; 
		case 4 ://天 
		date.setDate(date.getDate() + lIntval) 
		break 
		case 3 ://时 
		date.setHours(date.getHours() + lIntval) 
		break 
		case 2 ://分 
		date.setMinutes(date.getMinutes() + lIntval) 
		break 
		case 1 ://秒 
		date.setSeconds(date.getSeconds() + lIntval) 
		break; 
		default: 
	} 
	var month= date.getMonth()+1;
	var second=date.getDate();
	
	return date.getFullYear() + '-' + month + '-' +second +dtDate.substr(10); 
} 

StringToDate=function(DateStr){
    if(typeof DateStr=="undefined")return new Date();
	if(typeof DateStr=="date")return DateStr;
	var converted = Date.parse(DateStr);
	var myDate = new Date(converted);
	if(isNaN(myDate)){
		DateStr=DateStr.replace(/:/g,"-");
		DateStr=DateStr.replace(" ","-");
		DateStr=DateStr.replace(".","-");
		var arys= DateStr.split('-');
		switch(arys.length){
			case 7 : myDate = new Date(arys[0],--arys[1],arys[2],arys[3],arys[4],arys[5],arys[6]);break;
			case 6 : myDate = new Date(arys[0],--arys[1],arys[2],arys[3],arys[4],arys[5]);break;
			default: myDate = new Date(arys[0],--arys[1],arys[2]);break;
		};
	};
	return myDate;
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

function closePage(){
   	window.opener.location.reload();
    window.self.close();
}

function channelMultiplySelected(){
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/SaleChannelMultiplySelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = _fromChargeMainFormRowSet.getValue("EXTEND_CHANNEL");
    _fromChargeMainFormRowSet.setValue("EXTEND_CHANNEL",onItemMultiplySelected(url, iniVal, style));
}

function onrowchange1(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	chargeDetailListTable.setRowBgColor(oldIndex,"");
    }
    chargeDetailListTable.setRowBgColor(newIndex,"yellow");
}

function showApplyMain(){
	if(AIContractFrame_closeMe()){
	} else {
	  AIContractFrame_OpenClose("chargeMainframe");
	}
	var curRow = chargeApplyMainTable.getRow();
	var applyid=chargeApplyMainTable.getValue(curRow,"APPLY_ID");
	_fromChargeMainFormRowSet.refresh("&id="+applyid);
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	chargeDetailListTable.refresh("&mainId="+applyid+"&feetype="+feeType);
}

function addChargePc(){
	_fromChargeMainFormRowSet.newRow();
	chargeDetailListTable.clear();
	if(AIContractFrame_closeMe()){
	} else {
	  	AIContractFrame_OpenClose("chargeMainframe");
	}
	if(_fromChargeAMainFormRowSet.getValue("REAMRK_1")==""){
		return alert("请输入工单名称!");
	}
	var newMainid=_fromChargeAMainFormRowSet.getValue("MAIN_ID");
	
	if(newMainid==""){
		if ("O" != _fromChargeAMainFormRowSet.getSts()){
		    var list = new Array();
			list.push(_fromChargeAMainFormRowSet);
		    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=saveChargeNewMain&applyid=0';
		    var recode = saveRowSet(strUrl, list);
		    var mainId = recode.getValueByName("NewMainID");
		    _fromChargeMainFormRowSet.setValue("MAIN_ID",mainId);
		    var rFlag = recode.getValueByName("FLAG");
			//document.getElementById("include").style.display="block";
			//_mainId=mainId;
			_fromChargeAMainFormRowSet.refresh("&id="+mainId);
		} else {
		     _fromChargeMainFormRowSet.setValue("MAIN_ID",newMainid);
		}
	} else {
	   _fromChargeMainFormRowSet.setValue("MAIN_ID",newMainid);
	}
	_mainId=_fromChargeMainFormRowSet.getValue("MAIN_ID");
	updateinit();
	//document.getElementById("include").style.display="none";
	g_AIButtonManager.get("query3").setDisabled(true);
	g_AIButtonManager.get("query2").setDisabled(false);
	_fromChargeMainFormRowSet.setValue("MARKET_TYPE","1");
	_fromChargeMainFormRowSet.setValue("FEE_TYPE","11");
	_fromChargeMainFormRowSet.setValue("SALE_FASHION","3");
	_fromChargeMainFormRowSet.setColEditSts("SALE_FASHION",false);  
}


function delCharge(){
	var curRow = chargeApplyMainTable.getRow();
	var applyid=chargeApplyMainTable.getValue(curRow,"APPLY_ID");
    chargeApplyMainTable.deleteRow(curRow);
    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=saveChargeMain&applyid='+applyid;
    var recode = PostInfo(strUrl, null);
    alert("操作成功！"); 
    _fromChargeMainFormRowSet.newRow();
	chargeDetailListTable.clear();
}
</script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>

