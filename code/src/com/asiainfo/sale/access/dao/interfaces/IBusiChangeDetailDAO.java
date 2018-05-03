package com.asiainfo.sale.access.dao.interfaces;

import com.asiainfo.sale.access.ivalues.IBOBusiChangeDetailValue;
import com.asiainfo.sale.access.ivalues.IBOSelectSaleOrChargeValue;

public interface IBusiChangeDetailDAO {

	// 保存渠道修改申请明细信息
	public String saveBusiChangeDetail(
			IBOBusiChangeDetailValue busiChangeDetailValue) throws Exception;

	// 通过ID获取明细记录
	public IBOBusiChangeDetailValue getBusiChargeDetailByID(String busiDId)
			throws Exception;

	// 通过主ID获取明细记录
	public IBOBusiChangeDetailValue[] getBusiChargeDetailByPID(String busiId,
			String busiType, int startNum, int endNum) throws Exception;

	// 通过主ID获取明细记录数
	public int getBusiChargeDetailCountByPID(String busiId, String busiType)
			throws Exception;

	/*
	 * // 查询渠道修改信息 public IBOBusiChangeDetailValue[] queryBusiChangeValue(String
	 * applyName, String principle, String cityId, String beginTime, String
	 * endTime, int startNum, int endNum) throws Exception;
	 * 
	 * // 查询渠道修改信息记录数 public int queryBusiChangeCount(String applyName, String
	 * principle, String cityId, String beginTime, String endTime) throws
	 * Exception;
	 */
	// 批量处理
	public void saveBusiChangeDetailBatch(
			IBOBusiChangeDetailValue[] busiChangeDetailValues) throws Exception;

	// 选择营销案或资费案
	public IBOSelectSaleOrChargeValue[] getExistInfo(String batchType,
			String orgId, String operName, String batchName, String levelName,
			int startNum, int endNum) throws Exception;

	public int getExistInfoCount(String batchType, String orgId,
			String operName, String batchName, String levelName)
			throws Exception;

	// 判断填写工单在平台中是否存在
	public boolean isExistBatchId(String batchId, String batchType)
			throws Exception;
}
