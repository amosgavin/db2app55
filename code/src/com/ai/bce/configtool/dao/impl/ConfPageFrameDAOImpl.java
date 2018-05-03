package com.ai.bce.configtool.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.ai.bce.bo.BcePageEngine;
import com.ai.bce.bo.BcePageFrameBean;
import com.ai.bce.bo.BcePageFrameEngine;
import com.ai.bce.configtool.dao.interfaces.IConfPageFrameDAO;
import com.ai.bce.ivalues.IBcePageFramePageValue;
import com.ai.bce.ivalues.IBcePageFrameValue;
import com.ai.bce.ivalues.IBcePageValue;

public class ConfPageFrameDAOImpl implements IConfPageFrameDAO {

	/**
	 * 根据页面框架编号获取页面框架数据
	 * 
	 * @param pPageFrameId
	 * @return
	 * @throws Exception
	 */
	public IBcePageFrameValue getBcePageFrameValue(long pPageFrameId)
			throws Exception {
		IBcePageFrameValue retValue = null;
		retValue = BcePageFrameEngine.getBean(pPageFrameId);
		if (retValue != null && !retValue.isNew()) {
			return retValue;
		} else {
			return null;
		}
	}

	public IBcePageValue[] getBcePageValuesByBcePageFrameId(
			String bcePageFrameId) throws Exception {
		String sql = "select * from bce_page a where a.page_id in "
				+ "(select t.page_id from bce_page_frame_page t where "
				+ IBcePageFramePageValue.S_PageFrameId + "=:pageFrameId )";
		Map parameter = new HashMap();
		parameter.put("pageFrameId", bcePageFrameId);
		return BcePageEngine.getBeansFromSql(sql, parameter);
	}

	public IBcePageFrameValue[] getPageFrameValues(String cond, int startIndex,
			int endIndex) throws Exception {
		return BcePageFrameEngine.getBeans(null, cond, null, startIndex,
				endIndex, false);
	}

	public int getPageFrameValuesCount(String cond) throws Exception {
		return BcePageFrameEngine.getBeansCount(cond,null);
	}

	public int getBcePageFrameCountByModuleId(long moduleId) throws Exception {
		String cond = BcePageFrameBean.S_ModuleId +" = :moduleId";
		Map parameter = new HashMap();
		parameter.put("moduleId", new Long(moduleId));
		try {
			return BcePageFrameEngine.getBeansCount(cond, parameter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
