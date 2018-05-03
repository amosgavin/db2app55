/**
* AiTabPage前台模块
* 功能：实现TAB的显示、增、删、刷新等方法。
* 作者：张联华 亚信集团股份有限公司 南京研发中心J2EE Platform部
* 时间：2006.2.14
* 对外提供的函数：
* 1.	getCurrentTabFocusItem(aTabId) 			取当前聚焦的TABItem的索引号,没有聚焦返回-1
* 2.	getTabItemIdxsByTabItemId(aTabId,aItemId)	根据aItemId获得该aItemId对应的TAB index的数组
* 3.	setTabItem(aTabId,aItemId)			根据TAB编号和TABITEM编号设置Tab当前页
* 4.	setTabItemByItemIdx(aTabId,aIdx)		根据TAB编号和TABITEM索引设置Tab当前页
* 5.	refreshTabItem(aTabId,aTabItemId,aTitle,aUrl,isFocus)	根据TabItem的名称刷新
* 6.	refreshTabItemByIdx(aTabId,aIdx,aTitle,aUrl,isFocus)	根据TabItem的索引号刷新
* 7.	openNewTabItem(aTabId,aTabItemId,aTitle,aUrl,aIsDeletable,aIdx)	新增Tab页
* 8.	closeTabItem(aTabId,aTabItemId)			根据ItemId编号删除TAB页
* 9.	closeTabItemByIdx(aTabId,aIdx)			根据Item索引号删除TAB页
* 10.	setTabItemDeletable(aTabId,aItemId,aEditable)	根据Item名称设置对应Item的是否可删除属性
* 11.	setTabItemDeletableByIdx(aTabId,aIdx,aEditable)	根据Item索引设置对应Item的是否可删除属性
* 12.	getTabItemDeletable(aTabId,aItemId)		根据Item名称取对应Item的是否可删除属性
* 13.	getTabItemDeletableByIdx(aTabId,aIdx)		根据Item索引号取对应Item的是否可删除属性
* 14.	getTabType(aTabId)				根据TAB编号取TA类型
* 15.	setTabItemLen(aTabId,aTabItemId,aTabItemLen)	设置TabItem的宽度
*
*		================add by hexg 2006-6-28
* 16.	setTabItemTitle(aTabId,aItemId,title)	根据TAB编号和TABITEM编号设置Tab页的title
* 17.	getTabItemTitle(aTabId,aItemId)	根据TAB编号和TABITEM编号获取Tab页的title
* 18.   tabResizeTo(aTabId,width,height);
* 19.   setTabHeadScrollChangeValue(aTabId ,scrollChangeValue)
* 20.	getTabItemCount(aTabId)				获取打开tab页的数量
* 21.	isTabItemExist(aTabId,aItemId)		判断tab标签是否存在
* */

var TAB_TYPE_H="H";
var TAB_TYPE_V="V";
var TAB_TYPE_VV="VV";
var TAB_TYPE_B="B";

/**
 * tabItem的个数
 * @param aTabId
 * @return
 */
function getTabItemCount(aTabId){
	var aTitleTable=document.getElementById(aTabId+"_secTable");
	var aTitleChild=aTitleTable.children;
	var count=0;
	if (aTitleChild!="undefined" && aTitleChild!=null){
		count=aTitleChild.length;
	}
	return count;
}

/**
 * 判断aItemId的tab页是否已经存在
 * @param aTabId
 * @param aItemId
 * @return
 */
function isTabItemExist(aTabId,aItemId){
  var aAry=getTabItemIdxsByTabItemId(aTabId,aItemId);
  if (aAry.length>0){
    return true;
  }
  return false;
}

//取当前聚焦的TABItem
//没有聚焦返回-1
function getCurrentTabFocusItem(aTabId){
  if(! document.getElementById(aTabId))
    return -1;
  var tmpFocusIdx = document.getElementById(aTabId).currentTabFocusIdx;
  if(tmpFocusIdx == null)
  {
	tmpFocusIdx = 0;
	document.getElementById(aTabId).currentTabFocusIdx = tmpFocusIdx;
  }

  tmpFocusIdx = parseInt(tmpFocusIdx);
  return tmpFocusIdx;
}

function setCurrentTabFocusItem(aTabId,aFocusIdx){
    document.getElementById(aTabId).currentTabFocusIdx = aFocusIdx;
}

/**
* 根据aItemId获得该aItemId对应的TAB index的数组
* aTabId TAB编号
* aItemId TABITEM编号
* */
function getTabItemIdxsByTabItemId(aTabId,aItemId){
  var aIdxAry=new Array();
  var aMainObjId=aTabId+"_mainTable";
  var aMainObj=document.getElementById(aMainObjId);

  if(aMainObj!=null){
	  for (var i=0;i<aMainObj.rows[0].cells.length;i++){
	    if (aMainObj.rows[0].cells[i].id==aTabId+"_TableBody_"+aItemId){
	      aIdxAry[aIdxAry.length]=i;
	    }
	  }
  }
  return aIdxAry;
}

/**
  根据TAB编号和TABITEM编号设置Tab当前页
  aTabId：TAB编号
  aItemId:TABITEM编号
*/
function setTabItem(aTabId,aItemId){
  var aItemTitleObj=document.getElementById(aTabId +"_Title_"+ aItemId);
  var aItemBodyObj=document.getElementById(aTabId +"_TableBody_"+ aItemId);
  var aFrameObj=document.getElementById(aTabId + "_" + aItemId);

  if(aItemBodyObj==null){
  	alert(g_I18NMessage("appframe_core","tab_no_item"));
  	return false;
  }

  var ret=setTabItem_common(aTabId,aItemTitleObj,aItemBodyObj,aFrameObj);
  if (ret==false){
    return;
  }
  //根据aItemId获得该aItemId对应的TAB index的数组
  //记录当前焦点TAB的index
  var aAry=getTabItemIdxsByTabItemId(aTabId,aItemId);
  if (aAry.length>=0){
    setCurrentTabFocusItem(aTabId,aAry[0]);
  }
}


/**
*  点击TABItem时，根据TAB编号和当前点击的对象设置Tab当前页
*  内部方法，不对外提供！
*  aTabId：TAB编号
*  aClickedTdObj:当前点击的对象
*  在tab_h.vm和tab_v.vm中和新增Tab时引用了该方法，点击Tab页时调用
*/
function setClickedTabItem(aTabId,aClickedTdObj){
 //查询该对象的index
  var aIdx;
  var aTitleTable=document.getElementById(aTabId+"_secTable");

  var aTitleChild=aTitleTable.children;
  for (var i=0;i<aTitleChild.length;i++){
    if (aTitleChild[i].rows[0].cells[0].uniqueID==aClickedTdObj.uniqueID){
      aIdx=i;
      break;
    }
  }

  var ret=setTabItemByItemIdx(aTabId,aIdx);
  if (ret==false){
    return;
  }
}

/**
*  根据TAB编号和TABITEM索引设置Tab当前页
*  tabId：
*  aIdx:
*/
function setTabItemByItemIdx(aTabId,aIdx){
  if (aIdx==null||aIdx=="undefined"||aIdx<0){
    alert(g_I18NMessage("appframe_core","tab_item_index"));
    return;
  }
  var aItemTitleObj;
  var aItemBodyObj;
  var aFrameObj;
  var aTitleTable=document.getElementById(aTabId+"_secTable");
  if(aTitleTable.children.length-1<aIdx){
    alert(g_I18NMessage("appframe_core","tab_no_index"));
	  return false;
	}
  aItemTitleObj=aTitleTable.children[aIdx];

  var aMainObjId=aTabId+"_mainTable";
  var aMainObj=document.getElementById(aMainObjId);
  aItemBodyObj=aMainObj.rows[0].cells[aIdx];

  aFrameObj=aItemBodyObj.firstChild;
  //d1,d1_Title__dd4,d1_TableBody_dd4,d1_dd4
  var ret=setTabItem_common(aTabId,aItemTitleObj,aItemBodyObj,aFrameObj);
  if (ret==false){
    return;
  }
  //记录当前焦点TAB的index
  setCurrentTabFocusItem(aTabId,aIdx);
}

/**
* 内部方法，前两个设置Tab聚焦方法使用，不对外提供。
*  设置Tab当前页
*  tabId：TAB编号
*  aItemTitleObj: 标题所在的td对象
*  aItemBodyObj:  正文对象
*  aFrameObj：    iframe对象
*/
function setTabItem_common(tabId,aItemTitleObj,aItemBodyObj,aFrameObj,aItemFocusObj){
  var aItemTitleObjTD = aItemTitleObj.rows[0].cells[0];
  var tmpFocusIdx = getCurrentTabFocusItem(tabId);
  var headTable = document.getElementById(tabId + "_secTable");
  //beforeSetTab
  //SetTabItem之前的回调函数 dd
  var beforeSetTab= headTable.beforeSetTab;
  var afterSetTab= headTable.afterSetTab;
  var aOldItemTitle=null;
  var aOldItemTitleObjId=null;
  var aTitleTable=document.getElementById(tabId+"_secTable");
  if (tmpFocusIdx !=null && tmpFocusIdx >= 0){
    if (tmpFocusIdx>=aTitleTable.children.length){
      tmpFocusIdx=aTitleTable.children.length-1;
    }
    aOldItemTitleObjId=aTitleTable.children[tmpFocusIdx].rows[0].cells[0].id;
    aOldItemTitle=aOldItemTitleObjId.split("_Title_")[1];
  }

  var aNewItemTitleObjId=aItemTitleObj.id;
  var aNewItemTitle=aNewItemTitleObjId.split("_Title_")[1];
  if (beforeSetTab&&beforeSetTab!=""){
    try{
      var ret=eval(beforeSetTab+"('"+aOldItemTitle+"','"+aNewItemTitle+"')");
      if (ret==false){
        return false;
      }
    }catch(ex){
      alert(g_I18NMessage("appframe_core","tab_settab_err",new Array(ex.message)));
      return false;
    }
  }
  var mainTable = document.getElementById(tabId + "_mainTable");
  var aTagObj=document.getElementById(tabId);
  var tagType = getTabType(tabId);
  aTagType = tagType.toLowerCase();
  var aFocusClass="tab_"+aTagType+"_focus";
  var aNotFocusClass="tab_"+aTagType+"_not_focus";
  var aTitleClass = "tab_"+aTagType+"_title_style";
  var aTitleCurrentClass = "tab_"+aTagType+"_title_style_current";
  var aCloseBtnClass = "tab_item_close_button";
  var aCloseBtnCurrentClass = "tab_item_close_button_current";
    
    //将之前选中的tab变为普通样式
    for(i=0;i<headTable.children.length;i++){
     	if(headTable.children[i].rows[0].cells[0].firstChild.className != aTitleClass)
     	  headTable.children[i].rows[0].cells[0].firstChild.className = aTitleClass;
     	if(tagType == TAB_TYPE_H || tagType == TAB_TYPE_B){
	     	if (headTable.children[i].rows[0].cells[0].firstChild.firstChild.firstChild.rows[0].cells[1].firstChild != null){
	     		headTable.children[i].rows[0].cells[0].firstChild.firstChild.firstChild.rows[0].cells[1].firstChild.className=aCloseBtnClass;
	     	}
     	}
     	else if(tagType == TAB_TYPE_VV){
     	  if (headTable.children[i].rows[0].cells[0].firstChild.firstChild.firstChild.rows[1].cells[0].firstChild != null){
	     		headTable.children[i].rows[0].cells[0].firstChild.firstChild.firstChild.rows[1].cells[0].firstChild.className=aCloseBtnClass;
	     	}
     	}
     	else{
     	  if (headTable.children[i].rows[0].cells[0].firstChild.firstChild.firstChild.rows[0].cells[1].firstChild != null){
	     		headTable.children[i].rows[0].cells[0].firstChild.firstChild.firstChild.rows[0].cells[1].firstChild.className=aCloseBtnClass;
	     	}
     	}
	  }
	  //设置其它iframe不可见
	  for(i=0;i<mainTable.rows[0].cells.length;i++)
	      mainTable.rows[0].cells[i].style.display="none";
	      
    //设置当前选中tab的样式
	  aItemTitleObjTD.firstChild.className = aTitleCurrentClass; 
	  if(tagType == TAB_TYPE_H || tagType == TAB_TYPE_B){ 
		  var temp=aItemTitleObjTD.firstChild.firstChild.firstChild.rows[0].cells[1].firstChild;
		  if (temp != null){
		  	temp.className=aCloseBtnCurrentClass;
		  }
	  }
	  else if(tagType == TAB_TYPE_VV){
	    var temp=aItemTitleObjTD.firstChild.firstChild.firstChild.rows[1].cells[0].firstChild;
		  if (temp != null){
		  	temp.className=aCloseBtnCurrentClass;
		  }
	  }
	  else{
	    var temp=aItemTitleObjTD.firstChild.firstChild.firstChild.rows[0].cells[1].firstChild;
		  if (temp != null){
		  	temp.className=aCloseBtnCurrentClass;
		  }
	  }
	  aItemBodyObj.style.display="block";

  var src = aFrameObj.destsrc;
  var divobj = document.getElementById(tabId);
  var getparameterfunction = divobj.getparameterfunction;
  if(getparameterfunction&&(getparameterfunction!="")){
    //取得itemId
    var itemId=aItemTitleObj.id.split("_Title_")[1];
     var p = "";
     try{
       eval("p=" + getparameterfunction +"('" + itemId + "');");
     }catch(ex){
       alert(g_I18NMessage("appframe_core","tab_no_func",new Array(getparameterfunction))+"--"+ex.description);
       return;
     }
     if(p){
	     if(src.indexOf("?") > 0 ){
		src = src + "&" + p;
	     }else{
                src = src + "?" + p;
	     }
     }

  }
  //如果url不同就刷新。包括传入参数不同，才刷新。
  if(aFrameObj.src != src ){
      aFrameObj.src = src;
  }
  //SetTabItem之后的回调函数
  if (afterSetTab&&afterSetTab!=""){
    try{
     eval(afterSetTab+"('"+aOldItemTitle+"','"+aNewItemTitle+"')");
    }catch(ex){
      alert(g_I18NMessage("appframe_core","tab_settab_after_err",new Array(ex.message)));
      return;
    }
  }
}

/**
* 根据TabItem的名称刷新
* aTabId Tab名称
* aTabItemId   TabItem的名称
* aTitle 标题，不需要改变标题时传入null
* aUrl   Url，不需要改变Url时传入null
* isFocus 是否设置焦点，设置焦点为true或不传，不需要设置为false
* */
function refreshTabItem(aTabId,aTabItemId,aTitle,aUrl,isFocus){
	
  var aAry=getTabItemIdxsByTabItemId(aTabId,aTabItemId);
  for (var i=0;i<aAry.length;i++){
    refreshTabItemByIdx(aTabId,aAry[i],aTitle,aUrl,isFocus);
  }
}

/**
* 根据TabItem的索引号刷新
* aTabId Tab名称
* aIdx   TabItem的索引号
* aTitle 标题，不需要改变标题时传入null
* aUrl   Url，不需要改变Url时传入null
* isFocus 是否设置焦点，设置焦点为true或不传，不需要设置为false
* */
function refreshTabItemByIdx(aTabId,aIdx,aTitle,aUrl,isFocus){
  if (aIdx==null||aIdx=="undefined"||aIdx==undefined||aIdx<0){
    alert(g_I18NMessage("appframe_core","tab_item_index"));
    return;
  }
  if(isFocus!=null && isFocus==false){

  } else{
	  isFocus=true;
  }

  //如果标题和当前标题不同，则刷新标题
  //取标题对象和标题
  if (aTitle != null){
    var aHeadTable=document.getElementById(aTabId+"_secTable");
    if(aHeadTable.children.length <= aIdx){
      alert(g_I18NMessage("appframe_core","tab_no_obj"));
      return;
    }
    
    var aHeadTblObj = aHeadTable.children[aIdx];
    aHeadTblObj.itemTitle = aTitle;
    aHeadTblObj.rows[0].cells[0].firstChild.firstChild.firstChild.rows[0].cells[0].innerText=aTitle;  
  }
  //如果url不同，则刷新url
  //取正文对象和url
  if (aUrl){
    var aMainObjId=aTabId+"_mainTable";
    var aMainObj=document.getElementById(aMainObjId);
    aItemBodyObj=aMainObj.rows[0].cells[aIdx];
    if (typeof(aItemBodyObj) == "undefined"){
      alert(g_I18NMessage("appframe_core","tab_no_obj"));
      return;
    }
    aFrameObj=aItemBodyObj.firstChild;
    aFrameObj.destsrc=aUrl;
    aFrameObj.src = aUrl;
  }
  if(isFocus){
    setTabItemByItemIdx(aTabId,aIdx);
    updateScrollBarStatus(aTabId);
  }
}

/**
* 新增Tab页
* aTabId TAB编号
* aTabItemId TabItem编号
* aTitle 标题
* aUrl   URL
* aIsDeletable 是否可被删除
* aIdx    插入在该索引号的TAB页之前。
* */
function openNewTabItem(aTabId,aTabItemId,aTitle,aUrl,aIsDeletable,aIdx){
  //增加标题和关闭图片按钮及对应的关闭事件
  //读入文件，如果是横向，则从AddTabHeader_H.vm中读取
  //查询要插入的目标对象
  var aNewItemHeadObj;
  //取aTabType
  var aTagType=getTabType(aTabId);
  var aNewIdx=0;
  var aTotalNo=0;
  var aHeadTable=document.getElementById(aTabId+"_secTable");

  if (aTagType.toUpperCase()==TAB_TYPE_H || aTagType.toUpperCase()==TAB_TYPE_B){
    aNewItemHeadObj=getNewHItemHead(aTabId,aTabItemId,aTitle,aIsDeletable,aTagType.toLowerCase());
  }else if (aTagType.toUpperCase()==TAB_TYPE_VV){
    aNewItemHeadObj=getNewVVItemHead(aTabId,aTabItemId,aTitle,aIsDeletable);
  }
  else{
    aNewItemHeadObj=getNewVItemHead(aTabId,aTabItemId,aTitle,aIsDeletable);
  }
  aTotalNo=aHeadTable.children.length;
  //如果作为最后一个，则直接追加在最后一个对象之后。
  if (aIdx==null||aIdx=="undefined"||aIdx>=aTotalNo){
    aNewIdx=aTotalNo;
    aHeadTable.appendChild(aNewItemHeadObj);
  }else{
    //否则插在目标对象之前。
    var aAfterObj=aHeadTable.children[aIdx];
    aHeadTable.insertBefore(aNewItemHeadObj,aAfterObj);
    aNewIdx=aIdx;
  }

  //增加TAB正文内容
  var aMainObjId=aTabId+"_mainTable";
  var aMainObj=document.getElementById(aMainObjId);
  //根据aTabId取正文内容的高度！
  var aHeight=aMainObj.rows[0].cells[0].height;
  var aNewMainObj=getNewItemMain(aTabId,aTabItemId,aUrl,aHeight);
  //如果作为最后一个，则直接追加在最后一个对象之后。
  if (aIdx==null||aIdx=="undefined"||aIdx>=aTotalNo){
    aNewIdx=aTotalNo;
    aMainObj.rows[0].appendChild(aNewMainObj);
  }else{
    //否则插在目标对象之前。
    var aAfterObj=aMainObj.rows[0].cells[aIdx];
    aMainObj.rows[0].insertBefore(aNewMainObj,aAfterObj);
    aNewIdx=aIdx;
  }
  //调用setTabItem方法将新增的TAB页设为当前页
  setTabItemByItemIdx(aTabId,aNewIdx);
  updateScrollBarStatus(aTabId);
  
}

//取得新增横向TabItem的内容
function getNewHItemHead(aTabId,aTabItemId,aTitle,aIsDeletable,type){
  var aTdStr="<td class=tab_"+type+"_not_focus onclick=\"setClickedTabItem('"+aTabId+"',this)\" ";
  /****/
  aTdStr+="onmouseover=\"setMouseOverTabItem('"+aTabId+"',this,'over')\" ";
  aTdStr+="onmouseout=\"setMouseOverTabItem('"+aTabId+"',this,'out')\" ";
  /****/
  aTdStr+="style=\"white-space: nowrap; word-break: keep-all;\" isDeletable=\""+aIsDeletable+"\"  nowrap>";
  aTdStr+="</td>";
  var aTd=document.createElement(aTdStr);
  var aSpanStr = "<div id='item_title' nowrap align=center class='tab_"+type+"_title_style'><span><table border=\"0\" cellspacing=0 cellpadding=0><tr><td width=\"100%\" class=\"tab_"+type+"_title_font_style\" nowrap>"+aTitle+"</td>";
	aSpanStr+="<td>";
	if (aIsDeletable=="true"){
	    aSpanStr+="<div id=\"tab_item_close_button\" class=\"tab_item_close_button\" onclick=\"closeClickedTabItem('"+aTabId+"',this);\" "
	   	 		/****/
	    		+"onmouseover=\"setMouseOverCloseTabItem('"+aTabId+"',this,'_Title_"+aTabItemId+"','over')\" "
	    		+"onmouseout=\"setMouseOverCloseTabItem('"+aTabId+"',this,'_Title_"+aTabItemId+"','out')\" "
	    		/****/
	    		+"></div> ";
	}
  	aSpanStr+="</td></tr></table></span></div>";
  aTd.innerHTML=aSpanStr;
  var aTabStr = "<table id =\""+aTabId+"_Title_"+aTabItemId+"\" itemTitle=\""+aTitle+"\" style=\"height:24px;display:inline;\" border=0 cellspacing=0 cellpadding=0></table>";
  var aTab = document.createElement(aTabStr);
  aTab.insertRow().appendChild(aTd);
  return aTab;
}

//取得新增纵向TabItem的内容
function getNewVVItemHead(aTabId,aTabItemId,aTitle,aIsDeletable){
  var aTdStr="<td class=tab_vv_not_focus onclick=\"setClickedTabItem('"+aTabId+"',this)\" ";
  /****/
  aTdStr+="onmouseover=\"setMouseOverTabItem('"+aTabId+"',this,'over')\" ";
  aTdStr+="onmouseout=\"setMouseOverTabItem('"+aTabId+"',this,'out')\" ";
  /****/
  aTdStr+=" isDeletable=\""+aIsDeletable+"\">";
  aTdStr+="</td>";
  var aTd=document.createElement(aTdStr);
  var aSpanStr = "<div id='item_title' nowrap align=center class='tab_vv_title_style'><span><table border=\"0\" cellspacing=0 cellpadding=0><tr><td width=\"100%\" class=\"tab_vv_title_font_style\">"+aTitle+"</td></tr>";
	aSpanStr+="<tr><td>";
	if (aIsDeletable=="true"){
	    aSpanStr+="<div id=\"tab_item_close_button\" class=\"tab_item_close_button\" onclick=\"closeClickedTabItem('"+aTabId+"',this);\" "
	   	 		/****/
	    		+"onmouseover=\"setMouseOverCloseTabItem('"+aTabId+"',this,'_Title_"+aTabItemId+"','over')\" "
	    		+"onmouseout=\"setMouseOverCloseTabItem('"+aTabId+"',this,'_Title_"+aTabItemId+"','out')\" "
	    		/****/
	    		+"></div> ";
	}
  	aSpanStr+="</td></tr></table></span></div>";
  aTd.innerHTML=aSpanStr;
  var aTabStr = "<table id =\""+aTabId+"_Title_"+aTabItemId+"\" itemTitle=\""+aTitle+"\" border=0 cellspacing=0 cellpadding=0></table>";
  var aTab = document.createElement(aTabStr);
  aTab.insertRow().appendChild(aTd);
  return aTab;
}

//取得新增纵向TabItem的内容，标题横向显示
function getNewVItemHead(aTabId,aTabItemId,aTitle,aIsDeletable){
  var aTdStr="<td class=tab_v_not_focus onclick=\"setClickedTabItem('"+aTabId+"',this)\" ";
  /****/
  aTdStr+="onmouseover=\"setMouseOverTabItem('"+aTabId+"',this,'over')\" ";
  aTdStr+="onmouseout=\"setMouseOverTabItem('"+aTabId+"',this,'out')\" ";
  /****/
  aTdStr+=" isDeletable=\""+aIsDeletable+"\">";
  aTdStr+="</td>";
  var aTd=document.createElement(aTdStr);
  var aSpanStr = "<div id='item_title' nowrap class='tab_v_title_style'><span><table border=\"0\" cellspacing=0 cellpadding=0 style=\"width:100%\"><tr><td width=\"100%\" class=\"tab_v_title_font_style\">"+aTitle;
	aSpanStr+="</td><td>";
	if (aIsDeletable=="true"){
	    aSpanStr+="<div id=\"tab_item_close_button\" class=\"tab_item_close_button\" onclick=\"closeClickedTabItem('"+aTabId+"',this);\" "
	   	 		/****/
	    		+"onmouseover=\"setMouseOverCloseTabItem('"+aTabId+"',this,'_Title_"+aTabItemId+"','over')\" "
	    		+"onmouseout=\"setMouseOverCloseTabItem('"+aTabId+"',this,'_Title_"+aTabItemId+"','out')\" "
	    		/****/
	    		+"></div> ";
	}
  	aSpanStr+="</td></tr></table></span></div>";
  aTd.innerHTML=aSpanStr;
  var aTabStr = "<table id =\""+aTabId+"_Title_"+aTabItemId+"\" itemTitle=\""+aTitle+"\" border=0 cellspacing=0 cellpadding=0 width=\"100%\"></table>";
  var aTab = document.createElement(aTabStr);
  aTab.insertRow().appendChild(aTd);
  return aTab;
}

/*新增横向TabItem、纵向TabItem的正文内容
* 内部方法，不对外提供！
* */
function getNewItemMain(aTabId,aTabItemId,aUrl,aHeight){
  var aTdCont="<td id=\""+aTabId+"_TableBody_"+aTabItemId+"\" align=center valign=top ></td>";
  var aNewCell=document.createElement(aTdCont);
  aNewCell.innerHTML="<iframe id=\""+aTabId+"_"+aTabItemId+"\" destsrc=\""+aUrl+"\" width=\"100%\" height=\"100%\" frameborder=0> </iframe>";
  return aNewCell;
}

/**根据ItemId编号删除TAB页
* aTabId TAB编号
* aTabItemId ItemId编号
* */
function closeTabItem(aTabId,aTabItemId){
  //根据aTabItemId取得索引
  var aAry=getTabItemIdxsByTabItemId(aTabId,aTabItemId);
  if (aAry!=null&&aAry.length>0){
    for (var i=0;i<aAry.length;i++){
      //根据Item索引号删除
      closeTabItemByIdx(aTabId,aAry[i])
    }
  }else{
    alert(g_I18NMessage("appframe_core","tab_no_tab",new Array(aTabId+"_"+aTabItemId)));
    return "false";
  }
}

/**根据Item索引号删除
* aTabId TAB编号
* aIdx Item索引号
* */
function closeTabItemByIdx(aTabId,aIdx){
  if (aIdx==null||aIdx=="undefined"||aIdx<0){
    alert(g_I18NMessage("appframe_core","tab_item_index"));
    return;
  }

  //取当前状态，判断是否可删除
  var aCurState=getTabItemDeletableByIdx(aTabId,aIdx);

  if (aCurState==false || aCurState=="false"){
    alert(g_I18NMessage("appframe_core","tab_undeletable"));
    return false;
  }

  //根据Item索引号取得aCloseSpanObj对象
  var aTagObj=document.getElementById(aTabId);
  var aTitleTable=document.getElementById(aTabId+"_secTable");
  var aCloseSpanObj = aTitleTable.children[aIdx].rows[0].cells[0].firstChild.firstChild.firstChild.rows[0].cells[1].firstChild;
  closeClickedTabItem(aTabId,aCloseSpanObj);
}

/**点击关闭按钮时删除一个TAB页
* 内部方法，不对外提供！
* 在tab_h.vm和tab_v.vm中和新增Tab时引用了该方法，点击关闭按钮时调用
* aTabId TAB编号
* aCloseSpanObj 关闭按钮对象
* */
function closeClickedTabItem(aTabId,aCloseSpanObj){
  if (!aTabId){
    alert(g_I18NMessage("appframe_core","tab_no_tabid"));
    return;
  }
  //正文内容
  //如果只有最后一个，则不能删除！
  var aMainObjId=aTabId+"_mainTable";
  var aMainObj=document.getElementById(aMainObjId);
  if (aMainObj.rows[0].cells.length==1){
    alert(g_I18NMessage("appframe_core","tab_cannot_del"));
    return;
  }
  var aTagObj=document.getElementById(aTabId);
  var aItemHeadObj;
  var aIdx=-1;
  //查询该对象的index
  var aTitleTable=document.getElementById(aTabId+"_secTable");
  aItemHeadObj = aCloseSpanObj.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
   	
  var aTitleChild=aTitleTable.children;
  for (var i=0;i<aTitleChild.length;i++){
    if (aTitleChild[i].rows[0].cells[0].uniqueID==aItemHeadObj.uniqueID){
      aIdx=i;
      break;
    }
  }
  //删除标题和关闭图片按钮栏。
  aItemHeadObj.innerHTML="";
  var aItemTable = aItemHeadObj.parentNode.parentNode.parentNode;
  removeChild(aItemTable);
  aTitleTable.removeChild(aItemTable);

  //删除TAB正文内容
  aItemBodyObj=aMainObj.rows[0].cells[aIdx];
  if (aItemBodyObj){
	var iframeObj = aItemBodyObj.firstChild;
	if(iframeObj.tagName == 'IFRAME'){ 
	  try{
			var doc = iframeObj.contentDocument;
			if (doc == undefined || doc == null){
			   doc = iframeObj.contentWindow.document;
			}	
			doc.write('');        
			doc.clear(); 
		}
		catch(e){}
		iframeObj.contentWindow.location.replace("about:blank");
	}
	
    aItemBodyObj.removeNode(true);
  }

  //如果删除的TAB页是当前焦点TAB页，则
  //设置删除TAB页的前一个TAB页为当前焦点TAB页
  //如果删除的TAB页在当前焦点TAB页的上面，则当前当前焦点TAB页currentTabFocusIdx需要减1
  var tmpFocusIdx = getCurrentTabFocusItem(aTabId);
  if (aIdx<tmpFocusIdx){
    tmpFocusIdx = tmpFocusIdx -1;
    setCurrentTabFocusItem(aTabId,tmpFocusIdx);
  }
  var aFocusIdx;
  if (aIdx==tmpFocusIdx){
    aFocusIdx=aIdx-1;
    if (aFocusIdx<=0){
      aFocusIdx=0;
    }
    setTabItemByItemIdx(aTabId,aFocusIdx);
  }
  else{
    if (aIdx==0){
      aFocusIdx=0;
      setTabItemByItemIdx(aTabId,aFocusIdx);
    }
  }
  updateScrollBarStatus(aTabId)
}

/**根据Item名称设置对应Item的是否可删除属性
* aTabId TAB编号
* aItemId TabItem编号
* aEditable 是否可删除
* */
function setTabItemDeletable(aTabId,aItemId,aEditable){
  if (aEditable!="true"&&aEditable!="false"){
    alert("aEditable "+g_I18NMessage("appframe_core","tab_edit_param")+"true/false");
    return "false";
  }
  if((aTabId==null||aTabId==undefined||aTabId=="undefined")
  ||(aItemId==null||aItemId==undefined||aItemId=="undefined")){
    alert(g_I18NMessage("appframe_core","tab_tab_item"));
    return "false";
  }
  if (aTabId==null||aTabId==undefined||aTabId=="undefined"){
    alert(g_I18NMessage("appframe_core","tab_tabid"));
    return "false";
  }
  if (aItemId==null||aItemId==undefined||aItemId=="undefined"){
    alert(g_I18NMessage("appframe_core","tab_tabitemid"));
    return "false";
  }
  var aAry=getTabItemIdxsByTabItemId(aTabId,aItemId);
  if (aAry!=null&&aAry.length>0){
    for (var i=0;i<aAry.length;i++){
      setTabItemDeletableByIdx(aTabId,aAry[i],aEditable);
    }
  }else{
    alert(g_I18NMessage("appframe_core","tab_no_tab",new Array(aTabId+"_"+aItemId)));
    return "false";
  }

}

/**根据Item索引设置对应Item的是否可删除属性
* aTabId TAB编号
* aIdx TabItem的索引号
* aEditable 是否可删除
* */
function setTabItemDeletableByIdx(aTabId,aIdx,aEditable){
  if (aEditable!="true"&&aEditable!="false"){
    alert("aEditable "+g_I18NMessage("appframe_core","tab_edit_param")+"true/false");
    return "false";
  }
  if((aTabId==null||aTabId==undefined||aTabId=="undefined")
  ||(aIdx==null||aIdx==undefined||aIdx=="undefined")){
    alert(g_I18NMessage("appframe_core","tab_tab_item"));
    return "false";
  }

  if (aTabId==null||aTabId==undefined||aTabId=="undefined"){
    alert(g_I18NMessage("appframe_core","tab_tabid"));
    return "false";
  }
  if (aIdx==null||aIdx==undefined||aIdx=="undefined"||aIdx<0){
    alert(g_I18NMessage("appframe_core","tab_item_index"));
    return "false";
  }
  //判断对象的状态是否已经是要设置的状态,或者返回false
  var aCurState=getTabItemDeletableByIdx(aTabId,aIdx);
  if (aEditable==aCurState||aCurState==false){
    return "false";
  }

  var aTitleTable=document.getElementById(aTabId+"_secTable");
  var aTitleObj = aTitleTable.children[aIdx];
  var tmp = aTitleObj.id.substr(aTabId.length);
  //增加或删除图片按钮,并设置对象的值
  var aDivObjHtml = "";
  if(aEditable == "true")
    aDivObjHtml = "<div id=\"tab_item_close_button\" class=\"tab_item_close_button\" onclick=\"closeClickedTabItem('"+aTabId
      +"',this);\" onmouseover=\"setMouseOverCloseTabItem('"+aTabId
      +"',this,'"+tmp+"','over')\" onmouseout=\"setMouseOverCloseTabItem('"+aTabId
      +"',this,'"+tmp+"','out')\"></div>";
  aTitleObj.rows[0].cells[0].isDeletable=aEditable;
  var aTagType=getTabType(aTabId);
  if(aTagType == TAB_TYPE_H || aTagType == TAB_TYPE_B){
    aTitleObj.rows[0].cells[0].firstChild.firstChild.firstChild.rows[0].cells[1].innerHTML=aDivObjHtml;
  }
  else if(aTagType == TAB_TYPE_VV){
    aTitleObj.rows[0].cells[0].firstChild.firstChild.firstChild.rows[1].cells[0].innerHTML=aDivObjHtml;
  }
  else{
    aTitleObj.rows[0].cells[0].firstChild.firstChild.firstChild.rows[0].cells[1].innerHTML=aDivObjHtml;
  }
}

/**根据Item名称取对应Item的是否可删除属性
* aTabId TAB编号
* aItemId TabItem编号
* */
function getTabItemDeletable(aTabId,aItemId){
  if((aTabId==null||aTabId==undefined||aTabId=="undefined")
  ||(aItemId==null||aItemId==undefined||aItemId=="undefined")){
    alert(g_I18NMessage("appframe_core","tab_tab_item"));
    return "false";
  }
  if (aTabId==null||aTabId==undefined||aTabId=="undefined"){
    alert(g_I18NMessage("appframe_core","tab_tabid"));
    return "false";
  }
  if (aItemId==null||aItemId==undefined||aItemId=="undefined"){
    alert(g_I18NMessage("appframe_core","tab_tabitemid"));
    return "false";
  }
  var aAry=getTabItemIdxsByTabItemId(aTabId,aItemId);
  //只取第一个对象的属性
  if (aAry.length>=0){
    return getTabItemDeletableByIdx(aTabId,aAry[0]);
  }else{
    alert("Not Found aItemId！");
    return "false";
  }
}

/**根据Item索引号取对应Item的是否可删除属性
* aTabId TAB编号
* aIdx TabItem索引号
* */
function getTabItemDeletableByIdx(aTabId,aIdx){
  if((aTabId==null||aTabId==undefined||aTabId=="undefined")
  ||(aIdx==null||aIdx==undefined||aIdx=="undefined")){
    alert("aEditable "+g_I18NMessage("appframe_core","tab_check"));
    return false;
  }

  if (aTabId==null||aTabId==undefined||aTabId=="undefined"){
    alert(g_I18NMessage("appframe_core","tab_tabid"));
    return false;
  }
  if (aIdx==null||aIdx==undefined||aIdx=="undefined"||aIdx<0){
    alert(g_I18NMessage("appframe_core","tab_item_index"));
    return false;
  }

  var aTagType=getTabType(aTabId);
  var aItemEditable;
  var aTitleTable=document.getElementById(aTabId+"_secTable");
  if(aIdx > aTitleTable.children.length){
    alert(g_I18NMessage("appframe_core","tab_no_obj"));
    return  false;
  }
  aItemEditable=aTitleTable.children[aIdx].rows[0].cells[0].isDeletable;
  if (aItemEditable==""){
    aItemEditable="false";
  }
  return aItemEditable;
}

/**根据TAB编号取TA类型
* aTabId TAB编号
* 返回：H or V
* */
function getTabType(aTabId){
  var aTagObj=document.getElementById(aTabId);
  return aTagObj.tagType;
}
/**设置TabItem的宽度
*	aTabId	TAB编号
*	aTabItemId  TabItem编号
**/
function setTabItemLen(aTabId,aTabItemId,aTabItemLen){
	var td_obj = document.getElementById(aTabId+"_Title_"+aTabItemId);
	if(td_obj==null||td_obj==undefined){
		alert(g_I18NMessage("appframe_core","tab_no_item"));
		return false;
	}	
	td_obj.rows[0].cells[0].style.width = aTabItemLen;
	td_obj.rows[0].cells[0].firstChild.firstChild.style.width = aTabItemLen;
}

//根据TAB编号和TABITEM编号设置Tab页的title
function setTabItemTitle(aTabId,aItemId,aTitle){
	var aTitleObj=document.getElementById(aTabId +"_Title_"+ aItemId);

	if(aTitleObj==null){
		alert(g_I18NMessage("appframe_core","tab_no_item"));
		return false;
	}
	aTitleObj.itemTitle = aTitle;
	aTitleObj.rows[0].cells[0].firstChild.firstChild.firstChild.rows[0].cells[0].innerText = aTitle;
}
//	根据TAB编号和TABITEM编号获取Tab页的title
function getTabItemTitle(aTabId,aItemId){
	var aTitleObj=document.getElementById(aTabId +"_Title_"+ aItemId);

	if(aTitleObj==null){
		alert(g_I18NMessage("appframe_core","tab_no_item"));
		return false;
	}
	return aTitleObj.rows[0].cells[0].firstChild.firstChild.firstChild.rows[0].cells[0].innerText;
}

function tabResizeTo(aTabId,width,height){
  var tableID= aTabId+"_allTable";
  var tableObj=document.getElementById(tableID);
  var aTagType = getTabType(aTabId);
  if(width){
  	tableObj.width = width;
  }
  if(height){
  	tableObj.height = height;
  }
  updateScrollBarStatus(aTabId)
}

function scrollDivLeft(aTabId){
	var secTable = document.getElementById(aTabId+"_secTable");
	var scrollValue = secTable.scrollChangeValue;
  var titleTables = secTable.children;
  var newIndx = 0;
  var curIndx = getCurrentTabFocusItem(aTabId);
  for(var i=0;i<titleTables.length;i++){
    if(titleTables[i].style.display == "none")
      continue;
    //找到显示的最左边的标签
    if(i == titleTables.length-1){ //本身就在最右边，不能再滚动
      newIndx = i;
      break;
    }
    titleTables[i].style.display = "none";
    if(titleTables[i].scrollWidth >= scrollValue-50){ // 滚动到位
      newIndx = i+1;
      break;
    }
    scrollValue = scrollValue - titleTables[i].scrollWidth;
  }
  if(newIndx == curIndx)
    return;
  if(curIndx != -1 && curIndx < newIndx){ //当前item已经被隐藏，需要重新设置
    setTabItemByItemIdx(aTabId,newIndx);
    titleTables[curIndx].style.display = "none";
  }
  else{
    updateScrollBarStatus(aTabId);
  }
}

function scrollDivRight(aTabId){
	var secTable = document.getElementById(aTabId+"_secTable");
	var scrollValue = secTable.scrollChangeValue;
  var titleTables = secTable.children;
  var newIndx = -1;
  var curIndx = getCurrentTabFocusItem(aTabId);
  var curItem = titleTables[curIndx]; //当前标签
  for(var i=0;i<titleTables.length;i++){
    //找到显示的最左边的标签
    if(titleTables[i].style.display != "none"){
      newIndx = i;
      break;
    }
  }
  for(var i=newIndx-1;i>=0;i--){
    titleTables[i].style.display = "inline";
    if(titleTables[i].scrollWidth >= scrollValue){
      newIndx = i;
      break;
    }
    scrollValue = scrollValue - titleTables[i].scrollWidth;
  }
  if(newIndx == curIndx)
    return;
  if(curItem != null && curItem.offsetLeft >= secTable.clientWidth-60){ //当前item已经被隐藏，需要重新设置
    setTabItemByItemIdx(aTabId,newIndx);
  }
  else{
    updateScrollBarStatus(aTabId);
  }
}

function scrollDivUp(aTabId){
	var secTable = document.getElementById(aTabId+"_secTable");
	var scrollValue = secTable.scrollChangeValue;
  var titleTables = secTable.children;
  var newIndx = 0;
  var curIndx = getCurrentTabFocusItem(aTabId);
  for(var i=0;i<titleTables.length;i++){
    if(titleTables[i].style.display == "none")
      continue;
    //找到显示的最上边的标签
    if(i == titleTables.length-1){ //本身就在最上边，不能再滚动
      newIndx = i;
      break;
    }
    titleTables[i].style.display = "none";
    if(titleTables[i].scrollHeight >= scrollValue-50){ // 滚动到位
      newIndx = i+1;
      break;
    }
    scrollValue = scrollValue - titleTables[i].scrollHeight;
  }
  if(newIndx == curIndx)
    return;
  if(curIndx != -1 && curIndx < newIndx){ //当前item已经被隐藏，需要重新设置
    setTabItemByItemIdx(aTabId,newIndx);
    titleTables[curIndx].style.display = "none";
  }
  else{
    updateScrollBarStatus(aTabId);
  }
}

function scrollDivDown(aTabId){
	var secTable = document.getElementById(aTabId+"_secTable");
	var scrollValue = secTable.scrollChangeValue;
  var titleTables = secTable.children;
  var newIndx = -1;
  var curIndx = getCurrentTabFocusItem(aTabId);
  var curItem = curItem = titleTables[curIndx]; //当前标签
  for(var i=0;i<titleTables.length;i++){
    //找到显示的最上边的标签
    if(titleTables[i].style.display != "none"){
      newIndx = i;
      break;
    }
  }
  for(var i=newIndx-1;i>=0;i--){
    titleTables[i].style.display = "";
    if(titleTables[i].scrollHeight >= scrollValue){
      newIndx = i;
      break;
    }
    scrollValue = scrollValue - titleTables[i].scrollHeight;
  }
  if(newIndx == curIndx)
    return;
  if(curItem != null && curItem.offsetTop >= secTable.clientHeight-60){ //当前item已经被隐藏，需要重新设置
    setTabItemByItemIdx(aTabId,newIndx);
  }
  else{
    updateScrollBarStatus(aTabId);
  }
}

function showAllItems(aTabId){
  var popMenuDiv = document.getElementById(aTabId+"_popDiv");
  if(popMenuDiv){
    popMenuDiv.innerHTML="";
  }
  else{
    popMenuDiv = document.createElement("DIV");
    popMenuDiv.id = aTabId + "_popDiv";
    popMenuDiv.style.position="absolute";
    document.body.appendChild(popMenuDiv);
  }

  var secTable = document.getElementById(aTabId+"_secTable");
  var titleTables = secTable.children;
  var popTitleStr = "<table width=\"60\" style=\"table-layout:fixed;\" class=\"tab_pop_table\">";
  for(var i=0;i<titleTables.length;i++){
    popTitleStr = popTitleStr + "<tr><td id=\""+titleTables[i].id+"\" onclick=\"tabPopClick(this)\" style=\"white-space: nowrap;\" title=\""
                + titleTables[i].itemTitle + "\" class=\"tab_pop_menu\" onMouseOver=\"this.className='tab_pop_menuover';\" onMouseOut=\"this.className='tab_pop_menu';\">"
                + titleTables[i].itemTitle +"</td></tr>";
  }
  popTitleStr = popTitleStr + "</table>";

  popMenuDiv.innerHTML = popTitleStr;
  popMenuDiv.style.posLeft=document.body.scrollLeft+window.event.clientX;
  popMenuDiv.style.posTop=document.body.scrollTop+window.event.clientY;
  if(popMenuDiv.style.posLeft+popMenuDiv.offsetWidth > document.body.scrollLeft+document.body.clientWidth)
    popMenuDiv.style.posLeft=document.body.scrollLeft+document.body.clientWidth-popMenuDiv.offsetWidth;
  if(popMenuDiv.style.posLeft < 0)
    opMenuDiv.style.posLeft=0;
  if(popMenuDiv.style.posTop+popMenuDiv.offsetHeight > document.body.scrollTop+document.body.clientHeight)
    popMenuDiv.style.posTop=document.body.scrollTop+document.body.clientHeight-popMenuDiv.offsetHeight;
  if(popMenuDiv.style.posTop < 0)
    popMenuDiv.style.posTop=0;
  popMenuDiv.style.visibility="visible";
  
}

function tabPopClick(popObj){
  var tmp = popObj.id.split("_Title_");
  setTabItem(tmp[0],tmp[1]);
  
  var popMenuDiv = document.getElementById(tmp[0]+"_popDiv");
  popMenuDiv.style.visibility = "hidden";
  var aTagType=getTabType(tmp[0]);
  //_update(tmp[0],aTagType);
  updateScrollBarStatus(tmp[0]);
}

function _update(aTabId,aTagType){
  var secTable = document.getElementById(aTabId+"_secTable");
  var itemTables = secTable.children;
  var currentIndx = getCurrentTabFocusItem(aTabId);
  if(currentIndx < 0)
    return;
  if(aTagType == TAB_TYPE_H || aTagType == TAB_TYPE_B){
	  if(itemTables[currentIndx].offsetLeft >= secTable.clientWidth-60){
	    for(var i=0;i<currentIndx;i++){
		    itemTables[i].style.display="none";
		  }
		  for(var i=currentIndx;i<itemTables.length;i++){
		    itemTables[i].style.display="inline";
		  }
	  }
	  else if(itemTables[currentIndx].offsetLeft < secTable.offsetLeft || itemTables[currentIndx].style.display=="none"){
	    for(var i=currentIndx;i<itemTables.length;i++){
		    itemTables[i].style.display="inline";
		  }
	  }
  }
  else if(aTagType == TAB_TYPE_VV){
    if(itemTables[currentIndx].offsetTop >= secTable.clientHeight-60){
	    for(var i=0;i<currentIndx;i++){
		    itemTables[i].style.display="none";
		  }
		  for(var i=currentIndx;i<itemTables.length;i++){
		    itemTables[i].style.display="";
		  }
	  }
	  else if(itemTables[currentIndx].offsetTop < secTable.offsetTop || itemTables[currentIndx].style.display=="none"){
	    for(var i=currentIndx;i<itemTables.length;i++){
		    itemTables[i].style.display="";
		  }
	  }
  }
}

//设置操作滚动条的样式,内部方法
function updateScrollBarStatus (aTabId,isResize){
  var aTagType=getTabType(aTabId);
  var secTable = document.getElementById(aTabId+"_secTable");
  var itemTables = secTable.children;
  var td = document.getElementById(aTabId+"_btnTD");
  var btnDisplay = "none";
  if(aTagType == TAB_TYPE_V){
    return;
  }
  if(isResize == null || isResize != true){
    _update(aTabId,aTagType);
  }
  if(aTagType == TAB_TYPE_H || aTagType == TAB_TYPE_B){
	  for(var i=0;i<itemTables.length;i++){
	    if((itemTables[i].offsetLeft + itemTables[i].scrollWidth) >= secTable.clientWidth){
	      btnDisplay = "block";
	      break;
	    }
	    if(itemTables[i].style.display == "none"){
	      btnDisplay = "block";
	      break;
	    }
	  }
  }
  else{
    for(var i=0;i<itemTables.length;i++){
	    if((itemTables[i].offsetTop + itemTables[i].scrollHeight) >= secTable.clientHeight){
	      btnDisplay = "block";
	      break;
	    }
	    if(itemTables[i].style.display == "none"){
	      btnDisplay = "block";
	      break;
	    }
	  }
  }
  td.style.display = btnDisplay;
}

//设置鼠标移入移出标签上的变化
function setMouseOverTabItem(aTabId,aOverTdObj,aType){
  //查询该对象的index
  var aIdx;
  var aTitleTable=document.getElementById(aTabId+"_secTable");
  var aTitleChild=aTitleTable.children;
    for (var i=0;i<aTitleChild.length;i++){
      if (aTitleChild[i].rows[0].cells[0].uniqueID==aOverTdObj.uniqueID){
        aIdx=i;
        break;
      }
    }
  var ret=setOverTabItemByItemIdx(aTabId,aIdx,aType);
  if (ret==false){
    return;
  }
}

/**
* 根据TAB编号和TABITEM索引设置鼠标在组件上的样式
* aTabId
* aIdx
*/
function setOverTabItemByItemIdx(aTabId,aIdx,aType){
  if (aIdx==null||aIdx=="undefined"||aIdx<0){
    alert(g_I18NMessage("appframe_core","tab_item_index"));
    return;
  }
  
  var aTitleTable=document.getElementById(aTabId+"_secTable");
  var aTagType=getTabType(aTabId);
  aTagType = aTagType.toLowerCase();
  var tmpFocusIdx = getCurrentTabFocusItem(aTabId);
  var tabs = aTitleTable.children;
  if(tabs.length-1<aIdx){
  	alert(g_I18NMessage("appframe_core","tab_index_err"));
	  return false;
	}
	if (tmpFocusIdx != aIdx) {
	  if(aType == "over")
	    tabs[aIdx].rows[0].cells[0].firstChild.className = "tab_"+aTagType+"_title_style_hover";
	  else if(aType == "out")
	    tabs[aIdx].rows[0].cells[0].firstChild.className = "tab_"+aTagType+"_title_style";
	}
}

/**
* 鼠标移入移出TAB的关闭图标上的样式变化
*/
function setMouseOverCloseTabItem(aTabId,aCloseSpanObj,aOverTdId,aType) {
  var aTagType=getTabType(aTabId);
  //查询该对象的index
  var aIndx;
  
  var aTitleTable=document.getElementById(aTabId+"_secTable");
  var aOverTdObj=document.getElementById(aTabId+aOverTdId);
  
    var aTitleChild=aTitleTable.children;
    for (var i=0;i<aTitleChild.length;i++){
      if (aTitleChild[i].rows[0].cells[0].uniqueID==aOverTdObj.uniqueID){
        aIndx=i;
        break;
      }
    }
  
  var tmpFocusIdx = getCurrentTabFocusItem(aTabId);

  if (tmpFocusIdx == aIndx) {
    if(aType == "over")
  	  aCloseSpanObj.className="tab_item_close_button_hover";
  	else if(aType == "out")
  	  aCloseSpanObj.className="tab_item_close_button_current";
  }
}


//--------------add---------------
function tab_more_button_mouseover(aType){
  var obj = window.event.srcElement;
  if(obj.tagName!="DIV")return;
  else{
    if(aType != null && aType == "over")
      obj.className="tab_moreButton_hover";
    else
     obj.className="tab_moreButton";
  }
}

function tab_b_more_button_mouseover(aType){
  var obj = window.event.srcElement;
  if(obj.tagName!="DIV")return;
  else{
    if(aType != null && aType == "over")
      obj.className="tab_b_moreButton_hover";
    else
     obj.className="tab_b_moreButton";
  }
}

function tab_vv_more_button_mouseover(aType){
  var obj = window.event.srcElement;
  if(obj.tagName!="DIV")return;
  else{
    if(aType != null && aType == "over")
      obj.className="tab_vv_moreButton_hover";
    else
     obj.className="tab_vv_moreButton";
  }
}

function tab_h_button_mouseover(aDirection,aType){
 var obj = window.event.srcElement;
 if(obj.tagName!="DIV")return;
 
 if(aDirection == "left"){
   if(aType == "over")
     obj.className="tab_h_scrollLeftButton_hover";
   else
     obj.className="tab_h_scrollLeftButton";
 }
 else if(aDirection == "right"){
   if(aType == "over")
     obj.className="tab_h_scrollRightButton_hover";
   else
     obj.className="tab_h_scrollRightButton";
 }
}

function tab_b_button_mouseover(aDirection,aType){
 var obj = window.event.srcElement;
 if(obj.tagName!="DIV")return;
 
 if(aDirection == "left"){
   if(aType == "over")
     obj.className="tab_b_scrollLeftButton_hover";
   else
     obj.className="tab_b_scrollLeftButton";
 }
 else if(aDirection == "right"){
   if(aType == "over")
     obj.className="tab_b_scrollRightButton_hover";
   else
     obj.className="tab_b_scrollRightButton";
 }
}

function tab_vv_button_mouseover(aDirection,aType){
 var obj = window.event.srcElement;
 if(obj.tagName!="DIV")return;
 if(aDirection == "left"){
   if(aType == "over")
     obj.className="tab_vv_scrollLeftButton_hover";
   else
     obj.className="tab_vv_scrollLeftButton";
 }
 else if(aDirection == "right"){
   if(aType == "over")
     obj.className="tab_vv_scrollRightButton_hover";
   else
     obj.className="tab_vv_scrollRightButton";
 }
}

function removeChild(parentNode){
  for(var m=0;m<parentNode.childNodes.length;m++){
	  if(parentNode.childNodes[m].childNodes.length>0){
		  removeChild(parentNode.childNodes[m]);
	  }
	  else{
		  if(parentNode.childNodes[m].innerHTML){
			   parentNode.childNodes[m].innerHTML="";
		  }
		  parentNode.removeChild(parentNode.childNodes[m]);
		  
	  }
  }
}

