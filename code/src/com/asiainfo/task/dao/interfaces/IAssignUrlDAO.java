package com.asiainfo.task.dao.interfaces;

public interface IAssignUrlDAO {

	/**
	 * ˵��:����ģ���������̽ڵ��ǩ��ȡ���̽ڵ��Ӧ��url 
	 * flow_name:����ģ����
	 * node_tag�����̽ڵ��ǩ
	 * **/
	public String getAssignUrl(String templateTag,String taskTag)
			throws Exception, RuntimeException;

}
