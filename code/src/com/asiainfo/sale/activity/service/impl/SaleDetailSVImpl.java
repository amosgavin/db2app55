package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.ISaleDetailDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailGroupBySaleTypeValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleDetailSV;

public class SaleDetailSVImpl implements ISaleDetailSV {

	public void delSaleDetail(IBOSaleDetailValue[] SaleDetailValues)
			throws Exception, RuntimeException {
		((ISaleDetailDAO) ServiceFactory.getService(ISaleDetailDAO.class))
				.delSaleDetail(SaleDetailValues);
	}

	public int getCount(String mainId) throws Exception, RuntimeException {
		return ((ISaleDetailDAO) ServiceFactory
				.getService(ISaleDetailDAO.class)).getCount(mainId);
	}

	public IBOSaleDetailValue[] getSaleDetailByMainId(String mainId,
			int startNum, int endNum) throws Exception, RuntimeException {
		return ((ISaleDetailDAO) ServiceFactory
				.getService(ISaleDetailDAO.class)).getSaleDetailByMainId(
				mainId, startNum, endNum);
	}

	public String saveSaleDetail(IBOSaleDetailValue[] SaleDetailValues)
			throws Exception, RuntimeException {
		return ((ISaleDetailDAO) ServiceFactory
				.getService(ISaleDetailDAO.class))
				.saveSaleDetail(SaleDetailValues);
	}

	public IBOSaleDetailValue getSaleDetailById(String id) throws Exception,
			RuntimeException {
		return ((ISaleDetailDAO) ServiceFactory
				.getService(ISaleDetailDAO.class)).getSaleDetailById(id);
	}

	public int getCountGroupBySaleType(String mainId) throws Exception,
			RuntimeException {
		return ((ISaleDetailDAO) ServiceFactory
				.getService(ISaleDetailDAO.class))
				.getCountGroupBySaleType(mainId);
	}

	public IBOSaleDetailGroupBySaleTypeValue[] getSaleDetailGroupBySaleTypeValues(
			String mainId, int startNum, int endNum) throws Exception,
			RuntimeException {
		return ((ISaleDetailDAO) ServiceFactory
				.getService(ISaleDetailDAO.class))
				.getSaleDetailGroupBySaleTypeValues(mainId, startNum, endNum);
	}

	public int getCountBySaleFlag(String mainId, String saleFlag)
			throws Exception, RuntimeException {
		return ((ISaleDetailDAO) ServiceFactory
				.getService(ISaleDetailDAO.class)).getCountBySaleFlag(mainId,
				saleFlag);
	}

	public IBOSaleDetailValue[] getSaleDetailBySaleFlag(String mainId,
			String saleFlag, int startNum, int endNum) throws Exception,
			RuntimeException {
		return ((ISaleDetailDAO) ServiceFactory
				.getService(ISaleDetailDAO.class)).getSaleDetailBySaleFlag(
				mainId, saleFlag, startNum, endNum);
	}

	@Override
	public boolean IsHasSameBossId(String levBossid, String orderId)
			throws Exception {

		return ((ISaleDetailDAO) ServiceFactory
				.getService(ISaleDetailDAO.class)).IsHasSameBossId(levBossid,
				orderId);
	}

	@Override
	public String getNewSaleDetailId() throws Exception {

		return ((ISaleDetailDAO) ServiceFactory
				.getService(ISaleDetailDAO.class)).getNewSaleDetailId();
	}

}
