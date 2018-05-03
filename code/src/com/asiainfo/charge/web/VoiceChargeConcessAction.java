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
import com.asiainfo.charge.bo.BOChargeConcessDetailInfoBean;
import com.asiainfo.charge.bo.BOChargeConcessInfoBean;
import com.asiainfo.charge.ivalues.IBOChargeConcessInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessDetailInfoValue;
import com.asiainfo.charge.service.interfaces.IVoiceChargeConcessSV;

public class VoiceChargeConcessAction extends BaseAction {
	private transient static Log log = LogFactory
			.getLog(ChargeMainAction.class);

	public void saveChargeConcessMain(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOChargeConcessInfoBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}

		IBOChargeConcessInfoValue[] chargeConcessInfo = null;// ǰ̨�ύ������
        //dcLists.length�ĳ��ȶ���1
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOChargeConcessInfoBean[]) {
				chargeConcessInfo = (BOChargeConcessInfoBean[]) obj;
			}
		}

		IVoiceChargeConcessSV chargeConcessSV = (IVoiceChargeConcessSV) ServiceFactory.getService(IVoiceChargeConcessSV.class);

		try {
			if (null == chargeConcessInfo || 0 == chargeConcessInfo.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else if (1 == chargeConcessInfo.length) {
				cp.set("CONCESSID", chargeConcessSV.saveChargeInfo(chargeConcessInfo[0]));
				cp.set("FLAG", "Y");
				//cp.set("MESSAGE", "�����ɹ���");
			} else {
				chargeConcessSV.saveChargeInfo(chargeConcessInfo);
				cp.set("FLAG", "Y");
				//cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("���������Żݰ���Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void saveChargeConcessDetail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOChargeConcessDetailInfoBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}

		IBOChargeConcessDetailInfoValue[] chargeConcessdetail = null;// ǰ̨�ύ������
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOChargeConcessDetailInfoBean[]) {
				chargeConcessdetail = (BOChargeConcessDetailInfoBean[]) obj;
			}
		}

		IVoiceChargeConcessSV chargeConcessSV = (IVoiceChargeConcessSV) ServiceFactory.getService(IVoiceChargeConcessSV.class);

		try {
			if (null == chargeConcessdetail || 0 == chargeConcessdetail.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {
				chargeConcessSV.saveChargeDetailInfo(chargeConcessdetail);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("���������Żݰ���ϸ��Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	
}
