package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.bo.BOListItemBean;

/**
 * 
 * @author linzhaoming
 *
 */
public interface IConfServiceSV {

	/**
	 * ��ȡJava��ķ���
	 */
	public BOListItemBean[] getJavaMethodValues(String cond)throws Exception;
	
	/**
	 * ��ȡJava�����Ĳ���
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public BOListItemBean[] getJavaMethodParameters(String cond) throws Exception;
	
	/**
	 * ��ȡjavascript�ķ����б�
	 * @return
	 * @throws Exception
	 */
	public BOListItemBean[] getJSMethods(String cond) throws Exception;
	
	/**
	 * ��ȡJSP�ķ����б�
	 * @return
	 * @throws Exception
	 */
	public BOListItemBean[] getJSPMethods(String cond) throws Exception;
}
