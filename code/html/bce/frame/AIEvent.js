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
    	
	
	
	
	
	//内部方法
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
     
     //attachEvent不会覆盖之前注册的方法，按注册反序执行
     document.all.item(pSrcName).attachEvent(pEvent,myFunc);
    
     return true;
  }
  else
  {
    alert("注册失败, 页面中找不到源事件对象："+pSrcName+".");
    return false;
  }
  		
}





/**
 pSrcType-源对象类型，目前包括Normal,DBGrid,DBForm
 pExtendCond-扩展条件，不同的组件含义不同，DBForm，DBGrid类型里面存放字段名称
 
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
DBForm的事件实现
*/
var g_AIEvent_DBForm_triggerEventArray = new Array();
g_AIEvent_DBForm_triggerEventArray[g_AIEvent_FORM_EVENT_ONVALUECHANGE] = "AIEvent_trigerDBFormValueChangeEvent";
function AIEvent_registerDBForm(pFormId,pFormField,pEvent,pFuncName,pParam,pSeqNo)
{
	var formObj = g_FormRowSetManager.get(pFormId);
	if(formObj)
  { 
    //先注册form上已配的方法
	var oldFunc = formObj.OnValueChangeFunc; //直接配在form上的onValChange事件
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
    alert("注册失败, 页面中找不到DBForm事件对象：DBFormId="+pFormId+".");
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


