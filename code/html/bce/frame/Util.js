/**
	文件名称：Util.js
	作者	: zhongrui
	编制时间: 2006-11-29
	文件内容：受理中使用一些常用的js工具类
*/
var G_RTN_URL = _gModuleName+"/webframe/deskTop.jsp";

/*********************************************************************************
* FUNCTION: g_IsContainInArray.判断字符串是否包含在数组元素中.
* PARAMETER: pArray 数组对象,pStr要校验的字符串
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
* FUNCTION: g_GetElementInArrayByInxStr,根据索引字符,找出数组中值indexof索引字符串的值.
* PARAMETER: pArray 数组对象;pInxStr要检查的字符串
* RETURNS: array数组
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
* FUNCTION: g_GetElementInArrayByBeginEndStr,根据索引字符,找出数组中值以begstr开始,以endstr结尾的元素值.
* PARAMETER: pArray 数组对象,要检查的字符串,pBeginStr开始字符串,pEndStr结束字符串,pIsFindAll-是否遍历全部.true/false
* RETURNS: array数组
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
* FUNCTION: g_GetElementInArrayByIdxStr,根据起始字符,索引字符,结束字符.查询符合条件的值.
* PARAMETER: pArray 数组对象,要检查的字符串,pBeginStr开始字符串,pInxStr,pEndStr结束字符串,pIsFindAll-是否遍历全部.true/false
* RETURNS: array数组
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
* FUNCTION: BCEFrame_hideWaitingBanner隐藏等待条
* PARAMETER: none
* RETURNS: none
*********************************************************************************/
function BCEFrame_hideWaitingBanner()
{
  if(document.all.item("AIAPPFRAME_WAIT_DIV")!=null){
    //document.all.item("AIAPPFRAME_WAIT_DIV").style.visibility = "hidden";
    //去除等待条带来的额外的滚动条高度，将该div删除。
    var divObj=document.all.item("AIAPPFRAME_WAIT_DIV");
    document.body.removeChild(divObj);
  }
}
/*********************************************************************************
* FUNCTION: BCEFrame_hideWaitingBanner显示等待条
* PARAMETER: none
* RETURNS: none
*********************************************************************************/
function BCEFrame_showWaitingBanner(pStr)
{
     if(pStr==null){
		 //    	 pStr="页面正在加载中,请稍候......";
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
   //对"$"进行转化
   reStr = reStr.replace(/\$/g,'$25');
   //对"="进行转化
   reStr = reStr.replace(/=/g,'$3D');
   //对"+"进行转化
   reStr = reStr.replace(/[+]/g,'$2B');
   //对'&'进行转换
   reStr = reStr.replace(/&/g,'$26');
   //对'#'进行转换
   reStr = reStr.replace(/#/g,'$23');
   //对%转化
   reStr = reStr.replace(/%/g,'$27');
   return reStr;
}
function BCEFrame_returnPageStrDecode(pStr)
{
   if(pStr==null || pStr=="") return pStr;
   var reStr = pStr;
   //对"$"进行转化
   reStr = reStr.replace(/\$25/g,'$');
   //对"="进行转化
   reStr = reStr.replace(/\$3D/g,'=');
   //对"+"进行转化
   reStr = reStr.replace(/\$2B/g,'+');
   //对&进行转化
   reStr = reStr.replace(/\$26/g,'&');
   //对#进行转化
   reStr = reStr.replace(/\$23/g,'#');
   //对%转化
   reStr = reStr.replace(/\$27/g,'%');
   return reStr;
}

//获取上一页的值,按照&&&进行拆分,将最后一个url转码作为上一页的url.剩下的pre_page继续作为参数传到上一页,类似于堆栈的pop.
//目前框架中RETURN_PAGE,PRE_PAGE属性放置的url是以&&&分账的多个url
//urlPrefixName为返回URL的keyname,如RETURN_PAGE或者PRE_PAGE.最后构造的url为url...&urlPrefixName=preurl
function BCEFrame_getPrePageUrlStr(pAllUrlStr,urlPrefixName)
{
   var reVal ="";
   //获取上一页的值,按照&&&进行拆分,将最后一个url转码作为上一页的url.
   
   
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
 * 关闭当前Tab 页
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