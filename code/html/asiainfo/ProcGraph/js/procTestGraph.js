 
GraphEditor = {};
Ext.BLANK_IMAGE_URL = '../ext/resources/images/default/s.gif';
//For add customized properties begin
var currentCell=null;
var gUserName=_UserInfo.usercnname;
// Creates the graph and loads the default stylesheet
var contextPath = window.location['pathname'].split('/')[1];
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
  var procName = paramMap.PROCNAME;
  var DBNAME = paramMap.DBNAME; 
  var CYCLEID = paramMap.CYCLEID||(new Date).format('yyyymmdd'); 
  var METAPRJ=(typeof(paramMap.METAPRJ)!='undefined')?paramMap.METAPRJ:'';
if(METAPRJ) metaStore.transTabname(METAPRJ);

if(!DBNAME) DBNAME='defaultDB';
var schema='';
if(DBNAME=='defaultDB') schema='MD' 
else schema='NWH';
 
  var contextUrl = window.location['pathname'].split('/')[1];
  var contextPath = window.location['pathname'].split('/')[1];
 
var fd_stepseq = new Ext.form.TextField({
    fieldLabel:'步骤编号',
    name:'StepId',
    width:110,
    height:20,
    disabled:false,
    
 allowBlank:false
});
var ds_db= new Asiainfo.data.AsiaInfoJsonStore({
     sql:"select DBNAME ID, CNNAME VALUE  from MD.METADBCFG",
     root:'root',loadDataWhenInit : true,
     initUrl:'/'+contextUrl+'/newrecordService',
     url:'/'+contextUrl+'/newrecordService' });
var fd_stepdb = new Ext.form.ComboBox({
	     fieldLabel:'数据库',
	     name:'dbname',
	     height:21,
	     anchor:'97%',
             labelStyle: "text-align: right",
	     mode: 'local',
	     
             triggerAction:'all',
             store:ds_db,
             valueField: 'ID',displayField: 'VALUE' 
 });
 
var ds_fd_stepfunc= new Asiainfo.data.AsiaInfoJsonStore({
     //sql:'',
     //select FUNC_ID ID, FUNC_NAME ,MEMO VALUE  from MD.PROC_FUNC WHERE FUNC_ID<1000 order by FUNC_ID
     sql: 'select FUNC_ID ID, FUNC_NAME , REMARK VALUE  from MD.PROC_FUNC_DEF order by FUNC_ID',
     root:'root',
     initUrl:'/'+contextUrl+'/newrecordService',
     url:'/'+contextUrl+'/newrecordService',
     loadDataWhenInit:true });
  var ds_fd_GLOBAL= new Asiainfo.data.AsiaInfoJsonStore({
     sql:'select VAR_NAME ID, VAR_TYPE, SQL_DEF, DLL_DEF, SHELL_NAME, MEMO VALUE from MD.GLOBAL_VAL order by id',
     root:'root',
     initUrl:'/'+contextUrl+'/newrecordService',
     url:'/'+contextUrl+'/newrecordService',
     loadDataWhenInit:true });
     
     var GLOBAL_PARM = "";
      if (ds_fd_GLOBAL.getCount()>0){
 	 //var counti = 0 ;
   for (var i=0;i<ds_fd_GLOBAL.getCount();i++){
   	  //counti ++ ;
   	   var r = ds_fd_GLOBAL.getAt(i);
   	   GLOBAL_PARM += (r.get('ID')+'('+ r.get('VALUE') +');    ') ;
   	   if ( (i+1) % 3 ==0 )
   	       GLOBAL_PARM += '\n' ;
   }	
 }
var fd_stepfunc = new Ext.form.ComboBox({
    fieldLabel:'调用函数',
    name:'Fn',
    width:310,
    height:20,
    anchor:'97%',
    //labelStyle: "text-align: right",
    mode: 'remote',
    triggerAction:'all',
    store:ds_fd_stepfunc,
 	  valueField: 'ID',displayField: 'VALUE',
    allowBlank:false,
    listeners:{select:function(){
    	for(var i=0;i<ds_fd_stepfunc.getCount();i++){
    		if(this.value==ds_fd_stepfunc.getAt(i).get('ID')){
    			fd_stepfunpara.setValue(ds_fd_stepfunc.getAt(i).get('FUNC_NAME'));
    			fd_stepname.setValue(ds_fd_stepfunc.getAt(i).get('VALUE'));
    		}
    	}
    }
  }
});
var fd_stepfunpara = new Ext.form.TextField({
    fieldLabel:'参数格式',
    name:'stepfun',
    width:310,
    height:20,
    anchor:'97%',
    disabled:true,
    //labelStyle: "text-align: right",
   allowBlank:false
});
var fd_stepname = new Ext.form.TextField({
    fieldLabel:'步骤名称',
    name:'StepName',
    width:310,
    height:20,
    anchor:'97%',
    //labelStyle: "text-align: right",
 allowBlank:false
});
 
var fd_stepscript = new Ext.form.TextArea({
    fieldLabel:'脚本/参数',
    name:'Script',
    width:310,
    height:260,
    anchor:'97%',
    //hideLabel: true, 
    allowBlank:false
});
var fd_steppara = new Ext.form.TextArea({
    fieldLabel:'全局变量',
    name:'Script',
    width:310,
    height:60,
    anchor:'97%',
    //value:'&TASK_ID(日批次);&MTASK_ID(月批次号);&DTASK_ID(每月1号);&INDEXSPACE(索引空间);&LDTASK_ID(每月最后一天);&NDTASK_ID(下月1号);&NTASK_ID(下月批次号);&OP_DATE(当前批次对应的日期);&P2DTASK_ID(日批次对应前2天);&PDTASK_ID(日批次对应前一天);&PPTASK_ID(上上月批次号);&PTASK_ID(上月批次号);&SCHEMA(当前模式名);&TABSPACE(表空间参数);',
    value: (GLOBAL_PARM == ""?"":GLOBAL_PARM),
    //hideLabel: true, 
    allowBlank:false
});
var ds_fd_linetype= new Ext.data.SimpleStore({
 		fields:['ID','VALUE'],
 		data:[['0','成功时'],['1','失败时'],['2','完成时']]
 	});

var fd_linetype = new Ext.form.ComboBox({
    fieldLabel:'连线类型',
    name:'LinkType',
    width:110,
    height:20,
    //labelStyle: "text-align: right",
    mode: 'local',
 triggerAction:'all',
 store:ds_fd_linetype,
 	valueField: 'ID',displayField: 'VALUE',
 allowBlank:false,
 editable:false
});
var fd_linename = new Ext.form.TextField({
    fieldLabel:'连线名称',
    name:'LinkName',
    width:110,
    height:20,
    //labelStyle: "text-align: right",
 allowBlank:false
});
var fd_lineseq = new Ext.form.TextField({
    fieldLabel:'连线编号',
    name:'LinkId',
    width:110,
    height:20,
   // labelStyle: "text-align: right",
    disabled:true,
   allowBlank:false
});

var fd_help = new Ext.form.Label({id:'steplabel',name:'steplabel',html:'<a href="javascript:alert(\'显示帮助信息\')">帮助</a>'});
 
var f_stepinfo = new Ext.form.FormPanel({width:'90%',style : 'height: 90%;',layout: 'form', 
   items:[{layout:'column', border:false,
            items:[{columnWidth:.35,layout: 'form', border:false, items: [fd_stepseq]},
                   {columnWidth:.35,layout: 'form', border:false, items: [fd_stepdb]},
                   {columnWidth:.30,layout: 'form', border:false, items: [fd_help]}
                  ]
         },
         fd_stepfunc,fd_stepfunpara,fd_stepname,fd_stepscript,fd_steppara]
});
var f_linefo = new Ext.form.FormPanel({width:'90%',style : 'height: 90%;',layout: 'form', 
	   items:[fd_lineseq,fd_linename,fd_linetype]
	});
	
 
 
 
var win = new Ext.Window({   
        title: "步骤信息",    
        width: 800,
        height:500,
        minWidth: 300,
        minHeight: 300,
        layout: 'fit',
        modal: true,
        closable:false,
        bodyStyle:'padding:1px;',
        buttonAlign:'center',
             items: [f_stepinfo],   
             buttons: [{   
                text: "确定", 
                handler: this.onOKSave,   
                scope: this  
            }, {   
                text: "退出",   
                handler: this.closeWin,   
                scope: this  
            }]   
  }); 
function onOKSave(){
 
	if(!graph) {this.win.hide(); return;}
 
	if (graph.getSelectionCells().length==0){this.win.hide(); return;}
	 
	if (graph.getSelectionCells().length==1){
	      currentCell.setId(fd_stepseq.getValue());
	      currentCell.setobjType(fd_stepdb.getValue());
	      currentCell.setFn(fd_stepfunc.getValue());
	      currentCell.setValue(fd_stepname.getValue());	    
	      currentCell.setScript(fd_stepscript.getValue());
	      graph.refresh(currentCell);
	   } 
	  
	 this.win.hide();      
};    
function closeWin(){   
        if (this.win)    
            this.win.hide();   
        //this.win = null;   
        //this.fp = null;   
        
    };
/////////////////连线窗口设置
var LineWin = new Ext.Window({   
        title: "信息",    
        width: 300,
        height:200,
        minWidth: 200,
        minHeight: 100,
        layout: 'fit',
        plain:true,
        modal: true,
        closable:false,
        bodyStyle:'padding:1px;',
        buttonAlign:'center',
             items: [f_linefo],   
             buttons: [{   
                text: "确定", 
                handler: this.onLineOKSave,   
                scope: this  
            }, {   
                text: "退出",   
                handler: this.closeLineWin,   
                scope: this  
            }]   
  }); 
function onLineOKSave(){
 
	if(!graph) {this.LineWin.hide(); return;}
 
	if (graph.getSelectionCells().length==0){this.LineWin.hide(); return;}
	 
	if (graph.getSelectionCells().length==1){
	      currentCell.setLinkType(fd_linetype.getValue());
	      if (fd_linetype.getValue()==0) 
	      	{
	      		graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, '#00FF00');
	      		fd_linename.setValue('成功时');
	      		currentCell.setValue('成功时');
	      	}
	      else if (fd_linetype.getValue()==1) 
	      	{
	      		graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, '#FF0000',[currentCell]);
	      		fd_linename.setValue('失败时');
	      		currentCell.setValue('失败时');
	      	}
	      else if (fd_linetype.getValue()==2)
	      	{
	      		 graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, '#000000');
	      		 fd_linename.setValue('完成时');
	      		 currentCell.setValue('完成时');
	      	};
	      currentCell.setValue(fd_linename.getValue());
	      graph.refresh(currentCell);
	   } 
	  
	 this.LineWin.hide();      
};    
function closeLineWin(){   
        if (this.LineWin)    
            this.LineWin.hide();   
 };
function showWin(formtype){ //createForm()需要在继承时提供，该方法作用是创建表单   
        if(formtype=='Step'){
        	for(var i=0;i<ds_fd_stepfunc.getCount();i++){
    		if(fd_stepfunc.getValue()==ds_fd_stepfunc.getAt(i).get('ID')){
    			fd_stepfunpara.setValue(ds_fd_stepfunc.getAt(i).get('FUNC_NAME'));
    		  }
    	  }
        	this.win.show();
        }
        else if(formtype=='Line') this.LineWin.show();   
    }; 
 var proctabname = metaStore['PROC'].runtabname;
 if(DBNAME=='METADB' || DBNAME=='defaultDB')  proctabname =metaStore['PROC'].tabname;
var ds_proc = new Asiainfo.data.AsiaInfoJsonStore({
			table:schema+'.PROC',
			root:'root',
			sql:"select PROC_NAME,PROCCNNAME,INTERCODE,INORFULL,CYCLETYPE,TOPICNAME,REMARK,PROCTYPE,RUNPARA,DEVELOPER,EFF_DATE,CREATER, STATE, STATE_DATE, CURDUTYER,VERSEQ,XML from "+proctabname+" where PROC_NAME='"+procName+"'",
			initUrl:'/'+contextUrl+'/newrecordService',
			url:'/'+contextUrl+'/newrecordService',
			dataSource:DBNAME,
			loadDataWhenInit:true,
			key:'PROC_NAME'
		});
	
 
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
    // CreateStep Info
  var logSql="select a.proc_name,a.STEP_SEQ,a.STEP_NAME, value(b.RUN_PARAM,a.sql_text) sql_text,value(STEP_RESULT,-1) STEP_RESULT,SQLCODE,ROWNUM,char(time(START_TIME)) st,char(time(END_TIME)) et,timestampdiff(2,char(END_TIME - START_TIME)) dura from " + metaStore['MD.PROC_STEP'].tabname+" a left join "+metaStore['MD.PROC_STEP_LOG'].tabname+" b on a.proc_name=b.proc_name and a.step_seq=b.step_seq and b.cycle_id={CYCLEID} where a.proc_name='"+procName+"'";
 
  var ds_item = Asiainfo.getStore(logSql.replace('{CYCLEID}',CYCLEID));  
    
  var rendfun=function(value, p, record){
       return '<img src="../../images/cloud.gif"><b>'+value+','+record.get('STEP_NAME')+'</b>';
    };	 
  var cm = new Ext.grid.ColumnModel([{
           id: 'TARGET',
           header: "序号",
           dataIndex: 'STEP_SEQ',
           width: 300,
           renderer: rendfun 
        } ]);
  var gd_item= new Ext.grid.GridPanel({
         region:'east', id:'topic-grid',
         collapsible: true,
		     collapseMode:'mini', 
         width:400,
         store: ds_item,
         cm: cm,
         split:true,
         stripeRows:true,
         trackMouseOver:false,
         loadMask: {msg:'Loading Topics...'},
         viewConfig: {forceFit:true,enableRowBody:true,showPreview:true,
             getRowClass : function(record, rowIndex, p, ds){
             var color='blue';
             if(record.get('STEP_RESULT')=="") color='black'
             else if(record.get('STEP_RESULT')!=0  ) color='red';
             if(this.showPreview){
                      p.body = '<p style="word-break:break-all">'+record.data.SQL_TEXT+'</p>'+
                               '<p>状态:<font color='+color+'><b>'+record.data.STEP_RESULT+'</b></font>  |  记录数:<font color=blue><b>'+record.data.ROWNUM+'</b></font>  |  SQLCODE:<font color=blue><b>'+record.data.SQLCODE+'</b></font></p>'+
                               '<p>开始时间:<font color=blue><b>'+record.data.ST+'</b></font> | 结束时间:<font color=blue><b>'+record.data.ET+'</b></font>| 运行时长:<font color=blue><b>'+record.data.DURA+'秒</b> </font></p> ';
                                
                      return 'x-grid3-row-expanded';
            }
            return 'x-grid3-row-collapsed';
          }
         } 
 });
 var refreshLog=function(onlyFreshGraph){
 	if(onlyFreshGraph!='Y'){
 		 ds_item.updateSql(logSql.replace('{CYCLEID}',fd_Cycle.getValue()));
 		 ds_item.select();
 		  
 	};
  
 	 var parent = graph.getDefaultParent();
   var childCount = graph.getModel().getChildCount(parent);
    for (var i = 0; i < childCount; i++) {
       var child = graph.getModel().getChildAt(parent, i);
       if (child.isEdge() ) continue;
       graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#F5FFFA',[child]);
       var iRow = ds_item.find('STEP_SEQ',child.getId());
       if(iRow==-1) continue; 
      
       if(ds_item.getAt(iRow).get('STEP_RESULT')==0 )
         graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#33FF33',[child])
       else if(ds_item.getAt(iRow).get('STEP_RESULT')!=-1  )
       	 graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#FF0000',[child])
        
    }
 };
 var refreshGraph=function(){
 	var sm = gd_item.getSelectionModel() ;
 	 if(sm.getSelections().length==0) return; 
 	 var r=sm.getSelections()[0];
 	 var StepSeq=r.get('STEP_SEQ');
 	 
 	 var parent = graph.getDefaultParent();
   var childCount = graph.getModel().getChildCount(parent);
    for (var i = 0; i < childCount; i++) {
       var child = graph.getModel().getChildAt(parent, i);
       if (child.isEdge() ) continue;
       	if (child.id==StepSeq) {
       		 graph.setSelectionCell(child);
       	   //graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#0101DF',[child]);
       	   graph.scrollCellToVisible(child);
       	  }
        //else 
       	//   graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#F5FFFA',[child])
       }
 };
 gd_item.on('click',refreshGraph)
 

 
 
    // Creates the enclosing viewport
    var viewport = new Ext.Viewport({
        layout: 'border',
        items: [  mainPanel,gd_item]
         
    }); // end of new Viewport
    ////自定义工具栏目
  var ds_fd_DBNAME = new Asiainfo.data.AsiaInfoJsonStore({
	     sql:"select DBNAME ID, CNNAME VALUE from MD.METADBCFG",
	     initUrl:'/'+contextPath+'/newrecordService',
	     url:'/'+contextPath+'/newrecordService',
	     root:'root',
	     table:'',
	     loadDataWhenInit:true,
	     key:''
      });
 
var fd_DBNAME = new Ext.form.ComboBox({
	     fieldLabel:'执行数据库',
	     name:'DBNAME',
	     ds:ds_proc,
	     listeners:{change:fieldChang},
	     width:123,
	     height:21,
	     anchor:'97%',
	     value:DBNAME,
	     mode: 'remote',
      triggerAction:'all',
      store:ds_fd_DBNAME,
      valueField: 'ID',displayField: 'VALUE'
 });
botomBar.add('<b>执行数据库');
    botomBar.add(fd_DBNAME);
    botomBar.add('数据时间');
    var fd_Cycle = new Ext.form.TextField({
	     width:80,
	     height:21,
	     value:CYCLEID	      
    });
    botomBar.add(fd_Cycle);
    
    botomBar.add('开始步骤号');
    var fd_StartStep = new Ext.form.TextField({
	     width:40,
	     height:21,
	     value:1	      
    });
    botomBar.add(fd_StartStep);
    
     var btnRunTest= new Ext.Button({
      text: '执行测试',
     cls:'x-btn-text-icon',
     icon:'../../images/run.gif',
     handler:function(){
     	  //procname,startSeq,taskid,metaprj,cfgdb,exedb
     	  var _url="/"+contextPath+"/procexec?procname="+procName+"&taskid="+fd_Cycle.getValue();
     	  if(fd_StartStep.getValue()) _url+="&startstep="+fd_StartStep.getValue();
     	  
        window.open (_url,'程序执行','height=300,width=400,top=20,left=20,toolbar=no,menubar=no,scrollbars=no, resizable=yes,location=no, status=no');  
     }
    }); 
    botomBar.add(btnRunTest);
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

        if (ds_proc.getCount() != 0) {
            var record = ds_proc.getAt(0);
            var xml = record.get("XML");
            if (xml != null && xml.length > 0) {
                var doc = mxUtils.parseXml(xml);
                var dec = new mxCodec(doc);
                dec.decode(doc.documentElement, graph.getModel());
            }
        }
        // alert("Load success");

    } finally {
        // Updates the display
        graph.getModel().endUpdate();
          refreshLog('Y');
    }

    // Installs the command history after the initial graph
    graph.click = function(evt, cell) {
        //For display cell properties begin
        currentCell = cell;
        
        if (cell != null) {
            if (cell.isVertex()) {
                fd_stepseq.setValue(cell.getId());
                fd_stepfunc.setValue(cell.getFn());
                fd_stepdb.setValue(cell.getobjType());
                fd_stepname.setValue(cell.getValue());
                fd_stepscript.setValue(cell.getScript());
                fd_StartStep.setValue(cell.getId());
                var iRow = ds_item.find('STEP_SEQ',cell.getId());
  	            if(iRow!=-1) {
  		              var sm = gd_item.getSelectionModel();
  		              sm.selectRow(iRow);
  		             gd_item.getView().focusRow(iRow);   

  	            };  
            } else {
                if (!cell.getLinkType()) {
                    if (graph.getCellStyle(cell).strokeColor == '#00FF00') {
                        cell.setLinkType(0);
                        cell.value = '成功时';
                    } else if (graph.getCellStyle(cell).strokeColor == '#FF0000') {
                        cell.setLinkType(1);
                        cell.value = '失败时';
                    } else if (cell.getCellStyle(cell).strokeColor == '#000000') {
                        cell.setLinkType(2);
                        cell.value = '完成时';
                    }
                };
                fd_linetype.setValue(cell.getLinkType());
                fd_linename.setValue(cell.getValue());
                fd_lineseq.setValue(cell.getId());
            }

        }
    };
 

    graph.dblClick = function(evt, cell) {
        this.fireEvent(mxEvent.DOUBLE_CLICK, new mxEventObject([evt, cell]));

        if (!mxEvent.isConsumed(evt) && cell != null) {
            if (cell.isVertex()) showWin('Step');
            else showWin('Line');
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

 