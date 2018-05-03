<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page import="com.ai.appframe2.web.HttpUtil" %>
<html>
	<%	String moduleId = HttpUtil.getAsString(request,"module_id");
		String pFramePageId = request.getParameter("pFramePageId");
			if (null == pFramePageId || "".equals(pFramePageId)) {
				pFramePageId = "-1";
			}
		request.setAttribute("pFramePageId",pFramePageId);
	%>
	<head>
		<script language="javascript" src="../common/js/configtool.js"></script>
		<script type="text/javascript">
		
				function getPFramePageForm(){
						return g_FormRowSetManager.get("pageFramePageDetail");
				}
   		
   	    function edit(){
   	    	getPFramePageForm().setEditSts(true);
   	    	getPFramePageForm().setColEditSts("PAGE_FRAME_PAGE_ID",false);
   	    	getPFramePageForm().setColEditSts("PAGE_FRAME_ID",false);
   	    	getPFramePageForm().setColEditSts("PAGE_ID",false);
   	    	getPFramePageForm().setColEditSts("PAGE_LOAD_TYPE",false);
			getPFramePageForm().setColEditSts("PAGE_RULESET_ID",false);
			getPFramePageForm().setColEditSts("PAGE_TEMPLATE",false);
			getPFramePageForm().setColEditSts("PAGE_TYPE",false);
			getPFramePageForm().setColEditSts("PAGE_URL",false);
			getPFramePageForm().setColEditSts("IS_GET_PAGE_DATA",false);
			getPFramePageForm().setColEditSts("IS_DATA_MUST",false);
			getPFramePageForm().setColEditSts("MODULE_ID",false);
    	    document.getElementById("show").style.display="none";
    	    document.getElementById("ifShow").style.display="inline";
    	    document.getElementById("isShow").style.display="inline";
    		document.getElementById("getpage").disabled=false;
    		getPFramePageForm().setFocus("BUSINESS_ID");
   		}
   		
   		function cancel(){
	   		document.getElementById("show").style.display="";
	   	    document.getElementById("ifShow").style.display="none";
	   	    document.getElementById("isShow").style.display="none";
	   	   document.getElementById("getpage").disabled=true;
	   		getPFramePageForm().setEditSts(false);
   		}
   		
   		function save(){
   			if(getPFramePageForm().isFieldNull("PAGE_ID",true)){
   				return false
   			}
	   		var list = new Array();
	        list.push(getPFramePageForm());
	     var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.configtool.web.ConfPFramePageAction?action=savePageFramePage",list,false);
			if (ud.getValueByName("FLAG") == "ERROR") {
			  if(!ud.getValueByName("MESSAGE"))
			    alert(crm_i18n_msg("BEC0000013"));
				return;
			}
				getPFramePageForm().setEditSts(false); 
			    refreshTopByDetailChange();
			    window.location.reload();
   	    }
   	    
   	    function sel(){
   	        var pFramePageForm = getPFramePageForm();
			var obj = window.showModalDialog("../page/selectPage.jsp?moduleId=<%=moduleId%>",'',"scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");			
			if(obj != null){
				pFramePageForm.setValue("PAGE_ID",obj.pageId,obj.pageId);
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
	<body >
			<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem>
			</ai:contractitem>
		
			<ai:dbform formid="pageFramePageDetail"
				setname="com.ai.bce.web.QPageFramePage" editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfPFramePageSV"
				implservice_querymethod="getBcePageFramePageValueByPFramePageId(String pFramePageId)"
				initial="true" onvalchange="">
				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000501")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_FRAME_PAGE_ID"
								formid="pageFramePageDetail" editable="false" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000500")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_FRAME_ID"
								formid="pageFramePageDetail" editable="false" width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000503")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_TITLE"
								formid="pageFramePageDetail" editable="false" width="200" />
								</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000504")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="SEQ_NO" formid="pageFramePageDetail"
								editable="false" width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="REMARKS" formid="pageFramePageDetail"
								editable="false" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="STATE" formid="pageFramePageDetail"
								editable="false" width="200" />
						</td>
					</tr>
					<tr>
						
						
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000111")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="MODULE_ID"
								editable="false" formid="pageFramePageDetail" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000502")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
							<td>
							<ai:dbformfield fieldname="PAGE_ID" formid="pageFramePageDetail"
								editable="false" width="180"/><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="sel()" align="absmiddle" disabled=true
								style="cursor: hand;" id="getpage"/>
							
						</td>
					</tr>
					<tr><td colspan=8><hr style="width:90%" /><td></tr>
					<tr>
						
						
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000389")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_LOAD_TYPE"
								formid="pageFramePageDetail" editable="false" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000386")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="IS_GET_PAGE_DATA"
								formid="pageFramePageDetail" editable="false" width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000390")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_RULESET_ID"
								formid="pageFramePageDetail" editable="false" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000391")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_TEMPLATE"
								formid="pageFramePageDetail" editable="false" width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000392")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_TYPE"
								formid="pageFramePageDetail" editable="false" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000393")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_URL" formid="pageFramePageDetail"
								editable="false" width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000385")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="IS_DATA_MUST"
								formid="pageFramePageDetail" editable="false" width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000763")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="IS_DISPLAY"
								 formid="pageFramePageDetail" editable="false" width="200" />
						</td>
					</tr>
				</table>
				
				<div id ='ErrorOrInfo' style="color:red"></div>
				<div class="area_button">
					<div id="show">
						<ai:button text="BES0000323" i18nRes="CRM" id="edit" onclick="edit()"></ai:button>
					</div>
					<div id="ifShow" style="display: none">
						<ai:button text="BES0000319" i18nRes="CRM" id="save" onclick="save()"></ai:button>&nbsp;&nbsp;&nbsp;
					</div>
					<div id="isShow" style="display: none">
						<ai:button text="BES0000320" i18nRes="CRM" id="cancel" onclick="cancel()"></ai:button>
					</div>
				</div>
			</ai:dbform>

		</ai:contractframe>
	</body>

</html>