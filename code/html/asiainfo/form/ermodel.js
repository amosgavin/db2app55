﻿var oLines = new Array() ;
var oPubTables = new Array() ; //增加表的对象
var curTab,curField,curLine;
Array.removeAt=function(a,b){a.splice(b,1)}
function div_resizeend(tabDiv) {
if(tabDiv) var divsub=tabDiv.children[0];
else 	divsub = event.srcElement;
var tempdiv = divsub.children[0];
 
var iwid = divsub.offsetWidth-6;
if(iwid<20) iwid=20;
tempdiv.style.width=iwid;
divsub.style.width = iwid+6;
var ihei = divsub.offsetHeight-20;
if(ihei<30) ihei =30;
tempdiv.style.height = ihei;
divsub.style.height = ihei+20;
var tabName = divsub.parentNode.id;
tabName = tabName.substring(4,tabName.length);
_FindLine(tabName);
}
function div_move() {
var	divsub = event.srcElement;
var tabName = divsub.parentNode.id;
tabName = tabName.substring(4,tabName.length);
_FindLine(tabName);
}
function div_scroll() {
var	divsub = event.srcElement;
divsub = divsub.parentNode;
var tabName = divsub.parentNode.id;
tabName = tabName.substring(4,tabName.length);
_FindLine(tabName);

}

function rowSelect() {
var obj = event.srcElement;
if(obj.tagName == "TD") obj = obj.parentNode;
if(obj.tagName == "TR"){
var tab = obj.parentNode.parentNode;
for(var i=0;i<tab.rows.length;i++){
tab.rows(i).className = "";
}
obj.className="tdfilter1";
}
}

var dragObj=null;
function tab_mouse_down() {
curTab="";curField="";curLine="";

var obj = event.srcElement;
if(obj.tagName=='line'){
  curLine=obj.id;
};
 
var pobj = obj.parentNode;
if(pobj.tagName == "DIV" && pobj.id != "undefined"){
var s = pobj.id;
if(s.substring(0,4) == "tab_"){
 curTab = s.substring(4,s.length);
}
}
else if(obj.tagName=="TD"){
   var s = obj.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.id;
   if(s.substring(0,4) == "tab_"){
   curTab = s.substring(4,s.length);
   curField=obj.innerHTML;
  }
};
if(obj.tagName != "TD") return;
if(obj.parentNode.className != "tdfilter1") return;
dragObj = obj;
divMain.setCapture();
}
function tab_mouse_move() {
if(dragObj == null) return;
var obj = event.srcElement;
if(obj.tagName != "TD") return;
obj.style.cursor = "default";
var oTab = obj.parentNode.parentNode.parentNode;
if(oTab == dragObj.parentNode.parentNode.parentNode ) return;

}
function tab_mouse_up() {
if(dragObj == null) return;
divMain.releaseCapture();
var oBak = dragObj;
dragObj = null;
var obj = event.srcElement;
if(obj.tagName != "TD") return;
if(obj.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.id == oBak.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.id ) return;
//if(oBak.parentNode.rowIndex <= 0 || obj.parentNode.rowIndex <= 0 ) return;
 
LineToTable(oBak,obj);
}
function tab_dblclick() {
var obj = event.srcElement;
alert(obj.innerHTML)
if(obj.tagName == "line"){

for(var i=0;i<oLines.length;i++){
if(oLines[i].lineid+"3" == obj.id){
var sRet = DjOpen("eb_gensql2" ,oLines[i] , "展现","有模式窗口","直接","设置联接线");
if(typeof sRet != "undefined"){
if(sRet == "del"){
_DelOneLine(oLines[i],i);
}
}
break;
}
}
}

}
function title_dblclick(){
var obj = event.srcElement;
obj = obj.parentNode;
if(obj.tagName == "DIV" && obj.id != "undefined"){
var s = obj.id;
if(s.substring(0,4) == "tab_"){
var curTableName = s.substring(4,s.length);
for(var i=0;i<oPubTables.length;i++){
if(curTableName == oPubTables[i].name){
var arr = '';
if(typeof arr != "undefined"){
if(arr[0] == "del"){
_DelOneTable(curTableName);
}else if(arr[0] == "othername"){
var sOther = arr[1];
_ChangeTableName(oPubTables[i],sOther);
_RefreshDropDownList();
}
}
}
}
}
}
}

function _ChangeTableName(oTable,otherName) {
var tableName = oTable.name;
var oldOtherName = oTable.otherName
var s = tableName;
if(oldOtherName != "") s = oldOtherName;
oTable.otherName = otherName;

}

function LineToTable(oTd1,oTd2) {
var obj1 = _getTdPos(oTd1);
var obj2 = _getTdPos(oTd2);
var stable1 = oTd1.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.id;
stable1 = stable1.substring(4,stable1.length);
var stable2 = oTd2.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.id;
stable2 = stable2.substring(4,stable2.length);
var sId =stable1 + "_" +oTd1.parentNode.rowIndex+"_" + stable2 + "_" +oTd2.parentNode.rowIndex+"_" ;
var sLine = '<v:line id="' + sId+ '1" from="0,0" to="0,0" strokeweight="3pt" />' ;
sLine += '<v:line id="' + sId+ '2" from="0,0" to="0,0"  strokeweight="1pt" > <v:stroke EndArrow="classic"/></v:line>' ;
sLine += '<v:line id="' + sId+ '3" from="0,0" to="0,0" strokeweight="1pt"  />' ;
divMain.insertAdjacentHTML('beforeEnd',sLine);
var pos=oLines.length;
 
oLines[pos] = new Object();
oLines[pos].table1 = stable1;
oLines[pos].rowno1 = oTd1.parentNode.rowIndex;
oLines[pos].field1 = oTd1.innerHTML;
oLines[pos].td1 = oTd1;
oLines[pos].table2 = stable2;
oLines[pos].rowno2 = oTd2.parentNode.rowIndex;
oLines[pos].field2 = oTd2.innerHTML;
oLines[pos].td2 = oTd2;
oLines[pos].lineid = sId;
oLines[pos].op = "=";
oLines[pos].join = "inner";
_RedrawLine(oLines[pos]);
oTd1.style.fontWeight= "bold";
oTd2.style.fontWeight= "bold";

}
function _FindLine(tablename){
for(var i=0;i<oLines.length;i++){
if(oLines[i].table1 == tablename || oLines[i].table2 == tablename){
_RedrawLine(oLines[i]);
}
}
}
function _DelOneLine(oLine,iPos,lineid){
if(lineid){
  for(var i=0;i<oLines.length;i++){
    var line=oLines[i];
    alert('_DelOneLine'+line.lineid+"3");
    if(line.lineid+"3"==lineid){oLine=line;iPos=i}
  }
};
if(!oLine)return;
document.getElementById(oLine.lineid+"1").outerHTML = "";
document.getElementById(oLine.lineid+"2").outerHTML = "";
document.getElementById(oLine.lineid+"3").outerHTML = "";
var bTd1 = false;
var bTd2 = false;
for(var i=0;i<oLines.length;i++){
if(i == iPos ) continue;
if(bTd1 && bTd2 ) break;
if(oLines[i].table1 == oLine.table1 && oLines[i].rowno1 == oLine.rowno1) bTd1 = true ;
if(oLines[i].table2 == oLine.table2 && oLines[i].rowno2 == oLine.rowno2) bTd2 = true ;
}
if(bTd1 == false) oLine.td1.style.fontWeight="normal";
if(bTd2 == false) oLine.td2.style.fontWeight="normal";
oLines.splice(iPos, 1);

}
function _DelOneTable(tableName){
var s = oPubTables[tableName].otherName;
if(s == "") s = tableName;

for(var i=oLines.length-1;i>=0;i--){
if(oLines[i].table1 == tableName || oLines[i].table2 == tableName ){
_DelOneLine(oLines[i],i);
}
}
if(!document.getElementById("tab_"+tableName)) return;
document.getElementById("tab_"+tableName).outerHTML ="";
for(var i=0;i<oPubTables.length;i++){
if(oPubTables[i].name == tableName){
Array.removeAt(oPubTables,i);
break ;
}
}
_RefreshDropDownList();
}
function _RedrawLine(oLine){
var sId = oLine.lineid ;
var obj1 = _getTdPos(oLine.td1);
var obj2 = _getTdPos(oLine.td2);
if(obj1.left>obj2.left){
var obak = obj1;
obj1=obj2;
obj2=obak;
}
var o1 = document.getElementById(sId+"1");
var o2 = document.getElementById(sId+"2");
var o3 = document.getElementById(sId+"3");
 
o1.style.position = "absolute";
o1.style.left = obj1.right ;
o1.style.top = obj1.height;
o1.to = "20,0";
o2.style.position = "absolute";
o2.style.left = obj2.left-20 ;
o2.style.top = obj2.height;
o2.to = "20,0";
o3.style.position = "absolute";
o3.style.left = obj1.right+20 ;
o3.style.top = obj1.height;
o3.to =  (obj2.left-20-(obj1.right+20))+ ',' + (obj2.height-obj1.height) ;
}
function _getTdPos(oTd){
var oDiv = oTd.parentNode.parentNode.parentNode.parentNode ;
var iHeight = oDiv.parentNode.style.pixelTop + oDiv.offsetTop + oTd.offsetTop  - oDiv.scrollTop + oTd.offsetHeight/2;
var iStart = oDiv.parentNode.style.pixelTop + oDiv.offsetTop ;
var iEnd =  oDiv.parentNode.style.pixelTop + oDiv.offsetTop + oDiv.offsetHeight ;
if(iHeight > iEnd ) iHeight = iEnd;
if(iHeight < iStart ) iHeight = iStart ;
return {
height : iHeight,
left : oDiv.parentNode.style.pixelLeft ,
right : oDiv.parentNode.style.pixelLeft + oDiv.parentNode.style.pixelWidth
} ;
}
function _addOneTableByJson(tabjson){
var tableName=tabjson.tabname;
for(var i=0;i<oPubTables.length;i++){
if(oPubTables[i].name == tableName){
return ;
}
}
var ret = '';
var l = oPubTables.length;
oPubTables[l] = new Object();
oPubTables[l].name = tableName ;
oPubTables[l].otherName = tableName;
oPubTables[l].fieldstr = [];
for(var i=0;i<tabjson.fields.length;i++)
  oPubTables[l].fieldstr.push(tabjson.fields[i].fieldname);

oPubTables[tableName] = oPubTables[l];
for(var i=0;i<oPubTables[l].fieldstr.length;i++){
  ret+="<tr><td><input type=checkbox onclick=_RefreshFieldList() ></td><td style='font-size:12px' id='"+oPubTables[l].name+'.'+oPubTables[l].fieldstr[i]+"'>"+oPubTables[l].fieldstr[i].toLowerCase()+"</td></tr>"
};
var sb ="";
sb+=('<div  style="font-size:12px" id=tab_'+tableName+' contentEditable=true onselectstart="event.returnValue=false;" >');
sb+=('<div  contentEditable=false onresizeend="div_resizeend()" onmove="div_move()" ondblclick="title_dblclick()" style="padding:0px;z-index:3;overflow:hidden;background-color:midnightblue;color:#FFFFFF;position:absolute;left:'+tabjson.x+'px;top:'+tabjson.y+'px;width:'+tabjson.width+'px; border-bottom:gray 2px solid;border-top:gray 2px solid;border-left:gray 2px solid;border-right:gray 2px solid" >');
sb+=( tableName);
sb+=('<div style="font-size:12px"  style="overflow-x:hide;overflow-y:auto;background-color:white;color:black;" onscroll="div_scroll()">');
sb+=('<table onclick="rowSelect()" >');

sb+=(ret);
sb+=('</table>');
sb+=('</div>');
sb+=('</div>');
sb+=('</div>');
divMain.insertAdjacentHTML('beforeEnd',sb.toString());
var obj = document.getElementById("tab_"+tableName).children(0);
//if(tabjson.height)  obj.style.height=tabjson.Height else 
if(obj.offsetHeight > 250)
   obj.style.height = 250 ;
else
   obj.style.height = obj.offsetHeight;
   
//if(tabjson.width) obj.style.width=tabjson.width else 
if(obj.offsetWidth > 200) obj.style.width = 200 ;
else obj.style.width = obj.offsetWidth;
};
function _addOneTable(tableName) {
 
for(var i=0;i<oPubTables.length;i++){
if(oPubTables[i].name == tableName){
return ;
}
}
var ret = '';
var l = oPubTables.length;
oPubTables[l] = new Object();
oPubTables[l].name = tableName ;
oPubTables[l].otherName = "";
oPubTables[l].fieldstr = ['name','sex','remark','f1','f2','f3','f4','f5','<b>f7'];
oPubTables[tableName] = oPubTables[l];
for(var i=0;i<oPubTables[l].fieldstr.length;i++){
  ret+="<tr><td><input type=checkbox onclick=_RefreshFieldList() ></td><td id='"+oPubTables[l].name+'.'+oPubTables[l].fieldstr[i]+"'>"+oPubTables[l].fieldstr[i]+"</td></tr>"
};
var sb ="";
sb+=('<div  id=tab_'+tableName+' contentEditable=true onselectstart="event.returnValue=false;" >');
sb+=('<div  contentEditable=false onresizeend="div_resizeend()" onmove="div_move()" ondblclick="title_dblclick()" style="padding:0px;z-index:3;overflow:hidden;background-color:midnightblue;color:#FFFFFF;position:absolute;left:120px;top:20px;width:120px;border-bottom:gray 3px solid;border-top:gray 3px solid;border-left:gray 3px solid;border-right:gray 3px solid" >');
sb+=( tableName);
sb+=('<div  style="overflow-x:hide;overflow-y:auto;background-color:white;color:black;" onscroll="div_scroll()">');
sb+=('<table onclick="rowSelect()" >');

sb+=(ret);
sb+=('</table>');
sb+=('</div>');
sb+=('</div>');
sb+=('</div>');
divMain.insertAdjacentHTML('beforeEnd',sb.toString());
var obj = document.getElementById("tab_"+tableName).children(0);
if(obj.offsetHeight > 250)
obj.style.height = 250 ;
else
obj.style.height = obj.offsetHeight;
if(obj.offsetWidth > 200)
obj.style.width = 200 ;
else
obj.style.width = obj.offsetWidth;
_RefreshDropDownList();
 
 };
function _addLink(fromTab,fromField,toTab,toField) {
   var obj1 = document.getElementById(fromTab+"."+fromField) ;
   var obj2 = document.getElementById(toTab+"."+toField) ;
   if(obj1 && obj2)LineToTable(obj1,obj2);
};
function _RefreshDropDownList() {
return ;	
 
}
function _RefreshFieldList() {
var obj = event.srcElement;
var tableName = obj.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.id;
tableName = tableName.substring(4,tableName.length);
var fieldName = obj.parentNode.parentNode.cells(1).innerText ;
var sOther = tableName;
if(oPubTables[tableName].otherName != "") sOther = oPubTables[tableName].otherName;
var sAll =sOther +"."+fieldName;
 
}

function _PreCheck() {
var l = grid1.Rows;
if(oPubTables.length<=0){
return "至少要增加一个表!";
}
if(l<=1){
return "至少要选择一个字段!";
}
l=grid2.Rows;
var sLeft = "",sRight = "";
for(var i=1;i<l;i++){
var fdName = grid2.tab.rows(i).cells(2).innerText;
var sOp = grid2.tab.rows(i).cells(3).innerText;
var fdValue = grid2.tab.rows(i).cells(4).innerText;
if((fdName == "" && sOp =="" && fdValue =="") || (fdName != "" && sOp !="" && fdValue !="")){
} else {
return "条件中的第" + (i-1) + "行不完整";
}
sLeft += new Eapi.Str().trim(grid2.tab.rows(i).cells(1).innerText);
sRight += new Eapi.Str().trim(grid2.tab.rows(i).cells(5).innerText);
}
if(sLeft.length != sRight.length){
return "左括号和右括号的个数不一致!";
}
return "";
}


function _GenSql() {

var sSelect = "";
var sGroup = "";
var sOrder = "";
var l = grid1.Rows;
for(var i=1;i<l;i++){
var fdName = grid1.tab.rows(i).cells(1).innerText;
var sSum = grid1.tab.rows(i).cells(4).innerText;
sSum = _SumNameTo(sSum);
if(sSum != "") fdName = sSum +"(" + fdName + ")" ;
var fdOther = grid1.tab.rows(i).cells(5).innerText;
if(fdOther != "" ) fdName = fdName + " as " +fdOther;
var sEnd = "";
if(i != l-1) sEnd = "," ;
sSelect += fdName + sEnd ;
var sTmp = grid1.tab.rows(i).cells(2).innerText;
if(sTmp == "升序"){
sOrder += fdName+",";
}else if(sTmp == "降序"){
sOrder += fdName+" DESC ,"
}
var sTmp = grid1.tab.rows(i).cells(3).innerText;
if(sTmp == "分组"){
sGroup += fdName+",";
}
}
if(sOrder != "") sOrder = sOrder.substring(0,sOrder.length-1);
if(sGroup != "") sGroup = sGroup.substring(0,sGroup.length-1);
sOrder = new Eapi.Str().trim(sOrder);
sGroup = new Eapi.Str().trim(sGroup);
var sWhere = "";
var l = grid2.Rows;
for(var i=1;i<l;i++){
var fdName = grid2.tab.rows(i).cells(2).innerText;
var sOr = "";
if(i<l-1) {
if(grid2.tab.rows(i).cells(6).innerText == "或者"){
sOr =  " or ";
}else  {
sOr = " and ";
}
}
sWhere += grid2.tab.rows(i).cells(1).innerText + fdName + _OpNameTo(grid2.tab.rows(i).cells(3).innerText)+grid2.tab.rows(i).cells(4).innerText +grid2.tab.rows(i).cells(5).innerText + sOr;
}
sWhere = new Eapi.Str().trim(sWhere);
var oRs =Array.clone( oLines);
var sRelation = "";
var i=0;
if(oRs.length>0){
sRelation = oRs[0].table1;
}
while(oRs.length>0){
var arrTables = new Array();
arrTables[0] = oRs[0].table1;
sRelation += _FindOneRelation(arrTables,oRs)+",";
}
for(var i=0;i<oPubTables.length;i++){
var tabName = oPubTables[i].name;
var bFind =false;
for(var j=0;j<oLines.length;j++){
if(tabName == oLines[j].table1 || tabName == oLines[j].table2){
bFind = true;
break;
}
}
if(bFind == false){
sRelation += tabName+" "+oPubTables[tabName].otherName+",";
}
}
if(sRelation !="") sRelation = sRelation.substring(0,sRelation.length-1);
if(sWhere != "") sWhere = " where "+sWhere;
if(sGroup != "") sGroup = " group by " + sGroup;
if(sOrder != "") sOrder = " order by " + sOrder;
if(chkDistinct.value == "是" ) sSelect = "distinct " +sSelect;
var sAll ="select "+ sSelect + " from "+ sRelation +  sWhere +  sGroup + sOrder;
return sAll;
function _FindOneRelation(arrTables,oRs) {
var sRet = "";
while(true){
var s1="";
for(var i=oRs.length-1;i>=0;i--){
if(_HaveTable(arrTables,oRs[i].table1) && _HaveTable(arrTables,oRs[i].table2)==false ){
s1 = _AddOneTableStr(arrTables,oRs[i].table2);
break;
}else if(_HaveTable(arrTables,oRs[i].table2) && _HaveTable(arrTables,oRs[i].table1)==false){
s1 = _AddOneTableStr(arrTables,oRs[i].table1);
break;
}
}
if(s1 == ""){
break;
}else{
sRet += s1;
}
}
return sRet;
}
function _AddOneTableStr(arrTables,tableName) {
var sRet = "";
for(var i=0;i<arrTables.length;i++){
var tmp = _Get2TableRelation(oRs,tableName,arrTables[i]);
if(tmp != "") tmp = tmp + " and ";
sRet += tmp  ;
}
if(sRet != "")	{
arrTables[arrTables.length ] = tableName;
var sR = "inner";
for(var k=0;k<oLines.length;k++){
if(oLines[k].table1 == tableName || oLines[k].table2 == tableName){
sR = oLines[k].join;
break;
}
}
sRet = " "+sR+" join " + tableName +" " + oPubTables[tableName].otherName+ " on " + sRet.substring(0,sRet.length-4);
}
return sRet;
}
function _HaveTable(arr,tableName) {
for(var i=0;i<arr.length;i++){
if(arr[i] == tableName){
return true
}
}
return false;
}
function _Get2TableRelation(oRs,tableName1,tableName2){
var sR = ""
for(var i=oRs.length-1;i>=0;i--){
var table1 = oRs[i].table1 ;
var table2 = oRs[i].table2 ;
if((tableName1 == table1 && tableName2 == table2) || ( tableName2 == table1 && tableName1 == table2) ){
var sOther1 = oPubTables[table1].otherName;
if(sOther1 == "") sOther1 = table1;
var sOther2 = oPubTables[table2].otherName;
if(sOther2 == "") sOther2 = table2;
sR += sOther1+"."+oRs[i].td1.innerText +" = " + sOther2+"."+oRs[i].td2.innerText + " and ";
Array.removeAt(oRs,i);
}
}
if(sR != "") sR = sR.substring(0,sR.length-4);
return sR;
}
function _SumNameTo(sName) {
var sRet = "";
switch (sName) {
case "汇总" : sRet = "sum"; break;
case "计数" : sRet = "count"; break;
case "平均" : sRet = "avg"; break;
case "最小值" : sRet = "min"; break;
case "最大值" : sRet = "max"; break;
}
return sRet;
}
function _OpNameTo(sName) {
var sRet = "";
switch (sName) {
case "＝" : sRet = "="; break;
case "＞" : sRet = ">"; break;
case "＜" : sRet = "<"; break;
case "＞＝" : sRet = ">="; break;
case "！＝" : sRet = "!="; break;
case "开始于" : sRet = " like "; break;
}
return sRet;
}
}
