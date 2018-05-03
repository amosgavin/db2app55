package com.asiainfo.stopSelling.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.stopSelling.bo.BOStopSellMBean;
import com.asiainfo.stopSelling.ivalues.IBOStopSellMValue;
import com.asiainfo.stopSelling.service.interfaces.IStopSellMSV;
import com.asiainfo.task.ivalues.IBOVmTaskTsValue;
import com.asiainfo.task.service.interfaces.IVmTaskSV;
import com.asiainfo.workflow.util.server.interfaces.ITaskUtilSV;

public class StopSellMAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(StopSellMAction.class);

	public void saveStopSellMInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOStopSellMValue[] chargeStopSellMValues = null;// 前台提交的数据

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOStopSellMBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOStopSellMBean[]) {
				chargeStopSellMValues = (BOStopSellMBean[]) obj;
			}
		}
		IStopSellMSV chargeStopSellMSV = (IStopSellMSV) ServiceFactory
				.getService(IStopSellMSV.class);

		try {
			if (null == chargeStopSellMValues
					|| 0 == chargeStopSellMValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "没有修改需要保存！");
			} else {
				if(chargeStopSellMValues[0].isDeleted() == true)
				{
					chargeStopSellMValues[0].undelete();
					chargeStopSellMValues[0].setIsDelete("1");
				}
				int mainId = chargeStopSellMSV.save(chargeStopSellMValues);
				cp.set("MAINID", String.valueOf(mainId));
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	/**
	 * 提交下一节点
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void finishUserTask(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String taskId = request.getParameter("taskId");
		String wfId = request.getParameter("wfId");
		String result = request.getParameter("result");
		String nextStepStaff = request.getParameter("staffId");
		String comment = request.getParameter("comment");
		String reason = request.getParameter("reason").replace("^#", "%");
		String auditFlag = request.getParameter("auditFlag");
		String taskTag = request.getParameter("taskTag");
		String nextTaskTag = request.getParameter("nextTaskTag");

		ITaskUtilSV taskUtilSV = (ITaskUtilSV) ServiceFactory
				.getService(ITaskUtilSV.class);

		IVmTaskSV vmTaskSV = (IVmTaskSV) ServiceFactory
				.getService(IVmTaskSV.class);

		String[] rcode = null;
		try {
			if ("".equals(taskId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				// 提交前任务
				if (taskTag.contains("Sign005")) {
					IBOVmTaskTsValue curTask = vmTaskSV
							.getVmTaskTsByTaskId(taskId);
					if (curTask.getLabel().equals("分派停售任务")) {
						IBOVmTaskTsValue[] tasks = vmTaskSV.getVmTaskTsByWFId(
								wfId, taskTag);
						for (IBOVmTaskTsValue task : tasks) {
							if (task.getTaskStaffId().equals("000")) {
								task.setTaskStaffId(nextStepStaff);
								//task.setState(5);
								task.setLabel("停售处理");
								SimpleDateFormat df = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss");
								task.setCreateDate(Timestamp.valueOf(df
										.format(new Date())));
								vmTaskSV.saveVmTaskTs(task);
								break;
							}
						}
					}
				}
				rcode = taskUtilSV.finishUserTask(taskId, result, "",
						nextStepStaff, comment, reason, auditFlag);
				/* 提交后任务
				if (nextTaskTag.contains("Sign005")) {
					IBOVmTaskTsValue[] tasks = vmTaskSV.getVmTaskTsByWFId(wfId,
							nextTaskTag);
					for (IBOVmTaskTsValue task : tasks) {
						if (task.getTaskStaffId().equals("000")) {
							task.setState(6);
							task.setLabel("停售处理");
							vmTaskSV.saveVmTaskTs(task);
						}
					}
				} */
			}
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", rcode[1]);
		} catch (Exception e) {
			// 操作失败
			log.error("提交出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "提交失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void checkIsDispacher(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String taskId = request.getParameter("taskId");

		IVmTaskSV vmTaskSV = (IVmTaskSV) ServiceFactory
				.getService(IVmTaskSV.class);

		try {
			if ("".equals(taskId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				// 提交前任务
				IBOVmTaskTsValue curTask = vmTaskSV.getVmTaskTsByTaskId(taskId);
				if (curTask.getLabel().equals("分派停售任务")) {
					cp.set("FLAG", "Y");
				} else {
					cp.set("FLAG", "N");
				}
			}
		} catch (Exception e) {
			// 操作失败
			log.error("提交出错", e);
			cp.set("FLAG", "N");
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
