package com.asiainfo.workflow.workflowstat.dao.impl;

import java.util.HashMap;

import com.asiainfo.task.ivalues.IBOCurTaskValue;
import com.asiainfo.workflow.workflowstat.bo.BOAllTaskStatEngine;
import com.asiainfo.workflow.workflowstat.dao.interfaces.IAllTaskDAO;
import com.asiainfo.workflow.workflowstat.ivalues.IBOAllTaskStatValue;

public class AllTaskDAOImpl implements IAllTaskDAO {

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
		IBOAllTaskStatValue[] allTask;
		String condition = IBOCurTaskValue.S_WorkflowId
				+ " =:workflowId and STATE in('3','5') and (1=1 or (FINISH_STAFF_ID = TASK_STAFF_ID or FINISH_STAFF_ID is null))";
		HashMap<String, String> parameter = new HashMap<String, String>();
		parameter.put("workflowId", workflowId);

		allTask = BOAllTaskStatEngine.getBeans(null, condition.toString(),
				parameter, startNum, endNum, false);

		return allTask;

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
		String condition = IBOCurTaskValue.S_WorkflowId
				+ " =:workflowId and STATE in('3','5') and (1=1 or (FINISH_STAFF_ID = TASK_STAFF_ID or FINISH_STAFF_ID is null))";
		HashMap<String, String> parameter = new HashMap<String, String>();
		parameter.put("workflowId", workflowId);

		return BOAllTaskStatEngine.getBeansCount(condition, parameter);
	}

}
