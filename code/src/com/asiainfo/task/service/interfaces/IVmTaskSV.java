package com.asiainfo.task.service.interfaces;

import com.asiainfo.task.ivalues.IBOVmTaskTsValue;
import com.asiainfo.task.ivalues.IBOVmTaskValue;

public interface IVmTaskSV {
	/**
	 * ���ݸ�λ��ѯ��ǰ���칤��
	 * 
	 * @param role
	 *            ��λid
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
