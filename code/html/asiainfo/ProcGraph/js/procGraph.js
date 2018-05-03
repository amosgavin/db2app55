 
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
  var procName = paramMap.PROCNAME;
  var DBNAME = paramMap.DBNAME; 
if(!DBNAME) DBNAME='defaultDB';
var schema='';
if(DBNAME=='defaultDB') schema='MD' 
else schema='NWH';
var METAPRJ=(typeof(paramMap.METAPRJ)!='undefined')?paramMap.METAPRJ:'';
if(METAPRJ) metaStore.transTabname(METAPRJ);

  var contextUrl = window.location['pathname'].split('/')[1];
 
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
	     name:'DBNAME',
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
	
 
function fieldChang(field,newValue,oldValue){
  field.ds.curRecord.set(field.name,newValue);
  field.ds.curRecord.dirty=true;
 dataManager.fresh(null,field,field.ds.itemindex);
}
 
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
 
var ds_proc = new Asiainfo.data.AsiaInfoJsonStore({
			table:metaStore['PROC'].tabname,
			root:'root',
			sql:"select PROC_NAME,PROCCNNAME,INTERCODE,INORFULL,CYCLETYPE,TOPICNAME,REMARK,PROCTYPE,RUNPARA,DEVELOPER,EFF_DATE,CREATER, STATE, STATE_DATE, CURDUTYER,VERSEQ,XML from "+metaStore['PROC'].tabname+" where PROC_NAME='"+procName+"'",
			initUrl:'/'+contextUrl+'/newrecordService',
			url:'/'+contextUrl+'/newrecordService',
			dataSource:DBNAME,
			loadDataWhenInit:true,
			key:'PROC_NAME'
		});
	
if(ds_proc.getCount()==0){
 var rec = ds_proc.newRecord();
 //记录初始化
 rec.set('PROC_NAME',procName);
 rec.set('CYCLETYPE','日');
 rec.set('TOPICNAME','');
 rec.set('EFF_DATE',new Date());
 rec.set('CREATER',gUserName);
 rec.set('STATE','新建');
 rec.set('STATE_DATE',new Date());
 rec.set('PROCTYPE','METAPROC');
 rec.set('RUNMODE','调度');
 rec.set('DEVELOPER',gUserName);
 rec.set('CURDUTYER',gUserName);
 rec.set('VERSEQ','1');
 ds_proc.add(rec);
 //数据感知同步
 //dataManager.fresh(ds_proc,null,ds_proc.itemindex);	
}	
var procrec=ds_proc.getAt(0);
if(!procrec.get('VERSEQ')) procrec.set('VERSEQ',1);
///版本管理
function BackUpVersion(chgCause) {
  var _sql = "insert into MD.PROC_HIS(PROC_NAME,INTERCODE,PROCCNNAME,INORFULL,CYCLETYPE,TOPICNAME,EFF_DATE,IF_CHILD,CREATER,STATE,STATE_DATE,STARTDATE,STARTTIME,ENDTIME,PARENTPROC,REMARK,PROCTYPE,PATH,RUNMODE,DBUSER,RUNPARA,RUNDURA,DEVELOPER,CURDUTYER,VERSEQ,AL_LEVEL,XML,CAUSE) ";
  _sql += "select PROC_NAME,INTERCODE,PROCCNNAME,INORFULL,CYCLETYPE,TOPICNAME,EFF_DATE,IF_CHILD,CREATER,STATE,STATE_DATE,STARTDATE,STARTTIME,ENDTIME,PARENTPROC,REMARK,PROCTYPE,PATH,RUNMODE,DBUSER,RUNPARA,RUNDURA,DEVELOPER,CURDUTYER,VERSEQ,AL_LEVEL,XML,'" + chgCause + "' as CAUSE   ";
  _sql += "from "+metaStore['PROC'].tabname+" where PROC_NAME='" + procName + "'";
  var result=Asiainfo.executeSQL(_sql, false);
  
  var _sql = "insert into MD.PROC_STEP_HIS(PROC_NAME,STEP_SEQ,S_STEP,F_STEP,N_STEP,STEP_NAME,STEP_TYPE,STEP_CODE,SQL_TEXT,DBNAME,VERSEQ)";
  _sql += "select PROC_NAME,STEP_SEQ,S_STEP,F_STEP,N_STEP,STEP_NAME,STEP_TYPE,STEP_CODE,SQL_TEXT,DBNAME," + procrec.get('VERSEQ') + " from "+metaStore['MD.PROC_STEP'].tabname+" where PROC_NAME='" + procName + "'";
  var result=Asiainfo.executeSQL(_sql, false);
   
  procrec.set('STATE_DATE', new Date());
  procrec.set('CURDUTYER', _UserInfo.usercnname);
  procrec.set('STATE', '编辑');
  procrec.set('VERSEQ', procrec.get('VERSEQ') + 1);
   
 };
///工作流的事件提交前操作
function CheckReqForm(ActName,ActType){
	
  if(ActType=='FUNACT'){
  	if(ActName=='程序测试')
  	 Asiainfo.addTabSheet('test' + procName, '程序测试(' + procName + ')', '/devmgr/procTest.html?OBJTYPE=PROC&PROCNAME=' + procName + '&DBNAME=&DEVDB&METAPRJ='+METAPRJ); 
    else if(ActName=='元数据解析')
    	metaStore.parserProcMeta(procName,METAPRJ);
    else if(ActName=='比较同步')
    	Asiainfo.addTabSheet('syn' + procName, '程序发布(' + procName + ')', '/devmgr/ObjCompare.html?OBJTYPE=PROC&OBJNAME=' + procName + '&TARDB=&SOURDB=METADB&ONLYDIFF=F&METAPRJ='+METAPRJ);
    else if(ActName=='查看测试报告')
    	Asiainfo.ShowDialog('程序测试报告','/'+contextUrl+'/devmgr/procTestRep.html?OBJTYPE=PROC&PROCNAME=' + procName + '&DBNAME=&DEVDB&METAPRJ='+METAPRJ,500,400,false);
    else if(ActName=='上线操作')
    	Asiainfo.ShowDialog('上线操作','/'+contextUrl+'/devmgr/procUpLine.html?OBJTYPE=PROC&PROCNAME=' + procName + '&DBNAME=&DWDB&METAPRJ='+METAPRJ,500,400,false);
    
    return true;
  }
  else if(ActName=='变更'){
  	BackUpVersion('程序变更');
  	procrec.set('STATE_DATE', new Date());
    procrec.set('CURDUTYER', _UserInfo.usercnname);
    procrec.set('STATE', '编辑');
    procrec.set('VERSEQ', procrec.get('VERSEQ') + 1);
    ds_proc.commit(false);
    wkdriver.AddFlowLog(_UserInfo.usercnname,'变更','发布','编辑','程序变更到新版本'+procrec.get('VERSEQ'));
    window.location=window.location
     
    return false;
  }else if(ActName=='提交测试'){
  	  
    window.location='/'+contextUrl+'/devmgr/procTest.html?OBJTYPE=PROC&PROCNAME=' + procName + '&DBNAME=&DEVDB&METAPRJ='+METAPRJ;
     
    return false;
  }; 
  return true;
}
function CheckReqFormAft(ActType,ActName,AuditInfo){
	if(ActName=='变更'){
  	BackUpVersion(AuditInfo.advice);
  }
	return true;
};
function main() {
    Ext.QuickTips.init();
    graph = new mxGraph();
    // Disables browser context menu
   // mxEvent.disableContextMenu(document.body);

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

    var canedit = false;
    if (procrec.get('CURDUTYER') == _UserInfo.usercnname && procrec.get('STATE') != '发布' && DBNAME == 'defaultDB') canedit = true;

    var btnSaveNode = new Ext.Button({
        text: '保存',
        cls: 'x-btn-text-icon',
        icon: '../../images/save.gif',
        disabled: !canedit,
        handler: function() {
            var msg = checkGraph();
            if (msg != null) {
                if (!confirm(msg + ",continue to save？")) return;
            }

            var enc = new mxCodec(mxUtils.createXmlDocument());
            var parent = graph.getDefaultParent();
            var childCount = graph.getModel().getChildCount(parent);
            var node = enc.encode(graph.getModel());

            var rec = ds_proc.curRecord;

            rec.set('XML', mxUtils.getXml(node));
            rec.set('STATE_DATE', new Date());
            rec.dirty = true;
            if(!ds_proc.commit(false)){alert('程序信息保存失败');return;};
            
            //delete from table PROC_STEP
            store = new Asiainfo.data.AsiaInfoJsonStore({
                table: metaStore['MD.PROC_STEP'].tabname,
                root: 'root',
                sql: "select PROC_NAME,STEP_SEQ,S_STEP,F_STEP,N_STEP,STEP_NAME,STEP_TYPE,SQL_TEXT,DBNAME from " + metaStore['MD.PROC_STEP'].tabname+" where PROC_NAME='" + procName + "'",
                initUrl: '/' + contextUrl + '/newrecordService',
                url: '/' + contextUrl + '/newrecordService',
                key: 'PROC_NAME'
            });
            rec = store.newRecord();
            rec.set('PROC_NAME', procName);
            store.remove(rec);
            if(!store.commit(false)){alert('程序信息保存失败');};
           
            //insert into table  PROC_STEP						
            store = new Asiainfo.data.AsiaInfoJsonStore({
                table: metaStore['MD.PROC_STEP'].tabname,
                root: 'root',
                sql: 'select PROC_NAME,STEP_SEQ,S_STEP,F_STEP,N_STEP,STEP_NAME,STEP_TYPE,SQL_TEXT,DBNAME from ' + metaStore['MD.PROC_STEP'].tabname,
                initUrl: '/' + contextUrl + '/newrecordService',
                url: '/' + contextUrl + '/newrecordService',
                key: 'PROC_NAME'
            });
            for (var i = 0; i < childCount; i++) {
                var child = graph.getModel().getChildAt(parent, i);
                if (child.isVertex()) {
                    rec = store.newRecord();
                    rec.set('PROC_NAME', procName);
                    rec.set('STEP_SEQ', child.getId());
                    rec.set('STEP_NAME', child.getValue());                     
                    rec.set('DBNAME', child.getobjType()||"");
                    rec.set('S_STEP', getNextCellId(child, '0'));
                    rec.set('F_STEP', getNextCellId(child, '1'));
                    rec.set('N_STEP', getNextCellId(child, '2'));
                    rec.set('STEP_TYPE', child.getFn() == null ? -1 : child.getFn());
                    var sqltext = child.getScript() + '';
                    sqltext = sqltext.replace(/\r\n/gi, " ").replace(/\t/gi, " ").replace(/^\s+|\s+$/, '');
                    rec.set('SQL_TEXT', child.getScript() == null ? '': sqltext)            


                    store.add(rec);
                }

            }
            if(!store.commit(false)){alert('程序信息保存失败');return;};
            
            alert("Save success");
        }
    });
    var autidtitle = '执行变更';
    if (procrec.get('STATE') == '编辑') autidtitle = '执行发布';
    candedit = true;
    if ((procrec.get('CURDUTYER') != _UserInfo.usercnname && procrec.get('CURDUTYER')) && procrec.get('STATE') == '编辑') candedit = false
    if (DBNAME != 'defaultDB') candedit = false;
    
    var btnAudit = new Ext.Button({
        text: autidtitle,
        cls: 'x-btn-text-icon',
        icon: '../../images/user_suit.gif',
        disabled: !candedit,
        handler: function(button, e) {
            if (button.text == '执行变更') {
                BackUpVersion();
                button.setText('执行发布');
            } else {
                procrec.set('STATE', '发布');
                procrec.set('STATE_DATE', new Date());
                ds_proc.commit();
                button.setText('执行变更');
            }
        }
    });
    var btnProcTest = new Ext.Button({
        text: '程序测试',
        cls: 'x-btn-text-icon',
        icon: '../../images/run.gif', 
        handler: function() {
           Asiainfo.addTabSheet('test' + procName, '程序测试(' + procName + ')', '/devmgr/procTest.html?OBJTYPE=PROC&PROCNAME=' + procName + '&DBNAME=&DEVDB&METAPRJ='+METAPRJ); 
        }
    });
    var btnCompare = new Ext.Button({
        text: '比较同步',
        cls: 'x-btn-text-icon',
        icon: '../../images/datasyn.gif',
        handler: function() {
            Asiainfo.addTabSheet('syn' + procName, '程序发布(' + procName + ')', '/devmgr/ObjCompare.html?OBJTYPE=PROC&OBJNAME=' + procName + '&TARDB=&SOURDB=METADB&ONLYDIFF=F&METAPRJ='+METAPRJ);
        }
    });
    var btnHis = new Ext.Button({
        text: '历史版本',
        cls: 'x-btn-text-icon',
        icon: '../../images/find.gif',
        handler: function() {
            Asiainfo.addTabSheet('his' + procName, '程序版本(' + procName + ')', '/devmgr/ObjHis.html?OBJTYPE=PROC&OBJNAME=' + procName+'&METAPRJ='+METAPRJ);
        }
    });
    var btnProcParser = new Ext.Button({
        text: '程序解析',
        cls: 'x-btn-text-icon',
        icon: '../../images/icon_edit02.gif', 
        handler: function() {
          //Asiainfo.remoteData("../../RelaAnnyServ?command=RunLocal&cmd=F:\\test\\wanqs\\sqlparsercmd\\sqltool.exe optype=procparser proc_name="+procName,false);
      
          //var url = '../../Dsp?cmd=parserProc&procname='+procName+'&schema=NPD';

           //var workDir= Asiainfo.remoteData("/"+contextUrl.split("/")[0]+'/currentUser'+'?command=servpath');
           //workDir=workDir.replace(/\//g, "\\ ")+'WEB-INF\\cgi\\';  
           
          //Ext.Msg.alert('已经提交解析',Asiainfo.remoteData("../../RelaAnnyServ?command=RunLocal&cmd="+workDir+"\\sqltool.exe optype=procparser proc_name="+procName,false));
          //Ext.Msg.alert('已经提交解析',Asiainfo.remoteData(url));
          metaStore.parserProcMeta(procName,METAPRJ);
        }
    });
    var btnProcRela = new Ext.Button({
        text: '影响分析',
        cls: 'x-btn-text-icon',
        icon: '../../images/plugin.gif',
        handler: function() {
        	var metaprj="_"+METAPRJ;
        	if(!METAPRJ) metaprj="";
          Asiainfo.addTabSheet(procName+'eeproc',procName+'程序影响分析','./asiainfo/ProcGraph/rela.html?annyType=ETL&annyDirection=All&level=3&relaName='+procName+'&metaprj='+metaprj);
          
        }
    });
      var btnProcGerDoc = new Ext.Button({
        text: '导出文档',
        cls: 'x-btn-text-icon',
        icon: '../../images/proc.gif',
        handler: function() {
          window.open('../../devmgr/GerDoc.html?OBJTYPE=ETL&OBJNAME='+procName+'&METAPRJ='+METAPRJ, '生成程序文档');
         // Asiainfo.addTabSheet(procName+'gerdoc',procName+'文档导出','./devmgr/GerDoc.html?OBJTYPE=ETL&OBJNAME='+procName);
        }
    });
    //For add customized properties end

    // Creates the main containers
    var mainPanel = new MainPanel(graph, history);
    var library = new LibraryPanel();

    // Creates the container for the outline
    var outlinePanel = new Ext.Panel({
        id: 'outlinePanel',
        layout: 'fit',
        split: true,
        height: 200,
        region: 'south',
        buttons: []
    });
    //Check if there are cells with the same id
    function getNewID(){
      var newid=graph.getModel().createId();
      if(newid==99) newid=graph.getModel().createId();
      return newid;
    };
    function getSameCellId(startCell) {//对节点编号检查，开始节点为0，不允许节点为99,中间节点编号不能重复
        var parent = graph.getDefaultParent();
        var childCount = graph.getModel().getChildCount(parent);
        if(startCell.getId() != 1) startCell.setId(1);
        for (var i = 0; i < childCount; i++) {
            var child = graph.getModel().getChildAt(parent, i);
            if(child != startCell && child.id==1) child.setId(getNewID());
            if( child.id==99 ) child.setId(getNewID());
            for(var j = i+1 ;j< childCount; j++){
               var cell = graph.getModel().getChildAt(parent, j);
               if(child.id == cell.id )  cell.setId(getNewID()) ; 
            }
        };
        
    };
    //Get cell's source count
    function getLinkCount(cell) {
        var parent = graph.getDefaultParent();
        var childCount = graph.getModel().getChildCount(parent);
        var sourceCount = 0;
        var targetCount = 0;
        for (var i = 0; i < childCount; i++) {
            var child = graph.getModel().getChildAt(parent, i);
            if (child.isEdge()) {
                //增加连线的判断 20100105 by MeiKefu
                if (!child.getSource() || !child.getTarget()) {
                    alert("连接线 [" + child.id + " " + child.value + "] 没有连接正确");
                    return {
                        source: 0,
                        target: 0
                    };
                }
                if (child.getSource().getId() == cell.getId()) sourceCount++;
                if (child.getTarget().getId() == cell.getId()) targetCount++;
            }
        }
        return {
            source: sourceCount,
            target: targetCount
        };
    }
    //Check graph
    function checkGraph() {
        var parent = graph.getDefaultParent();
        var childCount = graph.getModel().getChildCount(parent);
        var msg = null;
        var startCell;
        ///先检查连线
        for (var i = 0; i < childCount; i++) {
            var child = graph.getModel().getChildAt(parent, i);
            if (child.isEdge()) {
                if (!child.getLinkType()) {
                    if (graph.getCellStyle(child).strokeColor == '#00FF00') {
                        child.setLinkType(0);
                        child.value = '成功时';
                    } else if (graph.getCellStyle(child).strokeColor == '#FF0000') {
                        child.setLinkType(1);
                        child.value = '失败时';
                    } else if (graph.getCellStyle(child).strokeColor == '#000000') {
                        child.setLinkType(2);
                        child.value = '完成时';
                    }
                }
            }
        }
        for (var i = 0; i < childCount; i++) {
            var child = graph.getModel().getChildAt(parent, i);
            if (child.isEdge()) {
                if (child.getSource() == null) {
                    msg = 'The id=' + child.getId() + ' line\'s source is not set';
                    break;
                }
                if (child.getTarget() == null) {
                    msg = 'The id=' + child.getId() + ' line\'s target is not set';
                   break;
                }

            } 
            else {
                var sourceCount = getLinkCount(child).source;
                var targetCount = getLinkCount(child).target;
                if (sourceCount > 2) {
                    msg = 'One step is allowed to be set as  2 sources at most, please check the id=' + child.getId() + ' step';
                    break;
                }
                if(targetCount==0) startCell=child;
                 
                if (sourceCount + targetCount == 0) {
                    msg = 'The id=' + child.getId() + ' step is isolated';
                    break;
                }
                if (getNextCellId(child, '0') == -1 && getNextCellId(child, '1') == -1 && getNextCellId(child, '2') == -1) {
                    msg = '步骤' + child.getId() + '错误,没有正确的连接';
                    break;
                }
            }
        };
        if(!startCell) {return '没有开始节点'};
        getSameCellId(startCell);
        return msg;
    };
    function getNextCellId(cell, linkType) {
        var nextid;
        var isEnd = true;
        var parent = graph.getDefaultParent();
        var childCount = graph.getModel().getChildCount(parent);
        var nextCell = null;
        for (var i = 0; i < childCount; i++) {
            var child = graph.getModel().getChildAt(parent, i);

            if (child.getSource() && child.getSource().getId() == cell.getId()) isEnd = false; ///是去S_STEP,而且有作为源,则不是最后节点
            if (child.isEdge() && child.getSource() && child.getLinkType() == linkType && child.getSource().getId() == cell.getId()) {
                nextCell = child.getTarget();
            }
        }
        nextid = nextCell != null ? nextCell.getId() : -1;
        if (isEnd && linkType == 0) nextid = 99;
        return nextid;
    };
    // Creates the enclosing viewport
    var viewport = new Ext.Viewport({
        layout: 'border',
        items: [{
            xtype: 'panel',
            margins: '1,1,1,1',
            region: 'center',
            layout: 'border',
            border: false,
            items: [new Ext.Panel({
                title: 'Library',
                region: 'west',
                layout: 'border',
                split: true,
                width: 180,
                collapsible: true,
                border: false,
                items: [library, outlinePanel]
            }), mainPanel]
        } // end master panel
        ] // end viewport items
    }); // end of new Viewport
    ////自定义工具栏目
    botomBar.add(btnProcRela);
    botomBar.add(btnProcGerDoc);
     botomBar.add(btnHis);
    botomBar.add('-');
    botomBar.add('<b>流程操作');
    botomBar.add(btnSaveNode);
    //botomBar.add(btnCompare);
   
    
    //botomBar.add('<font color=red>当前状态:' + procrec.get('STATE') + ',负责人:' + procrec.get('CURDUTYER') + ',您可以进行</font>');
    //botomBar.add(btnAudit);
    //botomBar.add(btnProcTest);
    //botomBar.add(btnProcParser);
    
    ///绑定工作流程
    wkdriver = new flowdriver('PROC',ds_proc,null,botomBar,false);
    wkdriver.CheckReqForm=CheckReqForm; 
    wkdriver.CheckReqFormAft=CheckReqFormAft;
    if(!ds_proc.getAt(0).get('STATE'))ds_proc.getAt(0).set('STATE','发布');
 //procrec=ds_proc.getAt(0);
    wkdriver.SetStateInfo('PROC',ds_proc.getAt(0).get('PROC_NAME'),ds_proc.getAt(0).get('STATE'),botomBar);

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
        var parent = graph.getDefaultParent();
        var childCount = graph.getModel().getChildCount(parent);
        for (var i = 0; i < childCount; i++) {
            var child = graph.getModel().getChildAt(parent, i);
            if (child.isEdge()) {
                if (child.getLinkType() == 0) child.setStyle('strokeColor=#00FF00');
                if (child.getLinkType() == 1) child.setStyle('strokeColor=#FF0000');
                if (child.getLinkType() == 2) child.setStyle('strokeColor=#000000');
                graph.refresh(child);
            }
        }
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
    graph.AftAddedCell = function(cells, parent, index, source, target, absolute) {
    	var hasSucessLink=false,hasFailLink=false;
        for (var i = 0; i < cells.length; i++){ 
          ///解决节点编号不能为99的问
           if(cells[i].id==99) cells[i].setId( getNewID());
           if(!cells[i].isVertex()){
           if(source){
             for(var j = 0;j< source.getEdgeCount();j++){
             	var edge = source.getEdgeAt(j);
             	if(edge==cells[i]) continue;
             	if(edge.getSource()!=source) continue;///不是以此为出发点的
             	if(edge.getLinkType()==0) hasSucessLink=true
             	else if(edge.getLinkType()==1) hasFailLink=true
             }
           };
           if(hasSucessLink && hasFailLink ) 
             alert('提示:已经存在两连线了');
           else if(!hasFailLink && !hasSucessLink){///0,或空时增加成功时
            cells[i].setValue('成功时');
            cells[i].setLinkType(0);
            graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, '#00FF00',[cells[i]]);
            //var style=graph.getCellStyle(cells[i]);
            //style.strokeColor = '#00FF00';
            //graph.setCellStyle(style,cells);
          }
          else if(hasFailLink && !hasSucessLink){///0,或空时增加成功时
            cells[i].setValue('成功时');
            cells[i].setLinkType(0);
            graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, '#00FF00',[cells[i]]);
            //var style=graph.getCellStyle(cells[i]);
            //style.strokeColor = '#00FF00';
            //graph.setCellStyle(style,cells);
          }
          else if( hasSucessLink && ! hasFailLink){///0,或空时失败时
            cells[i].setValue('失败时');
            cells[i].setLinkType(1);
            graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, '#FF0000',[cells[i]]);
            //var style=graph.getCellStyle(cells[i]);
            //style.strokeColor = '#FF0000';
            //graph.setCellStyle(style,cells);
           
          }
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
    library.getSelectionModel().on('selectionchange',
    function(sm, node) {
        if (node != null && node.attributes.cells != null) {
            var cell = node.attributes.cells[0];

            if (cell != null && graph.getModel().isEdge(cell)) {
                GraphEditor.edgeTemplate = cell;
            }
        }
    });

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
