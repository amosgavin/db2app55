package com.asiainfo.bi.dao.interfaces;

import com.asiainfo.bi.ivalues.IBOBusiSupportSValue;

public interface IBusiSupportSDAO {

	/**
	 * ���ݷ���ʱ�������ѯ
	 * @param dispatchTimeF
	 * @param dispatchTimeTo
	 * @return
	 * @throws Exception
	 */
	public IBOBusiSupportSValue[] getStatisticsINBusiSu(String dispatchTimeF,
			String dispatchTimeTo) throws Exception;
}
