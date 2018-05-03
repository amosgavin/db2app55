package com.asiainfo.sale.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.sale.common.service.interfaces.IPersonSetSV;

public class PersonSetAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(PersonSetAction.class);

	public void saveCurrentSet(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int operatorId = (int) (SessionManager.getUser().getID());
		CustomProperty cp = CustomProperty.getInstance();
		String isReceiveSMS = request.getParameter("isReceiveSMS");

		IPersonSetSV personSetSV = (IPersonSetSV) ServiceFactory
				.getService(IPersonSetSV.class);
		try {

			personSetSV.savePersonInfo(operatorId, isReceiveSMS, "0");
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("保存出错！", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	
	public void getSMSFlag(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		int operatorId = (int) (SessionManager.getUser().getID());
		IPersonSetSV personSetSV = (IPersonSetSV) ServiceFactory
				.getService(IPersonSetSV.class);
		try {

			boolean isReceiveSMS = personSetSV.isReceiveSMS(operatorId);
			if (isReceiveSMS) {
				cp.set("smsFlag", "true");
			} else {
				cp.set("smsFlag", "false");
			}
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("保存出错！", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
