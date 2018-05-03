/**
 * @author jason.cheng
 */
 
Ext.namespace("Asiainfo.form");

Asiainfo.form.AsiainfoFormPanel = Ext.extend(Ext.form.FormPanel, {
	
	//Ext.data.Record 同步form表单的值与store值的同步,record 和 oRecord属性 两个必须有一个赋值
	record : null,
	
	oRecord :'',
	
	store : null,
    
    // private
	initComponent : function() {
		//如果record对象为空的话，就创建对象
		alert('初始化form');
		if(this.record == null){
			var record = Ext.data.Record.create(this.oRecord);
			this.record = new record({});
		}	
		Asiainfo.form.AsiainfoFormPanel.superclass.initComponent.call(this);

	},
	
   /**
    * 保存数据到ExtExt.data.Record对象中，再由Ext.data.Record对象将数据放入store对象中
    */
	save : function(){
		var form = this;
		if(form.getForm().isValid()){
			for(var i = 0;i<this.oRecord.length;i++){
				this.record.set(this.oRecord[i].name,form.getForm().findField(this.oRecord[i].name).getValue());
	        }
	        
	        if(this.store != null){
	        	this.store.save({params:{conditionsValue:this.record.data}});
	        	//调用store的insert方法，将要保存的数据放入store中，然后有store统一提交
	        }
		}
		else
			Ext.Msg.alert("错误", "表单数据为空或者格式不对!请重新填写");
            
	}
});