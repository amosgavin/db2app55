package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.bo.BceModuleBean;
import com.ai.bce.ivalues.IQModuleMenuRelateValue;

public interface IConfModuleSV {
	/**
	 * ����ģ��ID��ȡ���в˵�
	 * @param moduleId
	 * @return
	 * @throws Exception
	 */
	public IQModuleMenuRelateValue[] getMenusByModuleId(String moduleId) throws Exception;
	
	/**
	 * �õ����е�����Դ
	 * @return
	 * @throws Exception 
	 */
	public BceModuleBean[] getDataSource() throws Exception;
}
