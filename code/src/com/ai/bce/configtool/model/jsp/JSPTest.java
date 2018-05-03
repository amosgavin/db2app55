package com.ai.bce.configtool.model.jsp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.EvaluatorException;
import org.mozilla.javascript.FunctionNode;
import org.mozilla.javascript.ScriptOrFnNode;

import com.ai.bce.bo.BOListItemBean;
import com.ai.bce.configtool.model.js.JSFileModel;
import com.ai.bce.configtool.model.js.JSMethodModel;

/**
 * 
 * @author linzhaoming
 * 2010-12-28
 *
 */
public class JSPTest {
	public static void main(String[] args) throws Exception {
		//String fileName = "E:\\Tmp\\test\\QryCustInfo.jsp";
		String fileName = "E:\\tmp\\test\\chart.jsp";
		
//		Parser parser = new Parser();
//		TagNameFilter filter = new TagNameFilter("script");
//		parser.setFeedback(Parser.STDOUT);
//		Parser.getConnectionManager().setMonitor(parser);
//		Parser.getConnectionManager().setRedirectionProcessingEnabled(true);
//		Parser.getConnectionManager().setCookieProcessingEnabled(true);
//		parser.setResource(fileName);
//		NodeList nodList = parser.parse(filter);
//	
//		List list = new ArrayList();
//		for (int i = 0; i < nodList.size(); i++) {
//			ScriptTag scriptTag = (ScriptTag) nodList.elementAt(i);
//			if(scriptTag.getAttribute("src")==null){	//只解析JSP中的js
//				JSPFileModel jspModel = new JSPFileModel(fileName, scriptTag);
//				System.out.println("**************");
//				System.out.println(scriptTag.getChildCount());
//				System.out.println(scriptTag.getStringText());
//				Node node = scriptTag.getChild(0);
//				
//				jspModel.setSeq(list.size());
//				list.add(jspModel);
//			}
//		}
//		
//		System.out.println(list);
		
		BOListItemBean[] results = getJSPMethods(fileName);
		System.out.println(results.length);
	}	
	
	public static BOListItemBean[] getJSPMethods(String cond) throws Exception{
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
			compilerEnv.setErrorReporter(new MyErrorReporter());
			compilerEnv.setGenerateDebugInfo(true);
			org.mozilla.javascript.Parser jsParser = new org.mozilla.javascript.Parser(compilerEnv, compilerEnv.getErrorReporter());
			try {
				String result = source;
//				result = StringEscapeUtils.escapeXml(source);
				result = source.replace("%>", "a").replace("<%", "a");
				System.out.println(result);
				ScriptOrFnNode tree = jsParser.parse(result, fileName, 1);
				//ScriptOrFnNode tree = jsParser.parse(StringEscapeUtils.escapeXml(source), fileName, 1);
				JSFileModel fileModel = new JSFileModel(fileName, tree);
				int count = tree.getFunctionCount();
				for(int j=0; j<count; j++){ 
					FunctionNode node = tree.getFunctionNode(j);
					JSMethodModel methodModel = new JSMethodModel(fileModel, node); 
					fileModel.addChild(methodModel);
					beansList.add(methodModel.toBOListItemBean());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
		return (BOListItemBean[])beansList.toArray(new BOListItemBean[0]);
	}
	
	public static class MyErrorReporter implements ErrorReporter{
		public void error(String message, String sourceName, int line,
	               String lineSource, int lineOffset) {
			System.out.println("------------------ error ------------------------------");
			System.out.println("message=" + message);
			System.out.println("sourceName=" + sourceName);
			System.out.println("line=" + line);
			System.out.println("lineSource=" + lineSource);
			System.out.println("lineOffset=" + lineOffset);
			System.out.println(lineSource.charAt(lineOffset-1) + "," + lineSource.charAt(lineOffset - 2));
		}
		
		public EvaluatorException runtimeError(String message, String sourceName,
                int line, String lineSource,
                int lineOffset){
			System.out.println("------------------ runtimeError ------------------------------");
			System.out.println("message=" + message);
			System.out.println("sourceName=" + sourceName);
			System.out.println("line=" + line);
			System.out.println("lineSource=" + lineSource);
			System.out.println("lineOffset=" + lineOffset);
			return new EvaluatorException("linz");
		}
		
		public void warning(String message, String sourceName, int line,
                 String lineSource, int lineOffset){
			System.out.println("------------------ warning ------------------------------");
			System.out.println("message=" + message);
			System.out.println("sourceName=" + sourceName);
			System.out.println("line=" + line);
			System.out.println("lineSource=" + lineSource);
			System.out.println("lineOffset=" + lineOffset);
		}
		
	}

}
