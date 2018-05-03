/**
�������̿���ж��ҳ����Ϣ�Ĵ��������--һ����˵����һ����Ʒ������ҳ�����ݻ����ϵ�һ��SubmitData�����С���ת��ΪXML�ύ����̨
ClassName:SubmitData(name)�ύ�����ܵĶ��� name:�����ƣ�nullʱΪmain
MethodName:
addNodeInfo(name,type)	����һ��nodeInfo�ڵ�,name-�ڵ����ƣ�type-�ڵ�����
addNewNodeInfo(pName,pType) ����һ���µ�NodeInfo����
toXmlString	��js����ת��Ϊxml�ַ���
getNodeInfoByName(name)	����nodeInfo��������ƻ�ȡNodeInfo����

**/
var SUBMITDATA_XMLTYPE_ROWSET = "ROWSET";//��������Ϊƽ̨rowset�ṹ��xml�����DBGrid,DBForm��toXmlString����
var SUBMITDATA_XMLTYPE_USERDATA ="USERDATA";//������������USERDATA��XML�ṹ
var SUBMITDATA_XMLTYPE_SUBMITXML="SUBMIT_XML";//�ӵ�SUBMITDATA��xml�ṹ

function SubmitData(name)
{
  this.nodeInfoArray = new Array();//list��ʽ����nodeinfo����
  this.nodeInfoHash = new Array();//name��hashmap��ʽ����nodeinfo�Ķ���
  this.type = 'N';//N��ʾ�µģ�O��ʾѡ��Ĭ�϶���Ϊ�½���
  if(name==null)
    this.name = "main";
  else
    this.name = name;
  this.curpageid = "";//��ǰ��ҳ��id
  this.nextpageid ="";  //��һ��Ҫ��ת��ҳ��id
 
  
  SubmitData.prototype.setCurPage = SubmitData_setCurPage;
  SubmitData.prototype.setNextPage = SubmitData_setNextPage;
  SubmitData.prototype.addNodeInfo = SubmitData_addNodeInfo;
  SubmitData.prototype.toXmlString= SubmitData_toXmlString;
  //����name��ȡNodeInfo����
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
    	 //    	 alert("[SubmitData]�Ѿ�������ͬ���ĵ�NodeInfo");
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
ClassName��NodeInfo	�ڵ����һ��һ��ҳ��ʹ��һ��NodeInfo����
���°���userdata(ud),rootinfo,chidSubmitData���Ӷ���
MethodName��
addUserData(key,value)	����userdata��Ϣ,��hashmap��
addChildSubmitData(pSubmitData)	�����ӵ�submitData
addRowsetXml(xmlStr)  ����һ��DBGrid��DBForm��xmlString
toXmlString = ��NodeInfo�������Ӷ���ת��Ϊxml���;
SubmitData_addNewNodeInfo(name,type)���һ���µ�NodeInfo����name��NodeInfo�����ƣ�type-node	Info������
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
	  //	  alert("NodeInfo����������rowsetxmlʱ��rowsetname����Ϊnull���߿�");
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

//NodeInfo����ķ���ʵ��
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
//ɾ��RowsetXml
function NodeInfo_removeRowsetXml()
{
	this.nodeXmlArray = new Array();
}
//����һ���ӵ�submitdata��xml
function NodeInfo_addSubmitDataXml(pName,pSubmitDataXml)
{
	var tmpArray = new Array();
	if(pName==null || pName=="")
	  {
//		alert("NodeInfo����������xmlʱ��pName����Ϊnull���߿�");
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
  //����
 
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
