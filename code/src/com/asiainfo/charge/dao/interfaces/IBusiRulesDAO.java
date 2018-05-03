package com.asiainfo.charge.dao.interfaces;

import com.asiainfo.charge.ivalues.IBOBusiRulesValue;

public interface IBusiRulesDAO {

	/**
	 * ���浵����Ϣ-ҵ�����
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
	 */
	public IBOBusiRulesValue queryBusiRules(String id) throws Exception;

}
