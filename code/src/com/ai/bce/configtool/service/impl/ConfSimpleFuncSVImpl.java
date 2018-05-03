package com.ai.bce.configtool.service.impl;

import com.ai.bce.bo.BceSimpleFuncEngine;
import com.ai.bce.bo.BceSimpleFuncFieldMappingEngine;
import com.ai.bce.configtool.service.interfaces.IConfSimpleFuncSV;
import com.ai.bce.ivalues.IBceSimpleFuncFieldMappingValue;
import com.ai.bce.ivalues.IBceSimpleFuncValue;

/**
 * 单点功能的服务实现类
 * 
 * @author linzhaoming
 *
 */
public class ConfSimpleFuncSVImpl implements IConfSimpleFuncSV {
	
	public IBceSimpleFuncValue[] getSimpleFuncValues(String cond,
			int startIndex, int endIndex) throws Exception {
		return BceSimpleFuncEngine.getBeans(null, cond, null, startIndex,
				endIndex, false);
	}

	public int getSimpleFuncValuesCount(String cond) throws Exception {
		return BceSimpleFuncEngine.getBeansCount(cond, null);
	}

	public IBceSimpleFuncFieldMappingValue[] getSimpleFuncFieldMappingValues(
			String cond, int startIndex, int endIndex) throws Exception {
		return BceSimpleFuncFieldMappingEngine.getBeans(null, cond, null,
				startIndex, endIndex, false);
	}

	public int getSimpleFuncFieldMappingCount(String cond) throws Exception {
		return BceSimpleFuncFieldMappingEngine.getBeansCount(cond, null);
	}
}
