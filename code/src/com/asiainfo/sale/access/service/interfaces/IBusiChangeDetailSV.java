package com.asiainfo.sale.access.service.interfaces;

import com.asiainfo.sale.access.ivalues.IBOBusiChangeDetailValue;
import com.asiainfo.sale.access.ivalues.IBOSelectSaleOrChargeValue;

public interface IBusiChangeDetailSV {

	// 保存渠道修改申请明细信息
	public String saveBusiChangeDetail(
			IBOBusiChangeDetailValue busiChangeDetailValue) throws Exception;

	// 通过ID获取明细记录
	public IBOBusiChangeDetailValue getBusiChangeDetailByID(String busiDId)
			throws Exception;

	// 通过主ID获取明细记录
	public IBOBusiChangeDetailValue[] getBusiChangeDetailByPID(String busiId,
			String busiType, int startNum, int endNum) throws Exception;

	// 通过主ID获取明细记录数
	public int getBusiChangeDetailCountByPID(String busiId, String busiType)
			throws Exception;

	// 批量处理
	public void deleteBusiChangeDetailBatch(
			IBOBusiChangeDetailValue[] busiChangeDetailValues) throws Exception;

	// 选择营销案或资费案
	public IBOSelectSaleOrChargeValue[] getExistInfo(String batchType,
			String orgId, String operName, String batchName, String levelName,
			int startNum, int endNum) throws Exception;

	// count
	public int getExistInfoCount(String batchType, String orgId,
			String operName, String batchName, String levelName)
			throws Exception;
	
	// 判断填写工单在平台中是否存在
	public boolean isExistBatchId(String batchId, String batchType)
			throws Exception;
}
