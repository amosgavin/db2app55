package com.asiainfo.costWarn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.costWarn.bo.BOCostWarnReceiverBean;
import com.asiainfo.costWarn.ivalues.IBOCostWarnReceiverValue;
import com.asiainfo.costWarn.service.interfaces.ICostWarnReceiverSV;

public class CostWarnReceiverAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(CostWarnReceiverAction.class);

	public void saveCostWarnReceiver(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil
				.getDataContainerLists(request.getInputStream(),
						new Class[] { BOCostWarnReceiverBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}

		IBOCostWarnReceiverValue[] receivers = null;// ǰ̨�ύ������

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOCostWarnReceiverBean[]) {
				receivers = (BOCostWarnReceiverBean[]) obj;
			}
		}

		ICostWarnReceiverSV costWarnReceiverSV = (ICostWarnReceiverSV) ServiceFactory
				.getService(ICostWarnReceiverSV.class);

		try {
			if (null == receivers || 0 == receivers.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {
				costWarnReceiverSV.saveCostWarnReceiverValues(receivers);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("�������", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

}
