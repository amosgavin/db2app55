package com.asiainfo.workflow.util.server.interfaces;

import java.rmi.RemoteException;

import com.asiainfo.workflow.util.ivalues.IBOTaskRouteValue;

public interface ITaskUtilSV {
	public IBOTaskRouteValue[] getRoute4TaskTemplate(String templateCode,
			long taskId) throws RuntimeException, Exception;

	public String getStaffIdByTaskId(String taskId) throws RuntimeException,
			Exception;

	public String[] finishUserTask(String taskId, String result,
			String curStaff, String nextStepStaff, String comment,
			String reason, String auditFlag) throws RuntimeException, Exception;

	public String[] reAuthorizeTask(String taskId, String authorizeStaffId,
			String staffId) throws RemoteException, Exception;

	public String[] createWorkflow(String flowType, String staffId,
			String objectId, String result, String notes)
			throws RuntimeException, Exception;

	public String getThisStaffId(String staffId) throws RuntimeException,
			Exception;
}
