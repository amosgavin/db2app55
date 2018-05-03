package com.ai.comframe.test;

import java.util.HashMap;
import java.sql.Timestamp;

import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.complex.center.CenterInfo;
import com.ai.comframe.client.ComframeClient;
import com.ai.comframe.vm.common.Constant;
import com.ai.appframe2.complex.cache.impl.TableSplitMappingCacheImpl;
import com.ai.appframe2.complex.self.dao.base.impl.BaseDAOImpl;
import com.ai.comframe.client.TaskInfo;

public class AssignWork {

	public static void main(String[] args) {
		HashMap aVars = new HashMap();
		String staffId = "666666";
		String objectTypeId = "saleCase";
		String objectId = "99008";
		TaskInfo currentTask = new TaskInfo();
		
		// 2¡¢Ò»°ãÁ÷³Ì
		try {
			TaskInfo[] task = ComframeClient.getTaskInfosByWorkflowObjectId(
					"HB", objectTypeId, objectId);
			for (int i = 0; i < task.length; i++) {
				if (task[i].getState() == 5) {
					currentTask = task[i];
				}
			}
			String taskId = currentTask.getTaskId();
			String result = "OK";
			String reason = "OK";
			aVars.put("result", "approve");

			//ComframeClient.resumeWorkflow(taskId, "666666", "Hello");

			ComframeClient.finishUserTask(taskId, staffId, result, reason, aVars);
			
			
		} catch (Exception xe) {
			System.out.println(xe.toString());
		}
	}
}