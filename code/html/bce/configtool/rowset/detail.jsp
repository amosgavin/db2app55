<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>


<%
	
	//数据集ID
	String curRowsetId = HttpUtil.getAsString(request ,"ROWSET_ID"); 
	String initial ="false";
	
	if(curRowsetId != null && !"".equals(curRowsetId))
	{
		request.setAttribute("cond","ROWSET_ID = "+curRowsetId);
		initial = "true";
	}
%>
<html>
<head>
<title>
</title>

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
		
			<ai:dbform formid="rowsetDetail" setname="com.ai.bce.web.BceRowset" editable="true"
   				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService" initial="<%=initial %>" onvalchange="" conditionname="condition1"
   				implservice_name = "com.ai.bce.configtool.service.interfaces.IConfRowsetSV"
   				implservice_querymethod = "getRowsetValues(String cond, int $STARTROWINDEX,int $ENDROWINDEX)" >
		   		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000507")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="ROWSET_ID" formid="rowsetDetail" editable="false" width="200"/></td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000509")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="ROWSET_TYPE" formid="rowsetDetail" editable="false" width="200"/></td>
					</tr>
					<tr>
						<td class="td_font">KEY<%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="ROWSET_KEY" formid="rowsetDetail" editable="false" width="200"/></td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000508")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="ROWSET_METHOD" formid="rowsetDetail" editable="false" width="200"/></td>
					</tr>     								  								
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000201")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="MODULE_ID" formid="rowsetDetail" editable="false" width="200"/></td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="STATE" formid="rowsetDetail" editable="false" width="200"/></td> 
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="REMARKS" formid="rowsetDetail" editable="false" width="200"/></td>
					</tr>
				</table>
 			</ai:dbform>	
 			<div class="area_button">
									<div id="modifyDiv" style="display:none"> 
										<ai:button text="BES0000323" i18nRes="CRM" onclick = "modify()" /> &nbsp;&nbsp;
									</div>
									<div id="saveDiv" style="display:none"> 
										<ai:button text="BES0000319" i18nRes="CRM" onclick = "save()" />&nbsp;&nbsp;
										<ai:button text="BES0000320" i18nRes="CRM" onclick = "setReadOnly()" />
									</div>
				</div>
 				</ai:contractframe>
									
</body> 
<script type="text/javascript">
		
	function refresh(rowsetId)
    { 
    	g_FormRowSetManager.get("rowsetDetail").refresh("cond=ROWSET_ID = "+rowsetId);
    }
	    /**
    	 * 修改数据集
    	 */    	  
    	function modify()
    	{
    		document.getElementById("modifyDiv").style.display="none";
    		document.getElementById("saveDiv").style.display="block";
    		var pageForm = g_FormRowSetManager.get("rowsetDetail");
    		pageForm.setEditSts(true);
    		pageForm.setColEditSts("ROWSET_ID", false);
    		pageForm.setColEditSts("MODULE_ID", false);
    	}
    	/**
    	 * 保存
    	 */
    	function save()
    	{
    		var rowsetDetailForm = g_FormRowSetManager.get("rowsetDetail");
    		
    		var xmlBody = rowsetDetailForm.toXmlString(true);
    		if(xmlBody=="")
    		{
    			alert(crm_i18n_msg("BEC0000008"));
    			return;
    		}
  			var list = new Array();
	        list.push(rowsetDetailForm);
	    var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
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
			g_FormRowSetManager.get("rowsetDetail").setEditSts(false);
			window.location.reload();
		}
		
</script>

</html>


