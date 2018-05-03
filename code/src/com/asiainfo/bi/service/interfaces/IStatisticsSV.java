package com.asiainfo.bi.service.interfaces;

import com.asiainfo.bi.ivalues.IBOStatisticsValue;
import com.asiainfo.bi.ivalues.IBOTaskDurationCountValue;
import com.asiainfo.bi.ivalues.IBOTaskDurationValue;

public interface IStatisticsSV {

	public IBOStatisticsValue[] getStatistics(String objectType)
			throws Exception;

	public IBOTaskDurationValue[] getTaskDuration(String objectType)
			throws Exception;

	public IBOTaskDurationCountValue[] getTaskDurationCount(String objectType)
			throws Exception;
	
	public IBOTaskDurationValue[] getProcessNodeAvgTime(String objectType,
			String startTimeFrom, String startTimeTo) throws Exception;
	
	public IBOTaskDurationCountValue[] getProcessNodeTaskCount(String objectType,
			String startTimeFrom, String startTimeTo) throws Exception;
}
