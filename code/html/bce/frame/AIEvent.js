var g_AIEvent = new AIEvent();

var g_AIEvent_FORM_EVENT_ONVALUECHANGE = "ONVALUECHANGE";
function AIEvent()
{
	
	this.listenArray = new Array();
	this.listenSeqArray = new Array();
	AIEvent.prototype.register = AIEvent_register;
	AIEvent.prototype.registerDBForm = AIEvent_registerDBForm;
	AIEvent.prototype.registerDBGrid = AIEvent_registerDBGrid;
	AIEvent.prototype.initial = AIEvent_initial;
    	
	
	
	
	
	//�ڲ�����
	AIEvent.prototype.registerPrivate = AIEvent_registerPrivate;
	AIEvent.prototype.trigerEvent = AIEvent_trigerEvent;
	AIEvent.prototype.trigerDBFormValueChangeEvent = AIEvent_trigerDBFormValueChangeEvent;
	
}

function AIEvent_register(pSrcName,pEvent,pFunc,pParam)
{
  if(document.all.item(pSrcName)){
     var myFunc = function(){
       eval("tmpObj="+pFunc);
       tmpObj(pParam);
     }
     
     //attachEvent���Ḳ��֮ǰע��ķ�������ע�ᷴ��ִ��
     document.all.item(pSrcName).attachEvent(pEvent,myFunc);
    
     return true;
  }
  else
  {
    alert("ע��ʧ��, ҳ�����Ҳ���Դ�¼�����"+pSrcName+".");
    return false;
  }
  		
}





/**
 pSrcType-Դ�������ͣ�Ŀǰ����Normal,DBGrid,DBForm
 pExtendCond-��չ��������ͬ��������岻ͬ��DBForm��DBGrid�����������ֶ�����
 
*/
function AIEvent_registerPrivate(pSrcType,pSrcName,pEvent,pFunc,pParam,pExtendCond,pSeqNo)
{
  if(this.listenArray[pSrcName]==null)
      {
        this.listenArray[pSrcName] = new Array();
        this.listenSeqArray[pSrcName] = new Array();
      }
  if(this.listenArray[pSrcName]!=null)
  {
        var listenerPool = this.listenArray[pSrcName];
        var listenerSeqPool = this.listenSeqArray[pSrcName];
        listenerSeqPool[listenerSeqPool.length] = pSeqNo;
        listenerPool[pSeqNo] = {type:pSrcType,event:pEvent.toUpperCase(),func:pFunc,param:pParam,extcond:pExtendCond.toUpperCase()};   
  }
      
  
 
  
  
}


function AIEvent_unregister(pSrcName,pEvent,pExtCond)
{
	 if(this.listenArray[pSrcName]!=null)
	 {
	 	 var listenPool = this.listenArray[pSrcName];
	 	 if(pEvent!=null && pEvent!="")
	 	   {
	 	 	   for(var i=0;i<listenPool.length;i++)
	 	     {
	 	 	   	   if(listenPool[i].event == pEvent)
	 	 	   	   {
	 	 	   	     if(pExtCond==null || pExtCond=="" || pExtCond == listenPool[i].extcond)
	 	 	   	     {
	 	 	   	     	  var lastObj = listenPool.pop();
	 	 	   	        listenPool[i] = lastObj;
	 	 	   	     }
	 	 	   	     
	 	 	       }
	 	     }
	 	   }
	 	 else
	 	 	 {
	 	 	 	 for(var i=0;i<listenPool.length;i++)
	 	     {
	 	     	  listenPool[i] = null;
	 	     }
	 	     this.listenArray[pSrcName]=null;
	 	 	 }
	 	 }
	 	
	 
}


function AIEvent_trigerEvent(pSrcObjName,pEventName)
{
  

  if(pSrcObjName &&  this.listenArray[pSrcObjName])
  {
     var listenerPool = this.listenArray[pSrcObjName];
     
     for(var i=0;i<listenerPool.length;i++)
     {
       
       if(pEventName.toUpperCase() == listenerPool[i].event)
       {
         var funcName =  listenerPool[i].func;
         var param = listenerPool[i].param;
         eval("tmpObj="+funcName);
         tmpObj(param);
         	
         /*
         var funcObj = function(){
         	 var a = eval("var tmpObj="+funcName);
         	 tmpObj(param);
			   }*/
		      	  
		
			   
			   

       }
     }
    
     
     
  }
}


/*
DBForm���¼�ʵ��
*/
var g_AIEvent_DBForm_triggerEventArray = new Array();
g_AIEvent_DBForm_triggerEventArray[g_AIEvent_FORM_EVENT_ONVALUECHANGE] = "AIEvent_trigerDBFormValueChangeEvent";
function AIEvent_registerDBForm(pFormId,pFormField,pEvent,pFuncName,pParam,pSeqNo)
{
	var formObj = g_FormRowSetManager.get(pFormId);
	if(formObj)
  { 
    //��ע��form������ķ���
	var oldFunc = formObj.OnValueChangeFunc; //ֱ������form�ϵ�onValChange�¼�
	if(oldFunc != null && this.listenArray[pFormId]==null){
	  this.registerPrivate("DBForm",pFormId,pEvent,oldFunc,"","","50");
	}
	//end
	
  	if(pFormField==null) pFormField = "";
  	if(pParam == null) pParam = "";
  	this.registerPrivate("DBForm",pFormId,pEvent,pFuncName,pParam,pFormField.toUpperCase(),pSeqNo);

  	formObj.onValueChange(g_AIEvent_DBForm_triggerEventArray[pEvent.toUpperCase()]);
  	//alert(g_AIEvent_DBForm_triggerEventArray[pEvent.toUpperCase()]);
  }
  else{
    alert("ע��ʧ��, ҳ�����Ҳ���DBForm�¼�����DBFormId="+pFormId+".");
    return false;
  }
}

function AIEvent_trigerDBFormValueChangeEvent(pFieldName,pOldVal,pNewVal,DBFormPK)
{
  
  //alert(pFieldName);
  if(DBFormPK && g_AIEvent.listenArray[DBFormPK]!=null)
  {
     var listenerPool = g_AIEvent.listenArray[DBFormPK];
     var listenerSeqPool = g_AIEvent.listenSeqArray[DBFormPK];
     listenerSeqPool.sort();
     for(var i=0;i<listenerSeqPool.length;i++)
     {
       
       var seq = listenerSeqPool[i];
       if(g_AIEvent_FORM_EVENT_ONVALUECHANGE == listenerPool[seq].event && "DBForm" == listenerPool[seq].type && (pFieldName.toUpperCase()==listenerPool[seq].extcond || listenerPool[seq].extcond==""))
       {
         
         var funcName =  listenerPool[seq].func;
         var param = listenerPool[seq].param;
         
         eval("var tmpObj="+funcName);
         var result = null;
         if(param!=null && param!="")
        	 result = tmpObj(param);
         else
        	 result = tmpObj(pFieldName,pOldVal,pNewVal,DBFormPK);
         if(result != null && result == false)
        	 return;
       }
     }
    
     
     
  }
}

function AIEvent_initial(){

}


function AIEvent_registerDBGrid(gridId,eventName,functionName){
	var formObj = g_TableRowSetManager.get(gridId);
	//alert(formObj);
	eval("formObj."+eventName +"="+functionName);
}


