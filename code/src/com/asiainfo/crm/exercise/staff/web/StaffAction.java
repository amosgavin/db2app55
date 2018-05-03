package com.asiainfo.crm.exercise.staff.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.crm.exercise.staff.bo.BOStaffBean;
import com.asiainfo.crm.exercise.staff.ivalues.IBOStaffValue;
import com.asiainfo.crm.exercise.staff.service.interfaces.IStaffSV;

public class StaffAction extends BaseAction {
	private transient static Log log = LogFactory.getLog(StaffAction.class);

	public StaffAction() {

	}

	public void saveStaff(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOStaffBean.class });

		if (dcLists.length == 0) {
			//HttpUtil.showInfo(response, CrmLocaleFactory
			//		.getResource("RSS0013180"));
			HttpUtil.showInfo(response, "操作对象为空");
			return;
		}

		IBOStaffValue[] staffValues = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOStaffBean[]) {
				staffValues = (BOStaffBean[]) obj;
			}
		}

		IStaffSV staffSV = (IStaffSV) ServiceFactory.getService(IStaffSV.class);

		try {
			staffSV.saveStaff(staffValues);
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("操作员工信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
