package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOBusiSurpConfValue;
import com.asiainfo.charge.ivalues.IBOChargeCfgValue;
import com.asiainfo.charge.ivalues.IBOChargeDevelopInfoValue;

public interface IChargeCfgSV {

	public IBOChargeCfgValue getCfgInfoByChargeId(String chargeId, String flag)
			throws Exception;

	public void save(IBOChargeCfgValue cfg) throws Exception;

	public IBOChargeDevelopInfoValue getChargeDevInfo(String chargeId)
			throws Exception;

	public void saveChargeDevInfo(IBOChargeDevelopInfoValue dev)
			throws Exception;

	public void save(IBOBusiSurpConfValue[] confs) throws Exception;

	public IBOBusiSurpConfValue[] getBusiSurpConfsByChargeId(
			String chargeOrderId, int startNum, int endNum) throws Exception;

	public int getBusiSurpConfCnByChargeId(String chargeOrderId)
			throws Exception;
}
