<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>

<html>
<head>
<title><%=LocaleResourceFactory.getResource("BES0000484")%></title>

<script language="javascript" src="../common/js/configtool.js"></script>

</head>
<body  onload="initRowset()">
		    <ai:contentframe id="" title="BES0000484" i18nRes="CRM" contenttype="table" width="98%">
					<ai:dbform formid="rowsetDetail" setname="com.ai.bce.web.BceRowset" editable="true"
		   				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService" initial="false" onvalchange="" conditionname="condition1"
		   				implservice_name = "com.ai.bce.service.interfaces.IBceStudioSV"
		   				implservice_querymethod = "getRowsetValues(String cond)" >
				   		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
							<tr>
								<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000509")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="ROWSET_TYPE" formid="rowsetDetail"  width="200"/></td>
							</tr><tr>	
								<td class="td_font">KEY<%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="ROWSET_KEY" formid="rowsetDetail"  width="200"/></td>
							</tr><tr>
								<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000508")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="ROWSET_METHOD" formid="rowsetDetail"  width="200"/></td>
							</tr><tr>
								<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000201")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="MODULE_ID" formid="rowsetDetail" width="200"/></td>
							</tr><tr>
								<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="STATE" formid="rowsetDetail"  width="200"/></td> 
							</tr> 									
							<tr>
								<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td><td><ai:dbformfield fieldname="REMARKS" formid="rowsetDetail"  width="200"/></td>
							</tr>
						</table>
		 			</ai:dbform>		
		 			</ai:contentframe>
					<div class="area_button">
											<ai:button text="BES0000319" i18nRes="CRM" onclick = "save()" />&nbsp;&nbsp;
											<ai:button text="BES0000480" i18nRes="CRM" onclick = "closeWindow()" />
					</div>
</body> 
<script type="text/javascript">
		/**
		 * 初始化数据集
		 */
		function initRowset()
		{
			var rowsetForm = g_FormRowSetManager.get("rowsetDetail");
			rowsetForm.setValue("ROWSET_TYPE", 1);
			rowsetForm.setValue("STATE", 1);
			rowsetForm.setValue("MODULE_ID", window.dialogArguments);
		}
    	/**
    	 * 保存
    	 */
    	function save()
    	{
    		var rowsetDetailForm = g_FormRowSetManager.get("rowsetDetail");
    		var xmlBody = rowsetDetailForm.toXmlString(true);
    		if(xmlBody=="")
    		{
    			alert(crm_i18n_msg("BEC0000008"));
    			return;
    		}
  			var list = new Array();
	        list.push(rowsetDetailForm);
	   var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
			if (ud.getValueByName("FLAG") == "ERROR") {
			  if(!ud.getValueByName("MESSAGE"))
			    alert(crm_i18n_msg("BEC0000013"));
				return;
			}
			window.self.close();
    	}
    	/**
		 * 关闭窗口
		 */
		function closeWindow()
		{
			window.self.close();
		}
		
</script>

</html>


