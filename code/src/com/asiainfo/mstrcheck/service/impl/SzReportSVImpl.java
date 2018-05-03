package com.asiainfo.mstrcheck.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.mstrcheck.dao.interfaces.ISzReportDAO;
import com.asiainfo.mstrcheck.service.interfaces.ISzReportSV;

public class SzReportSVImpl implements ISzReportSV {

	public String getXml(String szToken) throws Exception {

		return ((ISzReportDAO) ServiceFactory.getService(ISzReportDAO.class))
				.getXml(szToken);
	}

	public void getToken(String orgName, String token) throws Exception {

		((ISzReportDAO) ServiceFactory.getService(ISzReportDAO.class))
				.getToken(orgName, token);
	}
}