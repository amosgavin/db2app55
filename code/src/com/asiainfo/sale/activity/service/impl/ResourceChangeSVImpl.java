package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.IResourceChangeDAO;
import com.asiainfo.sale.activity.ivalues.IBOResourceChangeValue;
import com.asiainfo.sale.activity.service.interfaces.IResourceChangeSV;

public class ResourceChangeSVImpl implements IResourceChangeSV{

	@Override
	public IBOResourceChangeValue getResourceChange(String ResourceId)
			throws Exception {
		return ((IResourceChangeDAO)ServiceFactory.getService(IResourceChangeDAO.class)).getResourceChange(ResourceId);
	}

	@Override
	public int saveResourceChange(IBOResourceChangeValue resourceChangeValue)
			throws Exception {
		return ((IResourceChangeDAO)ServiceFactory.getService(IResourceChangeDAO.class)).saveResourceChange(resourceChangeValue);
	}

	@Override
	public int queryResourceChangeCount(String resourceId, String applyName,
			String principle, String cityId, String state, String beginTime,
			String endTime) throws Exception {
		return ((IResourceChangeDAO)ServiceFactory.getService(IResourceChangeDAO.class)).queryResourceChangeCount(resourceId,
				applyName, principle, cityId, state, beginTime, endTime);
	}

	@Override
	public IBOResourceChangeValue[] queryResourceChangeValue(String resourceId,
			String applyName, String principle, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum)
			throws Exception {
		return ((IResourceChangeDAO)ServiceFactory.getService(IResourceChangeDAO.class)).queryResourceChangeValue(resourceId,
				applyName, principle, cityId, state, beginTime, endTime,
				startNum, endNum);
	}
	
	public void changeStateToPass(String resourceId) throws Exception {

		changeStateTo(resourceId, "3");
	}
	
	public void changeStateToNoPass(String resourceId) throws Exception{
		
		changeStateTo(resourceId,"4");
	}
	
	public void changeStateTo(String resourceId, String state) throws Exception {

		((IResourceChangeDAO) ServiceFactory.getService(IResourceChangeDAO.class))
				.changeStateTo(resourceId, state);
	}

}
