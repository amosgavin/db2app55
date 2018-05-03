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
 * author:zxh ����˵�����������ӿڷ�װ���ṩ���������������ύ����
 ******************************************************************************/

public class ClientAgentById {

	/***************************************************************************
	 * ����˵������������ʵ�� 
	 * ����˵���� flowCode ģ�����
	 *  staffId ����Ա
	 *  ID objectTypeId �������ͣ���"salecase"��ʾӪ������룩
	 *  objectId ����ID 
	 *  result ���̽�����ڴ�������ʱ����Ҫ�����ֱ�Ӵ���ֵ���ɣ�
	 * startTime ����ʱ�� notes ���̱�ע
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
	 * ����˵��:ָ����ǩ ����˵���� role Ա����ɫID staffId ����ԱID objectTypeId
	 * �������ͣ���"salecase"��ʾӪ������룩 objectId ����ID result ���̽�����Ƿ�ͬ����߻�ǩ�ȣ� comment ��ע
	 * reason ˵��
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
	 * ����˵��:�ύ ����˵���� 
	 * role Ա����ɫID 
	 * staffId ����ԱID 
	 * objectTypeId �������ͣ���"salecase"��ʾӪ������룩
	 * objectId ����ID 
	 * result ���̽�����Ƿ�ͬ����߻�ǩ�ȣ� 
	 * comment ��ע
	 * reason ˵��
	 * staffNext ��һ������ԱID
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
	 * ����˵��:�ύ ����˵���� 
	 * role Ա����ɫID 
	 * staffId ����ԱID 
	 * objectTypeId �������ͣ���"salecase"��ʾӪ������룩
	 * objectId ����ID 
	 * staffNext ��һ��������ID
	 * result ���̽�����Ƿ�ͬ����߻�ǩ�ȣ� 
	 * comment ��ע
	 * reason ˵��
	 * staffNext ��һ������ԱID
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
            //������Ӫ������ʡ��˾ָ��������
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
	 * ����˵��:����ύ����ָ����ǩ����ָ�������� ����˵����
	 * role Ա����ɫID 
	 * staffId ����ԱID 
	 * objectTypeId �������ͣ���"salecase"��ʾӪ������룩 
	 * objectId ����ID 
	 * result ���̽�����Ƿ�ͬ����߻�ǩ�ȣ� 
	 * comment ��ע
	 * reason ˵�� staffstrָ���Ļ�ǩ�˻��ߴ�����
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
	 * ����˵��:��ǩ ����˵���� role Ա����ɫID staffId ����ԱID objectTypeId
	 * �������ͣ���"salecase"��ʾӪ������룩 objectId ����ID result ���̽�����Ƿ�ͬ����߻�ǩ�ȣ� comment ��ע
	 * reason ˵��
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
            //ȡ�ϼ�����ķ�����id
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
	 * ����˵��:����objectTypeId��objectId��ȡ��ǰ���������� ����˵���� role Ա����ɫID staffId ����ԱID
	 * objectTypeId �������ͣ���"salecase"��ʾӪ������룩 objectId ����ID result
	 * ���̽�����Ƿ�ͬ����߻�ǩ�ȣ� comment ��ע reason ˵��
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
	 * ����˵��:��ȡ��һ������ ����˵���� role Ա����ɫID staffId ����ԱID objectTypeId
	 * �������ͣ���"salecase"��ʾӪ������룩 objectId ����ID result ���̽�����Ƿ�ͬ����߻�ǩ�ȣ� comment ��ע
	 * reason ˵��
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
	 * ����˵��:���ݽ�ɫ�͹������ͻ�ȡ���е�ǰ����ʵ���͹���״̬ objectTypeId �������� reason ˵��
	 **************************************************************************/
	public static Map getCurrentRecord(String role, String objectTypeId) {
		return new HashMap();

	}

	/***************************************************************************
	 * ����˵��:���ݹ���״̬����ɫ�͸�λ��ѯ���д��칤�� roleId ��λID staffId Ա����� reason ˵��
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
	 * ����˵��:��������tag��ѯ��ǰ������칤�� taskTag �����ǩ objectType �������� reason ˵��
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
	 * ����˵��:��������Id���˵�ǰ���� taskId ����Id reason ����ԭ�� avars ���̲���
	 **************************************************************************/
	public static boolean backTask(String taskId, String staffId,
			String reason, HashMap aVars) throws Exception, RuntimeException {
		boolean rs = false;
		TaskInfo bakTask = new TaskInfo();// ��Ҫ���ص�����ڵ�
		TaskInfo curTask = ComframeClient.getTaskInfo(taskId);

		// ��ȡ��ǰ����ĵ�һ���¼��˹����񣬲��ж������Ƿ��Ѿ����
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
	 * �˹���������Ȩ����
	 * 
	 * @param taskId
	 *            long ������
	 * @param authorizeStaffId
	 *            long ����Ȩ���ڵ���Ա
	 * @param staffId
	 *            long ��Ȩ�������ִ����
	 * @return long ת�ɺ������id
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