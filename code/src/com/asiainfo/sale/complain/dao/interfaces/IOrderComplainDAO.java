package com.asiainfo.sale.complain.dao.interfaces;

import com.asiainfo.sale.complain.ivalues.IBOOrderComplainsValue;

public interface IOrderComplainDAO {
	// ������������Ϣ
	public int saveOrderComplain(IBOOrderComplainsValue OrderComplainsValue)
			throws Exception;
	// ��ȡ�޸���������Ϣ
	public IBOOrderComplainsValue getOrderComplainsById(String complain_id) throws Exception;
	
	// ��ѯͶ��������Ϣ
	public IBOOrderComplainsValue[] queryOrderComplainValue(String complainId,
			String applyName, String principle, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum)
			throws Exception;

	// ��ѯͶ��������Ϣ��¼��
	public int queryOrderComplainCount(String complainId, String applyName,
			String principle, String cityId, String state, String beginTime,
			String endTime) throws Exception;

	// ��������
	public void saveOrderComplainBatch(IBOOrderComplainsValue[] busiChangeValues)
			throws Exception;

	// �޸Ĺ���״̬
	public void changeStateTo(String complainId, String state) throws Exception;

}
