package com.asiainfo.bi.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.bi.dao.interfaces.IStatisticsDAO;
import com.asiainfo.bi.ivalues.IBOStatisticsValue;
import com.asiainfo.bi.ivalues.IBOTaskDurationCountValue;
import com.asiainfo.bi.ivalues.IBOTaskDurationValue;
import com.asiainfo.bi.service.interfaces.IStatisticsSV;

public class StatisticsSVImpl implements IStatisticsSV {

	@Override
	public IBOStatisticsValue[] getStatistics(String objectType)
			throws Exception {

		return ((IStatisticsDAO) ServiceFactory
				.getService(IStatisticsDAO.class)).getStatistics(objectType);
	}

	@Override
	public IBOTaskDurationValue[] getTaskDuration(String objectType)
			throws Exception {

		return ((IStatisticsDAO) ServiceFactory
				.getService(IStatisticsDAO.class)).getTaskDuration(objectType);
	}

	@Override
	public IBOTaskDurationCountValue[] getTaskDurationCount(String objectType)
			throws Exception {

		return ((IStatisticsDAO) ServiceFactory
				.getService(IStatisticsDAO.class))
				.getTaskDurationCount(objectType);
	}

	@Override
	public IBOTaskDurationValue[] getProcessNodeAvgTime(String objectType,
			String startTimeFrom, String startTimeTo) throws Exception {

		return ((IStatisticsDAO) ServiceFactory
				.getService(IStatisticsDAO.class)).getProcessNodeAvgTime(
				objectType, startTimeFrom, startTimeTo);
	}

	@Override
	public IBOTaskDurationCountValue[] getProcessNodeTaskCount(
			String objectType, String startTimeFrom, String startTimeTo)
			throws Exception {

		return ((IStatisticsDAO) ServiceFactory
				.getService(IStatisticsDAO.class)).getProcessNodeTaskCount(
				objectType, startTimeFrom, startTimeTo);
	}

}
