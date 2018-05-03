package com.asiainfo.crm.exercise.staff.service.impl;

import java.rmi.RemoteException;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.crm.exercise.staff.dao.interfaces.IStaffDAO;
import com.asiainfo.crm.exercise.staff.ivalues.IBOStaffValue;
import com.asiainfo.crm.exercise.staff.service.interfaces.IStaffSV;

public class StaffSVImpl implements IStaffSV {

	private IStaffDAO getIStaffDAO() {
		return (IStaffDAO) ServiceFactory.getService(IStaffDAO.class);
	}

	public IBOStaffValue[] getStaffByStaffID(String staffID, int startNum,
			int endNum) throws RemoteException, Exception {
		return getIStaffDAO().getStaffByStaffID(staffID, startNum, endNum);
	}
	
	public void delStaff(IBOStaffValue[] objIBOStaffValues)
			throws RemoteException, Exception {
		getIStaffDAO().delStaff(objIBOStaffValues);
	}

	public IBOStaffValue[] getStaffByName(String name, int startNum, int endNum)
			throws RemoteException, Exception {
		return getIStaffDAO().getStaffByName(name, startNum, endNum);
	}

	public IBOStaffValue[] getStaffByOrgID(String organizeID, int startNum,
			int endNum) throws RemoteException, Exception {
		return getIStaffDAO().getStaffByOrgID(organizeID, startNum, endNum);
	}

	public int getStaffCountByOrgId(String organizeId) throws RemoteException,
			Exception {
		return getIStaffDAO().getStaffCountByOrgId(organizeId);
	}

	public int getStaffCountByStaffId(String staffId) throws RemoteException,
			Exception {
		return getIStaffDAO().getStaffCountByStaffId(staffId);
	}

	public void saveStaff(IBOStaffValue[] objIBOStaffValues)
			throws RemoteException, Exception {
		getIStaffDAO().saveStaff(objIBOStaffValues);		
	}

	public int getStaffCountByName(String name) throws RemoteException,
			Exception {
		return getIStaffDAO().getStaffCountByName(name);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
