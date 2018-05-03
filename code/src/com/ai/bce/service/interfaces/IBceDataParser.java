package com.ai.bce.service.interfaces;

import java.util.Map;

import com.ai.bce.ivalues.IBceData;
import com.ai.bce.ivalues.ISubmitData;

public interface IBceDataParser {

	public IBceData dataParse(ISubmitData[] submitDatas, Map sessionMap)throws Exception;
}
