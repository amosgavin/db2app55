package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleOrderValue;

public interface ISaleOrderDAO {

	public IBOSaleOrderValue[] getSaleOrderInfo(String orderId,
			String orderName, String pinciple, String staffName, String orgId,
			String orgName, String state, String beginTime, String endTime,
			int startNum, int endNum) throws Exception;

	public IBOSaleOrderValue getSaleOrderInfo(String orderId) throws Exception;

	public int getSaleOrderCount(String orderId, String orderName,
			String pinciple, String staffName, String orgId, String orgName,
			String state, String beginTime, String endTime) throws Exception;

	public int saveSaleOrderInfo(IBOSaleOrderValue saleOrderValue)
			throws Exception;

	public IBOSaleMainValue[] getSaleMainByOrderId(String orderId,
			int startNum, int endNum) throws Exception;

	public int getSaleMainCountByOrderId(String orderId) throws Exception;

	public IBOSaleDetailValue[] getSaleDetailByOrderId(String orderId,
			int startNum, int endNum) throws Exception;

	public int getSaleDetailCountByOrderId(String orderId) throws Exception;

	public void cloneSaleOrder(String orderId, String operatorId,
			String staffName, String orgId, String orgName) throws Exception;

	/**
	 * 同意-修改营销案状态
	 * 
	 * @param orderId
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void changeStsToAgreen(String orderId) throws Exception,
			RuntimeException;

	/**
	 * 不同意-修改营销案状态
	 * 
	 * @param orderId
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void changeStsToNo(String orderId) throws Exception,
			RuntimeException;

	/**
	 * 该表工单状态
	 * 
	 * @param orderId
	 * @param state
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void changeStsTo(String orderId, String state) throws Exception,
			RuntimeException;

	/**
	 * 通过武器id查询关联营销活动工单
	 * 
	 * @param wpId
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleOrderValue[] getRelatSaleOrderByWpId(String wpId,
			int startNum, int endNum) throws Exception, RuntimeException;

	public int getRelatSaleOrderCnByWpId(String wpId) throws Exception,
			RuntimeException;

	public int getSaleOrderCountBySql(String orderId, String orderName,
			String pinciple, String staffName, String orgId, String orgName,
			String state, String beginTime, String endTime) throws Exception;

	public IBOSaleOrderValue[] getSaleOrderInfoBySql(String orderId,
			String orderName, String pinciple, String staffName, String orgId,
			String orgName, String state, String beginTime, String endTime,
			int startNum, int endNum) throws Exception;
}
