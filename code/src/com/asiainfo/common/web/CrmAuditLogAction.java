package com.asiainfo.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.common.bo.BOCrmAuditLogBean;
import com.asiainfo.common.ivalues.IBOCrmAuditLogValue;
import com.asiainfo.common.service.interfaces.ICrmAuditLogSV;

public class CrmAuditLogAction extends BaseAction {

	private transient static Log log = LogFactory
			.getLog(CrmAuditLogAction.class);

	public void saveAuditLog(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOCrmAuditLogBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "没有修改需要保存！");
			return;
		}

		IBOCrmAuditLogValue[] crmAuditLogValues = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof IBOCrmAuditLogValue[]) {
				crmAuditLogValues = (IBOCrmAuditLogValue[]) obj;
			}
		}

		ICrmAuditLogSV crmAuditLogSV = (ICrmAuditLogSV) ServiceFactory
				.getService(ICrmAuditLogSV.class);

		try {
			if (null == crmAuditLogValues || 0 == crmAuditLogValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "没有修改需要保存！");
			} else {
				crmAuditLogSV.saveAuditLog(crmAuditLogValues[0]);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存审批信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			//HttpUtil.showInfo(response, cp);
		}
	}
}
