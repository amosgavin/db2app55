package com.asiainfo.sale.access.service.interfaces;

public interface IBusiChangeAssistSV {

	/**
	 * 检查填写的渠道id是否正确
	 * 
	 * @param channelIdStr
	 * @return 返回填写有误的渠道id，没有返回空。
	 * @throws Exception
	 */
	public String checkChannelId(String channelIdStr) throws Exception;

	/**
	 * 获取营销案的办理量
	 * 
	 * @param feeId
	 * @return 返回累计办理量，上月新增办理量 
	 * @throws Exception
	 */
	public String getSaleHandles(String feeId) throws Exception;
}
