package com.asiainfo.task.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.task.ivalues.IBOVmTaskTsValue;
import com.asiainfo.task.ivalues.IBOVmTaskValue;
import com.asiainfo.task.dao.interfaces.IVmTaskSVDAO;
import com.asiainfo.task.service.interfaces.IVmTaskSV;

public class VmTaskSVImpl implements IVmTaskSV {
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
			RuntimeException {
		IVmTaskSVDAO vmtask = (IVmTaskSVDAO) ServiceFactory
				.getService(IVmTaskSVDAO.class);

		return vmtask.getVmTask(role);
	}

	@Override
	public IBOVmTaskValue getVmTaskByTaskId(String taskId) throws Exception,
			RuntimeException {

		return ((IVmTaskSVDAO) ServiceFactory.getService(IVmTaskSVDAO.class))
				.getVmTaskByTaskId(taskId);
	}

	@Override
	public IBOVmTaskValue[] getVmTaskByWFId(String wfId, String taskTag)
			throws Exception, RuntimeException {

		return ((IVmTaskSVDAO) ServiceFactory.getService(IVmTaskSVDAO.class))
				.getVmTaskByWFId(wfId, taskTag);
	}

	@Override
	public IBOVmTaskTsValue getVmTaskTsByTaskId(String taskId)
			throws Exception, RuntimeException {

		return ((IVmTaskSVDAO) ServiceFactory.getService(IVmTaskSVDAO.class))
				.getVmTaskTsByTaskId(taskId);
	}

	@Override
	public IBOVmTaskTsValue[] getVmTaskTsByWFId(String wfId, String taskTag)
			throws Exception, RuntimeException {

		return ((IVmTaskSVDAO) ServiceFactory.getService(IVmTaskSVDAO.class))
				.getVmTaskTsByWFId(wfId, taskTag);
	}

	@Override
	public void saveVmTask(IBOVmTaskValue task) throws Exception,
			RuntimeException {

		((IVmTaskSVDAO) ServiceFactory.getService(IVmTaskSVDAO.class))
				.saveVmTask(task);
	}

	@Override
	public void saveVmTaskTs(IBOVmTaskTsValue task) throws Exception,
			RuntimeException {

		((IVmTaskSVDAO) ServiceFactory.getService(IVmTaskSVDAO.class))
				.saveVmTaskTs(task);
	}

	@Override
	public void changeVmTaskStateTo6(String wfId) {

		IVmTaskSVDAO dao = ((IVmTaskSVDAO) ServiceFactory
				.getService(IVmTaskSVDAO.class));
		try {
			IBOVmTaskTsValue[] tasks = dao.getVmTaskTsByWFId(wfId, null);
			for (IBOVmTaskTsValue task : tasks) {
				if (task.getTaskStaffId().equals("000")) {
					task.setState(6);
					task.setLabel("停售处理");
					dao.saveVmTaskTs(task);
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
