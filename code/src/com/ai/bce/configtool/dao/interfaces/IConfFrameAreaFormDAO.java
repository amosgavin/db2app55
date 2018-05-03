package com.ai.bce.configtool.dao.interfaces;

import com.ai.bce.ivalues.IBceAttrValue;
import com.ai.bce.ivalues.IBceFormGroupValue;
import com.ai.bce.ivalues.IBceFrameAreaFormValue;

public interface IConfFrameAreaFormDAO {
	public IBceFrameAreaFormValue getFrameAreaFormValueById(long bceFrameId,String formId) throws Exception;
	public IBceAttrValue[] getBceAttr(String cond,int startIndex,int endIndex)throws Exception;
	public int getBceAttrCount(String cond) throws Exception ;
	public IBceAttrValue[] getBceAttr(String cond)throws Exception;
	public IBceAttrValue[] getAttributesByIds(long[] attrIds) throws Exception;
	public IBceFormGroupValue[] getGroups(String cond) throws Exception;
}
