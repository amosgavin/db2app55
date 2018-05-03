package com.asiainfo.sale.tag.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.tag.dao.interfaces.ITagMainDAO;
import com.asiainfo.sale.tag.ivalues.IBOApplyTagValue;
import com.asiainfo.sale.tag.service.interfaces.ITagMainSV;

public class TagMainSVImpl implements ITagMainSV {

	
	public int saveTagMain(IBOApplyTagValue tagMainValues) throws Exception,
			RuntimeException {
		return ((ITagMainDAO) ServiceFactory.getService(ITagMainDAO.class))
				.saveTagMain(tagMainValues);
	}

	
	public IBOApplyTagValue getTagMainShowById(String id) throws Exception,
			RuntimeException {
		return ((ITagMainDAO) ServiceFactory.getService(ITagMainDAO.class))
				.getTagMainShowById(id);
	}

	
	public IBOApplyTagValue[] getMainTagShowByTaskTag(String taskTag)
			throws Exception {
		return ((ITagMainDAO) ServiceFactory.getService(ITagMainDAO.class))
				.getMainTagShowByTaskTag(taskTag);
	}

}
