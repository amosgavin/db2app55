<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<HTML>
	<HEAD>
		<TITLE>
		<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.objectItemDetail7"></i18n:message>
		</TITLE>
	</HEAD>
	<BODY onload="refreshObjectItem();">
		<%
			String ObjectItemId = HttpUtil.getParameter(request, "OBJECT_ITEM_ID");
			if (ObjectItemId == null) {
				ObjectItemId = "-1";
			}
			String ObjectItemType = HttpUtil.getParameter(request, "OBJECT_ITEM_TYPE");
			String ObjectItemKindId = HttpUtil.getParameter(request, "OBJECT_ITEM_KIND_ID");
			//pageContext.getRequest().setAttribute("OBJECT_ITEM_ID",ObjectItemId);
		%>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr class="alt_row">
					<td class="section_content">
						<!--内容写在下面：有几个模块就用几个table；table的宽度不可超过900，如果DBGrid超过900，则在'div'中加入'style="width:900;overflow:auto"';高度不要定义-->
						<!--功能内容开始-->
						<table align="center">
							<tr>
								<td>
								<ai:contractframe title="" id="ab" width="100%" height="100%" allowcontract="false">
									<ai:contractitem>
										<table width="100%" height="100%">
											<tr>
												<td id="selectTemplateTD" style="text-align: right;display: none;">
													<ai:button i18nRes="i18n.comframe_resource" text="comframe.html.jsv2.udfpage.PageDesign119"  onclick="selectTemplate()"/>
													<input type="checkbox" id="selectTemplateCheck" checked="checked"  onclick=""><i18n:message res="i18n.comframe_resource" key="comframe.html.workflow.autoform.objectItemDetail.checkBox_template"></i18n:message> 
												</td>
											</tr>
										</table>	
									</ai:contractitem>
								
									<ai:dbform formid="objectItemForm"
										setname="com.ai.comframe.autoform.web.SETVMObjectItem"
										implservice_name="com.ai.comframe.autoform.service.interfaces.IAutoFormSV"
										implservice_querymethod="getObjectItemDetail(long aObjectItemId)"
										initial="false" 
										datamodel="com.ai.appframe2.web.datamodel.MethodModelForService">
										<table border="0" cellspacing="0" cellpadding="0"
											align="center">
											<tr>
												<td width="100" class="td_font">
													<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.objectItemDetail38"></i18n:message>：												</td>
												<td width="240" class="td_font">
													<ai:dbformfield fieldname="OBJECT_ITEM_ID"
														formid="objectItemForm" editable="false" width="240"></ai:dbformfield>
												</td>
												<td width="100" class="td_font">
													<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.objectItemDetail45"></i18n:message>：												</td>
												<td width="240" class="td_font">
													<ai:dbformfield fieldname="CODE" formid="objectItemForm"
														width="240"></ai:dbformfield>
												</td>
											</tr>
											<tr>
												<td width="100" class="td_font">
													<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.objectItemDetail54"></i18n:message>：												</td>
												<td width="240" class="td_font">
													<ai:dbformfield fieldname="NAME" formid="objectItemForm"
														width="240"></ai:dbformfield>
												</td>
												<td width="100" class="td_font">
													<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.objectItemDetail61"></i18n:message>：												</td>
												<td width="240" class="td_font">
													<ai:dbformfield fieldname="DESCRIPTION"
														formid="objectItemForm" width="240"></ai:dbformfield>
												</td>
											</tr>
											<tr>
												<td width="100" class="td_font">
													<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.objectItemDetail70"></i18n:message>：												</td>
												<td width="240" class="td_font">
													<ai:dbformfield fieldname="ITEM_TYPE"
														formid="objectItemForm" width="240"></ai:dbformfield>
												</td>
												<td width="100" class="td_font">
													<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.objectItemDetail77"></i18n:message>：												</td>
												<td width="240" class="td_font">
													<ai:dbformfield fieldname="SORT_BY" formid="objectItemForm"
														width="240"></ai:dbformfield>
												</td>
											</tr>
											<tr>
												<td width="100" class="td_font">
													<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.objectItemDetail86"></i18n:message>：												</td>
												<td width="240" class="td_font">
													<ai:dbformfield fieldname="STATE" formid="objectItemForm" editable="false"
														width="240"></ai:dbformfield>
												</td>
												<td width="100" class="td_font">
													<i18n:message res="i18n.comframe_resource"  key="comframe.html.jsv2.udfpage.UserDefineField81"></i18n:message>：												</td>
												<td width="240" class="td_font">
													<ai:dbformfield fieldname="REMARKS" formid="objectItemForm"
														width="240"></ai:dbformfield>
												</td>
											</tr>
										</table>
									</ai:dbform>
									</ai:contractframe>
								</td>
							</tr>
							<tr>
								<td>
											
										<ai:contractframe width="100%"   i18nRes="i18n.comframe_resource" title="comframe.html.workflow.autoform.objectItemDetail148" id="cd"  allowcontract="false">
											<ai:contractitem>
											<div class="t-bot-mc-button">
											<ai:button text="comframe.html.jsv2.udfpage.UserDefineFieldQuery91" i18nRes="i18n.comframe_resource" onclick="addUrl()"/>
											<ai:button text="comframe.html.jsv2.udfpage.UserDefineFieldQuery97" i18nRes="i18n.comframe_resource" onclick="deleteTable('TblUrl')"/>
											</div>
											</ai:contractitem>	
													<ai:table
															setname="com.ai.comframe.autoform.web.SETVMObjectItemUrl"
															tableid="TblUrl"
															implservice_name="com.ai.comframe.autoform.service.interfaces.IAutoFormSV"
															implservice_querymethod="getObjectItemUrl(String aObjectItemId,int $STARTROWINDEX,int $ENDROWINDEX)"
															
															tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
															pagesize="20" editable="true" footdisplay="none"
															height="160" width="100%" initial="false"
															multiselect="true" needrefresh="true">
								
															<ai:col fieldname="URL_BUSI_TYPE" editable="true"
																visible="true" width="35%" />
															<ai:col fieldname="URL" editable="true" visible="true"
																width="65%" />
															<ai:col fieldname="OBJECT_ITEM_ID" editable="true"
																visible="false"  width="0"/>
														</ai:table>
										</ai:contractframe>

					

								</td>
							</tr>
							
							
							<tr align="right">
								
								
								<td class="td_button">									
									<ai:button text="comframe.html.jsv2.udfpage.PageDesign116" i18nRes="i18n.comframe_resource" onclick="saveObjectItem()"/>
								</td>
							</tr>
						</table>

						<!--功能内容结束-->
					</td>
				</tr>
			</table>

		
	</BODY>
</HTML>
<script language="javascript">
var templateCode="";
function selectTemplate(){
	var tmpName = window.showModalDialog("SelectTemplate.jsp",this,"scroll:no;resizable:no;status:no;dialogHeight:550px;dialogWidth:450px");
	if(!tmpName||tmpName==""){
		//g_AIButtonManager.get("selectTemplateButton").setDisabled(true);
		return;
	}
	//g_AIButtonManager.get("selectTemplateButton").setDisabled(false);
	
	//var url = "<%=request.getContextPath()%>/business/com.ai.comframe.autoform.web.AutoFormAction?action=getDetailInfo&tmpName="+tmpName;
     
  //saveRowSet(url,list,false,false,null,false,true);
   ////ret = PostInfo(url);
  //if(ret.getValueByName("msg")=="Y"){
  	gObjectItemRowSet().setValue("CODE",tmpName);
  	gObjectItemRowSet().setValue("NAME",tmpName);
  	gObjectItemRowSet().setValue("DESCRIPTION",tmpName);
  	gObjectItemRowSet().setValue("REMARKS",tmpName);
  	templateCode = tmpName;
  //}else{
  	//alert(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm123"));
 // /}//
	
}

function generateWorkflowChild(){
	var url = "<%=request.getContextPath()%>/business/com.ai.comframe.autoform.web.AutoFormAction?action=generateWorkflowChild&templateCode="+templateCode;
	ret = PostInfo(url);
	
}

function gObjectItemRowSet(){
  return g_FormRowSetManager.get("objectItemForm");
}

function gObjectItemUrlSetRowSet(){
  return g_TableRowSetManager.get("TblUrl");
}


function addUrl(){
	var OBJECT_ITEM_ID = gObjectItemRowSet().getValue("OBJECT_ITEM_ID");
	gObjectItemUrlSetRowSet().newRow(false);
	gObjectItemUrlSetRowSet().setValue(gObjectItemUrlSetRowSet().getRow(),"OBJECT_ITEM_ID",OBJECT_ITEM_ID);
}



function deleteTable(object){
	var selArray=g_TableRowSetManager.get(object).getSelectedRows();
    if(selArray.length>0){
        if(window.confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_objectItemDetail465"))){            
            for(var i=selArray.length-1;i>=0;i--){
              g_TableRowSetManager.get(object).deleteRow(selArray[i]);
            }
            return true;
        }
    }else{
    	var aRowNo=g_TableRowSetManager.get(object).getRow();
        if (aRowNo>=0){
          if(window.confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_objectItemDetail474"))){            
              g_TableRowSetManager.get(object).deleteRow(aRowNo);
          }else{
            return;
          }
        }else{
          alert(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_objectItemDetail480"));        }
     }
}

function refreshObjectItem(){
  if ("<%=ObjectItemId%>"=="-1"){
    gObjectItemRowSet().newRow();
    gObjectItemRowSet().setValue("ITEM_TYPE","<%=ObjectItemType%>");
    if("<%=ObjectItemType%>"=="WORKFLOW" || "<%=ObjectItemType%>"=="WORKFLOW_NODE"){
    	//document.all.item("AttrExtDiv").style.display="block";
    	//document.all.item("URLDiv").style.display="block";
    }
    if("<%=ObjectItemType%>"=="WORKFLOW"){
    	//document.all.item("AttrExtDiv").style.display="block";
    	//document.all.item("URLDiv").style.display="block";
    	document.getElementById("selectTemplateTD").style.display="block";
    	
    }
  }else{
  	if("<%=ObjectItemType%>"=="WORKFLOW"){
    	//document.all.item("AttrExtDiv").style.display="block";
    	//document.all.item("URLDiv").style.display="block";
    	document.getElementById("selectTemplateTD").style.display="block";
    	
    }
    var param="aObjectItemId=<%=ObjectItemId%>";
    gObjectItemRowSet().refresh(param);
    if("<%=ObjectItemType%>"=="WORKFLOW" || "<%=ObjectItemType%>"=="WORKFLOW_NODE"){
    	//document.all.item("AttrExtDiv").style.display="block";
    	//document.all.item("URLDiv").style.display="block";
    	gObjectItemUrlSetRowSet().refresh(param);
    }
   
  }
}
function saveObjectItem(){
  var DC_LIST="";
  var list = new Array();
  if (gObjectItemRowSet().toXmlString()!=""){
      DC_LIST="ObjectItemDc";
      //test verify方法
      var r=gObjectItemRowSet().validate("REMARKS",true,false);
      if (r==false){
        alert(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_objectItemDetail539"));        return;
      }
      list.push(gObjectItemRowSet());
  }
 
  if (gObjectItemUrlSetRowSet().toXmlString()!=""){
      if (DC_LIST!=""){
        DC_LIST+=",";
      }
      DC_LIST+="ObjectItemUrlSetDc";
      list.push(gObjectItemUrlSetRowSet());
  }
  
  
  
 
  if (list.length==0){
    alert(g_I18NMessage("comframe_resources","comframe_html_jsv2_udfpage_FieldPropSetUp77"));    return;
  }
  var param="&DC_LIST="+DC_LIST+"&OBJECT_ITEM_KIND_ID=<%=ObjectItemKindId%>";
  if(document.getElementById("selectTemplateCheck").checked==true && gObjectItemRowSet().getValue("ITEM_TYPE") == "WORKFLOW"){
  	param+="&selectTemplateCheck=Y";
  }
  var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.comframe.autoform.web.AutoFormAction?action=saveObjectItem"+param,list,false);
  var ret = msg.getValueByName("retVal");
  
  if (ret.substring(0,1)=="Y"){
	alert(ret.substring(1,ret.length));
    location.reload();
    //刷新树节点。
    var aTree=window.parent.parent.refreshNode();
  }
  else
	  alert(ret);
}

</script>
