<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<html>
	<%
		String bcePageFrameId = request.getParameter("bcePageFrameId");
		if (null == bcePageFrameId || "".equals(bcePageFrameId)) {
			bcePageFrameId = "-1";
		}
		long moduleId = HttpUtil.getAsLong(request,"moduleId");
	%>
	<head>
		<script language="javascript" src="../common/js/configtool.js"></script>
		<title><%=LocaleResourceFactory.getResource("BES0000071")%></title>
	</head>
	<body onLoad="init()">
		<ai:contentframe id="" title="BES0000031" i18nRes="CRM" contenttype="table" width="98%">
			<ai:dbform formid="pageFrameDetail"
				setname="com.ai.bce.web.BcePageFrame" editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				initial="false" onvalchange=""
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfPageFrameSV"
				implservice_querymethod="getBcePageFrameValueByBcePageFrameId(String bcePageFrameId)">
				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						

						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000397")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_FRAME_NAME"
								formid="pageFrameDetail"  width="200" />

						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000394")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="FRAME_TYPE" formid="pageFrameDetail"
								 width="200" />
						</td>
					</tr>
					<tr>
						
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="REMARKS" formid="pageFrameDetail"
								 width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							
							<ai:dbformfield fieldname="STATE" formid="pageFrameDetail"
								 width="200" />
							<ai:dbformfield fieldname="PAGE_FRAME_ID"
								formid="pageFrameDetail" visible="false" width="200" />
						</td>
					</tr>
					<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000111")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="MODULE_ID" formid="pageFrameDetail"  
								 width="200" />
						</td>
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
   					function init(){
   						getPageFrameForm().setValue("STATE",1);
   						getPageFrameForm().setValue("FRAME_TYPE",2);
   						getPageFrameForm().setValue("MODULE_ID","<%=moduleId%>");
   						}
   						
   					function getPageFrameForm(){
   					return g_FormRowSetManager.get("pageFrameDetail");
   					}
   					
		    	function save(){
		    		var list = new Array();
			        list.push(getPageFrameForm());
			        var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
					if (ud.getValueByName("FLAG") == "ERROR" ) {
    	  if(!ud.getValueByName("MESSAGE"))
					   alert(crm_i18n_msg("BEC0000013"));
						return;
					} 
					window.returnValue=1;
					window.close();
		    	 }
		    	 
		    	 function cancel(){
		    	 window.close();
		    	 }
   					</script>
</html>