package com.asiainfo.workflow.util;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.complex.center.CenterInfo;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.comframe.client.ComframeClient;
import com.ai.comframe.client.TaskInfo;
import com.ai.comframe.config.service.interfaces.ITemplateSV;
import com.ai.comframe.vm.common.Constant;
import com.ai.comframe.vm.template.GoToItem;
import com.ai.comframe.vm.template.TaskTemplate;
import com.ai.comframe.vm.template.TaskUserTemplate;
import com.ai.comframe.vm.template.WorkflowTemplate;
import com.asiainfo.costWarn.job.ConnectUtil;
import com.asiainfo.sale.common.service.interfaces.ISendSmsSV;
import com.asiainfo.sale.util.StringUtil;
import com.asiainfo.task.bo.BOVmTaskBean;
import com.asiainfo.task.bo.BOVmTaskEngine;
import com.asiainfo.task.bo.BOVmTaskTsBean;
import com.asiainfo.task.bo.BOVmTaskTsEngine;
import com.asiainfo.task.dao.interfaces.IVmTaskSVDAO;
import com.asiainfo.task.ivalues.IBOVmTaskValue;
import com.asiainfo.workflow.util.bo.BOTaskRouteBean;

public class TaskUtil {
	private static Log log = LogFactory.getLog(TaskUtil.class);
	private static Map m_workflow_templateinfo = new HashMap();

	/**
	 * 根据流程模板名称获取模板中的所有节点对象
	 * 
	 * @param templateCode
	 *            模板名
	 * @return
	 */
	private static TaskTemplate[] getTaskTemplates(String templateCode) {
		TaskTemplate[] taskTemplates = (TaskTemplate[]) m_workflow_templateinfo
				.get(templateCode);
		if (null == taskTemplates) {
			log.debug("m_workflow_templateinfo缓存为空，初始化缓存开始");
			ITemplateSV templateSV = (ITemplateSV) ServiceFactory
					.getService(ITemplateSV.class);

			try {
				WorkflowTemplate wt = templateSV.getWorkflowTemplate(-1,
						templateCode);

				taskTemplates = wt.getTaskTemplates();
				if (taskTemplates.length > 0) {
					m_workflow_templateinfo.put(templateCode, taskTemplates);
					log.debug("m_workflow_templateinfo缓存初始化完成，记录条数："
							+ taskTemplates.length);
				} else {
					log.error("m_workflow_templateinfo缓存初始化失败：数据集为空");
				}
			} catch (RemoteException e) {
				log.error("获取流程模板失败：templateCode = " + templateCode);
				e.printStackTrace();
			} catch (Exception e) {
				log.error("获取流程模板失败：templateCode = " + templateCode);
				e.printStackTrace();
			}
		}
		return taskTemplates;
	}

	/**
	 * 根据节点ID获取节点信息
	 * 
	 * @param taskId
	 *            节点ID
	 * @param taskTemplates
	 *            节点对象组
	 * @return
	 */
	private static TaskTemplate getTaskTemplate(long taskId,
			TaskTemplate[] taskTemplates) {
		if (null != taskTemplates && 0 < taskTemplates.length) {
			for (int i = 0; i < taskTemplates.length; i++) {
				if (taskId == taskTemplates[i].getTaskTemplateId()) {
					return taskTemplates[i];
				}
			}
		}
		return null;
	}

	/**
	 * 根据当前节点获取当前节点出口相关信息
	 * 
	 * @param thisTaskTemplate
	 *            当前节点
	 * @param taskTemplates
	 *            节点数组
	 * @return
	 */
	private static BOTaskRouteBean[] getTaskConditionInfo(
			TaskTemplate thisTaskTemplate, TaskTemplate[] taskTemplates) {
		List goToItems = thisTaskTemplate.getGoToItems();//下一节点
		String condition = "";
		long taskId = 0;
		String lable = "";
		String organizeid = "";
		String userId = "";
		String userType = "";
		String taskType = "";
		String thisTaskType = thisTaskTemplate.getTaskType();
		BOTaskRouteBean taskRouteBean = null;
		TaskTemplate nextTemplate = null;
		String messageType = "";
		String nextTaskTag = "";

		BOTaskRouteBean[] taskRouteBeans = new BOTaskRouteBean[goToItems.size()];
		int i = 0;
		for (Object goToItem : goToItems) {//遍历下一节点
			try {
				taskRouteBean = new BOTaskRouteBean();
				taskId = ((GoToItem) goToItem).getNextTaskTemplateId();
				taskRouteBean.setTaskid(taskId);
				nextTemplate = getTaskTemplate(taskId, taskTemplates);//下一节点对象
				taskType = nextTemplate.getTaskType();
				taskRouteBean.setTasktype(taskType);
				condition = taskType + "~"
						+ ((GoToItem) goToItem).getCondition();
				lable = nextTemplate.getDescription();
				if (null == lable || "".equals(lable)) {
					lable = nextTemplate.getLabel();
				}

				messageType = nextTemplate.getLabel();
				String[] messageTypeTmp = null;
				if (null != messageType && messageType.indexOf("~") > 1) {
					messageTypeTmp = messageType.split("~");
					messageType = messageTypeTmp[1];
				}

				taskRouteBean.setLable(lable);
				if (nextTemplate instanceof TaskUserTemplate) {
					userType = ((TaskUserTemplate) nextTemplate)
							.getTaskUserType();
					taskRouteBean.setUsertype(userType);
					organizeid = ((TaskUserTemplate) nextTemplate)
							.getOrganizeId();
					if (!"user".equals(taskType)) {
						organizeid = "-1";
					}
					userId = ((TaskUserTemplate) nextTemplate).getTaskUserId();
					taskRouteBean.setUserid(userId);
				}
				nextTaskTag = nextTemplate.getTaskTag();
				taskRouteBean.setCondition(condition + "~" + userType + "~"
						+ organizeid + "~" + userId + "~" + messageType + "~"
						+ thisTaskType + "~" + nextTaskTag);

				taskRouteBeans[i] = taskRouteBean;
				i++;
			} catch (AIException e) {
				log.error("创建BOTaskRouteBean异常;" + e);
				e.printStackTrace();
			}
		}
		return taskRouteBeans;
	}

	/**
	 * 根据模板名、节点ID获取出口相关信息
	 * 
	 * @param templateCode
	 *            模板名
	 * @param taskId
	 *            节点ID
	 * @return
	 */
	public static BOTaskRouteBean[] getRoute4TaskTemplate(String templateCode,
			long taskId) {
		log.debug("获取节点出口1:" + templateCode + "~" + taskId);
		if ("-1".equals(templateCode) || -1 == taskId) {
			return null;
		}
		TaskTemplate[] taskTemplates = getTaskTemplates(templateCode);//根据流程模板名称获取模板中的所有节点对象
		TaskTemplate thisTaskTemplate = null;
		BOTaskRouteBean[] taskRouteBeans = null;
		log.debug("获取节点出口2:taskTemplates.length===" + taskTemplates.length);
		if (null != taskTemplates && 0 < taskTemplates.length) {
			thisTaskTemplate = getTaskTemplate(taskId, taskTemplates);//根据节点ID,从所有节点中获取节点信息
			BOTaskRouteBean[] taskRoute = getTaskConditionInfo(
					thisTaskTemplate, taskTemplates);//根据当前节点获取当前节点出口相关信息
			if (taskRoute.length == 1) {
				log.debug("获取节点出口3:taskRoute[0].getTasktype()==="
						+ taskRoute[0].getTasktype());
				if (!"user".equals(taskRoute[0].getTasktype())
						&& !"sign".equals(taskRoute[0].getTasktype())
						&& !"finish".equals(taskRoute[0].getTasktype())) {
					taskRoute = getTaskConditionInfo(getTaskTemplate(
							taskRoute[0].getTaskid(), taskTemplates),
							taskTemplates);
					log.debug("获取节点出口4:taskRoute===" + taskRoute);
				}
			}
			log.debug("获取节点出口5:taskRoute.length===" + taskRoute.length);
			taskRouteBeans = new BOTaskRouteBean[taskRoute.length];
			int i = 0;
			for (BOTaskRouteBean taskRouteBean : taskRoute) {
				log.debug("节点出口:" + taskRouteBean.getCondition() + "~"
						+ taskRouteBean.getTaskid() + "~"
						+ taskRouteBean.getLable() + "~"
						+ taskRouteBean.getTasktype());
				taskRouteBeans[i] = taskRouteBean;
				i++;
			}
			for (int j = 0; j < taskRouteBeans.length; j++) {
				String conditionTmp = taskRouteBeans[j].getCondition();
				String[] condition = conditionTmp.split("~");
				String defaultCondition = condition[1];
				if (defaultCondition.equalsIgnoreCase("default")) {
					log.debug("获取节点出口tmp:defaultCondition==="
							+ defaultCondition);
					BOTaskRouteBean taskRouteBeanTmp = null;
					taskRouteBeanTmp = taskRouteBeans[0];
					taskRouteBeans[0] = taskRouteBeans[j];
					taskRouteBeans[j] = taskRouteBeanTmp;
				}
			}
			log.debug("获取节点出口:taskRouteBeans[0]==="
					+ taskRouteBeans[0].getCondition());
		}
		return taskRouteBeans;
	}

	public static String getStaffIdByTaskId(String taskId) {
		TaskInfo taskInfo = null;
		try {
			taskInfo = ComframeClient.getTaskInfo(taskId);
			return taskInfo.getTaskStaffId();
		} catch (RemoteException e) {
			log.error("根据taskId获取节点处理人编号异常;" + e);
			e.printStackTrace();
		} catch (Exception e) {
			log.error("根据taskId获取节点处理人编号异常;" + e);
			e.printStackTrace();
		}
		return null;
	}

	public static String getThisStaffId(String staffId) {
		return staffId;
	}

	public static String[] createWorkflow(String flowCode, String staffId,
			String objectTypeId, String objectId, String result, String notes) {
		String thisStaffId = Long.toString(SessionManager.getUser().getID());
		String orgId = Long.toString(SessionManager.getUser().getOrgId());

		boolean rs = true;
		System.setProperty(Constant.S_COMFRAME_DEV_NAME, "CM");
		HashMap<String, String> aVars = new HashMap<String, String>();
		String vorgId = orgId.substring(0, 2);

		aVars.put("result", result);
		aVars.put("staff", staffId);
		aVars.put("staff01", thisStaffId);
		if (flowCode.equals("template.UniteChargeFlow")) {
			aVars.put("staff02", "20004937");
			// aVars.put("staff03", "20005256");
		}
		try {
			log.debug("创建工作流begin:" + flowCode + "|" + thisStaffId + "|"
					+ objectTypeId + "|" + objectId + "|" + notes);
			CenterFactory.setDirectCenterInfo(new CenterInfo("0", vorgId));
			ComframeClient.createWorkflow(flowCode, thisStaffId, objectTypeId,
					objectId, aVars, null, notes);
			CenterFactory.setCenterInfoEmpty();
			log.debug("创建工作流end:" + flowCode + "|" + thisStaffId + "|"
					+ objectTypeId + "|" + objectId + "|" + notes);
		} catch (Exception e) {
			log.error("创建工作流异常:" + flowCode + "|" + thisStaffId + "|"
					+ objectTypeId + "|" + objectId + "|" + notes + ";" + e);
			e.printStackTrace();
			rs = false;
		}

		if (rs) {
			ISendSmsSV iSendSmsSV = (ISendSmsSV) ServiceFactory
					.getService(ISendSmsSV.class);
			try {
				iSendSmsSV.sendSms(flowCode, objectId, thisStaffId, staffId);
			} catch (RuntimeException e) {
				e.printStackTrace();
				return new String[] { "0000", "提交审核成功" };
			} catch (Exception e) {
				e.printStackTrace();
				return new String[] { "0000", "提交审核成功" };
			}
			return new String[] { "0000", "提交审核成功" };
		} else {
			return new String[] { "1000", "提交审核失败" };
		}
	}

	public static String[] finishUserTask(String taskId, String result,
			String curStaff, String nextStepStaff, String comment,
			String reason, String auditFlag) throws RuntimeException, Exception {
		HashMap<String, String> aVars = new HashMap<String, String>();
		aVars.put("result", result);
		if (!"".equals(nextStepStaff)) {
			aVars.put("staff", nextStepStaff);
		}
		String thisStaffId = "";
		/**
		 * 获得当前员工ID
		 */
		if (curStaff != null && !curStaff.equals("")) {
			thisStaffId = curStaff;
		} else {
			if (SessionManager.getUser() != null) {
				thisStaffId =Long.toString(SessionManager.getUser().getID());
			} else {
				IVmTaskSVDAO vmDao = (IVmTaskSVDAO) ServiceFactory
				.getService(IVmTaskSVDAO.class);
				thisStaffId = vmDao.getVmTaskByTaskId(taskId).getTaskStaffId();//根据TASK_ID从HBSALE.VM_TASK获得TASK_STAFF_ID
			}
		}
		boolean rs = false;

		try {
			log.debug("提交工作流begin:" + taskId + "|" + result + "|"
					+ nextStepStaff + "|" + comment + "|" + reason);
			rs = ComframeClient.finishUserTask(taskId, thisStaffId, comment,
					reason, aVars);
			log.debug("提交工作流end:" + rs + ":" + taskId + "|" + result + "|"
					+ nextStepStaff + "|" + comment + "|" + reason);
		} catch (RemoteException e) {
			log.error("提交工作流异常:" + taskId + "|" + result + "|" + nextStepStaff
					+ "|" + comment + "|" + reason + ";" + e);
			e.printStackTrace();
		} catch (Exception e) {
			log.error("提交工作流异常:" + taskId + "|" + result + "|" + nextStepStaff
					+ "|" + comment + "|" + reason + ";" + e);
			e.printStackTrace();
		}

		if (rs) {

			ISendSmsSV iSendSmsSV = (ISendSmsSV) ServiceFactory
					.getService(ISendSmsSV.class);
			try {
				if (StringUtil.isNotBlank(auditFlag)) {
					BOVmTaskBean vmTask = BOVmTaskEngine.getBean(taskId);
					if (vmTask != null
							&& StringUtil.isNotBlank(vmTask.getWorkflowId())) {
						vmTask.setDecisionResult(auditFlag);
						BOVmTaskEngine.save(vmTask);
					} else {
						BOVmTaskTsBean vmTaskTs = BOVmTaskTsEngine
								.getBean(taskId);
						vmTaskTs.setDecisionResult(auditFlag);
						BOVmTaskTsEngine.save(vmTaskTs);
					}
				}
				iSendSmsSV.sendSms(taskId, thisStaffId, nextStepStaff);
			} catch (RuntimeException e) {
				e.printStackTrace();
				return new String[] { "0000", "提交成功" };
			} catch (Exception e) {
				e.printStackTrace();
				return new String[] { "0000", "提交成功" };
			}
			return new String[] { "0000", "提交成功" };
		} else {
			return new String[] { "1000", "提交失败" };
		}
	}

	public static boolean terminateWorkflow(String object_id,
			String object_type, String staffId, String reason)
			throws RemoteException, Exception {
		String thisStaffId = Long.toString(SessionManager.getUser().getID());
		boolean rs = false;
		TaskInfo[] task = ComframeClient.getTaskInfosByWorkflowObjectId("HB",
				object_type, object_id);
		String workflow_id = "";
		if (task.length > 0) {
			workflow_id = task[0].getWorkflowId();
		}
		for (int i = 0; i < task.length; i++) {
			if (task[i].getTasktype().equals("user") && task[i].getState() == 3) {
				log.debug("该工单已被审批，无法回退！");
				return rs;
			}
		}
		try {
			log.debug("终止工作流begin:" + object_id + "|" + staffId + "|" + reason);
			// ComframeClient.terminateWorkflow(workflow_id, thisStaffId,
			// reason);
			ComframeClient.dropWorkflow(workflow_id);
			rs = true;
			return rs;
		} catch (RemoteException e) {
			log.error("终止工作流异常:" + workflow_id + "|" + staffId + reason + ";"
					+ e);
			e.printStackTrace();
			return rs;
		} catch (Exception e) {
			log.error("终止工作流异常:" + workflow_id + "|" + staffId + reason + ";"
					+ e);
			e.printStackTrace();
			return rs;
		}
	}

	public static Map<String, String> getCurWpTaskBySaleOrderId(String orderId)
			throws Exception {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Map<String, String> wpIdTaskIdMap = new HashMap<String, String>();
		try {
			conn = ConnectUtil.getConnection();
			String querySql = "SELECT wp.id wp_id, vm.task_id task_id "
					+ " FROM HBSALE.SALE_WEAPON_T wp, "
					+ " (SELECT workflow_object_id, task_id "
					+ " FROM hbsale.vm_wf wf, hbsale.vm_task task "
					+ " WHERE wf.WORKFLOW_ID = task.WORKFLOW_ID "
					+ " AND task.task_tag IN ('w01', 'w02') "
					+ " AND task.STATE = 5) vm "
					+ " WHERE wp.ID IN (SELECT weapon_id "
					+ " FROM hbsale.sale_detail_t "
					+ " WHERE sale_id IN (SELECT ID "
					+ " FROM hbsale.sale_main_t  WHERE order_id = " + orderId
					+ " )) AND STATE = 'C' "
					+ " AND wp.MID = vm.WORKFLOW_OBJECT_ID ";
			st = conn.createStatement();
			rs = st.executeQuery(querySql);
			while (rs.next()) {
				wpIdTaskIdMap.put(rs.getString("wp_id"), rs
						.getString("task_id"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return wpIdTaskIdMap;
	}

	public static String[] getDefaultPsByRoleAndOrg(String roleId, String orgId)
			throws Exception {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		// [0] operatorIds, [1] staffNames
		String[] opStaff = { "", "" };
		try {
			conn = ConnectUtil.getConnection();
			String querySql = "SELECT opt.operator_id op_id, staff_name "
					+ " FROM sechb.sec_op_station opt, sechb.sec_operator op, sechb.sec_staff st "
					+ " WHERE op_station_id IN (SELECT op_station_id "
					+ " FROM sechb.sec_author " + "  WHERE ROLE_ID = " + roleId
					+ " AND state = 1) " + " AND opt.STATE = 1 "
					+ " AND op.state = 1 " + " AND st.STATE = 1 "
					+ " AND op.STAFF_ID = st.STAFF_ID "
					+ " AND opt.OPERATOR_ID = op.OPERATOR_ID ";
			if (orgId.length() == 4) {
				querySql += " AND substr (st.ORGANIZE_ID, 1, 4) =  " + orgId;
			} else {
				querySql += " AND substr (st.ORGANIZE_ID, 1, 2) =  " + orgId;
			}
			st = conn.createStatement();
			rs = st.executeQuery(querySql);
			while (rs.next()) {
				if (!opStaff[0].equals("")) {
					opStaff[0] += ";";
					opStaff[1] += ";";
				}
				opStaff[0] += rs.getString("op_id");
				opStaff[1] += rs.getString("staff_name");
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return opStaff;
	}

	public static String getSignResult(String taskId) throws Exception {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		int noGreenCn = 0;
		try {
			conn = ConnectUtil.getConnection();
			String querySql = "SELECT count(*) cn FROM hbsale.vm_task_ts WHERE parent_task_id IN (SELECT parent_task_id FROM hbsale.vm_task_ts WHERE task_id = '"
					+ taskId + "') AND decision_result = 'no'";
			st = conn.createStatement();
			rs = st.executeQuery(querySql);
			if (rs.next()) {
				noGreenCn = rs.getInt("cn");
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return noGreenCn > 0 ? "no" : "default";
	}
}
