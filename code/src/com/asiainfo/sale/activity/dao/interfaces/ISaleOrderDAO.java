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
	 * ͬ��-�޸�Ӫ����״̬
	 * 
	 * @param orderId
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void changeStsToAgreen(String orderId) throws Exception,
			RuntimeException;

	/**
	 * ��ͬ��-�޸�Ӫ����״̬
	 * 
	 * @param orderId
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void changeStsToNo(String orderId) throws Exception,
			RuntimeException;

	/**
	 * �ñ���״̬
	 * 
	 * @param orderId
	 * @param state
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void changeStsTo(String orderId, String state) throws Exception,
			RuntimeException;

	/**
	 * ͨ������id��ѯ����Ӫ�������
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
