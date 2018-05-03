package com.asiainfo.sale.complain.dao.interfaces;

import com.asiainfo.sale.complain.ivalues.IBOOrderComplainsValue;

public interface IOrderComplainDAO {
	// 保存申请主信息
	public int saveOrderComplain(IBOOrderComplainsValue OrderComplainsValue)
			throws Exception;
	// 获取修改申请主信息
	public IBOOrderComplainsValue getOrderComplainsById(String complain_id) throws Exception;
	
	// 查询投诉申请信息
	public IBOOrderComplainsValue[] queryOrderComplainValue(String complainId,
			String applyName, String principle, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum)
			throws Exception;

	// 查询投诉申请信息记录数
	public int queryOrderComplainCount(String complainId, String applyName,
			String principle, String cityId, String state, String beginTime,
			String endTime) throws Exception;

	// 批量处理
	public void saveOrderComplainBatch(IBOOrderComplainsValue[] busiChangeValues)
			throws Exception;

	// 修改工单状态
	public void changeStateTo(String complainId, String state) throws Exception;

}
