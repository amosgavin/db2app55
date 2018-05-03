package com.asiainfo.charge.dao.interfaces;

import com.asiainfo.charge.ivalues.IBOChargeNodeDateValue;

public interface IChargeNodeDateDAO {
	/**
	 * 根据资费档次ID获取资费结构树
	 * 
	 * @return
	 * @throws Exception
	 */
	public IBOChargeNodeDateValue[] getChargeNodeDateValuesByChargeId(
			String chargeId) throws Exception;

	/**
	 * 保存资费结构树
	 * @param chargeNodeDateValue
	 * @throws Exception
	 */
	public void saveChargeNodeDate(IBOChargeNodeDateValue chargeNodeDateValue)
			throws Exception;
}
