/*
 * $Id: GraphEditor.js,v 1.37 2009/04/06 15:07:19 gaudenz Exp $
 * Copyright (c) 2008, Gaudenz Alder
 */

GraphEditor = {};
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
  var FLOWCODE = paramMap.FLOWCODE;
  var FLOWNAME = paramMap.FLOWNAME;
  var DEVFLOWCODE = paramMap.DEVFLOWCODE;
   
  var METAPRJ=(typeof(paramMap.METAPRJ)!='undefined')?paramMap.METAPRJ:'';
  if(METAPRJ=='undefined')METAPRJ="";
  var schema='MD';
  var _objtype="";
  var contextUrl = window.location['pathname'].split('/')[1];
 if(METAPRJ) metaStore.transTabname(METAPRJ); 
var ds_fd_objtype= new Ext.data.SimpleStore({
 		fields:['ID','VALUE'],
 		data:metaStore.objtypes
 	}); 
var fd_objtype = new Ext.form.ComboBox({
    fieldLabel:'对象类型',
    name:'OBJTYPE',
    width:110,
    height:20,
    //labelStyle: "text-align: right",
    mode: 'local',
    triggerAction:'all',
    store:ds_fd_objtype,
 	  valueField: 'ID',displayField: 'VALUE',
    allowBlank:false
});
var fd_objname = new Ext.form.TextField({
    fieldLabel:'对象名称',
    name:'StepName',
    width:210,
    height:20,
    //labelStyle: "text-align: right",
 allowBlank:false
});
var fd_objcnname = new Ext.form.TextField({
    fieldLabel:'中文名称',
    name:'objcnName',
    width:210,
    height:20,
    //labelStyle: "text-align: right",
 allowBlank:false
});
var ds_fd_objfn= new Ext.data.SimpleStore({
 		fields:['ID','VALUE'],
 		data:[['新建','新建'],['修改','修改'],['引用','引用']]
 	}); 
var fd_objfn = new Ext.form.ComboBox({
    fieldLabel:'属性',
    name:'OBJFN',
    width:110,
    height:20,
    //labelStyle: "text-align: right",
    mode: 'local',
    triggerAction:'all',
    store:ds_fd_objfn,
    value:'新建',
 	  valueField: 'ID',displayField: 'VALUE',
    allowBlank:false
});
var fd_objremark = new Ext.form.TextArea({
    fieldLabel:'备注',
    name:'Remark',
    anchor: '95%',
    //hideLabel: true, 
    allowBlank:false
});
var f_objinfo = new Ext.form.FormPanel({width:'90%',style : 'height: 90%;',layout: 'form', 
   items:[fd_objtype,fd_objname,fd_objcnname,fd_objfn,fd_objremark]
});
///选择流程中的对象
function getObjByValue(value){
	var _result=null;
	var parent = graph.getDefaultParent();
	var childCount=graph.getModel().getChildCount(parent);
	for (var i=0;i<childCount;i++){
	   var child=graph.getModel().getChildAt(parent,i);
	   if(child.value==value) {_result=child;break;}
  }
  return _result;
};
//带关系增加程序
function AddProcRela(procname){
	 
	var proccell=getObjByValue(procname);
	 
	var _ds = new Asiainfo.data.AsiaInfoJsonStore({
			root:'root',
			sql:"Select distinct transname,target,source from "+metaSotre['MD.TRANSDATAMAP']+" where transname ='"+procname+"'",
			initUrl:'/'+contextUrl+'/newrecordService',
			url:'/'+contextUrl+'/newrecordService',
			loadDataWhenInit:true 
		});
	 var x=Math.random()*100+350;
	 var y=Math.random()*60+15;
	 var parent = graph.getDefaultParent();
	 if(!proccell){
	 var _style='image;image=images/gear.gif';
	 if(metaStore['程序'])  _style='image;image=images/'+metaStore['程序'].icon;
	 proccell=graph.insertVertex(parent,procname,procname, x, y, 40, 40,_style);
	 proccell.value=procname;
	 proccell.objType='程序';
	};
	var geo = graph.getModel().getGeometry(proccell);
        x=geo.x;
	 for(var i=0;i<_ds.getCount();i++){
	   var _r=_ds.getAt(i);
	   var sour_cell=getObjByValue(_r.get('SOURCE'));
	   if(!sour_cell){
	   	var _style='image;image=images/gear.gif';
	        if(metaStore['表'])  _style='image;image=images/'+metaStore['表'].icon;
	   	 sour_cell=graph.insertVertex(parent,_r.get('SOURCE'),_r.get('SOURCE'), x-200, y+i*40, 40, 40,_style);
	   	 sour_cell.objType='表';
	         sour_cell.value=_r.get('SOURCE');
	   }
	   
	   graph.insertEdge(parent,'','',sour_cell,proccell);
	   var target_cell=getObjByValue(_r.get('TARGET'));
	   if(!target_cell){
	   	var _style='image;image=images/tab.gif';
	   	if(metaStore['表'])  _style='image;image=images/'+metaStore['表'].icon;
	   	target_cell=graph.insertVertex(parent,_r.get('TARGET'),_r.get('TARGET'), x+300, y+i*40, 40, 40,_style);
	   	target_cell.objType='表';
	        target_cell.value=_r.get('TARGET');
	   }
	   graph.insertEdge(parent,'','',proccell,target_cell);
	}
};
///增加对象到面板
function AddpanelObj(objtype,objname,objcnname,state,remark){
	if(getObjByValue(objname)){alert(objname+',已经存在');return};
	 var parent = graph.getDefaultParent();
	 var _style='image;image=images/gear.gif';
	 if(metaStore[objtype])  _style='image;image=images/'+metaStore[objtype].icon;
	 
	 var x=Math.random()*100+300;
	 var y=Math.random()*60+15;
	 var mxCell=graph.insertVertex(parent,objname,objname, x, y, 40, 40,_style);
	 mxCell.objType=objtype;
	 mxCell.setFn(state);
	 mxCell.value=objname;	    
	 mxCell.cnname=objcnname;
	 mxCell.remark=(fd_objremark.getValue());
	 if(objtype=='PROC' || objtype=='程序')  {AddProcRela(objname);}
	 //var port = graph.insertVertex(parent, null, 'Trigger', 0, 0.25, 16, 16,
	//						'port;image=editors/images/overlays/flash.png;align=right;imageAlign=right;spacingRight=18px');
	// graph.setCellStyles(mxConstants.STYLE_IMAGE, 'images/earth.png',[mxCell]);
}; 
 
var win = new Ext.Window({   
        title: "信息",    
        width: 500,
        height:300,
        minWidth: 300,
        minHeight: 200,
        layout: 'fit',
        plain:true,
        modal: true,
        bodyStyle:'padding:1px;',
        buttonAlign:'center',
             items: [f_objinfo],   
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
 
	if(_objtype!=""){
		//alert(_objtype);
		AddpanelObj(fd_objtype.getValue(),fd_objname.getValue(),fd_objcnname.getValue(),fd_objfn.getValue(),fd_objremark.getValue());
		_objtype=''; 
		this.win.hide(); 
		return;
	}
	if (graph.getSelectionCells().length==0){this.win.hide(); return;}
	if (graph.getSelectionCells().length==1){
		    currentCell.objType=(fd_objtype.getValue());
	      currentCell.setFn(fd_objfn.getValue());
	      var objvalue=fd_objname.getValue();
	      if(currentCell.objType=='表' && objvalue)
	        currentCell.value=objvalue.toUpperCase()	
	      else
	        currentCell.value=(fd_objname.getValue());	
	      currentCell.cnname=(fd_objcnname.getValue());
	      currentCell.remark=(fd_objremark.getValue());
	      //if(fd_objtype.getValue()=='PROC') graph.setCellStyles(mxConstants.STYLE_SHAPE, 'ellipse', [currentCell])
	      //else if (fd_objtype.getValue()=='DATA') graph.setCellStyles(mxConstants.STYLE_SHAPE, 'rectangle', [currentCell]);
	      graph.refresh(currentCell);
	   } 
	 _objtype=''; 
	 this.win.hide();      
};    
function closeWin(){   
        if (this.win)  this.win.hide();    
};
 
function showWin(formtype){ //createForm()需要在继承时提供，该方法作用是创建表单   
        this.win.show()
       
    }; 
 
function closeWin(){   
        if (win) win.hide();   
};

  
function ShownewObjWin(objtype){
	_objtype = objtype;
	fd_objtype.setValue(_objtype);
	fd_objname.setValue('');
	fd_objcnname.setValue('');
	fd_objfn.setValue('新建');
  win.show();
};
var funAftPickObj = function(tr_e,rs){
	for(var i=0;i<rs.length;i++){
	  if(rs[i].get('VALUES3')) _objtype=rs[i].get('VALUES3') ;
	  AddpanelObj(_objtype,rs[i].get('VALUES1'),rs[i].get('VALUES2'));
	}	 
	_objtype="";
};

var ds_flow = new Asiainfo.data.AsiaInfoJsonStore({
			root:'root',
			sql:"select FLOWCODE,FLOWNAME,XML,VERSEQ,CURDUTYER,EFF_DATE,CREATER,STATE,STATE_DATE from "+metaStore['FLOW'].tabname+" where FLOWCODE='"+FLOWCODE+"'",
			initUrl:'/'+contextUrl+'/newrecordService',
			url:'/'+contextUrl+'/newrecordService',
			loadDataWhenInit:true,
			table:metaStore['FLOW'].tabname,
			key:metaStore['FLOW'].keyfield
		});
var flowrec;	
if(ds_flow.getCount()==0){
 flowrec = ds_flow.newRecord();
 flowrec.set('FLOWCODE',FLOWCODE);
 flowrec.set('FLOWNAME',FLOWNAME);
 flowrec.set('EFF_DATE',new Date());
 flowrec.set('CREATER',_UserInfo.usercnname);
 flowrec.set('STATE','新建');
 flowrec.set('STATE_DATE',new Date());
 flowrec.set('CURDUTYER',_UserInfo.usercnname);
 flowrec.set('VERSEQ',0); 
 flowrec.dirty=true;
 ds_flow.add(flowrec);
 //ds_flow.commit();
}
else  flowrec=ds_flow.getAt(0);
	
var rightInfo = metaStore.getRightInfo('FLOW',flowrec.get('STATE'),flowrec.get('CURDUTYER'));
autidtitle=rightInfo.autidtitle;
candedit =rightInfo.candedit;  
cansave = rightInfo.cansave;
function main()
{    
    Ext.QuickTips.init();
    Ext.BLANK_IMAGE_URL = '../ext/resources/images/default/s.gif';
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



function PickObj(objtype){
	var _tmpsql;
	_objtype = objtype;
  if(metaStore[objtype]) _tmpsql="select "+metaStore[objtype].keyfield+" VALUES1,"+metaStore[objtype].nameField+" VALUES2 from "+metaStore[objtype].tabname
	else {alert('未配置的对象:'+objtype);return};
  mywin = searchWin.init(funAftPickObj,_tmpsql)
  mywin.win.show();
 
};

var btnEditCfgWin = new Ext.Button({
    	text: '节点配置',
    	cls:'x-btn-text-icon',
      icon:'../../images/cog_edit.png',
    	disabled:true,
    	handler:function(){
    		if(!currentCell) return;
    		 showWin('Obj') 
    	}
}) 
var canedit=false;
if(flowrec.get('CURDUTYER')==_UserInfo.username && flowrec.get('STATE')!='发布') canedit=true;
function getObjSourceTarget(cell){
   var source="",target="";
   for(var j = 0;j< cell.getEdgeCount();j++){
       var edge = cell.getEdgeAt(j);
       var sObj=edge.getSource();
       var tObj=edge.getTarget();
       if(!tObj || !sObj) continue;
       if(sObj==cell && tObj!=cell ){
       	if(target) target+=','+tObj.getValue()  
       	else target=tObj.getValue();
       }
       else if(tObj==cell && sObj!=cell ){
       	if(source) source+=','+sObj.getValue()
       	else source=sObj.getValue();
       }
   }
   return source+";"+target;
};
var btnSaveNode= new Ext.Button({
     text: '保存',
     cls:'x-btn-text-icon',
     icon:'../../images/save.gif',
     disabled:!cansave,
     handler:function(){

							var enc = new mxCodec(mxUtils.createXmlDocument());
							var parent = graph.getDefaultParent();
							var childCount=graph.getModel().getChildCount(parent);
							var node = enc.encode(graph.getModel());
							
            	var rec = ds_flow.curRecord;
              
						  rec.set('XML',mxUtils.getPrettyXml(node));
							rec.dirty=true;
							ds_flow.commit();
							//delete from table PROC_STEP
							ds_flowobj = new Asiainfo.data.AsiaInfoJsonStore({
								table:metaStore['MD.TRANSFLOWOBJ'].tabname,
								root:'root',
								sql:"select FLOWCODE, OBJNAME, OBJTYPE, OBJCNNAME,ACTIONTYPE, REMARK  from "+metaStore['MD.TRANSFLOWOBJ'].tabname+" where  FLOWCODE='"+FLOWCODE+"'",
								initUrl:'/'+contextUrl+'/newrecordService',
								url:'/'+contextUrl+'/newrecordService',
								key:'FLOWCODE'
							});	
							rec = store.newRecord();
							rec.set('FLOWCODE',FLOWCODE);
							ds_flowobj.remove(rec);
							ds_flowobj.commit();
							for (var i=0;i<childCount;i++)
							{      
								var child=graph.getModel().getChildAt(parent,i);
								if (child.isVertex())
								{
								   var remark=child.remark;
								  if(child.objType=='程序' || child.objType=='应用' ){
								  	remark=getObjSourceTarget(child)
								  };
								  rec = ds_flowobj.newRecord();
								  rec.set('FLOWCODE',FLOWCODE);
								  rec.set('OBJNAME',child.value);
								  rec.set('OBJCNNAME',child.cnname);
								  rec.set('OBJTYPE',child.objType);
								  rec.set('REMARK',remark);
								  rec.set('ACTIONTYPE',child.fn);
								  ds_flowobj.add(rec);
								}
							}
							ds_flowobj.commit();
							metaStore.initFlowObjInstance(FLOWCODE,METAPRJ);
							if(DEVFLOWCODE){
							 
								var _tmpsql="insert into md.devflowobj(flowcode,objname,objtype,objcnname,remark,actiontype,state_date,state)";
                   _tmpsql+="select '"+DEVFLOWCODE+"'FLOWCODE,OBJNAME, max(OBJTYPE), max(OBJCNNAME),max(REMARK),max(ACTIONTYPE),";
                   _tmpsql+="current timestamp STATE_DATE, '设计' STATE "
                   _tmpsql+="from md.transflowobj where flowcode='"+FLOWCODE+"' and objname not in(select objname from md.devflowobj "
                   _tmpsql+=" where flowcode='"+DEVFLOWCODE+"') group by objname ";
								 
								 Asiainfo.executeSQL(_tmpsql);
							}
			        alert("Save success");
            }
          });	
 
 
function BackUpVersion(){
	Ext.Msg.prompt('版本变更', '输入变更原因',function(btn, text){
    if (btn == 'ok'){ 
    var _sql="insert into MD.TRANSFLOW_HIS(FLOWCODE,FLOWNAME,REMARK,CREATER,AUDITER,CHART,PARENTCODE,SCOPE,EFF_DATE,STATE,STATE_DATE,DEVELOPER,CURDUTYER,VERSEQ,XML,CAUSE) ";
        _sql+="select FLOWCODE,FLOWNAME,REMARK,CREATER,AUDITER,CHART,PARENTCODE,SCOPE,EFF_DATE,STATE,STATE_DATE,DEVELOPER,CURDUTYER,VERSEQ,XML,'"+text+"' as CAUSE   ";
        _sql+="from "+metaStore['FLOW'].tabname+" where FLOWCODE='"+FLOWCODE+"'";
     
    Asiainfo.executeSQL(_sql,false);
    flowrec.set('STATE_DATE',new Date());
    flowrec.set('CURDUTYER',_UserInfo.usercnname);
    flowrec.set('STATE','修改');
    flowrec.set('VERSEQ',flowrec.get('VERSEQ')+1);
     
    ds_flow.commit();
   
  }
  });
};	
var btnAudit = new Ext.Button({
    	text: autidtitle,
    	cls:'x-btn-text-icon',
      icon:'../../images/user_suit.gif',
    	disabled:!candedit,
    	handler:function(button,e){
    		if (button.text=='执行变更'){
    			 BackUpVersion();
    			 btnSaveNode.setDisabled(false);
    			 button.setText('执行发布');
    			
    			}
    		else {
    			flowrec.set('STATE','发布');
    			flowrec.set('STATE_DATE',new Date());
    			ds_flow.commit();
    			button.setText('执行变更');
    			btnSaveNode.setDisabled(true);
    		}
   }
});
var btnAddFlow =new Ext.menu.Item({
	text: '流程',
  cls:'x-btn-text-icon',
  icon:'../../images/flow.gif',
  handler: function(item){ShownewObjWin('流程')}
});
var btnAddTab =new Ext.menu.Item({
	text: '表',
  cls:'x-btn-text-icon',
  icon:'../../images/tab.gif',
  handler: function(item){ShownewObjWin('表')
  }
});
var btnAddProc =new Ext.menu.Item({
	text: '程序',
  cls:'x-btn-text-icon',
  icon:'../../images/proc.gif',
  handler: function(item){ShownewObjWin('程序') }
});
var btnAddApp =new Ext.menu.Item({
	text: '应用',
  cls:'x-btn-text-icon',
  icon:'../../images/app.gif',
  handler: function(item){ShownewObjWin('应用')
  }
});
var btnAddZb =new Ext.menu.Item({
	text: '指标',
  cls:'x-btn-text-icon',
  icon:'../../images/zb.gif',
  handler: function(item){ShownewObjWin('指标')
  }
});
var btnAddInter =new Ext.menu.Item({
	text: '接口',
  cls:'x-btn-text-icon',
  icon:'../../images/inter.gif',
  handler: function(item){ShownewObjWin('接口')
  }
});
var btnPickFlow =new Ext.menu.Item({
	text: '流程',
  cls:'x-btn-text-icon',
  icon:'../../images/flow.gif',
  handler: function(item){PickObj('流程')}
});
var btnPickTab =new Ext.menu.Item({
	text: '数据库表',
  cls:'x-btn-text-icon',
  icon:'../../images/tab.gif',
  handler: function(item){PickObj('表')
  }
});
var btnPickProc =new Ext.menu.Item({
	text: '程序',
  cls:'x-btn-text-icon',
  icon:'../../images/proc.gif',
  handler: function(item){PickObj('程序')}
});
var btnPickApp =new Ext.menu.Item({
	text: '应用',
  cls:'x-btn-text-icon',
  icon:'../../images/app.gif',
  handler: function(item){PickObj('应用')}
});
var btnPickZb =new Ext.menu.Item({
	text: '指标',
  cls:'x-btn-text-icon',
  icon:'../../images/zb.gif',
  handler: function(item){PickObj('指标')
  }
});
var btnPickInter =new Ext.menu.Item({
	text: '接口',
  cls:'x-btn-text-icon',
  icon:'../../images/inter.gif',
  handler: function(item){PickObj('接口')
  }
});
var btnPickFlowObj =new Ext.menu.Item({
	text: '流程中的对象',
  cls:'x-btn-text-icon',
  icon:'../../images/folder_go.png',
  handler: function(item){PickObj('流程中对象')
  }
});
var btnDelete =new Ext.Button({
	text: '删除',
  cls:'x-btn-text-icon',
  icon:'../../images/delete.gif',
  handler: function(item){
			Ext.Msg.confirm('信息','确定要删除当前记录吗?',function(btn){
			if(btn=='yes'){
			        var rec = ds_1.curRecord;
			        ds_1.remove(rec);
			         //数据感知同步
			         dataManager.fresh(ds_1,null,ds_1.itemindex);
			        }
			})
      }
}); 
var btnAddMenu =new Ext.Button({
            text:'新增对象',
            cls:'x-btn-text-icon',
            icon:'../../images/add.gif',
            handler: function(menu) { },
            menu: { items: [btnAddFlow,btnAddTab,btnAddProc,btnAddApp,btnAddZb,btnAddInter] }
         });
var btnPickMenu =new Ext.Button({
            text:'选择对象',
            cls:'x-btn-text-icon',
            icon:'../../images/edit.gif',
            handler: function(menu) { },
            menu: { items: [btnPickFlow,btnPickTab,btnPickProc,btnPickApp,btnPickZb,btnPickInter,btnPickFlowObj] }
         }); 
//For add customized properties end
   
  
	// Creates the main containers
	 
	var mainPanel = new MainPanel(graph, history);
	var library = new LibraryPanel('dataflow');

    // Creates the container for the outline
	var outlinePanel = new Ext.Panel(
	{
		id:'outlinePanel',
		layout: 'fit',
		split: true,
		height: 200,
    region:'south' 
    });
  //Check if there are cells with the same id
 
 // Creates the enclosing viewport
    var viewport = new Ext.Viewport(
    {
    	layout:'border',
    	items:
        [{
	        xtype: 'panel',
	       	margins:'1,1,1,1',
	        region: 'center',
	        layout: 'border',
	        border: false,
        	items:
        	[
	            new Ext.Panel(
	            {
	            	title: 'Index',
			        region:'west',
			        layout:'border',
			        split:true,
			        width: 180,
			        collapsible: true,
			        border: false,
			        items: [library, outlinePanel ]
		    	}),
	        	mainPanel 
        	]
       	  } // end master panel
       	] // end viewport items
    }); // end of new Viewport
    
    
    ////自定义工具栏目
    botomBar.add(btnAddMenu);
    botomBar.add(btnPickMenu);
    botomBar.add(btnSaveNode);
    botomBar.add(btnEditCfgWin);
    botomBar.add('-');
    botomBar.add('<font color=red>当前状态:'+flowrec.get('STATE')+',负责人:'+flowrec.get('CURDUTYER')+',您可以进行</font>'); 
    botomBar.add(btnAudit);
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
    graph.connectionHandler.setCreateTarget(false);

	// Creates rubberband selection
    var rubberband = new mxRubberband(graph);

	// Adds some example cells into the graph
    var parent = graph.getDefaultParent();
	graph.getModel().beginUpdate();
	try
	{
		  
	 if (ds_flow.getCount()!=0)
	 {
	 	var record = ds_flow.getAt(0);
	 	var xml =record.get("XML");
	  
		if (xml != null && xml.length > 0)
		{
			var doc = mxUtils.parseXml(xml); 
			var dec = new mxCodec(doc); 
			dec.decode(doc.documentElement, graph.getModel());
		}
	 }
	 
	
	}
	finally
	{
		// Updates the display
		graph.getModel().endUpdate();
	  
	}
		    
    // Installs the command history after the initial graph
  graph.click=function(evt,cell)
{
	//For display cell properties begin
	currentCell=cell; 
	if(cell==null) btnEditCfgWin.disable()  
	if (cell!=null)
	{  btnEditCfgWin.enable();
	//	alert(cell.style);
	  if(!cell.objType)cell.objType=metaStore.getObjTypeByStyle(cell.style);
		fd_objtype.setValue(cell.objType);
		fd_objname.setValue(cell.value);
		fd_objcnname.setValue(cell.cnname);
		fd_objfn.setValue(cell.fn);
		fd_objremark.setValue(cell.remark);
		  
	}
	};
  graph.dblClick = function(evt, cell)
{
					this.fireEvent(mxEvent.DOUBLE_CLICK,
						new mxEventObject([evt, cell]));
				 
					if (!mxEvent.isConsumed(evt) && cell != null)
					{  
						if(!cell.objType || !cell.value || !cell.cnname)showWin('Obj')
						else if(metaStore[cell.objType])metaStore.ShowDetail(cell.objType,cell.value,METAPRJ)
						else showWin('Obj') 
						 
		      } 
				};
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
	var outline = new mxOutline(graph, outlinePanel.body.dom);
	
    // Adds the entries into the library
    /*insertImageTemplate(library, graph, 'Bell', 'images/bell.png', false);
    insertImageTemplate(library, graph, 'Box', 'images/box.png', false);
    insertImageTemplate(library, graph, 'OLAP', 'images/cube_green.png', false);
    insertImageTemplate(library, graph, 'User', 'images/dude3.png', true);
    insertImageTemplate(library, graph, 'Earth', 'images/earth.png', true);
    insertImageTemplate(library, graph, 'Gear', 'images/gear.png', true);
    insertImageTemplate(library, graph, 'Home', 'images/house.png', false);
    
    insertImageTemplate(library, graph, 'Printer', 'images/printer.png', false);
    insertImageTemplate(library, graph, 'Server', 'images/server.png', false);
    insertImageTemplate(library, graph, 'Workplace', 'images/workplace.png', false);
    */
    insertImageTemplate(library, graph, '接口', 'images/inter.png', true);
    //insertImageTemplate(library, graph, '流程', 'images/flow.gif', true);
    insertImageTemplate(library, graph, '数据表', 'images/table.png', true);
    insertImageTemplate(library, graph, '程序', 'images/proc.png', true);
    insertImageTemplate(library, graph, '分发', 'images/wrench.png', true);
    insertImageTemplate(library, graph, '指标', 'images/zb.png', true);
    insertImageTemplate(library, graph, 'SCOPE', 'images/package.png', false);
    insertImageTemplate(library, graph, '应用', 'images/rep.gif', true);
     
     
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
