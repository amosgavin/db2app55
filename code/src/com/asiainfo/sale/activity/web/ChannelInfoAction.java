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
import com.asiainfo.sale.activity.bo.BOChannelInfoBean;
import com.asiainfo.sale.activity.ivalues.IBOChannelInfoValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleChannelInfoSV;

public class ChannelInfoAction extends BaseAction {

	private transient static Log log = LogFactory
			.getLog(ChannelRuleAction.class);

	public void save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOChannelInfoBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}

		IBOChannelInfoValue[] channelList = null;// ǰ̨�ύ������

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOChannelInfoBean[]) {
				channelList = (BOChannelInfoBean[]) obj;
			}
		}

		ISaleChannelInfoSV channelchannelListv = (ISaleChannelInfoSV) ServiceFactory
				.getService(ISaleChannelInfoSV.class);

		try {
			if (null == channelList || 0 == channelList.length) {
				cp.set("FLAG", "N");
				//cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {
				channelchannelListv.save(channelList);
				cp.set("FLAG", "Y");
				//cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ�� 
			log.error("��������������Ϣ����", e);
			cp.set("FLAG", "N");
			//cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
