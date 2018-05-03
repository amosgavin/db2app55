package com.asiainfo.sale.complain.dao.interfaces;

import java.rmi.RemoteException;

import com.asiainfo.sale.complain.ivalues.IBOOrderComplainsDetailValue;

public interface IOrderComplainDetailDAO {

	// ����Ͷ��������ϸ��Ϣ
	public int saveOrderComplainDetail(
			IBOOrderComplainsDetailValue OrderComplainDetailValue) throws Exception;
	
	// ����ɾ��Ͷ��������ϸ��Ϣ
	public void delOrderComplainDetail(
			IBOOrderComplainsDetailValue[] OrderComplainDetailValues) throws Exception;

	// ͨ��ID��ȡ��ϸ��¼
	public IBOOrderComplainsDetailValue getOrderComplainDetailByID(String Id)
			throws Exception;

	// ͨ������ID��ȡ��ϸ��¼
	public IBOOrderComplainsDetailValue[] getOrderComplainDetailByPID(String complainId,
			 int startNum, int endNum) throws Exception;

	// ͨ������ID��ȡ��ϸ��¼��
	public int getOrderComplainDetailCountByPID(String complainId)
			throws Exception;

	// ��������
	public void deleteOrderComplainDetailBatch(
			IBOOrderComplainsDetailValue[] orderComplainDetailValues) throws Exception;

	// �ж���д������ƽ̨���Ƿ����
	public boolean isExistBatchId(String batchId, String batchType)
			throws Exception;
}
