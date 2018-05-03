package com.asiainfo.sale.complain.dao.interfaces;

import java.rmi.RemoteException;

import com.asiainfo.sale.complain.ivalues.IBOOrderComplainsDetailValue;

public interface IOrderComplainDetailDAO {

	// 保存投诉申请明细信息
	public int saveOrderComplainDetail(
			IBOOrderComplainsDetailValue OrderComplainDetailValue) throws Exception;
	
	// 批量删除投诉申请明细信息
	public void delOrderComplainDetail(
			IBOOrderComplainsDetailValue[] OrderComplainDetailValues) throws Exception;

	// 通过ID获取明细记录
	public IBOOrderComplainsDetailValue getOrderComplainDetailByID(String Id)
			throws Exception;

	// 通过工单ID获取明细记录
	public IBOOrderComplainsDetailValue[] getOrderComplainDetailByPID(String complainId,
			 int startNum, int endNum) throws Exception;

	// 通过工单ID获取明细记录数
	public int getOrderComplainDetailCountByPID(String complainId)
			throws Exception;

	// 批量处理
	public void deleteOrderComplainDetailBatch(
			IBOOrderComplainsDetailValue[] orderComplainDetailValues) throws Exception;

	// 判断填写工单在平台中是否存在
	public boolean isExistBatchId(String batchId, String batchType)
			throws Exception;
}
