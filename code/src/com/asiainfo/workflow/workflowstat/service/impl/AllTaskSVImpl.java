package com.asiainfo.workflow.workflowstat.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.workflow.workflowstat.dao.interfaces.IAllTaskDAO;
import com.asiainfo.workflow.workflowstat.ivalues.IBOAllTaskStatValue;
import com.asiainfo.workflow.workflowstat.service.interfaces.IAllTaskSV;

public class AllTaskSVImpl implements IAllTaskSV {

	/**
	 * 根据workflowId查询出所有工单（已归档工单及未归档待办工单）
	 * 
	 * @param workflowId
	 *            工作流ID
	 * @param startNum
	 *            分页记录开始索引
	 * @param endNum
	 *            分页记录结束索引
	 * 
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOAllTaskStatValue[] getAllTaskByWorkFlowId(String workflowId,
			int startNum, int endNum) throws Exception, RuntimeException {
		IBOAllTaskStatValue[] taskList = null;
		taskList = ((IAllTaskDAO) ServiceFactory.getService(IAllTaskDAO.class))
				.getAllTaskByWorkFlowId(workflowId, startNum, endNum);

		return taskList;
	}

	/**
	 * 根据workflowId查询出所有任务总记录数
	 * 
	 * @param workflowId
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getAllTaskCount(String workflowId) throws Exception,
			RuntimeException {

		int cnt = ((IAllTaskDAO) ServiceFactory.getService(IAllTaskDAO.class))
				.getAllTaskCount(workflowId);

		return cnt;
	}

}
