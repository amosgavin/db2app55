package com.asiainfo.sale.access.service.interfaces;

import com.asiainfo.sale.access.ivalues.IBOBusiChangeValue;

public interface IBusiChangeSV {

	// 保存渠道修改申请主信息
	public int saveBusiChange(IBOBusiChangeValue busiChangeValue)
			throws Exception;

	// 获取修改申请主信息
	public IBOBusiChangeValue getBusiChargeById(String busiId) throws Exception;

	// 查询渠道修改信息
	public IBOBusiChangeValue[] queryBusiChangeValue(String busiId,
			String applyName, String principle, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum)
			throws Exception;

	// 查询渠道修改信息记录数
	public int queryBusiChangeCount(String busiId, String applyName,
			String principle, String cityId, String state, String beginTime,
			String endTime) throws Exception;

	// 删除记录
	public void deleteBusiChangeMainRecords(
			IBOBusiChangeValue[] busiChangeValues) throws Exception;

	// 修改工单状态
	public void changeStateTo(String busiId, String state) throws Exception;
	
	// 是否含有电子券
	public boolean isHasTicketChange(String busiId) throws Exception;

	public void changeStateToPass(String busiId) throws Exception;

	public void changeStateToNoPass(String busiId) throws Exception;
	
	public void changeStateTo2(String busiId) throws Exception;

	public String checkdq_kf(String busiId) throws Exception;
}
