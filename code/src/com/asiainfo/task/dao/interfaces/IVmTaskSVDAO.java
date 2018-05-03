package com.asiainfo.task.dao.interfaces;

import com.asiainfo.task.ivalues.IBOVmTaskTsValue;
import com.asiainfo.task.ivalues.IBOVmTaskValue;

public interface IVmTaskSVDAO {

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
}
