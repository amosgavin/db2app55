package com.asiainfo.sale.complain.service.impl;

import java.rmi.RemoteException;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.complain.dao.interfaces.IOrderComplainDAO;
import com.asiainfo.sale.complain.ivalues.IBOOrderComplainsValue;
import com.asiainfo.sale.complain.service.interfaces.IOrderComplainSV;

public class OrderComplainSVImpl implements IOrderComplainSV {

	@Override
	public int saveOrderComplain(IBOOrderComplainsValue orderComplainValue)
			throws Exception, RemoteException {
		// TODO Auto-generated method stub
		IOrderComplainDAO orderComplainDAO = (IOrderComplainDAO) ServiceFactory.getService(IOrderComplainDAO.class);
		 return orderComplainDAO.saveOrderComplain(orderComplainValue);
	}

	@Override
	public IBOOrderComplainsValue getOrderComplainByID(String complainid)
			throws Exception , RemoteException {
		// TODO Auto-generated method stub
		IOrderComplainDAO orderComplainDAO = (IOrderComplainDAO) ServiceFactory.getService(IOrderComplainDAO.class);
		IBOOrderComplainsValue ivalue =orderComplainDAO.getOrderComplainsById(complainid);
		return ivalue;
	}

	@Override
	public void changeStateTo(String complainId, String state) throws Exception, RemoteException {
		// TODO Auto-generated method stub
		IOrderComplainDAO orderComplainDAO = (IOrderComplainDAO) ServiceFactory.getService(IOrderComplainDAO.class);
		orderComplainDAO.changeStateTo(complainId, state);
	}

	@Override
	public void changeStateTo2(String complainId) throws Exception, RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStateToNoPass(String complainId) throws Exception, RemoteException {
		// TODO Auto-generated method stub
		changeStateTo(complainId,"4");
	}

	@Override
	public void changeStateToPass(String complainId) throws Exception, RemoteException {
		// TODO Auto-generated method stub
		changeStateTo(complainId,"3");
	}
	
	@Override
	public void changeStsToNo(String mainId, String choice) throws Exception,
	RuntimeException {
		// TODO Auto-generated method stub
		if (choice.equals("end")) {
			changeStateTo(mainId, "4");
		}
	}

	@Override
	public void deleteOrderComplainMainRecords(
			IBOOrderComplainsValue[] orderComplainValues) throws Exception, RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int queryOrderComplainCount(String complainId, String applyName,
			String principle, String cityId, String state, String beginTime,
			String endTime) throws Exception, RemoteException {
		// TODO Auto-generated method stub
		IOrderComplainDAO orderComplainDAO = (IOrderComplainDAO) ServiceFactory.getService(IOrderComplainDAO.class);
		return orderComplainDAO.queryOrderComplainCount(complainId, applyName, principle, cityId, state, beginTime, endTime);
	}

	@Override
	public IBOOrderComplainsValue[] queryOrderComplainValue(String complainId,
			String applyName, String principle, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum)
			throws Exception, RemoteException {
		// TODO Auto-generated method stub
		IOrderComplainDAO orderComplainDAO = (IOrderComplainDAO) ServiceFactory.getService(IOrderComplainDAO.class);
		return orderComplainDAO.queryOrderComplainValue(complainId, applyName, principle, cityId, state, beginTime, endTime, startNum, endNum);
	}


}
