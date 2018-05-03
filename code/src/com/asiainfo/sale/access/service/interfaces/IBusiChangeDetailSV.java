package com.asiainfo.sale.access.service.interfaces;

import com.asiainfo.sale.access.ivalues.IBOBusiChangeDetailValue;
import com.asiainfo.sale.access.ivalues.IBOSelectSaleOrChargeValue;

public interface IBusiChangeDetailSV {

	// ���������޸�������ϸ��Ϣ
	public String saveBusiChangeDetail(
			IBOBusiChangeDetailValue busiChangeDetailValue) throws Exception;

	// ͨ��ID��ȡ��ϸ��¼
	public IBOBusiChangeDetailValue getBusiChangeDetailByID(String busiDId)
			throws Exception;

	// ͨ����ID��ȡ��ϸ��¼
	public IBOBusiChangeDetailValue[] getBusiChangeDetailByPID(String busiId,
			String busiType, int startNum, int endNum) throws Exception;

	// ͨ����ID��ȡ��ϸ��¼��
	public int getBusiChangeDetailCountByPID(String busiId, String busiType)
			throws Exception;

	// ��������
	public void deleteBusiChangeDetailBatch(
			IBOBusiChangeDetailValue[] busiChangeDetailValues) throws Exception;

	// ѡ��Ӫ�������ʷѰ�
	public IBOSelectSaleOrChargeValue[] getExistInfo(String batchType,
			String orgId, String operName, String batchName, String levelName,
			int startNum, int endNum) throws Exception;

	// count
	public int getExistInfoCount(String batchType, String orgId,
			String operName, String batchName, String levelName)
			throws Exception;
	
	// �ж���д������ƽ̨���Ƿ����
	public boolean isExistBatchId(String batchId, String batchType)
			throws Exception;
}
