<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil" %>
<!--

//-->
</script>
<html>
	<%
		String moduleId = HttpUtil.getAsString(request,"module_id");
		String bceFrameId = request.getParameter("bceFrameId");
		String bcePageFrameId = request.getParameter("bcePageFrameId");
		if (null == bceFrameId || "".equals(bceFrameId)) {
			bceFrameId = "-1";
		}
		if (null == bcePageFrameId || "".equals(bcePageFrameId)) {
			bcePageFrameId = "-1";
		}
	%>
	<head>
		<script language="javascript" src="../common/js/configtool.js"></script>
		<script type="text/javascript">
			function init(){
					getBceFrameForm().refresh("bceFrameId=<%=bceFrameId%>");
					getPageFrameForm().refresh("bcePageFrameId=<%=bcePageFrameId%>");
			}
					
					function getBceFrameForm(){
						return g_FormRowSetManager.get("bceFrameDetail");
					}
					
					function getPageFrameForm(){
						return g_FormRowSetManager.get("pageFrameDetail");
					}
		
   		
   	    function edit(){
    	    document.getElementById("show").style.display="none";
    	    document.getElementById("ifShow").style.display="inline";
    	    document.getElementById("isShow").style.display="inline";
    	    var imgs = document.getElementsByTagName("img");
    	    for(var i=0;i<imgs.length;i++){
    	    	imgs[i].disabled = false;
    	    }
    		getBceFrameForm().setEditSts(true);
			getBceFrameForm().setColEditSts("PAGE_FRAME_ID",false);
			getBceFrameForm().setColEditSts("BCE_FRAME_ID",false);
			getBceFrameForm().setColEditSts("BUSINESS_ID",false);
			getBceFrameForm().setColEditSts("WORKFLOW_CODE",false);
			getBceFrameForm().setColEditSts("ENTRY_PAGE_URL",false);
    		getBceFrameForm().setFocus("BUSINESS_ID");
   		}
   		
   		function cancel(){
	   		document.getElementById("show").style.display="";
	   	    document.getElementById("ifShow").style.display="none";
	   	    document.getElementById("isShow").style.display="none";
	   	   var imgs = document.getElementsByTagName("img");
    	    for(var i=0;i<imgs.length;i++){
    	    	imgs[i].disabled = true;
    	    }
	   		getBceFrameForm().setEditSts(false);
	   		getPageFrameForm().setEditSts(false);
   		}
   		
   		function save(){
	   		var checkField = getBceFrameForm().isFieldNull("BUSINESS_ID,REMARKS",true);
	   		if(checkField){
	   			return;
	   		}
	   		var list = new Array();
	        list.push(getBceFrameForm());
	        var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
			if (ud.getValueByName("FLAG") == "ERROR") {
			  	alert(crm_i18n_msg("BEC0000013"));
				return;
			} 
			var bcePageFrameId = getBceFrameForm().getValue("PAGE_FRAME_ID");
		  	refreshTopByDetailChange();
		  	window.location.href="detail.jsp?bceFrameId=<%=bceFrameId%>&bcePageFrameId="+bcePageFrameId;
   	    }
  
   	    function getPageFrame(){
			//window.showModalDialog("selectDialog.jsp","Ò³Ãæ¿ò¼ÜÁÐ±í","scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");
			var id = window.showModalDialog("../pageframe/selectPageFrame.jsp?module_id=<%=moduleId%>","","scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");
			if(id == null)return;
			getBceFrameForm().setValue("PAGE_FRAME_ID",id,id);
			getPageFrameForm().refresh("bcePageFrameId="+id);				
		}
		
		function getVM(){
			var rtnVal = window.showModalDialog("<%=request.getContextPath()%>/bce/configtool/model/wvm/selectWVM.jsp", "",
			"scroll:no;resizable:no;help:no;status:no;dialogHeight:580px;dialogWidth:800px");
			if(rtnVal){
				getBceFrameForm().setValue("WORKFLOW_CODE", rtnVal.treeValue);
			}	
		}
		
		function getSV(){
			var rtnVal = window.showModalDialog("<%=request.getContextPath()%>/bce/configtool/model/service/selectService.jsp", "",
			"scroll:no;resizable:no;help:no;status:no;dialogHeight:580px;dialogWidth:800px");
			if(rtnVal){
				getBceFrameForm().setValue("DEAL_SERVICE",rtnVal.treeValue);
			}	
		}
		
		function getParserSV(){
			var rtnVal = window.showModalDialog("<%=request.getContextPath()%>/bce/configtool/model/clazz/selectClazz.jsp", "",
			"scroll:no;resizable:no;help:no;status:no;dialogHeight:580px;dialogWidth:800px");
			if(rtnVal){
				getBceFrameForm().setValue("DATA_PARSER",rtnVal.treeValue);
			}	
		}
		
		function getJsp(){
			var rtnVal = window.showModalDialog("<%=request.getContextPath()%>/bce/configtool/model/jsp/selectJSP.jsp", "",
			"scroll:no;resizable:no;help:no;status:no;dialogHeight:580px;dialogWidth:800px");
			if(rtnVal){
				getBceFrameForm().setValue("ENTRY_PAGE_URL",rtnVal.treeValue);
			}	
		}
		
		
		function getBS(){
			var rtnVal = window.showModalDialog("selectBusiness.jsp", "",
			"scroll:no;resizable:no;help:no;status:no;dialogHeight:580px;dialogWidth:800px");
			if(rtnVal != null && rtnVal != '')
				getBceFrameForm().setValue("BUSINESS_ID",rtnVal);
		}
</script>
	</head>
	<body onLoad="init()">
	<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem>
			</ai:contractitem>
			
			<ai:dbform formid="bceFrameDetail" setname="com.ai.bce.web.BceFrame"
				editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfFrameSV"
				implservice_querymethod="getBceFrameValueByBceFrameId(String bceFrameId)"
				initial="false" onvalchange="">
				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000105")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="BCE_FRAME_ID" formid="bceFrameDetail"
								editable="false" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000110")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="PAGE_FRAME_ID" formid="bceFrameDetail"
								editable="false" width="180"/><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt='<%=LocaleResourceFactory.getResource("BES0000038")%>' onClick="getPageFrame()" align="absmiddle"
								disabled=true style="cursor: hand;" id="getpage"/>
						</td>

					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000106")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="BUSINESS_ID" formid="bceFrameDetail"
								editable="false" width="180" /><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								onClick="getBS()" align="absmiddle"
								disabled=true style="cursor:hand;" id="getBS"/>
						</td>

						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000115")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="WORKFLOW_CODE" formid="bceFrameDetail"
								editable="false" width="180" /><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								onClick="getVM()" align="absmiddle"
								disabled=true style="cursor:hand;" id="getVM"/>
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000021")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="REMARKS" formid="bceFrameDetail"
								editable="false" width="200" />
						</td>
						
					
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000107")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="DATA_PARSER" formid="bceFrameDetail"
								editable="false" width="180" /><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								onClick="getParserSV()" align="absmiddle"
								disabled=true style="cursor: hand;" id="getParserSV"/>
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000108")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="DEAL_SERVICE" formid="bceFrameDetail"
								editable="false" width="180" /><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								onClick="getSV()" align="absmiddle"
								disabled=true style="cursor: hand;" id="getSV"/>
						</td> 
						
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000114")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="STATE" formid="bceFrameDetail"
								editable="false" width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000109")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td colspan=3>
							<ai:dbformfield fieldname="ENTRY_PAGE_URL"
								formid="bceFrameDetail" editable="false" width="500" /><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								disabled="disabled" onClick="getJsp()" align="absmiddle"
								style="cursor:hand;" id="getJSP"/>
						</td>
					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000112")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td colspan=3>
							<ai:dbformfield fieldname="PARAM_DATA" formid="bceFrameDetail"
								editable="false" width="500" height="50"/>
						</td>
					</tr>
				<tr><td colspan=8 align=center><hr style="width:90%"/></td></tr>
				</table>

			</ai:dbform>
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
								formid="pageFrameDetail" editable="false" width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="REMARKS" formid="pageFrameDetail"
								editable="false" width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000394")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="FRAME_TYPE" formid="pageFrameDetail"
								editable="false" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="STATE" formid="pageFrameDetail"
								editable="false" width="200" />
						</td>
					</tr>
				</table>
				<div class="area_button">
					<div id="show">
						<ai:button text="BES0000323" i18nRes="CRM" id="edit" onclick="edit()"></ai:button>
					</div>
					<div id="ifShow" style="display: none">
						<ai:button text="BES0000319" i18nRes="CRM" id="save" onclick="save()"></ai:button>
						&nbsp;&nbsp;&nbsp;
					</div>
					<div id="isShow" style="display: none">
						<ai:button text="BES0000320" i18nRes="CRM" id="cancel" onclick="cancel()"></ai:button>
					</div>
				</div>
			</ai:dbform>
			
		</ai:contractframe>
	</body>

</html>