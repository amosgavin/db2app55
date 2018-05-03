package com.ai.bce.configtool.dao.impl;

import com.ai.bce.bo.BceAttrEngine;
import com.ai.bce.bo.BceFormGroupEngine;
import com.ai.bce.bo.BceFrameAreaFormEngine;
import com.ai.bce.configtool.dao.interfaces.IConfFrameAreaFormDAO;
import com.ai.bce.ivalues.IBceAttrValue;
import com.ai.bce.ivalues.IBceFormGroupValue;
import com.ai.bce.ivalues.IBceFrameAreaFormValue;

public class ConfFrameAreaFormDAOImpl implements IConfFrameAreaFormDAO {

	public IBceFrameAreaFormValue getFrameAreaFormValueById(long bceFrameId,String formId) throws Exception {
		return BceFrameAreaFormEngine.getBean(bceFrameId,formId);
	}
	public IBceAttrValue[] getAttributesByIds(long[] attrIds) throws Exception {
		if(attrIds != null && attrIds.length > 0)
		{
			StringBuilder querySb = new StringBuilder();
			StringBuilder idSb = new StringBuilder();
			for(int i=0; i < attrIds.length-1; i++)
			{
				idSb.append(attrIds[i]).append(",");
			}
			idSb.append(attrIds[attrIds.length-1]);
			querySb.append(IBceAttrValue.S_AttrId).append(" IN( ").append(idSb).append(" ) ");
			return BceAttrEngine.getBeans(querySb.toString(), null);
		}
		return null;
	}

	public IBceAttrValue[] getBceAttr(String cond, int startIndex, int endIndex)
			throws Exception {
		cond += " ORDER BY ATTR_ID DESC";
		return BceAttrEngine.getBeans(null, cond, null, startIndex, endIndex, false);
	}

	public IBceAttrValue[] getBceAttr(String cond) throws Exception {
		return BceAttrEngine.getBeans(cond, null);
	}

	public int getBceAttrCount(String cond) throws Exception {
		return BceAttrEngine.getBeansCount(cond, null);
	}

	public IBceFormGroupValue[] getGroups(String cond) throws Exception {
		return BceFormGroupEngine.getBeans(cond, null);
	}

}
