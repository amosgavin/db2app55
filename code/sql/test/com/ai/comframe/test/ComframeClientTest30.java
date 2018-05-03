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
		
		/**���� ��ʷ����ʵ����ѯ **/
		//��ѯ��������ʵ��
//		String[] ids = ComframeClient.getWorkflowsByWorkflowObjectId("test", "test", "2");
//		System.out.println("��ѯ��������ʵ��:"+ids.length);
		//��ʷ����ʵ��,�������,comframe.ini���� true,false,��������ļ���ķֱ�����
//		String[] h_ids = ComframeClient.getWorkflowsHisByWorkflowObjectId("test", "test", "2");
//		System.out.println("��ѯ������ʷ����ʵ��:"+h_ids.length);
		/**���� ����ʵ����ѯ **/
		//��ѯ��������ʵ������		
		HashMap aVars = new HashMap();
		aVars.put("qid", "test");
//		int cnt =ComframeClient.getWorkflowCount("test", "QUEUE_ID=:qid", aVars);
//		System.out.println("��ѯ������ʷ����ʵ������:"+cnt);
		//��ѯ����������ʷʵ������
//		int cnt_h =ComframeClient.getWorkflowHisCount("test", "QUEUE_ID=:qid", aVars);
//		System.out.println("��ѯ������ʷ����ʵ������:"+cnt_h);
		//����������ѯ��������ʵ������  --BUG
		int cnt_c =ComframeClient.getWorkflowHisCount("test","201111","1=1",aVars);
		System.out.println("��ѯ������ʷ����ʵ������:"+cnt_c);
		
		/**���� ����ʵ����ѯ **/  
		//---bug �޷���queueID������ѯ
		int task_cnt = ComframeClient.getTaskCount("test", "QUEUE_ID=:qid", aVars);		
		System.out.println("��ѯ��������ʵ������:"+task_cnt);
		//---bug �޷���queueID������ѯ
		int task_cnth = ComframeClient.getTaskHisCount("test", "QUEUE_ID=:qid", aVars);
		System.out.println("��ѯ��������ʵ������:"+task_cnth);

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
	public static void testCanExecuteTask() throws Exception {
//		boolean rtn = ComframeClient.finishUserTask("test^111^0000000000000299","123", null,null, null);
//		System.out.println("�ص���������="+rtn);
//		boolean rtn = ComframeClient.canExecuteTask("test^111^0000000000000304", new long[]{2},"2");
		boolean rtn = ComframeClient.canExecuteTask("test^111^0000000000000304", new long[]{2,0,1,22},"2");
//		Assert.assertEquals(false, rtn);
	}
	
	
	/**
	 *    new API test
	 */
	
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
	public static void testGetTaskInfosByAttr2()throws Exception{
		TaskInfo[] result = ComframeClient.getTaskInfosByAttr(queueID,condition,null,null,null,-1,-1);
		System.out.println("��ѯ��Ӧ�Ĺ�����������Ϣ�ɹ���reuslt="+result);
	}
	
    /**
     * ָ�����ڰ���������ѯ��ʷ����ʵ������
     * @param queueID ���б�ʶ
     * @param acctPeriod ���ڱ�ʶ(��ʽ:yyyyMM,��201105)
     * @param condition ��ѯ����
     * @param parameter ��ѯ�����еĲ���
     * @return
     * @throws RemoteException
     * @throws Exception
     */
	public static void testGetTaskHisCount() throws Exception{
		int task_cnt3 = ComframeClient.getTaskHisCount("test", "201110", condition,null);
		System.out.println("ָ�����ڰ���������ѯ��ʷ����ʵ������:"+task_cnt3);
		
	}
	
	/**
	 * ����taskId��ѯ����������Ϣ
	 * 
	 * @param TaskId
	 *          ������
	 * @return �������
	 * @throws RemoteException
	 * @throws Exception
	 */
	public static void testGetTaskInfoHis() throws Exception{
		TaskInfo ret = ComframeClient.getTaskInfoHis(taskID);
		System.out.println("getTaskInfoHis(taskID)���ý��������Ϊ��"+ret);
	}
	/**
	 * ����taskId������ ��ѯ����������Ϣ
	 * 
	 * @param TaskId ������
	 * @param  acctPeriod  ����  
	 * @return �������
	 * @throws RemoteException
	 * @throws Exception
	 */
	public static void testGetTaskInfoHis2() throws Exception{
		TaskInfo ret = ComframeClient.getTaskInfoHis(taskID, acctPeriod);
		System.out.println("getTaskInfoHis(taskID, acctPeriod)���ý��������Ϊ��"+ret);
	}
	/**
	 *  ��ѯ����������Ϣ
	 * 
	 * @param queueID ����
	 * @param  acctPeriod  ����  
	 * @param  condition ����
	 * @param  parameter ��ѯ�����еĲ���
	 * @param startIndex   int -1ʱ���Դ˲���
	 * @param endIndex   int -1ʱ���Դ˲���
	 * @return �������
	 * @throws RemoteException
	 * @throws Exception
	 */
	public static void testGetTaskInfosHis2() throws Exception{
		TaskInfo[] ret = ComframeClient.getTaskInfosHis(queueID, acctPeriod, condition, null, -1, -1);
		System.out.println("getTaskInfosHis���ý��������Ϊ��"+ret);
	}
	
	public static void testGetTaskInfo() throws Exception{
		TaskInfo ret = ComframeClient.getTaskInfo(taskID);
		System.out.println("getTaskInfo(taskID)���ý��������Ϊ��"+ret);
	}
	
	public static void testGetTaskInfosByWorkflowId() throws Exception{
		TaskInfo[] ret = ComframeClient.getTaskInfosByWorkflowId(workflowid);
		System.out.println("getTaskInfosByWorkflowId(workflowId)���ý��������Ϊ��"+ret);
	}
	
	public static void testGetTaskInfosHisByWorkflowId() throws Exception{
		TaskInfo[] ret=	ComframeClient.getTaskInfosHisByWorkflowId(workflowid);
		System.out.println("getTaskInfosHisByWorkflowId(workflowId)���ý��������Ϊ��"+ret);
	}
	public static void testGetTaskInfosHisByWorkflowId2() throws Exception{
		TaskInfo[] ret= ComframeClient.getTaskInfosHisByWorkflowId(workflowid, acctPeriod);
		System.out.println("getTaskInfosHisByWorkflowId(workflowId)���ý��������Ϊ��"+ret);
	}
	public static void testGetTaskInfosHisByWorkflowObjectId() throws Exception{
		TaskInfo[] ret= ComframeClient.getTaskInfosHisByWorkflowObjectId(queueID, acctPeriod, objectTypeId, objectId);
		System.out.println("getTaskInfosHisByWorkflowObjectId(queueID, acctPeriod, objectTypeId, objectId)���ý��������Ϊ��"+ret);
	}
	
	/**����ʵ��  */
	
	/**
	   * ����ҵ��������ͺ�ҵ���������ȡ���й���������ʵ�����
	   * @param queueID ����ID
	   * @param objectTypeId String ҵ��������ͱ���
	   * @param objectId String ҵ��������
	   * @return long[] ����ʵ����������
	   * @throws RemoteException
	   * @throws Exception
	 */
	public static void testGetWorkflowsByWorkflowObjectId() throws Exception{
		String[] ids = ComframeClient.getWorkflowsByWorkflowObjectId("test", "test", "2");
		System.out.println("��ѯ��ȡ���й���������ʵ�����:"+ids);
	}
	public static void testGetWorkflowHisInfos() throws Exception{
		WorkflowInfo[] wf =ComframeClient.getWorkflowHisInfos(queueID,acctPeriod, condition,null, -1, -1);
		System.out.println("getWorkflowHisInfos��ѯ���:"+wf);
	}
	public static void testGetWorkflowInfo() throws Exception{
		WorkflowInfo wf2 = ComframeClient.getWorkflowInfo(workflowid);
		System.out.println("getWorkflowInfo��ѯ���:"+wf2);
	}
	
	public static void testGetWorkflowInfosHis() throws Exception{
		WorkflowInfo[] wf3 = ComframeClient.getWorkflowInfosHis(queueID, acctPeriod,condition, null, -1, -1);
		System.out.println("getWorkflowInfosHis��ѯ���:"+wf3);
	}
	public static void testGetWorkflowsHisByWorkflowObjectId() throws Exception{
		String[] ids2 = ComframeClient.getWorkflowsHisByWorkflowObjectId(queueID, objectTypeId, objectId);
		System.out.println("getWorkflowsHisByWorkflowObjectId��ѯ���:"+ids2);
	}
	public static void testGetWorkflowsHisByWorkflowObjectId2() throws Exception{	
		String[] ids3 = ComframeClient.getWorkflowsHisByWorkflowObjectId(queueID, acctPeriod, objectTypeId, objectId);
		System.out.println("getWorkflowsHisByWorkflowObjectId��ѯ���:"+ids3);
	}
	public static void testGetWorkflowInfoHis()	 throws Exception{
		WorkflowInfo wf4 = ComframeClient.getWorkflowInfoHis(h_workflowid);
		System.out.println("getWorkflowInfoHis��ѯ���:"+wf4);
	}
	public static void testGetWorkflowInfoHis2()	throws Exception{
		WorkflowInfo wf5 = ComframeClient.getWorkflowInfoHis(h_workflowid, acctPeriod);
		System.out.println("getWorkflowInfoHis��ѯ���:"+wf5);
	}

	public static void testGetAlarmConfig() throws Exception{
		IBOVmAlarmConfigValue[] aa = ComframeClient.getAlarmConfig(taskTag,"template.TestTemplate");
		System.out.println("getAlarmConfig��ѯ���:"+aa.length);
	}

	public static void testGetAlarmConfigs() throws Exception{
		IBOVmAlarmConfigValue[] bb = ComframeClient.getAlarmConfigs("template.TestTemplate");
		System.out.println("getAlarmConfigs��ѯ���:"+bb);
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
	 * ģ���Ƿ���process����
	 * 
	 * @param templateCode ���̱���
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
//	public void testIsProcess() throws Exception {
//		boolean rtn = ComframeClient.isProcess(flowCode);
//		Assert.assertEquals(false, rtn);
//	}
	
	
	 /**
	 * ģ���Ƿ���workflow����
	 * 
	 * @param templateCode ���̱���
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
//	public void testIsWorkFlow() throws Exception {
//		boolean rtn = ComframeClient.isWorkflow(flowCode);
//		Assert.assertEquals(true, rtn);
//	}
	
	
	
	  /**
	   * ��һ�����̴��쳣�����лָ�����
	   * @param workflowId long ����ʵ�����
	   * @throws Exception
	   */
//	  public void testresumeExceptionWorkflow() throws Exception{
//		  long workflowId = getWorkflowID();
//	     apiClient.resumeExceptionWorkflow(workflowId);
//	  }



	
	/**
	   * ���Դ�
	   * @param taskId long ������
	   * @param staffId long ����Ա��
	   * @param aVars Map ��Ҫ�޸ĵ�����ʵ������
	   * @return boolean
	   * @throws RemoteException
	   * @throws Exception
	   */
//	public void testPrintUserTask()throws Exception{ 
//	boolean result = ComframeClient.printUserTask(taskID, staffID,null);
//	System.out.println("����������="+result);
//	} 	
//	}
	
	
//	public static void main(String[] args) throws Exception{
//		boolean result = apiClient.printUserTask("test^mm^00000000000000884", "0191",null);
//		System.out.println("����������="+result);

//	}
	
	
	
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
//	public void testFinishUserTask()throws Exception{ 
//	boolean result = ComframeClient.finishUserTask(taskID, staffID, null, null,null);
//	System.out.println("�ص���������="+result);
//	} 
//	}
	
//	public static void main(String[] args) throws Exception{
//		boolean result = ComframeClient.finishUserTask("test^mm^00000000000000993", "0191", null, null,null);
//		System.out.println("�ص���������="+result);
//	}
	
	
	
	
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
//	public void testReAuthorizeTask() throws Exception {
//		String result = ComframeClient.reAuthorizeTask(task_id, staffID, "-1", "2");
//		System.out.println("reAuthorizeTask ID = " + result);
//	}

//	public static void main(String[] args) throws Exception{
//	String result = ComframeClient.reAuthorizeTask("test^mm^00000000000000881", "0199", "-1", "0191");
//	System.out.println("reAuthorizeTask ID = " + result);

//}   
	
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
//	public void testGoBackToTask2() throws Exception {
//		boolean rtn = ComframeClient.goBackToTask(goBackTaskID, null, staffID, null);
//		Assert.assertEquals(true, rtn);
//	}

//    public static void main(String[] args) throws Exception{
//    	boolean a = ComframeClient.goBackToTask("test^mm^00000000000000998", null, "0199", null);
//    	System.out.println("���˽��Ϊ"+a);
    	
//    }	    
	

	
	
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
//	public void testGoBackToTask3() throws Exception {
//		boolean rtn = ComframeClient.goBackToTask(this.goBackTaskID, this.templateId, staffID, null, null);
//		Assert.assertEquals(false, rtn);
//	}

	
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
//	public void testStopWorkflow() throws Exception {
//		ComframeClient.stopWorkflow(this.getWorkflowID(), staffID, null);
//		System.out.println("stopWorkflow....");
//	}	
}
