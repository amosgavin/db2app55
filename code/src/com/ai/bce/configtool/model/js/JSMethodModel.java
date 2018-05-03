package com.ai.bce.configtool.model.js;

import org.mozilla.javascript.FunctionNode;

import com.ai.appframe2.common.AIException;
import com.ai.bce.bo.BOListItemBean;
import com.ai.bce.configtool.model.common.AbstractModel;
import com.ai.bce.configtool.model.common.IModel;

/**
 * Javascript方法
 * @author linzhaoming
 * 2010-12-26
 *
 */
public class JSMethodModel extends AbstractModel{

	private String funcName;	//方法名
	private int baseLineno;		//开始行号
	private int endLineno;		//结束行号
	private int funcType;		//方法类型
	private String sourceName;	//源文件名
	
	private FunctionNode funcNode;	//方法节点
	
	private JSFileModel parent;
	
	public JSMethodModel(IModel parent, FunctionNode funcNode){
		super(parent);
		this.funcNode = funcNode;
		init(funcNode);
	}
	
	private void init(FunctionNode funcNode){
		setFuncName(funcNode.getFunctionName());
		setBaseLineno(funcNode.getBaseLineno());
		setEndLineno(funcNode.getEndLineno());
		setFuncType(funcNode.getFunctionType());
		setSourceName(funcNode.getSourceName());
	}
	
	public BOListItemBean toBOListItemBean() {
		BOListItemBean bean = null;
		try {
			bean = new BOListItemBean();
			bean.setItem1("function " + funcName + "()");
			bean.setItem2(funcName);
			bean.setItem3(String.valueOf(baseLineno));
			bean.setItem4(String.valueOf(endLineno));
			bean.setItem5(String.valueOf(funcType));
			bean.setItem6(String.valueOf(sourceName));
		} catch (AIException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
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

	public int getFuncType() {
		return funcType;
	}

	public void setFuncType(int funcType) {
		this.funcType = funcType;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public IModel getParent() {
		return parent;
	}

	public void setParent(JSFileModel parent) {
		this.parent = parent;
	}
	
	public FunctionNode getFunctionNode() {
		return funcNode;
	}
	
	public String toString() {
		return "JSMethodModel: " + "funcName=" + funcName + " ,baseLineno" 
		+ baseLineno + " ,endLineno=" + endLineno + " ,funcType=" + funcType + ", sourceName" + sourceName;
	}
	
}
