<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<% String path = request.getContextPath();
   String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head><title>资源借调申请</title></head>
<body onload="initPage();">
<ai:contractframe id="resourceChangeMainframe" contenttype="table" title="资源借调申请主要信息" width="100%" allowcontract="true" frameclosed="false">
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
		<td class="td_font">申请名称:</td>
           <td><ai:dbformfield formid="resourceChangeMainForm" fieldname="APPLY_NAME" width="200"/><span class="font_red">*</span>
           <ai:dbformfield formid="resourceChangeMainForm" fieldname="RESOURCE_ID" width="60" editable="" visible="false"/>
           <ai:dbformfield formid="resourceChangeMainForm" fieldname="STATE" width="150" editable="" visible="false"/></td>
		<td class="td_font">申请人:</td>
		<td><ai:dbformfield formid="resourceChangeMainForm" fieldname="PRINCIPLE" width="150" editable="false" visible="false" />
			<ai:dbformfield formid="resourceChangeMainForm" fieldname="PROP_STAFF" width="150" editable="false" />
			<span class="font_red">*</span></td>
	</tr>
	<tr>
		<td class="td_font">申请单位:</td>
		<td><ai:dbformfield formid="resourceChangeMainForm" fieldname="ORG" width="130" editable="false" visible="false" />
			<ai:dbformfield formid="resourceChangeMainForm" fieldname="ORG_NAME" width="200" editable="false" />
			<span class="font_red">*</span>
		</td>
	</tr>
	<tr>
		<td class="td_font">申请说明及依据:</td>
		<td colspan="5"><ai:dbformfield formid="resourceChangeMainForm" fieldname="DESCRIPTION" height="60" width="700" />
		<span class="font_red">*</span></td>
	</tr>
	<tr>
		<td colspan="4" align="center"><ai:button text="保存主信息" id="query2" onclick="doWork('saveResourceChangeMainInfo()')" /></td>
	</tr>
</table>
</ai:dbform>
</ai:contractframe>

<div id = "saleResAllot_div">	
<ai:contractframe id="saleResAllotFFrame" contenttype="table"
	title="资源借调明细信息" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem />
	<ai:dbform formid="saleResAllotForm"
		setname="com.asiainfo.sale.activity.web.SETSaleResourceAllot"
		conditionname="condition" parametersname="parameters"
		editable="true" initial="false"
		datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleResourceSV"
		implservice_querymethod="getResourceAllot(String cityId)">
	<table width="98%" align="center" border="0" cellpadding="1"
		cellspacing="2">
		<tr>
			<td class="td_font">省终端补贴：<ai:dbformfield formid="saleResAllotForm" fieldname="P_TERM" width="150" editable="false"/>(万元)</td>
			<td class="td_font" align="left">地市终端补贴：<ai:dbformfield formid="saleResAllotForm" fieldname="L_TERM" width="150" editable="false"/>(万元)</td>
		</tr>
		<tr>
			<td class="td_font">省折扣折让：<ai:dbformfield formid="saleResAllotForm" fieldname="P_DISC" width="150" editable="false"/>(万元)</td>
			<td class="td_font" align="left">地市折扣折让：<ai:dbformfield formid="saleResAllotForm" fieldname="L_DISC" width="150" editable="false"/>(万元)</td>
		</tr>
		<tr>
			<td class="td_font">省促销积分：<ai:dbformfield formid="saleResAllotForm" fieldname="P_POINTS"width="150" editable="false"/>(万元)</td>
			<td class="td_font" align="left">地市促销积分：<ai:dbformfield formid="saleResAllotForm" fieldname="L_POINTS" width="150" editable="false"/>(万元)</td>
		</tr>
		<tr>
			<td class="td_font">省促销费：<ai:dbformfield formid="saleResAllotForm" fieldname="P_PROMT" width="150" editable="false"/>(万元)</td>
			<td class="td_font" align="left">地市促销费：<ai:dbformfield formid="saleResAllotForm" fieldname="L_PROMT" width="150" editable="false"/>(万元)</td>
		</tr>
		<tr><td colspan="4" align="center"><ai:button text="保存资源借调明细信息" onclick="doWork('saveResourceChangeDetailInfo()')" /></td></tr>
	</table>
	</ai:dbform>
</ai:contractframe>
</div>
		
<div id = "ResourceChangeDetail_div">		
<ai:contractframe id="ResourceChangeDetailFFrame" contenttype="table" title="资源借调明细信息" width="100%" allowcontract="true" frameclosed="false">
		<ai:contractitem/>
		<ai:dbform formid="ResourceChangeDetailForm" 
         setname="com.asiainfo.sale.activity.web.SETResourceChangeDetail"
         conditionname="condition" parametersname="parameters"
         editable="true" initial="false"
         datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
         implservice_name="com.asiainfo.sale.activity.service.interfaces.IResourceChangeDetailSV"
         implservice_querymethod="getResourceChangeDetailByID(int resourceId)">
    		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
    		<span style="font-family:华文中宋; color:red; text-align: center;">(资源借调只能由省资源向地市资源借调)</span>
          <tr>
         		<td class="td_font">借调终端补贴：</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="C_TERM" width="150" editable="false"/>(万元)</td>
          	<td class="td_font">省终端补贴：</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="P_TERM" width="150"/>(万元)</td>
          	<td class="td_font">地市终端补贴：</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="L_TERM" width="150"/>(万元)</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="RESOURCE_ID" width="150" visible="false"/></td>
          </tr>
          <tr>
         		<td class="td_font">借调折扣折让：</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="C_DISC" width="150"/>(万元)</td>
          	<td class="td_font">省折扣折让：</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="P_DISC" width="150"/>(万元)</td>
          	<td class="td_font">地市折扣折让：</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="L_DISC" width="150"/>(万元)</td>
          </tr>
          <tr>
         		<td class="td_font">借调促销积分：</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="C_POINTS" width="150"/>(万元)</td>
          	<td class="td_font">省促销积分：</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="P_POINTS" width="150"/>(万元)</td>
          	<td class="td_font">地市促销积分：</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="L_POINTS" width="150"/>(万元)</td>
          </tr>
          <tr>
         	    <td class="td_font">借调促销费：</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="C_PROMT" width="150"/>(万元)</td>
          	<td class="td_font">省促销费：</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="P_PROMT" width="150"/>(万元)</td>
          	<td class="td_font">地市促销费：</td>
          	<td><ai:dbformfield formid="ResourceChangeDetailForm" fieldname="L_PROMT" width="150"/>(万元)</td>
          </tr>
		</table>
		</ai:dbform>
</ai:contractframe>
<ai:loginuser />
</div>
<%--<%@include file="/sale/resource/include/_resChangeCreateWF.jsp"%>--%>
</body>
<script type="text/javascript">
var _orgId = g_GetUserInfo().ORG_ID;
var resourceId = "<%=request.getParameter("resourceId")%>";
</script>
<script type="text/javascript">
var resourceChangeMainForm = g_FormRowSetManager.get("resourceChangeMainForm");
var resourceChangeDetailForm = g_FormRowSetManager.get("ResourceChangeDetailForm");
var saleResAllotForm = g_FormRowSetManager.get("saleResAllotForm");

function initPage() {
	if('null'!=resourceId){
		document.getElementById("saleResAllot_div").style.display="none";
		resourceChangeMainForm.refresh("&ResourceId="+resourceId);
		resourceChangeDetailForm.refresh("&resourceId="+resourceId);
		var state =resourceChangeMainForm.getValue("STATE");
		//工单状态或者查询人员不是申请人员
		if(state != '1' || resourceChangeMainForm.getValue("PRINCIPLE") != g_GetUserInfo().STAFF_ID){
		resourceChangeMainForm.setEditSts("false");	
		var resourceDid=resourceChangeDetailForm.getValue("RESOURCE_ID");
		//变更明细已经存在
		if(resourceDid!=null){
		   resourceChangeDetailForm.setEditSts("false");	
		 }
		}else{
		document.getElementById("saleResAllot_div").style.display="none";
		var org = g_GetUserInfo().ORG_ID.substr(0, 2);
		if (org == '10') {
			org = '';
		}
		saleResAllotForm.refresh("cityId=" + org);
		showdetail();
	    
		}
		}
}

function showdetail(){
	    resourceChangeMainForm.setValue("PRINCIPLE",g_GetUserInfo().STAFF_ID);
	    resourceChangeMainForm.setValue("PROP_STAFF",g_GetUserInfo().STAFF_NAME);
	    resourceChangeMainForm.setValue("ORG",g_GetUserInfo().ORG_ID);
	    resourceChangeMainForm.setValue("ORG_NAME",g_GetUserInfo().ORG_NAME);
	    resourceChangeDetailForm.setValue("P_TERM",saleResAllotForm.getValue("P_TERM"));
	    resourceChangeDetailForm.setValue("L_TERM",saleResAllotForm.getValue("L_TERM"));
	    resourceChangeDetailForm.setValue("P_DISC",saleResAllotForm.getValue("P_DISC"));
	    resourceChangeDetailForm.setValue("L_DISC",saleResAllotForm.getValue("L_DISC"));
	    resourceChangeDetailForm.setValue("P_POINTS",saleResAllotForm.getValue("P_POINTS"));
	    resourceChangeDetailForm.setValue("L_POINTS",saleResAllotForm.getValue("L_POINTS"));
	    resourceChangeDetailForm.setValue("P_PROMT",saleResAllotForm.getValue("P_PROMT"));
	    resourceChangeDetailForm.setValue("L_PROMT",saleResAllotForm.getValue("L_PROMT"));
}

function doWork(fun) {
	beginAIWaitBanner(fun, "正在处理，请稍后...");
}

function saveResourceChangeMainInfo(){
var applyName=resourceChangeMainForm.getValue("APPLY_NAME");
 var mark=resourceChangeMainForm.getValue("DESCRIPTION"); 
 if(""==applyName || null==applyName){return  alert("请输入资源调用申请名称！");}
 if(""==mark){return  alert("请填写申请说明！");}
 
  if ("O" != resourceChangeMainForm.getSts()||resourceChangeMainForm.getSts()=="U")
 {
    var list = new Array();
    list.push(resourceChangeMainForm);
    var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.ResourceChangeAction?action=saveResourceChangeMainInfo';
    var recode = saveRowSet(strUrl, list);
    ResourceId = recode.getValueByName("ResourceId");
    if(ResourceId == null || ResourceId == '' || ResourceId == 'undefined'){
    	return alert("保存操作失败！");
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
