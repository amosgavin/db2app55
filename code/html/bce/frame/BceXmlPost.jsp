
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.auto.plugin.qr.PrintUtil"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
	String billId = HttpUtil.getAsString(request,"BillId");
	String idDBArray = HttpUtil.getAsString(request,"keyOfDBArray");
	String idDBRegionIdArray = HttpUtil.getAsString(request,"regionIdArray");
	
	String idSessionArray = HttpUtil.getAsString(request,"keyOfSessionArray");
	String[] idOfDB = null;
	String idOfDBRegionid = null;
	String[] dbBceFrameIdArray = null;
	String[] sessionBceFrameIdArray=null;
	if(!StringUtils.isEmpty(idDBArray) && !StringUtils.isEmpty(idDBRegionIdArray) ){
		idOfDB = idDBArray.split("_");
	    idOfDBRegionid = idDBRegionIdArray.split("_")[0];
	}
    List toXmlInfo=new ArrayList();
    //toXmlInfo=PrintUtil.getPrintBusiInfoForPlat(idOfDBRegionid,idOfDB,billId);
    //String xmlView = BcePrintDataToXml.getXMLDataInfo(toXmlInfo);
%>
<script LANGUAGE="JavaScript">  
 window.onload.openPostWindow("http://10.70.181.228:7003/bp003.go?method=init",xmlView,'BceXmlPost.jsp');
function openPostWindow(url, data, name)    
 {    
    var tempForm = document.createElement("form");    
    tempForm.id="tempForm1";    
     tempForm.method="post";    
     tempForm.action=url;    
     tempForm.target=name;    
  
     var hideInput = document.createElement("input");    
     hideInput.type="hidden";    
     hideInput.name= "content"; 
     hideInput.value= data;  
     tempForm.appendChild(hideInput);     
     tempForm.attachEvent("onsubmit",function(){ openWindow(name); });  
     document.body.appendChild(tempForm);    
  
     tempForm.fireEvent("onsubmit");  
     tempForm.submit();  
     document.body.removeChild(tempForm);  
}  
  
function openWindow(name)    
{    
     window.open('about:blank',name,'height=400, width=400, top=0, left=0, toolbar=yes, menubar=yes, scrollbars=yes, resizable=yes,location=yes, status=yes');     
}    
</script> 
 

