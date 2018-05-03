package com.asiainfo.task.dao.impl;

import java.util.HashMap;

import com.asiainfo.task.dao.interfaces.IAssignUrlDAO;
import com.asiainfo.task.bo.BOAssignUrlEngine;
import com.asiainfo.task.bo.BOAssignUrlBean;

public class AssignUrlDAOImpl implements IAssignUrlDAO {

	/**
	 * ˵��:����ģ���������̽ڵ��ǩ��ȡ���̽ڵ��Ӧ��url flow_name:����ģ���� node_tag�����̽ڵ��ǩ
	 * **/
	public String getAssignUrl(String templateTag, String taskTag)
			throws Exception, RuntimeException {
		String url = null;
		String condition = BOAssignUrlBean.S_FlowName + "=:templateTag and "
				+ BOAssignUrlBean.S_NodeTag + "=:taskTag";
		HashMap<String, String> parameter = new HashMap<String, String>();
		parameter.put("templateTag", templateTag);
		parameter.put("taskTag", "ALL");
		if (templateTag.equals("template.WeaponNewApprove")
				|| templateTag.equals("template.ProductBossId")) {
			parameter.put("taskTag", taskTag);
		}
		BOAssignUrlBean[] beans = null;
		BOAssignUrlBean urlbean = new BOAssignUrlBean();
		beans = BOAssignUrlEngine.getBeans(condition, parameter);

		if (beans.length != 1) {
			return url = null;
		}

		urlbean = beans[0];
		url = urlbean.getUrl();
		return url;
	}

}
