package com.asiainfo.sale.common.service.impl;

import java.rmi.RemoteException;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.common.dao.interfaces.ISaleStaticDataDAO;
import com.asiainfo.sale.common.ivalues.IBOSaleStaticDataValue;
import com.asiainfo.sale.common.service.interfaces.ISaleStaticDataSV;

public class SaleStaticDataSVImpl implements ISaleStaticDataSV {

	public IBOSaleStaticDataValue[] getSaleStaticData(String codeType)
			throws Exception, RemoteException {
		try {
			ISaleStaticDataDAO saleStaticDataDAO = (ISaleStaticDataDAO) ServiceFactory
					.getService(ISaleStaticDataDAO.class);
			IBOSaleStaticDataValue[] values = saleStaticDataDAO
					.getSaleStaticData(codeType);
			return values;
		} catch (Throwable e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public IBOSaleStaticDataValue getSaleStaticData(String codeType,
			String codeId) throws Exception, RemoteException {
		try {
			ISaleStaticDataDAO saleStaticDataDAO = (ISaleStaticDataDAO) ServiceFactory
					.getService(ISaleStaticDataDAO.class);
			IBOSaleStaticDataValue ISysStaticDataValue = saleStaticDataDAO
					.getSaleStaticData(codeType, codeId);
			return ISysStaticDataValue;
		} catch (Throwable e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public IBOSaleStaticDataValue[] getBrand() throws Exception,
			RuntimeException {
		return getSaleStaticData("brand");
	}

	public IBOSaleStaticDataValue[] getChannel() throws Exception,
			RuntimeException {
		return getSaleStaticData("qd");
	}

	public IBOSaleStaticDataValue[] getMarket() throws Exception,
			RuntimeException {
		return getSaleStaticData("market");
	}
	
	public IBOSaleStaticDataValue[] getGroupType() throws Exception,
	RuntimeException {
		return getSaleStaticData("groupType");
		}
	
	public IBOSaleStaticDataValue[] getActivity() throws Exception,
	RuntimeException {
		return getSaleStaticData("actform");
		}

	public IBOSaleStaticDataValue[] area_type() throws Exception,
			RuntimeException {
		return getSaleStaticData("area_type");
	}

	public IBOSaleStaticDataValue[] getZDYXD() throws Exception,
			RuntimeException {
		return getSaleStaticData("zdyxd");
	}

	public void initCache() throws Exception, RuntimeException {
		((ISaleStaticDataDAO) ServiceFactory
				.getService(ISaleStaticDataDAO.class)).initCache();
	}

	public IBOSaleStaticDataValue[] getSaleStaticDatas(String codeType,
			String name) throws Exception {
		ISaleStaticDataDAO saleStaticDataDAO = (ISaleStaticDataDAO) ServiceFactory
				.getService(ISaleStaticDataDAO.class);
		return saleStaticDataDAO.getSaleStaticDatas(codeType, name);
	}

	public int queryStaticDateCount(String codeType, String name)
			throws Exception {
		ISaleStaticDataDAO saleStaticDataDAO = (ISaleStaticDataDAO) ServiceFactory
				.getService(ISaleStaticDataDAO.class);
		return saleStaticDataDAO.queryStaticDateCount(codeType, name);
	}

	@Override
	public IBOSaleStaticDataValue[] getBusiChangeType() throws Exception,
			RuntimeException {
		return getSaleStaticData("busiChangeType");
	}

	@Override
	public IBOSaleStaticDataValue[] getChannelType() throws Exception,
			RuntimeException {

		return getSaleStaticData("channelType");
	}

	@Override
	public IBOSaleStaticDataValue[] getOpenBrand() throws Exception,
			RuntimeException {
		
		return getSaleStaticData("openBrand");
	}

	@Override
	public IBOSaleStaticDataValue[] getGeoPosType() throws Exception,
			RuntimeException {

		return getSaleStaticData("geoPosType");
	}

	@Override
	public IBOSaleStaticDataValue[] getStarLevel() throws Exception,
			RuntimeException {

		return getSaleStaticData("starLevel");
	}

	@Override
	public IBOSaleStaticDataValue[] getBatchCode() throws Exception,
			RuntimeException {

		return getSaleStaticData("bossBatchCode");
	}

	@Override
	public IBOSaleStaticDataValue[] getBatchName() throws Exception,
			RuntimeException {

		return getSaleStaticData("bossBatchName");
	}
}
