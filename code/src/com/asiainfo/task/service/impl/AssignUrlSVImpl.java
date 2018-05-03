package com.asiainfo.task.service.impl;

import java.util.*;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.task.service.interfaces.IAssignUrlSV;
import com.asiainfo.task.dao.interfaces.IAssignUrlDAO;

public class AssignUrlSVImpl implements IAssignUrlSV{
	
	/**
	 * 说明:流程模板名和流程节点标签获取流程节点对应的url 
	 * flow_name:流程模板名
	 * node_tag：流程节点标签
	 * **/
	public Map<String,String> getAssignUrl(String templateTag,String taskTag)
			throws Exception, RuntimeException{
		String url = null;
		String errmsg = null;
		HashMap<String,String> rs = new HashMap<String,String>();
		
		url = ((IAssignUrlDAO)ServiceFactory.getService(IAssignUrlDAO.class)).getAssignUrl(templateTag, taskTag);

		if(url ==  null){
			errmsg = "获取任务链接报错，请联系管理员";
		}
		rs.put("url", url);
		rs.put("errmsg", errmsg);
		
		return rs;
	}

}
