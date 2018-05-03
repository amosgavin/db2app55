package com.asiainfo.charge.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.asiainfo.charge.bo.BOChargeInfoExtBean;
import com.asiainfo.charge.bo.BOChargeInfoExtEngine;
import com.asiainfo.charge.dao.interfaces.IChargeInfoExtDAO;
import com.asiainfo.charge.ivalues.IBOChargeInfoExtValue;

public class ChargeInfoExtDAOImpl implements IChargeInfoExtDAO {
	
	@Override
	public IBOChargeInfoExtValue[] getChargeInfoExt(String applyId,
			String type)throws Exception {
		StringBuffer sqlStr = new StringBuffer();
		Map map = new HashMap();
		if(null!= applyId && !"".equals(applyId)){
			sqlStr.append(IBOChargeInfoExtValue.S_ApplyId).append("=:applyId ");
			map.put("applyId", applyId);
			
		}
		else {
			return new BOChargeInfoExtBean[0];
		}
		if(null!=type && !"".equals(type)){
			sqlStr.append(" and ").append(IBOChargeInfoExtValue.S_PrivType).append("=:type");
			map.put("type", type);
		}
		sqlStr.append(" and status='1'");
		return BOChargeInfoExtEngine.getBeans(sqlStr.toString(), map);
		
	}

	@Override
	public void saveChargeInfoExt(IBOChargeInfoExtValue[] infoExtValues)
			throws Exception {
		BOChargeInfoExtEngine.save(infoExtValues);
		
	}

	
	

	
}
