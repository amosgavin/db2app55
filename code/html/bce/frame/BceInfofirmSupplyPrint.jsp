<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<%@page import="com.ai.appframe2.common.ServiceManager"%>
<%@page import="com.ai.bce.util.BceServiceFactory"%>
<%@page import="com.ai.bce.ivalues.IBceQrTemplateValue"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.ai.bce.auto.plugin.qr.PrintUtil"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/frame/BceFrameHead.jsp"%>
<%@page import="com.ai.bce.util.BceUtil"%>
<% 
    String EtCellVersion = "CODEBASE='"+ request.getContextPath()
			+ "/download/ocx/EtCell.CAB#version=3,8,7,408'";
	String regionId  = String.valueOf(ServiceManager.getUser().get("REGION_ID"));
	long bceframeId = HttpUtil.getAsLong(request,BceUtil.BCE_FRAME_ID_KEY);
	String info_nos  = HttpUtil.getAsString(request,"info_nos");
	//String idDBArray = HttpUtil.getAsString(request,"keyOfDBArray");
	//String[]info_nos.split(",");
	String idDBArray = info_nos;
	String region_code = HttpUtil.getAsString(request,"region_code");
	String v_bill_Id = HttpUtil.getAsString(request,"bill_Id");
	String create_date = HttpUtil.getAsString(request,"create_date");
//	String sessionBceFrameIds = HttpUtil.getAsString(request,"SessionFrameId");
//	String dbBceFrameIds = HttpUtil.getAsString(request,"dbBceFrameId");
	IBceQrTemplateValue templateValue  = BceServiceFactory.getBceFrameSV().getTemplateValueByTmmplateId(20111124);
	String[] idOfDB = null;
	String[] idOfSession=null;
	String idOfDBRegionid = null;
	String[] dbBceFrameIdArray = null;
	String[] sessionBceFrameIdArray=null;
	List tmp = new ArrayList();
  
	String billId = HttpUtil.getAsString(request,"BillId");
	

%>

<html>
	<head>
		<title><%=LocaleResourceFactory.getResource("BES0000870") %></title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
		<%if(StringUtils.isNotBlank(templateValue.getJsFile())){
			%>
			<script type="text/javascript" src="<%=request.getContextPath()+templateValue.getJsFile()%>"></script>
			<%			
		} %>
		<script LANGUAGE="JavaScript">
 var  turnValue  = false;
 var returnMsg  = "";
 var billId="<%=v_bill_Id%>";
function getIdOfDBData(){
 	var idOfDBStr = '<%=idDBArray %>';
 	if(null!=idOfDBStr && ""!=idOfDBStr && "null"!=idOfDBStr){
 		return idOfDBStr;
 	}else{
 		return "";
 	}
 }
 
 
 
function init(){   
	//PrintUtil.getSupplyPrintContentMap(region_code,info_nos,v_bill_Id,create_date)
  	//document.getElementById("buttonOK").focus();
  	EtCell.SetPrintLine(true);
  	EtCell.SetPrintMargin(10,70,10,10); 
  	EtCell.SetAutoAdjustTable(1);
  	<%=StringUtils.isNotBlank(templateValue.getJsFunction())?templateValue.getJsFunction()+"()":"" %>
	window.returnValue = "";
}
/*
function doReturn()
{
	doSave();
	window.returnValue = "false";
	turnValue = true;
	window.close();
}*/

function doPrint()
{
	
	
	var isUpdate = "Y";
	//向记录表插入记录
	isUpdate = doSave();
	if("Y"==isUpdate){
	EtCell.PrintPreview();
	//调用方法去更新数据库里的打印数据
	updatePrintState();
	}
	
	//清理用户打印信息缓存
	//clearUserPrintInfoInSession();  
//	EtCell.Print(true);
}
function getPrintId(){
	return EtCell.GetAliasCell("PRINT_ID");
}

	/**
	清楚缓存的该用户的打印信息
	*/
	function clearUserPrintInfoInSession(){
	//var idOfSession = getIdOfSession();
	var url = '<%=request.getContextPath() %>/business/com.asiainfo.crm.so.web.PrintInfoAction?action=clearSessionOfThePrint&BillId='+billId+'&IdOfSessionKey='+idOfSession;
	//alert(url);
    PostInfo(url,'');
	}

 
function updatePrintState(){
 	    var create_date = '<%=create_date %>';
	
		var printId = getPrintId();
		//alert("printId:"+printId);
		//更新数据库里的数据
		var idStr = getIdOfDBData();
	 
		var url = _gModuleName+"/business/com.asiainfo.crm.so.web.PrintInfoAction?action=updatePrintInfoState&BillId="+<%=v_bill_Id %>+"&INFO_PK="+idStr+"&PRINT_ID="+printId+"&create_date="+create_date;
		var ret = PostInfo(url,null);
		var result = ret.getValueByName("result");
		if("N"==result){
			alert("更新打印状态失败");
		}
}
 
function doPrintPreview()
{

	
    return;
}

function doSaveAs(){
  PrintPage.docSave();
}

function doSave(){
 
 	var G_RTUN_QR =_gModuleName+"/business/com.ai.bce.web.BceFrameAction";//合并打印页页面
	var url  =  G_RTUN_QR + "?action=saveOrderInfo&orderid=0&templateId=" + <%=templateValue.getTemplateId()%>  + "&BillId=" + billId + "&printType=2";
 
  	var ret = PostInfo(url,returnMsg);
  	var isTooMuchData = ret.getValueByName("isTooMuchData");
  	if('Y'==isTooMuchData){
  		alert("提示：合并的数据的太多，请重新选择需要合并的工单！");
  		return "N";
  	}else{
  		return "Y";
  	}
 
}

function doSaveBak(){
	//var content=PrintPage.confirmContent.innerHTML;
	var option=document.all.item("saveoption").value;
	//save as html
	if(saveoption[0].checked){
          PrintPage.docSave();
	}
	if(saveoption[1].checked){
		
	}
	//save as pdf
	if(saveoption[2].checked){
	  document.all.item("testHref").href=_gModuleName+"/business/com.asiainfo.boss.so.web.SoFrameAction?action=convertToPdf";
	  document.all.item("testHref").click();
	}
}
function kk(){
	window.returnValue = "false";
	turnValue = false;
	//PostInfo("<%=request.getContextPath()%>/business/com.ai.bce.web.BceFrameAction?action=clearCache","");
	window.close();
	
}

function cannelSubmit(){
	window.returnValue = "false";
	turnValue = false;
	window.close();
}



</script>
		<!--media=print 这个属性可以在打印时有效-->
		<style media=print>
.Noprint {
	display: none;
}

.PageNext {
	page-break-after: always;
}
</style>
	</head>
	<BODY bgcolor="#ffffff" leftmargin="0" topmargin="0" marginwidth="0"
		marginheight="0" onload="init()" onunload="kk()">
		<table boder=1>
			<tr>
				<td align="center">
					<object classid="clsid:20423C49-2276-43D5-BC6D-53829C41AEAD"
						id="EtCell" width="710pt" height="610pt" <%=EtCellVersion%>
						style="display: block">
						<param name="_Version" value="196611">
						<param name="_ExtentX" value="10848">	
						<param name="_ExtentY" value="7091">
						<param name="_StockProps" value="0">
						<param name="FileName"
		                   value="<%=request.getContextPath()+templateValue.getFilePath()%>">
						<param name="Script" value>
						<param name="CanSizeRow" value="-1">
						<param name="CanSizeCol" value="-1">
						<param name="Ruler" value="0">
						<param name="Rows" value="30">
						<param name="Cols" value="30">
						<param name="NotScrollRows" value="0">
						<param name="NotScrollCols" value="0">
						<param name="PrintEtCellBackColor" value="0">
						<param name="PrintCellBackColor" value="-1">
						<param name="FixedCellSelect" value="0">
						<param name="MultiSelect" value="0">
						<param name="PrintHeaderText" value>
						<param name="PrintFooterText" value>
						<param name="PrintHeaderLine" value="0">
						<param name="PrintFooterLine" value="0">
						<param name="PrintPageNo" value="0">
						<param name="PrintDirectH" value="0">
						<param name="PrintFullPage" value="0">
						<param name="ConnectionString" value>
						<param name="DatabaseTableName" value>
						<param name="DatabaseActive" value="0">
						<param name="Border3D" value="0">
						<param name="RunStartScript" value="-1">
						<param name="ReadOnly" value="true">
						<param name="DefaultLibFileName" value>
						<param name="FocusCellShape" value="0">
					</object>
				</td>
			</tr>
		</table>
<br>
<div align="center" id="divSaveBtn" style="">
	
			
			<ai:button id="button" text='<%=LocaleResourceFactory.getResource("BES0000874") %>'  onclick="doPrint()" />
			&nbsp;
			<ai:button id="buttonCancel" text="取  消"  onclick="cannelSubmit()" />
			
</div>
	</BODY>
</HTML>
