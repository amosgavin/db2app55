package com.asiainfo.sale.common.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.common.bo.BOOperatorInfoBean;
import com.asiainfo.sale.common.bo.BOWFOperatorBean;
import com.asiainfo.sale.common.dao.interfaces.IOperatorInfoDAO;
import com.asiainfo.sale.common.ivalues.IBOWFOperatorValue;
import com.asiainfo.sale.common.service.interfaces.IOperatorInfoSV;

public class OperatorInfoSVImpl implements IOperatorInfoSV {

	
	public BOOperatorInfoBean[] getOperatorInfo(String staffName, String orgId, int startNum,
			int endNum) throws Exception, RuntimeException {
		IOperatorInfoDAO operatorInfoDAO = (IOperatorInfoDAO) ServiceFactory
				.getService(IOperatorInfoDAO.class);
		return operatorInfoDAO.getOperatorInfo(staffName, orgId, startNum, endNum);
	}

	
	public int getCountByOrgId(String staffName, String orgId) throws Exception,
			RuntimeException {
		IOperatorInfoDAO operatorInfoDAO = (IOperatorInfoDAO) ServiceFactory
		.getService(IOperatorInfoDAO.class);
		return operatorInfoDAO.getCountByOrgId(staffName, orgId);
	}

	
	public int getWFOperatorCountByOrgId(String staffName, String roleId, String orgId)
			throws Exception, RuntimeException {
		IOperatorInfoDAO operatorInfoDAO = (IOperatorInfoDAO) ServiceFactory
		.getService(IOperatorInfoDAO.class);
		return operatorInfoDAO.getWFOperatorCountByOrgId(staffName, roleId, orgId);
	}

	
	public BOWFOperatorBean[] getWFOperatorInfo(String staffName, String roleId, String orgId,
			int startNum, int endNum) throws Exception, RuntimeException {
		IOperatorInfoDAO operatorInfoDAO = (IOperatorInfoDAO) ServiceFactory
		.getService(IOperatorInfoDAO.class);
		return operatorInfoDAO.getWFOperatorInfo(staffName, roleId, orgId, startNum, endNum);
	}

	public IBOWFOperatorValue getNameById(String id)
			throws Exception, RuntimeException {
		IOperatorInfoDAO operatorInfoDAO = (IOperatorInfoDAO) ServiceFactory
		.getService(IOperatorInfoDAO.class);
		return operatorInfoDAO.getNameById(id);
	}
}
