package com.asiainfo.task.dao.impl;

import java.util.HashMap;

import com.asiainfo.task.dao.interfaces.IAssignUrlDAO;
import com.asiainfo.task.bo.BOAssignUrlEngine;
import com.asiainfo.task.bo.BOAssignUrlBean;

public class AssignUrlDAOImpl implements IAssignUrlDAO {

	/**
	 * 说明:流程模板名和流程节点标签获取流程节点对应的url flow_name:流程模板名 node_tag：流程节点标签
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
