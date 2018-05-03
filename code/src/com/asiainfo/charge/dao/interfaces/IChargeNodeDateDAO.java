package com.asiainfo.charge.dao.interfaces;

import com.asiainfo.charge.ivalues.IBOChargeNodeDateValue;

public interface IChargeNodeDateDAO {
	/**
	 * �����ʷѵ���ID��ȡ�ʷѽṹ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public IBOChargeNodeDateValue[] getChargeNodeDateValuesByChargeId(
			String chargeId) throws Exception;

	/**
	 * �����ʷѽṹ��
	 * @param chargeNodeDateValue
	 * @throws Exception
	 */
	public void saveChargeNodeDate(IBOChargeNodeDateValue chargeNodeDateValue)
			throws Exception;
}
