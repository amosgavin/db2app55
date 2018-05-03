package com.asiainfo.sale.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.sale.common.service.interfaces.IProxySV;

public class ProxyAction extends BaseAction {
	private transient static Log log = LogFactory.getLog(ProxyAction.class);

	public void setProxy(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String createrId = String.valueOf(SessionManager.getUser().getID());
		String proxyerId = request.getParameter("proxyerId");
		String mFlag = request.getParameter("mFlag");
		try {
		
			if (null == createrId || "".equals(createrId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "授权人为空！");
			} else if (null == proxyerId || "".equals(proxyerId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "被授权人为空！");
			} else if (null == mFlag || "".equals(mFlag)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "授权类型为空！");
			} else {
				IProxySV iProxySV = (IProxySV) ServiceFactory.getService(IProxySV.class);
				String[] rStrings = iProxySV.setProxy(createrId, proxyerId, mFlag);
				if ("0000".equals(rStrings[0])) {
					cp.set("FLAG", "Y");
					cp.set("MESSAGE", "操作成功！");
				} else {
					cp.set("FLAG", "N");
					cp.set("MESSAGE", rStrings[1]);
				}
			}
		} catch (Exception e) {
			log.error("授权操作出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void delProxy(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String createrId = String.valueOf(SessionManager.getUser().getID());
		try {
			if (null == createrId || "".equals(createrId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "授权人为空！");
			} else {
				IProxySV iProxySV = (IProxySV) ServiceFactory.getService(IProxySV.class);
				String[] rStrings = iProxySV.delProxy(createrId);
				if ("0000".equals(rStrings[0])) {
					cp.set("FLAG", "Y");
					cp.set("MESSAGE", "操作成功！");
				} else {
					cp.set("FLAG", "N");
					cp.set("MESSAGE", rStrings[1]);
				}
			}
		} catch (Exception e) {
			log.error("授权操作出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
