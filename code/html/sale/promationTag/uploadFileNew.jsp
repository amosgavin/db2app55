<%@ page contentType="text/html; charset=GBK" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>附件上传</title>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/HtmlParameter.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/CommUtil.js"></script> 
</head>
<body bgcolor="#ffffff">
<ai:contractframe id="applyTagframe" contenttype="table" title="标识申请信息" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:dbform formid="queryForm" initial="false"
			setname="com.asiainfo.sale.tag.web.SETApplyTag" editable="true"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		    implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagMainSV"
			implservice_querymethod="getTagMainShowById(String id)">
			
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
			<tr>        	
	           	<td class="td_font">申请人：</td>
	           	<td>
	           		<ai:dbformfield formid="queryForm" fieldname="PRINCIPAL" width="150" editable="false"/>
	           	</td>
	           	<td class="td_font">申请单位：</td>
	           	<td>
	           		<ai:dbformfield formid="queryForm" fieldname="PROMOTE_MANAGER" width="150" editable="false"/>
	           	</td>
	           	<td class="td_font">申请部门：</td>
	           	<td>
	           		<ai:dbformfield formid="queryForm" fieldname="PROMOTE_DEPART" width="150" editable="false"/>
	           	</td>
	        </tr>
	      	<tr>
	         	<td class="td_font" >申请说明：</td>
				<td colspan="5">
					<ai:dbformfield formid="queryForm" fieldname="CASE" width="600" height="100" editable="ture"/>
				</td>
	         </tr>
	   </table>
	</ai:dbform>
<span class=modeMenuName style="width:70;left:30;z-index:10;" >文件上传</span>
<ai:fileupload name="frmTestUpload"  fileSavePath="" formXmlParamName=""
submitFuncName="doUpload"  savePathStyle="H" showProcessBar="true" onFinishFuncName="doOnFinish" >
  <table width="460" height=150 border=0 cellspacing=0 class=modeContArea >
    <tr align="center">
      <td class="FormTD">
请选择要上传的文件: <input id="importFile" name="importFile" type="file"> <br/>
	</td></tr>
	<tr align="center">
	<td>
  		<input id="submitButton" type="button" value="删除页面已选择文件" class="B" onclick="delFile()" />  
   		 &nbsp;
<input id="submitButton" type="submit" value="  确  定  " class="B" />	
&nbsp;
<input id="submitButton" type="button" value="  取  消  " class="B" onclick="closePage();" />  
  </td>
    </tr>
  </table>    
</ai:fileupload>
</ai:contractframe>
<script language="javascript">
 //   SAVE_PATH=gHtmlParameter.getParameter("SAVE_PATH");
	//if (!SAVE_PATH){
	//	SAVE_PATH="";
	//}
  //SAVE_PATH=SAVE_PATH.replace("\\","/");//把\换成/
function doUpload(){
  var aXmlAry=new Array();
  aXmlAry[aXmlAry.length]=getStaffRs();
  var aFileUploadFormObj=frmTestUpload;
  var aFormXmlParamName="staffForm";
  var aIsXmlForceFlag=null;
  var aActionUrl="<%=request.getContextPath()%>/business/com.asiainfo.demo.TestUploadAction?action=testUpload&param1=test1&param2=test2";
  PostUploadInfo(aFileUploadFormObj,aActionUrl,aXmlAry,aFormXmlParamName,aIsXmlForceFlag);
}

function doOnFinish(aUserDataXml){
  var aFlag=getReturnValueByName(aUserDataXml,"FLAG");
  var aMsg=getReturnValueByName(aUserDataXml,"MSG");
  alert(aMsg);
  if (aFlag=="Y"){
  	var obj=new Object();
  	obj.isSucc=true;
  	var aFileNameList=getReturnValueByName(aUserDataXml,"FILE_NAME_LIST");
  	var aVirtualFileName=getReturnValueByName(aUserDataXml,"VIRTUAL_FILE_NAME_LIST");
  	obj.fileName=aFileNameList.split(",")[0];
  	obj.virtualFileName=aVirtualFileName.split(",")[0];
  	top.returnValue=obj;
   	if(parent.document.getElementById('attachFrame')!=null && parent.document.getElementById('divFrame')!=null){
   		parent.document.getElementById('attachFrame').style.display = 'none';
   		parent.document.getElementById('divFrame').style.display = 'none';
		var name = parent.document.getElementById("attachFrame").title;
		parent.attachIncSetFileName(name, obj);
   	} else{
    	top.close();
    }
  }
}

function getStaffRs(){
  return g_FormRowSetManager.get("queryForm");
}

//删除主界面已经选择的文件
function delFile(){
  if(!confirm("是否确定要删除主界面已经选择的文件？"))return;
  var obj=new Object();
  obj.isSucc=true;
  obj.virtualFileName='';
  top.returnValue=obj;
   	if(parent.document.getElementById('attachFrame')!=null && parent.document.getElementById('divFrame')!=null){
   		parent.document.getElementById('attachFrame').style.display = 'none';
   		parent.document.getElementById('divFrame').style.display = 'none';
		var name = parent.document.getElementById("attachFrame").title;
   	} else{
    	top.close();
    }
}

    function trimFileName(InFile){
      var file_len=InFile.length;
      var s = InFile.lastIndexOf("\\");
      if (s>0){
        return InFile.substring(s+1,file_len);
      }else{
        return InFile;
      }
    }
    
    function hidePage(){
    	if(parent.document.getElementById('attachFrame')!=null){
    		parent.document.getElementById('attachFrame').style.display = 'none';
    	}
    	if(parent.document.getElementById('divFrame')!=null){
    		parent.document.getElementById('divFrame').style.display = 'none';
    	}
    }
    
    function closePage(){
    	if(parent.document.getElementById('attachFrame')!=null){
    		hidePage();
    	} else{
    		window.close();
    	}
    }
    
</script>
</body>
</html>