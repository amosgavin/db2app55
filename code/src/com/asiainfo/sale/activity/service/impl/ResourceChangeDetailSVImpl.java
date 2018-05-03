package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.IResourceChangeDetailDAO;
import com.asiainfo.sale.activity.ivalues.IBOResourceChangeDetailValue;
import com.asiainfo.sale.activity.service.interfaces.IResourceChangeDetailSV;

public class ResourceChangeDetailSVImpl implements IResourceChangeDetailSV{

	@Override
	public IBOResourceChangeDetailValue getResourceChangeDetailByID(
			int resourceId) throws Exception {
		return ((IResourceChangeDetailDAO)ServiceFactory.getService(IResourceChangeDetailDAO.class)).getResourceChangeDetailByID(resourceId);
	}

	@Override
	public int saveResourceChangeDetail(IBOResourceChangeDetailValue resourceChangeDetailValue)
			throws Exception {
		return ((IResourceChangeDetailDAO)ServiceFactory.getService(IResourceChangeDetailDAO.class)).saveResourceChangeDetail(resourceChangeDetailValue);
	}

}
