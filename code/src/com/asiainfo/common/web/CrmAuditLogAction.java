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
			HttpUtil.showInfo(response, "û���޸���Ҫ���棡");
			return;
		}

		IBOCrmAuditLogValue[] crmAuditLogValues = null;// ǰ̨�ύ������

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
				cp.set("MESSAGE", "û���޸���Ҫ���棡");
			} else {
				crmAuditLogSV.saveAuditLog(crmAuditLogValues[0]);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("����������Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			//HttpUtil.showInfo(response, cp);
		}
	}
}