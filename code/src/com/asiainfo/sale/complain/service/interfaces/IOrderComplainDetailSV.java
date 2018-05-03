package com.asiainfo.sale.complain.service.interfaces;

import java.rmi.RemoteException;

import com.asiainfo.sale.complain.ivalues.IBOOrderComplainsDetailValue;

public interface IOrderComplainDetailSV {
	// ����Ͷ��������ϸ��Ϣ
	public int saveOrderComplainDetail(
			IBOOrderComplainsDetailValue OrderComplainDetailValue) throws Exception, RemoteException;
	
	// ����ɾ��Ͷ��������ϸ��Ϣ
	public void delOrderComplainDetail(
			IBOOrderComplainsDetailValue[] OrderComplainDetailValues) throws Exception, RemoteException;

	// ͨ��ID��ȡ��ϸ��¼
	public IBOOrderComplainsDetailValue getOrderComplainDetailByID(String Id)
			throws Exception, RemoteException;

	// ͨ������ID��ȡ��ϸ��¼
	public IBOOrderComplainsDetailValue[] getOrderComplainDetailByPID(String complainId,
			 int startNum, int endNum) throws Exception, RemoteException;

	// ͨ������ID��ȡ��ϸ��¼��
	public int getOrderComplainDetailCountByPID(String complainId)
			throws Exception, RemoteException;

	// ��������
	public void deleteOrderComplainDetailBatch(
			IBOOrderComplainsDetailValue[] orderComplainDetailValues) throws Exception, RemoteException;

	// �ж���д������ƽ̨���Ƿ����
	public boolean isExistBatchId(String batchId, String batchType)
			throws Exception, RemoteException;
}
