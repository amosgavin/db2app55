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
import com.asiainfo.charge.bo.BOFinalShareBean;
import com.asiainfo.charge.ivalues.IBOFinalShareValue;
import com.asiainfo.charge.service.interfaces.IFinaAllocShareSV;

public class FinaAllocShareAction extends BaseAction {
	private transient static Log log = LogFactory
			.getLog(FinaAllocShareAction.class);

	/**
	 * 保存财务分摊规则信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveFinaAllocShare(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOFinalShareBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "没有修改需要保存！");
			return;
		}

		IBOFinalShareValue[] finaAllocShareValues = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOFinalShareBean[]) {
				finaAllocShareValues = (BOFinalShareBean[]) obj;
			}
		}

		IFinaAllocShareSV finaAllocShareSV = (IFinaAllocShareSV) ServiceFactory
				.getService(IFinaAllocShareSV.class);

		try {
			if (null == finaAllocShareValues
					|| 0 == finaAllocShareValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else if (1 <= finaAllocShareValues.length) {
				finaAllocShareSV.saveFinaAllocShareInfo(finaAllocShareValues);
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

	public void checkEmptyFinalShareInCharge(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("orderId");
		IFinaAllocShareSV finaAllocShareSV = (IFinaAllocShareSV) ServiceFactory
				.getService(IFinaAllocShareSV.class);

		try {
			if (finaAllocShareSV.haveEmptyFinalShareInCharge(orderId)) {
				cp.set("haveEmpty", "yes");
			} else {
				cp.set("haveEmpty", "no");
			}
			cp.set("FLAG", "Y");
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
