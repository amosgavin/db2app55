<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<title>�����ʷ�����</title>
	</head>
	<body>
		<ai:contractframe id="qryInfo" contenttype="table" title="������Ϣ"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:dbform formid="attrForm"
				setname="com.asiainfo.charge.web.SETProductExtDesc"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				initial="false" editable="true">
				<table>
					<tr>
						<td class="td_font">
							��������
						</td>
						<td>
							<ai:dbformfield fieldname="EXT_NAME" formid="attrForm" />
						</td>
						<td class="td_font">
							�ʷ�����
						</td>
						<td>
							<ai:dbformfield fieldname="EXT_TYPE" formid="attrForm" />
						</td>
					</tr>
					

				</table>

			</ai:dbform>
			
		<div class="area_button">

			<ai:button id="saveAttr" text="����" onclick="save()" />
			
		
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
		alert("����д��������");
		return ;
	}
	if(null == extType || "" == extType){
		alert("��ѡ���ʷ����ͣ�");
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
		alert("����ʧ�ܣ�");
	}
	
}

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>