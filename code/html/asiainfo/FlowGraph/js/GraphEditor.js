/*
 * $Id: GraphEditor.js,v 1.37 2009/04/06 15:07:19 gaudenz Exp $
 * Copyright (c) 2008, Gaudenz Alder
 */
GraphEditor = {};
//For add customized properties begin
var currentCell=null;
 var fd_9 = new Ext.form.TextField({
	     fieldLabel:'编号',
	     name:'NODEID',
	     width:110,
	     height:20,
       allowBlank:false,
       disabled:true
});
var fd_10 = new Ext.form.TextField({
	     fieldLabel:'名称',
	     name:'NODENAME',
	     width:110,
	     height:20,
   allowBlank:false
});
var fd_11 = new Ext.form.TextField({
	     fieldLabel:'负责人',
	     name:'OWNER',
	     width:110,
	     height:20,
       allowBlank:false

});
//For add customized properties end

function main()
{
    Ext.QuickTips.init();

	// Disables browser context menu
	mxEvent.disableContextMenu(document.body);	
	
	// Makes the connection are smaller
	mxConstants.DEFAULT_HOTSPOT = 0.3;
    
	// Creates the graph and loads the default stylesheet
    var graph = new mxGraph();
    
    // Creates the command history (undo/redo)
    var history = new mxUndoManager();

    // Loads the default stylesheet into the graph
    var node = mxUtils.load('resources/default-style.xml').getDocumentElement();
		var dec = new mxCodec(node.ownerDocument);
		dec.decode(node, graph.getStylesheet());
	
	// Sets the style to be used when an elbow edge is double clicked
	graph.alternateEdgeStyle = 'vertical';
	//For add blur event  begin
   fd_10.on('blur', function(e){
      if (graph.getSelectionCells().length==1)
      {
      	currentCell.setValue(e.getValue());
      	graph.refresh(currentCell);
      }
           
		  else
		  	   alert('请选择一个节点！');
    });	
  

	fd_11.on('blur', function(e){
      if (graph.getSelectionCells().length==1)
      {           
           currentCell.setOwner(e.getValue());
      	   graph.refresh(currentCell);
       }
		  else
		  	   alert('请选择一个节点！');
    });
    //For add blur event end
    
	
	// Creates the main containers
	var mainPanel = new MainPanel(graph, history);
	var library = new LibraryPanel();

    // Creates the container for the outline
	var outlinePanel = new Ext.Panel(
	{
		id:'outlinePanel',
		layout: 'fit',
		split: true,
		height: 200,
        region:'south'
    });
	function getFlowCode()
	{
		//get flowcode from url
	    var flowcode='';
    	var Pstr = window.location.search; 
        var flowcode;
	          if (Pstr!=null && Pstr!='')
	          {
	          	 Pstr=Pstr.substring(1);
	          	 var p=Pstr.split('&');
	          	 var temp='FLOWCODE='
	          	 for (var i=0;i<p.length;i++)
	          	 {
	          	 	p[i]=p[i].toUpperCase().trim();
	          	 	if (p[i].substring(0,temp.length)==temp)
	          	 	{
	          	 		flowcode=p[i].replace(temp,'');
	          	 	}
	          	 }
	          }
	    return flowcode;
	}
  var schema='MD';
  var btnSaveNode= new Ext.Button({
     text: 'save',
     handler:function(){
     	        var flowcode=getFlowCode();
							var enc = new mxCodec(mxUtils.createXmlDocument());
							var parent = graph.getDefaultParent();
							var childCount=graph.getModel().getChildCount(parent);
							var node = enc.encode(graph.getModel());
							var contextUrl = window.location['pathname'].split('/')[1];
							//delete from table FLOWXML
							var store = new Asiainfo.data.AsiaInfoJsonStore({
								table:schema+'.FLOWXML',
								root:'root',
								sql:'select FLOWCODE,XML from '+schema+'.FLOWXML',
								initUrl:'/'+contextUrl+'/newrecordService',
								url:'/'+contextUrl+'/newrecordService',
								key:'FLOWCODE'
							});	
							var rec = store.newRecord();
							rec.set('FLOWCODE',flowcode);
							store.remove(rec);
							store.commit();	
							//delete from table DEVWKFLOW_STATE
              store = new Asiainfo.data.AsiaInfoJsonStore({
								table:schema+'.DEVWKFLOW_STATE',
								root:'root',
								sql:'select FLOWCODE,STATE,STATENAME,DUTYER from '+schema+'.DEVWKFLOW_STATE',
								initUrl:'/'+contextUrl+'/newrecordService',
								url:'/'+contextUrl+'/newrecordService',
								key:'FLOWCODE'
							});	
							var rec = store.newRecord();
							rec.set('FLOWCODE',flowcode);
							store.remove(rec);
							store.commit();							
							//delete from table DEVWKFLOW_ACT
							store = new Asiainfo.data.AsiaInfoJsonStore({
								table:schema+'.DEVWKFLOW_ACT',
								root:'root',
								sql:'select FLOWCODE,ACT,ACTNAME,ACTOWNER,STATE,STATENAME,AFTSTATE,AFTSTATENAME from '+schema+'.DEVWKFLOW_ACT',
								initUrl:'/'+contextUrl+'/newrecordService',
								url:'/'+contextUrl+'/newrecordService',
								key:'FLOWCODE'
							});	
							var rec = store.newRecord();
							rec.set('FLOWCODE',flowcode);
							store.remove(rec);
							store.commit();
							//insert into table  DEVWKFLOW_STATE						
							store = new Asiainfo.data.AsiaInfoJsonStore({
								table:schema+'.DEVWKFLOW_STATE',
								root:'root',
								sql:'select FLOWCODE,STATE,STATENAME,DUTYER from '+schema+'.DEVWKFLOW_STATE',
								initUrl:'/'+contextUrl+'/newrecordService',
								url:'/'+contextUrl+'/newrecordService',
								key:'FLOWCODE'
							});	
							for (var i=0;i<childCount;i++)
							{
								var child=graph.getModel().getChildAt(parent,i);
								if (child.isVertex())
								{
								rec = store.newRecord();
							  rec.set('FLOWCODE',flowcode);
							  rec.set('STATE',child.getId());
							  rec.set('STATENAME',child.getValue());
							  rec.set('DUTYER',child.getOwner()==null?'':child.getOwner());
								store.add(rec);	
								}
               
							}
							store.commit();
							//insert into table  DEVWKFLOW_ACT						
							store = new Asiainfo.data.AsiaInfoJsonStore({
								table:schema+'.DEVWKFLOW_ACT',
								root:'root',
								sql:'select FLOWCODE,ACT,ACTNAME,ACTOWNER,STATE,STATENAME,AFTSTATE,AFTSTATENAME from '+schema+'.DEVWKFLOW_ACT',
								initUrl:'/'+contextUrl+'/newrecordService',
								url:'/'+contextUrl+'/newrecordService',
								key:'FLOWCODE'
							});	
							for (var i=0;i<childCount;i++)
							{
								var child=graph.getModel().getChildAt(parent,i);
								if (child.isEdge())
								{
								rec = store.newRecord();
							  rec.set('FLOWCODE',flowcode);
							  rec.set('ACT',child.getId());
							  rec.set('ACTNAME',child.getValue());
							  rec.set('ACTOWNER',child.getOwner()==null?'':child.getOwner());
							  rec.set('STATE',child.source==null?'':child.source.getId());
							  rec.set('STATENAME',child.source==null?'':child.source.getValue());
							  rec.set('AFTSTATE',child.target==null?'':child.target.getId());
							  rec.set('AFTSTATENAME',child.target==null?'':child.target.getValue());
							  //alert(child.source==null?'':child.source.getId());
								store.add(rec);	
								}
               
							}
							store.commit();
							//insert into table  FLOWXML						
							store = new Asiainfo.data.AsiaInfoJsonStore({
								table:schema+'.FLOWXML',
								root:'root',
								sql:'select FLOWCODE,XML from '+schema+'.FLOWXML',
								initUrl:'/'+contextUrl+'/newrecordService',
								url:'/'+contextUrl+'/newrecordService',
								key:'FLOWCODE'
							});	
							rec = store.newRecord();
							rec.set('FLOWCODE',flowcode);
							rec.set('XML',mxUtils.getPrettyXml(node));
							store.add(rec);
							store.commit();
							
							
			        alert("Save success");
            }
          });
	// Creates the enclosing viewport

 

    var viewport = new Ext.Viewport(
    {
    	layout:'border',
    	items:
        [{
	        xtype: 'panel',
	       	margins:'5 5 5 5',
	        region: 'center',
	        layout: 'border',
	        border: false,
        	items:
        	[
	            new Ext.Panel(
	            {
	            	title: 'Library',
			        region:'west',
			        layout:'border',
			        split:true,
			        width: 180,
			        collapsible: true,
			        border: false,
			        items:
			        [
			         	library,
			        	outlinePanel
					]
		    	}),
	        	mainPanel,
	        	new Ext.FormPanel(
	        	{
	        		title: 'Detail',
			        region:'east',
			        split:true,
			        width: 220,
			        collapsible: true,
			        items :[fd_9,fd_10,fd_11],
			        buttons:[btnSaveNode]
	        	})
        	]
       	  } // end master panel
       	] // end viewport items
    }); // end of new Viewport

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
	try
	{
//		var v1 = graph.insertVertex(parent, null, 'Hello,', 20, 20, 80, 40);
//		var v2 = graph.insertVertex(parent, null, 'World!', 200, 150, 80, 40);
//		var e1 = graph.insertEdge(parent, null, 'Hello, World!', v1, v2);
		//v1.id='kkk';
		//v1.btn=btnSaveNode;
		//alert(v1.id);
		//v1.addListener(mxEvent.DOUBLE_CLICK, function(sender, evt){alert('kkk')});
		
		
		var contextUrl = window.location['pathname'].split('/')[1];
		var flowcode=getFlowCode();
		var store = new Asiainfo.data.AsiaInfoJsonStore({
			table:schema+'.FLOWXML',
			root:'root',
			sql:"select FLOWCODE,XML from "+schema+".FLOWXML where FLOWCODE='"+flowcode+"'",
			initUrl:'/'+contextUrl+'/newrecordService',
			url:'/'+contextUrl+'/newrecordService',
			key:'FLOWCODE'
		});
	 store.select(); 
	 if (store.getCount()!=0)
	 {
	 	var record = store.getAt(0);
	 	var xml =record.get("XML");
		if (xml != null && xml.length > 0)
		{
			var doc = mxUtils.parseXml(xml); 
			var dec = new mxCodec(doc); 
			dec.decode(doc.documentElement, graph.getModel());
		}
	 }
	 alert("Load success");
	}
	finally
	{
		// Updates the display
		graph.getModel().endUpdate();
	}
		    
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
    	//alert('kkk');
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
	var outline = new mxOutline(graph, outlinePanel.body.dom);
	
    // Adds the entries into the library
    insertVertexTemplate(library, graph, 'Container', 'images/swimlane.gif', 'swimlane', 200, 200, 'Container');
    insertVertexTemplate(library, graph, 'Rectangle', 'images/rectangle.gif', null, 100, 40);
    insertVertexTemplate(library, graph, 'Rounded Rectangle', 'images/rounded.gif', 'rounded=1', 100, 40);
    insertVertexTemplate(library, graph, 'Ellipse', 'images/ellipse.gif', 'ellipse', 60, 60);
    insertVertexTemplate(library, graph, 'Double Ellipse', 'images/doubleellipse.gif', 'ellipse;shape=doubleEllipse', 60, 60);
    insertVertexTemplate(library, graph, 'Triangle', 'images/triangle.gif', 'triangle', 40, 60);
    insertVertexTemplate(library, graph, 'Rhombus', 'images/rhombus.gif', 'rhombus', 60, 60);
	insertVertexTemplate(library, graph, 'Horizontal Line', 'images/hline.gif', 'line', 120, 10);
    insertVertexTemplate(library, graph, 'Hexagon', 'images/hexagon.gif', 'shape=hexagon', 80, 60);
    insertVertexTemplate(library, graph, 'Cylinder', 'images/cylinder.gif', 'shape=cylinder', 60, 80);
    insertVertexTemplate(library, graph, 'Actor', 'images/actor.gif', 'shape=actor', 40, 60);
    insertVertexTemplate(library, graph, 'Cloud', 'images/cloud.gif', 'ellipse;shape=cloud', 80, 60);

    insertImageTemplate(library, graph, 'Bell', 'images/bell.png', false);
    insertImageTemplate(library, graph, 'Box', 'images/box.png', false);
    insertImageTemplate(library, graph, 'Cube', 'images/cube_green.png', false);
    insertImageTemplate(library, graph, 'User', 'images/dude3.png', true);
    insertImageTemplate(library, graph, 'Earth', 'images/earth.png', true);
    insertImageTemplate(library, graph, 'Gear', 'images/gear.png', true);
    insertImageTemplate(library, graph, 'Home', 'images/house.png', false);
    insertImageTemplate(library, graph, 'Package', 'images/package.png', false);
    insertImageTemplate(library, graph, 'Printer', 'images/printer.png', false);
    insertImageTemplate(library, graph, 'Server', 'images/server.png', false);
    insertImageTemplate(library, graph, 'Workplace', 'images/workplace.png', false);
    insertImageTemplate(library, graph, 'Wrench', 'images/wrench.png', true);

    insertSymbolTemplate(library, graph, 'Cancel', 'images/symbols/cancel_end.png', false);
    insertSymbolTemplate(library, graph, 'Error', 'images/symbols/error.png', false);
    insertSymbolTemplate(library, graph, 'Event', 'images/symbols/event.png', false);
    insertSymbolTemplate(library, graph, 'Fork', 'images/symbols/fork.png', true);
    insertSymbolTemplate(library, graph, 'Inclusive', 'images/symbols/inclusive.png', true);
    insertSymbolTemplate(library, graph, 'Link', 'images/symbols/link.png', false);
    insertSymbolTemplate(library, graph, 'Merge', 'images/symbols/merge.png', true);
    insertSymbolTemplate(library, graph, 'Message', 'images/symbols/message.png', false);
    insertSymbolTemplate(library, graph, 'Multiple', 'images/symbols/multiple.png', false);
    insertSymbolTemplate(library, graph, 'Rule', 'images/symbols/rule.png', false);
    insertSymbolTemplate(library, graph, 'Terminate', 'images/symbols/terminate.png', false);
    insertSymbolTemplate(library, graph, 'Timer', 'images/symbols/timer.png', false);

	insertEdgeTemplate(library, graph, 'Straight', 'images/straight.gif', 'straight', 100, 100);
	insertEdgeTemplate(library, graph, 'Horizontal Connector', 'images/connect.gif', null, 100, 100);
    insertEdgeTemplate(library, graph, 'Vertical Connector', 'images/vertical.gif', 'vertical', 100, 100);
    insertEdgeTemplate(library, graph, 'Entity Relation', 'images/entity.gif', 'entity', 100, 100);
	insertEdgeTemplate(library, graph, 'Arrow', 'images/arrow.gif', 'arrow', 100, 100);
    
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
				tooltip.body.dom.firstChild.nodeValue = tip;
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
		
		document.title = 'Graph Editor' + title;
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
