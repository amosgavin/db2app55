
var _gStrLocale="<%=com.ai.appframe2.util.locale.AppframeLocaleFactory.getCurrentLocale().toString() %>";

/**
* getValue by res and key
* param: null if not need
*/
function g_I18NMessage(res,key,param){
  var value = key;
  if(res != null && res != "")
    value = eval(res+"."+key);
  if(value == null || value == undefined){
    value = key;
  }
  if(param != null && param.length > 0){
    for(var i=0;i< param.length;i++){
      value = value.replace(new RegExp("\\{"+i+"\\}", 'g'),param[i]);
    }
  }
  return value;
}

