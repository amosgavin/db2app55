<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<%
   String recordId = request.getParameter("recordId");
 %>
<html>
<head>
<title>ָ����ǩ��</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="">
  
    <ai:contractframe id="saleWeaponMainframe" contenttype="table" title="��������Ϣ" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="saleWeaponMainframe" 
			setname="com.asiainfo.sale.weapon.web.SETSaleWeaponMain"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponMainSV"
			implservice_querymethod="getSaleWeaponMainById(String id)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<ai:dbformfield formid="saleWeaponMainframe" fieldname="WMID" visible="false"/>   
	           	<ai:dbformfield formid="saleWeaponMainframe" fieldname="WID" visible="false"/>     	
	           	<td class="td_font">��ǰ�����ˣ�</td>
	           	<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="APPLICANT" width="150" editable="false"/>
	           	<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="PRINCIPAL" width="150" visible="false"/>
	           	<td class="td_font">�����˵�λ��</td>
	           	<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="ORG" width="130" editable="false"/>
	           		<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="PROMOTE_DEPART" width="130" visible="false"/>
			</tr>
			<tr style="display:none">
	           	<td class="td_font">��ǰʱ�䣺</td>
	           	<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="CREATE_TIME" width="150"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
  
  
  
<ai:contractframe id="weaponListframe" contenttype="table" title="��������" width="100%" allowcontract="false" frameclosed="fale" >
	<ai:contractitem/>
 	<ai:table
		tableid="weaponMainListTable"
		setname="com.asiainfo.sale.weapon.web.SETSaleWeapon"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
		implservice_querymethod="getSaleWeapon(String mid,String wwid,String wid,String weaponName, String marketType,
			String backMonth, String baseMonth, String lLimit, String bLimit,
			String presentValuePermon, String presentBusiMonth, String busiType,
			String netAge, String couponsValue, String selfBusi,
			String goodAdoptDirectory,String state,String presentBusiAmount,
			String presentReachAmount,String presentValuePermon,String presentBusi2Amount,
			String zfqType,String presentBusi4Amount,String openMonth,String minNetAge,String maxNetAge,
			int $STARTROWINDEX, int $ENDROWINDEX)"
		implservice_countmethod="getCount(String mid,String wwid,String wid,String weaponName,
			String marketType, String backMonth, String baseMonth, String lLimit,
			String bLimit, String saleFlag, String presentBusiMonth, String busiType,
			String netAge, String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state,String presentBusiAmount,String presentReachAmount,
			String presentValuePermon,String presentBusi2Amount,
			String zfqType,String presentBusi4Amount,String openMonth,String minNetAge,String maxNetAge)"
		onrowchange="aduit" 
		initial="false" pagesize="15" editable="false" width="100%"
		height="160" needrefresh="true">
		<ai:col title="�������" fieldname="WID" width="10%"  visible="false"/>
		<ai:col title="�������" fieldname="MID" width="10%"/>
		<ai:col title="��������" fieldname="WEAPON_NAME" width="20%" />
		<ai:col title="����" fieldname="SALE_FLAG" width="15%" />
		<ai:col title="ϸ���г�" fieldname="MARKET_TYPE" width="15%" />
		<ai:col title="����" fieldname="NET_AGE" width="15%" />
			<ai:col title="����ʱ��" fieldname="CREATE_TIME" width="17%" />
	</ai:table>

</ai:contractframe>

  <div class="area_button">
  <ai:button text="�鿴��ϸ" id="query1" onclick="doWork('modifyInfo()')" />&nbsp;&nbsp;
  <!--����<a href>�򿪵Ĵ��ڱ���ʹ�á�#nogo��; -->
  <div class="" id="time" style="display:none">
<ai:contractframe id="tagDetailframe" contenttype="table" title="��Ҫ�������ñ�ǩ" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:table setname="com.asiainfo.sale.tag.web.SETPromationTag"
			  tableid="detailTagTab" width="100%" multiselect="true"
			  needrefresh="true" initial="false" height = "100"
			  tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			  implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			  implservice_querymethod="getSpareTagDetailByMid(String mids)"			  
			  operator="query">
	       		<ai:col fieldname="WPID" width="6%" editable="false" visible="" />
	        	<ai:col fieldname="TAG_TYPE" width="10%" editable="false" visible="true" />
				<ai:col fieldname="NAME" width="10%" editable="false" visible="true" /> 
				<ai:col fieldname="ADD_MONTHCHARGE" title="�ܽ��" width="8%" editable="false" visible="true" />
				<ai:col fieldname="FIRSTCHARGE" title="�״ε���"  width="7%" editable="false" visible="true"/> 
				<ai:col fieldname="LASTCHARGE"  title="ĩ�ε���" width="7%" editable="false" visible="true"/> 
				<ai:col  fieldname="CHARGE" title="ÿ�½��" width="7%" visible="true"/>
				<ai:col title="ÿ������ֵ" fieldname="SUMCHARGE" width="8%" editable="false" />
				<ai:col fieldname="CYCLE"  width="7%" editable="false" visible="true"/> 
				<ai:col title="��������" fieldname="RETURN_TYPE" width="10%" editable="false" visible="true"/>
				<ai:col title="ר�Χ" fieldname="IS_SP" width="10%" editable="false" visible="true"/>
					<ai:col fieldname="AREA" width="7%" editable="false" visible="true"/>
				<ai:col title="��ǩ��ע" fieldname="REMARK_TAG" width="15%" editable="false" visible="true"/>
	</ai:table>
</ai:contractframe>	
<div style="display:none"><table align="center"><ai:button id="submit" text="�޸ı�ǩ" onclick="updateTag()"/></table></div>
	  </div>
</div>
<h1></h1>
<table>
<tr>
<td>��ѡ����һ��������</td>
<td><select  id="result" onchange="getSelectValue(this);"> 
   <option value="hq">��ǩ</option> 
   <option id="pz01" value="pz">ҵ֧���ķ�����������</option>
   <option id="ty01" value="0">ͬ�����</option>
   <option value="false">��ͬ��</option>
  </select> 
  </td>
  </tr>
</table>

<table width="100%">
<td width="60%">
<div id="showhq">
<ai:contractframe id="wfCheckframe" contenttype="table" title="ָ������Ϣ" width="98%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="wfCheckForm" 
        onvalchange="" initial="false"
        setname="com.asiainfo.sale.common.web.SETFWOperate">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr style="">
                <td class="td_font"  style="display: none">��ǩ�˱�ţ�</td>
                <td  style=""><ai:dbformfield formid="wfCheckForm" fieldname="APPLYID" visible="false"/></td>
            </tr>
            <tr id="result" >
                <td class="td_font">Э���ˣ�</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="ASSISTEMP" width="260" visible=""/>
                <img id="selectStaff1" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff('ASSISTEMP');" align="absmiddle" style="cursor:hand;"/>
                <ai:dbformfield formid="wfCheckForm" fieldname="RESULT" width="260" visible="false"/></td>
            </tr>
            
             <tr id="comment">
                <td class="td_font">֪���ˣ�</td>
                <td>
                <ai:dbformfield formid="wfCheckForm" fieldname="APPRISEEMP" width="260" visible=""/>
                <img id="selectStaff2" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff('APPRISEEMP');" align="absmiddle" style="cursor:hand;"/>
                <ai:dbformfield formid="wfCheckForm" fieldname="COMMENT" width="260" height="60" visible="false"/></td>
            </tr>
            <tr id="staffs">
                <td class="td_font" id="staffMain01">��һ����ǩ�ˣ�</td>
                <td id="staffMain02"><ai:dbformfield formid="wfCheckForm" fieldname="STAFFS" width="260"/>
                <img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff('STAFFS');" align="absmiddle" style="cursor:hand;"/></td>
            </tr>
            <tr id="reason" style="">
                <td class="td_font">˵����</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="REASON"  width="500" height="100"/></td>
            </tr>
            <tr><td class="td_font"><ai:button text="�ύ" id="query1" onclick="doWork('Assign()')" />&nbsp;&nbsp;</td></tr>
        </table>
    </ai:dbform>
</ai:contractframe>
</div>

</td>

  <td id="add" style="display:none;" width="40"><img border="0" src="<%=request.getContextPath()%>/webframe/images/icon/left.gif"  alt="" onClick="add()" align="absmiddle" /></td>
  <td id="remove" width="40"><img border="0" src="<%=request.getContextPath()%>/webframe/images/icon/right.gif"  alt="" onClick="remove()" align="absmiddle" /></td>
            
<td>
<ai:contractframe id="wfCheckframe1" contenttype="table" title="�Ӱ�����Ϣ" width="98%" allowcontract="true" frameclosed="true">
    <ai:contractitem/>
    <ai:dbform formid="wfCheckForm1" 
        onvalchange="" initial="false"
        setname="com.asiainfo.sale.common.web.SETFWOperate">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr style="">
                <td class="td_font"  style="display: none">��ǩ�˱�ţ�</td>
                <td  style=""><ai:dbformfield formid="wfCheckForm1" fieldname="APPLYID" visible="false"/></td>
            </tr>
            <tr id="result" style="display: none;">
                <td class="td_font">����������</td>
                <td><ai:dbformfield formid="wfCheckForm1" fieldname="RESULT" width="150"/></td>
            </tr>
            <tr id="staffs">
                <td class="td_font">�Ӱ��ˣ�</td>
                <td><ai:dbformfield formid="wfCheckForm1" fieldname="STAFFS" width="260"/><img id="selectStaff1" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff('STAFFS1');" align="absmiddle" style="cursor:hand;"/></td>
            </tr>
            <tr id="reason" style="">
                <td class="td_font">˵����</td>
                <td><ai:dbformfield formid="wfCheckForm1" fieldname="REASON" width="500" height="100"/></td>
            </tr>
            <tr id="comment" style="display: none;">
                <td class="td_font">ע�ͣ�</td>
                <td><ai:dbformfield formid="wfCheckForm1" fieldname="COMMENT" width="260" height="60" visible="false"/></td>
        </table>
    </ai:dbform>
    <div class="area_button">
   <ai:button text="�Ӱ�" id="queryB" onclick="doWork('AssignJB()')" />&nbsp;&nbsp;
   </div>
</ai:contractframe>
</td>

</table>

<ai:loginuser/>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script type="text/javascript">
var weaponMainListTable=g_TableRowSetManager.get("weaponMainListTable");
var saleWeaponMainframe = g_FormRowSetManager.get("saleWeaponMainframe");
var _fromWfCheckFormRowSet1 = g_FormRowSetManager.get("wfCheckForm1");
var _fromWfCheckFormRowSet = g_FormRowSetManager.get("wfCheckForm");
var _tableTagDetailRowSet = g_TableRowSetManager.get("detailTagTab");

var rid = <%=recordId%>;
init();
function init(){
 var staffId = g_GetUserInfo().STAFF_ID;
    saleWeaponMainframe.setValue("APPLICANT",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
    saleWeaponMainframe.setValue("PRINCIPAL",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
    saleWeaponMainframe.setValue("PROMOTE_DEPART",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
	saleWeaponMainframe.setValue("ORG",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
    var weaponMainListTable=g_TableRowSetManager.get("weaponMainListTable");
    //var list = new Array();
	//list.push(weaponMainListTable);
	//var strUrl = _gModuleName + '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=getSaleWeaponAssign&taskTag=w01';
	//saveRowSet(strUrl,list);
	if(rid==null){
	weaponMainListTable.refresh("&taskTag=w01");
	weaponMainListTable.rowSelected(0,true);
	}else{
	weaponMainListTable.refresh("&wid="+rid+"&weaponName="+"&busiType=");
	weaponMainListTable.rowSelected(0,true);
	//var curRowIndex = weaponMainListTable.getCurRowIndex();
	//weaponId = weaponMainListTable.getValue(curRowIndex, "WID");
	//_tableTagDetailRowSet.refresh("&weaponId=" + weaponId);
		var count = weaponMainListTable.count();
	var mids = "";
	for(var i=0;i<count;i++){
		mids = mids + weaponMainListTable.getValue(i, "WID")+",";
	}
	_tableTagDetailRowSet.refresh("&mids=" + mids);
	_tableTagDetailRowSet.rowSelected(0,true);
		if(_tableTagDetailRowSet.isSelected(0)==false){
			document.getElementById("result").options[1]=null;
		}else{
		document.getElementById("result").options[2]=null;
		}
	}
	
}

  var curTag="";
function aduit(showTime){
	
		    var curRow = weaponMainListTable.getRow();
		    var wid = weaponMainListTable.getValue(curRow,"WID");
		     var mid = weaponMainListTable.getValue(curRow,"MID");				
			//var taskTag = weaponMainListTable.getValue(curRow,"TASK_TAG");
			if(mid!=""){
				//reasonGo(mid,"weaponCase");
	            var strUrl = "<%=request.getContextPath()%>/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=AduitSaleWeapon&wid="+wid+"&mid="+mid+"&result="+result+"&reason="+reason+"&showTime="+showTime;      
	            var ud = PostInfo(strUrl,"");
	            if(ud){
			            if(ud.getValueByName("MESSAGE")=="WAIT"){
			            var reason=document.getElementById("time").style.display="block";
			            }else if(ud.getValueByName("MESSAGE")=="OK"){
			            var reason=document.getElementById("time").style.display="none";
			            }else{
		              init();
		              location.reload();
		            }
	            }   
            }

}

function reasonGo(vt1,vt2){
  reason(vt1,vt2);
}


function modifyInfo(oldRow,newRow){
			var curRow = weaponMainListTable.getRow();
			var wid = weaponMainListTable.getValue(curRow,"MID");
		    var saleFale = weaponMainListTable.getValue(curRow,"SALE_FLAG");		
			if(wid!=""){	
		    window.open("<%=request.getContextPath()%>/sale/weapon/WeaponInfoCommit.jsp?WID="+wid+"&saleFale="+saleFale+"&type=aduit","","height=650,width=700,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no"); 
			}else{
            alert("��ѡ�����У�");
            }
		} 
		
		
		
function remove(){
    AIContractFrame_OpenClose("wfCheckframe1");
    AIContractFrame_openMe();
    AIContractFrame_OpenClose("wfCheckframe");
    AIContractFrame_closeMe();
add1();
}

function add1(){
_fromWfCheckFormRowSet.setValue("REASON","");
document.getElementById("remove").style.display="none";
document.getElementById("add").style.display="block";
}

function add2(){
 _fromWfCheckFormRowSet1.setValue("APPLYID", "");
 _fromWfCheckFormRowSet1.setValue("STAFFS","");
document.getElementById("remove").style.display="block";
document.getElementById("add").style.display="none";
}   
function add(){
    AIContractFrame_OpenClose("wfCheckframe");
     AIContractFrame_openMe();
    AIContractFrame_OpenClose("wfCheckframe1");
    AIContractFrame_closeMe();
    add2();
}


function AssignJB(){
            var curRow = weaponMainListTable.getRow();
			var taskId="<%=request.getParameter("taskId")%>";
			var authorizeStaffId=g_GetUserInfo().STAFF_ID;
			var staffid=_fromWfCheckFormRowSet1.getValue("APPLYID");
			if(staffid!=0&&taskid!=""){
	            var strUrl = "<%=request.getContextPath()%>/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=reAuthorize&taskid="+taskid+"&authorizeStaffId="+authorizeStaffId+"&staffid="+staffid;      
	            var ud = PostInfo(strUrl);
	            if(ud){
	            alert(ud.getValueByName("MESSAGE"));
	            init();
	            window.parent.opener.location.reload();
            	window.self.close();
	            } 
            }else{
            alert("��û��ѡ�����л��߼Ӱ��ˣ�");	
            }	
}


function selectStaff(showtype)
    {
    
       	// var url = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s.jsp?org_id=10";
        //var result = window.showModalDialog(url, null, "scroll:yes;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px");
          //var result = openSelect.staffSelect("tmd",'10');
         var result = openSelect.staffSelect("tmd",'10',g_GetUserInfo().ORG_ID);
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
              _fromWfCheckFormRowSet.setValue("APPLYID", operatorId);
              if(showtype=="STAFFS"){
              _fromWfCheckFormRowSet.setValue("STAFFS", operatorId, name); 
              }else if(showtype=="APPRISEEMP"){
                _fromWfCheckFormRowSet.setValue("APPRISEEMP", operatorId, name); 
              }else if(showtype=="ASSISTEMP"){
                _fromWfCheckFormRowSet.setValue("ASSISTEMP", operatorId, name); 
              }else if(showtype=="STAFFS1"){
                 _fromWfCheckFormRowSet1.setValue("STAFFS", operatorId, name); 
              }
        }
    } 
 
 
 function getRadio(ynflag){
	 if("n"==ynflag){
	 document.getElementById("time").style.display="none";
	 }else{
	 	 var curRow = weaponMainListTable.getRow();
		 var wid = weaponMainListTable.getValue(curRow,"WID");	
		 var mid = weaponMainListTable.getValue(curRow,"MID");
	     var strUrl = "<%=request.getContextPath()%>/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=AduitSaleWeapon&wid="+wid;      
		 var ud = PostInfo(strUrl,"");
			 if(ud.getValueByName("MESSAGE")=="WAIT"){
				document.getElementById("time").style.display="block";
		   }
		   if(ud.getValueByName("MESSAGE")=="OK"){
		        document.getElementById("time").style.display="none";
		   }
	 }
	 }
 
 function selectStaff1()
    {
    
    var roleId="101432";
    var orgid=g_GetUserInfo().ORG_ID;
        var url = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s1.jsp?roleId="+roleId+"&orgId="+orgid;
        var result = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px");
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
        }
    } 
    
    
function updateTag()
{
	var selRows = new Array();
	var idList = new Array();
	//var curRowIndex = weaponMainListTable.getCurRowIndex();
	//weaponId = weaponMainListTable.getValue(curRowIndex, "WID");
	var count = weaponMainListTable.count();
	var mids = "";
	for(var i=0;i<count;i++){
		mids = mids + weaponMainListTable.getValue(i, "WID")+",";
	}
	selRows = _tableTagDetailRowSet.getSelectedRows();
	if(selRows != null && selRows.length > 0)
	{
		var sleRowCount = selRows.length;
		var i = -1;
		while (sleRowCount > 0) {
			sleRowCount--;
			idList[++i] = _tableTagDetailRowSet.getValue(selRows[sleRowCount], "ID");
		}
	} else {
		alert("����ѡ��Ҫ�޸ĵ���!");
		return;
	}
	var url = "<%=request.getContextPath()%>/sale/promationTag/updateTag.jsp?id="+idList[0];
	var retVal = window.showModalDialog(url, null, "scroll:yes;resizable:no;help:no;status:yes;dialogHeight:300px;dialogWidth:700px");
	//_tableTagDetailRowSet.refresh("&weaponId=" + weaponId);
	_tableTagDetailRowSet.refresh("&mids=" + mids);
}

var typeCharge="hq";
function getSelectValue(obj) {
           typeCharge = obj.options[obj.options.selectedIndex].value; //����ȡֵ
	           if(typeCharge=="pz"){
	           document.getElementById("staffMain01").style.display="none";
	           document.getElementById("staffMain02").style.display="none";
	           _fromWfCheckFormRowSet.setValue("STAFFS", ""); 
	           }else if(typeCharge=="hq"){
	             document.getElementById("staffMain01").style.display="block";
	             document.getElementById("staffMain02").style.display="block";
	           }else{
	             document.getElementById("staffMain01").style.display="none";
	          	 document.getElementById("staffMain02").style.display="none";
	            _fromWfCheckFormRowSet.setValue("STAFFS", ""); 
	           }
           }
           

function Assign(){
			var curRow = weaponMainListTable.getRow();
			var wid = weaponMainListTable.getValue(curRow,"WID");
			var mid = weaponMainListTable.getValue(curRow,"MID");
			//var taskTag = weaponMainListTable.getValue(curRow,"TASK_TAG");
			var reason=_fromWfCheckFormRowSet.getValue("REASON");
			var staffshq=_fromWfCheckFormRowSet.getValue("STAFFS");
			var taskId="<%=request.getParameter("taskId")%>";
			var workflowId = "<%=request.getParameter("workflowId")%>";
			var appriseEmp=_fromWfCheckFormRowSet.getValue("APPRISEEMP");
			var assistEmp=_fromWfCheckFormRowSet.getValue("ASSISTEMP");
		    //var remark=encodeURI(reaon);
			var taskType = "user";
			var flowType = "weaponCase";
			var mainId = wid;
			var nowtime =new Date();
			var time =nowtime.toLocaleString();
			time=time.replace("��","-");
			time=time.replace("��","-");
			time=time.replace("��","");
			if(typeCharge=="pz"||typeCharge=="hq"){
				if(reason==""){
	            return alert("�������ǩ˵����");
	            }
            }
				if(wid!=""){
					if(typeCharge=="pz"){
					staffid="20004952";  //ָ���������ñ��ñ�ʶ
					}
					else if(typeCharge=="hq"){
						if(staffshq==""){
			            alert("�������ǩ�ˣ�");
			            return;
			            }
					var staffid=_fromWfCheckFormRowSet.getValue("APPLYID");
					}
					else if(typeCharge=="0"||typeCharge=="false"){
					staffid=g_GetUserInfo().STAFF_ID;
					}
				//֪�ỷ��
				if(assistEmp!=""||appriseEmp!=""){
				var condition = 'workflowId=' + workflowId + '&appriseEmp=' + appriseEmp + '&assistEmp=' + assistEmp + '&content=' +reason ;
				var strUrlzh = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AppriseAction?action=saveAppriseMember&' + condition;
				var recode = PostInfo(strUrlzh, null);
				}
				//֪�ỷ�ڽ���
	           // var strUrl = "<%=request.getContextPath()%>/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=AssignSaleWeapon&wid="+wid+"&taskTag="+taskTag+"&staffid="+staffid+"&remark="+remark;      
				var strUrl = _gModuleName + '/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=finishUserTask&result=' + typeCharge 
																															+ "&staffId=" + staffid+"&reason="+reason+"&taskId="+taskId+"&taskType="+taskType
																															+"&flowType="+flowType+"&mainId="+mainId;	            
	            var ud = PostInfo(strUrl,"");
	            alert(ud.getValueByName("MESSAGE"));
	            location.reload();
	            window.parent.opener.location.reload();
            	window.self.close();
            }else{
            alert("��û��ѡ�����л��߻�ǩ�ˣ�");
            }		
}
</script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"���ڴ������Ժ�...");
}
</script>
  </body>
</html>
