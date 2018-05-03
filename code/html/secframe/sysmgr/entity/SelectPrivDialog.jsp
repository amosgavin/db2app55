<%@ page contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title></title>
	</head>
	<body>
	
	<table width="100%" border="0" cellpadding="0" cellspacing="1">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="40">&nbsp;&nbsp;<img src="../../images/circle.gif" width="12" height="12" /></td>
                <td><i18n:message key="sec.selectpriv.selpriv" res="i18n.secframe_resource"/></td>
                <td align="right"></td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td align="left" height="250" valign="top">
            <ai:table tableid="privTable"
							setname="com.ai.secframe.sysmgr.web.SETSecPriv"
							initial="true" multiselect="true" editable="false"
							tablemodel="com.ai.appframe2.web.datamodel.QueryModelForService"
							implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecEntitySV"
							implservice_querymethod="querySecPriv"  pagesize="100"
							width="380" ondbclick="getPriv"	
							height="350" needrefresh="true">
			  <ai:col fieldname="PRIV_ID" width="100" editable="false"
								visible="false" />															
              <ai:col fieldname="PRIV_NAME" width="100" editable="false"
								visible="true" />					
            </ai:table>
            </td>
        </tr>
      </table>	
		<table border=0 width=100% align="center">
			<tr>
				<td align="center">
				<ai:button text="sec.selectpriv.confirm" i18nRes="i18n.secframe_resource" id="affirm" onclick="affirm()"/>
				&nbsp;
				<ai:button  text="sec.selectpriv.cancel" i18nRes="i18n.secframe_resource" id="cancel" onclick="cancel()"/>
				</td>
			</tr>
		</table>
	</body>
</html>
<script type="text/javascript">

function getPriv()
{
    var privTable = g_TableRowSetManager.get("privTable");
    var row = privTable.getRow();
    var privId = privTable.getValue(privTable.getRow(),"PRIV_ID");
    var privName = privTable.getValue(privTable.getRow(),"PRIV_NAME");
    window.returnValue = privId+"|"+privName;	
	window.self.close();
}
function affirm(){
    var privTable = g_TableRowSetManager.get("privTable");
    if(privTable.getSelectedRows()==null ||privTable.getSelectedRows().length == 0)
    {
        //alert("请选择一条记录！");
        alert(g_I18NMessage("secframe_select_entityclassdialog","sec_select_entityclassdialog_select"));
		return false;
    }
	else if(privTable.getSelectedRows()!=null&&privTable.getSelectedRows().length>1){
		//alert("一次请选择一条记录！");
		alert(g_I18NMessage("secframe_select_entityclassdialog","sec_select_entityclassdialog_onlyone"));
		return false;
	}
	var selRows = privTable.getSelectedRows();
    var privId  = privTable.getValue(selRows[0],"PRIV_ID");
    var privName  = privTable.getValue(selRows[0],"PRIV_NAME");
    window.returnValue = privId+"|"+privName;	
	window.self.close();
}
function cancel(){	
	window.self.close();
}
function chkCur(){
	affirm();
}

</script>
