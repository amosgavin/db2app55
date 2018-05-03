 
 //��TABҳȫ��
function resizeTabToFullWindwo(tabId){
	var tableObj=document.getElementById(tabId+"_allTable");

	tableObj.width = document.body.clientWidth;
	tableObj.height = window.document.body.clientHeight;
	//tableObj.border=1;

	var mainTable=document.getElementById(tabId+"_mainTable");

	mainTable.width = document.body.clientWidth;
	mainTable.height = window.document.body.clientHeight-30;
}

//�������������б�ʱ���ã�ˢ�µײ����ڣ��������ڽ��������ݵ��ײ�����
function showDataDetail (argument){
	//��ȡ�ײ���ϸҳ�浱ǰ���ڵĵ�tab��
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


//����������ͼ��ʱ���ã�ˢ�µײ����ڣ��������ڽ��������ݵ��ײ�����
function showDataDetailForChart (argument ,type){
	//����type��ȡJSP����Ŀ¼
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

//���ݽڵ����ͣ���ȡJSP���ڵ�Ŀ¼
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



//�ײ�������ϸ��Ϣ�޸ĺ�ˢ�¶����Ĵ������ݵĴ��������÷����ȴ�������ע��
function refreshTopByDetailChange_Proxy(){}

//���ײ㴰�ڵ��ã��ͻ��˴�����ϸ��Ϣ�޸ĺ�ˢ�¶�������
function refreshTopByDetailChange(){
	if(typeof(getTopWindow().refreshTopByDetailChange_Proxy) !='undefined'){
		getTopWindow().refreshTopByDetailChange_Proxy();
	}
}

//�÷��������㴰�ڵ��ã�ʵ�ֵ��ײ���ϸ��Ϣ�޸ĺ󣬶��㴰����Ҫ���Ĳ���
function registerEventWhenDetailChange(func){
	//if(typeof(getTopWindow().refreshTopByDetailChange_Proxy) !='undefined'){
		getTopWindow().refreshTopByDetailChange_Proxy = func;
	//}
}



//�ײ�����������Ϣ�޸ĺ�ˢ�¶����Ĵ������ݵĴ��������÷����ȴ�������ע��
function refreshTopByQuoteChange_Proxy(){}

//���ײ㴰�ڵ��ã��ͻ��˴���������Ϣ�޸ĺ�ˢ�¶�������
function refreshTopByQuoteChange(){ 
	if(typeof(getTopWindow().refreshTopByQuoteChange_Proxy) !='undefined'){
		getTopWindow().refreshTopByQuoteChange_Proxy();
	}
}

//�÷��������㴰�ڵ��ã�ʵ�ֵ��ײ�������Ϣ�޸ĺ󣬶��㴰����Ҫ���Ĳ���
function registerEventWhenQuoteChange(func){
	//if(typeof(getTopWindow().refreshTopByDetailChange_Proxy) !='undefined'){
		getTopWindow().refreshTopByQuoteChange_Proxy = func;
	//}
}

//��ȡ��������
function getTopWindow(){
	var topFrame = window.parent;
	while(topFrame.parent != topFrame){
		topFrame = topFrame.parent;
	}
	return topFrame;
}

//��ȡindex_bottom.jspҳ�浱ǰѡ�е�tab_id
function getIndexBottomSelectedTabName(tab_id){
	//��ȡѡ��TABITEM����Ӱ
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

//���¼���ͼƬ
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

//��ȡ��ǰϵͳ��ģ��ID
function getCurrentModuleId(){
	if(typeof(getTopWindow().module_id)!='undefined'){
		return getTopWindow().module_id
	}
	return "";
}

var searchTxt = "�������ѯ��������������ÿո�ֿ�";
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

//���������ı����
function setSearchText(id){
	var obj = document.getElementById(id);
	if(obj == null )return;
	
	obj.value=searchTxt;
	obj.style.color='#888'
	obj.onfocus=searchTextFocus;
	obj.onblur=searchTextBlur;
}

//��ȡ�����ı���ֵ
function getValueFromSearchText(id){
	
	var obj = document.getElementById(id);
	if(obj == null )return '';
	
	if(obj.value ==searchTxt)return '';
	
	return obj.value;
}