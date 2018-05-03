<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>资费档次</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  <body onload="initPage()">
    <ai:contractframe id="chargeMainDeframe1" contenttype="table" title="资费档次信息" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="chargeMainDefrom" 
            setname="com.asiainfo.charge.web.SETChargeInfo"
            conditionname="condition" parametersname="parameters"
            onvalchange="" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
             implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainDeSV"
            implservice_querymethod="IChargeMainDeshow(String id)"
           >
        <table  width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        <tr>
         <td class="td_font">资费类型：</td>
         <td><ai:dbformfield formid="chargeMainDefrom" fieldname="CHARGE_TYPE" width="150" /><span class="font_red">*</span>
         <ai:dbformfield formid="chargeMainDefrom" fieldname="APPLY_ID" width="150" visible="false"/>
        <ai:dbformfield formid="chargeMainDefrom" fieldname="MID" width="150" visible="false"/>
         </td>
         <td class="td_font" style="">资费档次编码：</td>
         <td style=""><ai:dbformfield formid="chargeMainDefrom" fieldname="CASE" width="150" visible="" editable="false"/><span class="font_red">*</span>
         <ai:dbformfield formid="chargeMainDefrom" fieldname="FEE_NAME" width="150" visible="false"/>
         </td>
         <td class="td_font">套餐月使用费：</td>
         <td colspan=""><ai:dbformfield formid="chargeMainDefrom" fieldname="DOOR_DAMNIFY" width="150" editable=""/><span class="font_red">*</span>
         <ai:dbformfield formid="chargeMainDefrom" fieldname="DOOR_EARNING" width="150" visible="false" editable=""/>
         <ai:dbformfield formid="chargeMainDefrom" fieldname="EARNING_DAMNIFY" width="150" editable="" visible="false"/>
          <ai:dbformfield formid="chargeMainDefrom" fieldname="EARNING_TOTAL" width="150" editable="" visible="false"/>
          <ai:dbformfield formid="chargeMainDefrom" fieldname="INTENDING_ACOUNT" width="150" editable="" visible="false"/>
         </td>
        </tr>
<%--        <td id="busitype2">  <ai:dbformfield formid="chargeMainDefrom" fieldname="NINNER_TOCHARGE_COUNT" width="150" editable="" visible=""/></td>--%>
        <tr><td class="td_font" id="busitype1">业务类型：</td>
          	<td colspan="6">
            <input type="radio" name="GR" id="GR" onclick="showtype(GR);"/>个人(其中包括)&nbsp;
            <input type="radio" name="JT" id="JT" onclick="showtype(JT);"/>集团&nbsp;
          	<input type="radio" name="KD" id="KD" onclick="showtype(KD);"/>宽带&nbsp;
          	<input type="radio" name="HLWTV" id="HLWTV" onclick="showtype(HLWTV);"/>互联网TV&nbsp;
          	<input type="radio" name="YDZG" id="YDZG" onclick="showtype(YDZG);"/>移动职工&nbsp;
          	<input type="radio" name="MFZY" id="MFZY" onclick="showtype(MFZY);"/>免费资源&nbsp;
          	</td></tr>
          <tr id="gr_id" style="display: none;"><td></td>
          <td colspan="9">
          <input type="checkbox" name="YY" id="YY"/>语音&nbsp;
          <input type="checkbox" name="LL" id="LL"/>流量&nbsp;
          <input type="checkbox" name="WLAN" id="WLAN"/>WLAN&nbsp;
          <input type="checkbox" name="DX" id="DX"/>短信&nbsp;
          <input type="checkbox" name="CX" id="CX"/>彩信&nbsp;
          <input type="checkbox" name="BD" id="BD"/>保底&nbsp;
          <input type="checkbox" name="KB" id="KB"/>捆绑&nbsp;
          <input type="checkbox" name="FLLLSJYW" id="FLLLYWSJ"/>非流量类数据业务&nbsp;
          <input type="checkbox" name="QT" id="QT"/>其他&nbsp;
          </td>
          </tr><tr>
         	<td class="td_font">业务类型编码：</td>
         	<td><ai:dbformfield formid="chargeMainDefrom" fieldname="EXT2" width="150" editable="false" visible=""/></td>
        	<td class="td_font">资费类别：</td>
        	<td><ai:dbformfield formid="chargeMainDefrom" fieldname="CHARGE_CATEGORY" width="150" editable="" visible=""/><span class="font_red">*</span></td>
        	<td class="td_font">是否需要资费分摊：</td>
        	<td><ai:dbformfield formid="chargeMainDefrom" fieldname="IS_DIVIDE" width="150" editable="" visible=""/><span class="font_red">*</span></td>
         </tr>
         <tr>
          	<td class="td_font" id="busitype1">是否集团资费：</td>
         	<td id="busitype2">  <ai:dbformfield formid="chargeMainDefrom" fieldname="IS_GROUP" width="150" editable="" visible=""/><span class="font_red">*</span></td>
        	<td class="td_font">流量资费：</td>
        	<td><ai:dbformfield formid="chargeMainDefrom" fieldname="FLOW_CHARGE" width="150" editable="" visible=""/><span class="font_red">*</span></td>
        	<td class="td_font">是否发布电子渠道：</td>
        	<td><ai:dbformfield formid="chargeMainDefrom" fieldname="EXT6" width="150" editable="" visible=""/><span class="font_red">*</span></td>
        </tr>
        <tr>
        	<td class="td_font">是否需要短信提醒：</td>
        	<td colspan=3 ><ai:dbformfield formid="chargeMainDefrom" fieldname="IS_SEND_SMS" width="10" visible="false"/>
        		<input type="checkbox" id="selSendType0" value="0" onclick="checkboxSts(0);" />不需要短信提醒&nbsp;
        		<input type="checkbox" id="selSendType1" value="1" onclick="checkboxSts(1);" />业务受理短信&nbsp;
               	<input type="checkbox" id="selSendType2" value="2" onclick="checkboxSts(2);" />入网关怀短信&nbsp;
        </tr>
        <tr id="sms_id" style="display: none;">
        	<td class="td_font">入网短信内容(用户自定义)：</td>
        	<td colspan="5"><ai:dbformfield formid="chargeMainDefrom" fieldname="EXT4" height="60" width="70%"/><span class="font_red">*</span></td>
        </tr>
        <tr id="busi_sms_id" style="display: none;">
        	<td class="td_font">业务受理短信(系统固定模板)：</td>
        	<td colspan="5"><ai:dbformfield formid="chargeMainDefrom" fieldname="EXT3" height="50" width="70%" editable="false"/></td>
        </tr>
        <tr></tr>
        <tr>
         <td class="td_font">资费描述：</td>
         <td colspan="5"><ai:dbformfield formid="chargeMainDefrom" fieldname="FEE_MARK"  height="60" width="70%" editable=""/>
         <ai:dbformfield formid="chargeMainDefrom"  fieldname="ADD_USER_MARKET"  height="100" width="" visible="false"/>
         <ai:dbformfield formid="chargeMainDefrom"  fieldname="SPLICE_MUTEX_RULE"  height="100" width="" visible="false"/>
         </td>
        </tr>
         
        </table>
        </ai:dbform>
        </ai:contractframe>
       <%-- <div id="unitId1">
       <%@include file="/charge/include/_chargeTree.jsp"%>
       </div> 屏蔽资费结构树20140605
       --%>
        <div id="unitId3">
       <%@include file="/charge/include/_voicechargeconcessEdit.jsp" %>
       </div>
        <div id="unitId2">
       <%@include file="/charge/include/_dataConcessionalPkg.jsp" %>
       </div>
        <div class="area_button"><ai:button text="保存" id="query2" onclick="addChargeMainDe()" />&nbsp;&nbsp;</div>
        <div id="div_ProdAttr" style="display: none;">
        <%@include file="/charge/include/_chargeApplyProdAttr.jsp" %>
        </div>
        <%@include file="/charge/chargeinfo/_billingNested.jsp"%>
        <%@include file="/charge/include/_channelRuleShow.jsp"%>
        <table width=100%>
        <tr >
        <td width="625"><%@include file="/charge/chargeinfo/_staticSumEdit.jsp"%></td>
        <td ><%@include file="/charge/chargeinfo/_dynamicSum.jsp"%></td>
        </tr>
        </table>
  </body>

</html>
<ai:loginuser />
<script language="javascript"
	src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js"
	type="text/javascript"></script>
<script type="text/javascript">
var feeType="<%=request.getParameter("feeType")%>";
var applyId="<%=request.getParameter("applyId")%>";
var mid="<%=request.getParameter("mid")%>";
var taskId="<%=request.getParameter("taskId")%>";
var taskTag = "<%=request.getParameter("taskTag")%>";
var reSendSmsVal="<%=request.getParameter("isSendSmsVal")%>";
var userSms="<%=request.getParameter("userSms")%>";
var isNewFee="<%=request.getParameter("isNewFee")%>";
var state="<%=request.getParameter("state")%>";

var _fromChargeMainDeFormRowSet= g_FormRowSetManager.get("chargeMainDefrom");

var notes = "订购：尊敬的客户：您于%2成功办理%3！%4起生效。中国移动\n退订：%0，尊敬的%1客户：您于%2取消了%3！欢迎您再次使用！";


function initPage(){

    /////////////////根据不同资费类型显示--资费页面////////////////////
    //document.getElementById("unitId1").style.display="none";
    document.getElementById("unitId2").style.display="none";
    document.getElementById("unitId3").style.display="none";
    if(null == mid || "null" == mid || "" == mid){
	    _fromChargeMainDeFormRowSet.setValue("CHARGE_TYPE",feeType);
	    _fromChargeMainDeFormRowSet.setValue("APPLY_ID",applyId);
	    _fromChargeMainDeFormRowSet.setValue("NINNER_TOCHARGE_COUNT","1");
    } else {
	    _fromChargeMainDeFormRowSet.refresh("id="+mid);
	    _billingNested.initPage();
	    if ("41"==feeType){
	    	initDataConcessDetailInfo(mid);
	    }
	    if("31"==feeType){
	    	_voice_init(mid);
	    }
	    if(state != "null" && state != "1" && state != ""){
	    	document.getElementById("finalshare_form_div").style.display="none";
		    document.getElementById("finalshare_tab_div").style.display="block";
		    _fromChargeMainDeFormRowSet.setEditSts(false);
		    _billingNested.finaAllocShareForm.setEditSts(false);
		    g_AIButtonManager.get("query2").setDisabled(true);
		    g_AIButtonManager.get("query3").setDisabled(true);
		    ProdExtF.setEditSts(false);
		    g_AIButtonManager.get("bt_add").setDisabled(true); 
		    g_AIButtonManager.get("bt_del").setDisabled(true); 
		    g_AIButtonManager.get("bt_saveAll2").setDisabled(true); 
		    g_AIButtonManager.get("_billingNested_addBillingCheck").setDisabled(true);
		    g_AIButtonManager.get("_billingNested_delBillingCheck").setDisabled(true);
		    g_AIButtonManager.get("_billingNested_saveBillingCheck").setDisabled(true);
		    g_AIButtonManager.get("_billingNested_saveFinaAllocShare").setDisabled(true);
			g_AIButtonManager.get("_static_Sum").setDisabled(true);
			g_AIButtonManager.get("_static_save").setDisabled(true);
		    g_AIButtonManager.get("addDataConcess").setDisabled(true);
			g_AIButtonManager.get("delDataConcess").setDisabled(true);
			if (taskTag == "st3-ch2-audit" || taskTag == "st1-ch7-N") {
				_billingNested.finaAllocShareTab.setEditSts(true);
				g_AIButtonManager.get("_billingNested_saveFinalShare").setDisabled(false);
			} else {
				g_AIButtonManager.get("_billingNested_saveFinalShare").setDisabled(true);
			}
    	}
        _dynamic_init();
    }
   
    if ("41"==feeType){
		document.getElementById("unitId2").style.display="block";
		//document.getElementById("busitype1").style.display="none";
		//document.getElementById("busitype2").style.display="none";
	} else if ("31"==feeType){
		document.getElementById("unitId3").style.display="block";
		//document.getElementById("busitype1").style.display="none";
		//document.getElementById("busitype2").style.display="none";
	}
 	_fromChargeMainDeFormRowSet.setColEditSts("CHARGE_TYPE",false);
    _staticSumSetToEditable('_staticSumtable'); 
    //include_reflashAttachTable();
    
    if("null" != reSendSmsVal && "" != reSendSmsVal){
    	getcheckboxSts(reSendSmsVal);
    	//alert(reSendSmsVal);
    	//if("2" == reSendSmsVal){
    	//	document.getElementById("sms_id").style.display="block";
    	//}else{document.getElementById("sms_id").style.display="none";}
    }
    
    //_fromChargeMainDeFormRowSet.setValue("EXT3", notes);
    include_refreshChannealRule(mid);
	document.getElementById("div_ProdAttr").style.display = "block";
	initChargeProd();  
	var ext2=_fromChargeMainDeFormRowSet.getValue("EXT2");
	if("null" != ext2 && "" != ext2){
	showEXT2(ext2);
  }
	//if(isNewFee == "1"){
		//屏蔽原来资费结构树
		//document.getElementById("unitId1").style.display = "none";
		//初始化新的资费结构
	//}
}

var chargeid="";
var applyID="";
var busitype='000000000000000';
function addChargeMainDe(){
	var busitype1=getBusiType(busitype);
	if(busitype1=='000000000000000'){
		return alert("至少选择一个业务类别");
	}
	if(busitype1=='100000000000000'){
		return alert("至少选择一个'个人业务'类别");
	}
	_fromChargeMainDeFormRowSet.setValue("EXT2",busitype1);
	if (taskId == 'null' || (state == 1 && taskTag == "")) {
		getCode();
	}
	var tMoney=_fromChargeMainDeFormRowSet.getValue("DOOR_DAMNIFY");
	var chargeflag=_fromChargeMainDeFormRowSet.getValue("CHARGE_TYPE");
	//if(code==""){
	//	_fromChargeMainDeFormRowSet.setFocus("CASE");//得到资费编码焦点
	//return alert("请填写资费编码！");
	//}	
	if(chargeflag==""){
	  alert("页面加载过慢！请重新刷新页面！");
	  return window.location.reload();
	}
	if(tMoney==""){
		_fromChargeMainDeFormRowSet.setFocus("DOOR_DAMNIFY");//得到套餐使用费焦点
		return alert("请填月套餐使用费！");
	}
	
	if (_fromChargeMainDeFormRowSet.getValue("CHARGE_CATEGORY") == '') return alert("请选择资费类别！");
	
	if (_fromChargeMainDeFormRowSet.getValue("FLOW_CHARGE") == '') return alert("请选择流量资费！");
	
	if (_fromChargeMainDeFormRowSet.getValue("IS_DIVIDE") == '') return alert("请选择是否需要资费分摊！");
	
	if (_fromChargeMainDeFormRowSet.getValue("IS_GROUP") == '') return alert("请选择是否集团资费！");
	
	var isSendSmsVal = getSelSendType();
	_fromChargeMainDeFormRowSet.setValue("IS_SEND_SMS",isSendSmsVal);
	if(true == document.getElementById('selSendType2').checked){
		if(null == _fromChargeMainDeFormRowSet.getValue("EXT4") || "" == _fromChargeMainDeFormRowSet.getValue("EXT4")){
			return alert("您选择了入网短信提醒，请填写入网短信内容！");
		}
	}
	
	//不发送时，将短信内容设置为空
	if(true != document.getElementById('selSendType1').checked){
		var ext3 = _fromChargeMainDeFormRowSet.getValue("EXT3");
		if("" != ext3){
			_fromChargeMainDeFormRowSet.setValue("EXT3","");	
		}

	}
	if(true != document.getElementById('selSendType2').checked){
		var ext4 = _fromChargeMainDeFormRowSet.getValue("EXT4");
		if("" != ext4){
			_fromChargeMainDeFormRowSet.setValue("EXT4","");	
		}
	}
		
    if ("O" != _fromChargeMainDeFormRowSet.getSts())
    {
		var feeName="<%=request.getParameter("feeName")%>";
		//var feeName="<%=new String(request.getParameter("feeName").trim().getBytes("GBK"))%>";
		//var feeName="<%=new String(request.getParameter("feeName").trim().getBytes("ISO-8859-1"))%>";
	    _fromChargeMainDeFormRowSet.setValue("FEE_NAME",feeName+"_"+tMoney+"元套餐");
        saveChargeMainInclude();
    }
    //数据优惠包保存
    if ("41"==feeType){
     	applyID=_fromChargeMainDeFormRowSet.getValue("APPLY_ID");
    	chargeid=_fromChargeMainDeFormRowSet.getValue("MID");
        if(true==saveDataConcess(chargeid,applyID)){
        	_fromChargeMainDeFormRowSet.setValue("EARNING_TOTAL",getDataConcessDetailInfoContent());
        	 alert("保存操作成功！");
        }
   		// return true;
    } else if ("31"==feeType){     //语音优惠包保存
	    applyID=_fromChargeMainDeFormRowSet.getValue("APPLY_ID");
	    chargeid=_fromChargeMainDeFormRowSet.getValue("MID");
        if(true==saveVoiceChargeInfo(chargeid)){
   	   		_fromChargeMainDeFormRowSet.setValue("EARNING_TOTAL",getStrMsg());
        	alert("保存操作成功！");
        }
   	//	 return true;
    }
    //document.getElementById("submitButton").style.display="block";
    if ("O" != _fromChargeMainDeFormRowSet.getSts()){
    	saveChargeMainInclude();
    }
}

function getBusiType(busitype){
	var gr='0',jt='0',yy='0',ll='0',wlan='0',dx='0',cx='0',bd='0',kb='0',flllsjyw='0',qt='0',kd='0',hlwtv='0',ydzg='0',mfzy='0';
	if(document.getElementById("JT").checked){jt='1';}
	if(document.getElementById("GR").checked){
		gr='1';
		if(document.getElementById("YY").checked){yy='1';}
		if(document.getElementById("LL").checked){ll='1';}
		if(document.getElementById("WLAN").checked){wlan='1';}
		if(document.getElementById("DX").checked){dx='1';}
		if(document.getElementById("CX").checked){cx='1';}
		if(document.getElementById("BD").checked){bd='1';}
		if(document.getElementById("KB").checked){kb='1';}
		if(document.getElementById("FLLLSJYW").checked){flllsjyw='1';}
		if(document.getElementById("QT").checked){qt='1';}
	}
	if(document.getElementById("KD").checked){kd='1';}
	if(document.getElementById("HLWTV").checked){hlwtv='1';}
	if(document.getElementById("YDZG").checked){ydzg='1';}
	if(document.getElementById("MFZY").checked){mfzy='1';}
	busitype=gr+yy+ll+wlan+dx+cx+bd+kb+flllsjyw+qt+jt+kd+hlwtv+ydzg+mfzy;
	return busitype;
}

function getCode(){
	var ccode="";
	var numcode="";
	var chargeTypeCode="";
	var citycodes=g_GetUserInfo().ORG_ID.substr(0,2);
	var zfmarket="<%=request.getParameter("zfbmmark")%>";
	var typecards="<%=request.getParameter("typecards")%>";
	var chargetype=_fromChargeMainDeFormRowSet.getValue("CHARGE_TYPE");
	if(chargetype!="31"&&chargetype!="41"){
		//由于资费类型编码改为15位，组成系统生成的编码的该字段不好获取     20160531
		var chargebusitype='0';
<%--		var chargebusitype=_fromChargeMainDeFormRowSet.getValue("NINNER_TOCHARGE_COUNT");--%>
	} else if(chargetype=="31"){
		chargebusitype="1";
	} else if(chargetype=="41"){
		chargebusitype="2";
	}
	var num=_fromChargeMainDeFormRowSet.getValue("DOOR_DAMNIFY");
	//地市编码
	if(citycodes=="10"){
	ccode="99";
	}else if(citycodes=="11"){
	ccode="01";
	}else if(citycodes=="20"){
	ccode="02";
	}else if(citycodes=="23"){
	ccode="03";
	}else if(citycodes=="12"){
	ccode="04";
	}else if(citycodes=="16"){
	ccode="05";
	}else if(citycodes=="14"){
	ccode="06";
	}else if(citycodes=="17"){
	ccode="07";
	}else if(citycodes=="13"){
	ccode="08";
	}else if(citycodes=="26"){
	ccode="09";
	}else if(citycodes=="25"){
	ccode="10";
	}else if(citycodes=="19"){
	ccode="11";
	}else if(citycodes=="24"){
	ccode="12";
	}else if(citycodes=="15"){
	ccode="13";
	}else if(citycodes=="18"){
	ccode="14";
	}else if(citycodes=="27"){
	ccode="15";
	}else if(citycodes=="28"){
	ccode="16";
	}
	//优惠类型编码
	if(chargetype=="11"||chargetype=="14"||chargetype=="15"||chargetype=="17"){
		chargeTypeCode="012";
	} else if(chargetype=="12"){
		chargeTypeCode="010";
	} else if(chargetype=="13"){
		chargeTypeCode="007";
	} else if (chargetype=="16"){
		chargeTypeCode="006";
	} else if(chargetype=="24"){
		chargeTypeCode="013";
	} else if (chargetype=="21"||chargetype=="22"||chargetype=="23"){
		chargeTypeCode="016";
	} else if(chargetype=="31"){
		var vtype=voicechargemain.getValue("CONCESS_TYPE");
		if ("1002"==vtype) {
			chargeTypeCode="039";
		} else if("1003"==vtype){
			chargeTypeCode="037";
		} else if("1004"==vtype){
			chargeTypeCode="036";
		} else{
			chargeTypeCode="041";
		}
	} else if(chargetype=="41"){
	//chargeTypeCode="044";
		var length = getConcessDetailTable().getTotalRowCount();
		var index="";
	 	if(length>1){
			for (var i=0; i<length;i++){
				if(getConcessDetailTable().getDisplayText(i, "DETAIL_TYPE")=="短信"){
					chargeTypeCode = "044";
					break;
				}
			}
			if(chargeTypeCode != "044"){
				for (var i=0; i<length;i++){
					if(getConcessDetailTable().getDisplayText(i, "DETAIL_TYPE")=="彩信"){
						chargeTypeCode = "045";
						break;
					}
				}
			}
		}else {
			if(getConcessDetailTable().getDisplayText(0, "DETAIL_TYPE")=="短信"){
				chargeTypeCode = "044";
			} else if(getConcessDetailTable().getDisplayText(0, "DETAIL_TYPE")=="彩信"){
				chargeTypeCode = "045";
			}
		}
	
	}
	//档次费用编码
	if(num>=0&&num<10){
		numcode="000"+num;
	} else if(num>=10&&num<100){
		numcode="00"+num;
	} else if(num>=100&&num<1000){
		numcode="0"+num;
	} else if(num>=1000&&num<10000){
		numcode=num;
	} else {
		numcode="AAAA";
	}
	var zfbmcodeB="";
	if(chargetype!="31"&&chargetype!="41"){
	 	zfbmcodeB="B17"+ccode+zfmarket+chargebusitype+typecards+"1"+chargeTypeCode+numcode;
	} else {
	 	zfbmcodeB="G17"+ccode+zfmarket+chargebusitype+typecards+"2"+chargeTypeCode+numcode;
	}
	var getSeq="";
	var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainDeAction?action=isHaveYes&zfbm='+zfbmcodeB;
    var recode = PostInfo(strUrl, null);
    getSeq=recode.getValueByName("SEQ");
     
    var zfbmcode=zfbmcodeB+getSeq;
    _fromChargeMainDeFormRowSet.setValue("CASE",zfbmcode);
}

function saveChargeMainInclude(){
 	var list = new Array();
    list.push(_fromChargeMainDeFormRowSet);
    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainDeAction?action=saveChargeMainDe';
    var recode = saveRowSet(strUrl, list);
    var applyID = recode.getValueByName("applyID");
    chargeid = recode.getValueByName("chargeid");
    _fromChargeMainDeFormRowSet.setValue("APPLY_ID",applyID);
    _fromChargeMainDeFormRowSet.setValue("MID",chargeid);
    var rFlag = recode.getValueByName("FLAG");
    if(rFlag == "Y"){
    	alert("保存操作成功！");
    }
    _fromChargeMainDeFormRowSet.refresh("id="+chargeid);
    window.parent.window.opener.chargeDetailListTable.refresh("&mainId="+applyId+"&feeType="+feeType);
    window.parent.window.opener.showTableOn();
}

function marketMultiplySelected(){
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/SaleMarketMultiplySelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = _fromChargeMainDeFormRowSet.getValue("ADD_USER_MARKET");
    _fromChargeMainDeFormRowSet.setValue("ADD_USER_MARKET",onItemMultiplySelected(url, iniVal, style));
}

function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}

/* window.onbeforeunload = onbeforeunload_handler;   
    function onbeforeunload_handler(){   
        var warning="确认信息是否都保存，是否继续?";           
        return warning;   
    }   */
</script>

<script type="text/javascript">
function  getSelSendType() {
	var busiTypeVal = "";  //是否需要短信提醒
	var aSelBusiType = new Array("selSendType0", "selSendType1", "selSendType2"); 
    var pos = 0;
   	for(pos = 0;pos<aSelBusiType.length;pos++){
	//for ( var pos in aSelBusiType ) {
    	if (document.getElementById(aSelBusiType[pos]).checked) {
      		if (busiTypeVal != ""){
            	busiTypeVal += ";";
          	}
      		busiTypeVal += document.getElementById(aSelBusiType[pos]).value;
        }
    }
    return busiTypeVal;
}

function showtype(type) {
	if(type==GR){
	if(true == document.getElementById('GR').checked){
		document.getElementById("gr_id").style.display="block";
		document.getElementById('JT').checked=false;
		document.getElementById('KD').checked=false;
		document.getElementById('HLWTV').checked=false;
		document.getElementById('YDZG').checked=false;
		document.getElementById('MFZY').checked=false;
	}if(false == document.getElementById('GR').checked){
		closeGRtype();
	   }
	}
	if(type==JT){
		if(true == document.getElementById('JT').checked){
		document.getElementById('GR').checked=false;
		document.getElementById('KD').checked=false;
		document.getElementById('HLWTV').checked=false;
		document.getElementById('YDZG').checked=false;
		document.getElementById('MFZY').checked=false;
		closeGRtype();
		}
		}
	if(type==KD){
		if(true == document.getElementById('KD').checked){
		document.getElementById('GR').checked=false;
		document.getElementById('JT').checked=false;
		document.getElementById('HLWTV').checked=false;
		document.getElementById('YDZG').checked=false;
		document.getElementById('MFZY').checked=false;
		closeGRtype();
		}
		}
	if(type==HLWTV){
		if(true == document.getElementById('HLWTV').checked){
		document.getElementById('JT').checked=false;
		document.getElementById('KD').checked=false;
		document.getElementById('GR').checked=false;
		document.getElementById('YDZG').checked=false;
		document.getElementById('MFZY').checked=false;
		closeGRtype();
		}
		}
	if(type==YDZG){
		if(true == document.getElementById('YDZG').checked){
		document.getElementById('GR').checked=false;
		document.getElementById('KD').checked=false;
		document.getElementById('HLWTV').checked=false;
		document.getElementById('JT').checked=false;
		document.getElementById('MFZY').checked=false;
		closeGRtype();
		}
		}
	if(type==MFZY){
		if(true == document.getElementById('MFZY').checked){
		document.getElementById('GR').checked=false;
		document.getElementById('KD').checked=false;
		document.getElementById('HLWTV').checked=false;
		document.getElementById('YDZG').checked=false;
		document.getElementById('JT').checked=false;
		closeGRtype();
		}
		}
	
}   	

function closeGRtype(){
	    document.getElementById("gr_id").style.display="none";
		document.getElementById('YY').checked=false;
		document.getElementById('LL').checked=false;
		document.getElementById('WLAN').checked=false;
		document.getElementById('DX').checked=false;
		document.getElementById('CX').checked=false;
		document.getElementById('BD').checked=false;
		document.getElementById('KB').checked=false;
		document.getElementById('FLLLSJYW').checked=false;
		document.getElementById('QT').checked=false;
	}

function showEXT2(ext2){
	if(ext2.charAt(0)==1){
		document.getElementById('GR').checked=true;
		document.getElementById("gr_id").style.display="block";
		if(ext2.charAt(1)==1){document.getElementById('YY').checked=true;}
		if(ext2.charAt(2)==1){document.getElementById('LL').checked=true;}
		if(ext2.charAt(3)==1){document.getElementById('WLAN').checked=true;}
		if(ext2.charAt(4)==1){document.getElementById('DX').checked=true;}
		if(ext2.charAt(5)==1){document.getElementById('CX').checked=true;}
		if(ext2.charAt(6)==1){document.getElementById('BD').checked=true;}
		if(ext2.charAt(7)==1){document.getElementById('KB').checked=true;}
		if(ext2.charAt(8)==1){document.getElementById('FLLLSJYW').checked=true;}
		if(ext2.charAt(9)==1){document.getElementById('QT').checked=true;}
		}
		if(ext2.charAt(10)==1){document.getElementById('JT').checked=true;}
	if(ext2.charAt(11)==1){document.getElementById('KD').checked=true;}
	if(ext2.charAt(12)==1){document.getElementById('HLWTV').checked=true;}
	if(ext2.charAt(13)==1){document.getElementById('YDZG').checked=true;}
	if(ext2.charAt(14)==1){document.getElementById('MFZY').checked=true;}
	
	
}
   	
function checkboxSts(POS) {
	if(POS == 0){
		if(true == document.getElementById('selSendType0').checked){
			document.getElementById('selSendType1').checked = false;
			document.getElementById('selSendType2').checked = false;
			document.getElementById("sms_id").style.display="none";
			document.getElementById("busi_sms_id").style.display="none";
			//_fromChargeMainDeFormRowSet.setValue("EXT4","");
		}
	}
	if(POS == 1){
		if(true == document.getElementById('selSendType1').checked){
			document.getElementById("busi_sms_id").style.display="block";
			_fromChargeMainDeFormRowSet.setValue("EXT3", notes);
			document.getElementById('selSendType0').checked = false;
			
			if(true != document.getElementById('selSendType2').checked){
				document.getElementById('selSendType2').checked = false;
				document.getElementById("sms_id").style.display="none";
			}
		}else{
			document.getElementById("busi_sms_id").style.display="none";
		}
	}
	if(POS == 2){
		if(true == document.getElementById('selSendType2').checked){
			document.getElementById("sms_id").style.display="block";
			document.getElementById('selSendType0').checked = false;
			
			if(true != document.getElementById('selSendType1').checked){
				document.getElementById('selSendType1').checked = false;
				document.getElementById("busi_sms_id").style.display="none";
			}
		}else{
			document.getElementById("sms_id").style.display="none";
		}
	}
}		
	
//显示类型 是否需要短信提醒
function getcheckboxSts(sendType){
	if(sendType != null && sendType != ""){
    	var eMailBusiTypeArr = sendType.split(";");
    	for(var i = 0; i < eMailBusiTypeArr.length; i++){
    		if (i >= 3) return;
    		document.getElementById("selSendType"+eMailBusiTypeArr[i]).checked = true;
    		if("1" == eMailBusiTypeArr[i]){
    			document.getElementById("busi_sms_id").style.display="block";
    		} 
    		if("2" == eMailBusiTypeArr[i]){
    			document.getElementById("sms_id").style.display="block";
    		} 
    	}
    }
}
</script>


