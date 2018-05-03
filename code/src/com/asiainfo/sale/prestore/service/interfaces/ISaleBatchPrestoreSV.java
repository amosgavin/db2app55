package com.asiainfo.sale.prestore.service.interfaces;

import java.rmi.RemoteException;
import com.asiainfo.sale.prestore.ivalues.IBOSaleBatchPrestoreValue;
import com.asiainfo.sale.prestore.ivalues.IBOSaleBatchPrestoreListValue;

public interface ISaleBatchPrestoreSV {

	/**
	 * ��������Ԥ����浥��Ϣ
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public String saveSaleBatchPrestore(IBOSaleBatchPrestoreValue objSaleBatchPrestoreValue) throws  Exception, RemoteException;


	/**
	 * ���ݶ�����Ų�ѯӪ������Ϣ
	 * 
	 * @param id
	 *            ���
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleBatchPrestoreValue getSaleMainShowById(String id)
			throws Exception, RuntimeException;
	
	
	public IBOSaleBatchPrestoreListValue[] queryPrestoreInfo(String applyId, String applyName, String principal, String regionCode, String beginTime, String endTime, String isSubmit, int startNum, int endNum) throws Exception, RemoteException;
	public int queryPrestoreInfoCount(String applyId, String applyName, String principal, String regionCode, String beginTime, String endTime, String isSubmit) throws Exception, RemoteException;

	public void delSaleBatchPrestoreById(String applyId) throws Exception;

	public void deletePrestoreInfo(IBOSaleBatchPrestoreValue[] saleBatchPrestoreValues) throws Exception, RemoteException;

	public void updatePrestoreState(String applyId,String state)throws Exception, RuntimeException;
	
	// ͬ��-�޸�״̬
	public void prestoreStsToAgreen(String applyId) throws Exception,
			RuntimeException;

	// ��ͬ��-�޸�״̬
	public void prestoreStsToNo(String applyId) throws Exception, RuntimeException;
	
	

}
