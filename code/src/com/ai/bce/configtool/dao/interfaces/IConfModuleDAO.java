package com.ai.bce.configtool.dao.interfaces;

import com.ai.bce.bo.BceModuleBean;
import com.ai.bce.ivalues.IQModuleMenuRelateValue;

public interface IConfModuleDAO {
	/**
	 * ����ģ��ID��ȡ���в˵�
	 * @param moduleId
	 * @return
	 * @throws Exception
	 */
	public IQModuleMenuRelateValue[] getMenusByModuleId(String moduleId) throws Exception;
	public BceModuleBean[] getDataSource() throws Exception ;
}
