package com.ai.bce.configtool.dao.interfaces;

import com.ai.bce.ivalues.IBceFrameSpecialPageValue;

public interface IConfSpecialPageDAO {
public IBceFrameSpecialPageValue getSpecialPageById(long bceFrameId,long pageFramePageId) throws Exception;
public IBceFrameSpecialPageValue[] getSpecialPageValues(String cond,
		int startIndex, int endIndex) throws Exception ;
public int getSpecialPageValuesCount(String cond) throws Exception ;
}
