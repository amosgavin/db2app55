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
import com.asiainfo.charge.bo.BOChargeTestBean;
import com.asiainfo.charge.ivalues.IBOChargeTestValue;
import com.asiainfo.charge.service.interfaces.IChargeTestSV;

public class ChargeTestAction extends BaseAction {

	private transient static Log log = LogFactory
			.getLog(ChargeTestAction.class);

	public void save(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String flag = request.getParameter("flag");
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOChargeTestBean.class });

		if (dcLists.length == 0) {
			//HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		IChargeTestSV sv = (IChargeTestSV) ServiceFactory
				.getService(IChargeTestSV.class);
		IBOChargeTestValue[] ct = null;
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOChargeTestBean[]) {
				ct = (BOChargeTestBean[]) obj;
			}
		}
		try {
			sv.save(ct, flag);
			cp.set("FLAG", "Y");
			//cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("保存信息出错", e);
			cp.set("FLAG", "N");
			//cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

}
