<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/HtmlParameter.js"></script>
<title>ģ��021</title>
<!--Fromʾ��ģ��ҳ��˵�� -->
<!--
1����ģ���ƽ̨From��ʹ�ã������ϴ������˼򵥵�ʾ����
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
3����ѯ����ѯ����ֱ���ai:contractframe���÷ָ
4��ai:contractframeʹ��ע�⣺���������100%���߶�������������Ȼ�ſ���allowcontract���ԣ��Ƿ��������� Ĭ��true��ֵ��true/false����frameclosed���ԣ���ʼ��ʱ���������Ƿ��ڹر�״̬��Ĭ��false��ֵ��true/false��
5����ťλ����ע�⣺��ѯ��ťʹ��css��class="td_button"����������ťʹ��css��class="area_button"��;���Ŷ����ť����ʱ���м����2��&nbsp;&nbsp;��
6��ƽ̨DBFrom/button�������ܳ��ֵ���ʽ����ʼ�������ɱ༭���ϴ������ȣ��ɲο����£�
 -->
</head>

<body onLoad="init()">
<ai:contractframe id="�����б�" contenttype="table" title="�����б�" width="100%" allowcontract="true" frameclosed="false">
  <ai:contractitem/>
 <ai:table  tableid="tblAttach"  initial="true" width="100%" pagesize="10" needrefresh="true"
        setname="com.ai.frame.attach.SETSysAttach"  height="220" ondbclick=""
        onrowchange="" oncontextmenu="" >
        <ai:col fieldname="ATTACH_ID" width="10%" visible="true"/>
        <ai:col fieldname="NAME" width="30%"/>
        <ai:col fieldname="FILE_NAME" width="30%"/>
        <ai:col fieldname="REMARKS" width="30%" visible="true"/>
        <ai:col fieldname="BUSI_TYPE_CODE" width="0" visible="false"/>
        <ai:col fieldname="BUSI_SHEET_ID" width="0" visible="false"/>
    </ai:table>
</ai:contractframe>

<ai:contractframe id="��������" contenttype="table" title="��������" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
 <ai:dbform formid="formAttach" setname="com.ai.frame.attach.SETSysAttach" initial="false" >
    <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        <tr>
                <td class="td_font">������ţ�</td>
                <td><ai:dbformfield fieldname="ATTACH_ID" formid="formAttach" visible="true" width="150"/></td>
                <td class="td_font">���ҵ���ţ�</td>
                <td><ai:dbformfield fieldname="BUSI_SHEET_ID"  formid="formAttach" visible="true"  width="150"/></td>
                <td class="td_font">�ϴ�ʱ�䣺</td>
                <td><ai:dbformfield fieldname="BUSI_TYPE_CODE" formid="formAttach" visible="true"   width="150"/></td>
                <td>&nbsp;</td>
        </tr>
        <tr>
                <td class="td_font">�������ƣ�</td>
                <td><ai:dbformfield fieldname="NAME" formid="formAttach" visible="true" width="150" editable="false"/></td>
                <td class="td_font">�ļ�����</td>
                <td colspan="4">
                  <span id= "txt_file_div" style="float:left">
                    <ai:dbformfield fieldname="FILE_NAME" formid="formAttach" visible="true" width="330" editable="false"/>
                  </span>
                    <ai:fileupload name="frmTestUpload"  fileSavePath="" formXmlParamName="" showProcessBar="true"
                      submitFuncName="doUpload"  savePathStyle="H" onFinishFuncName="doOnFinish" >
                      <span id="upload_file_div" style="display:none;float:left">
                      <input id="importFile" style="width:330" name="importFile" type="file" contentEditable="false">   
                      </span>
                    </ai:fileupload>
                <span  id="chkFJ_div" style="display:none;float:left;"><input type=checkbox id="chkFJ" onClick="setUploadFileVisible(this.checked)"  >�޸ĸ���</span>
              </td>
        </tr>
        <tr>
                <td class="td_font">��ע��</td>
                <td colspan="6"><ai:dbformfield fieldname="REMARKS" formid="formAttach" editable="false" visible="true" height="40" width="670"/></td> 
        </tr>
    </table>
</ai:dbform>
</ai:contractframe>

<div class="area_button">
<ai:button  text="�鿴����" name="ftpAttach" id="cmdRead" enable="false"  onclick="readAttach()"/>&nbsp;&nbsp;
<ai:button  text="ɾ��" name="ftpAttach" id="cmdDelete" enable="false" onclick="deleteAttach()"/>&nbsp;&nbsp;
<ai:button  text="����" id="cmdAddNew" name="ftpAttach" onclick="addNewAttach()"/>&nbsp;&nbsp;
<ai:button  text="�޸�" id="cmdChange" enable="false" name="ftpAttach" onclick="modifyAttach()"/>&nbsp;&nbsp;
<ai:button  text="����" name="SaveAttach" id="cmdSave" enable="false" onclick="saveAttach()"/>&nbsp;&nbsp;
<ai:button  text="ȡ��" id="cmdCancel" enable="false" name="closeMe" onclick="cancelSave()"/>
</div>

</body>
</html>
<SCRIPT LANGUAGE="JavaScript" for="window" even="onload">
//��ѯ���ñ�ҳ���ҳ����?xxx=yyy&zzz=111��ʽ���ݵĲ�ѯ����
  BUSI_TYPE_CODE=gHtmlParameter.getParameter("BUSI_TYPE_CODE");  //ҵ��ģ�����
  BUSI_SHEET_ID=gHtmlParameter.getParameter("BUSI_SHEET_ID");  //�ø�����Ӧ����¼��ID��
  
  if_edit=true;
var   spath=null;
  
  //��ǰ�༭ģʽ���������������ΪaddNew ,�޸�Ϊmodify
  var edit_mode ='';
  
  var formRowset = g_FormRowSetManager.get("formAttach");
  
  //��ȡ������
  function  gAttachRowSet(){
    return g_TableRowSetManager.get("tblAttach");//�����б�
  }

  //�����б����������¼�����ʾ��������ϸ��Ϣ
  function gridRowFocusChange(){
      var rowNo=gAttachRowSet().getRow();
      var ATTACH_ID=-1;
      if(rowNo>-1){
        ATTACH_ID=gAttachRowSet().getValue(rowNo,"ATTACH_ID");
        formRowset.refresh("ATTACH_ID=" + ATTACH_ID);
          g_AIButtonManager.get("cmdRead").setDisabled(false);
        if (if_edit==false){
          g_AIButtonManager.get("cmdDelete").setDisabled(true);
          g_AIButtonManager.get("cmdChange").setDisabled(true);
        }else{
          g_AIButtonManager.get("cmdDelete").setDisabled(false);
          g_AIButtonManager.get("cmdChange").setDisabled(false);
        }
      }else{
        formRowset.newRow();
        g_AIButtonManager.get("cmdRead").setDisabled(true);
        g_AIButtonManager.get("cmdDelete").setDisabled(true);
        g_AIButtonManager.get("cmdChange").setDisabled(true);
      }
      
      
      formRowset.setEditSts(false);
      
      
      g_AIButtonManager.get("cmdSave").setDisabled(true);
      g_AIButtonManager.get("cmdCancel").setDisabled(true);
      
      if (if_edit==false){
        g_AIButtonManager.get("cmdaddNew").setDisabled(true);
      }else{
        g_AIButtonManager.get("cmdaddNew").setDisabled(false);
      }
      
      
      document.all("txt_file_div").style.display = "block";
      document.all("upload_file_div").style.display="none";
      document.all("chkFJ_div").style.display="none";
  }

  //��������
  function addNewAttach(){
    if (if_edit==false)return; 
    
    formRowset.newRow();
    formRowset.setEditSts(true);
    formRowset.setValue("BUSI_SHEET_ID",BUSI_SHEET_ID);
    formRowset.setValue("BUSI_TYPE_CODE",BUSI_TYPE_CODE);
    document.all("txt_file_div").style.display = "none";
    document.all("upload_file_div").style.display="block";
    document.all("upload_file_div").innerHTML = "<input id='importFile' style='width:330' name='importFile' type='file' contentEditable='false'>";
    document.all("importFile").value='';
    g_AIButtonManager.get("cmdSave").setDisabled(false);
    g_AIButtonManager.get("cmdRead").setDisabled(true);
    g_AIButtonManager.get("cmdDelete").setDisabled(true);
    g_AIButtonManager.get("cmdChange").setDisabled(true);
    g_AIButtonManager.get("cmdCancel").setDisabled(false);
    g_AIButtonManager.get("cmdaddNew").setDisabled(true);
    edit_mode = 'addNew';
  }
  
  //���渽��
  function saveAttach(){
  alert(spath);
    if (if_edit==false)return; 
    //��������
    if(edit_mode == 'addNew'){
      if(document.all("importFile").value==''){
        alert('�Բ�����ѡ����Ҫ�ϴ����ļ�!');
        document.all("importFile").focus();
        return;
      }
      formRowset.setValue("ATTACH_ID","0");
      document.all("frmTestUpload").submit();
    }
    
    //�޸ı���
    else if(edit_mode == 'modify'){
    
      //�����Ҫ�޸ĸ����ļ�
      if(document.all("chkFJ").checked){
        if(document.all("importFile").value==''){
          alert('�Բ�����ѡ����Ҫ�ϴ����ļ�!');
          document.all("importFile").focus();
          return;
        }
        document.all("frmTestUpload").submit();
      }
      //ֻ�޸ĸ�������
      else{
        if(formRowset.toXmlString(true)==''){
          alert('��ǰ����û�б��޸ģ�����Ҫ���棡');
          return;
        }
        var list = new Array();
        list[list.length]=(formRowset);
        var r=saveRowSet('<%=request.getContextPath()%>/business/com.ai.frame.attach.AttachAction?action=saveAttach&pFilePath=' 
          +spath,list).getValueByName("retValue");;
        
        var row=gAttachRowSet().getRow();
        refreshList();
        gAttachRowSet().setRow(row);
        //gridRowFocusChange();
        formRowset.setEditSts(false);
        document.all("txt_file_div").style.display = "block";
        document.all("upload_file_div").style.display="none";
        document.all("chkFJ_div").style.display="none";
      }    
    }
    
    
  }
  
  //ȡ������
  function cancelSave(){
      g_AIButtonManager.get("cmdCancel").setDisabled(true);
      g_AIButtonManager.get("cmdaddNew").setDisabled(false);
      g_AIButtonManager.get("cmdSave").setDisabled(true);
      g_AIButtonManager.get("cmdChange").setDisabled(true);
      var tablerowset = gAttachRowSet();
      if(tablerowset.getRow()>=0){
        gridRowFocusChange();
      }
      else{
        formRowset.setEditSts(false);
      }
      
      document.all("txt_file_div").style.display = "block";
      document.all("upload_file_div").style.display="none";
      document.all("chkFJ_div").style.display="none";
      edit_mode = ''
  }
  
  
  //�޸ĸ���
  function modifyAttach(){
    if (if_edit==false)return; 
    
    edit_mode = 'modify';
    g_AIButtonManager.get("cmdSave").setDisabled(false);
    g_AIButtonManager.get("cmdRead").setDisabled(true);
    g_AIButtonManager.get("cmdDelete").setDisabled(true);
    g_AIButtonManager.get("cmdChange").setDisabled(true);
    g_AIButtonManager.get("cmdCancel").setDisabled(false);
    g_AIButtonManager.get("cmdaddNew").setDisabled(true);
    formRowset.setEditSts(true);
    
    document.all("upload_file_div").innerHTML = "<input id='importFile' style='width:330' name='importFile' type='file' contentEditable='false'>";
    document.all("chkFJ_div").style.display="block";
    document.all("chkFJ").checked =false;
    document.all("importFile").value='';
  }
  //ɾ������
  function deleteAttach(){
    if (if_edit==false)return; 
    
    var newRow=gAttachRowSet().getRow();
    if (newRow==-1){
        alert("����Ҫ�޸ĵ��������ϵ���Ҽ���ѡ��ɾ����");
        return;
    }
    var attach_name=gAttachRowSet().getValue(newRow,"NAME");
    if (confirm("ȷ��ɾ������ "+attach_name+" ��")==false)return;
    
    gAttachRowSet().deleteRow(newRow);
    var list = new Array();
    list[list.length]=(gAttachRowSet());
  	var r=saveRowSet('<%=request.getContextPath()%>/business/com.ai.frame.attach.AttachAction?action=saveAttach&pFilePath='+spath,list).getValueByName("retValue");;
  	if (r.substring(0,1)=="S"){
      gridRowFocusChange();
		  alert(r.substring(1,r.length));
  	}
  }

  //���ĸ����ļ�
  function readAttach(){
    var newRow=gAttachRowSet().getRow();
        if (newRow==-1){
        alert("����Ҫ�޸ĵ��������ϵ���Ҽ���ѡ���Ķ�������");
        return;
    }
    var filename=gAttachRowSet().getValue(newRow,"FILE_NAME");
    var mylabel=gAttachRowSet().getValue(newRow,"NAME");
    myurl=spath+"/"+filename;
    filename=g_StringTrim(filename);
    window.open ('<%=request.getContextPath()%>/business/com.ai.frame.attach.AttachAction?action=doDownload&spath=' + spath + '&FILE_NAME='+myurl); 
  }
  
  //�����ļ�·��ȫ����ȡ�ļ���
  function trimFileName(InFile){
    if (InFile==null){
      return "";
    }
    var file_len=InFile.length;
    var s = InFile.lastIndexOf("\\");
    if (s>0){
      return InFile.substring(s+1,file_len);
    }else{
      return InFile;
    }
  }

 //ˢ�¸����б�
 function refreshList(){
	/**���ݸ������ͱ�ź�ҵ����ȡ�����и�ҵ��ĸ����ļ���Ϣ**/
   var param="BUSI_TYPE_CODE='"+BUSI_TYPE_CODE+"' and BUSI_SHEET_ID='"+BUSI_SHEET_ID+"' order by attach_id";
   gAttachRowSet().refresh(param);
 }

	/**����Ϊ�Ҽ��˵�*/
  var model = new AIPopMenuModel();
  var popMenu;
  function createMenu(){
 	 //������ܱ༭
 	 //��ɾ����ɾ�Ĳ˵�
 	 model.addPopMenuItem("readAttach","�鿴��������",null,"readAttach()");
	 
  	popMenu = new AIPopMenu(model);
  	document.onclick=hidePopMenu;
  }
  
  //��ʾ�Ҽ��˵�
  function showPopMenu()
  {
    popMenu.showPopMenu();
    window.returnValue=false;
    return false;
  }
  
  //�����Ҽ��˵�
  function hidePopMenu()
  {
    popMenu.hidePopMenu();
  }
  /**�Ҽ��˵�����*/


  //�ϴ������������� 
  function doUpload(){
      var para="";
      var resu="";
      var sFile=trimFileName(document.all.item("importFile").value);
      if (sFile==null||g_StringTrim(sFile)==""){
         return;
      }
    // spath=spath.replace("\\","/");//��\����/
     var aXmlAry=null;
     var aFileUploadFormObj=frmTestUpload;
     var aFormXmlParamName=null;
     var aIsXmlForceFlag=null;
     var aActionUrl="<%=request.getContextPath()%>/business/com.ai.frame.attach.AttachAction?action=doUpload";
     document.all.APPFRAME_TARGET_UPLOAD_PATH.value=resu+"/"+spath;
     PostUploadInfo(aFileUploadFormObj,aActionUrl,aXmlAry,aFormXmlParamName,aIsXmlForceFlag)
  }
  
  //�����ϴ���Ϻ�Ĳ���
  function doOnFinish(aUserDataXml){
    var aFlag=getReturnValueByName(aUserDataXml,"FLAG");
    var aMsg=getReturnValueByName(aUserDataXml,"MSG");
    if (aFlag=="Y"){
      var aVirtualFileName=getReturnValueByName(aUserDataXml,"VIRTUAL_FILE_NAME_LIST");
      formRowset.setValue("FILE_NAME",aVirtualFileName)
      
      if(formRowset.getValue("NAME")==''){
        var aFileNameList=getReturnValueByName(aUserDataXml,"FILE_NAME_LIST");
        aFileNameList = trimFileName(aFileNameList);
        formRowset.setValue("NAME",aFileNameList);
      }
      
      var list = new Array();
      list[list.length]=(formRowset);
      var r=saveRowSet('<%=request.getContextPath()%>/business/com.ai.frame.attach.AttachAction?action=saveAttach&pFilePath=' 
        +spath,list).getValueByName("retValue");;
      
      refreshList();
      var tablerowset = g_TableRowSetManager.get("tblAttach");
      
      if(tablerowset.getRow()>=0){
        gridRowFocusChange();
      }else{
        tablerowset.setRow(tablerowset.count()-1);
      }
      formRowset.setEditSts(false);
      document.all("txt_file_div").style.display = "block";
      document.all("upload_file_div").style.display="none";
      document.all("chkFJ_div").style.display="none";
      alert('����ɹ���');
    }
  }
  
  //ҳ����غ�ĳ�ʼ������
  function init(){
    IF_CAN_EDIT=gHtmlParameter.getParameter("IF_CAN_EDIT");     //�����Ƿ���Ա༭
    if (IF_CAN_EDIT=="-1"){
      if_edit=false;
    }
    if (BUSI_TYPE_CODE==null){
      BUSI_TYPE_CODE=0;
      //alert("δ����ҵ�����Ͳ���!");
      return;
    }
  
    if (BUSI_SHEET_ID==null){
      BUSI_SHEET_ID=0;
      //alert("δ����ҵ���Ų���!");
      return;
    }
  
    //ȡ��ҵ�����͸����Ĵ��·��
    //���ݸ������ͱ��ȡ�ø��������ļ��Ĵ��·��
    var param=g_ConditonStrEncode("BUSI_TYPE_CODE='"+BUSI_TYPE_CODE+"'");
    param="?action=queryRowSet&setName=com.ai.frame.attach.SETSysBusiType&param="+param;
  
    var gRowSet1 = g_NormalRowSetManager.create("dual","<%=request.getContextPath()%>/business/com.ai.appframe2.web.DefaultAction"+param);

    if(gRowSet1==null||gRowSet1.count() == 0){
      alert("ȡ�����ļ����·��ʧ��,���ϵͳ����Ա��ϵ!��");
      return;
    }
    
    spath=gRowSet1.getValue(0,"SAVE_PATH");
    refreshList();
    createMenu();
    
    if (if_edit==false){
      g_AIButtonManager.get("cmdaddNew").setDisabled(true);
    }
  }
  
  
  
  //�����޸İ�ť�Ŀɼ�/���ɼ�״̬
  function setUploadFileVisible(sts){
    if(sts){
      document.all("txt_file_div").style.display = "none";
      document.all("upload_file_div").style.display="block";
    }else{
      document.all("txt_file_div").style.display = "block";
      document.all("upload_file_div").style.display="none";
    
    }
  }
</script>