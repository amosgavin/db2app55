package com.asiainfo.task.service.interfaces;

import com.asiainfo.task.ivalues.IBOAssignUrlValue;

import java.util.Map;

public interface IAssignUrlSV {
	
	/**
	 * 说明:流程模板名和流程节点标签获取流程节点对应的url 
	 * flow_name:流程模板名
	 * node_tag：流程节点标签
	 * **/
	public Map<String,String> getAssignUrl(String templateTag,String taskTag)
			throws Exception, RuntimeException;
     
}
