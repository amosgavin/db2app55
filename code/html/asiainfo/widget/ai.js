function CompMgr(cfgStore){
	this.cfgStore=cfgStore;
	this.ds_cfg = new Asiainfo.data.AsiaInfoJsonStore({
	     sql:"select REPCODE,OBJTYPE,OBJCODE,OBJNAME,PARANAME,VAL,REMARK,PARENTCODE,CNNAME,TYPE,DEFAULT,SEQ,LISTVALUE,AWHERE,CLICKFUN,CLICKFUNPARA,DBCLICKFUN,DBCLICKFUNPARA,XML,CFG from MD.LDCREPCFG where REPCODE='"+_main.appCode+"' order by seq ",
	     initUrl:'/'+contextPath+'/newrecordService',
	     url:'/'+contextPath+'/newrecordService',
	     //dataSource: _UserInfo.dbname,
	     root:'root',
	     loadDataWhenInit:true 
      });
  this.maintbar;///主工具栏
  this.allObjs ={};
  this.dsArray ={};
}
CompMgr.prototype = {
   GetLayout : function(){
  	    var obj;
  	    var cObjs={};
  	    var objs={}; 
  	    
  	  	for(var i=0;i<this.cfgStore.getCount();i++){
  	  		var record = this.cfgStore.getAt(i);
  	  		var cfg=null;
  	      if(record.get('CFG').substr(4).length>10) cfg=Ext.util.JSON.decode(record.get('CFG').substr(4));
  	  		if(!cObjs[record.get('PARENTNAME')]) cObjs[record.get('PARENTNAME')]=[];
  	  		if(record.get('TYPENAME')=='panel' && record.get('HASCHILD')!='Y'){
  	  			var obj = this.GetComObj(record)
  	  		
         }
         else if (record.get('TYPENAME')=='panel' && record.get('HASCHILD')=='Y'){
         	var obj=new Ext.Panel({id:record.get('OBJNAME'),region:record.get('ALIGN'),layout:'border', 
  					 	width:parseInt(record.get('WIDTH')),height:parseInt(record.get('HEIGHT')),split:true,
  					items:cObjs[record.get('OBJNAME')]})
        }
        else if(record.get('TYPENAME')=='tabpanel'){
		 var  obj= new Ext.TabPanel({ region:record.get('ALIGN'),width:parseInt(record.get('WIDTH')),height:parseInt(record.get('HEIGHT')),
	             margins: '0 0 0 0', split:true, id:record.get('OBJNAME'),border:false,activeTab:1, 
	             items:cObjs[record.get('OBJNAME')]
              }); 
		    }
		    else if(record.get('TYPENAME')=='border'){
   	          var obj = new Ext.Panel({region:record.get('ALIGN')?record.get('ALIGN'):'center', layout:'border',width:parseInt(record.get('WIDTH')),height:parseInt(record.get('HEIGHT')),
	               margins: '3 0 0 3', split:true, id:record.get('OBJNAME'),border:false,
	               items:cObjs[record.get('OBJNAME')]
              });
              
              
        };
  
       if(record.get('PARENTNAME')!='mainpn') cObjs[record.get('PARENTNAME')].push(obj); 
       if(record.get('PARENTNAME')=='mainpn') return obj;
      }
   },
   GetDatastore : function(objcode){
   	if(this.dsArray[objcode]) return this.dsArray[objcode];
   	var obj_cfg=this.getCfgRecord(objcode);
   	if(!obj_cfg){alert('数据源获取错误,不存在:'+objcode);return;};
   	var sql=obj_cfg.get('VAL');
   	sql=this.DealSql(sql,obj_cfg.get('PARANAME'));
   	var ds_select = new Asiainfo.data.AsiaInfoJsonStore({
   		 id:objcode,
	     sql:sql,
	     initUrl:'/'+contextPath+'/newrecordService',
	     url:'/'+contextPath+'/newrecordService',
	     root:'root',
	     pageSize:obj_cfg.get('DEFAULT')?obj_cfg.get('DEFAULT'):30,
	     dataSource:'',
	     table:obj_cfg.get('CNNAME'),
	     loadDataWhenInit:true,
	     key:obj_cfg.get('LISTVALUE')
      });
     ds_select.oldSql=obj_cfg.get('VAL');
     ds_select.paraname=obj_cfg.get('PARANAME'); 
     if(obj_cfg.get('CFG')){
     ds_select.config=	Ext.decode(obj_cfg.get('CFG').substr(4));
     ds_select.BindObj=[];
     };
     this.dsArray[objcode]=ds_select;
     return ds_select;
   },
   GetComObj : function(record){
   	var cfg=null;
   	var obj=null;
   	var comObj=null
  	if(record.get('CFG').substr(4).length>10) cfg=Ext.util.JSON.decode(record.get('CFG').substr(4));
  	if (record.get('COMTYPE')=='toolbar'){var comObj=new Querytbar(record,this.ds_cfg);this.maintbar=comObj}
  	else if (record.get('COMTYPE')=='grid'){var comObj=new ExtGrid(record,this.ds_cfg);}
  	else if (record.get('COMTYPE')=='repcross'){var comObj=new CrossRep(record,this.ds_cfg);}
  	else if (record.get('COMTYPE')=='repgroup'){var comObj=new GroupRep(record,this.ds_cfg);}	
  	else if (record.get('COMTYPE')=='graph'){var comObj=new GraphChart(record,this.ds_cfg);}	
  	else if (record.get('COMTYPE')=='form'){var comObj=new ExtForm(record,this.ds_cfg); }
  	else if (record.get('COMTYPE')=='treegrid'){var comObj=new TreeGrid(record,this.ds_cfg); }
  	else if (record.get('COMTYPE')=='ifram'){var comObj=new Ifram(record,this.ds_cfg); };
    if(comObj) obj=comObj.create()
    else {
      obj=new Ext.Panel({idid:record.get('OBJNAME'),region:record.get('ALIGN'),title:cfg.title,
  	  				border:false,
  					 	width:parseInt(record.get('WIDTH')),height:parseInt(record.get('HEIGHT')),split:true
  					 	,html:record.get('OBJNAME')+','+record.get('COMTYPE')+',还未配置'  
  					})
    };
     	this.allObjs[record.get('OBJNAME')]=comObj;
  	return obj;
   } ,
   RefreshView : function(objcode){
   	if(objcode){
         var store=this.dsArray[objcode];
    	  if(store){
    	    var newsql=this.DealSql(store.oldSql,store.paraname);
	    
	    if (newsql!=store.sql){
		 store.updateSql(newsql);
		 store.select();
		 }
	    }
    	 if(this.allObjs[objcode] && this.allObjs[objcode].RefreshView) 
    	   this.allObjs[objcode].RefreshView();
	   }
	  else{
	  	///数据集刷新
	  	for ( var ds in this.dsArray ){
	  		var store=this.dsArray[ds];
	  		var newsql=this.DealSql(store.oldSql,store.paraname);
		   if (newsql!=store.sql){
				store.updateSql(newsql);
				store.select();
			  }
			 if(store.getCount()>0){dataManager.fresh(store,null,store.itemindex);}
	  	};
	    ///控件刷新
	  	for ( var comcode in this.allObjs ){
	  		if(this.allObjs[comcode] && this.allObjs[comcode].RefreshView) this.allObjs [comcode].RefreshView();
	     }
	   }
   },
   DealSql:function(cfgsql,paraname){
		var sql=cfgsql;
	  if(!paraname) paraname='';
	  ///外部参数替换
	  for(paraname in _main.paramMap){
	  	sql=sql.replace(new RegExp('{PARAM.'+paraname+'}',"gm"),_main.paramMap[paraname]); 
	  };
	  ///用户身份信息替换处理
	   for(paraname in _main.paramUser){
	     sql=sql.replace(new RegExp('{USER.'+paraname+'}',"gm"),_main.paramUser[paraname]); 
	    };
	   
		///工具栏参数替换
		var caluse = [];
		var where=" ";
		//if(sql.indexOf("{")==-1 || sql.indexOf("}")==-1) return sql;
		while(sql.indexOf("{now.")!=-1){
				var iPos=sql.indexOf("{now.");
				var dt=new Date();
				var format=sql.substr(iPos+5);
				format=format.substr(0,format.indexOf('}'));
				 
			  sql=sql.replaceAll("{now."+format+"}",dt.format(format));
			   
			};
		if(this.maintbar){
			 
		var tbfields= this.maintbar.tbfields;
		
		for(var i=0;i<tbfields.length;i++){
			var fdVal = tbfields[i].getValue();
     	if(fdVal && tbfields[i].getXType()=='datefield') fdVal=Ext.util.Format.date(fdVal, 'Y-m-d');
     	///增加where条件
     	 
     	if(fdVal && tbfields[i].where && fdVal!='all' && tbfields[i].name &&(paraname=='all' || paraname.indexOf(tbfields[i].name)!=-1))
			    caluse.push(tbfields[i].where.replace('{'+tbfields[i].name+'}',fdVal));
			///替换sql中的变量
	    if(sql.indexOf("{"+tbfields[i].getId()+".")!=-1 && tbfields[i].getXType()=='datefield'){
				var iPos=sql.indexOf("{"+tbfields[i].getId()+".");
				var dt=tbfields[i].getValue();
				var format=sql.substr(iPos+("{"+tbfields[i].getId()+".").length);
				format=format.substr(0,format.indexOf('}'));
				sql=sql.replaceAll("{"+tbfields[i].getId()+"."+format+"}",dt.format(format));
		  }
	   else if(sql.indexOf("{"+tbfields[i].getId()+"}")!=-1){
			  var replaceVal=tbfields[i].getValue();
			  if(replaceVal && tbfields[i].getXType()=='datefield') replaceVal=Ext.util.Format.date(replaceVal, 'Y-m-d');
			  if(!replaceVal && tbfields[i].getRawValue) replaceVal = tbfields[i].getRawValue();
			  if(!replaceVal || replaceVal=="") replaceVal=-999999999;
			  sql=sql.replace("{"+tbfields[i].getId()+"}",replaceVal);
		 }
		}
		if(caluse.length!=0) where +=' where '+  caluse.join(' and ')
		if(paraname) sql+= where ;
	 
	 }
		if(sql.indexOf("{")==-1 || sql.indexOf("}")==-1) return sql;
		///组件对象的参数处理
		while(sql.indexOf("{")!=-1 && sql.indexOf("}")!=-1){
			var newStr=-99999;
		  var oldstr=sql.substring(sql.indexOf("{")+1, sql.indexOf("}"));
		  var strArray=oldstr.split('.');
		  var record=null;
		  if(strArray[1]=='getwhere'){
		   
		  	if(this.allObjs[strArray[0]] &&  this.allObjs[strArray[0]].getwhere) newStr=this.allObjs[strArray[0]].getwhere()
		  	else newStr=' 1=1 '
		  }
		  else{
		    if(this.dsArray[strArray[0]] && this.dsArray[strArray[0]].curRecord) record=this.dsArray[strArray[0]].curRecord;
		    else if(this.allObjs[strArray[0]] && this.allObjs[strArray[0]].store && this.allObjs[strArray[0]].store.curRecord)
		  	record=this.allObjs[strArray[0]].store.curRecord; 
		    //var parentObj=this.getObj(strArray[0]);
		    //if(parentObj && parentObj.store && parentObj.store.curRecord){
		    if(record) newStr=record.get(strArray[1]);
		 }
		  sql=sql.replace("{"+oldstr+"}",newStr);
		}
		 
		return sql;
   },
   getObj:function(objcode){
	   for(var i=0;this.allObjs.length;i++){
			if (this.allObjs[i].getId()==objcode) return this.allObjs[i];
		}
  	return null;
   },
   getCfgRecord:function(objcode){
	 var r_cfg=null;
	 for(var i=0;i<this.ds_cfg.getCount();i++){
		 if(this.ds_cfg.getAt(i).get('OBJCODE')==objcode) {r_cfg=this.ds_cfg.getAt(i);break;}
	 }
	 return r_cfg;
  }
};

Main = function() {
	this.paramMap={};///外部参数
	this.paramUser={};///用户相关的身份信息
	this.paramUser['USERNAME']=_UserInfo.username;
	this.paramUser['USERCNNAME']=_UserInfo.usercnname;
};
Main.prototype = {
	
	init: function() {
		Ext.QuickTips.init();
	  Ext.BLANK_IMAGE_URL = '../ext/resources/images/default/s.gif';
    Ext.form.Field.prototype.msgTarget = 'side';
    var contextPath = window.location['pathname'].split('/')[1];
    var temp = window.location.search; 
    if(temp.length!=0){
	  temp = temp.substr(1).split('&');
	    for (i=0;i<temp.length;++i){
		f = temp[i].split('=');
		this.paramMap[f[0]]=f[1];
	    } 
	   };
    this.appCode=  this.paramMap.APPCODE;
    this.cfgStore = new Asiainfo.data.AsiaInfoJsonStore({
	     sql:"select MODELCODE, OBJNAME, PARENTNAME, TYPENAME, COLOR, ALIGN, HEIGHT, WIDTH, SEQ, CAPTION,CFG,HASCHILD,COMTYPE, COMCODE from MD.METALAYOUT where  MODELCODE='"+this.appCode+"' order by seq desc",
	     initUrl:'/'+contextPath+'/newrecordService',
	     url:'/'+contextPath+'/newrecordService',
	     root:'root',
	     table:'MD.METALAYOUT',
	     loadDataWhenInit:true,
	     key:'MODELCODE'
      });
      _main=this;
    
      this.CompMgr= new CompMgr(this.cfgStore);
      this.mainpn = this.CompMgr.GetLayout();
      this.viewport  = new Ext.Viewport({
	     layout:'border',
             margins: '3 0 0 3',
	     items:[this.mainpn]
      });
      for(var ds in _main.CompMgr.dsArray)
        _FO[ds]=_main.CompMgr.dsArray[ds];
      for(var obj in _main.CompMgr.allObjs)
        _FO[obj]=_main.CompMgr.allObjs[obj];
      
      this.CompMgr.RefreshView();   	
  }
  
};
var dataManager = new Asiainfo.data.dataManager();
main = new Main();
Ext.onReady(main.init, main);