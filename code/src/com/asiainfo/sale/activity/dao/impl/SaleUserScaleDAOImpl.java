package com.asiainfo.sale.activity.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.asiainfo.sale.activity.bo.BOUserScaleEngine;
import com.asiainfo.sale.activity.dao.interfaces.ISaleUserScaleDAO;
import com.asiainfo.sale.activity.ivalues.IBOUserScaleValue;
import com.asiainfo.sale.util.StringUtil;

public class SaleUserScaleDAOImpl implements ISaleUserScaleDAO {

	/*
	 * relaType Åú´Î£ºact£¬ µµ´Î£ºlev
	 */
	@Override
	public IBOUserScaleValue[] getUserScaleByRelaId(String relaId,String infoType,
			int startNum, int endNum) throws Exception {
		String cd = " " + IBOUserScaleValue.S_RelId + " = :relaId and "
					+ IBOUserScaleValue.S_InfoType + " = :infoType ";
		Map<String, String> param = new HashMap<String, String>();
		if (StringUtil.isBlank(relaId))
			return null;
		param.put("relaId", relaId);
		param.put("infoType", infoType);

		return BOUserScaleEngine.getBeans(null, cd, param, startNum, endNum,
				false, null);
	}

	@Override
	public void save(IBOUserScaleValue[] values) throws Exception {

		if (values != null && values.length >= 1) {

			for (int i = 0; i < values.length; i++) {
				if (values[i].isNew()) {
					values[i].setId(BOUserScaleEngine.getNewId().intValue());
					values[i].setStsToNew();
				}
			}
			BOUserScaleEngine.save(values);
		}
	}

	@Override
	public int getCnUserScaleListByRelaId(String relaId,String infoType)
			throws Exception {
		String cd = " " + IBOUserScaleValue.S_RelId + " = :relaId and "
					+ IBOUserScaleValue.S_InfoType + " = :infoType ";
		if (StringUtil.isBlank(relaId))
			return 0;
		Map<String, String> param = new HashMap<String, String>();
		param.put("relaId", relaId);
		param.put("infoType", infoType);
		return BOUserScaleEngine.getBeansCount(cd, param);
	}

	public void cloneUserScaleByRelaId( String oldId,String infoType,
			String newId) throws Exception {
		IBOUserScaleValue[] vals = getUserScaleByRelaId(oldId,infoType, 0,
				-1);
		for (int i = 0; i < vals.length; ++i) {
			vals[i].setId(BOUserScaleEngine.getNewId().intValue());
			vals[i].setRelId(Integer.parseInt(newId));
			vals[i].setStsToNew();
		}
		save(vals);
	}
}
