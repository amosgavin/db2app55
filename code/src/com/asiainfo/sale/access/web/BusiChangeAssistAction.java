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
import com.asiainfo.sale.access.bo.BOBusiChangeDetailBean;
import com.asiainfo.sale.access.ivalues.IBOBusiChangeDetailValue;
import com.asiainfo.sale.access.service.interfaces.IBusiChangeAssistSV;
import com.asiainfo.sale.access.service.interfaces.IBusiChangeDetailSV;

public class BusiChangeAssistAction extends BaseAction {
	private transient static Log log = LogFactory
			.getLog(BusiChangeAssistAction.class);

	public void checkChannelId(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String channelIdStr = request.getParameter("channelIdStr");
		IBusiChangeAssistSV busiChangeAssistSV = (IBusiChangeAssistSV) ServiceFactory
				.getService(IBusiChangeAssistSV.class);

		try {
			String erroChannelIdStr = busiChangeAssistSV
					.checkChannelId(channelIdStr);
			if (erroChannelIdStr.equals("")) {
				cp.set("FLAG", "Y");
			} else {
				cp.set("FLAG", "N");
				cp.set("erroChannelIdStr", erroChannelIdStr);
			}
		} catch (Exception e) {
			// ²Ù×÷Ê§°Ü
			log.error("Ö´ÐÐ³ö´í", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "²Ù×÷Ê§°Ü" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}

	public void getSaleHandles(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String feeId = request.getParameter("feeId");
		IBusiChangeAssistSV busiChangeAssistSV = (IBusiChangeAssistSV) ServiceFactory
				.getService(IBusiChangeAssistSV.class);

		try {
			String sumAndMonCn = busiChangeAssistSV.getSaleHandles(feeId);
			if (sumAndMonCn.equals("")) {
				cp.set("FLAG", "N");
			} else {
				cp.set("FLAG", "Y");
				cp.set("sumAndMonCn", sumAndMonCn);
			}
		} catch (Exception e) {
			// ²Ù×÷Ê§°Ü
			log.error("Ö´ÐÐ³ö´í", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "²Ù×÷Ê§°Ü" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}
}
