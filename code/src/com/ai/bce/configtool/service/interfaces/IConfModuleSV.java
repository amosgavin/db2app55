package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.bo.BceModuleBean;
import com.ai.bce.ivalues.IQModuleMenuRelateValue;

public interface IConfModuleSV {
	/**
	 * 根据模块ID获取所有菜单
	 * @param moduleId
	 * @return
	 * @throws Exception
	 */
	public IQModuleMenuRelateValue[] getMenusByModuleId(String moduleId) throws Exception;
	
	/**
	 * 得到所有的数据源
	 * @return
	 * @throws Exception 
	 */
	public BceModuleBean[] getDataSource() throws Exception;
}
