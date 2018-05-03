<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<%
   String recordId = request.getParameter("recordId");
 %>
<html>
<head>
<title><i18n:message key="������ǩ" res="i18n.secframe_resource"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initPage()">
<ai:contractframe id="saleWeaponMainframe" contenttype="table" title="��ǰ��������Ϣ" width="100%" allowcontract="true" frameclosed="fale">
<ai:contractitem/>
	<ai:dbform formid="saleWeaponMainframe" 
			setname="com.asiainfo.sale.weapon.web.SETSaleWeaponMain"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="false" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponMainSV"
			implservice_querymethod="getSaleWeaponMainById(String id)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
			<tr>
	           	<td class="td_font">��ǰ�����ˣ�</td>
	           	<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="APPLICANT" width="150" editable="false"/></td>
	           	<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="PRINCIPAL" width="150" visible="false"/></td>
	           	<td class="td_font">�����˵�λ��</td>
	           	<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="ORG" width="130" editable="false"/></td>
	           		<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="PROMOTE_DEPART" width="130" visible="false"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="weaponListframe" contenttype="table" title="������Ϣ" width="100%" allowcontract="false" frameclosed="fale" >
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
		onrowchange="" 
		initial="false" pagesize="100" editable="false" width="100%"
		height="160" needrefresh="true">
		<ai:col title="���" fieldname="WID" width="10%"  visible="false"/>
		<ai:col title="�������" fieldname="MID" width="10%"/>
		<ai:col title="��������" fieldname="WEAPON_NAME" width="20%" />
		<ai:col title="����" fieldname="SALE_FLAG" width="15%" />
		<ai:col title="ϸ���г�" fieldname="MARKET_TYPE" width="15%" />
		<ai:col title="����" fieldname="NET_AGE" width="15%" />
		<ai:col title="����ʱ��" fieldname="CREATE_TIME" width="17%" />
	</ai:table>
	<table align = "center">
		<ai:button id="show" text="�鿴��������" onclick="showWeaponDetail()"/>
	</table>
</ai:contractframe>

<ai:contractframe id="tagDetailframe" contenttype="table" title="�迪����ǩ(��дӪҵ�ʷ�ID)" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:table setname="com.asiainfo.sale.tag.web.SETPromationTag"
			  tableid="detailTagTab" editable="true" width="100%" pagesize="100"
			  needrefresh="true" initial="false" height = "130" multiselect="false"
			  tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			  implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			  implservice_querymethod="getSpareTagDetailByMid(String mids)"			  
			  operator="query">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
	        <tr>
	       		<ai:col fieldname="WPID" width="6%" editable="false" visible="" />
	       		<ai:col title="Ӫҵ�ʷ�ID" fieldname="TAG_CODE" width="10%" visible="true"/>
	        	<ai:col fieldname="TAG_TYPE" width="10%" editable="false" visible="true" />
				<ai:col fieldname="NAME" width="10%" editable="false" visible="true" /> 
				<ai:col fieldname="ADD_MONTHCHARGE" title="�ܽ��" width="5%" editable="false" visible="true" />
				<ai:col fieldname="FIRSTCHARGE" title="�״ε���"  width="6%" editable="false" visible="true"/> 
				<ai:col fieldname="LASTCHARGE"  title="ĩ�ε���" width="7%" editable="false" visible="true"/> 
				<ai:col  fieldname="CHARGE" title="ÿ�½��" width="7%" editable="false" visible="true"/>
				<ai:col title="ÿ������ֵ" fieldname="SUMCHARGE" width="8%" editable="false" />
				<ai:col fieldname="CYCLE"  width="7%" editable="false" visible="true"/> 
				<ai:col title="��������" fieldname="RETURN_TYPE" width="10%" editable="false" visible="true"/>
				<ai:col fieldname="AREA" width="7%" editable="false" visible="true"/>
				<ai:col title="��ǩ��ע" fieldname="REMARK_TAG" width="10%" editable="false" visible="true"/>
					<ai:col title="ר�Χ" fieldname="IS_SP" width="10%" editable="false" visible="true"/>
				<ai:col title="��������" fieldname="ACCOUNT_TYPE" width="10%" editable="false" visible="true"/>
			</tr>
		</table>
	</ai:table>
	<ai:dbform formid="weaponForm" setname="com.asiainfo.sale.weapon.web.SETSaleWeapon" 
		initial="false" editable="false" datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
		implservice_querymethod="getSaleWeaponByID(String wid, int $STARTROWINDEX, int $ENDROWINDEX)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
	          <tr><td class="td_font">�������ʱ�䣺</td>
	           	<td><ai:dbformfield formid="weaponForm" fieldname="CONFIG_TIME" width="100"/>
	           	<a href="#" onclick="window.open('<%=request.getContextPath()%>/sale/common/include/_delayReason.jsp?itemId='+<%=request.getParameter("recordId")%>+'&taskTag=w05','_blank','toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');">
            	<span id="sp_delay" style="font-family:��������; color:red; "></span></a> </td>
	          </tr>
	      </table>
	</ai:dbform>
</ai:contractframe>	

<table align="center"><ai:button id="submit" text="����" onclick="save()"/></table>
					
<ai:contractframe id="reasonframe" contenttype="table" title="�������������" width="100%" height="20" allowcontract="true" frameclosed="true" >
<ai:contractitem/>
<%@ include file="/main3/include/reasonlist.jsp" %>
</ai:contractframe>

<%@include file="/sale/promationTag/attach.jsp"%>

<ai:contractframe id="tagApproveframe" contenttype="table" title="��ǩ������Ϣ" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="approveForm" 
			setname="com.asiainfo.sale.tag.web.SETApproveColumn"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
			
			<tr><td class="td_font">ѡ��Э���ˣ�</td>
				<td><input type="text" id="assistEmp" style="width: 300px;"/>
				    <img id="selectStaff3" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="assistEmpSelect();" align="middle" style="cursor:hand;"/>
				</td></tr>
			<tr><td class="td_font"><i18n:message key="SOS0100102" res="CRM" /></td>
				<td><input type="text" id="appriseEmp" style="width: 300px;"/>
				    <img id="selectStaff2" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="appriseEmpSelect();" align="middle" style="cursor:hand;"/>
				</td>
			</tr>
			<tr>
	           	<td class="td_font">�������ݣ�</td>
	           	<td><ai:dbformfield formid="approveForm" fieldname="ADVISE" width="600" height="180"/><span class="font_red">*</span></td>
	           	
			</tr>
		</table>
	</ai:dbform>
	
<ai:button id="submit" text="��     ��" onclick="commit()"/>
</ai:contractframe>

<ai:contractframe id="proxyframe" contenttype="table" title="�Ӱ�(������Ҳ�����°�ť)" width="100%" allowcontract="true" frameclosed="true">
	<ai:contractitem/>
	<ai:dbform formid="proxyTaskForm" 
			setname="com.asiainfo.sale.tag.web.SETApproveColumn"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
			<tr><td class="td_font">ָ���Ӱ���    ��  </td>
				<td><input type = "text" id = "staffId" value='' />
				<img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="middle" style="cursor:hand;"/>&nbsp;&nbsp;
				<ai:button id="submit" text="��     ��" onclick="reAuthorizeTask()"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:loginuser/>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script type="text/javascript">

var operatorId = '';
var appriseEmp = '';
var assistEmp = '';
var taskState = "taskIsEnd";
var workflowId = "<%=request.getParameter("workflowId")%>";
var vmTaskId = "<%=request.getParameter("taskId")%>";
var _tableTagDetailRowSet = g_TableRowSetManager.get("detailTagTab");
var saleWeaponMainframe = g_FormRowSetManager.get("saleWeaponMainframe");
var weaponRs = g_TableRowSetManager.get("weaponMainListTable");
var weap = g_FormRowSetManager.get("weaponForm");
var rid = <%=recordId%>;
function initPage()
{
	document.getElementById("staffId").disabled=true;
	document.getElementById("appriseEmp").disabled=true;
	document.getElementById("assistEmp").disabled=true;
	var taskTag = "w05";
	saleWeaponMainframe.setValue("APPLICANT",g_GetUserInfo().STAFF_NAME);
	saleWeaponMainframe.setValue("ORG",g_GetUserInfo().ORG_NAME);
	if (rid == null){
		//weaponRs.refresh("&taskTag=" + taskTag);
	} else {
		weaponRs.refresh("&wid="+rid+"&weaponName="+"&busiType=");
	}
	weaponRs.rowSelected(0,true);
	showTagInfo();
	var ret = PostInfo(_gModuleName + '/business/com.asiainfo.common.web.ItemOtherInfoAction?action=getAdDateInGeneral&itemId=' + <%=request.getParameter("recordId")%> + "&taskTag=w05");
   	if (ret.getValueByName("FLAG") == 'Y') {
   		weap.setValue("CONFIG_TIME", ret.getValueByName("advDate").substr(0,10));
   		var advDate = ret.getValueByName("advDate").substr(0,10);  
		advDate = advDate.replace(/-/g,"/");//�滻�ַ�����ɱ�׼��ʽ  
		var d2=new Date();//ȡ���������  
		var d1 = new Date(Date.parse(advDate));
		if (d1 < d2 ) {
			document.getElementById("sp_delay").innerHTML='�����Ѿ���ʱ������д��ʱԭ��(�����ɫ���������д)*';
		}
	} 
}

function showWeaponDetail(){
	
	var curRowIndex = weaponRs.getCurRowIndex();
	var weaponId = weaponRs.getValue(curRowIndex, "MID");
	var saleFale=weaponRs.getValue(curRowIndex, "SALE_FLAG");
	if( weaponId != null && weaponId != ""){
		
		   window.open("<%=request.getContextPath()%>/sale/weapon/WeaponInfo.jsp?WID="+weaponId + "&saleFale="+saleFale,"","height=650,width=600,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
		   
      } else {
           alert("��ѡ�����У�");
      }
}

function checkBossId()
{
	var length = _tableTagDetailRowSet.getTotalRowCount();
	
	for (var i=0; i<length; ++i){
		tmp = _tableTagDetailRowSet.getValue(i, "TAG_CODE");
	
		if (null == tmp || "" == tmp){
			alert("����д��Ӫҵ�ʷ�ID!");
			return false;
		}
	}
	return true;
}

function update()
{
	var selRows = new Array();
	var idList = new Array();
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
	var url = "<%=request.getContextPath()%>/sale/promationTag/writeBossIdTag.jsp?id="+idList[0];
	var retVal = window.showModalDialog(url, null, "scroll:yes;resizable:no;help:no;status:yes;dialogHeight:300px;dialogWidth:700px");
	var count = weaponRs.count();
		var mids = "";
		for(var i=0;i<count;i++){
			mids = mids + weaponRs.getValue(i, "WID")+",";
		}
		_tableTagDetailRowSet.refresh("&mids=" + mids);
	//_tableTagDetailRowSet.refresh("&weaponId=" + weaponId);
}

function save()
{
		//�ж�boss id�Ƿ�Ϊ��
		var isTrue = checkBossId();
		if(!isTrue) {
			return;
		}
		var xmlbody = _tableTagDetailRowSet.toXmlString(true);
		if (xmlbody == null || xmlbody == "") {
			alert("����û�ı�!");
			return;
		}
		var xml = "<RootInfo>" + xmlbody + "</RootInfo>";
		var ud = PostInfo(
				"<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveDetailTag&pid=0",
				xml);
		if (ud.getValueByName("FLAG") == "Y") {
			alert("����Ӫҵ�ʷ�ID�ɹ���");
		} else {
			alert(ud.getValueByName("MESSAGE"));
			return;
		}
		//isSavedBossId = true;
		var count = weaponRs.count();
		var mids = "";
		for(var i=0;i<count;i++){
			mids = mids + weaponRs.getValue(i, "WID")+",";
		}
		_tableTagDetailRowSet.refresh("&mids=" + mids);
		var curRowIndex = weaponRs.getCurRowIndex();
		var weaponId = weaponRs.getValue(curRowIndex, "WID");
		//_tableTagDetailRowSet.refresh("&weaponId=" + weaponId);
}

function reasonGo(wid, taskType){
  reason(wid,taskType);
}

function showTagInfo()
{
	if(weaponRs.getTotalRowCount() == 0){
		return;
	}
	var count = weaponRs.count();
		var mids = "";
		for(var i=0;i<count;i++){
			mids = mids + weaponRs.getValue(i, "WID")+",";
		}
	_tableTagDetailRowSet.refresh("&mids=" + mids);
	var curRowIndex = weaponRs.getCurRowIndex();
	var weaponId = weaponRs.getValue(curRowIndex, "WID");
	//_tableTagDetailRowSet.refresh("&weaponId=" + weaponId);
	//reasonGo(weaponId,"weaponCase");
	weap.refresh("&wid=" + weaponId);
	include_reflashAttachTable();
}

function beforeCommit()
{
		var xmlbody = _tableTagDetailRowSet.toXmlString(true);
		if (xmlbody == null || xmlbody == "") {
			//alert("����û�ı�!");
			return;
		}
		var xml = "<RootInfo>" + xmlbody + "</RootInfo>";
		var ud = PostInfo(
				"<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveDetailTag&pid=0",
				xml);
		if (ud.getValueByName("FLAG") == "Y") {
		
		} else {
			alert(ud.getValueByName("MESSAGE"));
			return 'no';
		}
}

function sendApprise()
{
	if (appriseEmp == '' && assistEmp == ''){
		
	} else {
		
		var content = g_FormRowSetManager.get("approveForm").getValue("ADVISE");
	    var condition = 'workflowId=' + workflowId + '&appriseEmp=' + appriseEmp + '&assistEmp=' + assistEmp + '&content=' +content ;
		var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AppriseAction?action=saveAppriseMember&' + condition;
		var recode = PostInfo(strUrl, null);
		if (recode.getValueByName("FLAG") == "Y") {
			
		} else {
			alert(recode.getValueByName("MESSAGE"));
			return;
		}
	}
}

function commit()
{
		//�ж�boss id�Ƿ�Ϊ��
		var isTrue = checkBossId();
		if(!isTrue) {
			return;
		}
		//�ж�boss id�Ƿ񱣴��
		//if (!isSavedBossId){
		if (beforeCommit() == 'no') {
			return;
		}
		//}
		
		var reason = g_FormRowSetManager.get("approveForm").getValue("ADVISE");
		var curRowIndex = weaponRs.getCurRowIndex();
		var weaponId = weaponRs.getValue(curRowIndex, "WID");
		var taskId = "<%=request.getParameter("taskId")%>";
		//alert(reason);
		if (reason == null || reason ==""){
			alert("����д�ÿ������ܣ�");
			return;
		}
			var condition = "&weaponId=" + weaponId + "&taskState=" + taskState;
	        var strUrl = _gModuleName + '/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=finishUserTask&taskId=' + taskId
	                    + "&staffId=111"                                                                     
	                    + "&reason=" + trim(reason);
			sendApprise();
	        var recode = PostInfo(strUrl);
	        if ("Y" == recode.getValueByName("FLAG"))
	        {
	            alert("�ύ�ɹ�");
	            strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.TagFlowAction?action=afterFinishTask&condition=' + condition;
				PostInfo(strUrl, null);
	            
	        } else {
	            alert(recode.getValueByName("MESSAGE"));
	        }
	        window.parent.opener.location.reload();
            window.self.close();
}

function reAuthorizeTask()
{
		if (document.getElementById("staffId").value==''){
			alert("����ָ����Ա��")
			
		} else {
			
			configTime = weap.getValue("CONFIG_TIME");
			var curRowIndex = weaponRs.getCurRowIndex();
			var taskId = "<%=request.getParameter("taskId")%>";
			
	        PostInfo(_gModuleName + '/business/com.asiainfo.common.web.ItemOtherInfoAction?action=reComputeAdviseDate&itemId='+<%=request.getParameter("recordId")%>+"&itemType=weaponCase&node=pz&taskTag=w05&reAuthorOpid="+operatorId);
			var strUrl = "<%=request.getContextPath()%>/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=reAuthorizeTask&taskId="+taskId + "&nextStaffId="+operatorId;      
        
	        var recode = PostInfo(strUrl);
	        if ("Y" == recode.getValueByName("FLAG"))
	        {
	            alert("�Ӱ��ύ�ɹ�");
	            
	        } else {
	            alert(recode.getValueByName("MESSAGE"));
	        }
	      	window.parent.opener.location.reload();
            window.self.close();
		}
}


function trim(str)
{
     return str.replace(/(^\s*)(\s*$)/g, '');
}

function selectStaff()
{
        //var url = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?org_id=10";
        //var result = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:s;dialogHeight:630px;dialogWidth:650px");
        var result = openSelect.staffSelect("tsd",'10',g_GetUserInfo().ORG_ID);
        if(result != null){
            
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
            document.getElementById("staffId").value = name; 
        }
} 

function appriseEmpSelect()
{
        //url = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s.jsp?org_id=10";
        //var result = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:s;dialogHeight:600px;dialogWidth:650px");
        var result = openSelect.staffSelect("tmd",'10',g_GetUserInfo().ORG_ID);
        if(result != null){
            
            var name;
            for(var i=0;i < result.elements.length;i++)
            {
                if (i == 0)
                {
                    appriseEmp = result.elements[i].operatorId;
                    name = result.elements[i].name;
                } else {
                    appriseEmp = appriseEmp + ";" + result.elements[i].operatorId;
                    name = name + ";" + result.elements[i].name;
                }
            }
            document.getElementById("appriseEmp").value = name; 
        }
} 

function assistEmpSelect()
{
        //url = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s.jsp?org_id=10";
        //var result = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:s;dialogHeight:600px;dialogWidth:650px");
         var result = openSelect.staffSelect("tmd",'10',g_GetUserInfo().ORG_ID);
        if(result != null){
            
            var name;
            for(var i=0;i < result.elements.length;i++)
            {
                if (i == 0)
                {
                    assistEmp = result.elements[i].operatorId;
                    name = result.elements[i].name;
                } else {
                    assistEmp = assistEmp + ";" + result.elements[i].operatorId;
                    name = name + ";" + result.elements[i].name;
                }
            }
            document.getElementById("assistEmp").value = name; 
        }
}
</script>
