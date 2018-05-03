package com.asiainfo.bi.dao.interfaces;

import com.asiainfo.bi.ivalues.IBOBusiSupportValue;

public interface IBusiSupportDAO {

	/**
	 * 根据条件查询工单明细
	 * 
	 * @param itemId
	 *            工单id
	 * @param itemType
	 *            工单类型
	 * @param state
	 *            工单状态
	 * @param dispatchTimeF
	 *            分派时间from
	 * @param dispatchTimeTo
	 *            分派时间to
	 * @param dealPerson
	 *            处理人
	 * @return
	 * @throws Exception
	 */
	public IBOBusiSupportValue[] getItemInfoINBusiSu(String itemId,
			String itemType, String state, String dispatchTimeF,
			String dispatchTimeTo, String dealPerson, int startNum, int endNum)
			throws Exception;

	public int getItemInfoINBusiSuCount(String itemId, String itemType,
			String state, String dispatchTimeF, String dispatchTimeTo,
			String dealPerson) throws Exception;
}
