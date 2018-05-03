package com.asiainfo.task.service.impl;

import java.util.*;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.task.service.interfaces.IAssignUrlSV;
import com.asiainfo.task.dao.interfaces.IAssignUrlDAO;

public class AssignUrlSVImpl implements IAssignUrlSV{
	
	/**
	 * ˵��:����ģ���������̽ڵ��ǩ��ȡ���̽ڵ��Ӧ��url 
	 * flow_name:����ģ����
	 * node_tag�����̽ڵ��ǩ
	 * **/
	public Map<String,String> getAssignUrl(String templateTag,String taskTag)
			throws Exception, RuntimeException{
		String url = null;
		String errmsg = null;
		HashMap<String,String> rs = new HashMap<String,String>();
		
		url = ((IAssignUrlDAO)ServiceFactory.getService(IAssignUrlDAO.class)).getAssignUrl(templateTag, taskTag);

		if(url ==  null){
			errmsg = "��ȡ�������ӱ�������ϵ����Ա";
		}
		rs.put("url", url);
		rs.put("errmsg", errmsg);
		
		return rs;
	}

}
