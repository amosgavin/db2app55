package com.asiainfo.sale.access.dao.interfaces;

import com.asiainfo.sale.access.ivalues.IBOBusiChangeDetailValue;
import com.asiainfo.sale.access.ivalues.IBOSelectSaleOrChargeValue;

public interface IBusiChangeDetailDAO {

	// ���������޸�������ϸ��Ϣ
	public String saveBusiChangeDetail(
			IBOBusiChangeDetailValue busiChangeDetailValue) throws Exception;

	// ͨ��ID��ȡ��ϸ��¼
	public IBOBusiChangeDetailValue getBusiChargeDetailByID(String busiDId)
			throws Exception;

	// ͨ����ID��ȡ��ϸ��¼
	public IBOBusiChangeDetailValue[] getBusiChargeDetailByPID(String busiId,
			String busiType, int startNum, int endNum) throws Exception;

	// ͨ����ID��ȡ��ϸ��¼��
	public int getBusiChargeDetailCountByPID(String busiId, String busiType)
			throws Exception;

	/*
	 * // ��ѯ�����޸���Ϣ public IBOBusiChangeDetailValue[] queryBusiChangeValue(String
	 * applyName, String principle, String cityId, String beginTime, String
	 * endTime, int startNum, int endNum) throws Exception;
	 * 
	 * // ��ѯ�����޸���Ϣ��¼�� public int queryBusiChangeCount(String applyName, String
	 * principle, String cityId, String beginTime, String endTime) throws
	 * Exception;
	 */
	// ��������
	public void saveBusiChangeDetailBatch(
			IBOBusiChangeDetailValue[] busiChangeDetailValues) throws Exception;

	// ѡ��Ӫ�������ʷѰ�
	public IBOSelectSaleOrChargeValue[] getExistInfo(String batchType,
			String orgId, String operName, String batchName, String levelName,
			int startNum, int endNum) throws Exception;

	public int getExistInfoCount(String batchType, String orgId,
			String operName, String batchName, String levelName)
			throws Exception;

	// �ж���д������ƽ̨���Ƿ����
	public boolean isExistBatchId(String batchId, String batchType)
			throws Exception;
}
