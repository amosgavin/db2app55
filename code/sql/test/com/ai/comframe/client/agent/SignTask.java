package com.ai.comframe.client.agent;

import java.util.HashMap;

import com.asiainfo.util.agent.ClientAgent;
import com.ai.comframe.client.ComframeClient;

public class SignTask {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, String> aVars = new HashMap<String, String>();
		String staffId = "f888888";
		String objectTypeId = "weaponCase";
		String objectId = "4820111";
		String role = "5000";
		String comment = "ͬ��";
		String reason = "��ͬ��ñ�ǩ�����̫��";
		String result = "OK";
		
		try {
			ClientAgent.signTask(role, staffId, objectTypeId, objectId, comment, reason, result);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
