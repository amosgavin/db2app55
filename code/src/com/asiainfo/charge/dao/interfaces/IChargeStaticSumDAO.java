package com.asiainfo.charge.dao.interfaces;

import com.asiainfo.charge.bo.BOChargeStaticSumBean;
import com.asiainfo.charge.ivalues.IBOChargeStaticSumShowValue;

public interface IChargeStaticSumDAO {

	public void save(String sums) throws Exception;

	public IBOChargeStaticSumShowValue[] getStaticSumByGrandId(String grandId)
			throws Exception;

	public int getStaticSumCount(String grandId) throws Exception;

	public BOChargeStaticSumBean[] getStaticSumValueByGrandId(String grandId)
			throws Exception;

	public String getSaveRecords(String grandId) throws Exception;

}
