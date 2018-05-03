package com.asiainfo.stopSelling.service.interfaces;

import com.asiainfo.stopSelling.ivalues.IBOStopSellDValue;

public interface IStopSellDSV {

	public void save(IBOStopSellDValue[] stopSells) throws Exception;

	public IBOStopSellDValue getStopSellDById(String did) throws Exception;

	public IBOStopSellDValue[] getStopSellDByMainId(String mainId,
			int startNum, int endNum) throws Exception;

	public int getStopSellDCountByMainId(String mainId) throws Exception;
}
