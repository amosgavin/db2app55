package com.asiainfo.sale.access.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.workflow.util.TaskUtil;

import com.asiainfo.sale.access.bo.BOAccessChangeBean;
import com.asiainfo.sale.access.bo.BOAccessChangeDetailBean;
import com.asiainfo.sale.access.ivalues.IBOAccessChangeDetailValue;
import com.asiainfo.sale.access.ivalues.IBOAccessChangeValue;
import com.asiainfo.sale.access.ivalues.IBOAccessChangeDetailValue;
import com.asiainfo.sale.access.service.interfaces.IAccessChangeSV;

public class AccessChangeAction extends BaseAction {
	private transient static Log log = LogFactory
			.getLog(AccessChangeAction.class);

	public void saveAccessChangeInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOAccessChangeValue[] accessChangeValue = null;// ǰ̨�ύ������
		String applyid = request.getParameter("applyid");
		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOAccessChangeBean.class });

		if (dcLists.length == 0) {
			//HttpUtil.showInfo(response, "��������Ϊ�գ�");
			cp.set("M", "N");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOAccessChangeBean[]) {
				accessChangeValue = (BOAccessChangeBean[]) obj;
			}
		}
		IAccessChangeSV accessChangeSV = (IAccessChangeSV) ServiceFactory
				.getService(IAccessChangeSV.class);

		try {
			if (null == accessChangeValue || 0 == accessChangeValue.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else if (1 == accessChangeValue.length) {
				int accessid = accessChangeSV
						.saveAccessChange(accessChangeValue[0]);
				cp.set("accessid", String.valueOf(accessid));
				cp.set("state", String.valueOf("1"));
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("���������޸�����Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}

	public void saveAccessChangeDetail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOAccessChangeDetailValue[] accessChangeDetailValue = null;// ǰ̨�ύ������
		String accessid = request.getParameter("accessid");

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(),
				new Class[] { BOAccessChangeDetailBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOAccessChangeDetailBean[]) {
				accessChangeDetailValue = (BOAccessChangeDetailBean[]) obj;
			}
		}
		IAccessChangeSV accessChangeSV = (IAccessChangeSV) ServiceFactory.getService(IAccessChangeSV.class);

		try {
			if (!accessid.isEmpty()) {
				if (null == accessChangeDetailValue
						|| 0 == accessChangeDetailValue.length) {
					cp.set("FLAG", "N");
					cp.set("MESSAGE", "������ϸ��ϢΪ�գ�");
				} else {
					accessChangeSV.saveAccessChangeDetailBatch(accessChangeDetailValue);
				}
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("���������޸���ϸ��Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}
	
	public void delAccessChangeInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();		
		String accessid = request.getParameter("accessid");
		IAccessChangeSV accessChangeSV = (IAccessChangeSV) ServiceFactory.getService(IAccessChangeSV.class);
		try {
			    accessChangeSV.delAccessChangeValue(Integer.valueOf(accessid).intValue());
				cp.set("accessid", String.valueOf(accessid));
				cp.set("state", String.valueOf("1"));
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "ɾ�������ɹ���");
		}catch (Exception e) {
			// ����ʧ��
			log.error("ɾ�������޸���Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}	

}
