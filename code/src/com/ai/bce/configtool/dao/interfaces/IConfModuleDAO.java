package com.ai.bce.configtool.dao.interfaces;

import com.ai.bce.bo.BceModuleBean;
import com.ai.bce.ivalues.IQModuleMenuRelateValue;

public interface IConfModuleDAO {
	/**
	 * 根据模块ID获取所有菜单
	 * @param moduleId
	 * @return
	 * @throws Exception
	 */
	public IQModuleMenuRelateValue[] getMenusByModuleId(String moduleId) throws Exception;
	public BceModuleBean[] getDataSource() throws Exception ;
}
