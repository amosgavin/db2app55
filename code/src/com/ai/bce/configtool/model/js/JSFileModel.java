package com.ai.bce.configtool.model.js;

import org.mozilla.javascript.ScriptOrFnNode;

import com.ai.appframe2.common.AIException;
import com.ai.bce.bo.BOListItemBean;
import com.ai.bce.configtool.model.common.AbstractModel;

/**
 * JSÎÄ¼þ
 * 
 * @author linzhaoming
 * 2010-12-26
 *
 */
public class JSFileModel extends AbstractModel{
	private ScriptOrFnNode parseTree;
	private String filePath; 
	private int baseLineno;
	private int endLineno;
		
	public JSFileModel(String filePath, ScriptOrFnNode parseTree){
		super(null);
		this.filePath = filePath;
		init(parseTree);
	}
//	
//	public static ScriptOrFnNode parseJSFile(String fileName) throws Exception{
//		String source = FileUtils.readFileToString(new File(fileName), null);
//		CompilerEnvirons compilerEnv = new CompilerEnvirons();
//		compilerEnv.setGenerateDebugInfo(true);
//		Parser p = new Parser(compilerEnv, compilerEnv.getErrorReporter());
//		ScriptOrFnNode tree = p.parse(source, fileName, 1);
//		return tree;
//	}
	
	private void init(ScriptOrFnNode parseTree){
		this.parseTree = parseTree;
		this.baseLineno = parseTree.getBaseLineno();
		this.endLineno = parseTree.getEndLineno();
	}
	
	public BOListItemBean toBOListItemBean() {
		BOListItemBean bean = null;
		try {
			bean = new BOListItemBean();
			bean.setItem1("");	
			bean.setItem2(this.filePath);
			bean.setItem3(String.valueOf(baseLineno));
			bean.setItem4(String.valueOf(endLineno));
		} catch (AIException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public String getFilePath() {
		return filePath;
	}

	public int getBaseLineno() {
		return baseLineno;
	}

	public void setBaseLineno(int baseLineno) {
		this.baseLineno = baseLineno;
	}

	public int getEndLineno() {
		return endLineno;
	}

	public void setEndLineno(int endLineno) {
		this.endLineno = endLineno;
	}
	
	public ScriptOrFnNode getParseTree() {
		return parseTree;
	}

	public String toString() {
		return "JSFileModel:" + "size=" + getChildren().size() + ",filePath=" + filePath 
		+ ",baseLineno" + baseLineno + ",endLineno=" + endLineno;
	}
}
