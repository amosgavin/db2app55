<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<html>
	<%
		String bceFrameId = request.getParameter("bceFrameId");
		String pageFramePageId = request.getParameter("pFramePageId");
		boolean bceFlag = false;
		boolean pageFlag = false;
		if (null == pageFramePageId || "".equals(pageFramePageId)) {
			pageFramePageId = "-1";
			pageFlag = true;
		}
		if (null == bceFrameId || "".equals(bceFrameId)) {
			bceFrameId = "-1";
			bceFlag = true;
		}
			request.setAttribute("bceFrameId",bceFrameId);
			request.setAttribute("pageFramePageId",pageFramePageId);
	%>
	<head>
		<script language="javascript" src="../common/js/configtool.js"></script>
		<title><%=LocaleResourceFactory.getResource("BES0000099")%></title>
	</head>
	<body onload = "init()">
		<ai:contentframe id="" title="BES0000099" i18nRes="CRM" contenttype="table"  width="98%">
			<ai:dbform formid="specialpageForm"
				setname="com.ai.bce.web.BceFrameSpecialPage" editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				initial="true" onvalchange=""
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfSpecialPageSV"
				implservice_querymethod="getSpecialPageById(String bceFrameId,String pageFramePageId)">
				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000374")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="BCE_FRAME_ID" formid="specialpageForm"
								editable="false" width="180"/><img id=" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="<%=LocaleResourceFactory.getResource("BES0000068")%>" onClick="<%=bceFlag%>==false?'':selBceFrame()" align="absmiddle" style="cursor:hand;"/>
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000501")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_FRAME_PAGE_ID" formid="specialpageForm" 
							width="200" editable="false" /><img id=" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="<%=pageFlag%>==false?'':selPageFramePage()" align="absmiddle" style="cursor:hand;"/>
						</td>
					</tr>
					<tr>
					  <td class="td_font"><%=LocaleResourceFactory.getResource("BES0000096")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="REMARKS" formid="specialpageForm"
								width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000097")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_PARAM" formid="specialpageForm"
								width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000376")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="IS_GET_PAGE_DATA"
								formid="specialpageForm" width="200" />
						</td><td class="td_font"><%=LocaleResourceFactory.getResource("BES0000375")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="IS_DATA_MUST" formid="specialpageForm"
								width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000379")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_RULESET_ID"
								formid="specialpageForm" width="180" editable="false"/><img id="" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="<%=LocaleResourceFactory.getResource("BES0000608")%>" onClick="selRuleSet()" align="absmiddle" style="cursor:hand;"/>
						</td><td class="td_font"><%=LocaleResourceFactory.getResource("BES0000380")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_TITLE" formid="specialpageForm"
								width="200" />
						</td>
					</tr>
					<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td><ai:dbformfield fieldname="STATE" formid="specialpageForm"
								width="200" />
							<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000121")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td><ai:dbformfield fieldname="MODULE_ID" formid="specialpageForm"
								width="200" />
					</tr>
				</table>
			</ai:dbform>
		</ai:contentframe>
		<div class="area_button">
				<ai:button text="BES0000319" i18nRes="CRM" onclick="save()" />
				<ai:button text="BES0000320" i18nRes="CRM" onclick="cancel()" />
				</div>
	</body>
	<script type="text/javascript">
   				var pageFrameId = "-100";
   				function init(){
   				var pFramePageId = "<%=pageFramePageId%>";
   				var bceFrameId = "<%=bceFrameId%>";
   				if(window.dialogArguments.isEdit != -10){
   					getSpecialPageForm().newRow();
   					if(bceFrameId != '-1'){
   						getSpecialPageForm().setValue("BCE_FRAME_ID",bceFrameId,bceFrameId);
   					}	
   					if(pFramePageId != '-1'){
   	   				getSpecialPageForm().setValue("PAGE_FRAME_PAGE_ID",pFramePageId,pFramePageId);
   					}	
   					getSpecialPageForm().setValue("IS_DATA_MUST",1,1);
   					getSpecialPageForm().setValue("STATE",1,1);
   					getSpecialPageForm().setValue("IS_GET_PAGE_DATA",1,1);
   					getSpecialPageForm().setValue("MODULE_ID",window.dialogArguments.moduleId);
   				}
   				}	
   				
   				function getSpecialPageForm(){
   					return g_FormRowSetManager.get("specialpageForm");
   				}
		    		function cancel(){
		    		window.close();
		    		}
		    		
		    	function save(){
			    	if(getSpecialPageForm().isFieldNull("BCE_FRAME_ID,PAGE_FRAME_PAGE_ID",true)){
				    	return;
			    	}
    		if(getSpecialPageForm().toXmlString(true) == "")
    		{
    			alert(crm_i18n_msg("BEC0000008"));
    			return;
    		}
  			var list = new Array();
	      	list.push(getSpecialPageForm());
	        var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);

			if (ud.getValueByName("FLAG") == "ERROR") {
			  if(!ud.getValueByName("MESSAGE"))
			    alert(crm_i18n_msg("BEC0000013"));
				return;
			}
		   			window.returnValue=1
		   			window.close(); 
		    	 }
		    	 
		    	function selRuleSet(){
		    		var rtnVal = window.showModalDialog("../ruleset/selectRuleset.jsp?RULESET_TYPE=1",window.dialogArguments.moduleId,"scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");
		    		if(rtnVal != null){
		    			if(rtnVal == -1){
		    				getSpecialPageForm().setValue("PAGE_RULESET_ID",'');
		    			}else{
		    				getSpecialPageForm().setValue("PAGE_RULESET_ID",rtnVal,rtnVal);
		    			}
		    		}
		    	}
		    	
		    	function selBceFrame(){
		    		var rtnVal = window.showModalDialog("../bceframe/selectBceFrame.jsp?module_id="+window.dialogArguments.moduleId,"","scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");
		    		if(rtnVal != null ){
		    			getSpecialPageForm().setValue("BCE_FRAME_ID",rtnVal.bceFrameId,rtnVal.bceFrameId);
		    			if("<%=pageFramePageId%>" == "-1"){
		    			  pageFrameId = rtnVal.pageFrameId;
		    			  getSpecialPageForm().setValue("PAGE_FRAME_PAGE_ID","","");
		    			}
		    		}
		    		else{
		    			pageFrameId = "-100";
		    		}
		    	}

		    	function selPageFramePage(){
			    	if(pageFrameId == "-100"){
				    	alert(crm_i18n_msg("BEC0000341"));
				    	return;
			    	}
		    		var rtnVal = window.showModalDialog("../pageFramePage/SelectPageFramePage.jsp?pageFrameId="+pageFrameId+"&module_id="+window.dialogArguments.moduleId,"","scroll:no;resizable:no;help:no;status:no;dialogHeight:300px;dialogWidth:700px");
		    		if(rtnVal != null ){
		    			getSpecialPageForm().setValue("PAGE_FRAME_PAGE_ID",rtnVal,rtnVal);
		    		}
		    	}
   					</script>
</html>