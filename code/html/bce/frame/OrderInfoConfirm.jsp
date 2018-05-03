<%@page import="com.ai.appframe2.web.HttpUtil"%>
<%@page import="com.ai.appframe2.common.ServiceManager"%>
<%@page import="com.ai.bce.util.BceServiceFactory"%>
<%@page import="com.ai.bce.ivalues.IBceQrTemplateValue"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.ai.omframe.order.data.ivalues.ISoOrderData" %>
<%@page import="com.ai.bce.auto.plugin.qr.PrintUtil"%>
<%@page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@include file="/bce/frame/BceFrameHead.jsp"%>
<%@page import="com.ai.bce.util.BceUtil"%>
<%
    String EtCellVersion = "CODEBASE='"+ request.getContextPath()
			+ "/download/ocx/EtCell.CAB#version=3,8,7,408'";
	String regionId  = String.valueOf(ServiceManager.getUser().get("REGION_ID"));
	long bceframeId = HttpUtil.getAsLong(request,BceUtil.BCE_FRAME_ID_KEY);
	String orderid  = HttpUtil.getAsString(request,"COUSTOM_ORDER_ID");
	String commPara = HttpUtil.getAsString(request,"COMM_PARA");
	String billId = HttpUtil.getAsString(request, "BILL_ID");
	IBceQrTemplateValue templateValue  = BceServiceFactory.getBceFrameSV().getTemplateValueByframeId(bceframeId);
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
 var printId = "";
 var billId="<%=billId%>";
 
function getPrintId(){
	var printId = EtCell.GetAliasCell("PRINT_ID");
	return printId;
 }
 
function init(){   
	<%=PrintUtil.getPrintContent(bceframeId,orderid,commPara) 
	%>
  	document.getElementById("buttonCancel").disabled = "true";
  	EtCell.SetPrintLine(true);
  	EtCell.SetPrintMargin(10,70,10,10); 
  	EtCell.SetAutoAdjustTable(1);
  	<%=StringUtils.isNotBlank(templateValue.getJsFunction())?templateValue.getJsFunction()+"()":"" %>
  	printId = getPrintId();
	window.returnValue = "";
}
function doReturn()
{	
	doSave();
	updateCheckFlag();
	window.returnValue = "true";
	turnValue = true;
	window.close();
}

function updateCheckFlag(){	
		var url = '<%=request.getContextPath() %>/business/com.asiainfo.crm.so.web.PrintInfoAction?action=updateCheckFlag&BillId='+billId+"&PRINT_ID="+printId;
		PostInfo(url,'');
}

function doPrint()
{	
	document.getElementById("buttonCancel").disabled = "";
	document.getElementById("button").disabled = "true";
	doSave();
	updateCheckFlag();
	EtCell.PrintPreview();
//	EtCell.Print(true);
}
function doPrintPreview()
{

	
    return;
}

function doSaveAs(){
  PrintPage.docSave();
}

function doSave(){
	
 // if(!confirm("<%=LocaleResourceFactory.getResource("BES0000875")%>")){
  	var url = "<%=request.getContextPath()%>/business/com.ai.bce.web.BceFrameAction?action=saveOrderInfo&orderid=<%=orderid %>&templateId=<%=templateValue.getTemplateId()+"&BillId="+billId+"&printType=2&"+BceUtil.encodeUrlQueryString(request)%>";
  	//alert(url);
  	var ret = PostInfo(url,returnMsg);
    return;
  //}
 // PrintPage.saveToDB();
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
	if(!turnValue){
		PostInfo("<%=request.getContextPath()%>/business/com.ai.bce.web.BceFrameAction?action=clearCache","");
	}
}
function cannelSubmit(){
	window.returnValue = "true";
	turnValue = true;
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
			<ai:button id="buttonCancel" text="关  闭"  onclick="cannelSubmit()" />
</div>
	</BODY>
</HTML>
