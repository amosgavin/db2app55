package com.asiainfo.costWarn.service.interfaces;

import com.asiainfo.costWarn.ivalues.IBOCostWarnReceiverValue;

public interface ICostWarnReceiverSV {

	/**
	 * �������޸�Ԥ�����š��ʼ�������Ա
	 * 
	 * @param costWarnValues
	 * @throws Exception
	 */
	public void saveCostWarnReceiverValues(
			IBOCostWarnReceiverValue[] costWarnReceiverValues) throws Exception;

	/**
	 * ɾ��Ԥ������
	 * 
	 * @param costWarnValues
	 * @throws Exception
	 */
	public void deleteCostWarnReceiverValues(
			IBOCostWarnReceiverValue[] costWarnReceiverValues) throws Exception;

	/**
	 * ����id,����,��Դ����,����,�ֻ��Ż�ȡ��¼
	 * 
	 * @param personId
	 * @param cityId
	 * @param target
	 * @param grade
	 * @param bill_id
	 * @return
	 * @throws Exception
	 */
	public IBOCostWarnReceiverValue[] getCostWarnReceiverValues(
			String personId, String cityId, String target, String levelId,
			String grade, String bill_id, int startNum, int endNum)
			throws Exception;

	/**
	 * ����id,����,��Դ����,����,�ֻ��Ż�ȡ������¼
	 * 
	 * @param personId
	 * @param cityId
	 * @param target
	 * @param grade
	 * @param bill_id
	 * @return
	 * @throws Exception
	 */
	public IBOCostWarnReceiverValue getCostWarnReceiverValue(String personId,
			String cityId, String target, String levelId, String grade,
			String bill_id) throws Exception;

	/**
	 * ����id,����,��Դ����,����,�ֻ��Ż�ȡ��¼��
	 * 
	 * @param personId
	 * @param cityId
	 * @param target
	 * @param grade
	 * @param bill_id
	 * @return
	 * @throws Exception
	 */
	public int getCountCostWarnReceiverValues(String personId, String cityId,
			String target, String levelId, String grade, String bill_id)
			throws Exception;
}
