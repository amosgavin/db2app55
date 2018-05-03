package com.ai.bce.configtool.model.jsp;

import org.htmlparser.tags.ScriptTag;

import com.ai.bce.bo.BOListItemBean;
import com.ai.bce.configtool.model.common.AbstractModel;

/**
 * 
 * @author linzhaoming
 * 2010-12-26
 *
 */
public class JSPFileModel extends AbstractModel{
	private String filePath; 
	private ScriptTag scriptTag;
	private String source = "";
	
	public JSPFileModel(String filePath, ScriptTag scriptTag) {		
		super(null);
		this.filePath = filePath;
		this.scriptTag = scriptTag;
		init();
	}
	
	private void init(){
		this.source = scriptTag.getScriptCode();
	}
	

	public BOListItemBean toBOListItemBean() {
		return null;
	}

	public String getFilePath() {
		return filePath;
	}

	public ScriptTag getScriptTag() {
		return scriptTag;
	}

	public String getSource() {
		return source;
	}
	
	public String toString() {
		return "JSPFileModel: " + "filePath=" + filePath + ", seq=" + getSeq();
	}
	
}
