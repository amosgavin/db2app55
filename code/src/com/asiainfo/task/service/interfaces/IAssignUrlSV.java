package com.asiainfo.task.service.interfaces;

import com.asiainfo.task.ivalues.IBOAssignUrlValue;

import java.util.Map;

public interface IAssignUrlSV {
	
	/**
	 * ˵��:����ģ���������̽ڵ��ǩ��ȡ���̽ڵ��Ӧ��url 
	 * flow_name:����ģ����
	 * node_tag�����̽ڵ��ǩ
	 * **/
	public Map<String,String> getAssignUrl(String templateTag,String taskTag)
			throws Exception, RuntimeException;
     
}
