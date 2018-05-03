package com.asiainfo.charge.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.asiainfo.charge.bo.BOEchannelNcodeCommandEngine;
import com.asiainfo.charge.dao.interfaces.IEchannelNcodeCommandDAO;
import com.asiainfo.charge.ivalues.IBOEchannelNcodeCommandValue;
import com.asiainfo.sale.util.StringUtil;

public class EchannelNcodeCommandDAOImpl implements IEchannelNcodeCommandDAO {

	/*
	 * relaType Åú´Î£ºact£¬ µµ´Î£ºlev
	 */
	@Override
	public IBOEchannelNcodeCommandValue[] getEchannelNcodeCommandByRelaId(String relaId,String infoType,
			int startNum, int endNum) throws Exception {
		String cd = " " + IBOEchannelNcodeCommandValue.S_RelId + " = :relaId and "
					+ IBOEchannelNcodeCommandValue.S_InfoType + " = :infoType ";
		Map<String, String> param = new HashMap<String, String>();
		if (StringUtil.isBlank(relaId))
			return null;
		param.put("relaId", relaId);
		param.put("infoType", infoType);

		return BOEchannelNcodeCommandEngine.getBeans(null, cd, param, startNum, endNum,
				false, null);
	}

	@Override
	public void save(IBOEchannelNcodeCommandValue[] values) throws Exception {

		if (values != null && values.length >= 1) {

			for (int i = 0; i < values.length; i++) {
				if (values[i].isNew()) {
					values[i].setId(BOEchannelNcodeCommandEngine.getNewId().intValue());
					values[i].setStsToNew();
				}
			}
			BOEchannelNcodeCommandEngine.save(values);
		}
	}

	@Override
	public int getCnEchannelNcodeCommandListByRelaId(String relaId,String infoType)
			throws Exception {
		String cd = " " + IBOEchannelNcodeCommandValue.S_RelId + " = :relaId and "
					+ IBOEchannelNcodeCommandValue.S_InfoType + " = :infoType ";
		if (StringUtil.isBlank(relaId))
			return 0;
		Map<String, String> param = new HashMap<String, String>();
		param.put("relaId", relaId);
		param.put("infoType", infoType);
		return BOEchannelNcodeCommandEngine.getBeansCount(cd, param);
	}

	public void cloneEchannelNcodeCommandByRelaId( String oldId,String infoType,
			String newId) throws Exception {
		IBOEchannelNcodeCommandValue[] vals = getEchannelNcodeCommandByRelaId(oldId,infoType, 0,
				-1);
		for (int i = 0; i < vals.length; ++i) {
			vals[i].setId(BOEchannelNcodeCommandEngine.getNewId().intValue());
			vals[i].setRelId(Integer.parseInt(newId));
			vals[i].setStsToNew();
		}
		save(vals);
	}
}
