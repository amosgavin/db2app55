package com.asiainfo.sale.complain.service.interfaces;

import java.rmi.RemoteException;

import com.asiainfo.sale.complain.ivalues.IBOOrderComplainsValue;

public interface IOrderComplainSV {

	// ����Ͷ����������Ϣ
	public int saveOrderComplain(IBOOrderComplainsValue orderComplainValue)
			throws Exception, RemoteException;
	
	//ͨ������ID��ѯͶ��������Ϣ
	public IBOOrderComplainsValue getOrderComplainByID(String complainid) throws Exception, RemoteException;
	
	// ��ѯ�����޸���Ϣ
	public IBOOrderComplainsValue[] queryOrderComplainValue(String complainId,
			String applyName, String principle, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum)
			throws Exception, RemoteException;

	// ��ѯ�����޸���Ϣ��¼��
	public int queryOrderComplainCount(String complainId, String applyName,
			String principle, String cityId, String state, String beginTime,
			String endTime) throws Exception, RemoteException;

	// ɾ����¼
	public void deleteOrderComplainMainRecords(
			IBOOrderComplainsValue[] orderComplainValues) throws Exception, RemoteException;

	// �޸Ĺ���״̬
	public void changeStateTo(String complainId, String state) throws Exception, RemoteException;
	
	public void changeStateToPass(String complainId) throws Exception, RemoteException;

	public void changeStateToNoPass(String complainId) throws Exception, RemoteException;
	
	public void changeStateTo2(String complainId) throws Exception, RemoteException;
	
	public void changeStsToNo(String mainId, String choice) throws Exception,RuntimeException;
}
