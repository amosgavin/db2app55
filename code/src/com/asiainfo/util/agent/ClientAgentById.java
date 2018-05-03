package com.asiainfo.util.agent;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.complex.center.CenterInfo;
import com.ai.comframe.client.ComframeClient;
import com.ai.comframe.client.TaskInfo;
import com.ai.comframe.client.WorkflowInfo;
import com.ai.comframe.vm.common.Constant;
import com.ai.comframe.client.TaskInfo;
import com.ai.comframe.utils.DataSourceUtil;

/*******************************************************************************
 * author:zxh 功能说明：工作流接口封装，提供了启动工作流和提交功能
 ******************************************************************************/

public class ClientAgentById {

	/***************************************************************************
	 * 功能说明：创建流程实例 
	 * 参数说明： flowCode 模板代码
	 *  staffId 操作员
	 *  ID objectTypeId 工单类型（如"salecase"表示营销活动申请）
	 *  objectId 工单ID 
	 *  result 流程结果（在创建流程时不需要结果，直接传空值即可）
	 * startTime 创建时间 notes 流程备注
	 **************************************************************************/
	public static boolean createWorkflow(String flowCode, String staffId,
			String objectTypeId, String objectId, String result, String notes,
			String orgId) {
		boolean rs = true;
		System.setProperty(Constant.S_COMFRAME_DEV_NAME, "CM");
		HashMap<String, String> aVars = new HashMap<String, String>();
		String vorgId = orgId.substring(0, 2);
		aVars.put("result", result);
		try {
			CenterFactory.setDirectCenterInfo(new CenterInfo("0", vorgId));
			ComframeClient.createWorkflow(flowCode, staffId, objectTypeId,
					objectId, aVars, null, notes);
			CenterFactory.setCenterInfoEmpty();

		} catch (Exception e) {
			e.printStackTrace();
			rs = false;
			return rs;
		}
		return rs;
	}

	/***************************************************************************
	 * 功能说明:指定会签 参数说明： role 员工角色ID staffId 操作员ID objectTypeId
	 * 工单类型（如"salecase"表示营销活动申请） objectId 工单ID result 流程结果（是否同意或者会签等） comment 备注
	 * reason 说明
	 **************************************************************************/
	public static boolean assignReason(String staffId,String taskId,String staffStr,String result,String reason) {
		TaskInfo currentTask = new TaskInfo();
		boolean rs = true;

		HashMap<String, String> aVars = new HashMap<String, String>();
		aVars.put("staff", staffStr);
		aVars.put("result", result);

		try {
			rs = ComframeClient.finishUserTask(taskId, staffId, null,reason, aVars);
		} catch (Exception xe) {
			xe.printStackTrace();
			rs = false;
			return rs;
		}
		return rs;
	}

	/***************************************************************************
	 * 功能说明:提交 参数说明： 
	 * role 员工角色ID 
	 * staffId 操作员ID 
	 * objectTypeId 工单类型（如"salecase"表示营销活动申请）
	 * objectId 工单ID 
	 * result 流程结果（是否同意或者会签等） 
	 * comment 备注
	 * reason 说明
	 * staffNext 下一步操作员ID
	 **************************************************************************/
	public static boolean assignTask(String staffId,String taskId,String comment,String reason, String result) {
		boolean rs = true;
		HashMap<String, String> aVars = new HashMap<String, String>();
		aVars.put("result", result);
		//aVars.put("staff", staffNext);
		try {
			rs = ComframeClient.finishUserTask(taskId, staffId, comment, reason, aVars);
		} catch (Exception xe) {
			xe.printStackTrace();
			rs = false;
			return rs;
		}
		return rs;
	}

	/***************************************************************************
	 * 功能说明:提交 参数说明： 
	 * role 员工角色ID 
	 * staffId 操作员ID 
	 * objectTypeId 工单类型（如"salecase"表示营销活动申请）
	 * objectId 工单ID 
	 * staffNext 下一步操作人ID
	 * result 流程结果（是否同意或者会签等） 
	 * comment 备注
	 * reason 说明
	 * staffNext 下一步操作员ID
	 **************************************************************************/
	public static boolean assignTask(String role, String staffId,
			String objectTypeId, String objectId,String staffNext ,String comment,
			String reason, String result) {
		TaskInfo currentTask = new TaskInfo();
		boolean rs = true;
		HashMap<String, String> aVars = new HashMap<String, String>();
		aVars.put("result", result);
		aVars.put("staff", staffNext);
		try {
			TaskInfo[] task = ComframeClient.getTaskInfosByWorkflowObjectId(
					"HB", objectTypeId, objectId);
			for (int i = 0; i < task.length; i++) {
				if (task[i].getState() == 5) {
					currentTask = task[i];
				}
			}

			String taskId = currentTask.getTaskId();
            //处理市营销案，省公司指定主办人
			if(currentTask.getTaskTag().equals("t06")){
            	aVars.put("staff06", staffNext);
            }
			

			rs = ComframeClient.finishUserTask(taskId, staffId, comment,
					reason, aVars);

		} catch (Exception xe) {
			xe.printStackTrace();
			rs = false;
			return rs;
		}
		return rs;
	}
	
	/***************************************************************************
	 * 功能说明:完成提交或者指定会签或者指定主办人 参数说明：
	 * role 员工角色ID 
	 * staffId 操作员ID 
	 * objectTypeId 工单类型（如"salecase"表示营销活动申请） 
	 * objectId 工单ID 
	 * result 流程结果（是否同意或者会签等） 
	 * comment 备注
	 * reason 说明 staffstr指定的会签人或者代办人
	 **************************************************************************/
	public static boolean assignAnyTask(String role, String staffId,
			String objectTypeId, String objectId, String comment,
			String reason, String result, String staffstr) {
		TaskInfo currentTask = new TaskInfo();
		boolean rs = true;
		HashMap<String, String> aVars = new HashMap<String, String>();
		aVars.put("result", result);
		aVars.put("staff", staffstr);
		try {
			TaskInfo[] task = ComframeClient.getTaskInfosByWorkflowObjectId(
					"HB", objectTypeId, objectId);
			for (int i = 0; i < task.length; i++) {
				if (task[i].getState() == 5) {
					currentTask = task[i];
				}
			}

			String taskId = currentTask.getTaskId();

			rs = ComframeClient.finishUserTask(taskId, staffId, comment,
					reason, aVars);

		} catch (Exception xe) {
			xe.printStackTrace();
			rs = false;
			return rs;
		}
		return rs;
	}

	/***************************************************************************
	 * 功能说明:会签 参数说明： role 员工角色ID staffId 操作员ID objectTypeId
	 * 工单类型（如"salecase"表示营销活动申请） objectId 工单ID result 流程结果（是否同意或者会签等） comment 备注
	 * reason 说明
	 **************************************************************************/
	public static boolean signTask(String role, String staffId,
			String objectTypeId, String objectId, String comment,
			String reason, String result) {
		TaskInfo currentTask = new TaskInfo();
		TaskInfo[] signTask = null;
		String state = "5";
		boolean rs = true;
		HashMap<String, String> aVars = new HashMap<String, String>();
		HashMap<String, String> parameter = new HashMap<String, String>();
		aVars.put("result", result);
		aVars.put("staffId", staffId);
		
		try {
			TaskInfo[] task = ComframeClient.getTaskInfosByWorkflowObjectId(
					"HB", objectTypeId, objectId);
			for (int i = 0; i < task.length; i++) {
				if (task[i].getState() == 5) {
					currentTask = task[i];
				}
			}
            //取上级任务的发起人id
			String lastTaskId = currentTask.getLastTaskId();
			TaskInfo lastTask = ComframeClient.getTaskInfo(lastTaskId);
			
			String condition = "parent_task_id=:parentId" + " "
					+ "and task_staff_id=:taskStaffId and state=:state";
			String parentId = currentTask.getTaskId();
			parameter.put("parentId", parentId);
			parameter.put("taskStaffId", staffId);
			parameter.put("state", state);
			parameter.put("staffId", lastTask.getFinishStaffId());

			signTask = ComframeClient.getTaskInfos("HB", condition, parameter, 0, 1000);
			// if(!currentTask.getStationId().equalsIgnoreCase(role.toString())&&!currentTask.getTasktype().equalsIgnoreCase(sign)){
			// rs = false;
			// return rs;
			// }
			String taskId = signTask[0].getTaskId();
			
			rs = ComframeClient.finishUserTask(taskId, staffId, comment, reason, aVars);
		} catch (Exception xe) {
			xe.printStackTrace();
			rs = false;
			return rs;
		}
		return rs;
	}

	/***************************************************************************
	 * 功能说明:根据objectTypeId和objectId获取当前工作流任务 参数说明： role 员工角色ID staffId 操作员ID
	 * objectTypeId 工单类型（如"salecase"表示营销活动申请） objectId 工单ID result
	 * 流程结果（是否同意或者会签等） comment 备注 reason 说明
	 **************************************************************************/
	public static TaskInfo currentTask(String objectTypeId, String objectId)
			throws Exception {
		TaskInfo currentTask = null;
		TaskInfo[] task = ComframeClient.getTaskInfosByWorkflowObjectId("HB",
				objectTypeId, objectId);
		for (int i = 0; i < task.length; i++) {
			if (task[i].getState() == 5) {
				currentTask = task[i];
			}
		}
		return currentTask;
	}

	/***************************************************************************
	 * 功能说明:获取上一个任务 参数说明： role 员工角色ID staffId 操作员ID objectTypeId
	 * 工单类型（如"salecase"表示营销活动申请） objectId 工单ID result 流程结果（是否同意或者会签等） comment 备注
	 * reason 说明
	 **************************************************************************/
	public static TaskInfo parentTask(String objectTypeId, String objectId)
			throws Exception {
		TaskInfo currentTask = null;
		TaskInfo parentTask = null;
		TaskInfo[] task = ComframeClient.getTaskInfosByWorkflowObjectId("HB",
				objectTypeId, objectId);
		for (int i = 0; i < task.length; i++) {
			if (task[i].getState() == 5) {
				currentTask = task[i];
			}
		}
		String pid = currentTask.getParentTaskId();

		parentTask = ComframeClient.getTaskInfo(pid);
		return parentTask;
	}

	/***************************************************************************
	 * 功能说明:根据角色和工单类型获取所有当前流程实例和工单状态 objectTypeId 工单类型 reason 说明
	 **************************************************************************/
	public static Map getCurrentRecord(String role, String objectTypeId) {
		return new HashMap();

	}

	/***************************************************************************
	 * 功能说明:根据工单状态、角色和岗位查询所有待办工单 roleId 岗位ID staffId 员工编号 reason 说明
	 **************************************************************************/
	public static TaskInfo[] getAllCurTaskByStaff(String roleId,
			String staffId, String curStat) throws Exception, RuntimeException {
		TaskInfo[] taskList;
		HashMap<String, String> parameter = new HashMap<String, String>();
		parameter.put("curStat", curStat);
		parameter.put("roleId", roleId);
		parameter.put("staffId", staffId);
		String condition = "state =:curStat and " + "( "
				+ "task_staff_id=:staffId " + " or station_id=:roleId " + " )";

		taskList = ComframeClient.getTaskInfos("HB", condition, parameter, 0,
				10000);

		return taskList;
	}

	/***************************************************************************
	 * 功能说明:根据任务tag查询当前任务待办工单 taskTag 任务标签 objectType 工单类型 reason 说明
	 **************************************************************************/
	public static ArrayList<String> getAllCurTaskByTag(String taskTag,
			String objectType, String curStat) throws Exception,
			RuntimeException {
		ArrayList<String> objId = new ArrayList();
		TaskInfo[] taskList;
		HashMap<String, String> parameter = new HashMap<String, String>();
		WorkflowInfo workflow = null;

		parameter.put("taskTag", taskTag);
		parameter.put("state", curStat);
		parameter.put("objectType", objectType);
		String conditionTask = "state in('5','10') and " + " task_tag=:taskTag and "
				+ " WORKFLOW_OBJECT_TYPE=:objectType";

		taskList = ComframeClient.getTaskInfos("HB", conditionTask, parameter,
				0, 10000);
		for (int i = 0; i < taskList.length; i++) {
			workflow = ComframeClient.getWorkflowInfo(taskList[i]
					.getWorkflowId());
			if (!objId.contains(workflow.getWorkflowObjectId())) {
				objId.add(workflow.getWorkflowObjectId());
			}
		}
		return objId;
	}

	/***************************************************************************
	 * 功能说明:根据任务Id回退当前工单 taskId 任务Id reason 回退原因 avars 流程参数
	 **************************************************************************/
	public static boolean backTask(String taskId, String staffId,
			String reason, HashMap aVars) throws Exception, RuntimeException {
		boolean rs = false;
		TaskInfo bakTask = new TaskInfo();// 需要返回的任务节点
		TaskInfo curTask = ComframeClient.getTaskInfo(taskId);

		// 获取当前任务的第一个下级人工任务，并判断任务是否已经完成
		HashMap<String, String> parameter = new HashMap<String, String>();
		parameter.put("taskId", taskId);
		String condition = "last_task_id=:taskId";

		TaskInfo childTaskArray[] = ComframeClient.getTaskInfos("HB",
				condition, parameter, 0, 1000);
		TaskInfo childTask = childTaskArray[0];

		while (!childTask.getTasktype().equals("user")) {
			if(!childTask.getTasktype().equals("sign")){
				parameter.put("taskId", childTask.getTaskId());
				childTaskArray = ComframeClient.getTaskInfos("HB", condition,
						parameter, 0, 1000);
				childTask = childTaskArray[0];
			}
		}

		if (childTask.getState() != 5) {

			return rs = false;
		}

		rs = ComframeClient.goBackToTask(childTask.getTaskId(), curTask.getTaskTag(), staffId,	reason, aVars);
		return rs;
	}

	/**
	 * 人工任务再授权处理
	 * 
	 * @param taskId
	 *            long 任务编号
	 * @param authorizeStaffId
	 *            long 再授权给于的人员
	 * @param staffId
	 *            long 授权后的任务执行人
	 * @return long 转派后的任务id
	 * @throws RemoteException
	 * @throws Exception
	 */
	public static String reAuthorizeTask(String taskId,
			String authorizeStaffId, String staffId) throws RemoteException,
			Exception {
		String rs;
		rs = ComframeClient.reAuthorizeTask(taskId, authorizeStaffId, "-1",
				staffId);
		return rs;
	}

}