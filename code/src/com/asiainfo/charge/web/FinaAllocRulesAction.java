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
import com.asiainfo.charge.bo.BOFinaAllocRulesBean;
import com.asiainfo.charge.ivalues.IBOFinaAllocRulesValue;
import com.asiainfo.charge.service.interfaces.IFinaAllocRulesSV;

public class FinaAllocRulesAction extends BaseAction {
	private transient static Log log = LogFactory
			.getLog(FinaAllocRulesAction.class);

	/**
	 * 保存财务分摊规则信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveFinaAllocRules(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOFinaAllocRulesBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}

		IBOFinaAllocRulesValue[] finaAllocRulesValues = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOFinaAllocRulesBean[]) {
				finaAllocRulesValues = (BOFinaAllocRulesBean[]) obj;
			}
		}

		IFinaAllocRulesSV finaAllocRulesSV = (IFinaAllocRulesSV) ServiceFactory
				.getService(IFinaAllocRulesSV.class);

		try {
			if (null == finaAllocRulesValues
					|| 0 == finaAllocRulesValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else if (1 == finaAllocRulesValues.length) {
				cp.set("ID", finaAllocRulesSV
						.saveFinaAllocRulesInfo(finaAllocRulesValues[0]));
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
