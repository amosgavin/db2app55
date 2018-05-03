<%-- 
	功能说明：资费套餐高级查询
	作者：江晓莉
	创建日期：2013年11月6日

--%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<script language="javascript"
	src="<%=request.getContextPath()%>/jsv2/DBListBox.js"></script>
	
<%
	String extType = HttpUtil.getAsString(request,"extType");
	
%>
<html>
	<head>
		<title>高级查询</title>
	</head>
	<body onload="init()">
		<ai:contractframe id="addQryCond" contenttype="table" title="添加查询属性"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<table>
				<tr>
					<td class="td_font">
						查询属性
					</td>
					<td>
						<ai:listbox ds="com.asiainfo.charge.web.DSProductAttr"
							parameters="privType=" id="privType" width="150" />
					</td>

					<td>
						<ai:button id="addAttr" onclick="addAttr()" text="添加" />
						&nbsp;
						<ai:button id="delAttr" onclick="delAttr()" text="删除" />

					</td>
				</tr>

			</table>

		</ai:contractframe>
		<ai:contractframe id="attrInfo" contenttype="table"
			title="查询属性列表(可对属性值进行修改)" width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:table tableid="attrInfoDetail"
				setname="com.asiainfo.charge.web.SETProductExtDesc"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="" implservice_querymethod=""
				implservice_countmethod="" initial="false" onrowchange=""
				pagesize="100" editable="true" width="100%" height="180"
				needrefresh="false" multiselect="true">
				<ai:col fieldname="EXT_CODE" editable="false" width="30%" />
				<ai:col fieldname="EXT_NAME" editable="false" width="30%"/>
				<ai:col fieldname="EXT1" title="属性值" editable="true" width="30%"/>

			</ai:table>

		</ai:contractframe>
		<div class="area_button">

			<ai:button id="confirm" text="确定" onclick="confirmQry()" />
		

		</div>
	</body>
</html>

<script type="text/javascript" language="javascript">
var table = g_TableRowSetManager.get("attrInfoDetail");
function init(){
	var extType = "<%=extType%>";
	g_getListBox("privType").refresh("privType="+extType);
}
function confirmQry(){
	var totalCounts = table.getTotalRowCount();
	var condStr = "";
	
	for( var i = 0 ; i < totalCounts;i ++){
		var extCode = table.getValue(i,"EXT_CODE");
		var value = table.getValue(i,"EXT1");
		if(""!=condStr){
			condStr+= " and ";
		}
		if(null!=extCode && ""!=extCode &&  null!=value && ""!=value){
			condStr+=extCode+"='"+value+"'";
		}
		
	}

	window.returnValue = condStr;
	window.close();
}

function addAttr(){
	var attrId = g_getListBox("privType").getID();
	var attrName = g_getListBox("privType").getValue();
	
	if(null == attrId || attrId ==""){
		alert("属性为空，不能选择");
		return;
	}
	
	//判断是否重复
	var totalCounts = table.getTotalRowCount();
	
	for( var i = 0 ; i < totalCounts;i ++){
		if(attrId == table.getValue(i,"EXT_CODE")){
			alert("该属性已选择!");
			return;
		}
	}
	
	var rowIndex = table.newRow(true);
	table.setValue(rowIndex,"EXT_CODE",attrId,attrId);
	table.setValue(rowIndex,"EXT_NAME",attrName,attrName);
	table.setValue(rowIndex,"EXT1","1");
	

}

function delAttr(){
 	var selectRows = table.getSelectedRows();
 	if(selectRows.length<=0){
 		alert("请选择要删除的属性");
 		return;
 	}

 	for(var i = 0; i < selectRows.length; i ++){	
 		
 		table.deleteRow(selectRows[i]-i);
 		
 	}
	
}

</script>