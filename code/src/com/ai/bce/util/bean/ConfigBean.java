package com.ai.bce.util.bean;

import java.util.HashMap;
import java.util.Map;

public class ConfigBean {

	private Map configMap = new HashMap();

	public void put(String key, Object value) {
		// TODO Auto-generated method stub
		this.configMap.put(key, value);
	}

	public Object get(String key) {
		// TODO Auto-generated method stub
		return this.configMap.get(key);
	}
}
