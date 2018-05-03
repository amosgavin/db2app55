<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'VerOrdSqlExport.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		<ai:contentframe contenttype="table" title="BES0000787" i18nRes="CRM"
			id="" width="90%">
			<ai:table tableid="ordDetail" setname="com.ai.bce.web.BceVerOrd"
				needrefresh="true"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfVersionSV"
				implservice_querymethod="getVerOrds(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
				initial="true" height="180" width="100%" footdisplay="block"
				pagesize="10" rowsequence="true">
				<ai:col fieldname="ORD_ID" visible="true" />
				<ai:col fieldname="VERSION_ID" visible="false" />
				<ai:col fieldname="ORD_USER" visible="false" />
				<ai:col fieldname="ORD_USE_ID" width="20%" />
				<ai:col fieldname="ORD_NAME" width="20%" />
				<ai:col fieldname="APPLY_USER" width="20%" />
				<ai:col fieldname="REMARKS" width="10%" />
				<ai:col fieldname="PUBILSH_STATE" width="10%" />
				<ai:col fieldname="CREAT_DATE" width="10%" />
				<ai:col fieldname="STATE" width="10%" />
			</ai:table>
			<div class="area_button">
				<select id="exportOption">
					<option value="1">
						<%=LocaleResourceFactory.getResource("BES0000807")%>
					</option>
					<option value="0">
						<%=LocaleResourceFactory.getResource("BES0000808")%>
					</option>
				</select>
				<ai:button text="BES0000798" i18nRes="CRM"
					onclick="exportSqlButton()"></ai:button>

				<a id="dowlown" href='' target="blank">
					<%=LocaleResourceFactory.getResource("BES0000799") %>
				</a>
			</div>
			<div class="area_button">
				<textarea id="exportSql" style="width: 99%; height: 100px"></textarea>
			</div>
		</ai:contentframe>
		<script type="text/javascript">
		function getOrdTab(){
			return g_TableRowSetManager.get("ordDetail");
		}
			function exportSqlButton(){
				var index = getOrdTab().getRow();
				if(index<0){
					alert(crm_i18n_msg("BEC0000014"));
					return;
				}
				var ORD_ID  = getOrdTab().getValue(index,"ORD_ID");
				var exportOption = document.getElementById("exportOption").value;
				var ud = PostInfo("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=getExportSQL&ORD_ID="+ORD_ID+"&exportOption="+exportOption);
				
			if (ud.getValueByName("FLAG") == "ERROR") {
				alert(crm_i18n_msg("BEC0000013"));
				return false;
			} 
			document.getElementById("exportSql").value=ud.getValueByName("sql");
			document.getElementById("dowlown").href="<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=DownLoadExportSQL&ORD_ID="+ORD_ID+"&exportOption="+exportOption;
				alert(document.getElementById("dowlown").href);
			}
		</script>
	</body>
</html>
