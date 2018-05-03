package com.ai.comframe.client.agent;

import java.sql.Timestamp;
import java.util.Date;

import com.asiainfo.util.agent.ClientAgent;

public class AgentCreateFlow {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String staffId = "-110";
		String objectTypeId = "weaponCase";
		String objectId = "4820111990";
		String flowCode = "template.WeaponNewApprove";
		String orgId = "12";
		String result = null;
		Date date = new Date();
		
		Timestamp startTime = new Timestamp(new Date().getTime());
		String notes = null;
		ClientAgent.createWorkflow(flowCode, staffId, objectTypeId, objectId, result, notes,orgId);
	}
}
