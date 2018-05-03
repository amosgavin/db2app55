package com.ai.comframe.test;

import java.util.HashMap;
import java.util.Map;

import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.complex.center.CenterInfo;
import com.ai.comframe.client.ComframeClient;
import com.ai.comframe.client.TaskInfo;
import com.ai.comframe.client.TaskTemplateInfo;
import com.ai.comframe.client.WorkflowInfo;
import com.ai.comframe.client.WorkflowTemplateInfo;



import junit.framework.Assert;
import junit.framework.TestCase;

public class ComframeClientTest extends TestCase{	
	
	public static ComframeClient apiClient = null;
	public static String queueID = "dev";
	public static String workflowid="dev^000000000000000000794";
	public static String taskID = "dev^000000000000000002265";
	public static String goBackTaskID = "";
	public static String staffID = "1";
	public static String flowCode="template.TestTemplate";
	public static String taskTag = "user";
	public static String errorCode = "1";
	public static long stations[] = {1,2};
	public static long templateId = 277;
	public static String objectTypeId = "CRM";
	public static String errorMessage = "unittest";
	public static String objectId = "1";
	public static long parentID = 44;
	public static String processName = "template.tProcess";
	public static HashMap parameters = null;
	public static String condition = " 1 = 1 ";
//	public static String subFlow = "template.subFlow";
	
	static{
		try {
			//apiClient = ComframeClient.getDefaultComframeClient();
			CenterFactory.setDirectCenterInfo(new CenterInfo("0", "571"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	   * 测试创建工作流实例
	   * @param flowCode String 流程代码
	   * @param staffId long 创建员工编码
	   * @param objectTypeId String 业务对象类型编码
	   * @param objectId String  业务对象编码
	   * @param aVars Map 流程实例变量集合
	   * @param startTime Timestamp  启动时间
	   * @param notes 备注信息
	   * @return long 流程实例编码
	   * @throws RemoteException
	   * @throws Exception
	   */
	public void testCreateWorkFlow()throws Exception{		
//		long result = apiClient.createWorkflow(
//				flowCode, 
//				staffID, 
//				null, 
//				null, 
//				null, 
//				null, 
//				null);
//		this.workflowid = result;
//		System.out.println("创建成功！workflowid="+result);
	}
	
	/**
	   * 测试创建工作流子流程实例
	   * @param flowCode String 流程代码
	   * @param parentTaskId long 父流程实例ID
	   * @param staffId long  创建员工编码
	   * @param objectTypeId String 业务对象类型编码
	   * @param objectId String  业务对象编码
	   * @param aVars Map 流程实例变量集合
	   * @param startTime Timestamp  启动时间
	   * @param notes 备注信息
	   * @return long 流程实例编码
	   * @throws RemoteException
	   * @throws Exception
	   */
	public void testCreateSubWorkFlow()throws Exception{		
//		long result = apiClient.createWorkflow(
//				subFlow, 
//				this.parentID,
//				this.staffID, 
//				null, 
//				null, 
//				null, 
//				null, 
//				null);
//		System.out.println("创建成功！workflowid="+result);
	}
	
	/**
	   * 测试执行process
	   * @param processName  流程编码
	   * @param parameters   参数
	   * @return
	   * @throws Exception
	   * @throws RemoteException
	   */
	public void testExecuteProcess()throws Exception{	
		this.parameters = new HashMap();
		this.parameters.put("param", "1");
//		Map result = apiClient.executeProcess(this.processName,this.parameters);
		System.out.println("创建成功！process=");
	}	
	
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
	public void testFinishUserTask()throws Exception{ 
//	this.taskID = getUserTask();
//	if (this.taskID != 0) {
//	boolean result = apiClient.finishUserTask(this.taskID, this.staffID, null, null,null);
//	System.out.println("回单情况！结果="+result);
//	} else {
//	System.out.println("测试人工任务回单失败");
//	}
	}
	/**
	   * 测试打单
	   * @param taskId long 任务编号
	   * @param staffId long 操作员工
	   * @param aVars Map 需要修改的流程实例变量
	   * @return boolean
	   * @throws RemoteException
	   * @throws Exception
	   */
	public void testPrintUserTask()throws Exception{ 
//	this.taskID = getUserTask();
//	if (this.taskID != 0) {
//	boolean result = apiClient.printUserTask(this.taskID, this.staffID,null);
//	System.out.println("打单情况！结果="+result);
//	} else {
//	System.out.println("测试打单失败");
//	}
	}
	/**
	   * 测试锁定任务
	   * @param taskId long 任务编码
	   * @param staffId long 员工编码
	   * @throws RemoteException
	   * @throws Exception
	   */
	public void testLockTask()throws Exception{ 
//		this.taskID = getUserTask();
//		if (this.taskID != 0) {
//		apiClient.lockTask(this.taskID, this.staffID);
//		System.out.println("锁定任务成功");
//		} else {
//		System.out.println("锁定任务失败");
//		}
	}
	/**
	   * 测试释放锁定的流程
	   * @param taskId long 任务编码
	   * @throws RemoteException
	   * @throws Exception
	   */
	public void testRealseTask()throws Exception{
//		this.taskID = getUserTask();
//		apiClient.lockTask(this.taskID, this.staffID);
//		apiClient.realseTask(this.taskID);
//		System.out.println("释放锁定的任务成功");
	}
	/**
	   * 返回一个人工任务taskID
	   * @param taskId long 任务编码
	   * @param staffId long 员工编码
	   * @throws RemoteException
	   * @throws Exception
	   */
//	public String getUserTask()throws Exception{ 
////		WorkflowConsoleImpl wi = new WorkflowConsoleImpl();
////		TaskViewBean[] tb = wi.getTaskLists("",this.staffID,this.flowCode,"");
////		if (tb != null && tb.length > 1)
////		return tb[0].getTaskId();
//		return null;
//	}
	
	/**
	   * 返回一个人工任务taskID
	   * @param taskId long 任务编码
	   * @param staffId long 员工编码
	   * @throws RemoteException
	   * @throws Exception
	   */
//	public String getWorkflowID()throws Exception{ 
////		String cond = " 1=1 ";
////		WorkflowBean[] bf = WorkflowConsoleImpl.getWorkflowInst().getWorkflowBeans(cond, null,-1,-1);
////		if (bf != null && bf.length > 1)
////		return bf[0].getTaskId();
//		return null;
//	}
//	 
	
	
	
  
	
	
	
	
	
	
	
	  
	/**
	   * 测试获取一个流程实例的所有流程实例变量
	   * @param workflowId long 流程实例编号
	   * @return Map
	   * @throws RemoteException
	   * @throws Exception
	   */
	public void testGetWorkflowVars()throws Exception{		
//		Map result = apiClient.getWorkflowVars(getWorkflowID());
//		System.out.println("创建成功！workflowid="+result);
	}

	/**
   * 测试设置流程实例变量
   * @param workflowId long 流程实例编号
   * @param aVars HashMap 流程实例参数
   * @throws RemoteException
   * @throws Exception
   */
	public void testSetWorkflowVars()throws Exception{
//		this.parameters = new HashMap();
//		this.parameters.put("param", "1");
//		apiClient.setWorkflowVars(getWorkflowID(),this.parameters);
//		System.out.println("设置流程实例变量成功！");
	}
	
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
	public void testGetTaskInfosByAttr()throws Exception{
		TaskInfo[] result = apiClient.getTaskInfosByAttr(queueID,condition,null,null,null,-1,-1);
		System.out.println("查询对应的工作流任务信息成功！reuslt="+result);
	}

	/**
	   * 根据变量、条件查询对应的工作流任务信息总数
	   * @param condition
	   * @param parameter
	   * @param instVars
	   * @return
	   * @throws RemoteException
	   * @throws Exception
	   */
	public void testGetTaskCountByAttr()throws Exception{
		int result = apiClient.getTaskCountByAttr(queueID,condition,null,null,null);
		System.out.println("查询对应的任务信息总数成功！reuslt="+result);
	}
	  
	/**
	   * 根据workflowId查询流程变量
	   * @param workflowId
	   * @return
	   * @throws RemoteException
	   * @throws Exception
	   * @deprecated
	   */
	public void testGetVmWorkflowAttrsByWorkflowId()throws Exception{
		//此方法已不支持
		//VmWorkflowAttrInfo[] result = apiClient.getVmWorkflowAttrsByWorkflowId(this.workFlowID);
		//System.out.println("查询流程变量成功！reuslt="+result);
	}
	
	/**
	   * 通过任务编码来设置流程异常
	   * @param taskId long 任务编码
	   * @param errorCode String 异常原因代码
	   * @param errorMessage String 异常原因描述
	   * @throws Exception
	   */
	  public void testfireWorkflowExceptionByTaskId() throws
	      Exception{
//		  long taskId = getUserTask();
//		  String staffId = this.staffID;
//		  String errorCode = this.errorCode;
//		  String errorMessage = this.errorMessage;
//		  apiClient.fireWorkflowExceptionByTaskId(1891,staffId,errorCode, errorMessage);
	  }
	  /**
	   * 通过任务编码和异常流程编码来设置流程异常
	   * @param taskId long 任务编码
	   * @param errorCode String 异常原因代码
	   * @param errorMessage String 异常原因描述
	   * @throws Exception
	   */
	  public void testfireWorkflowExceptionByTaskId1() throws
	      Exception{
//		  long taskId=getUserTask();
//		  String staffId=this.staffID;
//		  String errorCode=this.errorCode;
//		  String nextWorkflowCode= this.flowCode;
//		  String errorMessage=this.errorMessage;
//		  apiClient.fireWorkflowExceptionByTaskId(taskId,staffId,errorCode, nextWorkflowCode,errorMessage);
	  }
	  
	  /**
	   * 将一个流程从异常队列中恢复回来
	   * @param workflowId long 流程实例编号
	   * @throws Exception
	   */
	  public void testresumeExceptionWorkflow() throws Exception{
//		  long workflowId = getWorkflowID();
//	     apiClient.resumeExceptionWorkflow(workflowId);
	  }
	  
	  /**
	   * 根据一个工作流实例和异常编码撤单
	   * @param workflowId
	   * @param staffId
	   * @param errorCode
	   * @param errorMessage
	   * @throws RemoteException
	   * @throws Exception
	   */
	  public void testcancelWorkflow() throws Exception {
//		  long workflowId=getWorkflowID();
//		  String staffId=this.staffID;
//		  String errorCode=this.errorCode;
//		  String errorMessage="errorMessage";
//		 apiClient.cancelWorkflow(workflowId, staffId, errorCode, errorMessage);
	}
	  /**
	   * 根据一个工作流实例，异常编码和异常流程编码撤单
	   * @param workflowId
	   * @param staffId
	   * @param errorCode
	   * @param nextWorkflow
	   * @param errorMessage
	   * @throws RemoteException
	   * @throws Exception
	   */
	public void testcancelWorkflow1() throws
	     Exception {
//		long workflowId = getWorkflowID();
//		String staffId =this.staffID;
//		String errorCode=this.errorCode;
//		String nextWorkflowCode = "";
//		String errorMessage = "errorMessage";
//		apiClient.cancelWorkflow(workflowId, staffId, errorCode, nextWorkflowCode,errorMessage);
	}
	/**
	   * 根据一个工作流对象,工作流对象类型和异常编码撤单
	   * @param workflowId
	   * @param staffId
	   * @param errorCode
	   * @param errorMessage
	   * @throws RemoteException
	   * @throws Exception
	   */
	public void testcancelWorkflow2() throws
	   Exception {
		String objectTypeId = this.objectTypeId;
		String objectId = this.objectId;
		String staffId = this.staffID;
		String errorCode = this.errorCode;
		String errorMessage = this.errorMessage;
		apiClient.cancelWorkflow(objectTypeId, objectId, staffId, errorCode, errorMessage);
	}
	/**
	   * 根据工作流对象,工作流对象和异常编码撤单
	   * @param workflowId
	   * @param staffId
	   * @param errorCode
	   * @param errorMessage
	   * @throws RemoteException
	   * @throws Exception
	   */
	public void testcancelWorkflow3() throws
	    Exception {
//		String objectTypeId = this.objectTypeId;
//		String objectId = this.objectId;
//		String staffId = this.staffID;
//		String errorCode = this.errorCode;
//		String nextWorkflowCode ="";
//		String errorMessage = this.errorMessage;
//		apiClient.cancelWorkflow(objectTypeId, objectId, staffId, errorCode, nextWorkflowCode, errorMessage) ;
	}

	
	
	
	/**
	 * 终止一个工作流实例
	 * 
	 * @param workflowId 工作流实例编号
	 * @param user 删除工作流实例的用户
	 * @throws Exception
	 */
	public void testTerminateWorkflow() throws Exception {
//		long result = apiClient.createWorkflow(flowCode, staffID, null,
//				null, null, null, null);
//
//		apiClient.terminateWorkflow(result, staffID, null);
//		System.out.println("TerminateWorkflow...");
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
	public void testCanExecuteTask() throws Exception {
//		boolean rtn = apiClient.canExecuteTask(getUserTask(), null, Long.parseLong(staffID));
//		Assert.assertEquals(false, rtn);
	}

	/**
	 * 模板是否是process类型
	 * 
	 * @param templateCode 流程编码
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public void testIsProcess() throws Exception {
		boolean rtn = apiClient.isProcess(flowCode);
		Assert.assertEquals(false, rtn);
	}
	
	 /**
	 * 模板是否是workflow类型
	 * 
	 * @param templateCode 流程编码
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public void testIsWorkFlow() throws Exception {
		boolean rtn = apiClient.isWorkflow(flowCode);
		Assert.assertEquals(true, rtn);
	}
	
	/**
	 * 根据业务对象类型和业务对象编码获取所有关联的流程实例编号
	 * 
	 * @param objectTypeId String 业务对象类型编码
	 * @param objectId String 业务对象编码
	 * @return long[] 流程实例编码数组
	 * @throws RemoteException
	 * @throws Exception
	 * public long[] getWorkflowsByWorkflowObjectId(String objectTypeId,String objectId) throws
      									 Exception;
	 */
	public void testGetWorkflowsByWorkflowObjectId() throws Exception {
		String[] result = apiClient.getWorkflowsByWorkflowObjectId(queueID,this.objectTypeId, this.objectId);
		System.out.println("testGetWorkflowsByWorkflowObjectId调用结果："+result);
	}
	
	/**
	 * 查询当前流程实例数量
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 * 
	 * public int getWorkflowCount(String condition,HashMap parameter)throws Exception;
	 */
	public void testGetWorkflowCount() throws Exception {
		int count = apiClient.getWorkflowCount(queueID,null, null);
		System.out.println("testGetWorkflowCount: " + count);
	}
	
	/**
	 * 查询历史流程实例数量
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 * 
	 * public int getWorkflowHisCount(String condition,HashMap parameter)throws Exception;
	 */
	public void testGetWorkflowHisCount() throws Exception {
		int hisCount = apiClient.getWorkflowHisCount(queueID,null, null);
		System.out.println("testGetWorkflowHisCount: " + hisCount);
	}

	/**
	 * 查询全部流程实例数量
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 * 
	 *  public int getWorkflowAllCount(String condition,HashMap parameter)throws Exception;
	 */
	public void testGetWorkflowHisCount2() throws  Exception {
		int allCount = apiClient.getWorkflowHisCount(queueID,null, null);
		System.out.println("testGetWorkflowAllCount: " + allCount);
	}
	
	/**
	 * 查询流程实例信息
	 * @param condition String 查询条件
	 * @param parameter HashMap 查询参数
	 * @param startIndex int -1时忽略此参数
	 * @param endIndex int -1时忽略此参数
	 * @return WorkflowViewBean[] 流程实例数组
	 * @throws RemoteException
	 * @throws Exception
	 * 
	 * public WorkflowInfo[] getWorkflowInfos(String condition,
											HashMap parameter, int startIndex, int endIndex) throws
      										 Exception;
	 */
	public void testGetWorkflowInfos() throws  Exception {
		WorkflowInfo[] infos = apiClient.getWorkflowInfos(queueID,null, null, -1, -1);
		for (int i = 0; i < infos.length; i++) {
			System.out.println(infos[i].getTaskTag());
		}
		System.out.println("testGetWorkflowInfos调用结束："+infos);
	}

	/**
	 * 查询流程实例历史信息
	 * @param condition String 查询条件
	 * @param parameter HashMap 查询参数
	 * @param startIndex int -1时忽略此参数
	 * @param endIndex int -1时忽略此参数
	 * @return WorkflowViewBean[] 流程实例数组
	 * @throws RemoteException
	 * @throws Exception
	 * 
	 * public WorkflowInfo[] getWorkflowHisInfos(String condition,
                                                HashMap parameter,int startIndex,int endIndex) throws
      											 Exception;

	 */
	public void testGetWorkflowHisInfos() throws  Exception {
		WorkflowInfo[] hisInfos = apiClient.getWorkflowHisInfos(queueID,null, null, -1, -1);
//		for (int i = 0; i < hisInfos.length; i++) {
		System.out.println("testGetWorkflowHisInfos:"+hisInfos);
//		}
	}
	
	/**
	 * 查询全部流程实例信息
	 * @param condition String 查询条件
	 * @param parameter HashMap 查询参数
	 * @param startIndex int -1时忽略此参数
	 * @param endIndex int -1时忽略此参数
	 * @return WorkflowViewBean[] 流程实例数组
	 * @throws RemoteException
	 * @throws Exception
	 * 
	 * public WorkflowInfo[] getWorkflowAllInfos(String condition,
                                                HashMap parameter,int startIndex,int endIndex) throws
      											 Exception;
	 */
	public void testGetWorkflowInfosHis() throws  Exception {
		WorkflowInfo[] allInfos = apiClient.getWorkflowInfos(queueID,null, null, -1, -1);
//		for (int i = 0; i < allInfos.length; i++) {
//			System.out.println(allInfos[i].getTaskTag());
//		}
		System.out.println("testGetWorkflowAllInfos调用结果："+allInfos);
	}
	
	/**
	 * 根据岗位编号获取工作任务对象数组
	 * 
	 * @param stationId 岗位编号
	 * @return 任务对象数组
	 * @throws Exception
	 * 
	 * public TaskInfo[] getTaskInfosByStationId(long stationId,
	 * 											String workflowTemplateCode,String taskTag)
      		 									throws  Exception;
	 */
	public void testGetTaskInfosByStationId() throws  Exception {
		TaskInfo[] infos = apiClient.getTaskInfosByStationId(queueID,null, flowCode, "template.TestTemplate");
//		for (int i = 0; i < infos.length; i++) {
//			System.out.println(infos[i].getLabel());
//		}
		System.out.println("testGetTaskInfosByStationId调用结束："+infos);
	}
	
	
	  /**
	   * 根据岗位编号获取工作任务对象数组
	   * @param stationId 岗位编号
	   * @return 任务对象数组
	   * @throws Exception
	   */
	  public void testgetTaskInfosByStationId() throws
	       Exception{
			
			TaskInfo[] ret = apiClient.getTaskInfosByStationId(queueID,this.stations, this.flowCode, this.taskTag);
			System.out.println("getTaskInfosByStationId 调用结束："+ret);
	  }

	  /**
	   * 根据岗位编号和员工编号获取工作任务对象数组
	   * @param stations 岗位数组
	   * @param staffid 员工编号
	   * @return 任务对象数组
	   * @throws Exception
	   */
	  public void testgetTaskInfosByStationIdAndStaffId() throws  Exception{
		  TaskInfo[] ret = apiClient.getTaskInfosByStationIdAndStaffId(queueID,this.stations, this.staffID, this.flowCode, this.taskTag);
		  System.out.println("getTaskInfosByStationIdAndStaffId调用结束："+ret);
	  }
	  /**
	   * 根据对象类型和对象编号获取工作任务对象数组
	   * @param objectTypeId 对象类型编号
	   * @param objectId 对象编号
	   * @return 任务对象数组
	   * @throws Exception
	   */
	  public void testgetTaskInfosByWorkflowObjectId() throws  Exception{
		  String objectTypeId=this.objectTypeId;
	      String objectId=this.objectId;
		  TaskInfo[] ret = apiClient.getTaskInfosByWorkflowObjectId(queueID,objectTypeId, objectId);
		  System.out.println("getTaskInfosByWorkflowObjectId调用结束："+ret);
	  }
	/**
	   * 查询全部任务实例数量
	   * @param condition
	   * @param parameter
	   * @return
	   * @throws RemoteException
	   * @throws Exception
	   */
	  public void testgetTaskHisCount()throws Exception{
		  int ret =0;
		  String condition = " TASK_ID < :NUM ";
		  HashMap parameter = new HashMap();
		  parameter.put("NUM", "1000");
		  ret= apiClient.getTaskHisCount(queueID,condition, parameter);
		  System.out.println("getTaskAllCount调用结束：取得任务数"+ret+"条");			
	  }
	  
	  /**
	   * 查询当前任务实例数量
	   * @param condition
	   * @param parameter
	   * @return
	   * @throws RemoteException
	   * @throws Exception
	   */
	  public void testgetTaskCount()throws Exception{
		  int ret =0;
		  String condition = " TASK_ID < :NUM ";
		  HashMap parameter = new HashMap();
		  parameter.put("NUM", "1000");
		  ret= apiClient.getTaskCount(queueID,condition, parameter);
		  System.out.println("getTaskCount调用结束：取得任务数"+ret+"条");			
	  }
	  /**
	   * 查询工作任务信息
	   * @param condition 查询条件
	   * @param parameter 查询参数
	   * @param startIndex int  -1时忽略此参数
	   * @param endIndex int    -1时忽略此参数
	   * @return 任务对象数组
	   * @throws RemoteException
	   * @throws Exception
	   */
	  public void testgetTaskInfos() throws Exception{
		  String condition = " TASK_ID < :NUM ";
		  HashMap parameter = new HashMap();
		  parameter.put("NUM", "1000");
		  TaskInfo[] ret = apiClient.getTaskInfos(queueID,condition, parameter, -1, -1);
		  System.out.println("getTaskInfos调用结束，结果为："+ret);
	  }

	  /**
	   * 查询全部任务实例信息
	   * @param condition String 查询条件
	   * @param parameter HashMap 查询参数
	   * @param startIndex int  -1时忽略此参数
	   * @param endIndex int    -1时忽略此参数
	   * @return TaskInfo[] 任务信息数组
	   * @throws RemoteException
	   * @throws Exception
	   */
	  public void testgetTaskInfosHis() throws
	       Exception{
		  String condition = " TASK_ID=:NUM ";
		  HashMap parameter = new HashMap();
		  parameter.put("NUM", "1000");
		  TaskInfo[] ret = apiClient.getTaskInfosHis(queueID,condition, parameter, -1, -1);
		  System.out.println("getTaskAllInfos调用结束，结果为："+ret);
	  }

	/**
	  *查询流程模板
	  *对于非发布模式，生效时间段的参数无用
	  *@param templateCode 流程模板编码，可模糊匹配，可为null
	  *@param sValidDate 起始生效时间，可为null
	  *@param eValidDate  截至生效时间，可为null
	  */
	  public void testgetWorkflowTemplates()throws Exception{
		  
		  WorkflowTemplateInfo[] ret = apiClient.getWorkflowTemplates(this.flowCode,"2009-1-1", "2019-9-9");
		  System.out.println("getWorkflowTemplates调用结束，结果为："+ret);
	  }
	/**
	   * 获取流程模板中所有人工任务节点
	   *@param templateId 模板id，为-1时根据模板编码查询流程模板
	   *@param templateCode 模板编码，为空时根据模板id查询流程模板
	   * @return TaskTemplateInfo[]
	   */
	  public void testgetUserTaskTemplates()throws Exception{
		  		  
		  TaskTemplateInfo[] ret = apiClient.getUserTaskTemplates(templateId, this.flowCode);
		  System.out.println("testgetUserTaskTemplates调用结束:"+ret);
	  }
	 
	/**
	   * 获取流程模板中所有任务节点 
	   *@param templateId 模板id，为-1时根据模板编码查询流程模板
	   *@param templateCode 模板编码，为空时根据模板id查询流程模板
	   * @return TaskTemplateInfo[]
	   */
	  public void testgetTaskTemplates()throws Exception{
		  		
		  TaskTemplateInfo[] ret = apiClient.getTaskTemplates(this.templateId, this.flowCode);
		  System.out.println("testgetTaskTemplates调用结束:"+ret);
	  }
	
	/**
	     * 生成一个流程的SVG监控图
	     * @param workflowId long 流程实例编号
	     * @return String SVG图型的XML串
	     * @throws RemoteException
	     * @throws Exception
	     */
//	    public void testtoSvg() throws  Exception{
//	    	String ret = apiClient.toSvg(this.getWorkflowID());
//	    	System.out.println("toSvg调用结束:"+ret);
//	    }

	    /**
	     * 生成一个流程的SVG监控图（非异常流程）
	     * @param objectTypeId 流程对象类型id
	     * @param objectId  流程对象id
	     * @return
	     * @throws Exception
	     */
	    public void testtoSvgByWorkflowObjectId() throws  Exception{
	    	String objectTypeId=this.objectTypeId;
	    	String objectId =this.objectId;
	    	String ret = apiClient.toSvgByWorkflowObjectId(queueID,objectTypeId,objectId);
	    	System.out.println("testtoSvgByWorkflowObjectId调用结束:"+ret);
	    }
	    
		/**
		 * 当前任务处理失败，将流程回退到指定的流程节点
		 * 
		 * @param currentTaskId long 当前任务编号
		 * @param goBackTaskTag String 回退的目标任务节点编码
		 * @param staffId long 操作员工
		 * @param reason String 回退原因
		 * @param aVars Map 在回退的同时需要设置的流程变量
		 * @return boolean
		 * @throws RemoteException
		 * @throws Exception
		 * 
		 * public boolean goBackToTask(long currentTaskId,String
		 *             goBackTaskTag, String staffId, String reason,Map aVars)
		 *             throws RemoteException, Exception{
		 */
//		public void testGoBackToTask() throws Exception {
//			boolean rtn = apiClient.goBackToTask(this.goBackTaskID, this.taskTag, staffID, null, null);
//			Assert.assertEquals(true, rtn);
//		}
		
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
//		public void testGoBackToTask2() throws Exception {
//			boolean rtn = apiClient.goBackToTask(this.goBackTaskID, null, staffID, null);
//			Assert.assertEquals(true, rtn);
//		}

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
//		public void testGoBackToTask3() throws Exception {
//			boolean rtn = apiClient.goBackToTask(this.goBackTaskID, this.templateId, staffID, null, null);
//			Assert.assertEquals(false, rtn);
//		}

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
//		public void testReAuthorizeTask() throws Exception {
//			String result = apiClient.reAuthorizeTask(this.getUserTask(), staffID, "-1", "2");
//			System.out.println("reAuthorizeTask ID = " + result);
//		}
		  
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
//		public void testStopWorkflow() throws Exception {
//			apiClient.stopWorkflow(this.getWorkflowID(), staffID, null);
//			System.out.println("stopWorkflow....");
//		}
		  
		/**
		 * 重新启动一个工作流实例
		 * 
		 * @param workflowId 工作流实例编号
		 * @param staffId 重新启动工作流实例的用户
		 * @param reason 恢复原因
		 * @throws Exception
		 * 
		 * public void resumeWorkflow(long workflowId, String staffId, String reason) throws
		      			RemoteException, Exception{
		 */
//		public void testResumeWorkflow() throws Exception {
//			apiClient.resumeWorkflow(this.getWorkflowID(), staffID, null);
//			System.out.println("resumeWorkflow........");
//		}
	    

	   
	
}
