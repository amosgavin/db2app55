package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IChargeCfgDAO;
import com.asiainfo.charge.ivalues.IBOBusiSurpConfValue;
import com.asiainfo.charge.ivalues.IBOChargeCfgValue;
import com.asiainfo.charge.ivalues.IBOChargeDevelopInfoValue;
import com.asiainfo.charge.service.interfaces.IChargeCfgSV;

public class ChargeCfgSVImpl implements IChargeCfgSV {

	@Override
	public IBOChargeCfgValue getCfgInfoByChargeId(String chargeId, String flag)
			throws Exception {

		return ((IChargeCfgDAO) ServiceFactory.getService(IChargeCfgDAO.class))
				.getCfgInfoByChargeId(chargeId, flag);
	}

	@Override
	public void save(IBOChargeCfgValue cfg) throws Exception {

		((IChargeCfgDAO) ServiceFactory.getService(IChargeCfgDAO.class))
				.save(cfg);
	}

	@Override
	public IBOChargeDevelopInfoValue getChargeDevInfo(String chargeId)
			throws Exception {

		return ((IChargeCfgDAO) ServiceFactory.getService(IChargeCfgDAO.class))
				.getChargeDevInfo(chargeId);
	}

	@Override
	public void saveChargeDevInfo(IBOChargeDevelopInfoValue dev)
			throws Exception {

		((IChargeCfgDAO) ServiceFactory.getService(IChargeCfgDAO.class))
				.saveChargeDevInfo(dev);
	}

	@Override
	public int getBusiSurpConfCnByChargeId(String chargeOrderId)
			throws Exception {

		return ((IChargeCfgDAO) ServiceFactory.getService(IChargeCfgDAO.class))
				.getBusiSurpConfCnByChargeId(chargeOrderId);
	}

	@Override
	public IBOBusiSurpConfValue[] getBusiSurpConfsByChargeId(
			String chargeOrderId, int startNum, int endNum) throws Exception {

		return ((IChargeCfgDAO) ServiceFactory.getService(IChargeCfgDAO.class))
				.getBusiSurpConfsByChargeId(chargeOrderId, startNum, endNum);
	}

	@Override
	public void save(IBOBusiSurpConfValue[] confs) throws Exception {

		((IChargeCfgDAO) ServiceFactory.getService(IChargeCfgDAO.class))
				.save(confs);
	}

}
