package com.ai.bce.plugin.autoTable.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.plugin.autoTable.bo.BceTagPAutotableAttrBean;
import com.ai.bce.plugin.autoTable.bo.BceTagPAutotableBean;
import com.ai.bce.plugin.autoTable.dao.interfaces.IBceAutoPageTagATDAO;
import com.ai.bce.plugin.autoTable.service.interfaces.IBceAutoPageTagATSV;

public class BceAutoPageTagATSVImpl implements IBceAutoPageTagATSV{
	IBceAutoPageTagATDAO iBEAutoPageTagATDAO = (IBceAutoPageTagATDAO) ServiceFactory.getService(IBceAutoPageTagATDAO.class);
	
	public BceTagPAutotableBean getATableByObjId(long objId) throws Exception {
		// TODO Auto-generated method stub
		return iBEAutoPageTagATDAO.getATableByObjId( objId);
	}

	public BceTagPAutotableAttrBean[] getATableAttrByTbId(long id) throws Exception {
		// TODO Auto-generated method stub
		return iBEAutoPageTagATDAO.getATableAttrByTbId(id);
	}

}
