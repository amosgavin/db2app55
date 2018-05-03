package com.asiainfo.charge.dao.interfaces;

import com.asiainfo.charge.ivalues.IBOFinalShareValue;

public interface IFinaAllocShareDAO {

	/**
	 * ��������̯������Ϣ
	 * 
	 * @param finaAllocShareValue
	 * @return
	 * @throws Exception
	 */
	public Long saveFinaAllocShareInfo(IBOFinalShareValue[] finaAllocShareValues)
			throws Exception;

	/**
	 * ����chargeId��ѯ�����̯������Ϣ
	 * 
	 * @param chargeId
	 * @return
	 * @throws Exception
	 */
	public IBOFinalShareValue[] queryFinaAllocShare(String chargeId)
			throws Exception;

	/**
	 * �ж��Ƿ�ÿ���ʷ���ϸ����д�˲����̯����
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public boolean haveEmptyFinalShareInCharge(String orderId) throws Exception;

}
