<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ai.appframe2.common.SessionManager" %>  
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface" %>  
<%@ include file="/secframe/common/common.jsp" %>
<%@ include file="/webframe/common/commonhead.jsp" %>

<html><head>
<title>语音优惠包</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp" type="text/javascript"></script>
</head>
<% 
  String path = request.getContextPath();
  UserInfoInterface user = SessionManager.getUser();
  
  String staffId = String.valueOf(SessionManager.getUser().getID());
%>

<body onload="init_detail();">
<ai:contractframe id="voiceChargeMain" contenttype="table" title="语音优惠" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="voicecharge" 
			setname="com.asiainfo.charge.web.SETChargeConcessInfo"
			conditionname="condition" parametersname="parameters"
			onvalchange="setdetail" editable="true" initial="false" 
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.charge.service.interfaces.IVoiceChargeConcessSV"
			implservice_querymethod="getVoiceChargeMain(String chargeId)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td colspan="10">优惠包类别：
	           	<ai:dbformfield formid="voicecharge" fieldname="CONCESS_TYPE" width="150"/>&nbsp;&nbsp;&nbsp;
	           	优惠包类型：
	           	<ai:dbformfield formid="voicecharge" fieldname="BUSI_TYPE" width="150" />&nbsp;&nbsp;&nbsp;
	           	</td>
	        </tr>
	        <tr>
	           	<td>
	           	备注(忙闲时/优惠区域/定向对象等说明)：
	           	</td>
	        </tr>
	        
	        <tr>
	           	<td>
	           	<ai:dbformfield formid="voicecharge" fieldname="REMARK" width="650" height="100"/>&nbsp;&nbsp;&nbsp;
	           	<ai:dbformfield formid="voicecharge" fieldname="MID" width="450" editable="false" visible="false" />&nbsp;&nbsp;&nbsp;
	           	<ai:dbformfield formid="voicecharge" fieldname="CONCESSID" width="450" editable="false" visible="false" />&nbsp;&nbsp;&nbsp;
	           	<ai:dbformfield formid="voicecharge" fieldname="DIS_RATE" width="450" editable="false" visible="false" />&nbsp;&nbsp;&nbsp;
	           	<ai:dbformfield formid="voicecharge" fieldname="CHARGE_TYPE" width="450" editable="false" visible="false" />&nbsp;&nbsp;&nbsp;
	           	<ai:dbformfield formid="voicecharge" fieldname="FEE" width="150" editable="false" visible="false"/>
			    </td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:contractframe id="voiceChargedetail" contenttype="table" title="" width="100%" allowcontract="true" frameclosed="false">
<ai:contractitem>
  <ai:button text="增加一行" id="addLine" onclick="doWork('addVoiceConcessDetail()')" />&nbsp;&nbsp;
  <ai:button text="删除记录" id="addLine" onclick="doWork('deleteLine()')" />&nbsp;&nbsp;
</ai:contractitem>
<div id="voice01">
<ai:table tableid="charge_detail01" setname="com.asiainfo.charge.web.SETChargeConcessDetailInfo" height="100" multiselect="true" oncellchange="" 
oncontextmenu="" needrefresh="true" onrowchange="" pagesize="15" ondbclick=""
width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.charge.service.interfaces.IVoiceChargeConcessSV"  
implservice_querymethod="getVoiceChargeDetail(String concessid)" 
implservice_countmethod="" 
initial="false" editable="true" width="100%" >
 <ai:col fieldname="DETAIL_TYPE" width="180" visible="true"/>
 <ai:col fieldname="CHARGE_IN" width="180" visible="false" />
 <ai:col fieldname="CHARGE_OUT" width="160" visible="false" />
 <ai:col fieldname="PRICE" width="160" visible="true" />
 <ai:col fieldname="REMARK" width="800" visible="true" />
 <ai:col fieldname="CNT" width="180" visible="false" />
 <ai:col fieldname="CONSSID" width="180" visible="false" />
 <ai:col fieldname="ID" width="180" visible="false"/>
 <ai:col fieldname="UNIT" width="180" visible="false"/>
<ai:col fieldname="IS_CHARGE_DATA"  editable="false" visible="false" />
</ai:table>
</div>

<div id="voice02">
<ai:table tableid="charge_detail02" setname="com.asiainfo.charge.web.SETChargeConcessDetailInfo" height="100" multiselect="true" oncellchange="" 
oncontextmenu="" needrefresh="true" onrowchange="" pagesize="15" ondbclick=""
width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.charge.service.interfaces.IVoiceChargeConcessSV"  
implservice_querymethod="getVoiceChargeDetail(String concessid)" 
implservice_countmethod="" 
initial="false" editable="true" width="100%" >
 <ai:col fieldname="DETAIL_TYPE" width="180" visible="true"/>
 <ai:col fieldname="CHARGE_IN" width="180" visible="true" />
 <ai:col fieldname="CHARGE_OUT" width="160" visible="true" />
 <ai:col fieldname="PRICE" width="160" visible="false" />
 <ai:col fieldname="REMARK" width="800" visible="true" />
 <ai:col fieldname="CNT" width="180" visible="false" />
 <ai:col fieldname="CONSSID" width="180" visible="false" />
 <ai:col fieldname="ID" width="180" visible="false"/>
 <ai:col fieldname="UNIT" width="180" visible="false"/>
 <ai:col fieldname="IS_CHARGE_DATA"  editable="false" visible="false" />
</ai:table>
</div>
</ai:contractframe>

</body>
</html>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script language="javascript" type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>

<script language="javascript" type="text/javascript">

	var voicechargemain = g_FormRowSetManager.get("voicecharge");
	var detail01 = g_TableRowSetManager.get("charge_detail01");
	var detail02 = g_TableRowSetManager.get("charge_detail02");
    document.getElementById("voice01").style.display="none";
    document.getElementById("voice02").style.display="none";
	voicechargemain.setFocus("CONCESS_TYPE");
	voicechargemain.setFocus("BUSI_TYPE");

function addLoadEvent(func) {  
    var oldonload = window.onload;  
    if(typeof window.onload != "function"){  
        window.onload = func;  
    }else{  
        window.onload = function(){  
            oldonload();  
            func();  
        }  
    }  
}
addLoadEvent(initData);

function initData(){
     var id = voicechargemain.getValue("BUSI_TYPE");
     if(id=="1001"){
    	 var count = detail01.getTotalRowCount();
		 for(var i = 0 ;i<count;i++){
			  detail01.setValue(i,"IS_CHARGE_DATA","YHB_BUSI_TYPE_VOICE","") ;
		 }
     }
     //包分钟数型
     if(id=="1002"){
    	 var count = detail02.getTotalRowCount();
		 for(var i = 0 ;i<count;i++){
			  detail02.setValue(i,"IS_CHARGE_DATA","YHB_BUSI_TYPE_VOICE","") ;
		 }
     }
}

    function init_detail(){
     var id = voicechargemain.getValue("BUSI_TYPE");
     addVoiceConcessDetail(); 
     if(id=="1001"){
        document.getElementById("voice02").style.display="none";
        document.getElementById("voice01").style.display="block";
     }
     //包分钟数型
     if(id=="1002"){
        document.getElementById("voice01").style.display="none";
        detail02.refresh("&concessid="+concessid);
     }
    }
	
  function _voice_init(chargeId){
     voicechargemain.refresh("&chargeId="+chargeId);
     var concessid = voicechargemain.getValue("CONCESSID");
     var id = voicechargemain.getValue("BUSI_TYPE");
     if(id=="1001"){
        document.getElementById("voice02").style.display="none";
        document.getElementById("voice01").style.display="block";
        detail01.refresh("&concessid="+concessid);
     }
     //包分钟数型
     if(id=="1002"){
        document.getElementById("voice01").style.display="none";
        detail02.refresh("&concessid="+concessid);
        document.getElementById("voice02").style.display="block";
     }
  }

function saveVoiceChargeDetail(concessid){
     var id = voicechargemain.getValue("BUSI_TYPE");
     var i = 0;
     if(id=="1001"){
       while(i<detail01.getTotalRowCount()){
         detail01.setValue(i,"CONSSID",concessid,"");
         if(detail01.getValue(i,"DETAIL_TYPE")==""){
            alert("业务类型不允许为空,请填写完整!");   
            return;    
         }
         i++;
       }
       var list = new Array();
       list.push(detail01);
       var strUrl = _gModuleName+'/business/com.asiainfo.charge.web.VoiceChargeConcessAction?action=saveChargeConcessDetail';
       if(detail01.getTotalRowCount()>0){
         var record = saveRowSet(strUrl, list);
       }
       return "1";
     }
     if(id=="1002"){
       while(i<detail02.getTotalRowCount()){
         detail02.setValue(i,"CONSSID",concessid,"");
         if(detail02.getValue(i,"DETAIL_TYPE")==""){
            alert("业务类型不允许为空,请填写完整!");   
            return;    
         }
         i++;
       }
       var list = new Array();
       list.push(detail02);
       var strUrl = _gModuleName+'/business/com.asiainfo.charge.web.VoiceChargeConcessAction?action=saveChargeConcessDetail';
       if(detail02.getTotalRowCount()>0){
         var recode = saveRowSet(strUrl, list);
       }
       return "1";
     }
     if(id=="1001"){
        document.getElementById("voice02").style.display="none";
        document.getElementById("voice01").style.display="block";
        detail01.refresh("&concessid="+concessid);
     }
     //包分钟数型
     if(id=="1002"){
        document.getElementById("voice01").style.display="none";
        document.getElementById("voice02").style.display="block";
        detail02.refresh("&concessid="+concessid);
     }
} 

function saveVoiceChargeInfo(chargeid){
   var CONCESS_TYPE = voicechargemain.getValue("CONCESS_TYPE");
   var BUSI_TYPE = voicechargemain.getValue("BUSI_TYPE");
   voicechargemain.setValue("CHARGE_TYPE","31");
   var mid = chargeid;
   voicechargemain.setValue("MID",mid);

   if(CONCESS_TYPE==""){
      return  alert("请选择优惠包类别！");
   }
   if(BUSI_TYPE==""){
      return  alert("请选择优惠包类型！");
   }
   if("O" != voicechargemain.getSts()){
     var list = new Array();
     list.push(voicechargemain);
     var strUrl = _gModuleName+'/business/com.asiainfo.charge.web.VoiceChargeConcessAction?action=saveChargeConcessMain';
     var record = saveRowSet(strUrl, list);

	 voicechargemain.setEditSts(true);
	 voicechargemain.refresh("&chargeId="+mid);
	 var concessid=voicechargemain.getValue("CONCESSID");
     saveVoiceChargeDetail(concessid);	 
     return true;
   }else{
	 var concessid=voicechargemain.getValue("CONCESSID");
     saveVoiceChargeDetail(concessid);
     return true;
   }
   
   return false;
  }


function addLine(){
   var id = voicechargemain.getValue("BUSI_TYPE");
   if(id=="1001"){
      detail01.newRow();   
   }
   //包分钟数型
   if(id=="1002"){
      detail02.newRow();
   }
}

function deleteLine(){
   var id = voicechargemain.getValue("BUSI_TYPE");
   if(id=="1001"){
	  var selectRows  = detail01.getSelectedRows();
		if(selectRows.length<1){
			alert("请选择要删除的数据！");
			return;
		}else{
			if(confirm("确定要删除这"+selectRows.length+"条数据吗？")){
				for(var i = selectRows.length - 1 ; i>=0 ; i--){
					detail01.deleteRow(selectRows[i]);
				}
			}
		}
   }
   //包分钟数型
   if(id=="1002"){
	  var selectRows  = detail02.getSelectedRows();
		if(selectRows.length<1){
			alert("请选择要删除的数据！");
			return;
		}else{
			if(confirm("确定要删除这"+selectRows.length+"条数据吗？")){
				for(var i = selectRows.length - 1 ; i>=0 ; i--){
					detail02.deleteRow(selectRows[i]);
				}
			}
		}
   }
}

function setdetail(){
   var id = voicechargemain.getValue("BUSI_TYPE");
   //单价型
   if(id=="1001"){
       document.getElementById("voice02").style.display="none";
       document.getElementById("voice01").style.display="block";
   }
   //包分钟数型
   if(id=="1002"){
       document.getElementById("voice01").style.display="none";
       document.getElementById("voice02").style.display="block";
   }else{
     return;
   }
}

//套餐内
function getvoicecharge_in(){
   var id = voicechargemain.getValue("BUSI_TYPE");
   var str = "";
   //包分钟数型
   if(id=="1002"){
       var i=0;
       while(i<detail02.getTotalRowCount()){
          str = str+detail02.getDisplayText(i,"DETAIL_TYPE")+"套餐内："+detail02.getValue(i,"CHARGE_IN")+"分钟；";
          i++;      
       }
       return str;
   }else{
     return "";
   }  
}

//套餐外
function getvoicecharge_out(){
   var str = "";
   var id = voicechargemain.getValue("BUSI_TYPE");
   //包分钟数型
   if(id=="1002"){
       var i=0;
       while(i<detail02.getTotalRowCount()){
          str = str+detail02.getDisplayText(i,"DETAIL_TYPE")+"套餐外："+detail02.getValue(i,"CHARGE_OUT")+"分钟；";
          i++;      
       }
       return str;
   }else{
     return "";
   }  
}
//取单价
function getprice(){
   var str = "";
   var id = voicechargemain.getValue("BUSI_TYPE");
   if(id=="1001"){
       var i=0;
       while(i<detail01.getTotalRowCount()){
          str = str+detail01.getDisplayText(i,"DETAIL_TYPE")+"单价："+detail01.getValue(i,"PRICE")+"元/分钟；";
          i++;      
       }
       return str;
   }
}

function getStrMsg(){
   var str = "";
   var id = voicechargemain.getValue("BUSI_TYPE");
   //单价型
   if(id=="1001"){
      str = getprice();
      return str;
   }
   //包分钟数型
   if(id=="1002"){
      str = getvoicecharge_in()+getvoicecharge_out();
      return str;
   }
   return str;
}

//新增数据优惠包 -- 包含业务内容
function addVoiceConcessDetail(){
     var id = voicechargemain.getValue("BUSI_TYPE");
     if(id=="1001"){
	   detail01.newRow();
	   var bit = 0;
	   var count = detail01.getTotalRowCount();
	   detail01.setValue(bit,"IS_CHARGE_DATA","YHB_BUSI_TYPE_VOICE","") ;
	   bit = count;
     }
     //包分钟数型
     if(id=="1002"){
	   detail02.newRow();
	   var bit = 0;
	   var count = detail01.getTotalRowCount();
	   detail02.setValue(bit,"IS_CHARGE_DATA","YHB_BUSI_TYPE_VOICE","") ;
	   bit = count;
     }
}

</script>
