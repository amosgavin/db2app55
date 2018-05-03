<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ai.appframe2.common.SessionManager" %>  
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface" %>  
<%@ include file="/secframe/common/common.jsp" %>
<%@ include file="/webframe/common/commonhead.jsp" %>

<html>
	<head>
		<title>目标客户群</title>
		<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
		<script language="javascript" src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>
		<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/CommUtil.js"></script>
	</head>
	<body onload="initPage()">
	<ai:contractframe id="formFrame" contenttype="table" title="查询" width="100%" allowcontract="true" frameclosed="fale">
		<ai:contractitem/>
		<ai:dbform formid="custGroupFm" 
				setname="com.asiainfo.sale.activity.web.SETSaleCustGroup"
				conditionname="condition" parametersname="parameters"
				onvalchange="" editable="true" initial="false"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleCustGroupSV"
				implservice_querymethod="getCustGroup(String cityId,String custGroupName, String createDateF, 
				                                      String createDateE, int $STARTROWINDEX, int $ENDROWINDEX)">
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
		        <tr>   	
		           	<td class="td_font">创建地市：</td>
		           	<td><ai:dbformfield formid="custGroupFm" fieldname="CITY_ID" width="90" editable="false"/></td>
		           	<td class="td_font">目标客户群：</td>
		           	<td><ai:dbformfield formid="custGroupFm" fieldname="CUST_GROUP_NAME" width="150"/>(模糊查询)</td>
		        </tr><tr>
		           	<td class="td_font">创建时间（从）：</td>
		           	<td><ai:dbformfield formid="custGroupFm" fieldname="CREATE_DATE" width="90"/></td>
		           	<td class="td_font">创建时间（截至）：</td>
		           	<td><ai:dbformfield formid="custGroupFm" fieldname="CREATE_DATE_END" width="150"/>
				    <ai:button text="查询" onclick="query()"/></td>
				</tr>
			</table>
		</ai:dbform>
	</ai:contractframe>
	
	<ai:contractframe id="tabFrame" contenttype="table" title="目标客户群列表" width="100%" allowcontract="true" frameclosed="false" >
		<ai:contractitem>
		</ai:contractitem>
		<ai:table setname="com.asiainfo.sale.activity.web.SETSaleCustGroup"
				tableid="custGroupTab"  editable="false" multiselect="false" 
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				needrefresh="true" pagesize="30" initial="false" width="100%" height="400" 
				onrowchange="changeColor" ondbclick="sureInfo"
				implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleCustGroupSV"
				implservice_querymethod="getCustGroup(String cityId,String custGroupName, String createDateF, 
				                                      String createDateE, int $STARTROWINDEX, int $ENDROWINDEX)"
				implservice_countmethod="getCustGroupCn(String cityId, String custGroupName, 
				                                        String createDateF, String createDateE)">
	 			<ai:col fieldname="CITY_ID" width="10%" editable="false" visible="true"/>
	 			<ai:col fieldname="CUST_GROUP_NAME" width="35%" editable="false" visible="true"/>
	            <ai:col fieldname="CUST_GROUP_ID" width="25%"  editable="false" visible="true"/>	
	 		    <ai:col fieldname="CUST_GROUP_NUM" width="15%" editable="false" visible="true"/>		
	            <ai:col fieldname="CREATE_DATE" width="15%" editable="false" visible="true"/>
	            <ai:col fieldname="CUST_GROUP_TAB_NAME" width="30%" editable="false" visible="false"/>
		</ai:table>
	</ai:contractframe>
	</body>

<script type="text/javascript">
var custGroupFm = g_FormRowSetManager.get("custGroupFm");
var custGroupTab = g_TableRowSetManager.get("custGroupTab");
function initPage() {
	var cityId= "<%=request.getParameter("orgId")%>";
	if (cityId == '28') {
		cityId = '1';
	} else if (cityId == '10') {
		cityId = '0';
		custGroupFm.setColEditSts("CITY_ID", true);
	}
	custGroupFm.setValue("CITY_ID", cityId);
	custGroupTab.refresh("cityId=" + cityId);
}

function query() {
	var cityId = custGroupFm.getValue("CITY_ID");
	var custGroupName = custGroupFm.getValue("CUST_GROUP_NAME");
	var createDateF = custGroupFm.getValue("CREATE_DATE");
	var createDateE = custGroupFm.getValue("CREATE_DATE_END");
	custGroupTab.refresh("cityId=" + cityId+"&custGroupName="+encodeURI(trim(custGroupName))
		+"&createDateF="+createDateF+"&createDateE="+createDateE);
}

function sureInfo() {
	var selRows = custGroupTab.getSelectedRows();
	var cGroupId=custGroupTab.getValue(selRows,"CUST_GROUP_ID");
	if (cGroupId == "") {
		return alert("请先选定一条记录！")
	}
	var cityId = custGroupTab.getValue(selRows,"CITY_ID");
	var region = "";
	switch (cityId) {
		case  '0':  region=999; break;
		case  '1':  region=728; break;
		case '27':  region=728; break;
		case '11':  region=270; break;
		case '12':  region=714; break;
		case '19':  region=715; break;
		case '13':  region=711; break;
		case '24':  region=722; break;
		case '14':  region=717; break;
		case '16':  region=719; break;
		case '18':  region=728; break;
		case '20':  region=716; break;
		case '15':  region=718; break;
		case '23':  region=724; break;
		case '25':  region=713; break;
		case '17':  region=710; break;
		case '26':  region=712; break;
	}
	var cGroupName=custGroupTab.getValue(selRows,"CUST_GROUP_NAME");
	var cGroupTabName=custGroupTab.getValue(selRows,"CUST_GROUP_TAB_NAME");
	var cGroupNum = custGroupTab.getValue(selRows,"CUST_GROUP_NUM");
	window.returnValue=cGroupId+","+cGroupTabName+","+cGroupName+","+region+","+cGroupNum;
    window.self.close();
}

function changeColor(oldIndex,newIndex){
	if(-1 != oldIndex) {
      custGroupTab.setRowBgColor(oldIndex,"");
    }
      custGroupTab.setRowBgColor(newIndex,"yellow");
}

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>
