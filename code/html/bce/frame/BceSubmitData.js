/**
受理流程框架中多个页面信息的打包工具类--一般来说受理一个产品产生的页面数据会整合到一个SubmitData对象中。并转换为XML提交到后台
ClassName:SubmitData(name)提交数据总的对象 name:类名称，null时为main
MethodName:
addNodeInfo(name,type)	增加一个nodeInfo节点,name-节点名称，type-节点类型
addNewNodeInfo(pName,pType) 增加一个新的NodeInfo对象
toXmlString	将js对象转换为xml字符串
getNodeInfoByName(name)	根据nodeInfo对象的名称获取NodeInfo对象

**/
var SUBMITDATA_XMLTYPE_ROWSET = "ROWSET";//数据类型为平台rowset结构的xml，如果DBGrid,DBForm的toXmlString方法
var SUBMITDATA_XMLTYPE_USERDATA ="USERDATA";//变量数据类型USERDATA的XML结构
var SUBMITDATA_XMLTYPE_SUBMITXML="SUBMIT_XML";//子的SUBMITDATA的xml结构

function SubmitData(name)
{
  this.nodeInfoArray = new Array();//list方式保存nodeinfo对象
  this.nodeInfoHash = new Array();//name的hashmap方式保存nodeinfo的对象
  this.type = 'N';//N表示新的，O表示选的默认都是为新建立
  if(name==null)
    this.name = "main";
  else
    this.name = name;
  this.curpageid = "";//当前的页面id
  this.nextpageid ="";  //下一个要跳转的页面id
 
  
  SubmitData.prototype.setCurPage = SubmitData_setCurPage;
  SubmitData.prototype.setNextPage = SubmitData_setNextPage;
  SubmitData.prototype.addNodeInfo = SubmitData_addNodeInfo;
  SubmitData.prototype.toXmlString= SubmitData_toXmlString;
  //根据name获取NodeInfo对象
  SubmitData.prototype.getNodeInfo = SubmitData_getNodeInfo;	
  SubmitData.prototype.addNewNodeInfo = SubmitData_addNewNodeInfo;
   SubmitData.prototype.setType = SubmitData_setType;
   SubmitData.prototype.getType = SubmitData_getType;
}

function SubmitData_setCurPage(pCurPageId){
  this.curpageid = pCurPageId;
}
function SubmitData_setNextPage(pNextPageId){
  this.nextpageid = pNextPageId;
}

function SubmitData_setType(type){
	this.type = type;
}
function SubmitData_getType(){
	return this.type ;
}

function SubmitData_addNodeInfo(pNodeInfo){
  if(pNodeInfo!=null)
  {
   if(pNodeInfo.getName() && pNodeInfo.getName()!="")
   {
     if(this.nodeInfoHash[pNodeInfo.getName()])
     {
    	 //    	 alert("[SubmitData]已经增加了同名的的NodeInfo");
    	 alert(crm_i18n_msg("BEC0000010"));
    	 return;
     }
     this.nodeInfoHash[pNodeInfo.getName()] = pNodeInfo;
     this.nodeInfoArray[this.nodeInfoArray.length] = pNodeInfo;
     
   }
  
  } 
}

function SubmitData_toXmlString()
{
  var tmpArray = new Array();
  var headTmpArray = new Array();
  if(this.nodeInfoArray.length>0)
  {
   for(var i=0;i<this.nodeInfoArray.length;i++)
   {
      
      tmpArray[tmpArray.length] = this.nodeInfoArray[i].toXmlString();
      
   }
   
   if(tmpArray.join("").length>0)
   {
     headTmpArray[headTmpArray.length] = "<submitdata ";
     headTmpArray[headTmpArray.length] = "name='";
     headTmpArray[headTmpArray.length] = this.name;
     headTmpArray[headTmpArray.length] = "' curpageid='";
     headTmpArray[headTmpArray.length] = this.curpageid;
     headTmpArray[headTmpArray.length] = "' type='";
     headTmpArray[headTmpArray.length] = this.type;
     headTmpArray[headTmpArray.length] = "' nextpageid='";
     headTmpArray[headTmpArray.length] = this.nextpageid;
     headTmpArray[headTmpArray.length] = "'>"; 
     headTmpArray[headTmpArray.length]=tmpArray.join("");
     headTmpArray[headTmpArray.length] = "</submitdata>";
   }
  }
  return  headTmpArray.join("");
}

function SubmitData_getNodeInfo(pName)
{
  if(pName && this.nodeInfoHash[pName]){
     return this.nodeInfoHash[pName]
  }
  else{
     return null;
  }
}

function SubmitData_addNewNodeInfo(pName,pType)
{
  var nodeInfo = new NodeInfo(pName,pType);
  this.addNodeInfo(nodeInfo);
  return nodeInfo;
}




/**
ClassName：NodeInfo	节点对象，一般一个页面使用一个NodeInfo对象，
其下包括userdata(ud),rootinfo,chidSubmitData等子对象
MethodName：
addUserData(key,value)	增加userdata信息,类hashmap。
addChildSubmitData(pSubmitData)	增加子的submitData
addRowsetXml(xmlStr)  增加一个DBGrid，DBForm的xmlString
toXmlString = 将NodeInfo中所有子对象转换为xml输出;
SubmitData_addNewNodeInfo(name,type)添加一个新的NodeInfo对象。name－NodeInfo的名称，type-node	Info的类型
*/
function NodeInfo(pName,pInfoType)
{
  this.name = "";
  this.infotype="";
  if(pName!=null) this.name=pName;
  if(pInfoType!=null) this.infotype = pInfoType;
  this.paramObj = createNewUserDataClass();
  this.childSubmitDataArray = new Array();
  this.rowSetXml = "";
  this.nodeXmlArray = new Array();
  
 
  //inner funct
  NodeInfo.prototype.wrapRowsetXml = NodeInfo_wrapRowsetXml;
  
  //outter func
  NodeInfo.prototype.getName = NodeInfo_getName;
  NodeInfo.prototype.addUserData = NodeInfo_addUserData;
  NodeInfo.prototype.addChildSubmitData = NodeInfo_addChildSubmitData ;
  NodeInfo.prototype.addRowsetXml = NodeInfo_addRowsetXml;
  NodeInfo.prototype.addRowsetXmlStr = NodeInfo_addRowsetXmlStr;
  NodeInfo.prototype.removeRowsetXml = NodeInfo_removeRowsetXml;
  NodeInfo.prototype.toXmlString = NodeInfo_toXmlString;
  NodeInfo.prototype.addSubmitDataXml = NodeInfo_addSubmitDataXml;
  NodeInfo.prototype.setRowSetXml = NodeInfo_setRowSetXml;
  NodeInfo.prototype.getRowSetXml = NodeInfo_getRowSetXml;
}
function NodeInfo_setRowSetXml(rowSetXml){
	this.rowSetXml = rowSetXml;
}
function NodeInfo_getRowSetXml(){
	this.rowSetXml = rowSetXml;
}

function NodeInfo_wrapRowsetXml(pName,pType,pXmlStr)
{
  var tmpArray = new Array();
  if(pName==null || pName=="")
  {
	  //	  alert("NodeInfo对象中增加rowsetxml时，rowsetname不可为null或者空");
    alert(crm_i18n_msg("BEC0000011"));
    return;
  }
  if(pXmlStr==null || pXmlStr=="")
    return "";
  if(pType==null||pType=="")
    pType = SUBMITDATA_XMLTYPE_ROWSET;
  
  tmpArray[tmpArray.length] = "<nodexml name='";
  tmpArray[tmpArray.length] = pName;
  tmpArray[tmpArray.length] = "' xmltype='";
  tmpArray[tmpArray.length] = pType;
  tmpArray[tmpArray.length] ="'><RootInfo>";
  tmpArray[tmpArray.length] = pXmlStr;
  tmpArray[tmpArray.length] = "</RootInfo></nodexml>";
  return tmpArray.join("");
}

//NodeInfo对象的方法实现
function NodeInfo_getName()
{
 return this.name;
}

function NodeInfo_addUserData(paramName,paramValue)
{
  this.paramObj.addData(paramName,paramValue);
}

function NodeInfo_addChildSubmitData(pChildSubmitData)
{
  if(pChildSubmitData==null)
    return;
  this.childSubmitDataArray[this.childSubmitDataArray.length] = pChildSubmitData;
}

function NodeInfo_addRowsetXml(pRsName,pType,pRsXmlString)
{
  
  this.nodeXmlArray[this.nodeXmlArray.length] = this.wrapRowsetXml(pRsName,pType,pRsXmlString);
}
function NodeInfo_addRowsetXmlStr(pRsName,pType,pRsXmlString)
{
  
  this.nodeXmlArray[this.nodeXmlArray.length] = pRsXmlString;
}
//删除RowsetXml
function NodeInfo_removeRowsetXml()
{
	this.nodeXmlArray = new Array();
}
//增加一个子的submitdata的xml
function NodeInfo_addSubmitDataXml(pName,pSubmitDataXml)
{
	var tmpArray = new Array();
	if(pName==null || pName=="")
	  {
//		alert("NodeInfo对象中增加xml时，pName不可为null或者空");
	    alert(crm_i18n_msg("BEC0000012"));
	    return;
	  }
	if(pSubmitDataXml==null || pSubmitDataXml=="")
	    return "";
	 tmpArray[tmpArray.length] = "<nodexml name='";
	  tmpArray[tmpArray.length] = pName;
	  tmpArray[tmpArray.length] = "' xmltype='";
	  tmpArray[tmpArray.length] = SUBMITDATA_XMLTYPE_SUBMITXML;
	  tmpArray[tmpArray.length] ="'>";
	  tmpArray[tmpArray.length] = pSubmitDataXml;
	  tmpArray[tmpArray.length] = "</nodexml>";
	this.nodeXmlArray[this.nodeXmlArray.length] = tmpArray.join("");
}

function NodeInfo_toXmlString()
{
 
  var tmpArray = new Array();
  //参数
 
  tmpArray[tmpArray.length] = this.paramObj.toXmlString();
 
  //xml
  for(var i=0;i<this.nodeXmlArray.length;i++)
  {
     tmpArray[tmpArray.length] = this.nodeXmlArray[i];
   
  }
  //childsubmitdata
  for(var i=0;i<this.childSubmitDataArray.length;i++)
  {
    tmpArray[tmpArray.length] = this.childNodeInfo[i].toXmlString();
  }
  var reVal = tmpArray.join("");
  if(reVal!="")
  {
   return  "<nodeinfo name='"+this.name+"' infotype='"+this.infotype+"'>"+reVal+"</nodeinfo>";
  }
  else
  {
    return "";
  }
 }
