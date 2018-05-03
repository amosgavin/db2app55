<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<html>
<%
String tabId = request.getParameter("tabId");
String moduleId = request.getParameter("moduleId");
String tabItemId = request.getParameter("tabItemId");
String init = "false";
if(null == tabItemId || "".equals(tabItemId)){
	
}
else{
  init = "true";
  String cond = "tab_item_id="+tabItemId;
  request.setAttribute("condition", "cond=" + cond);
} 
%>
<head>
	<title>TabItem</title>
</head>
<body onload="init()">
	<ai:contentframe id="" title="TabItem" contenttype="table" width="98%">
		<ai:dbform formid="tabItemDetail"
			setname="com.ai.bce.web.BceFrameTabitem" editable="true"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				conditionname="condition"
				implservice_name="com.ai.bce.service.interfaces.IBceStudioSV"
				implservice_querymethod="getBceFrameTabitem(String cond)"
			initial="<%=init %>" onvalchange="">
			<table width="98%" align="center" border="0" cellpadding="1"
				cellspacing="2">
				<tr>
					<td class="td_font">
						TAB_ID<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="TAB_ITEM_ID" editable="false"
							formid="tabItemDetail"  visible="false" />
						<ai:dbformfield fieldname="TAB_ID" editable="false"
							formid="tabItemDetail"  width="200" />
					</td>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000133")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="TITLE" formid="tabItemDetail"
							 width="200" />
					</td>

				</tr>
				<tr>
					<td class="td_font">
						SRC<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="SRC" formid="tabItemDetail"
							 width="200" />
					</td>

					<td class="td_font">
						SRC_PARAMS<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="SRC_PARAMS"
							formid="tabItemDetail"  width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000119")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="I18NRES"
							formid="tabItemDetail"  width="200" />
					</td>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000185")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="WIDTH"
							formid="tabItemDetail"  width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000804")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="ISINITIAL"
							formid="tabItemDetail"  width="200" />
					</td>
					<td class="td_font">
						IS_DELETABLE<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="ISDELETABLE"
							formid="tabItemDetail"  width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						MO<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="MO" formid="tabItemDetail"
							 width="200" />
					</td>
					<td class="td_font">
						OPERATOR<%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="OPERATOR"
							formid="tabItemDetail"  width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000121")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="MODULE_ID"
							formid="tabItemDetail"  width="200" editable="false"/>
					</td>
					<td class="td_font">
						<%= LocaleResourceFactory.getResource("BES0000120")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="STATE"
							formid="tabItemDetail"  width="200" />
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
		getTabItemForm().setValue("TAB_ID","<%=tabId%>");
		getTabItemForm().setValue("ISINITIAL",0);
		getTabItemForm().setValue("ISDELETABLE",0);
		getTabItemForm().setValue("MODULE_ID","<%=moduleId%>");
		getTabItemForm().setValue("STATE",1);
	}
}

function save(){
	var checkField = getTabItemForm().isFieldNull("TAB_ID,SRC,TITLE",true);
	if(checkField){
		return;
	}
	var form = getTabItemForm();
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

function getTabItemForm(){
	return g_FormRowSetManager.get("tabItemDetail");
}
</script>
</html>
