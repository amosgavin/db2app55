package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.common.util.ExceptionUtil;
import com.asiainfo.charge.dao.interfaces.IChargeProdAttrDAO;
import com.asiainfo.charge.ivalues.IBOChargeApplyProdAttrExtValue;
import com.asiainfo.charge.ivalues.IBOChargeApplyProdAttrValue;
import com.asiainfo.charge.ivalues.IBOChargeInfoExtValue;
import com.asiainfo.charge.service.interfaces.IChargeProdAttrSV;

public class ChargeProdAttrSVImpl implements IChargeProdAttrSV {

	private IChargeProdAttrDAO getProdDAO() {

		return (IChargeProdAttrDAO) ServiceFactory
				.getService(IChargeProdAttrDAO.class);
	}

	@Override
	public void saveProdAttr(IBOChargeApplyProdAttrValue[] prodAttrValues)
			throws Exception, RuntimeException {

		if (prodAttrValues != null || prodAttrValues.length > 0) {

			getProdDAO().saveProdAttr(prodAttrValues);
		} else {
			ExceptionUtil.throwBusinessException("没有要保存的数据！");
		}
	}

	@Override
	public void delProdAttr(IBOChargeApplyProdAttrValue[] prodAttrValues)
			throws Exception, RuntimeException {
		if (null != prodAttrValues && prodAttrValues.length > 0) {
			getProdDAO().delProdAttr(prodAttrValues);
		}
	}

	@Override
	public IBOChargeApplyProdAttrExtValue getProdAttrExtById(String chargeId)
			throws Exception, RuntimeException {
		return getProdDAO().getProdAttrExtById(chargeId);
	}

	@Override
	public String saveProdAttrExt(IBOChargeApplyProdAttrExtValue objProdAttrExt)
			throws Exception, RuntimeException {
		return getProdDAO().saveProdAttrExt(objProdAttrExt);

	}

	@Override
	public IBOChargeApplyProdAttrValue[] getProdAttrById(String chargeId,
			int startNum, int endNum) throws Exception, RuntimeException {
		return getProdDAO().getProdAttrById(chargeId, startNum, endNum);

	}

	@Override
	public int getProdAttrCount(String chargeId) throws Exception,
			RuntimeException {
		return getProdDAO().getProdAttrCount(chargeId);

	}

	@Override
	public void prodAttrExtStsToAgreen(String chargeId) throws Exception,
			RuntimeException {
		this.updateProdAttrExtState(chargeId, "3"); // 同意

	}

	@Override
	public void prodAttrExtStsToNo(String chargeId) throws Exception,
			RuntimeException {
		this.updateProdAttrExtState(chargeId, "4");// 不同意

	}

	@Override
	public void updateProdAttrExtState(String chargeId, String state)
			throws Exception, RuntimeException {
		IBOChargeApplyProdAttrExtValue getValue = this
				.getProdAttrExtById(chargeId);
		getValue.setState(state); // 回撤操作状态：state=1
		// getValue.setOperType("4");//回撤操作
		this.saveProdAttrExt(getValue);

	}

	@Override
	public void saveProdAttr(IBOChargeApplyProdAttrValue[] prodAttrValues,
			IBOChargeInfoExtValue[] infoExtValues) throws Exception {
		if ((prodAttrValues != null && prodAttrValues.length > 0) || (null!= infoExtValues && infoExtValues.length>0)) {

			getProdDAO().saveProdAttr(prodAttrValues,infoExtValues);
		} else {
			ExceptionUtil.throwBusinessException("没有要保存的数据！");
		}

	}

}
