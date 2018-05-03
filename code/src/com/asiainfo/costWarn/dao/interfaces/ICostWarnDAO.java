package com.asiainfo.costWarn.dao.interfaces;

import com.asiainfo.costWarn.ivalues.IBOCostWarnValue;

public interface ICostWarnDAO {

	/**
	 * �������޸�Ԥ������
	 * 
	 * @param costWarnValues
	 * @throws Exception
	 */
	public String saveCostWarnValues(IBOCostWarnValue[] costWarnValues)
			throws Exception;

	/**
	 * ɾ��Ԥ������
	 * 
	 * @param costWarnValues
	 * @throws Exception
	 */
	public void deleteCostWarnValues(IBOCostWarnValue[] costWarnValues)
			throws Exception;

	/**
	 * ��������id,����,��Դ���ͷ��ؼ�¼
	 * 
	 * @param cfId
	 * @param cityId
	 * @param target
	 * @return
	 * @throws Exception
	 */
	public IBOCostWarnValue[] getCostWarnValues(String cfId, String cityId,
			String target, String levelId, String grade, int startNum,
			int endNum) throws Exception;

	/**
	 * ��������id,����,��Դ���ͷ��ؼ�¼��
	 * 
	 * @param cfId
	 * @param cityId
	 * @param target
	 * @return
	 * @throws Exception
	 */
	public int getCountCostWarnValues(String cfId, String cityId,
			String target, String levelId, String grade) throws Exception;
}
