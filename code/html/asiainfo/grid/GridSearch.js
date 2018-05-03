Ext.util.FormSubmit = function(url,params){
	//手工创建form表单
	var submitForm = document.createElement("FORM");
	//手工放置在body中
	document.body.appendChild(submitForm);
	//设置提交方式
	submitForm.method = "POST";
	//在表单中设置参数
	//alert(params);
	for(var key in params){
		var value = params[key];
		
		var arr = [];
		if(typeof value=='string'){
			arr.push(value);
		}else{
			arr = value;
		}
		
		for(var i=0,l=arr.length;i<l;i+=1){
			var newElement = document.createElement("<input name='"+(key)+"' type='hidden'>");
		 	submitForm.appendChild(newElement);
		 	newElement.value = (arr[i]);
		}
	}
	//手工设置提交地址
	submitForm.action=url;
	//手工提交
 	submitForm.submit();
};
function ShowSearch(grid){
	var dsPQ=new Ext.data.JsonStore({ 
   fields:["idx","relation","fieldname","operator","value","type"]  
});
var coldata=new Array();
for(var i=1;i<grid.colModel.getColumnCount();i++){
	var datatype='string';
  for(var j=0;j<grid.getStore().recordFields.length;j++){
		if(grid.getStore().recordFields[j].name==grid.colModel.getDataIndex(i))
		   {datatype=grid.getStore().recordFields[j].type ;break;} 
	}
	 
	var item={value:grid.colModel.getDataIndex(i),text:grid.colModel.getColumnHeader(i),type:datatype};
	coldata.push(item);
}

var fieldsDef = new Ext.data.JsonStore({ 
    fields: ['value','text','type'], 
    data:coldata
}); 

var numericOp = datetimeOp = new Ext.data.SimpleStore({ 
    fields: ['value','text'], 
    data : [['=','='],['<>','<>'],['<','<'],['<=','<='],['>','>'],['>=','>='],['is null','空白'],['is not null','非空白']] 
}); 
var stringOp = new Ext.data.SimpleStore({ 
    fields: ['value','text'], 
    data : [['=','='],['<>','<>'],['<','<'],['<','>'], 
    ['like |%','以...开头'],['like %|','以...结尾'],['like %|%','包含字符'],['not like %|%','不包含字符'], 
    ['is null','空白'],['is not null','非空白']] 
}); 
var lookupOp = booleanOp = new Ext.data.SimpleStore({ 
    fields: ['value','text'], 
    data : [['=','='],['<>','<>'],['is null','空白'],['is not null','非空白']] 
}); 

var objGridTextEditor = new Ext.grid.GridEditor(new Ext.form.TextField()); 
//var objGridMemoEditor = new Ext.grid.GridEditor(new Ext.form.TextArea()); 
var objGridDateEditor = new Ext.grid.GridEditor(new Ext.form.DateField({format:'Y-m-d'})); 
var objGridIntegerEditor = new Ext.grid.GridEditor(new Ext.form.NumberField({allowBlank:false,allowNegative:false,allowDecimals:false})); 
var objGridFloatEditor = new Ext.grid.GridEditor(new Ext.form.NumberField({allowBlank:false,allowNegative:false})); 
var objGridBooleanEditor = new Ext.grid.GridEditor(new Ext.form.ComboBox({ 
    store: [[true,'是'],[false,'否']], 
    mode: 'local', 
    readOnly: true, 
    triggerAction: 'all', 
    allowBlank: false, 
    editable: false, 
    forceSelection: true, 
    blankText:'请选择...' 
})); 
var objGridLookupEditor = new Ext.grid.GridEditor(new Ext.form.ComboBox({ 
    //store: [], 
    mode: 'local', 
    readOnly: true, 
    triggerAction: 'all', 
    allowBlank: false, 
    editable: false, 
    forceSelection: true, 
    blankText:'请选择...' 
})); 

function fileListChange(field,newValue,oldValue){ 
    //alert(field); 
} 
function findRecordValue(store,prop, propValue,field){ 
    var record; 
    if(store.getCount() > 0){ 
        store.each(function(r){ 
            if(r.data[prop] == propValue){ 
                record = r; 
                //return false; 
            } 
        }); 
    } 
    return record ? record.data[field] : ''; 
} 
function displayOperator(v){ 
    switch(v){ 
        case 'is null': return '空白'; 
        case 'is not null': return '非空白'; 
        case 'like |%': return '以...开头'; 
        case 'like %|': return '以...结尾'; 
        case 'like %|%': return '包含字符'; 
        case 'not like %|%': return '不包含字符'; 
        default: return v; 
    } 
} 
function displayValue(v, params, record){ 
    var dataType = findRecordValue(fieldsDef,'value',record.get('fieldname'),'type'); 
    var operator = record.get('operator'); 
    if (operator=='is null'||operator=='is not null') return ''; 
    switch(dataType){ 
        case 'date': return v ? v.dateFormat('Y-m-d'): ''; 
        case 'boolean': return (v?'是':'否'); 
        default: return v; 
    } 
} 

var qRowData = Ext.data.Record.create([ 
    {name:'idx',type:'int'}, 
    {name:'relation',type:'string'},  
    {name:'fieldname',type:'string'}, 
    {name:'operator',type:'string'}, 
    {name:'value',type:'string'}
]); 

var dsPQ=new Ext.data.JsonStore({ 
   data:[], 
   fields:["idx","relation","fieldname","operator","value"]  
}); 
var ds_fd_rela= new Ext.data.SimpleStore({
      		fields:['ID','VALUE'],
      		 data:[['and','并且'],['or','或者']]
      	});
var fd_rela = new Ext.form.ComboBox({
	     fieldLabel:'rela',
 
	     width:180,
	     height:21,
	     mode: 'local',
      triggerAction:'all',
      store:ds_fd_rela,
      	valueField: 'ID',displayField: 'VALUE',
      allowBlank:false
 });
 var ds_fd_caltype= new Ext.data.SimpleStore({
      		fields:['ID','VALUE'],
      		 data:[['is null','空白'],['is not null','不为空'],['like |%','以...开头'],['like %|','以...结尾'],['like %|%','包含字符'],['not like %|%','不包含字符'],['is not null','不为空']]
      	});
      
var fd_caltype = new Ext.form.ComboBox({
	     fieldLabel:'rela',
	     width:180,
	     height:21,
	     mode: 'local',
      triggerAction:'all',
      store:ds_fd_caltype,
      	valueField: 'ID',displayField: 'VALUE',
      allowBlank:false
 });
var colM=new Ext.grid.ColumnModel([ 
    { 
        header:"关系", 
        dataIndex:"relation", 
        width:50, 
        renderer: function(v){return (v=='and'?'并且':'或者')}, 
        editor: fd_rela 
    }, { 
        header:"字段名", 
        dataIndex:"fieldname", 
        width:130, 
        renderer: function(v){return findRecordValue(fieldsDef,'value',v,'text');}, 
        editor:new Ext.form.ComboBox({ 
            store: fieldsDef, 
            mode: 'local', 
            triggerAction: 'all', 
            valueField: 'value', 
            displayField: 'text', 
            editable: false, 
            listeners:{change:fileListChange} 
        }) 
    },{ 
        header:"运算符", 
        width:80, 
        dataIndex:"operator", 
        renderer: displayOperator 
    }, { 
        header:"内容", 
        dataIndex:"value", 
        width:130, 
        renderer: displayValue 
    }
]); 
//排序字段:
var ds_sorttype= new Ext.data.SimpleStore({
      		fields:['ID','VALUE'],
      		data:[['desc','降序'],['aesc','升序']]
 });
var fd_sordtype = new Ext.form.ComboBox({
	     fieldLabel:'rela',
	     width:50,
	     height:21,
	     blankText:'请选择...',
	     mode: 'local',
      triggerAction:'all',
      value:'desc',
      store:ds_sorttype,
      	valueField: 'ID',displayField: 'VALUE' 
 });
var fd_sord1 = new Ext.form.ComboBox({
	     fieldLabel:'rela',
	     width:80,
	     height:21,
	     blankText:'请选择...',
	     mode: 'local',
      triggerAction:'all',
      store:fieldsDef,
      	valueField: 'value',displayField: 'text' 
 });
 var fd_sord2 = new Ext.form.ComboBox({
	     fieldLabel:'rela',
	     width:80,
	     height:21,
	     mode: 'local',
      triggerAction:'all',
      blankText:'请选择...' ,
      store:fieldsDef,
      	valueField: 'value',displayField: 'text' 
 });
 var fd_sord3 = new Ext.form.ComboBox({
	     fieldLabel:'rela',
	     width:80,
	     height:21,
	     mode: 'local',
      triggerAction:'all',
      store:fieldsDef,
      blankText:'请选择...',
      valueField: 'value',displayField: 'text' 
 });
var grdDPQuery = new Ext.grid.EditorGridPanel({ 
    height:500, 
    width:490, 
    cm:colM, 
    sm:new Ext.grid.RowSelectionModel({singleSelect:false}), 
    store:dsPQ, 
    region:'center', 
    border: false, 
    enableColumnMove: false, 
    enableHdMenu: false, 
    loadMask: {msg:'加载数据...'}, 
    clicksToEdit:1, 
    bbar:[ 
        {text:'添加',handler:function(){ 
                var count = dsPQ.getCount(); 
                var r = new qRowData({idx:dsPQ.getCount(),relation:'and',fieldname:'',operator:'=',value:'',type:'string'}); 
                
                dsPQ.insert(count,r); 
                dsPQ.commitChanges(); 
            } 
        }, 
        {text:'删除',handler:function(){ 
                //store = grid.getStore(); 
                var selections = grdDPQuery.getSelectionModel().getSelections(); 
                for(var i = 0; i < selections.length; i++){  
                    dsPQ.remove(selections[i]);  
                } 
            } 
        }, 
        {text:'全部清除',handler:function(){dsPQ.removeAll();}},
        '-',
        '排序类型:',fd_sordtype,
        '字段:',fd_sord1,fd_sord2,fd_sord3,'-',
        {text:'查询',handler:function()
        	{     
        	      var where="";
                for(var i=0;i<dsPQ.getCount();i++){
                	var r=dsPQ.getAt(i);
                	if(r.get('relation') && r.get('fieldname') && r.get('operator')){
                		 var str="";
                     if(r.get('operator')== 'is null') str=" is null "
                     else if(r.get('operator')== 'is not null') str=" is not null "
                     else if(r.get('operator')== 'like |%') str=" like '%"+r.get('value')+"'" 
                     else if(r.get('operator')== 'like %|') str=" like '"+r.get('value')+"%'"
                     else if(r.get('operator')== 'like %|%') str=" like '%"+r.get('value')+"%'"
                     else if(r.get('operator')== 'not like %|%') str=" not like '%"+r.get('value')+"%'" ;
                    
                     if(str==""){
                     	 if(r.get('type')=='date') str=r.get('operator')+" '"+r.get('value').format('YYYY-MM-DD')+"'";
                     	 else if(r.get('type')=='string') str=r.get('operator')+" '"+r.get('value')+"'";
                     	 else  str=r.get('operator')+" "+r.get('value');
                     }
                		if(where=="") where=" "+ r.get('fieldname')+" "+ str
                		else where+=" "+r.get('relation')+" "+ r.get('fieldname')+" "+ str
                	} 
                }
                var order='',str='';
                if(fd_sordtype.getValue()=='desc')
                	str=' desc'
                else str='';
                 
                if(fd_sord1.getValue()) order=' order by '+fd_sord1.getValue()+str;
                if(fd_sord2.getValue()){if(order) order+=','+fd_sord2.getValue()+str;else order=' order by '+fd_sord2.getValue()+str}; 
                if(fd_sord3.getValue()){if(order) order+=','+fd_sord3.getValue()+str;else order=' order by '+fd_sord3.getValue()+str}; 
                if(where && order) grid.getStore().updateSql('select * from ('+grid.getStore().oldSql+') a where '+ where+order)
                else if(order) grid.getStore().updateSql('select * from ('+grid.getStore().oldSql+') a '+order)
                else if(where) grid.getStore().updateSql('select * from ('+grid.getStore().oldSql+') a where '+where);
                if(where || order) {
                  grid.getStore().select(); 
                }
                else {grid.getStore().updateSql(grid.getStore().oldSql); grid.getStore().select()};
            } 
        },
        {text:'close',handler:function(){searchwin.destroy()}}
        
    ], 
    listeners: { 
        afteredit: function(e){ 
            if (e.column==1/*e.field=='fieldname'*/){ 
                var oldDataType = findRecordValue(fieldsDef,'value',e.originalValue,'type'); 
                var newDataType = findRecordValue(fieldsDef,'value',e.value,'type'); 
                if (oldDataType!=newDataType){ 
                    e.record.set('operator', '='); 
                    e.record.set('value', '');
                    e.record.set('type', newDataType); 
                } 
            } 
        }, 
        cellclick: function(grid, rowIndex, columnIndex, e){ 
       
            if (columnIndex!=2&&columnIndex!=3) return;
            
            var record = grid.getStore().getAt(rowIndex);  // Get the Record 
            
            //var fieldName = grid.getColumnModel().getDataIndex(columnIndex); // Get field name 
            //var data = record.get(fieldName);
           
            var dataType = findRecordValue(fieldsDef,'value',record.get('fieldname'),'type');
            if (dataType=='') return;//未选定字段，退出 
            if (columnIndex==2){//绑定运算符 
                var grdEditor = grid.colModel.getCellEditor(columnIndex,rowIndex); 
                if (grdEditor) grdEditor.destroy(); 
                var _store; 
                switch(dataType){ 
                    case 'string': _store = stringOp; break; 
                    case 'date': _store = datetimeOp; break; 
                    case 'boolean': _store = booleanOp; break; 
                    case 'int': 
                    case 'float': _store = numericOp; break; 
                    case 'lookup': _store = lookupOp; break; 
                } 
                grdEditor = new Ext.form.ComboBox({ 
                    store: _store, 
                    mode: 'local', 
                    triggerAction: 'all', 
                    valueField: 'value', 
                    displayField: 'text', 
                    editable: false 
                }) 
                grid.colModel.setEditor(columnIndex, new Ext.grid.GridEditor(grdEditor)); 
            } 
            else if (columnIndex==3){//绑定编辑器 
                var operator = record.get('operator'); 
                if (operator=='is null'||operator=='is not null'){ 
                    grid.colModel.setEditor(columnIndex, null); 
                    return; 
                } 
                var grdEditor; 
                switch(dataType){ 
                    case 'string': grdEditor = objGridTextEditor; break; 
                    case 'date': grdEditor = objGridDateEditor; break; 
                    case 'boolean': grdEditor = objGridBooleanEditor; break; 
                    case 'int': grdEditor = objGridIntegerEditor; break; 
                    case 'float': grdEditor = objGridFloatEditor; break; 
                    case 'lookup': grdEditor = objGridLookupEditor; break; 
                } 
                if (grid.colModel.getCellEditor(columnIndex,rowIndex)!=grdEditor){ 
                    grid.colModel.setEditor(columnIndex, grdEditor); 
                } 
            } 
        } 
    } 
}); 
var searchwin = new Ext.Window({
			//el:div_id,
			layout:'fit',
			title:"查询与排序",
		    width:600,
		    height:330,
		    closeAction:'hide',
		    plain: true,
			items: [grdDPQuery], 
		    modal:true
		});
		searchwin.show();
}