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
import com.asiainfo.costWarn.bo.BOCostWarnBean;
import com.asiainfo.costWarn.ivalues.IBOCostWarnValue;
import com.asiainfo.costWarn.service.interfaces.ICostWarnSV;

public class CostWarnAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(CostWarnAction.class);

	public void saveCostWarn(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOCostWarnBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}

		IBOCostWarnValue[] costWarnValues = null;// ǰ̨�ύ������

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOCostWarnBean[]) {
				costWarnValues = (BOCostWarnBean[]) obj;
			}
		}

		ICostWarnSV costWarnSV = (ICostWarnSV) ServiceFactory
				.getService(ICostWarnSV.class);

		try {
			if (null == costWarnValues || 0 == costWarnValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {
				String ret = costWarnSV.saveCostWarnValues(costWarnValues);
				if (ret.equals("exist")) {
					cp.set("FLAG", "N");
					cp.set("MESSAGE", "�Ѵ��ڵ����ã�");
				} else {

					cp.set("FLAG", "Y");
					cp.set("MESSAGE", "�����ɹ���");
				}
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
