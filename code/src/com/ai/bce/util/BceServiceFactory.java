package com.ai.bce.util;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.dao.interfaces.IBceFrameDAO;
import com.ai.bce.service.interfaces.IBceFrameSV;
import com.ai.bce.service.interfaces.IBceRuleEngineForQuerySV;
import com.ai.bce.service.interfaces.IBceRuleEngineSV;
import com.ai.bce.service.interfaces.IBceStudioSV;

public class BceServiceFactory {

	public static IBceFrameSV getBceFrameSV() throws Exception {
		return (IBceFrameSV) BServiceFactory.getService(IBceFrameSV.class);
	}

	public static IBceFrameDAO getBceFrameDAOForConf() throws Exception {
		return (IBceFrameDAO) BServiceFactory.getService(IBceFrameDAO.class);
	}

	public static IBceFrameDAO getBceFrameDAO() throws Exception {
		return (IBceFrameDAO) ServiceFactory.getService(IBceFrameDAO.class);
	}

	public static IBceRuleEngineSV getCrossRuleEngine() {
		return (IBceRuleEngineSV) ServiceFactory.getCrossCenterService(IBceRuleEngineSV.class);
	}

	public static IBceRuleEngineSV getRuleEngine() {
		return (IBceRuleEngineSV) BceSVUtil.getSVService(IBceRuleEngineSV.class);
	}

	public static IBceRuleEngineSV getRuleEngineForQuery() {
		return (IBceRuleEngineSV) BceSVUtil.getSVService(IBceRuleEngineForQuerySV.class);
	}

	public static IBceStudioSV getBceStudioSV() throws Exception {
		return (IBceStudioSV) BServiceFactory.getService(IBceStudioSV.class);
	}
}
