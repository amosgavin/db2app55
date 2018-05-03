<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>

<html>
	<%
		long moduleId = HttpUtil.getAsLong(request,"moduleId");
		String moduleName = HttpUtil.getAsString(request,"moduleName");
		String versionId = HttpUtil.getAsString(request, "versionId");
		long userId = HttpUtil.getAsLong(request,"userId");
		if (!"".equals(versionId) && null != versionId)
			request.setAttribute("cond", "VERSION_ID = " + versionId+" and ORD_USER = "+userId);
	%>
	<head>
		<title><%=LocaleResourceFactory.getResource("BES0000775")%></title>
	</head>

	<body onload="init()">
		<ai:contentframe contenttype="table" title="BES0000787" i18nRes="CRM"
			id="" width="100%">
			<ai:table tableid="ordDetail" setname="com.ai.bce.web.BceVerOrd"
				needrefresh="true"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfVersionSV"
				implservice_querymethod="getVerOrds(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
				initial="true" height="180" width="100%" editable="true"
				multiselect="false" footdisplay="block" pagesize="10"
				rowsequence="true">
				<ai:col fieldname="ORD_ID" visible="false"/>
				<ai:col fieldname="VERSION_ID" visible="false"/>
				<ai:col fieldname="ORD_USER" visible="false" />
				<ai:col fieldname="ORD_USE_ID" width="20%"/>
				<ai:col fieldname="ORD_NAME" width="20%" />
				<ai:col fieldname="APPLY_USER" width="20%" />
				<ai:col fieldname="REMARKS" width="10%" />
				<ai:col fieldname="PUBILSH_STATE" width="10%" />
				<ai:col fieldname="CREAT_DATE" width="10%" />
				<ai:col fieldname="STATE" width="10%" />
			</ai:table>
			<div class="area_button">
				<ai:button text="BES0000322" i18nRes="CRM" onclick="add()"></ai:button>
				<ai:button text="BES0000324" i18nRes="CRM" onclick="del()"></ai:button>
				<ai:button text="BES0000633" i18nRes="CRM" onclick="submit()"></ai:button>
				<ai:button text="BES0000015" i18nRes="CRM" onclick="next()"></ai:button>
			</div>
		</ai:contentframe>
	</body>
</html>

<script type="text/javascript">
function init(){
	
}
function getOrdTab(){
	return g_TableRowSetManager.get("ordDetail");
}

function add(){
	var ordTab = getOrdTab();
	var date = new Date();
	ordTab.newRow();
	var index = ordTab.getRow();
	ordTab.setValue(index,"VERSION_ID","<%=versionId%>");
	ordTab.setValue(index,"ORD_USER","<%=userId%>");
	ordTab.setValue(index,"PUBILSH_STATE","00");
	ordTab.setValue(index,"STATE","1");
	ordTab.setValue(index,"CREAT_DATE",""+date.getFullYear()+"-"+parseInt(date.getMonth()+1)+"-"+date.getDate());
	ordTab.setRowEditSts(index,true);
}

function del(){
	var ordTab = getOrdTab();
	ordTab.deleteRow();
}

function submit(){
	var ordTab = getOrdTab();
	if(ordTab.toXmlString() == ""){
	  alert(crm_i18n_msg("BEC0000021"));
	  return false;
	}
	var list = new Array();
	list.push(ordTab);
	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
	if (ud.getValueByName("FLAG") == "ERROR") {
		alert(crm_i18n_msg("BEC0000013"));
		return false;
	} 
	alert(crm_i18n_msg("BEC0000321"));
	return true;
}

function next(){
	var ordTab = getOrdTab();
	var index = ordTab.getRow();
	if(index == -1 && ordTab.count() > 0){
	  index = 0;
	}
	if(index == -1){
		alert(crm_i18n_msg("BEC0000014"));
		return;
	}
	var ordId = ordTab.getValue(index,"ORD_ID");
	if(ordId == undefined || ordId == ""){
	  if(submit() == false)
	    return;
	}
	var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.bce.configtool.web.ConfVersionAction?action=next&ordId="+ordId);
	if(msg.getValueByName('flag') == 'succ')
		window.location.href="<%=request.getContextPath()%>/bce/configtool/main.jsp?module_id=<%=moduleId%>&module_name=<%=moduleName%>";
}
function cancel(){
	window.close();
}
</script>
