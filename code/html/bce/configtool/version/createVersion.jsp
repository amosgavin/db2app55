<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>

<html>
	<%
	  long moduleId = HttpUtil.getAsLong(request,"moduleId");
		String moduleName = HttpUtil.getAsString(request,"moduleName");
		long userId = HttpUtil.getAsLong(request,"userId");
		
		request.setAttribute("cond", "PUBILSH_STATE = '00' and state = 1");
	%>
	<head>
		<title><%=LocaleResourceFactory.getResource("BES0000775")%></title>
	</head>

	<body onload="init()">
	<%--
	<ai:contentframe contenttype="table" title="BES0000786" i18nRes="CRM"
			id="" width="100%">  --%>
	<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem/>
		<ai:dbform formid="versionDetail" setname="com.ai.bce.web.BceVerHand"
			editable="true"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.ai.bce.configtool.service.interfaces.IConfVersionSV"
			implservice_querymethod="getVerHands(String cond)" initial="true"
			onvalchange="">
			<table>
				<tr>
					<td class="td_font">
						<%=LocaleResourceFactory.getResource("BES0000770")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="VERSION_ID" formid="versionDetail"
							visible="false" />
						<ai:dbformfield fieldname="VERSION_NAME" formid="versionDetail"
							width="200" />
					</td>
					<td class="td_font">
						<%=LocaleResourceFactory.getResource("BES0000771")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="VERSION_DESC" formid="versionDetail"
							width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						<%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="STATE" formid="versionDetail"
							width="200" />
					</td>
					<td class="td_font">
						<%=LocaleResourceFactory.getResource("BES0000772")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="PUBILSH_STATE" formid="versionDetail"
							width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						<%=LocaleResourceFactory.getResource("BES0000773")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="CREAT_DATE" formid="versionDetail"
							width="200" />
					</td>
					<td class="td_font">
						<%=LocaleResourceFactory.getResource("BES0000774")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="APPLY_USER" formid="versionDetail"
							width="200" />
					</td>
				</tr>
				<tr>
					<td class="td_font">
						<%=LocaleResourceFactory.getResource("BES0000113")%><%=LocaleResourceFactory.getResource("BES0000000")%>
					</td>
					<td>
						<ai:dbformfield fieldname="REMARKS" formid="versionDetail"
							width="200" />
					</td>
				</tr>
			</table>
		</ai:dbform>
		<div class="area_button">
			<ai:button text="BES0000015" i18nRes="CRM" onclick="next()"></ai:button>
			<ai:button text="BES0000320" i18nRes="CRM" onclick="cancel()"></ai:button>
		</div>
		</ai:contractframe>
	</body>
</html>

<script type="text/javascript">
function getVersionTab(){
	return g_FormRowSetManager.get("versionDetail");
}

function init(){
  var versionTab = getVersionTab();
	var versionId = versionTab.getValue("VERSION_ID");
	if(versionId == null || versionId == ''){
	  versionTab.newRow();
	  var date = new Date();
	  versionTab.setValue("PUBILSH_STATE","00");
	  versionTab.setValue("STATE","1");
	  versionTab.setValue("CREAT_DATE",""+date.getFullYear()+"-"+parseInt(date.getMonth()+1)+"-"+date.getDate());
	}
}

function next(){
	var versionTab = getVersionTab();
	var versionId = versionTab.getValue("VERSION_ID");
	if(versionId == null || versionId == ''){
	  var checkField = versionTab.isFieldNull("VERSION_NAME,VERSION_DESC,APPLY_USER,PUBILSH_STATE,CREAT_DATE,STATE",true);
	  if(checkField){
	  	return;
	  }
		var list = new Array();
		list.push(versionTab);
		var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.configtool.web.ConfVersionAction?action=saveVersion",list,false);
		versionId = ud.getValueByName("versionId"); 
		if(versionId == null || versionId == ''){
			alert(crm_i18n_msg("BEC0000013"));
			return;
		}
	}
	window.location.href="../bce/configtool/version/createVerOrd.jsp?versionId="+versionId+"&userId=<%=userId%>&moduleId=<%=moduleId%>&moduleName=<%=moduleName%>";
}

function cancel(){
	window.close();
}
</script>
