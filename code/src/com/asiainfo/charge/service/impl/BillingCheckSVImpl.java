package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IBillingCheckDAO;
import com.asiainfo.charge.ivalues.IBOBillingCheckValue;
import com.asiainfo.charge.service.interfaces.IBillingCheckSV;

public class BillingCheckSVImpl implements IBillingCheckSV {

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
			int startNum, int endNum) throws Exception {
		IBOBillingCheckValue[] billingCheck = null;

		billingCheck = ((IBillingCheckDAO) ServiceFactory
				.getService(IBillingCheckDAO.class)).queryBillingCheckInfo(
				chargeId, startNum, endNum);

		return billingCheck;
	}

	/**
	 * �����ʷ�ID��ȡ�ʷѶԱ��ܼ�¼��
	 * 
	 * @param chargeId
	 *            �ʷ�ID
	 * @return
	 * @throws Exception
	 */
	public int countBillingCheckInfo(String chargeId) throws Exception {
		int cnt = ((IBillingCheckDAO) ServiceFactory
				.getService(IBillingCheckDAO.class))
				.countBillingCheckInfo(chargeId);

		return cnt;
	}

	/**
	 * �����ʷѶԱ���Ϣ�����billingCheckValues����
	 * 
	 * @param billingCheckValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void saveBillingCheckInfo(IBOBillingCheckValue[] billingCheckValues)
			throws Exception, RuntimeException {
		IBillingCheckDAO billingCheckDAO = (IBillingCheckDAO) ServiceFactory
				.getService(IBillingCheckDAO.class);
		billingCheckDAO.saveBillingCheckInfo(billingCheckValues);

	}

	/**
	 * �����ʷѶԱ���Ϣ������billingCheckValues����
	 * 
	 * @param billingCheckValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public String saveBillingCheckInfo(IBOBillingCheckValue billingCheckValues)
			throws Exception, RuntimeException {
		IBillingCheckDAO billingCheckDAO = (IBillingCheckDAO) ServiceFactory
				.getService(IBillingCheckDAO.class);
		return billingCheckDAO.saveBillingCheckInfo(billingCheckValues);
	}

}
