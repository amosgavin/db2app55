<%@ page contentType="text/html; charset=GBK" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>�����ϴ�</title>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/HtmlParameter.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/CommUtil.js"></script> 
</head>
<body bgcolor="#ffffff">
<ai:contractframe id="applyTagframe" contenttype="table" title="��ʶ������Ϣ" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:dbform formid="queryForm" initial="false"
			setname="com.asiainfo.sale.tag.web.SETApplyTag" editable="true"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		    implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagMainSV"
			implservice_querymethod="getTagMainShowById(String id)">
			
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
			<tr>        	
	           	<td class="td_font">�����ˣ�</td>
	           	<td>
	           		<ai:dbformfield formid="queryForm" fieldname="PRINCIPAL" width="150" editable="false"/>
	           	</td>
	           	<td class="td_font">���뵥λ��</td>
	           	<td>
	           		<ai:dbformfield formid="queryForm" fieldname="PROMOTE_MANAGER" width="150" editable="false"/>
	           	</td>
	           	<td class="td_font">���벿�ţ�</td>
	           	<td>
	           		<ai:dbformfield formid="queryForm" fieldname="PROMOTE_DEPART" width="150" editable="false"/>
	           	</td>
	        </tr>
	      	<tr>
	         	<td class="td_font" >����˵����</td>
				<td colspan="5">
					<ai:dbformfield formid="queryForm" fieldname="CASE" width="600" height="100" editable="ture"/>
				</td>
	         </tr>
	   </table>
	</ai:dbform>
<span class=modeMenuName style="width:70;left:30;z-index:10;" >�ļ��ϴ�</span>
<ai:fileupload name="frmTestUpload"  fileSavePath="" formXmlParamName=""
submitFuncName="doUpload"  savePathStyle="H" showProcessBar="true" onFinishFuncName="doOnFinish" >
  <table width="460" height=150 border=0 cellspacing=0 class=modeContArea >
    <tr align="center">
      <td class="FormTD">
��ѡ��Ҫ�ϴ����ļ�: <input id="importFile" name="importFile" type="file"> <br/>
	</td></tr>
	<tr align="center">
	<td>
  		<input id="submitButton" type="button" value="ɾ��ҳ����ѡ���ļ�" class="B" onclick="delFile()" />  
   		 &nbsp;
<input id="submitButton" type="submit" value="  ȷ  ��  " class="B" />	
&nbsp;
<input id="submitButton" type="button" value="  ȡ  ��  " class="B" onclick="closePage();" />  
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
  //SAVE_PATH=SAVE_PATH.replace("\\","/");//��\����/
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

//ɾ���������Ѿ�ѡ����ļ�
function delFile(){
  if(!confirm("�Ƿ�ȷ��Ҫɾ���������Ѿ�ѡ����ļ���"))return;
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