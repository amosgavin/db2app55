package com.asiainfo.sale.complain.service.impl;

import java.rmi.RemoteException;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.complain.dao.interfaces.IOrderComplainDetailDAO;
import com.asiainfo.sale.complain.ivalues.IBOOrderComplainsDetailValue;
import com.asiainfo.sale.complain.service.interfaces.IOrderComplainDetailSV;

public class OrderComplainDetailSVImpl implements IOrderComplainDetailSV {

	@Override
	public void deleteOrderComplainDetailBatch(
			IBOOrderComplainsDetailValue[] orderComplainDetailValues)
			throws Exception, RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IBOOrderComplainsDetailValue getOrderComplainDetailByID(String Id)
			throws Exception, RemoteException {
		// TODO Auto-generated method stub
		IOrderComplainDetailDAO idao = (IOrderComplainDetailDAO) ServiceFactory.getService(IOrderComplainDetailDAO.class);
		return idao.getOrderComplainDetailByID(Id);
	}

	@Override
	public IBOOrderComplainsDetailValue[] getOrderComplainDetailByPID(
			String complainId, int startNum, int endNum) throws Exception, RemoteException {
		// TODO Auto-generated method stub
		IOrderComplainDetailDAO idao = (IOrderComplainDetailDAO) ServiceFactory.getService(IOrderComplainDetailDAO.class);
		return idao.getOrderComplainDetailByPID(complainId, startNum, endNum);
	}

	@Override
	public int getOrderComplainDetailCountByPID(String complainId)
			throws Exception, RemoteException {
		// TODO Auto-generated method stub
		IOrderComplainDetailDAO idao = (IOrderComplainDetailDAO) ServiceFactory.getService(IOrderComplainDetailDAO.class);
		return idao.getOrderComplainDetailCountByPID(complainId);
	}

	@Override
	public boolean isExistBatchId(String batchId, String batchType)
			throws Exception, RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveOrderComplainDetail(
			IBOOrderComplainsDetailValue OrderComplainDetailValue)
			throws Exception, RemoteException {
		// TODO Auto-generated method stub
		IOrderComplainDetailDAO idao = (IOrderComplainDetailDAO) ServiceFactory.getService(IOrderComplainDetailDAO.class);
		return idao.saveOrderComplainDetail(OrderComplainDetailValue);
	}

	@Override
	public void delOrderComplainDetail(
			IBOOrderComplainsDetailValue[] OrderComplainDetailValues)
			throws Exception, RemoteException {
		// TODO Auto-generated method stub
		IOrderComplainDetailDAO idao = (IOrderComplainDetailDAO) ServiceFactory.getService(IOrderComplainDetailDAO.class);
		idao.delOrderComplainDetail(OrderComplainDetailValues);
		
	}

}
