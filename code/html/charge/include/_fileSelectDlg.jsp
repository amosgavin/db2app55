<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<ai:contractframe id="attachFrame" contenttype="table" title="�ϴ��ļ�"
	width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem></ai:contractitem>
	<table>
		<tr>
			<ai:fileupload name="frmAttachUpload" fileSavePath=""
				formXmlParamName="staffForm" submitFuncName="doUpload"
				savePathStyle="F" onFinishFuncName="doOnFinish">
				<td>
					��ѡ��Ҫ�������ļ���
				</td>
				<td>
					<input id="importFile" onpropertychange=doUpload(this) name="importFile" type="file" value="���" />
				</td>
				<td>
					<input id="submitButton" type="submit" value="�����ļ�" />
				</td>
			</ai:fileupload>
		</tr>
	</table>
</ai:contractframe>
<script type="text/javascript">

function doUpload(input) {
	var aXmlAry = null;
	var aFileUploadFormObj = frmAttachUpload;
	var aFormXmlParamName = "";
	var aIsXmlForceFlag = null;
	var colNum = <%=request.getParameter("colNum")%>;
	var aActionUrl = _gModuleName
			+ "/business/com.asiainfo.common.web.FileParseAction?action=parseFile&colNum="+colNum;
	PostUploadInfo(aFileUploadFormObj, aActionUrl, aXmlAry, aFormXmlParamName,
			aIsXmlForceFlag);
}

function doOnFinish(aUserDataXml) {
	var aFlag = getReturnValueByName(aUserDataXml, "FLAG");
	if (aFlag != "Y") {
		window.returnValue = "";
		window.self.close();
	}
	var retVal = getReturnValueByName(aUserDataXml, "confs");
	window.returnValue = retVal;
	window.self.close();
}

</script>
