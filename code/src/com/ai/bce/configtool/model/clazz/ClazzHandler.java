package com.ai.bce.configtool.model.clazz;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ai.bce.configtool.model.common.ModelUtils;
import com.ai.bce.configtool.model.common.ServiceModel;

/**
 * 服务Util类
 * 
 * @author linzhaoming
 *
 */
public class ClazzHandler {
	
	public static ServiceModel rootmodel = new ServiceModel(null);
	
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
		
		rootmodel.setName(file.getName());
		rootmodel.setDirectory(true);
		rootmodel.setDisplayPath(file.getPath());
		rootmodel.setFilePath(file.getPath());
		
		//File[] files = file.listFiles(ModelUtils.getServiceFileFilter());
		File[] files = file.listFiles(ModelUtils.getJavaFileFilter());
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
		/*
		if (files == null || files.length == 0) {	//空目录
			return;
		}*/
		for(int i=0; i<files.length; i++){
			File file = files[i];
			if(file.isDirectory()){			
				//File[] childFiles = file.listFiles(ModelUtils.getServiceFileFilter());			
				File[] childFiles = file.listFiles(ModelUtils.getJavaFileFilter());		
				if(childFiles !=null && childFiles.length >0){	//不为空目录
					ServiceModel model = new ServiceModel(parent);
					model.setDirectory(true);
					model.setName(file.getName());
					model.setDisplayPath(toDisplayPath(file.getPath()));	
					model.setFilePath(file.getPath());
					processFile(map, model, file.getAbsolutePath(), childFiles);
				}
			}else{
				ServiceModel model = new ServiceModel(parent);
				model.setDirectory(false);
				String fileName = file.getName();
				model.setName(fileName.substring(0, fileName.length() -6));
				model.setFilePath(file.getPath());
				model.setDisplayPath(toDisplayPath(file.getPath()));				
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
	
	public static String toDisplayPath(String str){
//		String str = " E:\\Project\\zjngcm_cvs\\products\\zjngboss\\BCE\\html\\WEB-INF\\classes\\com\\ai\\bce\\configtool\\dao\\interfaces\\IConfFrameAreaFormDAO";
		if(str == null || str.length() ==0){
			return str;
		}
		int ind1 = str.indexOf("WEB-INF");
		String remain = str;
		if(ind1>0){
			try{
			remain = str.substring(ind1 + 16, str.length());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		int ind2= remain.indexOf(".class");
		if(ind2>0){	//以.class结尾			
			remain = remain.substring(0, ind2);
		}
		String result = remain.replace(System.getProperty("file.separator"), ".");
		return result;
	}
}
