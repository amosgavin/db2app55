<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>业务变更申请</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  
  <body onload="">
    <ai:contractframe id="accessMainframe" contenttype="table" title="业务变更申请主要信息" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="accessMainForm" 
            setname="com.asiainfo.sale.access.web.SETAccessChange"
            conditionname="condition" parametersname="parameters"
            onvalchange="setdetail" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.access.service.interfaces.IAccessChangeSV"
            implservice_querymethod="getAccessChargeById(int accessid)">
        <table width="100%" align="center" border="0" cellpadding="1" cellspacing="1">
        <tr>
           <td class="td_font">申请名称:</td>
           <td><ai:dbformfield formid="accessMainForm" fieldname="APPLY_NAME" width="150"/>    
           <ai:dbformfield formid="accessMainForm" fieldname="ACCESS_ID" width="60" editable="" visible="false"/>
           <ai:dbformfield formid="accessMainForm" fieldname="STATE" width="150" editable="" visible="false"/><span class="font_red">*</span></td>
           <td class="td_font">申请人:</td>
           <td><ai:dbformfield formid="accessMainForm" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
               <ai:dbformfield formid="accessMainForm" fieldname="STAFFNAME" width="150" editable="" /><span class="font_red">*</span>
           </td>
           <td class="td_font">联系电话:</td>
           <td><ai:dbformfield formid="accessMainForm" fieldname="TEL" width="150" /><span class="font_red">*</span></td>
         </tr> 
         <tr>
              <td class="td_font">申请单位:</td>
              <td><ai:dbformfield formid="accessMainForm" fieldname="ORG" width="130" editable="false" visible="false"/>
              <ai:dbformfield formid="accessMainForm" fieldname="ORGNAME" width="150" editable=""/><span class="font_red">*</span></td>
               <td class="td_font">开放开始时间:</td>
               <td><ai:dbformfield formid="accessMainForm" fieldname="B_TIME" width="150"/><span class="font_red">*</span></td>
               <td class="td_font">开放结束时间:</td>
               <td><ai:dbformfield formid="accessMainForm" fieldname="E_TIME" width="150"/><span class="font_red">*</span></td>
           </tr>
           <tr>
               <td class="td_font">开放对象:</td>
               <td><ai:dbformfield formid="accessMainForm" fieldname="O_OBJECT" width="150"/><span class="font_red">*</span></td>
               <td class="td_font">开放类型:</td>
               <td><ai:dbformfield formid="accessMainForm" fieldname="O_TYPE" width="150"/></td>
               <td class="td_font">开放范围:</td>
               <td colspan="1"><ai:dbformfield formid="accessMainForm" fieldname="SCALE" width="150" visible="false"/>
               <input type=checkbox name="scaleType" value="1">指定渠道&nbsp;
               <input type=checkbox name="scaleType" value="2">自办厅&nbsp;
               <input type=checkbox name="scaleType" value="3">代理商
               </td>
           </tr>
           <tr>
               <td class="td_font">变更前开放品牌:</td>
               <td colspan="5"><ai:dbformfield formid="accessMainForm" fieldname="OLD_BAND" width="150" visible="false"/>
               <input type=checkbox name="oldBand" value="qqt">全球通
               <input type=checkbox name="oldBand" value="szx">神州行
               <input type=checkbox name="oldBand" value="dgdd">动感地带
               </td>
           </tr>
           <tr>
               <td class="td_font">变更后开放品牌:</td>
               <td colspan="5"><ai:dbformfield formid="accessMainForm" fieldname="NEW_BAND" width="150" visible="false"/>
               <input type=checkbox name="newBand" value="qqt">全球通
               <input type=checkbox name="newBand" value="szx">神州行
               <input type=checkbox name="newBand" value="dgdd">动感地带
               </td>
           </tr>
           <tr>
              <td class="td_font">申请说明及依据:</td>
              <td colspan="5"><ai:dbformfield formid="accessMainForm" fieldname="REMARK" height="100" width="850"/><span class="font_red">*</span><span style="font-family:华文中宋; color:red; ">(请注明本平台或OA平台相应工单号)</span></td>
           </tr>
           <tr>
             <td class="td_font">开放工号或渠道节点明细:</td>
              <td colspan="5"><ai:dbformfield formid="accessMainForm" fieldname="ACCES_DETAIL" height="100" width="850"/></td>
           </tr>
       </table>

    </ai:dbform>
</ai:contractframe>
<ai:contractframe id="accessDetailListframe" contenttype="table" title="详细信息" width="100%" allowcontract="true" frameclosed="fale">
<ai:contractitem>
  <ai:button text="增加一行" id="addLine" onclick="addAccessDetail()" />&nbsp;&nbsp;
  <ai:button text="删除记录" id="addLine" onclick="doWork('deleteLine()')" />&nbsp;&nbsp;
</ai:contractitem>
<div id="detail01">
<ai:table tableid="accessDetailListTable01" setname="com.asiainfo.sale.access.web.SETAccessChangeDetail" height="100" multiselect="true" oncellchange="" 
oncontextmenu="" needrefresh="true" onrowchange="" pagesize="30" ondbclick=""
width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.sale.access.service.interfaces.IAccessChangeSV"  
implservice_querymethod="getAccessChargeDetailById(int accessid,int $STARTROWINDEX, int $ENDROWINDEX)" 
implservice_countmethod="getAccessChargeDetailCount(int accessid)" 
initial="false" editable="true" width="100%" >
        	<ai:col fieldname="ID" visible="false"/>
        	<ai:col fieldname="ACCESS_ID" visible="false"/>
            <ai:col fieldname="ZF_ID" width="200" visible="true"/>
            <ai:col fieldname="ZF_NAME" width="120" visible="true"/>
        	<ai:col fieldname="RW_ID" width="200" visible="false"/>
            <ai:col fieldname="RW_NAME" width="150" visible="false"/>
            <ai:col fieldname="YX_DC_CODE" width="200" visible="false"/>
            <ai:col fieldname="YX_DC_NAME" width="150" visible="false"/>
            <ai:col fieldname="YX_PC_CODE" width="200" visible="false"/>
            <ai:col fieldname="YX_PC_NAME" width="150" visible="false"/>             
    </ai:table>
</div>
<div id="detail02">
<ai:table tableid="accessDetailListTable02" setname="com.asiainfo.sale.access.web.SETAccessChangeDetail" height="100" multiselect="true" oncellchange="" 
oncontextmenu="" needrefresh="true" onrowchange="" pagesize="30" ondbclick=""
width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.sale.access.service.interfaces.IAccessChangeSV"  
implservice_querymethod="getAccessChargeDetailById(int accessid,,int $STARTROWINDEX, int $ENDROWINDEX)" 
implservice_countmethod="getAccessChargeDetailCount(int accessid)" 
initial="false" editable="true" width="100%" >
        	<ai:col fieldname="ID" visible="false"/>
        	<ai:col fieldname="ACCESS_ID" visible="false"/>
        	<ai:col fieldname="RW_ID" width="200" visible="true"/>
            <ai:col fieldname="RW_NAME" width="150" visible="true"/>
            <ai:col fieldname="YX_DC_CODE" width="200" visible="false"/>
            <ai:col fieldname="YX_DC_NAME" width="150" visible="false"/>
            <ai:col fieldname="YX_PC_CODE" width="200" visible="false"/>
            <ai:col fieldname="YX_PC_NAME" width="150" visible="false"/>
            
    </ai:table>
</div>
<div id="detail03">
<ai:table tableid="accessDetailListTable03" setname="com.asiainfo.sale.access.web.SETAccessChangeDetail" height="100" multiselect="true" oncellchange="" 
oncontextmenu="" needrefresh="true" onrowchange="" pagesize="30" ondbclick=""
width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.sale.access.service.interfaces.IAccessChangeSV"  
implservice_querymethod="getAccessChargeDetailById(int accessid,,int $STARTROWINDEX, int $ENDROWINDEX)" 
implservice_countmethod="getAccessChargeDetailCount(int accessid)" 
initial="false" editable="true" width="100%" >
        	<ai:col fieldname="ID" width="150" visible="false"/>
        	<ai:col fieldname="ACCESS_ID" width="150" visible="false"/>
            <ai:col fieldname="YX_DC_CODE" width="200" visible="true"/>
            <ai:col fieldname="YX_DC_NAME" width="150" visible="true"/>
            <ai:col fieldname="YX_PC_CODE" width="200" visible="true"/>
            <ai:col fieldname="YX_PC_NAME" width="150" visible="true"/>
             <ai:col fieldname="ZF_ID" width="200" visible="false"/>
             <ai:col fieldname="ZF_NAME" width="120" visible="false"/>
        	<ai:col fieldname="RW_ID" width="200" visible="false"/>
            <ai:col fieldname="RW_NAME" width="150" visible="false"/>            
    </ai:table>
</div>    
</ai:contractframe>
   <div class="area_button">
   <ai:button text="保存业务变更信息" id="query2" onclick="doWork('addAccessInfo()')" />&nbsp;&nbsp;
  </div>
<ai:loginuser/>
<script type="text/javascript">
var _templateCode = "template.AccessChangeFlow";
var _flowType = "accessCaseT";
var _mainId = "";
var _orgId = g_GetUserInfo().ORG_ID;

</script>
<%@include file="/sale/common/include/_createWF.jsp"%>
<%@include file="/sale/access/_accessAttach.jsp"%>
</body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script language="javascript" type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>
<script language="javascript" type="text/javascript">
var _fromAccessFormRowSet= g_FormRowSetManager.get("accessMainForm");
var accessDetailListTable01 = g_TableRowSetManager.get("accessDetailListTable01");
var accessDetailListTable02 = g_TableRowSetManager.get("accessDetailListTable02");
var accessDetailListTable03 = g_TableRowSetManager.get("accessDetailListTable03");
var applyid="<%=request.getParameter("applyid")%>";

document.getElementById("detail03").style.display="none";
document.getElementById("detail02").style.display="none";
document.getElementById("detail01").style.display="none";

function show(){
	alert("ACCESS_ID:"+_fromAccessFormRowSet.getValue("ACCESS_ID"));
}

function init(){ 
	var accessid =_fromAccessFormRowSet.getValue("ACCESS_ID");
	var state =_fromAccessFormRowSet.getValue("STATE");
	//点击查询时候（状态为已保存）进入页面
	if("null"!=applyid ){
	  _mainId=applyid;
	  _fromAccessFormRowSet.refresh("&accessid="+applyid);
	  showName();
	  setCheckBox();
	  setdetail();
      var o_object = _fromAccessFormRowSet.getValue("O_OBJECT");
	   if(o_object=="1"){
   	     accessDetailListTable01.refresh("&accessid="+applyid);
	   }
	   if(o_object=="2"){
   	     accessDetailListTable02.refresh("&accessid="+applyid);
	   }
	   if(o_object=="3"){
   	     accessDetailListTable03.refresh("&accessid="+applyid);
	   }
	   include_attach_setButtonDisabled(false);
	   include_reflashAttachTable();
	}
	else{
	//页面刷新，或是修改；id为空时，是申请
	 var staffId = g_GetUserInfo().STAFF_ID;
    _fromAccessFormRowSet.setValue("O_OBJECT","3");	 
	_fromAccessFormRowSet.setValue("PRINCIPLE",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
	_fromAccessFormRowSet.setValue("ORG",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
	_fromAccessFormRowSet.setValue("TEL",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
	showName();
	include_attach_setButtonDisabled(true);
   }
}

function showName(){
	_fromAccessFormRowSet.setFocus("STAFFNAME");
    _fromAccessFormRowSet.setFocus("ORGNAME");
    _fromAccessFormRowSet.setFocus("TEL");    
	_fromAccessFormRowSet.setColEditSts("ORGNAME",false);
	_fromAccessFormRowSet.setColEditSts("STAFFNAME",false);
	_fromAccessFormRowSet.setColEditSts("TEL",false);
}

function addAccessDetail(){
	   var o_object = _fromAccessFormRowSet.getValue("O_OBJECT");
	   if(o_object==""){
		   alert("请先选择开放对象");
		   return;
	   }
	   if(o_object=="1"){
   	     accessDetailListTable01.newRow();
	   }
	   if(o_object=="2"){
   	     accessDetailListTable02.newRow();
	   }
	   if(o_object=="3"){
   	     accessDetailListTable03.newRow();
	   }
}

function deleteLine(){
	   var o_object = _fromAccessFormRowSet.getValue("O_OBJECT");
	   var sts = _fromAccessFormRowSet.getSts();	   
	   if(o_object==""){
		   alert("请先选择开放对象"+o_object);
		   return;
	   }
	   if(o_object=="1"){
         var selectRows  = accessDetailListTable01.getSelectedRows();
		 if(selectRows.length<1){
			 alert("请选择要删除的数据！");
			 return;
		 }else{
			 if(confirm("确定要删除这"+selectRows.length+"条数据吗？")){
				  for(var i = 0;i< selectRows.length ;i++){
					 accessDetailListTable01.deleteRow(selectRows[i]);
			      }
			 }
             if(sts=="O"){
                  var accessid = _fromAccessFormRowSet.getValue("ACCESS_ID");            	 
                  var list = new Array();    	
	              list.push(accessDetailListTable01);
	              var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.AccessChangeAction?action=saveAccessChangeDetail&accessid='+accessid;
	              var recode = saveRowSet(strUrl, list);
	              accessDetailListTable01.refresh("&accessid="+accessid);	           
             }				
		 }
       }			 
	   if(o_object=="2"){
       var selectRows  = accessDetailListTable02.getSelectedRows();
		if(selectRows.length<1){
			alert("请选择要删除的数据！");
			return;
		}else{
			if(confirm("确定要删除这"+selectRows.length+"条数据吗？")){
				for(var i = 0;i< selectRows.length ;i++){
					aaccessDetailListTable02.deleteRow(selectRows[i]);
                }					
			}
             if(sts=="O"){
               var accessid = _fromAccessFormRowSet.getValue("ACCESS_ID");
               var list = new Array();    	
	           list.push(accessDetailListTable02);
	           var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.AccessChangeAction?action=saveAccessChangeDetail&accessid='+accessid;
	           var recode = saveRowSet(strUrl, list);
	           accessDetailListTable02.refresh("&accessid="+accessid);	           
             }
		}
       }			
	   if(o_object=="3"){
        var selectRows  = accessDetailListTable03.getSelectedRows();
		if(selectRows.length<1){
			alert("请选择要删除的数据！");
			return;
		}else{
			if(confirm("确定要删除这"+selectRows.length+"条数据吗？")){
				for(var i = 0;i< selectRows.length ;i++){
					accessDetailListTable03.deleteRow(selectRows[i]);
			    }
			}
             if(sts="O"){
               var accessid = _fromAccessFormRowSet.getValue("ACCESS_ID");
               var list = new Array();    	
	           list.push(accessDetailListTable03);
	           var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.AccessChangeAction?action=saveAccessChangeDetail&accessid='+accessid;
	           var recode = saveRowSet(strUrl, list);
	           accessDetailListTable03.refresh("&accessid="+accessid);	           
		   }
		}
	  }		
}

function saveAccessChangeDetail(){
 var o_object = _fromAccessFormRowSet.getValue("O_OBJECT");
 var accessid = _fromAccessFormRowSet.getValue("ACCESS_ID");
 if(accessid==""){
	 alert("请先保存主信息！");
	 return;
 }
	//资费
	var list = new Array();
	if(o_object == "1"){
   	    if(accessDetailListTable01.getTotalRowCount()>0){
   	      var i = 0;
   	      while(i<accessDetailListTable01.getTotalRowCount()){
             accessDetailListTable01.setValue(i,"ACCESS_ID",accessid,"");
             i++;
          }
	      list.push(accessDetailListTable01);
	      var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.AccessChangeAction?action=saveAccessChangeDetail&accessid='+accessid;
	      var recode = saveRowSet(strUrl,list);
	      accessDetailListTable01.refresh("&accessid="+accessid);
        }
	}
	//入网方案
	if(o_object == "2"){
   	    if(accessDetailListTable02.getTotalRowCount()>0){
   	      var i = 0;
   	      while(i<accessDetailListTable02.getTotalRowCount()){
             accessDetailListTable02.setValue(i,"ACCESS_ID",accessid,"");
             i++;
          }
	      list.push(accessDetailListTable02);
	      var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.AccessChangeAction?action=saveAccessChangeDetail&accessid='+accessid;
	      var recode = saveRowSet(strUrl,list);
	      accessDetailListTable02.refresh("&accessid="+accessid);
       }
   }
	//营销案
	if(o_object == "3"){
   	    if(accessDetailListTable03.getTotalRowCount()>0){
   	      var i = 0;
   	      while(i<accessDetailListTable03.getTotalRowCount()){
             accessDetailListTable03.setValue(i,"ACCESS_ID",accessid,"");
             i++;
          }
	      list.push(accessDetailListTable03);
	      var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.AccessChangeAction?action=saveAccessChangeDetail&accessid='+accessid;
	      var recode = saveRowSet(strUrl,list);
	      accessDetailListTable03.refresh("&accessid="+accessid);
      }
   }
}	

function setdetail(){
	var o_object = _fromAccessFormRowSet.getValue("O_OBJECT");
	//资费
	if(o_object=="1"){
       document.getElementById("detail03").style.display="none";
       document.getElementById("detail02").style.display="none";
       document.getElementById("detail01").style.display="block";
	}
	//入网方案
	if(o_object=="2"){
       document.getElementById("detail01").style.display="none";
       document.getElementById("detail03").style.display="none";
       document.getElementById("detail02").style.display="block";
	}
	//营销案
	if(o_object=="3"){
       document.getElementById("detail01").style.display="none";
       document.getElementById("detail03").style.display="block";
       document.getElementById("detail02").style.display="none";
       document.getElementById("detail03").style.display="block";
   }
}

function addAccessInfo(){
 var applyName=_fromAccessFormRowSet.getValue("APPLY_NAME");
 var b_time=_fromAccessFormRowSet.getValue("B_TIME");
 var e_time=_fromAccessFormRowSet.getValue("E_TIME");
 var o_object=_fromAccessFormRowSet.getValue("O_OBJECT"); 
 var mark=_fromAccessFormRowSet.getValue("REMARK"); 
 var accessdetail=_fromAccessFormRowSet.getValue("ACCES_DETAIL");   
 if(""==applyName){return  alert("请输入业务变更申请名称！");}
 if(""==b_time){return  alert("请输入开放开始时间！");}
 if(""==e_time){return  alert("请输入开放结束时间！");}
 if(""==o_object){return  alert("请选择开放对象！");}
 if(1 == g_CompareDate(b_time,e_time)){ return alert("开放开始时间小于开放结束时间！");}
 if(""==mark){return  alert("请填写申请说明！");}
 if(""==accessdetail){return  alert("开放工号或渠道明细！");} 

 if(o_object=="1"){
	 if(accessDetailListTable01.getTotalRowCount()<1){
		 return alert("请输入变更详细信息！");
	 }
 }
 if(o_object=="2"){
	 if(accessDetailListTable02.getTotalRowCount()<1){
		 return alert("请输入变更详细信息！");
	 }
 }
 if(o_object=="3"){
	 if(accessDetailListTable03.getTotalRowCount()<1){
		 return alert("请输入变更详细信息！");
	 }
 }
 
 var accessDetailListTable = null;
 if ("O" != _fromAccessFormRowSet.getSts()||_fromAccessFormRowSet.getSts()=="U")
    {
	   // var accessid= _fromAccessFormRowSet.getValue("ACCESS_ID");
	   //if(accessid==""){
        var list = new Array();
        var checkvalues = document.getElementsByName("scaleType");
        var cv ="";
        for(var i=0;i<checkvalues.length;i++){
        	if(checkvalues[i].checked==true){
          	  cv=cv+checkvalues[i].value+";";
        	}
        }
        _fromAccessFormRowSet.setValue("SCALE",cv);
        var checkvalues01 = document.getElementsByName("oldBand");
        var cv01 ="";
        for(var i=0;i<checkvalues01.length;i++){
        	if(checkvalues01[i].checked==true){
          	  cv01=cv01+checkvalues01[i].value+";";
        	}
        }
        _fromAccessFormRowSet.setValue("OLD_BAND",cv01);

        var checkvalues02 = document.getElementsByName("newBand");
        var cv02 ="";
        for(var i=0;i<checkvalues02.length;i++){
        	if(checkvalues02[i].checked==true){
          	  cv02=cv02+checkvalues02[i].value+";";
        	}
        }
        _fromAccessFormRowSet.setValue("NEW_BAND",cv02);

        var state = _fromAccessFormRowSet.getValue("STATE");
        if(state==""){
           _fromAccessFormRowSet.setValue("STATE","1");
        }

	    list.push(_fromAccessFormRowSet);
	    var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.AccessChangeAction?action=saveAccessChangeInfo&applyid=0';
	    var recode = saveRowSet(strUrl, list);
	    var accessid = recode.getValueByName("accessid");
	    if(accessid==null){
	    	return alert("保存操作失败！");
	    }
  	    _fromAccessFormRowSet.refresh("&accessid="+accessid);
	    _fromAccessFormRowSet.setValue("STAFFNAME",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
    	_fromAccessFormRowSet.setValue("ORGNAME",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
	    showName();    
	    setCheckBox();
	    _mainId=accessid;
	    saveAccessChangeDetail();
	    include_attach_setButtonDisabled(false);
       //}else{
       // saveAccessChangeDetail();  
		//_mainId=accessid;
	  //}
	    
    }else{
        var list = new Array();    	
	    list.push(_fromAccessFormRowSet);
	    var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.AccessChangeAction?action=saveAccessChangeInfo&applyid=0';
	    var recode = saveRowSet(strUrl, list);
	    var accessid = _fromAccessFormRowSet.getValue("ACCESS_ID");
        var message = recode.getValueByName("M");
  	    _fromAccessFormRowSet.refresh("&accessid="+accessid);
	    //_fromAccessFormRowSet.setValue("PRINCIPLE",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
	    //_fromAccessFormRowSet.setValue("ORG",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
  	    setCheckBox();
  	    saveAccessChangeDetail();
	    showName();
	    _mainId=accessid;
    }
}

function setCheckBox(){
   		var scale=_fromAccessFormRowSet.getValue("SCALE");
   		var checkvalues = document.getElementsByName("scaleType");
   		if(scale!=""){
   			var v = new Array();
   			v=scale.split(";");
   			var j =0;
   			var str="";
   			for(j=0;j<v.length;j++){
               for(var i=0;i<checkvalues.length;i++){
                   if(checkvalues[i].value==v[j]){
          	            checkvalues[i].checked=true;
                   }          	          
        	   }
            }
   		}
   		
   		var oldBand=_fromAccessFormRowSet.getValue("OLD_BAND");
   		var checkvalues01 = document.getElementsByName("oldBand");
   		if(oldBand!=""){
   			var v = new Array();
   			v=oldBand.split(";");
   			var j =0;
   			var str="";
   			for(j=0;j<v.length;j++){
               for(var i=0;i<checkvalues01.length;i++){
                   if(checkvalues01[i].value==v[j]){
          	            checkvalues01[i].checked=true;
                   }          	          
        	   }
            }
   		}
   		
   		var newBand=_fromAccessFormRowSet.getValue("NEW_BAND");
   		var checkvalues02 = document.getElementsByName("newBand");
   		if(newBand!=""){
   			var v = new Array();
   			v=newBand.split(";");
   			var j =0;
   			var str="";
   			for(j=0;j<v.length;j++){
               for(var i=0;i<checkvalues02.length;i++){
                   if(checkvalues02[i].value==v[j]){
          	            checkvalues02[i].checked=true;
                   }          	          
        	   }
            }
   		}
}

</script>

<script type="text/javascript">
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
addLoadEvent(init);
addLoadEvent(initCheckPage);
</script>