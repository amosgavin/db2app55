<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>


<%
	String moduleId = HttpUtil.getAsString(request,"module_id");
	//数据集ID
	String curRelateId = HttpUtil.getAsString(request ,"PAGE_FRAME_PAGE_ID"); 
	String curRowsetId = HttpUtil.getAsString(request ,"ROWSET_ID"); 
	String initial ="false";
	
	if(curRelateId != null && !"".equals(curRelateId) && curRowsetId != null && !"".equals(curRowsetId))
	{
		request.setAttribute("cond","PAGE_FRAME_PAGE_ID="+curRelateId+" AND ROWSET_ID="+curRowsetId);
		initial = "true";
	}
%>
<html>
<head>
<title></title>

<script language="javascript" src="../common/js/configtool.js"></script>

<script type="text/javascript">
		function initButton()
		{
			<%
				if(initial.equals("true")){
			%>
				document.getElementById("modifyDiv").style.display="block";
			<%}%>
		}
</script>
</head>
<body  onload="initButton()">
		<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem>
			</ai:contractitem>
		
			<ai:dbform formid="rowsetRelate" setname="com.ai.bce.web.SETBcePageRowset" editable="true"
   				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService" initial="<%=initial %>" onvalchange="" conditionname="condition1"
   				implservice_name = "com.ai.bce.configtool.service.interfaces.IConfRowsetSV"
   				implservice_querymethod = "getPageRowsetValues(String cond, int $STARTROWINDEX,int $ENDROWINDEX)" >
		   		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
		   			
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000223")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="PAGE_FRAME_PAGE_ID" formid="rowsetRelate" editable="false" visible="true" width="200"/></td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000224")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="RELATE_STATE" formid="rowsetRelate" editable="false" visible="true" width="200"/></td>
					</tr>   								
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000225")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td><ai:dbformfield fieldname="ROWSET_ID" formid="rowsetRelate" editable="false" visible="true" width="180"/><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif" id="selRowsetBtn"
								alt='<%=LocaleResourceFactory.getResource("BES0000611")%>' onClick="selectRowset()" align="absmiddle"
								style="cursor: hand;" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000227")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="ROWSET_TYPE" formid="rowsetRelate" editable="false" width="200"/></td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000220")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="ROWSET_KEY" formid="rowsetRelate" editable="false" width="200"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000226")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="ROWSET_METHOD" formid="rowsetRelate" editable="false" width="200"/></td>
					</tr>     								  								
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000201")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="MODULE_ID" formid="rowsetRelate" editable="false" width="200"/></td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="STATE" formid="rowsetRelate" editable="false" width="200"/></td> 
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="REMARKS" formid="rowsetRelate" editable="false" width="200"/></td>
					</tr>
					<tr>
						<td colspan="4" align="center">
							<table>
								<tr>
								<td>
									<div id="modifyDiv" style="display:none"> 
										<ai:button text="BES0000323" i18nRes="CRM"  onclick = "modify()" />
									</div>
									<div id="saveDiv" style="display:none"> 
										<ai:button text="BES0000319" i18nRes="CRM" onclick = "save()" />&nbsp;&nbsp;
										<ai:button text="BES0000320" i18nRes="CRM" onclick = "setReadOnly()" />
									</div>
								</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
 			</ai:dbform>								
		</ai:contractframe>
		
</body> 
<script type="text/javascript">
		
		function refresh(realteId, rowsetId)
	    { 
	    	g_FormRowSetManager.get("rowsetRelate").refresh("cond=PAGE_FRAME_PAGE_ID = "+realteId+" AND ROWSET_ID="+rowsetId);
	    }
	    /**
    	 * 修改数据集
    	 */    	  
    	function modify()
    	{
    		document.getElementById("modifyDiv").style.display="none";
    		document.getElementById("saveDiv").style.display="block";
    		var realteForm = g_FormRowSetManager.get("rowsetRelate");
    		realteForm.setColEditSts("RELATE_STATE", true);
    		document.getElementById("selRowsetBtn").disabled = false;
    	}
    	/**
    	 * 保存
    	 */
    	function save()
    	{
    		var rowsetRelateForm = g_FormRowSetManager.get("rowsetRelate");
    		var xmlBody = rowsetRelateForm.toXmlString(true);
    		if(xmlBody=="")
    		{
    			alert(crm_i18n_msg("BEC0000008"));
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
			window.location.reload();
			
			//刷新顶层框架
			refreshTopByDetailChange();
    		
    	}
    	/**
		 * 置为只读状态
		 */
		function setReadOnly()
		{
		    document.getElementById("modifyDiv").style.display="block";
    		document.getElementById("saveDiv").style.display="none";
			g_FormRowSetManager.get("rowsetRelate").setEditSts(false);
			window.location.reload();
		}
		/**
		 * 选择数据集
		 */
		function selectRowset()
		{
			var url = "<%=request.getContextPath()%>/bce/configtool/rowset/selectRowset.jsp?moduleId=<%=moduleId%>";
	 		var retVal = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");
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


