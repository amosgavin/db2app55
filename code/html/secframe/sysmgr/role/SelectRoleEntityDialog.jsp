<%@ page contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<title></title>
	</head>
<body onLoad="loadRoleEntityDetail();">
			<ai:dbform formid="roleEntityForm"
					setname="com.ai.secframe.sysmgr.web.SETQSecRoleEntity"
					datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecRoleSV"
					implservice_querymethod="querySecRole"
					initial="false" editable="false">
					<ai:dbformfield formid="roleEntityForm" fieldname="ENT_CLASS_ID" visible="false" />
					<ai:dbformfield formid="roleEntityForm" fieldname="PRIV_ID" visible="false" />
					<ai:dbformfield formid="roleEntityForm" fieldname="ROLE_ID"  visible="false" />
		            <ai:contractframe id="" contenttype="table" title="sec.roleentity.selectentityclass" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
			            <ai:contractitem/>		
			         <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
		              <tr>
					    <td class="td_font"><i18n:message key="sec.roleentity.selectentityclass" res="i18n.secframe_resource"/></td>
		                <td><ai:dbformfield formid="roleEntityForm" fieldname="NAME" width="150" height="20" editable="true" visible="true" /><img id="selectEntClassBtn" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="" onClick="selectEntityClass();" align="absmiddle" style="cursor:hand;"/></td>
						 </tr>
		            </table>
		            </ai:contractframe> 
		            </ai:dbform>
		            
					<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
				         <tr>
				           <td width="45%" valign="top">
			                <ai:contractframe id="" contenttype="table" title="sec.roleentity.noentity" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
			                 <ai:contractitem/>
							   <ai:table setname="com.ai.secframe.sysmgr.web.SETQSecPrivEntityByEntityClass" tableid="NotContainRoleEntity"
									 tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
									 parametersname="com.ai.secframe.sysmgr.web.SecRoleAction" pagesize="5"
									 initial = "false" multiselect = "true" ondbclick=""
									 height="120" width="100%" needrefresh="true" editable="false">
						 		<ai:col fieldname="ENT_ID"  visible="false"/>
						 		<ai:col fieldname="NAME"  visible="true" width="34%"/>
								<ai:col fieldname="ENT_NAME"  visible="true" width="33%"/>
								<ai:col fieldname="PRIV_ID"  visible="false"/>
								<ai:col fieldname="PRIV_NAME"  visible="true" width="33%"/>
								<ai:col fieldname="FLAG"  visible="false"/>
						 	</ai:table>
						 	</ai:contractframe>
						 </td>
                        <td align=center width="2%">	
						<img id="remove" border="0" src="<%=request.getContextPath()%>/webframe/images/icon/left.gif"  alt="" onClick="remove()" align="absmiddle" style="cursor:hand;"/>
                        <br>
                        <br>
		                  <img id="add" border="0" src="<%=request.getContextPath()%>/webframe/images/icon/right.gif"  alt="" onClick="add()" align="absmiddle" style="cursor:hand;"/>
                        </td>
              		  <td width="45%" valign="top">
                          <ai:contractframe id="" contenttype="table" title="sec.roleentity.containentity" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
                 			<ai:contractitem/>
		               			<ai:table setname="com.ai.secframe.sysmgr.web.SETQSecPrivEntityByRole" tableid="ContainRoleEntity"
									 tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
									 parametersname="com.ai.secframe.sysmgr.web.SecRoleAction" pagesize="5"
									 initial = "false" multiselect = "true" ondbclick=""
									 height="120" width="100%" needrefresh="true" editable="false">
						 		<ai:col fieldname="ENT_ID"  visible="false"/>
						 		<ai:col fieldname="NAME"  visible="true" width="34%"/>
								<ai:col fieldname="ENT_NAME"  visible="true" width="33%"/>
								<ai:col fieldname="PRIV_ID"  visible="false"/>
								<ai:col fieldname="PRIV_NAME"  visible="true" width="33%"/>
								<ai:col fieldname="FLAG"  visible="false"/>
						 	</ai:table>
						 	</ai:contractframe>
					  </td>
		              </tr>
		            </table>
		            <div class="area_button">
						<ai:button id="doBtn" text="sec.roleentity.do" i18nRes="i18n.secframe_resource" onclick="save()"/>
						<ai:button id="doBtn" text="sec.roleentity.cancel" i18nRes="i18n.secframe_resource" onclick="cancel()"/>
					</div>
	</body>
</html>
<script type="text/javascript">
var selEntityClassId = "";
var selRoleId ="";
var roleEntityForm = g_FormRowSetManager.get("roleEntityForm");
var NotContainRoleEntity = g_TableRowSetManager.get("NotContainRoleEntity");	
var ContainRoleEntity = g_TableRowSetManager.get("ContainRoleEntity");

function loadRoleEntityDetail()
{
   selRoleId=window.dialogArguments;
}

function selectEntityClass()
{
    var result = window.showModalDialog("<%=request.getContextPath()%>/secframe/sysmgr/entity/SelectEntityClassDialog.jsp","","scroll:no;resizable:no;status:no;dialogHeight:475px;dialogWidth:430px");
	if(result=='undefined'||result==null){
			result="";
		}else {
			result = result.split('|');
			roleEntityForm.setValue("ENT_CLASS_ID",result[0]);	 
			roleEntityForm.setValue("NAME",result[1]);	
			selEntityClassId = result[0];
		}
   	
   NotContainRoleEntity.refresh("refreshPrivEntityByEntityClass","roleId="+selRoleId+"&entClassId="+selEntityClassId);
   ContainRoleEntity.refresh("refreshPrivEntityByRole","roleId="+selRoleId+"&entClassId="+selEntityClassId);
}

function add()
{
    if( NotContainRoleEntity.getSelectedRows()!=null&&NotContainRoleEntity.getSelectedRows().length>0)
    {
	 		var selRows = NotContainRoleEntity.getSelectedRows();
	  		for(var i=0;i<selRows.length;i++)
	  		{
		  		ContainRoleEntity.newRow(false);
				ContainRoleEntity.setValue(ContainRoleEntity.getRow(),"ENT_ID",NotContainRoleEntity.getValue(selRows[i],"ENT_ID"),NotContainRoleEntity.getValue(selRows[i],"ENT_ID"));
				ContainRoleEntity.setValue(ContainRoleEntity.getRow(),"ENT_NAME",NotContainRoleEntity.getValue(selRows[i],"ENT_NAME"),NotContainRoleEntity.getValue(selRows[i],"ENT_NAME"));
				ContainRoleEntity.setValue(ContainRoleEntity.getRow(),"PRIV_ID",NotContainRoleEntity.getValue(selRows[i],"PRIV_ID"),NotContainRoleEntity.getValue(selRows[i],"PRIV_ID"));
				ContainRoleEntity.setValue(ContainRoleEntity.getRow(),"PRIV_NAME",NotContainRoleEntity.getValue(selRows[i],"PRIV_NAME"),NotContainRoleEntity.getValue(selRows[i],"PRIV_NAME"));
				ContainRoleEntity.setValue(ContainRoleEntity.getRow(),"NAME",NotContainRoleEntity.getValue(selRows[i],"NAME"),NotContainRoleEntity.getValue(selRows[i],"NAME"));
				ContainRoleEntity.setValue(ContainRoleEntity.getRow(),"FLAG",NotContainRoleEntity.getValue(selRows[i],"FLAG"),NotContainRoleEntity.getValue(selRows[i],"FLAG"));
	  		}
	  		for(var i=0;i < NotContainRoleEntity.count();i++)
	  		{
			    if(NotContainRoleEntity.isSelected(i))
			    {
				    NotContainRoleEntity.deleteRow(i);
				    i--;
				}
         	}
	  		
	 }
	 else
	 {
	  //alert("请选择要添加的实体权限！");
	  alert(g_I18NMessage("secframe_role_entity" , "sec_role_entity_seladdentity"));
	 }
   
}

function remove()
{

    if( ContainRoleEntity.getSelectedRows()!=null&&ContainRoleEntity.getSelectedRows().length>0)
    {
	 		var selRows = ContainRoleEntity.getSelectedRows();
	  		for(var i=0;i<selRows.length;i++)
	  		{
		  		NotContainRoleEntity.newRow(false);
	            NotContainRoleEntity.setValue(NotContainRoleEntity.getRow(),"ENT_ID",ContainRoleEntity.getValue(selRows[i],"ENT_ID"),ContainRoleEntity.getValue(selRows[i],"ENT_ID"));
				NotContainRoleEntity.setValue(NotContainRoleEntity.getRow(),"ENT_NAME",ContainRoleEntity.getValue(selRows[i],"ENT_NAME"),ContainRoleEntity.getValue(selRows[i],"ENT_NAME"));
				NotContainRoleEntity.setValue(NotContainRoleEntity.getRow(),"PRIV_ID",ContainRoleEntity.getValue(selRows[i],"PRIV_ID"),ContainRoleEntity.getValue(selRows[i],"PRIV_ID"));
				NotContainRoleEntity.setValue(NotContainRoleEntity.getRow(),"PRIV_NAME",ContainRoleEntity.getValue(selRows[i],"PRIV_NAME"),ContainRoleEntity.getValue(selRows[i],"PRIV_NAME"));
				NotContainRoleEntity.setValue(NotContainRoleEntity.getRow(),"NAME",ContainRoleEntity.getValue(selRows[i],"NAME"),ContainRoleEntity.getValue(selRows[i],"NAME"));
				NotContainRoleEntity.setValue(NotContainRoleEntity.getRow(),"FLAG",ContainRoleEntity.getValue(selRows[i],"FLAG"),ContainRoleEntity.getValue(selRows[i],"FLAG"));
	  		}
	  		for(var i=0;i < ContainRoleEntity.count();i++)
	  		{
			    if(ContainRoleEntity.isSelected(i))
			    {
				    ContainRoleEntity.deleteRow(i);
				    i--;
				}
         	}
	  		
	 }
	 else
	 {
	  //alert("请选择要删除的实体权限！");
	  alert(g_I18NMessage("secframe_role_entity" , "sec_role_entity_seldelentity"));
	 }
}

function save()
{
    var addCount = ContainRoleEntity.count();
    var addEntityPrivs="";
    var oneEntityPriv="";
    for (var i = 0 ;i<addCount;i++)
    {
       ContainRoleEntity.setRow(i);
       var flag = ContainRoleEntity.getValue(ContainRoleEntity.getRow(),"FLAG");
       var entId = ContainRoleEntity.getValue(ContainRoleEntity.getRow(),"ENT_ID");
       var privId = ContainRoleEntity.getValue(ContainRoleEntity.getRow(),"PRIV_ID");
       if (null != flag && flag == 0)
       {
           oneEntityPriv = entId+","+privId;
           addEntityPrivs = addEntityPrivs + ":"+oneEntityPriv;
       }
    }
    addEntityPrivs = addEntityPrivs.substring(1);
    
    var delCount = NotContainRoleEntity.count();
    var delEntityPrivs="";
    var oneDelEntityPriv="";
    for (var i = 0 ;i<delCount;i++)
    {
       NotContainRoleEntity.setRow(i);
       var flag = NotContainRoleEntity.getValue(NotContainRoleEntity.getRow(),"FLAG");
       var delEntId = NotContainRoleEntity.getValue(NotContainRoleEntity.getRow(),"ENT_ID");
       var delPrivId = NotContainRoleEntity.getValue(NotContainRoleEntity.getRow(),"PRIV_ID");
       if (null != flag && flag == 1)
       {
           oneDelEntityPriv = delEntId+","+delPrivId;
           delEntityPrivs = delEntityPrivs + ":"+oneDelEntityPriv;
       }
    }
    delEntityPrivs = delEntityPrivs.substring(1);
    
    var msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecRoleAction?"+
				"action=saveAddDelRoleEntity&addEntityPrivs="+addEntityPrivs+"&delEntityPrivs="+delEntityPrivs+"&roleId="+selRoleId);
	var retVal = msg.getValueByName("retVal");
	if( retVal == "0" )
	{
	   //alert("角色关联实体信息保存成功!");
	   alert(g_I18NMessage("secframe_role_entity" , "sec_role_entity_save_ok")); 
       window.returnValue="ok";
       window.self.close();
	}
    else
	{
	   alert(msg.getValueByName("retMsg"));
	}
}
function cancel(){	
	window.self.close();
}
</script>
