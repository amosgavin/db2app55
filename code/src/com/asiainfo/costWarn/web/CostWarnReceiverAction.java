package com.asiainfo.costWarn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.costWarn.bo.BOCostWarnReceiverBean;
import com.asiainfo.costWarn.ivalues.IBOCostWarnReceiverValue;
import com.asiainfo.costWarn.service.interfaces.ICostWarnReceiverSV;

public class CostWarnReceiverAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(CostWarnReceiverAction.class);

	public void saveCostWarnReceiver(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil
				.getDataContainerLists(request.getInputStream(),
						new Class[] { BOCostWarnReceiverBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}

		IBOCostWarnReceiverValue[] receivers = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOCostWarnReceiverBean[]) {
				receivers = (BOCostWarnReceiverBean[]) obj;
			}
		}

		ICostWarnReceiverSV costWarnReceiverSV = (ICostWarnReceiverSV) ServiceFactory
				.getService(ICostWarnReceiverSV.class);

		try {
			if (null == receivers || 0 == receivers.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				costWarnReceiverSV.saveCostWarnReceiverValues(receivers);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

}
