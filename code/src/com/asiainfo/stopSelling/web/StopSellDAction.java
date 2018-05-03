package com.asiainfo.stopSelling.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.stopSelling.bo.BOStopSellDBean;
import com.asiainfo.stopSelling.ivalues.IBOStopSellDValue;
import com.asiainfo.stopSelling.service.interfaces.IStopSellDSV;

public class StopSellDAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(StopSellDAction.class);

	public void saveStopSellDInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOStopSellDValue[] stopSellDValues = null;// ǰ̨�ύ������

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOStopSellDBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOStopSellDBean[]) {
				stopSellDValues = (BOStopSellDBean[]) obj;
			}
		}
		IStopSellDSV stopSellDSV = (IStopSellDSV) ServiceFactory
				.getService(IStopSellDSV.class);

		try {
			if (null == stopSellDValues || 0 == stopSellDValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "û���޸���Ҫ���棡");
			} else {
				if(stopSellDValues[0].isDeleted() == true){
					stopSellDValues[0].undelete();
					stopSellDValues[0].setIsDelete("1");
					}
				stopSellDSV.save(stopSellDValues);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("������Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}
}
