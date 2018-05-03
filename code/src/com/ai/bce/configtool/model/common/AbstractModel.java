package com.ai.bce.configtool.model.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author linzhaoming
 *
 */
public abstract class AbstractModel implements IModel{
	private List children = new ArrayList();
	private IModel parent;
	private int seq;
	
	public AbstractModel(IModel parent){
		this.parent = parent;
	}
	
	public List getChildren(){
		return children;
	}
	
	public void addChild(IModel child){
		this.children.add(child);
	}
	
	public IModel getParent(){
		return parent;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
	
}
