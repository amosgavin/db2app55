package com.ai.bce.configtool.dao.impl;

import java.util.HashMap;

import com.ai.bce.bo.BceModuleBean;
import com.ai.bce.bo.BceModuleEngine;
import com.ai.bce.bo.QModuleMenuRelateEngine;
import com.ai.bce.configtool.dao.interfaces.IConfModuleDAO;
import com.ai.bce.ivalues.IQModuleMenuRelateValue;

public class ConfModuleDAOImpl implements IConfModuleDAO {
	/**
	 * 根据模块ID获取所有菜单
	 * @param moduleId
	 * @return
	 * @throws Exception
	 */
	public IQModuleMenuRelateValue[] getMenusByModuleId(String moduleId) throws Exception{
		HashMap para = new HashMap();
		para.put("module_id", moduleId);
		
		return QModuleMenuRelateEngine.getBeans("" ,para);
	}

	public BceModuleBean[] getDataSource() throws Exception {
		return BceModuleEngine.getBeans("", null);
	}
}
