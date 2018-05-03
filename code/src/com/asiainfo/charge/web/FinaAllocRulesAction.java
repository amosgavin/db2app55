package com.asiainfo.charge.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.charge.bo.BOFinaAllocRulesBean;
import com.asiainfo.charge.ivalues.IBOFinaAllocRulesValue;
import com.asiainfo.charge.service.interfaces.IFinaAllocRulesSV;

public class FinaAllocRulesAction extends BaseAction {
	private transient static Log log = LogFactory
			.getLog(FinaAllocRulesAction.class);

	/**
	 * ��������̯������Ϣ
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveFinaAllocRules(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOFinaAllocRulesBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}

		IBOFinaAllocRulesValue[] finaAllocRulesValues = null;// ǰ̨�ύ������

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOFinaAllocRulesBean[]) {
				finaAllocRulesValues = (BOFinaAllocRulesBean[]) obj;
			}
		}

		IFinaAllocRulesSV finaAllocRulesSV = (IFinaAllocRulesSV) ServiceFactory
				.getService(IFinaAllocRulesSV.class);

		try {
			if (null == finaAllocRulesValues
					|| 0 == finaAllocRulesValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else if (1 == finaAllocRulesValues.length) {
				cp.set("ID", finaAllocRulesSV
						.saveFinaAllocRulesInfo(finaAllocRulesValues[0]));
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("����ʧ�ܣ�", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
