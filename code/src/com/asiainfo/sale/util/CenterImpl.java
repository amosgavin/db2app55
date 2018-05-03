package com.asiainfo.sale.util;

import com.ai.appframe2.complex.center.CenterInfo;

public class CenterImpl implements com.ai.appframe2.complex.center.interfaces.ICenter{

	
	public CenterInfo getCenterByValue(String regionId) throws Exception {
		return new CenterInfo("ICenter", regionId);
	}

}
