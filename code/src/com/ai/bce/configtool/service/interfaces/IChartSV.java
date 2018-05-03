package com.ai.bce.configtool.service.interfaces;

public interface IChartSV {
	public int getBceFramesCountByModuleId(long moduleId) throws Exception;
	
	public int getBcePageFrameCountByModuleId(long moduleId) throws Exception;
	
	public int getBcePageCountByModuleId(long moduleId) throws Exception;
	
	public int getBceRuleSetCountByModuleId(long moduleId) throws Exception;
}
