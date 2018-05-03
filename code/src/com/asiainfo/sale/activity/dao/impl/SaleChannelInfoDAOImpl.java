package com.asiainfo.sale.activity.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.asiainfo.sale.activity.bo.BOChannelInfoEngine;
import com.asiainfo.sale.activity.dao.interfaces.ISaleChannelInfoDAO;
import com.asiainfo.sale.activity.ivalues.IBOChannelInfoValue;
import com.asiainfo.sale.util.StringUtil;

public class SaleChannelInfoDAOImpl implements ISaleChannelInfoDAO {

	/*
	 * relaType Åú´Î£ºact£¬ µµ´Î£ºlev
	 */
	@Override
	public IBOChannelInfoValue[] getChannelInfoByRelaId(String relaId,
			String relaType, int startNum, int endNum) throws Exception {
		String cd = " " + IBOChannelInfoValue.S_RelId + " = :relaId and "
				+ IBOChannelInfoValue.S_RelType + " = :relaType ";
		Map<String, String> param = new HashMap<String, String>();
		if (StringUtil.isBlank(relaId) || StringUtil.isBlank(relaType))
			return null;
		param.put("relaId", relaId);
		param.put("relaType", relaType);
		return BOChannelInfoEngine.getBeans(null, cd, param, startNum, endNum,
				false, null);
	}

	@Override
	public void save(IBOChannelInfoValue[] values) throws Exception {

		if (values != null && values.length >= 1) {

			for (int i = 0; i < values.length; i++) {
				if (values[i].isNew()) {
					values[i].setId(BOChannelInfoEngine.getNewId().intValue());
					values[i].setStsToNew();
				}
			}
			BOChannelInfoEngine.save(values);
		}
	}

	@Override
	public int getCnChannelListByRelaId(String relaId, String relaType)
			throws Exception {
		String cd = " " + IBOChannelInfoValue.S_RelId + " = :relaId and "
				+ IBOChannelInfoValue.S_RelType + " = :relaType ";
		if (StringUtil.isBlank(relaId) || StringUtil.isBlank(relaType))
			return 0;
		Map<String, String> param = new HashMap<String, String>();
		param.put("relaId", relaId);
		param.put("relaType", relaType);
		return BOChannelInfoEngine.getBeansCount(cd, param);
	}

	public void cloneChannelInfoByRelaId(String relaType, String oldId,
			String newId) throws Exception {
		IBOChannelInfoValue[] vals = getChannelInfoByRelaId(oldId, relaType, 0,
				-1);
		for (int i = 0; i < vals.length; ++i) {
			vals[i].setId(BOChannelInfoEngine.getNewId().intValue());
			vals[i].setRelId(Integer.parseInt(newId));
			vals[i].setStsToNew();
		}
		save(vals);
	}
}
