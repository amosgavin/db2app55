<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>


<%
	
	//页面ID
	String curPageId = HttpUtil.getAsString(request ,"PAGE_ID"); 
	String initial ="false";
	String moduleId = HttpUtil.getAsString(request,"module_id");
	if(curPageId != null && !"".equals(curPageId)){
		request.setAttribute("cond","page_id = "+curPageId);
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
			
		<ai:dbform formid="pageDetail" setname="com.ai.bce.web.BcePage" editable="true"
   				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService" initial="<%=initial %>" onvalchange="" 
   				implservice_name = "com.ai.bce.configtool.service.interfaces.IConfPageSV"
   				implservice_querymethod = "getBcePageValues(String cond, int $STARTROWINDEX,int $ENDROWINDEX)"  >
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000388")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="PAGE_ID" formid="pageDetail" editable="false" width="200"/>
					</td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000387")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="MODULE_ID" formid="pageDetail" editable="false" width="200"/>
					</td>
				</tr>
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000392")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="PAGE_TYPE" formid="pageDetail" editable="false" width="200"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000393")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="PAGE_URL" formid="pageDetail" editable="false" width="180"/><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif" id="chooseUrl"
								alt='<%=LocaleResourceFactory.getResource("BES0000611")%>' onClick="getUrl()" align="absmiddle"
								style="cursor: hand;" disabled=true/>
					</td>
				</tr>
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000386")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="IS_GET_PAGE_DATA" formid="pageDetail" editable="false" width="200"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000385")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="IS_DATA_MUST" formid="pageDetail" editable="false" width="200"/></td>
				</tr>
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000390")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="PAGE_RULESET_ID" formid="pageDetail" editable="false" width="180"/><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif" id="chooseRuleset"
								alt='<%=LocaleResourceFactory.getResource("BES0000611")%>'s onClick="getRuleSetId()" align="absmiddle"
								style="cursor: hand;" disabled=true/>
					</td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000389")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="PAGE_LOAD_TYPE" formid="pageDetail" editable="false" width="200"/></td>
				</tr>
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="STATE" formid="pageDetail" editable="false" width="200"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="REMARKS" formid="pageDetail" editable="false" width="200"/></td>
				</tr>
			</table>
		</ai:dbform>
		</ai:contractframe>
		<div class="area_button">
								<div id="modifyDiv" style="display:none"> 
									<ai:button text="BES0000323" i18nRes="CRM" onclick = "modifyPage()" />&nbsp;&nbsp;
								</div>
								<div id="saveDiv" style="display:none"> 
									<ai:button text="BES0000319" i18nRes="CRM" onclick = "savePage()" />&nbsp;&nbsp;
									<ai:button text="BES0000320" i18nRes="CRM" onclick = "setReadOnly()" />
								</div>	
		</div>
</body> 
<script type="text/javascript">
		
	function refreshPage(pageId)
    { 
    	g_FormRowSetManager.get("pageDetail").refresh("cond=page_id = "+pageId);
    }
	    /**
    	 * 修改页面
    	 */    	  
    	function modifyPage()
    	{
    		document.getElementById("modifyDiv").style.display="none";
    		document.getElementById("saveDiv").style.display="block";
    		var pageForm = g_FormRowSetManager.get("pageDetail");
    		pageForm.setEditSts(true);
    		pageForm.setColEditSts("PAGE_ID", false);
    		pageForm.setColEditSts("PAGE_RULESET_ID", false);
    		document.getElementById("chooseRuleset").disabled = false;
    		document.getElementById("chooseUrl").disabled = false;
    	}
    	/**
    	 * 保存
    	 */
    	function savePage()
    	{
    		var pageDetailForm = g_FormRowSetManager.get("pageDetail");
    		if(pageDetailForm.toXmlString(true) == "")
    		{
    			alert(crm_i18n_msg("BEC0000008"));
    			return;
    		}
  			var list = new Array();
	      	list.push(pageDetailForm);
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
			g_FormRowSetManager.get("pageDetail").setEditSts(false);
			document.getElementById("chooseRuleset").disabled = true;
			document.getElementById("chooseUrl").disabled = true;
			window.location.reload();
		}
    	/**
    	 * 获取页面URL
    	 */
    	function getUrl()
    	{
    		var rtnVal = window.showModalDialog("<%=request.getContextPath()%>/bce/configtool/model/jsp/selectJSP.jsp", "",
					"scroll:no;resizable:no;help:no;status:no;dialogHeight:580px;dialogWidth:800px");
			if(rtnVal)
			{
				var pageDetailForm = g_FormRowSetManager.get("pageDetail");
				pageDetailForm.setValue("PAGE_URL", rtnVal.treeValue);
			}
    	}		
		function getRuleSetId()
	  	{
	  		var url = "<%=request.getContextPath()%>/bce/configtool/ruleset/selectRuleset.jsp?RULESET_TYPE=1"; 
    		var rtnVal = window.showModalDialog(url,<%=moduleId%>,"scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");
	
    		if(rtnVal != null){
		    			if(rtnVal == -1){
		    				g_FormRowSetManager.get("pageDetail").setValue("PAGE_RULESET_ID", '');
		    			}else{
		    				g_FormRowSetManager.get("pageDetail").setValue("PAGE_RULESET_ID", rtnVal,rtnVal);
		    			}
		    		}
    	}
</script>

</html>


