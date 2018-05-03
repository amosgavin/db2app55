<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<html>
	<%
		String bcePageFrameId = request.getParameter("bcePageFrameId");
			if (null == bcePageFrameId || "".equals(bcePageFrameId)) {
				bcePageFrameId = "-1";
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
			<ai:dbform formid="pageFrameDetail"
				setname="com.ai.bce.web.BcePageFrame" editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				initial="false" onvalchange=""
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfPageFrameSV"
				implservice_querymethod="getBcePageFrameValueByBcePageFrameId(String bcePageFrameId)">
				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000395")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_FRAME_ID"
								formid="pageFrameDetail" editable="false" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000397")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_FRAME_NAME"
								formid="pageFrameDetail" editable="false" width="200" />

						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000394")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="FRAME_TYPE" formid="pageFrameDetail"
								editable="false" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							
							<ai:dbformfield fieldname="REMARKS" formid="pageFrameDetail"
								editable="false" width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td><ai:dbformfield fieldname="STATE" formid="pageFrameDetail"
								editable="false" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000111")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="MODULE_ID" formid="pageFrameDetail" editable="false" 
								 width="200" />
						</td>
					</tr>
				</table>
				<div class="area_button">
					<div id="show">
						<ai:button text="BES0000323" i18nRes="CRM" onclick="edit()" />&nbsp;&nbsp;&nbsp;
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
   						var condition = "bcePageFrameId=<%=bcePageFrameId%>";
   						getPageFrameForm().refresh(condition);
   					}
   					
   					function getPageFrameForm(){
   					return g_FormRowSetManager.get("pageFrameDetail");
   					}
   					
   					function edit(){
		    	    document.getElementById("show").style.display="none";
		    	    document.getElementById("ifShow").style.display="inline";
		    	    document.getElementById("isShow").style.display="inline"; 
		    	    getPageFrameForm().setEditSts(true);
		    		getPageFrameForm().setColEditSts("PAGE_FRAME_ID",false);
		    		getPageFrameForm().setFocus("PAGE_FRAME_NAME");
		    	}
		    		
		    	function cancel(){
		    		document.getElementById("show").style.display="";
		    		document.getElementById("isShow").style.display="none";
		    	    document.getElementById("ifShow").style.display="none";
		    		getPageFrameForm().setEditSts(false);
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
		   			getPageFrameForm().setEditSts(false);
		   			refreshTopByDetailChange();  
		   			window.location.reload();
		    	 }
   					</script>
</html>