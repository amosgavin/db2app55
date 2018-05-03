/*
 * $Id: GraphEditor.js,v 1.37 2009/04/06 15:07:19 gaudenz Exp $
 * Copyright (c) 2008, Gaudenz Alder
 */
GraphEditor = {};
Ext.BLANK_IMAGE_URL = '../ext/resources/images/default/s.gif';
var contextPath = window.location['pathname'].split('/')[1];
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

var annyType = (typeof(paramMap.annyType)!='undefined')?paramMap.annyType:'fieldmap'; 
var relaName = (typeof(paramMap.relaName)!='undefined')?paramMap.relaName:'AcAcct';
var annyDirection = (typeof(paramMap.annyDirection)!='undefined')?paramMap.annyDirection:'All';
var level =(!paramMap.level)?6:paramMap.level; 
var granularity = (typeof(paramMap.granularity)!='undefined')?paramMap.granularity:'0';
var control = (typeof(paramMap.control)!='undefined')?paramMap.control:'2';
var layoutType =(typeof(paramMap.layoutType)!='undefined')?paramMap.layoutType:'Hierarchical'; 
var metaprj=(typeof(paramMap.metaprj)!='undefined')?paramMap.metaprj:'';  
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
function getVertexByValue(vertexArr,value)
				{
					var result=null;
					 
					for (var i=0;i<vertexArr.length;i++)
					{ 
						if (vertexArr[i].value==value)
						{ 
							result=vertexArr[i];
							break;
						}
				  }
				 
				  return result;
				}				
//For add customized properties end
var showDetail = function(objtype,objname){
	var _url="./meta/TableDetail.html?DATANAME="+objname;
	 
	if(objtype=='ZB')_url="./meta/zbInfo.html?ZBCODE="+objname
	else if(objtype=='PROC')_url="./meta/Procframe.html?PROCNAME="+objname
	else if(objtype=='INTER')_url="./meta/interMapDetail.html?FULLINTERCODE="+objname
	Asiainfo.addTabSheet(objname,objname+'['+objtype+']', _url); 
  
  	
};
function main()
{
    Ext.QuickTips.init();

	// Disables browser context menu
	mxEvent.disableContextMenu(document.body);	
	
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
	// Creates the main containers
	var mainPanel = new MainPanel(graph, history);
	var library = new LibraryPanel();

    // Creates the container for the outline
  var ds_item = Asiainfo.getStore("select '' TARGET,'' SOURCE,'' TRANSSQL,TRANSNAME from MD.TRANSMAP where 1=2");  
  
  var rendfun=function(value, p, record){
       return '<img src="../../images/cloud.gif"><b>'+value+'</b>';
    };	 
  var cm = new Ext.grid.ColumnModel([{
           id: 'TARGET',
           header: "路径信息",
           dataIndex: 'TARGET',
           width: 300,
           renderer: rendfun 
        } ]);
  var gd_item= new Ext.grid.GridPanel({
         region:'east', id:'topic-grid',
         collapsible: true,
		     collapseMode:'mini', 
         width:300,
         store: ds_item,
         cm: cm,
         split:true,
         stripeRows:true,
         trackMouseOver:false,
         loadMask: {msg:'Loading Topics...'},
         viewConfig: {forceFit:true,enableRowBody:true,showPreview:true,
             getRowClass : function(record, rowIndex, p, ds){
             if(this.showPreview){
                      p.body = '<p style="word-break:break-all">源:<a href=javascript:alert()>'+record.data.SOURCE+'</a></p>'+
                               '<p>转换脚本:'+record.data.TRANSSQL+'</p>'+
                               '<p>程序:'+record.data.TRANSNAME+'</p>'
                      return 'x-grid3-row-expanded';
            }
            return 'x-grid3-row-collapsed';
          }
         },
       
          bbar: new Ext.PagingToolbar({
             pageSize: 25,
             store: ds_item,
             displayInfo: true,
             displayMsg: 'Displaying topics {0} - {1} of {2}',
             emptyMsg: "No topics to display"
       })
 });
 var refreshGraph=function(){
 	var sm = gd_item.getSelectionModel() ;
 	 if(sm.getSelections().length==0) return; 
 	 var r=sm.getSelections()[0];
 	 var targetField=r.get('TARGET');
 	 
 	 var parent = graph.getDefaultParent();
   var childCount = graph.getModel().getChildCount(parent);
    for (var i = 0; i < childCount; i++) {
       var child = graph.getModel().getChildAt(parent, i);
       if (child.isEdge() && child.getTarget() && child.getTarget().id==targetField) {
       	 graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, '#FF0000',[child]);
       }
       else
       	graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, '#C0C0C0',[child]);
      // graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, '#FF0000',[child]);
       //graph.scrollCellToVisible(child);
       //graph.refresh(child);
       var cChildCount = graph.getModel().getChildCount(child);
       for(var j=0;j<cChildCount;j++){
       	  var cchild = graph.getModel().getChildAt(child, j);
       	  if(cchild==null) continue;
       	  if((child.value+"."+cchild.value)==targetField)
       	    graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#FF0000',[cchild])
       	  else 
       	  	graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#F5FFFA',[cchild]);
       };
    }
 };
 gd_item.on('click',refreshGraph)

  var loadData = function (targetName,targetFieldName){
  	var iRow = ds_item.find('TARGET',targetName+'.'+targetFieldName);
  	 
  	if(iRow!=-1) {
  		var sm = gd_item.getSelectionModel();
  		sm.selectRow(iRow);
  		gd_item.getView().focusRow(iRow);   

  	};  
  	var _sql="select TRANSNAME,seq,TARGETDATANAME,TARGETCOLNAME,SOURCEDATANAME, SOURCECOLNAME,TRANSSQL from md.TRANSMAP"+metaprj+" where TARGETDATANAME='"+targetName+"'"; 
  	var _store=Asiainfo.getStore(_sql);
  	var _source="";_target="";_procname="";_stepsql="";
  	for(var i=0;i<_store.getCount();i++){
  		var _r=_store.getAt(i);
  		var targetfield=_r.get('TARGETDATANAME')+'.'+_r.get('TARGETCOLNAME');
  		var fieldName=_r.get('SOURCEDATANAME')+'.'+_r.get('SOURCECOLNAME');
  		var iRow = ds_item.find('TARGET',targetfield);
  		if(iRow==-1){
  			 itemRec = ds_item.getNewRecord();
  			 itemRec.set('TARGET',targetfield);
  			 itemRec.set('SOURCE',"<a href=javascript:showDetail('DATA','"+_r.get('SOURCEDATANAME')+"')>"+_r.get('SOURCEDATANAME')+'.'+_r.get('SOURCECOLNAME')+"</a>");
  			 var transname=_r.get('TRANSNAME');
  			 if(transname.indexOf('ZB-')!=-1)
  			   transname="<a href=javascript:showDetail('ZB','"+_r.get('TARGETDATANAME')+"')>"+transname+"</a>"
  			 else if(transname.indexOf('IMP-')!=-1)
  			 	 transname="<a href=javascript:showDetail('INTER','"+_r.get('SOURCEDATANAME')+"')>"+transname+"</a>" 
  			 else 
  			 	 transname="<a href=javascript:showDetail('PROC','"+transname+"')>"+transname+"</a>" ;
  			 	 
  			 itemRec.set('TRANSNAME',transname);
  			 itemRec.set('TRANSSQL',_r.get('TRANSSQL'));
  			 ds_item.add(itemRec);
  		}
  		else{
  			 var itemRec=ds_item.getAt(iRow);
  			 var sourc = _r.get('SOURCEDATANAME')+'.'+_r.get('SOURCECOLNAME');
  			 if( itemRec.get('SOURCE').indexOf(sourc)==-1)
  			   itemRec.set('SOURCE',itemRec.get('SOURCE')+";"+"<a href=javascript:showDetail('DATA','"+_r.get('SOURCEDATANAME')+"')>"+sourc+"</a>");
  		};
  	 }
  };
  var loadTransData=function(transName){
  	var _sql="select distinct TARGETDATANAME from md.transmap"+metaprj+" where transname='"+transName+"'";
  	var _store=Asiainfo.getStore(_sql);
  	for(var i=0;i<_store.getCount();i++){
  		var _r=_store.getAt(i);
  		loadData(_r.get('TARGETDATANAME'));
  	};
  }; 
  loadTransData(relaName);
	// Creates the enclosing viewport
    var viewport = new Ext.Viewport(
    {
    	layout:'border',
    	items:
        [ mainPanel,gd_item

       	] // end viewport items
    }); // end of new Viewport
     
    
    botomBar.add("-");
    botomBar.add("<font color=red>选择对象继续:");
    var btnRelaDown= new Ext.Button({
      text: '影响分析',
     cls:'x-btn-text-icon',
     icon:'../../images/datasyn.gif',
     handler:function(){		 
         var parent = graph.getDefaultParent();
         var cells=graph.getSelectionCells();
         if(cells.length==0){alert('请先选择要影响分析的对象'); return;};
         var fieldName="";
         if(cells[0].isEdge() && cells[0].getTarget())
           fieldName=cells[0].getTarget().id
         else{
         	var tabName=cells[0].parent.value;
				  if(!tabName || tabName=='undefined'){alert('请先选择要影响分析的字段'); return;};
				  fieldName = cells[0].id;
				 }; 
				 if(fieldName)
				 Asiainfo.addTabSheet('rela'+fieldName,'字段影响分析'+fieldName, './asiainfo/ProcGraph/rela.html?annyType=FIELD&annyDirection=Down&level=5&relaName='+fieldName);
     }
    });
    var btnRelaUp= new Ext.Button({
      text: '血缘分析',
     cls:'x-btn-text-icon',
     icon:'../../images/datasyn.gif',
     handler:function(){
     		var parent = graph.getDefaultParent();
         var cells=graph.getSelectionCells();
         if(cells.length==0){alert('请先选择要影响分析的对象'); return;};
         var fieldName="";
         if(cells[0].isEdge() && cells[0].getTarget())
           fieldName=cells[0].getTarget().id
         else{
         	var tabName=cells[0].parent.value;
				  if(!tabName || tabName=='undefined'){alert('请先选择要影响分析的字段'); return;};
				  fieldName = cells[0].id;
				 }; 
				 if(fieldName)
				 Asiainfo.addTabSheet('rela'+fieldName,'字段影响分析'+fieldName, './asiainfo/ProcGraph/rela.html?annyType=FIELD&annyDirection=Up&level=5&relaName='+fieldName);
    }
  });
  var btnRelaAll= new Ext.Button({
      text: '过程分析',
     cls:'x-btn-text-icon',
     icon:'../../images/datasyn.gif',
     handler:function(){
         var parent = graph.getDefaultParent();
         var cells=graph.getSelectionCells();
         if(cells.length==0){alert('请先选择要影响分析的对象'); return;};
         var fieldName="";
         if(cells[0].isEdge() && cells[0].getTarget())
           fieldName=cells[0].getTarget().id
         else{
         	var tabName=cells[0].parent.value;
				  if(!tabName || tabName=='undefined'){alert('请先选择要影响分析的字段'); return;};
				  fieldName = cells[0].id;
				 }; 
				 if(fieldName)
				 Asiainfo.addTabSheet('rela'+fieldName,'字段影响分析'+fieldName, './asiainfo/ProcGraph/rela.html?annyType=FIELD&annyDirection=All&level=5&relaName='+fieldName);
    }
  });
    botomBar.add(btnRelaUp);
    botomBar.add(btnRelaDown);
    botomBar.add(btnRelaAll);
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
 
	  var url = '../../metarela?annyType='+annyType+'&relaName='+relaName+'&metaprj='+metaprj+'&annyDirection='+annyDirection+'&level='+level+'&granularity=0&outtype=xml';
	 var xml=Asiainfo.remoteData(url,false);
	 var doc = mxUtils.parseXml(xml); 
	 var dec = new mxCodec(doc); 
	 dec.decode(doc.documentElement, graph.getModel());
	  
	}
	//finally
	{
		// Updates the display
		graph.getModel().endUpdate();
		if (layoutType=='Circle'){
		  // executeLayout(new mxCircleLayout(graph), true);
		  }
		else if (layoutType=='Organic'){
		  var layout = new mxFastOrganicLayout(graph);
		  layout.forceConstant = 80;
		  //executeLayout(layout, true);
		}
              else {
	          //executeLayout(new mxHierarchicalLayout(graph,mxConstants.DIRECTION_WEST), true);
	      }
	};
 
  var showCellDetail=function(cell){
  	if(cell.isEdge()){
						    var model=graph.getModel();
						    var sourFieldCell = cell.getSource();
						    var tarFieldCell =  cell.getTarget();
						    var sourTabCell=model.getParent(sourFieldCell);
						    var tarTabCell=model.getParent(tarFieldCell);
						  ///  win.show();
						    //document.getElementById("mapContent").innerHTML=getHTML(tarTabCell.value+'.'+tarFieldCell.value);
						    loadData(tarTabCell.value,tarFieldCell.value);
						    //sourTabCell.value+'.'+cell.getSource().value+'->'+tarTabCell.value+'.'+tarFieldCell.value;
		};
  };
  graph.click = function(evt, cell){
  	//this.fireEvent(mxEvent.CLICK, new mxEventObject([evt, cell]));
  	if(cell==null) return;
  	 	 
  		if(cell.isEdge()){
						   showCellDetail(cell);
						   refreshGraph();
						   return;
			};
			var model=graph.getModel(); 
			var tarTabCell=model.getParent(cell);
			//if(typeof(tarTabCell) == 'undefined') return;
			if(typeof(tarTabCell.value) == 'undefined') return;
			//if(tarTabCell==null||tarTabCell.value=='undefined') return;
			loadData(tarTabCell.value,cell.value);
  	  refreshGraph()
  };
	graph.dblClick = function(evt, cell)
				{
					this.fireEvent(mxEvent.DOUBLE_CLICK, new mxEventObject([evt, cell]));
					 
					if (!mxEvent.isConsumed(evt) && cell != null)
					{  if(cell.isEdge()){
						   showCellDetail(cell);
						   return;
					   };
						if(cell.stype && cell.style.indexOf('ellipse')!=-1) cell.objType='PROC'
						else cell.objType='DATA';
						//else if(!cell.style) cell.objType='DATA';
						if(!cell.objType || !cell.value) showWin('Obj')  
						else if(cell.objType=='PROC' || cell.objType=='程序' || cell.style=='ellipse')  
						  Asiainfo.addTabSheet(cell.value,'程序:'+cell.value,'./asiainfo/ProcGraph/procGraph.html?PROCNAME='+cell.value);
					        else if(cell.objType=='FLOW' || cell.objType=='流程')
				                 Asiainfo.addTabSheet(cell.value,'流程:'+cell.value,'./asiainfo/ProcGraph/dataFlowGraph.html?FLOWCODE='+cell.value)
				                else if(cell.objType=='DATA' || cell.objType=='表')
				                 Asiainfo.addTabSheet(cell.value,'表:'+cell.value,'./meta/TableDetail.html?DATANAME='+cell.value)
				     
				   
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
    library.getSelectionModel().on('selectionchange', function(sm, node)
    {
    	if (node != null &&
    		node.attributes.cells != null)
    	{
    		var cell = node.attributes.cells[0];
    		
    		if (cell != null &&
    			graph.getModel().isEdge(cell))
    		{
    			GraphEditor.edgeTemplate = cell;
    		}
    	}
    });

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
  };
  
// end of main

function insertSymbolTemplate(panel, graph, name, icon, rhombus)
{
    var imagesNode = panel.symbols;
    var style = (rhombus) ? 'rhombusImage' : 'roundImage';
    return insertVertexTemplate(panel, graph, name, icon, style+';image='+icon, 50, 50, '', imagesNode);
};

function insertImageTemplate(panel, graph, name, icon, round)
{
    var imagesNode = panel.images;
    var style = (round) ? 'roundImage' : 'image';
    return insertVertexTemplate(panel, graph, name, icon, style+';image='+icon, 50, 50, name, imagesNode);
};

function insertVertexTemplate(panel, graph, name, icon, style, width, height, value, parentNode)
{
		var cells = [new mxCell((value != null) ? value : '', new mxGeometry(0, 0, width, height), style)];
		cells[0].vertex = true;
		
		var funct = function(graph, evt, target)
		{
			cells = graph.getImportableCells(cells);
			
			if (cells.length > 0)
			{
				var validDropTarget = (target != null) ?
					graph.isValidDropTarget(target, cells, evt) : false;
				var select = null;
				
				if (target != null &&
					!validDropTarget &&
					graph.getModel().getChildCount(target) == 0 &&
					graph.getModel().isVertex(target) == cells[0].vertex)
				{
					graph.getModel().setStyle(target, style);
					select = [target];
				}
				else
				{
					if (target != null &&
						!validDropTarget)
					{
						target = null;
					}
					
					var pt = graph.getPointForEvent(evt);
					
					// Splits the target edge or inserts into target group
					if (graph.isSplitEnabled() &&
						graph.isSplitTarget(target, cells, evt))
					{
						graph.splitEdge(target, cells, null, pt.x, pt.y);
						select = cells;
					}
					else
					{
						cells = graph.getImportableCells(cells);
						
						if (cells.length > 0)
						{
							select = graph.importCells(cells, pt.x, pt.y, target);
						}
					}
				}
				
				if (select != null &&
					select.length > 0)
				{
					graph.scrollCellToVisible(select[0]);
					graph.setSelectionCells(select);
				}
			}
		};
		
		// Small hack to install the drag listener on the node's DOM element
		// after it has been created. The DOM node does not exist if the parent
		// is not expanded.
		var node = panel.addTemplate(name, icon, parentNode, cells);
		var installDrag = function(expandedNode)
		{
			if (node.ui.elNode != null)
			{
				// Creates the element that is being shown while the drag is in progress
				var dragPreview = document.createElement('div');
				dragPreview.style.border = 'dashed black 1px';
				dragPreview.style.width = width+'px';
				dragPreview.style.height = height+'px';
				
				mxUtils.makeDraggable(node.ui.elNode, graph, funct, dragPreview, 0, 0,
						graph.autoscroll, true);
			}
		};
		
		if (!node.parentNode.isExpanded())
		{
			panel.on('expandnode', installDrag);
		}
		else
		{
			installDrag(node.parentNode);
		}
		
		return node;
};

function insertEdgeTemplate(panel, graph, name, icon, style, width, height, value, parentNode)
{
		var cells = [new mxCell((value != null) ? value : '', new mxGeometry(0, 0, width, height), style)];
		cells[0].geometry.setTerminalPoint(new mxPoint(0, height), true);
		cells[0].geometry.setTerminalPoint(new mxPoint(width, 0), false);
		cells[0].edge = true;
		
		var funct = function(graph, evt, target)
		{
			cells = graph.getImportableCells(cells);
			
			if (cells.length > 0)
			{
				var validDropTarget = (target != null) ?
					graph.isValidDropTarget(target, cells, evt) : false;
				var select = null;
				
				if (target != null &&
					!validDropTarget)
				{
					target = null;
				}
				
				var pt = graph.getPointForEvent(evt);
				var scale = graph.view.scale;
				
				pt.x -= graph.snap(width / 2);
				pt.y -= graph.snap(height / 2);
				
				select = graph.importCells(cells, pt.x, pt.y, target);
				
				// Uses this new cell as a template for all new edges
				GraphEditor.edgeTemplate = select[0];
				
				graph.scrollCellToVisible(select[0]);
				graph.setSelectionCells(select);
			}
		};
		
		// Small hack to install the drag listener on the node's DOM element
		// after it has been created. The DOM node does not exist if the parent
		// is not expanded.
		var node = panel.addTemplate(name, icon, parentNode, cells);
		var installDrag = function(expandedNode)
		{
			if (node.ui.elNode != null)
			{
				// Creates the element that is being shown while the drag is in progress
				var dragPreview = document.createElement('div');
				dragPreview.style.border = 'dashed black 1px';
				dragPreview.style.width = width+'px';
				dragPreview.style.height = height+'px';
				
				mxUtils.makeDraggable(node.ui.elNode, graph, funct, dragPreview, -width / 2, -height / 2,
						graph.autoscroll, true);
			}
		};
		
		if (!node.parentNode.isExpanded())
		{
			panel.on('expandnode', installDrag);
		}
		else
		{
			installDrag(node.parentNode);
		}
		
		return node;
};

// Defines a global functionality for displaying short information messages
Ext.example = function(){
    var msgCt;

    function createBox(t, s){
        return ['<div class="msg">',
                '<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>',
                '<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc"><h3>', t, '</h3>', s, '</div></div></div>',
                '<div class="x-box-bl"><div class="x-box-br"><div class="x-box-bc"></div></div></div>',
                '</div>'].join('');
    }
    return {
        msg : function(title, format){
            if(!msgCt){
                msgCt = Ext.DomHelper.append(document.body, {id:'msg-div'}, true);
            }
            msgCt.alignTo(document, 't-t');
            var s = String.format.apply(String, Array.prototype.slice.call(arguments, 1));
            var m = Ext.DomHelper.append(msgCt, {html:createBox(title, s)}, true);
            m.slideIn('t').pause(1).ghost("t", {remove:true});
        }
    };
}();
