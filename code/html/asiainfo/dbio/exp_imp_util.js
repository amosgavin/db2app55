var contextPath = window.location['pathname'].split('/')[1];
var _url = '/'+contextPath+'/fileMgr';
var push_sql_db2 = function(f,r,c){
	if(f=='conn'){
		r.sql_cmds.push('DB2 CONNECT TO '+c.databaseName+' USER '+c.username+' USING '+c.password);
	}else if(f=='disconn'){
		r.sql_cmds.push('DB2 DISCONNECT '+c.databaseName);
		r.sql_cmds.push('DB2 QUIT');
	}
};

var db2_data_type_separator = function(data_type,sepa){
	if(data_type == 'DEL'){
		return ' MODIFIED BY COLDEL0x'+char2Hex(sepa);
	}else if(data_type == 'IXF'){
		return ' ';
	}else{
		return ' ';
	}
};
var download = function(path,fileName){
 
	window.location.href=_url+'?cmd=download&filepath='+path+'&filename='+encodeURIComponent(encodeURIComponent(fileName));
}
var db2_export = function(c){
	var r = {sql_cmds:[],cmd:'databaseDataExport'};
	var exportPath = spell_right_relative_path(c.exportPath);
	if(c.db_id){
		r.db_id = c.db_id;
		c.databaseName = '?databaseName?';
		c.username = '?username?';
		c.password = '?password?';
	}
	push_sql_db2('conn',r,c);
	var sepa = c.sepa || ',';
	var data_type = c.data_type.toUpperCase() || 'DEL';
	if(c.sql){
		c.sql = c.sql.replace(/%{1}/g,'%%');
		r.sql_cmds.push('DB2 "EXPORT TO '+exportPath+' OF '+data_type+db2_data_type_separator(data_type,sepa)+' '+encodeURIComponent(encodeURIComponent(c.sql))+'"');
	}else{
		if(!c.whereCaluse)c.whereCaluse='1=1';c.whereCaluse = c.whereCaluse.replace(/%{1}/g,'%%');
		r.sql_cmds.push('DB2 "EXPORT TO '+exportPath+' OF '+data_type+db2_data_type_separator(data_type,sepa)+' SELECT '+c.columns.join(',')+' FROM '+c.table+' WHERE '+c.whereCaluse+' WITH UR"');
	}
	push_sql_db2('disconn',r,c);
	return r;
};

var db2_import = function(c){
	var r = {sql_cmds:[],cmd:'databaseDataImport'};
	var importFile = spell_right_relative_path(c.importFile);
	if(c.db_id){
		r.db_id = c.db_id;
		c.databaseName = '?databaseName?';
		c.username = '?username?';
		c.password = '?password?';
	}
	push_sql_db2('conn',r,c);
	var sepa = c.sepa || ',';
	var data_type = c.data_type.toUpperCase() || 'DEL';
	var columns;
	if(c.columns.length==0 || c.columns[0]=='*'){
		columns = '';
	}else{
		columns = '('+c.columns.join(',')+')';
	}
	r.sql_cmds.push('DB2 "IMPORT FROM '+importFile+' OF '+data_type+db2_data_type_separator(data_type,sepa)+' INSERT INTO '+c.table+columns);
	push_sql_db2('disconn',r,c);
	return r;
};

var oracle_export = function(c){
	var r = {sql_cmds:[],cmd:'databaseDataExport'};
	var exportPath = spell_right_relative_path(c.exportPath);
	if(c.db_id){
		r.db_id = c.db_id;
		c.username = '?username?';
		c.password = '?password?';
		c.databaseName = '?databaseName?';
	}
	r.sql_cmds.push('conn '+c.username+'/'+c.password+'@'+c.databaseName+';');
	r.sql_cmds.push('spool '+exportPath+';');
	r.sql_cmds.push('set heading off;');
	if(c.sepa)r.sql_cmds.push("set colsep '"+c.sepa+"';");
	if(c.sql){
		if(!c.whereCaluse)c.whereCaluse='1=1';
		r.sql_cmds.push('SELECT '+c.columns.join(',')+' FROM '+c.table+' WHERE '+(c.whereCaluse)+';');
	}else{
		r.sql_cmds.push(c.sql);
	}
	
	r.sql_cmds.push('spool off;');
	r.sql_cmds.push('exit;');
	r.sql_cmds.push('quit;');
	return r;
};

var oracle_import = function(c){
	var r = {sql_cmds:[],cmd:'databaseDataImport'};
	var importFile = spell_right_relative_path(c.importFile);
	if(c.db_id){
		r.db_id = c.db_id;
		c.username = '?username?';
		c.password = '?password?';
		c.databaseName = '?databaseName?';
	}
	r.sql_cmds.push('load data');
	r.sql_cmds.push("infile '"+importFile+"'");
	r.sql_cmds.push(''+c.add_way+' table '+c.table+'');
	r.sql_cmds.push("fields terminated by X'"+char2Hex(c.sepa || '\t')+"'");
	r.sql_cmds.push('('+c.columns.join(',')+')'); 
	return r;
};

var spell_right_relative_path = function(p){
	while(p.indexOf('/')===0 || p.indexOf('\\')===0){
		p = p.substr(1);
	}
	return p;
};

var char2Hex = function(c){
	var sl = parseInt(c.charCodeAt(),10).toString(16);
	if(sl.length==1){
		sl = '0'+sl;
	}
	//sl = '0x'+sl;
	return sl;
};

var sendAjax = function(c){
	Ext.Ajax.request({
		method:'POST',
		url:_url,
		params:c.params,
		success:c.success || function(){},
		failure:c.failure || function(){},
		callback:c.callback || function(){}
	});
};
/**
	@param db_id 在dbconfig.xml中配置的<id>值，通过它读取数据库信息，包括username、password、databaseName
	@param (username、password、databaseName)在没有配置db_id时起作用，作为保留接口
	@param sepa 在导入文件中，以什么作为分隔符
	@param importFile 导入文件在服务器上的路径，写成相对路径形式，如/flow.txt,则F:\apache-tomcat-5.5.20\webapps\FileManager\flow.txt为导入文本
	@param table 导入到哪张表
	@param columns 数组类型，列对应关系，如['TABLE_NAME','VALUE_LENGTH','PERFIX_WORD']，则文本中第一列对应TABLE_NAME,第二列对应VALUE_LENGTH,第三列对应PERFIX_WORD
	@param (success、failure、callback)为发送ajax请求后所需的回调函数
	@return 没有返回值
*/
var data_import = function(c){
	im_ex_port(c,'import');
};

/**
	@param db_id 在dbconfig.xml中配置的<id>值，通过它读取数据库信息，包括username、password、databaseName
	@param (username、password、databaseName)在没有配置db_id时起作用，作为保留接口
	@param table 需要导出的表
	@param columns 数组类型，需要导出的列
	@param whereCaluse where字句，一般如这种形式：TABLE_NAME LIKE ='test' AND VALUE=1 OR VALUE=9 AND AGE IN (6,8,9)
	@param sql 有时并不想提供table,columns,whereCaluse三种参数的方式而想直接写sql语句，则可以提供次参数，一旦提供了sql则前述三参数作废处理（亦即sql优先处理）
	@param data_type 这是一个db2相关参数，与其它数据库无关，可以为DEL或IXF
	@param sepa 导出的数据以什么为分隔符，db2默认为逗号，oracle默认为制表符，
	@param exportPath 导出路径，一般写/FLOW_IDMANAGER.txt则为导出为工程根路径下的FLOW_IDMANAGER.txt文件，根路径定义为“webapps\工程名”
	@param (success、failure、callback)为发送ajax请求后所需的回调函数
	@return 没有返回值
*/
var data_export = function(c){
	im_ex_port(c,'export');
}

var im_ex_port = function(c,_t){
	sendAjax({
		params:{dbId:c.db_id,cmd:'getDBType'},
		success:function(r,o){
			var m = eval('('+r.responseText+')')['result'];
			c.params = eval(m+'_'+_t)(c);
			sendAjax(c);
		}
	});
}
/**
	@db2数据库导出到文件函数
	@param db_id 在dbconfig.xml中配置的<id>值，通过它读取数据库信息，包括username、password、databaseName
	@param sql 导出的sql语句
	@param exportPath 导出路径，一般写/FLOW_IDMANAGER.txt则为导出为工程根路径下的FLOW_IDMANAGER.txt文件，根路径定义为“webapps\工程名”
	@param data_type 数据类型，是DEL还是IXF类型，目前只支持这两种类型
	@param c 配置回调函数的Object，格式如下{success:function(r,o){alert(o.reponseText);},failure:function(r,o){alert(o.reponseText);}}
	@return 没有返回值
*/	
var db2Export = function(db_id,sql,exportPath,data_type,c){
	im_ex_port({
		db_id:db_id,
		sql:sql,
		exportPath:exportPath,
		data_type:data_type,
		success: c.success || Ext.emptyFn,
        failure: c.failure || Ext.emptyFn
	},'export');
};

/**
	@db2从文件导入到数据库函数
	@param db_id 在dbconfig.xml中配置的<id>值，通过它读取数据库信息，包括username、password、databaseName
	@param importFile 导入文件在服务器上的路径，写成相对路径形式，如/flow.txt,则F:\apache-tomcat-5.5.20\webapps\FileManager\flow.txt为导入文本
	@param table 导入到哪张表
	@param columns 数组类型，列对应关系，如['TABLE_NAME','VALUE_LENGTH','PERFIX_WORD']，则文本中第一列对应TABLE_NAME,第二列对应VALUE_LENGTH,第三列对应PERFIX_WORD，如果为['*']或[]则默认导入所有列
	@param data_type 数据类型，是DEL还是IXF类型，目前只支持这两种类型
	@param c 配置回调函数的Object，格式如下{success:function(r,o){alert(o.reponseText);},failure:function(r,o){alert(o.reponseText);}}
	@return 没有返回值
*/
var db2Import = function(db_id,importFile,table,columns,data_type,c){
	im_ex_port({
		db_id:db_id,
		importFile:importFile,
		table:table,
		columns:columns,
		data_type:data_type,
		success: c.success || Ext.emptyFn,
        failure: c.failure || Ext.emptyFn
	},'import');
}

