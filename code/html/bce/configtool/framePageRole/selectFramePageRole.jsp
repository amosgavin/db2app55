<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<html>
	<%
		String pFrameId = request.getParameter("pFramePageId");
		String roleId = request.getParameter("roleId");
		String frameId = request.getParameter("bceFrameId");
		boolean bceFlag = false;
		boolean pageFlag = false;
		String enable = "false";
		if (null == pFrameId || "".equals(pFrameId)) {
			pFrameId = "-1";
			pageFlag = true;
		}
		if (null == roleId || "".equals(roleId)) {
			roleId = "-1";
			enable="true";
		}
		if (null == frameId || "".equals(frameId)) {
			frameId = "-1";
			bceFlag=true;
		}
		request.setAttribute("pFramePageId", pFrameId);
		request.setAttribute("roleId", roleId);
		request.setAttribute("frameId", frameId);
	%>
	<head>
		<script language="javascript" src="../common/js/configtool.js"></script>
		<title><%=LocaleResourceFactory.getResource("BES0000066")%></title>
	</head>
	<body onLoad="init()">
		<ai:contentframe id="" title='<%=LocaleResourceFactory.getResource("BES0000067")%>' contenttype="table"  width="98%">
			<ai:dbform formid="framePageRoleForm"
				setname="com.ai.bce.web.BceFramePageRole" editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				initial="true" onvalchange=""
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfFramePageRoleSV"
				implservice_querymethod="getPageRoleById(String pFramePageId,String roleId, String frameId)">
				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000369")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="BCE_FRAME_ID" editable="false"
								formid="framePageRoleForm" width="180"/><img id="sel" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="<%=LocaleResourceFactory.getResource("BES0000068")%>"  onclick="<%=bceFlag%>==false?'':selBceFrame()" align="absmiddle"  style="cursor:hand;"/>
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000371")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_FRAME_PAGE_ID" formid="framePageRoleForm" 
							width="200" editable="false"/><img id=" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="<%=pageFlag%>==false?'':selPageFramePage()" align="absmiddle" style="cursor:hand;"/>
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000372")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="ROLE_ID"  formid="framePageRoleForm" editable="<%=enable %>" width="200"/>
						</td><td class="td_font"><%=LocaleResourceFactory.getResource("BES0000370")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="MAX_NUM" formid="framePageRoleForm"
								width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000373")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="SEQ_NO" formid="framePageRoleForm"
								width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td><ai:dbformfield fieldname="REMARKS" formid="framePageRoleForm"
								width="200" />
							
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="STATE" formid="framePageRoleForm"
								width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000121")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="MODULE_ID" formid="framePageRoleForm"
								width="200" />
						</td>
					</tr>
				</table>
			</ai:dbform>
		</ai:contentframe>
		<div class="area_button">
				<ai:button  text="BES0000319" i18nRes="CRM" onclick="save()" />
				<ai:button text="BES0000320" i18nRes="CRM" onclick="cancel()" />
		</div>
	</body>
	<script type="text/javascript">
	        var pageFrameId = "-100";
   				function init(){
	   				var bceFrameId = "<%=frameId%>";
		   			var pFramePageId = "<%=pFrameId%>";
		   			var roleId = "<%=roleId%>";
		   			bceFrameId = bceFrameId=='-1'?"":bceFrameId;
		   			pFramePageId = pFramePageId=='-1'?"":pFramePageId;
		   			roleId = roleId=='-1'?"":roleId;
	   				if(bceFrameId == '' || roleId == ''){
	   					getframePageRoleForm().newRow();
	   					getframePageRoleForm().setValue("PAGE_FRAME_PAGE_ID",pFramePageId,pFramePageId);
	   					getframePageRoleForm().setValue("BCE_FRAME_ID",bceFrameId,bceFrameId);
	   					getframePageRoleForm().setValue("ROLE_ID",roleId,roleId);
	   					getframePageRoleForm().setValue("STATE",1);
	   					getframePageRoleForm().setValue("MODULE_ID",window.dialogArguments);
	   				}
	   			}
   					
   					function getframePageRoleForm(){
   						return g_FormRowSetManager.get("framePageRoleForm");
   					}
		    		function cancel(){
		    		window.close();
		    		}
		    	function save(){
		    		if(getframePageRoleForm().isFieldNull("BCE_FRAME_ID,PAGE_FRAME_PAGE_ID,ROLE_ID",true)){
				    	return;
			    	}
		    		if(getframePageRoleForm().toXmlString(true) == "")
		    		{
		    			alert(crm_i18n_msg("BEC0000008"));
		    			return;
		    		}
		    		var list = new Array();
			        list.push(getframePageRoleForm());
			        var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
					if (ud.getValueByName("FLAG") == "ERROR" ) {
					  if(!ud.getValueByName("MESSAGE"))
					  alert(crm_i18n_msg("BEC0000013"));
						return;
					} 
					window.returnValue = 1;
					window.close();
		    	 }
		    	
		    	function selBceFrame(){
		    		var rtnVal = window.showModalDialog("../bceframe/selectBceFrame.jsp?module_id="+window.dialogArguments,"","scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");
		    		if(rtnVal != null ){
		    			getframePageRoleForm().setValue("BCE_FRAME_ID",rtnVal.bceFrameId,rtnVal.bceFrameId);
		    			if("<%=pFrameId%>" == "-1"){
		    			  pageFrameId = rtnVal.pageFrameId;
		    			  getframePageRoleForm().setValue("PAGE_FRAME_PAGE_ID","","");
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
		    		var rtnVal = window.showModalDialog("../pageFramePage/SelectPageFramePage.jsp?pageFrameId="+pageFrameId+"&module_id="+window.dialogArguments,"","scroll:no;resizable:no;help:no;status:no;dialogHeight:300px;dialogWidth:700px");
		    		if(rtnVal != null ){
		    			getframePageRoleForm().setValue("PAGE_FRAME_PAGE_ID",rtnVal,rtnVal);
		    		}
		    	}
   					</script>
</html>