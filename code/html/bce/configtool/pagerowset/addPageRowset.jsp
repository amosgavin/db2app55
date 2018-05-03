<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>


<%
	String pFramePageId = HttpUtil.getAsString(request, "pFramePageId");
	String flag="false";//控制dbform是否刷新
	String rowsetId = HttpUtil.getAsString(request, "rowsetId");
	if (rowsetId != null && !"".equals(rowsetId)){
		flag="true";
		request.setAttribute("cond", "PAGE_FRAME_PAGE_ID=" + pFramePageId
				+ " and ROWSET_ID=" +rowsetId);
		}
%>
<html>
	<head>
		<title><%=LocaleResourceFactory.getResource("BES0000494")%></title>
		<script language="javascript" src="../common/js/configtool.js"></script>
	</head>
	<body onLoad="init()">
		<ai:contentframe id="" title="BES0000494" i18nRes="CRM" contenttype="table" width="98%">
			<ai:dbform formid="rowsetRelate"
				setname="com.ai.bce.web.SETBcePageRowset" editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				initial="<%=flag %>"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfRowsetSV"
				implservice_querymethod="getPageRowsetValues(String cond)">
				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000223")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_FRAME_PAGE_ID" editable="false"
								formid="rowsetRelate" width="200"/>
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000111")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="MODULE_ID" formid="rowsetRelate"
								width="200" editable="false"/>
						</td>
					</tr>
					<tr>
					<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000224")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="RELATE_STATE" formid="rowsetRelate"
								visible="true" width="200"/>
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000225")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="ROWSET_ID" formid="rowsetRelate"
								editable="false" width="180" /><img id="sel" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif" disabled="disabled"
								alt='<%=LocaleResourceFactory.getResource("BES0000611")%>' onClick="selectRowset()"
								align="absmiddle" style="cursor: hand;" />
						</td>
						
					</tr>
					<tr><td colspan=4><hr style="width:100%" /><td></tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000220")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="ROWSET_KEY" formid="rowsetRelate"
							editable="false"	width="200"/>
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000226")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="ROWSET_METHOD" formid="rowsetRelate"
							editable="false"	width="200"/>
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="STATE" formid="rowsetRelate"
							editable="false"	width="200"/>
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="REMARKS" formid="rowsetRelate"
							editable="false"	width="200"/>
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000227")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="ROWSET_TYPE" formid="rowsetRelate"
							editable="false"	width="200"/>
						</td>
					</tr>
				</table>
			</ai:dbform>
		</ai:contentframe>
			<div class="area_button">
				<ai:button text="BES0000319" i18nRes="CRM" onclick="save()" />&nbsp;&nbsp;&nbsp;
				<ai:button text="BES0000480" i18nRes="CRM" onclick="window.close()" />
			</div>
	<script type="text/javascript">
		
		function init(){
			if('<%=rowsetId%>' == ''){
				getPageRowsetForm().setValue("PAGE_FRAME_PAGE_ID","<%=pFramePageId%>");
				getPageRowsetForm().setValue("RELATE_STATE","1");
	 			getPageRowsetForm().setValue("MODULE_ID", window.dialogArguments);
	 			document.getElementById("sel").disabled=false;
			}
		}
		
		function getPageRowsetForm(){
			return g_FormRowSetManager.get("rowsetRelate");
		}
		
    	/**
    	 * 保存
    	 */
    	function save()
    	{
    		if(getPageRowsetForm().isFieldNull("ROWSET_ID",true)){
    			return;
    		}
    		var rowsetRelateForm = g_FormRowSetManager.get("rowsetRelate");
    		var xmlBody = rowsetRelateForm.toXmlString(true);
    		if(xmlBody=="")
    		{
    			alert(crm_i18n_msg("BEC0000301"));
    			return;
    		}
  			var list = new Array();
	        list.push(rowsetRelateForm);
	    var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.configtool.web.ConfRowsetAction?action=savePageRowset",list,false);
			if (ud.getValueByName("FLAG") == "ERROR") {
			  if(!ud.getValueByName("MESSAGE"))
			    alert(crm_i18n_msg("BEC0000013"));
				return;
			}			
			rowsetRelateForm.setEditSts(false);
			window.returnValue = 1;
			window.close();
    	}
    	
		/**
		 * 选择数据集
		 */
		function selectRowset()
		{
			var url = "<%=request.getContextPath()%>/bce/configtool/rowset/selectRowset.jsp?moduleId="+window.dialogArguments;
	 		var retVal = window.showModalDialog(url, "", "scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");
	 		if(retVal != null)
	 		{
	 			var form = g_FormRowSetManager.get("rowsetRelate");
	 			form.setValue("ROWSET_ID", retVal.id);
	 			form.setValue("ROWSET_TYPE", retVal.type);
	 			form.setValue("ROWSET_KEY", retVal.key);
	 			form.setValue("ROWSET_METHOD", retVal.method);
	 			form.setValue("STATE", retVal.state);
	 			form.setValue("REMARKS", retVal.remarks);
	 		}
		}
</script>

</html>


