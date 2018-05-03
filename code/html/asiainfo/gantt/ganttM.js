
/*
*DES:甘特图
*DATE:2006-11-17
*USE:var gantt = new Gantt();
*			gantt.Init("开始日期","结束日期",左表头数组);
*			gantt.addWbsData(id,pid,"开始日期","结束日期",当前完成率,数组,URL);//注：数组长度与“左表头数组”长度一致;没有父任务的，pid =0
*			gantt.DrawGantt();
*AUTHOR:YUANJQ
*/
function Gantt(){
	this.startDate;
	this.endDate;
	this.isFixTableHeader = true;//是否固定表头，true:是，false:否
	this.parentLineColor = "#000000"; //非叶子任务颜色
	this.childLineColor = "#0000AF"; //叶子任务颜色
	this.percentCompleteRateColor = "#FFFFED";
	
	this.WbsStartDate;
	this.WbsEndDate;
	this.percentCompleteRate;
	this.URLS;
	this.WbsDataArray;
	this.leftHeadNameArray;
	
	this.Gantt;
	this.tHead;
	this.tBody;
	
	this.pidArray = new Array();
}
Gantt.prototype.setStartDate =function(DateStr){
	this.startDate = new Date(DateStr.replace(/-/g,"/"));
		//把开始日期调到星期一
	if(this.startDate.getDay() == 0)
	{
		this.startDate.setDate(this.startDate.getDate() - 6);
	}
	else
	{
		this.startDate.setDate(this.startDate.getDate() - (this.startDate.getDay() - 1));
	}
}
Gantt.prototype.getStartDate =function(){
	return this.startDate;
}
Gantt.prototype.setEndDate =function(DateStr){
	this.endDate = new Date(DateStr.replace(/-/g,"/"));
	
	//默认甘特图为一个月，以给用户更好的视觉效果
	if((this.endDate.getTime() - this.startDate.getTime())/1000/60/60/24 < 20 )
	{
		var ttday = 30 - (this.endDate.getTime() - this.startDate.getTime())/1000/60/60/24;
		this.endDate.setDate(this.endDate.getDate() + parseInt(ttday));
	}
	//把结束日期调到星期天
	if(this.endDate.getDay() == 0)
	{
		//为方面显示后面的数据，将周数往后移一周 +7
		this.endDate.setDate(this.endDate.getDate() + 7);
	}
	else
	{
		this.endDate.setDate(this.endDate.getDate() + (7 - this.endDate.getDay()) + 7);
	}
}
Gantt.prototype.getEndDate =function(){
	return this.endDate;
}
Gantt.prototype.setWbsStartDate =function(DateStr){
	this.WbsStartDate = new Date(DateStr.replace(/-/g,"/"));
}
Gantt.prototype.getWbsStartDate =function(DateStr){
	return this.WbsStartDate;
}
Gantt.prototype.setWbsEndDate =function(DateStr){
	this.WbsEndDate = new Date(DateStr.replace(/-/g,"/"));
}
Gantt.prototype.getWbsEndDate =function(DateStr){
	return this.WbsEndDate;
}
Gantt.prototype.setWbsDataArray =function(aWbsDataArray){
	this.WbsDataArray = aWbsDataArray;
}
Gantt.prototype.getWbsDataArray =function(){
	return this.WbsDataArray;
}
Gantt.prototype.setLeftHeadNameArray =function(aWbsDataArray){
	this.leftHeadNameArray = aWbsDataArray;
}
Gantt.prototype.getLeftHeadNameArray =function(){
	return this.leftHeadNameArray;
}
Gantt.prototype.setIsFixTableHeader =function(bool){
	this.isFixTableHeader = bool;
}
Gantt.prototype.getIsFixTableHeader =function(){
	return this.isFixTableHeader;
}
Gantt.prototype.setURLS =function(URLS){
	this.URLS = URLS;
}
Gantt.prototype.getURLS =function(){
	return this.URLS;
}
Gantt.prototype.setPercentCompleteRate =function(percentCompleteRate){
	this.percentCompleteRate = percentCompleteRate;
}
Gantt.prototype.getPercentCompleteRate =function(){
	return this.percentCompleteRate;
}
Gantt.prototype.setParentLineColor =function(parentLineColor){
	this.parentLineColor = parentLineColor;
}
Gantt.prototype.getParentLineColor =function(){
	return this.parentLineColor;
}
Gantt.prototype.setChildLineColor =function(childLineColor){
	this.childLineColor = childLineColor;
}
Gantt.prototype.getChildLineColor =function(){
	return this.childLineColor;
}
Gantt.prototype.setPercentCompleteRateColor =function(percentCompleteRateColor){
	this.percentCompleteRateColor = percentCompleteRateColor;
}
Gantt.prototype.getPercentCompleteRateColor =function(){
	return this.percentCompleteRateColor;
}
//生成表头
Gantt.prototype.Init =function(sDateStr,eDateStr,aWbsDataArray){
	this.setStartDate(sDateStr);
	this.setEndDate(eDateStr);
	this.setLeftHeadNameArray(aWbsDataArray);
	
	var tableLeftColumnNum=aWbsDataArray.length;
	var tableRightColumnNum=(this.getEndDate()-this.getStartDate())/1000/60/60/24 + 1;//+1表加上开始一天
	var tableTotalColumnNum=tableLeftColumnNum+tableRightColumnNum;	
	this.Gantt = document.createElement("<table id='gantt' class='table'></table>");	
	this.tHead = document.createElement("<thead></thead>");	
	this.tBody = document.createElement("<tbody></tbody>");
	this.Gantt.appendChild(this.tHead);
	this.Gantt.appendChild(this.tBody);

	var HeadRow = this.tHead.insertRow();
	
	if(this.isFixTableHeader)
	{
		HeadRow.className = "IEfixheader";
	}
	var pidcell = HeadRow.insertCell();//放置是否父任务标记
		pidcell.rowSpan = 2;
		pidcell.noWrap = true;
		pidcell.innerHTML = "标记";
		
	var spanNum = 0;
	//生成第一行左部,合并一行
	for(var i=0;i<tableLeftColumnNum;i++){
		var cell = HeadRow.insertCell();
		cell.noWrap = true;
		//cell.vAlign="top";
		cell.rowSpan = 2;
		spanNum++;
		cell.innerHTML = aWbsDataArray[i];
	}	
	
	
	//生成第一行右部,/7表示按星期显示
	var _TempDate = new Date(this.getStartDate().toString());
	for(var i=0;i < tableRightColumnNum / 7;i++){
		var cell = HeadRow.insertCell();
		cell.noWrap = true;
		cell.colSpan = 7;
		//spanNum++;
		cell.innerHTML = formatDate(_TempDate);// + "---" + formatDate(_TempDate.setDate(_TempDate.getDate() + 6))
		_TempDate.setDate(_TempDate.getDate()+7);
	}
	
	//生成第二行，星期数据
	HeadRow = this.tHead.insertRow();
	if(this.isFixTableHeader)
	{
		HeadRow.className = "IEfixheader";
	}
	var dayNum = 0;	
	for(var i=0;i<(tableTotalColumnNum - spanNum);i++){
		var cell = HeadRow.insertCell();
		cell.noWrap = true;
		cell.style.width = '20px';//为方面设定下面TR背景而设
		switch((dayNum == 7 ? dayNum =1 : ++dayNum))
		{
			case 1:cell.innerHTML = "一";break;
			case 2:cell.innerHTML = "二";break;
			case 3:cell.innerHTML = "三";break;
			case 4:cell.innerHTML = "四";break;
			case 5:cell.innerHTML = "五";break;
			case 6:cell.innerHTML = "<span style='color:red;'>六</span>";break;
			case 7:cell.innerHTML = "<span style='color:red;'>日</span>";break;
		}
	}
}
Gantt.prototype.AddWbsData =function(id,pid,sDateStr,eDateStr,percentCompleteRate,aWbsDataArray,URLS){
	this.setWbsStartDate(sDateStr);
	this.setWbsEndDate(eDateStr);
	this.setWbsDataArray(aWbsDataArray);
	var tableLeftColumnNum=this.getWbsDataArray().length;
	var tableRightColumnNum=(this.getEndDate() - this.getStartDate())/1000/60/60/24 + 1;//+2表加上开始一天
	
	
	var HeadRow = this.tBody.insertRow();
	
	//设置一条记录的相关属性
	HeadRow.id = id;
	HeadRow.pid = pid;
	this.pidArray.push(pid);
	
	var pidcell = HeadRow.insertCell();//放置是否父任务标记
	pidcell.innerHTML = "";
	pidcell.align  = "center";
	
	for(var i=0;i<tableLeftColumnNum;i++){
		var cell = HeadRow.insertCell();
		cell.noWrap = true;
		cell.innerHTML = this.getWbsDataArray()[i];
	}
	var rightCell = HeadRow.insertCell();
	rightCell.colSpan = tableRightColumnNum;
	rightCell.className = "backDiv";
	
	rightCell.innerHTML = this.DrawLine(id,percentCompleteRate,URLS);
}
Gantt.prototype.AdornTable = function(num){
	this.Gantt.border=num;
}
Gantt.prototype.getLineTitle = function(){
	var titleStr = "";
	for(var i=0;i<this.getLeftHeadNameArray().length;i++)
	{
		titleStr += this.getLeftHeadNameArray()[i] + ":" + this.getWbsDataArray()[i] + "&#13;&#10;";
	}
	return titleStr;
}

//得到左边空多少距离
Gantt.prototype.getLineMargin_left = function(){
	var totalDay = (this.getEndDate() - this.getStartDate())/1000/60/60/24 + 1;//+1表加上开始一天
	var wbsLeftTotalDay = (this.getWbsStartDate() - this.getStartDate())/1000/60/60/24;
	var margin_left = wbsLeftTotalDay/totalDay * 100;
	return margin_left;	
}
Gantt.prototype.getLineWidth = function(){
	var totalDay = (this.getEndDate() - this.getStartDate())/1000/60/60/24 + 1;//+1表加上开始一天
	var wbsTotalDay = ((this.getWbsEndDate() - this.getWbsStartDate())/1000/60/60/24) + 1;
	var widthNum = (wbsTotalDay/totalDay * 100)/(100 - this.getLineMargin_left());
	widthNum *=100;
	return widthNum;	
}
Gantt.prototype.DrawLine =function(id,percentCompleteRate,URLS){
	var lineHTML = "";
	if(URLS != null && URLS != undefined)
	{
		lineHTML += "<a style='cursor: hand;' href='"+ URLS +"'> ";
	}
	if(percentCompleteRate == null || percentCompleteRate == undefined || percentCompleteRate == '' || isNaN(percentCompleteRate))
	{
		this.setPercentCompleteRate(0);
	}
	else
	{
		this.setPercentCompleteRate(percentCompleteRate);
		
	}
		lineHTML += "<SPAN id='span_" + id + "' ";
		lineHTML += "style='";
		lineHTML += "background-color:" + this.getChildLineColor()  + ";";
		lineHTML += "width: " + this.getLineWidth() + "%;";
		lineHTML += "margin-left: " + this.getLineMargin_left() + "%;";
		//lineHTML += "margin-top: 1%;";
		//lineHTML += "margin-bottom: 1%;";
		lineHTML += "height: 5px;";
		lineHTML += "font-size:4px;";
		lineHTML += "' ";		
		lineHTML += "title='" + this.getLineTitle() + "' ";		
		lineHTML += ">";
		//完成率
			lineHTML += "<SPAN ";
			lineHTML += "style='";
			lineHTML += "background-color: " + this.getPercentCompleteRateColor()  + ";";
			lineHTML += "width: " + this.getPercentCompleteRate() + "%;";
			lineHTML += "margin-left: 0%;";
			lineHTML += "margin-top: 3px;";
			lineHTML += "margin-bottom: 3px;";
			lineHTML += "' ";		
			lineHTML += "title='"+ this.getLineTitle() + "&#13;&#10;完成率: " + percentCompleteRate + "%' ";		
			lineHTML += ">";
			lineHTML += "</SPAN>";
		
	lineHTML += "</SPAN>";
	if(URLS != null && URLS != undefined)
	{
		lineHTML += "</a>";
	}
	lineHTML += "("+ percentCompleteRate +"%)";
	return lineHTML;
}
Gantt.prototype.ChangeParentAttribute = function(){
	for(var i=0 ;i < this.pidArray.length;i++)
	{
		if(this.pidArray[i] == "0") continue;
		
		var objSpan = document.getElementById("span_" + this.pidArray[i]);
		var ojbTR = document.getElementById("" + this.pidArray[i]);
		
		objSpan.style.backgroundColor = this.getParentLineColor();
		objSpan.style.height = "8px";
		objSpan.style.fontSize = "7px";
		ojbTR.cells[0].innerHTML = "<img src='../images/minus.png' style='cursor: hand;' onclick = 'CloseChildWbs(\"" + this.pidArray[i] + "\",this.parentNode);'></img>";
		ojbTR.cells[0].style.display = '';
		//alert(ojbTR.cells[0].innerHTML);
	}
}
Gantt.prototype.DrawGantt =function(DIV){
	if(this.isFixTableHeader)
	{
		DIV.className = "DIVfixheader";
	}
	//this.Gantt.appendChild(this.tHead);
	//this.Gantt.appendChild(this.tBody);
	
	DIV.appendChild(this.Gantt);
	
	this.ChangeParentAttribute();
}

CloseChildWbs = function (pid,obj)
{
	var childIdArray = document.getElementsByTagName("tr");
	if(obj == null || obj == undefined || obj == "")
	{
		//childobj.innerHTML = "<b style='cursor: hand;' onclick = 'OpenChildWbs(\"" + pid + "\",this.parentNode);'>+</b>";
	}
	else
	{
		obj.innerHTML = "<img src='../images/plus.png' style='cursor: hand;' onclick = 'OpenChildWbs(\"" + pid + "\",this.parentNode);'></img>";
	}
	
	for(var i=0 ;i <childIdArray.length;i++)
	{
		if(childIdArray[i].pid != null && childIdArray[i].pid != undefined && childIdArray[i].pid == pid)
		{			
			childIdArray[i].style.display = "none";			
			//递归
			if(childIdArray[i].cells[0].innerHTML == "")
			{
				CloseChildWbs(childIdArray[i].id,'');
			}
			else
			{
				CloseChildWbs(childIdArray[i].id,childIdArray[i].cells[0]);
			}
		}
	}
}
OpenChildWbs = function (pid,obj)
{
	var childIdArray = document.getElementsByTagName("tr");
	for(var i=0 ;i <childIdArray.length;i++)
	{
		
		if(childIdArray[i].pid != null && childIdArray[i].pid != undefined && childIdArray[i].pid == pid)
		{
			childIdArray[i].style.display = "";
		}
	}
	obj.innerHTML = "<img src='../images/minus.png' style='cursor: hand;' onclick = 'CloseChildWbs(\"" + pid + "\",this.parentNode);'></img>";
}

function formatDate(date,split)
{
	var splitFlag = "-";
	if(split == undefined)
	{
		splitFlag = "-";
	}
	else
	{
		splitFlag = split;
	}	
	var tmp_month = date.getMonth() + 1;
	if(tmp_month < 10)
	{
		tmp_month = "0" + tmp_month; 
	}
	var tmp_date = date.getDate();
	if(tmp_date < 10)
	{
		tmp_date = "0" + tmp_date;
	}	
	return date.getFullYear() + splitFlag + tmp_month + splitFlag + tmp_date;
	//return tmp_month + splitFlag + tmp_date;
}
/*DEMO
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>GANTT</title>
<LINK href="gantt.css" rel=stylesheet type="text/css">
<script src="gantt.js" type="text/javascript"></script>
</head>

<body>甘特图测试
<DIV id="ganttdiv"></DIV>
<script>
var gantt = new Gantt();
	gantt.setIsFixTableHeader(true);
	//gantt.setChildLineColor("#00000F");
	gantt.Init("2006-10-01","2006-11-10",["编号","名称","开始日期","结束日期"]);
	gantt.AddWbsData('1','0',"2006-10-01","2006-10-06",20,["1","分析","2006-10-01","2006-10-06"],'javascript:alert(\"加入链接成功\");');
	gantt.AddWbsData('2','1',"2006-10-02","2006-10-03",'0',["1.2","分析","2006-10-02","2006-10-03"]);
	gantt.AddWbsData('3','1',"2006-10-03","2006-10-06",20,["1.3","分析","2006-10-04","2006-10-06"]);
	gantt.AddWbsData('4','0',"2006-10-02","2006-10-07",40,["4","分析","2006-10-02","2006-10-07"]);
	gantt.AddWbsData('5','4',"2006-10-03","2006-10-06",20,["5","分析","2006-10-03","2006-10-06"]);
	gantt.AddWbsData('6','4',"2006-10-03","2006-10-06",20,["6","分析","2006-10-03","2006-10-06"]);
	gantt.AddWbsData('7','4',"2006-10-03","2006-10-06",20,["7","分析","2006-10-03","2006-10-06"]);
	gantt.AdornTable(1);
	gantt.DrawGantt(document.all.ganttdiv);
</script>
</body>
</html>*/