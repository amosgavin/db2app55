package com.asiainfo.workflow.util.server.impl;

import java.rmi.RemoteException;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.comframe.client.ComframeClient;
import com.asiainfo.sale.activity.dao.interfaces.ISaleMainDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;
import com.asiainfo.sale.common.service.impl.SendSmsSVImpl;
import com.asiainfo.sale.common.service.interfaces.ISaleStaticDataSV;
import com.asiainfo.sale.common.service.interfaces.ISendSmsSV;
import com.asiainfo.sale.util.StringUtil;
import com.asiainfo.workflow.util.TaskUtil;
import com.asiainfo.workflow.util.ivalues.IBOTaskRouteValue;
import com.asiainfo.workflow.util.server.interfaces.ITaskUtilSV;

public class TaskUtilSVImpl implements ITaskUtilSV {

	@Override
	public IBOTaskRouteValue[] getRoute4TaskTemplate(String templateCode,
			long taskId) {
		return TaskUtil.getRoute4TaskTemplate(templateCode, taskId);
	}

	@Override
	public String getStaffIdByTaskId(String taskId) {
		return TaskUtil.getStaffIdByTaskId(taskId);
	}

	@Override
	public String[] finishUserTask(String taskId, String result,
			String curStaff, String nextStepStaff, String comment,
			String reason, String auditFlag) throws RuntimeException, Exception {
		return TaskUtil.finishUserTask(taskId, result, curStaff, nextStepStaff,
				comment, reason, auditFlag);
	}

	@Override
	public String[] createWorkflow(String flowType, String staffId,
			String objectId, String result, String notes)
			throws RuntimeException, Exception {
		ISaleStaticDataSV iSaleStaticDataSV = (ISaleStaticDataSV) ServiceFactory
				.getService(ISaleStaticDataSV.class);
		String flowCode = iSaleStaticDataSV.getSaleStaticData("flowType",
				flowType).getCodeName();

		String[] rcode = TaskUtil.createWorkflow(flowCode, staffId, flowType,
				objectId, result, notes);
		return rcode;
	}

	@Override
	public String getThisStaffId(String staffId) throws RuntimeException,
			Exception {
		return TaskUtil.getThisStaffId(staffId);
	}

	@Override
	public String[] reAuthorizeTask(String taskId, String authorizeStaffId,
			String staffId) throws RemoteException, Exception {
		if (null == taskId) {
			return new String[] { "1000", "获取流程编号为空" };
		}
		if (null == staffId) {
			return new String[] { "1000", "获取提交人为空" };
		}
		if (null == authorizeStaffId) {
			return new String[] { "1000", "获取加办人为空" };
		}
		String rs = ComframeClient.reAuthorizeTask(taskId, staffId, "-1",
				authorizeStaffId);
		if (StringUtil.isNotBlank(rs)) {
			return new String[] { "0000", rs };
		} else {
			return new String[] { "1001", "提交加办失败" };
		}
	}
}