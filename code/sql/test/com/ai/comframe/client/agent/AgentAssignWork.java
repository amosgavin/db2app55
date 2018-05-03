package com.ai.comframe.client.agent;

import java.util.HashMap;

import com.asiainfo.util.agent.ClientAgent;

public class AgentAssignWork {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap aVars = new HashMap();
		String staffId = "666666";
		String objectTypeId = "weaponCase";
		String objectId = "1888";
		String role = "5000";
		String comment = "ЭЌвт";
		String reason = "That is ok!";
		String result = "approve";
		
		//ClientAgent.assignTask(role, staffId, objectTypeId, objectId, comment, reason, result);
		ClientAgent.assignTask(role, staffId, objectTypeId, objectId, "20005232", comment, reason, result);
	}
}
