package com.ai.bce.configtool.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.ai.bce.bo.BcePageFrameBean;
import com.ai.bce.bo.BcePageFrameEngine;
import com.ai.bce.configtool.dao.interfaces.IConfPageDAO;

public class ConfPageDAOImpl implements IConfPageDAO {

	public int getBcePageCountByModuleId(long moduleId) throws Exception {
		String cond = BcePageFrameBean.S_ModuleId +" = :moduleId";
		Map parameter = new HashMap();
		parameter.put("moduleId", new Long(moduleId));
		try {
			return BcePageFrameEngine.getBeansCount(cond, parameter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
