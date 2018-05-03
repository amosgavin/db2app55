package com.asiainfo.task.web;

import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.secframe.orgmodel.ivalues.IBOSecOperatorValue;
import com.ai.secframe.orgmodel.ivalues.IBOSecStaffValue;
import com.ai.secframe.orgmodel.service.interfaces.ISecOperatorSV;

import com.asiainfo.task.service.impl.AssignUrlSVImpl;

public class AssignTaskAction extends BaseAction {

	public static String forward(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String templateTag = request.getParameter("templateTag");
		String taskTag = request.getParameter("taskTag");
		String url = null, errmsg = null;

		AssignUrlSVImpl urlserver = new AssignUrlSVImpl();
		HashMap<String, String> map = (HashMap<String, String>) urlserver
				.getAssignUrl(templateTag, taskTag);

		url = map.get("url");
		errmsg = map.get("errmsg");
		// if (errmsg != null) {
		// System.out.println("不存在对应任务的处理！");
		// return url = null;
		// }
		return url;
	}

	public static IBOSecStaffValue getOperatorInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String taskStaffId = request.getParameter("taskStaffId");
		if(taskStaffId.isEmpty()){
			return null;
		}

	    ISecOperatorSV sv = (ISecOperatorSV)ServiceFactory.getService(ISecOperatorSV.class);
	    IBOSecStaffValue staffValue = sv.getStaffByOperId(Long.valueOf(taskStaffId).longValue());
		// if (errmsg != null) {
		// System.out.println("不存在对应任务的处理！");
		// return url = null;
		// }
		return staffValue;
	}

}
