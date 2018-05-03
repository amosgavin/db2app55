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
import com.asiainfo.sale.activity.bo.BOSaleRelatCgroupBean;
import com.asiainfo.sale.activity.ivalues.IBOSaleRelatCgroupValue;
import com.asiainfo.sale.activity.service.interfaces.ICustGroupSV;

public class CustGroupAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(CustGroupAction.class);

	public void save(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOSaleRelatCgroupBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}

		IBOSaleRelatCgroupValue[] cgroupList = null;// ǰ̨�ύ������

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOSaleRelatCgroupBean[]) {
				cgroupList = (BOSaleRelatCgroupBean[]) obj;
			}
		}

		ICustGroupSV custGroupSV = (ICustGroupSV) ServiceFactory
				.getService(ICustGroupSV.class);

		try {
			if (null == cgroupList || 0 == cgroupList.length) {
				cp.set("FLAG", "N");
				// cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {
				custGroupSV.save(cgroupList);
				cp.set("FLAG", "Y");
				// cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("����Ŀ��ͻ�Ⱥ��Ϣ����", e);
			cp.set("FLAG", "N");
			// cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
