<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<HTML>
<head>
<title><i18n:message key="sec.organize.orgmgr" res="i18n.secframe_resource"/></title>

</head>
<body onLoad="doResize()" onResize="doResize()">
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
  <tr>
     <td width="290" valign="top">
          <ai:contractframe id="" contenttype="table" title="sec.organize.orgchioc" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
              <ai:contractitem>
  					<div class="t-bot-mc-button">
					           <ai:button id="byorgbtn" text="sec.operator.query.org" i18nRes="i18n.secframe_resource" onclick="QueryByOrg()" enable="false" />
							   <ai:button id="bycondbtn" text="sec.operator.query.condition" i18nRes="i18n.secframe_resource" onclick="QueryByCond()"/>
  					</div>
  				</ai:contractitem>
  				<div id="bycond" style="display: none; height:500px;">
								<table width="100%" align="center" border="0" cellpadding="1" cellspacing="2">
					                      <tr>
					                        <td class="td_font"><i18n:message key="sec.org.name" res="i18n.secframe_resource"/>：</td>
					                        <td>
					                        	<input value="" type="text" id="name" style="width:130"/>
					                        </td>
					                      </tr>
					             </table>
					                    <div class="area_button">
											<ai:button text="sec.query" i18nRes="i18n.secframe_resource" id="searchOrgBtn" onclick="searchOrganize()"/>
										</div>
										<div>
						
								<ai:table tableid="dbTableOrg"
							setname="com.ai.secframe.orgmodel.web.SETSecOrganize"
							initial="false" multiselect="false" editable="false"
							tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
							parametersname="com.ai.secframe.orgmodel.web.SecOrganizeAction"
							onrowchange="selectOrganize" pagesize="10"
							width="280" height="250" needrefresh="true" footdisplay="true">
			
                   <ai:col fieldname="ORGANIZE_ID"  width="110" visible="true"/>
                   <ai:col fieldname="ORGANIZE_NAME" width="170" visible="true"/>
                
                   	    </ai:table>
										
										</div>
										
							</div>
							<div id="byorg">
							<table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
              					<ai:dbtree_new id="orgTree" datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel" 
									multiselect="false" height="500" width="100%" ishaveline="true" 
									onselect="treeNodeClick"/>
								</td>
							</tr>
						</table>
            				</div>
            				</ai:contractframe>
                 </td>
    <td valign="top" align="right">
    
                   	   
                  
					  <ai:contractframe id="" contenttype="table" title="sec.organize.orgbaseinfo" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
			  <ai:contractitem/>					
      <ai:dbform setname="com.ai.secframe.orgmodel.web.SETSecOrganize"
	     formid="partyRoleOrg_form"
	     datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
	     implservice_name="com.ai.secframe.orgmodel.service.interfaces.ISecOrganizeSV" 
	     implservice_querymethod="querySecOrganize"
	     initial="false"
	     editable="false">
        <ai:dbformfield fieldname="PARENT_ORGANIZE_ID" formid="partyRoleOrg_form" width="150" visible="false" />
		  
		
		  <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.name" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="ORGANIZE_NAME" formid="partyRoleOrg_form" width="150" /><span class="font_red">*</span></td>
                <td class="td_font"><i18n:message key="sec.organize.id" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="ORGANIZE_ID" formid="partyRoleOrg_form" width="150" /></td>              
              </tr>
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.englishname" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="ENGLISH_NAME" formid="partyRoleOrg_form" width="150" /></td>
                <td class="td_font"><i18n:message key="sec.organize.shortname" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="SHORT_NAME" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.managername" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="MANAGER_NAME" formid="partyRoleOrg_form" width="150" /></td>
                <td class="td_font"><i18n:message key="sec.organize.email" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="EMAIL" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.phoneid" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="PHONE_ID" formid="partyRoleOrg_form" width="150" /></td>
                <td class="td_font"><i18n:message key="sec.organize.faxid" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="FAX_ID" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.contactname" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="CONTACT_NAME" formid="partyRoleOrg_form" width="150" /></td>
                <td class="td_font"><i18n:message key="sec.organize.contactbillid" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="CONTACT_BILL_ID" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.contactcardtype" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="CONTACT_CARD_TYPE" formid="partyRoleOrg_form" width="150" /></td>
                <td class="td_font"><i18n:message key="sec.organize.contactcardid" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="CONTACT_CARD_ID" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.districtid" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="DISTRICT_ID"  formid="partyRoleOrg_form" width="150" visible="true" /><span class="font_red">*</span></td>
                <td class="td_font"><i18n:message key="sec.organize.countryid" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="COUNTY_ID" formid="partyRoleOrg_form" width="130"  visible="true" /><img id="selectDis" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="" onClick="selectDis();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>              
              </tr>
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.orgroletypeid" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield  fieldname="ORG_ROLE_TYPE_ID" formid="partyRoleOrg_form" width="130" visible="true" /><img id="selectOrgType" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="" onClick="selectOrgType();" align="absmiddle" style="cursor:hand;"/></td>
                <td class="td_font"><i18n:message key="sec.organize.numbernum" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="MEMBER_NUM" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.postprovince" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="POST_PROVINCE" formid="partyRoleOrg_form" width="150" /></td>
                <td class="td_font"><i18n:message key="sec.organize.postcity" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="POST_CITY" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.postcod" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="POST_POSTCOD" formid="partyRoleOrg_form" width="150" /></td>
                <td class="td_font"><i18n:message key="sec.organize.postaddress" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="POST_ADDRESS" formid="partyRoleOrg_form" width="150" />
                <ai:dbformfield fieldname="STATE" visible="false" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.isleaf" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield fieldname="IS_LEAF" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.orgaddress" res="i18n.secframe_resource"/></td>
                <td colspan="3"><ai:dbformfield fieldname="ORG_ADDRESS" formid="partyRoleOrg_form" width="410" />
                  </td>
              </tr>
              <tr>
                <td class="td_font"><i18n:message key="sec.organize.note" res="i18n.secframe_resource"/></td>
                <td colspan="3"><ai:dbformfield fieldname="NOTES" edittype="DBTextArea" formid="partyRoleOrg_form" width="410" /></td>
              </tr>
            </table>
           
            
           </ai:dbform>
            </ai:contractframe>
           	
           <div id="buttonDiv" class="area_button">
              <ai:button text="sec.organize.addbutton" i18nRes="i18n.secframe_resource" id="insertOrg" onclick="insertOrg()"/>
              &nbsp;
              <ai:button text="sec.organize.savebutton"  i18nRes="i18n.secframe_resource" id="saveOrg" onclick="saveOrg()"/>
              &nbsp;
              <ai:button text="sec.organize.delbutton" i18nRes="i18n.secframe_resource" id="deleteOrg" onclick="deleteOrg()"/>
              &nbsp;
              <ai:button text="sec.organize.dobutton" i18nRes="i18n.secframe_resource" id="undeleteOrg" onclick="undeleteOrg()"/>
            </div>
            </td>
  </tr>
</table>
</body>


<script type="text/javascript">
var org_id =""; //当前节点的组织ID
var organizeName = "";	 //当前组织的名称	
var partyRoleOrg_formRowSet = g_FormRowSetManager.get("partyRoleOrg_form");
var dbTree = g_DBTreeNewManager.get("orgTree");


	
//根据partyRoleId删除组织
function delOrgByRoleId(roleId)
{		
	if(dbTree.hasChildNode(roleId)){
		//alert('对不起，该组织存在下属组织，不能删除!');
		alert(g_I18NMessage("secframe_orglist", "secframe_orglist_delerror"));
		return;
	}		
	var org_name = dbTree.getNodeInfo(roleId).text;		
	//if(!confirm("确实要删除 '"+ org_name + "' 吗？"))return;
	if(!confirm(g_I18NMessage("secframe_orglist", "secframe_orglis_confirmdel")+ org_name + g_I18NMessage("secframe_orglist", "secframe_orglist_what")))return;
	var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOrganizeAction?"+
		"action=deleteOrganize&org_id="+roleId);
     
   	var result = msg.getValueByName('MESSAGE');
	if(result=='1'){
 			//alert('删除成功！');
 			alert(g_I18NMessage("secframe_orglist", "secframe_orglist_delsucc"));
		var parent_value = dbTree.getParentNodeInfo(roleId).value;
		dbTree.refresh(parent_value ,1);
		dbTree.setNodeSelect(parent_value);
	}else if(result=='-1'){
		//alert('删除失败!');
		alert(g_I18NMessage("secframe_orglist", "secframe_orglist_delfailed"));
	}else {
    		alert(result);
   	}
}

//右键菜单刷新
function refreshOrg()
{
	dbTree.refresh(org_id ,1);
}

//刷新树的某个节点
function refreshTreeNode(organizeId)
{
	dbTree.refresh(org_id ,1);
}
//刷新当前树节点
function refreshCurNode()
{
 dbTree.refresh(org_id ,1);
}

//刷新树的某个节点的父节点
function refreshParentTreeNode(org_id,org_name){
    
    var objCurParNode=dbTree.getParentNodeInfo(org_id);
    //alert(org_id);
    if(objCurParNode!=null&&objCurParNode.value>0)
    {
	 var parent_value = objCurParNode.value;		 
	 dbTree.refresh(parent_value ,1);
	}
	if(objCurParNode.value==-1)
	  dbTree.setCurNodeInfo(org_id,org_name,org_id);
}


//点击参与人显示该参与所包含的操作员
function treeNodeClick(treeVal,treeText,treeUserObj,treeNodeType){
    org_id = treeVal;
	organizeName = treeText;
	refresh_Org_Form(org_id);
}

//调整控件大小以适应窗口
function doResize()
{
	var width = document.body.offsetWidth;
	var height = document.body.offsetHeight;
}

function refresh_Org_Form(org_id)
{
    var org_state="";
    var orgState="";   
    orgState= PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOrganizeAction?"+
			"action=getOrgState&orgId="+org_id);
    org_state = orgState.getValueByName("retVal"); 
    if(org_id!="")
    {
   		partyRoleOrg_formRowSet.refresh("ORGANIZE_ID = "+org_id);
   		partyRoleOrg_formRowSet.setEditSts(true);
   		partyRoleOrg_formRowSet.setColEditSts("ORGANIZE_ID",false);
   		partyRoleOrg_formRowSet.setColEditSts("ORG_ROLE_TYPE_ID",false);
   		partyRoleOrg_formRowSet.setColEditSts("DISTRICT_ID",false);
   		partyRoleOrg_formRowSet.setColEditSts("COUNTY_ID",false);  
   		var msg;
   		var result; 		
    		
		if(partyRoleOrg_formRowSet.getValue("ORG_ROLE_TYPE_ID")!='')
		{ 
			msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOrganizeAction?"+
			"action=getRoleTypeInfo&role_type_id="+partyRoleOrg_formRowSet.getValue("ORG_ROLE_TYPE_ID"));
		    result = msg.getValueByName("retVal"); 
    		partyRoleOrg_formRowSet.setValue("ORG_ROLE_TYPE_ID",result); 
    	}
    	if(partyRoleOrg_formRowSet.getValue("COUNTY_ID")!='')
    	{ 
		msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOrganizeAction?"+
			"action=getDisInfo&dis_id="+partyRoleOrg_formRowSet.getValue("COUNTY_ID"));
		result = msg.getValueByName("retVal"); 
		partyRoleOrg_formRowSet.setValue("COUNTY_ID",result);			
	}
	if(partyRoleOrg_formRowSet.getValue("DISTRICT_ID")!='')
	{   		
    		msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOrganizeAction?"+
				"action=getDisInfo&dis_id="+partyRoleOrg_formRowSet.getValue("DISTRICT_ID"));
			result = msg.getValueByName("retVal"); 
			partyRoleOrg_formRowSet.setValue("DISTRICT_ID",result);
	}
     	document.getElementById("selectDis").disabled = org_state==2?true:false;
		document.getElementById("selectOrgType").disabled = org_state==2?true:false;
		document.getElementById("insertOrg").disabled = org_state==2?true:false;
		document.getElementById("saveOrg").disabled = org_state==2?true:false;
		document.getElementById("deleteOrg").disabled = org_state==2?true:false;  	
		document.getElementById("undeleteOrg").disabled = org_state==2?false:true;  	
	} else {
		document.getElementById("selectDis").disabled = true;
		document.getElementById("selectOrgType").disabled = true;
		document.getElementById("insertOrg").disabled = true;
		document.getElementById("saveOrg").disabled = true;
		document.getElementById("deleteOrg").disabled = true;
		document.getElementById("undeleteOrg").disabled = true;
	}
}
refresh_Org_Form(org_id);

function selectOrgType()
{
	var result = window.showModalDialog("OrgTypeTree.jsp","org","scroll:no;resizable:no;status:no;dialogHeight:460px;dialogWidth:300px");
	if(result=='undefined'||result==null){
		result="";
	} else {
		partyRoleOrg_formRowSet.setValue("ORG_ROLE_TYPE_ID",result);	
	}
}

function selectDis(){
	var result = window.showModalDialog("<%=request.getContextPath()%>/secframe/orgmodel/organize/DistrictSelectDialog.jsp","org","scroll:no;resizable:no;status:no;dialogHeight:460px;dialogWidth:300px");
	if(result=='undefined'||result==null){
		result="";
	}else {
		result = result.split('&');
		partyRoleOrg_formRowSet.setValue("DISTRICT_ID",result[0]);	 
		partyRoleOrg_formRowSet.setValue("COUNTY_ID",result[1]);	 
	}
}

function insertOrg(){
	if(org_id==''){
		//alert('请选择一个所属的上级组织!');
		alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_selfarorg"));
		return;
	}		
	partyRoleOrg_formRowSet.refresh("ORGANIZE_ID = -1");
	partyRoleOrg_formRowSet.setValue("PARENT_ORGANIZE_ID",org_id);
	partyRoleOrg_formRowSet.setEditSts(true);
	partyRoleOrg_formRowSet.setColEditSts("ORGANIZE_ID",false);
	partyRoleOrg_formRowSet.setColEditSts("ORG_ROLE_TYPE_ID",false);
	partyRoleOrg_formRowSet.setColEditSts("DISTRICT_ID",false);
	partyRoleOrg_formRowSet.setColEditSts("COUNTY_ID",false);  
	if(org_id!=""&&org_id!=null){
		var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOrganizeAction?"+
			"action=getOrganizeCodeByJsp&org_id="+org_id);
		var result = msg.getValueByName("retVal"); 
		if(result=="-1"){
			//alert("获取regCode失败！");
			alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_catchcodeerror"));
		}else if(result=="-5"){
			 alert(msg.getValueByName("errorMsg"));
		}
		else{
			 partyRoleOrg_formRowSet.setValue("ORGANIZE_ID",result);
		}	
	}
		document.getElementById("insertOrg").disabled = true;
		document.getElementById("saveOrg").disabled = false;
		document.getElementById("deleteOrg").disabled = true;
}

function saveOrg(){	
	var orgName = partyRoleOrg_formRowSet.getValue("ORGANIZE_NAME");
	orgName = g_StringTrim(orgName);
	if( orgName==null || orgName =="" ){
		//alert('请输入组织名称!');
		alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_inputorgname"));
		partyRoleOrg_formRowSet.setFocus("ORGANIZE_NAME");
		return;
	}
	if( partyRoleOrg_formRowSet.getValue("COUNTY_ID")==null ||
	    partyRoleOrg_formRowSet.getValue("COUNTY_ID") =="" ){
		//alert('请输入区县!');
		alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_inputcountryid"));
		partyRoleOrg_formRowSet.setFocus("COUNTY_ID");
		//return;
	}
	
	
	
    if(partyRoleOrg_formRowSet.getValue("EMAIL")!=null
    	&& partyRoleOrg_formRowSet.getValue("EMAIL")!=""
    	&& !g_IsEmail(partyRoleOrg_formRowSet.getValue("EMAIL"))){
    	//alert("请输入正确的Email格式，形如:test@test.com");
    	alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_email"));
    	partyRoleOrg_formRowSet.setFocus("EMAIL");
    	return;
    }
    if(partyRoleOrg_formRowSet.getValue("PHONE_ID")!=null
    	&& partyRoleOrg_formRowSet.getValue("PHONE_ID")!=""
    	&& !g_IsTeleNumber(partyRoleOrg_formRowSet.getValue("PHONE_ID"))){
    	//alert("请输入正确的普通电话格式，形如:+86-021-12345678");
    	alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_phone"));
    	partyRoleOrg_formRowSet.setFocus("PHONE_ID");
    	return;
    }
    if(partyRoleOrg_formRowSet.getValue("FAX_ID")!=null
    	&& partyRoleOrg_formRowSet.getValue("FAX_ID")!=""
    	&& !g_IsTeleNumber(partyRoleOrg_formRowSet.getValue("FAX_ID"))){
    	//alert("请输入正确的传真格式，形如:+86-021-12345678");
    	alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_fax"));
    	partyRoleOrg_formRowSet.setFocus("FAX_ID");
    	return;
    }
    if(partyRoleOrg_formRowSet.getValue("CONTACT_BILL_ID")!=null
    	&& partyRoleOrg_formRowSet.getValue("CONTACT_BILL_ID")!=""
    	&& !g_IsMobileNumber(partyRoleOrg_formRowSet.getValue("CONTACT_BILL_ID"))){
    	//alert("请输入正确的手机号码格式，形如:13900000000");
    	alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_tel"));
    	partyRoleOrg_formRowSet.setFocus("CONTACT_BILL_ID");
    	return;
    }
    if(partyRoleOrg_formRowSet.getValue("CONTACT_CARD_TYPE")!=null
    	&& partyRoleOrg_formRowSet.getValue("CONTACT_CARD_TYPE")!=""){
    	if(partyRoleOrg_formRowSet.getValue("CONTACT_CARD_ID")==null
    		|| partyRoleOrg_formRowSet.getValue("CONTACT_CARD_ID")==""){
    		//alert("请填入正确的联系人证件号码");
    		alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_cardtype"));
    		partyRoleOrg_formRowSet.setFocus("CONTACT_CARD_ID");
    		return;
    	}
      //判断身份证号码
    	if(partyRoleOrg_formRowSet.getValue("CONTACT_CARD_TYPE")=="1"){
        var card_id = partyRoleOrg_formRowSet.getValue("CONTACT_CARD_ID");

        if(!g_IDCardNumber(card_id)){
      		//alert("请输入15位或者18位的身份证号码");
      		alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_cardid"));
      		partyRoleOrg_formRowSet.setFocus("CONTACT_CARD_ID");
      		return;
        }
    	}
    }

    //判断是否修改
    if(partyRoleOrg_formRowSet.toXmlString(true)==""){
			//alert('当前的数据尚未被修改，不需要保存！');
			alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_nochange"));
			return;
	}
	
   
    	if(partyRoleOrg_formRowSet.getValue("DISTRICT_ID")!=''){
    		partyRoleOrg_formRowSet.setValue("DISTRICT_ID",partyRoleOrg_formRowSet.getValue("DISTRICT_ID").split('|')[0]);
    	}
    	if(partyRoleOrg_formRowSet.getValue("COUNTY_ID")!=''){
    		partyRoleOrg_formRowSet.setValue("COUNTY_ID",partyRoleOrg_formRowSet.getValue("COUNTY_ID").split('|')[0]);
    	}
    	if(partyRoleOrg_formRowSet.getValue("ORG_ROLE_TYPE_ID")!=''){
    		partyRoleOrg_formRowSet.setValue("ORG_ROLE_TYPE_ID",partyRoleOrg_formRowSet.getValue("ORG_ROLE_TYPE_ID").split('|')[0]);
    	}
 
   
    var list = new Array();	
    list.push(partyRoleOrg_formRowSet);	

    var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOrganizeAction?action=saveSecOrganize&org_id="+org_id
    ,list,false ,false);
    var ret = msg.getValueByName("retVal");
 	if( ret == 0 )
	{
	  //alert("组织更新成功!");
	  alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_uodatesucc"));
	  refreshCurNode();
	  var org_id=msg.getValueByName("org_id");
	  
	  var org_name=partyRoleOrg_formRowSet.getValue("ORGANIZE_NAME");
	  if(!isNaN(org_id))
	  refresh_Org_Form(org_id);
	  refreshParentTreeNode(org_id,org_name);
	}else{
	  //alert("操作失败:"+msg.getValueByName("errorMsg"));
	  alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_error")+msg.getValueByName("errorMsg"));
	}

}

//删除
function deleteOrg(){	
	return;
if(partyRoleOrg_formRowSet.getValue("STATE")==0){
	//alert("只能删除有效的组织");
	alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_onlydelorg"));
	return;
}	
	delOrgByRoleId(org_id);	
}

function undeleteOrg()
{
	var formRowSet = g_FormRowSetManager.get("partyRoleOrg_form");
	if(formRowSet.getValue("STATE")==1)
	{
		//alert("只能启用失效的组织");
		alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_onlydoorg"));
		return;
	}

	formRowSet.setValue("STATE",1);
	
	if(partyRoleOrg_formRowSet.getValue("DISTRICT_ID")!=''){
	    		partyRoleOrg_formRowSet.setValue("DISTRICT_ID",partyRoleOrg_formRowSet.getValue("DISTRICT_ID").split('|')[0]);
	    	}
	    	if(partyRoleOrg_formRowSet.getValue("COUNTY_ID")!=''){
	    		partyRoleOrg_formRowSet.setValue("COUNTY_ID",partyRoleOrg_formRowSet.getValue("COUNTY_ID").split('|')[0]);
	    	}
	    	if(partyRoleOrg_formRowSet.getValue("ORG_ROLE_TYPE_ID")!=''){
	    		partyRoleOrg_formRowSet.setValue("ORG_ROLE_TYPE_ID",partyRoleOrg_formRowSet.getValue("ORG_ROLE_TYPE_ID").split('|')[0]);
	    	}
	var list = new Array();	
	list.push(formRowSet);	
		
	var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOrganizeAction?action=saveSecOrganize&org_id="+
	org_id,list,true);
	var ret = msg.getValueByName("retVal");
	if( ret == 0 )
	{
		//alert("启用成功");
		alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_dosucc"));
		refreshCurNode();
		var org_name=partyRoleOrg_formRowSet.getValue("ORGANIZE_NAME");
	    if(!isNaN(org_id))
	    refresh_Org_Form(org_id);
	    refreshParentTreeNode(org_id,org_name);
	}
}	

function getDBTableOrg()
	{
		return g_TableRowSetManager.get("dbTableOrg");
	}

function searchOrganize(){
		
		var dbTableOrg = getDBTableOrg(); 
		var name =g_StringTrim(document.getElementById("name").value);
		
		if(name==null||name==""){
			alert(g_I18NMessage("secframe_common", "condition_empty"));
			return;
		}
		var nameCond = "";
		var flag = false;
		if(name != null && name != "")
		{
			name = encodeURI(name); 
			name = encodeURI(name);
			nameCond = "name="+name;
		}
		
	
		dbTableOrg.refresh("refresh",nameCond);		
	}
	
function QueryByOrg()
	{
		document.getElementById("byorg").style.display="block";
		document.getElementById("bycond").style.display="none";
		g_AIButtonManager.get("byorgbtn").setDisabled(true);
		g_AIButtonManager.get("bycondbtn").setDisabled(false);
	}

function QueryByCond()
	{
		document.getElementById("byorg").style.display="none";
		document.getElementById("bycond").style.display="block";
		g_AIButtonManager.get("byorgbtn").setDisabled(false);
		g_AIButtonManager.get("bycondbtn").setDisabled(true);
	}
function selectOrganize()
	{
	    var dbTableOrg = getDBTableOrg();
		var orgId = dbTableOrg.getValue(dbTableOrg.getRow(),"ORGANIZE_ID");
		refresh_Org_Form(orgId);
	}
	 

</script>

</html>
