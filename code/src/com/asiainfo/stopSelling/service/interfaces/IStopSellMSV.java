package com.asiainfo.stopSelling.service.interfaces;

import com.asiainfo.stopSelling.ivalues.IBOStopSellMValue;

public interface IStopSellMSV {

	public int save(IBOStopSellMValue[] stopSellCharge) throws Exception;

	public IBOStopSellMValue getStopSellMInfoById(String mainId)
			throws Exception;

	public IBOStopSellMValue[] query(String mainId, String applyName,
			String itemType, String principal, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum)
			throws Exception;

	public int queryCn(String mainId, String applyName, String itemType,
			String principal, String cityId, String state, String beginTime,
			String endTime) throws Exception;

	public void changeStsTo2(String mainId) throws Exception, RuntimeException;

	/**
	 * ͬ��-�޸Ĺ���״̬
	 * 
	 * @param orderId
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void changeStsToAgreen(String mainId) throws Exception,
			RuntimeException;

	/**
	 * ��ͬ��-�޸Ĺ���״̬
	 * 
	 * @param orderId
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void changeStsToNo(String mainId, String choice) throws Exception,
			RuntimeException;

	/**
	 * �ñ���״̬
	 * 
	 * @param orderId
	 * @param state
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void changeStsTo(String mainId, String state) throws Exception,
			RuntimeException;

}
