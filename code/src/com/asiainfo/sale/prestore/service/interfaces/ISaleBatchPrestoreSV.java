package com.asiainfo.sale.prestore.service.interfaces;

import java.rmi.RemoteException;
import com.asiainfo.sale.prestore.ivalues.IBOSaleBatchPrestoreValue;
import com.asiainfo.sale.prestore.ivalues.IBOSaleBatchPrestoreListValue;

public interface ISaleBatchPrestoreSV {

	/**
	 * 保存批量预存申告单信息
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public String saveSaleBatchPrestore(IBOSaleBatchPrestoreValue objSaleBatchPrestoreValue) throws  Exception, RemoteException;


	/**
	 * 根据订单编号查询营销案信息
	 * 
	 * @param id
	 *            编号
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
	
	// 同意-修改状态
	public void prestoreStsToAgreen(String applyId) throws Exception,
			RuntimeException;

	// 不同意-修改状态
	public void prestoreStsToNo(String applyId) throws Exception, RuntimeException;
	
	

}
