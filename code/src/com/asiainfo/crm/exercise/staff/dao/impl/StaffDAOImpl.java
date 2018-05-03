package com.asiainfo.crm.exercise.staff.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.asiainfo.crm.exercise.staff.bo.BOStaffBean;
import com.asiainfo.crm.exercise.staff.bo.BOStaffEngine;
import com.asiainfo.crm.exercise.staff.dao.interfaces.IStaffDAO;
import com.asiainfo.crm.exercise.staff.ivalues.IBOStaffValue;

public class StaffDAOImpl implements IStaffDAO {

	public void delStaff(IBOStaffValue[] objIBOStaffValues) throws Exception {
		for (int i = 0; i < objIBOStaffValues.length; i++) {
			objIBOStaffValues[i].delete();
		}
		BOStaffEngine.save(objIBOStaffValues);
	}

	public IBOStaffValue[] getStaffByStaffID(String staffId, int startNum,
			int endNum) throws Exception {
		String[] cols = null;
		boolean isShowFK = false;
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		condition.append(" AND " + IBOStaffValue.S_StaffId + " = :staffId");
		Map parameter = new HashMap();
		parameter.put("staffId", staffId);
		return BOStaffEngine.getBeans(cols, condition.toString(), parameter,
				startNum, endNum, isShowFK);
	}

	public IBOStaffValue[] getStaffByName(String name, int startNum, int endNum)
			throws Exception {
		String[] cols = null;
		boolean isShowFK = false;
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		condition.append(" AND " + IBOStaffValue.S_Name + " like :name");
		Map parameter = new HashMap();
		parameter.put("name", "%"+name+"%");
		return BOStaffEngine.getBeans(cols, condition.toString(), parameter,
				startNum, endNum, isShowFK);
	}

	public IBOStaffValue[] getStaffByOrgID(String organizeId, int startNum,
			int endNum) throws Exception {
		String[] cols = null;
		boolean isShowFK = false;
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		condition.append(" AND " + IBOStaffValue.S_OrganizeId
				+ " = :organizeId");
		Map parameter = new HashMap();
		parameter.put("organizeId", organizeId);
		return BOStaffEngine.getBeans(cols, condition.toString(), parameter,
				startNum, endNum, isShowFK);
	}

	public int getStaffCountByOrgId(String organizeId) throws Exception {
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		condition.append(" AND " + IBOStaffValue.S_OrganizeId
				+ " = :organizeId");
		Map parameter = new HashMap();
		parameter.put("organizeId", organizeId);
		return BOStaffEngine.getBeansCount(condition.toString(), parameter);
	}

	public int getStaffCountByStaffId(String staffId) throws Exception {
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		condition.append(" AND " + IBOStaffValue.S_StaffId + " = :staffId");
		Map parameter = new HashMap();
		parameter.put("staffId", staffId);
		return BOStaffEngine.getBeansCount(condition.toString(), parameter);
	}

	public int getStaffCountByName(String name) throws Exception {
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		condition.append(" AND " + IBOStaffValue.S_Name + " like :name");
		Map parameter = new HashMap();
		parameter.put("name", "%"+name+"%");
		return BOStaffEngine.getBeansCount(condition.toString(), parameter);
	}

	public void saveStaff(IBOStaffValue[] objIBOStaffValues) throws Exception {
		BOStaffBean[] arrStaffBeans = BOStaffEngine.transfer(objIBOStaffValues);
		for (int i = 0; i < arrStaffBeans.length; i++) {
			if (arrStaffBeans[i].isNew()) {
				System.out.println(arrStaffBeans[i].getStaffId() + " isNew");
			} else if (arrStaffBeans[i].isModified()) {
				System.out.println(arrStaffBeans[i].getStaffId()
						+ " isModified");
			} else if (arrStaffBeans[i].isDeleted()) {
				System.out.println(arrStaffBeans[i].getStaffId()
						+ " isDeleted");
			} else if (arrStaffBeans[i].isHasRowId()) {
				System.out.println(arrStaffBeans[i].getStaffId()
						+ " isHasRowId");
			}
			// else if (arrStaffBeans[i].isNull(arg0)) {
			// System.out.print(arrStaffBeans[i].getOrganizeId()
			// + " isNull");
			// } else if (arrStaffBeans[i].isPropertyInitial(name)) {
			// System.out.print(arrStaffBeans[i].getOrganizeId()
			// + " isPropertyInitial");
			// } else if (arrStaffBeans[i].isPropertyModified(name)) {
			// System.out.print(arrStaffBeans[i].getOrganizeId()
			// + " isPropertyModified");
			// }
		}
		BOStaffEngine.saveBatch(arrStaffBeans);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
