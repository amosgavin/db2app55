contextPath = window.location['pathname'].split('/')[1];
 var ds_people= new Asiainfo.data.AsiaInfoJsonStore({
     sql:"select usecnname ID,usecnname VALUE,USERNAME,PHONE from md.metauser",
     root:'root',
     loadDataWhenInit:true,
     initUrl:'/'+contextPath+'/newrecordService',
     url:'/'+contextPath+'/newrecordService' });
 
function CheckUserIsITService(usercnname){
	if(_UserInfo.USERTYPE){
		if (_UserInfo.USERTYPE=='省支撑中心') return true
		if (_UserInfo.USERTYPE=='业务支撑中心'||_UserInfo.USERTYPE=='省支撑中心') return true
		else return false;
	}
	for(var i=0;i<ds_people.getCount();i++){
		var _r=ds_people.getAt(i);
		if (_r.get('ID')==usercnname) return true;
	}
	return false;
}     
function GetNewCode(CodeType,TABNAME,KEYFIELD){
	if(!TABNAME)TABNAME='MD.DEVREQ';
	if(!KEYFIELD)KEYFIELD='REQCODE';
	var newcode='';
	var _tmpsql;
 
		var _d = new Date();
		var cycle =_d.format("YYMM"); 
		 
		_tmpsql="select max(int(substr("+KEYFIELD+",6,3))) as seq from "+TABNAME+" where "+KEYFIELD+" like '%"+cycle+"%'"
	  var ds_code = new Asiainfo.data.AsiaInfoJsonStore({
	     sql:_tmpsql,
	     initUrl:'/'+contextPath+'/newrecordService',
	     url:'/'+contextPath+'/newrecordService',
	     root:'root',
	     table:'',
	     loadDataWhenInit:true,
	     key:''
      });
   var seq=0;
   if(ds_code.getCount()>0){
   	 seq=ds_code.getAt(0).get('SEQ')+1;
   }
   seq=seq+'';
 
   if (seq.length==1) seq='00'+seq
   else if(seq.length==2) seq='0'+seq;
  if(CodeType=='REQ') CodeType='R';
  newcode= CodeType+cycle+seq;
  return newcode;
	  
};
function SendSms(phone,msg){
	//alert('will send:'+phone+','+msg);
	//phone='13599448448';msg='真实号码:'+phone+','+msg; 	
	var newSend =  Ext.Ajax.request({
   url: '/ldc_new/sms?PHONE='+phone+'&MSG='+encodeURIComponent(encodeURIComponent(msg)),
  method: 'GET', 
   onComplete: function(r){
	alert(r.responseText);
	}
});
}; 
function SendSmsByname(usercnname,msg){
	var sendphone='';
	 
	for(var i=0;i<ds_people.getCount()-1;i++){
	  var _userRec=ds_people.getAt(i);
	  if (_userRec.get('VALUE')==usercnname || _userRec.get('USERNAME')==usercnname){
	     sendphone=_userRec.get('PHONE');
	     break;
	  } 
	}
	if(sendphone!='') SendSms(sendphone,msg);
}
var _self;
function flowdriver(ModelCode,store,substore,tbar,showDefaultFun){
	 _self=this;
   
	this.ModelCode=ModelCode;	
	this.taskname='';
	this._store = store;
	this._substore=substore;
	this._rec = store.getAt(0);
	this.tbar=tbar;
  this.showDefaultFun=true;
  
  if(showDefaultFun==false)this.showDefaultFun=false;
   
  var _sql="select FLOWCODE,MASTERTABLE,MASTERTABLEKEY,MASTERTABLETITLE,SUBTABLE,NEWFORM,DEFAULTFORM from MD.DEVWKFLOW where FLOWCODE ='"+ModelCode+"'";
  var _t_select = new Asiainfo.data.AsiaInfoJsonStore({
	     sql:_sql,
	     initUrl:'/'+contextPath+'/newrecordService',
	     url:'/'+contextPath+'/newrecordService',
	     root:'root',
	     loadDataWhenInit:true 
      });
  if(_t_select.getCount()==0) {alert('工作流错误,没有配置:'+ModelCode);return};
  this._keyfield=_t_select.getAt(0).get('MASTERTABLEKEY');
  this._titlefield=_t_select.getAt(0).get('MASTERTABLETITLE');
  
  this._flowcode=this._rec.get(this._keyfield);
  this.taskname =this._rec.get(this._titlefield);
  this.NEWFORM=_t_select.getAt(0).get('NEWFORM')?_t_select.getAt(0).get('NEWFORM'):'';
  this.DEFAULTFORM=_t_select.getAt(0).get('DEFAULTFORM')?_t_select.getAt(0).get('DEFAULTFORM'):'';
  this.MASTERTABLE=_t_select.getAt(0).get('MASTERTABLE');
  this.SUBTABLE=_t_select.getAt(0).get('SUBTABLE');
  var _sql="select  ROLENAME, ROLEUSERNAME, ROLEFIELD,ROLEINDITYPE,TASKTO from MD.DEVWKFLOW_ROLE where FLOWCODE ='"+ModelCode+"'";
  var _t_select = new Asiainfo.data.AsiaInfoJsonStore({
	     sql:_sql,
	     initUrl:'/'+contextPath+'/newrecordService',
	     url:'/'+contextPath+'/newrecordService',
	     root:'root',
	     loadDataWhenInit:true 
      });
 
  if (_t_select.getCount()==0) alert('未知的需求模板:'+ModelCode); 
  for(var i=0;i<_t_select.getCount();i+=1){
     var _r = _t_select.getAt(i);
     if(i==0){
   	this._rolenames = _r.get('ROLENAME');
        this._roleusers = _r.get('ROLEUSERNAME');
        this._rolefields = _r.get('ROLEFIELD');
        this._roleIndiTypes = _r.get('ROLEINDITYPE');
        this.taskto = _r.get('TASKTO');
      }
      else{
   	  this._rolenames =this._rolenames +'#'+_r.get('ROLENAME');
   	  this._roleusers = this._roleusers+'#'+_r.get('ROLEUSERNAME');
   	  this._rolefields =this._rolefields+'#'+_r.get('ROLEFIELD');
   	  this._roleIndiTypes =this._roleIndiTypes+'#'+ _r.get('ROLEINDITYPE');
   	  this.taskto +="#"+ _r.get('TASKTO');
   	  }
   	};
  
};
flowdriver.prototype.Dealrule =function(instr){
  var outstr=instr  ;
  for(var i=0;i<this._store.columnModel.config.length;i+=1){
    outstr=outstr.replace('{'+this._store.columnModel.config[i].dataIndex+'}',this._rec.get(this._store.columnModel.config[i].dataIndex));
  };
  outstr = outstr.replace('IsFromIT',CheckUserIsITService(_UserInfo.usercnname)+' ');
  return outstr;
};
flowdriver.prototype.CheckReqForm= function (ActName,ActType){///审批操作提交前处理
    return true;
};
flowdriver.prototype.CheckReqFormAft= function (ActName,ActType,AuditInfo){///审批操作提交后处理
    return true;
};
flowdriver.prototype.reload = function(){//重新加载页面
   
  if(_self.NEWFORM=='' && _self.DEFAULTFORM==''){//在需求管理中新建时没有绑定工作流，考虑外部用户的链接
      var url=window.location+"";	 
     if(url.indexOf(this._keyfield)==-1 && url.indexOf('&')==-1)
         window.location=url+'?'+this._keyfield+'='+this._flowcode
     else window.location=window.location;    
   }
   else if(_self._rec.get('STATE')=='新建') 
   window.location='../devmgr/'+_self.NEWFORM+'?USERTYPE='+_UserInfo.USERTYPE+'&USERNAME='+_UserInfo.username+'&USERCNNAME='+_UserInfo.usercnname+'&REQCODE='+_self._flowcode
   else
   window.location='../devmgr/'+_self.DEFAULTFORM+'?USERTYPE='+_UserInfo.USERTYPE+'&USERNAME='+_UserInfo.username+'&USERCNNAME='+_UserInfo.usercnname+'&REQCODE='+_self._flowcode;	
};
 
flowdriver.prototype.ShowAuditAct =function(ActName){
  if(!_self.CheckReqForm(ActName)) return; ///调用检查表单
  	
  var hasWhere=false,onceNoWhere=false,proceType='普通';//条件;并行
  var tmpsql="select a.FLOWCODE,ACTNAME,ACTOWNER,PROMPT,a.STATENAME,a.AFTSTATENAME,b.DUTYER as aftdutyer "+
             "from MD.DEVWKFLOW_ACT a,MD.DEVWKFLOW_STATE b where a.flowcode like '"+this.ModelCode+"' and a.flowcode=b.flowcode "+
             "and a.aftstate=b.STATE and a.statename='"+this._rec.get('STATE')+"' and a.actname='"+ActName+"'";
 
  var ds_tmp = new Asiainfo.data.AsiaInfoJsonStore({
	     sql:tmpsql,
	     initUrl:'/'+contextPath+'/newrecordService', url:'/'+contextPath+'/newrecordService', root:'root', loadDataWhenInit:true 
      });
   var fitRowIndex=0;
   for(var i=0;i<ds_tmp.getCount();i++){
     var r=ds_tmp.getAt(i);
     if(r.get('PROMPT')){
     	hasWhere=true;
     	var rule=this.Dealrule(r.get('PROMPT'));
   	var bResult=eval(rule);
   	if(bResult) fitRowIndex=i;
     }
     else onceNoWhere=true;	
  };
  if(ds_tmp.getCount()==1)proceType='普通'
  else if(hasWhere && !onceNoWhere) proceType='条件' 
  else if(!hasWhere)  proceType='并行';
  else proceType='unkown';
  if( proceType=='并行' ||proceType=='unkown') {alert('错误,不支持:'+proceType);return};
  var r=ds_tmp.getAt(fitRowIndex);
  var aftdutyerRole=r.get('AFTDUTYER');
  var aftDutyerName='',vfield='ID', dfield='VALUE';
  var ds_fd_aftDutyer;
  var rolefield='';
  ///节点指定了特殊负责人 
  if(aftdutyerRole=='上一节点负责人') {
  	aftDutyerName=_self._rec.get('CURDUTYER');
  	ds_fd_aftDutyer= new Ext.data.SimpleStore({ fields:['ID','VALUE'], data:[[aftDutyerName,aftDutyerName]] });
  }
  else if(aftdutyerRole=='上一负责人指定'){
  	 aftDutyerName=' ';
  	 ds_fd_aftDutyer=ds_people;
  }
  else {///节点指定了流程角色的
    var rolenames =_self._rolenames.split('#');
    var roleusers =_self._roleusers.split('#');
    var rolefields =_self._rolefields.split('#');
    var roleIndiTypes =_self._roleIndiTypes.split('#');
    var i= rolenames.indexOf(aftdutyerRole);
    
    if(i==-1) {alert('错误,没有流程角色:'+aftdutyerRole);return;};
    rolefield=rolefields[i];
    
    if(rolefields[i] ){///有跟表单字段绑定的
    	aftDutyerName=_self._rec.get(rolefields[i] );
    	ds_fd_aftDutyer= new Ext.data.SimpleStore({ fields:['ID','VALUE'], data:[[aftDutyerName,aftDutyerName]] });
    };
    if(roleIndiTypes[i]=='常量'){
    	aftDutyerName=roleusers[i];
    	if(rolefields[i] && _self._rec.get(rolefields[i]))
    	  ds_fd_aftDutyer= new Ext.data.SimpleStore({ fields:['ID','VALUE'], data:[[_self._rec.get(rolefields[i]),_self._rec.get(rolefields[i])]] });
    	else 
    	 ds_fd_aftDutyer= new Ext.data.SimpleStore({ fields:['ID','VALUE'], data:[[aftDutyerName,aftDutyerName]] });
    	
    }
    else {///条件选择  运行时指定,选择变量,条件变量
    	//aftDutyerName=roleusers[i];
      if(roleusers[i] && roleusers[i].indexOf('select')!=-1){///sql语句选择
    	var _tmpsql=_self.Dealrule(roleusers[i]);
	    ds_fd_aftDutyer = new Asiainfo.data.AsiaInfoJsonStore({
	     sql:_tmpsql,
	     initUrl:'/'+contextPath+'/newrecordService', url:'/'+contextPath+'/newrecordService', root:'root',
	     loadDataWhenInit:true 
      });
      
      if(ds_fd_aftDutyer.recordFields.length==1) {vfield=ds_fd_aftDutyer.recordFields[0].name;dfield=ds_fd_aftDutyer.recordFields[0].name;}
      else{vfield=ds_fd_aftDutyer.recordFields[0].name;dfield=ds_fd_aftDutyer.recordFields[1].name;}
      if(ds_fd_aftDutyer.getCount()>0){
        aftDutyerName=ds_fd_aftDutyer.getAt(0).get(ds_fd_aftDutyer.columnModel.config[0].dataIndex);
      }
    }
    else if(roleusers[i]){
      var canSelusers=roleusers[i].split(',');
      var selUser=[];
      for(var i=0;i<canSelusers.length;i++)  
         selUser.push([canSelusers[i],canSelusers[i]]);
      ds_fd_aftDutyer= new Ext.data.SimpleStore({ fields:['ID','VALUE'], data:selUser});
    }
  }
 }
 
   var strInfo='当前状态:<b><font color=red>'+this._rec.get('STATE')+'</font></b>,您的操作:<b><font color=red>'+ActName+'</font></b>';
      
   
  var fd_aftState=new Ext.form.TextField({width:320,fieldLabel:'<b>下一环节',value:r.get('AFTSTATENAME'),disabled:true});
   var fd_aftDutyer = new Ext.form.ComboBox({
	    width:200,fieldLabel:'<b>负责人</b>',
	     mode: 'local', triggerAction:'all', store:ds_fd_aftDutyer,
      	     valueField:vfield ,displayField: dfield,
      	     editable:true,disabled:false,
             allowBlank:false
 });
  if(aftDutyerName) fd_aftDutyer.setValue(aftDutyerName); 
  fd_aftDutyer.on('render',function(){
     var bd = Ext.getDom(this.id);    
     var bd2 = Ext.get(bd.parentNode);
     bd2.createChild([{tag:'span',html:'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;('+aftdutyerRole+')'}]);  
});  
  var fd_Advice=new Ext.form.TextArea({
  	//width:320,height:60,fieldLabel: '<b>您的建议'
  	fieldLabel:'<b>您的建议</b>',
	     id:'Advice1', 
	     width: 320,
	     height: 60,
	     //anchor:'92%',
	     maxLength:800,
	     maxLengthText :'需求描述请勿超过200个汉字！',
      allowBlank:false
  	});
//  if (typeof(fd_Advice_main)!='undefined'){
//  	fd_Advice.setValue(fd_Advice_main.getValue());
//  }
  var fmAudit = new Ext.FormPanel({
      height:372,width:400,border:false,
       autoScroll:true, region:'center',
	     buttons:[], items:[fd_aftState,fd_aftDutyer,fd_Advice] 
  });

  var _aduitwin = new Ext.Window({ 
	         title:'审核信息:'+strInfo, layout:'fit',  id:'_wkflowtmpwin',
	         width:450, height:280, border:false, modal: true, // <-- 设置为 模式窗口,    
	         items:[fmAudit],
	         buttons: [{ text: "确定",  handler: onOKSave,    scope: this }, 
	                   { text: "退出", handler: closeWin,  scope: this  }
	                  ]   
	           
         });
   _aduitwin.show();
function onOKSave(){ 
   var AuditInfo={};
   AuditInfo.roleField=rolefield;
   AuditInfo.aftState=fd_aftState.getValue();
   AuditInfo.aftDutyer=fd_aftDutyer.getValue();
   AuditInfo.advice=fd_Advice.getValue();
   if ((AuditInfo.aftState=='不通过'||AuditInfo.aftState=='拒绝')&&!AuditInfo.advice){alert('请填写原因!');return;}
   if(!AuditInfo.aftDutyer){alert('请先指定下一环节负责人');return};
   AuditInfo.ActName=ActName;
   AuditInfo.aftdutyerRole=r.get('AFTDUTYER');
   if(!_self.CheckReqFormAft('Audit',ActName,AuditInfo)) return;
    _aduitwin.destroy();      
   _self.AuditActProcess(AuditInfo);
  
};    
function closeWin(){
  if (_aduitwin)  _aduitwin.destroy();    
};
  
};
flowdriver.prototype.AuditAct =function(button,e) {
   _self._store.commit(false);
   var aftusername;
   if(button.id=='VIEWLOG'){
      Asiainfo.addTabSheet(_self._flowcode+'log','日志:'+_self._flowcode,'./asiainfo/ProcGraph/workflowlog.html?FLOWCODE='+_self.ModelCode+'&REQCODE='+_self._flowcode);
      return;
   };
   _self.ShowAuditAct(button.text);
}
flowdriver.prototype.AuditActProcess =function(AuditInfo) {
  this.taskname =this._rec.get(this._titlefield);
  if(_self._rec.get('STATE')=='新建') _self.AddFlowLog(_UserInfo.usercnname,'新建','新建','新建');
  ///是否存在代理人设置 
  
  var agent=_self.getAgent(AuditInfo.aftdutyerRole);
   
  
  var curState=_self._rec.get('STATE');
  _self._rec.set('STATE',AuditInfo.aftState);
  var serverDate = getServerDate();
  _self._rec.set('STATE_DATE',new Date());
  _self._rec.set('STATE_DATE',new Date(serverDate));//wqs,服务还没有
  _self._rec.set('CURDUTYER',agent?agent:AuditInfo.aftDutyer);
  if(agent){ 
  	_self._rec.set('CURAGENT',AuditInfo.aftDutyer);
   }
  if(AuditInfo.roleField){
  	_self._rec.set(AuditInfo.roleField,agent?agent:AuditInfo.aftDutyer);
  	_self._rec.set('CURAGENT',AuditInfo.aftDutyer);
  }
  _self._store.commit(false);
  
  ///记录日志
 _self.AddFlowLog(_UserInfo.usercnname,AuditInfo.ActName,curState,AuditInfo.aftState,AuditInfo.advice);
  ///如果有代理，给被代理者发短信
  if(agent){
  	//alert('即将发短信人：'+AuditInfo.aftDutyer);
    _self.SendSmsByUserName(AuditInfo.aftDutyer,this.taskname+',当前状态:'+AuditInfo.aftState+',已经提交给您的代理人:'+agent+'处理,请关注!');
  }
  ///发送短信给下一环节的人
  _self.SendSmsByUserName(AuditInfo.aftDutyer,this.taskname+',当前状态:'+AuditInfo.aftState+',负责人:'+(agent==''?agent:AuditInfo.aftDutyer)+',请关注!');
  ///发送短信给需求登记人
  
   if(_self._rec.get('CREATER')!=AuditInfo.aftDutyer)
   _self.SendSmsByUserName(_self._rec.get('CREATER'),'您登记的:'+this.taskname+',当前状态:'+AuditInfo.aftState+',负责人:'+AuditInfo.aftDutyer+',请关注!');
    ///发送短信给需求负责人
   if(!agent)
   alert('提交到下一环节:'+AuditInfo.aftState+'\n下一环节处理人:'+AuditInfo.aftdutyerRole+'('+AuditInfo.aftDutyer+')')
   else
   alert('提交到下一环节:'+AuditInfo.aftState+'\n下一环节处理人:'+AuditInfo.aftdutyerRole+'('+agent+'[代:'+AuditInfo.aftDutyer+'])')	
   _self.reload();
};
flowdriver.prototype.getAgent =function(dutyerRole) {///检查是否有代理设置
  var agent='';
  var roleNames=this._rolenames.split('#');
  var roleAgents=this.taskto.split('#');
  var roleIndex = roleNames.indexOf(dutyerRole);
  if(roleIndex!=-1) agent=roleAgents[roleIndex];
  return agent;
};
flowdriver.prototype.FuncsAct = function(button,e){//功能操作
   
   if(_self.CheckReqForm) _self.CheckReqForm(button.text,'FUNACT');
}; 
 
flowdriver.prototype.SetStateInfo = function(addFunList) {
   var state=this._rec.get('STATE');
   var _sql="select a.FLOWCODE, a.STATE, a.ACTNAME, a.ACTOWNER, a.AFTSTATE, b.FUNC,b.DUTYER, a.PROMPT, a.SUBSTATE, a.AFTERSUBSTATE, a.ACT, a.STATENAME, a.AFTSTATENAME from MD.DEVWKFLOW_ACT a,MD.DEVWKFLOW_STATE b  "+
  	    "where a.flowcode=b.flowcode and a.STATENAME=b.STATENAME and a.flowcode='"+this.ModelCode+"' and a.STATENAME='"+state+"'";
   var _t_select = new Asiainfo.data.AsiaInfoJsonStore({
	     sql:_sql,
	     initUrl:'/'+contextPath+'/newrecordService',
	     url:'/'+contextPath+'/newrecordService',
	     root:'root',
	     loadDataWhenInit:true 
      });
   
   ///功能操作
  if(this.showDefaultFun){
  var btn_save= new Ext.Button({
     text: '保存',
     cls:'x-btn-text-icon',
     icon:'/'+contextPath+'/images/save.gif',
     disabled:(_self._store.getAt(0).get('CURDUTYER')==_UserInfo.usercnname)?false:true,
     handler:function(button,event){
     	 if(!_self.CheckReqForm())return;
       _self._store.commit();
       if(_self._substore)_self._substore.commit();
     }
    });
  this.tbar.addButton(btn_save);
  var btnRefresh= new Ext.Button({
       text:'刷新',
       id: 'Refresh',
       cls:'x-btn-text-icon',
       icon:'/'+contextPath+'/images/datasyn.gif',
       handler:function(){
        
       	history.go(0);
       	 } 
    }); 
    this.tbar.addButton(btnRefresh);
   var btn_log= new Ext.Button({
       text:'查看日志',
       id: 'VIEWLOG',
       cls:'x-btn-text-icon',
       icon:'/'+contextPath+'/images/yonghu.gif',
       handler:this.AuditAct
    });
   this.tbar.addButton(btn_log);
   this.tbar.addSeparator(); 
   var btn_rolbak= new Ext.Button({
       text:'回退',
       id: 'rolbak',
       tooltip:'可使用的人:sys 或者流程管理员',
       disabled:(_UserInfo.username=='sys'||_UserInfo.usercnname=='张韬')?false:true,
       cls:'x-btn-text-icon',
       icon:'/'+contextPath+'/images/application_go.png',
       handler:function(){
       	  var ds_hisState = new Asiainfo.data.AsiaInfoJsonStore({
	        sql:"select distinct USERNAME,STATE||'('||USERNAME||')' VSTATE,STATE from MD.DEVLOG where FLOWCODE='"+_self._flowcode+"'",
	        initUrl:'/'+contextPath+'/newrecordService',
	        url:'/'+contextPath+'/newrecordService',
	        root:'root',
	        loadDataWhenInit:true
	        });
       var fd_hisState = new Ext.form.ComboBox({
	        fieldLabel:'历史状态',
	        name:'',
	        width:100,
	        height:21,
	        
	        mode: 'remote',
	        disabled:false,
	        allowDomMove:false,
	        editable:true,
          triggerAction:'all',
          store:ds_hisState,
      	  valueField: 'STATE',displayField: 'VSTATE',
          allowBlank:false
      });
      var win = new Ext.Window({   
        title: "选择历史状态",    
        width: 300,
        height:200,
        minWidth: 200,
        minHeight: 200,
        layout: 'fit',
        plain:true,
        modal: true,
        bodyStyle:'padding:1px;',
        buttonAlign:'center',
             items: [fd_hisState],   
             buttons: [{   
                text: "确定", 
                handler: onOKSave,   
                scope: this  
            }, {   
                text: "退出",   
                handler: closeWin,   
                scope: this  
            }]   
    });
   function onOKSave(){
   	  if(_self._rec.get('STATE')==fd_hisState.getValue()){alert('您选择的回退状态跟当前状态一样,请重新选择');return};
   	  _self.AddFlowLog(_UserInfo.usercnname,'回退',_self._rec.get('STATE'),fd_hisState.getValue(),tb_advice.getValue());
      _self._rec.set('STATE',fd_hisState.getValue());
      for(var i=0;i<ds_hisState.getCount();i++){
      	if(ds_hisState.getAt(i).get('STATE')==fd_hisState.getValue())
      	  _self._rec.set('CURDUTYER',ds_hisState.getAt(i).get('USERNAME'));
      }
       _self.SendSmsByUserName(_self._rec.get('CURDUTYER'),'需求:'+_self._rec.get('REQNAME')+',状态回退到:'+fd_hisState.getValue()+',由您负责,请关注!');
       _self._store.commit();
       _self.reload();     
    };    
    function closeWin(){
      if (win)  win.hide();    
    }; 
    win.show();
       } 
    });
   this.tbar.addButton(btn_rolbak);
  };
  
  ///工作流程中配置的操作
   var _r = _t_select.getAt(0);
   if(_r){
      var funnum=0;
      var bAddtion=false;
      if(this._rec.get('CURDUTYER')==_UserInfo.usercnname ||this._rec.get('CURDUTYER')==_UserInfo.username) bAddtion=true;//如果是当前负责人
      var agent=this.getAgent(_r.get('DUTYER'));
      if(agent==_UserInfo.usercnname ||agent==_UserInfo.username) bAddtion=true;
      
      if(_r.get('FUNC')){this.tbar.addSeparator(); var _funcs=_r.get('FUNC').split(','); funnum=_funcs.length; };
       if(this._rec.get('CURDUTYER')==_UserInfo.usercnname) bAddtion=true;
       for(var i=0;i<funnum;i+=1)
       {  var btn= new Ext.Button({
               text:_funcs[i], id: _funcs[i],
               cls:'x-btn-text-icon',
               tooltip:'可使用的人:'+(_r.get('ACTOWNER')?_r.get('ACTOWNER'):'当前负责人')+'('+this._rec.get('CURDUTYER')+')',
               disabled:!bAddtion,icon:'/'+contextPath+'/images/icon_manage.gif',
               handler:this.FuncsAct
        });
        this.tbar.addButton(btn);  
       };
    };
   //审批操作
    this.tbar.addSeparator();
   var actStr='';
   for(var i=0;i<_t_select.getCount();i+=1){//对某个操作有操作权限条件:当前节点的负责人,如果连续操作有指定了负责人呢，则采用连续的负责人
   	  var _r = _t_select.getAt(i);
   	  if(actStr.indexOf('&&&'+_r.get('ACTNAME')+'&&&')!=-1)continue;
   	  actStr+='&&&'+_r.get('ACTNAME')+'&&&';
   	  
   	  var tooltip='可使用的人:'+(_r.get('ACTOWNER')?_r.get('ACTOWNER'):'当前负责人')+'('+this._rec.get('CURDUTYER')+')';
   	  var bAddtion=false; 
   	  
   	  if(this._rec.get('CURDUTYER')==_UserInfo.usercnname ||this._rec.get('CURDUTYER')==_UserInfo.username){//如果是当前负责人
   	  	 bAddtion=true;
   	  };
   	  
      var agent=this.getAgent(_r.get('DUTYER'));
      if(agent)  tooltip+=',及其代理人('+agent+')';
      
      if(agent==_UserInfo.usercnname ||agent==_UserInfo.username) bAddtion=true;
   	  if(_r.get('ACTOWNER') && _r.get('ACTOWNER').toUpperCase()=='ALL'){ bAddtion=true;tooltip='允许所有人操作'};
   	  
   	
   	  if (_r.get('ACTNAME')=='确认工作量' || _r.get('ACTNAME')=='系统部评估' || _r.get('ACTNAME')=='需求发起人评估' ||_r.get('ACTNAME')=='提交评估' ||_r.get('ACTNAME')=='评估确定'||_r.get('ACTNAME')=='确认考核'||_r.get('ACTNAME')=='确认完成') bAddtion=false; 
   	  var btn= new Ext.Button({ text: _r.get('ACTNAME'),disabled:!bAddtion,id: _r.get('ACT'),
              tooltip:tooltip,
              cls:'x-btn-text-icon', icon:'/'+contextPath+'/images/query.gif', handler:this.AuditAct
          });
         this.tbar.addButton(btn);  
   }	
};
flowdriver.prototype.AddFlowLog = function(username,actname,curstate,aftstate,remark){
	var ds_flowlog = new Asiainfo.data.AsiaInfoJsonStore({
			table:'MD.DEVLOG',
			root:'root',
			sql:"select FLOWCODE, USERNAME, ACTNAME, STATE, AFTSTATE,ADVICE from MD.DEVLOG where 1>2",
			initUrl:'/'+contextPath+'/newrecordService',
			url:'/'+contextPath+'/newrecordService',
			key:'FLOWCODE',
			loadDataWhenInit:true
		  });
	var _t_rec = ds_flowlog.newRecord();
	_t_rec.set('FLOWCODE',this._rec.get(this._keyfield));///wqs
	_t_rec.set('USERNAME',username);
	_t_rec.set('ACTNAME',actname);
	_t_rec.set('STATE',curstate);
	_t_rec.set('AFTSTATE',aftstate);
	_t_rec.set('ADVICE',remark);
	
	ds_flowlog.add(_t_rec);
	ds_flowlog.commit(false);
};
flowdriver.prototype.SendSmsByUserName = function(username,msg){
	 SendSmsByname(username,msg); 
	
};
function getServerDate(){
	 
  var serverDate = Asiainfo.currentTime();
  serverDate = serverDate.replace('年','/');
  serverDate = serverDate.replace('月','/');
  serverDate = serverDate.replace('日','');
  //alert('serverDate:'+serverDate);
  return serverDate ;
};
