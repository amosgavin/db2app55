package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOFinalShareValue;

public interface IFinaAllocShareSV {

	/**
	 * ��������̯������Ϣ
	 * 
	 * @param finaAllocShareValue
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public Long saveFinaAllocShareInfo(IBOFinalShareValue[] finaAllocShareValues)
			throws Exception, RuntimeException;

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
