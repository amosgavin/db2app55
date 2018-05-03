<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<% String path = request.getContextPath();
   String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head><title>��Դ�������</title></head>
<body onload="initPage();">
<ai:contractframe id="resourceChangeMainframe" contenttype="table" title="��Դ���������Ҫ��Ϣ" width="100%" allowcontract="true" frameclosed="false">
<ai:contractitem />
<ai:dbform formid="resourceChangeMainForm"
	setname="com.asiainfo.sale.activity.web.SETResourceChange"
	conditionname="condition" parametersname="parameters"
	editable="true" initial="false"
	datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	implservice_name="com.asiainfo.sale.activity.service.interfaces.IResourceChangeSV"
	implservice_querymethod="getResourceChange(String ResourceId)">
<table width="100%" align="center" border="0" cellpadding="1">
	<tr>
		<td class="td_font">��������:</td>
           <td><ai:dbformfield formid="resourceChangeMainForm" fieldname="APPLY_NAME" width="200"/><span class="font_red">*</span>
           <ai:dbformfield formid="resourceChangeMainForm" fieldname="RESOURCE_ID" width="60" editable="" visible="false"/>
           <ai:dbformfield formid="resourceChangeMainForm" fieldname="STATE" width="150" editable="" visible="false"/></td>
		<td class="td_font">������:</td>
		<td><ai:dbformfield formid="resourceChangeMainForm" fieldname="PRINCIPLE" width="150" editable="false" visible="false" />
			<ai:dbformfield formid="resourceChangeMainForm" fieldname="PROP_STAFF" width="150" editable="false" />
			<span class="font_red">*</span></td>
	</tr>
	<tr>
		<td class="td_font">���뵥λ:</td>
		<td><ai:dbformfield formid="resourceChangeMainForm" fieldname="ORG" width="130" editable="false" visible="false" />
			<ai:dbformfield formid="resourceChangeMainForm" fieldname="ORG_NAME" width="200" editable="false" />
			<span class="font_red">*</span>
		</td>
	</tr>
	<tr>
		<td class="td_font">����˵��������:</td>
		<td colspan="5"><ai:dbformfield formid="resourceChangeMainForm" fieldname="DESCRIPTION" height="60" width="700" />
		<span class="font_red">*</span></td>
	</tr>
	<tr>
		<td colspan="4" align="center"><ai:button text="��������Ϣ" id="query2" onclick="doWork('saveResourceChangeMainInfo()')" /></td>
	</tr>
</table>
			</ai:dbform>
		</ai:contractframe>

		
<div id = "ResourceChangeDetail_div">		
<ai:contractframe id="ResourceChangeDetailFFrame" contenttype="table" title="��Դ�����ϸ��Ϣ" width="100%" allowcontract="true" frameclosed="false">
		<ai:contractitem/>
		<ai:dbform formid="ResourceChangeDetailForm" 
         setname="com.asiainfo.sale.activity.web.SETResourceChangeDetail"
         conditionname="condition" parametersname="parameters"
         editable="true" initial="false"
         datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
         implservice_name="com.asiainfo.sale.activity.service.interfaces.IResourceChangeDetailSV"
         implservice_querymethod="getResourceChangeDetailByID(int resourceId)">
    		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
          <tr>
         		<td class="td_font">����ն˲�����</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="C_TERM" width="150"/>(��Ԫ)</td>
          	<td class="td_font">ʡ�ն˲�����</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="P_TERM" width="150"/>(��Ԫ)</td>
          	<td class="td_font">�����ն˲�����</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="L_TERM" width="150"/>(��Ԫ)</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="RESOURCE_ID" width="150" visible="false"/></td>
          </tr>
          <tr>
         		<td class="td_font">����ۿ����ã�</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="C_DISC" width="150"/>(��Ԫ)</td>
          	<td class="td_font">ʡ�ۿ����ã�</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="P_DISC" width="150"/>(��Ԫ)</td>
          	<td class="td_font">�����ۿ����ã�</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="L_DISC" width="150"/>(��Ԫ)</td>
          </tr>
          <tr>
         		<td class="td_font">����������֣�</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="C_POINTS" width="150"/>(��Ԫ)</td>
          	<td class="td_font">ʡ�������֣�</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="P_POINTS" width="150"/>(��Ԫ)</td>
          	<td class="td_font">���д������֣�</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="L_POINTS" width="150"/>(��Ԫ)</td>
          </tr>
          <tr>
         	    <td class="td_font">��������ѣ�</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="C_PROMT" width="150"/>(��Ԫ)</td>
          	<td class="td_font">ʡ�����ѣ�</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="P_PROMT" width="150"/>(��Ԫ)</td>
          	<td class="td_font">���д����ѣ�</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="L_PROMT" width="150"/>(��Ԫ)</td>
          </tr>
		</table>
		</ai:dbform>
</ai:contractframe>
<ai:loginuser />
</div>
<%@include file="/sale/resource/include/_resChangeCheck.jsp"%>
</body>
<script type="text/javascript">
var _orgId = g_GetUserInfo().ORG_ID;
var resourceId = "<%=request.getParameter("recordId")%>";
var _mainId = resourceId;
</script>
<script type="text/javascript">
var resourceChangeMainForm = g_FormRowSetManager.get("resourceChangeMainForm");
var resourceChangeDetailForm = g_FormRowSetManager.get("ResourceChangeDetailForm");

function initPage() {
if('null'!=resourceId || "" !=resourceId){
		resourceChangeMainForm.refresh("&ResourceId="+resourceId);
		resourceChangeDetailForm.refresh("&resourceId="+resourceId);
		var state =resourceChangeMainForm.getValue("STATE");
		if(state != '1' || resourceChangeMainForm.getValue("PRINCIPLE") != g_GetUserInfo().STAFF_ID){
		resourceChangeMainForm.setEditSts("false");	
		var resourceDid=resourceChangeDetailForm.getValue("RESOURCE_ID");
		if(resourceDid!=null ||"" !=resourceId){
		   resourceChangeDetailForm.setEditSts("false");	
		 }
		}
		}
}

function doWork(fun) {
	beginAIWaitBanner(fun, "���ڴ������Ժ�...");
}

function saveResourceChangeMainInfo(){
var applyName=resourceChangeMainForm.getValue("APPLY_NAME");
 var mark=resourceChangeMainForm.getValue("DESCRIPTION"); 
 if(""==applyName || null==applyName){return  alert("��������Դ�����������ƣ�");}
 if(""==mark){return  alert("����д����˵����");}
 
  if ("O" != resourceChangeMainForm.getSts()||resourceChangeMainForm.getSts()=="U")
 {
    var list = new Array();
    list.push(resourceChangeMainForm);
    var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.ResourceChangeAction?action=saveResourceChangeMainInfo';
    var recode = saveRowSet(strUrl, list);
    ResourceId = recode.getValueByName("ResourceId");
    if(ResourceId == null || ResourceId == '' || ResourceId == 'undefined'){
    	return alert("�������ʧ�ܣ�");
    }
 	    resourceChangeMainForm.refresh("&ResourceId="+ResourceId);
 	    //showName();
 }
}

function saveResourceChangeDetailInfo(){
	if(ResourceId!=null && ResourceId!=''){
	resourceChangeDetailForm.setValue("RESOURCE_ID",ResourceId);
	}
	var list = new Array();
    list.push(resourceChangeDetailForm);
    var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.ResourceChangeDetailAction?action=saveResourceChangeDetailInfo';
    var recode = saveRowSet(strUrl, list);
    ResourceDid = recode.getValueByName("ResourceDid");
    //resourceChangeDetailForm.refresh("&ResourceDid="+ResourceDid);
}
</script>
</html>
