package com.asiainfo.task.dao.impl;

import java.util.HashMap;

import com.asiainfo.task.dao.interfaces.IVmTaskSVDAO;
import com.asiainfo.task.ivalues.IBOVmTaskTsValue;
import com.asiainfo.task.ivalues.IBOVmTaskValue;
import com.asiainfo.task.bo.BOVmTaskEngine;
import com.asiainfo.task.bo.BOVmTaskTsEngine;

public class VmTaskSVDAOImpl implements IVmTaskSVDAO {

	public IBOVmTaskValue[] getVmTask(String role) throws Exception,
			RuntimeException {
		String sql = "";
		HashMap critas = new HashMap();
		return BOVmTaskEngine.getBeans(sql, critas);
	}

	@Override
	public IBOVmTaskValue getVmTaskByTaskId(String taskId) throws Exception,
			RuntimeException {

		return BOVmTaskEngine.getBean(taskId);
	}

	@Override
	public IBOVmTaskValue[] getVmTaskByWFId(String wfId, String taskTag)
			throws Exception, RuntimeException {

		String condition = " workflow_id='" + wfId + "' and task_tag='"
				+ taskTag + "' ";
		return BOVmTaskEngine.getBeans(condition, null);
	}

	@Override
	public IBOVmTaskTsValue getVmTaskTsByTaskId(String taskId)
			throws Exception, RuntimeException {

		return BOVmTaskTsEngine.getBean(taskId);
	}

	@Override
	public IBOVmTaskTsValue[] getVmTaskTsByWFId(String wfId, String taskTag)
			throws Exception, RuntimeException {

		String condition = " workflow_id='" + wfId + "' and task_tag='"
				+ taskTag + "' ";
		return BOVmTaskTsEngine.getBeans(condition, null);
	}

	@Override
	public void saveVmTaskTs(IBOVmTaskTsValue task) throws Exception,
			RuntimeException {

		BOVmTaskTsEngine.save(task);
	}

	@Override
	public void saveVmTask(IBOVmTaskValue task) throws Exception,
			RuntimeException {

		BOVmTaskEngine.save(task);
	}
}
