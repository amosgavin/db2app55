package com.asiainfo.charge.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.charge.bo.BODynamicSumEngine;
import com.asiainfo.charge.dao.interfaces.IDynamicSumDAO;
import com.asiainfo.charge.ivalues.IBOChargeApplyMainValue;
import com.asiainfo.charge.ivalues.IBODynamicSumValue;

public class DynamicSumDAOImpl implements IDynamicSumDAO {
	public void delDynamicSumById(String id) throws Exception,
	RuntimeException {
		IBODynamicSumValue dynamicSumValue =this.getDynamicSumById(id);
		if(dynamicSumValue!=null){
			dynamicSumValue.delete();
			BODynamicSumEngine.save(dynamicSumValue);
		}
	}
	
	public IBODynamicSumValue getDynamicSumById(String id) throws Exception,
			RuntimeException {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if(StringUtils.isNotBlank(id)){
			condition.append(" AND " + IBODynamicSumValue.S_Mid
					+ " = :mid");
			parameter.put("mid",id);
		}
		if(BODynamicSumEngine.getBeans(condition.toString(), parameter).length==0){
			return null;
		}else{
		return BODynamicSumEngine.getBeans(condition.toString(), parameter)[0];
		}
	}

	
	public String saveDynamicSum(IBODynamicSumValue dynamicSumValue)
			throws Exception, RuntimeException {
		if(dynamicSumValue!=null){
			if(dynamicSumValue.isNew()){
				dynamicSumValue.setId(BODynamicSumEngine.getNewId().toString());
				dynamicSumValue.setStsToNew();
			}
			BODynamicSumEngine.save(dynamicSumValue);
			return dynamicSumValue.getMid();
		}
		return null;
	}

}
