<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title></title>
</head>
<%
	long orgId=SessionManager.getUser().getOrgId();
 %>
<body>
	<center>
	<ai:button id="searchOperBtn" name="searchOperBtn" text="QueryOperator" mo="com.ailk.query" operator="qry" onclick="queryOperator()" />
	&nbsp;&nbsp;
	<ai:button id="searchOperBtn" name="searchOperBtn" text="QueryOrganize" onclick="doOrgQuery()" />
	</center>
</body>
<script type="text/javascript">
	function queryOperator(){
		var url = _gModuleName+"/secframe/common/query/SearchOperator.jsp";
		var retVal = window.showModalDialog(url, null,"scroll:no;resizable:no;status:no;dialogHeight:600px;dialogWidth:400px");
		//alert(retVal);
		//alert(retVal.opId);//����Ա���
		//alert(retVal.opName);//����Ա����
		//alert(retVal.opCode);//����Ա����
		//alert(retVal.orgId);//��֯���
		//alert(retVal.orgName);//��֯����
	}
	function doOrgQuery(){
		var orgId="<%=orgId%>";
		orgSelectDialog(orgId);
	}
</script>
</html>