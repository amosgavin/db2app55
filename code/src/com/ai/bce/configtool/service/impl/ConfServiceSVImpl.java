package com.ai.bce.configtool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.FunctionNode;
import org.mozilla.javascript.ScriptOrFnNode;

import com.ai.bce.bo.BOListItemBean;
import com.ai.bce.configtool.model.clazz.ClassModel;
import com.ai.bce.configtool.model.clazz.JavaMethodModel;
import com.ai.bce.configtool.model.clazz.ParameterModel;
import com.ai.bce.configtool.model.js.JSFileModel;
import com.ai.bce.configtool.model.js.JSHandler;
import com.ai.bce.configtool.model.js.JSMethodModel;
import com.ai.bce.configtool.model.jsp.JSPFileModel;
import com.ai.bce.configtool.model.jsp.JSPHandler;
import com.ai.bce.configtool.service.interfaces.IConfServiceSV;
import com.ai.bce.util.LocaleResourceFactory;

/**
 * 
 * @author linzhaoming
 *
 */
public class ConfServiceSVImpl implements IConfServiceSV {

	protected static transient Log log = LogFactory.getLog(ConfServiceSVImpl.class);

	/**
	 * 获取类的方法
	 */
	public BOListItemBean[] getJavaMethodValues(String cond)
			throws Exception {
		String name = cond;
		if(StringUtils.isEmpty(cond)){
			return new BOListItemBean[0];
		}
		ClassModel model = new ClassModel(name);
		List list = model.getChildren();		
		BOListItemBean[] beans = new BOListItemBean[list.size()];
		for (int i = 0; i < list.size(); i++) {
			JavaMethodModel method = (JavaMethodModel)list.get(i);
			beans[i] = method.toBOListItemBean();
		}
		return beans;		               
	}
	
	/**
	 * 获取Java方法的参数
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public BOListItemBean[] getJavaMethodParameters(String cond) throws Exception{
		ClassModel model = new ClassModel("com.ai.bce.configtool.model.service.TestClass");
		List methodList = model.getChildren();
		if (methodList.size() == 0) {
			return new BOListItemBean[0];
		} else {
			JavaMethodModel methodModel = (JavaMethodModel)methodList.get(1);
			List list = methodModel.getChildren();
			BOListItemBean[] beans = new BOListItemBean[list.size()];
			for (int i = 0; i < list.size(); i++) {
				ParameterModel para = (ParameterModel) list.get(i);
				beans[i] = para.toBOListItemBean();
			}
			return beans;
		}
	}
	
	/**
	 * 获取javascript的方法列表
	 * @return
	 * @throws Exception
	 */
	public BOListItemBean[] getJSMethods(String cond) throws Exception{
		String fileName = cond;
		if(StringUtils.isEmpty(fileName)){
			return new BOListItemBean[0];
		}
		
		//处理JSP逻辑
		boolean isJSP = FilenameUtils.isExtension(fileName, "jsp");
		if(isJSP){
			return getJSPMethods(cond);
		}
		
		ScriptOrFnNode tree = JSHandler.parseJSFile(fileName);		
		JSFileModel fileModel = new JSFileModel(fileName, tree);
		int count = tree.getFunctionCount();
		BOListItemBean[] beans = new BOListItemBean[count];
		for(int i=0; i<count; i++){ 
			FunctionNode node = tree.getFunctionNode(i);
			JSMethodModel methodModel = new JSMethodModel(fileModel, node); 
			fileModel.addChild(methodModel);
			beans[i] = methodModel.toBOListItemBean();
		}	
		
		return beans;
	}
	
	/**
	 * 获取JSP的方法列表
	 * @return
	 * @throws Exception
	 */
	public BOListItemBean[] getJSPMethods(String cond) throws Exception{
		String fileName = cond;
		if(StringUtils.isEmpty(fileName)){
			return new BOListItemBean[0];
		}
		
		List list = JSPHandler.getJSFromJSPFile(fileName);
		List beansList = new ArrayList();
		for(int i=0;i<list.size(); i++){
			JSPFileModel jspModel = (JSPFileModel)list.get(i);
			String source = jspModel.getSource();			
			CompilerEnvirons compilerEnv = new CompilerEnvirons();
			compilerEnv.setGenerateDebugInfo(true);
			org.mozilla.javascript.Parser jsParser = new org.mozilla.javascript.Parser(compilerEnv, compilerEnv.getErrorReporter());
			try {
				ScriptOrFnNode tree = jsParser.parse(source, fileName, 1);
				JSFileModel fileModel = new JSFileModel(fileName, tree);
				int count = tree.getFunctionCount();
				for(int j=0; j<count; j++){ 
					FunctionNode node = tree.getFunctionNode(j);
					JSMethodModel methodModel = new JSMethodModel(fileModel, node); 
					fileModel.addChild(methodModel);
					beansList.add(methodModel.toBOListItemBean());
				}
			} catch (Exception e) {
				log.error(e.getMessage());
				BOListItemBean bean1 = new BOListItemBean();
				bean1.setItem1(LocaleResourceFactory.getResource("BES0000816")); //解析JSP出错 
				bean1.setItem9("false");
				
				BOListItemBean bean2 = new BOListItemBean();
				bean2.setItem1(e.getMessage());
				bean2.setItem9("false");
				return new BOListItemBean[]{bean1, bean2};
			}	
		}
		
		return (BOListItemBean[])beansList.toArray(new BOListItemBean[0]);
	}
	

}
