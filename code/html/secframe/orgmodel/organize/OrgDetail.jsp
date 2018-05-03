<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page import="com.ai.appframe2.service.ServiceFactory"%>
<%@ page import="com.ai.secframe.orgmodel.service.interfaces.ISecOrganizeSV"%>
<%@ page import="com.ai.secframe.orgmodel.ivalues.IBOSecOrganizeValue"%>
<html>
<head>
<title><i18n:message key="sec.organize.orginfo" res="i18n.secframe_resource"/></title>
</head>
<body>
<%
	String org_id = HttpUtil.getParameter(request, "org_id");
	long org_state = 0;
	if (null != org_id && (org_id.trim()).length()>0)
	{
	ISecOrganizeSV organizeSv = (ISecOrganizeSV) ServiceFactory.getService( ISecOrganizeSV.class );
    IBOSecOrganizeValue val = organizeSv.getSecOrganizeById( Long.valueOf(org_id).longValue() );
     org_state= val.getState();
    }
%>
<ai:dbform setname="com.ai.secframe.orgmodel.web.SETSecOrganize"
	formid="partyRoleOrg_form"
	datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
	implservice_name="com.ai.secframe.orgmodel.service.SecOrganize" 
	implservice_querymethod="querySecOrganize"
	initial="false"
	editable="false">
<ai:dbformfield fieldname="ORGANIZE_ID" formid="partyRoleOrg_form"
	width="150" visible="false" />
<ai:dbformfield fieldname="PARENT_ORGANIZE_ID"
	formid="partyRoleOrg_form" width="150" visible="false" />
<table width="100%" border=0 cellpadding=0 cellspacing=0>
  <tr>
    <td valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="1" >
        <tr>
          <td ><table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="40">&nbsp;&nbsp;<img src="../../images/circle.gif" width="12" height="12" /></td>
                <td> <i18n:message key="sec.organize.orgbaseinfo" res="i18n.secframe_resource"/></td>
                <td align="right"></td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td  align="left" valign="top">
		  
		  <table width="100%" border="0" cellpadding="0" cellspacing="0" height="400">
              <tr>
                <td width="140" align="left"><i18n:message key="sec.organize.name" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="ORGANIZE_NAME" formid="partyRoleOrg_form" width="150" />
                <span class=pr9>*</span></td>
                <td width="1"></td>
                <td width="140" align="left"><i18n:message key="sec.organize.code" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="CODE" formid="partyRoleOrg_form" width="150" />
                <span >*</span></td>
              </tr>
              <tr>
                <td width="140" height="1"></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td width="140" ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td width="140" align="left"><i18n:message key="sec.organize.englishname" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="ENGLISH_NAME" formid="partyRoleOrg_form" width="150" /></td>
                <td width="1"></td>
                <td width="140" align="left"><i18n:message key="sec.organize.shortname" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="SHORT_NAME" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td width="140" height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td width="140" ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td width="140" align="left"><i18n:message key="sec.organize.managername" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="MANAGER_NAME" formid="partyRoleOrg_form" width="150" /></td>
                <td width="1"></td>
                <td width="140" align="left"><i18n:message key="sec.organize.email" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="EMAIL" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td width="140" height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td width="140" ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td width="140" align="left"><i18n:message key="sec.organize.phoneid" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="PHONE_ID" formid="partyRoleOrg_form" width="150" /></td>
                <td width="1"></td>
                <td width="140" align="left"><i18n:message key="sec.organize.faxid" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="FAX_ID" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td width="140" height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td width="140" ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td width="140" align="left"><i18n:message key="sec.organize.contactname" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="CONTACT_NAME" formid="partyRoleOrg_form" width="150" /></td>
                <td width="1"></td>
                <td width="140" align="left"><i18n:message key="sec.organize.contactbillid" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="CONTACT_BILL_ID" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td width="140" height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td width="140" ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td width="140" align="left"><i18n:message key="sec.organize.contactcardtype" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="CONTACT_CARD_TYPE" formid="partyRoleOrg_form" width="150" /></td>
                <td width="1"></td>
                <td width="140" align="left"><i18n:message key="sec.organize.contactcardid" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="CONTACT_CARD_ID" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td width="140" height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td width="140" ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td width="140" align="left"><i18n:message key="sec.organize.districtid" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="DISTRICT_ID"  formid="partyRoleOrg_form" width="150" visible="true" /></td>
                <td width="1"></td>
                <td width="140" align="left"><i18n:message key="sec.organize.countryid" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="COUNTY_ID" formid="partyRoleOrg_form" width="150"  visible="true" />
                  <ai:button  text=".." id="selectDis" onclick="selectDis()"/></td>
              </tr>
              <tr>
                <td width="140" height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td width="140" ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td width="140" align="left"><i18n:message key="sec.organize.orgroletypeid" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield  fieldname="ORG_ROLE_TYPE_ID" formid="partyRoleOrg_form" width="150" visible="true" />
                  <ai:button  text=".." id="selectOrgType" onclick="selectOrgType()"/>
                </td>
                <td width="1"></td>
                <td width="140" align="left"><i18n:message key="sec.organize.numbernum" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="MEMBER_NUM" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td width="140" height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td width="140" ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td width="140" align="left"><i18n:message key="sec.organize.isleaf" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="IS_LEAF" formid="partyRoleOrg_form" width="150" /></td>
                <td width="1"></td>
              </tr>
              <tr>
                <td width="140" height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td width="140" ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td width="140" height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td width="140" ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td width="140"  align="left"><i18n:message key="sec.organize.orgaddress" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td  colspan="5"><ai:dbformfield fieldname="ORG_ADDRESS" formid="partyRoleOrg_form" width="400" />
                  </td>
              </tr>
              <tr>
                <td width="140" height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td width="140" ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td width="140" align="left"><i18n:message key="sec.organize.note" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td  colspan="5"><ai:dbformfield fieldname="NOTES" edittype="DBTextArea" formid="partyRoleOrg_form" width="400" /></td>
              </tr>
              <tr>
                <td width="140" height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td width="140" ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td width="140" align="left"><i18n:message key="sec.organize.postprovince" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="POST_PROVINCE" formid="partyRoleOrg_form" width="150" /></td>
                <td width="1"></td>
                <td width="140" align="left"><i18n:message key="sec.organize.postcity" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="POST_CITY" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td width="140" height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td width="140" ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td width="140" align="left"><i18n:message key="sec.organize.postcod" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="POST_POSTCOD" formid="partyRoleOrg_form" width="150" /></td>
                <td width="1"></td>
                <td width="140" align="left"><i18n:message key="sec.organize.postaddress" res="i18n.secframe_resource"/></td>
                <td width="1"></td>
                <td ><ai:dbformfield fieldname="POST_ADDRESS" formid="partyRoleOrg_form" width="150" />
                <ai:dbformfield fieldname="STATE" visible="false" formid="partyRoleOrg_form" width="150" /></td>
              </tr>
              <tr>
                <td height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
              <tr>
                <td height="1" ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td ></td>
                <td width="1"></td>
                <td ></td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td><div id="buttonDiv" align="center">
              <ai:button text="sec.organize.addbutton" i18nRes="i18n.secframe_resource" id="insertOrg" onclick="insertOrg()"/>
              &nbsp;
              <ai:button text="sec.organize.savebutton"  i18nRes="i18n.secframe_resource" id="saveOrg" onclick="saveOrg()"/>
              &nbsp;
              <ai:button text="sec.organize.delbutton" i18nRes="i18n.secframe_resource" id="deleteOrg" onclick="deleteOrg()"/>
              &nbsp;
              <ai:button text="sec.organize.dobutton" i18nRes="i18n.secframe_resource" id="undeleteOrg" onclick="undeleteOrg()"/>
            </div></td>
        </tr>
      </table></td>
  </tr>
</table>
</ai:dbform>
</body>
</html><script>
  	var org_id = "<%=org_id%>";
  	var org_state = "<%=org_state%>";
  	var partyRoleOrg_formRowSet = g_FormRowSetManager.get("partyRoleOrg_form");
  
	function refresh_Org_Form(org_id)
	{
     	if(org_id!=""){
     		partyRoleOrg_formRowSet.refresh("ORGANIZE_ID = "+org_id);
     		partyRoleOrg_formRowSet.setEditSts(true);
     		partyRoleOrg_formRowSet.setColEditSts("CODE",false);
     		partyRoleOrg_formRowSet.setColEditSts("ORG_ROLE_TYPE_ID",false);
     		partyRoleOrg_formRowSet.setColEditSts("DISTRICT_ID",false);
     		partyRoleOrg_formRowSet.setColEditSts("COUNTY_ID",false);  
     		var msg;
     		var result; 		
     		
			if(partyRoleOrg_formRowSet.getValue("ORG_ROLE_TYPE_ID")!=''){ 
				msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOrganizeAction?"+
					"action=getRoleTypeInfo&role_type_id="+partyRoleOrg_formRowSet.getValue("ORG_ROLE_TYPE_ID"));
				result = msg.getValueByName("retVal"); 
	     		partyRoleOrg_formRowSet.setValue("ORG_ROLE_TYPE_ID",result); 
	     	}
	     	if(partyRoleOrg_formRowSet.getValue("COUNTY_ID")!=''){ 
				msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOrganizeAction?"+
					"action=getDisInfo&dis_id="+partyRoleOrg_formRowSet.getValue("COUNTY_ID"));
				result = msg.getValueByName("retVal"); 
				partyRoleOrg_formRowSet.setValue("COUNTY_ID",result);			
			}
			if(partyRoleOrg_formRowSet.getValue("DISTRICT_ID")!=''){   		
	     		msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.orgmodel.web.SecOrganizeAction?"+
					"action=getDisInfo&dis_id="+partyRoleOrg_formRowSet.getValue("DISTRICT_ID"));
				result = msg.getValueByName("retVal"); 
				partyRoleOrg_formRowSet.setValue("DISTRICT_ID",result);
			}
	     	document.getElementById("selectDis").disabled = org_state==0?true:false;
			document.getElementById("selectOrgType").disabled = org_state==0?true:false;
			document.getElementById("insertOrg").disabled = org_state==0?true:false;
			document.getElementById("saveOrg").disabled = org_state==0?true:false;
			document.getElementById("deleteOrg").disabled = org_state==0?true:false;  	
			//document.getElementById("undeleteOrg").disabled = org_state==0?false:true;  	
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
	
	function selectOrgType(){
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
		partyRoleOrg_formRowSet.setColEditSts("CODE",false);
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
				 partyRoleOrg_formRowSet.setValue("CODE",result);
			}	
		}
			document.getElementById("insertOrg").disabled = true;
			document.getElementById("saveOrg").disabled = false;
			document.getElementById("deleteOrg").disabled = true;
	}

	function saveOrg(){	
	
		if( partyRoleOrg_formRowSet.getValue("ORGANIZE_NAME")==null ||
		    partyRoleOrg_formRowSet.getValue("ORGANIZE_NAME") =="" ){
			//alert('请输入组织名称!');
			alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_inputorgname"));
			partyRoleOrg_formRowSet.setFocus("ORGANIZE_NAME");
			rturn;
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
		  parent.refreshCurNode();
		  var org_id=msg.getValueByName("org_id");
		  
		  var org_name=partyRoleOrg_formRowSet.getValue("ORGANIZE_NAME");
		  if(!isNaN(org_id))
		  refresh_Org_Form(org_id);
		  parent.refreshParentTreeNode(org_id,org_name);
		}else{
		  //alert("操作失败:"+msg.getValueByName("errorMsg"));
		  alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_error")+msg.getValueByName("errorMsg"));
		}

	}



	//删除
	function deleteOrg(){	
	if(partyRoleOrg_formRowSet.getValue("STATE")==0){
		//alert("只能删除有效的组织");
		alert(g_I18NMessage("secframe_orgdetail", "secframe_orgdetail_onlydelorg"));
		return;
	}	
		parent.delOrgByRoleId(org_id);
		window.location.reload();
		
		
	}

	function undeleteOrg(){
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
			var org_name=partyRoleOrg_formRowSet.getValue("ORGANIZE_NAME");
		  if(!isNaN(org_id))
		  refresh_Org_Form(org_id);
		  parent.refreshParentTreeNode(org_id,org_name);
			window.location.reload();
		}
	}

</script>
