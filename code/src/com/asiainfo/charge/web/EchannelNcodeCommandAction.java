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
import com.asiainfo.charge.bo.BOEchannelNcodeCommandBean;
import com.asiainfo.charge.ivalues.IBOEchannelNcodeCommandValue;
import com.asiainfo.charge.service.interfaces.IEchannelNcodeCommandSV;

public class EchannelNcodeCommandAction extends BaseAction {

	private transient static Log log = LogFactory
			.getLog(EchannelNcodeCommandAction.class);

	public void save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOEchannelNcodeCommandBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}

		IBOEchannelNcodeCommandValue[] EchannelNcodeCommandList = null;// ǰ̨�ύ������

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOEchannelNcodeCommandBean[]) {
				EchannelNcodeCommandList = (BOEchannelNcodeCommandBean[]) obj;
			}
		}

		IEchannelNcodeCommandSV EchannelNcodeCommandListListv = (IEchannelNcodeCommandSV) ServiceFactory
				.getService(IEchannelNcodeCommandSV.class);

		try {
			if (null == EchannelNcodeCommandList || 0 == EchannelNcodeCommandList.length) {
				cp.set("FLAG", "N");
				//cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {
				EchannelNcodeCommandListListv.save(EchannelNcodeCommandList);
				cp.set("FLAG", "Y");
				//cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ�� 
			log.error("����ָ����NCODE�б�", e);
			cp.set("FLAG", "N");
			//cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
