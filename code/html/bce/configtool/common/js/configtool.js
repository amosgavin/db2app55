 
 //将TAB页全屏
function resizeTabToFullWindwo(tabId){
	var tableObj=document.getElementById(tabId+"_allTable");

	tableObj.width = document.body.clientWidth;
	tableObj.height = window.document.body.clientHeight;
	//tableObj.border=1;

	var mainTable=document.getElementById(tabId+"_mainTable");

	mainTable.width = document.body.clientWidth;
	mainTable.height = window.document.body.clientHeight-30;
}

//当顶层是数据列表时调用，刷新底部窗口，顶级窗口将参数传递到底部窗口
function showDataDetail (argument){
	//获取底部详细页面当前所在的的tab框
	var curTabItemName = "";
	try{
		curTabItemName = getTopWindow().frame_bottom.getIndexBottomSelectedTabName("main_tab");
	}catch(e){}
	
	var url = "index_bottom.jsp?showDetail=true&" + argument;
	if(curTabItemName != null && curTabItemName != ''){
		url = url + "&curTabItemName=" + curTabItemName;
	}
	url=url + "&module_id=" + getCurrentModuleId();
	
	clearIframe(getTopWindow().document.getElementById("frame_bottom"));
	getTopWindow().frame_bottom.location=url;
}


//当顶层是树图形时调用，刷新底部窗口，顶级窗口将参数传递到底部窗口
function showDataDetailForChart (argument ,type){
	//根据type获取JSP所在目录
	var url = getJspDirByType(type);
	if(url == ''){
		getTopWindow().frame_bottom.location="about:blank";
		return;
	}
	
	if(argument !=null && argument !='null' && argument !=''){
		url = url + "index_bottom.jsp?showChart=false&curTabItemName=detail&" + argument;	
	}
	url=url + "&module_id=" + getCurrentModuleId();
	
	clearIframe(getTopWindow().document.getElementById("frame_bottom"));
	getTopWindow().frame_bottom.location=url;
}

//根据节点类型，获取JSP所在的目录
function getJspDirByType(type){
	if(type =='BCE_FRAME'){
		return "../bceframe/";
	}else if(type =='BCE_PAGE_FRAME'){
		return "../pageframe/";
	}else if(type =='BCE_PAGE_FRAME_PAGE'){
		return "../pageFramePage/";
	}else if(type =='BCE_PAGE'){
		return "../page/";
	}else if(type =='BCE_ROWSET'){
		return "../rowset/";
	}else if(type =='BCE_RULE'){
		return "../rule/";
	}else if(type =='BCE_FRAME_PAGE_ROLE'){
		return "../framePageRole/";
	}else if(type =='BCE_PAGE_ROWSET_REL'){
		return "../pagerowset/";
	}else if(type =='BCE_RULESET'){
		return "../ruleset/";
	}else if(type =='BCE_FRAME_JAVA_RULESET_REL'){
		return "../javaruleset/";
	}else if(type =='BCE_RULESET_RULE'){
		return "../rulesetrule/";
	}else if(type =='BCE_FRAME_SPECIAL_PAGE'){
		return "../specialPage/";
	}
	
	return "";
}



//底部窗口详细信息修改后，刷新顶部的窗口数据的代理方法，该方法等待主窗口注册
function refreshTopByDetailChange_Proxy(){}

//供底层窗口调用，客户端窗口详细信息修改后，刷新顶部方法
function refreshTopByDetailChange(){
	if(typeof(getTopWindow().refreshTopByDetailChange_Proxy) !='undefined'){
		getTopWindow().refreshTopByDetailChange_Proxy();
	}
}

//该方法供顶层窗口调用，实现当底部详细信息修改后，顶层窗口需要做的操作
function registerEventWhenDetailChange(func){
	//if(typeof(getTopWindow().refreshTopByDetailChange_Proxy) !='undefined'){
		getTopWindow().refreshTopByDetailChange_Proxy = func;
	//}
}



//底部窗口引用信息修改后，刷新顶部的窗口数据的代理方法，该方法等待主窗口注册
function refreshTopByQuoteChange_Proxy(){}

//供底层窗口调用，客户端窗口引用信息修改后，刷新顶部方法
function refreshTopByQuoteChange(){ 
	if(typeof(getTopWindow().refreshTopByQuoteChange_Proxy) !='undefined'){
		getTopWindow().refreshTopByQuoteChange_Proxy();
	}
}

//该方法供顶层窗口调用，实现当底部引用信息修改后，顶层窗口需要做的操作
function registerEventWhenQuoteChange(func){
	//if(typeof(getTopWindow().refreshTopByDetailChange_Proxy) !='undefined'){
		getTopWindow().refreshTopByQuoteChange_Proxy = func;
	//}
}

//获取顶级窗口
function getTopWindow(){
	var topFrame = window.parent;
	while(topFrame.parent != topFrame){
		topFrame = topFrame.parent;
	}
	return topFrame;
}

//获取index_bottom.jsp页面当前选中的tab_id
function getIndexBottomSelectedTabName(tab_id){
	//获取选中TABITEM的缩影
	var index = getCurrentTabFocusItem(tab_id);
	if(index <0)return null;
	
  	var aMainObj=document.getElementById(tab_id +"_mainTable");
  	if(aMainObj.rows[0].cells.length <= index){
  		return null;
  	}
  	
	var itemName = aMainObj.rows[0].cells[index].id;
	itemName = itemName.replace(tab_id+"_TableBody_" , "");
	return itemName;
 
}

//重新加载图片
function reloadChar(){
	window.location.reload();
}

function windowOpenFullScreen(url,name){   
	window.open(url ,name ,"menubar=no,status=no,resizable=yes,scrollbars=no,toolbar=no,top=0,left=0,width="+ (screen.Width-8)+ ",height=" +(screen.Height-60));
}


function clearIframe(iframeObj){
	try{
		var doc = iframeObj.contentDocument;
		
		if (typeof(doc) == 'undefined' || doc == null){ 
		   doc = iframeObj.contentWindow.document;
		} 
		doc.write('');        
		doc.clear(); 
	}
	catch(e){}
}

function clickFirstRow(tableId){
	if(g_TableRowSetManager.get(tableId).count()>0){
		g_TableRowSetManager.get(tableId).setRow(0);
	}
}

//获取当前系统的模块ID
function getCurrentModuleId(){
	if(typeof(getTopWindow().module_id)!='undefined'){
		return getTopWindow().module_id
	}
	return "";
}

var searchTxt = "请输入查询条件，多个条件用空格分开";
function searchTextFocus(){
	if(this.value==searchTxt){
		this.value='';
	}
	this.style.color='#000';
}
function searchTextBlur(){
	if(this.value==''){
		this.value=searchTxt;
	}
	this.style.color='#888'	;
}

//设置输入文本风格
function setSearchText(id){
	var obj = document.getElementById(id);
	if(obj == null )return;
	
	obj.value=searchTxt;
	obj.style.color='#888'
	obj.onfocus=searchTextFocus;
	obj.onblur=searchTextBlur;
}

//获取输入文本的值
function getValueFromSearchText(id){
	
	var obj = document.getElementById(id);
	if(obj == null )return '';
	
	if(obj.value ==searchTxt)return '';
	
	return obj.value;
}