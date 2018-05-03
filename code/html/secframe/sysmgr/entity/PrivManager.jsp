<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="sec.privmanager.actmanage" res="i18n.secframe_resource"/></title>
</head>
<body onload="initButton()">

<ai:dbform formid="secPrivEntityClassSearchForm"
					setname="com.ai.secframe.sysmgr.web.SETSecPrivEntityClass"
					datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecEntitySV"
					implservice_querymethod="querySecPrivEntityClass" 
					initial="false" editable="true">
            <ai:contractframe id="" contenttype="table" title="sec.privmanager.query" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>		
            <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
              <tr>
                <td class="td_font"><i18n:message key="sec.privmanager.name" res="i18n.secframe_resource"/></td>
                <td><ai:dbformfield formid="secPrivEntityClassSearchForm" fieldname="PRIV_NAME"
								width="150" editable="true" visible="true" />		
                <td class="td_font"><i18n:message key="sec.privmanager.describe" res="i18n.secframe_resource"/></td>
                <td><ai:dbformfield formid="secPrivEntityClassSearchForm" fieldname="PRIV_DESC"
								width="150" editable="true" visible="true" />			
                <td class="td_font"><i18n:message key="sec.privmanager.opname" res="i18n.secframe_resource"/></td>
                <td><ai:dbformfield formid="secPrivEntityClassSearchForm" fieldname="NAME"
								width="150" editable="true" visible="true" />	
			    <td><ai:button  text="sec.query" i18nRes="i18n.secframe_resource" id="searchBtn" onclick="search()"/></td> 						
              </tr>           
            </table>
            </ai:contractframe>
            </ai:dbform>
            
            <ai:contractframe id="" contenttype="table" title="sec.privmanager.list" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>
            <ai:table tableid="secPrivEntityClassSearchResultTable"
							setname="com.ai.secframe.sysmgr.web.SETSecPrivEntityClass"
							initial="false" multiselect="false" editable="false"
							tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
							implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecEntitySV"
							implservice_querymethod="querySecPrivEntityClass"  pagesize="10"
							implservice_countmethod="querySecPrivEntityClassCount" width="100%" onrowchange="loadPrivEntityClassDetailMsg"	
							height="220" needrefresh="true">
			  <ai:col fieldname="ENT_CLASS_ID" width="100" editable="false"
								visible="false" />	
			  <ai:col fieldname="PRIV_ID" width="25%" editable="false"
								visible="true" />	
			  <ai:col fieldname="PRIV_NAME" width="25%" editable="false"
								visible="true" />		
			  <ai:col fieldname="PRIV_DESC" width="25%" editable="false"
								visible="true" />															
              <ai:col fieldname="NAME" width="25%" editable="false"
								visible="true" />					
            </ai:table>
            </ai:contractframe>
            
            <ai:dbform formid="secPrivEntityClassDetailForm"
					setname="com.ai.secframe.sysmgr.web.SETSecPrivEntityClass"
					datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
					implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecEntitySV"
					implservice_querymethod="querySecPrivEntityClass" 
					initial="false" editable="false">
                  <ai:contractframe id="" contenttype="table" title="sec.privmanager.detail" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
                  <ai:contractitem/>		
                  <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                    <tr>
                      <td><ai:dbformfield formid="secPrivEntityClassDetailForm" fieldname="PRIV_ID"  visible="false" /></td>
					  <td><ai:dbformfield formid="secPrivEntityClassDetailForm" fieldname="ENT_CLASS_ID" visible="false" /></td>			
                    </tr>
                    <tr>
                      <td class="td_font"><i18n:message key="sec.privmanager.name" res="i18n.secframe_resource"/></td>
                      <td ><ai:dbformfield formid="secPrivEntityClassDetailForm" fieldname="PRIV_NAME"
								width="150" editable="false" visible="true" /><span class="font_red">*</span>
                      <td class="td_font"><i18n:message key="sec.privmanager.describe" res="i18n.secframe_resource"/></td>
                      <td ><ai:dbformfield formid="secPrivEntityClassDetailForm" fieldname="PRIV_DESC"
								width="150" editable="false" visible="true" />
                      <td class="td_font"><i18n:message key="sec.privmanager.opname" res="i18n.secframe_resource"/></td>
                      <td ><ai:dbformfield formid="secPrivEntityClassDetailForm" fieldname="NAME"
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
                  <div>
                 
<script type="text/javascript">
var privId = "";
var condition = "";

var secPrivEntityClassDetailForm = g_FormRowSetManager.get("secPrivEntityClassDetailForm");
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
   var secPrivEntityClassSearchForm = g_FormRowSetManager.get("secPrivEntityClassSearchForm");
   var secPrivEntityClassSearchResultTable = g_TableRowSetManager.get("secPrivEntityClassSearchResultTable");	
   var privName = secPrivEntityClassSearchForm.getValue("PRIV_NAME");
   var privDesc = secPrivEntityClassSearchForm.getValue("PRIV_DESC");
   var entityClassName = secPrivEntityClassSearchForm.getValue("NAME");
   var privNameCond = "";
   var privDescCond = "";
   var entityClassNameCond="";
   var flag = false;
   if(privName!=null&&privName!="")
   {
	    privNameCond = " PRIV_NAME LIKE '"+privName+"%' ";
   }
   if(privDesc!=null&&privDesc!="")
   {
	    privDescCond = " PRIV_DESC LIKE '"+privDesc+"%' ";
   }
   if(entityClassName!=null&&entityClassName!="")
   {
	    entityClassNameCond = " NAME LIKE '"+entityClassName+"%' ";
   }
   //平凑查询条件
   var cond = "";
   if(privNameCond!="")
   {
	   cond = cond + privNameCond;
			flag=true;
   }
		
   if(privDescCond!="")
   {
	   if(flag)
	   {
		  cond = cond +" AND "+ privDescCond;
	   }
	   else 
	   {
		  cond = cond +  privDescCond;
		  flag = true;
	   }
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
		//alert(g_I18NMessage("sec_privmanager", "sec_privmanager_inputcod"));
		secPrivEntityClassSearchResultTable.refresh(cond);
		return ;
	}
	condition = cond;
    secPrivEntityClassSearchResultTable.refresh(cond);
}

function loadPrivEntityClassDetailMsg()
{
  document.getElementById("updateBtn").disabled = false;
  document.getElementById("addBtn").disabled = false;
  document.getElementById("saveBtn").disabled = false;
  document.getElementById("delBtn").disabled = false;
  document.getElementById("selectEntClass").disabled = true;
  var secPrivEntityClassSearchResultTable = g_TableRowSetManager.get("secPrivEntityClassSearchResultTable");
  var secPrivEntityClassDetailForm = g_FormRowSetManager.get("secPrivEntityClassDetailForm");
  var privId = secPrivEntityClassSearchResultTable.getValue(secPrivEntityClassSearchResultTable.getRow(),"PRIV_ID");
  if (null == privId || privId =="")
    {
       alert(g_I18NMessage("sec_privmanager", "sec_privmanager_select"));
       return;
    }
  var cond = "PRIV_ID = " + privId;
  secPrivEntityClassDetailForm.refresh(cond);  
  //refreshDetailMsg(privId);
}

function refreshDetailMsg(privId)
{
    if (null == privId || privId =="")
    {
       alert(g_I18NMessage("sec_privmanager", "sec_privmanager_select"));
       return;
    }
    var secPrivEntityClassDetailForm = g_FormRowSetManager.get("secPrivEntityClassDetailForm");
    var cond = "PRIV_ID = " + privId;
    secPrivEntityClassDetailForm.refresh(cond);
    if(secPrivEntityClassDetailForm.getValue("ENT_CLASS_ID")!=''){ 
				msg = PostInfo("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecEntityAction?"+
					"action=getEntityClassName&entityClassId="+secPrivEntityClassDetailForm.getValue("ENT_CLASS_ID"));
				result = msg.getValueByName("retVal"); 
				secPrivEntityClassDetailForm.setValue("NAME",result);			
			}
   
}

function update()
{
    document.getElementById("addBtn").disabled = true;
    document.getElementById("saveBtn").disabled = false;
    document.getElementById("delBtn").disabled = true;
    document.getElementById("selectEntClass").disabled = false;
    var secPrivEntityClassDetailForm = g_FormRowSetManager.get("secPrivEntityClassDetailForm");
    secPrivEntityClassDetailForm.setColEditSts("PRIV_NAME",true);
    secPrivEntityClassDetailForm.setColEditSts("PRIV_DESC",true);
    secPrivEntityClassDetailForm.setColEditSts("NAME",true);
}


function save()
{
    if (null ==secPrivEntityClassDetailForm.getValue("PRIV_NAME")||"" ==secPrivEntityClassDetailForm.getValue("PRIV_NAME"))
    {
       alert(g_I18NMessage("sec_privmanager", "sec_privmanager_notnull"));
       return;
    }
    if (null ==secPrivEntityClassDetailForm.getValue("NAME")||"" ==secPrivEntityClassDetailForm.getValue("NAME"))
    {
       alert(g_I18NMessage("sec_privmanager", "sec_privmanager_namenotnull"));
       return;
    }
    // 保存
	var list = new Array();
	if(secPrivEntityClassDetailForm.toXmlString(true) == "")
	    {
	    	alert(g_I18NMessage("sec_privmanager", "sec_privmanager_unupdate"));
	    	return;
	    }
		
	//if(secPrivEntityClassDetailForm.getValue("NAME")!=''){
   //  		secPrivEntityClassDetailForm.setValue("ENT_CLASS_ID",secPrivEntityClassDetailForm.getValue("ENT_CLASS_ID").split('|')[0]);
    // 		secPrivEntityClassDetailForm.setValue("NAME",secPrivEntityClassDetailForm.getValue("NAME").split('|')[1]);
    // 	}
     	    
	list.push(secPrivEntityClassDetailForm);
	
	var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecEntityAction?action=savePrivEntityClass", list);
	var retVal = msg.getValueByName("retVal");
	if( retVal == "0" )
	{
	   alert(g_I18NMessage("sec_privmanager", "sec_privmanager_savesuccess"));
	   secPrivEntityClassDetailForm.setEditSts(false);
	   document.getElementById("addBtn").disabled = false;
	   secPrivEntityClassDetailForm.refresh("PRIV_ID = -1" );
	   g_TableRowSetManager.get("secPrivEntityClassSearchResultTable").refresh(condition);
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
    var secPrivEntityClassDetailForm = g_FormRowSetManager.get("secPrivEntityClassDetailForm");
    secPrivEntityClassDetailForm.setEditSts(true);
    secPrivEntityClassDetailForm.setColEditSts("NAME",false);
    secPrivEntityClassDetailForm.setValue("PRIV_ID","-1");
    secPrivEntityClassDetailForm.setValue("NAME","");
    secPrivEntityClassDetailForm.setValue("PRIV_NAME","");
    secPrivEntityClassDetailForm.setValue("PRIV_DESC","");
}


function del()
{
    var list = new Array();
    var secPrivEntityClassDetailForm = g_FormRowSetManager.get("secPrivEntityClassDetailForm");
    var delPrivId = secPrivEntityClassDetailForm.getValue("PRIV_ID");
    list.push(secPrivEntityClassDetailForm);
	var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecEntityAction?action=delPriv&delPrivId="+delPrivId, list);
	var retVal = msg.getValueByName("retVal");
	if( retVal == "0" )
	{
	   alert(g_I18NMessage("sec_privmanager", "sec_privmanager_deletesuccess"));
	   secPrivEntityClassDetailForm.setEditSts(false);
	   g_TableRowSetManager.get("secPrivEntityClassSearchResultTable").refresh(condition);
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
			secPrivEntityClassDetailForm.setValue("ENT_CLASS_ID",result[0]);	 
			secPrivEntityClassDetailForm.setValue("NAME",result[1]);	 
		}
}
</script>
</body>
</html>