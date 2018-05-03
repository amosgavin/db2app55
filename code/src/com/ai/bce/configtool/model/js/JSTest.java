package com.ai.bce.configtool.model.js;

import org.mozilla.javascript.FunctionNode;
import org.mozilla.javascript.ScriptOrFnNode;

/**
 * 
 * @author linzhaoming
 * 2010-12-28
 *
 */
public class JSTest {
	public static void main(String[] args) throws Exception{
		String fileName = "E:\\tmp\\test\\AIButtonManager.js";
		ScriptOrFnNode tree = JSHandler.parseJSFile(fileName);
		
		JSFileModel fileModel = new JSFileModel(fileName, tree);
		int count = tree.getFunctionCount();
		for(int i=0; i<count; i++){
			FunctionNode node = tree.getFunctionNode(i);
			JSMethodModel methodModel = new JSMethodModel(fileModel, node); 
			fileModel.addChild(methodModel);
		}	
		System.out.println(fileModel);
		System.out.println(fileModel.getChildren());
	}
	

}
