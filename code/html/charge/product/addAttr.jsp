<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<title>新增资费属性</title>
	</head>
	<body>
		<ai:contractframe id="qryInfo" contenttype="table" title="新增信息"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:dbform formid="attrForm"
				setname="com.asiainfo.charge.web.SETProductExtDesc"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				initial="false" editable="true">
				<table>
					<tr>
						<td class="td_font">
							属性名称
						</td>
						<td>
							<ai:dbformfield fieldname="EXT_NAME" formid="attrForm" />
						</td>
						<td class="td_font">
							资费类型
						</td>
						<td>
							<ai:dbformfield fieldname="EXT_TYPE" formid="attrForm" />
						</td>
					</tr>
					

				</table>

			</ai:dbform>
			
		<div class="area_button">

			<ai:button id="saveAttr" text="保存" onclick="save()" />
			
		
		</div>
			
		</ai:contractframe>
	</body>
</html>
<script language="javascript" type="text/javascript">
var attrForm  =  g_FormRowSetManager.get("attrForm");
function save(){
	
	var extName = attrForm.getValue("EXT_NAME");
	
	var extType = attrForm.getValue("EXT_TYPE");
	if(null == extName || "" == extName){
		alert("请填写属性名称");
		return ;
	}
	if(null == extType || "" == extType){
		alert("请选择资费类型！");
		return;
	}
	var url ="<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeShowAction?action=saveAttr&extName="+trim(extName)+"&extType="+extType;
	var record = PostInfo(url,null);
	
	if(null != record){
		retVal = record.getValueByName("retVal");
		
		if(retVal == "Y"){
		
			alert(record.getValueByName("retMsg"));
			window.close();
		}
		else{
			alert(record.getValueByName("retMsg"));
		}
	}
	else{
		alert("保存失败！");
	}
	
}

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>