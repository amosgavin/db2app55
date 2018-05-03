package com.ai.bce.configtool.dao.interfaces;

import com.ai.bce.ivalues.IQPageFramePageValue;

public interface IConfPFramePageDAO {
	public IQPageFramePageValue getPFramePageByPFramePageId(long pFramePageId);
	
	public IQPageFramePageValue[] getPageFramePageByBcePageFrameId(long bcePageFrameId);
		
	public IQPageFramePageValue[] getBcePageFramePageValues(String cond,
			int startIndex, int endIndex) throws Exception ;

	public int getBcePageFramePageValuesCount(String cond) throws Exception ;
}
