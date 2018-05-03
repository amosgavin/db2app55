package com.ai.bce.configtool.model.common;

import java.util.List;

import com.ai.bce.bo.BOListItemBean;

/**
 * 
 * @author linzhaoming
 *
 */
public interface IModel {
	
	public List getChildren();
	
	public IModel getParent();
	
	public BOListItemBean toBOListItemBean();
	
	public int getSeq();
}
