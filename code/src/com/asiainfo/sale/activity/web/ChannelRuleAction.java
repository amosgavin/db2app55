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
import com.asiainfo.sale.activity.bo.BOChannelRuleBean;
import com.asiainfo.sale.activity.ivalues.IBOChannelRuleValue;
import com.asiainfo.sale.activity.service.interfaces.IChannelRuleSV;

public class ChannelRuleAction extends BaseAction {

	private transient static Log log = LogFactory
			.getLog(ChannelRuleAction.class);

	public void saveChannelRule(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOChannelRuleBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}

		IBOChannelRuleValue[] rules = null;// ǰ̨�ύ������

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOChannelRuleBean[]) {
				rules = (BOChannelRuleBean[]) obj;
			}
		}

		IChannelRuleSV channelRuleSv = (IChannelRuleSV) ServiceFactory
				.getService(IChannelRuleSV.class);

		try {
			if (null == rules || 0 == rules.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else if (rules.length == 1) {
				String ruleId = channelRuleSv.saveChannelRule(rules[0]);
				cp.set("RULEID", ruleId);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			} else {
				channelRuleSv.saveChannelRules(rules);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("��������������Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
