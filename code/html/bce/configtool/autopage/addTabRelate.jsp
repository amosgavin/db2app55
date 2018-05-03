<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<html>
<%
String bceFrameId = request.getParameter("bceFrameId");
String moduleId = request.getParameter("moduleId");
String tabId = request.getParameter("tabId");
String init = "false";
if(null == tabId || "".equals(tabId)){
	
}
else{
  init = "true";
  String cond = "tab_id="+tabId;
  request.setAttribute("condition", "cond=" + cond);
} 
%>
<head>
	<title><%= LocaleResourceFactory.getResource("BES0000800")%></title>
</head>
<body onload="init()">
	<ai:contentframe id="" title="BES0000800" i18nRes="CRM" contenttype="table" width="98%">
		<ai:dbform formid="tabDetail"
			setname="com.ai.bce.web.BceFrameAreaPagetab" editable="true"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				conditionname="condition"
				implservice_name="com.ai.bce.service.interfaces.IBceStudioSV"
				implservice_querymethod="getBceFrameAreaPagetab(String cond)"
			initial="<%=init %>" onvalchange="">
			<table width="98%" align="center" border="0" cellpadding="1"
				cellspacing="2">
				<tr>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000191")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
					  <ai:dbformfield fieldname="TAB_ID" editable="false" visible="false"
							formid="tabDetail"/>
						<ai:dbformfield fieldname="BCE_FRAME_ID" editable="false"
							formid="tabDetail"  width="200" />
					</td>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000359")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="AREA_ID" formid="tabDetail"
							 width="200" />
					</td>

				</tr>
				<tr>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000802")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="TAB_TYPE" formid="tabDetail"
							 width="200" />
					</td>

					<td class="td_font">
						VM_FILE<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="VMFILE"
							formid="tabDetail"  width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000185")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="WIDTH"
							formid="tabDetail"  width="200" />
					</td>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000801")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="HEIGHT"
							formid="tabDetail"  width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						BEFORE_SET_TAB<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="BEFORESETTAB"
							formid="tabDetail"  width="200" />
					</td>
					<td class="td_font">
						AFTER_SET_TAB<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="AFTERSETTAB"
							formid="tabDetail"  width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						GET_PARAMETER<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="GETPARAMETER" formid="tabDetail"
							 width="200" />
					</td>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000113")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="REMARKS"
							formid="tabDetail"  width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000121")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="MODULE_ID"
							formid="tabDetail"  width="200" editable="false"/>
					</td>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000120")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="STATE"
							formid="tabDetail"  width="200" />
					</td>
				</tr>
			</table>
		</ai:dbform>
		<div class="area_button">
			<ai:button text="BES0000319" i18nRes="CRM" onclick="save()" />
			<ai:button text="BES0000320" i18nRes="CRM" onclick="cancel()" />
		</div>
	</ai:contentframe>
</body>
<script type="text/javascript">
function init(){
	if("<%=init%>" == "false"){
		getTabForm().setValue("BCE_FRAME_ID","<%=bceFrameId%>");
		getTabForm().setValue("TAB_TYPE","H");
		getTabForm().setValue("MODULE_ID","<%=moduleId%>");
		getTabForm().setValue("STATE",1);
	}
}

function save(){
	var checkField = getTabForm().isFieldNull("AREA_ID",true);
	if(checkField){
		return;
	}
	var form = getTabForm();
	var list = new Array();
	list.push(form);
	var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
	if(msg.getValueByName("FLAG")=="ERROR" ){
		alert(crm_i18n_msg("BEC0000013"));
		return;
	}
	window.returnValue=1;
	window.close();
}

function cancel(){
	window.close();
}

function getTabForm(){
	return g_FormRowSetManager.get("tabDetail");
}
</script>
</html>
