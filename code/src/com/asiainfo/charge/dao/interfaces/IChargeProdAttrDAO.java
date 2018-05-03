package com.asiainfo.charge.dao.interfaces;

import java.rmi.RemoteException;

import com.asiainfo.charge.ivalues.IBOChargeApplyProdAttrExtValue;
import com.asiainfo.charge.ivalues.IBOChargeApplyProdAttrValue;
import com.asiainfo.charge.ivalues.IBOChargeInfoExtValue;

public interface IChargeProdAttrDAO{
	
	public void saveProdAttr(IBOChargeApplyProdAttrValue[] prodAttrValues) throws Exception,RemoteException;
	
	public IBOChargeApplyProdAttrValue[] getProdAttrById(String chargeId, int startNum, int endNum) throws Exception, RemoteException;
	public int getProdAttrCount(String chargeId) throws Exception, RemoteException;
	public void delProdAttr(IBOChargeApplyProdAttrValue[] prodAttrValues) throws Exception, RemoteException;


	public String saveProdAttrExt(IBOChargeApplyProdAttrExtValue objProdAttrExt) throws Exception,RemoteException;
	public IBOChargeApplyProdAttrExtValue getProdAttrExtById(String chargeId) throws Exception,RemoteException;

	public void saveProdAttr(IBOChargeApplyProdAttrValue[] prodAttrValues,
			IBOChargeInfoExtValue[] infoExtValues)throws Exception;


}