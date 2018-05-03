package com.ai.bce.configtool.dao.impl;

import com.ai.bce.bo.BceFrameSpecialPageEngine;
import com.ai.bce.configtool.dao.interfaces.IConfSpecialPageDAO;
import com.ai.bce.ivalues.IBceFrameSpecialPageValue;

public class ConfSpecialPageDAOImpl implements IConfSpecialPageDAO {

	public IBceFrameSpecialPageValue getSpecialPageById(long bceFrameId,
			long pageFramePageId) throws Exception {
		return BceFrameSpecialPageEngine.getBean(bceFrameId, pageFramePageId);
	}


	public IBceFrameSpecialPageValue[] getSpecialPageValues(String cond,
			int startIndex, int endIndex) throws Exception {
		return BceFrameSpecialPageEngine.getBeans(null, cond, null, startIndex, endIndex, false);
	}

	public int getSpecialPageValuesCount(String cond) throws Exception {
		return BceFrameSpecialPageEngine.getBeansCount(cond, null);
	}
}
