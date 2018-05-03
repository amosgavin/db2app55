package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IBusiRulesDAO;
import com.asiainfo.charge.ivalues.IBOBusiRulesValue;
import com.asiainfo.charge.service.interfaces.IBusiRulesSV;

public class BusiRulesSVImpl implements IBusiRulesSV {

	/**
	 * ���浵����Ϣ-ҵ�������Ϣ
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
	 * ����ID��ѯ������Ϣ-ҵ�������Ϣ
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
