<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="SOS0100088" res="CRM" /></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="init()">

<ai:contractframe id="appriseframe" contenttype="table" title="SOS0100105" i18nRes="CRM" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="appriseForm" 
			setname="com.asiainfo.sale.tag.web.SETApproveColumn"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
			<tr><td>选择协办人：</td>
				<td><input type="text" id="assistEmp" style="width: 300px;"/>
				    <img id="selectStaff1" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="assistEmpSelect();" align="middle" style="cursor:hand;"/>
				</td></tr>
			<tr><td><i18n:message key="SOS0100102" res="CRM" /></td>
				<td><input type="text" id="appriseEmp" style="width: 300px;"/>
				    <img id="selectStaff1" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="appriseEmpSelect();" align="middle" style="cursor:hand;"/>
				</td>
			</tr>
			<tr>
	           	<td><i18n:message key="SOS0100105" res="CRM" /></td>
	           	<td><ai:dbformfield formid="appriseForm" fieldname="ADVISE" width="440" height="180"/></td>
			</tr>
		</table>
	</ai:dbform>

</ai:contractframe>
<ai:loginuser/>
<table align = "center">
    <ai:button id="certain" text="SOS0100103" i18nRes="CRM" onclick="send()"/>
	<ai:button id="cansel" text="SOS0100104" i18nRes="CRM" onclick="cancel()"/>
</table>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script type="text/javascript">

var appriseEmp = '';
var assistEmp = '';
var workflowId = "<%=request.getParameter("workflowId")%>";
var orgInit = "<%=request.getParameter("orgInit")%>";
var _formRowSet = g_FormRowSetManager.get("appriseForm");

function init(){
	
	document.getElementById("appriseEmp").disabled=true;
	document.getElementById("assistEmp").disabled=true;
}
function cancel()
{
	top.close();
}

function send()
{
	if (appriseEmp == '' && assistEmp == ''){
		alert(crm_i18n_msg("SOC0100106"));
		return;
	}
	var content = _formRowSet.getValue("ADVISE");
    var condition = 'workflowId=' + workflowId + '&appriseEmp=' + appriseEmp + '&assistEmp=' + assistEmp + '&content=' +content ;
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AppriseAction?action=saveAppriseMember&' + condition;
	var recode = PostInfo(strUrl, null);
	if (recode.getValueByName("FLAG") == "Y") {
		alert(crm_i18n_msg("SOC0100107"));
		top.close();
	} else {
		alert(recode.getValueByName("MESSAGE"));
		return;
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

function trim(str)
{
     return str.replace(/(^\s*)(\s*$)/g, '');
}
</script>
