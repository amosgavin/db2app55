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
import com.asiainfo.charge.bo.BOFinAllocRulesBean;
import com.asiainfo.charge.ivalues.IBOFinAllocRulesValue;
import com.asiainfo.charge.service.interfaces.IFinAllocRulesSV;

public class FinAllocRulesAction extends BaseAction {
	private transient static Log log = LogFactory
			.getLog(FinAllocRulesAction.class);

	/**
	 * 保存财务分摊规则信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveFinAllocRulesInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOFinAllocRulesBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}

		IBOFinAllocRulesValue[] finAllocRulesValues = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOFinAllocRulesBean[]) {
				finAllocRulesValues = (BOFinAllocRulesBean[]) obj;
			}
		}

		IFinAllocRulesSV finAllocRulesSV = (IFinAllocRulesSV) ServiceFactory
				.getService(IFinAllocRulesSV.class);

		try {
			if (null == finAllocRulesValues || 0 == finAllocRulesValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else if (1 == finAllocRulesValues.length) {
				cp.set("ID", finAllocRulesSV
						.saveFinAllocRulesInfo(finAllocRulesValues[0]));
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			} else {
				finAllocRulesSV.saveFinAllocRulesInfo(finAllocRulesValues);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("操作失败！", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
