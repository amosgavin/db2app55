//注册命名空间
Namespace.register("com.ai.bce.ui.js");


com.ai.bce.ui.js.commonTool= function(){
	this.getChildNode = function(key,id){
		var array = key.childNodes;
		for ( var i = 0; i < array.length; i++) {
			if(array[i].id == id){
				return array[i];
			}
			var child = this.getChildNode(array[i],id);
			if( child!= null)
				return child;
		}
	}
	this.$ = function(id){
		return document.getElementById(id);
	}
	
	this.onready = function(){
		var prate = window.parent;
		if(prate==window){
			return true;
		}
		
		var state  = prate.readyState;
		if (state && state == 'complete'){
			return true;
		}
		
		prate.onreadystatechange = function() {
			var state  = prate.readyState;
			if (state && state == 'complete') {
				eval("");
			}else{
			}
		}
		
	}
}
/**
 * 常用工具测试类~
 */
var g_AiBcetools =new com.ai.bce.ui.js.commonTool();


com.ai.bce.ui.js.BceCommon=function(){
	this.NormalToAction=function(ruString){
		var url = _gModuleName + "/business/com.ai.bce.web.BceRuleForJsAction?action=checkRule" + ruString;
		var reVal = PostInfo(url, "");
		var ret = reVal.getValueByName("retVal");
		if (ret == "Y") {
			if (reVal.getValueByName("retMsg") != "") {
				alert(reVal.getValueByName("retMsg"));
			}
			return true;
		} else {
			alert(reVal.getValueByName("retMsg"));
			return false;
		}
	}
	this.getDbFormSrcFuntion=function(objName,eventName){
		var formObj = g_FormRowSetManager.get(objName);
		var funct = null;
		if(formObj!= null)
			eval( "funct = formObj."+eventName );
		return funct;
	}
	this.NormalToActionWarning=function(ruString){
		var url = _gModuleName + "/business/com.ai.bce.web.BceRuleForJsAction?action=checkRule&"+ ruString;
		var reVal = PostInfo(url, "");
		var ret = reVal.getValueByName("retVal");
		if (ret == "Y") {
			return new Array(true,reVal.getValueByName("retMsg"));
		} else {
			return new Array(false,reVal.getValueByName("retMsg"));
		}
	}
	
	this.getSrcDbTableFuntion = function(objName,eventName){
		var formObj = g_TableRowSetManager.get(objName);
		var funct = null;
		if(formObj!= null)
			eval( "funct = formObj."+eventName );
		return funct;
	}
	/**
	 * 增加关闭事件监听
	 * 
	 * @param id
	 *            tableId
	 * @param functionName
	 *            方法名称
	 * @param tabId
	 * @param tabitem
	 * @return
	 */
	this.tabCloseFunction = function(itemId,functionName,tabId){
		tabId = "bce_tab_"+tabId;
		var tab = g_AiBcetools.$(tabId+"_Title_"+itemId);
		var closeItem = g_AiBcetools.getChildNode(tab,"tab_item_close_button");
		if(closeItem!=null){
			closeItem.onclick = function(){
				if(functionName!=null&&functionName!=""){
					eval("var falg="+functionName+"('"+tabId+"','"+itemId+"');");
					if(!falg){
						return;
					}
				}
				closeClickedTabItem(tabId,closeItem);
			};
		}
	}
	
	/**
	 * 创建一个新的Tab页
	 * 
	 * @param tabId
	 *            TAB编号
	 * @param TabItemId
	 *            TabItem编号
	 * @param aTitle
	 *            显示名称
	 * @param aUrl
	 *            Url地址
	 * @param aIsDeletable
	 *            是否是删除的
	 * @param aIdx
	 *            索引地址
	 * @param closeFunc
	 *            关闭事件方法名称
	 * @return
	 */
	this.bceOpenNewTabItem = function(tabId,TabItemId,aTitle,aUrl,aIsDeletable,aIdx,closeFunc){
		var aTabId = "bce_tab_"+tabId;
		var aTabItemId =tabId+"_"+TabItemId;
		openNewTabItem(aTabId,aTabItemId,aTitle,aUrl,aIsDeletable,aIdx);
		this.tabCloseFunction(aTabItemId,closeFunc,tabId);
	}
	
	/**
	 * 拦截方法
	 * @param id
	 * @return
	 */
	this.onBusiStart = function(id){
		if(!this.buttonDisabled(id)) return false;
		return true;
	}
	
	/**
	 * 对buttonDisabled()方法进行了处理
	 * @param id
	 * @return
	 */
	this.buttonDisabled= function(id){
		//检测当前是否存在Button 如果存在则进行判断，否则不进行判断。
		if(typeof(g_AIButtonManager)!="undefined"){
			var obj = document.all(id+'_btnText');
			if(obj){
				return !document.all(id).disabled;
			}
		}
		return true;
	}
}


/**
 * Bce基础服务包
 */
var g_AiBcecommon  = new com.ai.bce.ui.js.BceCommon();