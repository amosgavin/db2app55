package com.asiainfo.sale.prestore.dao.interfaces;

import java.rmi.RemoteException;

import com.asiainfo.sale.prestore.ivalues.IBOSaleBatchPrestoreHisValue;
import com.asiainfo.sale.prestore.ivalues.IBOSaleBatchPrestoreListValue;
import com.asiainfo.sale.prestore.ivalues.IBOSaleBatchPrestoreValue;

public interface ISaleBatchPrestoreDAO {

	/**
	 * ��������Ԥ����浥��Ϣ
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public String saveSaleBatchPrestore(IBOSaleBatchPrestoreValue objSaleBatchPrestoreValue) throws Exception;

	/**
	 * ���ݶ�����Ų�ѯԤ����浥��Ϣ
	 * 
	 * @param id
	 *            ���
	 * @return
	 * @throws Exceptions
	 * @throws RuntimeException
	 */
	public IBOSaleBatchPrestoreValue getSaleMainShowById(String id) throws Exception;

	public IBOSaleBatchPrestoreListValue[] queryPrestoreInfo(String applyId, String applyName, String principal, String regionCode, String beginTime, String endTime, String isSubmit, int startNum, int endNum) throws Exception, RemoteException;
	public int queryPrestoreInfoCount(String applyId, String applyName, String principal, String regionCode, String beginTime, String endTime, String isSubmit) throws Exception, RemoteException;
	
	public void delSaleBatchPrestoreById(String applyId) throws Exception;
	public void deletePrestoreInfo(IBOSaleBatchPrestoreValue[] saleBatchPrestoreValues) throws Exception;

	public void saleBatchPrestoreToHis(IBOSaleBatchPrestoreValue[] saleBatchPrestoreValues) throws Exception;

}
