package com.asiainfo.costWarn.service.interfaces;

import com.asiainfo.costWarn.ivalues.IBOCostWarnReceiverValue;

public interface ICostWarnReceiverSV {

	/**
	 * 新增或修改预警短信、邮件接收人员
	 * 
	 * @param costWarnValues
	 * @throws Exception
	 */
	public void saveCostWarnReceiverValues(
			IBOCostWarnReceiverValue[] costWarnReceiverValues) throws Exception;

	/**
	 * 删除预警设置
	 * 
	 * @param costWarnValues
	 * @throws Exception
	 */
	public void deleteCostWarnReceiverValues(
			IBOCostWarnReceiverValue[] costWarnReceiverValues) throws Exception;

	/**
	 * 根据id,地市,资源类型,级别,手机号获取记录
	 * 
	 * @param personId
	 * @param cityId
	 * @param target
	 * @param grade
	 * @param bill_id
	 * @return
	 * @throws Exception
	 */
	public IBOCostWarnReceiverValue[] getCostWarnReceiverValues(
			String personId, String cityId, String target, String levelId,
			String grade, String bill_id, int startNum, int endNum)
			throws Exception;

	/**
	 * 根据id,地市,资源类型,级别,手机号获取单条记录
	 * 
	 * @param personId
	 * @param cityId
	 * @param target
	 * @param grade
	 * @param bill_id
	 * @return
	 * @throws Exception
	 */
	public IBOCostWarnReceiverValue getCostWarnReceiverValue(String personId,
			String cityId, String target, String levelId, String grade,
			String bill_id) throws Exception;

	/**
	 * 根据id,地市,资源类型,级别,手机号获取记录数
	 * 
	 * @param personId
	 * @param cityId
	 * @param target
	 * @param grade
	 * @param bill_id
	 * @return
	 * @throws Exception
	 */
	public int getCountCostWarnReceiverValues(String personId, String cityId,
			String target, String levelId, String grade, String bill_id)
			throws Exception;
}
