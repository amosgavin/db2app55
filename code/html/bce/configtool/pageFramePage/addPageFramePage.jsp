<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<html>
	<%
		String pFramePageId = request.getParameter("pFramePageId");
		if (null == pFramePageId || "".equals(pFramePageId)) {
			pFramePageId = "-1";
		}
		String pageFrameId = request.getParameter("pageFrameId");
		if (null == pageFrameId || "".equals(pageFrameId)) {
			pageFrameId = "-1";
		}
		long moduleId = HttpUtil.getAsLong(request,"moduleId");
	%>
	<head>
		<title><%=LocaleResourceFactory.getResource("BES0000058")%></title>
		<script language="javascript" src="../common/js/configtool.js"></script>
		<script type="text/javascript">
		function getPFramePageForm(){
			return g_FormRowSetManager.get("pageFramePageDetail");
		}
		function init(){
			if("<%=pFramePageId%>" != '-1'){
				getPFramePageForm().refresh("pFramePageId=<%=pFramePageId%>");
			}else{
				getPFramePageForm().setValue("PAGE_FRAME_ID",'<%=pageFrameId%>','<%=pageFrameId%>');
				getPFramePageForm().setValue("MODULE_ID","<%=moduleId%>");
				getPFramePageForm().setValue("STATE",1);
				getPFramePageForm().setValue("IS_DISPLAY",1);
				}
		}
		
   		function save(){
   		   if(getPFramePageForm().isFieldNull("PAGE_ID",true)){
   		   		return false;
   		   		}
	   		var list = new Array();
	        list.push(getPFramePageForm());
	    var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.configtool.web.ConfPFramePageAction?action=savePageFramePage",list,false);
			if (ud.getValueByName("FLAG") == "ERROR") {
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
   	    
   	    function sel(){
   	        var pFramePageForm = getPFramePageForm();
			var obj = window.showModalDialog("../page/selectPage.jsp?moduleId="+pFramePageForm.getValue("MODULE_ID"),"","scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");			
			if(obj != null){
				pFramePageForm.setValue("PAGE_ID",obj.pageId);
				pFramePageForm.setValue("PAGE_LOAD_TYPE",obj.pageLoadType);
				pFramePageForm.setValue("PAGE_RULESET_ID",obj.pageResultId);
				pFramePageForm.setValue("PAGE_TEMPLATE",obj.pageTemplate);
				pFramePageForm.setValue("PAGE_TYPE",obj.pageType);
				pFramePageForm.setValue("PAGE_URL",obj.pageUrl);
				pFramePageForm.setValue("IS_GET_PAGE_DATA",obj.isGetPageData);
				pFramePageForm.setValue("IS_DATA_MUST",obj.isDataMust);
			}	
		}
</script>
	</head>
	<body onLoad="init()">
		<ai:contentframe id="" title="BES0000058" i18nRes="CRM" contenttype="table" width="98%">
			<ai:dbform formid="pageFramePageDetail"
				setname="com.ai.bce.web.QPageFramePage" editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfPFramePageSV"
				implservice_querymethod="getBcePageFramePageValueByPFramePageId(String pFramePageId)"
				initial="false" onvalchange="">
				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000502")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_ID" formid="pageFramePageDetail"
								width="180" editable="false"/><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								 onClick="sel()" align="absmiddle"
								style="cursor: hand;" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000763")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="IS_DISPLAY"
								 formid="pageFramePageDetail" width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000503")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_TITLE"
								formid="pageFramePageDetail" width="200" />
							<ai:dbformfield fieldname="PAGE_FRAME_PAGE_ID"
								formid="pageFramePageDetail" visible="false" width="200" />
							<ai:dbformfield fieldname="PAGE_FRAME_ID"
								formid="pageFramePageDetail" visible="false" width="200" />
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000504")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="SEQ_NO" formid="pageFramePageDetail"
								width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="REMARKS" formid="pageFramePageDetail"
								width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="STATE" formid="pageFramePageDetail"
								width="200" />
						</td>
					</tr>
					<tr><td colspan=4><hr style="width:100%" /><td></tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000392")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_TYPE"
							   editable="false"	formid="pageFramePageDetail" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000393")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_URL" formid="pageFramePageDetail"
								editable="false" width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000390")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_RULESET_ID"
								editable="false"formid="pageFramePageDetail" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000391")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_TEMPLATE"
								editable="false"formid="pageFramePageDetail" width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000385")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="IS_DATA_MUST"
								editable="false"formid="pageFramePageDetail" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000386")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="IS_GET_PAGE_DATA"
								editable="false"formid="pageFramePageDetail" width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000389")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_LOAD_TYPE"
								editable="false"formid="pageFramePageDetail" width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000111")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="MODULE_ID"
								 formid="pageFramePageDetail" width="200" editable="false"/>
						</td>
						</tr>
				</table>				
			</ai:dbform>
		</ai:contentframe>
		
		<div id ='ErrorOrInfo' style="color:red"></div>
				<div class="area_button">
					<ai:button text="BES0000319" i18nRes="CRM" id="save" onclick="save()" />
					<ai:button text="BES0000320" i18nRes="CRM" onclick="cancel()" />
				</div>
	</body>

</html>