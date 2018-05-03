<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>

<html>
	<%
		String bceFrameId = request.getParameter("bceFrameId");
		if (null == bceFrameId || "".equals(bceFrameId)) {
			bceFrameId = "-1";
		}
		String moduleId = HttpUtil.getAsString(request, "module_id");
		String cond = "BCE_FRAME_ID=" + bceFrameId;

		if (moduleId != null && "".equals(moduleId) == false) {
			cond = cond + " and (MODULE_ID=" + moduleId
					+ " or module_id='0' or module_id is null)";
		}
		request.setAttribute("cond", cond);
	%>
	<head>
		<title></title>
		<script language="javascript" src="../common/js/configtool.js"></script>
	</head>

	<body>

		<ai:table tableid="javarulesetrelDBTable"
			setname="com.ai.bce.web.BceFrameJavaRulesetRel" needrefresh="true"
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.ai.bce.service.interfaces.IBceStudioSV"
			implservice_querymethod="getFrameJavaRulesetRelValues(String cond)"
			initial="true" height="180" width="100%" editable="false"
			multiselect="false" footdisplay="block" pagesize="8"
			rowsequence="true">
			<ai:col fieldname="RELATE_ID" width="10%" />
			<ai:col fieldname="BCE_FRAME_ID" width="10%" />
			<ai:col fieldname="CHECK_TYPE" width="10%" />
			<ai:col fieldname="PARAM_DATA" width="20%" />
			<ai:col fieldname="REMARKS" width="20%" />
			<ai:col fieldname="RULESET_ID" width="10%" />
			<ai:col fieldname="RULESET_TYPE" width="10%" />
			<ai:col fieldname="STATE" width="10%" />
		</ai:table>
		<%
			if (!"-1".equals(bceFrameId)) {
		%>
		<div class="area_button">
			<ai:button text="BES0000322" i18nRes="CRM" onclick="add()" />
			<ai:button text="BES0000323" i18nRes="CRM" onclick="edit()" />
			<ai:button text="BES0000324" i18nRes="CRM" onclick="del()" />
		</div>
		<%
			}
		%>
	</body>


	<script type="text/javascript">
    		
       function getJavaRuleTab(){
       	return g_TableRowSetManager.get("javarulesetrelDBTable");
       }	
       
       function del(){
		var list = new Array();
		var index = getJavaRuleTab().getRow();
		if(index == -1){
			alert(crm_i18n_msg("BEC0000014"));
			return false;
		}
		if(!confirm(crm_i18n_msg("BEC0000015"))){
    		return false;
    	}
		getJavaRuleTab().deleteRow(index);
		list.push(getJavaRuleTab());
		var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);		
		window.location.reload();
		refreshTopByQuoteChange();
		}
	
		function getRelateId(){
			var index = getJavaRuleTab().getRow();
			if(index == -1){
			alert(crm_i18n_msg("BEC0000014"));
			return false;
			}
			var relateId = getJavaRuleTab().getValue(index,"RELATE_ID");
			return relateId;
		}
		
	function edit(){
		if(getRelateId() != false){
		var rtnVal = window.showModalDialog('../javaruleset/addJavaRule.jsp?relateId='+getRelateId()+"&bceFrameId=<%=bceFrameId%>&moduleId=<%=moduleId%>","","dialogWidth=700px;dialogHeight=290px");
		if(rtnVal == 1){
			window.location.reload();
			refreshTopByQuoteChange();
		}
	}
	}
	
	function add(){
		var bceFrameId = "<%=bceFrameId%>";
		var rtnVal = window.showModalDialog('../javaruleset/addJavaRule.jsp?bceFrameId='+bceFrameId,<%=moduleId%>,'dialogWidth=700px;dialogHeight=290px');
		if(rtnVal == 1){
			window.location.reload();
			refreshTopByQuoteChange();
		}
	}
</script>
</html>
