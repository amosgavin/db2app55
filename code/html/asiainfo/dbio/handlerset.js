/**
	Ext的prompt框不能满足条件，它的文本框中没有默认文字，此自定义框弥补了不足
*/
Ext.MessageBox.promptWithValue = function(c,func){
	return Ext.MessageBox.show({
		title:c.title,
		msg:c.msg,
		buttons:Ext.MessageBox.OKCANCEL,//Ext.MessageBox[c.btns.join('').toUpperCase()]
		fn:func,
		icon: Ext.MessageBox.INFO,
		prompt:true,
        value:c.value
	});
};

/**
	重命名操作
	@param file_name 需要被重命名的文件名
	@param url 提交的路径地址
	@param parent 需要被重命名的文件的父路径(完整路径)
	@param success 更名成功后运行的方法
	@param fail 更名失败后运行的方法
	@param callback 最后会运行的方法
*/
var rename = function(config){
	Ext.MessageBox.promptWithValue({title:'重命名框',msg:'请输入新名称(<font color=red>\ / : * ? " < > | 除外</font>)',value:config.file_name
	},function(btn,text){
		if(btn=='ok'){
			var old_name = config.file_name;
			var new_name = text;
			if(old_name != new_name){
				if(text.match(/\<|\>|\\|\/|\*|\?|\||\:|\"/)){
					Ext.Msg.show({
					   title: '警告框',
					   msg: '请勿输入<font color=red> \ / : * ? " < > | </font>等非法字符',
					   width: 250
					});
					setTimeout(function(){
						Ext.MessageBox.hide();
					    rename(config);
					}, 1000);
				}else{
					if(text.replace(/^\s+|\s+$/g,'').length!=0){
						Ext.Ajax.request({
							url:config.url,
						    method:'POST',
						    params:{
						    	cmd:'rename',
						    	//debug:true,
						    	old_name:old_name,
						    	new_name:new_name,
						    	parent:config.parent
							},
							success:config.success || function(r,o){},
							fail:config.fail || function(r,o){},
							callback:config.callback || function(r,o){}
						});
					}
				}
			}
		}
	});
};
		
/**
	创建文件夹操作
	@param url 提交的路径地址
	@param path 要在哪个文件夹路径(path)下创建
	@param success 更名成功后运行的方法
	@param fail 更名失败后运行的方法
	@param callback 最后会运行的方法
*/		
var create_folder = function(config){
	 		
			Ext.Ajax.request({
				url:config.url,
				method:'POST',
				params:{
					cmd:'createFolder',
					//debug:true,
					path:config.path,
					folder_name:config.foldername
				},
				success:config.success || function(r,o){},
				fail:config.fail || function(r,o){},
				callback:config.callback || function(r,o){}
			});
};

/**
	删除文件夹操作
	@param url 提交的路径地址
	@param success 更名成功后运行的方法
	@param fail 更名失败后运行的方法
	@param callback 最后会运行的方法
	@param path 要删除的文件路径
*/
var remove = function(config){
	Ext.Msg.confirm('确认框','您确定吗？',function(btn){
		if(btn=='yes'){
			Ext.Ajax.request({
				url:config.url,
				method:'POST',
				params:{
					cmd:'delete',
					//debug:true,
					path:config.path
				},
				success:config.success || function(r,o){},
				fail:config.fail || function(r,o){},
				callback:config.callback || function(r,o){}
			});
		}
	})
};

/**
	刷新同步文件夹
	@param url 提交的路径地址
	@param success 更名成功后运行的方法
	@param fail 更名失败后运行的方法
	@param callback 最后会运行的方法
	@param path 要被刷新同步的文件夹
*/
var refresh = function(config){
	Ext.Ajax.request({
		url:config.url,
		method:'POST',
		params:{
			cmd:'list',
			path:config.path
		},
		success:config.success || function(r,o){},
		fail:config.fail || function(r,o){},
		callback:config.callback || function(r,o){}
	})
}

/**
	上传文件组件
	@param url 提交的路径地址

var upload = function(config){
	var dialog = new Ext.ux.UploadDialog.Dialog({
        url: config.url,
    	//modal: true,
    	reset_on_hide: false
    });
    
    this.getDialog = function(){return dialog;};
    
    this.show = function(c){
    	dialog.setBaseParams({
			cmd:'upload',
			uploadPath:c.uploadPath,
			over_write:c.over_write
		});
		dialog.show(c.btn);
    }
}
*/

var upload = function(form,uploadPath,c){
	
	 if(form.isValid()){
	  
		form.submit({
        	url: '/'+contextPath+'/fileupload',
            waitMsg: c.waitMsg || 'Uploading your file...',
            params :{
            	cmd:'upload',
				uploadPath:uploadPath,
				over_write:c.over_write || true
            },
            success: c.success || Ext.emptyFn,
            failure: c.failure || Ext.emptyFn
        });
	}
};

/**
	下载文件组件
	@param path 下载路径(相对的)
*/
var download = function(c){

	window.location.href=_url+'?cmd=download&filepath='+c.path+'&filename='+encodeURIComponent(encodeURIComponent(c.fileName));
}

/*
	生成export的sql语句
*/
var getExportSql = function(c){
	var table = c.table;
	var columns = c.columns;
	var sql="SELECT ";
	sql+=columns.join(",");
	sql+=" FROM "+table+" with ur";
	c.exportSql = sql;
	return c;
}

/*
	生成import的sql语句
*/
var getImportSql = function(c){
	var table = c.table;
	var columns = c.columns;
	var sql = "of del insert into "+table;
	if(columns && columns.length>0){
		sql+="(";
		sql+=columns.join(",");
		sql+=")";
	}
	c.importSql = sql;
	return c;
}
