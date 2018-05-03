package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.ISaleUserScaleDAO;
import com.asiainfo.sale.activity.ivalues.IBOUserScaleValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleUserScaleSV;


public class SaleUserScaleSVImpl implements ISaleUserScaleSV {

	@Override
	public IBOUserScaleValue[] getUserScaleByRelaId(String relaId,String infoType,
			 int startNum, int endNum) throws Exception {
		return ((ISaleUserScaleDAO) ServiceFactory
				.getService(ISaleUserScaleDAO.class)).getUserScaleByRelaId(
				relaId,infoType, startNum, endNum);
	}

	@Override
	public void save(IBOUserScaleValue[] values) throws Exception {

		((ISaleUserScaleDAO) ServiceFactory
				.getService(ISaleUserScaleDAO.class)).save(values);
	}

	@Override
	public int getCnUserScaleListByRelaId(String relaId,String infoType)
			throws Exception {

		return ((ISaleUserScaleDAO) ServiceFactory
				.getService(ISaleUserScaleDAO.class))
				.getCnUserScaleListByRelaId(relaId,infoType);
	}

}
