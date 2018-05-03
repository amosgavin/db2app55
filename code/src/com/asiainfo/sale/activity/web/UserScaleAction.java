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
import com.asiainfo.sale.activity.bo.BOUserScaleBean;
import com.asiainfo.sale.activity.ivalues.IBOUserScaleValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleUserScaleSV;

public class UserScaleAction extends BaseAction {

	private transient static Log log = LogFactory
			.getLog(UserScaleAction.class);

	public void save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOUserScaleBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}

		IBOUserScaleValue[] userScaleList = null;// ǰ̨�ύ������

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOUserScaleBean[]) {
				userScaleList = (BOUserScaleBean[]) obj;
			}
		}

		ISaleUserScaleSV userScaleListListv = (ISaleUserScaleSV) ServiceFactory
				.getService(ISaleUserScaleSV.class);

		try {
			if (null == userScaleList || 0 == userScaleList.length) {
				cp.set("FLAG", "N");
				//cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {
				userScaleListListv.save(userScaleList);
				cp.set("FLAG", "Y");
				//cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ�� 
			log.error("�����û���ģ��Ϣ�������", e);
			cp.set("FLAG", "N");
			//cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
