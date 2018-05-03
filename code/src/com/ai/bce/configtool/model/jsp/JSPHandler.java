package com.ai.bce.configtool.model.jsp;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.ScriptTag;
import org.htmlparser.util.NodeList;

import com.ai.bce.configtool.model.common.ModelUtils;
import com.ai.bce.configtool.model.common.ServiceModel;

/**
 * JSP Util类
 * 
 * @author linzhaoming
 *
 */
public class JSPHandler {
	
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
		
		File[] files = file.listFiles(ModelUtils.getJSPFileFilter());
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
				File[] childFiles = file.listFiles(ModelUtils.getJSPFileFilter());			
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
		/*}else{
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
	public static List getJSFromJSPFile(String fileName) throws Exception{
		Parser parser = new Parser();
		TagNameFilter filter = new TagNameFilter("script");
		parser.setFeedback(Parser.STDOUT);
		Parser.getConnectionManager().setMonitor(parser);
		Parser.getConnectionManager().setRedirectionProcessingEnabled(true);
		Parser.getConnectionManager().setCookieProcessingEnabled(true);
		parser.setResource(fileName);
		NodeList nodList = parser.parse(filter);
	
		List list = new ArrayList();
		for (int i = 0; i < nodList.size(); i++) {
			ScriptTag scriptTag = (ScriptTag) nodList.elementAt(i);
			if(scriptTag.getAttribute("src")==null){	//只解析JSP中的js
				JSPFileModel jspModel = new JSPFileModel(fileName, scriptTag);
				jspModel.setSeq(list.size());
				list.add(jspModel);
			}
		}
		return list;
	}
}
