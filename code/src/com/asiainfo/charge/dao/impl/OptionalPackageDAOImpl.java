package com.asiainfo.charge.dao.impl;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import com.asiainfo.charge.bo.BOOptionalPackaegEngine;
import com.asiainfo.charge.dao.interfaces.IOptionalPackageDAO;
import com.asiainfo.charge.ivalues.IBOOptionalPackaegValue;
import com.asiainfo.sale.common.ivalues.IBOOperatorInfoValue;

public class OptionalPackageDAOImpl implements IOptionalPackageDAO {
	@Override
	public int getCountOptionalPackaegValues(String id, String name)
			throws Exception {
		Map parameter = new HashMap();
		String condition = " 1 = 1 ";
		if (null != id && !"".equals(id) && !"null".equals(id)){
			condition = condition + " AND " + IBOOptionalPackaegValue.S_Id
				+ " LIKE :id";
			parameter.put("id",  "%" + id + "%");
		}
		if (null != name && !"".equals(name) && !"null".equals(name)){
			name = URLDecoder.decode(name,"utf-8");
			condition = condition + " AND " + IBOOptionalPackaegValue.S_Name
				+ " LIKE :name";
			parameter.put("name",  "%" + name + "%");
		}
		return BOOptionalPackaegEngine.getBeansCount(condition, parameter);
	}

	@Override
	public IBOOptionalPackaegValue[] getOptionalPackaegValues(String id, String name,
			int startNum, int endNum) throws Exception {
		String[] cols = null;
		boolean isShowFK = false;
		Map parameter = new HashMap();
		String condition = " 1 = 1 ";
		if (null != id && !"".equals(id) && !"null".equals(id)){
			condition = condition + " AND " + IBOOptionalPackaegValue.S_Id
				+ " LIKE :id";
			parameter.put("id",  "%" + id + "%");
		}
		if (null != name && !"".equals(name) && !"null".equals(name)){
			name = URLDecoder.decode(name,"utf-8");
			condition = condition + " AND " + IBOOptionalPackaegValue.S_Name
				+ " LIKE :name";
			parameter.put("name",  "%" + name + "%");
		}
		
		return BOOptionalPackaegEngine.getBeans(cols, condition, parameter, startNum, endNum, isShowFK);
	}
}
