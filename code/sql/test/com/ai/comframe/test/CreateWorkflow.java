package com.ai.comframe.test;

import java.util.HashMap;
import java.sql.Timestamp;

import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.complex.center.CenterInfo;
import com.ai.comframe.client.ComframeClient;
import com.ai.comframe.vm.common.Constant;
import com.ai.appframe2.complex.cache.impl.TableSplitMappingCacheImpl;
import com.ai.appframe2.complex.self.dao.base.impl.BaseDAOImpl;

public class CreateWorkflow {

	public static void main(String[] args) throws Exception {
		CenterFactory.setDirectCenterInfo(new CenterInfo("0", "571"));
		System.setProperty(Constant.S_COMFRAME_DEV_NAME, "CM");
		HashMap aVars = new HashMap();
//		aVars.put("custName", "devname");
////		aVars.put("test", "2");
		//ComframeClient.createWorkflow("template.ProvinceSaleCaseApprove", "4444", "order", "1",aVars, null, "");
		String staffId = "666666";
		String objectTypeId = "saleCase";
		String objectId = "99008";
		aVars.put("result", "1");
		Timestamp startTime = null;
		String notes = "Test saleCase";
		ComframeClient.createWorkflow("template.TownSaleCaseApprove", staffId, objectTypeId, objectId, aVars, startTime, notes);
//		ComframeClient.createWorkflow(flowCode, staffId, objectTypeId, objectId, aVars, startTime, notes);
//		ComframeClient.finishUserTask("dev^571^00000000000006557", "123", null, null, aVars);
//		ComframeClient.finishUserTask(taskId, staffId, result, reason, aVars);
//		ComframeClient.printUserTask(taskId, staffId, aVars);
		CenterFactory.setCenterInfoEmpty();
		
		//ComframeClient.finishUserTask(taskId, staffId, result, reason, aVars);
		//ComframeClient.printUserTask(taskId, staffId, aVars);
		
		//工作流开发
		//创建工作流实例
		//1、第一步
		//ComframeClient.createWorkflow("template.ProvinceSaleCaseApprove", staffId, "salecase", objectId, aVars, startTime, notes);
		
		//2、一般流程
		//ComframeClient.getTaskInfosByWorkflowObjectId(queueID, objectTypeId, objectId);
		
		//ComframeClient.finishUserTask(taskId, staffId, result, reason, aVars);
		//ComframeClient.printUserTask(taskId, staffId, aVars);
		
		//3、回退
		//ComframeClient.getTaskInfosByWorkflowObjectId(queueID, objectTypeId, objectId);
		//ComframeClient.goBackToTask(currentTaskId, vars, staffId, notes);
		
		//4、跳转
		//ComframeClient.jumpToTask(taskId, taskTemplateId, vars, staffId, notes);
	}
}