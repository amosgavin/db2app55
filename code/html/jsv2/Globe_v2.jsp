<%@ page contentType="text/html; charset=GBK" %>

<%
/**
  ���� �� ǽ��   2004/05/13
splitString(str,separator):  ���ݷָ��ַ����ַ����ָ�Ϊ����
	����˵����
	������������str: ԭʼ�ַ���
	������������separator�����ָ�����������
	����ֵ˵�����ָ����ַ�������

saveRowSet(aUrl,aRowSets,isSetStsToOld,isOnlySendModifyData,colnames,isIncludeDisplayAttr,isOnlySelectData):����RowSet����
	����˵����
��������������������aUrl: URL��ַ
		   aRowSets:��RowSet����
		   isSetStsToOld:�Ƿ��ڱ��������rowset��״̬��Ϊold �� true/false
		   isOnlySendModifyData:�Ƿ�ֻ�ύ�޸Ĺ�������,ȱʡ��true(ֻ�ύ�޸Ĺ���������)
		   colnames:��Ҫ�ύ���ݼ�������,��һ������,��aRowSets��Ӧ,ÿ������Ԫ������","�ָ��������ַ���
		   isIncludeDisplayAttr:�Ƿ��ύ��ʾ����,ȱʡ��true(�ύ��ʾ����)
		   isOnlySelectData:�Ƿ�ֻ�ύѡ�е����ݣ�ȱʡ��false
	����ֵ˵����UserDataClass ����

copyRowSet(source,sourceRowIndex,dest,destRowIndex):�������ݼ���һ������
		�� source: Դ���ݼ�
		   sourceRowIndex:��Դ�к�
		   dest:��Ŀ�����ݼ�
		   destRowIndex: Ŀ���к�

g_GetUserInfo��������js�ű��л�ȡ��ǰ��½�û���Ϣ�ķ���v

g_ShowDefineQryDlg(pFuncCode,pStaffId  )   �����Ի�����ʾ�Զ����ѯ�����öԻ���
	    pFuncCode ����ģ�����
	   pStaffId Ա����staffidֵ�����Ϊ����ʾ��ǰ��½Ա����staffid
	  return true/false ��ʾ�����Ƿ���¹���


*/
%>
//���ڷָ��
var DATE_SEPARATOR = "-";

var _gModuleName = "<%=request.getContextPath()%>";
var _WBS_LOGINOUT_FLAG ="<LOGIN_OUT>LOGINOUT</LOGIN_OUT>";//�ǳ���־
var _LOGIN_OUT_PAGE = _gModuleName+"<%=com.ai.appframe2.common.SessionManager.getLoginOutWebPageUrl()%>";
var _isClearCacheObj = "<%=com.ai.appframe2.common.AIConfigManager.getConfigItem("IS_CLEAR_PAGE_CACHE")%>";


function gCheckLogOut(pXml){

 if(pXml == _WBS_LOGINOUT_FLAG){
    window.location = _LOGIN_OUT_PAGE;
 }
 else if(pXml.indexOf(_WBS_LOGINOUT_FLAG)>0)
	window.location = _LOGIN_OUT_PAGE;
 else
	 return pXml;
}

function splitString(str,separator)
{
   if (!(str)) return new Array(0);
   if (!(separator)) return new Array(str);
   var List = new Array(0);
   var tmpStr = "";
   var index = 0;
   while (str)
   {  index = str.indexOf(separator);
      if (index < 0)    //û���ҵ�
      { List[List.length] = (str);
	str = null;
	break;
      }
      else if (index ==0)  // �ָ�����ǰ��û�������ַ�
	 str = str.substr(index + separator.length);
      else
      {    tmpStr = str.substring(0,index);
	   List[List.length]=(tmpStr);
		 str = str.substr(index + separator.length);
      }
   }
   return List;
}



/**
  modify by qianghui 2004/09/03 add parameter isOnlySendModifyData
  modify by qianghui 20050704 add parameter colnames(����ָ�����е���̨������������)
 */
function saveRowSet(aUrl,aRowSets,isSetStsToOld,isOnlySendModifyData,colnames,isIncludeDisplayAttr,isOnlySelectData){
   var beforeSaveRowSetFunc = null;
   try
   {
      eval("beforeSaveRowSetFunc=g_AIBeforeSaveRowSetFunc");
   }
   catch(e)
   {
      beforeSaveRowSetFunc =null;
   }
   if(beforeSaveRowSetFunc!=null)
   {
     beforeSaveRowSetFunc(aRowSets);
   }
   if(isSetStsToOld==null)
     isSetStsToOld = true;
   
   //Ĭ�Ͻ����ύ��ʾ����
   if(isIncludeDisplayAttr==null){
    isIncludeDisplayAttr = false;
   }
   if(isOnlySelectData == null){
     isOnlySelectData = false;
   }
    
   if (aRowSets == null || aRowSets.length == 0){
      alert(g_I18NMessage("appframe_core","globe_no_rowset"));
      return ;
   }

   var tmpstr  = "<RootInfo>"
   for(var i =0 ; i < aRowSets.length;i ++){
     if(colnames != null && colnames[i]!=null){
       if(isOnlySelectData == false){
	       tmpstr = tmpstr + aRowSets[i].toXmlString(isOnlySendModifyData,colnames[i],isIncludeDisplayAttr);
	     }
	     else{
	       tmpstr = tmpstr + aRowSets[i].toXmlStringOfSelects(isOnlySendModifyData,colnames[i],isIncludeDisplayAttr);
	     }
	   }
     else{
       if(isOnlySelectData == false){
	       tmpstr = tmpstr + aRowSets[i].toXmlString(isOnlySendModifyData,null,isIncludeDisplayAttr);
	     }
	     else{
	       tmpstr = tmpstr + aRowSets[i].toXmlStringOfSelects(isOnlySendModifyData,null,isIncludeDisplayAttr);
	     }
	   }
   }
   tmpstr = tmpstr   + "</RootInfo>";
   var sRe=PostInfotoServer(aUrl,tmpstr);
   var xml = g_GetXMLDocument();
   xml.loadXML(sRe);
   var xmlNode = xml.documentElement;
   var ud = createUserDataClass(xmlNode,true);

   var flag =ud.getValueByName("FLAG");
   var message =ud.getValueByName("MESSAGE");
   if((flag != "ERROR") && (isSetStsToOld == true)){
     for(var i =0 ; i < aRowSets.length;i ++)
	 aRowSets[i].setStsToOld();
   }
   if(message){
       var infoDiv = document.all("ErrorOrInfo");
       if (infoDiv)
	  infoDiv.innerText = message;
       else
	  alert(message);
   }
   return ud;
}
/**
 * �������ݼ���һ������
��* source: Դ���ݼ�
  * sourceRowIndex:��Դ�к�
  * dest:��Ŀ�����ݼ�
  * destRowIndex: Ŀ���к�
 */
function copyRowSet(source,sourceRowIndex,dest,destRowIndex){
  var cols = source.getColNames();
  var sourceClassName = source.getClassName();
  var destClassName = dest.getClassName();
  if((sourceClassName == "FormRowSet") && (destClassName == "FormRowSet")){
    for(var i=0;i < cols.length ; i++)
      dest.setValue(cols[i],source.getValue(cols[i]),source.getDisplayText(cols[i]) );
  }else if(sourceClassName == "FormRowSet"){
     for(var i=0;i < cols.length;i++)
       dest.setValue(destRowIndex,cols[i],
	    source.getValue(cols[i]),
	    source.getDisplayText(cols[i]) );
  }else if(destClassName == "FormRowSet"){
    for(var i=0;i < cols.length;i++)
       dest.setValue(cols[i],
	    source.getValue(sourceRowIndex,cols[i]),
	    source.getDisplayText(sourceRowIndex,cols[i]) );
  }else{
    for(var i=0;i < cols.length;i++)
      dest.setValue(destRowIndex,cols[i],
	    source.getValue(sourceRowIndex,cols[i]),
	    source.getDisplayText(sourceRowIndex,cols[i]) );
  }
}






function getXmlNodeFromStr(str)
{
  var xml= g_GetXMLDocument();
  xml.async = false;
  xml.loadXML(str);
  return xml.documentElement;
}


function callXMLHTTP(url,xml){
    if(typeof(monitor_flag)=='undefined'){
      monitor_flag = false;
    }
    if (url.indexOf("?") >=0)
      url = url +"&url_source=XMLHTTP";
    else
      url = url +"?url_source=XMLHTTP";
      
    if(monitor_flag ==true){
       url = url + getLogString();
       recordExecStartTime();
    }

    var XMLSender = g_GetXMLHTTPRequest();
    XMLSender.Open("POST",url,false);
    XMLSender.setRequestHeader("Content-Type","multipart/form-data");
    XMLSender.send(xml);
   
   
    if(monitor_flag ==true){
      recordExecEndTime();
    }
    return XMLSender.responseText;
}

function PostInfotoServer(url,xml){
    if(xml ==null)
      return;

    return gCheckLogOut(callXMLHTTP(url,xml));

}

function PostInfo(url,xml){

   var sRe = gCheckLogOut(callXMLHTTP(url,xml));

   var xml = g_GetXMLDocument();
   xml.loadXML(sRe);
   var xmlNode = xml.documentElement;
   var ud = createUserDataClass(xmlNode,true);
   return ud;
}

function sendToServer(url,xml){
   if(xml==null) xml="";
   var sRe = PostInfotoServer(url,xml);
   var xml = g_GetXMLDocument();
   xml.loadXML(sRe);
   var xmlNode = xml.documentElement;

   var ud = createUserDataClass(xmlNode,true);
   var message =ud.getValueByName("MESSAGE");
   if(message){
       var infoDiv = document.all("ErrorOrInfo");
       if (infoDiv)
	  infoDiv.innerText = message;
       else
	  alert(message);
   }
   return ud;
}

/**
add by zr 20060420����
�ɽ�paramͨ��post�������ݵ�action�У������Ƿ���url���洫��
pUrl---ҳ������
pParam---�����ԣ���aa=123&bb=456
�÷������ݲ������������ģ���̨��ȡʱӦʹ��UTF8����ת�롣
HttpUtil.getParameter(req,"��������",HttpUtil.CHARSET_UTF8);
*/
function postParamToServer(pUrl,pParam)
{
   if(typeof(monitor_flag)=='undefined'){
      monitor_flag = false;
    }
    if(monitor_flag ==true){
       pUrl = pUrl + getLogString();
       recordExecStartTime();
    }
  var XMLSender = g_GetXMLHTTPRequest();
  XMLSender.Open("POST",pUrl,false);
  XMLSender.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
  //XMLSender.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
  XMLSender.setrequestheader("CONTENT-LENGTH",pParam.length);
  XMLSender.send(pParam);
  if(monitor_flag ==true){
      recordExecEndTime();
    }
  return XMLSender.responseText;
}
/**
  ����ֵΪUserData����
*/
function postParam(pUrl,pParam)
{
   var sRe = postParamToServer(pUrl,pParam);
   var xml = g_GetXMLDocument();
   xml.loadXML(sRe);
   var xmlNode = xml.documentElement;
   var ud = createUserDataClass(xmlNode,true);
   return ud;
}





/**
add by zr �ж��Ƿ�ǰ�û��Ѿ���ע��������ע������ת����¼����
����createRowSetFactory
 */

function userValidCheckByNode(pXmlNode)
{
	if(pXmlNode!=null && pXmlNode.baseName=="LOGIN_OUT")
	{
	 var strURL= _gModuleName + "/index.jsp";
	 alert(g_I18NMessage("appframe_core","globe_relogin"));
	  var winObj = getTopWin();
	 if(winObj!=null)
	      winObj.location = strURL;
	  else
	      top.location = strURL;
	  return false;
	}
	return true;
}



/**
�������ַ����е������ַ����б���
 */
function g_ConditonStrEncode(pStr)
{
   if(pStr==null || pStr=="") return pStr;

   var reStr = pStr;
   //��"%"����ת��
   reStr = reStr.replace(/%/g,'%25');
   //��"="����ת��
   reStr = reStr.replace(/=/g,'%3D');
   //��"+"����ת��
   reStr = reStr.replace(/[+]/g,'%2B');
   //��'&'����ת��
   reStr = reStr.replace(/&/g,'%26');

   //��'#'����ת��
   reStr = reStr.replace(/#/g,'%23');

   return reStr;
}

function g_ConditonStrDecode(pStr)
{
   if(pStr==null || pStr=="") return pStr;

   var reStr = pStr;
   //��"%"����ת��
   reStr = reStr.replace('%25','%');
   //��"="����ת��
   reStr = reStr.replace('%3D','=');
   //��"+"����ת��
   reStr = reStr.replace('%2B','+');
   //��&����ת��
   reStr = reStr.replace('%26','&');

   //��#����ת��
   reStr = reStr.replace('%23','#');

   return reStr;
}

/**
���������ַ��滻,add by zhuwg
 */
function g_CheckAndTransStr(str)
  {
    str = str.toString();
    if(str=="") return str;
    strArray=str.split("&");
    tmpStr=strArray[0];
    if(strArray.length>1)
	for(i=1;i<strArray.length;i++)
    {
      tmpStr+="&amp;";
      tmpStr+=strArray[i];
    }
    str=tmpStr;
    while(str.indexOf(">")>=0)
    {
      index=str.indexOf(">");
      str=str.substring(0,index)+"&gt;"+str.substring(index+1,str.length);
    }
    while(str.indexOf("<")>=0)
    {
      index=str.indexOf("<");
      str=str.substring(0,index)+"&lt;"+str.substring(index+1,str.length);
    }
    while(str.indexOf("'")>=0)
    {
      index=str.indexOf("'");
      str=str.substring(0,index)+"&apos;"+str.substring(index+1,str.length);
    }
    while(str.indexOf('"')>=0)
    {
      index=str.indexOf('"');
      str=str.substring(0,index)+"&quot;"+str.substring(index+1,str.length);
    }
    return str;
  }




/**
 * ��js�ű��л�ȡ��ǰ��½�û���Ϣ�ķ���
 */
function g_GetUserInfo()
{
  var obj = document.all("AIFRAME2_LOGIN_USER");
  if(obj)
  {
    if(obj.length && obj.length>1)
	  {
		alert(g_I18NMessage("appframe_core","globe_one_tag"));
	return;
	  }
	return obj;
  }
  else
  {
    alert(g_I18NMessage("appframe_core","globe_no_tag"));
    return null;
  }
}

/**
 * ���ڲ�ѯʱ�����ڿؼ���ѡ�����ڣ��������������Ӧ�Ŀؼ��С�
 */
function getNewDate(obj){
  var dlgLeft = event.screenX;
  var dlgTop = event.screenY;
  var oldDate = null;
  if(!!obj.value)
    oldDate =obj.value;
   var showType = "date";
  var paramObj = {showtype:showType,definedate:oldDate};
  var newDate = openCalendarDlg(paramObj,"scroll:no;resizable:no;status:no;dialogLeft:"+dlgLeft+";dialogTop:"+dlgTop+";dialogHeight:280px;dialogWidth:280px");
  if (newDate!="none"){
     obj.value = newDate;
  }
}
/**���ڲ�ѯʱ������ʱ��ؼ���ѡ������ʱ�䣬��������ʱ�������Ӧ�Ŀؼ��С�*/
function getNewDateTime(obj){
  var dlgLeft = event.screenX;
  var dlgTop = event.screenY;
  var oldDateTime = null;
  if(!!obj.value)
    oldDateTime =obj.value;
   var showType = "datetime";
  var paramObj = {showtype:showType,definedate:oldDateTime};
  var newDateTime = openCalendarDlg(paramObj,"scroll:no;resizable:no;status:no;dialogLeft:"+dlgLeft+";dialogTop:"+dlgTop+";dialogHeight:320px;dialogWidth:280px");
  if (newDateTime!="none"){
     obj.value = newDateTime;
  }
}

/**���ڲ�ѯʱ������ʱ��ؼ�*/
function openCalendarDlg(paramObj,style){
  var resName = "/jsv2/DBCalendarDlg";
	if(_gStrLocale != null && _gStrLocale != ""){
	  resName = resName + "_" + _gStrLocale;
	}
	else{
	  resName = resName + "_zh_CN";
	}
	return window.showModalDialog( _gModuleName + resName + ".htm",paramObj,style);
}

/**
 * ��ȡ��߼���window����
 */
function getTopWin()
{
  if (window.name == "WebFrameSet")
  {
    return window;
  }
  
  var w = window;
  if (window == window.parent)
  {
  	
    if (window.opener)
    {
	w = window.opener;
	try{
		while ( w.opener!=null && (w != w.opener))
		{
		  if (w.name == "WebFrameSet")
		   {
		     return w;
		   }
		  w = w.opener;
		}
	}catch(e){
		return window;
	}
	
    }
    else
    {
       return window;
    }
  }
  else
  {
     w = window.parent;
     while (w.parent && (w != w.parent))
	{
	  if (w.name == "WebFrameSet")
	   {
	     return w;
	   }
	  w = w.parent;
	}
  }

  return w;
}



function arrayRemove(a,index)
{
    for(var i=index;i< a.length -1;i++)
      a[i] = a[i +1];
    a.length = a.length - 1;
    return a;
}
function arrayShift(inArray){
  var result = new Array();
  for(var i=0;i < inArray.length - 1;i++){
     result[i] = inArray[i + 1];
  }
  return result;
}
function arrayRemoveNoSort(a,index)
{
    a[index] = a[a.length - 1];
    result = a[a.length - 1];
    a.length = a.length - 1;
    return result;
}

function indexOfArray(arr,data)
{ var result = -1;
  if(arr)
   for(var i=0;i< arr.length;i++)
   { //alert(i+ '---' + data +'---' + arr.toString());
     if (arr[i] == data)
     {
       result =  i;
       break;
     }
   }
  //alert( result + '---' + arr.toString() + '---' + data );
  return result;
}

function g_TransCharge(pFloatCharge){
    var dw2 = new Array("","��","��");//��λ
	var dw1 = new Array("ʰ","��","ǧ");//С��λ
	var dw = new Array("��","Ҽ","��","��","��","��","½","��","��","��");//����������
	var dws = new Array("��","Ҽ","��","��","��","��","½","��","��","��");//С��������
	var ifnegative = 0;
	if(pFloatCharge < 0)
		ifnegative = 1;
	var whole = new String(Math.abs(pFloatCharge));
	//����������С��
	var num;
	var dig;
	if(whole.indexOf(".") == -1)
	{
		num = whole;
		dig = "";
	}
	else
	{
		num = whole.substring(0,whole.indexOf("."));
		dig = whole.substring( whole.indexOf(".")+1, whole.length);
	}
	//ת����������
	var i=1;
	var len = num.length;


	var k1=0;//��С��λ
	var k2=0;//�ƴ�λ
	var str="";

	for(i=1;i<=len;i++)
	{
		var n = num.charAt(len-i);
		str = dw[Number(n)].concat(str);//������

		if(len-i-1>=0)//�����ַ�Χ��
		{
			if(k1!=3)//��С��λ
			{
				str = dw1[k1].concat(str);
				k1++;
			}
			else//����С��λ���Ӵ�λ
			{
				k1=0;
				var temp = str.charAt(0);
				if(temp=="��" || temp=="��")//����λǰû����������ȥ��λ
					str = str.substr( 1, str.length-1);
				str = dw2[k2].concat(str);
			}
		}

		if(k1==3)//С��λ��ǧ���λ��һ
		{
			k2++;
		}
	}
	str+="Ԫ";
	//ת��С������

	for(i=0;i<2;i++){
		var n = dig.charAt(i);
		if (i==0)
		{
			str = str+dws[Number(n)]+"��";
		}
		else if(i==1)
		{
			str = str+dws[Number(n)]+"��";
		}
	}
   if(ifnegative ==1)
		str = "��" + str;
	return str;

}

//���ð�ť״̬
function AIButtonSetDisabled(flag){
   //������óɿɱ༭״̬����Ҫ�ж�Ȩ��
  if(flag==false){
    if(this.OperatorAuthor !=null && 
        (this.OperatorAuthor==false || this.OperatorAuthor=='false')){
      return;
    }
  }
  
  this.disabled = flag;
}

//��ȡhttpRequest����ı�׼����
function g_GetXMLHTTPRequest() {
  var xRequest=null;
  if (typeof ActiveXObject != "undefined"){
    //Internet Explorer     
    xRequest=new ActiveXObject
     ("Microsoft.XMLHTTP");   
  }
  else if (window.XMLHttpRequest) {                        
//Mozilla/Safari
    xRequest=new XMLHttpRequest();   
}
  return xRequest;
}
//��ȡxmlDom�ı�׼����
function g_GetXMLDocument(){
  var xDoc=null;
  if (typeof(ActiveXObject)!= "undefined"){
    var msXmlAx=null;
    //Newer Internet Explorer
    try{
      msXmlAx=new ActiveXObject("Msxml2.DOMDocument");   
    }catch (e){
      //Older Internet Explorer
      msXmlAx=new ActiveXObject("Msxml.DOMDocument");   
    }
    xDoc=msXmlAx;
  }
  else if (document.implementation && document.implementation.createDocument){ 
    //Mozilla/Safari
    xDoc=document.implementation.createDocument("","",null);   
  }
  if (xDoc==null || typeof xDoc.load=="undefined"){
    xDoc=null;
  }
  return xDoc;
}


function showMessage(point,str){  alert(point + "��" +str);}

//�ر���������ٷ����SESSION add by xuehao 2010��11��23��
function g_DestorySession(){
  try{
     var xmlHttp = g_GetXMLHTTPRequest();
     var url = _gModuleName+"/webframe/session/destorySession.jsp";
     xmlHttp.open("POST", url, false);
     xmlHttp.send(null);
     var result = xmlHttp.responseText;
    }
  catch(e)
    {
     alert("����Session�쳣��");
    }
}