package com.asiainfo.crm.exercise.staff.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.asiainfo.crm.exercise.staff.bo.BOOrganizeBean;
import com.asiainfo.crm.exercise.staff.bo.BOOrganizeEngine;
import com.asiainfo.crm.exercise.staff.dao.interfaces.IOrganizeDAO;
import com.asiainfo.crm.exercise.staff.ivalues.IBOOrganizeValue;

public class OrganizeDAOImpl implements IOrganizeDAO {

	public IBOOrganizeValue[] getOrganizeByName(String name, int startNum,
			int endNum) throws Exception {
		String[] cols = null;
		boolean isShowFK = false;
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		condition.append(" AND " + IBOOrganizeValue.S_Name + "= :name");
		Map parameter = new HashMap();
		parameter.put("name", "%" + name + "%");
		return BOOrganizeEngine.getBeans(cols, condition.toString(), parameter,
				startNum, endNum, isShowFK);
	}

	public IBOOrganizeValue[] getOrganizeByOrgID(String organizeId,
			int startNum, int endNum) throws Exception {
		String[] cols = null;
		boolean isShowFK = false;
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		condition.append(" AND " + IBOOrganizeValue.S_OrganizeId
				+ " = :organizeId");
		Map parameter = new HashMap();
		parameter.put("organizeId", organizeId);
		return BOOrganizeEngine.getBeans(cols, condition.toString(), parameter,
				startNum, endNum, isShowFK);
	}

	public void saveOrganize(IBOOrganizeValue[] objIOrganizeVlue)
			throws Exception {
		BOOrganizeBean[] arrOrganizeBeans = BOOrganizeEngine
				.transfer(objIOrganizeVlue);
		for (int i = 0; i < arrOrganizeBeans.length; i++) {
			if (arrOrganizeBeans[i].isNew()) {
				System.out
						.print(arrOrganizeBeans[i].getOrganizeId() + " isNew");
			} else if (arrOrganizeBeans[i].isModified()) {
				System.out.print(arrOrganizeBeans[i].getOrganizeId()
						+ " isModified");
			} else if (arrOrganizeBeans[i].isDeleted()) {
				System.out.print(arrOrganizeBeans[i].getOrganizeId()
						+ " isDeleted");
			} else if (arrOrganizeBeans[i].isHasRowId()) {
				System.out.print(arrOrganizeBeans[i].getOrganizeId()
						+ " isHasRowId");
			} 
//			else if (arrOrganizeBeans[i].isNull(arg0)) {
//				System.out.print(arrOrganizeBeans[i].getOrganizeId()
//						+ " isNull");
//			} else if (arrOrganizeBeans[i].isPropertyInitial(name)) {
//				System.out.print(arrOrganizeBeans[i].getOrganizeId()
//						+ " isPropertyInitial");
//			} else if (arrOrganizeBeans[i].isPropertyModified(name)) {
//				System.out.print(arrOrganizeBeans[i].getOrganizeId()
//						+ " isPropertyModified");
//			}
		}
		BOOrganizeEngine.saveBatch(arrOrganizeBeans);
	}

	public void delOrganize(IBOOrganizeValue[] objIBOOrganizeValues) throws Exception {
		for (int i = 0; i < objIBOOrganizeValues.length; i++) 
		{
			objIBOOrganizeValues[i].delete();
		}

		BOOrganizeEngine.save(objIBOOrganizeValues);
	}

	public IBOOrganizeValue[] getAllOrganize(int startNum, int endNum)
			throws Exception {
		String[] cols = null;
		boolean isShowFK = false;
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		Map parameter = null;
		return BOOrganizeEngine.getBeans(cols, condition.toString(), parameter,
				startNum, endNum, isShowFK);
	}

	public int getAllOrganizeCount() throws Exception {
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		Map parameter = null;
		return BOOrganizeEngine.getBeansCount(condition.toString(), parameter);
	}

	public IBOOrganizeValue[] getOrganizeByPareintID(String parentID,
			int startNum, int endNum) throws Exception {
		String[] cols = null;
		boolean isShowFK = false;
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		condition.append(" AND " + IBOOrganizeValue.S_ParentOrganizeId
				+ " = :parentID");
		Map parameter = new HashMap();
		parameter.put("parentID", parentID);
		return BOOrganizeEngine.getBeans(cols, condition.toString(), parameter,
				startNum, endNum, isShowFK);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
