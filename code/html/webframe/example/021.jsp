<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/HtmlParameter.js"></script>
<title>模板021</title>
<!--From示例模板页面说明 -->
<!--
1、本模板对平台From表单使用（附件上传）做了简单的示例；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、查询及查询结果分别用ai:contractframe套用分割；
4、ai:contractframe使用注意：宽度请设置100%，高度由里面内容自然撑开；allowcontract属性（是否允许收缩 默认true，值：true/false）；frameclosed属性（初始化时内容区域是否处于关闭状态，默认false，值：true/false）
5、按钮位置请注意：查询按钮使用css（class="td_button"）；操作按钮使用css（class="area_button"）;并排多个按钮存在时，中间请加2个&nbsp;&nbsp;；
6、平台DBFrom/button联动可能出现的样式（初始化、不可编辑、上传附件等）可参考以下；
 -->
</head>

<body onLoad="init()">
<ai:contractframe id="附件列表" contenttype="table" title="附件列表" width="100%" allowcontract="true" frameclosed="false">
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

<ai:contractframe id="附件管理" contenttype="table" title="附件管理" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
 <ai:dbform formid="formAttach" setname="com.ai.frame.attach.SETSysAttach" initial="false" >
    <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        <tr>
                <td class="td_font">附件编号：</td>
                <td><ai:dbformfield fieldname="ATTACH_ID" formid="formAttach" visible="true" width="150"/></td>
                <td class="td_font">相关业务编号：</td>
                <td><ai:dbformfield fieldname="BUSI_SHEET_ID"  formid="formAttach" visible="true"  width="150"/></td>
                <td class="td_font">上传时间：</td>
                <td><ai:dbformfield fieldname="BUSI_TYPE_CODE" formid="formAttach" visible="true"   width="150"/></td>
                <td>&nbsp;</td>
        </tr>
        <tr>
                <td class="td_font">附件名称：</td>
                <td><ai:dbformfield fieldname="NAME" formid="formAttach" visible="true" width="150" editable="false"/></td>
                <td class="td_font">文件名：</td>
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
                <span  id="chkFJ_div" style="display:none;float:left;"><input type=checkbox id="chkFJ" onClick="setUploadFileVisible(this.checked)"  >修改附件</span>
              </td>
        </tr>
        <tr>
                <td class="td_font">备注：</td>
                <td colspan="6"><ai:dbformfield fieldname="REMARKS" formid="formAttach" editable="false" visible="true" height="40" width="670"/></td> 
        </tr>
    </table>
</ai:dbform>
</ai:contractframe>

<div class="area_button">
<ai:button  text="查看附件" name="ftpAttach" id="cmdRead" enable="false"  onclick="readAttach()"/>&nbsp;&nbsp;
<ai:button  text="删除" name="ftpAttach" id="cmdDelete" enable="false" onclick="deleteAttach()"/>&nbsp;&nbsp;
<ai:button  text="新增" id="cmdAddNew" name="ftpAttach" onclick="addNewAttach()"/>&nbsp;&nbsp;
<ai:button  text="修改" id="cmdChange" enable="false" name="ftpAttach" onclick="modifyAttach()"/>&nbsp;&nbsp;
<ai:button  text="保存" name="SaveAttach" id="cmdSave" enable="false" onclick="saveAttach()"/>&nbsp;&nbsp;
<ai:button  text="取消" id="cmdCancel" enable="false" name="closeMe" onclick="cancelSave()"/>
</div>

</body>
</html>
<SCRIPT LANGUAGE="JavaScript" for="window" even="onload">
//查询调用本页面的页面用?xxx=yyy&zzz=111方式传递的查询参数
  BUSI_TYPE_CODE=gHtmlParameter.getParameter("BUSI_TYPE_CODE");  //业务模块代码
  BUSI_SHEET_ID=gHtmlParameter.getParameter("BUSI_SHEET_ID");  //该附件对应主记录的ID号
  
  if_edit=true;
var   spath=null;
  
  //当前编辑模式，如果是新增，则为addNew ,修改为modify
  var edit_mode ='';
  
  var formRowset = g_FormRowSetManager.get("formAttach");
  
  //获取表格对象
  function  gAttachRowSet(){
    return g_TableRowSetManager.get("tblAttach");//附件列表
  }

  //附件列表表格鼠标左键事件，显示附件的详细信息
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

  //新增附件
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
  
  //保存附件
  function saveAttach(){
  alert(spath);
    if (if_edit==false)return; 
    //新增保存
    if(edit_mode == 'addNew'){
      if(document.all("importFile").value==''){
        alert('对不起，请选择需要上传的文件!');
        document.all("importFile").focus();
        return;
      }
      formRowset.setValue("ATTACH_ID","0");
      document.all("frmTestUpload").submit();
    }
    
    //修改保存
    else if(edit_mode == 'modify'){
    
      //如果需要修改附件文件
      if(document.all("chkFJ").checked){
        if(document.all("importFile").value==''){
          alert('对不起，请选择需要上传的文件!');
          document.all("importFile").focus();
          return;
        }
        document.all("frmTestUpload").submit();
      }
      //只修改附件名称
      else{
        if(formRowset.toXmlString(true)==''){
          alert('当前数据没有被修改，不需要保存！');
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
  
  //取消保存
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
  
  
  //修改附件
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
  //删除附件
  function deleteAttach(){
    if (if_edit==false)return; 
    
    var newRow=gAttachRowSet().getRow();
    if (newRow==-1){
        alert("请在要修改的数据行上点击右键并选择删除！");
        return;
    }
    var attach_name=gAttachRowSet().getValue(newRow,"NAME");
    if (confirm("确认删除附件 "+attach_name+" 吗？")==false)return;
    
    gAttachRowSet().deleteRow(newRow);
    var list = new Array();
    list[list.length]=(gAttachRowSet());
  	var r=saveRowSet('<%=request.getContextPath()%>/business/com.ai.frame.attach.AttachAction?action=saveAttach&pFilePath='+spath,list).getValueByName("retValue");;
  	if (r.substring(0,1)=="S"){
      gridRowFocusChange();
		  alert(r.substring(1,r.length));
  	}
  }

  //查阅附件文件
  function readAttach(){
    var newRow=gAttachRowSet().getRow();
        if (newRow==-1){
        alert("请在要修改的数据行上点击右键并选择阅读附件！");
        return;
    }
    var filename=gAttachRowSet().getValue(newRow,"FILE_NAME");
    var mylabel=gAttachRowSet().getValue(newRow,"NAME");
    myurl=spath+"/"+filename;
    filename=g_StringTrim(filename);
    window.open ('<%=request.getContextPath()%>/business/com.ai.frame.attach.AttachAction?action=doDownload&spath=' + spath + '&FILE_NAME='+myurl); 
  }
  
  //根据文件路径全名获取文件名
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

 //刷新附件列表
 function refreshList(){
	/**根据附件类型编号和业务编号取得所有该业务的附件文件信息**/
   var param="BUSI_TYPE_CODE='"+BUSI_TYPE_CODE+"' and BUSI_SHEET_ID='"+BUSI_SHEET_ID+"' order by attach_id";
   gAttachRowSet().refresh(param);
 }

	/**以下为右键菜单*/
  var model = new AIPopMenuModel();
  var popMenu;
  function createMenu(){
 	 //如果不能编辑
 	 //则删除增删改菜单
 	 model.addPopMenuItem("readAttach","查看附件内容",null,"readAttach()");
	 
  	popMenu = new AIPopMenu(model);
  	document.onclick=hidePopMenu;
  }
  
  //显示右键菜单
  function showPopMenu()
  {
    popMenu.showPopMenu();
    window.returnValue=false;
    return false;
  }
  
  //隐藏右键菜单
  function hidePopMenu()
  {
    popMenu.hidePopMenu();
  }
  /**右键菜单结束*/


  //上传附件到服务器 
  function doUpload(){
      var para="";
      var resu="";
      var sFile=trimFileName(document.all.item("importFile").value);
      if (sFile==null||g_StringTrim(sFile)==""){
         return;
      }
    // spath=spath.replace("\\","/");//把\换成/
     var aXmlAry=null;
     var aFileUploadFormObj=frmTestUpload;
     var aFormXmlParamName=null;
     var aIsXmlForceFlag=null;
     var aActionUrl="<%=request.getContextPath()%>/business/com.ai.frame.attach.AttachAction?action=doUpload";
     document.all.APPFRAME_TARGET_UPLOAD_PATH.value=resu+"/"+spath;
     PostUploadInfo(aFileUploadFormObj,aActionUrl,aXmlAry,aFormXmlParamName,aIsXmlForceFlag)
  }
  
  //附件上传完毕后的操作
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
      alert('保存成功！');
    }
  }
  
  //页面加载后的初始化操作
  function init(){
    IF_CAN_EDIT=gHtmlParameter.getParameter("IF_CAN_EDIT");     //附件是否可以编辑
    if (IF_CAN_EDIT=="-1"){
      if_edit=false;
    }
    if (BUSI_TYPE_CODE==null){
      BUSI_TYPE_CODE=0;
      //alert("未传入业务类型参数!");
      return;
    }
  
    if (BUSI_SHEET_ID==null){
      BUSI_SHEET_ID=0;
      //alert("未传入业务编号参数!");
      return;
    }
  
    //取该业务类型附件的存放路径
    //根据附件类型编号取该附件类型文件的存放路径
    var param=g_ConditonStrEncode("BUSI_TYPE_CODE='"+BUSI_TYPE_CODE+"'");
    param="?action=queryRowSet&setName=com.ai.frame.attach.SETSysBusiType&param="+param;
  
    var gRowSet1 = g_NormalRowSetManager.create("dual","<%=request.getContextPath()%>/business/com.ai.appframe2.web.DefaultAction"+param);

    if(gRowSet1==null||gRowSet1.count() == 0){
      alert("取附件文件存放路径失败,请和系统管理员联系!！");
      return;
    }
    
    spath=gRowSet1.getValue(0,"SAVE_PATH");
    refreshList();
    createMenu();
    
    if (if_edit==false){
      g_AIButtonManager.get("cmdaddNew").setDisabled(true);
    }
  }
  
  
  
  //设置修改按钮的可见/不可见状态
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