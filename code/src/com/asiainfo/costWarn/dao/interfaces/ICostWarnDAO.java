package com.asiainfo.costWarn.dao.interfaces;

import com.asiainfo.costWarn.ivalues.IBOCostWarnValue;

public interface ICostWarnDAO {

	/**
	 * 新增或修改预警设置
	 * 
	 * @param costWarnValues
	 * @throws Exception
	 */
	public String saveCostWarnValues(IBOCostWarnValue[] costWarnValues)
			throws Exception;

	/**
	 * 删除预警设置
	 * 
	 * @param costWarnValues
	 * @throws Exception
	 */
	public void deleteCostWarnValues(IBOCostWarnValue[] costWarnValues)
			throws Exception;

	/**
	 * 根据条件id,地市,资源类型返回记录
	 * 
	 * @param cfId
	 * @param cityId
	 * @param target
	 * @return
	 * @throws Exception
	 */
	public IBOCostWarnValue[] getCostWarnValues(String cfId, String cityId,
			String target, String levelId, String grade, int startNum,
			int endNum) throws Exception;

	/**
	 * 根据条件id,地市,资源类型返回记录数
	 * 
	 * @param cfId
	 * @param cityId
	 * @param target
	 * @return
	 * @throws Exception
	 */
	public int getCountCostWarnValues(String cfId, String cityId,
			String target, String levelId, String grade) throws Exception;
}
