package com.asiainfo.bi.service.interfaces;

import com.asiainfo.bi.ivalues.IBOBusiSupportSValue;

public interface IBusiSupportSSV {

	public IBOBusiSupportSValue[] getStatisticsINBusiSu(String dispatchTimeF,
			String dispatchTimeTo) throws Exception;
}
