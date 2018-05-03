package com.asiainfo.charge.dao.impl;

import com.asiainfo.charge.bo.BOBusiSurpConfEngine;
import com.asiainfo.charge.bo.BOChargeCfgEngine;
import com.asiainfo.charge.bo.BOChargeDevelopInfoEngine;
import com.asiainfo.charge.dao.interfaces.IChargeCfgDAO;
import com.asiainfo.charge.ivalues.IBOBusiSurpConfValue;
import com.asiainfo.charge.ivalues.IBOChargeCfgValue;
import com.asiainfo.charge.ivalues.IBOChargeDevelopInfoValue;

public class ChargeCfgDAOImpl implements IChargeCfgDAO {

	@Override
	public IBOChargeCfgValue getCfgInfoByChargeId(String chargeId, String flag)
			throws Exception {

		String cd = " charge_id = " + chargeId + " and flag = " + flag;
		// if (StringUtil.isNotBlank(chargeId) ||
		// StringUtil.isNotBlank(chargeId))
		IBOChargeCfgValue[] cfgs = BOChargeCfgEngine.getBeans(cd, null);
		if (cfgs == null || cfgs.length < 1) {
			return null;
		}
		return cfgs[0];
	}

	@Override
	public void save(IBOChargeCfgValue cfg) throws Exception {

		if (cfg.isNew()) {
			cfg.setCfid(BOChargeCfgEngine.getNewId().intValue());
		}
		BOChargeCfgEngine.save(cfg);
	}

	@Override
	public IBOChargeDevelopInfoValue getChargeDevInfo(String chargeId)
			throws Exception {

		String cd = " charge_id = " + chargeId;
		IBOChargeDevelopInfoValue[] vs = BOChargeDevelopInfoEngine.getBeans(cd,
				null);
		if (vs == null || vs.length < 1) {
			return null;
		}
		return vs[0];
	}

	@Override
	public void saveChargeDevInfo(IBOChargeDevelopInfoValue dev)
			throws Exception {

		if (dev.isNew()) {
			dev.setId(BOChargeDevelopInfoEngine.getNewId().intValue());
		}
		BOChargeDevelopInfoEngine.save(dev);
	}

	@Override
	public int getBusiSurpConfCnByChargeId(String chargeOrderId)
			throws Exception {

		String condition = " order_id = " + chargeOrderId;
		return BOBusiSurpConfEngine.getBeansCount(condition, null);
	}

	@Override
	public IBOBusiSurpConfValue[] getBusiSurpConfsByChargeId(
			String chargeOrderId, int startNum, int endNum) throws Exception {

		String condition = " order_id = " + chargeOrderId;
		return BOBusiSurpConfEngine.getBeans(null, condition, null, startNum,
				endNum, false);
	}

	@Override
	public void save(IBOBusiSurpConfValue[] confs) throws Exception {

		if (confs != null) {
			for (int i = 0; i < confs.length; ++i) {
				if (confs[i].isNew()) {
					confs[i].setId(BOBusiSurpConfEngine.getNewId().intValue());
				}
			}
			BOBusiSurpConfEngine.save(confs);
		}
	}

}
