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
import com.asiainfo.charge.bo.BOFinalShareBean;
import com.asiainfo.charge.ivalues.IBOFinalShareValue;
import com.asiainfo.charge.service.interfaces.IFinaAllocShareSV;

public class FinaAllocShareAction extends BaseAction {
	private transient static Log log = LogFactory
			.getLog(FinaAllocShareAction.class);

	/**
	 * ��������̯������Ϣ
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveFinaAllocShare(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOFinalShareBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "û���޸���Ҫ���棡");
			return;
		}

		IBOFinalShareValue[] finaAllocShareValues = null;// ǰ̨�ύ������

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOFinalShareBean[]) {
				finaAllocShareValues = (BOFinalShareBean[]) obj;
			}
		}

		IFinaAllocShareSV finaAllocShareSV = (IFinaAllocShareSV) ServiceFactory
				.getService(IFinaAllocShareSV.class);

		try {
			if (null == finaAllocShareValues
					|| 0 == finaAllocShareValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else if (1 <= finaAllocShareValues.length) {
				finaAllocShareSV.saveFinaAllocShareInfo(finaAllocShareValues);
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

	public void checkEmptyFinalShareInCharge(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("orderId");
		IFinaAllocShareSV finaAllocShareSV = (IFinaAllocShareSV) ServiceFactory
				.getService(IFinaAllocShareSV.class);

		try {
			if (finaAllocShareSV.haveEmptyFinalShareInCharge(orderId)) {
				cp.set("haveEmpty", "yes");
			} else {
				cp.set("haveEmpty", "no");
			}
			cp.set("FLAG", "Y");
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
