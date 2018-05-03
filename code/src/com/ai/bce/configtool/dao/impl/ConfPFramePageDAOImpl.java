package com.ai.bce.configtool.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.ai.bce.bo.QPageFramePageEngine;
import com.ai.bce.configtool.dao.interfaces.IConfPFramePageDAO;
import com.ai.bce.ivalues.IQPageFramePageValue;

public class ConfPFramePageDAOImpl implements IConfPFramePageDAO {
	public IQPageFramePageValue getPFramePageByPFramePageId(long pFramePageId) {
		StringBuffer condition = new StringBuffer();
		condition.append(IQPageFramePageValue.S_PageFramePageId+" = :pFramePageId order by "+ IQPageFramePageValue.S_SeqNo);
		Map parameter = new HashMap();
		parameter.put("pFramePageId", new Long(pFramePageId));
		try {
			return QPageFramePageEngine.getBeans(condition.toString(), parameter)[0];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public IQPageFramePageValue[] getPageFramePageByBcePageFrameId(long bcePageFrameId) {
		String condition=IQPageFramePageValue.S_PageFrameId+" = :pageFrameId  order by "+IQPageFramePageValue.S_SeqNo;
    	Map parameter=new HashMap();
    	parameter.put("pageFrameId", new Long(bcePageFrameId));
    	IQPageFramePageValue[] pageFramePages = null;
    	try {
			pageFramePages = QPageFramePageEngine.getBeans(condition, parameter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageFramePages;
	}

	public IQPageFramePageValue[] getBcePageFramePageValues(String cond,
			int startIndex, int endIndex) throws Exception {
		return QPageFramePageEngine.getBeans(null, cond, null, startIndex, endIndex, false);
	}

	public int getBcePageFramePageValuesCount(String cond) throws Exception {
		return (QPageFramePageEngine.getBeans(cond, null)).length;
	}
}
