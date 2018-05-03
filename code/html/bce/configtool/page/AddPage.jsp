<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<html>
<head>
<title><%=LocaleResourceFactory.getResource("BES0000485")%></title>

<script language="javascript" src="../common/js/configtool.js"></script>

</head>
<body onLoad="initPage()">
		<ai:contentframe id="" title="BES0000485" i18nRes="CRM" contenttype="table" width="98%">
		<ai:dbform formid="pageDetail" setname="com.ai.bce.web.BcePage" editable="true"
   				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService" initial="false" onvalchange="" 
   				implservice_name = "com.ai.bce.configtool.service.interfaces.IConfPageSV"
   				implservice_querymethod = "getBcePageValues(String cond)" >
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000387")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="MODULE_ID" formid="pageDetail"  width="200" editable="false"/>
					</td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000392")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td><ai:dbformfield fieldname="PAGE_TYPE" formid="pageDetail"  width="200"/></td>
				</tr>
				<tr>	
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000393")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="PAGE_URL" formid="pageDetail"  width="180"/><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif" id="chooseUrl"
								alt='<%=LocaleResourceFactory.getResource("BES0000611")%>' onClick="getUrl()" align="absmiddle"
								style="cursor: hand;" />
					</td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000386")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="IS_GET_PAGE_DATA" formid="pageDetail"  width="200"/></td>
				</tr>
				<tr>					
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000385")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="IS_DATA_MUST" formid="pageDetail"  width="200"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000390")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="PAGE_RULESET_ID" formid="pageDetail" editable="false" width="180"/><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif" id="chooseRuleset"
								alt='<%=LocaleResourceFactory.getResource("BES0000611")%>' onClick="getRuleSetId()" align="absmiddle"
								style="cursor: hand;" />
					</td>
				</tr>
				<tr>					
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000389")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="PAGE_LOAD_TYPE" formid="pageDetail"  width="200"/></td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="STATE" formid="pageDetail"  width="200"/></td>
				</tr>
				<tr>					
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="REMARKS" formid="pageDetail"  width="200"/></td>
				</tr>
			</table>
		</ai:dbform>
	  </ai:contentframe>
	  <div class="area_button">
		<ai:button text="BES0000319" i18nRes="CRM" onclick = "savePage()"/>&nbsp;&nbsp;
		<ai:button text="BES0000480" i18nRes="CRM" onclick = "closeWindow()"/>
	  </div>
</body> 
<script type="text/javascript">
		
		function initPage()
		{
			var form = g_FormRowSetManager.get("pageDetail");
			form.setValue("PAGE_TYPE", 2);
			form.setValue("IS_GET_PAGE_DATA", 1);
			form.setValue("IS_DATA_MUST", 1);
			form.setValue("PAGE_LOAD_TYPE", 1);
			form.setValue("STATE", 1);
			form.setValue("MODULE_ID", window.dialogArguments);
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
    		if(pageDetailForm.isFieldNull("PAGE_URL",true))
    		{
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
    	closeWindow();
    	}
		/**
		 * 获取规则集编号
		 */
		function getRuleSetId()
	  	{
	  		var url = "<%=request.getContextPath()%>/bce/configtool/ruleset/selectRuleset.jsp?RULESET_TYPE=1";
    		var rtnVal = window.showModalDialog(url, window.dialogArguments,"scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");
    		if(rtnVal != null){
		    			if(rtnVal == -1){
		    				g_FormRowSetManager.get("pageDetail").setValue("PAGE_RULESET_ID", '');
		    			}else{
		    				g_FormRowSetManager.get("pageDetail").setValue("PAGE_RULESET_ID", rtnVal,rtnVal);
		    			}
		    		}	
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
    	/**
		 * 关闭窗口
		 */
		function closeWindow()
		{
			window.self.close();
		}    	
    	
</script>

</html>


