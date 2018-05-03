<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="sec.entityclassmanager.manage" res="i18n.secframe_resource"/></title>
</head>
<body onload="initButton()">

<ai:dbform formid="secEntityClassSearchForm"
					setname="com.ai.secframe.sysmgr.web.SETSecEntityClass"
					datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecEntitySV"
					implservice_querymethod="querySecEntityClass" 
					initial="false" editable="true">
			<ai:contractframe id="" contenttype="table" title="sec.entityclassmanager.query" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>		
            <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
              <tr>
                <td class="td_font"><i18n:message key="sec.entityclassmanager.name" res="i18n.secframe_resource"/></td>
                <td><ai:dbformfield formid="secEntityClassSearchForm" fieldname="NAME"
								width="150" height="20" editable="true" visible="true" />
				<td><ai:button text="sec.query" i18nRes="i18n.secframe_resource" id="searchBtn" onclick="search()"/></td>				
              </tr>           
            </table>
            </ai:contractframe>
            </ai:dbform>
            
            <ai:contractframe id="" contenttype="table" title="sec.entityclassmanager.list" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>
            <ai:table tableid="secEntityClassSearchResultTable"
							setname="com.ai.secframe.sysmgr.web.SETSecEntityClass"
							initial="false" multiselect="false" editable="false"
							tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
							implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecEntitySV"
							implservice_querymethod="querySecEntityClass"
							implservice_countmethod="querySecEntityClassCount"  pagesize="10"
							width="100%" onrowchange="loadEntityClassDetailMsg"	
							height="220" needrefresh="true">
			  <ai:col fieldname="ENT_CLASS_ID" width="30%" editable="false"
								visible="true" />				
              <ai:col fieldname="NAME" width="35%" editable="false"
								visible="true" />
			  <ai:col fieldname="REMARKS" width="35%" editable="false"
								visible="true" />						
            </ai:table>
            </ai:contractframe>
            
            <ai:dbform formid="secEntityClassDetailForm"
					setname="com.ai.secframe.sysmgr.web.SETSecEntityClass"
					datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecEntitySV"
					implservice_querymethod="querySecEntityClass" 
					initial="false" editable="false">
                  <ai:contractframe id="" contenttype="table" title="sec.entityclassmanager.detail" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
                   <ai:contractitem/>		
                   <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                    <tr>
                      <td class="td_font"><i18n:message key="sec.entityclassmanager.name" res="i18n.secframe_resource"/></td>
                      <td ><ai:dbformfield formid="secEntityClassDetailForm" fieldname="NAME"
								width="150" height="20" editable="false" visible="true" /><span class="font_red">*</span>
                      <td class="td_font"><i18n:message key="sec.entityclassmanager.note" res="i18n.secframe_resource"/></td>
                      <td><ai:dbformfield formid="secEntityClassDetailForm" fieldname="REMARKS"
								width="150" height="20" editable="false" visible="true" />
                    </tr>
                    <tr>
                      <td ><ai:dbformfield formid="secEntityClassDetailForm" fieldname="ENT_CLASS_ID"
								width="150" height="20" editable="false" visible="false" />
                    </tr>
                  </table>
                  </ai:contractframe>
                  </ai:dbform>
                  <div class="area_button">
                    <ai:button  text="sec.modify" i18nRes="i18n.secframe_resource" id="updateBtn" onclick="update()"/>
                    <ai:button  text="sec.add" i18nRes="i18n.secframe_resource" id="addBtn" onclick="add()"/>
                    <ai:button  text="sec.save" i18nRes="i18n.secframe_resource" id="saveBtn" onclick="save()"/>
                    <ai:button  text="sec.delete" i18nRes="i18n.secframe_resource" id="delBtn" onclick="del()"/>
                  <div>
<script type="text/javascript">
var condition = "";
//初始化按钮
function initButton()
{
    document.getElementById("updateBtn").disabled = true;
    document.getElementById("addBtn").disabled = false;
    document.getElementById("saveBtn").disabled = true;
    document.getElementById("delBtn").disabled = true;
}
function search()
{
  var secEntityClassSearchForm = g_FormRowSetManager.get("secEntityClassSearchForm");
  var secEntityClassSearchResultTable = g_TableRowSetManager.get("secEntityClassSearchResultTable");	
  var entityClassName = secEntityClassSearchForm.getValue("NAME");
  if(entityClassName!=null&&entityClassName!="")
   {
        condition = " NAME LIKE '"+entityClassName+"%' ";
	    secEntityClassSearchResultTable.refresh(" NAME LIKE '"+entityClassName+"%' ");
   }
   else
   {
        //alert(g_I18NMessage("sec_entityclassmanager", "sec_entityclassmanager_inputcod"));
        secEntityClassSearchResultTable.refresh();
		return ;
   }
}

function loadEntityClassDetailMsg()
{
  document.getElementById("updateBtn").disabled = false;
  document.getElementById("addBtn").disabled = false;
  document.getElementById("saveBtn").disabled = false;
  document.getElementById("delBtn").disabled = false;
  var secEntityClassSearchResultTable = g_TableRowSetManager.get("secEntityClassSearchResultTable");
  var secEntityClassDetailForm = g_FormRowSetManager.get("secEntityClassDetailForm");
  var entityClassId = secEntityClassSearchResultTable.getValue(secEntityClassSearchResultTable.getRow(),"ENT_CLASS_ID");
  
  if (null == entityClassId || entityClassId =="")
    {
       alert(g_I18NMessage("sec_entityclassmanager", "sec_entityclassmanager_select"));
       return;
    }
    var cond = "ENT_CLASS_ID = " + entityClassId;
    secEntityClassDetailForm.refresh(cond);
}

function update()
{
    document.getElementById("addBtn").disabled = true;
    document.getElementById("saveBtn").disabled = false;
    document.getElementById("delBtn").disabled = true;
    var secEntityClassDetailForm = g_FormRowSetManager.get("secEntityClassDetailForm");
    secEntityClassDetailForm.setColEditSts("NAME",true);
    secEntityClassDetailForm.setColEditSts("REMARKS",true);
}


function save()
{
    // 保存
	var list = new Array();
	var secEntityClassDetailForm = g_FormRowSetManager.get("secEntityClassDetailForm");
	if (null ==secEntityClassDetailForm.getValue("NAME")||"" ==secEntityClassDetailForm.getValue("NAME"))
    {
       alert(g_I18NMessage("sec_entityclassmanager", "sec_entityclassmanager_notnull"));
       return;
    }
	if(secEntityClassDetailForm.toXmlString(true) == "")
	    {
	    	alert(g_I18NMessage("sec_entityclassmanager", "sec_entityclassmanager_notupdate"));
	    	return;
	    }
	list.push(secEntityClassDetailForm);
	
	var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecEntityAction?action=saveEntityClass", list);
	var retVal = msg.getValueByName("retVal");
	if( retVal == "0" )
	{
	   alert(g_I18NMessage("sec_entityclassmanager", "sec_entityclassmanager_savesuccess"));
	   secEntityClassDetailForm.setEditSts(false);
	   secEntityClassDetailForm.refresh("ENT_CLASS_ID = -1" );
	   g_TableRowSetManager.get("secEntityClassSearchResultTable").refresh(condition);
	}
    else
	{
	   alert(msg.getValueByName("retMsg"));
	}
}

function add()
{
    document.getElementById("updateBtn").disabled = true;
    document.getElementById("addBtn").disabled = true;
    document.getElementById("saveBtn").disabled = false;
    document.getElementById("delBtn").disabled = true;
    var secEntityClassDetailForm = g_FormRowSetManager.get("secEntityClassDetailForm");
    secEntityClassDetailForm.setEditSts(true);
    secEntityClassDetailForm.setValue("ENT_CLASS_ID","-1");
    secEntityClassDetailForm.setValue("NAME","");
    secEntityClassDetailForm.setValue("REMARKS","");
}


function del()
{
    var list = new Array();
    var secEntityClassDetailForm = g_FormRowSetManager.get("secEntityClassDetailForm");
    var delEntityClassId = secEntityClassDetailForm.getValue("ENT_CLASS_ID");
    list.push(secEntityClassDetailForm);
	var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecEntityAction?action=delEntityClass&delEntityClassId="+delEntityClassId, list);
	var retVal = msg.getValueByName("retVal");
	if( retVal == "0" )
	{
	   alert(g_I18NMessage("sec_entityclassmanager", "sec_entityclassmanager_deletesuccess"));
	   secEntityClassDetailForm.setEditSts(false);
	   g_TableRowSetManager.get("secEntityClassSearchResultTable").refresh(condition);
	}
    else
	{
	   alert(msg.getValueByName("retMsg"));
	}
    
}
</script>
</body>
</html>