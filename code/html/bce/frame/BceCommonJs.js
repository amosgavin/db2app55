//ע�������ռ�
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
 * ���ù��߲�����~
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
	 * ���ӹر��¼�����
	 * 
	 * @param id
	 *            tableId
	 * @param functionName
	 *            ��������
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
	 * ����һ���µ�Tabҳ
	 * 
	 * @param tabId
	 *            TAB���
	 * @param TabItemId
	 *            TabItem���
	 * @param aTitle
	 *            ��ʾ����
	 * @param aUrl
	 *            Url��ַ
	 * @param aIsDeletable
	 *            �Ƿ���ɾ����
	 * @param aIdx
	 *            ������ַ
	 * @param closeFunc
	 *            �ر��¼���������
	 * @return
	 */
	this.bceOpenNewTabItem = function(tabId,TabItemId,aTitle,aUrl,aIsDeletable,aIdx,closeFunc){
		var aTabId = "bce_tab_"+tabId;
		var aTabItemId =tabId+"_"+TabItemId;
		openNewTabItem(aTabId,aTabItemId,aTitle,aUrl,aIsDeletable,aIdx);
		this.tabCloseFunction(aTabItemId,closeFunc,tabId);
	}
	
	/**
	 * ���ط���
	 * @param id
	 * @return
	 */
	this.onBusiStart = function(id){
		if(!this.buttonDisabled(id)) return false;
		return true;
	}
	
	/**
	 * ��buttonDisabled()���������˴���
	 * @param id
	 * @return
	 */
	this.buttonDisabled= function(id){
		//��⵱ǰ�Ƿ����Button �������������жϣ����򲻽����жϡ�
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
 * Bce���������
 */
var g_AiBcecommon  = new com.ai.bce.ui.js.BceCommon();