 
contextPath = window.location['pathname'].split('/')[1];
Ext.BLANK_IMAGE_URL = '../ext/resources/images/default/s.gif';
var paramMap={}; temp = window.location.search; if(temp.length!=0){ temp = temp.substr(1).split('&'); for (i=0;i<temp.length;++i){f = temp[i].split('=');paramMap[f[0]]=f[1];}}
		
var SIMPLENAME = paramMap.SIMPLENAME || 'MD';
var defaultWidth = 200;
var defaultHeight = 200;
var modelcode = paramMap.MODELCODE||'M009';
var showLevel = paramMap.SHOWLEVEL||'era';
var phyorLogic = paramMap.SHOWTYPE||'phy';//logic,phy
var isWizard = paramMap.ISWIZARD;
var wizardId = paramMap.WIZARDID;
var allTabs={};
var addCount=0;
function loadERModel(modelcode){
 	 var sql="select MODELCODE, OBJNAME, OBJCNNAME, OBJTYPE, REFOBJNAME, REFOBJCNNAME, OBJX, OBJY, OBJH, OBJW  from MD.BUSI_MODELDEF where MODELCODE='"+modelcode+"'";
 	 var ds_tab = Asiainfo.getStore(sql);
 	 var sql="select dataname,colname,colcnname,datatype,length,b.remark,col_seq,b.KEY_SEQ from MD.BUSI_MODELDEF a,md.column b where a.OBJNAME=b.dataname and a.MODELCODE='"+modelcode+"'  and objtype='表'  order by dataname,key_seq,col_seq";
   var ds_col = Asiainfo.getStore(sql);
    
   for(var i=0;i<ds_tab.getCount();i++){
     var tabjson={}; 
     var r=ds_tab.getAt(i);
     if(r.get('OBJTYPE')!='表') continue;
     var width=r.get('OBJW')?r.get('OBJW'):defaultWidth;
     if(width<defaultWidth) width=defaultWidth;
     tabjson.tabname=r.get('OBJNAME');tabjson.cnname=r.get('OBJNAME');tabjson.y=r.get('OBJY');tabjson.x=r.get('OBJX');
     tabjson.width=width;tabjson.height=r.get('OBJH')?r.get('OBJH'):defaultHeight;
     tabjson.fields=[];
     if(!tabjson.tabname) break;
     for(var j=0;j<ds_col.getCount();j++){
     	var fieldr=ds_col.getAt(j);
     	if(tabjson.tabname && fieldr && fieldr.get('DATANAME')!=tabjson.tabname) continue;
     	var field={};
     	field.name=fieldr.get('COLNAME');
     	field.cnname=fieldr.get('COLCNNAME');
     	field.pk=fieldr.get('KEY_SEQ')?"1":"0"
      tabjson.fields.push(field);
     };
     allTabs[tabjson.tabname]=tabjson;
     addTabByJson(tabjson);
    
   } 
   for(var i=0;i<ds_tab.getCount();i++){
     var r=ds_tab.getAt(i);
     if(r.get('OBJTYPE')=='连接'){
     	 addLink(r.get("OBJNAME"),r.get("OBJCNNAME").toUpperCase(),r.get("REFOBJNAME"),r.get("REFOBJCNNAME").toUpperCase()); 
     }
    };
   
 };
function getCellByID(id) {
	var _result=null;
	var parent = graph.getDefaultParent();
	var childCount=graph.getModel().getChildCount(parent);
	for (var i=0;i<childCount;i++){
	   var child=graph.getModel().getChildAt(parent,i);
	   if(child.id==id) {_result=child;break;}
  }
  return _result;
}
function getFieldSeq(tabname,fieldname){
	var tabInfo=allTabs[tabname];
	if(!tabInfo) return -1;
	var result=null;
 
	for(var i=0;i<tabInfo.fields.length;i++){
			
		if(tabInfo.fields[i].name==fieldname) {
			result=i+1;
		  break;
		}
	};
	return result;
};
function getFieldNameBySeq(tabname,seq){
	var tabInfo=allTabs[tabname];
	if(!tabInfo) return "";
  var seq=parseInt(seq)-1;
  if(seq<0 ||seq>=tabInfo.fields.length) return ""
  else return tabInfo.fields[seq].name;
};
function addLink(fromTab,fromField,toTab,toField) {
	var v1 = getCellByID(fromTab);

	if(!v1) {alert('not fount fromTab:'+fromTab);return false;};
	var v2 = getCellByID(toTab);
	
	if(!v2) {alert('not fount toTab:'+toTab);return false;};
	
	var sourSeq=getFieldSeq(fromTab,fromField);
	if(!sourSeq) {alert('not fount fromfield:'+fromTab+"."+fromField);return false;};
	
	var targetSeq=getFieldSeq(toTab,toField);
	if(!targetSeq) {alert('not fount tofield:'+toTab+"."+toField);return false;};
	
  var doc = mxUtils.createXmlDocument();
  
  var relation = doc.createElement('Relation');
 
	relation.setAttribute('sourceRow',sourSeq );
	relation.setAttribute('targetRow',targetSeq);
  var parent = graph.getDefaultParent();
  var e1 = graph.insertEdge(parent, "r1", relation, v1, v2); 
 
};
function addTabByJson(tabInfo){
	var parent = graph.getDefaultParent();
	 
	  graph.getModel().beginUpdate();
		try{
			var v1 = graph.insertVertex(parent,tabInfo.tabname, '', tabInfo.x+addCount, tabInfo.y +addCount, defaultWidth, 0);
			graph.updateCellSize(v1);
			v1.geometry.width = tabInfo.width;
			if(tabInfo.height)v1.geometry.height = tabInfo.height;
			v1.geometry.alternateBounds = new mxRectangle(0, 0, tabInfo.width, 27);
    }
	  //catch(e){alert(e)}
	  finally {
			graph.getModel().endUpdate();
		}
};
function aftSelTabAdd(tr_e,rs){
	
  for(var i=0;i<rs.length;i++){
  	var tabname=rs[i].get('VALUES1');
  	var tabInfo=getTabJson(tabname);
  	addTabByJson(tabInfo);
	}    
};
function selTabAdd(){ 
  addCount +=20;
  mywin = searchWin.init(aftSelTabAdd,'select dataname VALUES1,datacnname VALUES2 from md.tablefile')
  mywin.win.show();
};

function getTabJson(tabname){
	if(allTabs[tabname]) return allTabs[tabname];
	allTabs;
	var tabInfo={tabname:'',cnname:'',fields:[],x:20,y:20,width:defaultWidth};
	var sql="select dataname,datacnname from md.tablefile  where dataname='"+tabname+"'";
 	var ds_tab = Asiainfo.getStore(sql);
 	if(ds_tab.getCount()==0) return ;
 	tabInfo.tabname=tabname;
 	tabInfo.cnname = ds_tab.getAt(0).get('DATACNNAME')||tabname;
 	 var sql="select colname,colcnname,datatype,length,remark,col_seq,KEY_SEQ from md.column  where  dataname  ='"+tabname+"' order by dataname,key_seq ,col_seq";
   var ds_col = Asiainfo.getStore(sql);
   for(var i=0;i<ds_col.getCount()-1;i++){
   	var r=ds_col.getAt(i);
   	tabInfo.fields.push({id:i,name:r.get('COLNAME'),cnname:r.get('COLCNNAME')||r.get('COLNAME'),pk:r.get('KEY_SEQ')?"1":"0"});
   };
   if(tabInfo.fields.length>10) tabInfo.height = defaultHeight;
   allTabs[tabname]=tabInfo;
   
   return tabInfo;
};
function getFieldAttr(fieldInfo){
	var fieldname = fieldInfo.name;
	if(phyorLogic=='logic' && fieldInfo.cnname) fieldname = fieldInfo.cnname;
	if(fieldInfo.pk=="1"){
		return '<tr><td><img align="center" src="images/key.png"/></td><td><u>'+fieldname+'</u></td></tr>';
	}
	else 
		return '<tr><td>&nbsp;&nbsp;</td><td>'+fieldname.toLowerCase()+'</td></tr>' 
};
function getTabInfo(cell){
	if(!graph.getModel().isVertex(cell)) return "";
  var tabname=cell.id;
  var tabInfo=getTabJson(tabname);
  if(!tabInfo) return " ";
  var tmpTabName=tabname;
  if(phyorLogic=='logic') tmpTabName = tabInfo.cnname;
	if(tabname.length>24) tmpTabName=tabname.substr(1,24)+"...";
  if (graph.isCellCollapsed(cell)){
							return '<table width="100%" border="1" cellpadding="4" class="title">' +
								'<tr><th colspan="2">'+tmpTabName+'</th></tr>' +
								'</table>';
	};
	var html='<table width="100%" border="1" cellpadding="4" class="title"><tr><th colspan="2">'+tmpTabName+'</th></tr></table>';
	    html+='<div style="overflow:auto;cursor:default;"><table width="100%" height="100%" border="1" cellpadding="4" class="erd">';
	for(var i=0;i<tabInfo.fields.length;i++)
		  html+= getFieldAttr(tabInfo.fields[i]);
	    html+='</table></div>';
  return html;		 
};
function saveModel(modelcode){
	
	Asiainfo.executeSQL("delete from MD.BUSI_MODELDEF where modelcode='"+modelcode+"'");
	
	var sql="select MODELCODE, OBJNAME, OBJCNNAME, OBJTYPE, REFOBJNAME, REFOBJCNNAME, OBJX, OBJY, OBJH, OBJW  from MD.BUSI_MODELDEF where 1=2";
 	var ds_tab = Asiainfo.getStore(sql);
	var rec = ds_tab.newRecord();
  var parent = graph.getDefaultParent();
  var childCount = graph.getModel().getChildCount(parent);
  for (var i = 0; i < childCount; i++) {
    var child = graph.getModel().getChildAt(parent, i);
    if (child.isVertex()) {
    	var rec = ds_tab.newRecord();
	    rec.set('MODELCODE',modelcode);
	    rec.set('OBJNAME',child.id);
	    rec.set('OBJTYPE','表');
	    rec.set('OBJCNNAME',child.id);
	    rec.set('REFOBJNAME',"");
	    rec.set('REFOBJCNNAME',child.id);
	    rec.set('OBJX',child.geometry.x);
	    rec.set('OBJY',child.geometry.y);
	    rec.set('OBJW',child.geometry.width);
	    rec.set('OBJH',child.geometry.height);
	    ds_tab.add(rec);
      	//alert(child.id+",width="+child.geometry.width);
     	}
    if (child.isEdge()) {
     	var fromFieldName=getFieldNameBySeq(child.source.id,child.getAttribute('sourceRow'));
     	var tofieldName= getFieldNameBySeq(child.target.id,child.getAttribute('targetRow')); 
     	if(!fromFieldName){alert('no found field:'+child.source.id+"."+child.getAttribute('sourceRow'));return ;};
     	if(!tofieldName){alert('no found field:'+child.target.id+"."+child.getAttribute('targetRow'));return ;};
     	var rec = ds_tab.newRecord();  
	    rec.set('MODELCODE',modelcode);
	    
	    rec.set('OBJNAME',child.source.id);
	    rec.set('OBJCNNAME',fromFieldName);
	    rec.set('OBJTYPE','连接');
	    rec.set('REFOBJNAME',child.target.id);
	    rec.set('REFOBJCNNAME',tofieldName);
	    rec.set('OBJX',0);
	    rec.set('OBJY',0);
	    rec.set('OBJW',0);
	    rec.set('OBJH',0);
	    ds_tab.add(rec); 
     	 	 	//alert('isEdge,value:'+child.source.id);//getSource().value+",to:"+child.getTarget().value);
     	 	 //	alert(child.source.id+"."+child.getAttribute('sourceRow')+"->"+child.target.id+"."+child.getAttribute('targetRow'));
    }
    //	else alert('other,'+child.id);  
  }
  ds_tab.commit();
  //wangc
  //1.插入一个根节点
  var modelAttrStore = Asiainfo.getStore("select * from MD.BUSI_MODELATTR where modelcode='"+modelcode+"'");
  if(modelAttrStore.getCount()==0){
	  Asiainfo.executeSQL("INSERT INTO MD.BUSI_MODELATTR(MODELCODE,ATTRCODE,ATTNAME, ATTRTYPE) VALUES('"+modelcode+"','R0','模型属性','根节点')");
	  Asiainfo.executeSQL("INSERT INTO MD.BUSI_MODELATTR(MODELCODE,ATTRCODE,ATTNAME, ATTRTYPE) VALUES('"+modelcode+"','R1','自定义属性','分类节点')");
	  Asiainfo.executeSQL("INSERT INTO MD.BUSI_MODELATTR(MODELCODE,ATTRCODE,ATTNAME, ATTRTYPE) VALUES('"+modelcode+"','R2','与外部数据关联','分类节点')");
	  Asiainfo.executeSQL("INSERT INTO MD.BUSI_MODELATTR(MODELCODE,ATTRCODE,PARENTCODE,ATTNAME, ATTRTYPE,INPUTTYPE) VALUES('"+modelcode+"','R2_01','R2','与导入数据关联','关联','linkfileup')");
	  Asiainfo.executeSQL("INSERT INTO MD.BUSI_MODELATTR(MODELCODE,ATTRCODE,PARENTCODE,ATTNAME, ATTRTYPE,INPUTTYPE) VALUES('"+modelcode+"','R2_02','R2','与查询数据关联','关联','linkfileup')");
	  Asiainfo.executeSQL("INSERT INTO MD.BUSI_MODELATTR(MODELCODE,ATTRCODE,ATTNAME, ATTRTYPE) VALUES('"+modelcode+"','R9','不发布属性','分类节点')");
  }
  //2.插入表的分类节点
  var ds_tabNode=Asiainfo.getStore("select MODELCODE,ATTRCODE,PARENTCODE,ATTNAME,ATTRTYPE,FIELDDEF from MD.BUSI_MODELATTR where MODELCODE='"+modelcode+"' and attrcode like 'T%'");  
  var ds_newTable = Asiainfo.getStore("SELECT A.OBJNAME FROM MD.BUSI_MODELDEF A WHERE OBJTYPE = '表' and a.modelcode='"+modelcode+"' AND NOT EXISTS (SELECT 1 FROM MD.BUSI_MODELATTR B WHERE A.OBJNAME = B.FIELDDEF and b.modelcode='"+modelcode+"')");
   
  for(var i=0;i<ds_newTable.getCount();i++){
       var r = ds_newTable.getAt(i);
       var newAttrCode = Asiainfo.GetNewCode(ds_tabNode,'ATTRCODE','T');
       var newTabNode=ds_tabNode.getNewRecord();
       newTabNode.set('MODELCODE',modelcode);
       newTabNode.set('ATTRCODE',newAttrCode);	
       newTabNode.set('PARENTCODE','R0');	
       newTabNode.set('ATTNAME',r.get('OBJNAME'));	
       newTabNode.set('ATTRTYPE','分类节点');
       newTabNode.set('FIELDDEF',r.get('OBJNAME'));
       ds_tabNode.add(newTabNode);
       //			Asiainfo.executeSQL("INSERT INTO MD.BUSI_MODELATTR(MODELCODE,ATTRCODE,PARENTCODE,ATTNAME,ATTRTYPE,FIELDDEF) VALUES('"+modelcode+"','"+newAttrCode+"','R0','"+r.get('OBJNAME')+"','分类节点','"+r.get('OBJNAME')+"')"); 
  };
  ds_tabNode.commit();
  ///3.插入节点
  var sql="insert into MD.BUSI_MODELATTR(MODELCODE,ATTRCODE,PARENTCODE,ATTNAME,DATATYPE,ATTRTYPE,INPUTTYPE,INPUTPARA,FIELDDEF,RIGHTLEVEL,REMARK) "+
             "select a.MODELCODE, 'A'||a.attrcode||'_'||rtrim(char(COL_SEQ)) ATTRCODE,a.attrcode PARENTCODE,value(b.colcnname,b.colname) ATTNAME, b.DATATYPE, "+
             "case when substr(b.datatype,1,7)='VARCHAR' then '维度' else '指标' end ATTRTYPE,trim(case when substr(b.datatype,1,7) = 'VARCHAR' then 'text' when substr(UPPER(b.datatype),1,4) = 'TIME' then 'date' when substr(upper(b.datatype),1,7) = 'DECIMAL' then 'number' when substr(upper(b.datatype),1,8) = 'SMALLINT' then 'number' when substr(upper(b.datatype),1,7) = 'INTEGER' then 'number' else lower(b.datatype) end) INPUTTYPE "+
             ",'' INPUTPARA,b.dataname||'.'||b.colname FIELDDEF,'' RIGHTLEVEL ,b.REMARK "+
             "from MD.BUSI_MODELATTR a,md.column b where a.fielddef=b.dataname and b.dataname||'.'||b.colname not in "+
             "(select value(FIELDDEF,'0') from MD.BUSI_MODELATTR where MODELCODE='"+modelcode+"') "+
             "and MODELCODE='"+modelcode+"' order by b.dataname,b.col_seq ";
	Asiainfo.executeSQL(sql);
	//alert("save ok");
};
function showTabInfo(tabname){
	function afterTabInfoOk(){
		 
		return true;
	};
	 Asiainfo.ShowDialog(tabname,'../../meta/TableDetail.html?DATANAME='+tabname,900,500,afterTabInfoOk);
};
Ext.onReady(function(){
	Ext.QuickTips.init();
	 
	var pnMain = new Ext.Panel({contentEl:'graphContainer',bbar:buildToolbar(),region:'center',autoScroll:true})
	var vp = new Ext.Viewport({layout:'border',items:[pnMain]});
});

function buildToolbar(){
	 var fd_showLevel = new Ext.form.ComboBox({
	     fieldLabel:'显示级别',
	     name:'showLevel',
	     width:120,
	     height:21,
	     mode: 'local',
	     value:showLevel,
      triggerAction:'all',
      store:   new Ext.data.SimpleStore({
      		fields:['ID','VALUE'],
      		data:[['erd','表级'],['erk','主外键级'],['era','所有字段']]
      	}),
      	valueField: 'ID',displayField: 'VALUE',
      	anchor:'97%' 
   });
   var fd_phyorLogic = new Ext.form.ComboBox({
	     fieldLabel:'逻辑或物理',
	     name:'showLevel',
	     width:120,
	     height:21,
	     mode: 'local',
	     value:phyorLogic,
	     
      triggerAction:'all',
      store:   new Ext.data.SimpleStore({
      		fields:['ID','VALUE'],
      		data:[['phy','物理模型'],['logic','逻辑模型']]
      	}),
      	valueField: 'ID',displayField: 'VALUE',
      	anchor:'97%' 
   });
   var btn_refresh= new Ext.Button({
     text: '刷新',
     cls:'x-btn-text-icon',
     icon:'images/refresh.gif',
     handler:function(button,event){
 
     	 window.location="ergraph.html?ISWIZARD="+isWizard+"&WIZARDID="+wizardId+"&MODELCODE="+modelcode+"&SHOWLEVEL="+fd_showLevel.getValue()+"&SHOWTYPE="+fd_phyorLogic.getValue();
    }});
	var btn_addTab= new Ext.Button({
     text: '增加表',
     cls:'x-btn-text-icon',
     icon:'images/group.png',
     handler:function(button,event){
     	 selTabAdd();
    }});
   	var btn_addLink= new Ext.Button({
     text: '增加连接',
     cls:'x-btn-text-icon',
     icon:'images/group.png',
     handler:function(button,event){
     	 //addLink('NMK.KPI_AREA_BRAND','ITEMID','NWH.MBUSER','CUST_ID');
    }});
    var btn_loadModel= new Ext.Button({
     text: 'loadModel',
     cls:'x-btn-text-icon',
     icon:'images/group.png',
     handler:function(button,event){
     	 loadERModel(modelcode);
    }});
    var btn_saveModel= new Ext.Button({
     text: '保存',
     cls:'x-btn-text-icon',
     icon:'images/save.gif',
     handler:function(button,event){
     	 saveModel(modelcode);
    }});
    
    var btn_preStep= new Ext.Button({
     text: '上一步',
     cls:'x-btn-text-icon',
     icon:'../../images/arrow_left.gif',
     handler:function(button,event){
     	 SendParentCmd('wizard',wizardId+',pre');
    }});
    var btn_nextStep= new Ext.Button({
     text: '下一步',
     cls:'x-btn-text-icon',
     icon:'../../images/arrow_right.gif',
     handler:function(button,event){
     	 SendParentCmd('wizard',wizardId+',next');
    }});
    
    var btn_1= new Ext.Button({
     text: '取信息',
     cls:'x-btn-text-icon',
     icon:'images/group.png',
     handler:function(button,event){
     	var parent = graph.getDefaultParent();
      var childCount = graph.getModel().getChildCount(parent);
       
     	 for (var i = 0; i < childCount; i++) {
     	 	 var child = graph.getModel().getChildAt(parent, i);
     	 	 if (child.isVertex()) {
     	 	 	// alert('isVertex,'+child.value+","+child.id);
     	 	 	alert(child.id+",width="+child.geometry.width);
     	 	 }
     	 	 if (child.isEdge()) {
     	 	  
     	 	 	//alert('isEdge,value:'+child.source.id);//getSource().value+",to:"+child.getTarget().value);
     	 	 //	alert(child.source.id+"."+child.getAttribute('sourceRow')+"->"+child.target.id+"."+child.getAttribute('targetRow'));
     	 	}
     	 //	else alert('other,'+child.id);
     	  }
    }});
    
    var toolBarItems = ['显示级别:',fd_showLevel,fd_phyorLogic,btn_refresh,'-',btn_addTab,'-',btn_saveModel];
    if(isWizard && isWizard == 'true') toolBarItems.push('->',btn_preStep,btn_nextStep);
    var toolbar = new Ext.Toolbar({items: toolBarItems});
    return toolbar
};
 
function main(container){
			// Checks if the browser is supported
		 
			if (!mxClient.isBrowserSupported())
			{
				// Displays an error message if the browser is not supported.
				mxUtils.error('Browser is not supported!', 200, false);
			}
			else
			{
				// If connect preview is not moved away then getCellAt is used to detect the cell under
				// the mouse if the mouse is over the preview shape in IE (no event transparency), ie.
				// the built-in hit-detection of the HTML document will not be used in this case. This is
				// not a problem here since the preview moves away from the mouse as soon as it connects
				// to any given table row. This is because the edge connects to the outside of the row and
				// is aligned to the grid during the preview.
				mxConnectionHandler.prototype.movePreviewAway = false;
				
				// Disables foreignObject support for Webkit because scrollbars in
				// HTML labels do not work if x- or y-attribute of foreignObject != 0
				// see http://code.google.com/p/chromium/issues/detail?id=35545
				// also all HTML background is not visible if the vertex has a fill
				// color in SVG, which in turn is required for a shadow in mxGraph
				mxClient.NO_FO = mxClient.NO_FO || mxClient.IS_GC || mxClient.IS_SF;

				// Enables move preview in HTML to appear on top
				mxGraphHandler.prototype.htmlPreview = true;

				// Enables connect icons to appear on top of HTML
				mxConnectionHandler.prototype.moveIconFront = true;
				
				// Defines an icon for creating new connections in the connection handler.
				// This will automatically disable the highlighting of the source vertex.
				mxConnectionHandler.prototype.connectImage = new mxImage('images/connector.gif', 16, 16);

				// Overrides target perimeter point for connection previews
				mxConnectionHandler.prototype.getTargetPerimeterPoint = function(state, me)
				{
					// Determines the y-coordinate of the target perimeter point
					// by using the currentRowNode assigned in updateRow
					var y = me.getY();

					if (this.currentRowNode != null)
					{
						y = getRowY(state, this.currentRowNode);
					}

					// Checks on which side of the terminal to leave
					var x = state.x;
					
					if (this.previous.getCenterX() > state.getCenterX())
					{
						x += state.width;
					}
					
					return new mxPoint(x, y); 
				};

				// Overrides source perimeter point for connection previews
				mxConnectionHandler.prototype.getSourcePerimeterPoint = function(state, next, me)
				{
					var y = me.getY();

					if (this.sourceRowNode != null)
					{
						y = getRowY(state, this.sourceRowNode);
					}

					// Checks on which side of the terminal to leave
					var x = state.x;
					
					if (next.x > state.getCenterX())
					{
						x += state.width;
					}

					return new mxPoint(x, y);
				};

				// Disables connections to invalid rows
				mxConnectionHandler.prototype.isValidTarget = function(cell)
				{
					return this.currentRowNode != null;
				};
				
				// Creates the graph inside the given container
				  graph = new mxGraph(container);

				// Uses the entity perimeter (below) as default
				graph.stylesheet.getDefaultVertexStyle()[mxConstants.STYLE_VERTICAL_ALIGN] = mxConstants.ALIGN_TOP;
				graph.stylesheet.getDefaultVertexStyle()[mxConstants.STYLE_PERIMETER] =
					mxPerimeter.EntityPerimeter;
				graph.stylesheet.getDefaultVertexStyle()[mxConstants.STYLE_SHADOW] = true;
				delete graph.stylesheet.getDefaultVertexStyle()[mxConstants.STYLE_STROKECOLOR];

				// Used for HTML labels that use up the complete vertex space (see
				// graph.cellRenderer.redrawLabel below for syncing the size)
				graph.stylesheet.getDefaultVertexStyle()[mxConstants.STYLE_OVERFLOW] = 'fill';

				// Uses the entity edge style as default
				graph.stylesheet.getDefaultEdgeStyle()[mxConstants.STYLE_EDGE] =
					mxEdgeStyle.EntityRelation;
				graph.stylesheet.getDefaultEdgeStyle()[mxConstants.STYLE_STROKECOLOR] = 'black';
				graph.stylesheet.getDefaultEdgeStyle()[mxConstants.STYLE_FONTCOLOR] = 'black';

				// Allows new connections to be made but do not allow existing
				// connections to be changed for the sake of simplicity of this
				// example
				graph.setCellsDisconnectable(false);
				graph.setAllowDanglingEdges(false);
				graph.setCellsEditable(true);
				graph.setConnectable(true);

				// Override folding to allow for tables
				graph.isCellFoldable = function(cell, collapse)
				{
					return this.getModel().isVertex(cell);
				};

				// Overrides connectable state
				graph.isCellConnectable = function(cell)
				{
					return !this.isCellCollapsed(cell);
				};
				
				// Enables HTML markup in all labels
				graph.setHtmlLabels(true);

				// Scroll events should not start moving the vertex
				graph.cellRenderer.isLabelEvent = function(state, evt)
				{
					var source = mxEvent.getSource(evt);

					// FIXME: No scroll events in GC
					return state.text != null &&
						source != state.text.node &&
						source != state.text.node.getElementsByTagName('div')[0];
				};

				// Adds scrollbars to the outermost div and keeps the
				// DIV position and size the same as the vertex
				var oldRedrawLabel = graph.cellRenderer.redrawLabel;
				graph.cellRenderer.redrawLabel = function(state)
				{
					oldRedrawLabel.apply(this, arguments); // "supercall"
					var graph = state.view.graph;

					if (graph.getModel().isVertex(state.cell) && state.text != null)
					{
						// Scrollbars are on the div
						var s = graph.view.scale;
						var div = state.text.node.getElementsByTagName('div')[0];
						
						if (div != null)
						{
							// Adds height of the title table cell
							var oh = 0;
	
							if (div.previousSibling != null)
							{
								oh = div.previousSibling.firstChild.firstChild.firstChild.offsetHeight;
							}
	
							div.style.width = (state.width / s) + 'px';
							div.style.height = ((state.height / s) - oh) + 'px';
							div.style.zoom = s;
							
							// Installs the handler for updating connected edges
							if (div.scrollHandler == null)
							{
								div.scrollHandler = true;
								 
								  mxEvent.addListener(div, 'scroll',
									mxUtils.bind(this, function(evt)
									{
										graph.view.invalidate(state.cell, false, true);
										graph.view.validate();
									})
								);
		
								mxEvent.addListener(div, 'mouseup',
									mxUtils.bind(this, function(evt)
									{
										if (!this.isLabelEvent(state, evt))
										{
											graph.view.invalidate(state.cell, false, true);
											graph.view.validate();
										}
									})
								);
								 
							}
						}
					}
				};

				// Adds a new function to update the currentRow based on the given event
				// and return the DOM node for that row
				graph.connectionHandler.updateRow = function(target)
				{
					while (target != null && target.nodeName != 'TR')
					{
						target = target.parentNode;
					}

					this.currentRow = null;

					// Checks if we're dealing with a row in the correct table
					if (target != null && target.parentNode.parentNode.className == 'erd')
					{
						// Stores the current row number in a property so that it can
						// be retrieved to create the preview and final edge
						var rowNumber = 0;
						var current = target.parentNode.firstChild;

						while (target != current && current != null)
						{
							current = current.nextSibling;
							rowNumber++;
						}

						this.currentRow = rowNumber + 1;
					}
					else
					{
						target = null;
					}
					
					return target;
				};
				
				// Adds placement of the connect icon based on the mouse event target (row)
				graph.connectionHandler.updateIcons = function(state, icons, me)
				{
					var target = me.getSource();
					target = this.updateRow(target);
					
					if (target != null && this.currentRow != null)
					{
						var div = target.parentNode.parentNode.parentNode;

						icons[0].node.style.visibility = 'visible';
						icons[0].bounds.x = state.x + target.offsetLeft + Math.min(state.width,
							target.offsetWidth) - this.icons[0].bounds.width - 2;
						icons[0].bounds.y = state.y + target.offsetTop + target.offsetHeight / 2 -
							this.icons[0].bounds.height / 2 - div.scrollTop + div.offsetTop;
						icons[0].redraw();

						this.currentRowNode = target;
					}
					else
					{
						icons[0].node.style.visibility = 'hidden';
					}
				};

				// Updates the targetRow in the preview edge State
				var oldMouseMove = graph.connectionHandler.mouseMove;
				graph.connectionHandler.mouseMove = function(sender, me)
				{
					if (this.edgeState != null)
					{
						this.currentRowNode = this.updateRow(me.getSource());
						
						if (this.currentRow != null)
						{
							this.edgeState.cell.value.setAttribute('targetRow', this.currentRow);
						}
						else
						{
							this.edgeState.cell.value.setAttribute('targetRow', '0');
						}
						
						// Destroys icon to prevent event redirection via image in IE
						if (this.selectedIcon != null)
						{
							this.selectedIcon.destroy();
							this.selectedIcon = null;
						}
					}
					
					oldMouseMove.apply(this, arguments);
				};

				// Creates the edge state that may be used for preview
				graph.connectionHandler.createEdgeState = function(me)
				{
					var relation = doc.createElement('Relation');
					relation.setAttribute('sourceRow', this.currentRow || '0');
					relation.setAttribute('targetRow', '0');

					var edge = this.createEdge(relation);
					var style = this.graph.getCellStyle(edge);
					var state = new mxCellState(this.graph.view, edge, style);

					// Stores the source row in the handler
					this.sourceRowNode = this.currentRowNode;
					
					return state;
				};

				// Overrides getLabel to return empty labels for edges and
				// short markup for collapsed cells.
				graph.getLabel = function(cell)
				{
					return getTabInfo(cell);
				};

				// User objects (data) for the individual cells
				var doc = mxUtils.createXmlDocument();

				// Same should be used to create the XML node for the table
				// description and the rows (most probably as child nodes)
				var relation = doc.createElement('Relation');
				relation.setAttribute('sourceRow', '4');
				relation.setAttribute('targetRow', '6');
				
				// Enables rubberband selection
				new mxRubberband(graph);

				// Enables key handling (eg. escape)
				new mxKeyHandler(graph);
				
				// Gets the default parent for inserting new cells. This
				// is normally the first child of the root (ie. layer 0).
				var parent = graph.getDefaultParent();
								
				// Adds cells to the model in a single step
				
				graph.getModel().beginUpdate();
				try
				{
					loadERModel(modelcode);
					
				}
				finally
				{
					// Updates the display
					graph.getModel().endUpdate();
				}
			}
			installKeyLinten(graph);
};
function installKeyLinten(graph){
 
 graph.dblClick = function(evt, cell) {
 	if(!cell || !cell.id) return;
 	showTabInfo(cell.id);
 };
 var keyHandler = new mxKeyHandler(graph);

    // Ignores enter keystroke. Remove this line if you want the
    // enter keystroke to stop editing
    keyHandler.enter = function() {};

    keyHandler.bindKey(8,
    function() {
        graph.foldCells(true);
    });

    keyHandler.bindKey(13,
    function() {
        graph.foldCells(false);
    });

    keyHandler.bindKey(33,
    function() {
        graph.exitGroup();
    });

    keyHandler.bindKey(34,
    function() {
        graph.enterGroup();
    });

    keyHandler.bindKey(36,
    function() {
        graph.home();
    });

    keyHandler.bindKey(35,
    function() {
        graph.refresh();
    });

    keyHandler.bindKey(37,
    function() {
        graph.selectPreviousCell();
    });

    keyHandler.bindKey(38,
    function() {
        graph.selectParentCell();
    });

    keyHandler.bindKey(39,
    function() {
        graph.selectNextCell();
    });

    keyHandler.bindKey(40,
    function() {
        graph.selectChildCell();
    });

    keyHandler.bindKey(46,
    function() {
        graph.removeCells();
    });

    keyHandler.bindKey(107,
    function() {
        graph.zoomIn();
    });

    keyHandler.bindKey(109,
    function() {
        graph.zoomOut();
    });

    keyHandler.bindKey(113,
    function() {
        graph.startEditingAtCell();
    });

    keyHandler.bindControlKey(65,
    function() {
        graph.selectAll();
    });

    keyHandler.bindControlKey(89,
    function() {
        history.redo();
    });

    keyHandler.bindControlKey(90,
    function() {
        history.undo();
    });

    keyHandler.bindControlKey(88,
    function() {
        mxClipboard.cut(graph);
    });

    keyHandler.bindControlKey(67,
    function() {
        mxClipboard.copy(graph);
    });

    keyHandler.bindControlKey(86,
    function() {
        mxClipboard.paste(graph);
    });

    keyHandler.bindControlKey(71,
    function() {
        graph.setSelectionCell(graph.groupCells(null, 20));
    });

    keyHandler.bindControlKey(85,
    function() {
        graph.setSelectionCells(graph.ungroupCells());
    });
}
 