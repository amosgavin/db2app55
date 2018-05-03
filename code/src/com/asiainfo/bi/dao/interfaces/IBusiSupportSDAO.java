package com.asiainfo.bi.dao.interfaces;

import com.asiainfo.bi.ivalues.IBOBusiSupportSValue;

public interface IBusiSupportSDAO {

	/**
	 * 根据分派时间区间查询
	 * @param dispatchTimeF
	 * @param dispatchTimeTo
	 * @return
	 * @throws Exception
	 */
	public IBOBusiSupportSValue[] getStatisticsINBusiSu(String dispatchTimeF,
			String dispatchTimeTo) throws Exception;
}
