package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOBusiRulesValue;

public interface IBusiRulesSV {

	/**
	 * ���浵����Ϣ-ҵ�������Ϣ
	 * 
	 * @param busiRulesValue
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public String saveBusiRules(IBOBusiRulesValue busiRulesValue)
			throws Exception, RuntimeException;

	/**
	 * ����ID��ѯ������Ϣ-ҵ�������Ϣ
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IBOBusiRulesValue queryBusiRules(String id) throws Exception;
}
