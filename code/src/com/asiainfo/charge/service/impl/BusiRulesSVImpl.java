package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IBusiRulesDAO;
import com.asiainfo.charge.ivalues.IBOBusiRulesValue;
import com.asiainfo.charge.service.interfaces.IBusiRulesSV;

public class BusiRulesSVImpl implements IBusiRulesSV {

	/**
	 * 保存档次信息-业务规则信息
	 * 
	 * @param busiRulesValue
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public String saveBusiRules(IBOBusiRulesValue busiRulesValue)
			throws Exception, RuntimeException {
		IBusiRulesDAO busiRulesDAO = (IBusiRulesDAO) ServiceFactory
				.getService(IBusiRulesDAO.class);
		return busiRulesDAO.saveBusiRules(busiRulesValue);
	}

	/**
	 * 根据ID查询档次信息-业务规则信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IBOBusiRulesValue queryBusiRules(String id) throws Exception {
		IBusiRulesDAO busiRulesDAO = (IBusiRulesDAO) ServiceFactory
				.getService(IBusiRulesDAO.class);
		return busiRulesDAO.queryBusiRules(id);
	}

}
