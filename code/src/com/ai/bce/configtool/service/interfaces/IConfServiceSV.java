package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.bo.BOListItemBean;

/**
 * 
 * @author linzhaoming
 *
 */
public interface IConfServiceSV {

	/**
	 * 获取Java类的方法
	 */
	public BOListItemBean[] getJavaMethodValues(String cond)throws Exception;
	
	/**
	 * 获取Java方法的参数
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public BOListItemBean[] getJavaMethodParameters(String cond) throws Exception;
	
	/**
	 * 获取javascript的方法列表
	 * @return
	 * @throws Exception
	 */
	public BOListItemBean[] getJSMethods(String cond) throws Exception;
	
	/**
	 * 获取JSP的方法列表
	 * @return
	 * @throws Exception
	 */
	public BOListItemBean[] getJSPMethods(String cond) throws Exception;
}
