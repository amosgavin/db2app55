package com.asiainfo.sale.activity.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.sale.activity.bo.BOSaleResourceAllotBean;
import com.asiainfo.sale.activity.ivalues.IBOSaleResourceAllotValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleResourceSV;

public class SaleResourceAction extends BaseAction {

	private transient static Log log = LogFactory
			.getLog(SaleResourceAction.class);

	public void sava(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(),
				new Class[] { BOSaleResourceAllotBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}

		IBOSaleResourceAllotValue[] resourceAllots = null;// ǰ̨�ύ������

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOSaleResourceAllotBean[]) {
				resourceAllots = (BOSaleResourceAllotBean[]) obj;
			}
		}

		ISaleResourceSV resourceAllotSV = (ISaleResourceSV) ServiceFactory
				.getService(ISaleResourceSV.class);

		try {
			if (null == resourceAllots || 0 == resourceAllots.length) {
				cp.set("FLAG", "N");
				// cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {
				resourceAllotSV.save(resourceAllots[0]);
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
