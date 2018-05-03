package com.asiainfo.crm.exercise.staff.service.impl;

import java.rmi.RemoteException;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.crm.exercise.staff.dao.interfaces.IOrganizeDAO;
import com.asiainfo.crm.exercise.staff.ivalues.IBOOrganizeValue;
import com.asiainfo.crm.exercise.staff.service.interfaces.IOrganizeSV;

public class OrganizeSVImpl implements IOrganizeSV {

	private IOrganizeDAO getOrganizeDAO() {
		return (IOrganizeDAO) ServiceFactory.getService(IOrganizeDAO.class);
	}

	public IBOOrganizeValue[] getAllOrganize(int startNum, int endNum)
			throws RemoteException, Exception {
		return getOrganizeDAO().getAllOrganize(startNum, endNum);
	}

	public int getAllOrganizeCount() throws RemoteException, Exception {
		return getOrganizeDAO().getAllOrganizeCount();
	}

	public void delOrganize(IBOOrganizeValue[] objIBOOrganizeValues)
			throws RemoteException, Exception {
		getOrganizeDAO().delOrganize(objIBOOrganizeValues);
	}

	public IBOOrganizeValue[] getOrganizeByName(String name, int startNum,
			int endNum) throws RemoteException, Exception {
		return getOrganizeDAO().getOrganizeByName(name, startNum, endNum);
	}

	public IBOOrganizeValue[] getOrganizeByOrgID(String organizeId,
			int startNum, int endNum) throws RemoteException, Exception {
		return getOrganizeDAO().getOrganizeByOrgID(organizeId, startNum, endNum);
	}

	public void saveOrganize(IBOOrganizeValue[] objIBOOrganizeVlues)
			throws RemoteException, Exception {
		getOrganizeDAO().saveOrganize(objIBOOrganizeVlues);
	}

	public IBOOrganizeValue[] getOrganizeByPareintID(String parentID,
			int startNum, int endNum) throws RemoteException, Exception {
		return getOrganizeDAO().getOrganizeByPareintID(parentID, startNum, endNum);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
