package com.asiainfo.charge.dao.interfaces;

import com.asiainfo.charge.ivalues.IBOBillingCheckValue;

public interface IBillingCheckDAO {

	/**
	 * �����ʷ�ID��ѯ�ʷѶԱ���Ϣ
	 * 
	 * @param chargeId
	 *            �ʷ�ID
	 * @param startNum
	 *            ��ҳ��¼��ʼ����
	 * @param endNum
	 *            ��ҳ��¼��������
	 * @return
	 * @throws Exception
	 */
	public IBOBillingCheckValue[] queryBillingCheckInfo(String chargeId,
			int startNum, int endNum) throws Exception;

	/**
	 * ��ȡ�����̯������Ϣ�ܼ�¼��
	 * 
	 * @param chargeId
	 *            �ʷ�ID
	 * @return
	 * @throws Exception
	 */
	public int countBillingCheckInfo(String chargeId) throws Exception;

	/**
	 * �����ʷѶԱ���Ϣ�����billingCheckValues����
	 * 
	 * @param billingCheckValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void saveBillingCheckInfo(IBOBillingCheckValue[] billingCheckValues)
			throws Exception, RuntimeException;

	/**
	 * �����ʷѶԱ���Ϣ������billingCheckValues����
	 * 
	 * @param billingCheckValues
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public String saveBillingCheckInfo(IBOBillingCheckValue billingCheckValues)
			throws Exception, RuntimeException;

}
