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
	   * ���Դ���������ʵ��
	   * @param flowCode String ���̴���
	   * @param staffId long ����Ա������
	   * @param objectTypeId String ҵ��������ͱ���
	   * @param objectId String  ҵ��������
	   * @param aVars Map ����ʵ����������
	   * @param startTime Timestamp  ����ʱ��
	   * @param notes ��ע��Ϣ
	   * @return long ����ʵ������
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
//		System.out.println("�����ɹ���workflowid="+result);
	}
	
	/**
	   * ���Դ���������������ʵ��
	   * @param flowCode String ���̴���
	   * @param parentTaskId long ������ʵ��ID
	   * @param staffId long  ����Ա������
	   * @param objectTypeId String ҵ��������ͱ���
	   * @param objectId String  ҵ��������
	   * @param aVars Map ����ʵ����������
	   * @param startTime Timestamp  ����ʱ��
	   * @param notes ��ע��Ϣ
	   * @return long ����ʵ������
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
//		System.out.println("�����ɹ���workflowid="+result);
	}
	
	/**
	   * ����ִ��process
	   * @param processName  ���̱���
	   * @param parameters   ����
	   * @return
	   * @throws Exception
	   * @throws RemoteException
	   */
	public void testExecuteProcess()throws Exception{	
		this.parameters = new HashMap();
		this.parameters.put("param", "1");
//		Map result = apiClient.executeProcess(this.processName,this.parameters);
		System.out.println("�����ɹ���process=");
	}	
	
	/**
	   * �����˹�����ص�
	   * @param taskId long ������
	   * @param staffId String �ص�Ա�����
	   * @param result String �ص����
	   * @param reason String �ص����ԭ��
	   * @param aVars Map ��Ҫ���õ�����ʵ������
	   * @return boolean �ص��Ƿ����
	   * @throws RemoteException
	   * @throws Exception
	   */
	public void testFinishUserTask()throws Exception{ 
//	this.taskID = getUserTask();
//	if (this.taskID != 0) {
//	boolean result = apiClient.finishUserTask(this.taskID, this.staffID, null, null,null);
//	System.out.println("�ص���������="+result);
//	} else {
//	System.out.println("�����˹�����ص�ʧ��");
//	}
	}
	/**
	   * ���Դ�
	   * @param taskId long ������
	   * @param staffId long ����Ա��
	   * @param aVars Map ��Ҫ�޸ĵ�����ʵ������
	   * @return boolean
	   * @throws RemoteException
	   * @throws Exception
	   */
	public void testPrintUserTask()throws Exception{ 
//	this.taskID = getUserTask();
//	if (this.taskID != 0) {
//	boolean result = apiClient.printUserTask(this.taskID, this.staffID,null);
//	System.out.println("����������="+result);
//	} else {
//	System.out.println("���Դ�ʧ��");
//	}
	}
	/**
	   * ������������
	   * @param taskId long �������
	   * @param staffId long Ա������
	   * @throws RemoteException
	   * @throws Exception
	   */
	public void testLockTask()throws Exception{ 
//		this.taskID = getUserTask();
//		if (this.taskID != 0) {
//		apiClient.lockTask(this.taskID, this.staffID);
//		System.out.println("��������ɹ�");
//		} else {
//		System.out.println("��������ʧ��");
//		}
	}
	/**
	   * �����ͷ�����������
	   * @param taskId long �������
	   * @throws RemoteException
	   * @throws Exception
	   */
	public void testRealseTask()throws Exception{
//		this.taskID = getUserTask();
//		apiClient.lockTask(this.taskID, this.staffID);
//		apiClient.realseTask(this.taskID);
//		System.out.println("�ͷ�����������ɹ�");
	}
	/**
	   * ����һ���˹�����taskID
	   * @param taskId long �������
	   * @param staffId long Ա������
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
	   * ����һ���˹�����taskID
	   * @param taskId long �������
	   * @param staffId long Ա������
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
	   * ���Ի�ȡһ������ʵ������������ʵ������
	   * @param workflowId long ����ʵ�����
	   * @return Map
	   * @throws RemoteException
	   * @throws Exception
	   */
	public void testGetWorkflowVars()throws Exception{		
//		Map result = apiClient.getWorkflowVars(getWorkflowID());
//		System.out.println("�����ɹ���workflowid="+result);
	}

	/**
   * ������������ʵ������
   * @param workflowId long ����ʵ�����
   * @param aVars HashMap ����ʵ������
   * @throws RemoteException
   * @throws Exception
   */
	public void testSetWorkflowVars()throws Exception{
//		this.parameters = new HashMap();
//		this.parameters.put("param", "1");
//		apiClient.setWorkflowVars(getWorkflowID(),this.parameters);
//		System.out.println("��������ʵ�������ɹ���");
	}
	
	/**
	   * ���ݱ�����������ѯ��Ӧ�Ĺ�����������Ϣ
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
		System.out.println("��ѯ��Ӧ�Ĺ�����������Ϣ�ɹ���reuslt="+result);
	}

	/**
	   * ���ݱ�����������ѯ��Ӧ�Ĺ�����������Ϣ����
	   * @param condition
	   * @param parameter
	   * @param instVars
	   * @return
	   * @throws RemoteException
	   * @throws Exception
	   */
	public void testGetTaskCountByAttr()throws Exception{
		int result = apiClient.getTaskCountByAttr(queueID,condition,null,null,null);
		System.out.println("��ѯ��Ӧ��������Ϣ�����ɹ���reuslt="+result);
	}
	  
	/**
	   * ����workflowId��ѯ���̱���
	   * @param workflowId
	   * @return
	   * @throws RemoteException
	   * @throws Exception
	   * @deprecated
	   */
	public void testGetVmWorkflowAttrsByWorkflowId()throws Exception{
		//�˷����Ѳ�֧��
		//VmWorkflowAttrInfo[] result = apiClient.getVmWorkflowAttrsByWorkflowId(this.workFlowID);
		//System.out.println("��ѯ���̱����ɹ���reuslt="+result);
	}
	
	/**
	   * ͨ��������������������쳣
	   * @param taskId long �������
	   * @param errorCode String �쳣ԭ�����
	   * @param errorMessage String �쳣ԭ������
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
	   * ͨ�����������쳣���̱��������������쳣
	   * @param taskId long �������
	   * @param errorCode String �쳣ԭ�����
	   * @param errorMessage String �쳣ԭ������
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
	   * ��һ�����̴��쳣�����лָ�����
	   * @param workflowId long ����ʵ�����
	   * @throws Exception
	   */
	  public void testresumeExceptionWorkflow() throws Exception{
//		  long workflowId = getWorkflowID();
//	     apiClient.resumeExceptionWorkflow(workflowId);
	  }
	  
	  /**
	   * ����һ��������ʵ�����쳣���볷��
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
	   * ����һ��������ʵ�����쳣������쳣���̱��볷��
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
	   * ����һ������������,�������������ͺ��쳣���볷��
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
	   * ���ݹ���������,������������쳣���볷��
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
	 * ��ֹһ��������ʵ��
	 * 
	 * @param workflowId ������ʵ�����
	 * @param user ɾ��������ʵ�����û�
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
	 * ���ĳһ����Ա����һ����λ�Ƿ����ִ��ָ�������Ȩ��
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
	 * ģ���Ƿ���process����
	 * 
	 * @param templateCode ���̱���
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public void testIsProcess() throws Exception {
		boolean rtn = apiClient.isProcess(flowCode);
		Assert.assertEquals(false, rtn);
	}
	
	 /**
	 * ģ���Ƿ���workflow����
	 * 
	 * @param templateCode ���̱���
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public void testIsWorkFlow() throws Exception {
		boolean rtn = apiClient.isWorkflow(flowCode);
		Assert.assertEquals(true, rtn);
	}
	
	/**
	 * ����ҵ��������ͺ�ҵ���������ȡ���й���������ʵ�����
	 * 
	 * @param objectTypeId String ҵ��������ͱ���
	 * @param objectId String ҵ��������
	 * @return long[] ����ʵ����������
	 * @throws RemoteException
	 * @throws Exception
	 * public long[] getWorkflowsByWorkflowObjectId(String objectTypeId,String objectId) throws
      									 Exception;
	 */
	public void testGetWorkflowsByWorkflowObjectId() throws Exception {
		String[] result = apiClient.getWorkflowsByWorkflowObjectId(queueID,this.objectTypeId, this.objectId);
		System.out.println("testGetWorkflowsByWorkflowObjectId���ý����"+result);
	}
	
	/**
	 * ��ѯ��ǰ����ʵ������
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
	 * ��ѯ��ʷ����ʵ������
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
	 * ��ѯȫ������ʵ������
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
	 * ��ѯ����ʵ����Ϣ
	 * @param condition String ��ѯ����
	 * @param parameter HashMap ��ѯ����
	 * @param startIndex int -1ʱ���Դ˲���
	 * @param endIndex int -1ʱ���Դ˲���
	 * @return WorkflowViewBean[] ����ʵ������
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
		System.out.println("testGetWorkflowInfos���ý�����"+infos);
	}

	/**
	 * ��ѯ����ʵ����ʷ��Ϣ
	 * @param condition String ��ѯ����
	 * @param parameter HashMap ��ѯ����
	 * @param startIndex int -1ʱ���Դ˲���
	 * @param endIndex int -1ʱ���Դ˲���
	 * @return WorkflowViewBean[] ����ʵ������
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
	 * ��ѯȫ������ʵ����Ϣ
	 * @param condition String ��ѯ����
	 * @param parameter HashMap ��ѯ����
	 * @param startIndex int -1ʱ���Դ˲���
	 * @param endIndex int -1ʱ���Դ˲���
	 * @return WorkflowViewBean[] ����ʵ������
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
		System.out.println("testGetWorkflowAllInfos���ý����"+allInfos);
	}
	
	/**
	 * ���ݸ�λ��Ż�ȡ���������������
	 * 
	 * @param stationId ��λ���
	 * @return �����������
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
		System.out.println("testGetTaskInfosByStationId���ý�����"+infos);
	}
	
	
	  /**
	   * ���ݸ�λ��Ż�ȡ���������������
	   * @param stationId ��λ���
	   * @return �����������
	   * @throws Exception
	   */
	  public void testgetTaskInfosByStationId() throws
	       Exception{
			
			TaskInfo[] ret = apiClient.getTaskInfosByStationId(queueID,this.stations, this.flowCode, this.taskTag);
			System.out.println("getTaskInfosByStationId ���ý�����"+ret);
	  }

	  /**
	   * ���ݸ�λ��ź�Ա����Ż�ȡ���������������
	   * @param stations ��λ����
	   * @param staffid Ա�����
	   * @return �����������
	   * @throws Exception
	   */
	  public void testgetTaskInfosByStationIdAndStaffId() throws  Exception{
		  TaskInfo[] ret = apiClient.getTaskInfosByStationIdAndStaffId(queueID,this.stations, this.staffID, this.flowCode, this.taskTag);
		  System.out.println("getTaskInfosByStationIdAndStaffId���ý�����"+ret);
	  }
	  /**
	   * ���ݶ������ͺͶ����Ż�ȡ���������������
	   * @param objectTypeId �������ͱ��
	   * @param objectId ������
	   * @return �����������
	   * @throws Exception
	   */
	  public void testgetTaskInfosByWorkflowObjectId() throws  Exception{
		  String objectTypeId=this.objectTypeId;
	      String objectId=this.objectId;
		  TaskInfo[] ret = apiClient.getTaskInfosByWorkflowObjectId(queueID,objectTypeId, objectId);
		  System.out.println("getTaskInfosByWorkflowObjectId���ý�����"+ret);
	  }
	/**
	   * ��ѯȫ������ʵ������
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
		  System.out.println("getTaskAllCount���ý�����ȡ��������"+ret+"��");			
	  }
	  
	  /**
	   * ��ѯ��ǰ����ʵ������
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
		  System.out.println("getTaskCount���ý�����ȡ��������"+ret+"��");			
	  }
	  /**
	   * ��ѯ����������Ϣ
	   * @param condition ��ѯ����
	   * @param parameter ��ѯ����
	   * @param startIndex int  -1ʱ���Դ˲���
	   * @param endIndex int    -1ʱ���Դ˲���
	   * @return �����������
	   * @throws RemoteException
	   * @throws Exception
	   */
	  public void testgetTaskInfos() throws Exception{
		  String condition = " TASK_ID < :NUM ";
		  HashMap parameter = new HashMap();
		  parameter.put("NUM", "1000");
		  TaskInfo[] ret = apiClient.getTaskInfos(queueID,condition, parameter, -1, -1);
		  System.out.println("getTaskInfos���ý��������Ϊ��"+ret);
	  }

	  /**
	   * ��ѯȫ������ʵ����Ϣ
	   * @param condition String ��ѯ����
	   * @param parameter HashMap ��ѯ����
	   * @param startIndex int  -1ʱ���Դ˲���
	   * @param endIndex int    -1ʱ���Դ˲���
	   * @return TaskInfo[] ������Ϣ����
	   * @throws RemoteException
	   * @throws Exception
	   */
	  public void testgetTaskInfosHis() throws
	       Exception{
		  String condition = " TASK_ID=:NUM ";
		  HashMap parameter = new HashMap();
		  parameter.put("NUM", "1000");
		  TaskInfo[] ret = apiClient.getTaskInfosHis(queueID,condition, parameter, -1, -1);
		  System.out.println("getTaskAllInfos���ý��������Ϊ��"+ret);
	  }

	/**
	  *��ѯ����ģ��
	  *���ڷǷ���ģʽ����Чʱ��εĲ�������
	  *@param templateCode ����ģ����룬��ģ��ƥ�䣬��Ϊnull
	  *@param sValidDate ��ʼ��Чʱ�䣬��Ϊnull
	  *@param eValidDate  ������Чʱ�䣬��Ϊnull
	  */
	  public void testgetWorkflowTemplates()throws Exception{
		  
		  WorkflowTemplateInfo[] ret = apiClient.getWorkflowTemplates(this.flowCode,"2009-1-1", "2019-9-9");
		  System.out.println("getWorkflowTemplates���ý��������Ϊ��"+ret);
	  }
	/**
	   * ��ȡ����ģ���������˹�����ڵ�
	   *@param templateId ģ��id��Ϊ-1ʱ����ģ������ѯ����ģ��
	   *@param templateCode ģ����룬Ϊ��ʱ����ģ��id��ѯ����ģ��
	   * @return TaskTemplateInfo[]
	   */
	  public void testgetUserTaskTemplates()throws Exception{
		  		  
		  TaskTemplateInfo[] ret = apiClient.getUserTaskTemplates(templateId, this.flowCode);
		  System.out.println("testgetUserTaskTemplates���ý���:"+ret);
	  }
	 
	/**
	   * ��ȡ����ģ������������ڵ� 
	   *@param templateId ģ��id��Ϊ-1ʱ����ģ������ѯ����ģ��
	   *@param templateCode ģ����룬Ϊ��ʱ����ģ��id��ѯ����ģ��
	   * @return TaskTemplateInfo[]
	   */
	  public void testgetTaskTemplates()throws Exception{
		  		
		  TaskTemplateInfo[] ret = apiClient.getTaskTemplates(this.templateId, this.flowCode);
		  System.out.println("testgetTaskTemplates���ý���:"+ret);
	  }
	
	/**
	     * ����һ�����̵�SVG���ͼ
	     * @param workflowId long ����ʵ�����
	     * @return String SVGͼ�͵�XML��
	     * @throws RemoteException
	     * @throws Exception
	     */
//	    public void testtoSvg() throws  Exception{
//	    	String ret = apiClient.toSvg(this.getWorkflowID());
//	    	System.out.println("toSvg���ý���:"+ret);
//	    }

	    /**
	     * ����һ�����̵�SVG���ͼ�����쳣���̣�
	     * @param objectTypeId ���̶�������id
	     * @param objectId  ���̶���id
	     * @return
	     * @throws Exception
	     */
	    public void testtoSvgByWorkflowObjectId() throws  Exception{
	    	String objectTypeId=this.objectTypeId;
	    	String objectId =this.objectId;
	    	String ret = apiClient.toSvgByWorkflowObjectId(queueID,objectTypeId,objectId);
	    	System.out.println("testtoSvgByWorkflowObjectId���ý���:"+ret);
	    }
	    
		/**
		 * ��ǰ������ʧ�ܣ������̻��˵�ָ�������̽ڵ�
		 * 
		 * @param currentTaskId long ��ǰ������
		 * @param goBackTaskTag String ���˵�Ŀ������ڵ����
		 * @param staffId long ����Ա��
		 * @param reason String ����ԭ��
		 * @param aVars Map �ڻ��˵�ͬʱ��Ҫ���õ����̱���
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
		 * ���˵���һ������
		 * 
		 * @param currentTaskId ��ǰ������
		 * @param vars ����ʵ������
		 * @param staffId ������Ա��id
		 * @param notes ��ע��Ϣ
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
		 * ��ǰ������ʧ�ܣ������̻��˵�ָ�������̽ڵ�
		 * 
		 * @param currentTaskId long ��ǰ������
		 * @param goBackTaskTemplateId long ���˵�Ŀ������ڵ�ģ����
		 * @param staffId long ����Ա��
		 * @param reason String ����ԭ��
		 * @param aVars Map �ڻ��˵�ͬʱ��Ҫ���õ����̱���
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
		 * ��һ���˹������������Ȩ����
		 * 
		 * @param taskId long ������
		 * @param authorizeStaffId long ����Ȩ���ڵ���Ա,û����-1
		 * @param authorizeStationId long ����Ȩ����ĸ�λ��û����-1
		 * @param staffId long ����Ȩִ����
		 * @return long ת�ɺ������id
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
		 * ֹͣһ��������ʵ��
		 * 
		 * @param workflowId ������ʵ�����
		 * @param staffId ֹͣ������ʵ�����û�
		 * @param reason �ָ�ԭ��
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
		 * ��������һ��������ʵ��
		 * 
		 * @param workflowId ������ʵ�����
		 * @param staffId ��������������ʵ�����û�
		 * @param reason �ָ�ԭ��
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
