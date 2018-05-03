Ext.namespace("Asiainfo.grid");

Asiainfo.grid.GridPanel = Ext.extend(Ext.grid.EditorGridPanel, {
	
	//Ext.grid.GridPanel
	
	// 储存表格结构
	structure : '',
	
	
	root : '',
	
	//给grid加入form，使其与form关联
	form:'',


	// 指定加载的列 默认为读取表上所有列数据
	fields : '',

	// 每页显示条数
	pageSize : '15',
	
	bodyStyle:'Height:100%;',
    bodyStyle:'width:100%;' ,

	// 表单里控件的默认宽
	fieldwidth : 100,
	
	// 表格主键
	keyField : '',

	// 绑定查询的列
	findField : null,

	// 是否需要分组，默认为false，如果设置为true须再设置两个参数一个为myGroupField和myGroupTextTpl
	needGroup : false,

	// 分组的字段名称
	myGroupField : '',
	// 分组显示的模板，eg：{text} ({[values.rs.length]} {[values.rs.length > 1 ?
	// "Items" : "Item"]})
	myGroupTextTpl : '',

	// 列模式的选择模式,默认为rowselectModel，如果相设置成check模式，就设置为check
	selectType : '',

	// 默认排序字段
	defaultSortField : 'id',

	// 是否需要分页工具栏，默认为true
	needPage : true,
	//frame : false,
	frame:true,
	
	isEditor:false,
	
	
	
	//layout:'fit',
	//autoWidth :true,
	//autoScroll:true,

	// 是否带展开按钮，默认为false
	collapsible : false,

	animCollapse : true,

	loadMask : true,

	viewConfig : {
		//forceFit : false,
		//width:300,
		autoScroll:true
	},

	// 存储表头信息

	col : null,
	// private
	initComponent : function() {
		if (this.structure != '') {
			this.initStructure();
		}
		
		if(this.form !=''){
			this.on("cellclick",function (){
			var record = this.getSelectionModel().getSelected();
			if(this.structure !=''){
				for(var i = 0;i<this.structure.length;i++){
					this.form.getForm().findField(this.structure[i].name).setValue(record.get(this.structure[i].name));
					//this.record.set(this.structure[i].name,form.getForm().findField(this.oRecord[i].name).getValue());
		        }
		        //Ext.util.JSON.encode(this.record.data)
			}
	     
    	}); 
		}
		
		Asiainfo.grid.GridPanel.superclass.initComponent.call(this);

	},


	// private

	initStructure : function() {

		var oDs = null;
		var oCM = new Array(); // 列模式数组
		
		var defaultValue = new Array();//编辑框新增一条记录的默认值
		
		var tempValue = new Array();
		var oRecord = new Array(); // 容器对数组
		// 构成grid的两个必须组件: column和record，根据structure将这两个组件创建出来

		// 判断表格的选择模式
		if (this.selectType == 'check') {
			var sm = new Ext.grid.CheckboxSelectionModel();
			oCM[oCM.length] = sm;// 在列模式数组中添加checkbox模式按钮
			this.selModel = sm;// 并将selModel设置为check模式
		}
		var len = this.structure.length;// 得到结构的长度
		for (var i = 0; i < len; i++) {
			var c = this.structure[i];
		
			// alert( c.hidden ? c.width: this.fieldwidth)
			// 如果字段为hidden，则不生成filters和columnMode
		
			// 默认格式化日期列
			/**
			if (c.type == 'date' && !c.renderer) {
				c.renderer = this.formatDate;
			}
			*/
			var fm = Ext.form;
			
			oCM[oCM.length] = {
				header : c.header,
				dataIndex : c.name,
				hidden : c.hidden || false,
				width : !c.hidden ? c.width : this.fieldwidth,
				readOnly : c.readOnly,
				// 类型为数字则右对齐
				align : c.type == 'numeric' ? 'right' : 'left',
				
				// 结构的渲染函数
				renderer : c.renderer,
				editor: this.editorRender(c.type)
				
			};
			
		
			oRecord[oRecord.length] = {
				name : c.name,
				// 如果类型不是date型则全部为string型
				type : c.type == 'date' ? 'date' : 'string'
				//dateFormat : 'Y-m-d'
			};
		}
		
		

		this.col = oCM;
		// 生成columnModel
		this.cm = new Ext.grid.ColumnModel(oCM);
		// this.colModel = this.cm;
		// 默认可排序
		this.cm.defaultSortable = true;
		
		// 生成表格数据容器
		var record = Ext.data.Record.create(oRecord);
		
		// 判断读取类别，目前只实现了，jsonreader和arrayReader
		var reader;
		var pageSize = this.pageSize;
		var fields = this.fields;

		// 生成分页工具栏
		
	

		if (this.needPage) {
			var pagingToolbar = new Ext.PagingToolbar({
					displayInfo : true,
					displayMsg : '当前记录数:{0} - {1} 总记录数: {2}',
					emptyMsg : '没有符合条件的记录',
					store : this.store
			});
			pagingToolbar.pageSize = this.pageSize;
			this.bbar = pagingToolbar;
			this.bottomToolbar = this.bbar;
	
			
			var ogrid = this;
			var keyField = this.keyField;
			// 生成顶部工具条
			
			
			var topToolbar = new Ext.Toolbar({
						items : [{
									iconCls : 'add',
									text : "添加",
									handler : function() {
       									 win.show();
									}
								 },								 
								 	{
									iconCls : 'save',
									text : "修改",
									handler : function() {
										ogrid.doEdit();
									}
								 }, {
										iconCls : 'remove',
										text : "删除",
										handler : function() {
												ogrid.doDelete();
										}
								 },{
										iconCls : 'x-btn-text x-tbar-loading',
										text : "导出",	
										handler : function() {
											alert('调用导出的方法');
										}
								}, {
										iconCls : 'x-btn-text x-tbar-loading',
										text : "刷新",
										handler : function() {
											ogrid.getStore().reload();
										},
										scope : this
								}		
						 ]
			   })
			 }
		
			this.tbar = topToolbar;
			this.topToolbar = this.tbar;
		
			
		
		
		
			//this.store.load();
		},
		
		editorRender: function(c){
		 	switch (c) {
				case 'string' : return new Ext.form.Field({
									allowBlank: false
								}); 
						break;
				case 'date' : return new Ext.form.DateField({
									format : 'Y-m-d',
									minValue : '1800-01-01',
									readOnly : true
							  }); 
						break;	
					
				default :break;
			
			}
		
		},
		
		/*
		* @功能：编辑用户选中的数据 @参数：id 为空则为新增数据 不为空则为修改数据
		* 
		*/
		doEdit : function(id) {
			
			var records = this.store.getModifiedRecords();
			var len = records.length;
			
			alert(len);
			
			//update({params:{conditions:'FLOWCODE = :FLOWCODE',conditionsValue:{FLOWCODE:'workflow1'},updateFieldsValue:{FLOWNAME:'update更新数据'}}});
			var condition = this.keyField + '= :'+ this.keyField;
			for(var i=0;i<len;i++){
				alert(Ext.util.JSON.encode(records[i].getChanges()));
			  	this.store.update({params:{conditions:condition,conditionsValue:records[i].data,updateFieldsValue:records[i].getChanges()}});
			}
		},
	
		/*
		* @功能：删除所有选中记录支持批量删除
		* 
		*/
	
		doDelete : function() {
			var records = this.getSelectionModel().getSelections();
			var len = this.getSelectionModel().getSelections().length;
			for(var i = 0; i<len; i++){
				var record = this.getSelectionModel().getSelections()[i];
				var condition = this.keyField + '= :'+ this.keyField;
				
				var data = record.data;
				this.store.del({params:{conditions:condition,conditionsValue:data}});
			}
			
			for(var i =0;i<records.length;i++)
			this.store.remove(records[i]);
			
			this.store.reload();
		},

		
		/*
		* @功能：请求成功显示信息
		*/
		doSuccess : function(action, form) {
		
		var ogrid = this;
		
		Ext.Msg.alert('提示', '操作成功');
			ogrid.getStore().reload();
		},
	
		/*
		* @功能：请求失败显示信息
		*/
		doFailure : function(action, form) {
			Ext.Msg.alert('请求错误', '服务器未响应，请稍后再试');
		},
	
		/*
		* @功能:默认的格式化日期函数 @返回格式：2008-09-21
		*/
		formatDate : function(v) {
			return v ? v.dateFormat('Y-m-d') : ''
		}

});
