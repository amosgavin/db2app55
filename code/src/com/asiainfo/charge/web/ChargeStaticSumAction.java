package com.asiainfo.charge.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.charge.service.interfaces.IChargeStaticSumSV;

public class ChargeStaticSumAction extends BaseAction {

	private transient static Log log = LogFactory
			.getLog(ChargeStaticSumAction.class);

	public void saveChargeStaticSum(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String sumStr = request.getParameter("sumStr");// ǰ̨�ύ������

		IChargeStaticSumSV chargeStaticSumSV = (IChargeStaticSumSV) ServiceFactory
				.getService(IChargeStaticSumSV.class);

		try {
			if (null == sumStr || 0 == sumStr.length()) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {
				chargeStaticSumSV.save(sumStr);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("�������ݳ���", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	
	public void getSaveRecords(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String grandId = request.getParameter("grandId");

		IChargeStaticSumSV chargeStaticSumSV = (IChargeStaticSumSV) ServiceFactory
				.getService(IChargeStaticSumSV.class);

		try {
			if (null == grandId || 0 == grandId.length()) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {
				cp.set("savedRecords", chargeStaticSumSV.getSaveRecords(grandId));
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("�������ݳ���", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
