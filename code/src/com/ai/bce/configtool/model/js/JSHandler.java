package com.ai.bce.configtool.model.js;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.ScriptOrFnNode;

import com.ai.bce.configtool.model.common.ModelUtils;
import com.ai.bce.configtool.model.common.ServiceModel;

/**
 * JSP Util类
 * 
 * @author linzhaoming
 *
 */
public class JSHandler {
	
	protected static ServiceModel rootmodel = new ServiceModel(null);
	
	/** Context的文件路径 */
	protected static String ctxFilePath = null; 
	
	/**
	 * 获取所有classes的服务
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static Map getServiceMap(File file) throws Exception{
		//TODO: 缓存
		rootmodel = new ServiceModel(null);
		Map map = new HashMap();
		
		ctxFilePath = file.getPath();
		
		rootmodel.setName(file.getName());
		rootmodel.setDirectory(true);
		rootmodel.setDisplayPath(file.getPath());
		rootmodel.setFilePath(file.getPath());
		
		//File[] files = file.listFiles(ModelUtils.getJSFileFilter());
		File[] files = file.listFiles(ModelUtils.getAllJSFileFilter());
		processFile(map, rootmodel, file.getPath(), files);
		return map;
	}
	
	/**
	 * 迭代处理服务
	 * @param map
	 * @param parent
	 * @param name
	 * @param files
	 */
	protected static void processFile(Map map, ServiceModel parent, String name, File[] files){
		if (files == null || files.length == 0) {	//空目录
			return;
		}
		for(int i=0; i<files.length; i++){
			File file = files[i];
			if(file.isDirectory()){			//目录	
				//File[] childFiles = file.listFiles(ModelUtils.getJSFileFilter());	
				File[] childFiles = file.listFiles(ModelUtils.getAllJSFileFilter());
				if(childFiles !=null && childFiles.length >0){	//不为空目录
					ServiceModel model = new ServiceModel(parent);
					model.setDirectory(true);
					model.setName(file.getName());
					model.setDisplayPath(file.getPath());	
					model.setFilePath(file.getPath());
					processFile(map, model, file.getAbsolutePath(), childFiles);
				}
			}else{	//文件
				ServiceModel model = new ServiceModel(parent);
				model.setDirectory(false);
				String fileName = file.getName();
				model.setName(fileName);
				model.setDisplayPath(toDisplayPath(file.getPath()));	//TODO:
				model.setFilePath(file.getPath());
			}
		}
		
		List child1 = parent.getChildren();

		ModelUtils.clearEmotyChildren(child1);
		Collections.sort(child1, ModelUtils.getModelComparator());
		//if(parent.getParent() == null){
			map.put(name, child1);	
	/*	}else{
			map.put(name, child1);	
		}*/
	}
	
	/**
	 * 转换路径
	 * @param str
	 * @return
	 */
	public static String toDisplayPath(String filePath){
		int ctxLength = ctxFilePath.length();
		String remain = FilenameUtils.separatorsToUnix(filePath.substring(ctxLength));
		return remain;
	}
	
	/**
	 * 解析JSP文件
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static ScriptOrFnNode parseJSFile(String fileName) throws Exception{
		String source = FileUtils.readFileToString(new File(fileName), null);
		CompilerEnvirons compilerEnv = new CompilerEnvirons();
		compilerEnv.setGenerateDebugInfo(true);
		Parser jsParser = new Parser(compilerEnv, compilerEnv.getErrorReporter());
		ScriptOrFnNode tree = jsParser.parse(source, fileName, 1);
		return tree;
	}
}
