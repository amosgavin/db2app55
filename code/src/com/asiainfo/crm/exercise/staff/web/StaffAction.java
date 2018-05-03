package com.asiainfo.crm.exercise.staff.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.crm.exercise.staff.bo.BOStaffBean;
import com.asiainfo.crm.exercise.staff.ivalues.IBOStaffValue;
import com.asiainfo.crm.exercise.staff.service.interfaces.IStaffSV;

public class StaffAction extends BaseAction {
	private transient static Log log = LogFactory.getLog(StaffAction.class);

	public StaffAction() {

	}

	public void saveStaff(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOStaffBean.class });

		if (dcLists.length == 0) {
			//HttpUtil.showInfo(response, CrmLocaleFactory
			//		.getResource("RSS0013180"));
			HttpUtil.showInfo(response, "��������Ϊ��");
			return;
		}

		IBOStaffValue[] staffValues = null;// ǰ̨�ύ������

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOStaffBean[]) {
				staffValues = (BOStaffBean[]) obj;
			}
		}

		IStaffSV staffSV = (IStaffSV) ServiceFactory.getService(IStaffSV.class);

		try {
			staffSV.saveStaff(staffValues);
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "�����ɹ���");
		} catch (Exception e) {
			// ����ʧ��
			log.error("����Ա����Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
