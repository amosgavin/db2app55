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

public class ReAuthor {
	
	public static void main(String[] args)throws Exception{
		String taskId = "";
		String authorizeStaffId = "";
		String authorizeStationId = "";
		String staffId = "";
		
		ComframeClient.reAuthorizeTask(taskId, authorizeStaffId, authorizeStationId, staffId);
	}
}
