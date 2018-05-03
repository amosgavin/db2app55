/*
 * $Id: GraphEditor.js,v 1.37 2009/04/06 15:07:19 gaudenz Exp $
 * Copyright (c) 2008, Gaudenz Alder
 */
GraphEditor = {};
Ext.BLANK_IMAGE_URL = '../ext/resources/images/default/s.gif';
 var graph;
//For add customized properties begin
var vertexArr=new Array();
var edgeArr=new Array(); 
 
var paramMap={};
temp = window.location.search; 
if(temp.length!=0){
	temp = temp.substr(1).split('&');
	for (i=0;i<temp.length;++i){
		f = temp[i].split('=');
		paramMap[f[0]]=f[1];
	} 
};

var annyType = (typeof(paramMap.annyType)!='undefined')?paramMap.annyType:'DATA'; 
var relaName = (typeof(paramMap.relaName)!='undefined')?paramMap.relaName:'';
var annyDirection = (typeof(paramMap.annyDirection)!='undefined')?paramMap.annyDirection:'Up';
var level =(!paramMap.level)?2:paramMap.level; 
var granularity = (typeof(paramMap.granularity)!='undefined')?paramMap.granularity:'ALL';
var control = (typeof(paramMap.control)!='undefined')?paramMap.control:'2';
var layoutType =(typeof(paramMap.layoutType)!='undefined')?paramMap.layoutType:'Hierarchical'; 
var metaprj=(typeof(paramMap.metaprj)!='undefined')?paramMap.metaprj:''; 
var CYCLEID =(typeof(paramMap.CYCLEID)!='undefined')?paramMap.CYCLEID:(new Date()).format('yyyymmdd-3'); 
//var objStateStore=Asiainfo.getStore("select OBJNAME,OBJTYPE,CYCLEID,STATE from MD.CHECK_OBJ_LOG where 1=2");
 
var objStateStore = Asiainfo.getStore("select '' OBJNAME,'' OBJTYPE,'' STATE,'' REMARK from MD.PROC where 1=2 ");
function getObjRecord(objname){
	var idx = objStateStore.find('OBJNAME',objname.toUpperCase());
	return idx == -1 ? 'undefine': objStateStore.getAt(idx);
}
 
function getVertexById(vertexArr,id)
				{
					var result=null;
					for (var i=0;i<vertexArr.length;i++)
					{
						if (vertexArr[i].getId()==id)
						{
							result=vertexArr[i];
							break;
						}
				  }
				 
				  return result;
				};
function getVertexByValue(value) {
				var _result=null;
	var parent = graph.getDefaultParent();
	var childCount=graph.getModel().getChildCount(parent);
	for (var i=0;i<childCount;i++){
	   var child=graph.getModel().getChildAt(parent,i);
	   if(child.value==value) {_result=child;break;}
  }
  return _result;
				}	
//点击overlay弹出的Form表单				
var logForm=new Asiainfo.widget.Form({
	id:'logForm',
	subtype:'exttabform',
	labelWidth:60,
	frame:true,
	region:'center',
	store:objStateStore,
	border: 'border',
	width:400,
	height:230,
	fields:[
		[{xtype:'textfield',fieldLabel:'对象名',name:'OBJNAME',id:'OBJNAME',anchor:'98%'}],
		[{xtype:'textfield',fieldLabel:'运行时间',name:'CYCLEID',id:'CYCLEID',anchor:'98%'}],
		[{xtype:'textfield',fieldLabel:'运行状态',name:'STATE',id:'STATE',anchor:'98%'}],
		[{xtype:'textarea',fieldLabel:'运行结果',name:'REMARK',id:'REMARK',anchor:'97%'}]
	]
});

var logWindow=new Ext.Window({
	id:'win_logForm',
	title:'对象运行情况',
	layout:'fit',
	plain:true,
	modal:true,
	width:400,
	height:230,
	buttonAlign:'center',
	closable:false,
	items:[logForm.control],
	buttons:[{text:'退出',handler:function(){
		logWindow.hide();
	}}]
});


				
function createOverlay(image, tooltip)
		{
			var overlay = new mxCellOverlay(image, tooltip);
			
			// Installs a handler for clicks on the overlay
			overlay.addListener(mxEvent.CLICK, function(sender, evt)
			{
				 
				logWindow.show();
				if(tooltip) Ext.getCmp('logForm').getForm().loadRecord(tooltip);
			});
			
			return overlay;
		};
									
//For add customized properties end
function setVertexType(cell){///从cell.style中获取节点类型
	
	if(!cell.isVertex()) return;
	if(!cell.style) return;
	var str=cell.style;
	var objType="DATA";
	var cnname=cell.value;
	if(cell.style.indexOf("ellipse")!=-1)objType="PROC" ;
	
	var strList=str.split(";");
	for(var i=0;i<strList.length;i++){
		if(strList[i].indexOf("cnname")!=-1 && strList[i].indexOf("=")!=-1){
			cnname=strList[i].substr(strList[i].indexOf("=")+1);
		}
		if(strList[i].indexOf("objType")!=-1 && strList[i].indexOf("=")!=-1){
			objType=strList[i].substr(strList[i].indexOf("=")+1);
		}
	};
	if(cnname=="") cnname=cell.value;
	cell.cnname =cnname ||cell.value;
	
	cell.objType= objType;
  if(cell.objType=='ETL') cell.objType="PROC";
  //if(cell.objType == 'ETL' || cell.objType == 'PROC'){
    	var curRecord=getObjRecord(cell.value);
    	if(curRecord =='undefine'){
    		if(cell.value.indexOf('IMP-')>=0) objType='INTER'
    		else if(cell.value.indexOf('ZB-')>=0) objType='ZB'
    		else objType='PROC';
    		curRecord = objStateStore.newRecord();
    		curRecord.set('OBJNAME',cell.value);
    		curRecord.set('OBJTYPE',objType);
    		curRecord.set('STATE','undo');
    		curRecord.set('REMARK','对象未执行！');
    	}
    	var state = curRecord.get('STATE');
    	cell.objType= curRecord.get('OBJTYPE');
    	if(state == 'ok'){
    		graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#00FF00', [cell]);
    	}
    	else if(state == 'warn'){
    		graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#FFFF00', [cell]);
    	}else if(state == 'error'){
    		graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#FF0000', [cell]);
    	}else if(state == 'undo'){
    		graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#D8D8D8', [cell]);
    	}
    	
    	if( state == 'warn' || state == 'error' || state == 'undo' ){
    		graph.addCellOverlay(cell,createOverlay(graph.warningImage, curRecord));
    	}
  //  }
    
	
	graph.refresh(cell);
};

 var initCellFull = function (){///从cell.style中获取节点中文名
 var allobjs = "";
  var parent = graph.getDefaultParent();
  var childCount = graph.getModel().getChildCount(parent);
	for (var i = 0; i < childCount; i++) {
     var child = graph.getModel().getChildAt(parent, i);
     if(!child.isVertex()) continue;
     if(allobjs) allobjs+=",'"+child.value+"'"
     else allobjs="'"+child.value+"'";
  }
  var logSql="select 'PROC' objtype,PROC_NAME OBJNAME,cycle_id CYCLEID,dq_state state,dq_remark from MD.PROC_LOG where cycle_id="+CYCLEID+" and proc_name in("+allobjs+")";
  objStateStore.updateSql(logSql);
  objStateStore.select();
  
  if(allobjs.indexOf('IMP-')>=0){////增加接口单元日志
  	allobjs=allobjs.replaceAll('IMP-','');
    var logSql="select 'INTER' objtype,intercode OBJNAME,inter_bat CYCLEID,dq_state state,dq_remark  from md.inter_source_log where inter_bat='"+CYCLEID+"' and intercode in("+allobjs+")";
    var tmpStore=Asiainfo.getStore(logSql);
    for(var i=0;i<tmpStore.getCount();i++){
  	  var r=tmpStore.getAt(i);
  	  r.set('OBJNAME','IMP-'+r.get('OBJNAME'));
  	  objStateStore.add(r);
    };
  };
  if(allobjs.indexOf('ZB-')>=0){////增加接口单元日志
  	allobjs=allobjs.replaceAll('ZB-','');
    var logSql="select 'ZB' objtype,zb_code OBJNAME,op_time CYCLEID, dq_state state,dq_remark from md.stat_rep_content where op_time='"+CYCLEID+"' and zb_code in("+allobjs+")";
    var tmpStore=Asiainfo.getStore(logSql);
    for(var i=0;i<tmpStore.getCount();i++){
  	  var r=tmpStore.getAt(i);
  	  r.set('OBJNAME','ZB-'+r.get('OBJNAME'));
  	  objStateStore.add(r);
    };
  };
  
  for (var i = 0; i < childCount; i++) {
     var child = graph.getModel().getChildAt(parent, i);
     if(!child.isVertex()) continue;
      
     setVertexType(child);
  }
  
};
function main()
{
    Ext.QuickTips.init();
 
	// Disables browser context menu
//	mxEvent.disableContextMenu(document.body);	
	
	// Makes the connection are smaller
	mxConstants.DEFAULT_HOTSPOT = 0.3;
    
	// Creates the graph and loads the default stylesheet
      graph = new mxGraph();
    
    // Creates the command history (undo/redo)
    var history = new mxUndoManager();

    // Loads the default stylesheet into the graph
    var node = mxUtils.load('resources/default-style.xml').getDocumentElement();
		var dec = new mxCodec(node.ownerDocument);
		dec.decode(node, graph.getStylesheet());
	
	// Sets the style to be used when an elbow edge is double clicked
	graph.alternateEdgeStyle = 'vertical';
	function CheckIdExist(newId)
	{
		  var result=false;
		  var parent = graph.getDefaultParent();
			var childCount=graph.getModel().getChildCount(parent);
			for (var i=0;i<childCount;i++)
					{
						var child=graph.getModel().getChildAt(parent,i);
						if (child.getId()==newId)
						   {
						   	result=true;
						   	break;
						  }						
				  }	
		 	return result;
	}
 
  			
				  
		var executeLayout = function(layout, animate, ignoreChildCount)
	{
		var cell = graph.getSelectionCell();
		
		if (cell == null ||
			(!ignoreChildCount &&
			graph.getModel().getChildCount(cell) == 0))
		{
			cell = graph.getDefaultParent();
		}

		// Animates the changes in the graph model except
		// for Camino, where animation is too slow
		if (animate && navigator.userAgent.indexOf('Camino') < 0)
		{
			var listener = function(sender, evt)
			{
				mxUtils.animateChanges(graph, evt.getArgAt(0)/*changes*/);
				graph.getModel().removeListener(listener);
			};
			
			graph.getModel().addListener(mxEvent.CHANGE, listener);
		}

        layout.execute(cell);
	};
	  
  
    var rendfun=function(value, p, record){
       return '<img src="../../images/cloud.gif"><b>'+value+','+record.get('STATE')+'</b>';
    };	// , OBJTYPE, CYCLEID, STATE, RATE, MRATE, REMARK
     
 var refreshGraph=function(){
 	var sm = gd_item.getSelectionModel() ;
 	 if(sm.getSelections().length==0) return; 
 	 var r=sm.getSelections()[0];
 	 var OBJNAME=r.get('OBJNAME');
 	 
 	 var parent = graph.getDefaultParent();
   var childCount = graph.getModel().getChildCount(parent);
    for (var i = 0; i < childCount; i++) {
       var child = graph.getModel().getChildAt(parent, i);
       if (child.isEdge() ) continue;
       	if (child.value==OBJNAME) {
       		 graph.setSelectionCell(child);
       	   //graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#0101DF',[child]);
       	   graph.scrollCellToVisible(child);
       	  }
        //else 
       	//   graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#F5FFFA',[child])
       }
 };
  var rendfun=function(value, p, record){
       return '<img src="../../images/cloud.gif"><b>'+value+'</b>';
    };
 var cm = new Ext.grid.ColumnModel([{
           id: 'OBJNAME',
           header: "对象名称",
           dataIndex: 'OBJNAME',
           width: 100,
            renderer: rendfun  
        },{
           id: 'STATE',
           header: "状态",
           dataIndex: 'STATE',
           width: 50 
        },{
           id: 'RATE',
           header: "波动率",
           dataIndex: 'RATE',
           width: 80  
        },{
           id: 'MRATE',
           header: "波动率",
           dataIndex: 'MRATE',
           width: 80 
        } ]);
  var gd_item= new Ext.grid.GridPanel({
         region:'east', id:'topic-grid',
         collapsible: true,
		     collapseMode:'mini', 
         width:400,
         store: objStateStore,
         cm: cm,
         split:true,
         stripeRows:true,
         trackMouseOver:false,
         loadMask: {msg:'Loading Topics...'},
         viewConfig: {forceFit:true,enableRowBody:true,showPreview:true,
             getRowClass : function(record, rowIndex, p, ds){
             var color='blue';
         
             if(record.get('STATE')=="") color='black'
             else if(record.get('STATE')!='ok'  ) color='red';
             if(this.showPreview){
                      p.body = '<p style="word-break:break-all">质量描述:'+record.data.DQ_REMARK+'</p>'+
                               '<p>状态:<font color='+color+'><b>'+record.data.STATE+'</b></font>  |  记录数:<font color=blue><b>'+record.data.RATE+'</b></font>  |  SQLCODE:<font color=blue><b>'+record.data.CYCLEID+'</b></font></p>'+
                               '<p>开始时间:<font color=blue><b>'+record.data.START_TIME+'</b></font> | 结束时间:<font color=blue><b>'+record.data.END_TIME+'</b></font>| 运行时长:<font color=blue><b>'+record.data.DURA+'秒</b> </font></p> ';
                                
                      return 'x-grid3-row-expanded';
            }
            return 'x-grid3-row-collapsed';
          }
         } 
 });
 
 gd_item.on('click',refreshGraph)
 
	// Creates the main containers
 
 
	var mainPanel = new MainPanel(graph, history);
 
  var viewport = new Ext.Viewport(
    {
    	layout:'border',
    	items:
        [ mainPanel,gd_item
        ] // end viewport items
    }); // end of new Viewport
 
    botomBar.add("-");
   
   
  
   var btnreAnaly= new Ext.Button({
      text: '刷新',
     cls:'x-btn-text-icon',
     icon:'../../images/datasyn.gif',
     handler:function(){
       window.location="fieldMap.html?annyType=fieldmap&relaName="+fd_relaName.getValue();         
     }
    });  
    botomBar.add(btnreAnaly);
    botomBar.add("-");
    botomBar.add("<font color=red>选择对象继续:");
  
       
    // Enables scrollbars for the graph container to make it more
    // native looking, this will affect the panning to use the
    // scrollbars rather than moving the container contents inline
   	mainPanel.graphPanel.body.dom.style.overflow = 'auto';
   	
    // FIXME: For some reason the auto value is reset to hidden in
    // Safari on the Mac, this is _probably_ caused by ExtJs
   	if (mxClient.IS_MAC &&
   			mxClient.IS_SF)
	{
   		graph.addListener(mxEvent.SIZE, function(graph)
   		{
   			graph.container.style.overflow = 'auto';
   		});
	}

	// Initializes the graph as the DOM for the panel has now been created	
    graph.init(mainPanel.graphPanel.body.dom);
    graph.setConnectable(true);
    graph.setDropEnabled(true);
    graph.setPanning(true);
    graph.setTooltips(true);
    graph.connectionHandler.setCreateTarget(true);

	// Creates rubberband selection
    var rubberband = new mxRubberband(graph);

	// Adds some example cells into the graph
    var parent = graph.getDefaultParent();

	graph.getModel().beginUpdate();
	//try
	{
	  var contextUrl = window.location['pathname'].split('/')[1];
	  var url = '../../metarela?annyType=PROCRELA&relaName='+relaName+'&annyDirection='+annyDirection+'&level='+level+'&granularity='+granularity+'&outtype=xml&metaprj='+metaprj;
	 var xml=Asiainfo.remoteData(url,false);
	 var doc = mxUtils.parseXml(xml); 
	 var dec = new mxCodec(doc); 
	 dec.decode(doc.documentElement, graph.getModel());
	  
	}
	//finally
	{
		initCellFull();
		// Updates the display
		graph.getModel().endUpdate();
		if (layoutType=='Circle'){
		  // executeLayout(new mxCircleLayout(graph), true);
		  }
		else if (layoutType=='Organic'){
		  var layout = new mxFastOrganicLayout(graph);
		  layout.forceConstant = 80;
		  executeLayout(layout, true);
		}
              else {
	          //executeLayout(new mxHierarchicalLayout(graph,mxConstants.DIRECTION_WEST), true);
	      }
	};
	 graph.click = function(evt, cell) {
        //For display cell properties begin
        if (cell != null) {
            if (cell.isVertex()) {
                var iRow = objStateStore.find('OBJNAME',cell.value);
  	            if(iRow!=-1) {
  		              var sm = gd_item.getSelectionModel();
  		              sm.selectRow(iRow);
  		             gd_item.getView().focusRow(iRow);   

  	            };  
            } 
        }
    };
	graph.dblClick = function(evt, cell)
				{
					this.fireEvent(mxEvent.DOUBLE_CLICK,
						new mxEventObject([evt, cell]));
					 
					if (!mxEvent.isConsumed(evt) && cell != null)
					{ 
					   var objname=cell.value;
					  if(cell.objType=='INTER') objname=objname.substr(4);
					  if( cell.objType=='ZB') objname=objname.substr(3);
					  var contextUrl = window.location['pathname'].split('/')[1];
						var _url="dqmgr/DqRunDetail.html?OBJTYPE="+cell.objType+"&OBJNAME="+objname+"&OPTIME="+CYCLEID;
						Asiainfo.addTabSheet(cell.value+CYCLEID,cell.value+'['+CYCLEID+']运行质量明细',_url);
						
						 
		       }
					 
				};
		    
    // Installs the command history after the initial graph
    // has been created
	var listener = function(sender, evt)
	{
		history.undoableEditHappened(evt.getArgAt(0)/*edit*/);
	};
	
	graph.getModel().addListener(mxEvent.UNDO, listener);
	graph.getView().addListener(mxEvent.UNDO, listener);

	// Toolbar object for updating buttons in listeners
	var toolbarItems = mainPanel.graphPanel.getTopToolbar().items;
		    
    // Updates the states of all buttons that require a selection
    var selectionListener = function()
    {
    	var selected = !graph.isSelectionEmpty();
    	
    	toolbarItems.get('cut').setDisabled(!selected);
    	toolbarItems.get('copy').setDisabled(!selected);
    	toolbarItems.get('delete').setDisabled(!selected);
    	toolbarItems.get('italic').setDisabled(!selected);
    	toolbarItems.get('bold').setDisabled(!selected);
    	toolbarItems.get('underline').setDisabled(!selected);
    	toolbarItems.get('fillcolor').setDisabled(!selected);
    	toolbarItems.get('fontcolor').setDisabled(!selected);
    	toolbarItems.get('linecolor').setDisabled(!selected);
    	toolbarItems.get('align').setDisabled(!selected);
    };
    
    graph.getSelectionModel().addListener(mxEvent.CHANGE, selectionListener);

    // Updates the states of the undo/redo buttons in the toolbar
    var historyListener = function()
    {
    	toolbarItems.get('undo').setDisabled(!history.canUndo());
    	toolbarItems.get('redo').setDisabled(!history.canRedo());
    };

	history.addListener(mxEvent.ADD, historyListener);
	history.addListener(mxEvent.UNDO, historyListener);
	history.addListener(mxEvent.REDO, historyListener);
	
	// Updates the button states once
	selectionListener();
	historyListener();
	
    // Installs outline in outlinePanel
//	var outline = new mxOutline(graph, outlinePanel.body.dom);
	
    
    
    // Overrides createGroupCell to set the group style for new groups to 'group'
    var previousCreateGroupCell = graph.createGroupCell;
    
    graph.createGroupCell = function()
    {
    	var group = previousCreateGroupCell.apply(this, arguments);
    	group.setStyle('group');
    	
    	return group;
    };

    graph.connectionHandler.factoryMethod = function()
    {
		if (GraphEditor.edgeTemplate != null)
		{
    		return graph.cloneCells([GraphEditor.edgeTemplate])[0];
    	}
		
		return null;
    };

    // Uses the selected edge in the library as a template for new edges
    
    // Redirects tooltips to ExtJs tooltips. First a tooltip object
    // is created that will act as the tooltip for all cells.
  	var tooltip = new Ext.ToolTip(
		{
        target: graph.container,
        html: ''
    });
    
    // Disables the built-in event handling
    tooltip.disabled = true;
    
    // Installs the tooltip by overriding the hooks in mxGraph to
    // show and hide the tooltip.
    graph.tooltipHandler.show = function(tip, x, y)
    {
    	if (tip != null &&
    		tip.length > 0)
    	{
    		// Changes the DOM of the tooltip in-place if
    		// it has already been rendered
	    	if (tooltip.body != null)
	    	{
	    		// TODO: Use mxUtils.isNode(tip) and handle as markup,
	    		// problem is dom contains some other markup so the
	    		// innerHTML is not a good place to put the markup
	    		// and this method can also not be applied in
	    		// pre-rendered state (see below)
	    		//tooltip.body.dom.innerHTML = tip.replace(/\n/g, '<br>');
				//tooltip.body.dom.firstChild.nodeValue = tip;
	    	}
	    	
	    	// Changes the html config value if the tooltip
	    	// has not yet been rendered, in which case it
	    	// has no DOM nodes associated
	    	else
	    	{
	    		tooltip.html = tip;
	    	}
	    	
	    	tooltip.showAt([x, y + mxConstants.TOOLTIP_VERTICAL_OFFSET]);
	    }
    };
    
    graph.tooltipHandler.hide = function()
    {
    	tooltip.hide();
    };

    // Updates the document title if the current root changes (drilling)
	var drillHandler = function(sender)
	{
		var model = graph.getModel();
		var cell = graph.getCurrentRoot();
		var title = '';
		
		while (cell != null &&
			  model.getParent(model.getParent(cell)) != null)
		{
			// Append each label of a valid root
			if (graph.isValidRoot(cell))
			{
				title = ' > ' +
				graph.convertValueToString(cell) + title;
			}
			
			cell = graph.getModel().getParent(cell);
		}
		
		document.title = '影响分析' + title;
	};
		
	graph.getView().addListener(mxEvent.DOWN, drillHandler);
	graph.getView().addListener(mxEvent.UP, drillHandler);

	// Keeps the selection in sync with the history
	var undoHandler = function(sender, evt)
	{
		var changes = evt.getArgAt(0).changes;
		graph.setSelectionCells(graph.getSelectionCellsForChanges(changes));
	};
	
	history.addListener(mxEvent.UNDO, undoHandler);
	history.addListener(mxEvent.REDO, undoHandler);

	// Transfer initial focus to graph container for keystroke handling
	graph.container.focus();
	    
    // Handles keystroke events
    var keyHandler = new mxKeyHandler(graph);
    
    // Ignores enter keystroke. Remove this line if you want the
    // enter keystroke to stop editing
    keyHandler.enter = function() {};
    
    keyHandler.bindKey(8, function()
    {
    	graph.foldCells(true);
    });
    
    keyHandler.bindKey(13, function()
    {
    	graph.foldCells(false);
    });
    
    keyHandler.bindKey(33, function()
    {
    	graph.exitGroup();
    });
    
    keyHandler.bindKey(34, function()
    {
    	graph.enterGroup();
    });
    
    keyHandler.bindKey(36, function()
    {
    	graph.home();
    });

    keyHandler.bindKey(35, function()
    {
    	graph.refresh();
    });
    
    keyHandler.bindKey(37, function()
    {
    	graph.selectPreviousCell();
    });
        
    keyHandler.bindKey(38, function()
    {
    	graph.selectParentCell();
    });

    keyHandler.bindKey(39, function()
    {
    	graph.selectNextCell();
    });
    
    keyHandler.bindKey(40, function()
    {
    	graph.selectChildCell();
    });
    
    keyHandler.bindKey(46, function()
    {
    	graph.removeCells();
    });
    
    keyHandler.bindKey(107, function()
    {
    	graph.zoomIn();
    });
    
    keyHandler.bindKey(109, function()
    {
    	graph.zoomOut();
    });
    
    keyHandler.bindKey(113, function()
    {
    	graph.startEditingAtCell();
    });
  
    keyHandler.bindControlKey(65, function()
    {
    	graph.selectAll();
    });

    keyHandler.bindControlKey(89, function()
    {
    	history.redo();
    });
    
    keyHandler.bindControlKey(90, function()
    {
    	history.undo();
    });
    
    keyHandler.bindControlKey(88, function()
    {
    	mxClipboard.cut(graph);
    });
    
    keyHandler.bindControlKey(67, function()
    {
    	mxClipboard.copy(graph);
    });
    
    keyHandler.bindControlKey(86, function()
    {
    	mxClipboard.paste(graph);
    });
    
    keyHandler.bindControlKey(71, function()
    {
    	graph.setSelectionCell(graph.groupCells(null, 20));
    });
    
    keyHandler.bindControlKey(85, function()
    {
    	graph.setSelectionCells(graph.ungroupCells());
    });
}; // end of main

 