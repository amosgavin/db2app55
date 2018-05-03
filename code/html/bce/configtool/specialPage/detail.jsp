<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<html>
	<%
		String moduleId = HttpUtil.getAsString(request,"module_id");
		String bceFrameId = request.getParameter("bceFrameId");
		String pageFramePageId = request.getParameter("pageFramePageId");
			if (null == bceFrameId || "".equals(bceFrameId)) {
				bceFrameId = "-1";
			}
			if (null == pageFramePageId || "".equals(pageFramePageId)) {
				pageFramePageId = "-1";
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
			
			<ai:dbform formid="specialpageForm"
				setname="com.ai.bce.web.BceFrameSpecialPage" editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				initial="false" onvalchange=""
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfSpecialPageSV"
				implservice_querymethod="getSpecialPageById(String bceFrameId,String pageFramePageId)">
				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000374")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="BCE_FRAME_ID" formid="specialpageForm"
								editable="false" width="200"/>
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000377")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_FRAME_PAGE_ID" editable="false"
								formid="specialpageForm" width="200"/>
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td class="td_font">
							<ai:dbformfield fieldname="REMARKS" formid="specialpageForm"
								editable="false" width="200"/>
						</td>



						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000378")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_PARAM" formid="specialpageForm"
								editable="false" width="200"/>
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000376")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="IS_GET_PAGE_DATA"
								formid="specialpageForm" editable="false" width="200"/>
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000375")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="IS_DATA_MUST" formid="specialpageForm"
								editable="false" width="200"/>
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000379")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_RULESET_ID"
								formid="specialpageForm" width="180" editable="false" /><img id="sel" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="<%=LocaleResourceFactory.getResource("BES0000068")%>" disabled=true onClick="sel()" align="absmiddle"  style="cursor:hand;"/>
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="STATE" formid="specialpageForm"
								editable="false" width="200"/>
						</td>
					</tr>
					<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000111")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="MODULE_ID" formid="specialpageForm"
								editable="false" width="200"/>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000380")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_TITLE" formid="specialpageForm"
								editable="false" width="200"/>
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
	   					var condition = "bceFrameId=<%=bceFrameId%>&pageFramePageId=<%=pageFramePageId%>";
	   					getSpecialPageForm().refresh(condition);
   					}
   					
   					function getSpecialPageForm(){
   						return g_FormRowSetManager.get("specialpageForm");
   					}
   					
   					function edit(){
			    	    document.getElementById("show").style.display="none";
			    	    document.getElementById("ifshow").style.display="inline";
				    	document.getElementById("isshow").style.display="inline";
				    	document.getElementById("sel").disabled=false;
			    		getSpecialPageForm().setEditSts(true);
			    		getSpecialPageForm().setColEditSts("BCE_FRAME_ID",false);
			    		getSpecialPageForm().setColEditSts("PAGE_FRAME_PAGE_ID",false);
			    		getSpecialPageForm().setColEditSts("PAGE_RULESET_ID",false);
			    		getSpecialPageForm().setFocus("PAGE_FRAME_NAME");
		    	}
		    		
		    	function cancel(){
		    		document.getElementById("show").style.display="";
		    	    document.getElementById("ifshow").style.display="none";
		    	    document.getElementById("isshow").style.display="none";
		    	    document.getElementById("sel").disabled=true;
		    		getSpecialPageForm().setEditSts(false);
		    	}
		    		
		    	function save(){
		    		var list = new Array();
			        list.push(getSpecialPageForm());
			        var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
					if (ud.getValueByName("FLAG") == "ERROR" ) {
					  alert(crm_i18n_msg("BEC0000013"));
						return;
					} 
		   			getSpecialPageForm().setEditSts(false);
		   			refreshTopByDetailChange();  
		    	 }
		    	 
		    	function sel(){
		    		var rtnVal = window.showModalDialog("../ruleset/selectRuleset.jsp?RULESET_TYPE=1",<%=moduleId%>,"scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");
		    		if(rtnVal != null){
		    			if(rtnVal == -1){
		    				getSpecialPageForm().setValue("PAGE_RULESET_ID",'');
		    			}else{
		    				getSpecialPageForm().setValue("PAGE_RULESET_ID",rtnVal,rtnVal);
		    			}
		    		}
		    	}
   					</script>
</html>