<%@ page contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title></title>
	</head>
	<body onLoad="initForm()">
	
	<table width="100%" border="0" cellpadding="0" cellspacing="1">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="40">&nbsp;&nbsp;<img src="../../images/circle.gif" width="12" height="12" /></td>
                <td><i18n:message key="sec.selectentityclass.selentclass" res="i18n.secframe_resource"/></td>
                <td align="right"></td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td align="left" height="250" valign="top">
            <ai:table tableid="entityClassTable"
							setname="com.ai.secframe.sysmgr.web.SETSecPrivEntityClass"
							initial="false" multiselect="true" editable="false"
							tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
							implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecEntitySV"
							implservice_querymethod="querySecPrivEntityClass"  pagesize="100"
							width="380" ondbclick="getEntityClass"	
							height="350" needrefresh="true">
			  <ai:col fieldname="ENT_CLASS_ID" width="100" editable="false"
								visible="false" />															
              <ai:col fieldname="NAME" width="100" editable="false"
								visible="true" />					
            </ai:table>
            </td>
        </tr>
      </table>	
		<table border=0 width=100% align="center">
			<tr>
				<td align="center">
				<ai:button text="sec.selectentityclass.confirm" i18nRes="i18n.secframe_resource" id="affirm" onclick="affirm()"/>
				&nbsp;
				<ai:button  text="sec.selectentityclass.cancel" i18nRes="i18n.secframe_resource" id="cancel" onclick="cancel()"/>
				</td>
			</tr>
		</table>
	</body>
</html>
<script type="text/javascript">
var privId = "";


function initForm()
{
   var selPrivId = window.dialogArguments;
   if (null == selPrivId || selPrivId =="")
   {
       //alert("参数传递错误！");
       alert(g_I18NMessage("secframe_select_entityclassdialog","sec_select_entityclassdialog_paramerror"));
       return ;
   }
   var entityClassTable = g_TableRowSetManager.get("entityClassTable"); 
   privId = selPrivId;
   entityClassTable.refresh("PRIV_ID="+privId);

}

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
