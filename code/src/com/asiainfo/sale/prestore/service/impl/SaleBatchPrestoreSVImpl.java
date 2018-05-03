package com.asiainfo.sale.prestore.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.prestore.dao.interfaces.ISaleBatchPrestoreDAO;

import com.asiainfo.sale.prestore.ivalues.IBOSaleBatchPrestoreListValue;
import com.asiainfo.sale.prestore.ivalues.IBOSaleBatchPrestoreValue;
import com.asiainfo.sale.prestore.service.interfaces.ISaleBatchPrestoreSV;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.asiainfo.sale.prestore.bo.BOSaleBatchPrestoreEngine;
import com.ai.appframe2.common.ServiceManager;
import java.rmi.RemoteException;

public class SaleBatchPrestoreSVImpl implements ISaleBatchPrestoreSV {

	private static transient Log log = LogFactory.getLog(SaleBatchPrestoreSVImpl.class);

	private ISaleBatchPrestoreDAO getDAO(){
		return (ISaleBatchPrestoreDAO)ServiceFactory.getService(ISaleBatchPrestoreDAO.class);
	}	
	
	@Override
	public String saveSaleBatchPrestore(
			IBOSaleBatchPrestoreValue objSaleBatchPrestoreValue)throws RemoteException, Exception {

		return getDAO().saveSaleBatchPrestore(objSaleBatchPrestoreValue);
	}


	
	@Override
	public IBOSaleBatchPrestoreValue getSaleMainShowById(String id)
			throws Exception, RuntimeException {
		return getDAO().getSaleMainShowById(id);
	}

	@Override
	public IBOSaleBatchPrestoreListValue[] queryPrestoreInfo(String applyId,
			String applyName, String principal, String regionCode,
			String beginTime, String endTime, String isSubmit, int startNum,
			int endNum) throws Exception, RemoteException {
		return getDAO().queryPrestoreInfo(applyId, applyName, principal, regionCode, beginTime, endTime, isSubmit, startNum, endNum);

	}

	@Override
	public int queryPrestoreInfoCount(String applyId, String applyName,
			String principal, String regionCode, String beginTime,
			String endTime, String isSubmit) throws Exception, RemoteException {
		return getDAO().queryPrestoreInfoCount(applyId, applyName, principal, regionCode, beginTime, endTime, isSubmit);
	}

	@Override
	public void delSaleBatchPrestoreById(String applyId) throws Exception {
		getDAO().delSaleBatchPrestoreById(applyId);
	}

	@Override
	public void updatePrestoreState(String applyId, String state)
			throws Exception, RuntimeException {
		IBOSaleBatchPrestoreValue getValue = this.getSaleMainShowById(applyId);
		getValue.setIsSubmit(state); //回撤操作状态：state=1
		getValue.setOperType("4");//回撤操作
		this.saveSaleBatchPrestore(getValue);
		
	}

	@Override
	public void prestoreStsToAgreen(String applyId) throws Exception,
			RuntimeException {
		this.updatePrestoreState(applyId,"3"); 	//同意
		
	}

	@Override
	public void prestoreStsToNo(String applyId) throws Exception,
			RuntimeException {
		this.updatePrestoreState(applyId,"4");//不同意
		
	}

	@Override
	public void deletePrestoreInfo(
			IBOSaleBatchPrestoreValue[] saleBatchPrestoreValues)
			throws Exception, RemoteException {
		if (null != saleBatchPrestoreValues && saleBatchPrestoreValues.length > 0) {
			getDAO().saleBatchPrestoreToHis(saleBatchPrestoreValues);
			getDAO().deletePrestoreInfo(saleBatchPrestoreValues);
		}
	}

}
