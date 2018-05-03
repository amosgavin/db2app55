package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOBusiRulesValue;

public interface IBusiRulesSV {

	/**
	 * 保存档次信息-业务规则信息
	 * 
	 * @param busiRulesValue
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public String saveBusiRules(IBOBusiRulesValue busiRulesValue)
			throws Exception, RuntimeException;

	/**
	 * 根据ID查询档次信息-业务规则信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IBOBusiRulesValue queryBusiRules(String id) throws Exception;
}
