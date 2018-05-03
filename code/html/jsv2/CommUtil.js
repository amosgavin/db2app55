/**
	�ļ����ƣ�CommonUtil.js
	����	: zhongrui
	����ʱ��: 2005-03-24
	�ļ����ݣ�һЩ���õ�js�����ࡣ������
	����������
	g_FormFieldIsNull	 �ж�DBForm��ָ���ֶ��Ƿ�Ϊ��
	g_GetObjXY 		 ��ȡҳ����ĳ��Ԫ�صľ�������
	g_IsDigit    		 У���Ƿ�ȫ���������
	g_IsFloat(s,pDecimal) У���Ƿ��ǺϷ���С��
	g_IsEmail 		 �жϺϷ���email��ַ
	g_IsTeleNumber		 У����ͨ�绰��������룺���ԡ�+����ͷ���������⣬�ɺ��С�-��
	g_IsPostalCode 		У���������� 6λ����
	g_IsMobileNumber 	У���ֻ����룺���������ֿ�ͷ���������⣬�ɺ��С�-��
	g_IsDate		�ж����ڸ�ʽ�Ƿ�Ϸ�������yyyy-mm-dd
	g_IsDateTime		У������ʱ���Ƿ�Ϸ�yyyy-mm-dd H24:MI:SS���ָ�ʽ������+ʱ��
	g_getStrLen 		��ȡ�ַ����ĳ��ȣ�����ַ����а������ĵ�˫�ֽڴ��룬���䳤����Ϊ2��
	g_getSubStrInByte			��ȡ���ַ�������������Ϊ�ֽڳ��ȡ�
	g_StringTrim		�ַ���trim������ȡ����ǰ��Ŀո�
	g_GetSysDateTime	�������ݿ��ȡ���ݿ�����ں�ʱ��
	g_GetSysDate		�������ݿ��ȡ���ݿ�����
	g_GetSysTime		�������ݿ��ȡ���ݿ�ʱ��
  g_CheckInputNum         ����ֻ����������
  g_IDCardNumber      �ж��Ƿ������֤����
  g_FormatDate(aDate,format) ��ʽ������ʱ�䷽��PARAMETER: aDate:js�е�aDate����,format-��ʽ�ַ���.��:yyyy-MM-dd hh:mm:ss
  
  g_BeforePasteNum()  ճ��ʱ����ֻ���������ֺͻس� ��Ҫ��onbeforePaste�¼�
  g_BeforePasteEnglish() ճ��ʱ����ֻ���������ֺ���ĸ����Ҫ��onbeforePaste�¼�
  
  g_CompareDate       �ж����ڴ�С
  g_MonthsBetween	  �����·ݲ�(�����죬�Ƚ�ʱ��trunc���£�Ȼ�����Ƚ�)
**/


/**
 �ж�DBForm��ָ���ֶ��Ƿ�Ϊ�գ����Ϊ�շ���true����alert���档���򷵻�false
 pFormRowSet -- DBFormRowSet����
 pFieldNames -- У����ֶ����ƴ���ÿ���ַ���"," �ָ�
*/

function g_FormFieldIsNull(pFormRowSet,pFieldNames)
{
	var flag = false;
	if(pFormRowSet == null || pFieldNames==null || pFieldNames=="")
	{
		alert(g_I18NMessage("appframe_core","commutil_param_null"));
		return flag;
	}
    var fieldArray = pFieldNames.split(",");
	if(fieldArray!=null && fieldArray.length>0){
	  for (var i=0;i<fieldArray.length ;i++ )
	  {
	var fieldValue = pFormRowSet.getValue(fieldArray[i]);
	if(fieldValue!=null && g_StringTrim(fieldValue)==""){

		  var fieldText = pFormRowSet.getTitle(fieldArray[i]);
		  alert(fieldText+g_I18NMessage("appframe_core","commutil_cannot_null"));
		  flag = true;
		  break;
		}
	  }

	}
    return flag;

}



 /*********************************************************************************
* FUNCTION: g_GetObjXY ��ȡҳ����ĳ��Ԫ�صľ�������
* PARAMETER: obj,dhtml ����
* RETURNS: array��array['x']=xpos,array['y']=ypos
*********************************************************************************/
function g_GetObjXY(Obj)
 {
	 for(var sumTop=0,sumLeft=0;Obj!=document.body;sumTop+=Obj.offsetTop,sumLeft+=Obj.offsetLeft,Obj=Obj.offsetParent);
	return {left:sumLeft,top:sumTop};

 }



 /*********************************************************************************
* FUNCTION: g_IsEmail �жϺϷ���email��ַ
* PARAMETER: String (Email Address)
* RETURNS: TRUE if the String is a valid Email address
* FALSE if the passed string is not a valid Email Address
* EMAIL FORMAT: AnyName@EmailServer e.g; webmaster@hotmail.com
* @ sign can appear only once in the email address.
*********************************************************************************/
function g_IsEmail (theStr) {
if(theStr==null || theStr=='')return true;
var atIndex = theStr.indexOf('@');
var dotIndex = theStr.indexOf('.', atIndex);
var flag = true;
theSub = theStr.substring(0, dotIndex+1)

if ((atIndex < 1)||(atIndex != theStr.lastIndexOf('@'))||(dotIndex < atIndex + 2)||(theStr.length <= theSub.length))
{ return(false); }
else { return(true); }
}



/*********************************************************************************
* FUNCTION: g_IsDigit У���Ƿ�ȫ���������
* PARAMETER: �ַ���s
* RETURNS: true/false
*********************************************************************************/

function g_IsDigit(s)
{
 if(s==null) return false;
 if(s=='')return true;
 s=''+s;
 if(s.substring(0,1)=='-' && s.length>1)s=s.substring(1,s.length);

var patrn=/^[0-9]*$/;
if (!patrn.exec(s)) return false;
return true
}

/*********************************************************************************
* FUNCTION: g_IsFloat У���Ƿ���С��
* PARAMETER: �ַ���s.pDecimal���ȣ���������λС�� ֵΪ0���ߣ�1ʱ�����ƾ��ȣ�
* RETURNS: true/false
*********************************************************************************/
function g_IsFloat(s,pDecimal)
{
 if(s==null) return false;
 s=''+s;
 if(s=='')return true;
 
 if(s.substring(0,1)=='-' && s.length>1)s=s.substring(1,s.length);

 var dec = -1;
 if(parseInt(pDecimal)!=NaN)
   dec = pDecimal;
 var reg = "^[0-9]+(\\.[0-9]{1,"+dec+"})?$";
 if(dec==0 || dec==-1)
 {
   reg = "^[0-9]+(\\.[0-9]{1,10000})?$";
 }
 var re = new RegExp(reg,"g");
 if(!s.match(re)) return false;
 else return true;

}


/*********************************************************************************
* FUNCTION: g_IsTeleNumber У����ͨ�绰��������룺���ԡ�+����ͷ���������⣬�ɺ��С�-��
* PARAMETER: �ַ���s
* RETURNS: true/false
*********************************************************************************/

function g_IsTeleNumber_bak(s)
{
if(s==null || s=='')return true;
if(s.length>20)return false;
var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
if (!patrn.exec(s)) return false
return true
}
function g_IsTeleNumber(s)
{
if(s==null || s=='')return true;
if(s.length>20 || s.length<4)return false;

var re = new RegExp(/^[\d'('')'' '\*\-]*$/);

if(re.exec(s))return true;
else return false;
}
/*********************************************************************************
* FUNCTION: g_IsMobileNumber У���ֻ����룺���������ֿ�ͷ���������⣬�ɺ��С�-��
* PARAMETER: �ַ���s
* RETURNS: true/false
*********************************************************************************/

function g_IsMobileNumber_bak(s)
{
var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
if (!patrn.exec(s)) return false
return true
}

//�µ��ֻ�������֤����1��ͷ��11λ����
function g_IsMobileNumber(s)
{
if(s==null || s=='')return true;
if( s.length!=11 || ( s.substring(0,2)!='13' && s.substring(0,2)!='15' && s.substring(0,3)!='147' && s.substring(0,3)!='188'&&s.substring(0,3)!='187'))return false;
if(!g_IsDigit(s))return false;
return true
}
/*********************************************************************************
* FUNCTION: g_IsPostalCode У���������� 6λ����
* PARAMETER: �ַ���s
* RETURNS: true/false
*********************************************************************************/

//
function g_IsPostalCode(s)
{
if(s==null || s=='')return true;
var patrn=/^[0-9]{6}$/;
if (!patrn.exec(s)) return false
return true
}





/*********************************************************************************
* FUNCTION: g_IsDate У�������Ƿ�Ϸ�yyyy-mm-dd���ָ�ʽ������
* PARAMETER: �ַ���s
* RETURNS: true/false
*********************************************************************************/

function g_IsDate(str)
{
	if(str=='')return true;
   if(DATE_SEPARATOR==null) DATE_SEPARATOR ="-";
   var regExpStr = "^\\d{4}" + DATE_SEPARATOR + "\\d{1,2}" + DATE_SEPARATOR + "\\d{1,2}$";
   var patrn = new RegExp(regExpStr);

   if(!patrn.exec(str)) return false;
   var dateArray  = str.split(DATE_SEPARATOR);
   var d= new Date(dateArray[0],dateArray[1]-1,dateArray[2]);
   var issame =(d && (d.getFullYear()==dateArray[0])&& (d.getMonth()+1==dateArray[1]) &&(d.getDate()==dateArray[2]));
   if (!issame)
       {
	 return false;
       }
   return true;
}

/*********************************************************************************
* FUNCTION: g_IsDateTime У�������Ƿ�Ϸ�yyyy-mm-dd H24:MI:SS���ָ�ʽ������+ʱ��
* PARAMETER: �ַ���s
* RETURNS: true/false
*********************************************************************************/
function g_IsDateTime(str)
{
	if(str=='')return true;
   if(DATE_SEPARATOR==null) DATE_SEPARATOR ="-";
   var regExpStr = "^\\d{4}" + DATE_SEPARATOR + "\\d{1,2}" + DATE_SEPARATOR + "\\d{1,2}\\s\\d{2}:\\d{1,2}:\\d{1,2}$";
   var patrn = new RegExp(regExpStr);

   if(!patrn.exec(str)) return false;
   var dateTimeArray = str.split(" ");
   if(dateTimeArray==null || dateTimeArray.length!=2) return false;
   var dateArray  = dateTimeArray[0].split(DATE_SEPARATOR);
   var timeArray = dateTimeArray[1].split(":");
   var d= new Date(dateArray[0],dateArray[1]-1,dateArray[2],timeArray[0],timeArray[1],timeArray[2]);
   var issame =(d && (d.getFullYear()==dateArray[0])&& (d.getMonth()+1==dateArray[1]) &&(d.getDate()==dateArray[2]) && (d.getHours() == timeArray[0]) && (d.getMinutes()== timeArray[1]) && (d.getSeconds()== timeArray[2])  );
   if (!issame)
       {
	 return false;
       }
   return true;
}

/*********************************************************************************
* FUNCTION: ��ȡ�ַ����ĳ��ȣ�����ַ����а������ĵ�˫�ֽڴ��룬���䳤����Ϊ2��
* PARAMETER: �ַ���s
* RETURNS: int
*********************************************************************************/
function g_GetStrLen(str){
  str = str.toString(10);
  return str.replace(/[^\x00-\xff]/g,"aa").length;
}

/*********************************************************************************
* FUNCTION: ��ȡ���ַ�������������Ϊ�ֽڳ���
* PARAMETER: str�ַ�����length��ȡ���ȣ����ֽ�Ϊ��λ����˫�ֽڣ�����2�����Ӵ�ȡground
* RETURNS: int
*********************************************************************************/
function g_getSubStrInByte(str,lenth){
  str = str.toString(10);
  var tmpstr= str.replace(/[^\x00-\xff]/g,"\x0b\x0c");

	tmpstr =tmpstr.substring(0,lenth);
	tmpstr = tmpstr.replace(/\x0b/g,'');
	return str.substring(0,tmpstr.length);
}

/*********************************************************************************
* FUNCTION: �ַ���trim������ȡ����ǰ��Ŀո�
* PARAMETER: �ַ���s
* RETURNS: string�ַ���
*********************************************************************************/
function g_StringTrim(str){
  str = str.toString(10);
  return str.replace(/(^\s*)|(\s*$)/g, "");
}



/*********************************************************************************
* FUNCTION: �������ݿ��ȡ���ݿ�����ں�ʱ��
* PARAMETER: null
* RETURNS: string�ַ���
*********************************************************************************/
function g_GetSysDateTime()
{
     var _gNode = null;
     var xml= new ActiveXObject("Msxml.DOMDocument");
     xml.async = false;
     var url=  _gModuleName+ "/business/com.ai.appframe2.web.DefaultAction?action=getSysDateTime";
     var b = xml.load(url);
     if(!b){
	    alert(g_I18NMessage("appframe_core","commutil_gettime_err"));
		return null;
	  }

      var xmlNode = xml.documentElement;
      var ud = createUserDataClass(xmlNode,true);
      return ud.getValueByName("DateTime");
}



/*********************************************************************************
* FUNCTION: �������ݿ��ȡ���ݿ�����
* PARAMETER: null
* RETURNS: string�ַ���
*********************************************************************************/

function g_GetSysDate()
{
   var dateTime = g_GetSysDateTime();
   var date = null;
   if(dateTime!=null && dateTime.indexOf(' ')!=null)
	{
	   date = dateTime.substring(0,dateTime.indexOf(' '));
	}
  return date;
}

/*********************************************************************************
* FUNCTION: �������ݿ��ȡ���ݿ��ʱ��
* PARAMETER: null
* RETURNS: string�ַ���
*********************************************************************************/
function g_GetSysTime()
{
   var dateTime = g_GetSysDateTime();
   var time = null;
   if(dateTime!=null && dateTime.indexOf(' ')!=null)
	{
	   time = dateTime.substring(dateTime.indexOf(' ')+1,dateTime.length);
	}
  return time;
}


/*********************************************************************************
* FUNCTION: ����ֻ���������ֺͻس�
* PARAMETER: null
* RETURNS: null
*********************************************************************************/
function g_CheckInputNum(obj){
  var keyCode = event.keyCode;
  if(keyCode==8)return;
  if(keyCode==46)return;
  if(keyCode==35)return;
  if(keyCode==36)return;
  if(keyCode==37)return;
  if(keyCode==39)return;
  if(event.keyCode==13)return;

  //֧��ctrl + a��v��x��c
  if(event.ctrlKey && (keyCode==65 || keyCode==67
    ||keyCode==86 || keyCode==88)){
    if(keyCode==86){
      var str = window.clipboardData.getData('text');
      if(str!=null){
        str = str.replace(/[^\d\n]/g,'');
        str = str.replace(/[\n]+/g,'\n');
        window.clipboardData.setData('Text',str);
      }
    }
    return;
  }

  if(48>event.keyCode || (event.keyCode > 57 && event.keyCode < 96)
     || event.keyCode >105 ){
    event.returnValue=false;
  }
  //��΢�����뷨����������
  if(keyCode ==229 && obj !=null){
    obj.disabled = true;
    obj.disabled = false;
    obj.focus();
    obj.value = obj.value.replace(/[^\d]/g,'');
  }
}

/*********************************************************************************
* FUNCTION: ����ֻ���������ֻ���ĸ��
* �������ĸ���£�"0123456789-_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ "
* PARAMETER: null
* RETURNS: null
*********************************************************************************/

function g_CheckInputEnglish(obj){
  var keyCode = event.keyCode;

  if(keyCode==8)return;
  if(keyCode==46)return;
  if(keyCode==35)return;
  if(keyCode==36)return;
  if(keyCode==37)return;
  if(keyCode==39)return;
  if(event.keyCode==13)return;

  //֧��ctrl + a��v��x��c
  if(event.ctrlKey && (keyCode==65 || keyCode==67
    ||keyCode==86 || keyCode==88)){
    //
    if(keyCode==86){
      var str = window.clipboardData.getData('text');
      if(str!=null){
        str = str.replace(/[\W]/g,'');
        window.clipboardData.setData('Text',str);
      }
    }
    return;
  }

  var checkOK = "0123456789-_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

  var str = String.fromCharCode(keyCode);

  if(checkOK.indexOf(str)<0 ){
    event.returnValue=false;
  }
  //��΢�����뷨����������
  if(keyCode ==229 && obj !=null){
    obj.disabled = true;
    obj.disabled = false;
    obj.focus();
    obj.value = obj.value.replace(/[\W]/g,'')
  }
}


//�ж��Ƿ������֤����
function g_IDCardNumber(value){
  if(value=='' || value==null)return true;
  var length = value.length;

  if(length ==15){
    if(!g_IsDigit(value) || value.substring(0,1)=='-'){
      return false;
    }
    return true;
  }else if(length ==18){
    //ǰ17λ����������
    var code="";
    for (i= 0; i < 17;  i++){
      code = value.charCodeAt(i);
      if(code<48 || code>57)return false;
    }
    //18λ���֤��������һλ���������ֻ�Ӣ����ĸ
    code = value.charCodeAt(17);
    if(code>=48 && code<=57 || code>=65 && code<=90 || code>=97 && code<=122){
      return true;
    }
  }
  //λ����Ϊ15����18�򷵻�
  return false;
}

//�ж����ڴ�С,�������������ַ����������������ڵĴ�С
// 0һ���� ��1 ��һ���ڴ� ��-1 �ڶ������ڴ�,-2����
function g_CompareDate(date_str1 ,date_str2){
  if(date_str1 ==null)date_str1='';
  if(date_str2==null ) date_str2='';

  if(date_str1 ==date_str2)return 0;

  if( !g_IsDateTime(date_str1) && !g_IsDate(date_str1)
      || !g_IsDateTime(date_str2) && !g_IsDate(date_str2) ){
    alert(g_I18NMessage("appframe_core","commutil_comparedate_err"));
    return -2;
  }

  if(date_str1 =='' && date_str2 !='') return -1;
  if(date_str2 =='' && date_str1 !='')return 1;

  var hour =0;
  var min =0;
  var sec =0;

  var dateTimeArray = date_str1.split(" ");
  var dateArray  = dateTimeArray[0].split(DATE_SEPARATOR);
  if(dateTimeArray.length>1){
    var timeArray = dateTimeArray[1].split(":");
    hour = timeArray[0];
    min = timeArray[1]
    sec = timeArray[2]
  }
  var d1= new Date(dateArray[0],dateArray[1]-1,dateArray[2],hour ,min ,sec);

  hour =0;
  min =0;
  sec =0;

  dateTimeArray = date_str2.split(" ");
  dateArray  = dateTimeArray[0].split(DATE_SEPARATOR);
  if(dateTimeArray.length>1){
    var timeArray = dateTimeArray[1].split(":");
    hour = timeArray[0];
    min = timeArray[1]
    sec = timeArray[2]
  }
  var d2= new Date(dateArray[0],dateArray[1]-1,dateArray[2],hour ,min ,sec);

  if (d1.getTime()==d2.getTime()) return 0;
  if(d1.getTime()>d2.getTime())return 1;
  else return -1;
}
/**
�ж��·ݲ�,�������������ַ��������������·ݲ�
���������ǷǷ�ֵ���׳��쳣
(year1-year2)*12+(month1-month2)
add by yangbb
*/
function g_MonthsBetween(date_str1 ,date_str2){
	if(date_str1 ==null){
		date_str1='';
	}	
    if(date_str2==null ){
    	date_str2='';
    }	

    if(date_str1 ==date_str2){
    	return 0;
	}
	
    if( !g_IsDateTime(date_str1) && !g_IsDate(date_str1)|| !g_IsDateTime(date_str2) && !g_IsDate(date_str2) ){
    	alert(g_I18NMessage("appframe_core","commutil_comparedate_err"));
    	//�׳��쳣
    	throw new Error(g_I18NMessage("appframe_core","commutil_not_date"));
  	}

	//����ʱ���ַ���
	var year1 =0;
    var month1 =0;
    var day1 =0;
	var dateTimeArray = date_str1.split(" ");
  	var dateArray  = dateTimeArray[0].split(DATE_SEPARATOR);
  	year1=dateArray[0];
  	month1=dateArray[1];
  	day1=dateArray[2];
  	
  	var year2 =0;
    var month2 =0;
    var day2 =0;
  	dateTimeArray = date_str2.split(" ");
  	dateArray  = dateTimeArray[0].split(DATE_SEPARATOR);
  	year2=dateArray[0];
  	month2=dateArray[1];
  	day2=dateArray[2];
  	
	return (year1-year2)*12+(month1-month2);
}

//У�������Ƿ�Ϸ� ,8λ�ǿ���ĸ ���������ֺ���ĸ
function checkPSWFormatValid(psw){
  if(psw==null || psw.length<8){
    alert(g_I18NMessage("appframe_core","commutil_pwd_len"));
    return false;
  }
  if(psw.indexOf(' ')>-1 || psw.indexOf('&')>-1){
    alert(g_I18NMessage("appframe_core","commutil_pwd_black"));
    return false;
  }

  var bNumber = false;//�ж������Ƿ�������
  var bAlphe = false; //�ж��Ƿ���Ӣ����ĸ

  for (i = 0;  i < psw.length;  i++){
      //�������Ӣ����ĸ�����֣��򷵻�true
      if(bNumber && bAlphe ){
        return true;
      }
      code = psw.charCodeAt(i);
      //�ж��Ƿ��������
      if(!bNumber){
        if(code>=48 && code<=57){
           bNumber = true;
           continue;
        }
      }
      //�ж��Ƿ����Ӣ����ĸ
      if(!bAlphe){
        if(code>=65 && code<=90 || code>=97 && code<=122){
           bAlphe = true;
        }
      }
   }
   if(bNumber && bAlphe ){
        return true;
   }
   alert(g_I18NMessage("appframe_core","commutil_pwd_all"));
   return false;
}


/*********************************************************************************
* FUNCTION: ��ʽ������ʱ�䷽��
* PARAMETER: aDate:js�е�aDate����,format-��ʽ�ַ���.��:yyyy-MM-dd hh:mm:ss
* RETURNS: ��ʽ�������ʱ���ַ���
* AUTHOR:ZLH
*********************************************************************************/
function g_FormatDate(aDate,format)
  {
    var o = {
    "M+" : aDate.getMonth()+1, //month
    "d+" : aDate.getDate(),    //day
    "h+" : aDate.getHours(),   //hour
    "m+" : aDate.getMinutes(), //minute
    "s+" : aDate.getSeconds(), //second
    "q+" : Math.floor((aDate.getMonth()+3)/3),  //quarter
    "S" : aDate.getMilliseconds() //millisecond
    }
    if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
    (aDate.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)if(new RegExp("("+ k +")").test(format))
    format = format.replace(RegExp.$1,
    RegExp.$1.length==1 ? o[k] :
    ("00"+ o[k]).substr((""+ o[k]).length));
    return format;
  }

/*********************************************************************************
* FUNCTION: ճ��ʱ����ֻ���������ֺͻس�
* PARAMETER: null
* RETURNS: null
*********************************************************************************/
function g_BeforePasteNum(){
  var str = window.clipboardData.getData('text');
  if(str!=null){
    str = str.replace(/[^\d\n]/g,'');
    str = str.replace(/[\n]+/g,'\n');
    str = str.replace(/(^\s*)|(\s*$)/g, "");
    window.clipboardData.setData('Text',str);
  }
}

/*********************************************************************************
* FUNCTION: ճ��ʱ����ֻ���������ֺ���ĸ
* PARAMETER: null
* RETURNS: null
*********************************************************************************/
function g_BeforePasteEnglish(){
  var str = window.clipboardData.getData('text');
  if(str!=null){
    str = str.replace(/[\W]/g,'');
    window.clipboardData.setData('Text',str);
  }
}
/**********************************************************************
*�ж��Ƿ�Ϊip��ַ
* PARAMETER: ip
* RETURNS: true��false
***********************************************************************/
function g_isIpNumber(ip){
	if(ip!=null&&ip!=""){
		var p = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
		return p.test(ip);
	}else{
		alert(g_I18NMessage("appframe_core","commutil_param_null"))
		return false;
	}
}
/**********************************************************************
*�ж��Ƿ�Ϊ��ַ
* PARAMETER: ip
* RETURNS: true��false
***********************************************************************/
function g_isUrl(url){
	if(url!=null&&url!=""){
		var p = /(http[s]?|ftp):\/\/[^\/\.]+?\..+\w$/i;
		return p.test(url);
	}else{
		alert(g_I18NMessage("appframe_core","commutil_param_null"))
		return false;
	}
}



//��ҳ����DBGrid����ʾ���ݼ���title����
function setDBGridTitle(tableid){
    var item = document.all["DataTable_"+tableid];
    if(item){
        if(item.childNodes[0]){
            var tbody = item.childNodes[0];
            var rows = tbody.children;
            var tro;
            var tds;
            for(var k=0;k<rows.length;k++){
                tro = rows[k];
                tds = tro.children;
                for(var j=0;j<tds.length;j++){
                    tds[j].title = tds[j].innerText;
                }
            }
        }
    }
    setQueryDBGridNotFindDataInfo(tableid);
}

function setQueryDBGridNotFindDataInfo(tableid){
    var item = document.all["FootTable_"+tableid];
    var dbTable = g_TableRowSetManager.get(tableid);
    if(item){
        if(dbTable.count()>0){//�м�¼
            var tbody = item.childNodes[0];
            var rows = tbody.children;
            var tro = rows[0];
            if(tro.children.length==2){
                tro.deleteCell(0);
            }
        }else{
            var tbody = item.childNodes[0];
            var rows = tbody.children;
            var tro = rows[0];
            if(tro.children.length<2){
                if(item.childNodes[0]){
                    var msg = g_I18NMessage("appframe_core","commutil_no_data");
                    var info = "<font color=red>"+msg+"</font>";
                    var cell = tro.insertCell(0);
                    cell.innerHTML=info;
                    //cell.appendChild(info);
                }
            }
        }
    }
}

function clearNotQueryDataInfo(tableids){
    if(tableids){
        for(var i=0;i<tableids.length;i++){
            var item = document.all["FootTable_"+tableids[i]];
            if(item){
                var tbody = item.childNodes[0];
                var rows = tbody.children;
                var tro = rows[0];
                if(tro.children.length==2){
                    tro.deleteCell(0);
                }                
            }
        }
    }
}
