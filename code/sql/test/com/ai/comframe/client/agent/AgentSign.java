package com.ai.comframe.client.agent;

import java.util.HashMap;

import com.asiainfo.util.agent.ClientAgent;

public class AgentSign {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String,String> aVars = new HashMap<String,String>();
		String staffId = "f888888";
		String objectTypeId = "weaponCase";
		String objectId = "4820111";
		String role = "101406";
		String comment = "";
		String reason = "√ª¿Ì”…";
		String staffStr = "f888888;999999";
	
		ClientAgent.assignReason(role, staffId, objectTypeId, objectId, comment, reason, staffStr);
	}
}
