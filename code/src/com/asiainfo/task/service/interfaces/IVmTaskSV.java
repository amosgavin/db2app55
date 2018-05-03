package com.asiainfo.task.service.interfaces;

import com.asiainfo.task.ivalues.IBOVmTaskTsValue;
import com.asiainfo.task.ivalues.IBOVmTaskValue;

public interface IVmTaskSV {
	/**
	 * 根据岗位查询当前待办工单
	 * 
	 * @param role
	 *            岗位id
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOVmTaskValue[] getVmTask(String role) throws Exception,
			RuntimeException;

	public IBOVmTaskValue getVmTaskByTaskId(String taskId) throws Exception,
			RuntimeException;

	public IBOVmTaskTsValue getVmTaskTsByTaskId(String taskId)
			throws Exception, RuntimeException;

	public IBOVmTaskValue[] getVmTaskByWFId(String wfId, String taskTag)
			throws Exception, RuntimeException;

	public IBOVmTaskTsValue[] getVmTaskTsByWFId(String wfId, String taskTag)
			throws Exception, RuntimeException;

	public void saveVmTask(IBOVmTaskValue task) throws Exception,
			RuntimeException;

	public void saveVmTaskTs(IBOVmTaskTsValue task) throws Exception,
			RuntimeException;

	public void changeVmTaskStateTo6(String wfId);
}
