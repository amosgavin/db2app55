//package com.ai.comframe.test;
//
//import java.util.Collection;
//import java.util.HashMap;
//
//import com.ai.comframe.client.ComframeClient;
//import com.ai.comframe.client.WorkflowInfo;
//import com.ai.comframe.client.WorkflowTemplateInfo;
//import com.ai.comframe.wrap.wps.ComframeWrapForWPS;
//import com.ibm.toad.jan.jbc.JBCVisitor.Iterator;
//
//public class TestTaskWPS {
//
//	/**
//	 * @param args
//	 * @throws Exception 
//	 */
//	public static void main(String[] args) throws Exception {
//		HashMap map=new HashMap();
//////		map.put("$WORKFLOW_ID", "wps^571^00000000000000520");
//		map.put("_TASK_JUGE_RESULT", "exception");
//		ComframeWrapForWPS call =new ComframeWrapForWPS();
//		ComframeClient apiClient=new ComframeClient();
//		
////		apiClient.finishUserTask("wps^571^00000000000006245", "100003", null, null, null);
//		
////		apiClient.stopWorkflow("wps^571^00000000000000601", "100004", null);//--OK
//		
////		apiClient.cancelWorkflow("wps^571^00000000000000601", "100004", "OK", "some", "shit");//--OK
//		
////		apiClient.dropWorkflow("wps^571^00000000000000601");//--�ѹ�ʱ
//		
////		apiClient.setWorkflowVars("wps^571^00000000000000601", map);//--OK
//		
////		apiClient.resumeWorkflow("wps", "huhu", "102", "100004", "something is wrong");//--OK,stateΪ3ʱ���޷�����
//		
////		apiClient.resumeExceptionWorkflow("wps^571^00000000000000602");//--OK ��99��Ϊ2
//		
////		apiClient.realseTask("wps^571^00000000000006262");
//		
////		apiClient.fireWorkflowExceptionByTaskId("wps^571^00000000000006264", "100004", "error", "shit");//--OK
//		
////		apiClient.terminateWorkflow("wps^571^00000000000000651", "100004", "test");
////		apiClient.resumeWorkflow("wps^571^00000000000000639", "100004", "test");//==״̬Ϊ2,4,3ʱ��������
//		
////		apiClient.finishUserTask("wps^571^00000000000006326", "1", "child", "user", map);//--OK
//		
////		WorkflowInfo wf=apiClient.getRootWorkflowByWorkflowObjectId("wps", "good", "100");//--OK
////			System.out.println(wf.getWorkflowId());
//		
////		WorkflowInfo hwf=apiClient.getRootWorkflowsHisByWorkflowObjectId("wps", "wps", "1");//==OK
////			System.out.println(hwf.getWorkflowId());
//		
////		if(apiClient.isProcess("template.TestEx"))//==OK
////			System.out.println("��ҵ�����");
////			else  System.out.println("������");
//		
////		WorkflowTemplateInfo[] tms=apiClient.getWorkflowTemplates("template.good", "", "");
////		for(int i=0;i<tms.length;i++){
////		System.out.println(tms[i].getTemplateTag());
////		}
//		
////		if(apiClient.isWorkflow("template.TestEx"))//==OK
////			System.out.println("workflow");
////		else System.out.println("process");
//		
////		while(apiClient.getWorkflowVars("wps^571^00000000000000631").values().iterator().hasNext()){
////			System.out.println(apiClient.getWorkflowVars("wps^571^00000000000000631").values().iterator().next());
////		}
//		
////		call.finishEngineTask("wps^571^00000000000000654", "_PI:90030135.84ead366.f7ebf4f5.5d5e0002",
////				"_TKI:a01b0135.84ed72c6.f7ebf4f5.5d5e0069", map);//--�������"exception".//==OK
////		apiClient.fireWorkflowExceptionByTaskId("wps^571^00000000000006458", "1", "err", "ok");//==OK
//		//ִ����֮������ʵ��״̬��Ϊ98������״̬��ΪA������ڵ�״̬��Ϊ98.
////		apiClient.resumeExceptionWorkflow("wps^571^00000000000000672");//=ok,state:98->2
////		apiClient.goBackToTask("wps^571^00000000000006458", map, "1", "ok");//ֻ���˹�������Ի��ˡ�
//
//	}
//
//}
