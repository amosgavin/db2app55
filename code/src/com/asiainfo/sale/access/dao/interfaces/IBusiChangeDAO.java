package com.asiainfo.sale.access.dao.interfaces;

import com.asiainfo.sale.access.ivalues.IBOBusiChangeValue;

public interface IBusiChangeDAO {

	// ���������޸���������Ϣ
	public int saveBusiChange(IBOBusiChangeValue busiChangeValue)
			throws Exception;

	// ��ȡ�޸���������Ϣ
	public IBOBusiChangeValue getBusiChargeById(String busiId) throws Exception;

	// ��ѯ�����޸���Ϣ
	public IBOBusiChangeValue[] queryBusiChangeValue(String busiId,
			String applyName, String principle, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum)
			throws Exception;

	// ��ѯ�����޸���Ϣ��¼��
	public int queryBusiChangeCount(String busiId, String applyName,
			String principle, String cityId, String state, String beginTime,
			String endTime) throws Exception;

	// ��������
	public void saveBusiChangeBatch(IBOBusiChangeValue[] busiChangeValues)
			throws Exception;

	// �޸Ĺ���״̬
	public void changeStateTo(String busiId, String state) throws Exception;

	// �Ƿ��е���ȯ
	public boolean isHasTicketChange(String busiId) throws Exception;

	public String checkdq_kf(String busiId) throws Exception;
}
