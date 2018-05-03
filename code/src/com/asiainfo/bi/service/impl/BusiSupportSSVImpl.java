package com.asiainfo.bi.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.bi.dao.interfaces.IBusiSupportSDAO;
import com.asiainfo.bi.ivalues.IBOBusiSupportSValue;
import com.asiainfo.bi.service.interfaces.IBusiSupportSSV;

public class BusiSupportSSVImpl implements IBusiSupportSSV {

	@Override
	public IBOBusiSupportSValue[] getStatisticsINBusiSu(String dispatchTimeF,
			String dispatchTimeTo) throws Exception {

		return ((IBusiSupportSDAO) ServiceFactory
				.getService(IBusiSupportSDAO.class)).getStatisticsINBusiSu(
				dispatchTimeF, dispatchTimeTo);
	}

}
