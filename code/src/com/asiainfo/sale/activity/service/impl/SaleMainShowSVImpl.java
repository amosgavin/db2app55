package com.asiainfo.sale.activity.service.impl;

import java.net.URLDecoder;
import java.util.ArrayList;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.ISaleMainDAO;
import com.asiainfo.sale.activity.dao.interfaces.ISaleMainShowDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleInfoValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainShowValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleMainShowSV;
import com.asiainfo.util.agent.ClientAgent;

public class SaleMainShowSVImpl implements ISaleMainShowSV {

	public int getCount(String name, String applicant, String org)
			throws Exception, RuntimeException {
		return ((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.getCount(name, applicant, org);
	}

	public IBOSaleMainShowValue[] getSaleMainShow(String name,
			String applicant, String org, int startNum, int endNum)
			throws Exception, RuntimeException {
		return ((ISaleMainShowDAO) ServiceFactory
				.getService(ISaleMainShowDAO.class)).getSaleMainShow(name,
				applicant, org, startNum, endNum);
	}

	public IBOSaleMainShowValue getSaleMainShowById(String id)
			throws Exception, RuntimeException {
		return ((ISaleMainShowDAO) ServiceFactory
				.getService(ISaleMainShowDAO.class)).getSaleMainShowById(id);
	}

	public IBOSaleMainShowValue[] getSaleMainAndFWInfo(String taskTag,
			String curStat, String mainCode, String name, String applicant,
			String org, String submitTimeBegin, String submitTimeEnd,
			int startNum, int endNum) throws Exception, RuntimeException {
		ArrayList<String> wfList = ClientAgent.getAllCurTaskByTag(taskTag,
				"saleCase", curStat);
		if (null == wfList || wfList.size() < 1) {
			return new IBOSaleMainShowValue[0];
		}
		return ((ISaleMainShowDAO) ServiceFactory
				.getService(ISaleMainShowDAO.class)).getSaleMainAndFWInfo(
				wfList, mainCode, name, applicant, org, submitTimeBegin,
				submitTimeEnd, startNum, endNum);
	}

	public int getCount(String taskTag, String curStat, String mainCode,
			String name, String applicant, String org, String submitTimeBegin,
			String submitTimeEnd) throws Exception, RuntimeException {
		ArrayList<String> wfList = ClientAgent.getAllCurTaskByTag(taskTag,
				"saleCase", curStat);
		if (null == wfList || wfList.size() < 1) {
			return 0;
		}
		return ((ISaleMainShowDAO) ServiceFactory
				.getService(ISaleMainShowDAO.class)).getCount(wfList, mainCode,
				name, applicant, org, submitTimeBegin, submitTimeEnd);
	}

	public IBOSaleMainShowValue[] getSaleMainAndFWInfo2(String selectType,
			String mainCode, String name, String applicant, String org,
			String submitTimeBegin, String submitTimeEnd, String isFinish,
			int startNum, int endNum) throws Exception, RuntimeException {
		if(null != name){
			name = URLDecoder.decode(name,"utf-8");
		}
		return ((ISaleMainShowDAO) ServiceFactory
				.getService(ISaleMainShowDAO.class)).getSaleMainAndFWInfo(
				selectType, mainCode, name, applicant, org, submitTimeBegin,
				submitTimeEnd, isFinish, startNum, endNum);
	}

	public int getCount2(String selectType, String mainCode, String name,
			String applicant, String org, String submitTimeBegin,
			String submitTimeEnd, String isFinish) throws Exception,
			RuntimeException {
		if(null != name){
			name = URLDecoder.decode(name,"utf-8");
		}
		return ((ISaleMainShowDAO) ServiceFactory
				.getService(ISaleMainShowDAO.class)).getCount(selectType,
				mainCode, name, applicant, org, submitTimeBegin, submitTimeEnd,
				isFinish);
	}

	public IBOSaleMainShowValue getSaleMainOverviewById(String id)
			throws Exception, RuntimeException {
		return ((ISaleMainShowDAO) ServiceFactory
				.getService(ISaleMainShowDAO.class))
				.getSaleMainOverviewById(id)[0];
	}

	@Override
	public IBOSaleInfoValue getSaleInfoValue(String id) throws Exception,
			RuntimeException {
		return ((ISaleMainShowDAO) ServiceFactory
				.getService(ISaleMainShowDAO.class)).getSaleInfoValue(id);
	}

	@Override
	public IBOSaleMainShowValue[] getSaleMainInfo(String selectType,
			String mainCode, String name, String applicant, String org,
			String submitTimeBegin, String submitTimeEnd, int startNum,
			int endNum) throws Exception, RuntimeException {
		return ((ISaleMainShowDAO) ServiceFactory
				.getService(ISaleMainShowDAO.class)).getSaleMainInfo(
				selectType, mainCode, name, applicant, org, submitTimeBegin,
				submitTimeEnd, startNum, endNum);
	}

	@Override
	public int getSaleMainInfoCount(String selectType, String mainCode,
			String name, String applicant, String org, String submitTimeBegin,
			String submitTimeEnd) throws Exception,
			RuntimeException {
		return ((ISaleMainShowDAO) ServiceFactory
				.getService(ISaleMainShowDAO.class)).getSaleMainInfoCount(
				selectType, mainCode, name, applicant, org, submitTimeBegin,
				submitTimeEnd);
	}
}
