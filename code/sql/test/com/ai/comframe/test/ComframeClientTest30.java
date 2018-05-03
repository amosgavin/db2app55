package com.ai.comframe.test;

import java.util.HashMap;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.ai.comframe.client.ComframeClient;
import com.ai.comframe.client.TaskInfo;
import com.ai.comframe.client.WorkflowInfo;
import com.ai.comframe.config.ivalues.IBOVmAlarmConfigValue;

public class ComframeClientTest30 extends TestCase{
	
	public static ComframeClient apiClient = null;
	public static String queueID = "test";
	public static String workflowid="test^111^0000000000000128";
	public static String h_workflowid="test^111^0000000000000055";
	public static String taskID = "test^111^0000000000000290";
	public static String goBackTaskID = "";
	public static String staffID = "1";
	public static String flowCode="template.TestTemplate";
	public static String taskTag = "user";
	public static String errorCode = "1";
	public static long stations[] = {1,2};
	public static long templateId = 21;
	public static String objectTypeId = "test";
	public static String errorMessage = "unittest";
	public static String objectId = "2";
	public static long parentID = 44;
	public static String processName = "template.tProcess";
	public static HashMap parameters = null;
	public static String condition = " 1 = 1 ";
	public static String acctPeriod="201111";
	public static void main(String[] args) throws Exception {
//		testCanExecuteTask();
		
		/**测试 历史流程实例查询 **/
		//查询所有流程实例
//		String[] ids = ComframeClient.getWorkflowsByWorkflowObjectId("test", "test", "2");
//		System.out.println("查询所有流程实例:"+ids.length);
		//历史流程实例,两种情况,comframe.ini配置 true,false,配合配置文件里的分表设置
//		String[] h_ids = ComframeClient.getWorkflowsHisByWorkflowObjectId("test", "test", "2");
//		System.out.println("查询所有历史流程实例:"+h_ids.length);
		/**测试 流程实例查询 **/
		//查询所有流程实例数量		
		HashMap aVars = new HashMap();
		aVars.put("qid", "test");
//		int cnt =ComframeClient.getWorkflowCount("test", "QUEUE_ID=:qid", aVars);
//		System.out.println("查询所有历史流程实例数量:"+cnt);
		//查询所有流程历史实例数量
//		int cnt_h =ComframeClient.getWorkflowHisCount("test", "QUEUE_ID=:qid", aVars);
//		System.out.println("查询所有历史流程实例数量:"+cnt_h);
		//根据条件查询所有流程实例数量  --BUG
		int cnt_c =ComframeClient.getWorkflowHisCount("test","201111","1=1",aVars);
		System.out.println("查询所有历史流程实例数量:"+cnt_c);
		
		/**测试 任务实例查询 **/  
		//---bug 无法用queueID参数查询
		int task_cnt = ComframeClient.getTaskCount("test", "QUEUE_ID=:qid", aVars);		
		System.out.println("查询所有任务实例数量:"+task_cnt);
		//---bug 无法用queueID参数查询
		int task_cnth = ComframeClient.getTaskHisCount("test", "QUEUE_ID=:qid", aVars);
		System.out.println("查询所有任务实例数量:"+task_cnth);

	}

	
	/**
	 * 检测某一个人员或者一批岗位是否具有执行指定任务的权限
	 * 
	 * @param taskId long
	 * @param stations long[]
	 * @param staffId long
	 * @return boolean
	 * @throws RemoteException
	 * @throws Exception
	 */
	public static void testCanExecuteTask() throws Exception {
//		boolean rtn = ComframeClient.finishUserTask("test^111^0000000000000299","123", null,null, null);
//		System.out.println("回单情况！结果="+rtn);
//		boolean rtn = ComframeClient.canExecuteTask("test^111^0000000000000304", new long[]{2},"2");
		boolean rtn = ComframeClient.canExecuteTask("test^111^0000000000000304", new long[]{2,0,1,22},"2");
//		Assert.assertEquals(false, rtn);
	}
	
	
	/**
	 *    new API test
	 */
	
	/**
	   * 根据变量、条件查询对应的工作流任务信息
	   * @param condition
	   * @param parameter
	   * @param instVars
	   * @param startIndex
	   * @param endIndex
	   * @return
	   * @throws RemoteException
	   * @throws Exception
	   */
	public static void testGetTaskInfosByAttr2()throws Exception{
		TaskInfo[] result = ComframeClient.getTaskInfosByAttr(queueID,condition,null,null,null,-1,-1);
		System.out.println("查询对应的工作流任务信息成功！reuslt="+result);
	}
	
    /**
     * 指定账期按照条件查询历史任务实例数量
     * @param queueID 队列标识
     * @param acctPeriod 账期标识(格式:yyyyMM,例201105)
     * @param condition 查询条件
     * @param parameter 查询条件中的参数
     * @return
     * @throws RemoteException
     * @throws Exception
     */
	public static void testGetTaskHisCount() throws Exception{
		int task_cnt3 = ComframeClient.getTaskHisCount("test", "201110", condition,null);
		System.out.println("指定账期按照条件查询历史任务实例数量:"+task_cnt3);
		
	}
	
	/**
	 * 根据taskId查询工作任务信息
	 * 
	 * @param TaskId
	 *          任务编号
	 * @return 任务对象
	 * @throws RemoteException
	 * @throws Exception
	 */
	public static void testGetTaskInfoHis() throws Exception{
		TaskInfo ret = ComframeClient.getTaskInfoHis(taskID);
		System.out.println("getTaskInfoHis(taskID)调用结束，结果为："+ret);
	}
	/**
	 * 根据taskId和账期 查询工作任务信息
	 * 
	 * @param TaskId 任务编号
	 * @param  acctPeriod  账期  
	 * @return 任务对象
	 * @throws RemoteException
	 * @throws Exception
	 */
	public static void testGetTaskInfoHis2() throws Exception{
		TaskInfo ret = ComframeClient.getTaskInfoHis(taskID, acctPeriod);
		System.out.println("getTaskInfoHis(taskID, acctPeriod)调用结束，结果为："+ret);
	}
	/**
	 *  查询工作任务信息
	 * 
	 * @param queueID 队列
	 * @param  acctPeriod  账期  
	 * @param  condition 条件
	 * @param  parameter 查询条件中的参数
	 * @param startIndex   int -1时忽略此参数
	 * @param endIndex   int -1时忽略此参数
	 * @return 任务对象
	 * @throws RemoteException
	 * @throws Exception
	 */
	public static void testGetTaskInfosHis2() throws Exception{
		TaskInfo[] ret = ComframeClient.getTaskInfosHis(queueID, acctPeriod, condition, null, -1, -1);
		System.out.println("getTaskInfosHis调用结束，结果为："+ret);
	}
	
	public static void testGetTaskInfo() throws Exception{
		TaskInfo ret = ComframeClient.getTaskInfo(taskID);
		System.out.println("getTaskInfo(taskID)调用结束，结果为："+ret);
	}
	
	public static void testGetTaskInfosByWorkflowId() throws Exception{
		TaskInfo[] ret = ComframeClient.getTaskInfosByWorkflowId(workflowid);
		System.out.println("getTaskInfosByWorkflowId(workflowId)调用结束，结果为："+ret);
	}
	
	public static void testGetTaskInfosHisByWorkflowId() throws Exception{
		TaskInfo[] ret=	ComframeClient.getTaskInfosHisByWorkflowId(workflowid);
		System.out.println("getTaskInfosHisByWorkflowId(workflowId)调用结束，结果为："+ret);
	}
	public static void testGetTaskInfosHisByWorkflowId2() throws Exception{
		TaskInfo[] ret= ComframeClient.getTaskInfosHisByWorkflowId(workflowid, acctPeriod);
		System.out.println("getTaskInfosHisByWorkflowId(workflowId)调用结束，结果为："+ret);
	}
	public static void testGetTaskInfosHisByWorkflowObjectId() throws Exception{
		TaskInfo[] ret= ComframeClient.getTaskInfosHisByWorkflowObjectId(queueID, acctPeriod, objectTypeId, objectId);
		System.out.println("getTaskInfosHisByWorkflowObjectId(queueID, acctPeriod, objectTypeId, objectId)调用结束，结果为："+ret);
	}
	
	/**流程实例  */
	
	/**
	   * 根据业务对象类型和业务对象编码获取所有关联的流程实例编号
	   * @param queueID 队列ID
	   * @param objectTypeId String 业务对象类型编码
	   * @param objectId String 业务对象编码
	   * @return long[] 流程实例编码数组
	   * @throws RemoteException
	   * @throws Exception
	 */
	public static void testGetWorkflowsByWorkflowObjectId() throws Exception{
		String[] ids = ComframeClient.getWorkflowsByWorkflowObjectId("test", "test", "2");
		System.out.println("查询获取所有关联的流程实例编号:"+ids);
	}
	public static void testGetWorkflowHisInfos() throws Exception{
		WorkflowInfo[] wf =ComframeClient.getWorkflowHisInfos(queueID,acctPeriod, condition,null, -1, -1);
		System.out.println("getWorkflowHisInfos查询结果:"+wf);
	}
	public static void testGetWorkflowInfo() throws Exception{
		WorkflowInfo wf2 = ComframeClient.getWorkflowInfo(workflowid);
		System.out.println("getWorkflowInfo查询结果:"+wf2);
	}
	
	public static void testGetWorkflowInfosHis() throws Exception{
		WorkflowInfo[] wf3 = ComframeClient.getWorkflowInfosHis(queueID, acctPeriod,condition, null, -1, -1);
		System.out.println("getWorkflowInfosHis查询结果:"+wf3);
	}
	public static void testGetWorkflowsHisByWorkflowObjectId() throws Exception{
		String[] ids2 = ComframeClient.getWorkflowsHisByWorkflowObjectId(queueID, objectTypeId, objectId);
		System.out.println("getWorkflowsHisByWorkflowObjectId查询结果:"+ids2);
	}
	public static void testGetWorkflowsHisByWorkflowObjectId2() throws Exception{	
		String[] ids3 = ComframeClient.getWorkflowsHisByWorkflowObjectId(queueID, acctPeriod, objectTypeId, objectId);
		System.out.println("getWorkflowsHisByWorkflowObjectId查询结果:"+ids3);
	}
	public static void testGetWorkflowInfoHis()	 throws Exception{
		WorkflowInfo wf4 = ComframeClient.getWorkflowInfoHis(h_workflowid);
		System.out.println("getWorkflowInfoHis查询结果:"+wf4);
	}
	public static void testGetWorkflowInfoHis2()	throws Exception{
		WorkflowInfo wf5 = ComframeClient.getWorkflowInfoHis(h_workflowid, acctPeriod);
		System.out.println("getWorkflowInfoHis查询结果:"+wf5);
	}

	public static void testGetAlarmConfig() throws Exception{
		IBOVmAlarmConfigValue[] aa = ComframeClient.getAlarmConfig(taskTag,"template.TestTemplate");
		System.out.println("getAlarmConfig查询结果:"+aa.length);
	}

	public static void testGetAlarmConfigs() throws Exception{
		IBOVmAlarmConfigValue[] bb = ComframeClient.getAlarmConfigs("template.TestTemplate");
		System.out.println("getAlarmConfigs查询结果:"+bb);
	}
	
	public static void testGetChildWorkflowReturnVar() throws Exception{
//		ComframeClient.getChildWorkflowReturnVar("test^mm^00000000000000421", null);
//		System.out.println("11");
	}
	
//	
	public static void testGetExceptionCode() throws Exception{
//		ComframeClient.getExceptionCode(objectTypeId, flowCode, taskTag);	
	}
	
	public static void testGetHolidayList() throws Exception{
		ComframeClient.getHolidayList();	
	}

	public static void testGetRootInfo() throws Exception{
		ComframeClient.getRootInfo("test^^0000000000000000999");
	}

	/**
	 * 模板是否是process类型
	 * 
	 * @param templateCode 流程编码
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
//	public void testIsProcess() throws Exception {
//		boolean rtn = ComframeClient.isProcess(flowCode);
//		Assert.assertEquals(false, rtn);
//	}
	
	
	 /**
	 * 模板是否是workflow类型
	 * 
	 * @param templateCode 流程编码
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
//	public void testIsWorkFlow() throws Exception {
//		boolean rtn = ComframeClient.isWorkflow(flowCode);
//		Assert.assertEquals(true, rtn);
//	}
	
	
	
	  /**
	   * 将一个流程从异常队列中恢复回来
	   * @param workflowId long 流程实例编号
	   * @throws Exception
	   */
//	  public void testresumeExceptionWorkflow() throws Exception{
//		  long workflowId = getWorkflowID();
//	     apiClient.resumeExceptionWorkflow(workflowId);
//	  }



	
	/**
	   * 测试打单
	   * @param taskId long 任务编号
	   * @param staffId long 操作员工
	   * @param aVars Map 需要修改的流程实例变量
	   * @return boolean
	   * @throws RemoteException
	   * @throws Exception
	   */
//	public void testPrintUserTask()throws Exception{ 
//	boolean result = ComframeClient.printUserTask(taskID, staffID,null);
//	System.out.println("打单情况！结果="+result);
//	} 	
//	}
	
	
//	public static void main(String[] args) throws Exception{
//		boolean result = apiClient.printUserTask("test^mm^00000000000000884", "0191",null);
//		System.out.println("打单情况！结果="+result);

//	}
	
	
	
	/**
	   * 测试人工任务回单
	   * @param taskId long 任务编号
	   * @param staffId String 回单员工编号
	   * @param result String 回单结果
	   * @param reason String 回单结果原因
	   * @param aVars Map 需要设置的流程实例变量
	   * @return boolean 回单是否完成
	   * @throws RemoteException
	   * @throws Exception
	   */
//	public void testFinishUserTask()throws Exception{ 
//	boolean result = ComframeClient.finishUserTask(taskID, staffID, null, null,null);
//	System.out.println("回单情况！结果="+result);
//	} 
//	}
	
//	public static void main(String[] args) throws Exception{
//		boolean result = ComframeClient.finishUserTask("test^mm^00000000000000993", "0191", null, null,null);
//		System.out.println("回单情况！结果="+result);
//	}
	
	
	
	
	/**
	 * 对一个人工任务进行再授权处理
	 * 
	 * @param taskId long 任务编号
	 * @param authorizeStaffId long 再授权给于的人员,没有填-1
	 * @param authorizeStationId long 再授权给予的岗位，没有填-1
	 * @param staffId long 再授权执行人
	 * @return long 转派后的任务id
	 * @throws RemoteException
	 * @throws Exception
	 * 
	 * public long reAuthorizeTask(long taskId,String
	 *             authorizeStaffId,String authorizeStationId,String staffId)
	 *             throws RemoteException, Exception
	 */
//	public void testReAuthorizeTask() throws Exception {
//		String result = ComframeClient.reAuthorizeTask(task_id, staffID, "-1", "2");
//		System.out.println("reAuthorizeTask ID = " + result);
//	}

//	public static void main(String[] args) throws Exception{
//	String result = ComframeClient.reAuthorizeTask("test^mm^00000000000000881", "0199", "-1", "0191");
//	System.out.println("reAuthorizeTask ID = " + result);

//}   
	
	/**
	 * 回退到上一个任务
	 * 
	 * @param currentTaskId 当前任务编号
	 * @param vars 流程实例参数
	 * @param staffId 操作的员工id
	 * @param notes 备注信息
	 * @throws Exception
	 * 
	 * public boolean goBackToTask(long currentTaskId,Map vars,String staffId,String notes)
	 * 									throws RemoteException,Exception
	 */
//	public void testGoBackToTask2() throws Exception {
//		boolean rtn = ComframeClient.goBackToTask(goBackTaskID, null, staffID, null);
//		Assert.assertEquals(true, rtn);
//	}

//    public static void main(String[] args) throws Exception{
//    	boolean a = ComframeClient.goBackToTask("test^mm^00000000000000998", null, "0199", null);
//    	System.out.println("回退结果为"+a);
    	
//    }	    
	

	
	
	/**
	 * 当前任务处理失败，将流程回退到指定的流程节点
	 * 
	 * @param currentTaskId long 当前任务编号
	 * @param goBackTaskTemplateId long 回退的目标任务节点模板编号
	 * @param staffId long 操作员工
	 * @param reason String 回退原因
	 * @param aVars Map 在回退的同时需要设置的流程变量
	 * @return boolean
	 * @throws RemoteException
	 * @throws Exception
	 * 
	 * public boolean goBackToTask(long currentTaskId,long goBackTaskTemplateId, String staffId,
	                                String reason,Map aVars) throws RemoteException, Exception
	 */
//	public void testGoBackToTask3() throws Exception {
//		boolean rtn = ComframeClient.goBackToTask(this.goBackTaskID, this.templateId, staffID, null, null);
//		Assert.assertEquals(false, rtn);
//	}

	
	/**
	 * 停止一个工作流实例
	 * 
	 * @param workflowId 工作流实例编号
	 * @param staffId 停止工作流实例的用户
	 * @param reason 恢复原因
	 * @throws Exception
	 * 
	 * public void stopWorkflow(long workflowId, String staffId, String reason) throws
	      				RemoteException, Exception{
	 */
//	public void testStopWorkflow() throws Exception {
//		ComframeClient.stopWorkflow(this.getWorkflowID(), staffID, null);
//		System.out.println("stopWorkflow....");
//	}	
}
