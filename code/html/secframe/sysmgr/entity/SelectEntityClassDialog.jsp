<%@ page contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title></title>
	</head>
<body>
         <ai:contractframe id="" contenttype="table" title="sec.entityclassmanager.list" i18nRes="i18n.secframe_resource" width="98%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>
            <ai:table tableid="entityClassTable"
							setname="com.ai.secframe.sysmgr.web.SETSecEntityClass"
							initial="true" multiselect="true" editable="false"
							tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
							implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecEntitySV"
							implservice_querymethod="querySecEntityClass"  
							implservice_countmethod="querySecEntityClassCount" width="100%" height="320" needrefresh="true" pagesize="15"
							 ondbclick="getEntityClass">
			  <ai:col fieldname="ENT_CLASS_ID" visible="false" />															
              <ai:col fieldname="NAME" width="100%" editable="false"
								visible="true" />					
            </ai:table>
         </ai:contractframe>
         <div class="area_button">
				<ai:button text="sec.organize.selected" i18nRes="i18n.secframe_resource" id="affirm" onclick="affirm()"/>
				&nbsp;
				<ai:button  text="sec.organize.cancel" i18nRes="i18n.secframe_resource" id="cancel" onclick="cancel()"/>
         </div>
	</body>
</html>
<script type="text/javascript">

function getEntityClass()
{
    var entityClassTable = g_TableRowSetManager.get("entityClassTable");
    var row = entityClassTable.getRow();
    var entClassId = entityClassTable.getValue(entityClassTable.getRow(),"ENT_CLASS_ID");
    var entClassName = entityClassTable.getValue(entityClassTable.getRow(),"NAME");
    window.returnValue = entClassId+"|"+entClassName;	
	window.self.close();
}
function affirm(){
    var entityClassTable = g_TableRowSetManager.get("entityClassTable");
    if(entityClassTable.getSelectedRows()==null ||entityClassTable.getSelectedRows().length == 0)
    {
        //alert("请选择一条记录！");
        alert(g_I18NMessage("secframe_select_entityclassdialog","sec_select_entityclassdialog_select"));
		return false;
    }
	else if(entityClassTable.getSelectedRows()!=null&&entityClassTable.getSelectedRows().length>1){
		//alert("一次请选择一条记录！");
		alert(g_I18NMessage("secframe_select_entityclassdialog","sec_select_entityclassdialog_onlyone"));
		return false;
	}
	var selRows = entityClassTable.getSelectedRows();
    var entClassId  = entityClassTable.getValue(selRows[0],"ENT_CLASS_ID");
    var entClassName  = entityClassTable.getValue(selRows[0],"NAME");
    window.returnValue = entClassId+"|"+entClassName;	
	window.self.close();
}
function cancel(){	
	window.self.close();
}
function chkCur(){
	affirm();
}

</script>
