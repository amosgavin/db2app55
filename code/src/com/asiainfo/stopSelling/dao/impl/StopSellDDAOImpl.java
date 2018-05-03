package com.asiainfo.stopSelling.dao.impl;

import com.asiainfo.sale.util.StringUtil;
import com.asiainfo.stopSelling.bo.BOStopSellDEngine;
import com.asiainfo.stopSelling.dao.interfaces.IStopSellDDAO;
import com.asiainfo.stopSelling.ivalues.IBOStopSellDValue;

public class StopSellDDAOImpl implements IStopSellDDAO {

	@Override
	public void save(IBOStopSellDValue[] stopSells) throws Exception {

		if (stopSells != null && stopSells.length > 0) {
			for (int i = 0; i < stopSells.length; ++i) {
				if (stopSells[i].isNew()) {
					stopSells[i].setId(BOStopSellDEngine.getNewId().intValue());
					stopSells[i].setStsToNew();
				}
			}
			BOStopSellDEngine.save(stopSells);
		}
	}

	@Override
	public IBOStopSellDValue[] getStopSellDByMainId(String mainId,
			int startNum, int endNum) throws Exception {

		String cd = " ";
		if (!StringUtil.isBlank(mainId)) {
			cd += IBOStopSellDValue.S_Mainid + " = " + mainId;
			cd += " and (" + IBOStopSellDValue.S_IsDelete + " !=1 or "+ IBOStopSellDValue.S_IsDelete + " is null)";
		}
		cd += " order by id desc ";
		return BOStopSellDEngine.getBeans(null, cd, null, startNum, endNum,
				false);
	}

	@Override
	public int getStopSellDCountByMainId(String mainId) throws Exception {

		String cd = " ";
		if (!StringUtil.isBlank(mainId)) {
			cd += IBOStopSellDValue.S_Mainid + " = " + mainId;
			cd += " and (" + IBOStopSellDValue.S_IsDelete + " !=1 or "+ IBOStopSellDValue.S_IsDelete + " is null)";
		}
		return BOStopSellDEngine.getBeansCount(cd, null);
	}

	@Override
	public IBOStopSellDValue getStopSellDById(String did) throws Exception {

		return BOStopSellDEngine.getBean(Integer.parseInt(did));
	}
}
