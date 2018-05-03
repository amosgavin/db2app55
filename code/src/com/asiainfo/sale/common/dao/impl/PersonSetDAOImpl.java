package com.asiainfo.sale.common.dao.impl;

import com.asiainfo.sale.common.bo.BOPersonSetBean;
import com.asiainfo.sale.common.bo.BOPersonSetEngine;
import com.asiainfo.sale.common.dao.interfaces.IPersonSetDAO;
import com.asiainfo.sale.common.ivalues.IBOPersonSetValue;

public class PersonSetDAOImpl implements IPersonSetDAO {

	@Override
	public void savePersonInfo(int operatorId, String isReceiveSMS,
			String isReceiveSysInfo) throws Exception {

		IBOPersonSetValue personSet = getPersonSetByOpeId(operatorId);

		if (personSet != null) {

			if (isReceiveSMS != null && !isReceiveSMS.equals("")) {
				personSet.setReceiveSmsFlag(isReceiveSMS);
			}
			if (isReceiveSysInfo != null && !isReceiveSysInfo.equals("")) {
				personSet.setSysSmsFlag(isReceiveSysInfo);
			}

		} else {
			
			personSet = new BOPersonSetBean();
			personSet.setId(BOPersonSetEngine.getNewId().intValue());
			personSet.setOperatorId(operatorId);
			if (isReceiveSMS != null && !isReceiveSMS.equals("")) {
				personSet.setReceiveSmsFlag(isReceiveSMS);
			}
			if (isReceiveSysInfo != null && !isReceiveSysInfo.equals("")) {
				personSet.setSysSmsFlag(isReceiveSysInfo);
			}
			personSet.setStsToNew();
		}
		BOPersonSetEngine.save(personSet);
	}

	@Override
	public boolean isReceiveSMS(int operatorId) throws Exception {

		IBOPersonSetValue personSet = getPersonSetByOpeId(operatorId);
		if(null != personSet) {
			return personSet.getReceiveSmsFlag().equals("1");
		}
		return true;
	}

	private IBOPersonSetValue getPersonSetByOpeId(int operatorId) throws Exception{
		
		String condition = " " + IBOPersonSetValue.S_OperatorId + " = "
				+ operatorId;
		IBOPersonSetValue[] personSets = BOPersonSetEngine.getBeans(condition,
				null);

		IBOPersonSetValue personSet = new BOPersonSetBean();

		if (personSets != null && personSets.length > 0) {

			personSet = personSets[0];
		} else {
			return null;
		}
		return personSet;
	}
}
