<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@page import="com.ai.bce.configtool.service.interfaces.IConfModuleSV"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page import="com.ai.bce.bo.BceModuleBean"%>
<%@page import="com.ai.appframe2.service.ServiceFactory"%>

<html>
	<%
		long moduleId = HttpUtil.getAsLong(request, "moduleId");
		IConfModuleSV moduleSV = (IConfModuleSV) ServiceFactory
				.getService(IConfModuleSV.class);
		BceModuleBean[] beans = moduleSV.getDataSource();
	%>
	<head>
		<title><%=LocaleResourceFactory.getResource("BES0000537")%></title>
	</head>

	<body>
		<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem>
			</ai:contractitem>
			<table width="98%" align="center" border="0" cellpadding="1"
				cellspacing="2">
				<tr>
					<td>
						<%=LocaleResourceFactory.getResource("BES0000809")%>:
						<select id="ds" onchange="search()">
							<%
								for (int i = 0; i < beans.length; i++) {
									if (beans[i].getModuleId() == moduleId) {
							%>
							<option value="<%=beans[i].getModuleId()%>" selected="selected">
								<%=beans[i].getConfigDatasource()%>
							</option>
							<%
								} else {
							%>
							<option value="<%=beans[i].getModuleId()%>">
								<%=beans[i].getConfigDatasource()%>
							</option>
							<%
								}
								}
							%>
						</select>
						<br>
					</td>
					<td>
						<%=LocaleResourceFactory.getResource("BES0000810")%>:
						<input type="text" id="tableName" width="240" />
						<br>
					</td>
					<td>
						<ai:button text="BES0000325" i18nRes="CRM" onclick="query()" />
					</td>
				</tr>
			</table>
		</ai:contractframe>
		<ai:table tableid="Tab" setname="com.ai.bce.web.Tables"
			needrefresh="true"
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			conditionname="condition"
			implservice_name="com.ai.bce.configtool.service.interfaces.IConfAttrSV"
			implservice_querymethod="getTableNames(String dataSource, String cond)"
			initial="false" height="220" width="100%" editable="false"
			multiselect="false" footdisplay="block" pagesize="10"
			rowsequence="false" ondbclick="dbclick">
			<ai:col fieldname="OWNER" width="30%" />
			<ai:col fieldname="TABLE_NAME" width="70%" />
		</ai:table>
		<ai:table tableid="AttrTable" setname="com.ai.bce.web.BceAttr"
			needrefresh="true"
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			conditionname="condition"
			implservice_name="com.ai.bce.configtool.service.interfaces.IConfAttrSV"
			implservice_querymethod="getBceAttrBeans(String dataSource,String tableName)"
			initial="false" height="220" width="100%" editable="false"
			multiselect="true" footdisplay="block" pagesize="10"
			rowsequence="false">
			<ai:col fieldname="MODULE_ID" width="100" />
			<ai:col fieldname="OBJ_NAME" width="100" />
			<ai:col fieldname="ATTR_CODE" width="100" />
			<ai:col fieldname="ATTR_NAME" width="100" />
			<ai:col fieldname="FIELD_TYPE" width="100" />
			<ai:col fieldname="STATE" width="100" />
			<ai:col fieldname="I18N_RES" width="100" />
			<ai:col fieldname="FIELD_WIDTH" width="100" />
			<ai:col fieldname="COL_SPAN" width="100" />
			<ai:col fieldname="IS_NULLABLE" width="100" />
			<ai:col fieldname="EDIT_TYPE" width="100" />
			<ai:col fieldname="MAX_LENGTH" width="100" />
			<ai:col fieldname="RES_SRC" width="100" />
			<ai:col fieldname="RES_PARAM" width="100" />
			<ai:col fieldname="DEFAULT_VALUE" width="100" />
			<ai:col fieldname="VALUE_CLASS" width="100" />
			<ai:col fieldname="RULE_ID" width="100" />
			<ai:col fieldname="REMARKS" width="100" />
		</ai:table>
		<div class="area_button">
			<ai:button text="BES0000632" i18nRes="CRM" onclick="bExport()" />
		</div>
	</body>
</html>

<script type="text/javascript">
		function getTblAttr(){
			return g_TableRowSetManager.get("AttrTable");
		}
		
		function getTab(){
			return g_TableRowSetManager.get("Tab");
		}
		
		 function $(id){
		     return document.getElementById(id);
		 } 
        
		
        function query(){
        	var tableName = $('tableName').value;
        	var tableNames = tableName.split(/\s/);
        	var cond="( 1=2";
        	for(var i=0;i<tableNames.length;i++){
        		cond += " or TABLE_NAME like '%"+tableNames[i].toUpperCase()+"%' "
        	}
        	cond += ")";
        	var index = $('ds').selectedIndex;
        	var dataSource = $('ds').options[index].text;
	        getTab().refresh("dataSource="+dataSource+"&cond="+cond);
        }
        
        function bExport(){
        	var list = new Array();
        	list.push(getTblAttr());
        	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.configtool.web.ConfAttrAction?action=saveAttrBatch",list,false,false,null,false,true);
        	if (ud.getValueByName("FLAG") == "ERROR") {
			  if(!ud.getValueByName("MESSAGE"))
			    alert(crm_i18n_msg("BEC0000013"));
				return;
			}	
	        window.returnValue=1;
	        window.close();
        }
        
        function search(){
        	var index = $('ds').selectedIndex;
        	var dataSource = $('ds').options[index].text;
        	getTab().refresh("dataSource="+dataSource);
        }
        
        function dbclick(){
        	var index = getTab().getRow();
        	var tableName = getTab().getValue(index,"TABLE_NAME");
        	var dataSource = getTab().getValue(index,"OWNER");
        	getTblAttr().refresh("dataSource="+dataSource+"&tableName="+tableName);
	        for(var i=0;i<getTblAttr().count();i++){
	        	getTblAttr().rowSelected(i,true);
	        	getTblAttr().setValue(i,"MODULE_ID","<%=moduleId%>");
	        }
	        getTblAttr().setEditSts(true);
        }
       
</script>
