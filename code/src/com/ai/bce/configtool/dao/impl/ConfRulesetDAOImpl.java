package com.ai.bce.configtool.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.ai.bce.bo.BceRulesetBean;
import com.ai.bce.bo.BceRulesetEngine;
import com.ai.bce.configtool.dao.interfaces.IConfRulesetDAO;

public class ConfRulesetDAOImpl implements IConfRulesetDAO {

	public int getBceRuleSetCountByModuleId(long moduleId) throws Exception {
		String cond = 	BceRulesetBean.S_ModuleId +" = :moduleId";
		Map parameter = new HashMap();
		parameter.put("moduleId", new Long(moduleId));
		try {
			return BceRulesetEngine.getBeansCount(cond, parameter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
