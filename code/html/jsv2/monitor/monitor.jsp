<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ai.appframe2.monitor.URLFilter" %>

var ip ='<%= URLFilter.getIpAddr(request) %>'; 

//��ʾ�Ƿ���
var monitor_flag = true; 

//����ҳ��ִ��ʱ��ĵ�ַ
var recordJSExecTimeServlet ='/WebJSServlet';

//LOG��¼���
var ai_log_pk = -1;

//һ��������,action�ڼ��α�����
var exec_order = 0;

//��ǰ����ִ�й����е���־��Ϣ
var array_loginfo = new Array();

//������־��Ϣ
var all_logs_info = new Array();

//��ȡΨһLogPK
function  AI_getLogPK(){
  if(ai_log_pk ==-1){
    var current = new Date();
    ai_log_pk = ip + "_" + current.getTime() ;
    exec_order = 0
    array_loginfo = new Array();
    all_logs_info[all_logs_info.length] = array_loginfo;
  }
  exec_order ++;
  return ai_log_pk ;
}

//�ڵ���callHttpʱ,ͬʱ���͵�ǰ��LOGPK ��ִ��˳��ŵ���̨
function getLogString(){
  var pageURL = window.location.href;
  var index = window.location.href.indexOf(_gModuleName);
  if(index>-1){
    pageURL = window.location.href.substr(index);
  }
  
  
  
  var str = "&AILOGSTRING=" +  AI_getLogPK() + "@"+ exec_order +"@" + getUIID(pageURL);
  return str;
}

function getUIID(pageURL){
  index = pageURL.indexOf("?");
  if(index>-1){
    pageURL = pageURL.substring(0,index);
  }
  
  //��ȡ��ǰ�¼���Ӧ��element src 
  if(event == null || event.srcElement == null){
    return pageURL + "|onload";
  }
  
  var obj = event.srcElement;
  var str = "";
  
  if(obj.id != null && obj.id !=''){
    str = "|ctrl_id=" + obj.id;
  }else if(obj.name != null && obj.name !=''){
    str = "|ctrl_name=" + obj.name;
  }else if(typeof(obj.value)!='undefined' && obj.value != null && obj.value !=''){
    tmp = "" + obj.value;
    if(tmp.length>10){
      tmp = tmp.substring(0,6) + "...";
    }
    str = "|ctrl_value=" + tmp;
  }else{
    tmp = obj.innerText;
    if(tmp.length>10){
      tmp = tmp.substring(0,6) + "...";
    }
    str = "|ctrl_text=" + tmp;
  }
  
  str = str + "|ctrl_tag=" + obj.tagName;
  str = str + "|eventType=" + event.type;
  
  return pageURL + str;
}

//����ִ�е�ʱ���¼��LOGPK��˳��š���Ӧ��ַ����Ϣ
function recordExecStartTime(){
  if(exec_order ==1){
    array_loginfo["log_pk"] = ai_log_pk;
    array_loginfo["control_address"] = getCurrentAddress();
    array_loginfo["start_time"] = (new Date()).getTime();
  }
}

//��¼��ϵ�ʱ��
function recordExecEndTime(){
  array_loginfo["end_time"] = (new Date()).getTime();
}

//��ȡ��ǰ��Ӧ�ؼ��ĵ�ַ
function getCurrentAddress(){
  var pageURL = window.location.href;
  var index = window.location.href.indexOf(_gModuleName);
  if(index>-1){
    pageURL = window.location.href.substr(index);
  }

  //��ȡ��ǰ�¼���Ӧ��element src 
  if(event == null || event.srcElement == null){
    return pageURL + "|onload";
  }
  
  var obj = event.srcElement;
  var str = "";
  
  if(obj.id != null && obj.id !=''){
    str = "|ctrl_id=" + obj.id;
  }else if(obj.name != null && obj.name !=''){
    str = "|ctrl_name=" + obj.name;
  }else if(typeof(obj.value)!='undefined' && obj.value != null && obj.value !=''){
    tmp = "" + obj.value;
    if(tmp.length>10){
      tmp = tmp.substring(0,10) + "...";
    }
    str = "|ctrl_value=" + tmp;
  }else{
    tmp = obj.innerText;
    if(tmp.length>10){
      tmp = tmp.substring(0,10) + "...";
    }
    str = "|ctrl_text=" + tmp;
  }
  
  str = str + "|ctrl_tag=" + obj.tagName;
  str = str + "|eventType=" + event.type;
  
  return pageURL + str;
}

//����ǰ���е���־��Ϣת�����ַ���
function translateLogToString(){
  var str = '';
  
  for(i=0;i< all_logs_info.length;i++){
     var tmp = '';
     var arr = all_logs_info[i];
     for(prop in arr){
        tmp = tmp + "#" + prop + "=" + arr[prop];
     }
    str = str + "@@" + tmp;
  }
  
  all_logs_info.length = 0;
  return str;
}


//���ü�¼ID
function reset_logPK(){
  ai_log_pk = -1;
}

//�첽������Ϣ����̨WEB������
function sendWebLogInfo(){
  if(all_logs_info.length==0) return;
  
  var str = translateLogToString();
  
  var Sender = g_GetXMLHTTPRequest();
  Sender.Open("POST",_gModuleName + recordJSExecTimeServlet,true);
  Sender.send(str);
}

//����ǰҳ�����־��Ϣ��������ҳ�洦��
function addLogInfoToParent(arr){
  if(arr==null || arr.length==0)return;
  all_logs_info = all_logs_info.concat(arr);
}

//�������ü�¼��غ����������ҳ����ڼ�غ��������ø�ҳ��ģ��������Լ���
function resetExecFunction(){
  try{
    if(window.parent !=null && window.parent.location != window.location 
       && window.parent.addLogInfoToParent !=null){
        this.addLogInfoToParent = window.parent.addLogInfoToParent;      
        window.setInterval("this.addLogInfoToParent(all_logs_info);all_logs_info.length=0",3000);
        return;
    }
  }catch(e){
  }
    
  window.setInterval("sendWebLogInfo()",5000);
}

//��ʼ������������
function monitor_init(){
  if(window.document.body !=null){
    window.document.body.attachEvent('onmousemove', reset_logPK);
    window.document.body.attachEvent('onkeyup', reset_logPK);
  }
  
  //��ǿҳ��onunload �������ڹرյ�ʱ���ͼ������
  window.attachEvent('onunload', sendWebLogInfo);
  resetExecFunction();
}

window.attachEvent('onload', monitor_init);


