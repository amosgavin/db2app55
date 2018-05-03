function crm_i18n_msg(key,param){
  var value = eval("crm_message_resource."+key);
  if(value == null || value == undefined){
    value = key;
  }
  if(arguments.length> 1){
    for(var i=1;i < arguments.length;i++){
      value = value.replace(new RegExp("\\{"+(i-1)+"\\}", 'g'),arguments[i]);
    }
  }
  return value;
}

var crm_message_resource={
  <%
  try{
    out.print(com.ai.common.util.WebUtil.generatorJsResource());
  }catch(Exception ex){
    ex.printStackTrace();
  }
  %>
}
