Ext.namespace('Ext.ux','Ext.ux.plugins');
Ext.form.HtmlEditorImageInsert=function(config) {

    config=config||{};

    Ext.apply(this,config);

    this.init=function(htmlEditor) {
        this.editor=htmlEditor;
        this.editor.on('render',onRender,this);
    };

    this.imageInsertConfig={
        popTitle: config.popTitle||'Image URL',
        popMsg: config.popMsg||'Please select the URL of the image you want to insert:',
        popWidth: config.popWidth||350,
        popValue: config.popValue||''
    }

    this.imageInsert=function() {
        var range;
        if(Ext.isIE)
            range=this.editor.doc.selection.createRange();
        var msg=Ext.MessageBox.show({
            title: this.imageInsertConfig.popTitle,
            msg: this.imageInsertConfig.popMsg,
            width: this.imageInsertConfig.popWidth,
            buttons: Ext.MessageBox.OKCANCEL,
            prompt: true,
            value: this.imageInsertConfig.popValue,
            scope: this,
            fn: function(btn,text) {
                if(btn=='ok') {
                    if(Ext.isIE)
                        range.select();
                    this.editor.relayCmd('insertimage',text);
                }
            }
        });
        var win=msg.getDialog()
        win.show.defer(200,win)
    }

function onRender(){
   if( ! Ext.isSafari){
    this.editor.tb.add({
     itemId : 'htmlEditorImage',
     cls : 'x-btn-icon x-edit-insertimage',
     enableToggle : false,
     scope : this,
     handler : function(){
      this.imageInsert();
     },
     clickEvent : 'mousedown',
     tooltip : config.buttonTip || 
     {
      title : '插入图片',
      text : '插入图片到编辑器',
      cls : 'x-html-editor-tip'
     },
     tabIndex :- 1
    });
   }
}
}
Ext.form.HtmlEditor.Table = Ext.extend(Ext.util.Observable, {
    // private
    cmd: 'table',
    /**
     * @cfg {Array} tableBorderOptions
     * A nested array of value/display options to present to the user for table border style. Defaults to a simple list of 5 varrying border types.
     */
    tableBorderOptions: [['none', 'None'], ['1px solid #000', 'Sold Thin'], ['2px solid #000', 'Solid Thick'], ['1px dashed #000', 'Dashed'], ['1px dotted #000', 'Dotted']],
    // private
    init: function(cmp){
        this.cmp = cmp;
        this.cmp.on('render', this.onRender, this);
    },
    // private
    onRender: function(){
        var cmp = this.cmp;
        var btn = this.cmp.getToolbar().addButton({
            iconCls: 'x-edit-table',
            handler: function(){
            	 
                if (!this.tableWindow){
                     
                    this.tableWindow = new Ext.Window({
                        title: 'Insert Table',
                        closeAction: 'hide',
                        width:300,height:200,
                        items:[{
                            itemId: 'insert-table',
                            xtype: 'form',
                            border: false,
                            plain: true,
                            bodyStyle: 'padding: 10px;',
                            labelWidth: 60,
                            labelAlign: 'right',
                            items: [{
                                xtype: 'numberfield',
                                allowBlank: false,
                                allowDecimals: false,
                                fieldLabel: 'Rows',
                                name: 'row',
                                width: 60
                            }, {
                                xtype: 'numberfield',
                                allowBlank: false,
                                allowDecimals: false,
                                fieldLabel: 'Columns',
                                name: 'col',
                                width: 60
                            }, {
                                xtype: 'textfield',
                                fieldLabel: 'Border',
                                name: 'border',
                                forceSelection: true,
                                mode: 'local',
                                value:'1px solid #000',
                                 
                                width: 90
                            }]
                        }],
                        buttons: [{
                            text: 'Insert',
                            handler: function(){
                                var frm = this.tableWindow.getComponent('insert-table').getForm();
                                if (frm.isValid()) {
                                    var border = frm.findField('border').getValue();
                                    var rowcol = [frm.findField('row').getValue(), frm.findField('col').getValue()];
                                    if (rowcol.length == 2 && rowcol[0] > 0 && rowcol[0] < 10 && rowcol[1] > 0 && rowcol[1] < 10) {
                                        var html = "<table>";
                                        for (var row = 0; row < rowcol[0]; row++) {
                                            html += "<tr>";
                                            for (var col = 0; col < rowcol[1]; col++) {
                                                html += "<td width='20%' style='border: " + border + ";'>" + row + "-" + col + "</td>";
                                            }
                                            html += "</tr>";
                                        }
                                        html += "</table>";
                                        this.cmp.insertAtCursor(html);
                                    }
                                    this.tableWindow.hide();
                                }else{
                                    if (!frm.findField('row').isValid()){
                                        frm.findField('row').getEl().frame();
                                    }else if (!frm.findField('col').isValid()){
                                        frm.findField('col').getEl().frame();
                                    }
                                }
                            },
                            scope: this
                        }, {
                            text: 'Cancel',
                            handler: function(){
                                this.tableWindow.hide();
                            },
                            scope: this
                        }]
                    });
                
                }else{
                    this.tableWindow.getEl().frame();
                }
                this.tableWindow.show();
            },
            scope: this,
            tooltip: {
                title: 'Insert Table'
            },
            overflowText: 'Table'
        });
    }
});
Ext.form.HtmlEditor.HR = Ext.extend(Ext.util.Observable, {
    // private
    cmd: 'hr',
    // private
    init: function(cmp){
        this.cmp = cmp;
        this.cmp.on('render', this.onRender, this);
    },
    // private
    onRender: function(){
        var cmp = this.cmp;
        var btn = this.cmp.getToolbar().addButton({
            iconCls: 'x-edit-hr',
            handler: function(){
                if (!this.hrWindow){
                    this.hrWindow = new Ext.Window({
                        title: 'Insert Rule',
                        width:300,height:200,
                        closeAction: 'hide',
                        items: [{
                            itemId: 'insert-hr',
                            xtype: 'form',
                            border: false,
                            plain: true,
                            bodyStyle: 'padding: 10px;',
                            labelWidth: 60,
                            labelAlign: 'right',
                            items: [{
                                xtype: 'label',
                                html: 'Enter the width of the Rule in percentage<br/> followed by the % sign at the end, or to<br/> set a fixed width ommit the % symbol.<br/>&nbsp;'
                            }, {
                                xtype: 'textfield',
                                maskRe: /[0-9]|%/,
                                regex: /^[1-9][0-9%]{1,3}/,
                                fieldLabel: 'Width',
                                name: 'hrwidth',
                                width: 60,
                                 listeners: {
                                    specialkey: function(f, e){
                                        if ((e.getKey() == e.ENTER || e.getKey() == e.RETURN) && f.isValid()) {
                                            this.doInsertHR();
                                        }else{
                                            f.getEl().frame();
                                        }
                                    },
                                    scope: this
                                }
                            }]
                        }],
                        buttons: [{
                            text: 'Insert',
                            handler: function(){
                                var frm = this.hrWindow.getComponent('insert-hr').getForm();
                                if (frm.isValid()){
                                    this.doInsertHR();
                                }else{
                                    frm.findField('hrwidth').getEl().frame();
                                }
    						},
                            scope: this
                        }, {
                            text: 'Cancel',
                            handler: function(){
                                this.hrWindow.hide();
                            },
                            scope: this
                        }]
                    });
                }else{
                    this.hrWindow.getEl().frame();
                }
                this.hrWindow.show();
            },
            scope: this,
            tooltip: {
                title: 'Insert Horizontal Rule'
            },
            overflowText: 'Horizontal Rule'
        });
    },
    // private
    doInsertHR: function(){
        var frm = this.hrWindow.getComponent('insert-hr').getForm();
        if (frm.isValid()) {
            var hrwidth = frm.findField('hrwidth').getValue();
            if (hrwidth) {
                this.insertHR(hrwidth);
            } else {
                this.insertHR('100%');
            }
            frm.reset();
            this.hrWindow.hide();
        }
    },
    /**
     * Insert a horizontal rule into the document.
     * @param w String The width of the horizontal rule as the <tt>width</tt> attribute of the HR tag expects. ie: '100%' or '400' (pixels).
     */
    insertHR: function(w){
        this.cmp.insertAtCursor('<hr width="' + w + '">');
    }
});
 Ext.form.HtmlEditor.Image = Ext.extend(Ext.util.Observable, {
    // private
    cmd: 'image',
    // private
    init: function(cmp){
        this.cmp = cmp;
        this.cmp.on('render', this.onRender, this);
    },
    // private
    onRender: function(){
        var cmp = this.cmp;
        var btn = this.cmp.getToolbar().addButton({
            iconCls: 'x-edit-hr',
            handler: function(){
             if (!this.imageWindow){
                this.imgform = new Ext.FormPanel({
            itemId: 'insert-image',
            region : 'center',
            labelWidth : 55,
            frame : true,
            bodyStyle : 'padding:5px 5px 0',
            autoScroll : true,
            border : false,
            fileUpload : true,
            items : [{
                        xtype : 'textfield',
                        fieldLabel : '选择文件',
                        name : 'userfile',
                        inputType : 'file',
                        allowBlank : false,
                        blankText : '文件不能为空',
                        height : 25,
                        anchor : '90%'
                    }]
                    });

             this.imageWindow = new Ext.Window({
                        title: 'Insert Rule',
                        width:300,height:200,
                        closeAction: 'hide',
                        items: [this.imgform ] ,
            buttons : [{
                text : '上传',
                type : 'submit',
                scope: this,
                handler : function() {
                    
                    if (!this.imgform.form.isValid()) {return;}
                    upload(this.imgform.getForm(),'/tmp/',{
	               		waitMsg:'正在上传，请稍候.......',
	               		over_write:true,
	               		success:this.insertImage(cmp),
	               		failure:function(panel,o){
	               			alert('上传失败');
	               		}});
	               		
                    
                }
            }, {
                text : '关闭',
                type : 'submit',scope: this,
                handler : function() {
                    this.imageWindow.hide();
                }
            }]
                    });
                }else{
                    this.imageWindow.getEl().frame();
                }
                this.imageWindow.show();
            },
            scope: this,
            tooltip: {
                title: 'Insert Image'
            },
            overflowText: 'Image'
        });
    },
    insertImage: function(cmp){
    	var fileName =this.imgform.getForm().findField('userfile').getValue();
    	fileName=fileName.substring(fileName.lastIndexOf('\\')+1);
         var element = document.createElement("img");
         element.src = "../tmp/"+fileName;//action.result.fileURL;
                            if (Ext.isIE) {
                                this.cmp.insertAtCursor(element.outerHTML);
                            } else {
                                var selection = this.cmp.win.getSelection();
                                if (!selection.isCollapsed) {
                                    selection.deleteFromDocument();
                                }
                                selection.getRangeAt(0).insertNode(element);
                            }
                            this.imageWindow.hide();
                       
    }
     
});