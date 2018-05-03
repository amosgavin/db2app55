package com.asiainfo.bi.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.bi.dao.interfaces.IBusiSupportDAO;
import com.asiainfo.bi.ivalues.IBOBusiSupportValue;
import com.asiainfo.bi.service.interfaces.IBusiSupportSV;

public class BusiSupportSVImpl implements IBusiSupportSV {

	@Override
	public IBOBusiSupportValue[] getItemInfoINBusiSu(String itemId,
			String itemType, String state, String dispatchTimeF,
			String dispatchTimeTo, String dealPerson, int startNum, int endNum)
			throws Exception {

		return ((IBusiSupportDAO) ServiceFactory
				.getService(IBusiSupportDAO.class)).getItemInfoINBusiSu(itemId,
				itemType, state, dispatchTimeF, dispatchTimeTo, dealPerson,
				startNum, endNum);
	}

	@Override
	public int getItemInfoINBusiSuCount(String itemId, String itemType,
			String state, String dispatchTimeF, String dispatchTimeTo,
			String dealPerson) throws Exception {

		return ((IBusiSupportDAO) ServiceFactory
				.getService(IBusiSupportDAO.class)).getItemInfoINBusiSuCount(
				itemId, itemType, state, dispatchTimeF, dispatchTimeTo,
				dealPerson);
	}

}
