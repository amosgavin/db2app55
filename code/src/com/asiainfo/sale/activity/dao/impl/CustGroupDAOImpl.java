package com.asiainfo.sale.activity.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.asiainfo.sale.activity.bo.BOSaleRelatCgroupEngine;
import com.asiainfo.sale.activity.dao.interfaces.ICustGroupDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleRelatCgroupValue;
import com.asiainfo.sale.util.StringUtil;

public class CustGroupDAOImpl implements ICustGroupDAO {

	public void save(IBOSaleRelatCgroupValue[] values) throws Exception {

		if (values != null && values.length >= 1) {

			for (int i = 0; i < values.length; i++) {
				if (values[i].isNew()) {
					values[i].setId(BOSaleRelatCgroupEngine.getNewId()
							.intValue());
					values[i].setStsToNew();
				}
			}
			BOSaleRelatCgroupEngine.save(values);
		}
	}

	/*
	 * relaType Åú´Î£ºact£¬ µµ´Î£ºlev
	 */
	public IBOSaleRelatCgroupValue[] getSaleRelatCgroupByRelaId(String relaId,
			String relaType, int startNum, int endNum) throws Exception {
		String cd = " " + IBOSaleRelatCgroupValue.S_RelatId
				+ " = :relatId and " + IBOSaleRelatCgroupValue.S_RelatType
				+ " = :relatType ";
		Map<String, String> param = new HashMap<String, String>();
		if (StringUtil.isBlank(relaId) || StringUtil.isBlank(relaType))
			return null;
		param.put("relatId", relaId);
		param.put("relatType", relaType);
		return BOSaleRelatCgroupEngine.getBeans(null, cd, param, startNum,
				endNum, false, null);
	}

	public int getCnSaleRelatCgroupByRelaId(String relaId, String relaType)
			throws Exception {
		String cd = " " + IBOSaleRelatCgroupValue.S_RelatId
				+ " = :relatId and " + IBOSaleRelatCgroupValue.S_RelatType
				+ " = :relatType ";
		if (StringUtil.isBlank(relaId) || StringUtil.isBlank(relaType))
			return 0;
		Map<String, String> param = new HashMap<String, String>();
		param.put("relatId", relaId);
		param.put("relatType", relaType);
		return BOSaleRelatCgroupEngine.getBeansCount(cd, param);
	}

	public void cloneSaleRelatCgroupByRelaId(String relaType, String oldId,
			String newId) throws Exception {
		IBOSaleRelatCgroupValue[] vals = getSaleRelatCgroupByRelaId(oldId,
				relaType, 0, -1);
		for (int i = 0; i < vals.length; ++i) {
			vals[i].setId(BOSaleRelatCgroupEngine.getNewId().intValue());
			vals[i].setRelatId(newId);
			vals[i].setStsToNew();
		}
		save(vals);
	}
}
