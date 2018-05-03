<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>标识选择</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body >
<ai:contractframe id="saleWeaponMainframe" contenttype="table" title="查询条件" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<table>
		<tr align = "left">
	       <td>专款范围名称查询：</td>
	        <td><input type="text" id="staticName"></td>
	        <td>
			<ai:button id="queryTag" text="查询" onclick="querydtaticbyname()"/></td>
		</tr>
	</table>
</ai:contractframe>
<ai:contractframe id="" contenttype="table" title="专款范围名称(双击确认选中)" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:table setname="com.asiainfo.sale.common.web.SETSaleStaticDate"
			tableid="tagStaticTab"  editable="false"  ondbclick="getTagDetailReturn" 
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			needrefresh="true" pagesize="99" initial="false" width="100%"
			implservice_name="com.asiainfo.sale.common.service.interfaces.ISaleStaticDataSV"
			implservice_querymethod="getSaleStaticDatas(String codeType,String name)"
			implservice_countmethod="queryStaticDateCount(String codeType,String name)" >
            <ai:col   fieldname="CODE_ID" width="10%" editable="false" visible="false"/>
            <ai:col   fieldname="CODE_TYPE" width="10%" editable="false" visible="false"/>		
            <ai:col   fieldname="CODE_NAME" width="98%" editable="false" visible=""/>	
	</ai:table>
</ai:contractframe>
<div class="area_button">
   <ai:button text="关闭" id="close" onclick="window.close();" />&nbsp;&nbsp;
</div>
<ai:loginuser />
<script type="text/javascript">

var TagDetailTable = g_TableRowSetManager.get("tagStaticTab");
var codeType=<%=request.getParameter("codeType")%>;
init();
function init(){
TagDetailTable.refresh("&codeType=" +codeType);
}

function querydtaticbyname(){
var TagDetailTable = g_TableRowSetManager.get("tagStaticTab");
var name=document.getElementById("staticName").value;
TagDetailTable.refresh("&codeType="+codeType+"&name="+encodeURI(trim(name)));
}

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}


function getTagDetailReturn(){
  var curRow = TagDetailTable.getRow();
		   var charge = TagDetailTable.getValue(curRow,"CODE_ID");
		    if(charge==""){
		    alert("请选择");
		    }else{
	    	 window.returnValue = charge;
		    }
		    window.self.close();
}
</script>
</body>
</html>