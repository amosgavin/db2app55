 
GraphEditor = {};
Ext.BLANK_IMAGE_URL = '../ext/resources/images/default/s.gif';
//For add customized properties begin
var currentCell=null;
var gUserName=_UserInfo.usercnname;
// Creates the graph and loads the default stylesheet
var graph ;
/////init para ***************************************************************************
    ///1.传入参数处理
  var paramMap={};
  temp = window.location.search; 
  if(temp.length!=0){
	temp = temp.substr(1).split('&');
	for (i=0;i<temp.length;++i){
		f = temp[i].split('=');
		paramMap[f[0]]=f[1];
	 } 
  }
  var APPCODE = paramMap.APPCODE || 'APP-1112008';
  var DBNAME = paramMap.DBNAME; 
  var ATTNAME = '';
  var CYCLEID = paramMap.CYCLEID||(new Date).format('yyyymmdd'); 
  dataManager = new Asiainfo.data.dataManager();
  var METAPRJ=(typeof(paramMap.METAPRJ)!='undefined')?paramMap.METAPRJ:'';
if(METAPRJ) metaStore.transTabname(METAPRJ);


if(!DBNAME) DBNAME='defaultDB';
var schema='';
if(DBNAME=='defaultDB') schema='MD' 
else schema='NWH';
 
  var contextUrl = window.location['pathname'].split('/')[1];
  var contextPath = window.location['pathname'].split('/')[1];
var sourceDB = Asiainfo.readProfile(APPCODE+'_dbSource');
var tracefield;  
var qrycode;
var ds_app = new Asiainfo.data.AsiaInfoJsonStore({
			root:'root',
			sql:"select * from MD.BUSI_APPLIST WHERE APPCODE = '"+APPCODE+"'",
			initUrl:'/'+contextUrl+'/newrecordService',
			url:'/'+contextUrl+'/newrecordService',
			dataSource:DBNAME,
			loadDataWhenInit:true,
			key:'PROC_NAME'
		});

if(ds_app.getCount() > 0){
	var r=ds_app.getAt(0);
	qrycode = r.get('QRYCODE');
	str=r.get('CFGJSON');
  	str = str.substr(4);
  	if(str.length>5){
		 var tmpCfg=Ext.decode(str);
		 tracefield=tmpCfg.tracefield;
	};
}

function main() {
    Ext.QuickTips.init();
    graph = new mxGraph();
    // Disables browser context menu
    mxEvent.disableContextMenu(document.body);

    // Makes the connection are smaller
    mxConstants.DEFAULT_HOTSPOT = 0.3;

    // Creates the command history (undo/redo)
    var history = new mxUndoManager();

    // Loads the default stylesheet into the graph
    var node = mxUtils.load('resources/default-style.xml').getDocumentElement();
    var dec = new mxCodec(node.ownerDocument);
    dec.decode(node, graph.getStylesheet());

    // Sets the style to be used when an elbow edge is double clicked
    graph.alternateEdgeStyle = 'vertical';
    var style = graph.getStylesheet().getDefaultEdgeStyle();

    style[mxConstants.STYLE_EDGE] = mxEdgeStyle.ElbowConnector;
    style[mxConstants.STYLE_ENDARROW] = mxConstants.ARROW_BLOCK;
    style[mxConstants.STYLE_ROUNDED] = true;
    style[mxConstants.STYLE_FONTCOLOR] = 'black';
    style[mxConstants.STYLE_FONTCOLOR] = 'black';
    style[mxConstants.STYLE_STROKECOLOR] = '#00FF00';

   
    // Creates the main containers
    var mainPanel = new MainPanel(graph, history);
 function travel(cell,tracetype){
 	  if(!cell) return;
 	  graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#0101DF',[cell]);
 	  for(var j = 0;j< cell.getEdgeCount();j++){
    	var edge = cell.getEdgeAt(j);
    	if(!edge) break;
    	if(tracetype=='source'){
    	   var source =edge.getSource();
    	   if(source && source!=cell) {
    	    
    	   	travel(source,tracetype);
    	   }
      }
      else if(tracetype=='target'){
    	   var target =edge.getTarget();
    	   if(target && target!=cell){
    	    travel(target,tracetype)
    	  }
      }
    	//if(source!=cell) travel(source);
    	//var target =edge.getTarget(); 
    	//if(target!=cell) travel(target);
    }
 };
 
 var refreshGraph=function(cell){
    	 
 
 	 var parent = graph.getDefaultParent();
   var childCount = graph.getModel().getChildCount(parent);
    for (var i = 0; i < childCount; i++) {
       var child = graph.getModel().getChildAt(parent, i);
       for(var j=0;j<graph.getModel().getChildCount(child);j++){
       	 var cchild = graph.getModel().getChildAt(child, j);
       	 graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#F5FFFA',[cchild])
       }
       
      // if (child.isEdge() ) continue;
       //graph.setSelectionCell(child);
       //graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#0101DF',[child]);
       //graph.scrollCellToVisible(child);
       	  
        //else 
       	//   graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#F5FFFA',[child])
    }
    travel(cell,'source');
    travel(cell,'target');
 };
 
    // Creates the enclosing viewport
    var viewport = new Ext.Viewport({
        layout: 'border',
        items: [  mainPanel]
         
    }); // end of new Viewport

function getXML(url){
	var xml=Asiainfo.remoteData(url,false);
	if (xml != null && xml.length > 0) {
        var doc = mxUtils.parseXml(xml);
        var dec = new mxCodec(doc);
        dec.decode(doc.documentElement, graph.getModel());
    }
}    

var zbNameData='';
var qrydefStore = Asiainfo.getStore("select * from md.busi_qrydef where qrycode = '"+qrycode+"'");
function getAttCNNAME(attcode){
	var idx = qrydefStore.findBy(function(r){
		return r.get('ATTRCODE') == attcode;
	})

	return idx == -1 ? attcode : qrydefStore.getAt(idx).get('ATTNAME');
}

for(var i=0;i<tracefield.length;i++){
	var fieldName;
	fieldName = getAttCNNAME(tracefield[i]);
	zbNameData+="['"+tracefield[i]+"','"+fieldName+"'],";
}



var _date = Ext.decode('['+zbNameData.substr(0,zbNameData.length-1)+']');
botomBar.add('指标类型');
var ds_fd_ZBNAME= new Ext.data.SimpleStore({
 		fields:['ID','VALUE'],
 		data:_date
 	});
 
var fd_ZBNAME = new Ext.form.ComboBox({
	     fieldLabel:'指标类型',
	     id:'ZBNAMETYPE',
	     width:123,
	     height:21,
	     anchor:'97%',
	     mode: 'local',
	     triggerAction:'all',
	     store:ds_fd_ZBNAME,
      	valueField: 'ID',displayField: 'VALUE'
 });
 
 ATTNAME = Asiainfo.readProfile(APPCODE+'_attname') || tracefield[0];
 Ext.getCmp('ZBNAMETYPE').setValue(ATTNAME);

   function refreshLog(){
   	var newZbName = Ext.getCmp('ZBNAMETYPE').getValue();
   	if(newZbName == Asiainfo.readProfile(APPCODE+'_attname')) return false;
   	var newURL = "../../Dsp?cmd=TRACEGRAPH&appcode="+APPCODE+"&attname="+newZbName+"&zbname=count&dbname="+sourceDB;
//   	try{
   		getXML(newURL);
   		Asiainfo.rigisterProfile(APPCODE+'_attname',newZbName);
   		ATTNAME = newZbName;
//   	}finally {
//        // Updates the display
//        graph.getModel().endUpdate();
//    }
   	
}
    botomBar.add(fd_ZBNAME);
    botomBar.add('数据时间');
    var fd_Cycle = new Ext.form.TextField({
	     width:80,
	     height:21,
	     value:CYCLEID	      
    });
    botomBar.add(fd_Cycle);
    var btnRunRefresh= new Ext.Button({
      text: '刷新',
     cls:'x-btn-text-icon',
     icon:'../../images/datasyn.gif',
     handler:function(){
       refreshLog();
     }
    });
    botomBar.add(btnRunRefresh); 
    // Enables scrollbars for the graph container to make it more
    // native looking, this will affect the panning to use the
    // scrollbars rather than moving the container contents inline
    mainPanel.graphPanel.body.dom.style.overflow = 'auto';

    // FIXME: For some reason the auto value is reset to hidden in
    // Safari on the Mac, this is _probably_ caused by ExtJs
    if (mxClient.IS_MAC && mxClient.IS_SF) {
        graph.addListener(mxEvent.SIZE,
        function(graph) {
            graph.container.style.overflow = 'auto';
        });
    }

    // Initializes the graph as the DOM for the panel has now been created	
    graph.init(mainPanel.graphPanel.body.dom);
    graph.setConnectable(true);
    graph.setDropEnabled(true);
    graph.setPanning(true);
    graph.setTooltips(false);
    graph.connectionHandler.setCreateTarget(true);

    // Creates rubberband selection
    var rubberband = new mxRubberband(graph);

    // Adds some example cells into the graph
    var parent = graph.getDefaultParent();
    graph.getModel().beginUpdate();
    try {
    	var url="../../Dsp?cmd=TRACEGRAPH&appcode="+APPCODE+"&attname="+ATTNAME+"&zbname=count&dbname="+sourceDB;
		getXML(url);
        // alert("Load success");
		Asiainfo.rigisterProfile(APPCODE+'_attname',ATTNAME);
    } finally {
        // Updates the display
        graph.getModel().endUpdate();
         
    }

    // Installs the command history after the initial graph
    graph.click = function(evt, cell) {
        //For display cell properties begin
        currentCell = cell;
        if(cell==null) return;
        if (cell.isVertex()) {
                refreshGraph(cell); 
            } 
        else {
                 
        };
    };
 
    function showWin(objtype){
    	alert(objtype);
    };
            
    graph.dblClick = function(evt, cell) {
    	//alert("cell:"+cell.value+"\nsource:"+cell.source.value+"\nsource.parent:"+cell.source.parent.value+"\ntarget:"+cell.target.value+"\ntarget.parent:"+cell.target.parent.value);
        this.fireEvent(mxEvent.DOUBLE_CLICK, new mxEventObject([evt, cell]));
 
        if (!mxEvent.isConsumed(evt) && cell != null) {
            if (cell.isVertex()) showWin('Step');
            else {  
            	
            	var cnattname = getAttCNNAME(ATTNAME);
            	
            	var sourcepos = cell.source.parent.value.toString().substr(4,2)
            	var preColumn = ATTNAME+"_"+sourcepos;
            	var preCnCol = cnattname+"_"+sourcepos;
		        var preColumnValue = cell.source.value;
		        preColumnValue = preColumnValue.substr(0,preColumnValue.lastIndexOf('['));
		        
		        var targetpos = cell.target.parent.value.toString().substr(4,2)
		        var aftColumn = ATTNAME+"_"+targetpos;
		        var aftCnCol = cnattname+"_"+targetpos;
		        var aftColumnValue = cell.target.value;
		        aftColumnValue = aftColumnValue.substr(0,aftColumnValue.lastIndexOf('['));
							
				url = '../../busiapp/busiTraceDetail.html?';
				url += 'QRYCODE='+qrycode;
				url += '&preCnCol='+preCnCol;
				url += '&preColumn='+preColumn;
				url += '&preColumnValue='+preColumnValue;
				url += '&aftColumn='+aftColumn;
				url += '&aftCnCol='+aftCnCol;
				url += '&aftColumnValue='+aftColumnValue;
				url += '&DBNAME='+sourceDB;
				url += '&APPCODE='+APPCODE;
				url += '&tracefield='+tracefield;
				
				window.open(url);
            };
        }
    };
    // has been created
    var listener = function(sender, evt) {
        history.undoableEditHappened(evt.getArgAt(0)
        /*edit*/
        );
    };

    graph.getModel().addListener(mxEvent.UNDO, listener);
    graph.getView().addListener(mxEvent.UNDO, listener);

    // Toolbar object for updating buttons in listeners
    var toolbarItems = mainPanel.graphPanel.getTopToolbar().items;

    // Updates the states of all buttons that require a selection
    var selectionListener = function() {
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
    var historyListener = function() {
        toolbarItems.get('undo').setDisabled(!history.canUndo());
        toolbarItems.get('redo').setDisabled(!history.canRedo());
    };

    history.addListener(mxEvent.ADD, historyListener);
    history.addListener(mxEvent.UNDO, historyListener);
    history.addListener(mxEvent.REDO, historyListener);

    // Updates the button states once
    selectionListener();
    historyListener();

    

    // Overrides createGroupCell to set the group style for new groups to 'group'
    var previousCreateGroupCell = graph.createGroupCell;

    graph.createGroupCell = function() {
        var group = previousCreateGroupCell.apply(this, arguments);
        group.setStyle('group');

        return group;
    };

    graph.connectionHandler.factoryMethod = function() {
        if (GraphEditor.edgeTemplate != null) {
            return graph.cloneCells([GraphEditor.edgeTemplate])[0];
        }

        return null;
    };

    // Uses the selected edge in the library as a template for new edges
    

    // Redirects tooltips to ExtJs tooltips. First a tooltip object
    // is created that will act as the tooltip for all cells.
    var tooltip = new Ext.ToolTip({
        target: graph.container,
        html: ''
    });

    // Disables the built-in event handling
    tooltip.disabled = true;

    // Installs the tooltip by overriding the hooks in mxGraph to
    // show and hide the tooltip.
    graph.tooltipHandler.show = function(tip, x, y) {
        if (tip != null && tip.length > 0) {
            // Changes the DOM of the tooltip in-place if
            // it has already been rendered
            if (tooltip.body != null) {
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
            else {
                tooltip.html = tip;
            }

            tooltip.showAt([x, y + mxConstants.TOOLTIP_VERTICAL_OFFSET]);
        }
    };

    graph.tooltipHandler.hide = function() {
        tooltip.hide();
    };

    // Updates the document title if the current root changes (drilling)
    var drillHandler = function(sender) {
        var model = graph.getModel();
        var cell = graph.getCurrentRoot();
        var title = '';

        while (cell != null && model.getParent(model.getParent(cell)) != null) {
            // Append each label of a valid root
            if (graph.isValidRoot(cell)) {
                title = ' > ' + graph.convertValueToString(cell) + title;
            }

            cell = graph.getModel().getParent(cell);
        }

        document.title = 'Graph Editor' + title;
    };

    graph.getView().addListener(mxEvent.DOWN, drillHandler);
    graph.getView().addListener(mxEvent.UP, drillHandler);

    // Keeps the selection in sync with the history
    var undoHandler = function(sender, evt) {
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
}; // end of main

 