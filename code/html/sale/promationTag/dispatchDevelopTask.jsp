<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<%
   String recordId = request.getParameter("recordId");
 %>
<html>
<head>
<title><i18n:message key="支撑中心分派配置任务" res="i18n.secframe_resource"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initPage()">
<ai:contractframe id="saleWeaponMainframe" contenttype="table" title="当前操作人信息" width="100%" allowcontract="true" frameclosed="fale">
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
	           	<td class="td_font">当前操作人：</td>
	           	<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="APPLICANT" width="150" editable="false"/></td>
	           	<td class="td_font">操作人单位：</td>
	           	<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="ORG" width="130" editable="false"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:contractframe id="weaponListframe" contenttype="table" title="武器信息" width="100%" allowcontract="false" frameclosed="fale" >
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
		initial="false" pagesize="7" editable="false" width="100%"
		height="160" needrefresh="true">
		<ai:col title="编号" fieldname="WID" width="10%"  visible="false"/>
		<ai:col title="武器编号" fieldname="MID" width="10%"/>
		<ai:col title="武器名称" fieldname="WEAPON_NAME" width="20%" />
		<ai:col title="类型" fieldname="SALE_FLAG" width="15%" />
		<ai:col title="细分市场" fieldname="MARKET_TYPE" width="15%" />
		<ai:col title="网龄" fieldname="NET_AGE" width="15%" />
		<ai:col title="创建时间" fieldname="CREATE_TIME" width="17%" />
	</ai:table>
	<table align = "center">
		<ai:button id="show" text="查看武器详情" onclick="showWeaponDetail()"/>
	</table>
</ai:contractframe>

<ai:contractframe id="tagDetailframe" contenttype="table" title="需要开发备用标签" width="100%" allowcontract="true" frameclosed="false" >
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
				<ai:col fieldname="ADD_MONTHCHARGE" title="总金额" width="5%" editable="false" visible="true" />
				<ai:col fieldname="FIRSTCHARGE" title="首次到账"  width="6%" editable="false" visible="true"/> 
				<ai:col fieldname="LASTCHARGE"  title="末次到账" width="7%" editable="false" visible="true"/> 
				<ai:col  fieldname="CHARGE" title="每月金额" width="7%" visible="true"/>
				<ai:col title="每月增加值" fieldname="SUMCHARGE" width="8%" editable="false" />
				<ai:col fieldname="CYCLE"  width="7%" editable="false" visible="true"/> 
				<ai:col title="返还策略" fieldname="RETURN_TYPE" width="10%" editable="false" visible="true"/>
				<ai:col fieldname="AREA" width="7%" editable="false" visible="true"/>
				<ai:col title="标签备注" fieldname="REMARK_TAG" width="10%" editable="false" visible="true"/>
					<ai:col title="专款范围" fieldname="IS_SP" width="10%" editable="false" visible="true"/>
				<ai:col title="费用组编号" fieldname="ACCOUNT_TYPE" width="10%" editable="false" visible="true"/>
				<ai:col title="营业资费ID" fieldname="TAG_CODE" width="10%" editable="false" visible="true"/>
	</ai:table>
	<ai:dbform formid="weaponForm" setname="com.asiainfo.sale.weapon.web.SETSaleWeapon" 
		initial="false" editable="true" datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
		implservice_querymethod="getSaleWeaponByID(String wid, int $STARTROWINDEX, int $ENDROWINDEX)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
	          <tr id="suggest_time"><td class="td_font">配置完成时间：<ai:dbformfield formid="weaponForm" fieldname="CONFIG_TIME" width="100"/></td>
	          <td></td></tr>
	      </table>
	</ai:dbform>
</ai:contractframe>	

<table align="center"><ai:button id="submit" text="修改标签" onclick="update()"/></table>
					
<ai:contractframe id="reasonframe" contenttype="table" title="工单已审批意见" width="100%" height="20" allowcontract="true" frameclosed="true" >
<ai:contractitem/>
<%@ include file="/main3/include/reasonlist.jsp" %>
</ai:contractframe>

<ai:contractframe id="tagApproveframe" contenttype="table" title="标签开发信息" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="dispatchTaskForm" 
			setname="com.asiainfo.sale.tag.web.SETApproveColumn"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
			<tr id="select_dev"><td class="td_font">指定开发人：</td>
				<td><input type="text" id="staffIdList" value='' style="width: 300px;"/>
					<img id="selectStaff1" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="middle" style="cursor:hand;"/>
				<span class="font_red">*</span></td>
			</tr>
			<tr><td class="td_font">选择协办人：</td>
				<td><input type="text" id="assistEmp" style="width: 300px;"/>
				    <img id="selectStaff3" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="assistEmpSelect();" align="middle" style="cursor:hand;"/>
				</td></tr>
			<tr><td class="td_font"><i18n:message key="SOS0100102" res="CRM" /></td>
				<td><input type="text" id="appriseEmp" style="width: 300px;"/>
				    <img id="selectStaff2" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="appriseEmpSelect();" align="middle" style="cursor:hand;"/>
				</td>
			</tr>
			<tr><td class="td_font">审批操作：</td>
				<td><select  id="result" onchange="getSelectValue(this);"> 
					   <option id="agreen" value="">业支中心开发</option>
					   <option id="noAgreen" value="false">不同意，驳回到主办人</option>
			  		</select> 
			  </td>
			 </tr>
			<tr>
	           	<td class="td_font">内容：</td>
	           	<td><ai:dbformfield formid="dispatchTaskForm" fieldname="ADVISE" width="600" height="180"/></td>
			</tr>
		</table>
	</ai:dbform>
	
	<ai:button id="submit" text="提     交" onclick="commit()"/>
</ai:contractframe>

<ai:contractframe id="proxyframe" contenttype="table" title="加办(点击栏右侧的向下按钮)" width="100%" allowcontract="true" frameclosed="true">
	<ai:contractitem/>
	<ai:dbform formid="proxyTaskForm" 
			setname="com.asiainfo.sale.tag.web.SETApproveColumn"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
			<tr><td class="td_font">指定加办人    ：  </td>
				<td><input type = "text" id = "staffId" value='' />
				<img id="selectStaff4" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectProxyPerson();" align="middle" style="cursor:hand;"/>&nbsp;&nbsp;
				<ai:button id="submit" text="提     交" onclick="reAuthorizeTask()"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:loginuser/>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script type="text/javascript">

var operatorId;
var proxyOpId;
var appriseEmp = '';
var assistEmp = '';
var configTime;
var taskState = "runing";
var workflowId = "<%=request.getParameter("workflowId")%>";
var saleWeaponMainframe = g_FormRowSetManager.get("saleWeaponMainframe");
var _tableTagDetailRowSet = g_TableRowSetManager.get("detailTagTab");
var weaponRs = g_TableRowSetManager.get("weaponMainListTable");
var weap = g_FormRowSetManager.get("weaponForm");
var rid = <%=recordId%>;
function initPage()
{
	//document.getElementById("staffIdList").disabled=true;
	document.getElementById("staffId").disabled=true;
	document.getElementById("appriseEmp").disabled=true;
	document.getElementById("assistEmp").disabled=true;
	
	saleWeaponMainframe.setValue("APPLICANT",g_GetUserInfo().STAFF_NAME);
	saleWeaponMainframe.setValue("ORG",g_GetUserInfo().ORG_NAME);
	if (rid == null){
		//weaponRs.refresh("&taskTag=" + taskTag);
	} else {
		weaponRs.refresh("&wid="+rid+"&weaponName="+"&busiType=");
	}
	weaponRs.rowSelected(0,true);
	showTagInfo();
	document.getElementById('staffIdList').attachEvent('onpropertychange',function(o){   
	    if(o.propertyName!='value') return;  //不是value改变不执行下面的操作    
		if (operatorId == null || operatorId == '') {
			return alert("请选择人员！");
		}
		var ret = PostInfo(_gModuleName + '/business/com.asiainfo.common.web.ItemOtherInfoAction?action=getAdDateInConf&itemId=' + <%=request.getParameter("recordId")%> + "&itemType=weaponCase&taskTag=w05&taskReceiverOpid=" + operatorId);
	    if (ret.getValueByName("FLAG") == 'N') {
	    	weap.setValue("CONFIG_TIME",ret.getValueByName("advDate").substr(0,10));
	     	alert(ret.getValueByName("MESSAGE"));
	    } else {
	     	weap.setValue("CONFIG_TIME",ret.getValueByName("advDate").substr(0,10));
	    }
	});    
	var applyCity=("<%=request.getParameter("taskId")%>").substr(3,2);
	if (applyCity == '10') {
		operatorId = 20007430;
		document.getElementById("staffIdList").value = '张尉'; 
	} else if (applyCity == '11' || applyCity == '17' || applyCity == '13' || applyCity == '14') {
		operatorId = 20004934;
		document.getElementById("staffIdList").value = '肖敏'; 
	} else if (applyCity == '26' || applyCity == '15' || applyCity == '24') {
		operatorId = 20004916;
		document.getElementById("staffIdList").value = '肖剑'; 
	} else if (applyCity == '12' || applyCity == '19' || applyCity == '23') {
		operatorId = 20004948;
		document.getElementById("staffIdList").value = '戴帅'; 
	} else  {
		operatorId = 20004919;
		document.getElementById("staffIdList").value = '刘辉'; 
	}
}

function showWeaponDetail(){
	
	var curRowIndex = weaponRs.getCurRowIndex();
	var weaponId = weaponRs.getValue(curRowIndex, "MID");
	var saleFale=weaponRs.getValue(curRowIndex, "SALE_FLAG");
	if(weaponId != null && weaponId != ""){
		
		  window.open("<%=request.getContextPath()%>/sale/weapon/WeaponInfo.jsp?WID="+weaponId + "&saleFale="+saleFale,"","height=650,width=600,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
		   
      } else {
           alert("请选择行列！");
      }
}

function update()
{
	var selRows = new Array();
	var idList = new Array();
	//var curRowIndex = weaponRs.getCurRowIndex();
	//var weaponId = weaponRs.getValue(curRowIndex, "WID");
	var count = weaponRs.count();
		var mids = "";
		for(var i=0;i<count;i++){
			mids = mids + weaponRs.getValue(i, "WID")+",";
		}
	selRows = _tableTagDetailRowSet.getSelectedRows();
	if(selRows != null && selRows.length > 0)
	{
		var sleRowCount = selRows.length;
		var i = -1;
		while (sleRowCount > 0) {
			sleRowCount--;
			idList[++i] = _tableTagDetailRowSet.getValue(selRows[sleRowCount], "WPID");
		}
	} else {
		alert("请先选择要修改的行!");
		return;
	}
	var url = "<%=request.getContextPath()%>/sale/promationTag/updateTag.jsp?id="+idList[0];
	var retVal = window.showModalDialog(url, null, "scroll:yes;resizable:no;help:no;status:yes;dialogHeight:300px;dialogWidth:700px");
	_tableTagDetailRowSet.refresh("&mids=" + mids);
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
	var curRowIndex = weaponRs.getCurRowIndex();
	var weaponId = weaponRs.getValue(curRowIndex, "WID");
	var count = weaponRs.count();
		var mids = "";
		for(var i=0;i<count;i++){
			mids = mids + weaponRs.getValue(i, "WID")+",";
		}
		_tableTagDetailRowSet.refresh("&mids=" + mids);
	//_tableTagDetailRowSet.refresh("&weaponId=" + weaponId);
	//reasonGo(weaponId,"weaponCase");
	weap.refresh("&wid=" + weaponId);
	isCanSubmit = true;
}

function sendApprise()
{
	if (appriseEmp == '' && assistEmp == ''){
		
	} else {
		
		var content = g_FormRowSetManager.get("dispatchTaskForm").getValue("ADVISE");
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

var select_result = "";
function getSelectValue(obj) {
	
       select_result = obj.options[obj.options.selectedIndex].value; //这是取值
       if (select_result=="false"){
	       document.getElementById("select_dev").style.display="none";
		} else {
			document.getElementById("select_dev").style.display="block";
		}
}

function commit()
{
		if (select_result!="false" && document.getElementById("staffIdList").value==''){
			alert("请先指定人员！")
		} else {
			
			var curRowIndex = weaponRs.getCurRowIndex();
			var taskId = "<%=request.getParameter("taskId")%>";
		    var weaponId = weaponRs.getValue(curRowIndex, "WID");
		   
			var reason = g_FormRowSetManager.get("dispatchTaskForm").getValue("ADVISE");
			/*if (reason == '') {
				alert("请填写内容");
				return;
			}*/
			configTime = weap.getValue("CONFIG_TIME");
			var condition = "&weaponId=" + weaponId + "&taskState=" + taskState + "&configTime=" + configTime;
			
			if (select_result=="false") {
				operatorId = "20005341"; 
			}
	        var strUrl = _gModuleName + '/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=finishUserTask&taskId=' + taskId
	                    + "&result=" + select_result
	                    + "&staffId=" + operatorId
	                    +"&flowType="+'weaponCase'
	                    + "&reason=" + trim(reason);
			//alert(strUrl);
	        sendApprise();
	        var recode = PostInfo(strUrl);
	        if ("Y" == recode.getValueByName("FLAG"))
	        {
	            alert("提交成功");
	            strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.TagFlowAction?action=afterFinishTask&condition=' + condition;
				PostInfo(strUrl, null);
        		PostInfo(_gModuleName + '/business/com.asiainfo.common.web.ItemOtherInfoAction?action=saveItemOtherInfo&itemId=' + <%=request.getParameter("recordId")%>+"&advDate="+configTime + "&taskTag=w05");
	        } else {
	            alert(recode.getValueByName("MESSAGE"));
	        }
	       window.parent.opener.location.reload();
           window.self.close();

		}
}

function reAuthorizeTask()
{
		if (document.getElementById("staffId").value==''){
			alert("请先指定人员！")
			
		} else {
			
			configTime = weap.getValue("CONFIG_TIME");
			var curRowIndex = weaponRs.getCurRowIndex();
			var weaponId = weaponRs.getValue(curRowIndex, "WID");
			var taskId = "<%=request.getParameter("taskId")%>";
			
			var condition = "&weaponId=" + weaponId + "&configTime=" + configTime;
			
			var strUrl = "<%=request.getContextPath()%>/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=reAuthorizeTask&taskId="+taskId + "&nextStaffId="+proxyOpId;      
        
	        var recode = PostInfo(strUrl);
	        if ("Y" == recode.getValueByName("FLAG"))
	        {
	            alert("加办提交成功");
	            strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.TagFlowAction?action=afterProxyTask&condition=' + condition;
	            PostInfo(strUrl, null);
	            
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
        //var url = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?org_id=1001";
        //var result = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:s;dialogHeight:600px;dialogWidth:620px");
        var result = openSelect.staffSelect("tsd",'1001','100101');
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
            document.getElementById("staffIdList").value = name; 
        }
} 

function selectProxyPerson()
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
                    proxyOpId = result.elements[i].operatorId;
                    name = result.elements[i].name;
                } else {
                    proxyOpId = proxyOpId + ";" + result.elements[i].operatorId;
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
