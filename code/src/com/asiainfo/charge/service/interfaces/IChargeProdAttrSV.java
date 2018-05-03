package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOChargeApplyProdAttrExtValue;
import com.asiainfo.charge.ivalues.IBOChargeApplyProdAttrValue;
import com.asiainfo.charge.ivalues.IBOChargeInfoExtValue;

public interface IChargeProdAttrSV {
	
	public void saveProdAttr(IBOChargeApplyProdAttrValue[] prodAttrValues) throws Exception, RuntimeException;
	
	public IBOChargeApplyProdAttrValue[] getProdAttrById(String chargeId, int startNum, int endNum) throws Exception, RuntimeException;
	public int getProdAttrCount(String chargeId) throws Exception, RuntimeException;
	public void delProdAttr(IBOChargeApplyProdAttrValue[] prodAttrValues) throws Exception, RuntimeException;

	
	public String saveProdAttrExt(IBOChargeApplyProdAttrExtValue objProdAttrExt) throws Exception,RuntimeException;
	public IBOChargeApplyProdAttrExtValue getProdAttrExtById(String chargeId) throws Exception,RuntimeException;

	public void updateProdAttrExtState(String chargeId,String state)throws Exception, RuntimeException;
	
	// 同意-修改状态
	public void prodAttrExtStsToAgreen(String chargeId) throws Exception,
			RuntimeException;

	// 不同意-修改状态
	public void prodAttrExtStsToNo(String chargeId) throws Exception, RuntimeException;

	public void saveProdAttr(IBOChargeApplyProdAttrValue[] prodAttrValues,
			IBOChargeInfoExtValue[] infoExtValues)throws Exception;
	
	
	
	
}