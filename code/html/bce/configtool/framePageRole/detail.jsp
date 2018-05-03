<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<html>
	<%
		String pFrameId = request.getParameter("pFrameId");
		String roleId = request.getParameter("roleId");
		String frameId = request.getParameter("frameId");
			if (null == pFrameId || "".equals(pFrameId)) {
				pFrameId = "-1";
			}
			if (null == roleId || "".equals(roleId)) {
				roleId = "-1";
			}
			if (null == frameId || "".equals(frameId)) {
				frameId = "-1";
			}
	%>
	<head>
		<script language="javascript" src="../common/js/configtool.js"></script>
	</head>
	<body onLoad="init()">
			<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem>
			</ai:contractitem>
			
			<ai:dbform formid="framePageRoleForm"
				setname="com.ai.bce.web.BceFramePageRole" editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				initial="false" onvalchange=""
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfFramePageRoleSV"
				implservice_querymethod="getPageRoleById(String pFramePageId,String roleId, String frameId)">
				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000369")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="BCE_FRAME_ID" width="200"
								formid="framePageRoleForm" editable="false" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000371")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_FRAME_PAGE_ID" width="200"
								formid="framePageRoleForm" editable="false" />
						</td>
					<tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000372")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="ROLE_ID" formid="framePageRoleForm"
								editable="false" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="REMARKS" formid="framePageRoleForm"
								width="200" editable="false" width="200" />
						</td>

					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000373")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="SEQ_NO" formid="framePageRoleForm"
								editable="false" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000370")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="MAX_NUM" formid="framePageRoleForm"
								editable="false" width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="STATE" formid="framePageRoleForm"
								editable="false" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000111")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="MODULE_ID" formid="framePageRoleForm"
								editable="false" width="200" />
						</td>
					</tr>
				</table>
				<div class="area_button">
					<div id="show">
						<ai:button text="BES0000323" i18nRes="CRM" onclick="edit()" />
					</div>
					<div id="isshow" style="display: none">
						<ai:button text="BES0000319" i18nRes="CRM" onclick="save()" />
					</div>
					<div id="ifshow" style="display: none">
						<ai:button text="BES0000320" i18nRes="CRM" onclick="cancel()" />
					</div>
					
				</div>
			</ai:dbform>
		</ai:contractframe>
	</body>
	<script type="text/javascript">
   				function init(){
   						var condition = "pFramePageId=<%=pFrameId%>&roleId=<%=roleId%>&frameId=<%=frameId%>";
   						getframePageRoleForm().refresh(condition);
   					}
   					
   					function getframePageRoleForm(){
   						return g_FormRowSetManager.get("framePageRoleForm");
   					}
   					
   					function edit(){
			    	    document.getElementById("show").style.display="none";
			    	    document.getElementById("ifShow").style.display="inline";
			    	    document.getElementById("isShow").style.display="inline";
			    		getframePageRoleForm().setEditSts(true);
			    	    getframePageRoleForm().setColEditSts("BCE_FRAME_ID",false);
	   					getframePageRoleForm().setColEditSts("PAGE_FRAME_PAGE_ID",false);
	   					getframePageRoleForm().setColEditSts("ROLE_ID",false);
			    		getframePageRoleForm().setFocus("PAGE_FRAME_NAME");
		    	}
		    		
		    	function cancel(){
		    		document.getElementById("show").style.display="";
		    	    document.getElementById("ifShow").style.display="none";
		    	    document.getElementById("isShow").style.display="none";
		    		getframePageRoleForm().setEditSts(false);
		    	}
		    		
		    	function save(){
		    		var list = new Array();
			        list.push(getframePageRoleForm());
			        var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
					if (ud.getValueByName("FLAG") == "ERROR") {
					  alert(crm_i18n_msg("BEC0000013"));
						return;
					} 
		   			getframePageRoleForm().setEditSts(false);
		   			refreshTopByDetailChange();  
		   			window.location.reload();
		    	 }
   					</script>
</html>