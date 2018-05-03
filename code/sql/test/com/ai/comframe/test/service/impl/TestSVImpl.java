package com.ai.comframe.test.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.comframe.client.ComframeBusiException;
import com.ai.comframe.client.ComframeClient;
import com.ai.comframe.test.service.interfaces.ITestSV;
import com.ai.comframe.vm.common.Constant;

public class TestSVImpl implements ITestSV {

	public String autoDe(String flag) throws Exception {
//		String workflowObjectTypeVarName = "workflowObjectType";
//		String workflowObjectIDVarName = "workflowObjectID";
//		String workflowCreateStaffVarName = "workflowCreateStaff";
//		String mapName = "tmpMap";
//		String ww = "aaa";
//		StringBuffer buffer = new StringBuffer("");
//		buffer.append("com.ai.comframe.vm.workflow.WorkflowEngineFactory.getInstance().createWorkflow(null,\"-1\",\"" + ww
//				+ "\",com.ai.comframe.vm.common.Constant.WORKFLOW_TYPE_CHILDWORKFLOW," + workflowCreateStaffVarName + ","
//				+ workflowObjectTypeVarName + "," + workflowObjectIDVarName + "," + mapName + ");");
//		System.out.println(buffer);
//		ComframeClient.getTaskInfos("dev", "1=1", null, 1, 10);
//		ComframeClient.getTaskInfos("dev", "1=1", null, 11, 20);
//		if(true)
//			throw new ComframeBusiException("test","test comframeBusiException");
		return "auto";
	}

	public static void main(String[] args) throws Exception {
		ITestSV sv = (ITestSV)ServiceFactory.getService(ITestSV.class);
		sv.autoDe("a");
	}

	public void goBackTest(String wfId, String taskId) throws Exception {
		System.out.println("*****************goBackTest*******************");
		System.out.println(wfId);
		System.out.println(taskId);
		System.out.println("*****************goBackTest*******************");
	}

	public void jumpToTaskTest(String wfId, String taskId) throws Exception {
		System.out.println("*****************jumpToTaskTest*******************");
		System.out.println(wfId);
		System.out.println(taskId);
		System.out.println("*****************jumpToTaskTest*******************");
	}
	public void testFuego(int test) throws Exception{
		System.out.println("test"+test);
	}
	public void sysout(String custName) throws Exception{
		System.out.println(custName);
	}
	
	public String result(String rs) throws Exception{
		return rs;
	}
	

}
