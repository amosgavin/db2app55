/**
	�ļ����ƣ�Util.js
	����	: zhongrui
	����ʱ��: 2006-11-29
	�ļ����ݣ�������ʹ��һЩ���õ�js������
*/
var G_RTN_URL = _gModuleName+"/webframe/deskTop.jsp";

/*********************************************************************************
* FUNCTION: g_IsContainInArray.�ж��ַ����Ƿ����������Ԫ����.
* PARAMETER: pArray �������,pStrҪУ����ַ���
* RETURNS: true/false
*********************************************************************************/
function g_IsContainInArray(pArray,pStr)
{
   var reVal = false;
   if(pArray!=null){
     for(var i=0;i<pArray.length;i++)
     {
        if(pArray[i] == pStr){
          reVal = true;
          break;
        }
     }
   }
   return reVal;
}
/*********************************************************************************
* FUNCTION: g_GetElementInArrayByInxStr,���������ַ�,�ҳ�������ֵindexof�����ַ�����ֵ.
* PARAMETER: pArray �������;pInxStrҪ�����ַ���
* RETURNS: array����
*********************************************************************************/
function g_GetElementInArrayByInxStr(pArray,pInxStr){
  var reVal = new Array();
  for(var i=0;i<pArray.length;i++)
     {
        if(pArray[i]!=null && pArray[i].indexOf(pInxStr)>=0){
          reVal[reVal.length] = pArray[i];
          
        }
     }
  return reVal;   
}
/*********************************************************************************
* FUNCTION: g_GetElementInArrayByBeginEndStr,���������ַ�,�ҳ�������ֵ��begstr��ʼ,��endstr��β��Ԫ��ֵ.
* PARAMETER: pArray �������,Ҫ�����ַ���,pBeginStr��ʼ�ַ���,pEndStr�����ַ���,pIsFindAll-�Ƿ����ȫ��.true/false
* RETURNS: array����
*********************************************************************************/
function g_GetElementInArrayByBeginEndStr(pArray,pBeginStr,pEndStr,pIsFindAll)
{
   var reVal = new Array();
   for(var i=0;i<pArray.length;i++)
     {
        if(pArray[i]!=null && pArray[i].indexOf(pBeginStr)==0 && pArray[i].lastIndexOf(pEndStr)==(pArray[i].length-pEndStr.length)){
          reVal[reVal.length] = pArray[i];
          if(pIsFindAll==false){
            break;
          }
        }
     }
  return reVal;   
}
/*********************************************************************************
* FUNCTION: g_GetElementInArrayByIdxStr,������ʼ�ַ�,�����ַ�,�����ַ�.��ѯ����������ֵ.
* PARAMETER: pArray �������,Ҫ�����ַ���,pBeginStr��ʼ�ַ���,pInxStr,pEndStr�����ַ���,pIsFindAll-�Ƿ����ȫ��.true/false
* RETURNS: array����
*********************************************************************************/
function g_GetElementInArrayByIdxStr(pArray,pBeginStr,pIdxStr,pEndStr,pIsFindAll)
{
   var reVal = new Array();
   var checkFlag = 0;
   for(var i=0;i<pArray.length;i++)
     {
        checkFlag = 0;
        if(pArray[i]!=null){
          
          if( (pBeginStr!=null && g_StringTrim(pBeginStr)!="" && pArray[i].indexOf(pBeginStr)==0) || pBeginStr==null ||  g_StringTrim(pBeginStr)=="")
          {
            checkFlag++;
          }
          if((pEndStr!=null && g_StringTrim(pEndStr)!="" &&  pArray[i].lastIndexOf(pEndStr)==pArray[i].length-pEndStr.length) || pBeginStr==null ||  g_StringTrim(pEndStr)=="")
          {
            checkFlag++;
          }
          if((pIdxStr!=null && g_StringTrim(pIdxStr)!="" && pArray[i].indexOf(pIdxStr)>=0 ) || pIdxStr==null ||  g_StringTrim(pIdxStr)=="")
          {
            checkFlag++;
          }
          if(checkFlag==3)
          {
            reVal[reVal.length] = pArray[i];
            if(pIsFindAll==false){
               break;
            }
          }
          
          
        } 
          
    }
  return reVal;    
}

/*********************************************************************************
* FUNCTION: BCEFrame_hideWaitingBanner���صȴ���
* PARAMETER: none
* RETURNS: none
*********************************************************************************/
function BCEFrame_hideWaitingBanner()
{
  if(document.all.item("AIAPPFRAME_WAIT_DIV")!=null){
    //document.all.item("AIAPPFRAME_WAIT_DIV").style.visibility = "hidden";
    //ȥ���ȴ��������Ķ���Ĺ������߶ȣ�����divɾ����
    var divObj=document.all.item("AIAPPFRAME_WAIT_DIV");
    document.body.removeChild(divObj);
  }
}
/*********************************************************************************
* FUNCTION: BCEFrame_hideWaitingBanner��ʾ�ȴ���
* PARAMETER: none
* RETURNS: none
*********************************************************************************/
function BCEFrame_showWaitingBanner(pStr)
{
     if(pStr==null){
		 //    	 pStr="ҳ�����ڼ�����,���Ժ�......";
    	 pStr = crm_i18n_msg("BEC0000001");
     }
     if(document.all.item("AIAPPFRAME_WAIT_DIV")==null)
     {
        var divObj = document.createElement("div");
		document.body.appendChild(divObj);
		divObj.style.visibility = "visible";
		divObj.style.width = document.body.scrollWidth;
		divObj.style.height = document.body.scrollHeight;
		divObj.id = "AIAPPFRAME_WAIT_DIV";
		divObj.className = "AIAPPFRAME_WAIT_MAIN_CSS";
		divObj.innerHTML="<table width=\""+divObj.style.width+"\" height=\""+divObj.style.height+"\" border=0><tr><td align=\"center\" valign=\"middle\"><TABLE WIDTH=100% BORDER=0 CELLSPACING=0 CELLPADDING=0><TR><td width=30%></td><TD class='AIAPPFRAME_WAIT_DIV_BORDER_CSS'><TABLE WIDTH=100% height=70 BORDER=0 CELLSPACING=2 CELLPADDING=0>   <TR><td id=\"AIAPPFRAME_WAIT_DIV_CONTENT\" align=center class=\"AIAPPFRAME_WAIT_DIV_CSS\">"+pStr+"</td></tr></table></td><td width=30%></td></tr></table></td></tr></table>";
     }
    else{
      document.all.item("AIAPPFRAME_WAIT_DIV").style.visibility = "visible";
      document.all.item("AIAPPFRAME_WAIT_DIV_CONTENT").innerText = pStr;
    }
}

function BCEFrame_returnPageStrEncode(pStr)
{
   if(pStr==null || pStr=="") return pStr;
   var reStr = pStr;
   //��"$"����ת��
   reStr = reStr.replace(/\$/g,'$25');
   //��"="����ת��
   reStr = reStr.replace(/=/g,'$3D');
   //��"+"����ת��
   reStr = reStr.replace(/[+]/g,'$2B');
   //��'&'����ת��
   reStr = reStr.replace(/&/g,'$26');
   //��'#'����ת��
   reStr = reStr.replace(/#/g,'$23');
   //��%ת��
   reStr = reStr.replace(/%/g,'$27');
   return reStr;
}
function BCEFrame_returnPageStrDecode(pStr)
{
   if(pStr==null || pStr=="") return pStr;
   var reStr = pStr;
   //��"$"����ת��
   reStr = reStr.replace(/\$25/g,'$');
   //��"="����ת��
   reStr = reStr.replace(/\$3D/g,'=');
   //��"+"����ת��
   reStr = reStr.replace(/\$2B/g,'+');
   //��&����ת��
   reStr = reStr.replace(/\$26/g,'&');
   //��#����ת��
   reStr = reStr.replace(/\$23/g,'#');
   //��%ת��
   reStr = reStr.replace(/\$27/g,'%');
   return reStr;
}

//��ȡ��һҳ��ֵ,����&&&���в��,�����һ��urlת����Ϊ��һҳ��url.ʣ�µ�pre_page������Ϊ����������һҳ,�����ڶ�ջ��pop.
//Ŀǰ�����RETURN_PAGE,PRE_PAGE���Է��õ�url����&&&���˵Ķ��url
//urlPrefixNameΪ����URL��keyname,��RETURN_PAGE����PRE_PAGE.������urlΪurl...&urlPrefixName=preurl
function BCEFrame_getPrePageUrlStr(pAllUrlStr,urlPrefixName)
{
   var reVal ="";
   //��ȡ��һҳ��ֵ,����&&&���в��,�����һ��urlת����Ϊ��һҳ��url.
   
   
   if(pAllUrlStr.indexOf("$$$")>0){
     reVal =  BCEFrame_returnPageStrDecode(pAllUrlStr.substring(pAllUrlStr.lastIndexOf("$$$")+3,pAllUrlStr.length));
     if(reVal.indexOf("?")>0){
       reVal+="&";
     }
     else{
       reVal+="?";
     }
     reVal=reVal+urlPrefixName+"="+pAllUrlStr.substring(0,pAllUrlStr.lastIndexOf("$$$"));
   }
   else{
     reVal = BCEFrame_returnPageStrDecode(pAllUrlStr);
   }
   return reVal;
   
}
function BCEFrame_getPageUrlNoPrePageAndReturnPage(pUrlStr){
  var urlParamArray = pUrlStr.split("&");
  if(urlParamArray.length==1){
    if(urlParamArray[0].indexOf("?")>0 && (urlParamArray[0].indexOf("RETURN_PAGE")>=0 || urlParamArray[0].indexOf("PRE_PAGE")>=0)){
      return urlParamArray[0].split("?")[0];
    }
    else{
      return urlParamArray[0];
    }    
  }
  else{
    var url="";
    for(var i=0;i<urlParamArray.length;i++)
    {
      
      if(urlParamArray[i].indexOf("RETURN_PAGE")>=0 || urlParamArray[i].indexOf("PRE_PAGE")>=0){
        continue;
      }
      if(i==0) url+=urlParamArray[i];
      else url+="&"+urlParamArray[i];
    }
    return url;
  }
  
}

function isChinese(temp) 
{ 
	var re = /[^\u4e00-\u9fa5]/; 
	if(re.test(temp)) {
		return false;
	} 
	return true; 
} 
 

/**
 * �رյ�ǰTab ҳ
 * @returns {Boolean}
 */
function closeThisTab(){
	var pant = parent.getCurrentTabFocusItem("tab_desktop");
	 if(pant!= -1){
		 parent.closeTabItemByIdx("tab_desktop",pant);
		 return true;
	 }
    if(pant==-1){
   	 pant = parent.getCurrentTabFocusItem("tab_userview");
    }
    if(pant!= -1){
		 parent.closeTabItemByIdx("tab_userview",pant);
		 return true;
	 }
}