<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<html>
<%
	long moduleId = HttpUtil.getAsLong(request,"moduleId");
 %>
	<head>
		<title><%=LocaleResourceFactory.getResource("BES0000019")%></title>
		<script language="javascript" src="../common/js/configtool.js"></script>
		<script type="text/javascript">
					
					function getBceFrameForm(){
						return g_FormRowSetManager.get("bceFrameDetail");
					}
					
					function getPageFrameForm(){
						return g_FormRowSetManager.get("pageFrameDetail");
					}
					
			function init(){
				getBceFrameForm().setValue("STATE",1);
				getBceFrameForm().setValue("MODULE_ID",'<%=moduleId%>');
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
			  if(!ud.getValueByName("MESSAGE"))
			    alert(crm_i18n_msg("BEC0000013"));
				return;
			} 
			window.returnValue = 1;
			window.close();
   	    }
  
   	    function getPageFrame(){
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
		
		function getParserSV(){
			var rtnVal = window.showModalDialog("<%=request.getContextPath()%>/bce/configtool/model/clazz/selectClazz.jsp", "",
			"scroll:no;resizable:no;help:no;status:no;dialogHeight:580px;dialogWidth:800px");
			if(rtnVal){
				getBceFrameForm().setValue("DATA_PARSER",rtnVal.treeValue);
			}	
		}
		
		function getSV(){
			var rtnVal = window.showModalDialog("<%=request.getContextPath()%>/bce/configtool/model/service/selectService.jsp", "",
			"scroll:no;resizable:no;help:no;status:no;dialogHeight:580px;dialogWidth:800px");
			if(rtnVal){
				getBceFrameForm().setValue("DEAL_SERVICE",rtnVal.treeValue);
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
		
		function cancel(){
			window.close();
		}
</script>
	</head>
	<body onLoad="init()">
		<ai:contentframe id="" title='<%=LocaleResourceFactory.getResource("BES0000020")%>' contenttype="table" width="98%">
			<ai:dbform formid="bceFrameDetail" setname="com.ai.bce.web.BceFrame"
				editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfFrameSV"
				implservice_querymethod="getBceFrameValueByBceFrameId(String bceFrameId)"
				initial="false" onvalchange="">
				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000021")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td >
							<ai:dbformfield fieldname="REMARKS" formid="bceFrameDetail"
								width="200" />
							<ai:dbformfield fieldname="BCE_FRAME_ID" formid="bceFrameDetail"
								visible="false" />

						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000110")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td >
							<ai:dbformfield fieldname="PAGE_FRAME_ID" formid="bceFrameDetail"
								editable="false" width="180"/><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt='<%=LocaleResourceFactory.getResource("BES0000038")%>' onClick="getPageFrame()" align="absmiddle"
								style="cursor: hand;" id="getpage" />
						</td>

					</tr>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000106")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="BUSINESS_ID" formid="bceFrameDetail"
								width="180" editable="false"/><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								onClick="getBS()" align="absmiddle"
								 style="cursor:hand;" id="getBS"/>
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000115")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td><ai:dbformfield fieldname="WORKFLOW_CODE" formid="bceFrameDetail"
							editable="false"	width="180" /><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								onClick="getVM()" align="absmiddle"
								style="cursor:hand;" id="getVM"/>
							
						</td>

					</tr>
					
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000107")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="DATA_PARSER" formid="bceFrameDetail"
								width="180" /><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								onClick="getParserSV()" align="absmiddle" style="cursor: hand;" id="getParserSV"/>
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000108")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td colspan="2">
							<ai:dbformfield fieldname="DEAL_SERVICE" formid="bceFrameDetail"
								width="180" /><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								onClick="getSV()" align="absmiddle"
								style="cursor:hand;" id="getsv"/>
						</td>
					</tr>
					<tr>
						
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000111")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="MODULE_ID" formid="bceFrameDetail"  
								width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000114")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td>
							<ai:dbformfield fieldname="STATE" formid="bceFrameDetail"
								width="200" />
						</td>
					</tr>
					<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000109")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td colspan=3>
							<ai:dbformfield fieldname="ENTRY_PAGE_URL" width="500" 
							editable="false"	formid="bceFrameDetail"   /><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								onClick="getJsp()" align="absmiddle"
								style="cursor:hand;" id="getJSP"/>
						</td>
					<tr>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000112")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td colspan=3>
							<ai:dbformfield fieldname="PARAM_DATA" formid="bceFrameDetail" height='60'
								width="500" />
								<br>
								(key1=value1&key2=value2)
						</td>
					</tr>
				</table>

			</ai:dbform>
		</ai:contentframe>
		<ai:contentframe id="" title='<%=LocaleResourceFactory.getResource("BES0000031")%>' contenttype="table" width="98%">
			<ai:dbform formid="pageFrameDetail"
				setname="com.ai.bce.web.BcePageFrame" editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				initial="false" onvalchange=""
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfPageFrameSV"
				implservice_querymethod="getBcePageFrameValueByBcePageFrameId(String bcePageFrameId)">
				<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
					<tr>

						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000397")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td >
							<ai:dbformfield fieldname="PAGE_FRAME_NAME" editable="false"
								formid="pageFrameDetail" width="200" />
						</td>
						<td class="td_font">
							<%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
						<td >
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
			</ai:dbform>
		</ai:contentframe>

		<div class="area_button">
			<ai:button text="BES0000319" i18nRes="CRM" id="save" onclick="save()"></ai:button>&nbsp;&nbsp;
			<ai:button text="BES0000320" i18nRes="CRM" id="cancel" onclick="cancel()"></ai:button>
		</div>
	</body>

</html>