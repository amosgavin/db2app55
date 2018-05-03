package com.asiainfo.sale.weapon.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.bo.BOSaleMainEngine;
import com.asiainfo.sale.activity.dao.interfaces.ISaleDetailShowDAO;
import com.asiainfo.sale.weapon.bo.BOSaleWeaponBean;
import com.asiainfo.sale.weapon.bo.BOSaleWeaponEngine;
import com.asiainfo.sale.weapon.bo.BOSaleWeaponInfoBean;
import com.asiainfo.sale.weapon.bo.BOSaleWeaponMainBean;
import com.asiainfo.sale.weapon.bo.BOSaleWeaponMainDeEngine;
import com.asiainfo.sale.weapon.bo.BOSaleWeaponMainEngine;
import com.asiainfo.sale.weapon.dao.interfaces.ISaleWeaponDetailShowDAO;
import com.asiainfo.sale.weapon.dao.interfaces.ISaleWeaponMainDAO;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponDeValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponInfoValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponMainDeValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponMainValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponValue;

public class SaleWeaponMainDAOImpl implements ISaleWeaponMainDAO {

	
	public void delSaleWeaponMain(IBOSaleWeaponMainValue[] saleWeaponMainValues)
			throws Exception, RuntimeException {
		for (int i = 0; i < saleWeaponMainValues.length; i++) {
			saleWeaponMainValues[i].delete();
		}
		BOSaleWeaponMainEngine.save(saleWeaponMainValues);
	}
	
	public void delSaleWeaponMain(String mid)
	throws Exception, RuntimeException {
	IBOSaleWeaponMainValue[] saleWeaponMainValues=getSaleWeaponMainById(mid);
	this.delSaleWeaponMain(saleWeaponMainValues);
	}
	
	public int getCount(String name, String applicant, String org)
			throws Exception {
		Object[] objects = getCondition(name, applicant, org);
		return BOSaleWeaponMainEngine.getBeansCount((String) objects[0],
				(Map) objects[1]);
	}

	
	public int getCountById(String id) throws Exception {
		Map parameter = new HashMap();
		String condition = " 1 = 1 AND " + IBOSaleWeaponMainValue.S_Id
				+ " = :id";
		parameter.put("id", id);
		return BOSaleWeaponMainEngine.getBeansCount(condition, parameter);
	}

	
	public IBOSaleWeaponMainValue[] getSaleWeaponMain(String name,
			String applicant, String org, int startNum, int endNum)
			throws Exception {
		Object[] objects = getCondition(name, applicant, org);
		return BOSaleWeaponMainEngine.getBeans((String) objects[0],
				(Map) objects[1]);
	}

	public IBOSaleWeaponMainValue[] getSaleWeaponMainById(String id) throws Exception{
		Map parameter = new HashMap();
		String condition = " 1 = 1 AND " + IBOSaleWeaponMainValue.S_Id
				+ " = :id";
		parameter.put("id", id);
		return BOSaleWeaponMainEngine.getBeans(condition, parameter);
	}
	public IBOSaleWeaponMainValue[] getSaleWeaponMainById(String id,
			int startNum, int endNum) throws Exception {
		Map parameter = new HashMap();
		String condition = " 1 = 1 AND " + IBOSaleWeaponMainValue.S_Id
				+ " = :id";
		parameter.put("id", id);
		return BOSaleWeaponMainEngine.getBeans(condition, parameter);
		
	}

	
	public void saveSaleWeaponMain(IBOSaleWeaponMainValue[] saleWeaponMainValues)
			throws Exception {
		BOSaleWeaponMainBean[] saleWeaponMainBeans = BOSaleWeaponMainEngine
				.transfer(saleWeaponMainValues);
		for (int i = 0; i < saleWeaponMainBeans.length; i++) {
		if(saleWeaponMainBeans[i].isNew() || 0>=Integer.parseInt(saleWeaponMainBeans[i].getId())){
			saleWeaponMainBeans[i].setId(BOSaleWeaponMainEngine.getNewId().toString());
			saleWeaponMainBeans[i].setCreateTime(BOSaleMainEngine.getSysDate());
		}
		}
		BOSaleWeaponMainEngine.saveBatch(saleWeaponMainBeans);
	}	

	/**
	 * 查询参数拼装
	 * 
	 * @param name
	 * @param applicant
	 * @param org
	 * @return Object[] Object[0] String 查询条件; Object[1] Map 查询参数
	 */
	private Object[] getCondition(String name, String applicant, String org) {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
//		if (name != null && !name.equals("")) {
//			condition.append(" AND " + IBOSaleWeaponMainValue.S_Name
//					+ " like :name");
//			parameter.put("name", "%" + name + "%");
//		}
		if (applicant != null && !applicant.equals("")) {
			condition.append(" AND " + IBOSaleWeaponMainValue.S_Applicant
					+ " = :applicant");
			parameter.put("applicant", applicant);
		}
		if (org != null && !org.equals("")) {
			condition.append(" AND " + IBOSaleWeaponMainValue.S_Org
					+ " = :backMonth");
			parameter.put("org", org);
		}
		return new Object[] { condition.toString(), parameter };
	}

	public IBOSaleWeaponMainDeValue[] getSaleWeaponMainDeById(String id) throws Exception{
		Map parameter = new HashMap();
		String condition = " 1 = 1 AND " + IBOSaleWeaponMainDeValue.S_Id
				+ " = :id";
		parameter.put("id", id);
		return BOSaleWeaponMainDeEngine.getBeans(condition, parameter);
	}
	

	@Override
	public IBOSaleWeaponInfoValue getSaleWeaponInfoValue(String id) throws Exception {
		IBOSaleWeaponInfoValue saleWeaponInfoValue =new BOSaleWeaponInfoBean();
		IBOSaleWeaponMainDeValue[] saleWeaponMainDeValues=this.getSaleWeaponMainDeById(id);
		IBOSaleWeaponMainDeValue saleWeaponMainDeValue=saleWeaponMainDeValues[0];
		IBOSaleWeaponDeValue[] SaleWeaponDeValues=((ISaleWeaponDetailShowDAO) ServiceFactory
				.getService(ISaleWeaponDetailShowDAO.class)).getSaleWeaponDetailShowValues(id);
		saleWeaponInfoValue.setSaleWeaponMainDeValue(saleWeaponMainDeValue);
		saleWeaponInfoValue.setSaleDetailShowValues(SaleWeaponDeValues);
		return saleWeaponInfoValue;
	}
	
	
}
