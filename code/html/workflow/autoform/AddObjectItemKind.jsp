<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<HTML>
	<HEAD>
		<TITLE><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.addObjectItemKind7"></i18n:message></TITLE>	</HEAD>
	<%
		 /**
		 * 传入参数：
		 * 1、ITEM_KIND_ID,分类编号：-1为新增，其余为显示
		 * 2、ITEM_TYPE,所属对象类型 用于新增
		 * 3、PARENT_KIND_ID,上级分类编号 用于新增
		 *
		 **/
		String aItemKindId = HttpUtil.getParameter(request, "ITEM_KIND_ID");
		String aItemTypeEditable = "true";
		if (aItemKindId.equals("-1")) {
			aItemTypeEditable = "false";
		}
		String aItemType = HttpUtil.getParameter(request, "ITEM_TYPE");
		String aParentKindId = HttpUtil.getParameter(request, "PARENT_ITEM_KIND_ID");
	%>
	<BODY bgcolor="#ffffff" onload="refreshObjectItemKind();">
		<ai:dbform formid="objectItemKind"
			setname="com.ai.comframe.autoform.web.SETVMObjectItemKind"
			implservice_name="com.ai.comframe.autoform.service.interfaces.IAutoFormSV"
			implservice_querymethod="getObjectItemKindDetail(String aObjectItemKindId)"
			initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService">
			<table>
				<tr>
					<td width="100" class="td_font">
						<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.addObjectItemKind35"></i18n:message>：					</td>
					<td width="140" class="td_font">
						<ai:dbformfield fieldname="KIND_ID" formid="objectItemKind"
							editable="false"></ai:dbformfield>
					</td>
				</tr>
				<tr>
					<td width="100" class="td_font">
						<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.addObjectItemKind44"></i18n:message>：					</td>
					<td width="140" class="td_font">
						<ai:dbformfield fieldname="ITEM_KIND_NAME" formid="objectItemKind"></ai:dbformfield>
					</td>
				</tr>
				<tr>
					<td width="100" class="td_font">
						<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.addObjectItemKind52"></i18n:message>：					</td>
					<td width="140" class="td_font">
						<ai:dbformfield fieldname="ITEM_KIND_CODE" formid="objectItemKind"></ai:dbformfield>
					</td>
				</tr>
				<tr>
					<td width="100" class="td_font">
						<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.addObjectItemKind60"></i18n:message>：					</td>
					<td width="140" class="td_font">
						<ai:dbformfield fieldname="OBJECT_ITEM_TYPE"
							formid="objectItemKind" editable="<%=aItemTypeEditable%>"
							visible=""></ai:dbformfield>
					</td>
				</tr>
				<tr>
					<td width="100" class="td_font">
						<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.addObjectItemKind70"></i18n:message>：					</td>
					<td width="140" class="td_font">
						<ai:dbformfield fieldname="PARENT_KIND_ID" formid="objectItemKind"
							editable="false"></ai:dbformfield>
					</td>
				</tr>
				<tr>
					<td width="100" class="td_font">
						<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.addObjectItemKind79"></i18n:message>：					</td>
					<td width="140" class="td_font">
						<ai:dbformfield fieldname="SORTBY" formid="objectItemKind"></ai:dbformfield>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2">
					<ai:button text="comframe.html.jsv2.udfpage.PageDesign116" i18nRes="i18n.comframe_resource"onclick="saveObjectItemKind();"/>
					</td>
				</tr>
			</table>
		</ai:dbform>
	</BODY>

	<script>
function gObjectItemKindRowSet(){
  return g_FormRowSetManager.get("objectItemKind");
}

function refreshObjectItemKind(){
  if ("<%=aItemKindId%>"=="-1"){
    gObjectItemKindRowSet().newRow();
    gObjectItemKindRowSet().setValue("OBJECT_ITEM_TYPE","<%=aItemType%>");
    gObjectItemKindRowSet().setValue("PARENT_KIND_ID","<%=aParentKindId%>");
  }
  else{
    var cond = "aObjectItemKindId=<%=aItemKindId%>";
    gObjectItemKindRowSet().refresh(cond);
  }
}
function saveObjectItemKind(){
  var sform = g_FormRowSetManager.get("objectItemKind");
  if (sform.toXmlString()==""){
    alert(g_I18NMessage("comframe_resources","comframe_html_jsv2_udfpage_FieldPropSetUp77"));    return;
  }
  var aKindName=sform.getValue("ITEM_KIND_NAME");
  if (aKindName==null||aKindName==""){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_addObjectItemKind118"));    return;
  }
  var aKindCode=sform.getValue("ITEM_KIND_CODE");
  if (aKindCode==null||aKindCode==""){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_addObjectItemKind123"));    return;
  }
  
  var strUrl = "<%=request.getContextPath()%>/business/com.ai.comframe.autoform.web.AutoFormAction?action=saveObjectItemKind";
  var list = new Array();
  list.push(sform);
  var msg = saveRowSet(strUrl, list, false, true);
  //var list = new Array();
  //list[0]=gObjectItemKindRowSet();
  //var msg = saveRowSet(_gModuleName+"/business/com.ai.comframe.autoform.web.AutoFormAction?action=saveObjectItemKind",list,false);
  var ret = msg.getValueByName("retVal");
  alert(ret);
  top.close();
}
</script>
</HTML>
