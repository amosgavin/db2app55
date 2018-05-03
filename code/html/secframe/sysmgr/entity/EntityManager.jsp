<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="sec.entitymanager.entitymanager" res="i18n.secframe_resource"/></title>
</head>
<body onload="initButton()">
        <ai:dbform formid="secEntitySearchForm"
					setname="com.ai.secframe.sysmgr.web.SETQSecEntity"
					datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecEntitySV"
					implservice_querymethod="querySecEntity" 
					initial="false" editable="true">
            <ai:contractframe id="" contenttype="table" title="sec.entitymanager.entityquery" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>		
            <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
              <tr>
                <td class="td_font"><i18n:message key="sec.entitymanager.entityname" res="i18n.secframe_resource"/></td>
                <td ><ai:dbformfield formid="secEntitySearchForm" fieldname="ENT_NAME"
								width="150" editable="true" visible="true" />		
                <td class="td_font"><i18n:message key="sec.entitymanager.belongclass" res="i18n.secframe_resource"/></td>
                <td><ai:dbformfield formid="secEntitySearchForm" fieldname="NAME"
								width="150" editable="true" visible="true" />
			    <td> <ai:button  text="sec.query" i18nRes="i18n.secframe_resource" id="searchBtn" onclick="search()"/></td>							
              </tr>             
            </table>
            </ai:contractframe>
         </ai:dbform>

         <ai:contractframe id="" contenttype="table" title="sec.entitymanager.resultlist" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>
             <ai:table tableid="secEntitySearchResultTable"
							setname="com.ai.secframe.sysmgr.web.SETQSecEntity"
							initial="false" multiselect="false" editable="false"
							tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
							implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecEntitySV"
							implservice_querymethod="querySecEntity"  pagesize="10"
							implservice_countmethod="querySecEntityCount" width="100%" onrowchange="loadEntityDetailMsg"	
							height="220" needrefresh="true">
			  <ai:col fieldname="ENT_CLASS_ID" editable="false"
								visible="false" />	
			  <ai:col fieldname="ENT_ID" width="25%" editable="false"
								visible="true" />	
			  <ai:col fieldname="ENT_NAME" width="25%" editable="false"
								visible="true" />																	
              <ai:col fieldname="NAME" width="25%" editable="false"
								visible="true" />	
			  <ai:col fieldname="REMARKS" width="25%" editable="false"
								visible="true" />									
             </ai:table>
        </ai:contractframe>
            
        <ai:dbform formid="secEntityDetailForm"
				setname="com.ai.secframe.sysmgr.web.SETQSecEntity"
				datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
				implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecEntitySV"
				implservice_querymethod="querySecEntity" 
				initial="false" editable="false">
              <ai:contractframe id="" contenttype="table" title="sec.entitymanager.detail" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
                  <ai:contractitem/>		
                  <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                   <tr>
                     <td><ai:dbformfield formid="secEntityDetailForm" fieldname="ENT_ID" visible="false" /></td>
                     <td><ai:dbformfield formid="secEntityDetailForm" fieldname="ENT_CLASS_ID" visible="false" /></td>
                   </tr>
                   <tr>
                     <td class="td_font"><i18n:message key="sec.entitymanager.entityname" res="i18n.secframe_resource"/></td>
                     <td ><ai:dbformfield formid="secEntityDetailForm" fieldname="ENT_NAME"
							width="150" editable="false" visible="true" /><font color="red">*</font>
                     <td class="td_font"><i18n:message key="sec.entitymanager.entitynote" res="i18n.secframe_resource"/></td>
                     <td ><ai:dbformfield formid="secEntityDetailForm" fieldname="REMARKS"
							width="150" editable="false" visible="true" />
                     <td class="td_font"><i18n:message key="sec.entitymanager.belongname" res="i18n.secframe_resource"/></td>
                     <td ><ai:dbformfield formid="secEntityDetailForm" fieldname="NAME"
							width="130" editable="false" visible="true" /><img id="selectEntClass" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="" onClick="selectEntityClass();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>	
                   </tr>

                 </table>
             </ai:contractframe>
         </ai:dbform>
                  <div class="area_button">
                    <ai:button  text="sec.modify" i18nRes="i18n.secframe_resource" id="updateBtn" onclick="update()"/>
                    <ai:button  text="sec.add" i18nRes="i18n.secframe_resource" id="addBtn" onclick="add()"/>
                    <ai:button  text="sec.save" i18nRes="i18n.secframe_resource" id="saveBtn" onclick="save()"/>
                    <ai:button  text="sec.delete" i18nRes="i18n.secframe_resource" id="delBtn" onclick="del()"/>
                  </div>
<script type="text/javascript">
var condition = "";

var secEntityDetailForm = g_FormRowSetManager.get("secEntityDetailForm");
//初始化按钮
function initButton()
{
    document.getElementById("updateBtn").disabled = true;
    document.getElementById("addBtn").disabled = false;
    document.getElementById("saveBtn").disabled = true;
    document.getElementById("delBtn").disabled = true;
    document.getElementById("selectEntClass").disabled = true;
    
}
function search()
{
   var secEntitySearchForm = g_FormRowSetManager.get("secEntitySearchForm");
   var secEntitySearchResultTable = g_TableRowSetManager.get("secEntitySearchResultTable");	
   var entName = secEntitySearchForm.getValue("ENT_NAME");
   var entityClassName = secEntitySearchForm.getValue("NAME");
   var entNameCond = "";
   var entityClassNameCond="";
   var flag = false;
   if(entName!=null&&entName!="")
   {
	    entNameCond = " ENT_NAME LIKE '"+entName+"%' ";
   }
   if(entityClassName!=null&&entityClassName!="")
   {
	    entityClassNameCond = " NAME LIKE '"+entityClassName+"%' ";
   }
   //平凑查询条件
   var cond = "";
   if(entNameCond!="")
   {
	   cond = cond + entNameCond;
			flag=true;
   }
      
   if(entityClassNameCond!="")
   {
	    if(flag)
	    {
			cond = cond +" AND "+ entityClassNameCond;
		}
		else 
		{
			cond = cond +  entityClassNameCond;
		}
	}
		
	if(cond=="")
	{
		//alert(g_I18NMessage("sec_entitymanager", "sec_entitymanager_inputcod"));
		secEntitySearchResultTable.refresh(cond);
		return ;
	}
	condition = cond;
    secEntitySearchResultTable.refresh(cond);
}

function loadEntityDetailMsg()
{
  document.getElementById("updateBtn").disabled = false;
  document.getElementById("addBtn").disabled = false;
  document.getElementById("saveBtn").disabled = false;
  document.getElementById("delBtn").disabled = false;
  document.getElementById("selectEntClass").disabled = true;
  var secEntitySearchResultTable = g_TableRowSetManager.get("secEntitySearchResultTable");
  var secEntityDetailForm = g_FormRowSetManager.get("secEntityDetailForm");
  var entId = secEntitySearchResultTable.getValue(secEntitySearchResultTable.getRow(),"ENT_ID");
  if (null == entId || entId =="")
    {
       alert(g_I18NMessage("sec_entitymanager", "sec_entitymanager_select"));
       return;
    }
  var cond = "ENT_ID = " + entId;
  secEntityDetailForm.refresh(cond);  
}


function update()
{
    document.getElementById("addBtn").disabled = true;
    document.getElementById("saveBtn").disabled = false;
    document.getElementById("delBtn").disabled = true;
    document.getElementById("selectEntClass").disabled = false;
    var secEntityDetailForm = g_FormRowSetManager.get("secEntityDetailForm");
    secEntityDetailForm.setColEditSts("ENT_NAME",true);
    secEntityDetailForm.setColEditSts("REMARKS",true);
    secEntityDetailForm.setColEditSts("NAME",true);
}


function save()
{
    if (null ==secEntityDetailForm.getValue("ENT_NAME")||"" ==secEntityDetailForm.getValue("ENT_NAME"))
    {
       alert(g_I18NMessage("sec_entitymanager", "sec_entitymanager_notnull"));
       return;
    }
    if (null ==secEntityDetailForm.getValue("NAME")||"" ==secEntityDetailForm.getValue("NAME"))
    {
       alert(g_I18NMessage("sec_entitymanager", "sec_entitymanager_classnotnull"));
       return;
    }
    // 保存
	var list = new Array();
	if(secEntityDetailForm.toXmlString(true) == "")
	    {
	    	alert(g_I18NMessage("sec_entitymanager", "sec_entitymanager_unupdate"));
	    	return;
	    }
	    
	list.push(secEntityDetailForm);
	
	var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecEntityAction?action=saveEntity", list);
	var retVal = msg.getValueByName("retVal");
	if( retVal == "0" )
	{
	   alert(g_I18NMessage("sec_entitymanager", "sec_entitymanager_savesuccess"));
	   secEntityDetailForm.setEditSts(false);
	   document.getElementById("addBtn").disabled = false;
	   secEntityDetailForm.refresh("ENT_ID = -1" );
	   g_TableRowSetManager.get("secEntitySearchResultTable").refresh(condition);
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
    document.getElementById("selectEntClass").disabled = false;
    var secEntityDetailForm = g_FormRowSetManager.get("secEntityDetailForm");
    secEntityDetailForm.setEditSts(true);
    secEntityDetailForm.setColEditSts("NAME",false);
    secEntityDetailForm.setValue("ENT_ID","-1");
    secEntityDetailForm.setValue("NAME","");
    secEntityDetailForm.setValue("ENT_NAME","");
    secEntityDetailForm.setValue("REMARKS","");
}


function del()
{
    var list = new Array();
    var secEntityDetailForm = g_FormRowSetManager.get("secEntityDetailForm");
    var delEntId = secEntityDetailForm.getValue("ENT_ID");
    list.push(secEntityDetailForm);
	var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecEntityAction?action=delEntity&delEntId="+delEntId, list);
	var retVal = msg.getValueByName("retVal");
	if( retVal == "0" )
	{
	   alert(g_I18NMessage("sec_entitymanager", "sec_entitymanager_deletesuccess"));
	   secEntityDetailForm.setEditSts(false);
	   g_TableRowSetManager.get("secEntitySearchResultTable").refresh(condition);
	}
    else
	{
	   alert(msg.getValueByName("retMsg"));
	}    
}

function selectEntityClass()
{
    var result = window.showModalDialog("<%=request.getContextPath()%>/secframe/sysmgr/entity/SelectEntityClassDialog.jsp","org","scroll:no;resizable:no;status:no;dialogHeight:500px;dialogWidth:300px");
	if(result=='undefined'||result==null){
			result="";
		}else {
			result = result.split('|');
			secEntityDetailForm.setValue("ENT_CLASS_ID",result[0]);	 
			secEntityDetailForm.setValue("NAME",result[1]);	 
		}
}
</script>
</body>
</html>