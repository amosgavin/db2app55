<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>�����������</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  
  <body onload="">
    <ai:contractframe id="accessMainframe" contenttype="table" title="ҵ����������Ҫ��Ϣ" width="100%" allowcontract="true" frameclosed="false">
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
           <td class="td_font">��������:</td>
           <td><ai:dbformfield formid="accessMainForm" fieldname="APPLY_NAME" width="150"/>    
           <ai:dbformfield formid="accessMainForm" fieldname="ACCESS_ID" width="60" editable="" visible="false"/></td>
           <ai:dbformfield formid="accessMainForm" fieldname="STATE" width="150" editable="" visible="false"/>
           <td class="td_font">������:</td>
           <td><ai:dbformfield formid="accessMainForm" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
               <ai:dbformfield formid="accessMainForm" fieldname="STAFFNAME" width="150" editable="" />
           </td>
           <td class="td_font">��ϵ�绰:</td>
           <td><ai:dbformfield formid="accessMainForm" fieldname="TEL" width="150" /></td>
         </tr> 
         <tr>
              <td class="td_font">���뵥λ:</td>
              <td><ai:dbformfield formid="accessMainForm" fieldname="ORG" width="130" editable="false" visible="false"/>
              <ai:dbformfield formid="accessMainForm" fieldname="ORGNAME" width="150" editable=""/></td>
               <td class="td_font">���ſ�ʼʱ��:</td>
               <td><ai:dbformfield formid="accessMainForm" fieldname="B_TIME" width="150"/></td>
               <td class="td_font">���Ž���ʱ��:</td>
               <td><ai:dbformfield formid="accessMainForm" fieldname="E_TIME" width="150"/></td>
           </tr>
           <tr>
               <td class="td_font">���Ŷ���:</td>
               <td><ai:dbformfield formid="accessMainForm" fieldname="O_OBJECT" width="150"/></td>
               <td class="td_font">��������:</td>
               <td><ai:dbformfield formid="accessMainForm" fieldname="O_TYPE" width="150"/></td>
               <td class="td_font">���ŷ�Χ:</td>
               <td colspan="1"><ai:dbformfield formid="accessMainForm" fieldname="SCALE" width="150" visible="false"/>
               <input type=checkbox name="scaleType" value="1">ָ������&nbsp;
               <input type=checkbox name="scaleType" value="2">�԰���&nbsp;
               <input type=checkbox name="scaleType" value="3">������
               </td>
           </tr>
           <tr>
               <td class="td_font">���ǰ����Ʒ��:</td>
               <td colspan="5"><ai:dbformfield formid="accessMainForm" fieldname="OLD_BAND" width="150" visible="false"/>
               <input type=checkbox name="oldBand" value="qqt">ȫ��ͨ
               <input type=checkbox name="oldBand" value="szx">������
               <input type=checkbox name="oldBand" value="dgdd">���еش�
               </td>
           </tr>
           <tr>
               <td class="td_font">����󿪷�Ʒ��:</td>
               <td colspan="5"><ai:dbformfield formid="accessMainForm" fieldname="NEW_BAND" width="150" visible="false"/>
               <input type=checkbox name="newBand" value="qqt">ȫ��ͨ
               <input type=checkbox name="newBand" value="szx">������
               <input type=checkbox name="newBand" value="dgdd">���еش�
               </td>
           </tr>
           <tr>
              <td class="td_font">����˵��������:</td>
              <td colspan="5"><ai:dbformfield formid="accessMainForm" fieldname="REMARK" height="100" width="850"/><span style="font-family:��������; color:red; ">(��ע����ƽ̨��OAƽ̨��Ӧ������)</span></td>
           </tr>
           <tr>
             <td class="td_font">���Ź��Ż������ڵ���ϸ:</td>
              <td colspan="5"><ai:dbformfield formid="accessMainForm" fieldname="ACCES_DETAIL" height="100" width="850"/></td>
           </tr>
       </table>
    </ai:dbform>
</ai:contractframe>
<ai:contractframe id="accessDetailListframe" contenttype="table" title="��ϸ��Ϣ" width="100%" allowcontract="true" frameclosed="fale">
<ai:contractitem>
<div id="edit01">
  <ai:button text="����һ��" id="addLine" onclick="addAccessDetail()" />&nbsp;&nbsp;
  <ai:button text="ɾ����¼" id="addLine" onclick="doWork('deleteLine()')" />&nbsp;&nbsp;
</div>  
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
implservice_querymethod="getAccessChargeDetailById(int accessid,int $STARTROWINDEX, int $ENDROWINDEX)" 
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
implservice_querymethod="getAccessChargeDetailById(int accessid,int $STARTROWINDEX, int $ENDROWINDEX)" 
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
   <div class="" id="edit02">
   <ai:button text="����ҵ������Ϣ" id="query2" onclick="doWork('addAccessInfo()')" />&nbsp;&nbsp;
  </div>
<ai:loginuser/>
<%@include file="/sale/common/include/_check.jsp"%>
</body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script language="javascript" type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"���ڴ������Ժ�...");
}
</script>
<script language="javascript" type="text/javascript">
var _templateCode = "template.AccessChangeFlow";
var _flowType = "accessCaseT";
var _mainId = "";
var _orgId = g_GetUserInfo().ORG_ID;
var recordId = "<%=request.getParameter("recordId")%>";
var applyid="";
var taskTag="<%=request.getParameter("taskTag")%>";

var _fromAccessFormRowSet= g_FormRowSetManager.get("accessMainForm");
var accessDetailListTable01 = g_TableRowSetManager.get("accessDetailListTable01");
var accessDetailListTable02 = g_TableRowSetManager.get("accessDetailListTable02");
var accessDetailListTable03 = g_TableRowSetManager.get("accessDetailListTable03");

document.getElementById("detail03").style.display="none";
document.getElementById("detail02").style.display="none";
document.getElementById("detail01").style.display="none";

document.getElementById("edit01").style.display="none";
document.getElementById("edit02").style.display="none";


function show(){
	alert("recordId:"+recordId);
    alert("taskTag:"+taskTag);
	alert("ACCESS_ID:"+_fromAccessFormRowSet.getValue("ACCESS_ID"));
}

function init(){ 
	var state =_fromAccessFormRowSet.getValue("STATE");
	//�����ѯʱ��״̬Ϊ�ѱ��棩����ҳ��
	hiddenEdit();
    if(applyid==""){
       applyid=recordId;	
    }
	if(""!=applyid ){
	  _mainId=applyid;
	  var staffid="<%=request.getParameter("staffid")%>";
	  //_fromAccessFormRowSet.refresh("&accessid="+applyid);
	  //showName();
	  //_fromAccessFormRowSet.setEditSts(false);
	  //var feeType=_fromAccessFormRowSet.getValue("FEE_TYPE");
	  //var staffId = g_GetUserInfo().STAFF_ID;
	  //document.getElementById("query4").style.display="none";
	  //g_AIButtonManager.get("query2").setDisabled(true);
	  _fromAccessFormRowSet.refresh("&accessid="+applyid);
	  showName();
	  setCheckBox();
	  var accessid =_fromAccessFormRowSet.getValue("ACCESS_ID");	  
	  setdetail();
      var o_object = _fromAccessFormRowSet.getValue("O_OBJECT");
	   if(o_object=="1"){
   	     accessDetailListTable01.refresh("&accessid="+accessid);
	   }
	   if(o_object=="2"){
   	     accessDetailListTable02.refresh("&accessid="+accessid);
	   }
	   if(o_object=="3"){
   	     accessDetailListTable03.refresh("&accessid="+accessid);
	   }
	}
	else{
	//ҳ��ˢ�£������޸ģ�idΪ��ʱ��������
	 var staffId = g_GetUserInfo().STAFF_ID;
    _fromAccessFormRowSet.setValue("O_OBJECT","3");	 
	_fromAccessFormRowSet.setValue("PRINCIPLE",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
	_fromAccessFormRowSet.setValue("ORG",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
	_fromAccessFormRowSet.setValue("TEL",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
	showName();
	if("1"==state||state==""){
		 document.getElementById("include").style.display="block";
	}else if(""!=isSubmit) {
		window.location.href="<%=request.getContextPath()%>/charge/chargeinfo/chargeSelectInfo.jsp?applyid="+applyid;
		}
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
		   alert("����ѡ�񿪷Ŷ���");
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
		   alert("����ѡ�񿪷Ŷ���"+o_object);
		   return;
	   }
	   if(o_object=="1"){
         var selectRows  = accessDetailListTable01.getSelectedRows();
		 if(selectRows.length<1){
			 alert("��ѡ��Ҫɾ�������ݣ�");
			 return;
		 }else{
			 if(confirm("ȷ��Ҫɾ����"+selectRows.length+"��������")){
				  for(var i = 0;i< selectRows.length ;i++){
					 accessDetailListTable01.deleteRow(selectRows[i]);
			      }
			 }
             if(sts=="O"){
                  var accessid = _fromAccessFormRowSet.getValue("ACCESS_ID");            	 
                  var list = new Array();    	
	              list.push(accessDetailListTable01);
	              var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.AccessChangeAction?action=saveAccessChangeDetail&accessid=0';
	              var recode = saveRowSet(strUrl, list);
	              accessDetailListTable01.refresh("&accessid="+accessid);	           
             }				
		 }
       }			 
	   if(o_object=="2"){
       var selectRows  = accessDetailListTable02.getSelectedRows();
		if(selectRows.length<1){
			alert("��ѡ��Ҫɾ�������ݣ�");
			return;
		}else{
			if(confirm("ȷ��Ҫɾ����"+selectRows.length+"��������")){
				for(var i = 0;i< selectRows.length ;i++){
					aaccessDetailListTable02.deleteRow(selectRows[i]);
                }					
			}
             if(sts=="O"){
               var accessid = _fromAccessFormRowSet.getValue("ACCESS_ID");
               var list = new Array();    	
	           list.push(accessDetailListTable02);
	           alert("accessid:"+accessid);
	           var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.AccessChangeAction?action=saveAccessChangeDetail';
	           var recode = saveRowSet(strUrl, list);
	           accessDetailListTable02.refresh("&accessid="+accessid);	           
             }				
		}
       }			
	   if(o_object=="3"){
        var selectRows  = accessDetailListTable03.getSelectedRows();
		if(selectRows.length<1){
			alert("��ѡ��Ҫɾ�������ݣ�");
			return;
		}else{
			if(confirm("ȷ��Ҫɾ����"+selectRows.length+"��������")){
				for(var i = 0;i< selectRows.length ;i++){
					accessDetailListTable03.deleteRow(selectRows[i]);
			    }
			}
             if(sts=="O"){
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
	 alert("���ȱ�������Ϣ��");
	 return;
 }
	//�ʷ�
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
	//��������
	if(o_object == "2"){
   	    if(accessDetailListTable02.getTotalRowCount()>0){
   	      var i = 0;
   	      while(i<accessDetailListTable01.getTotalRowCount()){
             accessDetailListTable02.setValue(i,"ACCESS_ID",accessid,"");
             i++;
          }
	      list.push(accessDetailListTable02);
	      var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.AccessChangeAction?action=saveAccessChangeDetail&accessid='+accessid;
	      var recode = saveRowSet(strUrl,list);
	      accessDetailListTable02.refresh("&accessid="+accessid);
       }
   }
	//Ӫ����
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
	//�ʷ�
	if(o_object=="1"){
       document.getElementById("detail03").style.display="none";
       document.getElementById("detail02").style.display="none";
       document.getElementById("detail01").style.display="block";
	}
	//��������
	if(o_object=="2"){
       document.getElementById("detail01").style.display="none";
       document.getElementById("detail03").style.display="none";
       document.getElementById("detail02").style.display="block";
	}
	//Ӫ����
	if(o_object=="3"){
       document.getElementById("detail01").style.display="none";
       document.getElementById("detail02").style.display="none";
       document.getElementById("detail03").style.display="block";
   }
}

function hiddenEdit(){
	if(taskTag=="A02"||taskTag=="A09"){
		document.getElementById("edit01").style.display="block";
        document.getElementById("edit02").style.display="block";
	}
}

function addAccessInfo(){
 var applyName=_fromAccessFormRowSet.getValue("APPLY_NAME");
 var b_time=_fromAccessFormRowSet.getValue("B_TIME");
 var e_time=_fromAccessFormRowSet.getValue("E_TIME");
 if(""==applyName){return  alert("������ҵ�����������ƣ�");}
 if(""==b_time){return  alert("�����뿪�ſ�ʼʱ�䣡");}
 if(""==e_time){return  alert("�����뿪�Ž���ʱ�䣡");}
 if(1 == g_CompareDate(b_time,e_time)){ return alert("���ſ�ʼʱ��С�ڿ��Ž���ʱ�䣡");}
 var accessDetailListTable = null;
if ("O" != _fromAccessFormRowSet.getSts())
    {
        var list = new Array();
        var checkvalues = document.getElementsByName("scaleType");
        var cv ="";
        for(var i=0;i<checkvalues.length;i++){
        	if(checkvalues[i].checked==true){
          	  cv=cv+checkvalues[i].value+";";
        	}
        }
        _fromAccessFormRowSet.setValue("SCALE",cv);
        var state = _fromAccessFormRowSet.getValue("STATE");
        if(state==""){
           _fromAccessFormRowSet.setValue("STATE","1");
        }
	    list.push(_fromAccessFormRowSet);
	    var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.AccessChangeAction?action=saveAccessChangeInfo&applyid=0';
	    var recode = saveRowSet(strUrl, list);
	    var accessid = recode.getValueByName("accessid");
	    _fromAccessFormRowSet.refresh("&accessid="+accessid);
	    saveAccessChangeDetail();
	    showName();
	    _mainId=accessid;
    }else{
        var list = new Array();    	
	    list.push(_fromAccessFormRowSet);
	    var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.AccessChangeAction?action=saveAccessChangeInfo&applyid=0';
	    var recode = saveRowSet(strUrl, list);
	    var accessid = recode.getValueByName("accessid");
  	    _fromAccessFormRowSet.refresh("&accessid="+accessid);
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


function closePage(){
   window.opener.location.reload();
    window.self.close();
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