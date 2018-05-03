<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="attachFrame" contenttype="table" title="�����ļ�(���ȱ�����Ҫ��Ϣ)" width="100%" allowcontract="true" frameclosed="true" >
    <ai:contractitem><ai:button id="deleteAttachFile" text="ɾ    ��" onclick="deleteAttachFile()"/> 
                    <ai:button id="downloadAttachFile" text="��  ��" onclick="doDwonload()"/></ai:contractitem>
  <ai:table tableid="attachFile" editable="false" width="98%" height="150"
              setname="com.asiainfo.sale.common.web.SETNewAttach" pagesize="12"
              needrefresh="true" initial="false" multiselect="true"
              tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
              implservice_name="com.asiainfo.sale.common.service.interfaces.IAttachSV"
            implservice_querymethod="getAttachFileByItemId(int itemId, String itemType,int $STARTROWINDEX,int $ENDROWINDEX)"
              implservice_countmethod="getAttachFileCountByItemId(int itemId, String itemType)">
               <ai:col fieldname="ATTACHID" width="50" visible="false" />
               <ai:col fieldname="FILENAME" width="300"/>
               <ai:col fieldname="STAFFNAME" width="60"/>
               <ai:col fieldname="ORGANIZE_NAME" width="100"/>
               <ai:col fieldname="DEPART" width="150"/>
               <ai:col fieldname="LABEL" width="150"/>
    </ai:table>
<div class="area_button">
<table>
       <tr> <ai:fileupload name="frmTestUpload"  fileSavePath="" formXmlParamName="staffForm"
            submitFuncName="doUpload"  savePathStyle="F" onFinishFuncName="doOnFinish" >
           <td> ��ѡ��Ҫ�ϴ����ļ���</td>
           <td><input id="importFile" name="importFile" type="file" value="���"/></td>
           <td><input id="submitButton" type="submit" value="�ϴ��ļ�"/></td>
           </ai:fileupload>
	</tr>
<table>
<tr>
	<td class="td_font" align="left">��ע��</td>
	<td><span class="font_red">�ϴ�������ʽ���û����� Ԥ����</span></td>
</tr>
</table>	
	
</table>
</div>
</ai:contractframe>
<script type="text/javascript">

function _include_fromAttachFileFormRowSet(){
    return g_TableRowSetManager.get("attachFile");
}



function doUpload(){
	var pid = saleEditPrestoreF.getValue("ID");
    var vmTaskId = "<%=request.getParameter("taskId")%>";
    if("null" == vmTaskId){
        vmTaskId = "kaishi";
    }
    if("" != pid){
        aXmlAry=null;
        // aXmlAry[aXmlAry.length]=getStaffRs();
        var aFileUploadFormObj=frmTestUpload;
        var aFormXmlParamName="";
        var aIsXmlForceFlag=null;
        var aActionUrl="<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AttachAction?action=upload&itemId=" + pid + "&itemType=prestoreCase" + "&taskId=" + vmTaskId;;
        PostUploadInfo(aFileUploadFormObj,aActionUrl,aXmlAry,aFormXmlParamName,aIsXmlForceFlag);
    } else {
        return alert("���ȱ�����Ҫ��Ϣ��");
    }
}

function doOnFinish(aUserDataXml){

  var aFlag=getReturnValueByName(aUserDataXml,"FLAG");
  var aMsg=getReturnValueByName(aUserDataXml,"MSG");
  if(aFlag!="NULL") {
    alert(aMsg);
  }
  if (aFlag=="Y"){
    var obj=new Object();
    obj.isSucc=true;
    var aFileNameList=getReturnValueByName(aUserDataXml,"FILE_NAME_LIST");
    var aVirtualFileName=getReturnValueByName(aUserDataXml,"VIRTUAL_FILE_NAME_LIST");
    obj.fileName=aFileNameList.split(",")[0];
    include_reflashAttachTable();
    //top.returnValue=aFileNameList;
    //top.close();
  }
}

function include_reflashAttachTable(){
	var pid = saleEditPrestoreF.getValue("ID");
	if(""==pid){
		return false;
	}
    var condition = "itemId=" + pid + "&itemType=prestoreCase";
    _include_fromAttachFileFormRowSet().refresh(condition);
}

function deleteAttachFile(pid)
{
	var pid = saleEditPrestoreF.getValue("ID");
    var delRows = _include_fromAttachFileFormRowSet().getSelectedRows();
    var delRowCount = delRows.length;
    if (delRowCount == 0) {
        alert("����ѡ��Ҫɾ�����ļ�");
        return;
    }
    var staffname = g_GetUserInfo().STAFF_NAME;
    
    while (delRowCount > 0) {
        delRowCount--;
        var tmpStaffname = _include_fromAttachFileFormRowSet().getValue(delRows[delRowCount],"STAFFNAME")
        if(staffname != tmpStaffname){
            alert('ֻ��ɾ���Լ��ϴ��ĸ�����');
            return;
        } 
    }
    delRowCount = delRows.length;
    while (delRowCount > 0) {
        delRowCount--;
        _include_fromAttachFileFormRowSet().deleteRow(delRows[delRowCount]);
    }
    var list = new Array();
    list.push(_include_fromAttachFileFormRowSet());
    var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AttachAction?action=deleteAttachFile';
    var ud = saveRowSet(strUrl, list);
    if (ud.getValueByName("FLAG") == "Y") {
        _include_fromAttachFileFormRowSet().refresh("itemId=" + pid + "&itemType=prestoreCase");
    } else {
        alert(ud.getValueByName("MESSAGE"));
        return;
    }
}

function doDwonload()
{
    var selRows = new Array();
    var idList = new Array();
    selRows = _include_fromAttachFileFormRowSet().getSelectedRows();
    if (selRows.length < 1) {
        return alert("��ѡ��һ��Ҫ���ص��ļ�");
    }
    if (selRows.length > 1) {
    	return alert("һ��ֻ������һ���ļ�");
    }
    if(selRows != null && selRows.length > 0)
    {
        var sleRowCount = selRows.length;
        var i = -1;
        while (sleRowCount > 0) {
            sleRowCount--;
            idList[++i] = _include_fromAttachFileFormRowSet().getValue(selRows[sleRowCount], "ATTACHID");
        }
    }
    var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AttachAction?action=downLoadFile&idList='+idList;
    //PostInfo(strUrl, null);
    window.location.href = strUrl;
}

function include_attach_setButtonDisabled(style){
    if (true == style || false == style){
        g_AIButtonManager.get("importFile").setDisabled(style);
        g_AIButtonManager.get("submitButton").setDisabled(style);
        return style;
    } 
}

</script>
