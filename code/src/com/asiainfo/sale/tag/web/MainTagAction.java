package com.asiainfo.sale.tag.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.sale.tag.bo.BOApplyTagBean;
import com.asiainfo.sale.tag.ivalues.IBOApplyTagValue;
import com.asiainfo.sale.tag.service.interfaces.ITagMainSV;


public class MainTagAction extends BaseAction{

	private transient static Log log = LogFactory.getLog(MainTagAction.class);

	public void saveMainTag(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOApplyTagBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}
		IBOApplyTagValue[] tagMainValues = null;// ǰ̨�ύ������

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOApplyTagBean[]) {
				tagMainValues = (BOApplyTagBean[]) obj;
			}
		}

		ITagMainSV tagMainSV = (ITagMainSV) ServiceFactory.getService(ITagMainSV.class);

		try {
			if(null == tagMainValues || 0 == tagMainValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {
				tagMainSV.saveTagMain(tagMainValues[0]);
			}
			cp.set("ADDID", "");
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "�����ɹ���");
		} catch (Exception e) {
			// ����ʧ��
			log.error("����Ӫ��������Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
