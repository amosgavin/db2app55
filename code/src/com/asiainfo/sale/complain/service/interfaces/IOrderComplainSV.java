package com.asiainfo.sale.complain.service.interfaces;

import java.rmi.RemoteException;

import com.asiainfo.sale.complain.ivalues.IBOOrderComplainsValue;

public interface IOrderComplainSV {

	// 保存投诉申请主信息
	public int saveOrderComplain(IBOOrderComplainsValue orderComplainValue)
			throws Exception, RemoteException;
	
	//通过工单ID查询投诉申请信息
	public IBOOrderComplainsValue getOrderComplainByID(String complainid) throws Exception, RemoteException;
	
	// 查询渠道修改信息
	public IBOOrderComplainsValue[] queryOrderComplainValue(String complainId,
			String applyName, String principle, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum)
			throws Exception, RemoteException;

	// 查询渠道修改信息记录数
	public int queryOrderComplainCount(String complainId, String applyName,
			String principle, String cityId, String state, String beginTime,
			String endTime) throws Exception, RemoteException;

	// 删除记录
	public void deleteOrderComplainMainRecords(
			IBOOrderComplainsValue[] orderComplainValues) throws Exception, RemoteException;

	// 修改工单状态
	public void changeStateTo(String complainId, String state) throws Exception, RemoteException;
	
	public void changeStateToPass(String complainId) throws Exception, RemoteException;

	public void changeStateToNoPass(String complainId) throws Exception, RemoteException;
	
	public void changeStateTo2(String complainId) throws Exception, RemoteException;
	
	public void changeStsToNo(String mainId, String choice) throws Exception,RuntimeException;
}
